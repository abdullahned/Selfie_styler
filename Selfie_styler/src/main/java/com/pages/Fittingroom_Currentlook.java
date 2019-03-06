package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Fittingroom_Currentlook {
	
	WebDriver driver;
	
	public Fittingroom_Currentlook(WebDriver ldriver)
	{
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	
	}

	
	
	
	
	
	
	
	
}
