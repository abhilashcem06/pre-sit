package com.mms1.App.model;



public class Shops {
	
	private String shopRegId;
	private String shopName;
	private String shopType;
	private String shopLoc;
	private String state;
	private String district;
	private String country;
	
	public Shops(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
		this.shopRegId = string;
	}
	public Shops() {
		
	}
	public String getShopRegId() {
		return shopRegId;
	}
	public void setShopRegId(String shopRegId) {
		this.shopRegId = shopRegId;
	}
//	public String getShopId() {
//		return shopId;
//	}
//	public void setShopId(String shopId) {
//		this.shopId = shopId;
//	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopType() {
		return shopType;
	}
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}
	
	public String getShopLoc() {
		return shopLoc;
	}
	public void setShopLoc(String shopLoc) {
		this.shopLoc = shopLoc;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((shopId == null) ? 0 : shopId.hashCode());
//		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
//		result = prime * result + ((shopType == null) ? 0 : shopType.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Shops other = (Shops) obj;
//		if (shopId == null) {
//			if (other.shopId != null)
//				return false;
//		} else if (!shopId.equals(other.shopId))
//			return false;
//		if (shopName == null) {
//			if (other.shopName != null)
//				return false;
//		} else if (!shopName.equals(other.shopName))
//			return false;
//		if (shopType == null) {
//			if (other.shopType != null)
//				return false;
//		} else if (!shopType.equals(other.shopType))
//			return false;
//		return true;
//	}
//	

}
