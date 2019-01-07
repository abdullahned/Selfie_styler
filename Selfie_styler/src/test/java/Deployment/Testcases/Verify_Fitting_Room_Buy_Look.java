package Deployment.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Fitting_Room_Buy_Look {
	
    Login Login_obj;              // Login_obj is the object reference variable of Login class
	
	Fitting_Room_Hanger_Icon fitting_hanger_obj;  // fitting_hanger is the object reference variable of Fitting_Room_Hanger_Icon
	
	Fitting_Room_Edit_Look fitting_editlook_obj;
	
	Shop_Checkout Shop_Checkout_obj;  // Shop_Checkout_obj is the object reference variable of Shop_Checkout class
	
	FittingRoom_BuyLook FittingRoom_BuyLook_obj; // FittingRoom_BuyLook_obj is the object reference variable of FittingRoom_BuyLook
	
	String email="qa-women@mailinator.com";
	
	String password ="Germany0!";
	
	
    @Test (priority=21, enabled=true)
	
	public void validate_fitting_room_buylook () throws Exception
	{	
    	// This will launch browser and specific url 
       WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
    			
       Login_obj = new Login(driver);  // create the object of login class 
    			
       fitting_hanger_obj = new Fitting_Room_Hanger_Icon(driver);  // create the object of fitting_hanger class 
    			
       fitting_editlook_obj = new Fitting_Room_Edit_Look(driver);  // create the object of fitting_editlook class 
    			
       Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
       
       FittingRoom_BuyLook_obj = new FittingRoom_BuyLook(driver); // create the object of FittingRoom_BuyLook class
       
       Login_obj.login_selfie_styler(email, password);
       
       Thread.sleep(5000);
    	
       Shop_Checkout_obj.click_Women();
       
       fitting_hanger_obj.click_hanger();
       
       Thread.sleep(4000);
       
       fitting_hanger_obj.click_hanger1();
       
       Thread.sleep(5000);
       
       FittingRoom_BuyLook_obj.Click_Buy_look();
       
       Thread.sleep(5000);
       
   	   String product_size0 = fitting_editlook_obj.Select_size_0();   // get the text of select size drop down 
	
	   Assert.assertTrue(product_size0.contains("Select a size")); // verify by default, select a size should be selected for non calibrated
       
	   String product_size1 = fitting_editlook_obj.Select_size_1();   // get the text of select size drop down 
		
	   Assert.assertTrue(product_size1.contains("Select a size")); // verify by default, select a size should be selected for non calibrated
	   
	   String cart_count = Shop_Checkout_obj.get_cart_count();
	   
	   System.out.println("\n"+cart_count);
	   
	   Assert.assertTrue(cart_count.contains("0")); // verify empty cart count
	   
	   Thread.sleep(4000);
	   
	   fitting_editlook_obj.Click_Add_to_bag_0();   // add the item to the bag
	   
	   Thread.sleep(3000);
		
	    String error_message = fitting_editlook_obj.error_message_select_size();  // get the text of error message of select a size
		
		Assert.assertTrue(error_message.contains("Select a size"));
		
		fitting_editlook_obj.recommended_size0();   // select size from the drop down
	   
	   Thread.sleep(3000);
	   
	   fitting_editlook_obj.Click_Add_to_bag_0();   // add the item to the bag
	   
	   Thread.sleep(6000);
	   
	   fitting_editlook_obj.Click_Add_to_bag_1();
	   
	   Thread.sleep(2000);
	   
	   Assert.assertTrue(error_message.contains("Select a size"));
	   
       fitting_editlook_obj.recommended_size1();   // select size from the drop down
	   
	   Thread.sleep(3000);
	   
	   fitting_editlook_obj.Click_Add_to_bag_1();
	   
	   Thread.sleep(2000);
	   
	   String message = Shop_Checkout_obj.get_cart_message();
	   
	   System.out.println(message);
	   
	   Thread.sleep(5000);
	     
       String updated_cart_count = Shop_Checkout_obj.get_cart_count();
	   
	   System.out.println("\n"+updated_cart_count+"\n");
	   
	   Assert.assertTrue(updated_cart_count.contains("2")); //verify updated cart count
	   
       driver.quit();
       
       
    	
    	
    	
	}

}
