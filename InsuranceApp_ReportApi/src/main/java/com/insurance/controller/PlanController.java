package com.insurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.binding.Plan;
import com.insurance.binding.SearchRequest;
import com.insurance.service.PlanService;

@RestController
public class PlanController {

	@Autowired
	private PlanService planService;

	@GetMapping("/plannames")
	public ResponseEntity<List<String>> getPlanNames() {
		List<String> planNames = planService.getPlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}

	@GetMapping("/planstatuses")
	public ResponseEntity<List<String>> getPlanStatuses() {
		List<String> planStatus = planService.getPlanStatuses();
		return new ResponseEntity<>(planStatus, HttpStatus.OK);
	}

	@PostMapping("/search")
	public ResponseEntity<List<Plan>> search(@RequestBody SearchRequest request) {
		List<Plan> plan = planService.getPlans(request);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}

	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");

		String key = "Content-Disposition";
		String value = "attachment;file=citizens.xls";

		response.setHeader(key, value);
		planService.exportExcel(response);
		response.flushBuffer();
	}

	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");

		String key = "Content-Disposition";
		String value = "attachment;plans.pdf";

		response.setHeader(key, value);
		planService.exportPdf(response);
		response.flushBuffer();
	}

}
