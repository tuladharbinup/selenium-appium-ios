package com.binupjewlry.base;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {
	public BasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverContext.getIOSDriver()), this);
	}
}
