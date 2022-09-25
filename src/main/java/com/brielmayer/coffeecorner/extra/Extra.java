package com.brielmayer.coffeecorner.extra;

import java.math.BigDecimal;

// Entity
public class Extra {

    private final String name;
    private final BigDecimal price;

    public Extra(final String name, final BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Extra extra = (Extra) o;

        return name.equals(extra.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
