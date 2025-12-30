package com.strategy;

public class ShippingContext {
    private ShippingStrategy strategy;

    public void setShippingStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateCost(double weight, double distance) {
        if (strategy == null) {
            throw new IllegalStateException("Shipping main.java.com.factory.strategy not set");
        }
        return strategy.calculateShippingCost(weight, distance);
    }

    public String getMethod() {
        if (strategy == null) {
            throw new IllegalStateException("Shipping main.java.com.factory.strategy not set");
        }
        return strategy.getShippingMethod();
    }
}
