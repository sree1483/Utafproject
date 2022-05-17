package com.taf.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSHelper {
	private WebDriver driver;

	public JSHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript(script, args);
		return args;

	}

	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();", element);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}
	
	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
	}

	public void scrollAndClick(WebElement webElement) {
		scrollToElemet(webElement);
		webElement.click();
	}

	public void sendKeys(String value, WebElement element) {
		executeScript("arguments[0].value='" + value + "';", element);
	}
	
	public void ZoomInBypercentage(int percentage) {
		executeScript("document.body.style.zoom='percentage'");
	}

	public void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}
}
