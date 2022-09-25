package com.brielmayer.coffeecorner.order;

import com.brielmayer.coffeecorner.extra.Extra;
import com.brielmayer.coffeecorner.extra.ExtraNotFoundException;
import com.brielmayer.coffeecorner.orderedProduct.OrderedProduct;
import com.brielmayer.coffeecorner.product.Product;
import com.brielmayer.coffeecorner.product.ProductDao;
import com.brielmayer.coffeecorner.product.ProductNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class OrderParser {

    private static final Pattern PRODUCT_SEPARATOR_PATTERN = Pattern.compile("\\W?,\\W?");
    private static final Pattern EXTRA_SEPARATOR_PATTERN = Pattern.compile("\\Wwith\\W");

    public Order parse(final String order, final int stampsOnStampCared) throws InvalidOrderException, ProductNotFoundException, ExtraNotFoundException {
        final Order finalOrder = new Order(stampsOnStampCared);

        final String[] orderedProducts = PRODUCT_SEPARATOR_PATTERN.split(order);
        for (final String orderedProduct : orderedProducts) {

            final String[] productParts = EXTRA_SEPARATOR_PATTERN.split(orderedProduct);
            if (productParts.length < 1) {
                throw new InvalidOrderException(orderedProduct);
            }

            final String productName = productParts[0];
            final String[] extras = Arrays.copyOfRange(productParts, 1, productParts.length);

            final OrderedProduct finalOrderedProduct = getOrderedProduct(productName, extras);
            finalOrder.addOrderedProduct(finalOrderedProduct);
        }

        return finalOrder;
    }

    private OrderedProduct getOrderedProduct(final String productName, final String[] extras) throws ProductNotFoundException, ExtraNotFoundException {
        final Product product = new ProductDao().getAllProducts().stream()
            .filter(p -> p.name().equals(productName))
            .findFirst()
            .orElseThrow(() -> new ProductNotFoundException(productName));

        final OrderedProduct orderedProduct = getOrderedProductWithoutExtras(product);
        orderedProduct.extras().addAll(getExtras(product, extras));
        return orderedProduct;
    }

    private OrderedProduct getOrderedProductWithoutExtras(final Product product) {
        return new OrderedProduct(product.name(), product.price(), product.type(), new ArrayList<>());
    }

    private List<Extra> getExtras(final Product product, final String[] extras) throws ExtraNotFoundException {
        final List<Extra> actualExtras = new ArrayList<>();
        for (final String extra : extras) {
            final Extra actualExtra = product.extras().stream()
                .filter(e -> e.name().equals(extra))
                .findFirst()
                .orElseThrow(() -> new ExtraNotFoundException(extra));
            actualExtras.add(actualExtra);
        }
        return actualExtras;
    }
}
