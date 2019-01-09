package com.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pages.Women;

import Utility.BrowserFactory;

public class women extends FreeCRMTest {

	Women womenobj;
	
	@Test(priority=0,enabled=true)
	public void validate_women() throws Exception
	{
		   extentTest = extent.startTest("validate_women");
		
		   womenobj = new Women(driver);  // create the object of women class
			
		   womenobj.Signup_Click(); // click the sign up link
		   
		   womenobj.Enter_Firstname(firstname);  // enter the first name
		   
		   womenobj.Enter_Lastname(lastname);  // enter the last name
		   
		   womenobj.Enter_Email(email);  // enter the email
		   
		   womenobj.Enter_Phone(); // enter phone number
		   
		   womenobj.Enter_Password();  // enter the password
		   
		   womenobj.Enter_Confirm_Password(); // enter the confirm password
		   
		   Thread.sleep(3000);
		   
		   
		   womenobj.women_click(); // click the women radio button
		   
		   Thread.sleep(2000);
		   
		   womenobj.Terms_Click(); // click the terms link
		   
		   Thread.sleep(5000);
		   
		   womenobj.close_Click(); // close the popup
		   
		   womenobj.Click_Terms_checkbox();  // click the terms check box
		    
		   womenobj.Click_register_buttonx(); // click the register button
		   
		   Thread.sleep(8000);
		   
		   womenobj.click_AppleButton(); // click the apple button
		   
		   Thread.sleep(5000);
		  
		
	}
}
