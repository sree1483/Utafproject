package com.taf.managers;

import org.openqa.selenium.WebDriver;

import com.taf.helpers.AlertHelper;
import com.taf.helpers.DropDownHelper;
import com.taf.helpers.JSHelper;
import com.taf.helpers.WaitHelper;

public class HelperManager {
	private WebDriver driver;
	private WaitHelper waitHelper;
	private JSHelper jsHelper;
	private DropDownHelper ddHelper;
	private AlertHelper alertHelper;

	public HelperManager(WebDriver driver) {
		this.driver=driver;
	}

	public WaitHelper getWaitHelperObj() {
		return (waitHelper == null) ? waitHelper = new WaitHelper(driver) : waitHelper;
	}

	public DropDownHelper getDropDownHelperObj() {
		return (ddHelper == null) ? ddHelper = new DropDownHelper(driver) : ddHelper;
	}

	public AlertHelper getAlertHelperObj() {
		return (alertHelper == null) ? alertHelper = new AlertHelper(driver) : alertHelper;
	}

	public JSHelper getJSHelperObj() {
		return (jsHelper == null) ? jsHelper = new JSHelper(driver) : jsHelper;
	}

}
