package com.initialize;

import org.aeonbits.owner.ConfigFactory;

import com.taf.enums.BrowserType;
import com.taf.enums.EnvironmentType;
import com.taf.utils.Configuration;

public class InitMethod {
	Configuration myConfig = ConfigFactory.create(Configuration.class);
	protected BrowserType browserType = myConfig.getBrowser();
	protected EnvironmentType environmentType = myConfig.getEnvironmentType();
	protected String appUrl = myConfig.url();
	protected Long implicitWait = myConfig.implicitWait();
	protected boolean windowMaximize = myConfig.windowMaximize();
	public String testDataFilePath = myConfig.testDataPath();
	
}
