# Reflection

## What I Learned

**Design Patterns:**
- Factory pattern creates objects easily
- Strategy pattern lets you swap implementations
- Decorator adds features without changing original class
- Adapter connects old code with new code
- Singleton ensures only one instance exists

**SOLID Principles:**
- Each class should do one thing (SRP)
- Can add new features without breaking old code (OCP)
- Interfaces make code flexible (DIP)
- Small interfaces are better than big ones (ISP)

**Key Insight:**
Design patterns make code easier to change and extend.

---

## What Was Challenging

**Understanding Decorator:**
- Hard to understand wrapping at first
- Why use `new TimestampNotification(new SMSNotification())`?
- Realized it adds features layer by layer

**Factory vs Strategy:**
- Confused between them initially
- Factory = creates objects
- Strategy = chooses behavior

**Singleton Implementation:**
- Private constructor was confusing
- Understood it prevents creating multiple instances

---

## What I Improved from Previous Tasks

**Better Design:**
- Task 1: Just used inheritance
- Task 2: Used design patterns for flexibility

**Understanding Interfaces:**
- Task 1: Basic interface usage
- Task 2: Multiple interfaces working together

**Code Organization:**
- Task 1: Simple class structure
- Task 2: Organized with patterns in mind

**SOLID Application:**
- Task 1: Basic OOP
- Task 2: Applied all SOLID principles

---

## Main Takeaway
Design patterns solve common problems in proven ways. They make code flexible and maintainable.