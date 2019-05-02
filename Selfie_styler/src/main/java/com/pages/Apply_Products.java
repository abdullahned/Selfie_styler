package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Synchronization;

public class Apply_Products {

	WebDriver driver;
	
	public Apply_Products(WebDriver ldriver)
	{
	  this.driver=ldriver;
	  PageFactory.initElements(driver, this);
	}
		

	@FindBy(xpath="//a[@class='hanger']") 
	WebElement product_container;
	
	public void click_product_container() throws Exception
	{	
	  
	  Synchronization.Exception_Handling(driver, product_container, 30);
		
	}
	
	

	
}
