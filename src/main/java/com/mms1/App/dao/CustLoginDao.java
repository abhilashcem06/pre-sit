package com.mms1.App.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mms1.App.mapper.LoginMapper;
import com.mms1.App.model.LoginDetails;

@Repository
public class CustLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
    
	/*
	 * public String Checkuser(LoginDetails l) {
	 * 
	 * String query= "select ENCRYTED_PASSWORD from app_user where USER_NAME  = '"+
	 * l.getUsername()+"'";
	 * 
	 * String Dbpassword = jdbcTemplate.queryForObject(query, String.class); if
	 * (Dbpassword.equals(l.getPassword())) { return "Matched"; } else { return
	 * "NotMatched"; }
	 * 
	 * 
	 * // return Dbpassword; }
	 */
    
	public String Checkuser(LoginDetails l) {

		String roles = "";
		String usr_query = "select user_id,ENCRYTED_PASSWORD from app_user where USER_NAME  = '" + l.getUsername()+ "'";

		LoginDetails det = jdbcTemplate.queryForObject(usr_query, new LoginMapper());
		if (det.getPassword().equals(l.getPassword())) {
			String role_query = "select role_id from user_role where id  = '" + det.getUsr_id() + "'";
			roles = jdbcTemplate.queryForObject(role_query, String.class);
		} 
		return roles;

	}
	
}
