package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Utility.Synchronization;
import Utility.screenshot;

public class Contactus {
	
WebDriver driver;
	
	public Contactus(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Contact')]") 
	WebElement Contact;
	
	
	@FindBy(xpath="//textarea[@id='comments']") 
	WebElement comments;
	
	@FindBy(xpath="//button[@id='contact_submit']") 
	WebElement contact_submit;
	
	@FindBy(id="email") 
	WebElement email;
	
	@FindBy(xpath="//div[@id='contact_us_err_container']") 
	WebElement contact_us_err_container;
	
	@FindBy(xpath="//div[@id='error_contact_email']") 
	WebElement error_contact_email;
	
	@FindBy(xpath="//div[@id='error_contact_comment']") 
	WebElement error_contact_comment;
	
	

	public void click_contactus() throws Exception
	{
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;
		 
	     jex.executeScript("window.scrollBy(0,500)", "");
	     
	     Thread.sleep(2000);
	     
	     Synchronization.Exception_Handling(driver, Contact, 30);
	
	}
	
	
	public void Enter_Email(String mail)   // enter email
	{
		
		Synchronization.sendKeys(driver, email, 30, mail);
			
	}
	
	
	
	public void Enter_comments()
	{
		Synchronization.sendKeys(driver, comments, 30, "Please Let me know !!");
		
	}
	
	
	public void click_submit () throws Exception
	{
	
		Synchronization.Exception_Handling(driver, contact_submit, 30);
		
		Thread.sleep(2000);
		      
	    JavascriptExecutor nu = (JavascriptExecutor)driver;
			 
		nu.executeScript("window.scrollBy(0,-500)", "");
		     
		Thread.sleep(8000);
					
	}
	
	
	public String error_container()
	{
		
		String Error_Text = contact_us_err_container.getText();
		
		return Error_Text;
					
	}
	
	
	public String error_contact_email()
	{
		
		String Error_Text = error_contact_email.getText();
		
		return Error_Text;
					
	}
	
	
	public String error_contact_comment()
	{
		
		String Error_Text = error_contact_comment.getText();
		
		return Error_Text;
					
	}
	
	

	

	}
	


