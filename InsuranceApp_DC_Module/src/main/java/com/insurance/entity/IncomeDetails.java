package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Income_Details")
public class IncomeDetails {

	@Id
	@GeneratedValue
	private Integer incomeId;
	private Double monthlySal;
	private Double rentIncome;
	private Double propertyIncome;
	private Integer caseNumber;
}
