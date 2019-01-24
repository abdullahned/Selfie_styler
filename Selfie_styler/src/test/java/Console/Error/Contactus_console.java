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

import com.pages.Contactus;
import com.pages.Women;

public class Contactus_console extends Test_Base {

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
		
		email.setSubject("Contact us - Console Error");

		email.setMsg(test);
		
		email.addTo(prop.getProperty("email"));
		
		email.send(); 
	
		System.out.println("=========Email Sent============="); 
			  
	} 
	
	@Test(priority=3, enabled=true)
	public void Contactus_Console_Error () throws Exception
	{
	 extentTest = extent.startTest("Contactus_Console");
	 
	 Women womenobj = new Women(driver);  // create the object of women class
	 
	 Contactus contactusobj = new Contactus(driver); // create the object of contact us class
        
     System.out.println("*************SelfieStyler: Contact us - SelfieStyler******************\n");
     
     contactusobj.click_contactus(); // click the contact us link
	 
	 womenobj.Enter_Firstname(firstname);  // enter the first name
	   
	 womenobj.Enter_Lastname(lastname);  // enter the last name
	   
	 contactusobj.Enter_Email(email1);  // enter the email
	 
	 contactusobj.Enter_comments(); // enter the comments
	 
	 contactusobj.click_submit();  // click the submit button

     extractJSLogsInfo();    

}
		
	
}
