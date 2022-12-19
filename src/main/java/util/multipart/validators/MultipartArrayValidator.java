package util.multipart.validators;

import com.linkapital.core.util.file_analizer.analizers.MultipartFileAnalyzer;
import com.linkapital.core.util.multipart.Multipart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import static com.linkapital.core.configuration.context.MessageContextHolder.msg;
import static com.linkapital.core.util.file_analizer.analysis.type.FileType.ANY;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;
import static org.springframework.util.StringUtils.hasText;
import static org.springframework.util.unit.DataSize.ofBytes;
import static org.springframework.util.unit.DataSize.parse;

public class MultipartArrayValidator extends FileValidator implements ConstraintValidator<Multipart, MultipartFile[]> {

    @Override
    public boolean isValid(MultipartFile[] files, ConstraintValidatorContext context) {
        if (!isEmpty(files)) {
            context.disableDefaultConstraintViolation();

            var totalSize = new AtomicLong(0L);
            var allTypesAreOK = new AtomicBoolean(true);
            var validator = new MultipartFileAnalyzer();

            stream(files)
                    .takeWhile(file -> allTypesAreOK.get())
                    .forEach(file -> {
                        totalSize.addAndGet(file.getSize());
                        if (fileType != ANY)
                            allTypesAreOK.set(validator.isFileType(file, fileType));
                    });

            if (!maxSize.isEmpty())
                valid = validate(context, parse(maxSize).compareTo(ofBytes(totalSize.get())) > 0,
                        msg(errorMessage.get("maxSize")));

            if (valid && !hasText(fileType.getValue()))
                valid = validate(context, allTypesAreOK.get(), msg(errorMessage.get("fileType")));
        }

        return valid;
    }

}
