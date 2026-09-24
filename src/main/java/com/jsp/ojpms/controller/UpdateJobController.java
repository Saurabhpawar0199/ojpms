package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.service.JobService;

@Controller
public class UpdateJobController {

	@Autowired
	private JobService jobService;

	@PostMapping("/updatejob")
	public String updateJob(@RequestParam int id, @RequestParam String title, @RequestParam String description,
			@RequestParam String location, @RequestParam double salary) {

		Job job = jobService.getJobById(id);

		job.setTitle(title);
		job.setDescription(description);
		job.setLocation(location);
		job.setSalary(salary);

		jobService.updateJob(job);

		return "redirect:/managejobs";
	}
}