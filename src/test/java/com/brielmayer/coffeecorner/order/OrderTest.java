package com.brielmayer.coffeecorner.order;

import com.brielmayer.coffeecorner.extra.Extra;
import com.brielmayer.coffeecorner.orderedProduct.OrderedProduct;
import com.brielmayer.coffeecorner.product.ProductType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderTest {

    private static final Extra EXTRA_MILK = new Extra("extra milk", new BigDecimal("0.50"));

    private static final OrderedProduct SMALL_COFFEE = new OrderedProduct("small coffee", new BigDecimal("1.00"), ProductType.BEVERAGE, List.of());
    private static final OrderedProduct SMALL_COFFEE_WITH_MILK = new OrderedProduct("small coffee", new BigDecimal("1.00"), ProductType.BEVERAGE, List.of(EXTRA_MILK));
    private static final OrderedProduct BACON_ROLL = new OrderedProduct("bacon roll", new BigDecimal("2.00"), ProductType.SNACK, List.of());

    @Test
    public void testSmallCoffee() {
        final Order order = new Order(0);
        order.addOrderedProduct(SMALL_COFFEE);

        // no discount
        Assertions.assertEquals(new BigDecimal("1.00"), order.getFinalPrice());
    }

    @Test
    public void testSmallCoffeeWithMilkAndBaconRoll() {
        final Order order = new Order(0);
        order.addOrderedProduct(SMALL_COFFEE_WITH_MILK);
        order.addOrderedProduct(BACON_ROLL);

        // 1 extra is for free
        Assertions.assertEquals(new BigDecimal("3.00"), order.getFinalPrice());
    }

    // and so on...

}
