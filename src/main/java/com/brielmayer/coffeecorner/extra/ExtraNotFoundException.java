package com.brielmayer.coffeecorner.extra;

import java.io.Serial;

public class ExtraNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = -2519348779351480131L;

    public ExtraNotFoundException(final String message) {
        super(message);
    }
}
