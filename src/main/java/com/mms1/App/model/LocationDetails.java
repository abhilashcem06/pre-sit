package com.mms1.App.model;

public class LocationDetails {

	private String country;
	private String state;
	private String district;
	private String location;
	private String pincode;
	public LocationDetails(String country, String state, String district, String location, String pincode) {
		super();
		this.country = country;
		this.state = state;
		this.district = district;
		this.location = location;
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
}
