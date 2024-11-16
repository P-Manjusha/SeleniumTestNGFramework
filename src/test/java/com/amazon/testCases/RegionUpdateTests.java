package com.amazon.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pageObjects.CountryOrRegionPage;
import com.amazon.pageObjects.HomePage;
import com.amazon.utility.Log;

public class RegionUpdateTests extends BaseClass{
	CountryOrRegionPage coun;
	HomePage home;
	
	@BeforeMethod(groups = {"Sanity", "Smoke", "Regression"})
	public void setUp() {
		BaseClass.launchApp();
	}
	
	@AfterMethod(groups = {"Sanity", "Smoke", "Regression"})
	public void tearDown() {
	    driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyGoToWebsite() {
		Log.startTestCase("verifyGoToWebsite");
		coun = new CountryOrRegionPage();
		driver.navigate().to("https://www.amazon.in/customer-preferences/country?ref_=icp_lop_mop_chg&preferencesReturnUrl=/");
		boolean res = coun.validateGoToWebsiteButton();
		Assert.assertTrue(res);
		Log.endTestCase("verifyGoToWebsite");
	}
	
	@Test(groups = {"Sanity", "Smoke", "Regression"})
	public void goToWebsite() throws InterruptedException {
		Log.startTestCase("goToWebsite");
		coun = new CountryOrRegionPage();
		home = new HomePage();
		driver.navigate().to("https://www.amazon.in/customer-preferences/country?ref_=icp_lop_mop_chg&preferencesReturnUrl=/");
		boolean res = coun.validateGoToWebsiteButton();
		Assert.assertTrue(res);
		coun.clickGoToWebsite();
	    home.validateLogo();	
	    Log.endTestCase("goToWebsite");
	}

}
