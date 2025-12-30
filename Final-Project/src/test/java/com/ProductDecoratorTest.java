package com;

import com.builder.Product;
import com.builder.ProductBuilder;
import com.decorator.BasicProduct;
import com.decorator.DiscountDecorator;
import com.decorator.ProductPrice;
import com.decorator.TaxDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductDecoratorTest {

    private Product baseProduct;

    @BeforeEach
    void setUp() {
        baseProduct = new ProductBuilder()
                .setId("P001")
                .setName("Laptop")
                .setPrice(1000.0)
                .setCategory("Electronics")
                .build();
    }

    @Test
    void testDiscountDecorator_Success() {
        ProductPrice productPrice = new BasicProduct(baseProduct);
        productPrice = new DiscountDecorator(productPrice, 10);

        assertEquals(900.0, productPrice.getPrice(), 0.01, "Price should be discounted by 10%");
        assertTrue(productPrice.getDescription().contains("Discount: 10%"));
    }

    @Test
    void testTaxDecorator_Success() {
        ProductPrice productPrice = new BasicProduct(baseProduct);
        productPrice = new TaxDecorator(productPrice, 8);

        assertEquals(1080.0, productPrice.getPrice(), 0.01, "Price should include 8% tax");
        assertTrue(productPrice.getDescription().contains("Tax: 8%"));
    }

    @Test
    void testMultipleDecorators_Success() {
        ProductPrice productPrice = new BasicProduct(baseProduct);
        productPrice = new DiscountDecorator(productPrice, 10);
        productPrice = new TaxDecorator(productPrice, 8);

        assertEquals(972.0, productPrice.getPrice(), 0.01, "Price should have discount then tax applied");
    }

    @Test
    void testDiscountDecorator_FullDiscount_EdgeCase() {
        ProductPrice productPrice = new BasicProduct(baseProduct);
        productPrice = new DiscountDecorator(productPrice, 100);

        assertEquals(0.0, productPrice.getPrice(), 0.01, "100% discount should result in 0 price");
    }
}
