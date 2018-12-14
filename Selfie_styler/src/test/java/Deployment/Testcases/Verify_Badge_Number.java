package Deployment.Testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Badge_Number {
	
    Login Login_obj;
	
	Shop_Checkout Shop_Checkout_obj;
	
	Fitting_Room_Hanger_Icon fitting_hanger; 
		
	
	@Test(priority=25, enabled=true)
	
	public void validate_Badge_number() throws Exception
	{
		// This will launch browser and specific url 
		   WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login_deactivate/");  // live Environment
		   
		   Login_obj = new Login(driver); // create the object of login class
		   
		   Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
		   
		   fitting_hanger = new Fitting_Room_Hanger_Icon(driver); // create the object of fitting_hanger class
		   
		   Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");
		   
		   Thread.sleep(5000);
		   
		   Shop_Checkout_obj.click_Women(); // click the women link
		   
		   Thread.sleep(3000);
		    
		   String badge_number = Shop_Checkout_obj.get_badge_number();
		   
		   System.out.println("\n"+badge_number);
		     
		   Assert.assertTrue(badge_number.contains("0"));
		   
		   fitting_hanger.click_hanger();    // click on hanger for product
		   
		   Thread.sleep(8000);
		   
		   fitting_hanger.click_hanger();  // remove product from hanger
		   
		   fitting_hanger.clickRandom(); 
		   
		   System.out.println("\n"+badge_number);
		   
		   Assert.assertTrue(badge_number.contains("0"));
		   
		   Thread.sleep(5000);
		          		   
		   driver.quit();
		
		
		
	}
	
	
	

}
