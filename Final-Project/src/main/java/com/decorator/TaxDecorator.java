package com.decorator;

public class TaxDecorator extends ProductDecorator {
    private double taxPercentage;

    public TaxDecorator(ProductPrice productPrice, double taxPercentage) {
        super(productPrice);
        this.taxPercentage = taxPercentage;
    }

    @Override
    public double getPrice() {
        double originalPrice = productPrice.getPrice();
        return originalPrice + (originalPrice * taxPercentage / 100);
    }

    @Override
    public String getDescription() {
        return productPrice.getDescription() + " (Tax: " + taxPercentage + "%)";
    }
}