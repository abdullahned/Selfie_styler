package Deployment.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Contactus_Errorhandling {
	
	Contactus contactobj;

	@Test(priority =12,enabled=true)  
	
	public void Missing_Fields() throws Exception
	{
		//This will launch browser and specific url 
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/");  // live Environment
		
		contactobj = new Contactus(driver);
		
		contactobj.click_contactus(); // click the contact us link
		
		contactobj.click_submit(); // click the submit button
		
		String Actual_error = contactobj.error_container();
		
		String email_error = contactobj.error_contact_email();
		
		String comment_error = contactobj.error_contact_comment();
		
		String expect = "Looks like something went wrong\n" + 
				"Please enter valid email address\n" + "Please leave a comment";
		
		Assert.assertTrue(Actual_error.contains("Looks like something went wrong"));
		
		 Assert.assertTrue(Actual_error.contains("Please enter valid email address"));
		 
		 Assert.assertTrue(Actual_error.contains("Please leave a comment"));
		 
		 Assert.assertEquals(Actual_error, expect);
		
         Assert.assertTrue(email_error.contains("Please enter valid email address"));
		 
		 Assert.assertTrue(comment_error.contains("Please leave a comment"));
		
		 driver.quit();
		 
	}
	

}
