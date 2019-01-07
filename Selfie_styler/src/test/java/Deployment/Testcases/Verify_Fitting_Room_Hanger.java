package Deployment.Testcases;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Utility.BrowserFactory;
import com.pages.*;


public class Verify_Fitting_Room_Hanger {


	Fitting_Room_Hanger_Icon fitting_hanger;  // fitting_hanger is the object reference variable of Fitting_Room_Hanger_Icon
	
	 Login Login_obj;                      // login_obj is the object reference variable of Login class
	
	Shop_Checkout Shop_Checkout_obj;  // Shop_Checkout_obj is the object reference variable of Shop_Checkout class
	
	
	@Test (priority =16,enabled=true)
	 
	 public void validate_Fitting_Room_Hanger () throws Exception
	 {
		// This will launch browser and specific url 
			WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
				
			Login_obj = new Login(driver); // create the object of login class
			
			fitting_hanger = new Fitting_Room_Hanger_Icon(driver); // create the object of fitting_hanger class
			
			Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
			 	
			Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");
			
		    Thread.sleep(5000);
			
			Shop_Checkout_obj.click_Women();
		  //  Thread.sleep(5000);
		    
			fitting_hanger.click_hanger();
			
			Thread.sleep(8000);	
		    
			fitting_hanger.click_hanger();
			
			Thread.sleep(1000);	
			
			fitting_hanger.clickRandom();
			
			Thread.sleep(3000);
			
			driver.quit(); 
					
			
	 }
	
	
	
}
