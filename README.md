# Lab 05: Polymorphism

**Student Details:**
- **Name:** Anesu B Kahanda
- **Registration Number:** H250407A
- **Department:** Computer Science
- **Course:** Object-Oriented Programming in Java

---

## Overview
This laboratory explores polymorphism in Java:
1. **Compile-time polymorphism (Static / Overloading):** Methods sharing names but with distinct parameter signatures resolved by compiler.
2. **Run-time polymorphism (Dynamic / Overriding):** Dynamic method dispatch selecting method implementations based on the runtime object type.
3. Upcasting (treating child instances through parent references).
4. Safe downcasting using Java pattern matching for `instanceof`.
5. Non-polymorphic members (field hiding and static method hiding).
6. Practical implementation of the Open/Closed Principle.

---

## Files in this Directory

| File Name | Description |
|---|---|
| `Calculator.java` | Program 5.1: Compile-time method overloading (`add` for int, double, String). |
| `Shapes.java` | Program 5.2: Dynamic method dispatch across Circle, Rectangle, and Triangle hierarchies. |
| `CastingDemo.java` | Program 5.3: Upcasting, downcasting via `instanceof` pattern matching, and non-polymorphic fields/static methods. |
| `PrinterOverloadDemo.java` | Exercise 1: Overloaded `print` methods handling primitives, strings, and arrays. |
| `AnimalPolymorphismDemo.java` | Exercise 2: `Animal` base with Cat, Cow, and Duck polymorphic sounds in an array loop. |
| `PayrollInternDemo.java` | Exercise 3: Extends the corporate hierarchy with `Intern`, computing payroll without modifying existing loop logic. |
| `FieldVsMethodDemo.java` | Exercise 4: Demonstrates why field access is static (bound to reference) while method execution is dynamic (bound to instance). |
| `PaymentProcessingDemo.java` | Exercise 5: Compares `instanceof` conditional branching against polymorphic object delegation. |

---

## How to Compile and Run

To compile all files:
```bash
javac *.java
```

To run individual programs:
```bash
java Calculator
java Shapes
java CastingDemo
java PrinterOverloadDemo
java AnimalPolymorphismDemo
java PayrollInternDemo
java FieldVsMethodDemo
java PaymentProcessingDemo
```

---

## Expected Output Samples

### `Shapes.java`
```
Circle     area = 78.54
Rectangle  area = 24.00
Triangle   area = 12.00
Total area = 114.54
```

### `PaymentProcessingDemo.java`
```
--- 1. Testing instanceof Pattern Matching ---
[instanceof] Charging Card ************3456 for $150.00
[instanceof] Charging Mobile wallet +263771234567 for $45.00

--- 2. Testing Polymorphic Dispatch ---
Processed Card payment of $150.00 (Card ending in 3456)
Processed EcoCash mobile payment of $45.00 via +263771234567
```
