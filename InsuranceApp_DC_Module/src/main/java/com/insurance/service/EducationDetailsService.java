package com.insurance.service;

import java.util.List;

import com.insurance.entity.EducationDetails;

public interface EducationDetailsService {

	public String saveEducationDetails(EducationDetails educationDetails);
	public List<EducationDetails> getEducationDetails();
}
