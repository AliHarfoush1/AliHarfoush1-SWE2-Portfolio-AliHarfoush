package com;

import com.builder.Product;
import com.builder.ProductBuilder;
import com.decorator.BasicProduct;
import com.decorator.DiscountDecorator;
import com.decorator.ProductPrice;
import com.decorator.TaxDecorator;
import com.factory.Payment;
import com.factory.PaymentFactory;
import com.observer.Customer;
import com.observer.Order;
import com.singleton.DatabaseConnection;
import com.strategy.ExpressShipping;
import com.strategy.ShippingContext;
import com.strategy.StandardShipping;

public class ECommerceSystem {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce System Demo ===\n");

        // 1. Singleton Pattern
        System.out.println("1. SINGLETON PATTERN - Database Connection");
        DatabaseConnection db = DatabaseConnection.getInstance();
        System.out.println("Database connected: " + db.isConnected());
        System.out.println();

        // 2. Builder Pattern
        System.out.println("2. BUILDER PATTERN - Creating Product");
        Product laptop = new ProductBuilder()
                .setId("P001")
                .setName("Gaming Laptop")
                .setPrice(1200.0)
                .setCategory("Electronics")
                .setDescription("High-performance gaming laptop")
                .build();
        System.out.println("Product created: " + laptop.getName() + " - $" + laptop.getPrice());
        System.out.println();

        // 3. Factory Method Pattern
        System.out.println("3. FACTORY METHOD PATTERN - Payment Processing");
        Payment payment = PaymentFactory.createPayment("creditcard", "1234-5678-9012-3456");
        System.out.println("Payment type: " + payment.getPaymentType());
        payment.processPayment(1200.0);
        System.out.println();

        // 4. Decorator Pattern
        System.out.println("4. DECORATOR PATTERN - Applying Discount & Tax");
        ProductPrice productPrice = new BasicProduct(laptop);
        productPrice = new DiscountDecorator(productPrice, 10);
        productPrice = new TaxDecorator(productPrice, 8);
        System.out.println(productPrice.getDescription());
        System.out.println("Final Price: $" + String.format("%.2f", productPrice.getPrice()));
        System.out.println();

        // 5. Strategy Pattern
        System.out.println("5. STRATEGY PATTERN - Shipping Calculation");
        ShippingContext shipping = new ShippingContext();
        shipping.setShippingStrategy(new StandardShipping());
        System.out.println(shipping.getMethod());
        System.out.println("Shipping Cost: $" + shipping.calculateCost(5.0, 100.0));

        shipping.setShippingStrategy(new ExpressShipping());
        System.out.println(shipping.getMethod());
        System.out.println("Shipping Cost: $" + shipping.calculateCost(5.0, 100.0));
        System.out.println();

        // 6. Observer Pattern
        System.out.println("6. OBSERVER PATTERN - Order Notifications");
        Order order = new Order("ORD001");
        Customer customer1 = new Customer("John Doe", "john@example.com");
        Customer customer2 = new Customer("Jane Smith", "jane@example.com");
        order.attach(customer1);
        order.attach(customer2);
        order.updateStatus("Processing");
        order.updateStatus("Shipped");
        order.updateStatus("Delivered");
    }
}