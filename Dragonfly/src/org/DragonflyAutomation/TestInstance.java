package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestInstance {
	private List<List<TestInstanceDetail>> testInstance = new ArrayList<List<TestInstanceDetail>>();

	class TestInstanceDetail {
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
		TestInstanceDetail testInstanceDetail = new TestInstanceDetail();
		testInstanceDetail.setName(name);
		testInstanceDetail.setValue(value);
		List<TestInstanceDetail> testDataList = new ArrayList<TestInstanceDetail>();
		testDataList.add(testInstanceDetail);
		testInstance.add(testDataList);
	}

	void addInstanceByNumber(Integer instanceNumber, String name, String value) {
		TestInstanceDetail testData = new TestInstanceDetail();
		testData.setName(name);
		testData.setValue(value);
		testInstance.get(instanceNumber).add((TestInstanceDetail) testData);
	}

	Integer getInstanceCount() {
		return testInstance.size();
	}

	String getInstanceValueByName(Integer instanceNumber, String name) {
		for (TestInstanceDetail testData : testInstance.get(instanceNumber)) {
			if (testData.getName().equalsIgnoreCase(name)) {
				return testData.getValue();
			}
		}
		return null;
	}

	void setInstanceValueByName(Integer instanceNumber, String name, String value) {
		for (TestInstanceDetail testData : testInstance.get(instanceNumber)) {
			if (testData.getName().equalsIgnoreCase(name)) {
				testData.setValue(value);
			}
		}
	}
}
