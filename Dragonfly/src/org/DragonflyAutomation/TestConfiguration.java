package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

class TestConfiguration {
	private FileNames testConfiguration;

	//	TestConfiguration(String filePath) throws FileNotFoundException {
	//		FileReader jsonFile = new FileReader(filePath);
	//		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
	//		this.testConfiguration = gson.fromJson(jsonFile, TestConfiguration.class);
	//		System.out.println(gson.toJson(testConfiguration));
	//	}
	List<String> getTestModule() {
		return this.testConfiguration.testModule;
	}

	List<String> getTestInstance() {
		return this.testConfiguration.testInstance;
	}

	List<String> getTestElement() {
		return this.testConfiguration.testElement;
	}

	List<String> getTestData() {
		return this.testConfiguration.testData;
	}

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
