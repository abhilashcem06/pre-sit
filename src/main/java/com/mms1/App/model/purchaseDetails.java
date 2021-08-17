package com.mms1.App.model;

public class purchaseDetails {
	private String promoid;
	private String shopregid;
	private String custid;
	private int price;
	private String effdate;
	private String todate;
	
	
	public purchaseDetails(String promoid, String shopregid, String custid, int price, String effdate, String todate) {
		super();
		this.promoid = promoid;
		this.shopregid = shopregid;
		this.custid = custid;
		this.price = price;
		this.effdate = effdate;
		this.todate = todate;
	}
	public String getPromoid() {
		return promoid;
	}
	public void setPromoid(String promoid) {
		this.promoid = promoid;
	}
	public String getShopregid() {
		return shopregid;
	}
	public void setShopregid(String shopregid) {
		this.shopregid = shopregid;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEffdate() {
		return effdate;
	}
	public void setEffdate(String effdate) {
		this.effdate = effdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	
	

}
