package com;

import com.builder.Product;
import com.builder.ProductBuilder;
import com.util.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        product1 = new ProductBuilder()
                .setId("P001")
                .setName("Laptop")
                .setPrice(1000.0)
                .setCategory("Electronics")
                .build();
        product2 = new ProductBuilder()
                .setId("P002")
                .setName("Mouse")
                .setPrice(25.0)
                .setCategory("Accessories")
                .build();
    }

    @Test
    void testAddProduct_Success() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getItemCount(), "Cart should contain 2 items");
        assertEquals(1025.0, cart.getTotalPrice(), 0.01, "Total should be 1025");
    }

    @Test
    void testRemoveProduct_Success() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);

        assertEquals(1, cart.getItemCount(), "Cart should contain 1 item");
        assertEquals(25.0, cart.getTotalPrice(), 0.01, "Total should be 25");
    }

    @Test
    void testAddNullProduct_Fail() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(null);
        }, "Adding null product should throw exception");
    }

    @Test
    void testClearCart_Success() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.clear();

        assertEquals(0, cart.getItemCount(), "Cart should be empty");
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Total should be 0");
    }
}