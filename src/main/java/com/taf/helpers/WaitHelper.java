package com.taf.helpers;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	private WebDriver driver;
	private static Logger log = Logger.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setImplicitWait(long time) {
		driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
	}
	
	public void reSetImplicitWait() {
		driver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unused")
	public void waitForElementClickable(By locator, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		log.info(wait.toString() + " " + "Webelement is clickable now . . . ");
	}
	
	@SuppressWarnings("unused")
	public void waitForElement(By locator, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		log.info(wait.toString() + " " + "Webelement is visible now . . . ");
	}
	
	@SuppressWarnings("unused")
	public void waitForElement (WebElement element, String xpath, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.textToBePresentInElement(element, xpath));
		log.info(wait.toString() + " " + "Webelement is visible now . . . ");
	}
	
	public void waitforElementDisappear(WebElement element, long time) {
		reSetImplicitWait();
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.stalenessOf(element));
		log.info(wait.toString() + " " + "Webelement is disappear now . . . ");	
		setImplicitWait(30);
	}
	
	public void waitForElementAppear(WebElement element, long time) {
		reSetImplicitWait();
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(wait.toString() + " " + "Webelement is disappear now . . . ");		
		setImplicitWait(30);
	}
}
