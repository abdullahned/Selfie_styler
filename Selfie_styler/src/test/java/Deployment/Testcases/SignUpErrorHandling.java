package Deployment.Testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Utility.BrowserFactory;
import com.pages.*;

public class SignUpErrorHandling {

	 WebDriver driver;
	
	
Random r = new Random();
	
	String firstname = "QA"+r.nextInt(100);
	   String lastname = "test"+r.nextInt(1000);
	   String email = "Qtest"+r.nextInt(1000)+"@mailinator.com";
	   String email1 = "Qtest"+r.nextInt(1000)+"@mailinator.com";
	
	  // ExtentHtmlReporter htmlReports;
	  // ExtentReports extent;
	  // ExtentTest test;

	   Women womenobj;
	   
	   
	   @Test (priority =2,enabled=true)
	
	public void InvalidEmail() throws Exception                     // Invalid email , Invalid password , Terms not check
	{
		//ExtentTest test = extent.createTest("Invalid Email for Sign Up");
		 
	    // test.log(Status.INFO, "User has entered Invalid Email for Sign Up");
		
		
		
		//This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/");  // live Environment
		   
		womenobj = new Women(driver);  // create the object of women class
		
		womenobj.Signup_Click(); // click the sign up link
		 
		 womenobj.Enter_Firstname(firstname);  // enter the first name
		   
		 womenobj.Enter_Lastname(lastname);  // enter the last name
		 
		 womenobj.Enter_Email("abc.com");  // enter the email
		 
		 womenobj.Enter_Phone(); // enter phone number
		 
		 womenobj.Enter_Password_Invalid(); // enter invalid password
		 
		 womenobj.Enter_Confirm_Password_Invalid(); // enter ivalid confirm password
		
		 womenobj.Click_register_buttonx(); // click the register button
		 
		 JavascriptExecutor jq = (JavascriptExecutor)driver;
			
		jq.executeScript("window.scrollBy(0,-500)", "");
			
		Thread.sleep(3000);
			
		String top_error = driver.findElement(By.xpath("//div[@id='top-error']")).getText();
		
		System.out.println(top_error);
		
		
		String error_mem_email = driver.findElement(By.xpath("//div[@id='error_mem_email']")).getText();
			
        String error_mem_password = driver.findElement(By.xpath("//div[@id='error_mem_password']")).getText();
		
		
		String error_terms = driver.findElement(By.xpath("//div[@id='error_terms']")).getText();
		
		Assert.assertTrue(top_error.contains("Looks like something went wrong"));
		
		Assert.assertTrue(top_error.contains("Email address is not valid"));
		
		Assert.assertTrue(top_error.contains("Password is not valid"));
		
		Assert.assertTrue(top_error.contains("Read Terms and Privacy Policy not checked"));
		
		
		Assert.assertTrue(error_mem_email.contains("Please enter a valid email address"));
		
		Assert.assertTrue(error_mem_password.contains("Please enter a valid password."));
		
		Assert.assertTrue(error_terms.contains("Please check that you have read our Terms and Privacy Policy."));
		
		
		driver.quit();
		
	}
	
	   //(priority =1,enabled=true) 
	 
  @Test  (priority =3,enabled=true)                                   // Missing field, Password do not match

   public void PasswordNotMatch () throws Exception
  {
	 
	 // ExtentTest test = extent.createTest("Missing fields and passwords do not match");
		 
	 // test.log(Status.INFO, "User has entered mismatched password and missed some fields");
	  
	//This will launch browser and specific url 
	  WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/");  // live Environment
	  
	  womenobj = new Women(driver);  // create the object of women class
	  
	  womenobj.Signup_Click();
	  
	//  womenobj.select_gender(); // select the gender
		 
	  womenobj.Enter_Firstname(firstname);  // enter the first name
		   
	  womenobj.Enter_Lastname(lastname);  // enter the last name
		
	  womenobj.Enter_Phone(); // enter phone number
	
	  womenobj.Enter_Password(); // enter password
	  
	  womenobj.Enter_Confirm_Password_Invalid(); // enter invalid password
	  
	  womenobj.Click_Terms_checkbox(); // click terms check box
	  
	  womenobj.Click_register_buttonx(); // click the register button
		 
	  JavascriptExecutor jq = (JavascriptExecutor)driver;
			
	  jq.executeScript("window.scrollBy(0,-500)", "");
			
	  Thread.sleep(3000);
			
	  String top_error = driver.findElement(By.xpath("//div[@id='top-error']")).getText();
		
	  System.out.println(top_error);
	  
	  String error_confirm_mem_password = driver.findElement(By.xpath("//div[@id='error_confirm_mem_password']")).getText();
	  
	  String error_all_fields = driver.findElement(By.xpath("//div[@id='error_all_fields']")).getText();
	  
	  Assert.assertTrue(top_error.contains("Looks like something went wrong"));
		
	  Assert.assertTrue(top_error.contains("Passwords do not match"));
		
	  Assert.assertTrue(top_error.contains("Missing required fields"));
		
	  Assert.assertTrue(error_confirm_mem_password.contains("Passwords entered do not match."));
		
	  Assert.assertTrue(error_all_fields.contains("Please fill out all required fields"));
	 
	 
	  
	 driver.quit();
	  
  
   }
	

	
}
