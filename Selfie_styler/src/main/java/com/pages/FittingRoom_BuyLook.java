package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Utility.Synchronization;
import Utility.screenshot;

public class FittingRoom_BuyLook {
	
    WebDriver driver;
	
	public FittingRoom_BuyLook(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@id ='buy_the_look_button']") 
	WebElement Buy_look;
	
	
	public void Click_Buy_look() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, Buy_look, 30);
	}
	



}
