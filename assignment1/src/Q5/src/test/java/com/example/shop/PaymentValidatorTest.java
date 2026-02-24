package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentValidatorTest {

    private PaymentValidator paymentValidator;

    @BeforeEach
    public void setUp() {
        paymentValidator = new PaymentValidator();
    }

    @Test
    public void testIsPaymentMethodNull() {
        assertFalse(paymentValidator.isPaymentMethodValid(null));
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
