package com.brielmayer.coffeecorner.product;

import com.brielmayer.coffeecorner.extra.Extra;

import java.math.BigDecimal;
import java.util.Set;

public record Product(String name, BigDecimal price, ProductType type, Set<Extra> extras) {
}
