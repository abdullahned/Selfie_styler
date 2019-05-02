package Deployment.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Favourite;
import com.pages.Fittingroom_Currentlook;
import com.pages.Home;
import com.pages.Login;
import com.pages.Product_Details;

import resources.TestBase;

public class verify_productdetails extends TestBase  {
	
	@Test(priority=1, enabled=true, invocationCount=3)
	public void Acceptance_criteria_1() throws Exception
	{
        extentTest = extent.startTest("Product Detail AC#1");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
		
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);
		
		Product_Details Product_Details_obj = new Product_Details(driver);

		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_hanger();
		
		Thread.sleep(4000);
		
		Product_Details_obj.click_currentlook_detail();
		
		Thread.sleep(4000);
		
	    String additem_tocart = Fittingroom_Currentlook_obj.additem_tocart();
		
		Assert.assertEquals(additem_tocart, "Add item to cart", "Add to cart button is available");
		
        String add_to_fav = Product_Details_obj.addto_fav();
		
		Assert.assertEquals(add_to_fav, "add", "favorite verified");
		
		String brand = Product_Details_obj.Brand_name();
			
	    Assert.assertEquals(brand, "fitting_room_pd_brand", "brand verified");
	    
		String product = Product_Details_obj.Product_name();
		
	    Assert.assertEquals(product, "fitting_room_pd_title", "product verified");
	    
	    String surefit_message = Product_Details_obj.surefit();
	    
	    System.out.println(surefit_message);
	    
	    Assert.assertEquals(surefit_message, "Size: Don't worry, we have your", "surefit verified"); 
	    
		
		
	}
}
