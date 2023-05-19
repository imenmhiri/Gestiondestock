package com.fruits.fruits.Model;

import java.io.Serializable;

public class RequestSignup implements Serializable{	  
	private static final long serialVersionUID = 5926468583005150707L;

    private String email;

    private String prenom;
	  
	private String nom;
	 
	private String password; 
	  
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}


