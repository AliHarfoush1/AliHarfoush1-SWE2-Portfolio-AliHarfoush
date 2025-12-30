package com;

import com.strategy.ExpressShipping;
import com.strategy.ShippingContext;
import com.strategy.StandardShipping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShippingStrategyTest {

    private ShippingContext shippingContext;

    @BeforeEach
    void setUp() {
        shippingContext = new ShippingContext();
    }

    @Test
    void testStandardShipping_ValidData_Success() {
        shippingContext.setShippingStrategy(new StandardShipping());
        double cost = shippingContext.calculateCost(10.0, 50.0);

        assertEquals(10.0, cost, 0.01, "Standard shipping cost should be calculated correctly");
        assertEquals("Standard Shipping", shippingContext.getMethod());
    }

    @Test
    void testExpressShipping_ValidData_Success() {
        shippingContext.setShippingStrategy(new ExpressShipping());
        double cost = shippingContext.calculateCost(10.0, 50.0);

        assertEquals(30.0, cost, 0.01, "Express shipping cost should be calculated correctly");
        assertEquals("Express Shipping", shippingContext.getMethod());
    }

    @Test
    void testShipping_NegativeWeight_Fail() {
        shippingContext.setShippingStrategy(new StandardShipping());
        double cost = shippingContext.calculateCost(-5.0, 50.0);

        assertEquals(0.0, cost, 0.01, "Negative weight should result in 0 cost");
    }

    @Test
    void testShipping_NoStrategySet_Fail() {
        assertThrows(IllegalStateException.class, () -> {
            shippingContext.calculateCost(10.0, 50.0);
        }, "Should throw exception when strategy is not set");
    }
}
