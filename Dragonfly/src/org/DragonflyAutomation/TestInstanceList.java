package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestInstanceList {
	private List<List<TestData>> testInstance = new ArrayList<List<TestData>>();

	void addInstance(String name, String value) {
		TestData testData = new TestData();
		testData.setName(name);
		testData.setValue(value);
		List<TestData> testDataList = new ArrayList<TestData>();
		testDataList.add(testData);
		this.testInstance.add(testDataList);
	}

	void addInstanceByNumber(Integer instanceNumber, String name, String value) {
		TestData testData = new TestData();
		testData.setName(name);
		testData.setValue(value);
		testInstance.get(instanceNumber).add((TestData) testData);
	}

	Integer getInstanceCount() {
		return testInstance.size();
	}

	String getInstanceValueByName(Integer instanceNumber, String name) {
		for (TestData testData : testInstance.get(instanceNumber)) {
			if (testData.getName().equalsIgnoreCase(name)) {
				return testData.getValue();
			}
		}
		return null;
	}

	void setInstanceValueByName(Integer instanceNumber, String name, String value) {
		for (TestData testData : testInstance.get(instanceNumber)) {
			if (testData.getName().equalsIgnoreCase(name)) {
				testData.setValue(value);
			}
		}
	}
}
