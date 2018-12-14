package Deployment.Testcases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



import Utility.BrowserFactory;
import com.pages.*;

public class MenTest  {

	Random r = new Random();
		
		String firstname = "QA"+r.nextInt(100);
		   String lastname = "test"+r.nextInt(1000);
		   String email = "Qtest"+r.nextInt(1000)+"@mailinator.com";
		   String email1 = "Qtest"+r.nextInt(1000)+"@mailinator.com";
			
		Women womenobj;
		
	//	WebDriver driver;
		
		@Test (priority=1, enabled=true)
		public void validate_men() throws Exception
		{
			//This will launch browser and specific url 
			 WebDriver driver=BrowserFactory.startBrowser("chrome", "https://www.selfiestyler.com/");  // live Environment
			
			//test = reports.createTest("validate_men");
			   
			   womenobj = new Women(driver);  // create the object of women class
				
			   womenobj.Signup_Click(); // click the sign up link
			   
			   womenobj.Enter_Firstname(firstname);  // enter the first name
			   
			   womenobj.Enter_Lastname(lastname);  // enter the last name
			   
			   womenobj.Enter_Email(email);  // enter the email
			   
			   womenobj.Enter_Phone(); // enter phone number
			   
			   womenobj.Enter_Password();  // enter the password
			   
			   womenobj.Enter_Confirm_Password(); // enter the confirm password
			   
			   Thread.sleep(3000);
			   
			   
			   womenobj.men_click(); // click the men radio button
			   
			   Thread.sleep(2000);
			   
			   womenobj.Terms_Click(); // click the terms link
			   
			   Thread.sleep(5000);
			   
			   womenobj.close_Click(); // close the popup
			   
			   womenobj.Click_Terms_checkbox();  // click the terms check box
			    
			   womenobj.Click_register_buttonx(); // click the register button
			   
			   Thread.sleep(8000);
			   
			   womenobj.click_AppleButton(); // click the apple button
			   
			   Thread.sleep(5000);
			   
			   driver.quit();
			
		}
	
	
}
