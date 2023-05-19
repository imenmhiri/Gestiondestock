package com.fruits.fruits.Model;
import java.io.Serializable;

public class AuthenticateRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String password;
	private String email;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//need default constructor for JSON Parsing
	public AuthenticateRequest()
	{	
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
