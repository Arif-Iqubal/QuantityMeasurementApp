package com.apps.quantitymeasurement.entity;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementEntityTest {

	private QuantityMeasurementEntity entity;

	@BeforeEach
	public void setUp() {
		entity = new QuantityMeasurementEntity();
	}

	@Test
	public void testSetAndGetValues() {

//		entity.setId(1L);
		entity.setThisValue(10.0);
		entity.setThisUnit("FEET");
		entity.setThisMeasurementType("Length");

//		Assertions.assertEquals(Long.valueOf(1L), entity.getId());
		Assertions.assertEquals(10.0, entity.getThisValue(), 0.01);
		Assertions.assertEquals("FEET", entity.getThisUnit());
		Assertions.assertEquals("Length", entity.getThisMeasurementType());
	}

	@Test
	public void testResultFields() {

		entity.setResultValue(20.0);
		entity.setResultUnit("FEET");
		entity.setResultString("20 FEET");

		Assertions.assertEquals(20.0, entity.getResultValue(), 0.01);
		Assertions.assertEquals("FEET", entity.getResultUnit());
		Assertions.assertEquals("20 FEET", entity.getResultString());
	}

	@Test
	public void testErrorHandling() {

		entity.setError(true);
		entity.setErrorMessage("Invalid conversion");

		Assertions.assertTrue(entity.isError());
		Assertions.assertEquals("Invalid conversion", entity.getErrorMessage());
	}
}