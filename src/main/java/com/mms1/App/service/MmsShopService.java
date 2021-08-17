package com.mms1.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms1.App.dao.MmsShopDao;
import com.mms1.App.model.Shops;
@Service
public class MmsShopService {

	@Autowired
	MmsShopDao mmsShopDao ;

	
	
	  public int saveShop(Shops sh) {
		  mmsShopDao.saveShop(sh);
	  return 1; 
	  }
	 
	  
	  public List<Shops> retrieveShops(String locationName)
	  {
		  
		return mmsShopDao.getAllShops(locationName);
		  
	  }


	


	



}
