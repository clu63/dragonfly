package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestData {
	private List<TestDataFields> testData = new ArrayList<TestDataFields>();

	class TestDataFields {
		private String name;
		private String value;

		String getName() {
			return name;
		}

		String getValue() {
			return value;
		}

		void setName(String name) {
			this.name = name;
		}

		void setValue(String value) {
			this.value = value;
		}
	}

	void addTestData(String name, String value) {
		TestDataFields testData2 = new TestDataFields();
		testData2.setName(name);
		testData2.setValue(value);
		testData.add(testData2);
	}

	Integer getTestDataCount() {
		return testData.size();
	}

	String getValueByName(String name) {
		for (TestDataFields testData : testData) {
			if (testData.getName().equalsIgnoreCase(name)) {
				return testData.getValue();
			}
		}
		return null;
	}

	void setValueByName(String name, String value) {
		for (TestDataFields testData : testData) {
			if (testData.getName().equalsIgnoreCase(name)) {
				testData.setValue(value);
			}
		}
	}
}
