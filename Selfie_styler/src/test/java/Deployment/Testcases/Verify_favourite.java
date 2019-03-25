package Deployment.Testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.*;

import resources.TestBase;

public class Verify_favourite extends TestBase {
	
	@Test(priority=1, enabled=true)
	public void Acceptance_criteria_1() throws Exception
	{
        extentTest = extent.startTest("Fitting Room Favourite AC#1");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
		
		Favourite Favourite_obj = new Favourite(driver);
			
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);

		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_hanger();
		
		Thread.sleep(4000);
		
		Favourite_obj.click_fittingroom_fav();
		
		Thread.sleep(4000);
		
		String fav_prod = Favourite_obj.get_fittingroom_fav();
		
		System.out.println(fav_prod);
		
		Assert.assertEquals(fav_prod, "remove", "favorite verified");
		
		Thread.sleep(4000);
		
		Favourite_obj.click_fittingroom_fav();
		
		String remove_fav_prod = Favourite_obj.get_fittingroom_fav();
		
		Assert.assertEquals(remove_fav_prod, "remove", "favorite verified");
		
		Thread.sleep(2000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		Thread.sleep(2000);
		
		String notfav_prod = Favourite_obj.get_fittingroom_fav();
		
		Assert.assertEquals(notfav_prod, "add", "favorite verified");
		
	}
	
	
	@Test(priority=2, enabled=true)
	public void Acceptance_criteria_2() throws Exception
	{
        extentTest = extent.startTest("Fitting Room Favourite AC#2");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
		
		Favourite Favourite_obj = new Favourite(driver);
			
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);

		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_hanger();
		
		Thread.sleep(4000);
		
		Favourite_obj.click_sharelook();
		
		Thread.sleep(4000);
		
		String facebook = Favourite_obj.validate_facebook();
		
		Assert.assertEquals(facebook, "Facebook", "facebook verified");
		
        String twitter = Favourite_obj.validate_twitter();
		
		Assert.assertEquals(twitter, "Twitter", "twitter verified");
		
        String pinterest = Favourite_obj.validate_pinterest();
		
		Assert.assertEquals(pinterest, "Pinterest", "pinterest verified");
		
		

	}

}
