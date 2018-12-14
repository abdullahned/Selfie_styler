package com.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

public class Fitting_Room_Edit_Look {

	WebDriver driver;
	
	
	public Fitting_Room_Edit_Look(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="//div[@class ='edit_look']") 
	WebElement Edit_look;
	
	@FindBy(xpath="//select[@id ='size_0']") 
	WebElement Size0;
	
	@FindBy(xpath="//select[@id ='size_1']") 
	WebElement Size1;
	
	@FindBy(xpath="//input[@id ='product-remove-1']") 
	WebElement remove;
	
	@FindBy(xpath="//span[@class ='close_1']") 
	WebElement close;
	
	
	@FindBy(xpath="//input[@id ='product-add-0']") 
	WebElement Add_to_bag_0;
	
	@FindBy(xpath="//input[@id ='product-add-1']") 
	WebElement Add_to_bag_1;
	
	
	@FindBy(xpath="//a[@id ='cartToggle']") 
	WebElement cart_toggle;
	
	@FindBy(xpath="//div[@class ='errorcls']") 
	WebElement selectsize;	
	
	@FindBy(linkText="Brands") 
	WebElement brand;
	
	@FindBy(xpath="//a[@href ='/collections/vendors?q=Monrow']") 
	WebElement monrow;
	
	@FindBy(xpath="//a[@data-product-title='Oversized Crew Neck Tee']") 
	WebElement monrow_product;
	
	@FindBy(xpath="//select[@id ='color_0']") 
	WebElement color;
	
	
	public void Click_Edit_look() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, Edit_look, 30);
	}
	
	
	public String Select_size_0 ()
	{
		
		String text = Size0.getText();
		return text;
		
	}
	
	
	public String Select_size_1 ()
	{
		
		String text = Size1.getText();
		return text;
		
	}
	

	
	public void Remove_product () throws Exception
	{
		
		Synchronization.Exception_Handling(driver, remove, 30);
		
	}

	
	public void Close_edit_popup() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, close, 30);
	}
	
	
	public void Select_a_size() 
	{
		
		HighlightLocator.highLightElement(driver, Size0);
		 
		Select select = new Select(Size0);
		
		select.selectByVisibleText("Size: 26");	
		
	}
	
	
	public void Click_Add_to_bag_0() throws Exception
	{	
		
		Synchronization.Exception_Handling(driver, Add_to_bag_0, 30);
		
	}
	
	
	public void Click_Add_to_bag_1() throws Exception
	{	
		
		Synchronization.Exception_Handling(driver, Add_to_bag_1, 30);
		
	}
	

	
	public void Add_to_cart () throws InterruptedException
	
	{
		
		Actions action = new Actions(driver);
		
		HighlightLocator.highLightElement(driver, cart_toggle);
		
		Thread.sleep(1000);
		
		action.moveToElement(cart_toggle).build().perform();
		
		Thread.sleep(3000);
		
	}
	
	
	
	public String error_message_select_size()
	{
		
		String text1 = selectsize.getText();
		return text1;
				
		
	}
	

	
	public void recommended_size0() 
	{			
		HighlightLocator.highLightElement(driver, Size0);
		
		Select oSelect = new Select(Size0);
		
		List<WebElement> liElements = oSelect.getOptions();
		
		int size = liElements.size();
		
		int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		
		liElements.get(randnMumber).click();					
	}
	
	
	
	public void recommended_size1() 
	{
			
		HighlightLocator.highLightElement(driver, Size1);
		
		Select oSelect = new Select(Size1);
		
		List<WebElement> liElements = oSelect.getOptions();
		
		int size = liElements.size();
		
		int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		
		liElements.get(randnMumber).click();
					
	}
	
	
	
	
	public void click_brand() throws Exception
	{
		//HighlightLocator.highLightElement(driver, brand);
		
		//Synchronization.clickOn(driver,brand, 5);	
		
		Synchronization.Exception_Handling(driver, brand, 30);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;          // To scroll down the page 
		 
		jex.executeScript("window.scrollBy(0,300)", "");
		
	}
	
	
	
	public void clickMonrow() throws Exception
	{
	
		
		//Synchronization.Exception_Handling(driver, monrow, 30);
		
			
		Synchronization.clickOn(driver, monrow, 30);
		
		JavascriptExecutor jex = (JavascriptExecutor)driver;          // To scroll down the page 
		 
		jex.executeScript("window.scrollBy(0,300)", "");
			
	}
	
	
  public void click_monrow_product() throws Exception
  {
	    
	  
	//Synchronization.click_explicitly(driver, monrow_product, 30);
	  
	  //Synchronization.Exception_Handling(driver, monrow_product, 40);
	  
	  monrow_product.click();
	  
	 
	 
	 
  }
  
	
	
  public void Select_a_color() throws InterruptedException
	
	{
		
		HighlightLocator.highLightElement(driver, color);
		 
		Select select = new Select(color);
		
		Thread.sleep(2000);
		
		select.selectByVisibleText("Color: Blue");
		
		Thread.sleep(1000);
			
		
	}
	



	
	
}
	
	

		
	

