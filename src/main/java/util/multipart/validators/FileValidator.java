package util.multipart.validators;

import com.linkapital.core.util.file_analizer.analysis.type.FileType;
import com.linkapital.core.util.multipart.Multipart;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintValidatorContext;
import java.util.Map;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

@Getter
@Setter
public abstract class FileValidator {

    protected String maxSize;
    protected Map<String, String> errorMessage;
    protected FileType fileType;
    protected boolean valid;

    public static boolean validate(ConstraintValidatorContext context, boolean expresion, String errorMessage) {
        if (!expresion)
            context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();

        return expresion;
    }

    public void initialize(Multipart constraintAnnotation) {

        valid = true;
        maxSize = constraintAnnotation.maxSize();
        fileType = constraintAnnotation.fileType();

        errorMessage = ofEntries(
                entry("maxSize", constraintAnnotation.maxSizeErrorMessage()),
                entry("fileType", constraintAnnotation.fileTypeErrorMessage()));
    }

}
