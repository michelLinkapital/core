package stereotype;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated class is a "Business Service Facade". This annotation serves as a specialization of
 * {@link org.springframework.stereotype.Service @Service}, allowing for implementation classes to be autodetected through classpath scanning the
 * spring framework does.
 *
 * @since 0.1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface Facade {

    @AliasFor(annotation = Service.class, attribute = "value")
    String value() default "";

}
