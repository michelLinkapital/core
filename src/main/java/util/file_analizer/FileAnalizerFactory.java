package util.file_analizer;

import com.linkapital.core.util.file_analizer.analizers.BaseFileAnalyzer;
import com.linkapital.core.util.file_analizer.analizers.FileAnalyzer;
import com.linkapital.core.util.file_analizer.analizers.MultipartFileAnalyzer;

public class FileAnalizerFactory {

    private FileAnalizerFactory() {
    }

    public static BaseFileAnalyzer create(FileAnalizer file) {
        return switch (file) {
            case FILE -> new FileAnalyzer();
            case MULTIPART -> new MultipartFileAnalyzer();
        };
    }

}
