package com.brielmayer.coffeecorner.order;

import com.brielmayer.coffeecorner.extra.Extra;
import com.brielmayer.coffeecorner.orderedProduct.OrderedProduct;
import com.brielmayer.coffeecorner.product.ProductType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Order {

    private static final int FREE_BEVERAGE = 5;

    private final int stampsOnStampCard;
    private final List<OrderedProduct> orderedProducts = new ArrayList<>();

    public Order(final int stampsOnStampCard) {
        this.stampsOnStampCard = stampsOnStampCard;
    }

    public void addOrderedProduct(final OrderedProduct orderedProduct) {
        orderedProducts.add(orderedProduct);
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public BigDecimal getFinalPrice() {
        int numberOfSnacks = getNumberOfSnacks();
        int tempStampsOnCard = stampsOnStampCard;

        BigDecimal finalPrice = new BigDecimal("0.00");
        for (final OrderedProduct product : orderedProducts) {

            if(product.type() == ProductType.BEVERAGE && ++tempStampsOnCard > FREE_BEVERAGE) {
                tempStampsOnCard = 0;
            } else {
                finalPrice = finalPrice.add(product.price());
            }

            // sort extras by price, so customer gets a discount on the most expensive extra
            final List<Extra> sortedExtras = new ArrayList<>(product.extras());
            sortedExtras.sort(Comparator.comparing(Extra::price, Collections.reverseOrder()));

            for (final Extra extra : sortedExtras) {
                if (--numberOfSnacks < 0) {
                    finalPrice = finalPrice.add(extra.price());
                }
            }
        }
        return finalPrice;
    }

    @Override
    public String toString() {
        int numberOfSnacks = getNumberOfSnacks();
        int tempStampsOnStampCard = stampsOnStampCard;

        final String format = "%-15s %10s\n";

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(format, "Item", "Price"));
        stringBuilder.append(String.format(format, "----", "-----"));

        for (final OrderedProduct product : orderedProducts) {
            if(product.type() == ProductType.BEVERAGE && ++tempStampsOnStampCard > FREE_BEVERAGE) {
                tempStampsOnStampCard = 0;
                stringBuilder.append(String.format(format, product.name(), "0.00"));
            } else {
                stringBuilder.append(String.format(format, product.name(), product.price()));
            }

            // sort extras by price, so customer gets a discount on the most expensive extra
            final List<Extra> sortedExtras = new ArrayList<>(product.extras());
            sortedExtras.sort(Comparator.comparing(Extra::price, Collections.reverseOrder()));

            for (final Extra extra : sortedExtras) {
                if (--numberOfSnacks < 0) {
                    stringBuilder.append(String.format(format, "+ " + extra.name(), extra.price()));
                } else {
                    stringBuilder.append(String.format(format, "+ " + extra.name(), "0.00"));
                }
            }
        }

        stringBuilder.append(String.format(format, "----", "-----"));
        stringBuilder.append(String.format(format, "Total", getFinalPrice()));

        stringBuilder.append("\n");
        stringBuilder.append("You receive ").append(tempStampsOnStampCard - stampsOnStampCard).append(" stamp(s) on your beverage stamp card.\n");

        return stringBuilder.toString();
    }

    private int getNumberOfSnacks() {
        return orderedProducts.stream()
            .filter(orderedProduct -> orderedProduct.type() == ProductType.SNACK)
            .mapToInt(orderedProduct -> 1)
            .sum();
    }
}
