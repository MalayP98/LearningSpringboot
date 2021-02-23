package com.springwebapp.learningspring.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateUser(String userid, String password) {
		return userid.equals("Malay Pandey") && password.equals("abcdefgh");
	}
}
