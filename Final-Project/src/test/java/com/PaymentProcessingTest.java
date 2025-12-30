package com;

import com.factory.CreditCardPayment;
import com.factory.PayPalPayment;
import com.factory.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PaymentProcessingTest {

    private Payment creditCardPayment;
    private Payment paypalPayment;

    @BeforeEach
    void setUp() {
        creditCardPayment = new CreditCardPayment("1234-5678-9012-3456");
        paypalPayment = new PayPalPayment("user@example.com");
    }

    @Test
    void testCreditCardPayment_ValidAmount_Success() {
        boolean result = creditCardPayment.processPayment(250.50);
        assertTrue(result, "Valid payment should process successfully");
    }

    @Test
    void testCreditCardPayment_NegativeAmount_Fail() {
        boolean result = creditCardPayment.processPayment(-50.0);
        assertFalse(result, "Negative amount payment should fail");
    }

    @Test
    void testCreditCardPayment_ZeroAmount_Fail() {
        boolean result = creditCardPayment.processPayment(0);
        assertFalse(result, "Zero amount payment should fail");
    }

    @Test
    void testPayPalPayment_ValidEmail_Success() {
        boolean result = paypalPayment.processPayment(100.0);
        assertTrue(result, "Valid PayPal payment should succeed");
    }

    @Test
    void testPayPalPayment_InvalidEmail_Fail() {
        Payment invalidPayPal = new PayPalPayment("invalidemail");
        boolean result = invalidPayPal.processPayment(100.0);
        assertFalse(result, "PayPal payment with invalid email should fail");
    }
}