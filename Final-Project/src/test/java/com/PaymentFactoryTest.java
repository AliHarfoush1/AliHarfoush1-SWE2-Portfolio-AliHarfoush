package com;

import com.factory.Payment;
import com.factory.PaymentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFactoryTest {

    @Test
    void testCreateCreditCardPayment_Success() {
        Payment payment = PaymentFactory.createPayment("creditcard", "1234-5678-9012-3456");

        assertNotNull(payment, "Payment should not be null");
        assertEquals("Credit Card", payment.getPaymentType());
        assertTrue(payment.processPayment(100.0), "Payment should process successfully");
    }

    @Test
    void testCreatePayPalPayment_Success() {
        Payment payment = PaymentFactory.createPayment("paypal", "user@example.com");

        assertNotNull(payment, "Payment should not be null");
        assertEquals("PayPal", payment.getPaymentType());
        assertTrue(payment.processPayment(100.0), "Payment should process successfully");
    }

}
