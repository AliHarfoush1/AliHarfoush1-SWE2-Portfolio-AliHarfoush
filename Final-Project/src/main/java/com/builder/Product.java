package com.builder;

public class Product {
    private final String id;
    private final String name;
    private final double price;
    private final String category;
    private final String description;

    protected Product(ProductBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
        this.description = builder.description;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
}
