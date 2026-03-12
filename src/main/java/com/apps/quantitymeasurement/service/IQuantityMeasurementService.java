
package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.entity.QuantityDTO;

public interface IQuantityMeasurementService {

	// Compare service
	public boolean compare(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);

	// Convert service
	public QuantityDTO convert(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);

	// Addition service
	public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);

	// Addition with target result service
	public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO);

	// Subtraction service
	public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);

	// Subtraction with target result service
	public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO);

	// Division service
	public QuantityDTO divide(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
}
