package com.brielmayer.coffeecorner.order;

public class InvalidOrderException extends Exception {

    public InvalidOrderException(final String message) {
        super(message);
    }
}
