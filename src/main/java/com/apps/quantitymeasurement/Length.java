package com.apps.quantitymeasurement;

public class Length {
	private double value;
	private LengthUnit len;
	private static final double EPSILON = 0.01;
	
	
	
	public Length(double value, LengthUnit len) {
		if(Double.isNaN(value)) {
			throw new IllegalArgumentException("Invalid value!");
		}
		this.value = value;
		this.len = len;
	}
	
	public boolean compare(Length length) {
		return Math.abs(this.len.convertToBaseUnit(this.value) - length.len.convertToBaseUnit(length.value)) < EPSILON;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		
		return this.compare((Length)obj);
	}
	
	@Override
	public String toString() {
		return "Length [value=" + this.value + ", len=" + len + "]";
	}

	public Length convertTo(LengthUnit unit) {
		double result = (this.value*len.getConversionFactor())/unit.getConversionFactor();
		return new Length(result,unit);
	}
	
	public Length add(Length l1) {
		l1 = l1.convertTo(this.len);
		return new Length(this.value+l1.value,this.len);
	}
	
	public Length add(Length l1, LengthUnit unit) {
		Length length1 = addAndConvert(l1,unit);
		Length length2 = addAndConvert(this, len);
		return length1.add(length2);
	}
	
	private Length addAndConvert(Length length, LengthUnit targetUnit) {
		double baseValue = length.value*length.len.getConversionFactor();
		double convertToBase = convertFromBaseToTargetUnit(baseValue, targetUnit);
		return new Length(convertToBase,targetUnit);
	}
	
	private double convertFromBaseToTargetUnit(double inches, LengthUnit targetUnit) {
		return inches/targetUnit.getConversionFactor();
	}
	
	public static void main(String args[]) {
		Length len1 = new Length(1,LengthUnit.INCHES);
		Length len2 = new Length(1,LengthUnit.INCHES);
		System.out.println(len1.equals(len2));
		
		Length len3 = new Length(1.0,LengthUnit.YARD);
		Length len4 = new Length(36.0,LengthUnit.INCHES);
		System.out.println(len3.equals(len4));
		
		Length len5 = new Length(100.0,LengthUnit.CENTIMETERS);
		Length len6 = new Length(39.37,LengthUnit.INCHES);
		System.out.println(len5.equals(len6));
	}
}