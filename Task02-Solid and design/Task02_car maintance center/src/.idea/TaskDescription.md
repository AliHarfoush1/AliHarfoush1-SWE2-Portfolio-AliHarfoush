# Task: Car Workshop System

## What I Built
Car workshop management system with design patterns.

## Design Patterns

**1. Factory** - Creates services
- `ServiceFactory.createService("oil")`

**2. Strategy** - Choose payment method
- Visa or Cash

**3. Decorator** - Add features to notifications
- Add timestamp to SMS

**4. Adapter** - Use old email system
- Connects old system to new one

**5. Singleton** - One workshop only
- `Workshop.getInstance()`

---

## SOLID Principles

**S - Single Responsibility**
- Each class does one thing
- `Car` = car data only
- `VisaPayment` = visa payment only

**O - Open/Closed**
- Add new services without changing old code
- Just create new class

**L - Liskov Substitution**
- Any payment method works the same way
- Can swap Visa with Cash easily

**I - Interface Segregation**
- Small focused interfaces
- `paymentservice` only has `pay()`

**D - Dependency Inversion**
- Workshop uses interfaces not concrete classes
- `Workshop` uses `paymentservice` not `VisaPayment`

---

## Main Classes
- **Car** - car info
- **Workshop** - does the service
- **RepairService** - service types
- **paymentservice** - payment methods
- **Notificationservice** - send messages