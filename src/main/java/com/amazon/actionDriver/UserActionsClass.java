package com.amazon.actionDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.BaseClass;

public class UserActionsClass extends BaseClass{

	public static void implicitWait(WebDriver driver, int timeOut) {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); This is deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}
	
	public static boolean launchURL(WebDriver driver, String url) {
		boolean flag = true;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flag) {
				System.out.println("Successfully launched "+url);
			}else {
				System.out.println("Failed to launch "+url);
			}
		}
		
	}
	
	public static boolean isDisplayed(WebElement ele) {
		boolean flag = false;
		flag = ele.isDisplayed();
		if(flag) {
			System.out.println("The element is displayed");
		}else {
			System.out.println("The element is not displayed");
		}
		return flag;
	}
	
	public static void hoverElement(WebDriver ldriver, WebElement ele) {
		try {
			Actions act = new Actions(ldriver);
			act.moveToElement(ele).perform();
		} catch (Exception e) {
			System.out.println("Could not hover on the element");
		}
	}
	
	public static boolean click(WebElement ele, String elementName) {
		boolean flag = false;
		try {
			ele.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \""+elementName+"\"");
			} else {
				System.out.println("Unable to click on \""+elementName+"\"");
			}
		}

	}
	
	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}
	
	public static String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		/* This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";*/
		return destination;
		
	}

    
	

}
