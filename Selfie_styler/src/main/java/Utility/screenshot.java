package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


public class screenshot {
	
	public static WebDriver driver;
	
	public static void capturescreenshot (WebDriver driver, String screenshotname)
	
	{
		
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			 File source =ts.getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(source, new File("C:\\Users\\m.abdullah\\git\\Selfie_styler_updated\\Selfie_styler\\Failed-testcase-screenshots\\"+screenshotname+".png"));

		}
           catch (Exception e) {
			
        	   
		System.out.println("Exception while taking screenshot" +e.getMessage());
			                   
           }
		
		
		
		}
	
	public static void teardown(ITestResult result) 
	  {
		  
		  if(ITestResult.FAILURE ==result.getStatus())
			  
		  {
			  screenshot.capturescreenshot(driver, result.getName());
		  }
		  
		  
	  }
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
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
	}
	
	
}

	