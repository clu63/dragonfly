package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestData {
	private List<TestDataDetail> testData = new ArrayList<TestDataDetail>();

	Integer getTestDataCount() {
		return testData.size();
	}

	void addTestData(String name, String value) {
		TestDataDetail testData2 = new TestDataDetail();
		testData2.setName(name);
		testData2.setValue(value);
		testData.add(testData2);
	}

	String getValueByName(String name) {
		for (TestDataDetail testData : testData) {
			if (testData.getName().equalsIgnoreCase(name)) {
				return testData.getValue();
			}
		}
		return null;
	}

	void setValueByName(String name, String value) {
		for (TestDataDetail testData : testData) {
			if (testData.getName().equalsIgnoreCase(name)) {
				testData.setValue(value);
			}
		}
	}

	class TestDataDetail {
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
}
