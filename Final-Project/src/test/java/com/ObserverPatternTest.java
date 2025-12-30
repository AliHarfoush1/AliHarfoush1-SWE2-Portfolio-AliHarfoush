package com;

import com.observer.Customer;
import com.observer.Order;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverPatternTest {

    private Order order;
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        order = new Order("ORD001");
        customer1 = new Customer("John Doe", "john@example.com");
        customer2 = new Customer("Jane Smith", "jane@example.com");
    }

    @Test
    void testAttachObserver_Success() {
        order.attach(customer1);
        order.updateStatus("Processing");

        assertEquals("Processing", order.getStatus(), "Order status should be updated");
    }

    @Test
    void testMultipleObservers_Success() {
        order.attach(customer1);
        order.attach(customer2);
        order.updateStatus("Shipped");

        assertEquals("Shipped", order.getStatus(), "Order status should be updated");
    }

    @Test
    void testDetachObserver_Success() {
        order.attach(customer1);
        order.attach(customer2);
        order.detach(customer1);
        order.updateStatus("Delivered");

        assertEquals("Delivered", order.getStatus());
    }

    @Test
    void testOrderInitialStatus_Success() {
        assertEquals("Created", order.getStatus(), "Initial status should be 'Created'");
        assertEquals("ORD001", order.getOrderId());
    }
}
