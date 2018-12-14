package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Synchronization;

public class CancelSignup {
	
WebDriver driver;
	
	public CancelSignup(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@class,'cancel_button')]") 
	WebElement cancel_button;
	
	
	public void click_cancelsignup() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, cancel_button, 30);
		
	}
	

}
