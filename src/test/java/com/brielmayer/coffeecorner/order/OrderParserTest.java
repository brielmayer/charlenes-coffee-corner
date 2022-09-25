package com.brielmayer.coffeecorner.order;

import com.brielmayer.coffeecorner.extra.ExtraNotFoundException;
import com.brielmayer.coffeecorner.product.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderParserTest {

    final OrderParser orderParser = new OrderParser();

    @Test
    public void testSmallCoffeeWithNoExtras() throws InvalidOrderException, ExtraNotFoundException, ProductNotFoundException {
        final Order order = orderParser.parse("small coffee", 0);

        // expect 1 product
        Assertions.assertEquals(1, order.getOrderedProducts().size());
        Assertions.assertEquals("small coffee", order.getOrderedProducts().get(0).name());

        // expect 1 extra
        Assertions.assertEquals(0, order.getOrderedProducts().get(0).extras().size());
    }

    @Test
    public void testSmallCoffeeWithExtraMilk() throws InvalidOrderException, ExtraNotFoundException, ProductNotFoundException {
        final Order order = orderParser.parse("small coffee with extra milk", 0);

        // expect 1 product
        Assertions.assertEquals(1, order.getOrderedProducts().size());
        Assertions.assertEquals("small coffee", order.getOrderedProducts().get(0).name());

        // expect 1 extra
        Assertions.assertEquals(1, order.getOrderedProducts().get(0).extras().size());
        Assertions.assertEquals("extra milk", order.getOrderedProducts().get(0).extras().get(0).name());
    }

    @Test
    public void testSmallCoffeeWithDoubleExtraMilk() throws InvalidOrderException, ExtraNotFoundException, ProductNotFoundException {
        final Order order = orderParser.parse("small coffee with extra milk with extra milk", 0);

        // expect 1 product
        Assertions.assertEquals(1, order.getOrderedProducts().size());
        Assertions.assertEquals("small coffee", order.getOrderedProducts().get(0).name());

        // expect 2 extras
        Assertions.assertEquals(2, order.getOrderedProducts().get(0).extras().size());
        Assertions.assertEquals("extra milk", order.getOrderedProducts().get(0).extras().get(0).name());
        Assertions.assertEquals("extra milk", order.getOrderedProducts().get(0).extras().get(1).name());
    }

    @Test
    public void testSmallCoffeeWithExtraMilkAndSpecialRoast() throws InvalidOrderException, ExtraNotFoundException, ProductNotFoundException {
        final Order order = orderParser.parse("small coffee with extra milk with special roast", 0);

        // expect 1 product
        Assertions.assertEquals(1, order.getOrderedProducts().size());
        Assertions.assertEquals("small coffee", order.getOrderedProducts().get(0).name());

        // expect 2 extras
        Assertions.assertEquals(2, order.getOrderedProducts().get(0).extras().size());
        Assertions.assertEquals("extra milk", order.getOrderedProducts().get(0).extras().get(0).name());
        Assertions.assertEquals("special roast", order.getOrderedProducts().get(0).extras().get(1).name());
    }

    @Test
    public void testSmallCoffeeWithExtraMilkAndBaconRoll() throws InvalidOrderException, ExtraNotFoundException, ProductNotFoundException {
        final Order order = orderParser.parse("small coffee with extra milk, bacon roll", 0);

        // expect 2 product
        Assertions.assertEquals(2, order.getOrderedProducts().size());
        Assertions.assertEquals("small coffee", order.getOrderedProducts().get(0).name());
        Assertions.assertEquals("bacon roll", order.getOrderedProducts().get(1).name());

        // expect 1 extra
        Assertions.assertEquals(1, order.getOrderedProducts().get(0).extras().size());
        Assertions.assertEquals("extra milk", order.getOrderedProducts().get(0).extras().get(0).name());
    }

    // and so on...

}
