package com.brielmayer.coffeecorner.product;

import com.brielmayer.coffeecorner.extra.Extra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDao {

    // this should be a database call
    public List<Product> getAllProducts() {
        final List<Product> products = new ArrayList<>(5);
        addBeverages(products);
        addSnacks(products);
        return products;
    }

    private void addBeverages(final List<Product> products) {
        products.add(new Product(
            "small coffee",
            new BigDecimal("2.50"),
            ProductType.BEVERAGE,
            getCoffeeExtras())
        );
        products.add(new Product(
            "medium coffee",
            new BigDecimal("3.00"),
            ProductType.BEVERAGE,
            getCoffeeExtras())
        );
        products.add(new Product(
            "large coffee",
            new BigDecimal("3.50"),
            ProductType.BEVERAGE,
            getCoffeeExtras())
        );
        products.add(new Product(
            "orange juice",
            new BigDecimal("3.95"),
            ProductType.BEVERAGE,
            new HashSet<>(0))
        );
    }

    private void addSnacks(final List<Product> products) {
        products.add(new Product(
            "bacon roll",
            new BigDecimal("2.50"),
            ProductType.SNACK,
            new HashSet<>(0))
        );
    }

    private Set<Extra> getCoffeeExtras() {
        final Set<Extra> extras = new HashSet<>(3);
        extras.add(new Extra("extra milk", new BigDecimal("0.30")));
        extras.add(new Extra("foamed milk", new BigDecimal("0.50")));
        extras.add(new Extra("special roast", new BigDecimal("0.90")));
        return extras;
    }
}
