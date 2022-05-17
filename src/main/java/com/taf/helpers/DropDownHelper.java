package com.taf.helpers;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
	private WebDriver driver;
	Select select;

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void selectDropDownByIndex(WebElement element, int indexNo) {
		select = new Select(element);
		select.selectByIndex(indexNo);
	}
	
	public void selectDropDownByText(WebElement element, String textMessage) {
		select = new Select(element);
		select.selectByVisibleText(textMessage);
	}
	
	public void selectDropDownByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public String getSelectedValue(WebElement element) {
		
		String value = new Select(element).getFirstSelectedOption().getText();
		
		return value;
	}
	
	public List<String> getAllDropDownValues(WebElement webElement) {
		Select select = new Select(webElement);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			valueList.add(element.getText());
		}
		return valueList;
	}
}
