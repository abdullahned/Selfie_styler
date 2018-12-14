package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Utility.Synchronization;
import Utility.screenshot;


public class Fitting_Room_Hanger_Icon {

	WebDriver driver;
	
	public Fitting_Room_Hanger_Icon(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}
	
   
	@FindBy(xpath="//a[@id='1206']") 
	WebElement productdetail_hanger;
	
	
	@FindBy(xpath="//a[@id='1740']") 
	WebElement hanger;
	
	@FindBy(xpath="//a[@id='1206']") 
	WebElement hanger1;
	
	@FindBy(xpath="//div[@class='toolbar']") 
	WebElement random;
	
	
	public void click_productdetail_hanger()
	{
		productdetail_hanger.click();
		
	}
	

	
	public void click_hanger () throws Exception	
	{
		
		//Synchronization.clickOn(driver, hanger, 30);
		
		hanger.click();
	
	}
	
	
	public void click_hanger1 () throws Exception	
	{
			
		
		//Synchronization.click_explicitly(driver, hanger1, 30);
		
		hanger1.click();
					
	}
	
	
	
	public void clickRandom()
	{
		
	Actions action = new Actions(driver);

	action.moveToElement(random).click().perform();
			
		
	}
	
	
	public String verify_hanger_clicked()
	{
		String text = productdetail_hanger.getAttribute("class");
		return text;
		
	}
	
	


	
}
