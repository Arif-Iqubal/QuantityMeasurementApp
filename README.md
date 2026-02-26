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
[UC1: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC1-FeetEquality)


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
[UC2: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC2-InchEquality)


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
[ UC3: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC3-GenericQuantityClassForDRYPrinciple)



### UC4: Extended Unit Support (Yards & Centimeters)
📅 (Date: 24-Feb-2026)

Extended the generic `QuantityLength` class to support YARDS and CENTIMETERS, proving the scalability of the DRY-based enum design introduced in UC3.

<br>Covered:
- Added `YARDS` (1 yard = 3 feet) to the `LengthUnit` enum
- Added `CENTIMETERS` (1 cm = 0.393701 inches) to the `LengthUnit` enum
- Verified that no changes were required in `QuantityLength` class due to generic design
- Ensured seamless cross-unit comparisons (yard-to-feet, yard-to-inches, cm-to-inch, etc.)
- Maintained centralized conversion logic inside enum
- Preserved all UC1, UC2, and UC3 functionality without modification
- Implemented comprehensive test coverage for multi-unit and transitive comparisons

<br>Outcome:
- Demonstrated scalability of enum-based generic design
- Validated DRY principle by adding new units without duplicating code
- Strengthened understanding of conversion factor management and precision handling
- Ensured mathematical accuracy in cross-unit equality comparisons
- Maintained backward compatibility with all previous test cases

<br>🔗 Code Link:
[ UC4: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC4-ExtendedUnitSupport)



### UC5: Unit-to-Unit Conversion (Same Measurement Type)
📅 (Date: 24-Feb-2026)

Enhanced the `QuantityLength` API to support explicit unit-to-unit conversion (e.g., feet → inches, yards → feet, centimeters → inches) using centralized enum-based conversion factors.

<br>Covered:
- Implemented public static API: `convert(double value, LengthUnit source, LengthUnit target)`
- Normalized all conversions through a common base unit for mathematical consistency
- Validated inputs using `Double.isFinite()` and null checks for units
- Ensured precision handling with epsilon tolerance for floating-point comparison
- Demonstrated method overloading with `demonstrateLengthConversion(...)`
- Overrode `equals()` and `toString()` for value-based equality and readability
- Maintained immutability and value-object semantics (conversion returns new instance)
- Preserved backward compatibility with UC1–UC4

<br>Outcome:
- Implemented scalable and reusable conversion API
- Strengthened understanding of enum-based design and centralized conversion logic
- Applied DRY principle and abstraction for clean API design
- Improved mathematical accuracy and floating-point precision handling
- Enhanced usability with overloaded methods and clear documentation

<br>🔗 Code Link:
[UC5: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC5-Unit-to-UnitConversion)


### UC6: Addition of Two Length Units (Same Category)
📅 (Date: 24-Feb-2026)

Extended the `QuantityLength` API to support addition of two length measurements (same category) with automatic unit conversion and result returned in the unit of the first operand.

<br>Covered:
- Implemented `add()` method supporting cross-unit addition (feet, inches, yards, centimeters)
- Normalized both operands to a common base unit before performing arithmetic
- Converted the sum back to the unit of the first operand
- Ensured immutability by returning a new `QuantityLength` object
- Added overloaded `add()` methods for flexibility (object-based and raw values)
- Applied strict validation for null operands, invalid units, and non-finite values
- Verified commutative property and identity element (zero addition)
- Maintained precision using epsilon-based floating-point handling

<br>Outcome:
- Enabled domain-level arithmetic operations on value objects
- Reused conversion infrastructure from UC5 (high reusability & DRY compliance)
- Preserved mathematical properties (commutativity, identity)
- Strengthened understanding of immutability and functional-style design
- Ensured backward compatibility with UC1–UC5

<br>🔗 Code Link:
[UC6: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC6-Addition-Of-Two-Length-Units)


### UC7: Addition with Target Unit Specification
📅 (Date: 24-Feb-2026)

Enhanced the `QuantityLength` API to support addition with an explicitly specified target unit, allowing the result to be expressed in any supported length unit.

