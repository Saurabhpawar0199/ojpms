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
public class MyApplicationsController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/myapplications")
	public String myApplications(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		if (user == null) {
			return "redirect:/login";
		}

		List<Application> applications = applicationService.getApplicationsByUser(user.getId());

		model.addAttribute("applications", applications);

		return "my_applications";
	}
}