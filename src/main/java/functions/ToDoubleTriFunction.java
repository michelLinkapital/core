package functions;

@FunctionalInterface
public interface ToDoubleTriFunction<T, U, S> {


    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @param s the three function argument
     * @return the function result
     */
    double applyAsDouble(T t, U u, S s);

}
