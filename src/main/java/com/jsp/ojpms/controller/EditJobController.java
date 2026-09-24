package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.service.JobService;

@Controller
public class EditJobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/editjob")
	public String editJob(@RequestParam int id, Model model) {

		Job job = jobService.getJobById(id);

		model.addAttribute("job", job);

		return "edit_job";
	}
}