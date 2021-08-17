package com.mms1.App.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms1.App.dao.ProductDao;
import com.mms1.App.model.productDetails;
import com.mms1.App.model.promoDetails;

@Service
public class ProductService {
	
	@Autowired
	ProductDao ProductDao;
	public boolean saveProd(productDetails pd)
	{

		try {
			ProductDao.InsertProduct(pd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	
	}
	public List<productDetails> readProdDetails(String shopregid) {
		return ProductDao.readProdDao(shopregid);
	}
	
	public boolean savePurchaseProd(List<Map<String, Object>> myList)
	{
		ProductDao.communicateProductDet(myList);
		return false;
		
	}

}
