package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.DragonflyAutomation.TestInstance.TestInstanceFields;
import com.google.gson.Gson;

class ConfigurationSetup {
	//setup does not include Link or classByName
	ConfigurationSetup(String TestConfigurationFileName) throws FileNotFoundException {
		//TestConfiguration
		//FileReader jsonFile = new FileReader(Path.getInstance().testConfiguration + TestConfigurationFileName);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		TestConfiguration testConfiguration = gson.fromJson(new FileReader(Path.getInstance().testConfiguration + TestConfigurationFileName), TestConfiguration.class);
		System.out.println(testConfiguration.getTestDetailsTestName());
		System.out.println(testConfiguration.getTestDetailsTestDescription());
		System.out.println(testConfiguration.getTestDetailsTestType());
		//System.out.println(gson.toJson(testConfiguration));
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
		System.out.println(testConfiguration.getTestInstance());
		TestInstance testInstance = null;
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_test.json");
			//FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_template.json");
			gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			testInstance = gson.fromJson(jsonFile, TestInstance.class);
			//UtilFile.write("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_template.json", gson.toJson(testInstance));
			//getInstanceCount
			System.out.println("getInstanceCount = " + testInstance.getInstanceCount());
			//			System.out.println(gson.toJson(testInstance));
			//			//getInstanceValueByName
			//			System.out.println("getInstanceValueByName = " + testInstance.getInstanceValueByName(1, "firstName"));
			//			//setInstanceValueByName
			//			testInstance.setInstanceValueByName(0, "lastName", "lastName");
			//			System.out.println(gson.toJson(testInstance));
			//			//addInstanceByNumber
			//			testInstance.addInstanceByNumber(0, "newName", "newValue");
			//			System.out.println(gson.toJson(testInstance));
			//			// add new instance
			//			testInstance.addInstance("AddInstanceName", "AddInstanceValue");
			//			System.out.println(gson.toJson(testInstance));
			//			//getInstanceCount
			//			System.out.println("getInstanceCount = " + testInstance.getInstanceCount());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//System.exit(0);
		List<List<TestStep.TestStepFields>> testSteps = new ArrayList<List<TestStep.TestStepFields>>();
		List<TestStep.TestStepFields> testStepList = new ArrayList<TestStep.TestStepFields>();
		for (String testModule : testConfiguration.getTestModule()) {
			//System.out.println(testModule);
			TestStep testStep = gson.fromJson(new FileReader(Path.getInstance().testModules + testModule), TestStep.class);
			//System.out.println(gson.toJson(testStep));
			//System.out.println(gson.toJson(testStep.getTestModule()));
			testStepList.addAll(testStep.getTestModule());
		}
		
		Integer testInstanceCount = testInstance.getInstanceCount();
	
		
		for (int i = 0; i < testInstanceCount; i++) {
			testSteps.add(testStepList);
		}
		System.out.println(gson.toJson(testSteps));
		
		System.exit(0);
		
		for (String testElement : testConfiguration.getTestElement()) {
			System.out.println(testElement);
		}
		for (String testData : testConfiguration.getTestData()) {
			System.out.println(testData);
		}
		//replace the null values with TestStepDefaults
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
			if (testStepListEach.getExitOnFail() == null) {
				testStepListEach.setExitOnFail(testStepDefaultFields.getExitOnFail());
			}
			if (testStepListEach.getMillisecondsToWait() == null) {
				testStepListEach.setMillisecondsToWait(testStepDefaultFields.getMillisecondsToWait());
			}
			if (testStepListEach.getPleaseWait() == null) {
				testStepListEach.setPleaseWait(testStepDefaultFields.getPleaseWait());
			}
			if (testStepListEach.getHighlight() == null) {
				testStepListEach.setHighlight(testStepDefaultFields.getHighlight());
			}
			if (testStepListEach.getScreenshot() == null) {
				testStepListEach.setScreenshot(testStepDefaultFields.getScreenshot());
			}
			if (testStepListEach.getScreenshotArea() == null) {
				testStepListEach.setScreenshotArea(testStepDefaultFields.getScreenshotArea());
			}
			if (testStepListEach.getStatus() == null) {
				testStepListEach.setStatus(testStepDefaultFields.getStatus());
			}
		}
		System.out.println(gson.toJson(testStepList));
	}
}
