package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;
import com.google.common.base.Stopwatch;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class Dragonfly2 {
	public static void main(String[] args) {
		// TestDataList
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_data\\td_test.json");
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestDataList testDataList = gson.fromJson(jsonFile, TestDataList.class);
			//getTestDataCount
			System.out.println("getTestDataCount = " + testDataList.getTestDataCount());
			System.out.println(gson.toJson(testDataList));
			//getValueByName
			System.out.println("getValueByName = " + testDataList.getValueByName("firstName"));
			//setValueByName
			testDataList.setValueByName("lastName", "lastName");
			System.out.println(gson.toJson(testDataList));
			//addTestData
			testDataList.addTestData("newName", "newValue");
			System.out.println(gson.toJson(testDataList));
			//getTestDataCount
			System.out.println("getTestDataCount = " + testDataList.getTestDataCount());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
		// TestInstancesList
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_test.json");
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestInstanceList testInstanceList = gson.fromJson(jsonFile, TestInstanceList.class);
			//getInstanceCount
			System.out.println("getInstanceCount = " + testInstanceList.getInstanceCount());
			System.out.println(gson.toJson(testInstanceList));
			//getInstanceValueByName
			System.out.println("getInstanceValueByName = " + testInstanceList.getInstanceValueByName(1, "firstName"));
			//setInstanceValueByName
			testInstanceList.setInstanceValueByName(0, "lastName", "lastName");
			System.out.println(gson.toJson(testInstanceList));
			//addInstanceByNumber
			testInstanceList.addInstanceByNumber(0, "newName", "newValue");
			System.out.println(gson.toJson(testInstanceList));
			// add new instance
			testInstanceList.addInstance("AddInstanceName", "AddInstanceValue");
			System.out.println(gson.toJson(testInstanceList));
			//getInstanceCount
			System.out.println("getInstanceCount = " + testInstanceList.getInstanceCount());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
		// TestInstancesList
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_test.json");
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			Type TestInstancesType = new TypeToken<List<ArrayList<TestData>>>() {
			}.getType();
			List<List<TestData>> testInstanceList = new Gson().fromJson(jsonFile, TestInstancesType);
			System.out.println(gson.toJson(testInstanceList));
			//getValueByName(Integer instance, String name)
			System.out.println(testInstanceList.get(1).get(0).getName());
			System.out.println(testInstanceList.get(1).get(0).getValue());
			//set new values to second instance first object
			testInstanceList.get(1).get(0).setName("XXXXXXXXXXXXXX");
			testInstanceList.get(1).get(0).setValue("XXXXXXXXXXXXXX");
			System.out.println(gson.toJson(testInstanceList));
			//add object to first instance  
			TestData testData = new TestData();
			testData.setName("addName");
			testData.setValue("addValue");
			testInstanceList.get(0).add((TestData) testData);
			System.out.println(gson.toJson(testInstanceList));
			// add new instance
			TestData testData2 = new TestData();
			testData2.setName("AddInstanceName");
			testData2.setValue("AddInstanceValue");
			List<TestData> testDataList = new ArrayList<TestData>();
			testDataList.add(testData2);
			testInstanceList.add(testDataList);
			System.out.println(gson.toJson(testInstanceList));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		System.exit(0);
		//TestElementList
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_elements\\te_test.json");
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestElementList testElement = gson.fromJson(jsonFile, TestElementList.class);
			System.out.println(gson.toJson(testElement));
			System.out.println(gson.toJson(testElement));
			System.out.println(testElement.getTestApplication());
			testElement.setTestApplication("test");
			System.out.println(testElement.getTestApplication());
			//System.out.println(testElement.getElement().size());
			//System.out.println(testElement.getElement().get(0).getLogicalName());
			System.out.println("------");
			if (testElement.findElement("SelectDisabled")) {
				System.out.println(testElement.getElement().getAttributeNames());
				System.out.println(testElement.getElement().getAttributeValues());
				System.out.println(testElement.getElement().getTagName());
			}
			TestElementList te = new TestElementList();
			TestElementList.Objects objects = te.new Objects();
			objects.setAttributeNames("newErrorAN");
			objects.setAttributeValues("newattributeValues");
			objects.setLogicalName("newlogicalName");
			objects.setTagName("newtagName");
			testElement.getError().add(objects);
			System.out.println(gson.toJson(testElement));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		System.exit(0);
		//TestElement
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_elements\\te_test.json");
			//System.out.println(jsonFile);
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestElement testElement = gson.fromJson(jsonFile, TestElement.class);
			System.out.println(gson.toJson(testElement));
			System.out.println(testElement.getTestApplication());
			testElement.setTestApplication("test");
			System.out.println(testElement.getTestApplication());
			System.out.println(testElement.getElement()[0].getLogicalName());
			testElement.getElement()[0].setLogicalName("elementlogicalname");
			testElement.getError()[0].setLogicalName("errorlogicalname");
			testElement.getProcessing()[0].setLogicalName("processlogicalname");
			System.out.println(gson.toJson(testElement));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		System.exit(0);
		// TestInstances
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_test.json");
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestInstance[][] testInstances = gson.fromJson(jsonFile, TestInstance[][].class);
			System.out.println(gson.toJson(testInstances));
			System.out.println(gson.toJson(testInstances.length));
			System.out.println(testInstances[0].length);
			System.out.println(testInstances[1].length);
			System.out.println(testInstances[1][1].getName());
			System.out.println(testInstances[1][1].getValue());
			System.out.println(testInstances[1][1].getValue());
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		System.exit(0);
		// TestData 
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_data\\td_template.json");
			System.out.println(jsonFile);
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestData testData[] = gson.fromJson(jsonFile, TestData[].class);
			System.out.println(testData);
			System.out.println(gson.toJson(testData));
			System.out.println(testData[0].getName());
			System.out.println(testData[0].getValue());
			testData[1].setName("setName");
			testData[1].setValue("setValue");
			System.out.println(gson.toJson(testData));
			System.out.println(testData.length);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		System.exit(0);
		try {
			URL url = new URL("");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in, encoding);
			System.out.println(body);
		} catch (Exception e2) {
		}
		System.exit(0);
		//		try {
		//		FileReader jsonFile =	new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_modules\\tm_atw_framestest.json");
		//		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		//		TestModule[] userArray = gson.fromJson(jsonFile, TestModule[].class);
		//		System.out.println(gson.toJson(userArray));
		//		} catch (FileNotFoundException e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}
		//		try {
		//		FileReader jsonFile =	new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_configuration\\atw_frames.json");
		//		//System.out.println(jsonFile);
		//		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		//		
		//		Root userArray = gson.fromJson(jsonFile, Root.class);
		//		System.out.println(userArray.getTest_modules());
		//		System.out.println(gson.toJson(userArray));
		//		} catch (FileNotFoundException e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}	
		//		try {
		//			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_elements\\te_test.json");
		//			//System.out.println(jsonFile);
		//			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		//			//TestElement.Root2 testElement = gson.fromJson(jsonFile, TestElement.Root2.class);
		//			System.out.println(testElement.getTestElements());
		//			System.out.println(gson.toJson(testElement));
		//		} catch (FileNotFoundException e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}
		//		System.exit(0);
		Stopwatch.createStarted();
		//Logger.getInstance().add("  ==start==>mainDragonfly2 " + Util.getDateTimestamp());
		TimeLogger outside = new TimeLogger("Dragonfly2");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TimeLogger inside = new TimeLogger("CoordinatesElement");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//inside.stop("Dragonfly2");
		outside.stopFinally("done already");
		//System.out.println("inside  " + inside.getDuration());
		//System.out.println("outside  " + outside.getDuration());
		int test = 95;
		new TimeLogger("Dragonfly2");
		inside.stop("");
		inside.stop("objElementPoint.x " + test);
		inside.stop("objElementPoint.x " + test++);
		inside.stop("objElementPoint.x " + test++);
		outside.stop("objElementPoint.x " + test++);
		outside.stop("");
		inside.stamp("objElementPoint.x " + test++);
		inside.stamp("objElementPoint.x " + test++);
		inside.stamp("objElementPoint.x " + test++);
		outside.stamp("objElementPoint.x " + test++);
		inside.stopCatch("");
		inside.stopFinally("objElementPoint.x " + test++);
		outside.stopCatch("objElementPoint.x " + test++);
		outside.stopFinally("objElementPoint.x " + test++);
		//System.out.println(Stopwatch.createStarted().elapsed());
		System.exit(0);
		Logger.getInstance().add("  ==start==>mainDragonfly " + Util.getDateTimestamp());
		if (new Execution().getSource().equals("local")) {
			System.out.println(OperatingSystem.get());
			System.out.println(Config.getInstance().devicePixelRatio);
			System.out.println(Math.PI);
			try {
				//	new DialogLocal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Path.getInstance().setDirectory(new ManualTestSelection().testArea);
		//objTestConfigurationSetup.run(strNameTestConfiguration);
	}
}
