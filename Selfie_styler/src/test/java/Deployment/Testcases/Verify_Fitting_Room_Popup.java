package Deployment.Testcases;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Fitting_Room_Popup {

	Login Login_obj;             // login_obj is the object reference variable of Login class
	
	FittingRoomPopup fitting_room_popup_obj;    // fitting_room_popup_obj is the object reference variable of FittingRoomPopup
	
	Shop_Checkout Shop_Checkout_obj;  // Shop_Checkout_obj is the object reference variable of Shop_Checkout class
	
	
    @Test(priority =15,enabled=true)
	
	public void validate_fitting_room_popup() throws Exception
	{
	
	// This will launch browser and specific url 
	WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
	
	  Login_obj = new Login(driver); // create the object of login class
	
	  fitting_room_popup_obj = new FittingRoomPopup(driver);   // create the object of FittingRoomPopup class
	
	  Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
	
	  Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");
	   
	  Thread.sleep(5000);
	
	  Shop_Checkout_obj.click_Women();
	
	  fitting_room_popup_obj.click_down();
	  
	  fitting_room_popup_obj.click_up();
		
	  driver.quit();
	
	
	}
	

}
