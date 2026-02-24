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
[UC6: Addition of Two Length Units](https://github.com/Arif-Iqubal/QuantityMeasurementApp/tree/feature/UC6-Addition-Of-Two-Length-Units)