<br>Covered:
- Implemented overloaded `add(length1, length2, targetUnit)` method
- Allowed explicit control over the result unit (FEET, INCHES, YARDS, CENTIMETERS)
- Reused base-unit normalization logic for consistent arithmetic
- Added strict validation for null operands, null target unit, and non-finite values
- Ensured immutability by returning a new `QuantityLength` object
- Preserved backward compatibility with UC6 implicit-target addition
- Maintained commutativity across all target units
- Centralized conversion logic to avoid DRY principle violation

<br>Outcome:
- Provided flexible and expressive API for unit-based arithmetic
- Improved clarity by making caller intent explicit through target unit parameter
- Strengthened abstraction and reusability of conversion infrastructure
- Ensured mathematical correctness across varying unit scales
- Maintained thread-safety and immutability of value objects

<br>🔗 Code Link:
[ UC7 : Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC7-Addition-With-Target-Unit-Specification)



### UC8: Refactoring Unit Enum to Standalone with Conversion Responsibility
📅 (Date: 24-Feb-2026)

Refactored `LengthUnit` from a nested enum inside `QuantityLength` to a standalone top-level enum and delegated all conversion responsibilities to it, improving scalability and adhering to SOLID principles.

<br>Covered:
- Extracted `LengthUnit` as a standalone enum class (FEET, INCHES, YARDS, CENTIMETERS)
- Implemented `convertToBaseUnit()` and `convertFromBaseUnit()` inside `LengthUnit`
- Removed internal conversion logic from `QuantityLength`
- Delegated all conversion, equality, and arithmetic operations to unit methods
- Eliminated circular dependency risk for future measurement categories
- Preserved all UC1–UC7 functionality without modifying client code
- Ensured strict validation for null units and invalid values
- Verified backward compatibility by running all previous test cases

<br>Outcome:
- Achieved Single Responsibility Principle (SRP) compliance
- Improved separation of concerns and reduced coupling
- Centralized conversion logic for better cohesion
- Established scalable architecture for future categories (WeightUnit, VolumeUnit, etc.)
- Maintained immutability, type safety, and mathematical correctness
- Successfully refactored without breaking existing APIs or test suites

<br>🔗 Code Link:
[UC8: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC8-Refactoring-Unit-Enum-To-Standalone)



### UC9: Weight Measurement Equality, Conversion, and Addition (Kilogram, Gram, Pound)
📅 (Date: 24-Feb-2026)

Extended the Quantity Measurement Application to support a new measurement category: **Weight**, implementing equality, conversion, and addition operations for Kilogram, Gram, and Pound units.

<br>Covered:
- Created standalone `WeightUnit` enum (KILOGRAM, GRAM, POUND) with base unit normalization (kilogram)
- Implemented `QuantityWeight` class mirroring `QuantityLength` design
- Added equality comparison using base unit (kg) normalization with epsilon tolerance
- Implemented `convertTo()` method supporting all weight unit pairs
- Added overloaded `add()` methods (implicit and explicit target unit support)
- Ensured strict category type safety (weight ≠ length)
- Overrode `equals()`, `hashCode()`, and `toString()` for value-object correctness
- Preserved immutability (all operations return new instances)
- Maintained backward compatibility with UC1–UC8

<br>Outcome:
- Successfully scaled architecture to multiple measurement categories
- Validated reusable design pattern across Length and Weight
- Ensured mathematical correctness in cross-unit weight operations
- Strengthened understanding of enum-based conversion responsibility
- Achieved strong separation of concerns and category isolation
- Confirmed architectural readiness for future categories (Volume, Temperature, etc.)

<br>🔗 Code Link:
[UC9: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC9-Weight-Measurement)



### UC10: Generic Quantity Class with Unit Interface (Multi-Category Support)
📅 (Date: 25-Feb-2026)

Refactored the architecture to introduce a single generic `Quantity<U extends IMeasurable>` class, eliminating duplication across category-specific classes and enabling scalable multi-category measurement support.

<br>Covered:
- Created `IMeasurable` interface defining unit conversion contract
- Refactored `LengthUnit` and `WeightUnit` to implement `IMeasurable`
- Replaced `QuantityLength` and `QuantityWeight` with generic `Quantity<U>`
- Implemented type-safe equality, conversion, and addition using bounded generics
- Prevented cross-category comparisons using compile-time and runtime checks
- Simplified `QuantityMeasurementApp` with unified generic demonstration methods
- Preserved all UC1–UC9 functionality without modifying existing tests
- Ensured immutability, hashCode consistency, and DRY compliance

