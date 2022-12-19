package util.file_analizer.analysis.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileType {

    VIDEO("video"),
    IMAGE("image"),
    APPLICATION("application"),
    AUDIO("audio"),
    TEXT("text"),
    EXCEL("excel"),
    ANY(null);
    private final String value;

}
