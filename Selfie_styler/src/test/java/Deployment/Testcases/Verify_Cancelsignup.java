package Deployment.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Verify_Cancelsignup {

	
	Women womenobj;
	
	CancelSignup cancelobj;
	
	
	@Test(priority =13,enabled=true)  
	public void validate_cancelsignup() throws Exception
	{
		
		// This will launch browser and specific url 
		   WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/");  // live Environment
		   
		   womenobj = new Women(driver);  // create the object of women class
		   
		   cancelobj = new CancelSignup(driver);  // create the object of cancel signup class
		   
		   womenobj.Signup_Click(); // click the sign up link
		   
		   Thread.sleep(3000);
			 
		   JavascriptExecutor jss = (JavascriptExecutor)driver;
			 
		   jss.executeScript("window.scrollBy(0,500)", "");
		   
		   womenobj.Terms_Click(); // click the terms link
		   
		   Thread.sleep(5000);
		   
		   womenobj.close_Click(); // close the popup
		   
		   Thread.sleep(5000);
		   
		   cancelobj.click_cancelsignup(); // click the cancel signup
		   
		   Thread.sleep(3000);
		
		   driver.quit();  // close the browser
		   
		   
	}
	
	
	
	
	
	
	
	
}
