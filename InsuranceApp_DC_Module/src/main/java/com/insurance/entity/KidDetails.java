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
@Entity(name = "Kid_Details")
public class KidDetails {

	@Id
	@GeneratedValue
	private Integer kidId;
	private String kidName;
	private Integer kidAge;
	private Long ssn;
	private Integer caseNumber;
}
