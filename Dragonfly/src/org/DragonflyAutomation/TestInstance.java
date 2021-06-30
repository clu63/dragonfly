package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestInstance {
	private List<List<TestInstanceFields>> testInstance = new ArrayList<List<TestInstanceFields>>();

	class TestInstanceFields {
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

	void addInstance(String name, String value) {
		TestInstanceFields testInstanceFields = new TestInstanceFields();
		testInstanceFields.setName(name);
		testInstanceFields.setValue(value);
		List<TestInstanceFields> testDataList = new ArrayList<TestInstanceFields>();
		testDataList.add(testInstanceFields);
		testInstance.add(testDataList);
	}

	void addInstanceByNumber(Integer instanceNumber, String name, String value) {
		TestInstanceFields testData = new TestInstanceFields();
		testData.setName(name);
		testData.setValue(value);
		testInstance.get(instanceNumber).add((TestInstanceFields) testData);
	}

	Integer getInstanceCount() {
		return testInstance.size();
	}

	String getInstanceValueByName(Integer instanceNumber, String name) {
		for (TestInstanceFields testData : testInstance.get(instanceNumber)) {
			if (testData.getName().equalsIgnoreCase(name)) {
				return testData.getValue();
			}
		}
		return null;
	}

	void setInstanceValueByName(Integer instanceNumber, String name, String value) {
		for (TestInstanceFields testData : testInstance.get(instanceNumber)) {
			if (testData.getName().equalsIgnoreCase(name)) {
				testData.setValue(value);
			}
		}
	}
}
