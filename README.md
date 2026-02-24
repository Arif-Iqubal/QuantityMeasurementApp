# 🚀 Quantity Measurement Application  
## 📏 Test-Driven Development (TDD) | OOP | Clean Code | DRY Principle  

---

## 🧠 Project Overview

The **Quantity Measurement Application** is designed to validate equality, conversion, and arithmetic operations between different measurement units such as Feet, Inches, Yards, etc.

This project was implemented incrementally using:

- ✅ Test-Driven Development (TDD)
- ✅ Feature Branch Workflow
- ✅ Clean Code Practices
- ✅ DRY (Don't Repeat Yourself) Principle
- ✅ Proper Unit Conversion Strategy

---

# 🌳 Git Workflow

```

QuantityMeasurementApp
│
└── main
     │
     └── dev
          ├── feature/UC1-FeetEquality
          ├── feature/UC2-InchEquality
          ├── feature/UC3-GenericQuantityClassForDRYPrinciple
          ├── feature/UC4-ExtendedUnitSupport
          ├── feature/UC5-Unit-to-UnitConversion
          ├── feature/UC6-Addition-Of-Two-Length-Units
          ├── feature/UC7-Addition-With-Target-Unit-Specification
          ├── feature/UC8-Refactoring-Unit-Enum-To-Standalone
          ├── feature/UC9-Weight-Measurement
          ├── feature/UC10-Generic-Quantity-Class-with-Unit-Interface-For-Multi-Category-Support
          ├── feature/UC11-Volume-Measurement-Equality-Conversion-and-Addition
          ├── feature/UC12-Subtraction-and-Division-Operations-on-Quantity-Measurements
          ├── feature/UC13-Centralized-Arithmetic-Logic-to-Enforce-DRY-in-Quantity-Operations
          └── feature/UC14-Temperature-Measurement-with-Selective-Arithmetic-Support-and-Measurable-Refactoring

```

### UC1: Feet Measurement Equality
📅 (Date: 20-Feb-2026)

Implemented equality comparison for two feet measurement values using proper object-oriented design and Java equality contract principles.

<br>Covered:
- Designed `QuantityMeasurementApp` with an immutable inner `Feet` class
- Applied encapsulation using `private final double value`
- Overrode `equals()` method following reflexive, symmetric, transitive, consistent, and null-safe rules
- Used `Double.compare()` for precise floating-point comparison instead of `==`
- Implemented null checks and type safety using `getClass()`
- Wrote unit tests covering same value, different value, null comparison, and same reference scenarios

<br>Outcome:
- Strengthened understanding of object equality and value-based comparison
- Improved knowledge of immutability, null safety, and clean OOP design in Java

<br>🔗 Code Link:
[UC1: Feet Measurement Equality](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC1-FeetEquality)
