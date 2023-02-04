package com.report.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.report.binding.Plan;
import com.report.binding.SearchRequest;

public interface PlanService {

	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<Plan> getPlans(SearchRequest request);
	public void exportExcel(HttpServletResponse response) throws Exception;
	public void exportPdf(HttpServletResponse response) throws Exception;
	
}
