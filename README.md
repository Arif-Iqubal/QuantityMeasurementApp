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


### UC2: Feet and Inches Measurement Equality
📅 (Date: 21-Feb-2026)

Extended UC1 to support equality comparison for both Feet and Inches measurements while treating them as separate entities.

<br>Covered:
- Implemented a separate `Inches` class similar to the `Feet` class
- Compared inch-to-inch and feet-to-feet values independently
- Created static methods to reduce dependency on the main method
- Applied encapsulation using `private final double value` in both classes
- Overrode `equals()` method in both classes following Java Equality Contract
- Used `Double.compare()` for accurate floating-point comparison
- Ensured null checking and strict type safety using `getClass()`
- Wrote unit tests covering same value, different value, null comparison, non-numeric input, and same reference scenarios

<br>Outcome:
- Strengthened understanding of value-based equality across multiple unit types
- Practiced reusable equality logic with proper OOP principles
- Identified DRY principle violation due to duplicate logic in Feet and Inches classes
- Understood the need for a better design using a common `Quantity` class or unit parameterization

<br>🔗 Code Link:
[UC2: Feet and Inches Measurement Equality](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC2-InchEquality)


### UC3: Generic Quantity Class (DRY Principle Implementation)
📅 (Date: 23-Feb-2026)

Refactored separate `Feet` and `Inches` classes into a single generic `QuantityLength` class using an enum-based unit system to eliminate code duplication and follow the DRY principle.

<br>Covered:
- Created `LengthUnit` enum with conversion factors relative to a base unit (feet)
- Implemented a single `QuantityLength` class containing value + unit
- Centralized unit conversion logic before equality comparison
- Overrode `equals()` to support cross-unit equality (1 ft == 12 inches)
- Ensured type safety and null safety in comparison logic
- Preserved all UC1 and UC2 functionality without breaking existing tests
- Eliminated duplicate constructor and equals() logic from previous classes

<br>Outcome:
- Successfully applied DRY (Don’t Repeat Yourself) principle
- Improved scalability by enabling easy addition of new units
- Strengthened understanding of enums, abstraction, encapsulation, and polymorphism
- Implemented value-based equality with cross-unit comparison support
- Improved maintainability and reduced risk of inconsistent logic

<br>🔗 Code Link:
[ UC3: Generic Quantity Class](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC3-GenericQuantityClassForDRYPrinciple)
