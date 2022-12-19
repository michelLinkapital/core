package functions;

@FunctionalInterface
public interface ToDoubleFourFunction<T, U, S, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @param s the third function argument
     * @param r the four function argument
     * @return the function result
     */
    double applyAsDouble(T t, U u, S s, R r);

}
