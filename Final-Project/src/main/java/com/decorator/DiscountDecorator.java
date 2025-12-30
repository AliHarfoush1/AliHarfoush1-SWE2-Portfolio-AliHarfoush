package com.decorator;

public class DiscountDecorator extends ProductDecorator {
    private double discountPercentage;

    public DiscountDecorator(ProductPrice productPrice, double discountPercentage) {
        super(productPrice);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        double originalPrice = productPrice.getPrice();
        return originalPrice - (originalPrice * discountPercentage / 100);
    }

    @Override
    public String getDescription() {
        return productPrice.getDescription() + " (Discount: " + discountPercentage + "%)";
    }
}