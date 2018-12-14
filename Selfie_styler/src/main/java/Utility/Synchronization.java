package Utility;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		
		HighlightLocator.highLightElement(driver, element); 
		
		element.click();
	}
	
	
	public static void click_explicitly1(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(ElementNotVisibleException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	
	public static void click_explicitly(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(locator));
		
		HighlightLocator.highLightElement(driver, locator);
		
		locator.click();
	}
	
	
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).
		
		ignoring(NoSuchElementException.class).
		
		until(ExpectedConditions.visibilityOf(element));
		
		HighlightLocator.highLightElement(driver, element);
		
		element.sendKeys(value);
	}
	

	
     public static void Exception_Handling(WebDriver driver, WebElement locator, int timeout ) throws Exception{
 
        try {
            
        	HighlightLocator.highLightElement(driver, locator); 
        	
            locator.click();
 
        }
        
        catch (NoSuchElementException e) {
        	
        	new WebDriverWait(driver, timeout).
        	
        	ignoring(NoSuchElementException.class).
        	
        	until( ExpectedConditions.elementToBeClickable(locator));
        	
        
        	HighlightLocator.highLightElement(driver, locator); 
        	
        	locator.click();

        }
 
        catch (StaleElementReferenceException e) {
        	
        	new WebDriverWait(driver, timeout).
        	
        	ignoring(StaleElementReferenceException.class).
        	
        	until( ExpectedConditions.elementToBeClickable(locator));
        	
        	
        	
        	HighlightLocator.highLightElement(driver, locator); 
        	
        	locator.click();

        }
 
        
        catch (ElementNotVisibleException e) {
        	
        	new WebDriverWait(driver, timeout).
        	
        	ignoring(ElementNotVisibleException.class).
        	
        	until( ExpectedConditions.visibilityOf(locator));
        	
        	HighlightLocator.highLightElement(driver, locator); 
        	
        	locator.click();

        }
        
        
  
        
       catch (TimeoutException e) {
        	
        	new WebDriverWait(driver, timeout).
        	
        	ignoring(TimeoutException.class).
        	
        	until( ExpectedConditions.elementToBeClickable(locator));
        	
        	HighlightLocator.highLightElement(driver, locator); 
        	
        	locator.click();

        }
        
 
       
     catch (ElementNotSelectableException e) {
        	
        	new WebDriverWait(driver, timeout).
        	
        	ignoring(ElementNotSelectableException.class).
        	
        	until( ExpectedConditions.elementToBeClickable(locator));
        	
        	HighlightLocator.highLightElement(driver, locator); 
        	
        	locator.click();

        }
        
        
     catch (WebDriverException e) {
        	
        	new WebDriverWait(driver, timeout).
        	
        	ignoring(WebDriverException.class).
        	
        	until( ExpectedConditions.elementToBeClickable(locator));
        	
        	HighlightLocator.highLightElement(driver, locator); 
        	
        	locator.click();

        }
        
        
    
        

    }
	
	
	

	
}
