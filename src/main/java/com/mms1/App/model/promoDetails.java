package com.mms1.App.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class promoDetails {
	
	          private int promoid;
			  private String description;
			  private String category;
			//  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
			  private String fromdate;
			//  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
			  private String todate;
			  private int duration;
			  private String durtype;
			  private int price;
			  private int offerprice;
			  private String shopregid;
			
			  

			public promoDetails(int promoid, String description, String category, String fromdate, String todate, int duration,
					String durtype, int price, int offerprice, String shopregid) {
				super();
				this.promoid = promoid;
				this.description = description;
				this.category = category;
				this.fromdate = fromdate;
				this.todate = todate;
				this.duration = duration;
				this.durtype = durtype;
				this.price = price;
				this.offerprice = offerprice;
				this.shopregid = shopregid;
			}

		

			public promoDetails() {
				// TODO Auto-generated constructor stub
			}

			  public int getPromoid() {
					return promoid;
				}

				public void setPromoid(int promoid) {
					this.promoid = promoid;
				}

			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getCategory() {
				return category;
			}
			public void setCategory(String category) {
				this.category = category;
			}
			public String getFromdate() {
				return fromdate;
			}
			public void setFromdate(String fromdate) {
				this.fromdate = fromdate;
			}
			public String getTodate() {
				return todate;
			}
			public void setTodate(String todate) {
				this.todate = todate;
			}
			public int getDuration() {
				return duration;
			}
			public void setDuration(int duration) {
				this.duration = duration;
			}
			public String getDurtype() {
				return durtype;
			}
			public void setDurtype(String durtype) {
				this.durtype = durtype;
			}
			public int getPrice() {
				return price;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public int getOfferprice() {
				return offerprice;
			}
			public void setOfferprice(int offerprice) {
				this.offerprice = offerprice;
			}

			public String getShopregid() {
				return shopregid;
			}

			public void setShopregid(String shopregid) {
				this.shopregid = shopregid;
			}
			  

			  
		

}
