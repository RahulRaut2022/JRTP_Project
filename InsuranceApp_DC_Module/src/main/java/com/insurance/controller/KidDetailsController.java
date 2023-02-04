package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.serviceimpl.KidDetailsServiceImpl;

@RestController
public class KidDetailsController {

	@Autowired
	private KidDetailsServiceImpl kServiceImpl;
	
	
}
