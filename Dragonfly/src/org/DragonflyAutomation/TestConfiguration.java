package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;
import org.DragonflyAutomation.TestElement.ObjectDetail;

public class TestConfiguration {
	public TestConfigurationDetail testConfiguration;

	public class TestConfigurationDetail {
		public TestDetails testDetails;
		public List<String> testInstance = new ArrayList<String>();
		public List<String> testElement = new ArrayList<String>();
		public List<String> testModule = new ArrayList<String>();
		public List<String> testData = new ArrayList<String>();
	}

	public class TestDetails {
		public String testName;
		public String testDescription;
		public String testType;
	}
}
//class TestConfiguration {
//	public class Test_details {
//		private String test_name;
//		private String test_description;
//		private String test_type;
//
//		public void setTest_name(String test_name) {
//			this.test_name = test_name;
//		}
//
//		public String getTest_name() {
//			return this.test_name;
//		}
//
//		public void setTest_description(String test_description) {
//			this.test_description = test_description;
//		}
//
//		public String getTest_description() {
//			return this.test_description;
//		}
//
//		public void setTest_type(String test_type) {
//			this.test_type = test_type;
//		}
//
//		public String getTest_type() {
//			return this.test_type;
//		}
//	}
//
//	public class Root {
//		private Test_details test_details;
//		private List<String> test_instances;
//		private List<String> test_elements;
//		private List<String> test_modules;
//		private List<String> test_data;
//
//		public void setTest_details(Test_details test_details) {
//			this.test_details = test_details;
//		}
//
//		public Test_details getTest_details() {
//			return this.test_details;
//		}
//
//		public void setTest_instances(List<String> test_instances) {
//			this.test_instances = test_instances;
//		}
//
//		public List<String> getTest_instances() {
//			return this.test_instances;
//		}
//
//		public void setTest_elements(List<String> test_elements) {
//			this.test_elements = test_elements;
//		}
//
//		public List<String> getTest_elements() {
//			return this.test_elements;
//		}
//
//		public void setTest_modules(List<String> test_modules) {
//			this.test_modules = test_modules;
//		}
//
//		public List<String> getTest_modules() {
//			return this.test_modules;
//		}
//
//		public void setTest_data(List<String> test_data) {
//			this.test_data = test_data;
//		}
//
//		public List<String> getTest_data() {
//			return this.test_data;
//		}
//	}
//}
