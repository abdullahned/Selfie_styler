package Deployment.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Favourite;
import com.pages.Fittingroom_Currentlook;
import com.pages.Home;
import com.pages.Login;

import resources.TestBase;

public class Verify_Currentlook extends TestBase {


	@Test(priority=0, enabled=true)
	public void Acceptance_criteria_1() throws Exception
	{
		extentTest = extent.startTest("Fitting Room Current Look AC#1");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
			
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);

		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(5000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		Thread.sleep(2000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		String detail_text = Fittingroom_Currentlook_obj.currentlook_detail();
		
		Thread.sleep(2000);
			
		Assert.assertEquals(detail_text, "Details", "current look verified");	
		
	}
	

	@Test(priority=1, enabled=true)
	public void Acceptance_criteria_2() throws Exception
	{
		extentTest = extent.startTest("Fitting Room Current Look AC#2");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
			
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);
			
		Favourite Favourite_obj = new Favourite(driver) ;
		
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(5000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		Thread.sleep(2000);
		
		String detail_text = Fittingroom_Currentlook_obj.currentlook_detail();
			
		Assert.assertEquals(detail_text, "Details", "current look verified");	
		
		Favourite_obj.click_addFav();
		
		Thread.sleep(4000);
		
		String Removefav_text = Favourite_obj.click_removeFav();
		
		Assert.assertEquals(Removefav_text, "Remove Fav", "favorite verified");	
		
	}
	
		
}
