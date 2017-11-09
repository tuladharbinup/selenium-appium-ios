package com.binupjewlry.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverContext {
	private static IOSDriver<IOSElement> driver;
	private static IOSDriver<IOSElement> browserCapabilities() {
		try {
			DesiredCapabilities d=new DesiredCapabilities(); 
			d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
			d.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			d.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
			d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.1");
			
			driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
		catch (MalformedURLException mEx) {
				System.out.println(mEx.getMessage());	
				}
		catch (Exception Ex) {
			System.out.println(Ex.getMessage());	
			}
		return driver;

	}
	
	public static IOSDriver<IOSElement> getIOSDriver() {
		//singleton pattern
		if (driver == null) {
		return browserCapabilities();
		}
		return driver;		
	}
	
	public static void closeIOSDriver() {
		System.out.println("\nClosing ios driver");
		if (driver != null) {
		driver.quit();
		}
		
	}
}
