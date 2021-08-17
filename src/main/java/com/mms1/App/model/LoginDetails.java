package com.mms1.App.model;



public class LoginDetails {
	
	private String usr_id;
	private String username;
	private String password;
	
	
	
	public LoginDetails(String username, String password, String usr_id) {
		super();
		this.usr_id = usr_id;
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


	public String getUsr_id() {
		return usr_id;
	}


	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	

}
