package Deployment.Testcases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Contactus {

	 Random r = new Random();
		
		String firstname = "QA"+r.nextInt(100);
		   String lastname = "test"+r.nextInt(1000);
		   String email1 = "Qtest"+r.nextInt(1000)+"@mailinator.com";
			
		
		Women womenobj;
		
		Contactus contactusobj;
		
		@Test(priority =11,enabled=true)  
		public void validate_contactus() throws Exception
		{
			
		// This will launch browser and specific url 
		 WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/");  // live Environment
		 
		 womenobj = new Women(driver);  // create the object of women class
		 
		 contactusobj = new Contactus(driver); // create the object of contact us class
		 
		 contactusobj.click_contactus(); // click the contact us link
		 
		 womenobj.Enter_Firstname(firstname);  // enter the first name
		   
		 womenobj.Enter_Lastname(lastname);  // enter the last name
		   
		 contactusobj.Enter_Email(email1);  // enter the email
		 
		 contactusobj.Enter_comments(); // enter the comments
		 
		 contactusobj.click_submit();  // click the submit button
		 
		 driver.quit(); // close the browser
			
			
			
		}
		
		
		
		
		
	
}
