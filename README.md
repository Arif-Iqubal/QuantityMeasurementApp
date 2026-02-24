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
