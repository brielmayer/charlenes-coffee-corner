package com.brielmayer.coffeecorner.orderedProduct;

import com.brielmayer.coffeecorner.extra.Extra;
import com.brielmayer.coffeecorner.product.ProductType;

import java.math.BigDecimal;
import java.util.List;

public record OrderedProduct(String name, BigDecimal price, ProductType type, List<Extra> extras) {
}
