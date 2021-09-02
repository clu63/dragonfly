//TODO Alert handling get and verify
//TODO alertFind complete, determine which is best approach and choose method delete one
//TODO Create an array json for link values from output link name
//TODO Update json with results status timing step details
//TODO Confirm all browsers work
//TODO Json Element properties combine , using json format for key and value
//TODO Reporting add step details
//TODO Encryption
//TODO Add comment to file for changes
//TODO create a level for logging and add a global variable and a switch statement to  logger.add with several levels to filter what calls are added to  logger.add with a new input parameter intLevel
//TODO add recursive method for iframes
//TODO create new method for attribute setup to only call once per step
//TODO class to validate keywords for all standard
// sample of variable names
//strPathTestSteps
//strFileTestSteps
//strNameTestSteps
//strValueTestSteps
//
//
//Member variables can be accessed outside a class with following rules
//
//Modifier      Package  Subclass  World
//
//public          Yes      Yes     Yes
//
//protected       Yes      Yes     No
//
//Default (no
//modifier)       Yes       No     No
//
package org.DragonflyAutomation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Dragonfly {
	// System.exit(0);
	TestConfigurationSetup objTestConfigurationSetup = new TestConfigurationSetup();

	@SuppressWarnings("unused")
	public class StepSetupDefaults {
		String strDefault_blnExitOnFail = "true";
		String strDefault_blnHighlight = "true";
		String strDefault_blnOptional = "false";
		String strDefault_blnPleaseWait = "true";
		String strDefault_blnScreenshot = "true";
		String strDefault_intMillisecondsToWait = "120000";
		String strDefault_strAssert = "off";
		String strDefault_strScreenshotArea = "screen";
		String strDefault_strStatus = "info";

		private StepSetupDefaults(String strCurrentWindowHandle) {
			String[] arrDefaultKeys = new StepNames().getDefault();
			String[] arrKeys = new StepNames().getRuntime();
			for (String strKey : arrKeys) {
				if (!strKey.equals("strTestModuleStep")) {
					JSONS.getInstance().step.putValue(strKey, "");
				}
			}
			new KeywordsValid();
			Class<?> objClass = null;
			try {
				objClass = Class.forName("org.DragonflyAutomation.Dragonfly$StepSetupDefaults");
			} catch (ClassNotFoundException e) {
				Logger.getInstance().add("StepSetupDefaults: ClassNotFoundException = " + e.toString());
			} catch (Exception e) {
				Logger.getInstance().add("StepSetupDefaults: Class.forName Exception = " + e.toString());
			}
			for (String strKey : arrDefaultKeys) {
				Field objField = null;
				try {
					objField = objClass.getDeclaredField("strDefault_" + strKey);
				} catch (NoSuchFieldException | SecurityException e) {
					Logger.getInstance().add("StepSetupDefaults: NoSuchFieldException = " + e.toString());
				} catch (Exception e) {
					Logger.getInstance().add("StepSetupDefaults: Exception = " + e.toString());
				}
				if (JSONS.getInstance().step.getValueLength(strKey) == 0) {
					try {
						JSONS.getInstance().step.putValue(strKey, (String) objField.get(this));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						Logger.getInstance().add("StepSetupDefaults: IllegalArgumentException = " + e.toString());
						e.printStackTrace();
					} catch (Exception e) {
						Logger.getInstance().add("StepSetupDefaults: Exception = " + e.toString());
					}
				}
			}
			JSONS.getInstance().step.putValue("strCurrentWindowHandle", strCurrentWindowHandle);
		}
	}

	public static void main(String[] args) {
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.mainDragonfly(args, objDragonfly);
	}

	public String data_DateDaysOut(String strDaysOut) {
		Logger.getInstance().add("  ==start==>data_DateDaysOut " + Util.getDateTimestamp());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat objFormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (objFormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_EnvironmentURL(String strApplication_Environment) {
		Logger.getInstance().add("data_EnvironmentURL: gstrEnvironment = " + Config.getInstance().environment);
		Logger.getInstance().add("  ==start==>data_EnvironmentURL " + Util.getDateTimestamp());
		String strURL = "";
		Logger.getInstance().add("data_EnvironmentURL: Paths.getInstance().pathTestData = " + Path.getInstance().testData);
		String strFilePathTestData = Path.getInstance().testData + "Environment.json";
		//gstrEnvironment
		Logger.getInstance().add("data_EnvironmentURL: strApplication_Environment = " + strApplication_Environment);
		try {
			Logger.getInstance().add("data_EnvironmentURL: gstrEnvironment = " + Config.getInstance().environment);
			if (!Config.getInstance().environment.equals("test value")) {
				String[] arrApplication_Environment = strApplication_Environment.split("_");
				strApplication_Environment = arrApplication_Environment[0] + "_" + Config.getInstance().environment;
				Logger.getInstance().add("data_EnvironmentURL: strApplication_Environment = " + strApplication_Environment);
			}
			Logger.getInstance().add("data_EnvironmentURL: strFilePathTestData = " + strFilePathTestData);
			JSON objJsonObjectFile = new JSON();
			objJsonObjectFile.replaceAllFromFile(strFilePathTestData);
			Logger.getInstance().add("data_EnvironmentURL: strApplication_Environment = " + strApplication_Environment);
			strURL = objJsonObjectFile.getString(strApplication_Environment);
			Logger.getInstance().add("data_EnvironmentURL: strURL = " + strURL);
		} catch (Exception e) {
			Logger.getInstance().add("data_EnvironmentURL: Exception = " + e.toString());
		}
		return strURL;
	}

	public String data_localWebsiteFilePath(String strWebsite) {
		Logger.getInstance().add("  ==start==>data_localWebsiteFilePath " + Util.getDateTimestamp());
		String strLocalWebsiteFilePath = "file:///" + Path.getInstance().systemUserDir.replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		Logger.getInstance().add("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public String data_RandomFourNumbers(String strDaysOut) {
		Logger.getInstance().add("  ==start==>data_RandomFourNumbers " + Util.getDateTimestamp());
		return Integer.toString(Util.randomNumberRange(1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(String strDataInput) {
		Logger.getInstance().add("  ==start==>data_RandomRangeFiveNumbers " + Util.getDateTimestamp());
		return Integer.toString(Util.randomNumberRange(1, 99999));
	}

	public void mainDragonfly(String[] args, Dragonfly objDragonfly) {
		//AutoItSetObject objAutoItSetObject = new AutoItSetObject();
		JSONArray objJsonArrayTestSteps = null;
		JSONArray objJsonArrayTestStepsRun = new JSONArray();
		JSONParser objJsonParser = new JSONParser();
		Boolean blnExit = false;
		Logger.getInstance().add("  ==start==>mainDragonfly " + Util.getDateTimestamp());
		//objAutoItSetObject.createObject();
		//Util.windowsMinimizeAll();
		String strNameTestConfiguration;
		try {
			new DialogLaunch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		strNameTestConfiguration = Config.getInstance().testName;
		System.out.println("strNameTestConfiguration = " + strNameTestConfiguration);
		if (strNameTestConfiguration == null) {
			System.exit(0);
		}
		int intStep = 0;
		int intLoopCount = 0;
		int intLoopEach = 0;
		int intLoopStep = 0;
		int intTestInstanceEach = 0;
		Boolean blnIf = true;
		Boolean blnIfSet = false;
		String strCurrentWindowHandle = "";
		String strFileTestSteps = "";
		String strTestStatus = "";
		String strLoopExitValue = "";
		int intTestInstanceStart = 0;
		objTestConfigurationSetup.run(strNameTestConfiguration);
		int intTestInstanceSize = objTestConfigurationSetup.intTestInstanceSize;
		if (intTestInstanceSize == 0) {
			intTestInstanceStart = -1;
		}
		String strTestStepsCombinedOriginal = JSONS.getInstance().testSteps.toString();
		for (intTestInstanceEach = intTestInstanceStart; intTestInstanceEach < intTestInstanceSize; intTestInstanceEach++) {
			try {
				if (intTestInstanceEach > 0) {
					new SleepMilliseconds(100);
					System.out.println("@@@@@@@@@@@@@The start of Iteration " + intTestInstanceSize);
				}
				Logger.getInstance().add(">>>>>>mainDragonfly: JSONS.getInstance().step " + JSONS.getInstance().step);
				objJsonArrayTestStepsRun.clear();
				intStep = 0;
				intLoopCount = 0;
				intLoopEach = 0;
				intLoopStep = 0;
				strCurrentWindowHandle = "";
				strTestStatus = "pass";
				Path.getInstance().setPathResults(intTestInstanceSize, strNameTestConfiguration);
				objJsonArrayTestSteps = (JSONArray) objJsonParser.parse(strTestStepsCombinedOriginal);
				if (intTestInstanceSize > 0) {
					JSONS.getInstance().testInstancesEach.replaceAllFromMap((Map<String, String>) JSONS.getInstance().testInstances.get(intTestInstanceEach));
				}
				strFileTestSteps = Path.getInstance().testSteps + strNameTestConfiguration.replace(".json", ".html");
				new WriteJsonStepsToHtml(Path.getInstance().results, "original", objJsonArrayTestSteps, "StepsOriginal.html");
				for (intStep = 0; intStep < objJsonArrayTestSteps.size(); intStep++) {
					Logger.getInstance().add("mainDragonfly: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					Element.getInstance().element = null;
					JSONS.getInstance().step.replaceAllFromString((String) objJsonArrayTestSteps.get(intStep).toString());
					new StepSetupDefaults(strCurrentWindowHandle);
					String strInputValue = JSONS.getInstance().step.getString("strInputValue");
					for (String strKey : new StepNames().getOriginal()) {
						Logger.getInstance().add("LogStepDetails: " + strKey + " = " + JSONS.getInstance().step.getString(strKey));
					}
					if (JSONS.getInstance().step.getString("strLoopOrIf").trim().length() > 0) {
						if (JSONS.getInstance().step.getString("strLoopOrIf").toLowerCase().startsWith("<loopstart>") == true) {
							if (intLoopEach == 0) {
								intLoopCount = Integer.parseInt(JSONS.getInstance().step.getString("strLoopOrIf").substring(11));
								JSONS.getInstance().step.putValue("strLoopOrIf", "");
								intLoopEach = 1;
								intLoopStep = intStep;
							}
						}
					}
					if (!JSONS.getInstance().step.verifyEquals("strFunction", "")) {
						String strMethodName = JSONS.getInstance().step.getString("strFunction");
						String strArguments = strInputValue;
						Class<?> objClass = Class.forName("org.DragonflyAutomation.Dragonfly");
						Class<?> objParameterTypes[] = new Class[1];
						objParameterTypes[0] = String.class;
						Method objMethod = objClass.getMethod(strMethodName, objParameterTypes);
						Object arrArgumentList[] = new Object[1];
						arrArgumentList[0] = new String(strArguments);
						Object objReturn = objMethod.invoke(objDragonfly, arrArgumentList);
						String strReturnValue = (String) objReturn;
						strInputValue = strReturnValue.toString();
						JSONS.getInstance().step.putValue("strInputValue", strInputValue);
					}
					switch (JSONS.getInstance().step.returnKeyword("strLoopOrIf")) {
					case "<elseif>":
						if (blnIfSet.equals(true)) {
							blnIf = false;
						} else {
							blnIf = true;
						}
						break;
					case "<else>":
						if (blnIfSet.equals(true)) {
							blnIf = false;
						} else {
							blnIf = true;
						}
						break;
					}
					if (blnIf == true) {
						Logger.getInstance().add("mainDragonfly: strInputValue = " + strInputValue);
						if (strInputValue.trim().equalsIgnoreCase("<skip>")) {
							JSONS.getInstance().step.putValue("strStepActual", "skip");
							new StepDuration("<skip>", System.currentTimeMillis(), "skip");
						} else {
							switch (JSONS.getInstance().step.getLowerCase("strAction")) {
							case "break":
								Logger.getInstance().add("mainDragonfly: switch strAction = break was entered to at this step to stop execution");
								JSONS.getInstance().step.putValue("strStepActual", "break");
								new StepDuration("break", System.currentTimeMillis(), "break");
								blnExit = true;
								break;
							case "close":
								new BrowserCloseSync();
								break;
							case "drag":
								new ElementDragSync();
								break;
							case "drop":
								new ElementDropSync();
								break;
							case "get":
								new ElementGetSync();
								break;
							case "kill_ie":
								long lngStartTime = System.currentTimeMillis();
								UtilProcess.killInternetExplorer();
								JSONS.getInstance().step.putValue("strStepActual", "kill_ie");
								new StepDuration("kill_ie", lngStartTime, "kill_ie");
								break;
							case "launch":
								new BrowserLaunchSync();
								break;
							case "mouse_over":
								new ElementOnMouseOverSync();
								break;
							case "mouse_out":
								new ElementOnMouseOutSync();
								break;
							case "refresh":
								new BrowserRefreshSync();
								break;
							case "scroll":
								new ElementScrollSync();
								break;
							case "set":
								new ElementSetSync(false);
								break;
							case "set_js":
								new ElementSetSync(true);
								break;
							case "sleep":
								new SleepSync();
								break;
							case "sync_disabled":
								new ElementDisabledSync();
								break;
							case "sync_enabled":
								new ElementEnabledSync();
								break;
							case "sync_hidden":
								new ElementHiddenSync();
								break;
							case "sync_visible":
								new ElementVisibleSync();
								break;
							case "tooltip_get":
								new ElementTooltipGetSync();
								break;
							case "verify":
								new ElementVerifyValueSync();
								break;
							case "verify_not":
								new ElementVerifyNotValueSync();
								break;
							default:
								Logger.getInstance().add("mainDragonfly: switch strAction = " + JSONS.getInstance().step.getLowerCase("strAction") + "  not supported");
								new StepDuration("action", System.currentTimeMillis(), "action");
								blnExit = true;
								break;
							}
							strCurrentWindowHandle = JSONS.getInstance().step.getString("strCurrentWindowHandle");
						}
						if (JSONS.getInstance().step.getString("strOutputLinkName").trim().length() != 0) {
							JSONS.getInstance().links.putValue(JSONS.getInstance().step.getString("strOutputLinkName"), JSONS.getInstance().step.getString("strOutputValue"));
						}
						objJsonArrayTestStepsRun.add(JSONS.getInstance().step.toJSONString());
						Logger.getInstance().add("mainDragonfly: objJsonArrayTestStepsRun - " + objJsonArrayTestStepsRun);
						if (blnExit == true) {
							break;
						}
						if (JSONS.getInstance().step.verifyEquals("strStatus", "fail")) {
							strTestStatus = "fail";
							if (JSONS.getInstance().step.getBoolean("blnExitOnFail") == true) {
								new WebElementCollectionTable(JSONS.getInstance().step.getString("strTagName"));
								break;
							}
						}
					}
					switch (JSONS.getInstance().step.returnKeyword("strLoopOrIf")) {
					case "<loopexit>":
						strLoopExitValue = JSONS.getInstance().step.getString("strLoopOrIf").substring(10);
						if (JSONS.getInstance().step.verifyEquals("strOutputValue", strLoopExitValue)) {
							intLoopCount = 0;
							intLoopEach = 0;
						}
						break;
					case "<loopend>":
						if (intLoopEach == intLoopCount) {
							intLoopCount = 0;
							intLoopEach = 0;
						} else {
							intLoopEach = intLoopEach + 1;
							intStep = intLoopStep - 1;
						}
						break;
					case "<if>":
						if (JSONS.getInstance().step.verifyEquals("strStatus", "pass")) {
							blnIf = true;
							blnIfSet = true;
						} else {
							blnIf = false;
						}
						break;
					case "<elseif>":
						if (blnIfSet.equals(false)) {
							if (JSONS.getInstance().step.verifyEquals("strStatus", "pass")) {
								blnIf = true;
								blnIfSet = true;
							} else {
								blnIf = false;
							}
						}
						break;
					case "<endif>":
						blnIf = true;
						blnIfSet = false;
						break;
					}
				}
			} catch (Exception e) {
				Logger.getInstance().add("mainDragonfly: Exception " + e.toString());
			} finally {
				UtilFile.write(Path.getInstance().results + "StepsAfterRun.json", objJsonArrayTestStepsRun.toString());
				UtilFile.write(Path.getInstance().results + "StepsWithDefaults.json", JSONS.getInstance().testSteps.toString());
				new WriteJsonStepsToHtml(Path.getInstance().results, "original", objJsonArrayTestStepsRun, "StepsWithDefaults.html");
				new WriteJsonStepsToHtml(Path.getInstance().results, "complete", objJsonArrayTestStepsRun, "StepsAfterRun.html");
				new WriteReportToHtml(Path.getInstance().results + "Report.html", objJsonArrayTestStepsRun, strFileTestSteps, strNameTestConfiguration.replace(".json", ""));
				UtilFile.write(Path.getInstance().results + "Dragonfly.log", Logger.getInstance().getLog());
				UtilFile.write(Path.getInstance().results + "StepsManual.txt", StepsManual.getInstance().get());
				Path.getInstance().changeDirectoryNameStatus(strTestStatus);
				if (BrowserDriver.getInstance().browserDriver.toString().contains("InternetExplorerDriver")) {
					//	new WindowsProcessKill("taskkill /F /IM IEDriverServer_32.exe");
				}
			}
			Logger.getInstance().deleteLog();
			StepsManual.getInstance().delete();
		}
	}
}
