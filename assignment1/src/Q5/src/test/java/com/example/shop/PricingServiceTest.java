package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PricingServiceTest {

    private PricingService pricingService;

    @BeforeEach
    public void setUp() {
        pricingService = new PricingService();
    }

    @Test
    public void testCalculateSubtotal_MultipleItems() {
        Order order = new Order();
        order.addItem(new OrderItem("Mouse", 2, 25.0));
        order.addItem(new OrderItem("Keyboard", 1, 75.0));
        
        double result = pricingService.calculateSubtotal(order);
        assertEquals(125.0, result, 0.01);
    }

    @Test
    public void testCalculateTax_NegativeSubtotal_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pricingService.calculateTax(-100.0);
        });
    }

    @Test
    public void testCalculateTax_PositiveSubtotal() {
        double result = pricingService.calculateTax(100.0);
        assertEquals(20.0, result, 0.01);
    }

    @Test
    public void testCalculateTax_zero() {
        double result = pricingService.calculateTax(0.0);
        assertEquals(0.0, result, 0.01);
    }
}
