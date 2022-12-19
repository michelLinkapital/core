package multipart.validators;

import file_analizer.analizers.MultipartFileAnalyzer;
import multipart.Multipart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.springframework.util.StringUtils.hasText;
import static org.springframework.util.unit.DataSize.ofBytes;
import static org.springframework.util.unit.DataSize.parse;
import static util.MessageContextHolder.msg;

public class MultipartValidator extends FileValidator implements ConstraintValidator<Multipart, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file != null && !file.isEmpty()) {
            context.disableDefaultConstraintViolation();

            if (hasText(maxSize)) {
                valid = validate(context, parse(maxSize).compareTo(ofBytes(file.getSize())) > 0,
                        msg(errorMessage.get("maxSize")));
            }

            if (valid && fileType != null && hasText(fileType.getValue())) {
                valid = validate(context, new MultipartFileAnalyzer().isFileType(file, fileType),
                        msg(errorMessage.get("fileType")));
            }
        }

        return valid;
    }

}
