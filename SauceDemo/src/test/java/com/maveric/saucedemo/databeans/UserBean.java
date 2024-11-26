package com.maveric.saucedemo.databeans;

public class UserBean {
	
	private String username, password;
	public UserBean() {}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPasswsord() {
		return password;
	}
	public void setPasswsord(String passwsord) {
		this.password = passwsord;
	}
	@Override
	public String toString() {
		return "UserBean [userName=" + username + ", password=" + password + "]";
	}
	
	
}
