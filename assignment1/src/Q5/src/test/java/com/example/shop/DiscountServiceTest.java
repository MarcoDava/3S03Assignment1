package com.example.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountServiceTest {

    private DiscountService discountService;

    @BeforeEach
    public void setUp() {
        discountService = new DiscountService();
    }

    @Test
    public void testApplyDiscount_NullDiscountCode() {
        double result = discountService.applyDiscount(100.0, null);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    public void testApplyDiscount_Student10Code() {
        double result = discountService.applyDiscount(100.0, "STUDENT10");
        assertEquals(90.0, result, 0.01);
    }

    @Test
    public void testApplyDiscount_InvalidCode_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            discountService.applyDiscount(100.0, "INVALID");
        });
    }

    @Test
    public void testApplyDiscount_UnrecognizedCode() {
        double result = discountService.applyDiscount(100.0, "NOTACODE");
        assertEquals(100.0, result, 0.01);
    }
}
