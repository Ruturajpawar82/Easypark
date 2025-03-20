package com.jbk.entity;

public class Loginuser {
	
	private String username;
	private String password;
	
	public Loginuser() {
		
	}

	public Loginuser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Loginuser [username=" + username + ", password=" + password + "]";
	}
	
	

}
