package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UC5 – Length Conversion & Equality Test Suite
 */
public class QuantityMeasurementAppTest {

    // ===========================
    // SAME UNIT TESTS
    // ===========================

    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(l1, l2);
    }

    @Test
    public void testInchesEquality() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length l1 = new Length(2.0, Length.LengthUnit.FEET);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);
        assertNotEquals(l1, l2);
    }

    // ===========================
    // CROSS UNIT EQUALITY TESTS
    // ===========================

    @Test
    public void oneFootEqualsTwelveInches() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );
    }

    @Test
    public void threeFeetEqualsOneYard() {
        assertEquals(
                new Length(3.0, Length.LengthUnit.FEET),
                new Length(1.0, Length.LengthUnit.YARDS)
        );
    }

    @Test
    public void yardEquals36Inches() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(36.0, Length.LengthUnit.INCHES)
        );
    }

    @Test
    public void hundredCmEquals39Point37Inches() {
        assertEquals(
                new Length(100.0, Length.LengthUnit.CENTIMETERS),
                new Length(39.37, Length.LengthUnit.INCHES)
        );
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        assertEquals(
                new Length(30.48, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.FEET)
        );
    }

    // ===========================
    // INEQUALITY TESTS
    // ===========================

    @Test
    public void crossUnitInequality() {
        assertNotEquals(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(10.0, Length.LengthUnit.INCHES)
        );
    }

    @Test
    public void yardNotEqualTo35Inches() {
        assertNotEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(35.0, Length.LengthUnit.INCHES)
        );
    }

    // ===========================
    // EQUALS CONTRACT TESTS
    // ===========================

    @Test
    public void referenceEqualitySameObject() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(length, length);
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(length, null);
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);
        Length c = new Length(0.333333, Length.LengthUnit.YARDS); // 1 foot

        // Reflexive
        assertEquals(a, a);

        // Symmetric
        assertEquals(a, b);
        assertEquals(b, a);

        // Transitive
        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    // ===========================
    // CONVERSION METHOD TESTS
    // ===========================

    @Test
    public void convertFeetToInches() {
        Length result = new Length(3.0, Length.LengthUnit.FEET)
                .convertTo(Length.LengthUnit.INCHES);

        assertEquals(
                new Length(36.0, Length.LengthUnit.INCHES),
                result
        );
    }

    @Test
    public void convertYardsToInchesUsingAppMethod() {

        Length converted = QuantityMeasurementApp.demonstrateLengthConversion(
                2.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES
        );

        assertEquals(
                new Length(72.0, Length.LengthUnit.INCHES),
                converted
        );
    }

    @Test
    public void demonstrateLengthEqualityMethod() {

        assertTrue(
                QuantityMeasurementApp.demonstrateLengthEquality(
                        new Length(1.0, Length.LengthUnit.FEET),
                        new Length(12.0, Length.LengthUnit.INCHES)
                )
        );
    }
    
    @Test
    public void addFeetAndInches() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length sumLength =
            QuantityMeasurementApp.demonstrateLengthAddition(length1, length2);

        Length expectedLength = new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(
            QuantityMeasurementApp.demonstrateLengthEquality(sumLength, expectedLength)
        );
    }

}
