package Deployment.Testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pages.Apply_Products;
import com.pages.Home;
import com.pages.Login;

import resources.TestBase;

public class verify_products extends TestBase {
	
	String qwer = "";
	
	@Test
	public void validate_product() throws Exception
	{
		extentTest = extent.startTest("Verification of products");
		
		Login Login_obj = new Login(driver); 
		
		Home Home_obj = new Home(driver);
		
		Apply_Products Apply_Products_obj = new Apply_Products(driver);
		
        Login_obj.login_selfie_styler("erin@selfiestyler.com","Test1234");
		
		Thread.sleep(3000);
		
		Home_obj.Click_Dresses();
		
		Thread.sleep(2000);
		
		Home_obj.close_tutorial_popup();
		
		Thread.sleep(4000);
		
		
	//	List<WebElement> linkElement = driver.findElements(By.xpath("//div[@id='bc-sf-filter-products']//div[@class='fr_product_container']//div[@class='fitting_room_product_box']"));
		
		// String linkElement1 = linkElement.toString();
		 
        // System.out.println(linkElement1);
		
		 ArrayList arr = new ArrayList();
		
		List<WebElement> abc = driver.findElements(By.xpath("//a[@class='hanger']"));
	
		  
		  for (WebElement Productlist : abc) {
				if(Productlist.getAttribute("id") != null)
				{
					arr.add(Productlist);
				}
	
			}
		  
		  for (int i =0; i<arr.size();i++)
		  {
			 qwer += arr.get(i) +"\n";
			  
		  }
		 
		 System.out.println(qwer);
		
		
		
		
		
		
		
	}
	


}
