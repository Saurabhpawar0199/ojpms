package com.jsp.ojpms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.UserService;

@Controller
public class EditRecruiterProfileController {

	@Autowired
	private UserService userService;

	@GetMapping("/editrecruiterprofile")
	public String editRecruiterProfile(@RequestParam("userId") int id, Model model) {

		Optional<User> optional = userService.getUserById(id);

		if (optional.isPresent()) {
			model.addAttribute("user", optional.get());
			return "edit_recruiter_profile";
		}

		return "redirect:/recruiterdashboard";
	}
}