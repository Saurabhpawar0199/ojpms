package com.jsp.ojpms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageJobsController {

	@Autowired
	private JobService jobService;

	@GetMapping("/managejobs")
	public String manageJobs(HttpSession session, Model model) {

		User recruiter = (User) session.getAttribute("user");

		if (recruiter == null) {
			return "redirect:/login";
		}

		List<Job> jobs = jobService.getJobsByRecruiter(recruiter.getId());

		model.addAttribute("jobs", jobs);

		return "manage_jobs";
	}
}