package com;

import com.builder.Product;
import com.builder.ProductBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductBuilderTest {

    @Test
    void testBuildProduct_ValidData_Success() {
        Product product = new ProductBuilder()
                .setId("P001")
                .setName("Laptop")
                .setPrice(999.99)
                .setCategory("Electronics")
                .setDescription("High-end laptop")
                .build();

        assertNotNull(product, "Product should not be null");
        assertEquals("P001", product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice(), 0.01);
        assertEquals("Electronics", product.getCategory());
    }

    @Test
    void testBuildProduct_MissingId_Fail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProductBuilder()
                    .setName("Laptop")
                    .setPrice(999.99)
                    .build();
        }, "Building product without ID should throw exception");
    }

    @Test
    void testBuildProduct_NegativePrice_Fail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProductBuilder()
                    .setId("P001")
                    .setName("Laptop")
                    .setPrice(-999.99)
                    .build();
        }, "Building product with negative price should throw exception");
    }

    @Test
    void testBuildProduct_ZeroPrice_Fail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProductBuilder()
                    .setId("P001")
                    .setName("Laptop")
                    .setPrice(0)
                    .build();
        }, "Building product with zero price should throw exception");
    }
}
