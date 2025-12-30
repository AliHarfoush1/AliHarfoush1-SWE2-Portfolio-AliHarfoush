package com.decorator;

public abstract class ProductDecorator implements ProductPrice {
    protected ProductPrice productPrice;

    public ProductDecorator(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }
}
