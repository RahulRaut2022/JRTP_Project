package com.insurance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.IncomeDetails;
import com.insurance.repository.IncomeDetailsRepo;
import com.insurance.service.IncomeDetailsService;

@Service
public class IncomeDetailsServiceImpl implements IncomeDetailsService {

	@Autowired
	private IncomeDetailsRepo iRepo;
	
	@Override
	public String saveIncomeDetails(IncomeDetails incomeDetails) {

		iRepo.save(incomeDetails);
		return "Your Details saved successfully";
	}

	@Override
	public List<IncomeDetails> getIncomeDetails() {

		List<IncomeDetails> incomeDetails = iRepo.findAll();
		return incomeDetails;
	}

}
