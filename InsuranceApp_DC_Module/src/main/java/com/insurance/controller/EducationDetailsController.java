package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entity.EducationDetails;
import com.insurance.serviceimpl.EducationDetailsServiceImpl;

@RestController
public class EducationDetailsController {

	@Autowired
	private EducationDetailsServiceImpl eServiceImpl;
	
	@PostMapping("/education")
	public ResponseEntity<String> saveEducationDetails(@RequestBody EducationDetails eDetails){
		String saveEducationDetails = eServiceImpl.saveEducationDetails(eDetails);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getEducation")
	public ResponseEntity<List<EducationDetails>> getEducationDetails(){
		List<EducationDetails> educationDetails = eServiceImpl.getEducationDetails();
		return new ResponseEntity(educationDetails, HttpStatus.OK);
	}
}
