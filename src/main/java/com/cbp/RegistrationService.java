package com.cbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
	@Autowired
	private UserDAO dao;
	
	public int saveUser(User user) {
		return dao.add(user);
	}
	public User fetchUserByEmailId(String email) {
		return dao.searchEmailId(email);
	}
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return dao.searchEmailIdAndPassword(email, password);
	}
}
