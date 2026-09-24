package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.UserService;

@Controller
public class EditUserProfileController {

	@Autowired
	private UserService userService;

	@PostMapping("/edituserprofile")
	public String updateUserProfile(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam String password, Model model) {

		User user = new User();

		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		userService.updateProfile(user);

		model.addAttribute("msg", "Profile Updated Successfully...");

		return "user_dashboard";
	}
}