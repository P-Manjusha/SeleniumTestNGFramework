package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actionDriver.UserActionsClass;
import com.amazon.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[@href = '/ref=nav_logo' and @aria-label = 'Amazon.in']")
	WebElement AmazonLogo;
	@FindBy(xpath = "//span[@class = 'icp-nav-flag icp-nav-flag-in icp-nav-flag-lop']/..//span[@class = 'nav-icon nav-arrow'])")
	WebElement LanguageAndCountrySelectionDropdown;
	@FindBy(xpath = "//div[text() = 'Change country/region']")
	WebElement ChangeCountryOrRegion;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo() {
		return UserActionsClass.isDisplayed(AmazonLogo);
		
	}
	
	public void hoverLanguageAndCountrySelectionDropdown() {
		UserActionsClass.hoverElement(driver, LanguageAndCountrySelectionDropdown);
	}
	
	public void clickCountryOrRegionText() {
		UserActionsClass.click(ChangeCountryOrRegion, "ChangeCountryOrRegion");
	}

}
