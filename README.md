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
