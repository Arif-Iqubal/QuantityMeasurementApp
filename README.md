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
          ├── feature/UC14-Temperature-Measurement-with-Selective-Arithmetic-Support-and-Measurable-Refactoring
          ├── feature/UC15-N-Tier
          ├── feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence
          ├── feature/UC17-Spring-Backend-for-Quantity-Measurement
          └── feature/UC18-Google-Authnetication-and-User-Management-for-Quantity-Measurement


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



### UC13: Centralized Arithmetic Logic (DRY Enforcement)  
📅 Date: 26-Feb-2026  

Refactored arithmetic operations (`add`, `subtract`, `divide`) in the generic `Quantity<U extends IMeasurable>` class to eliminate duplication and fully enforce the **DRY principle**, without changing the public API or behavior.
---
### 🔍 Problem in UC12
- Repeated validation logic (null checks, category checks, finiteness)
- Repeated base-unit conversion logic
- Risk of inconsistent error handling
- Increased maintenance effort for future operations
---
### ✅ Refactoring Implemented
- Introduced **`ArithmeticOperation` enum** (`ADD`, `SUBTRACT`, `DIVIDE`) to encapsulate operation logic cleanly (via abstract method or lambda).
- Created centralized validation helper:
- - Public methods now:
- Validate inputs  
- Delegate to helper  
- Convert result if needed  
- Return final value  
---
### 🎯 Outcome
- ✅ No behavioral change (all UC12 tests pass unchanged)  
- ✅ Validation logic exists in one place  
- ✅ Conversion logic exists in one place  
- ✅ Shorter, cleaner public methods  
- ✅ Consistent error handling  
- ✅ Easy to add future operations (e.g., MULTIPLY)  
---
### 📐 SOLID & Design Validation
- SRP maintained  
- OCP improved (extend via enum constant)  
- DRY fully enforced  
- Scalable and maintainable internal structure  
---
🔗 Code Link:  
[UC13 : Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC13-Centralized-Arithmetic-Logic-to-Enforce-DRY-in-Quantity-Operations)



### UC14: Temperature with Selective Arithmetic Support  
📅 Date: 28-Feb-2026  

Added **Temperature (Celsius, Fahrenheit, Kelvin)** support and refactored `IMeasurable` to allow **optional arithmetic operations**, since temperature does not support meaningful add/divide operations.

---

### 🔍 Problem
Previous design assumed all measurement categories support full arithmetic.  
Temperature violates this assumption (e.g., 100°C + 50°C is not meaningful).

---

### ✅ What Was Done

- Refactored `IMeasurable` with **default methods** for optional arithmetic.
- Introduced `SupportsArithmetic` functional interface.
- Created `TemperatureUnit` enum with:
  - Proper non-linear conversion formulas  
  - Overridden `validateOperationSupport()`  
  - Arithmetic explicitly disabled (throws `UnsupportedOperationException`)
- Updated `Quantity<U>` to validate operation support before execution.

---

### 🎯 Outcome

- ✅ Temperature supports **equality & conversion**
- ❌ Arithmetic operations blocked with clear exceptions
- ✅ Length, Weight, Volume unchanged
- ✅ All previous UC tests pass
- ✅ ISP respected, backward compatibility maintained

---

### 📐 System Capability Snapshot

| Category     | Equality | Conversion | Arithmetic |
|-------------|----------|------------|------------|
| Length      | ✅        | ✅          | ✅          |
| Weight      | ✅        | ✅          | ✅          |
| Volume      | ✅        | ✅          | ✅          |
| Temperature | ✅        | ✅          | ❌          |

Architecture now supports categories with **different operational constraints** cleanly and safely.

🔗 Code Link:  
[UC14: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC14-Temperature-Measurement-with-Selective-Arithmetic-Support-and-Measurable-Refactoring)



### UC15: N-Tier Architecture Refactoring  
📅 Date: 12-Mar-2026  

