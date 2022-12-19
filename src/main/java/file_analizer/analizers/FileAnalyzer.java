package file_analizer.analizers;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class FileAnalyzer extends BaseFileAnalyzer {

    Logger log = LoggerFactory.getLogger(FileAnalyzer.class);

    @Override
    public String getMimeType(Object file) {
        final var tika = new Tika();
        var fileTypeDefault = "";
        try {
            fileTypeDefault = tika.detect((File) file);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return fileTypeDefault;
    }

}
