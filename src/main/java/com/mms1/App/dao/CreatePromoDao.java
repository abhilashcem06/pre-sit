package com.mms1.App.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.mms1.App.model.promoDetails;
import com.mms1.App.model.purchaseDetails;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Repository
public class CreatePromoDao {
	
	 private static final String ACCOUNT_SID = "ACc7c61bff297073e8e1457406a9cd44e1";
	private static final String AUTH_ID = "6493578ed486c9cf8e090fbcd54326b7";
	@Autowired
	    private JdbcTemplate jdbcTemplate;
	 	SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yy");
	 	
		@Autowired
	    private JavaMailSender javaMailSender;
	 
	 
		public void PromoCreateSql(promoDetails promo) throws ParseException {
			
			System.out.println(promo.getShopregid());

			String query2 = "select SHOPID from shop_header where shopregid = "+"'"+promo.getShopregid()+"'";

			int shop_id = jdbcTemplate.queryForObject(query2, int.class);
			
			/*
			 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd"); Date
			 * Fromdate = formatter.parse(promo.getFromdate()); Date Todate =
			 * formatter.parse(promo.getTodate());
			 */

			String query = "insert into promotion_header (description, category, fromdate, todate, duration, durtype, price, offerprice, SHOPID,SHOPNAME, shopregid ) values('"
					+ promo.getDescription() + "','" + promo.getCategory() + "'," + "TO_DATE('"+promo.getFromdate()+"','yyyy/mm/dd'),"+ "TO_DATE('"+promo.getTodate()+"','yyyy/mm/dd')" + ","
					 + promo.getDuration() + ",'" + promo.getDurtype() + "',"
					+ promo.getPrice() + "," + promo.getOfferprice() + "," + shop_id + ",'"
					+ "TEst Shop Name" +"','"+promo.getShopregid()+"')";
			jdbcTemplate.update(query);
		}


		public List<promoDetails> readPromoDao(String shopRegId) {
			// TODO Auto-generated method stub
			List<promoDetails> tempPromos = new ArrayList<>();
	
				
			//	String query3 = "select shopname,shoploc,shoptype,shopregid from shop_header";
				
				List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();
				String query = "select promo_id, description, CATEGORY, FROMDATE, TODATE, DURATION,"
						+ " DURTYPE, PRICE, OFFERPRICE, SHOPID, SHOPNAME from promotion_header where SHOPREGID ='"+shopRegId+"'";
				
				System.out.println("query -- > "+query);
				myList =  jdbcTemplate.queryForList(query);
				
				
		
				Map<String, Object> myMap ; 
				for (int j=0; j<myList.size(); j++)
				{
					 myMap = myList.get(j);
					 
					 
					 promoDetails promoDetails = new promoDetails();
					 promoDetails.setPromoid( new BigDecimal(myMap.get("promo_id").toString()).intValue());
					 promoDetails.setDescription((String) myMap.get("description"));
					 promoDetails.setCategory((String) myMap.get("category"));
					 promoDetails.setFromdate(df.format(myMap.get("fromdate")));
					 promoDetails.setTodate(df.format(myMap.get("todate")) );
					 promoDetails.setDuration( new BigDecimal(myMap.get("duration").toString()).intValue());
					 promoDetails.setDurtype((String) myMap.get("durtype"));
					 promoDetails.setPrice(new BigDecimal( myMap.get("price").toString()).intValue());
					 promoDetails.setOfferprice(new BigDecimal( myMap.get("offerprice").toString()).intValue());
					 promoDetails.setShopregid((String) myMap.get("shopregid"));
					 
					 tempPromos.add(promoDetails);
					 
				}
				

				return tempPromos;
		}

		
		
		

		public void PromoPurchaseSql(purchaseDetails pdd) throws ParseException {
			// TODO Auto-generated method stub
			
			int promId = Integer.parseInt(pdd.getPromoid().substring(1,pdd.getPromoid().length()-1));
			
			
			String query4 = "select user_id from app_user where user_name = "+"'"+pdd.getCustid()+"'";
			int userid = jdbcTemplate.queryForObject(query4, int.class);
			
			String query5 = "select mobile from customer_detail where cust_id = "+userid;
			String mobile_num = jdbcTemplate.queryForObject(query5, String.class);
			mobile_num = "+65"+mobile_num;
			
			
			String query = "insert into purchase_detail (cust_id, promo_id, active, total_value ) values("
					+ userid + "," + promId + ",'Y',"+ pdd.getPrice()+")";
			 jdbcTemplate.update(query);
			 

//  Send SMS			 
			 
			
				   Twilio.init(ACCOUNT_SID, AUTH_ID);
				
		//		   Message.creator(new com.twilio.type.PhoneNumber(mobile_num), new com.twilio.type.PhoneNumber("+18315315554"),
		//	"You have purchased:").create();
				   
				   
//  Send Email from Gmail.com
				   
				   SimpleMailMessage msg = new SimpleMailMessage();
			        msg.setTo("abhilashcem06@gmail.com");

			        msg.setSubject("Your Purchase Details from Vshop");
			        msg.setText("Your purchase request sent shop owner and delivery man");

			        javaMailSender.send(msg);
			        
			        
			
			
		}

}
