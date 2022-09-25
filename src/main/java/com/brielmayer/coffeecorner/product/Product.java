package com.brielmayer.coffeecorner.product;

import com.brielmayer.coffeecorner.extra.Extra;

import java.math.BigDecimal;
import java.util.Set;

// Entity
public class Product {

    private final String name;
    private final BigDecimal price;
    private final ProductType type;
    private final Set<Extra> extras;

    public Product(final String name, final BigDecimal price, final ProductType type, final Set<Extra> extras) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.extras = extras;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Product product = (Product) o;

        return name.equals(product.name);
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

    public ProductType getType() {
        return type;
    }

    public Set<Extra> getExtras() {
        return extras;
    }
}
