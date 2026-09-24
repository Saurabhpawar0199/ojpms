package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {

		User user = userService.loginUser(email, password);

		if (user != null) {

			session.setAttribute("user", user);

			if (user.getRole().equals("JOB_SEEKER")) {
				return "redirect:/userdashboard";
			}

			if (user.getRole().equals("RECRUITER")) {
				return "redirect:/recruiterdashboard";
			}

		}

		return "redirect:/login?error";
	}

}