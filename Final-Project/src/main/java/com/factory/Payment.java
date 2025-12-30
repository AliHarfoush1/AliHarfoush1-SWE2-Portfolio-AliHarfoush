package com.factory;

public interface Payment {
    boolean processPayment(double amount);
    String getPaymentType();
}
