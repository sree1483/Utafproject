package com.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	
	private  Map<String, Object> scenarioContext;
	
	public ScenarioContext() {
		scenarioContext = new HashMap<String, Object>();
	}	

	public void setScenarioContext(Map<String, Object> scenarioContext) {
		this.scenarioContext = scenarioContext;
	}
	
	public Map<String, Object> getScenarioContext() {
		return scenarioContext;
	}	

}
