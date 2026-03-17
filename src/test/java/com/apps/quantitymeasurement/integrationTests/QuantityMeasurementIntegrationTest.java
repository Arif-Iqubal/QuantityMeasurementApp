package com.apps.quantitymeasurement.integrationTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apps.quantitymeasurement.QuantityMeasurementApp;
import com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.entity.QuantityDTO;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;


public class QuantityMeasurementIntegrationTest {

	private QuantityMeasurementApp app;
	private QuantityMeasurementController controller;
	private IQuantityMeasurementRepository repository;

	@BeforeEach
	public static void setUpTestEnvironment() {
		System.setProperty("app.env", "test");
	}

	@BeforeAll
	public void setUp() {
		app = QuantityMeasurementApp.getInstance();
		controller = app.getController();
		repository = app.getRepository();

//		repository.deleteAll();
	}

	@Test
	public void testEndToEndLengthComparison() {

		QuantityDTO q1 = new QuantityDTO(1.0, "FEET", "LengthUnit");
		QuantityDTO q2 = new QuantityDTO(12.0, "INCHES", "LengthUnit");

		boolean result = controller.performComparison(q1, q2);

		Assertions.assertNotNull(result);
		Assertions.assertTrue(result);
	}

	@Test
	public void testEndToEndTemperatureConversion() {

		QuantityDTO thisDto = new QuantityDTO(0.0, "CELSIUS", "TemperatureUnit");
		QuantityDTO thatDto = new QuantityDTO(0.0, "FAHRENHEIT", "TemperatureUnit");

		QuantityDTO resultDTO = controller.performConversion(thisDto, thatDto);

		Assertions.assertNotNull(resultDTO);
		Assertions.assertEquals(32.0, resultDTO.getValue(), 0.01);
	}

	@Test
	public void testRepositoryPersistence() {

		QuantityDTO q1 = new QuantityDTO(5.0, "FEET", "LengthUnit");
		QuantityDTO q2 = new QuantityDTO(5.0, "FEET", "LengthUnit");

		controller.performAddition(q1, q2);

		Assertions.assertTrue(repository.getAllMeasurements().size() > 0);
	}
}