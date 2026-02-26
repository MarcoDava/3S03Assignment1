package com.example.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentValidatorTest {

    private PaymentValidator paymentValidator;

    @BeforeEach
    public void setUp() {
        paymentValidator = new PaymentValidator();
    }

    @Test
    public void testIsPaymentMethodValid_Card() {
        assertTrue(paymentValidator.isPaymentMethodValid("card"));
    }

    @Test
    public void testIsPaymentMethodValid_Crypto() {
        assertFalse(paymentValidator.isPaymentMethodValid("crypto"));
    }

    @Test
    public void testIsPaymentMethodValid_UnknownMethod_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            paymentValidator.isPaymentMethodValid("bitcoin");
        });
    }
}