Refactored the **Quantity Measurement Application** from a monolithic design into a **clean N-Tier architecture** to improve scalability, maintainability, and testability.

---

### 🔧 Layers Introduced

**Application Layer**
- `QuantityMeasurementApp`
- Entry point that initializes controller and service.

**Controller Layer**
- `QuantityMeasurementController`
- Handles requests and delegates operations to the service.

**Service Layer**
- `QuantityMeasurementServiceImpl`
- Contains core business logic for comparison, conversion, and arithmetic.

**Repository Layer**
- `IQuantityMeasurementRepository`
- `QuantityMeasurementCacheRepository` (Singleton) for storing operation history.

**Entity / Model Layer**
- `QuantityDTO` – data transfer between layers  
- `QuantityModel` – internal service representation  
- `QuantityMeasurementEntity` – stores operation details and results  

---

### 🎯 Outcome
- Clear **separation of concerns**
- Business logic reusable across **CLI, REST API, or GUI**
- Improved **testability and maintainability**
- Ready for **Dependency Injection and framework integration**
- All **UC1–UC14 functionality preserved**

---

### 🧠 Design Patterns Used
- **Singleton** – Repository  
- **Factory** – Service & controller creation  
- **Facade** – Controller simplifies service calls  
- **Dependency Injection** – Loose coupling between layers  

---

🔗 Code Link:  
[UC15: Source Code - ](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC15-N-Tier)




### UC16: JDBC Database Integration & Persistence  
📅 Date: 17-Mar-2026  

Enhanced the **Quantity Measurement Application** by integrating **JDBC-based database persistence** into the existing N-Tier architecture, replacing in-memory storage with a scalable and secure relational database solution.

---

### 🔧 Enhancements Introduced  

**Database Integration**
- Implemented `QuantityMeasurementDatabaseRepository` using JDBC  
- Supports CRUD operations with relational database  
- Enables persistent storage of measurement history  

**Configuration Layer**
- `ApplicationConfig` for loading database properties  
- `application.properties` for environment-based configuration  

**Connection Management**
- `ConnectionPool` for efficient database connection reuse  
- Handles max pool size, idle connections, and performance  

**Exception Handling**
- Introduced `DatabaseException` for DB-specific errors  
- Improved error propagation across layers  

**Repository Flexibility**
- Supports both:
  - `QuantityMeasurementCacheRepository` (in-memory)
  - `QuantityMeasurementDatabaseRepository` (database)
- Switching via configuration (Dependency Injection)

**Logging**
- Integrated **SLF4J + Logback**
- Replaced `System.out.println` with structured logging  

**Maven Integration**
- Standard project structure (`src/main`, `src/test`)  
- Added dependencies:
  - H2 Database  
  - MySQL/PostgreSQL (future use)  
  - JUnit & Mockito  
  - SLF4J  

---

### 🎯 Outcome  

- Persistent storage of measurement data  
- Support for **querying, filtering, and reporting**  
- Improved **scalability and performance**  
- Secure database operations using **PreparedStatement**  
- Efficient resource usage via **connection pooling**  
- Fully **backward compatible with UC15**  
- Ready for **enterprise-level backend (Spring Boot)**  

---

### 🧠 Design Patterns & Concepts Used  

- **Repository Pattern** – Abstracts database operations  
- **Dependency Injection** – Switch between cache and DB  
- **Factory Pattern** – Repository creation  
- **Singleton** – Connection pool management  
- **DAO Pattern (JDBC)** – Structured DB interaction  
- **Connection Pooling** – Performance optimization  

---

### 🗄️ Database Features  

- H2 in-memory database (development/testing)  
- Schema initialization using `schema.sql`  
- Parameterized queries (SQL Injection safe)  
- Transaction management for consistency  
- Query support:
  - Get all measurements  
  - Filter by operation/type  
  - Count records  
  - Delete all records  

---

