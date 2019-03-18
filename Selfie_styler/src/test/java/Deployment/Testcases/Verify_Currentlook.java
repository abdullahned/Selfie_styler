package Deployment.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Favourite;
import com.pages.Fittingroom_Currentlook;
import com.pages.Home;
import com.pages.Login;

import resources.TestBase;

public class Verify_Currentlook extends TestBase {


	@Test(priority=1, enabled=false)
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
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		Thread.sleep(2000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		String detail_text = Fittingroom_Currentlook_obj.currentlook_detail();
		
		Thread.sleep(2000);
			
		Assert.assertEquals(detail_text, "Details", "current look verified");	
		
	}
	

	@Test(priority=2, enabled=true)
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
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		Thread.sleep(2000);
		
		String detail_text = Fittingroom_Currentlook_obj.currentlook_detail();
			
		Assert.assertEquals(detail_text, "Details", "current look verified");	
		
		Favourite_obj.click_addFav();
		
		Thread.sleep(6000);
		
		String Removefav_text = Favourite_obj.click_Currentlook_remove_fav();
		
		System.out.println(Removefav_text);
		
		Assert.assertEquals(Removefav_text, "Remove Fav", "favorite verified");			
	}
	

	@Test(priority=3, enabled=false)
	public void Acceptance_criteria_3() throws Exception
	{
		extentTest = extent.startTest("Fitting Room Current Look AC#3");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
			
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);
		
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_product_slide();
		
		Thread.sleep(2000);
		
		String detail_text = Fittingroom_Currentlook_obj.currentlook_detail();
			
		Assert.assertEquals(detail_text, "Details", "current look verified");	
		
		Fittingroom_Currentlook_obj.click_currentlook_detail();
		
         String additem_tocart = Fittingroom_Currentlook_obj.additem_tocart();
		
		Assert.assertEquals(additem_tocart, "Add item to cart", "Add to cart button is available");
	
	}
		
	@Test(priority=4, enabled=false)
	public void Acceptance_criteria_4() throws Exception
	{
		extentTest = extent.startTest("Fitting Room Current Look AC#4");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
			
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);
		
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		
		Home_obj.Click_Dresses();
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(3000);
		
        Fittingroom_Currentlook_obj.search_product();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='bc-sf-search-box-0']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.select_color();
		
		Thread.sleep(5000);	
	}
	
	@Test(priority=5, enabled=false)
	public void Acceptance_criteria_5() throws Exception
	{
		extentTest = extent.startTest("Fitting Room Current Look AC#5");
		
		Login Login_obj = new Login(driver); 
			
		Home Home_obj = new Home(driver);
			
		Fittingroom_Currentlook Fittingroom_Currentlook_obj = new Fittingroom_Currentlook(driver);

		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000);
		
		Fittingroom_Currentlook_obj.click_hanger();
		
		Thread.sleep(2000);
		
		String detail_text = Fittingroom_Currentlook_obj.currentlook_detail();
		
		Thread.sleep(2000);
			
		Assert.assertEquals(detail_text, "Details", "current look verified");
		
		Fittingroom_Currentlook_obj.click_add_to_cart();
		
		Thread.sleep(2000);
		
		String badge_number = Fittingroom_Currentlook_obj.get_cart_count();
		   
		System.out.println("\n"+badge_number);
		     
		Assert.assertTrue(badge_number.contains("1"));
		
	}
	
	
}
