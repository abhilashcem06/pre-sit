package com.mms1.App.model;

public class CustDetails {
	private String fullname;
	private String email;
	private String cntry;
	private String mobile;
	private String password;
	private String role;
	public CustDetails(String fullname, String email,String cntry, String mobile, String password,String role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.mobile = mobile;
		this.cntry = cntry;
		this.password = password;
		this.role = role;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCntry() {
		return cntry;
	}
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
