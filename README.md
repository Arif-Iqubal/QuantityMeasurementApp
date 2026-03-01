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
