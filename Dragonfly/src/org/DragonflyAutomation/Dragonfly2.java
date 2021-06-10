package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import org.DragonflyAutomation.GsonArrayMember.Department;
import org.apache.commons.io.IOUtils;
import com.google.common.base.Stopwatch;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class Dragonfly2 {
	public static void main(String[] args) {
		//TestConfiguration
		try {
			String filePath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_configuration\\template.json";
			//String filePath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_configuration\\atw_test.json";
			FileReader jsonFile = new FileReader(filePath);
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestConfiguration testConfiguration = gson.fromJson(jsonFile, TestConfiguration.class);
			System.out.println(gson.toJson(testConfiguration));
			UtilFile.write(filePath, gson.toJson(testConfiguration));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		System.exit(0);
		// TestData
		try {
			//String filePath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_data\\td_template.json";
			String filePath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_data\\td_test.json";
			FileReader jsonFile = new FileReader(filePath);
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestData testData = gson.fromJson(jsonFile, TestData.class);
			//UtilFile.write(filePath, gson.toJson(testData));
			//getTestDataCount
			System.out.println("getTestDataCount = " + testData.getTestDataCount());
			System.out.println(gson.toJson(testData));
			//getValueByName
			System.out.println("getValueByName = " + testData.getValueByName("firstName"));
			//setValueByName
			testData.setValueByName("lastName", "lastName");
			System.out.println(gson.toJson(testData));
			//addTestData
			testData.addTestData("newName", "newValue");
			System.out.println(gson.toJson(testData));
			//getTestDataCount
			System.out.println("getTestDataCount = " + testData.getTestDataCount());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
		//		// TestInstance 
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_test.json");
			//FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_template.json");
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestInstance testInstance = gson.fromJson(jsonFile, TestInstance.class);
			//UtilFile.write("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_instances\\ti_template.json", gson.toJson(testInstance));
			//getInstanceCount
			System.out.println("getInstanceCount = " + testInstance.getInstanceCount());
			System.out.println(gson.toJson(testInstance));
			//getInstanceValueByName
			System.out.println("getInstanceValueByName = " + testInstance.getInstanceValueByName(1, "firstName"));
			//setInstanceValueByName
			testInstance.setInstanceValueByName(0, "lastName", "lastName");
			System.out.println(gson.toJson(testInstance));
			//addInstanceByNumber
			testInstance.addInstanceByNumber(0, "newName", "newValue");
			System.out.println(gson.toJson(testInstance));
			// add new instance
			testInstance.addInstance("AddInstanceName", "AddInstanceValue");
			System.out.println(gson.toJson(testInstance));
			//getInstanceCount
			System.out.println("getInstanceCount = " + testInstance.getInstanceCount());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
		//TestElement
		try {
			//String filePath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_elements\\te_template.json";
			String filePath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_elements\\te_test.json";
			FileReader jsonFile = new FileReader(filePath);
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestElement testElement = gson.fromJson(jsonFile, TestElement.class);
			System.out.println(gson.toJson(testElement));
			//UtilFile.write(filePath, gson.toJson(testElement));
			//						System.out.println(gson.toJson(testElement));
			//						System.out.println(testElement.getTestApplication());
			//						testElement.setTestApplication("test");
			//						System.out.println(testElement.getTestApplication());
			//						//System.out.println(testElement.getElement().size());
			//						//System.out.println(testElement.getElement().get(0).getLogicalName());
			//						System.out.println("------");
			//						if (testElementList.findElement("SelectDisabled")) {
			//							System.out.println(testElement.getElement().getAttributeNames());
			//							System.out.println(testElement.getElement().getAttributeValues());
			//							System.out.println(testElement.getElement().getTagName());
			//						}
			//						TestElementList te = new TestElementList();
			//						TestElementList.ObjectDetail objects = te.new ObjectDetail();
			//						objects.setAttributeNames("newErrorAN");
			//						objects.setAttributeValues("newattributeValues");
			//						objects.setLogicalName("newlogicalName");
			//						objects.setTagName("newtagName");
			//						testElementList.getError().add(objects);
			//						System.out.println(gson.toJson(testElementList));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		System.exit(0);
		//URL get response 
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
