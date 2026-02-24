package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testAddItem_WhenOrderCreated() {
        OrderItem item = new OrderItem("Laptop", 1, 1000.0);
        order.addItem(item);
        assertEquals(1, order.getItems().size());
    }
    @Test
    public void testAddItem_WhenOrderProcessed_ThrowsException() {
        order.setStatus(OrderStatus.PAID);
        OrderItem item = new OrderItem("Laptop", 1, 1000.0);
        assertThrows(IllegalStateException.class, () -> {
            order.addItem(item);
        });
    }

    @Test
    public void testGetStatus_InitiallyCreated() {
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }
}
