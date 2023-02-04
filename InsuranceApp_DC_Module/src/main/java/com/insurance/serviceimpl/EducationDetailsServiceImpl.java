package com.insurance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.EducationDetails;
import com.insurance.repository.EducationDeatailsRepo;
import com.insurance.service.EducationDetailsService;

@Service
public class EducationDetailsServiceImpl implements EducationDetailsService {

	@Autowired
	private EducationDeatailsRepo eRepo;
	
	@Override
	public String saveEducationDetails(EducationDetails educationDetails) {
		eRepo.save(educationDetails);
		return "Your Details saved Successfully";
	}

	@Override
	public List<EducationDetails> getEducationDetails() {
		List<EducationDetails> educationDetails = eRepo.findAll();
		return educationDetails;
	}

}
