package com.amazon.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pageObjects.CountryOrRegionPage;
import com.amazon.pageObjects.HomePage;
import com.amazon.utility.Log;

public class AmazonPageVerifyTests extends BaseClass{
	
	HomePage home;
	CountryOrRegionPage countryPage;
	
	@BeforeMethod(groups = {"Sanity", "Smoke", "Regression"})
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod(groups = {"Sanity", "Smoke", "Regression"})
	public void tearDown() {
	    driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		Log.startTestCase("verifyLogo");
		home = new HomePage();
		boolean res = home.validateLogo();
		Log.info("Validating the logo");
		Assert.assertTrue(false);//Failing deliberately. Actually it should be --> Assert.assertTrue(res);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Sanity")
	public void navigateToRegionUpdatePageAndVerify() throws InterruptedException {
		Log.startTestCase("navigateToRegionUpdatePageAndVerify");
		home = new HomePage();
		countryPage = new CountryOrRegionPage();
		Thread.sleep(5000);
		driver.navigate().to("https://www.amazon.in/customer-preferences/country?ref_=icp_lop_mop_chg&preferencesReturnUrl=/");
		boolean res = countryPage.validateCountryOrRegionText();
		Assert.assertTrue(res);
		Log.endTestCase("navigateToRegionUpdatePageAndVerify");		
	}

}
