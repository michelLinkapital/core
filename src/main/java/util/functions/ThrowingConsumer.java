package util.functions;

import com.linkapital.core.exceptions.LambdaException;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {

    static <T> Consumer<T> consumerWrapper(ThrowingConsumer<T, Exception> consumer) {

        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                throw new LambdaException(ex);
            }
        };
    }

    void accept(T t) throws E;

}