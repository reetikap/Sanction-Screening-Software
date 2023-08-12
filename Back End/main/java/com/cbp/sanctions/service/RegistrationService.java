package com.cbp.sanctions.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.sanctions.models.User;
import com.cbp.sanctions.repository.UserDAO;

@Service
public class RegistrationService {
	@Autowired
	private UserDAO dao;
	
	Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	public int saveUser(User user) {
		logger.info("User added successfully");
		return dao.add(user);
	}
	public User fetchUserByEmailId(String email) {
		return dao.searchEmailId(email);
	}
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return dao.searchEmailIdAndPassword(email, password);
	}
}
