package Console.Error;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_Base {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	Random r = new Random();
	
	  public String firstname = "QA"+r.nextInt(100);
	  public String lastname = "test"+r.nextInt(1000);
	  public String email = "Qtest"+r.nextInt(1000)+"@mailinator.com";
	  public String email1 = "Qtest"+r.nextInt(1000)+"@mailinator.com";
	  
	  
	  public Test_Base(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:/Users/m.abdullah/git/Selfie_styler_updated/Selfie_styler/src/test/java/Console/Error/test_data.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	  
	  
		@BeforeTest
		public void setExtent(){
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ConsoleError-Report.html", true);
			extent.addSystemInfo("Host Name", "Muhammad Abdullah");
			extent.addSystemInfo("Environment", "Production");
			
		}
		
		
		@BeforeMethod
		public void setup(){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.abdullah\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		
		}
		
		
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			
			if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
				String screenshotPath = Test_Base.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

			}
			
			
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			driver.quit();
		}
		
		
		
		@AfterTest
		public void endReport(){
			extent.flush();
			extent.close();
		}
		
	/*	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}  */
		
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			String encodedBase64 = null;
			
			FileInputStream fileInputStreamReader = null;
			
			try {
				
			fileInputStreamReader = new FileInputStream(source);
			
			byte[] bytes = new byte[(int)source.length()];
			
			fileInputStreamReader.read(bytes);
			
			encodedBase64 = new String(Base64.encodeBase64(bytes));
			
			} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
			return "data:image/png;base64,"+encodedBase64;
			
			
			
	
			
		   /* String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
			
			*/
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*
	public static void extractJSLogsInfo() throws EmailException
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
			     
			  }
			
			  j++;
			  
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
			
			email.addTo("muhammad.abdullah@selfiestyler.com");
			
			email.send(); 
		
			System.out.println("=========Email Sent============="); 
			
		  
		} */
		
		
	}
	
	
	
	


