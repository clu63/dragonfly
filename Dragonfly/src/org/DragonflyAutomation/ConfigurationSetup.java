//package org.DragonflyAutomation;
//
//import java.util.Iterator;
//import java.util.Map;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//public class ConfigurationSetup {
//
//		private int intTestInstanceSize;
//		private JSON objJsonObjectTestConfigurationFile = new JSON();
//
//		@SuppressWarnings("unchecked")
//		private JSONArray putAllArrays(String strJsonArrayName, String strJsonObjectName, String strPath) {
//			int intJsonArrayEach = 0;
//			JSONArray objJsonArray = null;
//			JSONArray objJsonArrayEach = null;
//			JSONArray objJsonArrayList = null;
//			JSON objJsonObjectFileEach = new JSON();
//			String strFileNameEach = "";
//			String strFilePathJsonArray = "";
//			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.getArray(strJsonArrayName);
//			if (objJsonArrayList == null) {
//				// if (objJsonArrayList.size() == 0) ||  (objJsonArrayList() == null){
//				return null;
//			} else {
//				for (intJsonArrayEach = 0; intJsonArrayEach < objJsonArrayList.size(); intJsonArrayEach++) {
//					strFileNameEach = objJsonArrayList.get(intJsonArrayEach).toString();
//					strFilePathJsonArray = strPath + strFileNameEach;
//					Logger.getInstance().add("TestConfigurationSetup:putAllArrays strFilePathJsonArray = " + strFilePathJsonArray);
//					try {
//						objJsonObjectFileEach.replaceAllFromFile(strFilePathJsonArray);
//						objJsonArrayEach = (JSONArray) objJsonObjectFileEach.getArray(strJsonObjectName);
//						int intStep = -1;
//						Iterator<JSONObject> iterator = objJsonArrayEach.iterator();
//						while (iterator.hasNext()) {
//							intStep++;
//							iterator.next().put("strTestModuleStep", strFileNameEach.replace(".json", "") + ": " + intStep);
//						}
//						Iterator<JSONObject> iterator2 = objJsonArrayEach.iterator();
//						while (iterator2.hasNext()) {
//							System.out.println(iterator2.next());
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						Logger.getInstance().add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
//						e.printStackTrace();
//					}
//					if (intJsonArrayEach == 0) {
//						objJsonArray = objJsonArrayEach;
//					} else {
//						objJsonArray.addAll(objJsonArrayEach);
//					}
//				}
//			}
//			Logger.getInstance().add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
//			return objJsonArray;
//		}
//
//		@SuppressWarnings("unchecked")
//		private JSON putAllObjects(String strJsonArrayName, String strJsonObjectName, String strPath) {
//			Logger.getInstance().add("  ==start==>putAllObjects " + Util.getDateTimestamp());
//			Integer intJsonObjectEach = 0;
//			JSONArray objJsonArrayList = null;
//			JSON objJsonObject = new JSON();
//			JSON objJsonObjectEach = new JSON();
//			JSON objJsonObjectFileEach = new JSON();
//			String strFileNameEach = "";
//			String strFilePathJsonArray = "";
//			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.getArray(strJsonArrayName);
//			//			if (objJsonArrayList == null) {
//			//				Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonArrayList.size() = NULL" );
//			//				return objJsonObject;
//			//			}
//			Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonArrayList.size() " + objJsonArrayList.size());
//			for (intJsonObjectEach = 0; intJsonObjectEach < objJsonArrayList.size(); intJsonObjectEach++) {
//				strFileNameEach = objJsonArrayList.get(intJsonObjectEach).toString();
//				Logger.getInstance().add("TestConfigurationSetup:putAllObjects strFileNameEach " + strFileNameEach);
//				strFilePathJsonArray = strPath + strFileNameEach;
//				Logger.getInstance().add("TestConfigurationSetup:putAllObjects strFilePathJsonArray = " + strFilePathJsonArray);
//				try {
//					objJsonObjectFileEach.replaceAllFromFile(strFilePathJsonArray);
//					Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonObjectFileEach = " + objJsonObjectFileEach);
//					objJsonObjectEach.replaceAllFromMap((Map<String, String>) objJsonObjectFileEach.getArray(strJsonObjectName));
//					Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonObjectEach = " + objJsonObjectEach);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				objJsonObject.replaceAllFromJSONObject(objJsonObjectEach.jSONObject);
//			}
//			Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonObject = " + objJsonObject);
//			return objJsonObject;
//		}
//
//		private void run(String strFileNameTestConfiguration) {
//			// TODO complete TestConfigurationSetup method to create json objects for test
//			Logger.getInstance().add("  ==start==>TestConfigurationSetup " + Util.getDateTimestamp());
//			long lngStartTime = System.currentTimeMillis();
//			String strFilePathTestConfiguration = "";
//			try {
//				strFilePathTestConfiguration = Paths.getInstance().pathTestConfiguration + strFileNameTestConfiguration;
//				Logger.getInstance().add("TestConfigurationSetup: strPathTestConfiguration = " + strFilePathTestConfiguration);
//				objJsonObjectTestConfigurationFile.replaceAllFromFile(strFilePathTestConfiguration);
//				Logger.getInstance().add("TestConfigurationSetup: objJsonObjectTestConfigurationFile = " + objJsonObjectTestConfigurationFile.toJSONString());
//				// test_instances
//				Logger.getInstance().add("TestConfigurationSetup: test_instances");
//				if (this.putAllArrays("test_instances", "test_instances", Paths.getInstance().pathTestInstances) == null) {
//					gobjJsonArrayTestInstances = null;
//					intTestInstanceSize = 0;
//				} else {
//					gobjJsonArrayTestInstances = this.putAllArrays("test_instances", "test_instances", Paths.getInstance().pathTestInstances);
//					intTestInstanceSize = gobjJsonArrayTestInstances.size();
//				}
//				// test_elements
//				Logger.getInstance().add("TestConfigurationSetup: test_elements");
//				gobjectElement = this.putAllObjects("test_elements", "elements", Paths.getInstance().pathTestElements);
//				// processing
//				Logger.getInstance().add("TestConfigurationSetup: processing");
//				gobjectProcessing = this.putAllObjects("test_elements", "processing", Paths.getInstance().pathTestElements);
//				// test_modules
//				Logger.getInstance().add("TestConfigurationSetup: test_modules");
//				gobjJsonArrayTestSteps = this.putAllArrays("test_modules", "steps", Paths.getInstance().pathTestModules);
//				Logger.getInstance().add("TestConfigurationSetup: gobjJsonArrayTestSteps.toString = " + gobjJsonArrayTestSteps.toString());
//				// TODO add error handling, report no test modules and fail
//				// test_links
//				gobjectLinks.parseString("{\"link\":[{}]}");
//				// test_data
//				Logger.getInstance().add("TestConfigurationSetup: test_data");
//				gobjectTestData = this.putAllObjects("test_data", "test_data", Paths.getInstance().pathTestData);
//			} catch (Exception e) {
//				Logger.getInstance().add("TestConfigurationSetup: Exception = " + e.toString());
//			} finally {
//				Logger.getInstance().add("TestConfigurationSetup: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
//			}
//		}
//	}
