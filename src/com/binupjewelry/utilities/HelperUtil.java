package com.binupjewelry.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.binupjewlry.base.DriverContext;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class HelperUtil {
	private static IOSDriver<IOSElement> driver=DriverContext.getIOSDriver();	
	
	public static void waitForElementToBeVisible(WebElement element){		
		WebDriverWait wait = new WebDriverWait(driver, 15);
			try {				
				wait.until(ExpectedConditions.visibilityOf(element));
				System.out.println("Element "+element+" is present");
			}
			catch (NoSuchElementException ex)	
			{
				System.out.println("Element was not found "+ex.getAdditionalInformation());
			}
			catch (Exception ex)
			{
				System.out.println("General exception "+ex.getMessage());
			}
		
	}
	
	public static void waitForElementToBeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 18);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (NoSuchElementException ex)	
		{
			System.out.println("Element was not found "+ex.getAdditionalInformation());
		}
		catch (Exception ex)
		{
			System.out.println("General exception "+ex.getMessage());
		}
	
	}
}
