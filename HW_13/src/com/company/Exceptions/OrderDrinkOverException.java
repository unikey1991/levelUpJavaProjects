package com.company.Exceptions;

/**
 * Created by unike on 25.12.2016.
 */
public class OrderDrinkOverException extends Exception {
    public OrderDrinkOverException() {
    }

    public OrderDrinkOverException(String message) {
        super(message);
    }

    public OrderDrinkOverException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDrinkOverException(Throwable cause) {
        super(cause);
    }
}
