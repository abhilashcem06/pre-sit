package com.mms1.App.model;

public class productDetails {
	private String prodname;
	private String unittype;
	private double unit;
	private double price;
	private String shopregid;
	private String category;
	
	

	public productDetails(String prodname, String unittype, double unit, double price, String shopregid, String category) {
		super();
		this.prodname = prodname;
		this.unittype = unittype;
		this.unit = unit;
		this.price = price;
		this.shopregid=shopregid;
		this.category=category;
	}
	public productDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getUnittype() {
		return unittype;
	}
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	public double getUnit() {
		return unit;
	}
	public void setUnit(double unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getShopregid() {
		return shopregid;
	}
	public void setShopregid(String shopregid) {
		this.shopregid = shopregid;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
