package com.app.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		 features = {"classpath:features/Register.feature"},
		 glue = {"classpath:com.app.stepdef"},
		 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ParaBankAutoReport.html", "rerun:target/failed-scenarios/ABC1.txt"},
		 tags = "@SCE-03",
		 monochrome = true,
		 strict = true,
		 dryRun = false)
public class ParaBankRegistrationTestRunner extends AbstractTestNGCucumberTests {}
