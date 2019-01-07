package Deployment.Testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Fitting_Room_Edit_Look {

	Login Login_obj;              // Login_obj is the object reference variable of Login class
	
	Fitting_Room_Hanger_Icon fitting_hanger_obj;  // fitting_hanger is the object reference variable of Fitting_Room_Hanger_Icon
	
	Fitting_Room_Edit_Look fitting_editlook_obj;
	
	Shop_Checkout Shop_Checkout_obj;  // Shop_Checkout_obj is the object reference variable of Shop_Checkout class
	

	@Test (priority=17, enabled=true)
	
	public void validate_fitting_room_editlook () throws Exception
	{
		// This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate//");  // live Environment
		
		Login_obj = new Login(driver);  // create the object of login class 
		
		fitting_hanger_obj = new Fitting_Room_Hanger_Icon(driver);  // create the object of fitting_hanger class 
		
		fitting_editlook_obj = new Fitting_Room_Edit_Look(driver);  // create the object of fitting_editlook class 
		
		Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
			
		Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");
		   
		Thread.sleep(5000);
		
		Shop_Checkout_obj.click_Women(); 
		
		fitting_hanger_obj.click_hanger();    // click on hanger for product
		
		Thread.sleep(8000);
		
		fitting_hanger_obj.click_hanger1();     // click on hanger for product
		
		Thread.sleep(6000);
		
		fitting_editlook_obj.Click_Edit_look();  // click on edit look in demo model
		
		String text = fitting_editlook_obj.Select_size_0();   // get the text of select size drop down 
		
		Assert.assertTrue(text.contains("Select a size")); // verify by default, select a size should be selected for non calibrated
		
    	Thread.sleep(3000);
		
		fitting_editlook_obj.Remove_product();    // this will remove the product
		
		Thread.sleep(5000);
		
		fitting_editlook_obj.Close_edit_popup();   // close the opened popup
		
		Thread.sleep(4000);
		
		fitting_editlook_obj.Click_Edit_look();   // click on edit look in demo model
		
		fitting_editlook_obj.recommended_size0();   // select size from the drop down
		
		fitting_editlook_obj.Add_to_cart();      // shows the status of cart
		
		fitting_editlook_obj.Click_Add_to_bag_0();   // add the item to the bag
		
		Thread.sleep(2000);
		
		fitting_editlook_obj.Add_to_cart();      // shows the status of cart
		
		driver.quit();
		
	}
	
	@Test(priority=18, enabled=true)
	
	public void validate_select_a_size() throws Exception
	
	{
		
		// This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
				
		Login_obj = new Login(driver);  // create the object of login class 
		
		fitting_hanger_obj = new Fitting_Room_Hanger_Icon(driver);
		
		fitting_editlook_obj = new Fitting_Room_Edit_Look(driver);

		Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
		
		Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");
		   
		Thread.sleep(5000);
		
		Shop_Checkout_obj.click_Women();
				
		fitting_hanger_obj.click_hanger();    // click on hanger for product
				
		Thread.sleep(8000);

		fitting_editlook_obj.Click_Edit_look();  // click on edit look in demo model
		
		Thread.sleep(4000);
		
		fitting_editlook_obj.Click_Add_to_bag_0();   // add the item to the bag
		
		Thread.sleep(3000);
		
		String text1 = fitting_editlook_obj.error_message_select_size();  // get the text of error message of select a size
		
		Assert.assertTrue(text1.contains("Select a size"));
		
		driver.quit();
			
		
	}
	
	
	
	@Test (priority =19, enabled=true)
	
	public void validate_calibrated_user() throws Exception
	{
		
		// This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
				
		Login_obj = new Login(driver);  // create the object of login class 
		
        fitting_hanger_obj = new Fitting_Room_Hanger_Icon(driver);
		
		fitting_editlook_obj = new Fitting_Room_Edit_Look(driver);

		Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
				
		Login_obj.login_selfie_styler("chandellevaldizon@yahoo.com", "Cjv913306061");
		  
		Thread.sleep(5000);
				
		Shop_Checkout_obj.click_Women();
		
        fitting_hanger_obj.click_hanger();    // click on hanger for product
		
		Thread.sleep(8000);
		
		fitting_hanger_obj.click_hanger1();     // click on hanger for product
		
		Thread.sleep(6000);
		
		fitting_editlook_obj.Click_Edit_look();  // click on edit look in demo model
		
       String recommended = fitting_editlook_obj.Select_size_0();   // get the text of select size drop down 
		
		//Assert.assertTrue(recommended.contains("(SureFit� Recommended)")); // verify by default, (SureFit� Recommended) should be selected for non calibrated
		
		Thread.sleep(3000);
		
		fitting_editlook_obj.Remove_product();    // this will remove the product
		
		Thread.sleep(3000);
		
		fitting_editlook_obj.Close_edit_popup();   // close the opened popup
		
		Thread.sleep(2000);
		
		fitting_editlook_obj.Click_Edit_look();   // click on edit look in demo model
		
        Thread.sleep(3000);
		
		fitting_editlook_obj.recommended_size0();
		
		Thread.sleep(2000);
		
	    fitting_editlook_obj.Add_to_cart();      // shows the status of cart
		
		fitting_editlook_obj.Click_Add_to_bag_0();   // add the item to the bag
		
		Thread.sleep(3000);
		
		fitting_editlook_obj.Add_to_cart();
		
		driver.quit();	
		
	}
	
	@Test (priority =20, enabled=true)
	
	public void validate_change_color() throws Exception
	{
		// This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
						
		Login_obj = new Login(driver);  // create the object of login class 
		
        fitting_hanger_obj = new Fitting_Room_Hanger_Icon(driver);
		
		fitting_editlook_obj = new Fitting_Room_Edit_Look(driver);

		Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
				
		Login_obj.login_selfie_styler("chandellevaldizon@yahoo.com", "Cjv913306061");
		   
		Thread.sleep(10000);
		
		fitting_editlook_obj.click_brand();
		
		Thread.sleep(3000);
		   
		fitting_editlook_obj.clickMonrow();
		
		Thread.sleep(8000);	
		
		fitting_editlook_obj.click_monrow_product();
		
		Thread.sleep(8000);	
		
		fitting_editlook_obj.Click_Edit_look();   // click on edit look in demo model
		
		fitting_editlook_obj.Select_a_color();
		
		Thread.sleep(2000);
		
		fitting_editlook_obj.recommended_size0();
		
        fitting_editlook_obj.Add_to_cart();      // shows the status of cart
		
		fitting_editlook_obj.Click_Add_to_bag_0();   // add the item to the bag
		
		Thread.sleep(3000);
		
		fitting_editlook_obj.Add_to_cart();      // shows the status of cart
		
		driver.quit();
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
