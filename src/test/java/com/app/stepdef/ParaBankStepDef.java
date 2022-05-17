package com.app.stepdef;

import java.util.Map;

import com.context.TestContext;
import com.initialize.InitMethod;
import com.taf.pageobjects.ParaBankRegistrationPage;
import com.taf.utils.ExcelDataBase;
import com.taf.utils.ExcelReader;
import com.taf.utils.TestDataHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ParaBankStepDef {
	TestContext context;
	ParaBankRegistrationPage paraBankRegistrationPage;
	TestDataHandler testDataHandler = new TestDataHandler();	
	public ParaBankStepDef(TestContext context) {
		this.context = context;
		paraBankRegistrationPage = context.getPageObjectManager().getParaBankRegistrationPageObject();
	}

	@Given("^I navigate to para bank app homepage$")
	public void i_navigate_to_para_bank_app_homepage() throws Throwable {
		paraBankRegistrationPage.clickOnRegisterBtn();

	}

	@Then("^I fill the registration form$")
	public void i_fill_the_registration_form() throws Throwable {		
		paraBankRegistrationPage
			.setFirstName("Lakshmi")
			.setLastName("A")
			.setAddress("USA")
			.setCity("NJ")
			.setState("California")
			.setZipCode("92782")
			.setPhoneNumber("1234567895")
			.setSSN("H369456")
			.setUserName("Hello")
			.setPassword("Hello123")
			.setConirmPassword("Hello123")
			.clickOnRegisterBtn();	
	}
	
	@Given("^I navigate to para bank Products Page$")
	public void iNavigateToParaBankProductsPage() throws Throwable {
		paraBankRegistrationPage.clickOnProductsLink();
	}
	@Then("^I fill the registration form using \"([^\"]*)\"$")
	public void i_fill_the_registration_form_using(String testCaseNo) throws Throwable {
		String dataFilePath = new InitMethod().testDataFilePath;
		Map<String, String> testDataInMap = ExcelDataBase.getTestData(dataFilePath, "UserData", testCaseNo);
		testDataHandler.setTestDataInMap(testDataInMap);
		Map<String, String> myTestData = testDataHandler.getTestDataInMap();		
		paraBankRegistrationPage
			.setFirstName(myTestData.get("FirstName"))
			.setLastName(myTestData.get("LastName"))
			.setAddress(myTestData.get("Address"))
			.setCity(myTestData.get("City"))
			.setState(myTestData.get("State"))
			.setZipCode(myTestData.get("ZipCode"))
			.setPhoneNumber(myTestData.get("PhoneNumber"))
			.setSSN(myTestData.get("SSN"))
			.setUserName(myTestData.get("UserName"))
			.setPassword(myTestData.get("Password"))
			.setConirmPassword(myTestData.get("ConfirmPassword"))
			.clickOnRegisterBtn();	
	}
	
	@Then("^I fill the registration form using excel poi \"([^\"]*)\"$")
	public void usingApachePoiLib(String testCaseNo) throws Throwable {
		String dataFilePath = new InitMethod().testDataFilePath;
		Map<String, String> testDataInMap = new ExcelReader(dataFilePath).getDataRowFromSheet(testCaseNo);
		testDataHandler.setTestDataInMap(testDataInMap);
		Map<String, String> myTestData = testDataHandler.getTestDataInMap();		
		paraBankRegistrationPage
			.setFirstName(myTestData.get("FirstName"))
			.setLastName(myTestData.get("LastName"))
			.setAddress(myTestData.get("Address"))
			.setCity(myTestData.get("City"))
			.setState(myTestData.get("State"))
			.setZipCode(myTestData.get("ZipCode"))
			.setPhoneNumber(myTestData.get("PhoneNumber"))
			.setSSN(myTestData.get("SSN"))
			.setUserName(myTestData.get("UserName"))
			.setPassword(myTestData.get("Password"))
			.setConirmPassword(myTestData.get("ConfirmPassword"))
			.clickOnRegisterBtn();	
	}
}
