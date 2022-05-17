package com.taf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	
	static String filePath = System.getProperty("user.dir") + "src/test/resources/config/Configuration.properties";
	
	public static String readProperty(String key) throws IOException {
		
		File file = new File(filePath);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return key;
		
	}
	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		PropertyUtil property = new PropertyUtil();
		PropertyUtil.readProperty("url");
		PropertyUtil.readProperty("implicitlyWait");
	}

}
