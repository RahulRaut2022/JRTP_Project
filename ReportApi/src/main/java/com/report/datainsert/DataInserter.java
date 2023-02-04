package com.report.datainsert;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.report.binding.Plan;
import com.report.repository.PlanRepository;

@Component
public class DataInserter implements ApplicationRunner {

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Plan p1 = new Plan();
		p1.setCname("john");
		p1.setGender("Male");
		p1.setPhno(745785220);
		p1.setPlanName("SNAP");
		p1.setPlanStatus("Approved");
		p1.setSsn(124578895);
		p1.setCemail("john@gmail.com");
		
		Plan p2 = new Plan();
		p2.setCname("Karan");
		p2.setGender("Male");
		p2.setPhno(795785530);
		p2.setPlanName("CCAP");
		p2.setPlanStatus("Approved");
		p2.setSsn(124578886);
		p2.setCemail("karan@gmail.com");
		
		Plan p3 = new Plan();
		p3.setCname("Suman");
		p3.setGender("Female");
		p3.setPhno(789785450);
		p3.setPlanName("SNAP");
		p3.setPlanStatus("Denied");
		p3.setSsn(124578878);
		p3.setCemail("suman@gmail.com");
		
		Plan p4 = new Plan();
		p4.setCname("kirti");
		p4.setGender("Female");
		p4.setPhno(798785450);
		p4.setPlanName("CCAP");
		p4.setPlanStatus("Approved");
		p4.setSsn(124578872);
		p4.setCemail("kirti@gmail.com");
		
		Plan p5 = new Plan();
		p5.setCname("Shiva");
		p5.setGender("Male");
		p5.setPhno(789778452);
		p5.setPlanName("CCAP");
		p5.setPlanStatus("Denied");
		p5.setSsn(124578874);
		p5.setCemail("shiva@gmail.com");
		
		List<Plan> list = Arrays.asList(p1,p2,p3,p4,p5);
		planRepository.saveAll(list);
	}

}
