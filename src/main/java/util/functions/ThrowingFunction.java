package util.functions;

import com.linkapital.core.exceptions.LambdaException;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Exception> {

    static <T, R> Function<T, R> functionWrapper(ThrowingFunction<T, R, Exception> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception ex) {
                throw new LambdaException(ex);
            }
        };
    }

    R apply(T t) throws E;

}