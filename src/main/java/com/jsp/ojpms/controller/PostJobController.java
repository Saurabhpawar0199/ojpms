package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostJobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/postjob")
	public String postJobPage() {
		return "post_job";
	}

	@PostMapping("/postjob")
	public String postJob(@RequestParam String title, @RequestParam String description, @RequestParam String location,
			@RequestParam Double salary, HttpSession session) {

		User recruiter = (User) session.getAttribute("user");

		Job job = new Job();
		job.setTitle(title);
		job.setDescription(description);
		job.setLocation(location);
		job.setSalary(salary);
		job.setRecuriter(recruiter);

		jobService.saveJob(job);

		return "redirect:/recruiterdashboard";
	}
}