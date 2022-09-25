package com.brielmayer.coffeecorner.orderedProduct;

import com.brielmayer.coffeecorner.extra.Extra;
import com.brielmayer.coffeecorner.product.ProductType;

import java.math.BigDecimal;
import java.util.List;

// Entity
public class OrderedProduct {

    private final String name;
    private final BigDecimal price;
    private final ProductType type;
    private final List<Extra> extras;

    public OrderedProduct(final String name, final BigDecimal price, final ProductType type, final List<Extra> extras) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.extras = extras;
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

    public List<Extra> getExtras() {
        return extras;
    }
}
