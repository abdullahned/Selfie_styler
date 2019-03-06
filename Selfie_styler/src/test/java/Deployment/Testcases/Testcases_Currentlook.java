package Deployment.Testcases;

import org.testng.annotations.Test;

import com.pages.Home;
import com.pages.Login;

import resources.TestBase;

public class Testcases_Currentlook extends TestBase {

	Login Login_obj; // Login_obj is the object reference variable of Login class
	
	Home Home_obj;
	
	
	@Test
	public void Acceptance_criteria1() throws Exception
	{
		extentTest = extent.startTest("FittingRoom");
		
		Login_obj = new Login(driver);  // create the object of login class 
		
		Home_obj = new Home(driver);
		
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
		Thread.sleep(5000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(5000);
		

	}
	

	
}
