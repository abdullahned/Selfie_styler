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

import com.pages.Login;

public class Login_Console extends Test_Base {
	
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
		
		email.setSubject("Login scenario - Console Error");

		email.setMsg(test);
		
		email.addTo("wali@selfiestyler.com");
		
		email.send(); 
	
		System.out.println("=========Email Sent============="); 
		
	  
	}  
	
	@Test(priority=0, enabled=true)
	public void Login_Console_Error () throws Exception
	{
	 extentTest = extent.startTest("Login_Console");
	 
	 Login Login_obj = new Login(driver);
        
     System.out.println("*************SelfieStyler: Login - SelfieStyler******************\n");

     Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");   

     Thread.sleep(5000);
     
     extractJSLogsInfo();    

}

}