package com.report.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.report.binding.Plan;

public interface PlanRepository extends JpaRepository<Plan, Serializable> {

	@Query("select distinct(planName) from Plan")
	public List<String> getPlanNames();
	
	@Query("select distinct(planStatus) from Plan")
	public List<String> getPlanStatus();
}
