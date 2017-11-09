package com.binupjewelry.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.binupjewelry.pages.CheckOutPage;
import com.binupjewelry.pages.HomePage;

public class SearchAndBuyRing {
	HomePage homepage;
	CheckOutPage checkoutpage;
	
	@BeforeClass
	public void beforeClassPageInstatntiation() {
		homepage = new HomePage();
		checkoutpage= new CheckOutPage();
	}
	
	@Test
	public void SearchAndBuyRingTest(){
	System.out.println("Executing Test SearchAndBuyRingTest");
	
	homepage.goToURL("https://binup-jewelry.offersupermarket.com");	
	homepage.searchProduct("Pandora Silver Beaded January Garnet Birthsone Ring 190854GA");
	homepage.clickBuy();
	
	checkoutpage.clickCheckout();
	checkoutpage.selectLoginCheckbox();
	checkoutpage.login("ripet@payperex2.com", "!2345678");
	checkoutpage.clickContinueToPayment();
	checkoutpage.enterCreditCardInfo("5555555555554444", "122020", "123");
	checkoutpage.clickTermsAndConditions();
	checkoutpage.clickCompleteOrder();
	}
}
