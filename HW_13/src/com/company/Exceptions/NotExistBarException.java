package com.company.Exceptions;

/**
 * Created by unike on 25.12.2016.
 */
public class NotExistBarException extends Exception{

    public NotExistBarException() {
    }

    public NotExistBarException(String message) {
        super(message);
    }

    public NotExistBarException(Throwable cause) {
        super(cause);
    }

    public NotExistBarException(String message, Throwable cause) {
        super(message, cause);
    }
}
