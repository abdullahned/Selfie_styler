package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import Utility.HighlightLocator;
import Utility.Synchronization;
import Utility.screenshot;

public class Women {
	
WebDriver driver;
	
	public Women(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign up')]") 
	WebElement signup;
	
	@FindBy(id="gender") 
	WebElement gender;
	
	@FindBy(id="first_name") 
	WebElement first_name;
	
	@FindBy(id="last_name") 
	WebElement last_name;
	
	@FindBy(id="mem_email") 
	WebElement email;
	
	@FindBy(id="phone") 
	WebElement phone;
	
	@FindBy(id="mem_password") 
	WebElement mem_password;
	
	@FindBy(id="confirm_mem_password") 
	WebElement confirm_mem_password;
	
	@FindBy(xpath="//img[@src='https://selfiestyler.com/wp-content/img/female-model.jpg']") 
	WebElement RadioFemale;
	
	@FindBy(xpath="//img[@src='https://selfiestyler.com/wp-content/img/male-model-small.jpg']") 
	WebElement RadioMale;
	
	
	@FindBy(xpath="//a[contains(text(),'Terms')]") 
	WebElement Terms;
	
	@FindBy(xpath="//button[contains(@class,'close')]") 
	WebElement Close;
	
	@FindBy(id="terms_checkbox") 
	WebElement terms_checkbox;
	
	@FindBy(id="register_button") 
	WebElement register_button;
	
	@FindBy(xpath="//img[@alt='Apple Store Button']") 
	WebElement AppleButton;
	
	public void Signup_Click() throws Exception   // click the sign up click
	{
		Synchronization.Exception_Handling(driver, signup, 30);
		
			
	}
	
	public void select_gender()    // select the gender
	{
		HighlightLocator.highLightElement(driver, gender);
		 
		Select select = new Select(gender);
		
		select.selectByVisibleText("Female");
				
	}
	
	public void Enter_Firstname(String fname)   // enter the first name
	{
		//first_name.sendKeys(fname);
		
		Synchronization.sendKeys(driver, first_name, 30, fname);
			
	}
	
	
	public void Enter_Lastname(String lname)   // enter the last name
	{
		
		Synchronization.sendKeys(driver, last_name, 30, lname);
			
	}
	
	public void Enter_Email(String mail)   // enter email
	{
		
		Synchronization.sendKeys(driver, email, 30, mail);
			
	}
	

	public void Enter_Phone()   // enter phone no.
	{
		
		Synchronization.sendKeys(driver, phone, 30, "0213578965");
			
	}
	
	
	public void Enter_Password()   // enter password
	{
		
		Synchronization.sendKeys(driver, mem_password, 30, "Pakistan0!");
			
	}
	
	public void Enter_Confirm_Password()   // enter confirm password
	{
	
		Synchronization.sendKeys(driver, confirm_mem_password, 30, "Pakistan0!");
			
	}
	
	

	public void Enter_Password_Invalid()   // enter password
	{
		
		Synchronization.sendKeys(driver, mem_password, 30, "Pakistan");
			
	}
	
	public void Enter_Confirm_Password_Invalid()   // enter confirm password
	{
	
		Synchronization.sendKeys(driver, confirm_mem_password, 30, "Pakistan");
			
	}
	
	
	public void women_click() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, RadioFemale, 50);		
		
		//RadioFemale.click();
	}
	
	
	public void men_click() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, RadioMale, 30);
				
	}
	


	public void Terms_Click() throws Exception   // click the Terms click
	{
		
		Synchronization.Exception_Handling(driver, Terms, 30);
		
	}
	
	public void close_Click() throws Exception   // click the close popup
	{
	
		
		Synchronization.Exception_Handling(driver, Close, 30);
		
	
	}
	
	
	public void Click_Terms_checkbox() throws Exception   // click the terms check box
	{
		
		
		Synchronization.Exception_Handling(driver, terms_checkbox, 30);
		
	}
		
	public void Click_register_buttonx() throws Exception   // click the register button
	{
	
		
		Synchronization.Exception_Handling(driver, register_button, 30);
			
	}
	
	public void click_AppleButton() throws Exception
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,-500)", "");
		
		Thread.sleep(2000);
		
		Synchronization.Exception_Handling(driver, AppleButton, 30);		
		
	}
	
	
	

	

}
