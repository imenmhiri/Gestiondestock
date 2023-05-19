package com.fruits.fruits.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fruits.fruits.Entity.User;
import com.fruits.fruits.Model.RequestSignup;
import com.fruits.fruits.Repository.UserDTORepository;

@Service
public class UserDetail {

	@Autowired
	private UserDTORepository userDao; 

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public  User findByEmail(String email) {
	       return userDao.findByEmail(email);        
	}

	public User saveUser(RequestSignup signUpRequest) {
		User newUser = new User();
		newUser.setEmail(signUpRequest.getEmail());
		newUser.setPassword(bcryptEncoder.encode(signUpRequest.getPassword()));
		newUser.setNom(signUpRequest.getNom());
		newUser.setPrenom(signUpRequest.getPrenom());
		return userDao.save(newUser);
	}
	
}
	

