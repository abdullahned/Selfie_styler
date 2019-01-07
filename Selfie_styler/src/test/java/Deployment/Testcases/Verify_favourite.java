package Deployment.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_favourite {
	
    Login Login_obj;
    
	Shop_Checkout Shop_Checkout_obj;
	
	Favourite Favourite_obj;
	
	@Test(priority=23, enabled=true)
	public void validate_favourite() throws Exception
	{
		
	   // This will launch browser and specific url 
	    WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
		   
		Login_obj = new Login(driver); // create the object of login class
		
		Favourite_obj = new Favourite(driver);  // create the object of favorite class 
		
		Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
		
		Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");
		 
		Thread.sleep(5000);
		   
		Shop_Checkout_obj.click_Women(); // click the women link
		
		Favourite_obj.click_favourite_product1();
		
		Thread.sleep(3000);
		
		Favourite_obj.click_favourite_product2();
		
		Thread.sleep(3000);
		
		JavascriptExecutor jkl = (JavascriptExecutor)driver;
		
	    jkl.executeScript("window.scrollBy(0,-500)", "");
		
		Favourite_obj.click_favourite();
		
		Thread.sleep(2000);
		
		Favourite_obj.click_remove_product();
		
		Thread.sleep(3000);
		
		Favourite_obj.switch_to_alert();
		
		Thread.sleep(5000);
		
		Shop_Checkout_obj.click_Women(); // click the shop link
		
		jkl.executeScript("window.scrollBy(0,-500)", "");
		
		Favourite_obj.click_favourite();
		
		Favourite_obj.click_accept_product();

		Thread.sleep(5000);
		
		driver.quit();
	}

}
