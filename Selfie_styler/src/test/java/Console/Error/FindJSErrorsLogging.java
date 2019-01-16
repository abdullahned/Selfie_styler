package Console.Error;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Home;
import com.pages.Login;



public class FindJSErrorsLogging {

	public WebDriver driver;
	
	Login Login_obj;
	
	Home Home_obj;
	
	ArrayList arr = new ArrayList();
	
	String test= "";
	 
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		LoggingPreferences loggingpreferences = new LoggingPreferences();
		loggingpreferences.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingpreferences);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.abdullah\\Downloads\\chromedriver.exe");
		
		driver = new ChromeDriver(capabilities); // launch chrome

		driver.manage().window().maximize(); //maximize window
			
		driver.manage().deleteAllCookies(); //delete all the cookies
		
		
	    //driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws EmailException
	{
		if(ITestResult.SUCCESS ==result.getStatus())	  
		{
			//Send_Email_Script.SendEmail();		
		  }
		
		driver.quit();
		
	}
	
	public void extractJSLogsInfo() throws EmailException
	{
	  LogEntries logEntries =driver.manage().logs().get(LogType.BROWSER);
	  for (LogEntry entry : logEntries)
	  {
		  
		 String Error_Message = new Date(entry.getTimestamp()) + "\n" +"\n" + entry.getLevel() + "\n" + "\n" + entry.getMessage()+"\n";
		 
		  if(Error_Message.contains("SEVERE"))
		  {
		    // System.out.println(Error_Message+"\n");
			  
			 arr.add(Error_Message); 
		     
		  }
		
	  }		
	  
	 for (int i =0; i<arr.size();i++)
	  {
		 test += arr.get(i) +"\n";
		 
		 // System.out.println(arr.get(i));
		  
	  }
	 
	 System.out.println(test);
	 
	   System.out.println("=========Test Started=============");
	  
	   Email email = new SimpleEmail();
		
		email.setHostName("smtp.gmail.com");
		
		email.setSmtpPort(465);
		
		email.setAuthenticator(new DefaultAuthenticator("qa.auto.sstyler@gmail.com","Karachi0!"));	
		
		email.setSSLOnConnect(true);
		
		email.setFrom("qa.auto.sstyler@gmail.com");
		
		email.setSubject("Login scenario Console Error");

		email.setMsg(test);
		
		email.addTo("webfeedback@selfiestyler.com");
		
		email.send(); 
	
		System.out.println("=========Email Sent============="); 
	  
	}
	
	
	
	  @Test
	    public void testMethod() throws Exception {
	       
	      System.out.println("*************SelfieStyler: Shop the latest fashion with our Virtual Fitting Room******************\n");
	      
	      driver.get("http://www.selfiestyler.com");
	      
	      Thread.sleep(2000);
	      
	  //    extractJSLogsInfo();
	      
	      Thread.sleep(1000);
	      
	      Login_obj = new Login(driver);
	      
	      Home_obj = new Home(driver);
	         
	      System.out.println("*************SelfieStyler: Login - SelfieStyler******************\n");
	
	      Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");   

	       Thread.sleep(10000);
	        
	       extractJSLogsInfo();
	        
	       Thread.sleep(3000);
	       
	    /*    Home_obj.Click_Brands();
	        
	        System.out.println("*************Brands Page******************\n");
	        
	        Thread.sleep(3000);
	        
	        extractJSLogsInfo();
	        
	        Home_obj.Click_MyAccount();
	        
	        System.out.println("*************My Account Page******************\n");
	        
	        Thread.sleep(3000);
	        
	        extractJSLogsInfo();
	        
	        Home_obj.Click_OurSelf();
	        
	        System.out.println("*************Our Self Page******************\n");
	        
	        Thread.sleep(3000);
	        
	        extractJSLogsInfo();
	        
	        */
	    }
	

	
}
