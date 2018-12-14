package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Utility.HighlightLocator;
import Utility.Synchronization;
import Utility.screenshot;

public class FittingRoomPopup {

	WebDriver driver;
	  
	public FittingRoomPopup(WebDriver ldriver)
	{
		
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="//span[@class='down']") 
	WebElement down;
	
	@FindBy(xpath="//span[@class='up']") 
	WebElement up;
	
	
	public void click_down() throws Exception
	{
		Synchronization.Exception_Handling(driver, down, 30);       // minimize the demo model popup
     	
		Thread.sleep(2000);
		
	}
	
	
	public void click_up() throws Exception
	{
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;          // To scroll down the page 
		 
	    jex.executeScript("window.scrollBy(0,-500)", "");
			
		Synchronization.Exception_Handling(driver, up, 30);       // maximize the demo model popup
     	
		Thread.sleep(2000);	
	}
	
	

	
	
}
