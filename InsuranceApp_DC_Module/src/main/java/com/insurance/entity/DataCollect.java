package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DataCollect {

	@Id
	@GeneratedValue
	private Integer caseNumber;
	private String plansName;
}
