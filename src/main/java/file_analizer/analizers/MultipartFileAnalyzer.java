package file_analizer.analizers;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MultipartFileAnalyzer extends BaseFileAnalyzer {

    Logger log = LoggerFactory.getLogger(MultipartFileAnalyzer.class);

    /**
     * Gets File Mimetype using Apache Tika
     *
     * @param file the file
     * @return the MimeType
     */
    public String getMimeType(Object file) {
        final var tika = new Tika();
        var fileTypeDefault = "";
        try (var inputStream = ((MultipartFile) file).getInputStream()) {
            fileTypeDefault = tika.detect(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return fileTypeDefault;
    }

}
