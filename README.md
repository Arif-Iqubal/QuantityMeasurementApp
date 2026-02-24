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
[ Addition with Target Unit Specification](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC7-Addition-With-Target-Unit-Specification)
