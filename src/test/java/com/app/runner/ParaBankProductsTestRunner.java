package com.app.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		 features = {"classpath:features/Products.feature"},
		 glue = {"classpath:com.app.stepdef"},
		 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ParaBankAutoReport.html", "rerun:target/failed-scenarios/PRODUCTS.txt"},
		 tags = "@SCE-01",
		 monochrome = true,
		 strict = true,
		 dryRun = false)
public class ParaBankProductsTestRunner extends AbstractTestNGCucumberTests {}
