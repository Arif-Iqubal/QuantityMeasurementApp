package com.app.quantitymeasurementapp.entity;

import java.util.ArrayList;
import java.util.List;

import com.app.quantitymeasurementapp.model.QuantityMeasurementEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantityMeasurementDTO {
	public double thisValue;
	public String thisUnit;
	public String thisMeasurementType;
	public double thatValue;
	public String thatUnit;
	public String thatMeasurementType;
	public String operation;
	public double resultValue;
	public String resultUnit;
	public String resultString;
	public String resultMeasurementType;
	@JsonProperty("error")
	public boolean error;
	public String errorMessage;

	public QuantityMeasurementDTO(double thisValue, String thisUnit, String thisMeasurementType, double thatValue,
			String thatUnit, String thatMeasurementType, String operation, double resultValue, String resultUnit,
			String resultString, String resultMeasurementType, boolean error, String errorMessage) {
		super();
		this.thisValue = thisValue;
		this.thisUnit = thisUnit;
		this.thisMeasurementType = thisMeasurementType;
		this.thatValue = thatValue;
		this.thatUnit = thatUnit;
		this.thatMeasurementType = thatMeasurementType;
		this.operation = operation;
		this.resultValue = resultValue;
		this.resultUnit = resultUnit;
		this.resultString = resultString;
		this.resultMeasurementType = resultMeasurementType;
		this.error = error;
		this.errorMessage = errorMessage;
	}

	public QuantityMeasurementDTO() {
	}

	public QuantityMeasurementDTO from(QuantityMeasurementEntity entity) {
		return new QuantityMeasurementDTO(entity.getThisValue(), entity.getThisUnit(), entity.getThisMeasurementType(),
				entity.getThatValue(), entity.getThatUnit(), entity.getThatMeasurementType(), entity.getOperation(),
				entity.getResultValue(), entity.getResultUnit(), entity.getResultString(),
				entity.getResultMeasurementType(), entity.isError(), entity.getErrorMessage());
	}

	public QuantityMeasurementEntity toEntity() {
		if (error) {
			return new QuantityMeasurementEntity(thisValue, thisUnit, thisMeasurementType, thatValue, thatUnit,
					thatMeasurementType, operation, errorMessage, error);
		}
		return new QuantityMeasurementEntity(thisValue, thisUnit, thisMeasurementType, thatValue, thatUnit,
				thatMeasurementType, operation, resultValue, resultUnit, resultMeasurementType, resultString, error,
				errorMessage);
	}

	public List<QuantityMeasurementDTO> fromList(List<QuantityMeasurementEntity> list) {
		List<QuantityMeasurementDTO> compute = new ArrayList<>();
		for (QuantityMeasurementEntity entity : list) {
			compute.add(from(entity));
		}
		return compute;
	}

	public List<QuantityMeasurementEntity> toEntityList(List<QuantityMeasurementDTO> list) {
		List<QuantityMeasurementEntity> compute = new ArrayList<>();
		for (QuantityMeasurementDTO entity : list) {
			compute.add(entity.toEntity());
		}
		return compute;
	}

	public double getThisValue() {
		return thisValue;
	}

	public void setThisValue(double thisValue) {
		this.thisValue = thisValue;
	}

	public String getThisUnit() {
		return thisUnit;
	}

	public void setThisUnit(String thisUnit) {
		this.thisUnit = thisUnit;
	}

	public String getThisMeasurementType() {
		return thisMeasurementType;
	}

	public void setThisMeasurementType(String thisMeasurementType) {
		this.thisMeasurementType = thisMeasurementType;
	}

	public double getThatValue() {
		return thatValue;
	}

	public void setThatValue(double thatValue) {
		this.thatValue = thatValue;
	}

	public String getThatUnit() {
		return thatUnit;
	}

	public void setThatUnit(String thatUnit) {
		this.thatUnit = thatUnit;
	}

	public String getThatMeasurementType() {
		return thatMeasurementType;
	}

	public void setThatMeasurementType(String thatMeasurementType) {
		this.thatMeasurementType = thatMeasurementType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getResultValue() {
		return resultValue;
	}

	public void setResultValue(double resultValue) {
		this.resultValue = resultValue;
	}

	public String getResultUnit() {
		return resultUnit;
	}

	public void setResultUnit(String resultUnit) {
		this.resultUnit = resultUnit;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public String getResultMeasurementType() {
		return resultMeasurementType;
	}

	public void setResultMeasurementType(String resultMeasurementType) {
		this.resultMeasurementType = resultMeasurementType;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}