package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Utility.Synchronization;
import Utility.screenshot;



public class Login {

	WebDriver driver;
	
	public Login(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Login')]") 
	WebElement clickLogin; 
	
	@FindBy(id="email") 
	WebElement enterEmail; 
	
	@FindBy(id="password") 
	WebElement enterPassword;
	
	@FindBy(id="customer_login") 
	WebElement submit;
	
	@FindBy(xpath="//div[@id='top_error_para']") 
	WebElement top_error_para;
	
	@FindBy(xpath="//div[@id='bottom_error_para']") 
	WebElement bottom_error_para;
	
	@FindBy(xpath="//div[@id='error_contact_comment']") 
	WebElement error_contact_comment;
	
	
	
	
	
	public void login_selfie_styler(String uid,String pass) throws Exception
	{
	
	// Synchronization.Exception_Handling(driver, clickLogin,30);
	  
	  Synchronization.sendKeys(driver, enterEmail, 30, uid);
	  
	  Synchronization.sendKeys(driver, enterPassword, 30, pass);
	  
	  Synchronization.Exception_Handling(driver, submit, 30);
	  

	}
	
	
	
	public void click_login() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, clickLogin, 30);
			
	}
	
	
	public void enter_email(String mail)
	{
		Synchronization.sendKeys(driver, enterEmail, 30, mail);
		
	}
	
	
	public void enter_password(String password)
	{
		Synchronization.sendKeys(driver, enterPassword, 30, password);
		
	}
	
	
	public void click_submit() throws Exception
	{
		Synchronization.Exception_Handling(driver, submit, 30);
		
	}
	
		
	public String top_error()
	{
		
		String top_Text = top_error_para.getText();
		
		return top_Text;
	}
	
	
	public String bottom_error()
	{
		
		String bottom_Text = bottom_error_para.getText();
		
		return bottom_Text;
		
	}
	

	
	
	
}
