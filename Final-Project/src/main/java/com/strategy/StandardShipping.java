package com.strategy;

public class StandardShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(double weight, double distance) {
        if (weight <= 0 || distance <= 0) {
            return 0;
        }
        return weight * 0.5 + distance * 0.1;
    }

    @Override
    public String getShippingMethod() {
        return "Standard Shipping";
    }
}