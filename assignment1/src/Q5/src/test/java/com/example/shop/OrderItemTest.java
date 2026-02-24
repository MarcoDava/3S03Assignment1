package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderItemTest {

    @Test
    public void testConstructor_NegativeQuantity_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("Mouse", -5, 25.0);
        });
    }

    @Test
    public void testConstructor_NegativePrice_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("Mouse", 5, -25.0);
        });
    }

    @Test
    public void testGetTotalPrice_MultipleItems() {
        OrderItem item = new OrderItem("Tablet", 3, 200.0);
        assertEquals(600.0, item.getTotalPrice(), 0.01);
    }
    @Test
    public void testGetQuantity_SingleItem() {
        OrderItem item = new OrderItem("Mouse", 2, 25.0);
        assertEquals(2, item.getQuantity());
    }
}
