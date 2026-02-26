package com.example.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
    }

    @Test
    public void testProcessOrder_InvalidPaymentMethod() {
        Order order = new Order();
        order.addItem(new OrderItem("Laptop", 1, 1000.0));
        
        double result = orderService.processOrder(order, null, "crypto");
        
        assertEquals(0.0, result, 0.01);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    public void testProcessOrder_ValidPayment_WithDiscount() {
        Order order = new Order();
        order.addItem(new OrderItem("Monitor", 1, 200.0));
        
        double result = orderService.processOrder(order, "STUDENT10", "card");
        
        assertEquals(216.0, result, 0.01);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    public void testProcessOrder_ValidPayment_NoDiscount() {
        Order order = new Order();
        order.addItem(new OrderItem("Keyboard", 1, 100.0));
        
        double result = orderService.processOrder(order, null, "card");
        
        assertEquals(120.0, result, 0.01);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }
}
