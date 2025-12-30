# E-Commerce System with SOLID Principles & Design Patterns

## 📋 Project Overview
This is a comprehensive Java e-commerce system demonstrating **SOLID principles** and **6 Design Patterns** with complete JUnit test coverage.

## 🎯 Design Patterns Implemented

### 1. **Singleton Pattern**
- **Class:** `DatabaseConnection`
- **Purpose:** Ensures only one database connection instance exists
- **SOLID Principle:** Single Responsibility Principle (SRP)

### 2. **Builder Pattern**
- **Class:** `Product` with `ProductBuilder`
- **Purpose:** Constructs complex Product objects step by step
- **SOLID Principle:** Single Responsibility, Open/Closed Principle

### 3. **Factory Method Pattern**
- **Class:** `PaymentFactory`
- **Purpose:** Creates different payment types (CreditCard, PayPal) without exposing creation logic
- **SOLID Principle:** Dependency Inversion Principle (DIP)

### 4. **Decorator Pattern**
- **Classes:** `DiscountDecorator`, `TaxDecorator`
- **Purpose:** Dynamically adds features (discount, tax) to products
- **SOLID Principle:** Open/Closed Principle (OCP)

### 5. **Strategy Pattern**
- **Classes:** `ShippingStrategy`, `StandardShipping`, `ExpressShipping`
- **Purpose:** Encapsulates different shipping algorithms
- **SOLID Principle:** Interface Segregation, Dependency Inversion

### 6. **Observer Pattern**
- **Classes:** `Order` (Subject), `Customer` (Observer)
- **Purpose:** Notifies customers about order status changes
- **SOLID Principle:** Single Responsibility, Dependency Inversion

## 🧪 JUnit Test Coverage

### Test Classes Included:
1. **PaymentFactoryTest** - Tests factory pattern with valid/invalid inputs
2. **PaymentProcessingTest** - Tests payment processing success/failure scenarios
3. **ProductBuilderTest** - Tests product creation with valid/invalid data
4. **ShippingStrategyTest** - Tests shipping cost calculations
5. **ProductDecoratorTest** - Tests discount and tax decorators
6. **ObserverPatternTest** - Tests notification system
7. **SingletonPatternTest** - Tests singleton instance uniqueness
8. **ShoppingCartTest** - Tests cart operations

### Test Scenarios:
Each test class includes:
- ✅ **Success Scenarios (Pass)**: Valid inputs and expected behavior
- ❌ **Failure Scenarios (Fail)**: Invalid inputs, edge cases, exceptions

## 📊 SOLID Principles Applied

### 1. Single Responsibility Principle (SRP)
- Each class has one reason to change
- `Product` handles product data only
- `Payment` handles payment processing only
- `ShippingStrategy` handles shipping calculations only

### 2. Open/Closed Principle (OCP)
- Classes are open for extension, closed for modification
- New payment types can be added without modifying `PaymentFactory`
- New decorators can be added without modifying `ProductPrice`

### 3. Liskov Substitution Principle (LSP)
- All payment implementations can substitute `Payment` interface
- All shipping strategies can substitute `ShippingStrategy` interface

### 4. Interface Segregation Principle (ISP)
- Small, focused interfaces: `Payment`, `ShippingStrategy`, `Observer`
- Clients only depend on methods they use

### 5. Dependency Inversion Principle (DIP)
- High-level modules depend on abstractions, not concrete classes
- `ShippingContext` depends on `ShippingStrategy` interface
- `Order` depends on `Observer` interface

## 🚀 How to Run

### Prerequisites:
- Java 8 or higher
- JUnit 5
- Maven or Gradle (optional)

### Compilation:
```bash
javac ECommerceSystem.java
```

### Run Main Program:
```bash
java ECommerceSystem
```

### Run Tests:
```bash
# Using Maven
mvn test

# Using Gradle
gradle test

# Using IDE (IntelliJ IDEA / Eclipse)
Right-click on test class → Run as JUnit Test
```

## 📁 Project Structure

```
ecommerce-system/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ECommerceSystem.java
│   └── test/
│       └── java/
│           ├── PaymentFactoryTest.java
│           ├── PaymentProcessingTest.java
│           ├── ProductBuilderTest.java
│           ├── ShippingStrategyTest.java
│           ├── ProductDecoratorTest.java
│           ├── ObserverPatternTest.java
│           ├── SingletonPatternTest.java
│           └── ShoppingCartTest.java
├── pom.xml (Maven)
└── README.md
```

## 🔧 Maven Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.3</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 📝 Example Usage

```java
// Create a product
Product laptop = new Product.ProductBuilder()
    .setId("P001")
    .setName("Gaming Laptop")
    .setPrice(1200.0)
    .build();

// Apply decorators
ProductPrice price = new BasicProduct(laptop);
price = new DiscountDecorator(price, 10); // 10% off
price = new TaxDecorator(price, 8);        // 8% tax

// Process payment
Payment payment = PaymentFactory.createPayment("creditcard", "1234-5678");
payment.processPayment(price.getPrice());

// Calculate shipping
ShippingContext shipping = new ShippingContext();
shipping.setShippingStrategy(new ExpressShipping());
double cost = shipping.calculateCost(5.0, 100.0);

// Order notifications
Order order = new Order("ORD001");
Customer customer = new Customer("John", "john@email.com");
order.attach(customer);
order.updateStatus("Shipped");
```

## ✨ Key Features

- ✅ 6 Design Patterns implemented
- ✅ All SOLID principles applied
- ✅ 8 comprehensive test classes
- ✅ 30+ test methods covering success and failure scenarios
- ✅ Exception handling and edge cases tested
- ✅ Clean, maintainable, and extensible code

## 📚 Learning Outcomes

This project demonstrates:
1. How to apply design patterns in real-world scenarios
2. How to write testable, maintainable code
3. How to follow SOLID principles for better software design
4. How to write comprehensive JUnit tests with success/failure scenarios
5. How to handle exceptions and edge cases properly

## 🎓 Author Notes

This project is designed for educational purposes to demonstrate best practices in object-oriented design, design patterns, and test-driven development (TDD).

---
**License:** MIT  
**Language:** Java 8+  
**Testing Framework:** JUnit 5