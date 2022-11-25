package com.amit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="PotentialUser")
public class PotentialUser {
	

	@Id
	@Column(nullable=false, unique=true, length=45)
	@Email(message = "Email address is not valid !!")
	private String email;

	
	@Column(nullable=false, length=64)
	private String password;
	
	
	public PotentialUser() {
		
	}

	
	public PotentialUser(Long id, @Email(message = "Email address is not valid !!") String email, String password) {
		super();
		
		this.email = email;
		this.password = password;
	}




	

	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "PotentialUser [ email=" + email + ", password=" + password + "]";
	}

	
	
}
