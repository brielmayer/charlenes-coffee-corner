package com.brielmayer.coffeecorner;

import com.brielmayer.coffeecorner.extra.ExtraNotFoundException;
import com.brielmayer.coffeecorner.order.InvalidOrderException;
import com.brielmayer.coffeecorner.order.Order;
import com.brielmayer.coffeecorner.order.OrderParser;
import com.brielmayer.coffeecorner.product.ProductNotFoundException;

import java.io.IOException;

public final class Main {

    private static final Console CONSOLE = new Console();

    public static void main(final String[] args) throws IOException {
        CONSOLE.writeLine("Welcome to Charlene's Coffee Corner! May I take your order?");
        final String order = CONSOLE.readLine();

        CONSOLE.writeLine("Stamps on your stamp card?");
        final int stampsOnStampCard = Integer.parseInt(CONSOLE.readLine());

        final OrderParser orderParser = new OrderParser();
        try {
            final Order parsedOrder = orderParser.parse(order, stampsOnStampCard);
            CONSOLE.writeLine(parsedOrder.toString());
        } catch (final InvalidOrderException e) {
            CONSOLE.writeLine("Invalid order: " + e.getMessage());
        } catch (final ProductNotFoundException e) {
            CONSOLE.writeLine("Product not found: " + e.getMessage());
        } catch (final ExtraNotFoundException e) {
            CONSOLE.writeLine("Extra not found: " + e.getMessage());
        }
    }
}
