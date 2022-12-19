package functions;

import exceptions.LambdaException;

import java.util.function.Supplier;

@FunctionalInterface
public interface ThrowingSupplier<R, E extends Exception> {

    static <R> Supplier<R> supplierWrapper(ThrowingSupplier<R, Exception> supplier) {
        return () -> {
            try {
                return supplier.get();
            } catch (Exception ex) {
                throw new LambdaException(ex);
            }
        };
    }

    R get() throws E;

}