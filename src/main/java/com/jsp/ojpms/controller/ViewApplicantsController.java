package com.jsp.ojpms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewApplicantsController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/viewapplicants")
	public String viewApplicants(HttpSession session, Model model) {

		User recruiter = (User) session.getAttribute("user");

		if (recruiter == null) {
			return "redirect:/login";
		}

		List<Application> applications = applicationService.getAllApplications();

		model.addAttribute("applications", applications);
		model.addAttribute("recruiterId", recruiter.getId());

		return "view_applicants";
	}
}