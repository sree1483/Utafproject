package com.taf.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {		
		PageFactory.initElements(this.driver, driver);
	}
	
}
