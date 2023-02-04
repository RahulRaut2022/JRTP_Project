package com.insurance.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.insurance.binding.Plan;
import com.insurance.binding.SearchRequest;

public interface PlanService {

	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<Plan> getPlans(SearchRequest request);
	public void exportExcel(HttpServletResponse response) throws Exception;
	public void exportPdf(HttpServletResponse response) throws Exception;
	
}
