package com.jsp.ojpms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.service.JobService;

@Controller
public class ViewJobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/viewjob")
	public String viewJobs(@RequestParam(required = false) String search, Model model) {

		List<Job> jobs;

		if (search != null && !search.trim().isEmpty()) {
			jobs = jobService.getSearchedJob(search);
		} else {
			jobs = jobService.getAllJobs();
		}

		model.addAttribute("jobs", jobs);

		return "viewjob";
	}
}