<br>Outcome:
- Eliminated exponential code duplication across categories
- Achieved full adherence to SRP, DRY, OCP, and LSP principles
- Established scalable architecture for future categories (Volume, Temperature, Time, etc.)
- Reduced maintenance burden with single source of truth for operations
- Strengthened type safety through generics and interface-based design
- Validated performance neutrality with no runtime overhead from generics

<br>🔗 Code Link:
[ UC10: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC10-Generic-Quantity-Class-with-Unit-Interface-For-Multi-Category-Support)



### UC11: Volume Measurement Equality, Conversion, and Addition (Litre, Millilitre, Gallon)
📅 (Date: 25-Feb-2026)

Extended the generic `Quantity<U extends IMeasurable>` architecture to support a third measurement category: **Volume**, without modifying any existing core classes.

<br>Covered:
- Created standalone `VolumeUnit` enum (LITRE, MILLILITRE, GALLON) implementing `IMeasurable`
- Defined base unit normalization using LITRE as the base unit
- Implemented accurate conversion factors (1 L = 1000 mL, 1 gal ≈ 3.78541 L)
- Verified equality comparison across units (L ↔ mL ↔ gallon)
- Validated conversion operations using generic `convertTo()` method
- Tested addition (implicit and explicit target unit) using generic `add()` methods
- Ensured cross-category safety (Volume ≠ Length ≠ Weight)
- Preserved immutability and epsilon-based floating-point tolerance
- Confirmed zero changes required in `Quantity<U>`, `IMeasurable`, or app structure

<br>Outcome:
- Proved UC10 generic design scales seamlessly to new categories
- Demonstrated true DRY compliance across three independent domains
- Validated architectural scalability without exponential code growth
- Maintained strict type safety using generics and runtime unit checks
- Ensured mathematical accuracy across all volume operations
- Established repeatable pattern for adding future categories (Temperature, Time, etc.)

<br>🔗 Code Link:
[UC11: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC11-Volume-Measurement-Equality-Conversion-and-Addition)


### UC12: Subtraction and Division Operations on Quantity Measurements
📅 (Date: 26-Feb-2026)

Extended the generic `Quantity<U extends IMeasurable>` architecture to support **Subtraction** and **Division** across all measurement categories (Length, Weight, Volume).

<br>Covered:
- Implemented overloaded `subtract()` methods  
  - Implicit target unit (first operand’s unit)  
  - Explicit target unit specification  
- Implemented `divide()` method returning a dimensionless scalar (double)  
- Enabled cross-unit arithmetic (e.g., feet − inches, kg − grams, litre − mL)  
- Normalized operands through base unit before arithmetic  
- Added strict validation (null checks, finiteness, cross-category prevention)  
- Prevented division by zero (throws `ArithmeticException`)  
- Preserved immutability (operations return new objects)  
- Maintained rounding consistency (2 decimal places for Quantity results)  
- Verified non-commutativity of subtraction and division  
- Ensured compatibility with addition, equality, and conversion  

<br>Outcome:
- Quantity system now supports full arithmetic set: **add, subtract, divide**
- Generic design required **no structural refactoring**
- Architecture scales seamlessly across Length, Weight, and Volume
- SOLID principles maintained (SRP, OCP, DRY intact)
- Cross-category operations safely rejected at compile-time + runtime
- Demonstrated mathematical correctness (identity, inverse, non-commutativity)
- Confirmed immutability and functional-style operations
- Strengthened validation and fail-fast error handling

<br>🔎 SOLID / Design Validation:
- ✅ SRP maintained (Quantity handles arithmetic only)
- ✅ OCP maintained (new operations added without modifying enums)
- ✅ DRY preserved (shared base-unit normalization logic reused)
- ⚠️ Minor Improvement Area: If arithmetic logic grows further, extract shared private helper for base-unit arithmetic to avoid future duplication.

<br>🔗 Code Link:
[UC12 : Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC12-Subtraction-and-Division-Operations-on-Quantity-Measurements)
