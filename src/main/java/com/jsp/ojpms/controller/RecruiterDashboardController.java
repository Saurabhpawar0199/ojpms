package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.ApplicationService;
import com.jsp.ojpms.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RecruiterDashboardController {

	@Autowired
	private JobService jobService;

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/recruiterdashboard")
	public String recruiterDashboard(HttpSession session, Model model) {

		User recruiter = (User) session.getAttribute("user");

		if (recruiter == null) {
			return "redirect:/login";
		}

		int jobCount = jobService.getJobCountByRecruiter(recruiter.getId());

		int applicationCount = applicationService.getApplicationCountForRecruiter(recruiter.getId());

		model.addAttribute("jobCount", jobCount);
		model.addAttribute("applicationCount", applicationCount);

		return "recruiter_dashboard";
	}
}