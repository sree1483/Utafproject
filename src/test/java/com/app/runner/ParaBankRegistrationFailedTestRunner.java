package com.app.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		 features = {"@target/failed-scenarios/ABC1.txt"},
		 glue = {"classpath:com.app.stepdef"},
		 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ParaBankRerunAutoReport.html"}
		 )
public class ParaBankRegistrationFailedTestRunner extends AbstractTestNGCucumberTests {}
