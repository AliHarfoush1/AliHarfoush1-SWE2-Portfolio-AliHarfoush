package com.decorator;

import com.builder.Product;

public class BasicProduct implements ProductPrice {
    private Product product;

    public BasicProduct(Product product) {
        this.product = product;
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public String getDescription() {
        return product.getName();
    }
}