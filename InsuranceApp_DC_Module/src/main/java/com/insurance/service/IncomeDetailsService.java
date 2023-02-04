package com.insurance.service;

import java.util.List;

import com.insurance.entity.EducationDetails;
import com.insurance.entity.IncomeDetails;

public interface IncomeDetailsService {

	public String saveIncomeDetails(IncomeDetails incomeDetails);
	public List<IncomeDetails> getIncomeDetails();
}
