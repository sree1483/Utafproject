package com.app.stepdef;

import java.util.Map;

import com.taf.utils.ExcelDataBase;
import com.taf.utils.TestDataHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestDataReadingStepDef {

	TestDataHandler testDataHandler = new TestDataHandler();

	@Given("^Read test data for testcase_(\\d+)$")
	public void read_test_data_for_testcase_(int arg1) throws Throwable {
	
		Map<String, String> TestDataInMap = ExcelDataBase.getTestData("./resources-testdata/TestData.xlsx",
				"TestData01", "TestCase_001");
		System.out.println(TestDataInMap.get("Skill_7"));

		testDataHandler.setTestDataInMap(TestDataInMap);

	}

	@When("^Read test data for skill two$")
	public void read_test_data_for_skill_two() throws Throwable {
		Map<String, String> testDataInMap = testDataHandler.getTestDataInMap();
		System.out.println(testDataInMap.get("Skill_2"));
	}

	@Then("^Read test data for skill Three$")
	public void read_test_data_for_skill_Three() throws Throwable {
		Map<String, String> testDataInMap = testDataHandler.getTestDataInMap();
		System.out.println(testDataInMap.get("Skill_3"));

	}

}
