package com.mms1.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms1.App.dao.CustLoginDao;
import com.mms1.App.model.LoginDetails;
import com.mms1.App.model.Shops;
@Service
public class CustloginService {
	
	@Autowired
	CustLoginDao custlogin;

	public String CheckUser(LoginDetails lg) {
	   String Checkvalue = custlogin.Checkuser(lg);
	  return Checkvalue;
	  }
	
}
