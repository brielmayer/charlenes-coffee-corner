package com.brielmayer.coffeecorner.order;

import java.io.Serial;

public class InvalidOrderException extends Exception {

    @Serial
    private static final long serialVersionUID = -5940888653614399130L;

    public InvalidOrderException(final String message) {
        super(message);
    }
}
