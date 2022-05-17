package com.taf.managers;

import org.openqa.selenium.WebDriver;

import com.taf.pageobjects.LoginPage;
import com.taf.pageobjects.ParaBankRegistrationPage;
import com.taf.pageobjects.RegistrationPage;

public class PageObjectManager {
	private WebDriver driver;
	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	private ParaBankRegistrationPage paraBankRegistrationPage;
		
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage getLoginPageObject() {
		return (loginPage == null)? loginPage = new LoginPage(driver):loginPage;		
	}
	
	public RegistrationPage getRegistrationPageObject() {
		return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
	}
	
	public ParaBankRegistrationPage getParaBankRegistrationPageObject() {
		return (paraBankRegistrationPage == null) ? paraBankRegistrationPage = new ParaBankRegistrationPage(driver) : paraBankRegistrationPage;
	}

}
