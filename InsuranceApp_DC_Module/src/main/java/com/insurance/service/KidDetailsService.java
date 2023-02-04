package com.insurance.service;

import java.util.List;

import com.insurance.entity.IncomeDetails;
import com.insurance.entity.KidDetails;

public interface KidDetailsService {

	public String saveKidDetails(KidDetails kidDetails);
	public List<KidDetails> getEducationDetails();
}
