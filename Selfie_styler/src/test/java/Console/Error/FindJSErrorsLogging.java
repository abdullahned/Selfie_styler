package Console.Error;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Login;

public class FindJSErrorsLogging {

	public WebDriver driver;
	
	Login Login_obj;
	
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		LoggingPreferences loggingpreferences = new LoggingPreferences();
		loggingpreferences.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingpreferences);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.abdullah\\Downloads\\chromedriver.exe");
		
		driver = new ChromeDriver(capabilities); // launch chrome	
		
	    //driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
		
	}
	
	public void extractJSLogsInfo()
	{
	  LogEntries logEntries =driver.manage().logs().get(LogType.BROWSER);
	  for (LogEntry entry : logEntries)
	  {
		  System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage()+"\n");
		  
	  }		
		
	}
	
	
	  @Test
	    public void testMethod() throws Exception {
	       
	      System.out.println("*************SelfieStyler: Shop the latest fashion with our Virtual Fitting Room******************\n");
	      
	      driver.get("http://www.selfiestyler.com");
	      
	      Thread.sleep(2000);
	      
	      extractJSLogsInfo();
	      
	      Thread.sleep(1000);
	      
	      System.out.println("*************SelfieStyler: Login - SelfieStyler******************\n");
	      
	      Login_obj = new Login(driver);  // create the object of login class 
	
	      Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");   

	       Thread.sleep(10000);
	        
	       extractJSLogsInfo();
	        
	       Thread.sleep(3000);
	       
	        driver.findElement(By.linkText("Brands")).click();
	        
	        System.out.println("*************Brands Page******************\n");
	        
	        Thread.sleep(3000);
	        
	        extractJSLogsInfo();
	        
            driver.findElement(By.linkText("My Account")).click();
	        
	        System.out.println("*************My Account Page******************\n");
	        
	        extractJSLogsInfo();
	        
           driver.findElement(By.linkText("Our Self")).click();
	        
	        System.out.println("*************Our Self Page******************\n");
	        
	        Thread.sleep(3000);
	        
	        extractJSLogsInfo();
	        
	        
	    }
	
	
	
	
	
	
}
