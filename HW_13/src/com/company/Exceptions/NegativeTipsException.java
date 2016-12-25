package com.company.Exceptions;

/**
 * Created by unike on 25.12.2016.
 */
public class NegativeTipsException extends Exception{

    public NegativeTipsException() {
    }

    public NegativeTipsException(String message) {
        super(message);
    }

    public NegativeTipsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeTipsException(Throwable cause) {
        super(cause);
    }
}