### 🧪 Testing  

- Unit tests for:
  - Repository  
  - Service  
  - Controller  
- Integration tests with H2 database  
- Connection pool testing  
- SQL injection prevention testing  

---

### 🚀 Commands  

mvn clean compile      # Build project  
mvn exec:java          # Run application  
mvn clean test         # Execute tests  

---

### 🔄 Improvements Over UC15  

- In-memory → Database persistence  
- No query support → SQL-based querying  
- No concurrency → Connection pooling  
- No schema → Structured relational schema  
- Limited scalability → Enterprise-ready system  

---

### 🔗 Code Link  
[Source Code - UC16](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence)


## 🚀 UC17: Spring Boot REST API Integration

📅 Date: 24-Mar-2026  

Upgraded the **Quantity Measurement Application** to a **Spring Boot REST API**, replacing JDBC with **Spring Data JPA** for a scalable, enterprise-ready backend.

---

## 🔧 Key Enhancements

- **Spring Boot** – Auto-config + embedded server  
- **REST APIs** – `@RestController`, JSON support  
- **Spring Data JPA** – Replaced JDBC, auto CRUD & queries  
- **Service Layer** – `@Service` with DI  
- **DTO + Validation** – Clean API contracts  
- **Global Exception Handling** – `@ControllerAdvice`  
- **Swagger** – API documentation  
- **Actuator** – Health & metrics  

---

## 🎯 Outcome

- Scalable RESTful backend  
- Reduced boilerplate code  
- Improved maintainability  
- Production-ready architecture  

---

## 🧪 Testing

- `@WebMvcTest` (Controller)  
- `@SpringBootTest` (Integration)  
- Mockito for mocking  

---

## 🚀 Commands

```bash
mvn spring-boot:run
mvn clean test

```
### 🔗 Code Link

[Source Code - UC17](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC17-Spring-Backend-for-Quantity-Measurement/QuantityMeasurementApp)



### UC18: Google Authentication and User Management for Quantity Measurement  
📅 (Date: 29-Mar-2026)

Implemented secure user authentication and management in the Quantity Measurement Spring Boot application using **Spring Security with JWT and OAuth2 (Google Login)**.

---


<br>

##  🔧 Covered:

- Designed `User` entity with fields like username, email, password, and role  
- Implemented `UserController` for user registration and login using JWT  
- Created `GoogleAuthController` to handle Google OAuth2 login flow  
- Configured Spring Security using `SecurityConfig` for both JWT and OAuth2 authentication  
- Integrated Google OAuth2 login using `spring.security.oauth2.client.registration.google`  
- Generated JWT tokens using `JwtService` after successful authentication  
- Implemented `JwtFilter` to validate JWT in every request  
- Developed `CustomUserDetailsService` for loading user details from database  
- Created DTOs (`RegisterRequest`, `LoginRequest`, `AuthResponse`) for structured data handling  
- Applied password encryption using `BCryptPasswordEncoder`  
- Handled unauthorized access using `JwtAuthenticationEntryPoint` and custom exceptions  
- Maintained stateless session using JWT with Spring Security filters  
- Tested authentication flows using Swagger and Postman  

---

<br>

##  🎯Outcome:

- Successfully integrated **JWT-based authentication** with **Google OAuth2 login**  
- Achieved secure and scalable user management system  
- Gained deep understanding of Spring Security filter chain and authentication mechanisms  
- Enabled both traditional login and third-party login (Google) in a single application  
- Built a production-ready authentication system for REST APIs  

---

<br>🔗 Code Link:  
[UC18: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC18-Google-Authnetication-and-User-Management-for-Quantity-Measurement/QuantityMeasurementApp/src)




## ☁️ UC21 – Microservices Architecture
📅 (Date: 09-April-2026)

## 📏 TDD | Microservices | Clean Architecture | Scalable System

---

## 🧠 Project Overview

