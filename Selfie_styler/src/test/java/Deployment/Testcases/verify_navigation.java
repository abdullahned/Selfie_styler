package Deployment.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Favourite;
import com.pages.Fittingroom_Currentlook;
import com.pages.Home;
import com.pages.Login;
import com.pages.Navigation;

import resources.TestBase;

public class verify_navigation extends TestBase {
	
	@Test(priority=1, enabled=true)
    public void Acceptance_criteria_1() throws Exception
	{
	   extentTest = extent.startTest("Navigation AC#1");
	   
	   Login Login_obj = new Login(driver);
	   
	   Navigation Navigation_obj = new Navigation(driver);
	   
	   Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
	   
	   Navigation_obj.click_dropdown_toggle();
	   
	   Thread.sleep(3000);
	   
	   String brands = Navigation_obj.get_brands();
		
	   Assert.assertEquals(brands, "Brands", "Brands verified");
	   
	   String blogs = Navigation_obj.get_blogs();
		
	   Assert.assertEquals(blogs, "Blog", "Blogs verified");
	   
	   String help = Navigation_obj.get_Help();
		
	   Assert.assertEquals(help, "Help / FAQs", "Help/FAQs verified");
	   
	   String privacy_policy = Navigation_obj.get_privacy_policy();
		
	   Assert.assertEquals(privacy_policy, "Privacy Policy", "privacy policy verified");
	   
	   String Terms_condition = Navigation_obj.get_Terms_condition();
		
	   Assert.assertEquals(Terms_condition, "Terms & Conditions", "Terms condition verified");
	   
	   String Contact_us = Navigation_obj.get_Contact_us();
		
	   Assert.assertEquals(Contact_us, "Contact Us", "Contact Us verified");
	   
	   Thread.sleep(4000);
	  
}
	

	@Test(priority=2, enabled=true)
    public void Acceptance_criteria_2() throws Exception
	{
		extentTest = extent.startTest("Navigation AC#2");
		   
		Login Login_obj = new Login(driver);
		   
		Navigation Navigation_obj = new Navigation(driver);
		   
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Navigation_obj.search_product();
		
		driver.findElement(By.xpath("//input[@id='bc-sf-search-box-1']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);

	}
	
	@Test(priority=3, enabled=true)
    public void Acceptance_criteria_3() throws Exception
	{
		extentTest = extent.startTest("Navigation AC#3");
		   
		Login Login_obj = new Login(driver);
		   
		Navigation Navigation_obj = new Navigation(driver);
		
		Home Home_obj = new Home(driver);
		   
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
        Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(2000);

		Navigation_obj.click_notification();
		
	   String notification = Navigation_obj.get_notification();
			
	   Assert.assertEquals(notification, "No notifications.", "Notification verified");
	
	   Navigation_obj.click_notification();	
	}
	
	
	@Test(priority=4, enabled=true)
    public void Acceptance_criteria_4() throws Exception
	{
		extentTest = extent.startTest("Navigation AC#4");
		   
		Login Login_obj = new Login(driver);
		   
		Navigation Navigation_obj = new Navigation(driver);
		
		Home Home_obj = new Home(driver);
		
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);
		
		Favourite Favourite_obj = new Favourite(driver);
		   
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
        Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_hanger();
		
		Thread.sleep(2000);
		
		Favourite_obj.click_sharelook();
		
		Thread.sleep(4000);
		
		Favourite_obj.click_facebook();
		
		Thread.sleep(2000);
		
		Navigation_obj.switch_to_other_page();	
	}
	
	
	@Test(priority=5, enabled=true)
    public void Acceptance_criteria_5() throws Exception
	{
		extentTest = extent.startTest("Navigation AC#5");
		
		Navigation Navigation_obj = new Navigation(driver);
		
		Navigation_obj.switch_to_facebook();
	
	}
	
	@Test(priority=6, enabled=true)
    public void Acceptance_criteria_6() throws Exception
	{
		extentTest = extent.startTest("Navigation AC#6");
		
		Login Login_obj = new Login(driver);
		
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);
		
		Home Home_obj = new Home(driver);
		
		Navigation Navigation_obj = new Navigation(driver);
		
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Home_obj.Click_Dresses();
		
        Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
        Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_hanger();
		
		Fittingroom_Currentlook_obj.click_add_to_cart();
		
		Thread.sleep(2000);
		
		Navigation_obj.click_shopping_cart();
		
		Thread.sleep(2000);
		
		Navigation_obj.click_view_cart();
		
		Thread.sleep(1000);
		
		Navigation_obj.click_shopping_cart();
		
		Thread.sleep(1000);
		
		Navigation_obj.click_checkout();
		
		Thread.sleep(4000);
		
		String continue_shopping = Navigation_obj.continue_shopping();
		
		Assert.assertEquals(continue_shopping, "Continue to shipping method", "continue shopping verified");		  
	}
	
	
	@Test(priority=7, enabled=true)
    public void Acceptance_criteria_7() throws Exception
	{
		extentTest = extent.startTest("Navigation AC#7");
		
		Login Login_obj = new Login(driver);
		
		Navigation Navigation_obj = new Navigation(driver);
		
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Navigation_obj.click_profile();
		
		Thread.sleep(1000);
		
		Navigation_obj.click_Personal_information();
		
		Thread.sleep(2000);
		
        String personal_information = Navigation_obj.get_personal_information();
		
		Assert.assertEquals(personal_information, "Personal information", "personal_information verified");
		
	
	
	}
	
	

}