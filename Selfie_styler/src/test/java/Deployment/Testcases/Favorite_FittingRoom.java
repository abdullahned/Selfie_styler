package Deployment.Testcases;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import com.pages.*;

public class Favorite_FittingRoom {
	
	Login Login_obj;
	
	Shop_Checkout Shop_Checkout_obj;
	
	Favourite Favourite_obj;
	
	Fitting_Room_Hanger_Icon fitting_hanger;  // fitting_hanger is the object reference variable of Fitting_Room_Hanger_Icon
	
	Fitting_Room_Edit_Look fitting_editlook;
	
	
	@Test(priority=24, enabled=true)
	public void validate_Favorite_FittingRoom() throws Exception
	{
		
		// This will launch browser and specific url 
	   WebDriver driver=BrowserFactory.startBrowser("chrome", "https://selfiestyler.com/login_deactivate");  // live Environment
	   
	   Login_obj = new Login(driver); // create the object of login class
	   
	   Shop_Checkout_obj = new Shop_Checkout(driver); // create the object of shop_checkout class
	   
	   Favourite_obj = new Favourite(driver);  // create the object of favorite class 
	   
	   fitting_hanger = new Fitting_Room_Hanger_Icon(driver); // create the object of fitting_hanger class
	   
	   fitting_editlook = new Fitting_Room_Edit_Look(driver); // create the object of fitting_editlook class
	   
	   Login_obj.login_selfie_styler("qa-women@mailinator.com", "Germany0!");
	   
	   Thread.sleep(5000);
	   
	   Shop_Checkout_obj.click_Women(); // click the women link
	   
	   fitting_hanger.click_hanger();    // click on hanger for product
		
	   Thread.sleep(8000);
		
	   fitting_hanger.click_hanger1();     // click on hanger for product
	   
	   Thread.sleep(5000);
	   
	   Favourite_obj.click_favourite_look();
	   
	//   String text = driver.findElement(By.xpath("//div[@id='modal_content']")).getText();
	   
	 //  System.out.println(text);
	   
	   Thread.sleep(7000);
	   
	   Favourite_obj.click_favourite_product3();
	   
	   Thread.sleep(5000);

	   fitting_editlook.Click_Edit_look();
	   
	   Thread.sleep(5000);	
	   
	   fitting_editlook.Close_edit_popup();
	   
	   Thread.sleep(5000);	   
	   
	   JavascriptExecutor jkl = (JavascriptExecutor)driver;
	
	    jkl.executeScript("window.scrollBy(0,-500)", "");
	    
	    Thread.sleep(5000);
	   
	   Favourite_obj.click_favourite();
	   
	   Thread.sleep(2000);

	   jkl.executeScript("window.scrollBy(0,250)", "");
	   
	   Thread.sleep(5000);
	   
	   Shop_Checkout_obj.click_Women(); // click the women link
	   
       Favourite_obj.click_favourite_look();
	   
	   Thread.sleep(8000);
	  
	   driver.quit();
	   
	   	
		
	}
	
	
	
	

}
