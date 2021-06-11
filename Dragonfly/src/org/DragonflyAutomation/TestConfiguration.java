package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

public class TestConfiguration {
	private FileNames testConfiguration;

	class FileNames {
		private TestDetails testDetails;
		private List<String> testInstance = new ArrayList<String>();
		private List<String> testModule = new ArrayList<String>();
		private List<String> testElement = new ArrayList<String>();
		private List<String> testData = new ArrayList<String>();
	}

	class TestDetails {
		private String testName;
		private String testDescription;
		private String testType;

		String getTestDescription() {
			return this.testDescription;
		}

		String getTestName() {
			return this.testName;
		}

		String getTestType() {
			return this.testType;
		}

		void setTestDescription(String testDescription) {
			this.testDescription = testDescription;
		}

		void setTestName(String testName) {
			this.testName = testName;
		}

		void setTestType(String testType) {
			this.testType = testType;
		}
	}
}
