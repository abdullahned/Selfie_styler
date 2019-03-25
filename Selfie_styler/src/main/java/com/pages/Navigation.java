package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


}
