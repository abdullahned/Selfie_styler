package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	
	
	public TestBase()
	{
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("C://Users//m.abdullah//git//Selfie_styler_updated//Selfie_styler//src//main//java//resources//configuration.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Newdesign-Report.html", true);
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
			
			String screenshotPath = TestBase.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			
			// extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.);

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
	
	
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	

	
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
		
		
	}
	
	
}
