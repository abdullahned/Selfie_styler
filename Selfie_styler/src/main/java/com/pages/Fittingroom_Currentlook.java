package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath="//button[@id='pd_add_cart_btn_950']") 
	WebElement add_item_to_cart;
	
	@FindBy(xpath="//input[@id='bc-sf-search-box-0']") 
	WebElement search_field;
	
	@FindBy(xpath="//select[@id='color_1404']") 
	WebElement selectcolor;
	
	
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
    	
    	
    	
    }
	
	
	
	
	
	
}
