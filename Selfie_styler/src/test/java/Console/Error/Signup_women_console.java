package Console.Error;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import com.pages.Women;

public class Signup_women_console extends Test_Base {
	
	public void extractJSLogsInfo() throws EmailException
	{
	  String test= "";
	  
	  int j = 1; 
	  
	  ArrayList arr = new ArrayList();
		
	  LogEntries logEntries =driver.manage().logs().get(LogType.BROWSER);
	  for (LogEntry entry : logEntries)
	  {
		  
		 String Error_Message = new Date(entry.getTimestamp()) + "\n" +"\n" + entry.getLevel() + "\n" + "\n" + entry.getMessage()+"\n";
		 
		  if(Error_Message.contains("SEVERE"))
		  {
		    // System.out.println(Error_Message+"\n");
			  
			 arr.add(j+":"+" "+Error_Message);
			 
			 j++;
		     
		  }
		
		  
	  }		
	  
	 for (int i =0; i<arr.size();i++)
	  {
		 test += arr.get(i) +"\n";
		  
	  }
	 
	 System.out.println(test);
	 
	   System.out.println("=========Test Started=============");
	  
	   Email email = new SimpleEmail();
		
		email.setHostName("smtp.gmail.com");
		
		email.setSmtpPort(465);
		
		email.setAuthenticator(new DefaultAuthenticator("qa.auto.sstyler@gmail.com","Karachi0!"));	
		
		email.setSSLOnConnect(true);
		
		email.setFrom("qa.auto.sstyler@gmail.com");
		
		email.setSubject("Sign up for Women - Console Error");

		email.setMsg(test);
		
		email.addTo(prop.getProperty("email"));
		
		email.send(); 
	
		System.out.println("=========Email Sent============="); 
		
	  
	}  
	


	@Test(priority=1,enabled=true)
	public void signup_women_console_error() throws Exception
	{
	  extentTest = extent.startTest("Signup_women_Console");
	  
	    System.out.println("*************SelfieStyler: Sign up for Women - SelfieStyler******************\n");
	  
	   Women womenobj = new Women(driver);
	
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
	   
	   Thread.sleep(5000);
	   
	   extractJSLogsInfo();
	   

	
	
	}
	
	
}
