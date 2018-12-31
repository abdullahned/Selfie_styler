package Send.Email.selenium;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Send_Email_Script {
	
	public static void SendEmail() throws EmailException
	{
		
       System.out.println("Server Started");
		
		Email email = new SimpleEmail();
		
		email.setHostName("smtp.office365.com");
		email.setSmtpPort(587);

		email.setAuthentication("m.abdullah@selfiestyler.com", "Karachi0!");
		
		email.setSSLOnConnect(false);
		email.setTLS(true);
		email.setFrom("m.abdullah@selfiestyler.com");
		email.setSubject("Execution Result of Testcases");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("m.abdullah@selfiestyler.com");
		email.send(); 
		
		
		System.out.println("Email Sent");
	}

}
