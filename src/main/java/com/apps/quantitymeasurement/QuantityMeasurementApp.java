package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ===============================
    // UC5 – Equality (UNCHANGED)
    // ===============================
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {

        if (length1 == null || length2 == null)
            throw new IllegalArgumentException("Lengths cannot be null");

        return length1.equals(length2);
    }

    // ===============================
    // UC5 – Conversion (UNCHANGED)
    // ===============================
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        if (length == null)
            throw new IllegalArgumentException("Length cannot be null");

        return length.convertTo(toUnit);
    }

    // ==========================================================
    // UC6 – ADDITION (NEW METHOD)
    // ==========================================================
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        if (length1 == null || length2 == null)
            throw new IllegalArgumentException("Lengths cannot be null");

        return length1.add(length2);
    }

    // ===============================
    // MAIN DEMO
    // ===============================
    public static void main(String[] args) {

        Length l1 = new Length(3.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = demonstrateLengthAddition(l1, l2);

        System.out.println("Result: " + result); // 4.00 FEET
    }
}
