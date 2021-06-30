package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

class ConfigurationSetup {
	ConfigurationSetup(String TestConfigurationFileName) throws FileNotFoundException {
		//TestConfiguration
		//FileReader jsonFile = new FileReader(Path.getInstance().testConfiguration + TestConfigurationFileName);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		TestConfiguration testConfiguration = gson.fromJson(new FileReader(Path.getInstance().testConfiguration + TestConfigurationFileName), TestConfiguration.class);
		System.out.println(testConfiguration.getTestDetailsTestName());
		System.out.println(testConfiguration.getTestDetailsTestDescription());
		System.out.println(testConfiguration.getTestDetailsTestType());
		System.out.println(gson.toJson(testConfiguration));
		//		testConfiguration.addTestElement("testElement.json");
		//		System.out.println(testConfiguration.removeTestElement("te_test2.json"));
		//		System.out.println(testConfiguration.removeTestElement("te_test22.json"));
		//		
		//		testConfiguration.addTestModule("testModule.json");
		//		System.out.println(testConfiguration.removeTestModule("tm_atw_test2.json"));
		//		System.out.println(testConfiguration.removeTestModule("tm_atw_test22.json"));
		//		
		//		testConfiguration.addTestData("testData.json");
		//		System.out.println(testConfiguration.removeTestData("td_test1.json"));
		//		System.out.println(testConfiguration.removeTestData("td_test11.json"));
		//		
		//		testConfiguration.setTestDetailsTestName("testName");
		//		testConfiguration.setTestDetailsTestDescription("testDescription");
		//		testConfiguration.setTestDetailsTestType("testType");
		//		
		//		System.out.println(gson.toJson(testConfiguration));
		//		
		//		
		//		System.out.println(testConfiguration.getTestDetailsTestName());
		//		System.out.println(testConfiguration.getTestDetailsTestDescription());
		//		System.out.println(testConfiguration.getTestDetailsTestType());
		//		System.out.println(testConfiguration.getTestDetails().getTestName());
		//		System.out.println(testConfiguration.getTestDetails().getTestDescription());
		//		System.out.println(testConfiguration.getTestDetails().getTestType());
		List<TestStep.TestStepFields> testStepList = new ArrayList<TestStep.TestStepFields>();
		for (String testModule : testConfiguration.getTestModule()) {
			//System.out.println(testModule);
			TestStep testStep = gson.fromJson(new FileReader(Path.getInstance().testModules + testModule), TestStep.class);
			//System.out.println(gson.toJson(testStep));
			//System.out.println(gson.toJson(testStep.getTestModule()));
			testStepList.addAll(testStep.getTestModule());
		}
		System.out.println(gson.toJson(testStepList));
		for (String testElement : testConfiguration.getTestElement()) {
			System.out.println(testElement);
		}
		for (String testInstance : testConfiguration.getTestInstance()) {
			System.out.println(testInstance);
		}
		for (String testData : testConfiguration.getTestData()) {
			System.out.println(testData);
		}
		TestStepDefault testStepDefault = gson.fromJson(new FileReader(Path.getInstance().testModules + "tm_default.json"), TestStepDefault.class);
		System.out.println(gson.toJson(testStepDefault));
		TestStepDefault.TestStepDefaultFields testStepDefaultFields = testStepDefault.getTestStepDefaultFields();
		for (TestStep.TestStepFields testStepListEach : testStepList) {
			if (testStepListEach.getAssertSet() == null) {
				testStepListEach.setAssertSet(testStepDefaultFields.getAssertSet());
			}
			if (testStepListEach.getOptional() == null) {
				testStepListEach.setOptional(testStepDefaultFields.getOptional());
			}
		}
		System.out.println(gson.toJson(testStepList));
	}
}
