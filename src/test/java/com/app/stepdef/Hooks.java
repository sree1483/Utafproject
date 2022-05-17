package com.app.stepdef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.context.TestContext;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
	    Reporter.assignAuthor("Hello123");
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) throws WebDriverException, Throwable {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) testContext.getDrivermaneManager().getDriver()).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "//target//cucumber-reports//screenshots//" + screenshotName + ".png");
				FileUtils.copyFile(sourcePath, destinationPath);   
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
	}
	
	
	@After(order = 0)
	public void AfterSteps() {
		testContext.getDrivermaneManager().quitDriver();
	}

}
