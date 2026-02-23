package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementAppUC3 – Unified Quantity Measurement System
 *
 * This class demonstrates length equality checks
 * using a unified Length class.
 */
public class QuantityMeasurementApp {

    // Generic equality method
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // Demonstrate Feet equality check
    public static void demonstrateFeetEquality() {

        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);

        boolean result = demonstrateLengthEquality(feet1, feet2);

        System.out.println("Feet Equality:");
        System.out.println("1 ft == 1 ft : " + result);
    }

    // Demonstrate Inches equality check
    public static void demonstrateInchesEquality() {

        Length inch1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(12.0, Length.LengthUnit.INCHES);

        boolean result = demonstrateLengthEquality(inch1, inch2);

        System.out.println("\nInches Equality:");
        System.out.println("12 in == 12 in : " + result);
    }

    // Demonstrate Feet and Inches comparison
    public static void demonstrateFeetInchesComparison() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        boolean result = demonstrateLengthEquality(feet, inches);

        System.out.println("\nFeet & Inches Comparison:");
        System.out.println("1 ft == 12 in : " + result);
    }

    // Main method
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}
