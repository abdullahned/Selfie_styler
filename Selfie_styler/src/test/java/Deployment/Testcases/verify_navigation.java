package Deployment.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

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
	   
	   Thread.sleep(2000);
	  
}
	


}