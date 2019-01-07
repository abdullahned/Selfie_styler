package Deployment.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_FittingRoom_ProductDetail {

    Login Login_obj;
	
	Shop_Checkout Shop_Checkout_obj;
	
	Fitting_Room_Hanger_Icon fitting_hanger_obj;
	
    String email="qa-women@mailinator.com";
	
	String password ="Germany0!";
	
	@Test(priority=22, enabled=true)
	
	public void validate_fittingRoom_ProductDetail() throws Exception
	{
	   // This will launch browser and specific url 
	   WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
	    			
	   Login_obj = new Login(driver);  // create the object of login class 
	   	
       Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
       
       fitting_hanger_obj = new Fitting_Room_Hanger_Icon(driver);  // create the object of fitting_hanger class 
       
       Login_obj.login_selfie_styler(email, password);
       
       Thread.sleep(5000);
    	
       Shop_Checkout_obj.click_Women();    
       
       fitting_hanger_obj.click_productdetail_hanger();
       
       Thread.sleep(8000);

       String hanger_clicked = fitting_hanger_obj.verify_hanger_clicked();
       
       Assert.assertTrue(hanger_clicked.contains("hanger activeproduct")); // verify hanger is clicked
       
       System.out.println(hanger_clicked);
          
	   Shop_Checkout_obj.click_product_Detail();
       
       Thread.sleep(3000);
	   
	   JavascriptExecutor jex = (JavascriptExecutor)driver;
	   
	   jex.executeScript("window.scrollBy(0,200)", "");
	   
	   String before_removing = Shop_Checkout_obj.before_remove_fitting_room_text();
	   
	   Assert.assertTrue(before_removing.contains("Remove from fitting room")); // verify the button text
	   
	   Thread.sleep(2000);
	   
	   System.out.println(before_removing);
	   
	   Shop_Checkout_obj.click_remove_fitting_room();
	   
	   Thread.sleep(4000);
	   
	   String after_removing = Shop_Checkout_obj.after_remove_fitting_room_text();
	   
	   Assert.assertTrue(after_removing.contains("Add to fitting room")); // verify the button text
	   
	   String click_up = Shop_Checkout_obj.click_up_text();
	   
	   Assert.assertTrue(click_up.contains("up")); // verify the button text
	   
	   System.out.println(click_up);
	   
	   Thread.sleep(4000);
	   
	   driver.quit();
	  
	   
		
	}
	
}
