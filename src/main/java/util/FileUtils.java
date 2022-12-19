package util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static util.MessageContextHolder.msg;

/**
 * Utility class for file operations. Intended to internal usage only.
 *
 * @since 0.1.0
 */
public final class FileUtils {

    private FileUtils() {
        throw new AssertionError(msg("system.configuration.fileutil.instance.not.found"));
    }

    public static InputStream getFile(String path) {
        try {
            return new DefaultResourceLoader().getResource(path).getInputStream();
        } catch (Exception ex) {
            throw new RuntimeException(msg("system.configuration.file.resources.not.found"), ex);
        }
    }

    public static String[] findFiles(String path,
                                     int levelsToSkip,
                                     String delimiter,
                                     Pattern patternFilter,
                                     Function<String, String> mappingFunc) {
        return findFilesAsStream(path, levelsToSkip, delimiter, patternFilter, mappingFunc).toArray(String[]::new);
    }

    public static Stream<String> findFilesAsStream(String path,
                                                   int levelsToSkip,
                                                   String delimiter,
                                                   Pattern patternFilter,
                                                   Function<String, String> mappingFunc) {
        var resolver = new PathMatchingResourcePatternResolver(FileUtils.class.getClassLoader());
        try {
            var resources = resolver.getResources(path);
            return stream(resources)
                    .filter(resource -> null != resource.getFilename() &&
                            patternFilter.matcher(resource.getFilename()).matches())
                    .map(resource -> map(resource, levelsToSkip, delimiter, mappingFunc))
                    .distinct();
        } catch (Exception ex) {
            throw new RuntimeException(msg("system.configuration.file.resources.not.found"), ex);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Support methods">
    private static String map(Resource resource,
                              int levelsToSkip,
                              String delimiter,
                              Function<String, String> mappingFunc) {
        try {
            var path = resource.getURL().getPath().split("/");
            return stream(path)
                    .skip(path.length - levelsToSkip)
                    .map(mappingFunc)
                    .collect(joining(delimiter));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
