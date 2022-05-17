package com.taf.utils;

import java.util.List;

import org.aeonbits.owner.Config;

import com.taf.enums.BrowserType;
import com.taf.enums.EnvironmentType;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
		value={"file:${user.dir}/src/main/resources/Configuration.properties", 
		"file:${user.dir}/src/main/resources/Dev.properties", "file:${user.dir}/src/main/resources/PROD.properties"})
public interface Configuration extends Config {
	@DefaultValue("CHROME")	
	@Key("browser")
	BrowserType getBrowser();
	String url();
	boolean windowMaximize();
	List<String> skillSet();
	@DefaultValue("30")
	Long implicitWait();	
	boolean abc();
	String prodUrl();
	@Key("environment")
	@DefaultValue("LOCAL")	
	EnvironmentType getEnvironmentType();
	@Key("testDataFilePath")
	String testDataPath();
}
