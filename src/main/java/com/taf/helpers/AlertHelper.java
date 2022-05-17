package com.taf.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	private static Logger log = Logger.getLogger(AlertHelper.class);
	private WebDriver driver;

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info(driver.hashCode());
	}

	private Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();

	}

	public void dismissAlert() {
		getAlert().dismiss();
	}

	public void sendKeys(String testData) {
		getAlert().sendKeys(testData);
	}

	public String getAlertText() {
		return getAlert().getText();
	}

	public boolean isAlertPresent() {
		try {
			getAlert();
			log.info("true");
			return true;
		} catch (NoAlertPresentException e) {
			// Ignore
			log.info("false");
			return false;
		}

	}

	public void acceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		acceptAlert();
		log.info("");
	}

	public void dismissAlertIfPresent() {
		if (!isAlertPresent())
			return;
		dismissAlert();
		log.info("");
	}

	public void acceptPrompt(String text) {
		if (!isAlertPresent())
			return;
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
		log.info(text);
	}

}
