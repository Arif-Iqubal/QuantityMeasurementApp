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
[UC5: Unit-to-Unit Conversion](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC5-Unit-to-UnitConversion)
