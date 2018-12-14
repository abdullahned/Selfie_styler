package com.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import Utility.HighlightLocator;
import Utility.Synchronization;
import Utility.screenshot;

public class Shop_Checkout {
	
	WebDriver driver;
			
	public Shop_Checkout(WebDriver ldriver)
	{
	  this.driver=ldriver;
	  PageFactory.initElements(driver, this);
	}
			
	@FindBy(linkText="Shop") 
	WebElement shop;
	
	@FindBy(linkText="Women") 
	WebElement Women;
	
	@FindBy(linkText="Men") 
	WebElement Men;
	
	
	@FindBy(xpath="//button[@class='btn']") 
    WebElement CHK;
	
		
	@FindBy(xpath="//a[@class='product-grid-image']") 
    WebElement product_detail;
	
	@FindBy(xpath="//input[@id='product-add-to-cart']") 
    WebElement add_to_cart;
	
	@FindBy(xpath="//span[@id='cartCount']") 
    WebElement cartCount;
	
	@FindBy(xpath="//button[@class ='btn-secondary btn-go-to-cart']")
	WebElement go_to_Cart;
	
	@FindBy(xpath="//p[@class ='success-message btn-go-to-cart']")
	WebElement go_to_Cart_message;
	
	
	@FindBy(xpath="//input[@name='checkout']") 
    WebElement checkout;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_address1']") 
    WebElement checkout_shipping_address;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_city']") 
    WebElement checkout_shipping_address_city;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_province']") 
    WebElement checkout_shipping_address_province;
	
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_zip']") 
    WebElement checkout_shipping_address_zip;
	
	@FindBy(xpath="//*[contains(text(),'Continue to shipping method')]") 
    WebElement continue_to_shipping_method;
	
	@FindBy(xpath="//*[contains(text(),'Continue to payment method')]") 
    WebElement continue_to_payment_method;
	
	@FindBy(xpath="//span[@class='fit_count']") 
    WebElement fit_count;
	
	@FindBy(xpath="//input[@value='Add to fitting room']") 
    WebElement add_to_fitting_room;
	
	@FindBy(xpath="//input[@value='Remove from fitting room']") 
    WebElement remove_from_fitting_room;
	
	@FindBy(xpath="//span[@class='up']") 
	WebElement up;
	
	
	public void click_Women() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, Women, 30);
		
		Thread.sleep(3000);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;          // To scroll down the page 
		 
	    jex.executeScript("window.scrollBy(0,300)", "");
		
		Thread.sleep(8000);					
	}
	
	
	
	public void click_men() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, Men, 30);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;          // To scroll down the page 
		 
	    jex.executeScript("window.scrollBy(0,300)", "");
		
		Thread.sleep(8000);					
	}
	
	
	public void click_product_Detail() throws Exception
	{
	   
		Synchronization.Exception_Handling(driver, product_detail, 30);
		
	}
	
	
	public void click_add_to_cart() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, add_to_cart, 30);
	
	}
	
	
	public void click_go_to_cart() throws Exception
	{
	    
	    boolean b1 = go_to_Cart.isDisplayed();
		System.out.println(b1); //true
	
		boolean b2 = go_to_Cart.isEnabled();
		System.out.println(b2); //false
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", go_to_Cart);    
		
		
	}
	
	
	public void click_checkout() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, checkout, 30);
	}
	
	
	
	public void click_checkout_shipping_address() throws Exception
	{
		
		Synchronization.sendKeys(driver, checkout_shipping_address, 30, "Test");
				
	}
	
	
	public void click_checkout_shipping_address_city() throws Exception
	{
		
		Synchronization.sendKeys(driver, checkout_shipping_address_city, 30, "Chicago");
				
	}
	
	
	public void click_checkout_shipping_address_state() throws Exception
	{
		
		HighlightLocator.highLightElement(driver, checkout_shipping_address_province);
		 
		Select select = new Select(checkout_shipping_address_province);
		
		select.selectByVisibleText("California");	
				
	}
	
	
	
	public void click_checkout_shipping_address_zip() throws Exception
	{
		
		Synchronization.sendKeys(driver, checkout_shipping_address_zip, 30, "74200");
		
	}
	
	
	public void click_continue_to_shipping_method() throws Exception
	{
		
		Actions actions = new Actions(driver);

		actions.moveToElement(continue_to_shipping_method).click().perform();		
		
	}
	
	
	public void click_continue_to_payment_method() throws Exception
	{
		
		Actions actions = new Actions(driver);

		actions.moveToElement(continue_to_payment_method).click().perform();
		
	}
	
	
	public String get_badge_number()
	{
		
		String count = fit_count.getText();
		return count;
		
	}
	
	public String updated_get_badge_number()
	{
		
		String count = fit_count.getText();
		return count;
		
	}
	
	
	public String get_cart_count()
	{
	    
		String count = cartCount.getText();
		return count;
		
	}
	
	
	public String get_cart_message()
	{
		
		String message = go_to_Cart_message.getText();
		return message;
	}
	
	
	public void click_add_fitting_room() throws Exception
	{
			
		Synchronization.Exception_Handling(driver, add_to_fitting_room, 30);
	
		
	}
	
	public void click_remove_fitting_room() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, remove_from_fitting_room, 30);
		
	}
	
	public String before_remove_fitting_room_text()
	{
		String button_text = remove_from_fitting_room.getAttribute("value");
		return button_text;
			
	}

	public String after_remove_fitting_room_text()
	{
		String button_text = add_to_fitting_room.getAttribute("value");
		return button_text;
			
	}
	
	
	public String click_up_text()
	{
		String text = up.getAttribute("class");
		return text;	
	}
	
	

	
}
