package com.mms1.App.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms1.App.dao.CreatePromoDao;
import com.mms1.App.model.promoDetails;
import com.mms1.App.model.purchaseDetails;

@Service
public class CreatePromotionService {
	
    @Autowired
	CreatePromoDao CreatePromoDao;
	public boolean savePromo(promoDetails pd)
	{

		try {
			CreatePromoDao.PromoCreateSql(pd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
	
	public boolean purchasePromo(purchaseDetails pdd)
	{

		try {
			CreatePromoDao.PromoPurchaseSql(pdd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}

	
	public List<promoDetails> readPromoserve(String ShopRegId)
	{
		return CreatePromoDao.readPromoDao(ShopRegId);
	}

}
