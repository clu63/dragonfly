package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestDataList {
	private List<TestData> testData = new ArrayList<TestData>();

	Integer getTestDataCount() {
		return testData.size();
	}

	void addTestData(String name, String value) {
		TestData testData2 = new TestData();
		testData2.setName(name);
		testData2.setValue(value);
		testData.add(testData2);
	}

	String getValueByName(String name) {
		for (TestData testData : testData) {
			if (testData.getName().equalsIgnoreCase(name)) {
				return testData.getValue();
			}
		}
		return null;
	}

	void setValueByName(String name, String value) {
		for (TestData testData : testData) {
			if (testData.getName().equalsIgnoreCase(name)) {
				testData.setValue(value);
			}
		}
	}
}
