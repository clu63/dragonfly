package org.DragonflyAutomation;

import java.util.HashMap;

public class JSON2 {
	private static volatile JSON2 instance = null;
	HashMap<String, String> element = new HashMap<String, String>();
	HashMap<String, String> links = new HashMap<String, String>();
	HashMap<String, String> processing = new HashMap<String, String>();
	HashMap<String, String> step = new HashMap<String, String>();
	HashMap<String, String> testData = new HashMap<String, String>();
	HashMap<String, String> testInstancesEach = new HashMap<String, String>();

	private JSON2() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static JSON2 getInstance() {
		if (instance == null) {
			instance = new JSON2();
			synchronized (JSON2.class) {
				if (instance == null) {
					instance = new JSON2();
				}
			}
		}
		return instance;
	}

	HashMap<String, String> getElement() {
		return element;
	}

	HashMap<String, String> getLinks() {
		return links;
	}

	HashMap<String, String> getProcessing() {
		return processing;
	}

	HashMap<String, String> getStep() {
		return step;
	}

	HashMap<String, String> getTestData() {
		return testData;
	}

	HashMap<String, String> getTestInstancesEach() {
		return testInstancesEach;
	}

	void setElement(HashMap<String, String> element) {
		this.element = element;
	}

	void setLinks(HashMap<String, String> links) {
		this.links = links;
	}

	void setProcessing(HashMap<String, String> processing) {
		this.processing = processing;
	}

	void setStep(HashMap<String, String> step) {
		this.step = step;
	}

	void setTestData(HashMap<String, String> testData) {
		this.testData = testData;
	}

	void setTestInstancesEach(HashMap<String, String> testInstancesEach) {
		this.testInstancesEach = testInstancesEach;
	}
}
