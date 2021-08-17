package com.mms1.App.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mms1.App.loguser.User;
import com.mms1.App.model.CustDetails;
import com.mms1.App.model.LocationDetails;
import com.mms1.App.model.LoginDetails;
import com.mms1.App.model.Shops;
import com.mms1.App.model.productDetails;
import com.mms1.App.model.promoDetails;
import com.mms1.App.model.purchaseDetails;
import com.mms1.App.service.CreatePromotionService;
import com.mms1.App.service.CustRegisterService;
import com.mms1.App.service.CustloginService;
import com.mms1.App.service.MmsShopService;
import com.mms1.App.service.ProductService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShopViewController {
	
	@Autowired
	MmsShopService mmsShopService;
	
	@Autowired
	CustRegisterService CustRegService;
	
	@Autowired
	CreatePromotionService CreatePromotionService;
	
	@Autowired
	ProductService ProductService;
	
	@Autowired
	CustloginService cstloginService;
	

	@RequestMapping(value = "/shopsList")
	public List<Shops> firstPashopsListge(@RequestParam("locationId") String locationId) {
	
		return mmsShopService.retrieveShops(locationId);
	//return createList();
        }
	
	@RequestMapping({"/readPromo"})
	public List<promoDetails> GetPromo(@RequestParam("shopregid") String shopregid) 
	{
		
		System.out.println("---  >"+shopregid);
		List<promoDetails> promoDetails =  CreatePromotionService.readPromoserve(shopregid);
		System.out.println(" promoDetails ---"+promoDetails.size());
		return promoDetails;
	}
	
	@RequestMapping({"/readProd"})
	public List<productDetails> GetProd(@RequestParam("shopregid") String shopregid) 
	{
		
		System.out.println("---  >"+shopregid);
		List<productDetails> productDetails =  ProductService.readProdDetails(shopregid);
		System.out.println(" prodDetails ---"+productDetails.size());
		return productDetails;
	}
	
	
	
	
	@GetMapping(produces = "application/json")
	@RequestMapping({"/login"})
	public User Checkuser(@RequestParam("username") String username, @RequestParam("password") String password) 
	{

		User u = new User("Invalid Username/Password");
		LoginDetails lg = new LoginDetails(username, password, null);
		
		String role = cstloginService.CheckUser(lg);
		
		System.out.println("Role ---> "+role);
		
		if (role != null && !role.equals("")) {
			  u = new User(role);
		}
			
			  return u;

	}
	
	@PostMapping("/purchase")
 public boolean purchasePromo(@RequestBody purchaseDetails pur )
 {
		if (CreatePromotionService.purchasePromo(pur)) {
    		return true;
			
		} else {
			return false;

		}
 }
 
    @PostMapping("/createShops")  
    public boolean saveShops(@RequestBody Shops shop) {  
//Changes for adding product based on shopregID 
    	System.out.println("Shop Name:     "+shop.getShopName());
    	System.out.println("Shop Reg ID:    "+shop.getShopRegId());
    	System.out.println("Shop Type:     "+shop.getShopType());
    	System.out.println("Shop Location: "+shop.getShopLoc());
    	 mmsShopService.saveShop(shop);
    	return true;
          
    }  
    
    @PostMapping("/registerCust")
    public boolean CustRegister(@RequestBody CustDetails cust)
    {
    	if (CustRegService.saveCust(cust)) {
    		return true;
			
		} else {
			return false;
		}	
    }
      
    
    @PostMapping("/createPromo")
    public boolean createPromo(@RequestBody promoDetails promo)
    {
    	if (CreatePromotionService.savePromo(promo)) {
    		return true;
			
		} else {
			return false;

		}
    	
    	
    }
    
    
    @PostMapping("/createProduct")
    public boolean createProduct(@RequestBody productDetails prod)
    {
    	if (ProductService.saveProd(prod)) {
    		return true;
			
		} else {
			return false;

		}
    	
    	
    }
    
    @PostMapping("/maintLocation")
    public boolean maintLocation(@RequestBody LocationDetails locDet)
    {
    	if (ProductService.saveProd(locDet)) {
    		return true;
			
		} else {
			return false;

		}
    	
    	
    }
    
    @PostMapping("/purchaseproduct")
    public boolean purchaseProduct(@RequestBody List<Map<String, Object>> myList)
    {
    	if (ProductService.savePurchaseProd(myList)) {
    		return true;
			
		} else {
			return false;

		}
    	
    	
    }
   

	private static List<Shops> createList() {
		List<Shops> tempShops = new ArrayList<>();
		Shops shop1 = new Shops();
		shop1.setShopRegId("Saloon001");
		shop1.setShopName("SaloonOne");
		shop1.setShopType("Saloon");
		shop1.setShopLoc("AngMoKio");

		tempShops.add(shop1);
		return tempShops;
	}
	
	
	@Value("${phoneNumber}")
    private String phoneNumber;
	
	@GetMapping("/")
	   public ModelAndView showDashboard(){
	       ModelAndView dashboard = new ModelAndView("dashboard");
	       dashboard.addObject("phoneNumber", phoneNumber);
	       return dashboard;
	   }
	
	 public static class MessageDetails {
	        public List<String> numbers;
	        public String message;
	    }
	 
	 @Value("${phoneNumber}")
	    private String myTwilioPhoneNumber;
	 private String PhoneNumber;

	  @Autowired
	    public void SMSController(
	        @Value("${twilioAccountSid}") String twilioAccountSid,
	        @Value("${twilioAuthToken}") String twilioAuthToken) {
	        Twilio.init(twilioAccountSid, twilioAuthToken);
	    }
	  
	  @PostMapping("/send-messages")
	   // @ResponseStatus(HttpStatus.ACCEPTED)
	    public void sendMessages(@RequestBody MessageDetails messageDetails) {

	        messageDetails.numbers.stream().forEach( number -> {
	            Message message = Message.creator(
	                new com.twilio.type.PhoneNumber(number),
	                new com.twilio.type.PhoneNumber(myTwilioPhoneNumber),
	                messageDetails.message).create();
	            System.out.println("Sent message w/ sid: " + message.getSid());
	        });
	  }
	  
	  
	
	
	
	
	
}