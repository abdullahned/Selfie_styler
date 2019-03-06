package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.HighlightLocator;
import Utility.Synchronization;

public class Home {

	WebDriver driver;
	
	public Home(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Dresses") 
	WebElement Dresses;	
	
	@FindBy(linkText="Brands") 
	WebElement Brands;
	
	@FindBy(linkText="My Account") 
	WebElement MyAccount;
	
	@FindBy(linkText="Our Self") 
	WebElement OurSelf;
	
	@FindBy(linkText="Fitting Room") 
	WebElement Fitting_Room;
	
	@FindBy(xpath="//a[@href='https://selfiestyler.com/women/']") 
	WebElement women;
	
	@FindBy(xpath="//a[@href='https://selfiestyler.com/men/']") 
	WebElement men;
	
	@FindBy(xpath="//a[@href='https://selfiestyler.com/blog/']") 
	WebElement Blog;
	
	@FindBy(linkText="Terms & Conditions") 
	WebElement Terms_condition;
	
	@FindBy(linkText="Privacy Policy") 
	WebElement Privacy_policy;
	
	
	public void Click_Dresses() throws Exception   // click the dresses category
	{
		
		Actions action = new Actions(driver);

		action.moveToElement(Dresses).click().perform();
		
	}
	
	
	
	public void Click_Brands() throws Exception   // click the sign up click
	{
		Synchronization.Exception_Handling(driver, Brands, 30);
		
	}
	
	
	public void Click_MyAccount() throws Exception   // click the sign up click
	{
		Synchronization.Exception_Handling(driver, MyAccount, 30);
		
			
	}
	
	
	public void Click_OurSelf() throws Exception   // click the sign up click
	{
		Synchronization.Exception_Handling(driver, OurSelf, 30);
			
	}
	
	
	public void Click_FittingRoom() throws Exception   // click the fitting room click
	{
		Synchronization.Exception_Handling(driver, Fitting_Room, 30);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;
		 
	    jex.executeScript("window.scrollBy(0,500)", "");
	    
	    Thread.sleep(2000);
			
	}
	
	public void Click_women() throws Exception   // click the women click
	{
		Synchronization.Exception_Handling(driver, women, 30);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;
		 
	    jex.executeScript("window.scrollBy(0,500)", "");
	    
	    Thread.sleep(2000);
			
	}
	
	public void Click_men() throws Exception   // click the men click
	{
		Synchronization.Exception_Handling(driver, men, 30);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;
		 
	    jex.executeScript("window.scrollBy(0,500)", "");
	    
	    Thread.sleep(2000);
			
	}
	
	public void Click_Blog() throws Exception   // click the Blog click
	{
		Synchronization.Exception_Handling(driver, Blog, 30);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;
		 
	    jex.executeScript("window.scrollBy(0,500)", "");
	    
	    Thread.sleep(2000);
			
	}
	
	
	public void Click_Terms_condition() throws Exception   // click the Blog click
	{
		JavascriptExecutor jex = (JavascriptExecutor)driver;
		 
	    jex.executeScript("window.scrollBy(0,500)", "");
	    
	    Thread.sleep(2000);
		
		Synchronization.Exception_Handling(driver, Terms_condition, 30);			
	}
	
		
	public void Click_Privacy_policy() throws Exception   // click the Blog click
	{
		JavascriptExecutor jex = (JavascriptExecutor)driver;
		 
	    jex.executeScript("window.scrollBy(0,500)", "");
	    
	    Thread.sleep(2000);
		
		Synchronization.Exception_Handling(driver, Privacy_policy, 30);			
	}
	
	
}
