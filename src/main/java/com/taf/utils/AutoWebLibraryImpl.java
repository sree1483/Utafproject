package com.taf.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.taf.helpers.JSHelper;
import com.taf.helpers.WaitHelper;

public class AutoWebLibraryImpl implements AutoWebLibrary {
	protected WebDriver driver;
	protected WaitHelper waitHelper;
	protected JSHelper jsHelper;
	
	public AutoWebLibraryImpl(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		jsHelper = new JSHelper(driver);
	}

	public void click(By locator) {
		waitHelper.waitForElementClickable(locator, 30);
		driver.findElement(locator).click();
	}

	public void click(WebElement webElement) {
		waitHelper.waitForElementAppear(webElement, 30);
		jsHelper.clickElement(webElement);
	}

	public void enterText(By locator, String data) {
		waitHelper.waitForElementClickable(locator, 30);
		driver.findElement(locator).sendKeys(data);

	}

	public void enterText(WebElement webElement, String data) {
		waitHelper.waitForElementAppear(webElement, 30);
		webElement.sendKeys(data);
	}

	@Override
	public void getText(WebElement webElement) {
				
	}

}