The **Quantity Measurement Application** is a production-ready system designed to handle:

* ✅ Unit comparison (Feet, Inches, Yards, etc.)
* ✅ Unit conversion
* ✅ Arithmetic operations on quantities

Built using modern engineering practices:

* 🧪 Test-Driven Development (TDD)
* 🧱 Microservices Architecture
* ♻️ DRY Principle
* 🧼 Clean Code Practices
* 🔐 Secure Authentication (JWT + Google Auth)


---

# ☁️ UC21 – Microservices Architecture
---

## 🎯 Objective

Refactor the monolithic system into a scalable **Microservices Architecture**:

* Independent services
* Separate deployments
* High scalability & maintainability

---

## 🧠 Tech Stack

| Layer            | Technology           |
| ---------------- | -------------------- |
| Backend          | Spring Boot          |
| Microservices    | Spring Cloud         |
| Service Registry | Eureka Server        |
| API Gateway      | Spring Cloud Gateway |
| Security         | JWT + Google OAuth   |
| Communication    | REST APIs            |

---

## 🏗️ System Architecture

```
                ┌──────────────────────┐
                │     API Gateway      │
                │       (8080)         │
                └─────────┬────────────┘
                          │
        ┌─────────────────┼─────────────────┐
        ▼                 ▼                 ▼
┌──────────────┐  ┌──────────────┐  ┌──────────────┐
│ Auth Service │  │ Quantity Svc │  │ Admin Service│
│   (8081)     │  │   (8082)     │  │   (8083)     │
└──────────────┘  └──────────────┘  └──────────────┘
                          │
                          ▼
                ┌──────────────────┐
                │ Eureka Server    │
                │     (8761)       │
                └──────────────────┘
```

---

## ⚙️ Services & Ports

| Service Name        | Artifact ID        | Port | Responsibility                       |
| ------------------- | ------------------ | ---- | ------------------------------------ |
| 🧭 Eureka Server    | `eureka-server`    | 8761 | Service Registry                     |
| 🚪 API Gateway      | `api-gateway`      | 8080 | Entry point, routing, JWT validation |
| 🔐 Auth Service     | `auth-service`     | 8081 | Login, JWT, Google Authentication    |
| 📏 Quantity Service | `quantity-service` | 8082 | Unit conversion & business logic     |
| 🛠 Admin Service    | `admin-service`    | 8083 | Monitoring & control                 |

---

## 🔄 Request Flow

### 🔐 Authentication Flow

```
Client → Login → Auth Service → JWT Token
```

### 📡 Authorized Request Flow

```
Client → Request (JWT)
        ↓
API Gateway (Validate Token)
        ↓
Route Request
        ↓
Quantity Service (Business Logic)
```

---

## ✅ Key Features

* 🔐 JWT + Google OAuth Authentication
* 🌐 Centralized API Gateway
* 🔍 Eureka Service Discovery
* 🔄 Loose Coupling with Microservices
* 📈 Scalable & Production-Ready
* 🧪 Fully TDD-driven development

---

## 🚀 How to Run

### 1️⃣ Start Services (Order Matters)

```bash
# 1. Eureka Server
cd eureka-server
mvn spring-boot:run

# 2. API Gateway
cd api-gateway
mvn spring-boot:run

# 3. Auth Service
cd auth-service
mvn spring-boot:run

# 4. Quantity Service
cd quantity-service
mvn spring-boot:run

# 5. Admin Service
cd admin-service
mvn spring-boot:run
```

---

## 🌐 Service URLs

| Service          | URL                   |
| ---------------- | --------------------- |
| Eureka Dashboard | http://localhost:8761 |
| API Gateway      | http://localhost:8080 |
| Auth Service     | http://localhost:8081 |
| Quantity Service | http://localhost:8082 |
| Admin Service    | http://localhost:8083 |

---


[UC21: Source Code](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC21-Microservices-Architecture-for-Quantity-Measurement)
