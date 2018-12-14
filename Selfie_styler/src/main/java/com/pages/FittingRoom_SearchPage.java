package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Utility.Synchronization;
import Utility.screenshot;

public class FittingRoom_SearchPage {
	

	WebDriver driver;
	
	public FittingRoom_SearchPage(WebDriver ldriver)
	{
		
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@class='input-group-field']") 
    WebElement search;
	
	
	@FindBy(xpath="//button[@class='btn btn-search']") 
    WebElement search_button;
	
	
	@FindBy(xpath="//header[@class='page-header']") 
    WebElement verify;
	
	
	
	
	public void search_text() throws Exception
	{
	    boolean b1 = search.isDisplayed();
		System.out.println(b1); //true
			
	    boolean b2 = search.isEnabled();
	    System.out.println(b2); //false
				
		JavascriptExecutor executor = (JavascriptExecutor)driver;
				
		executor.executeScript("arguments[0].click();", search);	
		
		executor.executeScript("arguments[1].value = arguments[0]; ", "Lush Clothing", search); 
		
	
	}
	
	
	public void click_search() throws Exception
	{
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", search_button);
	
	}
	
	
	public String verify_searchtext()
	{
	  
		String text = verify.getText();
		
		return text;
	}

	


	
}
