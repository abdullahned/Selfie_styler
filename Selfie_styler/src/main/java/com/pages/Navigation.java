package com.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Synchronization;

public class Navigation {
	
WebDriver driver;
	
	public Navigation(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//button[@class='dropdown-toggle menu_dropdown_btn']") 
	WebElement dropdown_toggle;
	
	@FindBy(xpath="//a[@id='discover_modal_trigger']") 
	WebElement brands;
	
	@FindBy(xpath="//a[@href='https://www.selfiestyler.com/blog']") 
	WebElement blogs;
	
	@FindBy(xpath="//a[@href='/pages/selfiestyler-faq-s']") 
	WebElement Help;
		
	@FindBy(xpath="//a[@href='/pages/selfiestyler-privacy-policy']") 
	WebElement privacy_policy;
	
	@FindBy(xpath="//a[@href='/pages/selfiestyler-terms-conditions']") 
	WebElement Terms_condition;
	
	@FindBy(xpath="//a[@href='/pages/contact-us']") 
	WebElement Contact_us;
	
	@FindBy(xpath="//input[@id='bc-sf-search-box-1']") 
	WebElement search_field;
	
	@FindBy(xpath="//div[@class='fr_secondary_menu_notification']") 
	WebElement notification;
	
	@FindBy(xpath="//li[@class='no_notification']") 
	WebElement no_notification;
	
	@FindBy(xpath="//input[@id='email']") 
	WebElement facebook_email;
	
	@FindBy(xpath="//input[@id='pass']") 
	WebElement facebook_password;
	
	@FindBy(xpath="//input[@id='u_0_0']") 
	WebElement facebook_submit;
	
	@FindBy(xpath="//input[@id='u_0_2']") 
	WebElement web_facebook_submit;
	
	@FindBy(xpath="//button[@id='u_0_24']") 
	WebElement Post_to_facebook;
	
	@FindBy(xpath="//*[text()='Furqan']") 
	WebElement facebook_profile;
	
	@FindBy(xpath="//a[@class='_52c6']") 
	WebElement facebook_selfie_share;
	
	@FindBy(xpath="//img[@class='shopping_cart_icon']") 
	WebElement shopping_cart_icon;
	
	@FindBy(xpath="//a[text()='View Cart']") 
	WebElement view_cart;
	
	@FindBy(xpath="//button[text()='Checkout']") 
	WebElement checkout;
	
	@FindBy(xpath="//button[@id='continue_button']") 
	WebElement continue_to_shopping;
	
	@FindBy(xpath="//img[@class='myaccount_wrapper_icon profile_picture']") 
	WebElement profile;
	
	@FindBy(xpath="//a[text()='Personal information']") 
	WebElement Personal_information;
	
	@FindBy(xpath="//div[@class='col-md-12 col-sm-12 page_header boder_none']") 
	WebElement get_personal;
	
	
	
	public void click_dropdown_toggle() throws Exception
	{
	  
	  Synchronization.Exception_Handling(driver, dropdown_toggle, 30);	
		
	}
	
	public String get_brands()
	{
	   String brands_text = brands.getText();
	   
		return brands_text;
	}
	
	public String get_blogs()
	{
	   String blogs_text = blogs.getText();
	   
		return blogs_text;
	}
	
	public String get_Help()
	{
	   String Help_text = Help.getText();
	   
		return Help_text;
	}
	
	public String get_privacy_policy()
	{
	   String privacy_policy_text = privacy_policy.getText();
	   
		return privacy_policy_text;
	}
	
	public String get_Terms_condition()
	{
	   String Terms_condition_text = Terms_condition.getText();
	   
		return Terms_condition_text;
	}
	
	public String get_Contact_us()
	{
	   String Contact_us_text = Contact_us.getText();
	   
		return Contact_us_text;
	}
	

	public void search_product() throws Exception
	{
		
	  Synchronization.sendkey(driver, search_field, 30, "Keepsake V-neck Tee");
		
	}
	
	public void click_notification() throws Exception
	{
		
	  Synchronization.Exception_Handling(driver, notification, 30);	
		
	}
	
	public String get_notification()
	{
	   String notifcation_text = no_notification.getText();
	   
		return notifcation_text;
	}
	
	
	public void switch_to_other_page() throws Exception
	{
		
		String parent_window= driver.getWindowHandle();
		 
		Set<String> s1=driver.getWindowHandles();
		
		Iterator<String> i1=s1.iterator();
		
		while (i1.hasNext())
		{
			String child_window = i1.next();
			
			if(!parent_window.equalsIgnoreCase(child_window))
			{
				driver.switchTo().window(child_window);
				
				Synchronization.sendkey(driver, facebook_email, 30, "qa.auto.sstyler@gmail.com");
				
				Thread.sleep(2000);
				
				 Synchronization.sendkey(driver, facebook_password, 30, "Karachi0!");
				
				Thread.sleep(1000);
				
				Synchronization.Exception_Handling(driver, facebook_submit, 30);	
				
				Thread.sleep(5000);
				
				Synchronization.Exception_Handling(driver, Post_to_facebook, 30);	
				
				Thread.sleep(2000);
  		
	}
		
}
	}
	
	
	public void switch_to_facebook() throws Exception
	{
		driver.get("https://www.facebook.com/");

	   	   JavascriptExecutor js = (JavascriptExecutor)driver;
		
		   js.executeScript("arguments[0].click();", facebook_email);
	       
		 //  facebook_email.sendKeys("qa.auto.sstyler@gmail.com");
		   
	      Synchronization.sendkey(driver, facebook_email, 30, "qa.auto.sstyler@gmail.com");
		
		  Synchronization.sendkey(driver, facebook_password, 30, "Karachi0!");
		   
		  Thread.sleep(4000);
		   
		   Synchronization.Exception_Handling(driver, web_facebook_submit, 30);
		   
		   Synchronization.Exception_Handling(driver, facebook_profile, 30);
		   
		   Thread.sleep(2000);
		   
		   Synchronization.Exception_Handling(driver, facebook_selfie_share, 30);
		   
		   Thread.sleep(4000);
	
	}
	
	public void click_shopping_cart() throws Exception
	{
		
	  Synchronization.Exception_Handling(driver, shopping_cart_icon, 30);	
		
	}
	
	public void click_view_cart() throws Exception
	{
		
	  Synchronization.Exception_Handling(driver, view_cart, 30);	
		
	}
	
	public void click_checkout() throws Exception
	{
		
	  Synchronization.Exception_Handling(driver, checkout, 30);	
		
	}
	
	public String continue_shopping()
	{
	   String shopping_method = continue_to_shopping.getText();
	   
		return shopping_method;
	}
	
	
	public void click_profile() throws Exception
	{
		
	  Synchronization.Exception_Handling(driver, profile, 30);	
		
	}

	public void click_Personal_information() throws Exception
	{
		
	  Synchronization.Exception_Handling(driver, Personal_information, 30);	
		
	}

	
	public String get_personal_information()
	{
	   String personal_infomation_text = get_personal.getText();
	   
		return personal_infomation_text;
	}
	
	
	
}
