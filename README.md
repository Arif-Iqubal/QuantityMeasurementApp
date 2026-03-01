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
