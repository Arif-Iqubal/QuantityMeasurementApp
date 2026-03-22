package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.entity.QuantityDTO;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementControllerTest {

	private QuantityMeasurementController controller;

	@BeforeEach
	public void setUp() {
		controller = new QuantityMeasurementController(null);
	}

	@Test
	public void testPerformComparison() {

		QuantityDTO q1 = new QuantityDTO(1.0, "FEET", "LengthUnit");
		QuantityDTO q2 = new QuantityDTO(12.0, "INCHES", "LengthUnit");

		boolean result = controller.performComparison(q1, q2);

		Assertions.assertTrue(result);
	}

	@Test
	public void testPerformAddition() {

		QuantityDTO q1 = new QuantityDTO(5.0, "FEET", "LengthUnit");
		QuantityDTO q2 = new QuantityDTO(5.0, "FEET", "LengthUnit");

		QuantityDTO result = controller.performAddition(q1, q2);

		Assertions.assertNotNull(result);
		Assertions.assertEquals(10.0, result.getValue(), 0.01);
	}

	@Test
	public void testPerformConversion() {

		QuantityDTO celsius = new QuantityDTO(0.0, "CELSIUS", "TemperatureUnit");
		QuantityDTO fahrenheit = new QuantityDTO(0.0, "FAHRENHEIT", "TemperatureUnit");

		QuantityDTO result = controller.performConversion(celsius, fahrenheit);

		Assertions.assertEquals(32.0, result.getValue(), 0.01);
	}
}