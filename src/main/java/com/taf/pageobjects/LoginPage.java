package com.taf.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(this.driver, driver);
	}
	////////////////////////////////////////////
	//////////// WebElements Declaration ///////
	////////////////////////////////////////////	
	private By userName = By.xpath("");
	private By password = By.xpath("");
	private By loginBtn = By.xpath("");
	
	////////////////////////////////////////////
	///////////// Webpage action methods ///////
	////////////////////////////////////////////
	
    public LoginPage setUsername(String uname) {    
    	driver.findElement(userName).sendKeys(uname);
    	return this;
    }
    
    public LoginPage setPassword(String pwd) {  
    	driver.findElement(password).sendKeys(pwd);
    	return this;
    }
    
    public LoginPage clickOnLoginBtn() {
    	driver.findElement(loginBtn);
    	return this;
    }
	

}
