package com.binupjewelry.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.binupjewelry.utilities.HelperUtil;
import com.binupjewlry.base.BasePage;

public class CheckOutPage extends BasePage {

		//@iOSFindBy(locator_for_ios) //this locater is used when here is iOS native content
		@FindBy(id="basket_purchase_main") 
		public WebElement btnCheckOut;
		
		@FindBy(xpath="//span[contains(text(),'Login to your account')]") 
		public WebElement checkLogin;
		
		@FindBy(id="account_email") 
		public WebElement txtEmail;
		
		@FindBy(id="account_login_password") 
		public WebElement txtPassword;
		
		@FindBy(id="btnAccountLogin") 
		public WebElement btnLogin;
		
		@FindBy(xpath="//div[@id='btnConfirmShipping']//input[@value='Continue to Payment']") 
		public WebElement btnContinueToPayment;
		
		@FindBy(id="terms_acceptance")
		public WebElement chkTermsAndCondidtions;
		
		public void clickCheckout() {
			btnCheckOut.click();
		}
		public void selectLoginCheckbox() {
			checkLogin.click();
		}
		
		@FindBy(id="stripe_cardnumber") 
		public WebElement txtCardNumber;
		
		@FindBy(id="stripe_card_month") 
		public WebElement txtCardExpiry;
		
		@FindBy(id="stripe_card_cvc") 
		public WebElement txtCardCVC;
		
		@FindBy(id="btnCompleteOrderStripe") 
		public WebElement btnCompleteOrder;
		
		public void login(String username, String password) {
			HelperUtil.waitForElementToBeVisible(txtEmail);
			txtEmail.clear();
			txtEmail.sendKeys(username);
			txtPassword.clear();
			txtPassword.sendKeys(password);
			btnLogin.click();
		}
		
		public void clickContinueToPayment() {
			HelperUtil.waitForElementToBeClickable(btnContinueToPayment);
			btnContinueToPayment.click();
		}
		
		public void enterCreditCardInfo(String cardNumber, String cardExpiry, String cardCVC) {
		try {
			HelperUtil.waitForElementToBeVisible(txtCardNumber);
			txtCardNumber.clear();
			Thread.sleep(100);
			txtCardNumber.sendKeys(cardNumber.substring(0, 4));		
			Thread.sleep(100);
			txtCardNumber.sendKeys(cardNumber.substring(4, 8));		
			Thread.sleep(100);
			txtCardNumber.sendKeys(cardNumber.substring(8, 12));		
			Thread.sleep(100);
			txtCardNumber.sendKeys(cardNumber.substring(12, 16));			
			Thread.sleep(100);
			
			txtCardExpiry.clear();
			Thread.sleep(100);
			txtCardExpiry.sendKeys(cardExpiry.substring(0, 2));
			Thread.sleep(100);
			txtCardExpiry.sendKeys(cardExpiry.substring(2, 6));
			Thread.sleep(100);
			
			txtCardCVC.clear();
			txtCardCVC.sendKeys(cardCVC);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		public void clickTermsAndConditions() {
			chkTermsAndCondidtions.click();
		}
		
		public void clickCompleteOrder() {
			HelperUtil.waitForElementToBeClickable(btnCompleteOrder);
			btnCompleteOrder.click();
		}
}
