package com.taf.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface AutoWebLibrary {
	
	public void click(By locator);	
	public void click(WebElement webElement);	
	public void enterText(By locator, String data);
	public void enterText(WebElement webElement, String data);
	public void getText(WebElement webElement);

}
