package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Synchronization;

public class Product_Details {
	
	WebDriver driver;
	
	public Product_Details(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//a[@class='fitting_room_cl_prod_link']") 
	WebElement currentlook_detail;
	
	@FindBy(xpath="//button[starts-with(@id,'pd_add_cart_btn_')]") 
	WebElement add_item_to_cart;
	
	@FindBy(xpath="//a[@data-fav='add']") 
	WebElement Add_fav;
	
	@FindBy(xpath="//p[@class='fitting_room_pd_brand']") 
	WebElement Brand;
	
	@FindBy(xpath="//p[@class='fitting_room_pd_title']") 
	WebElement Product;
	
	@FindBy(xpath="//p[@class='pm_surefit_name']") 
	WebElement surefit_message;
	
	
	
	public void click_currentlook_detail() throws Exception
	{
	  
	  Synchronization.Exception_Handling(driver, currentlook_detail, 30);	
		
	}
	
	public String additem_tocart()
	{
	   String additem_tocart = add_item_to_cart.getText();
	   
		return additem_tocart;
	}

	public String addto_fav() throws Exception
	{
		String PD_fav = Add_fav.getAttribute("data-fav");
		
		return PD_fav;    
	    	
	}
		
	public String Brand_name() throws Exception
	{
		String PD_Brand = Brand.getAttribute("class");
		
		return PD_Brand;    
	    	
	}
	
	public String Product_name() throws Exception
	{
		String PD_Product = Product.getAttribute("class");
		
		return PD_Product;    
	    	
	}
	
	public String surefit()
	{
	   String surefit_mess = surefit_message.getText();
	   
		return surefit_mess;
	}
	
}
