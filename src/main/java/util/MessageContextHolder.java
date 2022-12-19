package util;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.function.UnaryOperator;

import static java.util.regex.Pattern.compile;
import static java.util.stream.Stream.concat;
import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import static util.FileUtils.findFilesAsStream;

public class MessageContextHolder {

    private static final MessageSource SOURCE;

    static {
        SOURCE = new ResourceBundleMessageSource();// (1)
        ((ResourceBundleMessageSource) SOURCE).setBasenames(getPropertiesFilesPaths());
        ((ResourceBundleMessageSource) SOURCE).setDefaultEncoding("UTF-8");
    }

    private MessageContextHolder() {
        throw new AssertionError("No 'MessageContextHolder' instances for you!");
    }

    public static String msg(String code, Object... args) {
        return SOURCE.getMessage(code,
                0 != args.length
                        ? args
                        : null,
                getLocale());
    }

    public static MessageSource source() {
        return SOURCE;
    }

    private static String[] getPropertiesFilesPaths() {
        var pattern = compile("\\p{javaLetter}+([_]\\p{javaLetter}+)+.properties{1}");
        UnaryOperator<String> mappingFunc = line -> line.endsWith(".properties")
                ? line.substring(0, line.indexOf("essages_") + 7)
                : line;
        var defaultMessages = findFilesAsStream("classpath*:i18n/*.properties", 2,
                ".", pattern, mappingFunc);
        var validationMessages = findFilesAsStream("classpath*:org/hibernate/validator/*.properties",
                4, ".", pattern, mappingFunc);
        return concat(defaultMessages, validationMessages).toArray(String[]::new);
    }

}
