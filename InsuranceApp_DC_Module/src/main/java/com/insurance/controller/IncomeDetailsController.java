package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entity.IncomeDetails;
import com.insurance.serviceimpl.IncomeDetailsServiceImpl;

@RestController
public class IncomeDetailsController {

	@Autowired
	private IncomeDetailsServiceImpl iServiceImpl;
	
	@PostMapping("/income")
	public ResponseEntity<String> saveIncomeDetails(@RequestBody IncomeDetails iDetails){
		String saveIncomeDetails = iServiceImpl.saveIncomeDetails(iDetails);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getIncome")
	public ResponseEntity<List<IncomeDetails>> getIncomeDetails(){
		
		List<IncomeDetails> incomeDetails = iServiceImpl.getIncomeDetails();
		
		return new ResponseEntity(incomeDetails, HttpStatus.OK);
	}
}
