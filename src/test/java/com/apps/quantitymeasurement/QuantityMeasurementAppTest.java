package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Unified Length system (UC3)
 */
public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length1.equals(length2),
                "Expected same feet values to be equal");
    }

    @Test
    public void testInchesEquality() {

        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(length1.equals(length2),
                "Expected same inches values to be equal");
    }

    @Test
    public void testFeetInchesComparison() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches),
                "Expected 1 foot to equal 12 inches");
    }

    @Test
    public void testFeetInequality() {

        Length feet = new Length(2.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertFalse(feet.equals(inches),
                "Expected 2 feet to NOT equal 12 inches");
    }

    @Test
    public void testInchesInequality() {

        Length inch1 = new Length(10.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertFalse(inch1.equals(inch2),
                "Expected 10 inches to NOT equal 12 inches");
    }

    @Test
    public void testCrossUnitInequality() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(10.0, Length.LengthUnit.INCHES);

        assertFalse(feet.equals(inches),
                "Expected 1 foot to NOT equal 10 inches");
    }

    @Test
    public void testMultipleFeetComparison() {

        Length feet = new Length(2.0, Length.LengthUnit.FEET);
        Length inches = new Length(24.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches),
                "Expected 2 feet to equal 24 inches");
    }
}
