package file_analizer;

import file_analizer.analizers.BaseFileAnalyzer;
import file_analizer.analizers.FileAnalyzer;
import file_analizer.analizers.MultipartFileAnalyzer;

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
