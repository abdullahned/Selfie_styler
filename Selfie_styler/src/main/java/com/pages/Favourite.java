package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Utility.Synchronization;
import Utility.screenshot;

public class Favourite {
	
	WebDriver driver;
	
	public Favourite(WebDriver ldriver)
	{
	  this.driver=ldriver;
	  PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(xpath="//a[@data-fav='add']") 
	WebElement Add_fav;
	
	@FindBy(xpath="//a[@data-fav='remove']") 
	WebElement Currentlook_remove_fav;
	
	
	@FindBy(xpath="//a[@id='favorite_look_heart']") 
	WebElement Remove_Fav;
	
	@FindBy(xpath="//a[@id='favorite_look_heart']")
	WebElement favourite_look;
	
	@FindBy(xpath="//a[@id='share_look_link']") 
	WebElement Share_look;
	
	@FindBy(xpath="//a[@id='facebook_share_button']") 
	WebElement facebook;
	
	@FindBy(xpath="//a[@id='twitter_share_button']") 
	WebElement twitter;
	
	@FindBy(xpath="//a[@id='pinterest_share_button']") 
	WebElement pinterest;
	

	
	@FindBy(xpath="//*[@data-product-id='1481625010230']") // need to change if products change
	WebElement favourite_product1;
	
	@FindBy(xpath="//*[@data-product-id='529753866294']") // need to change if products change 
	WebElement favourite_product2;
	
	@FindBy(xpath="//*[@data-product-id='529753374774']") // need to change if products change 
	WebElement favourite_product3;
	
	
	@FindBy(xpath="//a[contains(text(),'Favorites')]") 
	WebElement favourite;
	
	@FindBy(xpath="//a[@class='fav-remove-list btn-remove-wishlist']") 
	WebElement remove_prod;
	
	@FindBy(xpath="//a[@class='btn add-to-cart-btn']") 
	WebElement accept_prod;
	
	
	public void click_addFav() throws Exception
	{	
	  
	  Synchronization.Exception_Handling(driver, Add_fav, 30);
		
	}
	
	
	public String click_removeFav() throws Exception
	{
      String Remove_Fav_text = Remove_Fav.getText();
		
	  return Remove_Fav_text;
	  
	}
	
	public void click_fittingroom_fav() throws Exception
	{
	    	
	  // Synchronization.Exception_Handling(driver, favourite_look, 30);
		
		//favourite_look.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", favourite_look);
	    	
	}
	
	public String get_fittingroom_fav() throws Exception
	{
		String fittingroom_fav = Remove_Fav.getAttribute("data-fav");
		
		return fittingroom_fav;    
	    	
	}
	
	
	public String click_Currentlook_remove_fav() throws Exception
	{	
	  
		String Remove_Fav_text = Currentlook_remove_fav.getText();
		
		return Remove_Fav_text;
		
	}
	
	
	public void click_sharelook() throws Exception
	{	
	  
	  Synchronization.Exception_Handling(driver, Share_look, 30);
		
	}
	
	public String validate_facebook() throws Exception
	{	
	  String facebook_text = facebook.getText();
		
	   return facebook_text;		
	}
	
	public String validate_twitter() throws Exception
	{	
	  String twitter_text = twitter.getText();
		
	   return twitter_text;		
	}
	
	
	public String validate_pinterest() throws Exception
	{	
	  String pinterest_text = pinterest.getText();
		
	   return pinterest_text;		
	}
	

	
	public void click_favourite() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, favourite, 30);
	}

	
	public void click_favourite_product1() throws Exception
	{
       
		Synchronization.Exception_Handling(driver, favourite_product1, 30);
		
		Thread.sleep(3000);
		
	
	}
	
	
	public void click_favourite_product2() throws Exception
	{
			
		Synchronization.Exception_Handling(driver, favourite_product2, 30);
		
		Thread.sleep(3000);
		

		
	}
	
	
	public void click_favourite_product3() throws Exception
	{

		
		Synchronization.Exception_Handling(driver, favourite_product3, 30);
		
		Thread.sleep(3000);
		
		
	}
	
	
	
	public void click_remove_product() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, remove_prod, 30);
		
		
	}
	
	
	public void click_accept_product() throws Exception
	{
	
		Synchronization.Exception_Handling(driver, accept_prod, 30);
	}
	
	
	public void switch_to_alert()
	{
		
        Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		String text = alert.getText();
		
		if(text.equals("Are you sure you want to remove?")){
			System.out.println("correct alert messg");
			
			alert.accept();
		}
		
		else{
			System.out.println("in-correct alert messg");
			
			alert.dismiss();
		}
		
		
	}
	
	
}
