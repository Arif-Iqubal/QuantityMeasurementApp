package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QuantityMeasurementDatabaseRepositoryTest {

	private QuantityMeasurementDatabaseRepository repository;
	private QuantityMeasurementEntity testEntity;

	@BeforeEach
	public static void setUpDatabase() {
		System.setProperty("app.env", "test");
	}

	@BeforeAll
	public void setUp() {
		repository = QuantityMeasurementDatabaseRepository.getInstance();
		repository.deleteAll();
		createTestEntity();
	}

	@AfterAll
	public void tearDown() {
		repository.deleteAll();
	}

	@Test
	public void testSaveEntity() {
		repository.save(testEntity);

		List<QuantityMeasurementEntity> list = repository.getAllMeasurements();
		Assertions.assertEquals(1, list.size());
	}

	@Test
	public void testGetAllMeasurements() {
		repository.save(testEntity);
		repository.save(createTestEntityCopy(20));

		List<QuantityMeasurementEntity> list = repository.getAllMeasurements();

		Assertions.assertEquals(2, list.size());
	}

	@Test
	public void testGetMeasurementsByOperation() {
		repository.save(testEntity);

		List<QuantityMeasurementEntity> list = repository.getMeasurementsByOperation("Addition");

		Assertions.assertTrue(list.size() > 0);
	}

	@Test
	public void testGetMeasurementsByType() {
		repository.save(testEntity);

		List<QuantityMeasurementEntity> list = repository.getMeasurementsByType("Length");

		Assertions.assertTrue(list.size() > 0);
	}

	@Test
	public void testGetTotalCount() {
		repository.save(testEntity);
		repository.save(createTestEntityCopy(50));

		int count = repository.getTotalCount();

		Assertions.assertEquals(2, count);
	}

	@Test
	public void testDeleteAll() {
		repository.save(testEntity);

		repository.deleteAll();

		Assertions.assertEquals(0, repository.getTotalCount());
	}

	// ---------------- Helper Methods ----------------

	private void createTestEntity() {
		testEntity = new QuantityMeasurementEntity();

		testEntity.setThisValue(10);
		testEntity.setThisUnit("FEET");
		testEntity.setThisMeasurementType("Length");

		testEntity.setThatValue(5);
		testEntity.setThatUnit("FEET");
		testEntity.setThatMeasurementType("Length");

		testEntity.setOperation("Addition");

		testEntity.setResultValue(15);
		testEntity.setResultUnit("FEET");
		testEntity.setResultMeasurementType("Length");

		testEntity.setResultString("15 FEET");
		testEntity.setError(false);
		testEntity.setErrorMessage(null);
	}

	private QuantityMeasurementEntity createTestEntityCopy(double value) {

		QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

		entity.setThisValue(value);
		entity.setThisUnit("FEET");
		entity.setThisMeasurementType("Length");

		entity.setThatValue(5);
		entity.setThatUnit("FEET");
		entity.setThatMeasurementType("Length");

		entity.setOperation("Addition");

		entity.setResultValue(value + 5);
		entity.setResultUnit("FEET");
		entity.setResultMeasurementType("Length");

		entity.setResultString((value + 5) + " FEET");
		entity.setError(false);

		return entity;
	}
}