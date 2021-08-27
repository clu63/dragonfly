package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestConfiguration {
	private TestConfigurationBuild testConfiguration;

	void addTestData(String testData) {
		this.testConfiguration.testData.add(testData);
	}

	void addTestElement(String testElement) {
		this.testConfiguration.testElement.add(testElement);
	}

	void addTestModule(String testModule) {
		this.testConfiguration.testModule.add(testModule);
	}

	List<String> getTestData() {
		return this.testConfiguration.testData;
	}

	String getTestDetailsTestDescription() {
		return this.testConfiguration.testDetails.getTestDescription();
	}

	String getTestDetailsTestName() {
		return this.testConfiguration.testDetails.getTestName();
	}

	String getTestDetailsTestType() {
		return this.testConfiguration.testDetails.getTestType();
	}

	List<String> getTestElement() {
		return this.testConfiguration.testElement;
	}

	String getTestInstance() {
		return this.testConfiguration.testInstance;
	}

	List<String> getTestModule() {
		return this.testConfiguration.testModule;
	}

	Boolean removeTestData(String testData) {
		return this.testConfiguration.testData.remove(testData);
	}

	Boolean removeTestElement(String testElement) {
		return this.testConfiguration.testElement.remove(testElement);
	}

	Boolean removeTestModule(String testModule) {
		return this.testConfiguration.testModule.remove(testModule);
	}

	void setTestDetailsTestDescription(String testDescription) {
		this.testConfiguration.testDetails.setTestDescription(testDescription);
	}

	void setTestDetailsTestName(String testName) {
		this.testConfiguration.testDetails.setTestName(testName);
	}

	void setTestDetailsTestType(String testType) {
		this.testConfiguration.testDetails.setTestType(testType);
	}

	class TestConfigurationBuild {
		private TestDetails testDetails;
		private String testInstance;
		private List<String> testModule = new ArrayList<String>();
		private List<String> testElement = new ArrayList<String>();
		private List<String> testData = new ArrayList<String>();
	}

	class TestDetails {
		private String testName;
		private String testDescription;
		private String testType;

		private String getTestDescription() {
			return this.testDescription;
		}

		private String getTestName() {
			return this.testName;
		}

		private String getTestType() {
			return this.testType;
		}

		private void setTestDescription(String testDescription) {
			this.testDescription = testDescription;
		}

		private void setTestName(String testName) {
			this.testName = testName;
		}

		private void setTestType(String testType) {
			this.testType = testType;
		}
	}
}
