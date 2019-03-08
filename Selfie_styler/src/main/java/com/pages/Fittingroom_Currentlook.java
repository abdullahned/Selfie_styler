package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Synchronization;

public class Fittingroom_Currentlook {
	
	WebDriver driver;
	
	public Fittingroom_Currentlook(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="//button[@class='fitting_room_next_btn']") 
	WebElement product_slide;
	
	@FindBy(xpath="//a[@class='fitting_room_cl_prod_link']") 
	WebElement currentlook_detail;
	
	
	public void click_product_slide() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, product_slide, 30);	

	}
	
	
	public String currentlook_detail()
	{
		
		String Detail = currentlook_detail.getText();
		
		return Detail;
	}
	
	
	
}
