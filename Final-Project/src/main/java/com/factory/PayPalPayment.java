package com.factory;

public class PayPalPayment implements Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0 || email == null || !email.contains("@")) {
            return false;
        }
        System.out.println("Processing PayPal payment: $" + amount);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}
