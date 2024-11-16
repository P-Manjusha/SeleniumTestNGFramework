package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.amazon.actionDriver.UserActionsClass;
import com.amazon.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		if(browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.contains("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}
		UserActionsClass.implicitWait(driver, 20);
		UserActionsClass.pageLoadTimeOut(driver, 30);
		UserActionsClass.launchURL(driver, prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@BeforeSuite(groups = {"Sanity", "Smoke", "Regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();  //Creates Extent Report
		DOMConfigurator.configure("log4j.xml");  //Configures Logging
		try {  //Reads Config.properties File
			prop = new Properties();
			FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
