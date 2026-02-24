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
[ UC4: Extended Unit Support](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC4-ExtendedUnitSupport)
