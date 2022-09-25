package com.brielmayer.coffeecorner.product;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(final String message) {
        super(message);
    }
}
