package com.binupjewelry.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.binupjewelry.utilities.HelperUtil;
import com.binupjewlry.base.BasePage;
import com.binupjewlry.base.DriverContext;

public class HomePage extends BasePage {
	
	//@iOSFindBy(locator_for_ios) //this locater is used when here is iOS native content
	@FindBy(id="txtQuickSearch") 
	public WebElement txtSearch;
	
	@FindBy(id="search_button") 
	public WebElement btnSearch;
	
	@FindBy(xpath="//div[contains(text(),'Buy')]")
	public WebElement btnBuy;
	
	public void goToURL(String url) {
		DriverContext.getIOSDriver().get(url);
		
	}
	
	public void searchProduct(String productText) {
		txtSearch.sendKeys(productText);
		btnSearch.click();
	}
	
	public void clickBuy() {
		HelperUtil.waitForElementToBeClickable(btnBuy);
		btnBuy.click();
	}
}
