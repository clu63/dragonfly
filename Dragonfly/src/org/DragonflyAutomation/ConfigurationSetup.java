package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.DragonflyAutomation.TestStep.TestStepDetails;
import com.google.gson.Gson;

class ConfigurationSetup {
	ConfigurationSetup(String TestConfigurationFileName) throws FileNotFoundException {
		//TestConfiguration
		//FileReader jsonFile = new FileReader(Path.getInstance().testConfiguration + TestConfigurationFileName);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		TestConfiguration testConfiguration = gson.fromJson(new FileReader(Path.getInstance().testConfiguration + TestConfigurationFileName), TestConfiguration.class);
		System.out.println(gson.toJson(testConfiguration));
		List<TestStepDetails>  testStepList = new ArrayList<TestStepDetails>();
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
	}
}
