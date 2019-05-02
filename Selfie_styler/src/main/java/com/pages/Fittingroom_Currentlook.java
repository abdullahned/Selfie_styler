package com.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.HighlightLocator;
import Utility.Synchronization;

public class Fittingroom_Currentlook {
	
	WebDriver driver;
	
	public Fittingroom_Currentlook(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="//button[@class='fitting_room_next_btn']") 
	WebElement product_slide;
	
	@FindBy(xpath="//a[@class='fitting_room_cl_prod_link']") 
	WebElement currentlook_detail;
	
	@FindBy(xpath="//button[starts-with(@id,'pd_add_cart_btn_')]") 
	WebElement add_item_to_cart;
	
	@FindBy(xpath="//input[@id='bc-sf-search-box-0']") 
	WebElement search_field;
	
	@FindBy(xpath="//select[@id='color_1404']") 
	WebElement selectcolor;
	
	@FindBy(xpath="//button[starts-with(@id,'product-add-')]") 
	WebElement add_to_cart;
	
	@FindBy(xpath="//span[@id='cartCount']") 
    WebElement cartCount;
	
	@FindBy(xpath="//a[starts-with(@id,'950')]") 
	WebElement hanger;
	
	
	public void click_product_slide() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, product_slide, 30);	
	}
	
	
	public String currentlook_detail()
	{
	   String Detail = currentlook_detail.getText();
	   
		return Detail;
	}
	
	public void click_currentlook_detail() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, currentlook_detail, 30);	
	}
	
	
	public String additem_tocart()
	{
	   String additem_tocart = add_item_to_cart.getText();
	   
		return additem_tocart;
	}
	
	
	public void search_product() throws Exception
	{
		
	  Synchronization.sendkey(driver, search_field, 30, "Keepsake V-neck Tee");
		
	}
	
    public void select_color()
    {
    	HighlightLocator.highLightElement(driver, selectcolor);
		 
		Select select = new Select(selectcolor);
		
        List<WebElement> liElements = select.getOptions();
		
		int size = liElements.size();
		
		int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		
		liElements.get(randnMumber).click();	
    	
    }
	
    public void click_add_to_cart() throws Exception
	{
		
		Synchronization.Exception_Handling(driver, add_to_cart, 30);	
	}
	
    
    public String get_cart_count()
	{
	    
		String count = cartCount.getText();
		return count;
		
	}
    
    public void click_hanger() throws Exception
   	{
   		hanger.click();

   	}
   	

    
	
}
