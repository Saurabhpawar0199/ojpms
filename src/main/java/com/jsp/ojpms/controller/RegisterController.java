package com.jsp.ojpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam String role) {

		User user = new User(name, email, password, role);

		userService.saveUser(user);

		return "redirect:/home";
	}

}