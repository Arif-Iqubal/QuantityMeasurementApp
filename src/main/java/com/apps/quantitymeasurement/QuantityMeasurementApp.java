package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementAppUC4 – Extended Unit Support
 */
public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        boolean result = length1.equals(length2);

        System.out.println(value1 + " " + unit1 +
                " == " + value2 + " " + unit2 +
                " ? " + result);

        return result;
    }

    public static void main(String[] args) {

        // Feet & Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                                    12.0, Length.LengthUnit.INCHES);

        // Yards & Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                    36.0, Length.LengthUnit.INCHES);

        // Centimeters & Inches
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                                    39.37, Length.LengthUnit.INCHES);

        // Feet & Yards
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                                    1.0, Length.LengthUnit.YARDS);

        // Centimeters & Feet
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                                    1.0, Length.LengthUnit.FEET);
    }
}
