package com.mms1.App.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.mms1.App.model.productDetails;
import com.mms1.App.model.promoDetails;
import com.twilio.Twilio;

@Repository
public class ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String ACCOUNT_SID = "ACc7c61bff297073e8e1457406a9cd44e1";
	private static final String AUTH_ID = "6493578ed486c9cf8e090fbcd54326b7";
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void InsertProduct(productDetails prd) throws ParseException {
		
		String query2 = "select SHOPID from shop_header where shopregid = "+"'"+prd.getShopregid()+"'";

		int shop_id = jdbcTemplate.queryForObject(query2, int.class);
		String Product_Name = prd.getProdname().replaceAll("\\s", "");
		
		String query = "BEGIN insert into product_details (PRODUCTNAME, UNITTYPE, UNIT, PRICE, SHOPID, SHOPREGID,category) values('"
				+ Product_Name + "','" + prd.getUnittype() + "', " + prd.getUnit()+ ","
				+ prd.getPrice() + "," + shop_id
				+ ",'"+prd.getShopregid()+"','"+prd.getCategory()+"');"
			    + " EXCEPTION WHEN dup_val_on_index THEN  UPDATE product_details SET UNITTYPE = '"+ prd.getUnittype() +"', "
			    + "unit = "+ prd.getUnit()+ ", price = "+ prd.getPrice() + ", category = '"+prd.getCategory()+"' "
			    + "where shopid = "+ shop_id + "and productname = '" + Product_Name + "';"
			    + " END;"; 
		
		jdbcTemplate.update(query);
		
	}

	public List<productDetails> readProdDao(String shopregid) {
		
		List<productDetails> tempProd = new ArrayList<>();
			
			List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();
			String query = "select productname, unittype, unit, price,shopregid,category"
					+ "  from product_details where SHOPREGID ='"+shopregid+"'";
			
			System.out.println("query -- > "+query);
			myList =  jdbcTemplate.queryForList(query);
			
			
	
			Map<String, Object> myMap ; 
			for (int j=0; j<myList.size(); j++)
			{
				 myMap = myList.get(j);
				 
				 
				 productDetails productDetails = new productDetails();
				 
				 productDetails.setProdname((String) myMap.get("productname"));
				 
				 productDetails.setUnittype((String) myMap.get("unittype"));
				
				 productDetails.setUnit( new BigDecimal(myMap.get("unit").toString()).intValue());
				
				 productDetails.setPrice(new BigDecimal( myMap.get("price").toString()).intValue());
				
				 productDetails.setShopregid((String) myMap.get("shopregid"));
				 
				 productDetails.setCategory((String) myMap.get("category"));
				 
				 tempProd.add(productDetails);
				 
			}
			

			return tempProd;
	}


	public void communicateProductDet(List<Map<String, Object>> myList) {
		
		List<productDetails> tempProd = new ArrayList<>();
		
		
		StringBuilder sb = new StringBuilder();
		   
		   
//Send Email from Gmail.com
		   
		   SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("abhilashcem06@gmail.com");

	        msg.setSubject("Your Purchase Details from Vshop");
	        
	        int total_price = 0;
	        int k = 0;
	        for (int j=0; j<myList.size(); j++)
			{
	        	k = j+1;
	            sb.append(k+")\t"+myList.get(j).get("ProductName")+"\t");
	            sb.append(myList.get(j).get("Unit")+"  ");
	            sb.append(myList.get(j).get("UnitType")+"\t");
	            
	            sb.append("Price:   "+myList.get(j).get("Price")+"\n");
	            
	            int Price_Temp =  (int) myList.get(j).get("Price");
	            total_price += Price_Temp;
	            
			}

	        sb.append("\n"+"Total Price: "+total_price);
	        
	        msg.setText("YOU HAVE PURCHASED THE ITEMS LISTED FROM Vshop."+"\n"+"Please contact the owner and delivery man if any delay in delivery time"+"\n"+sb);
	        javaMailSender.send(msg);
	        
	        
	        
	    	//  Send SMS			 
			 
			
			   Twilio.init(ACCOUNT_SID, AUTH_ID);
			
//			   Message.creator(new com.twilio.type.PhoneNumber(mobile_num), new com.twilio.type.PhoneNumber("+18315315554"),
//		"You have purchased:").create();
	        
	        
	}

}
