package com.mms1.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms1.App.dao.CustRegDao;
import com.mms1.App.model.CustDetails;


@Service
public class CustRegisterService {
	
	@Autowired
	CustRegDao custreg;

	public boolean saveCust(CustDetails cust) {
		// TODO Auto-generated method stub
		
		boolean user_count = custreg.alreadyregistered(cust);
		if (user_count) {
			custreg.saveCustomer(cust);
			return true;
		}
			else {
				return false;
			}
		
		
	}

}
