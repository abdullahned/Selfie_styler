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
	
	@FindBy(xpath="//input[@id='username_or_email']") 
	WebElement twitter_email;
	
	@FindBy(xpath="//input[@id='password']") 
	WebElement twitter_password;
	
	@FindBy(xpath="//input[@class='button selected submit']") 
	WebElement twitter_submit;
	
	@FindBy(xpath="//input[@id='email']") 
	WebElement facebook_email;
	
	@FindBy(xpath="//input[@id='pass']") 
	WebElement facebook_password;
	
	@FindBy(xpath="//input[@id='u_0_0']") 
	WebElement facebook_submit;
	
	@FindBy(xpath="//input[@id='u_0_2']") 
	WebElement web_facebook_submit;
	
	
	//button[starts-with(@id,'pd_add_cart_btn_')]
	
	@FindBy(xpath="//button[@id='u_0_24']") 
	WebElement Post_to_facebook;
	
	
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
	
	
	public void Enter_twitter_email() throws Exception
	{
		
	  Synchronization.sendkey(driver, twitter_email, 30, "qa.auto.sstyler@gmail.com");
		
	}
	
	public void Enter_twitter_password() throws Exception
	{
		
	  Synchronization.sendkey(driver, twitter_password, 30, "Karachi0!");
		
	}
	
	public void click_twitter_submit() throws Exception
	{
		
	  Synchronization.Exception_Handling(driver, twitter_submit, 30);	
		
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
				
				Map<String, Object> prefs = new HashMap<String, Object>();
	              
                // Set the notification setting it will override the default setting
		        prefs.put("profile.default_content_setting_values.notifications", 2);
  
                // Create object of ChromeOption class
		        ChromeOptions options = new ChromeOptions();
 
                // Set the experimental option
		         options.setExperimentalOption("prefs", prefs);
 
                // pass the options object in Chrome driver
 
		       WebDriver driver = new ChromeDriver(options);
		       
		       driver.get("https://www.facebook.com/");
		       
		   	   JavascriptExecutor js = (JavascriptExecutor)driver;
			
			   js.executeScript("arguments[0].click();", facebook_email);
		       
			   facebook_email.sendKeys("qa.auto.sstyler@gmail.com");
			   
		     //  Synchronization.sendkey(driver, facebook_email, 30, "qa.auto.sstyler@gmail.com");
			
			   Synchronization.sendkey(driver, facebook_password, 30, "Karachi0!");
			   
			   Synchronization.Exception_Handling(driver, web_facebook_submit, 30);
			   
			   
				
			
						
				
	}
		
}
	}


	
}
