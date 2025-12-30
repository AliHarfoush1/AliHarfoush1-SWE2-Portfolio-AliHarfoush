package com.factory;

public class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            return false;
        }
        System.out.println("Processing credit card payment: $" + amount);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}
