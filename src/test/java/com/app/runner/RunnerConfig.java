package com.app.runner;

import org.aeonbits.owner.ConfigFactory;

import com.taf.utils.Configuration;

public class RunnerConfig {
	public static void main(String[] args) {
		Configuration myConfig = ConfigFactory.create(Configuration.class);		
		System.out.println(myConfig.getBrowser());
		System.out.println(myConfig.windowMaximize());
		System.out.println(myConfig.implicitWait());
		System.out.println(myConfig.abc());
		System.out.println(myConfig.prodUrl());
	}

}
