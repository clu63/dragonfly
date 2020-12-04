package org.DragonflyAutomation;

import org.json.simple.JSONArray;

class JSONS {
	private static volatile JSONS instance = null;
	JSON processing = new JSON();
	JSON element = new JSON();
	JSON step = new JSON();
	JSON links = new JSON();
	JSON testData = new JSON();
	JSON testInstancesEach = new JSON();
	JSONArray testInstances = null;
	JSONArray testSteps = null;

	private JSONS() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static JSONS getInstance() {
		if (instance == null) {
			instance = new JSONS();
			synchronized (JSONS.class) {
				if (instance == null) {
					instance = new JSONS();
				}
			}
		}
		return instance;
	}
}