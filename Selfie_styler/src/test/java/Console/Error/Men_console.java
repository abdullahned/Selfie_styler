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

import com.pages.Home;

public class Men_console extends Test_Base {

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
	 
	 if(test.contains("SEVERE"))
	 
	 { System.out.println("=========Test Started=============");
	  
	   Email email = new SimpleEmail();
		
		email.setHostName("smtp.gmail.com");
		
		email.setSmtpPort(465);
		
		email.setAuthenticator(new DefaultAuthenticator("qa.auto.sstyler@gmail.com","Karachi0!"));	
		
		email.setSSLOnConnect(true);
		
		email.setFrom("qa.auto.sstyler@gmail.com");
		
		email.setSubject("Men scenario - Console Error");

		email.setMsg(test);
		
		email.addTo(prop.getProperty("email"));
		
		email.send(); 
	
		System.out.println("=========Email Sent============="); }
		
	  
	}  
	
	@Test(priority=6, enabled=true)
	public void Men_Console_Error () throws Exception
	{
	 extentTest = extent.startTest("Men_Console");
	 
	 Home homeobj = new Home(driver);  
	 
     System.out.println("*************SelfieStyler: Men - SelfieStyler******************\n");
     
     homeobj.Click_men();
     
     extractJSLogsInfo();    

}
	
}
