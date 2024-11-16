package com.amazon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actionDriver.UserActionsClass;
import com.amazon.base.BaseClass;

public class CountryOrRegionPage extends BaseClass {
	@FindBy(xpath = "//h3[contains(text(), 'Country/Region') and @class = 'a-spacing-extra-large']")
	WebElement CountryOrRegionText;

	@FindBy(xpath = "//i[@class = 'a-icon a-icon-dropdown']")
	WebElement CountrySelectionDropdown;

	@FindBy(xpath = "//span[contains(text(), 'Go to website')]/..")
	WebElement GoToWebsiteButton;
	
	@FindBy(xpath = "//a[@class = 'a-dropdown-link']")
	WebElement CountryOption;
	
	public CountryOrRegionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCountryOrRegionText() {
		return UserActionsClass.isDisplayed(CountryOrRegionText);
	}
	
	public void clickCountrySelectionDropdown() {
		UserActionsClass.click(CountrySelectionDropdown, "CountrySelectionDropdown");
	}
	
	public void selectCountry() {
		UserActionsClass.selectByVisibleText("United States", CountryOption);
	}
	
	public void clickGoToWebsite() {
		GoToWebsiteButton.click();
		//UserActionsClass.click(GoToWebsiteButton, "GoToWebsiteButton");
	}
	
	public boolean validateGoToWebsiteButton() {
		return UserActionsClass.isDisplayed(GoToWebsiteButton);
	}
	
	public void verifyCurrentWebsite() {
		String currentURL = UserActionsClass.getCurrentURL(driver);
		boolean flag = false;
		if(currentURL.equals("https://www.amazon.com/?ref_=icp_country_from_in")) {
			System.out.println("Successfully landed on ");
		}
	}

}
