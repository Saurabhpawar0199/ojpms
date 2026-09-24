package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserDashboardController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/userdashboard")
	public String userDashboard(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		if (user == null) {
			return "redirect:/login";
		}

		int appliedJobs = applicationService.getApplicationCountByUser(user.getId());

		model.addAttribute("appliedJobs", appliedJobs);

		return "user_dashboard";
	}
}