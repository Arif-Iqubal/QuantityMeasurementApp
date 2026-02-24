package com.apps.quantitymeasurement;

/**
 * UC5 – Application demonstrating Length conversion and equality
 */
public class QuantityMeasurementApp {

    /**
     * Demonstrate equality check
     */
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    /**
     * Demonstrate comparison using values and units
     */
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        return l1.equals(l2);
    }

    /**
     * Demonstrate conversion
     */
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    /**
     * Overloaded conversion method
     */
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

        // 1 Foot = 12 Inches
        System.out.println("1 foot == 12 inches ? "
                + demonstrateLengthComparison(1.0,
                Length.LengthUnit.FEET,
                12.0,
                Length.LengthUnit.INCHES));

        // 1 Yard = 36 Inches
        System.out.println("1 yard == 36 inches ? "
                + demonstrateLengthComparison(1.0,
                Length.LengthUnit.YARDS,
                36.0,
                Length.LengthUnit.INCHES));

        // 100 cm ≈ 39.37 inches
        System.out.println("100 cm == 39.37 inches ? "
                + demonstrateLengthComparison(100.0,
                Length.LengthUnit.CENTIMETERS,
                39.37,
                Length.LengthUnit.INCHES));

        // Conversion Example
        Length converted = demonstrateLengthConversion(
                3.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        System.out.println("3 feet in inches = " + converted);
    }
}
