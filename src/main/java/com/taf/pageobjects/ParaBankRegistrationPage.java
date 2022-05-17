package com.taf.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.taf.utils.AutoWebLibraryImpl;

public class ParaBankRegistrationPage extends AutoWebLibraryImpl {
	public ParaBankRegistrationPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath = "//div[@id='loginPanel']//a[text()='Register']")
//	public WebElement registerLink;
	
	private By registerLink = By.xpath("//div[@id='loginPanel']//a[text()='Register']");

//	@FindBy(xpath = "//input[@id='customer.firstName']")
//	public WebElement firstName;
	
	private By firstName = By.xpath("//input[@id='customer.firstName']");

//	@FindBy(xpath = "//input[@id='customer.lastName']")
//	public WebElement lastName;
	
	private By lastName = By.xpath("//input[@id='customer.lastName']");
	
	private By address = By.xpath("//input[@id='customer.address.street']");
	private By city = By.xpath("//input[@id='customer.address.city']");
	private By state = By.xpath("//input[@id='customer.address.state']");
	private By zipCode = By.xpath("//input[@id='customer.address.zipCode']");
	private By phoneNumber = By.xpath("//input[@id='customer.phoneNumber']");
	private By ssn = By.xpath("//input[@id='customer.ssn']");
	private By username = By.xpath("//input[@id='customer.username']");
	private By password = By.xpath("//input[@id='customer.password']");
	private By confirmPassword = By.xpath("//input[@id='repeatedPassword']");
	private By registerBtn = By.xpath("//input[@class='button' and @value='Register']");
	private By productsLink = By.xpath("//div[@id='headerPanel']//ul[1]//a[text()='Products']");

	public ParaBankRegistrationPage clickOnRegisterBtn() {
		click(registerLink);
		return this;
	}

	public ParaBankRegistrationPage setFirstName(String firstNameValue) {
		enterText(firstName, firstNameValue);
		return this;
	}

	public ParaBankRegistrationPage setLastName(String lastNameValue) {
		enterText(lastName, lastNameValue);
		return this;
	}
	
	public ParaBankRegistrationPage setAddress(String addressData) {
		enterText(address, addressData);
		return this;
	}
	
	public ParaBankRegistrationPage setCity(String testData) {
		enterText(city, testData);
		return this;
	}
	
	public ParaBankRegistrationPage setState(String testData) {
		enterText(state, testData);
		return this;
	}
	
	public ParaBankRegistrationPage setZipCode(String testData) {
		enterText(zipCode, testData);
		return this;
	}
	
	public ParaBankRegistrationPage setPhoneNumber(String testData) {
		enterText(phoneNumber, testData);
		return this;
	}
	
	public ParaBankRegistrationPage setSSN(String testData) {
		enterText(ssn, testData);
		return this;
	}
	
	public ParaBankRegistrationPage setUserName(String testData) {
		enterText(username, testData);
		return this;
	}
	
	public ParaBankRegistrationPage setPassword(String testData) {
		enterText(password, testData);
		return this;
	}
	
	public ParaBankRegistrationPage setConirmPassword(String testData) {
		enterText(confirmPassword, testData);
		return this;
	}
	
	public ParaBankRegistrationPage clickRegisterButton() {
		click(registerBtn);
		return this;
	}
	
	public ParaBankRegistrationPage clickOnProductsLink() {
		click(productsLink);
		return this;
	}
}
