package com.apps.quantitymeasurement;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * UC5 – Length with full unit-to-unit conversion support.
 * Base unit: INCHES
 */
public class Length {

    private final double value;
    private final LengthUnit unit;

    /**
     * Supported Length Units with conversion factor relative to inches.
     */
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    /**
     * Convert this length to base unit (inches) and round to 2 decimal places.
     */
    private double convertToBaseUnit() {
        double inches = this.value * this.unit.getConversionFactor();
        return round(inches);
    }

    /**
     * Convert to target unit.
     */
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = convertToBaseUnit();
        double convertedValue = baseValue / targetUnit.getConversionFactor();

        return new Length(round(convertedValue), targetUnit);
    }

    /**
     * Compare two Length objects.
     */
    private boolean compare(Length that) {
        return Double.compare(this.convertToBaseUnit(),
                that.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;
        return compare(other);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    /**
     * Utility rounding method (2 decimal places)
     */
    private double round(double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
