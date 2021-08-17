package com.mms1.App.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mms1.App.model.LoginDetails;

public class LoginMapper implements RowMapper<LoginDetails>{

	@Override
	public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new LoginDetails(null, rs.getString(2), rs.getString(1));
	}

	
	
}
