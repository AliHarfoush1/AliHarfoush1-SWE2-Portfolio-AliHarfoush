package com.builder;

public class ProductBuilder {
    String id;
    String name;
    double price;
    String category;
    String description;

    public ProductBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product build() {
        if (id == null || name == null || price <= 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        return new Product(this);
    }
}