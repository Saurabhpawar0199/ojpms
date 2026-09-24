package com.jsp.ojpms.service;

import java.util.Optional;

import com.jsp.ojpms.entity.User;

public interface UserService {

	void saveUser(User user);

	User loginUser(String email, String password);

	boolean updatePassword(String email, String password);

	void updateProfile(User user);

	Optional<User> getUserById(int id);

}