package com.brielmayer.coffeecorner.product;

import java.io.Serial;

public class ProductNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = -9185202448119122887L;

    public ProductNotFoundException(final String message) {
        super(message);
    }
}
