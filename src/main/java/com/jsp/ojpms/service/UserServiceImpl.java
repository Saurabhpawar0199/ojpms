package com.jsp.ojpms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User loginUser(String email, String password) {
		Optional<User> optionalUser = userRepository.findByEmail(email);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();

			if (user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		Optional<User> optional = userRepository.findByEmail(email);

		if (optional.isPresent()) {

			User user = optional.get();

			user.setPassword(password);

			userRepository.save(user);

			return true;

		}

		return false;

	}

	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public void updateProfile(User user) {
		userRepository.save(user);
	}

}