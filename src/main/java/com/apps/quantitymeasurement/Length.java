package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // ===============================
    // ENUM (UNCHANGED FROM UC5)
    // ===============================
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

    // ===============================
    // CONSTRUCTOR (UNCHANGED)
    // ===============================
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // ===============================
    // UC5 BASE CONVERSION (UNCHANGED)
    // ===============================
    private double convertToBaseUnit() {
        double inches = this.value * this.unit.getConversionFactor();
        return Math.round(inches * 100.0) / 100.0;
    }

    // ===============================
    // UC5 BASE → TARGET (UNCHANGED)
    // ===============================
    private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
        double value = lengthInInches / targetUnit.getConversionFactor();
        return Math.round(value * 100.0) / 100.0;
    }

    // ===============================
    // UC5 EQUALITY (UNCHANGED)
    // ===============================
    private boolean compare(Length thatLength) {
        return this.convertToBaseUnit() == thatLength.convertToBaseUnit();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Length that = (Length) o;
        return compare(that);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    // ===============================
    // UC5 CONVERSION (UNCHANGED)
    // ===============================
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double inches = convertToBaseUnit();
        double convertedValue = convertFromBaseToTargetUnit(inches, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    // ==========================================================
    // UC6 – ADDITION (NEW METHOD – DOES NOT MODIFY OLD LOGIC)
    // ==========================================================
    public Length add(Length thatLength) {

        if (thatLength == null)
            throw new IllegalArgumentException("Length to add cannot be null");

        // Convert both to base unit (inches)
        double thisInches = this.convertToBaseUnit();
        double thatInches = thatLength.convertToBaseUnit();

        // Add
        double sumInches = thisInches + thatInches;

        // Convert back to THIS object's unit
        double resultValue =
                convertFromBaseToTargetUnit(sumInches, this.unit);

        return new Length(resultValue, this.unit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
