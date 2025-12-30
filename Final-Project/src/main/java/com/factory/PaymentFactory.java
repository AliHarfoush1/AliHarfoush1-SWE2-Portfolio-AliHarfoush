package com.factory;

public class PaymentFactory {
    public static Payment createPayment(String type, String credential) {
        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }

        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment(credential);
            case "paypal":
                return new PayPalPayment(credential);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}