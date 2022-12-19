package multipart.validators;

import file_analizer.analizers.MultipartFileAnalyzer;
import multipart.Multipart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import static file_analizer.analysis.type.FileType.ANY;
import static java.util.Arrays.stream;
import static org.springframework.util.StringUtils.hasText;
import static org.springframework.util.unit.DataSize.ofBytes;
import static org.springframework.util.unit.DataSize.parse;
import static util.MessageContextHolder.msg;

public class MultipartArrayValidator extends FileValidator implements ConstraintValidator<Multipart, MultipartFile[]> {

    @Override
    public boolean isValid(MultipartFile[] files, ConstraintValidatorContext context) {
        if (files.length > 0) {
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
