package com.mms1.App.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mms1.App.model.CustDetails;
import com.mms1.App.model.Shops;

@Repository
public class CustRegDao {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 
	 public boolean alreadyregistered (CustDetails cst)
	 {
		 String query4 = "select count(*) from app_user where user_name = '"+ cst.getEmail()+"'";
		 boolean result = true;

		    int count =  jdbcTemplate.queryForObject(query4, Integer.class); 
		    if (count > 0) {
		    	result = false;
		    }

		 return result;
		 
	 };
	 
	    
	    public int saveCustomer(CustDetails cst) {
	        System.out.println("Registering customer...");
	        
	        String query="insert into customer_detail (fullname, email, mobile, country_code ) values('"+cst.getFullname()+"','"+cst.getEmail()+"','"+cst.getMobile()+"','"+cst.getCntry()+"')";  
	        	     jdbcTemplate.update(query);
	        	     
	        String query2= "select max(cust_id) from customer_detail where email = '"+ cst.getEmail()+"'";
	        	        
	        String cust_Id =  jdbcTemplate.queryForObject(query2, String.class);  
	        int cust_id_num = Integer.parseInt(cust_Id);
	        int role_num = Integer.parseInt(cst.getRole());
	        
	        String query5="insert into user_role (ID, USER_ID, ROLE_ID ) values("+cust_id_num+",'"+cst.getEmail()+"',"+role_num+")";  
        	jdbcTemplate.update(query5);
	        
	        String query3="insert into app_user (user_id, user_name, encryted_password, enabled ) values('"+cust_Id+"','"+cst.getEmail()+"','"+cst.getPassword()+"','"+1+"')";  
	        	return  jdbcTemplate.update(query3);
	        	

	        	     
	        }
	    
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			
		}
	
}
