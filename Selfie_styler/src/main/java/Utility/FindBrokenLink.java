package Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Home;
import com.pages.Login;

import Utility.GetReponseCode;

public class FindBrokenLink {
	
	
	WebDriver driver;
	
	// It will open the browser & Application before Test
	@BeforeTest
	public void openBrowser() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.abdullah\\Downloads\\chromedriver.exe");
		  
		driver = new ChromeDriver();
		
		//To maximize the Window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//To Open the Application
		driver.get("http://www.selfiestyler.com/login-deactivate");
		
	
	    
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.close();
	}
	
	@Test
	 public void getBrokenLinks() throws Exception {
		
       Login Login_obj = new Login(driver);
		
		Home Home_obj = new Home(driver);
		
		Login_obj.login_selfie_styler("test-monika.horvat@selfiestyler.com", "12345678Aa");
		
        Thread.sleep(5000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000); 
		
		
		
		 // Find all Elements on the page with 'a' tag
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		 
		 System.out.println("Total Number of Links : " +allLinks.size());
		 
		 //Iterate over all available Links on webpage
		 for (WebElement link : allLinks) {
			String linkURL = link.getAttribute("href");
			
			//Call VerifyURL form GetResponse Code Class
			GetReponseCode.verifyUrl(linkURL);
		}
		 
		 System.out.println("Total Number of Links : " +allLinks.size());
		 GetReponseCode.getInvalidLinkCount(); 
	}
	

}
