package com.taf.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.initialize.InitMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager extends InitMethod {
	private WebDriver driver;

	public DriverManager() {
	}

	public WebDriver getDriver() throws Throwable {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() throws Throwable {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalMachineExecution();
			break;
		case REMOTE:
			driver = createRemoteMachineExecution();
			break;
		default:
			break;
		}

		return driver;

	}

	private WebDriver createRemoteMachineExecution() throws Throwable {
		throw new Throwable("!!!!! We are not executing on Remote Machine !!!!!!!");
	}

	private WebDriver createLocalMachineExecution() {
		switch (browserType) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
		if (windowMaximize)
			driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}

	public WebDriver quitDriver() {
		driver.close();
		driver.quit();
		return driver;
	}
}
