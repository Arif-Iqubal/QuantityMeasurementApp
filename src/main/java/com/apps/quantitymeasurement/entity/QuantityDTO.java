
package com.apps.quantitymeasurement.entity;

interface IMeasurableUnit {
	public String getUnitName();

	public String getMeasurementType();
}

public class QuantityDTO {
	// Length Unit enum
	enum LengthUnit implements IMeasurableUnit {
		FEET, INCHES, YARDS, CENTIMETERS;

		@Override
		public String getUnitName() {
			return this.name();
		}

		@Override
		public String getMeasurementType() {
			return this.getClass().getSimpleName().replace("Unit", "");
		}
	}

	// Volume unit enum
	enum VolumeUnit implements IMeasurableUnit {
		LITRE, MILLILITRE, GALLON;

		@Override
		public String getUnitName() {
			return this.name();
		}

		@Override
		public String getMeasurementType() {
			return this.getClass().getSimpleName().replace("Unit", "");
		}
	}

	// Weight unit enum
	enum WeightUnit implements IMeasurableUnit {
		KILOGRAM, GRAM, POUND;

		@Override
		public String getUnitName() {
			return this.name();
		}

		@Override
		public String getMeasurementType() {
			return this.getClass().getSimpleName().replace("Unit", "");
		}
	}

	// Temperature unit enum
	enum TemperatureUnit implements IMeasurableUnit {
		CELSIUS, FAHRENHEIT, KELVIN;

		@Override
		public String getUnitName() {
			return this.name();
		}

		@Override
		public String getMeasurementType() {
			return this.getClass().getSimpleName().replace("Unit", "");
		}
	}

	public double value;
	public String unit;
	public String measurementType;

	// Parameterized constructor
	public QuantityDTO(double value, IMeasurableUnit unit) {
		this.value = value;
		this.unit = unit.getUnitName();
		this.measurementType = unit.getMeasurementType();
	}

	// Parameterized constructor
	public QuantityDTO(double value, String unit, String measurementType) {
		this.value = value;
		this.unit = unit;
		this.measurementType = measurementType;
	}

	// Getter method to get value
	public double getValue() {
		return value;
	}

	// Getter method to get unit
	public String getUnit() {
		return unit;
	}

	// Getter method to get measurement type
	public String getMeasurementType() {
		return measurementType;
	}

	@Override
	public String toString() {
		return "QuantityDTO [value=" + value + ", unit=" + unit + ", measurementType=" + getMeasurementType() + "]";
	}

	public static void main(String[] args) {

		QuantityDTO length = new QuantityDTO(10, LengthUnit.FEET);
		QuantityDTO volume = new QuantityDTO(5, VolumeUnit.LITRE);
		QuantityDTO weight = new QuantityDTO(2, WeightUnit.KILOGRAM);
		QuantityDTO temperature = new QuantityDTO(37, TemperatureUnit.CELSIUS);

		System.out.println(length);
		System.out.println(volume);
		System.out.println(weight);
		System.out.println(temperature);
	}
}
