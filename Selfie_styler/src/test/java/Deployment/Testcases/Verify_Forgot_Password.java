package Deployment.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Forgot_Password {
	
	Forgot_Password Forgot_Password_obj;
	
	Login Login_obj;
	
	@Test(priority =5,enabled=true)  
	public void validate_forgot_password() throws Exception
	{
	// This will launch browser and specific url 
	   WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login-deactivate/");  // live Environment
	   
	   Forgot_Password_obj = new Forgot_Password(driver); // create the object of forgot password class
	   
	   Login_obj = new Login(driver); // create the object of login class
	   
	 //  Login_obj.click_login(); // click the login link
	   
	   Forgot_Password_obj.Click_forgot(); // click the forgot password link
		
	   Login_obj.enter_email("qa-women@mailinator.com"); // enter the email to get the forgot password link
	   
	   Forgot_Password_obj.click_request_password_button(); // click the reset button
	   
	   Forgot_Password_obj.mailinator(); //open the mailinator url
	   
	   Forgot_Password_obj.inboxfield_mailinator("qa-women@mailinator.com"); // enter the email in mailinator
	   
	   Forgot_Password_obj.btn_mailinator(); // click the go button
	   
	   Forgot_Password_obj.open_email(); // open the email
	   
	   Thread.sleep(6000);
		 
	   driver.switchTo().frame("msg_body");  // move into the email
		 
	  Thread.sleep(4000);
	   
	   Forgot_Password_obj.email_button();  // click the button which is in email
	   
	   Forgot_Password_obj.switch_to_other_page("Germany0!","Germany0!");
	      
	   Thread.sleep(8000);
	   
	   Login_obj.click_login(); // click the login link
	
	   Thread.sleep(5000);
	   
	   driver.quit();
	   
	   
	}
	
	
	
	
	

}
