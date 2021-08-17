package com.mms1.App.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mms1.App.model.Shops;

@Repository
public class MmsShopDao implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int saveShop(Shops e) {
    	
    	try {
        String query1 = "insert into location_header(LOCATION, COUNTRY, STATE, DISTRICT) values('"+e.getShopLoc()+"','"+e.getCountry()+"','"+e.getState()+"','"+e.getDistrict()+"')";
        	
	    jdbcTemplate.update(query1);
    	} catch(DataIntegrityViolationException exept)
    	{
    	}
    	
	    
	    String query2 = "select LOCATIONID from location_header where LOCATION = '"+e.getShopLoc()+ "' and COUNTRY = '"+e.getCountry()+
	    		"' and STATE = '"+e.getState()+"' and DISTRICT = '"+e.getDistrict()+"'";
	    int loc_id = jdbcTemplate.queryForObject(query2, int.class);
        String query="insert into shop_header(SHOPREGID, SHOPNAME, SHOPTYPE, SHOPLOC, LOCATIONID) values('"+e.getShopRegId()+"','"+e.getShopName()+"','"+e.getShopType()+"','"+e.getShopLoc()+ loc_id +"')";  
        	    return jdbcTemplate.update(query);          
        }
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<Shops> getAllShops(String locationName )
	{
		List<Shops> tempShops = new ArrayList<>();
	
		 String query3 = "select LOCATION, COUNTRY, STATE, DISTRICT from location_header where location = '"+ locationName+"'";
		 List<Map<String, Object>> myListloc = new ArrayList<Map<String, Object>>();
		 myListloc =  jdbcTemplate.queryForList(query3);
		 Map<String, Object> myMapLoc ; 
		 myMapLoc = myListloc.get(0);
		 
		 
		 String query4 = "select locationid from location_header where location = '"+ locationName+"'";
		 int locationID = jdbcTemplate.queryForObject(query4, int.class) ;
		
		List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();

		myList =  jdbcTemplate.queryForList("select * from shop_header where locationid = '"+locationID+"'");
		
		Map<String, Object> myMap ; 
		for (int j=0; j<myList.size(); j++)
		{
			 myMap = myList.get(j);
	
			 
			 Shops shop1 = new Shops();
			 shop1.setShopName((String) myMap.get("shopname"));
			 shop1.setShopLoc((String) myMap.get("shoploc"));
			 shop1.setShopRegId((String) myMap.get("shopregid"));
			 shop1.setCountry((String) myMapLoc.get("country"));
			 shop1.setState((String) myMapLoc.get("state"));
			 shop1.setDistrict((String) myMapLoc.get("district"));
			 tempShops.add(shop1);
			 
		}
		

		return tempShops;
	}
    
}