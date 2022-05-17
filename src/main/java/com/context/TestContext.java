package com.context;

import com.taf.managers.DriverManager;
import com.taf.managers.HelperManager;
import com.taf.managers.PageObjectManager;

public class TestContext {
	private DriverManager drivermaneManager;
	private HelperManager helperManager;
	private PageObjectManager pageObjectManager;

	public TestContext() throws Throwable {
		drivermaneManager = new DriverManager();
		helperManager = new HelperManager(drivermaneManager.getDriver());
		pageObjectManager = new PageObjectManager(drivermaneManager.getDriver());
	}

	public DriverManager getDrivermaneManager() {
		return drivermaneManager;
	}

	public HelperManager getHelperManager() {
		return helperManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
