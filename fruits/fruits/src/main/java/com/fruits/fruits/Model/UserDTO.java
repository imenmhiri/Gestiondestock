package com.fruits.fruits.Model;

public class UserDTO {
	
	 private  Long id; 
	  
	 private String prenom,nom,password,email; 
	  
	 public Long getId() {
		return id;
	 }

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserAnonyme [id=" + id + ", email=" + email + ", prenom=" + prenom + ", nom=" + nom + ", password="
				+ password + "]";
	}

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
