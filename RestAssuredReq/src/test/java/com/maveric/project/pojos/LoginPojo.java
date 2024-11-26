package com.maveric.project.pojos;

public class LoginPojo {

	
	String email, password;

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
		return "LoginPojo [email=" + email + ", password=" + password + "]";
	}
	
}
