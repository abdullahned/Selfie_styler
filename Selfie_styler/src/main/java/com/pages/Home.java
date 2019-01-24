package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Synchronization;

public class Home {

	WebDriver driver;
	
	public Home(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Brands") 
	WebElement Brands;
	
	@FindBy(linkText="My Account") 
	WebElement MyAccount;
	
	@FindBy(linkText="Our Self") 
	WebElement OurSelf;
	
	@FindBy(linkText="Fitting Room") 
	WebElement Fitting_Room;
	
	@FindBy(linkText="Women") 
	WebElement women;
	
	@FindBy(linkText="Men") 
	WebElement men;
	
	@FindBy(linkText="Blog") 
	WebElement Blog;
	
	
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
			
	}
	
	public void Click_women() throws Exception   // click the women click
	{
		Synchronization.Exception_Handling(driver, women, 30);
			
	}
	
	public void Click_men() throws Exception   // click the men click
	{
		Synchronization.Exception_Handling(driver, men, 30);
			
	}
	
	public void Click_Blog() throws Exception   // click the Blog click
	{
		Synchronization.Exception_Handling(driver, Blog, 30);
			
	}
	
}
