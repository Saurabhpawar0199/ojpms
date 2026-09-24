package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.service.UserService;

@Controller
public class ForgetPasswordController {

	@Autowired
	private UserService userService;

	@PostMapping("/reset")
	public String resetPassword(@RequestParam String email, @RequestParam String password,
			@RequestParam String confirmPassword, Model model) {

		if (!password.equals(confirmPassword)) {

			model.addAttribute("error", "Password and Confirm Password do not match");

			return "reset";
		}

		boolean updated = userService.updatePassword(email, password);

		if (updated) {

			model.addAttribute("success", "Password reset successfully");

			return "login";
		}

		model.addAttribute("error", "Email not found");

		return "reset";
	}
}