package exceptions;

import java.io.Serial;

public class LambdaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7111215781378668614L;

    public LambdaException(Throwable e) {
        super(e);
    }

}
