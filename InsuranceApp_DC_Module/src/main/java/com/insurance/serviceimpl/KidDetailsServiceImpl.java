package com.insurance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.KidDetails;
import com.insurance.repository.KidDetailsRepo;
import com.insurance.service.KidDetailsService;

@Service
public class KidDetailsServiceImpl implements KidDetailsService {

	@Autowired
	private KidDetailsRepo kRepo;
	
	@Override
	public String saveKidDetails(KidDetails kidDetails) {
		kRepo.save(kidDetails);
		return "Your Details saved successfully";
		
	}

	@Override
	public List<KidDetails> getEducationDetails() {

		List<KidDetails> kidDetails = kRepo.findAll();
		return kidDetails;
	}

}
