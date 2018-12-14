package Deployment.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Fitting_Room_SearchPage {
	
    Login Login_obj;
	
	Shop_Checkout Shop_Checkout_obj;
	
	FittingRoom_SearchPage FittingRoom_SearchPage_obj;
	
	String email="qa-women@mailinator.com";
		
	String password ="Germany0!";
	
	@Test(priority=26, enabled=true)
	
	public void validate_fitting_searchpage() throws Exception
	{
		
	   // This will launch browser and specific url 
	  WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login_deactivate/");  // live Environment
		    			
	  Login_obj = new Login(driver);  // create the object of login class 
		   	
	  Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
	  
	  FittingRoom_SearchPage_obj = new FittingRoom_SearchPage(driver);
	  
	  Login_obj.login_selfie_styler(email, password);
      
      Thread.sleep(5000);
   	
      //Shop_Checkout_obj.click_Women();
      
      FittingRoom_SearchPage_obj.search_text();
   
      
      Thread.sleep(2000);
      
      FittingRoom_SearchPage_obj.click_search();
      
      Thread.sleep(5000);
      
      FittingRoom_SearchPage_obj.verify_searchtext();
      
      Thread.sleep(4000);
      
      String search_text =  FittingRoom_SearchPage_obj.verify_searchtext();
      
      Thread.sleep(5000);
      
   //  Assert.assertTrue(search_text.contains("YOUR SEARCH FOR \"LUSH CLOTHING\" REVEALED THE FOLLOWING:")); // verify the search text
      
      driver.quit();  	
		
	}
	
 
	

}
