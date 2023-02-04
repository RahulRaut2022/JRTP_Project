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
@Entity(name = "Education_Details")
public class EducationDetails {

	@Id
	@GeneratedValue
	private Integer educationId;
	private String highestDegree;
	private Integer graduationYear;
	private String universityName;
	private Integer caseNumber;
}
