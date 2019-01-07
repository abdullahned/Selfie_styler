package Deployment.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Signin_Errorhandling {

	Login loginobj;
	
	Forgot_Password Forgot_Password_obj;

	
	@Test(priority =6,enabled=true)  
	public void Invalidcrdentials() throws Exception
	{
		//This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
		
		loginobj = new Login(driver);
		
		//loginobj.click_login();
		
		loginobj.enter_email("abc@gmail.com");
		
		loginobj.enter_password("Germany0!");
		
		loginobj.click_submit();
		
		Thread.sleep(6000);
		
		String top_error_message = loginobj.top_error();
		
		System.out.println(top_error_message);
		
		String bottom_error_message = loginobj.bottom_error();
		
		System.out.println(bottom_error_message);
		
		 Assert.assertTrue(top_error_message.contains("Looks like something went wrong"));
			
		 Assert.assertTrue(top_error_message.contains("User name and/or password is not valid"));
		 
		 Assert.assertTrue(bottom_error_message.contains("Please enter valid user name and password."));
		 
		 driver.quit();
		
	}
	
	@Test(priority =7,enabled=true)  
	
	public void InvalidEmail() throws Exception
	{
		
		//This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
		
		loginobj = new Login(driver); // create object of login class
		
		Forgot_Password_obj = new Forgot_Password(driver); // create object of forgot password class
		
		//loginobj.click_login();
		
		Forgot_Password_obj.Click_forgot();
		
		loginobj.enter_email("abc.com");
		
		Forgot_Password_obj.click_request_password_button();
		
		Thread.sleep(6000);
		
		String top_error_message = loginobj.top_error();
		
		System.out.println(top_error_message);
		
		String bottom_error_message = loginobj.bottom_error();
		
		System.out.println(bottom_error_message);
		
		Assert.assertTrue(top_error_message.contains("Looks like something went wrong"));
			
		Assert.assertTrue(top_error_message.contains("Email address is not valid."));
		 
	   Assert.assertTrue(bottom_error_message.contains("Please enter valid email address."));
	   
	   driver.quit();	
				
	}
	
	@Test(priority =8,enabled=true)  
	
	public void EmailNotFound() throws Exception
	{
		//This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
		
		loginobj = new Login(driver); // create object of login class
		
		Forgot_Password_obj = new Forgot_Password(driver); // create object of forgot password class
		
		//loginobj.click_login();
		
		Forgot_Password_obj.Click_forgot();
		
		loginobj.enter_email("abc@mailinator.com");
		
		Forgot_Password_obj.click_request_password_button();
		
		Thread.sleep(6000);
		
		String top_error_message = loginobj.top_error();
		
		System.out.println(top_error_message);
		
		String bottom_error_message = loginobj.bottom_error();
		
		System.out.println(bottom_error_message);
		
		Assert.assertTrue(top_error_message.contains("Looks like something went wrong"));
			
		Assert.assertTrue(top_error_message.contains("Email address not found."));
		 
	   Assert.assertTrue(bottom_error_message.contains("Sorry, we could not find an account for this email."));
	   
	   driver.quit();	
		
	}
	
	
	@Test(priority =9,enabled=true)
	
	public void InvalidPwdCriteria() throws Exception
	{
		
		//This will launch browser and specific url 
		   WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
		   
		   Forgot_Password_obj = new Forgot_Password(driver); // create the object of forgot password class
		   
		   loginobj = new Login(driver); // create the object of login class
		   
		// loginobj.click_login(); // click the login link
		   
		   Forgot_Password_obj.Click_forgot(); // click the forgot password link
			
		   loginobj.enter_email("qa-women@mailinator.com"); // enter the email to get the forgot password link
		   
		   Forgot_Password_obj.click_request_password_button(); // click the reset button
		   
		   Forgot_Password_obj.mailinator(); //open the mailinator url
		   
		   Forgot_Password_obj.inboxfield_mailinator("qa-women@mailinator.com"); // enter the email in mailinator
		   
		   Forgot_Password_obj.btn_mailinator(); // click the go button
		   
		   Forgot_Password_obj.open_email(); // open the email
		   
		   Thread.sleep(6000);
			 
		   driver.switchTo().frame("msg_body");  // move into the email
			 
		  Thread.sleep(4000);
		   
		   Forgot_Password_obj.email_button();  // click the button which is in email
		   
		   Forgot_Password_obj.switch_to_other_page("America","America");
		   
		   
		   Thread.sleep(8000);
		   
		   
		   String top_error_message = loginobj.top_error();
			
			System.out.println(top_error_message);
			
			String bottom_error_message = loginobj.bottom_error();
			
			System.out.println(bottom_error_message);   
		   
		  Assert.assertTrue(top_error_message.contains("Looks like something went wrong"));
				
		  Assert.assertTrue(top_error_message.contains("Password is not valid."));
				 
		  Assert.assertTrue(bottom_error_message.contains("Please enter valid password."));
		  
		  driver.quit();
	
		
	}
	
	
	@Test(priority =10,enabled=true)
	public void PasswordNotMatched() throws Exception
	{
		//This will launch browser and specific url 
		   WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
		   
		   Forgot_Password_obj = new Forgot_Password(driver); // create the object of forgot password class
		   
		   loginobj = new Login(driver); // create the object of login class
		   
		  //loginobj.click_login(); // click the login link
		    
		   Forgot_Password_obj.Click_forgot(); // click the forgot password link
			
		   loginobj.enter_email("qa-women@mailinator.com"); // enter the email to get the forgot password link
		   
		   Forgot_Password_obj.click_request_password_button(); // click the reset button
		   
		   Forgot_Password_obj.mailinator(); //open the mailinator url
		   
		   Forgot_Password_obj.inboxfield_mailinator("qa-women@mailinator.com"); // enter the email in mailinator
		   
		   Forgot_Password_obj.btn_mailinator(); // click the go button
		   
		   Forgot_Password_obj.open_email(); // open the email
		   
		   Thread.sleep(6000);
			 
		   driver.switchTo().frame("msg_body");  // move into the email
			 
		  Thread.sleep(4000);
		   
		   Forgot_Password_obj.email_button();  // click the button which is in email
		   
		   Forgot_Password_obj.switch_to_other_page("Pakistan0!","Pakistan");
		   
		   
		   Thread.sleep(8000);
		   
		   
		   String top_error_message = loginobj.top_error();
			
			System.out.println(top_error_message);
			
			String bottom_error_message = loginobj.bottom_error();
			
			System.out.println(bottom_error_message);   
		   
		  Assert.assertTrue(top_error_message.contains("Looks like something went wrong"));
				
		  Assert.assertTrue(top_error_message.contains("Passwords entered do not match."));
				 
		  Assert.assertTrue(bottom_error_message.contains("Passwords must match."));
		  
		  driver.quit();
	
	
		
		
		  
	}
	
	

}
