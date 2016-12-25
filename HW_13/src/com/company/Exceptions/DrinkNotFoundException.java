package com.company.Exceptions;

/**
 * Created by unike on 25.12.2016.
 */
public class DrinkNotFoundException extends Exception{

    public DrinkNotFoundException() {
    }

    public DrinkNotFoundException(String message) {
        super(message);
    }

    public DrinkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DrinkNotFoundException(Throwable cause) {
        super(cause);
    }
}
