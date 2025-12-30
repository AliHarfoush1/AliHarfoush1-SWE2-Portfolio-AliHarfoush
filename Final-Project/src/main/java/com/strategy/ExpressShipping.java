package com.strategy;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(double weight, double distance) {
        if (weight <= 0 || distance <= 0) {
            return 0;
        }
        return weight * 1.5 + distance * 0.3;
    }

    @Override
    public String getShippingMethod() {
        return "Express Shipping";
    }
}
