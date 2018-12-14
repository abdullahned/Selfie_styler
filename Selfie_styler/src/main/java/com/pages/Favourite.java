package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Synchronization;

public class Favourite {
	
	WebDriver driver;
	
	public Favourite(WebDriver ldriver)
	{
	  this.driver=ldriver;
	  PageFactory.initElements(driver, this);
	}
				
	@FindBy(xpath="//a[@id='favorite_look_heart']") // need to change if products change
	WebElement favourite_look;
	
	@FindBy(xpath="//*[@data-product-id='1481625010230']") // need to change if products change
	WebElement favourite_product1;
	
	@FindBy(xpath="//*[@data-product-id='529753866294']") // need to change if products change 
	WebElement favourite_product2;
	
	@FindBy(xpath="//*[@data-product-id='529753374774']") // need to change if products change 
	WebElement favourite_product3;
	
	@FindBy(xpath="//*[@data-product-id='1484878413878']") // need to change if products change
	WebElement men_favourite_product1;
	
	@FindBy(xpath="//*[@data-product-id='1484887916598']") // need to change if products change 
	WebElement men_favourite_product2;
	
	@FindBy(xpath="//*[@data-product-id='1484894142518']") // need to change if products change 
	WebElement men_favourite_product3;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Favorites')]") 
	WebElement favourite;
	
	@FindBy(xpath="//a[@class='fav-remove-list btn-remove-wishlist']") 
	WebElement remove_prod;
	
	@FindBy(xpath="//a[@class='btn add-to-cart-btn']") 
	WebElement accept_prod;
	
	
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
	
	
    public void click_favourite_look() throws Exception
    {
    	
    	Synchronization.Exception_Handling(driver, favourite_look, 30);
    	
    }
	
	
}
