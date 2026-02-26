package com.example.shop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    public void testConstructor_NegativeQuantity_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("Mouse", -5, 25.0);
        });
    }

    @Test
    public void testGetTotalPrice_MultipleItems() {
        OrderItem item = new OrderItem("Tablet", 3, 200.0);
        assertEquals(600.0, item.getTotalPrice(), 0.01);
    }
}
