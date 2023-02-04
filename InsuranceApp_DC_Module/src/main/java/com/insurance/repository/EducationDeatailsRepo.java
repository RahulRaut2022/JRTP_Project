package com.insurance.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.EducationDetails;

public interface EducationDeatailsRepo extends JpaRepository<EducationDetails, Serializable> {
	
}
