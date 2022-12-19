package multipart;

import file_analizer.analysis.type.FileType;
import multipart.validators.MultipartArrayValidator;
import multipart.validators.MultipartValidator;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static file_analizer.analysis.type.FileType.ANY;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {MultipartValidator.class, MultipartArrayValidator.class})
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface Multipart {

    String message() default "";

    /**
     * Represents the max size acceptable of an uploaded {@link MultipartFile}
     * String parseable to a {@link org.springframework.util.unit.DataSize}
     * example 30KB, or 1MB
     */
    String maxSize() default "";

    /**
     * Represents the type of file expected {@link FileType}
     * example VIDEO, AUDIO
     */
    FileType fileType() default ANY;

    String maxSizeErrorMessage() default "file.maximum.upload.size.exceeded";

    String fileTypeErrorMessage() default "file.wrong.type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
