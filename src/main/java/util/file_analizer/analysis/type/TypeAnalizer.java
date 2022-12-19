package util.file_analizer.analysis.type;

import static com.linkapital.core.util.file_analizer.analysis.type.FileType.EXCEL;
import static org.apache.tika.mime.MediaType.parse;

/**
 * The interface Type validator.
 */
public interface TypeAnalizer {

    /**
     * @param file the type of File
     * @return audio, video,text, application, etc
     */
    default String getFileType(Object file) {
        // no uso operador ternario porque esto va a crecer indefinidamente para machear con los distintos MIMETYPEs
        if (isExcel(file))
            return EXCEL.getValue();
        else
            return parse(getMimeType(file)).getType();
    }

    /**
     * Is file type.
     *
     * @param file     the file
     * @param fileType the file type
     * @return the boolean
     */
    default boolean isFileType(Object file, FileType fileType) {
        return getFileType(file).equals(fileType.getValue());
    }

    /**
     * Is image.
     *
     * @param file the file
     * @return the boolean
     */
    default boolean isImage(Object file) {
        return getFileType(file).equals(FileType.IMAGE.getValue());
    }

    /**
     * Is video.
     *
     * @param file the file
     * @return the boolean
     */
    default boolean isVideo(Object file) {
        return getFileType(file).equals(FileType.VIDEO.getValue());
    }

    /**
     * Is audio.
     *
     * @param file the file
     * @return the boolean
     */
    default boolean isAudio(Object file) {
        return getFileType(file).equals(FileType.AUDIO.getValue());
    }

    /**
     * Is text
     *
     * @param file the file
     * @return the boolean
     */
    default boolean isText(Object file) {
        return getFileType(file).equals(FileType.TEXT.getValue());
    }

    /**
     * Is application boolean.
     *
     * @param file the file
     * @return the boolean
     */
    default boolean isApplication(Object file) {
        return getFileType(file).equals(FileType.APPLICATION.getValue());
    }

    default boolean isExcel(Object file) {
        var fileMime = getMimeType(file);

        return fileMime.contains("application/vnd.ms-excel") ||
                fileMime.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    /**
     * Gets File Mimetype using Apache Tika
     *
     * @param file the file
     * @return the MimeType
     */
    String getMimeType(Object file);

    /**
     * @param file the file
     * @return the MimeType
     */
    default boolean isMimeType(Object file, String mimeType) {
        return getMimeType(file).equals(mimeType);
    }

}
