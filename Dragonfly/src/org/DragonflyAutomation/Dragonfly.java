//TODO Alert handling get and verify
//TODO Create an array json for link values from output link name
//TODO Update json with results status timing step details
//TODO Webtable for StepsAfterRun json file
//TODO Confirm all browsers work
//TODO Json Element properties combine , using json format for key and value
//TODO Reporting add step details
//TODO Encryption
//TODO Add comment to file for changes
//TODO Check changes to library files and save backup.
//TODO Copy library files to local drive.
//TODO check for StaleElementReferenceException included
//TODO create a level for logging and add a global variable and a switch statement to objDragonfly.objLogger.setLogRow with several levels to filter what calls are added to objDragonfly.objLogger.setLogRow with a new input parameter intLevel
//TODO clean up unneeded code for new methods and limit comments to objDragonfly.objLogger.setLogRow as needed for normal execution
//TODO add recursive method for iframes
//TODO change objSteps to a global variable
//TODO add option to find by.id, name, class etc based on what attributes are input
//TODO create new method for attribute setup to only call once per step
//TODO alertFind complete, determine which is best approach and choose method delete one
package org.DragonflyAutomation;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.apache.commons.io.FileUtils;
import org.ini4j.Reg;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import com.opera.core.systems.OperaDriver;

public class Dragonfly {
	// System.exit(0);
	//static Dragonfly objDragonfly = new Dragonfly();
	//CreateDragonlfyObject objCreateDragonlfyObject = new CreateDragonlfyObject();
	//Dragonfly objDragonfly = objCreateDragonlfyObject.getObject();
	Logger objLogger = new Logger();
	AutoItSetObject2 objAutoItSetObject2 = new AutoItSetObject2();
	//AutoItSetObject objAutoItSetObject = new AutoItSetObject();
	//AutoItX gobjAutoIt = null;
	//AutoItX gobjAutoIt2 = objAutoItSetObject.getObject();
	//	try {
	//		gobjAutoIt = objAutoIt.createObject();
	//	} catch (InterruptedException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	static Alert gobjAlert = null;
	//static AutoItX gobjAutoIt;
	static int gintTestInstanceEach = 0;
	static int gintTestInstanceSize = 0;
	static JSONArray gobjJsonArrayLink = null;
	static JSONArray gobjJsonArrayTestInstances = null;
	static JSONArray gobjJsonArrayTestSteps = null;
	static JSONArray gobjJsonArrayTestStepsComplete = null;
	static JSONObject gobjJsonObjectElement = null;
	static JSONObject gobjJsonObjectElements = null;
	static JSONObject gobjJsonObjectStepsFile = null;
	static JSONObject gobjJsonObjectTestDataFile = null;
	static JSONObject gobjJsonObjectLinks = null;
	static JSONObject gobjJsonObjectStep = new JSONObject();
	static JSONObject gobjJsonObjectTestInstance = null;
	static JSONObject gobjJsonObjectTestInstancesEach = null;
	static JSONParser gobjJsonParser = new JSONParser();
	static String gstrLog = "";
	static String gstrOperatingSystem = "";
	static String gstrPathData = "Data/public/";//"Data/internal/";//
	static String gstrPathElementRepository = gstrPathData + "element_repository/";
	static String gstrPathResultsFolder = "";
	static String gstrPathResultsIterationsFolder = "";
	static String gstrPathSystemUserDir = System.getProperty("user.dir");
	static String gstrPathTestData = gstrPathData + "test_data/";
	static String gstrPathTestInstances = gstrPathData + "test_instances/";
	static String gstrPathTestMatrix = gstrPathData + "test_matrix/";
	static String gstrPathTestModules = gstrPathData + "test_modules/";
	static String gstrTestStepsCombinedOriginal = "";
	static WebDriver gobjWebDriver = null;
	static WebElement gobjWebElement = null;
	static WebElement gobjWebElementDrag = null;
	static WebElement gobjWebElementDrop = null;

	//	public interface WebElement extends  Cloneable{
	//		public WebElement clone();
	//	}
	//	public class WebElement implements Cloneable
	//	{
	//	    @Override
	//	    public WebElement clone()
	//	    {
	//			return null;
	//	            // ... return a clone of this Widget
	//	    }
	//	}
	public class CreateDragonlfyObject {
		Dragonfly objDragonfly = new Dragonfly();

		public Dragonfly getObject() {
			return objDragonfly;
		}
	}

	public static class ElementNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementNotFoundException(String message) {
			super(message);
		}
	}

	public static class MultipleElementsFoundException extends Exception {
		private static final long serialVersionUID = 1L;

		public MultipleElementsFoundException(String message) {
			super(message);
		}
	}

	public static class ElementNotSetException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementNotSetException(String message) {
			super(message);
		}
	}

	public static class ElementNotVisibleException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementNotVisibleException(String message) {
			super(message);
		}
	}

	public static class ElementNotHiddenException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementNotHiddenException(String message) {
			super(message);
		}
	}

	public static class ElementNotEnabledException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementNotEnabledException(String message) {
			super(message);
		}
	}

	public static class ElementNotDisabledException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementNotDisabledException(String message) {
			super(message);
		}
	}

	public static class ValueNotMatchedException extends Exception {
		private static final long serialVersionUID = 1L;

		public ValueNotMatchedException(String message) {
			super(message);
		}
	}

	public static class ElementValueNotVerifiedException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementValueNotVerifiedException(String message) {
			super(message);
		}
	}

	public static class ElementTagNameNotSupportedException extends Exception {
		private static final long serialVersionUID = 1L;

		public ElementTagNameNotSupportedException(String message) {
			super(message);
		}
	}

	public static class BrowserDriverNotSupportedException extends Exception {
		private static final long serialVersionUID = 1L;

		public BrowserDriverNotSupportedException(String message) {
			super(message);
		}
	}

	public static class DoPostBackNotCompleteException extends Exception {
		private static final long serialVersionUID = 1L;

		public DoPostBackNotCompleteException(String message) {
			super(message);
		}
	}

	public static class JQueryAjaxNotCompleteException extends Exception {
		private static final long serialVersionUID = 1L;

		public JQueryAjaxNotCompleteException(String message) {
			super(message);
		}
	}

	public static class JQueryAnimationNotCompleteException extends Exception {
		private static final long serialVersionUID = 1L;

		public JQueryAnimationNotCompleteException(String message) {
			super(message);
		}
	}

	public static class AngularJsNotCompleteException extends Exception {
		private static final long serialVersionUID = 1L;

		public AngularJsNotCompleteException(String message) {
			super(message);
		}
	}

	public static class JSONKeyNotPresentException extends Exception {
		private static final long serialVersionUID = 1L;

		public JSONKeyNotPresentException(String message) {
			super(message);
		}
	}

	public static class TestInstanceMoreThanOneException extends Exception {
		private static final long serialVersionUID = 1L;

		public TestInstanceMoreThanOneException(String message) {
			super(message);
		}
	}

	public static void main(String[] args) {
		//new Dragonfly();
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>main " + dateTimestamp());
		objDragonfly.objAutoItSetObject2.createObject(objDragonfly);
		//objCreateDragonlfyObject
		//objDragonfly.Logger.("  ==start==>main " + dateTimestamp());
		//		SyncTime newSync = new Dragonfly().new SyncTime();
		//		newSync.start();
		//		sleepMilliseconds(1000);
		//		newSync.stop();
		//		sleepMilliseconds(1000);
		//		System.out.println(newSync.getDuration());
		//		stepsNames StepsNames = new Dragonfly().new stepsNames();
		//		String[] arrKeys = StepsNames.getComplete();
		//		for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
		//			String strKey = (String) arrKeys[intKeysEach].toString();
		//			objDragonfly.objLogger.setLogRow("jsonOrder2: " + strKey + " = " + strKey);
		//		}
		//		System.exit(0);
		//		//		SyncTime.start();
		//		//		
		//		//		  LocalInnerClass localInnerClass = new MyInnerClass().new LocalInnerClass();
		//		//		    localInnerClass.localInnerClassMethod();
		//		try {
		//			internetExplorerVersion();
		//		} catch (IOException e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}
		//		//		String value = WindowsReqistry.readRegistry("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\" + "Explorer\\Shell Folders", "Personal");
		//		//		System.out.println(value);
		//		System.exit(0);
		//testPage();
		// try {
		// objDragonfly.objLogger.setLogRow("clearMyTracksByProcessCookies start = ");
		// commandLineExecution();
		// // clearMyTracksByProcessCookies();
		// // clearMyTracksByProcessCache();
		// } catch (Exception e1) {
		// objDragonfly.objLogger.setLogRow("clearMyTracksByProcessCookies Exception = " + e1.toString());
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//webDriverTest();
		//		jsonOrder2();
		//		System.exit(0);
		//		JSONObject gobjJsonObjectTestInstancesEach = null;
		//		JSONObject gobjJsonObjectStep = new JSONObject();
		String strPathFullTestMatix = "";
		String strTestMatixFileName = "local_ATW_AlertPopups.json";
		int intStep = 0;
		int intMillisecondsToWaitDefault = 20000;
		int intFrame = -1;
		int intLoopCount = 0;
		int intLoopEach = 0;
		int intLoopStep = 0;
		String strCurrentWindowHandle = "";
		String strPathResults = "";
		String strPathImages = "";
		String strTestStatus = "";
		String strLoopExitValue = "";
		writeJsonStepsToHtml objWriteJsonStepsToHtml = new Dragonfly().new writeJsonStepsToHtml();
		//		try {
		//			autoItSetObject();
		//		} catch (InterruptedException e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}
		gstrOperatingSystem = oSType(objDragonfly);
		windowsMinimizeAll(objDragonfly);
		strPathFullTestMatix = gstrPathTestMatrix + strTestMatixFileName;
		objDragonfly.objLogger.setLogRow("main: strPathFullTestMatix = " + strPathFullTestMatix);
		testMatrixSetup(objDragonfly, strPathFullTestMatix);
		for (gintTestInstanceEach = 0; gintTestInstanceEach < gintTestInstanceSize; gintTestInstanceEach++) {
			try {
				gobjWebElement = null;
				gobjJsonArrayTestSteps = null;
				gobjJsonArrayTestSteps = (JSONArray) gobjJsonParser.parse(gstrTestStepsCombinedOriginal);
				objDragonfly.objLogger.setLogRow("main: gintTestInstanceSize = " + gintTestInstanceSize);
				gobjJsonObjectTestInstancesEach = (JSONObject) gobjJsonArrayTestInstances.get(gintTestInstanceEach);
				gobjJsonObjectStep = null;
				intStep = 0;
				intMillisecondsToWaitDefault = 20000;
				intFrame = -1;
				intLoopCount = 0;
				intLoopEach = 0;
				intLoopStep = 0;
				strCurrentWindowHandle = "";
				strPathResults = "";
				strPathImages = "";
				strTestStatus = "pass";
				gstrPathResultsFolder = gstrPathResultsIterationsFolder + dateTimestamp();
				objDragonfly.objLogger.setLogRow("main: Working Directory = " + gstrPathSystemUserDir);
				objDragonfly.objLogger.setLogRow("main: gstrOperatingSystem = " + gstrOperatingSystem);
				switch (gstrOperatingSystem) {
				case "Windows":
					strPathResults = gstrPathSystemUserDir + "\\Results\\" + strTestMatixFileName.replace(".json", "") + "\\" + gstrPathResultsFolder + "\\";
					strPathImages = "images\\";
					break;
				case "Mac":
					strPathResults = gstrPathSystemUserDir + "/Results/" + strTestMatixFileName.replace(".json", "") + "/" + gstrPathResultsFolder + "/";
					strPathImages = "images/";
					break;
				default:
					objDragonfly.objLogger.setLogRow("main: switch gstrOperatingSystem = " + gstrOperatingSystem + "  not supported");
					return;
				}
				objDragonfly.objLogger.setLogRow("main: strPathResults = " + strPathResults);
				new File(strPathResults).mkdirs();
				new File(strPathResults + strPathImages).mkdirs();
				objWriteJsonStepsToHtml.createReport(objDragonfly, "original", gobjJsonArrayTestSteps, strPathResults, "StepsOriginal.html");
				//writeJsonStepsToHtml("original", gobjJsonArrayTestSteps, strPathResults, "StepsOriginal.html");
				objDragonfly.objLogger.setLogRow("main: gobjJsonArrayTestSteps.size() = " + gobjJsonArrayTestSteps.size());
				for (intStep = 0; intStep < gobjJsonArrayTestSteps.size(); intStep++) {
					objDragonfly.objLogger.setLogRow("main: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					gobjWebElement = null;
					gobjJsonObjectStep = (JSONObject) gobjJsonArrayTestSteps.get(intStep);
					String strInputValue = gobjJsonObjectStep.get("strInputValue").toString();
					String strLogicalName = gobjJsonObjectStep.get("strLogicalName").toString();
					if (strLogicalName.toLowerCase().startsWith("<er>") == true) {
						strLogicalName = strLogicalName.replace("<er>", "");
						jsonObjectValidateKey(objDragonfly, gobjJsonObjectElement, strLogicalName);
						JSONObject objJsonObjectElementNode = (JSONObject) gobjJsonObjectElement.get(strLogicalName);
						jsonObjectStepPut("strTagName", jsonObjectGetValue(objDragonfly, objJsonObjectElementNode, "strTagName", ""));
						jsonObjectStepPut("strAttributeNames", jsonObjectGetValue(objDragonfly, objJsonObjectElementNode, "strAttributeNames", ""));
						jsonObjectStepPut("strAttributeValues", jsonObjectGetValue(objDragonfly, objJsonObjectElementNode, "strAttributeValues", ""));
					}
					if (strInputValue.toLowerCase().startsWith("<link>") == true) {
						strInputValue = jsonObjectGetValue(objDragonfly, gobjJsonObjectLinks, strInputValue, "<link>");
						jsonObjectStepPut("strInputValue", strInputValue);
					}
					if (strInputValue.toLowerCase().startsWith("<ti>") == true) {
						strInputValue = jsonObjectGetValue(objDragonfly, gobjJsonObjectTestInstancesEach, strInputValue, "<ti>");
						jsonObjectStepPut("strInputValue", strInputValue);
					}
					if (strInputValue.toLowerCase().startsWith("<td>") == true) {
						strInputValue = jsonObjectGetValue(objDragonfly, gobjJsonObjectTestDataFile, strInputValue, "<td>");
						jsonObjectStepPut("strInputValue", strInputValue);
					}
					if (gobjJsonObjectStep.get("intMillisecondsToWait").toString().trim().length() == 0) {
						jsonObjectStepPut("intMillisecondsToWait", Integer.toString(intMillisecondsToWaitDefault));
					}
					if (gobjJsonObjectStep.get("blnOptional").toString().trim().length() == 0) {
						jsonObjectStepPut("blnOptional", "false");
					}
					if (gobjJsonObjectStep.get("strAssert").toString().trim().length() == 0) {
						jsonObjectStepPut("strAssert", "off");
					}
					jsonObjectStepPut("blnPleaseWait", "true");
					jsonObjectStepPut("blnHighlight", "true");
					jsonObjectStepPut("blnScreenshot", "true");
					jsonObjectStepPut("strScreenshotArea", "screen");
					jsonObjectStepPut("strHighlightArea", "");
					if (gobjJsonObjectStep.get("blnExitOnFail").toString().trim().length() == 0) {
						jsonObjectStepPut("blnExitOnFail", "true");
					}
					jsonObjectStepPut("strCurrentWindowHandle", strCurrentWindowHandle);
					jsonObjectStepPut("strType", "");
					jsonObjectStepPut("strScreenshotFilePath", strPathResults + strPathImages);
					jsonObjectStepPut("strStatus", "info");
					jsonObjectStepPut("intFrame", Integer.toString(intFrame));
					jsonObjectStepPut("strStartTimestamp", "");
					jsonObjectStepPut("strStepDuration", "");
					jsonObjectStepPut("strEndTimestamp", "");
					jsonObjectStepPut("strStepExpected", "");
					jsonObjectStepPut("strStepActual", "");
					logStepDetails(objDragonfly, intStep);
					if (gobjJsonObjectStep.get("intLoop").toString().trim().length() > 0) {
						if (gobjJsonObjectStep.get("intLoop").toString().toLowerCase().startsWith("<loopstart>") == true) {
							if (intLoopEach == 0) {
								intLoopCount = Integer.parseInt(gobjJsonObjectStep.get("intLoop").toString().substring(11));
								jsonObjectStepPut("intLoop", "");
								intLoopEach = 1;
								intLoopStep = intStep;
							}
						}
					}
					objDragonfly.objLogger.setLogRow("main: intLoopCount = " + intLoopCount);
					objDragonfly.objLogger.setLogRow("main: intLoopEach = " + intLoopEach);
					objDragonfly.objLogger.setLogRow("main: intStep = " + intStep);
					objDragonfly.objLogger.setLogRow("main: intLoopStep = " + intLoopStep);
					if (!gobjJsonObjectStep.get("strFunction").toString().trim().equals("")) {
						String strMethodName = gobjJsonObjectStep.get("strFunction").toString();
						String strArguments = strInputValue;
						Class<?> objClass = Class.forName("org.DragonflyAutomation.Dragonfly");
						//						Class<?> objParameterTypes[] = new Class[1];
						//						objParameterTypes[0] = String.class;
						Class<?> objParameterTypes[] = new Class[2];
						objParameterTypes[0] = Dragonfly.class;
						objParameterTypes[1] = String.class;
						Method objMethod = objClass.getMethod(strMethodName, objParameterTypes);
						//Dragonfly objDragonfly = new Dragonfly();
						Object arrArgumentList[] = new Object[2];
						arrArgumentList[0] = objDragonfly;
						arrArgumentList[1] = new String(strArguments);
						//Object arrArgumentList[] = new Object[1];
						//arrArgumentList[0] = new String(strArguments);
						Object objReturn = objMethod.invoke(objDragonfly, arrArgumentList);
						String strReturnValue = (String) objReturn;
						strInputValue = strReturnValue.toString();
						jsonObjectStepPut("strInputValue", strInputValue);
						objDragonfly.objLogger.setLogRow("main: call function return value = " + strInputValue);
					}
					if (!strInputValue.toLowerCase().equals("<skip>")) {
						switch (gobjJsonObjectStep.get("strAction").toString().toLowerCase()) {
						case "launch":
							browserLaunchSync(objDragonfly);
							break;
						case "close":
							browserCloseSync(objDragonfly);
							break;
						case "get":
							elementGetSync(objDragonfly);
							break;
						case "set":
							elementSetSync(objDragonfly);
							break;
						case "verify":
							elementVerifyValueSync(objDragonfly);
							break;
						case "sync_visible":
							elementVisibleSync(objDragonfly);
							break;
						case "sync_hidden":
							elementHiddenSync(objDragonfly);
							break;
						case "sync_enabled":
							elementEnabledSync(objDragonfly);
							break;
						case "sync_disabled":
							elementDisabledSync(objDragonfly);
							break;
						case "mouse_over":
							elementOnMouseOverSync(objDragonfly);
							break;
						case "drag":
							elementDragSync(objDragonfly);
							break;
						case "drop":
							elementDropSync(objDragonfly);
							break;
						case "sleep":
							sleepSync(objDragonfly);
							break;
						case "refresh":
							browserRefreshSync(objDragonfly);
							break;
						case "break":
							objDragonfly.objLogger.setLogRow("main: switch strAction = break was entered to at this step to stop execution");
							return;
						default:
							objDragonfly.objLogger.setLogRow("main: switch strAction = " + gobjJsonObjectStep.get("strAction").toString().toLowerCase() + "  not supported");
							return;
						}
						strCurrentWindowHandle = gobjJsonObjectStep.get("strCurrentWindowHandle").toString();
						intFrame = Integer.parseInt(gobjJsonObjectStep.get("intFrame").toString());
					}
					if (gobjJsonObjectStep.get("strOutputLinkName").toString().trim().length() != 0) {
						gobjJsonObjectLinks.put(gobjJsonObjectStep.get("strOutputLinkName").toString(), gobjJsonObjectStep.get("strOutputValue").toString());
					}
					if (gobjJsonObjectStep.get("strStatus").toString().equals("fail")) {
						strTestStatus = "fail";
						if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnExitOnFail").toString()) == true) {
							webElementCollectionTable(objDragonfly, gobjJsonObjectStep.get("strTagName").toString());
							break;
						}
					}
					if (gobjJsonObjectStep.get("intLoop").toString().toLowerCase().startsWith("<loopexit>") == true) {
						strLoopExitValue = gobjJsonObjectStep.get("intLoop").toString().substring(10);
						objDragonfly.objLogger.setLogRow("main: strLoopExitValue = " + strLoopExitValue);
						if (gobjJsonObjectStep.get("strOutputValue").toString().equals(strLoopExitValue)) {
							intLoopCount = 0;
							intLoopEach = 0;
						}
					}
					if (gobjJsonObjectStep.get("intLoop").toString().toLowerCase().startsWith("<loopend>") == true) {
						if (intLoopEach == intLoopCount) {
							intLoopCount = 0;
							intLoopEach = 0;
						} else {
							intLoopEach = intLoopEach + 1;
							intStep = intLoopStep - 1;
						}
					}
					//					if (gobjJsonArrayTestStepsComplete == null) {
					//						gobjJsonArrayTestStepsComplete = (JSONObject) gobjJsonParser.parse(gobjJsonObjectStep.toString());
					//					} else {
					//						gobjJsonArrayTestStepsComplete.putAll((JSONObject) gobjJsonParser.parse(new FileReader(strPathFullTestData)));
					//					}
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("main: " + e.toString());
			} finally {
				//writeFile(strPathResults + "Dragonfly.log", Dragonfly.gstrLog);
				writeFile(objDragonfly, strPathResults + "Dragonfly.log", objDragonfly.objLogger.getLog());
				writeFile(objDragonfly, strPathResults + "StepsWithDefaults.json", gobjJsonArrayTestSteps.toString());
				writeFile(objDragonfly, strPathResults + "StepsAfterRun.json", gobjJsonObjectStepsFile.toString());
				//writeJsonStepsToHtml("original", gobjJsonArrayTestSteps, strPathResults, "StepsWithDefaults.html");
				//writeJsonStepsToHtml("complete", gobjJsonArrayTestSteps, strPathResults, "StepsAfterRun.html");
				objWriteJsonStepsToHtml.createReport(objDragonfly, "original", gobjJsonArrayTestSteps, strPathResults, "StepsWithDefaults.html");
				objWriteJsonStepsToHtml.createReport(objDragonfly, "complete", gobjJsonArrayTestSteps, strPathResults, "StepsAfterRun.html");
				writeReportToHtml(objDragonfly, gobjJsonArrayTestSteps, strPathResults + "Report.html");
				File objDirectoryOld = new File(strPathResults);
				String strPathResultsNew = strPathResults.replace(gstrPathResultsFolder, gstrPathResultsFolder + "_" + strTestStatus);
				objDragonfly.objLogger.setLogRow("main: strPathResultsNew = " + strPathResultsNew);
				File objDirectoryNew = new File(strPathResultsNew);
				objDirectoryOld.renameTo(objDirectoryNew);
				if (gobjWebDriver.toString().contains("InternetExplorerDriver")) {
					windowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
				}
			}
			gstrLog = "";
		}
	}

	public static boolean alertFind(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>alertFind " + dateTimestamp());
		try {
			objDragonfly.objLogger.setLogRow("alertFind: gobjWebDriver.getTitle() = " + gobjWebDriver.getTitle());
			gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			objDragonfly.objLogger.setLogRow("alertFind: implicitlyWait  ");
			String strAlertPresent = gobjWebDriver.switchTo().alert().getText();
			objDragonfly.objLogger.setLogRow("alertFind: alert switch to which did not fail:  " + strAlertPresent);
			return true;
		} catch (UnhandledAlertException e) {
			//objDragonfly.objLogger.setLogRow("alertFind getText " + gobjWebDriver.switchTo().alert().getText());
			objDragonfly.objLogger.setLogRow("alertFind: UnhandledAlertException = " + e.toString());
			return true;
		} catch (NoAlertPresentException e) {
			objDragonfly.objLogger.setLogRow("alertFind: NoAlertPresentException = " + e.toString());
			return false;
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("alertFind: Exception = " + e.toString());
			return false;
		}
	}

	public class AutoItSetObject2 {
		public AutoItX objAutoIt;

		public void createObject(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>autoItSetObject " + dateTimestamp());
			String strJacobDllVersionToUse;
			if (jvmBitVersion(objDragonfly).contains("32")) {
				strJacobDllVersionToUse = "jacob-1.18-x86.dll";
			} else {
				strJacobDllVersionToUse = "jacob-1.18-x64.dll";
			}
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + System.getProperty("java.library.path"));
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + strJacobDllVersionToUse);
			File objFile = new File("Libraries", strJacobDllVersionToUse);
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + LibraryLoader.JACOB_DLL_PATH);
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + objFile.getAbsolutePath());
			System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
			objAutoIt = new AutoItX();
		}

		public AutoItX getObject() {
			return objAutoIt;
		}
	}

	//	public class AutoItSetObject {
	//		public AutoItX objAutoIt;
	//
	//		//Dragonfly objDragonfly = new Dragonfly();
	//		public AutoItSetObject() {
	//			//objDragonfly.objLogger.setLogRow("  ==start==>autoItSetObject " + dateTimestamp());
	//			//			AutoItX objAutoIt;
	//			String strJacobDllVersionToUse;
	//			if (jvmBitVersion().contains("32")) {
	//				strJacobDllVersionToUse = "jacob-1.18-x86.dll";
	//			} else {
	//				strJacobDllVersionToUse = "jacob-1.18-x64.dll";
	//			}
	//			//objDragonfly.objLogger.setLogRow("autoItSetObject: " + System.getProperty("java.library.path"));
	//			//objDragonfly.objLogger.setLogRow("autoItSetObject: " + strJacobDllVersionToUse);
	//			File objFile = new File("Libraries", strJacobDllVersionToUse);
	//			//objDragonfly.objLogger.setLogRow("autoItSetObject: " + LibraryLoader.JACOB_DLL_PATH);
	//			//objDragonfly.objLogger.setLogRow("autoItSetObject: " + objFile.getAbsolutePath());
	//			System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
	//			objAutoIt = new AutoItX();
	//			//return objAutoIt;
	//			//return new AutoItX();
	//		}
	//
	//		public AutoItX getObject() {
	//			return objAutoIt;
	//		}
	//	}
	//	public AutoItX createObject() {
	//		objDragonfly.objLogger.setLogRow("  ==start==>autoItSetObject " + dateTimestamp());
	//		AutoItX objAutoIt;
	//		String strJacobDllVersionToUse;
	//		if (jvmBitVersion().contains("32")) {
	//			strJacobDllVersionToUse = "jacob-1.18-x86.dll";
	//		} else {
	//			strJacobDllVersionToUse = "jacob-1.18-x64.dll";
	//		}
	//		objDragonfly.objLogger.setLogRow("autoItSetObject: " + System.getProperty("java.library.path"));
	//		objDragonfly.objLogger.setLogRow("autoItSetObject: " + strJacobDllVersionToUse);
	//		File objFile = new File("Libraries", strJacobDllVersionToUse);
	//		objDragonfly.objLogger.setLogRow("autoItSetObject: " + LibraryLoader.JACOB_DLL_PATH);
	//		objDragonfly.objLogger.setLogRow("autoItSetObject: " + objFile.getAbsolutePath());
	//		System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
	//		objAutoIt = new AutoItX();
	//		return objAutoIt;
	//	}
	public static void browserClose(Dragonfly objDragonfly) {
		// TODO create a browserCloseSync to manage reporting and sync close
		gobjWebDriver.close();
		gobjWebDriver.quit();
		jsonObjectStepPut("strStatus", "pass");
		coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
	}

	public static void browserCloseSync(Dragonfly objDragonfly) {
		browserClose(objDragonfly);
	}

	public static WebDriver browserLaunch(Dragonfly objDragonfly) throws BrowserDriverNotSupportedException {
		//Dragonfly objDragonfly = new Dragonfly();
		// TODO combine duplicate code
		// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
		objDragonfly.objLogger.setLogRow("  ==start==>browserLaunch " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		DesiredCapabilities desiredCapabilities = null;
		try {
			jsonObjectStepPut("blnStatus", "true");
			jsonObjectStepPut("strStatus", "pass");
			jsonObjectStepPut("intFrame", "-1");
			switch (gobjJsonObjectStep.get("strTagName").toString()) {
			case "firefox":
				gobjWebDriver = new FirefoxDriver();
				gobjWebDriver.get(gobjJsonObjectStep.get("strInputValue").toString());
				gobjWebDriver.manage().window().maximize();
				Actions myAction = new Actions(gobjWebDriver);
				myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
				break;
			case "ie":
				// internetExplorerProcessKill();
				windowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
				sleepMilliseconds(objDragonfly, 1000);
				objDragonfly.objLogger.setLogRow("browserLaunch: DesiredCapabilities");
				desiredCapabilities = DesiredCapabilities.internetExplorer();
				objDragonfly.objLogger.setLogRow("browserLaunch: setJavascriptEnabled");
				desiredCapabilities.setJavascriptEnabled(true);
				//desiredCapabilities.setCapability("unexpectedAlertBehaviour", "ignore");
				objDragonfly.objLogger.setLogRow("browserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
				desiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
				objDragonfly.objLogger.setLogRow("browserLaunch: IE_ENSURE_CLEAN_SESSION");
				desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				objDragonfly.objLogger.setLogRow("browserLaunch: REQUIRE_WINDOW_FOCUS");
				desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				objDragonfly.objLogger.setLogRow("browserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				objDragonfly.objLogger.setLogRow("browserLaunch: new InternetExplorerDriver(desiredCapabilities)");
				gobjWebDriver = new InternetExplorerDriver(desiredCapabilities);
				//try {
				//C:\Users\perrj115\Documents\GitHub\dragonfly\Dragonfly\Drivers\IEDriverServer.exe
				//	File file = new File(System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				//	objDragonfly.objLogger.setLogRow("browserLaunch file.getAbsolutePath() " + file.getAbsolutePath());
				//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				//	WebDriver driver = new InternetExplorerDriver();
				//	gobjWebDriver = new InternetExplorerDriver();
				//} catch (Exception e) {
				//	objDragonfly.objLogger.setLogRow("browserLaunch new InternetExplorerDriver " + e.toString());
				//	}
				// gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
				objDragonfly.objLogger.setLogRow("browserLaunch: gobjJsonObjectStep.get(strInputValue).toString() = " + gobjJsonObjectStep.get("strInputValue").toString());
				gobjWebDriver.get(gobjJsonObjectStep.get("strInputValue").toString());
				// gobjWebDriver.navigate().to(gobjJsonObjectStep.get("strInputValue").toString());
				objDragonfly.objLogger.setLogRow("browserLaunch: gobjWebDriver.manage().window().maximize()");
				gobjWebDriver.manage().window().maximize();
				//	Capabilities getCapabilities();
				// gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				// // gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				break;
			case "chrome":
				switch (gstrOperatingSystem) {
				case "Windows":
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
					break;
				case "Mac":
					System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
					break;
				default:
					// TODO need to raise an error and log
					break;
				}
				gobjWebDriver = new ChromeDriver();
				gobjWebDriver.get(gobjJsonObjectStep.get("strInputValue").toString());
				gobjWebDriver.manage().window().maximize();
				break;
			case "safari":
				gobjWebDriver = new SafariDriver();
				gobjWebDriver.get(gobjJsonObjectStep.get("strInputValue").toString());
				gobjWebDriver.manage().window().maximize();
				break;
			case "opera":
				// TODO OperaDriver setup latest driver and test desiredCapabilities = DesiredCapabilities.internetExplorer();
				// desiredCapabilities.setJavascriptEnabled(true);
				gobjWebDriver = new OperaDriver();
				gobjWebDriver.get(gobjJsonObjectStep.get("strInputValue").toString());
				// gobjWebDriver.manage().window().maximize();
				// gobjWebDriver.manage().window().setPosition(new Point(0, 0));
				// Dimension dim = new Dimension(1382, 754);
				// gobjWebDriver.manage().window().setSize(dim);
				// Selenium selenium;
				// gobjWebDriver = new OperaDriver();
				// selenium = new WebDriverBackedSelenium(gobjWebDriver, "https://www.google.com/");
				// return gobjWebDriver;
				break;
			default:
				jsonObjectStepPut("blnStatus", "false");
				jsonObjectStepPut("strStatus", "fail");
				throw new BrowserDriverNotSupportedException("Browser '" + gobjJsonObjectStep.get("strTagName").toString() + "' not supported");
			}
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("browserLaunch: Exception" + e.toString());
		} finally {
			jsonObjectStepPut("strCurrentWindowHandle", gobjWebDriver.getWindowHandle());
			coordinatesElement(objDragonfly);
			coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
			stepDuration(objDragonfly, "browserLaunch", lngTimeStart, "launch");
		}
		return gobjWebDriver;
	}

	public static void browserLaunchSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>browserLaunchSync " + dateTimestamp());
		writeFile(objDragonfly, "c:\\temp\\DragonflyBrowser.log", objDragonfly.objLogger.getLog());
		// TODO create a browserLaunchSync to manage reporting and sync
		try {
			gobjWebDriver = browserLaunch(objDragonfly);
		} catch (BrowserDriverNotSupportedException e) {
			// TODO confirm the exceptions to catch in main some may need to be removed
			objDragonfly.objLogger.setLogRow("main: " + e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void browserRefresh(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>webDriverRefresh " + dateTimestamp());
		gobjWebDriver.navigate().refresh();
	}

	public static void browserRefreshSync(Dragonfly objDragonfly) {
		browserRefresh(objDragonfly);
	}

	//	public static void objDragonfly.objLogger.setLogRow(String strTextToAdd) {
	//		System.out.println(strTextToAdd);
	//		if (gstrLog.length() == 0) {
	//			gstrLog = strTextToAdd;
	//		} else {
	//			gstrLog = gstrLog + System.getProperty("line.separator") + strTextToAdd;
	//		}
	//	}
	public class Logger {
		private String gstrLog;

		public void setLogRow(String strTextToAdd) {
			System.out.println(strTextToAdd);
			gstrLog = gstrLog + System.getProperty("line.separator") + strTextToAdd;
			//if (gstrLog.length() == 0) {
			//			if (gstrLog.equals("")) {
			//				gstrLog = strTextToAdd;
			//			} else {
			//				gstrLog = gstrLog + System.getProperty("line.separator") + strTextToAdd;
			//			}
		}

		public String getLog() {
			return gstrLog;
		}
	}

	public static String oSType(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>oSType " + dateTimestamp());
		String strOS = System.getProperty("os.name").toLowerCase();
		if (strOS.contains("win")) {
			return "Windows";
		} else if (strOS.contains("nux") || strOS.contains("nix")) {
			return "Linux";
		} else if (strOS.contains("mac")) {
			return "Mac";
		} else if (strOS.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}
	}

	public static String jvmBitVersion(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("jvmBitVersion: System.getProperty(sun.arch.data.model) =" + System.getProperty("sun.arch.data.model"));
		return System.getProperty("sun.arch.data.model");
	}

	public static void windowsMinimizeAll(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>windowsMinimizeAll " + dateTimestamp());
		Robot objRobot = null;
		switch (gstrOperatingSystem) {
		case "Windows":
			try {
				objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_WINDOWS);
				objRobot.keyPress(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_WINDOWS);
				objDragonfly.objLogger.setLogRow("windowsMinimizeAll: Windows operating system minimize all windows.");
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("windowsMinimizeAll: Exception = " + e.toString());
			}
			break;
		case "default":
			objDragonfly.objLogger.setLogRow("windowsMinimizeAll: the operating system not supported at this time " + gstrOperatingSystem);
		}
	}

	public static void windowsProcessKill(Dragonfly objDragonfly, String strProcessToKill) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>windowsProcessKill " + dateTimestamp());
		try {
			Runtime.getRuntime().exec(strProcessToKill);
			objDragonfly.objLogger.setLogRow("windowsProcessKill: process killed = " + strProcessToKill);
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("windowsProcessKill: Exception = " + e.toString());
		}
	}

	public static void sleepMilliseconds(Dragonfly objDragonfly, int intMillisecondsToWait) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>sleepMilliseconds " + dateTimestamp());
		try {
			TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("sleepMilliseconds: Exception = " + e.toString());
		}
	}

	public static void internetExplorerVersion(Dragonfly objDragonfly) throws IOException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>internetExplorerVersion " + dateTimestamp());
		String strKeyName = "";
		Process objProcess;
		String strSvcUpdateVersion = "11.0.27";
		String strSvcvcVersion = "11.0.9600.18163";
		String strSvcvcKBNumber = "KB3124275";
		String strExpectedKeyValue = "";
		String strActualKeyValue = "";
		for (int intKeysEach = 0; intKeysEach < 3; intKeysEach++) {
			switch (intKeysEach) {
			case 0:
				strKeyName = "svcUpdateVersion";
				strExpectedKeyValue = strSvcUpdateVersion;
				break;
			case 1:
				strKeyName = "svcVersion";
				strExpectedKeyValue = strSvcvcVersion;
				break;
			case 2:
				strKeyName = "svcKBNumber";
				strExpectedKeyValue = strSvcvcKBNumber;
				break;
			}
			objProcess = Runtime.getRuntime().exec("REG QUERY \"HKLM\\SOFTWARE\\Microsoft\\Internet Explorer\" /v " + strKeyName);
			StringWriter objStringWriter = new StringWriter();
			try {
				int intCount;
				while ((intCount = objProcess.getInputStream().read()) != -1)
					objStringWriter.write(intCount);
			} catch (IOException e) {
			}
			String strOutput = objStringWriter.toString();
			String[] arrParsed = strOutput.split("\t");
			String strFullRegistryKey = arrParsed[arrParsed.length - 1];
			String[] arrActualKeyValue = strFullRegistryKey.replaceAll("\\s+", " ").trim().split(" ");
			strActualKeyValue = arrActualKeyValue[arrActualKeyValue.length - 1];
			if (strActualKeyValue.equals(strExpectedKeyValue)) {
				objDragonfly.objLogger.setLogRow(strFullRegistryKey.replaceAll("\\s+", " ").trim());
				objDragonfly.objLogger.setLogRow(strActualKeyValue);
			}
			;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void jsonOrder() {
		Map obj = new LinkedHashMap();
		obj.put("name", "foo");
		obj.put("num", new Integer(100));
		obj.put("balance", new Double(1000.21));
		obj.put("is_vip", new Boolean(true));
		obj.put("nickname", null);
		String jsonText = JSONValue.toJSONString(obj);
		System.out.print(jsonText);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void jsonOrder2(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		Map obj = new LinkedHashMap();
		//		String strKeys = "intBrowserOuterHeight|strOutputLinkName|intBrowserInnerWidth|strType|intBrowserOuterX|intBrowserOuterY|strFunction";
		//		strKeys = strKeys + "|strAttributeValues|blnHighlight|intElementX|strScreenshotFilePath|intElementY|strAssert|intLoop|strAssistiveProperties";
		//		strKeys = strKeys + "|intElementHeight|intElementScreenY|strAttributeNames|strLogicalName|intElementScreenX|strStepActual|strOutputValue";
		//		strKeys = strKeys + "|strAction|strScreenshotArea|strStartTimestamp|strTagType|intMillisecondsToWait|intElementWidth|intBrowserOuterWidth";
		//		strKeys = strKeys + "|blnOptional|strCurrentWindowHandle|strStepExpected|blnScreenshot|blnExitOnFail|intFrame|intBrowserInnerHeight";
		//		strKeys = strKeys + "|strEndTimestamp|blnPleaseWait|strStepDuration|strInputValue|strTagName|strStatus";
		//		String strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait|blnOptional|strAssert|";
		//		strKeys = strKeys + "blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail|strOutputLinkName|strOutputValue|intLoop|";
		//		strKeys = strKeys + "intBrowserInnerHeight|intBrowserInnerWidth|intBrowserOuterHeight|intBrowserOuterWidth|intBrowserOuterX|intBrowserOuterY|intElementHeight|";
		//		strKeys = strKeys + "intElementScreenX|intElementScreenY|intElementWidth|intElementX|intElementY|intFrame|strTagType|strType|strCurrentWindowHandle|";
		//		strKeys = strKeys + "strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strScreenshotFilePath|strStatus|blnStatus";
		String strKey = "";
		String[] arrKeys;
		//	arrKeys = strKeys.split("\\|");
		arrKeys = stepsNamesCompleteArray(objDragonfly);
		for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
			strKey = (String) arrKeys[intKeysEach].toString();
			obj.put(strKey, "");
		}
		String jsonText = JSONValue.toJSONString(obj);
		System.out.print(jsonText);
		JSONObject objTestStep = null;
		try {
			objTestStep = (JSONObject) gobjJsonParser.parse(jsonText);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Iterator<?> iterator = objTestStep.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			objDragonfly.objLogger.setLogRow("jsonOrder2: " + key + " = " + objTestStep.get(key));
		}
		objDragonfly.objLogger.setLogRow("jsonOrder2: ````````````````````````````");
		for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
			strKey = (String) arrKeys[intKeysEach].toString();
			objDragonfly.objLogger.setLogRow("jsonOrder2: " + strKey + " = " + objTestStep.get(strKey));
		}
	}

	//	public static int loopEndFind(JSONObject objJSONObject) {
	//		objDragonfly.objLogger.setLogRow("  ==start==>loopEndFind " + dateTimestamp());
	//		JSONArray objTestSteps2 = null;
	//		int intStep2 = 0;
	//		JSONObject objStep2 = null;
	//		try {
	//			objTestSteps2 = (JSONArray) gobjJsonParser.parse(gstrTestStepsCombinedOriginal);
	//		} catch (ParseException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		for (intStep2 = 0; intStep2 < objTestSteps2.size(); intStep2++) {
	//			objStep2 = (JSONObject) gobjJsonArrayStepsCombinedOriginal.get(intStep2);
	//			if (objStep2.get("intLoop").toString().toLowerCase().startsWith("<loopend>") == true) {
	//				return intStep2;
	//			}
	//		}
	//		return 0;
	//	}
	public static void jsonObjectValidateKey(Dragonfly objDragonfly, JSONObject objJSONObject, String strKeyName) throws JSONKeyNotPresentException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>jsonObjectValidateKey " + dateTimestamp());
		if (!objJSONObject.containsKey(strKeyName)) {
			throw new JSONKeyNotPresentException("JSON Key " + strKeyName + " not present");
		}
	}

	public static String jsonObjectGetValue(Dragonfly objDragonfly, JSONObject objJSONObject, String strInputValue, String strKeywordName) throws JSONKeyNotPresentException {
		//objDragonfly.objLogger.setLogRow("  ==start==>jsonObjectGetValue " + dateTimestamp());
		//Dragonfly objDragonfly = new Dragonfly();
		String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
		String strJSONObjectValue = "";
		if (objJSONObject.containsKey(strJSONObjectKey)) {
			strJSONObjectValue = objJSONObject.get(strJSONObjectKey).toString();
			objDragonfly.objLogger.setLogRow("jsonObjectGetValue: strJSONObjectValue = " + strJSONObjectValue);
			return strJSONObjectValue;
		} else {
			objDragonfly.objLogger.setLogRow("jsonObjectGetValue: JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
			throw new JSONKeyNotPresentException("JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
		}
	}

	@SuppressWarnings("unchecked")
	public static void jsonObjectStepPut(String strKeyName, String strKeyValue) {
		//objDragonfly.objLogger.setLogRow("  ==start==>jsonObjectStepPut " + dateTimestamp());
		gobjJsonObjectStep.put(strKeyName, strKeyValue);
	}

	public static void testMatrixSetup(Dragonfly objDragonfly, String strPathTestMatix) {
		// TODO complete testMatrixSetup method to create json objects for test
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>testMatrixSetup " + dateTimestamp());
		int intElementRepositoryEach = 0;
		int intJsonArrayTestInstanceSize = 0;
		int intTestDataEach = 0;
		int intTestModulesEach = 0;
		JSONArray objJsonArrayElementRepository = null;
		JSONArray objJsonArraySteps = null;
		JSONArray objJsonArrayTestData = null;
		JSONArray objJsonArrayTestInstance = null;
		JSONArray objJsonArrayTestModules = null;
		JSONObject objJsonObjectElementsEach = null;
		JSONObject objJsonObjectTestMatrixFile = null;
		String strFileNameElementRepository = "";
		String strFileNameTestData = "";
		String strFileNameTestInstance = "";
		String strFileNameTestModules = "";
		String strPathFullTestData = "";
		String strPathFullTestInstances = "";
		String strPathFullTestModules = "";
		String strStepsToString = "";
		try {
			objDragonfly.objLogger.setLogRow("testMatrixSetup: strPathTestMatix = " + strPathTestMatix);
			objJsonObjectTestMatrixFile = (JSONObject) gobjJsonParser.parse(new FileReader(strPathTestMatix));
			// test_instances
			objJsonArrayTestInstance = (JSONArray) objJsonObjectTestMatrixFile.get("test_instances");
			intJsonArrayTestInstanceSize = objJsonArrayTestInstance.size();
			if (intJsonArrayTestInstanceSize == 1) {
				strFileNameTestInstance = objJsonArrayTestInstance.get(0).toString();
				strPathFullTestInstances = gstrPathTestInstances + strFileNameTestInstance;
				gobjJsonObjectTestInstance = (JSONObject) gobjJsonParser.parse(new FileReader(strPathFullTestInstances));
				gobjJsonArrayTestInstances = (JSONArray) gobjJsonObjectTestInstance.get("test_instances");
				gintTestInstanceSize = gobjJsonArrayTestInstances.size();
			} else if (intJsonArrayTestInstanceSize == 0) {
				gintTestInstanceSize = 1;
				gobjJsonObjectTestInstance = (JSONObject) gobjJsonParser.parse("{\"test_instances\":[{}]}");
				gobjJsonArrayTestInstances = (JSONArray) gobjJsonObjectTestInstance.get("test_instances");
			} else if (intJsonArrayTestInstanceSize > 1) {
				gintTestInstanceSize = 0;
				objDragonfly.objLogger.setLogRow("testMatrixSetup: " + intJsonArrayTestInstanceSize + " Test Instances " + objJsonArrayTestInstance.toString() + " exceeds requirements of one. Update test matrix to have only one test instance.");
				throw new TestInstanceMoreThanOneException(intJsonArrayTestInstanceSize + " Test Instances " + objJsonArrayTestInstance.toString() + " exceeds requirements of one. Update test matrix to have only one test instance.");
			}
			if (gintTestInstanceSize > 1) {
				gstrPathResultsIterationsFolder = dateTimestamp() + "_Iterations_" + gintTestInstanceSize + "\\";
			}
			// element_repository
			objJsonArrayElementRepository = (JSONArray) objJsonObjectTestMatrixFile.get("element_repository");
			for (intElementRepositoryEach = 0; intElementRepositoryEach < objJsonArrayElementRepository.size(); intElementRepositoryEach++) {
				strFileNameElementRepository = objJsonArrayElementRepository.get(intElementRepositoryEach).toString();
				objDragonfly.objLogger.setLogRow("testMatrixSetup: strFileNameElementRepository = " + strFileNameElementRepository);
				gobjJsonObjectElements = (JSONObject) gobjJsonParser.parse(new FileReader(gstrPathElementRepository + strFileNameElementRepository));
				objJsonObjectElementsEach = (JSONObject) gobjJsonObjectElements.get("elements");
				if (intElementRepositoryEach == 0) {
					gobjJsonObjectElement = (JSONObject) gobjJsonObjectElements.get("elements");
				} else {
					gobjJsonObjectElement.putAll(objJsonObjectElementsEach);
				}
				objDragonfly.objLogger.setLogRow("testMatrixSetup: gobjJsonObjectElement = " + gobjJsonObjectElement);
			}
			// test_modules
			objJsonArrayTestModules = (JSONArray) objJsonObjectTestMatrixFile.get("test_modules");
			if (objJsonArrayTestModules.size() == 0) {
				// TODO add error handling, report no test modules and fail
				objDragonfly.objLogger.setLogRow("testMatrixSetup: objJsonArrayTestModules.size() == 0.  At lease 1 test module must be includes in a dragonfly test");
			} else {
				for (intTestModulesEach = 0; intTestModulesEach < objJsonArrayTestModules.size(); intTestModulesEach++) {
					strFileNameTestModules = objJsonArrayTestModules.get(intTestModulesEach).toString();
					strPathFullTestModules = gstrPathTestModules + strFileNameTestModules;
					objDragonfly.objLogger.setLogRow("testMatrixSetup: strPathFullTestModules = " + strPathFullTestModules);
					gobjJsonObjectStepsFile = (JSONObject) gobjJsonParser.parse(new FileReader(strPathFullTestModules));
					objJsonArraySteps = (JSONArray) gobjJsonObjectStepsFile.get("steps");
					strStepsToString = objJsonArraySteps.toString();
					objDragonfly.objLogger.setLogRow("testMatrixSetup: objJsonStepsEach = " + objJsonArraySteps.toString());
					if (intTestModulesEach > 0) {
						gstrTestStepsCombinedOriginal = gstrTestStepsCombinedOriginal.substring(0, gstrTestStepsCombinedOriginal.length() - 1) + "," + strStepsToString.substring(1);
					} else {
						gstrTestStepsCombinedOriginal = strStepsToString;
					}
				}
				objDragonfly.objLogger.setLogRow("testMatrixSetup: gstrTestStepsCombinedOriginal = " + gstrTestStepsCombinedOriginal);
				gobjJsonArrayLink = (JSONArray) gobjJsonObjectStepsFile.get("link");
				gobjJsonObjectLinks = (JSONObject) gobjJsonArrayLink.get(0);
			}
			// test_data
			objJsonArrayTestData = (JSONArray) objJsonObjectTestMatrixFile.get("test_data");
			if (objJsonArrayTestData.size() > 0) {
				for (intTestDataEach = 0; intTestDataEach < objJsonArrayTestData.size(); intTestDataEach++) {
					strFileNameTestData = objJsonArrayTestData.get(intTestDataEach).toString();
					strPathFullTestData = gstrPathTestData + strFileNameTestData;
					gobjJsonObjectTestDataFile = (JSONObject) gobjJsonParser.parse(new FileReader(strPathFullTestData));
					if (intTestDataEach > 0) {
						gobjJsonObjectTestDataFile.putAll((JSONObject) gobjJsonParser.parse(new FileReader(strPathFullTestData)));
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void logStepDetails(Dragonfly objDragonfly, int intStep) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>logStepDetails " + dateTimestamp());
		String[] arrKeys;
		String strKeys = "";
		String strKey = "";
		strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait";
		strKeys = strKeys + "|blnOptional|strAssert|blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail";
		strKeys = strKeys + "|strOutputLinkName|strOutputValue|intLoop|strCurrentWindowHandle";
		// objDragonfly.objLogger.setLogRow("logStepDetails: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
		arrKeys = strKeys.split("\\|");
		for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
			strKey = (String) arrKeys[intKeysEach].toString();
			if (gobjJsonObjectStep.containsKey(strKey) == true) {
				objDragonfly.objLogger.setLogRow("logStepDetails: " + strKey + " = " + gobjJsonObjectStep.get(strKey).toString());
			}
		}
	}

	public static void elementOnMouseOver(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementOnMouseOver " + dateTimestamp());
		objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + gobjWebElement.toString());
		JavascriptExecutor objJavascriptExecutor = null;
		if (gobjWebElement != null) {
			objJavascriptExecutor = (JavascriptExecutor) gobjWebDriver;
		}
		objJavascriptExecutor.executeScript("arguments[0].onmouseover();", gobjWebElement);
	}

	public static void elementOnMouseOverSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementOnMouseOverSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnOnMouseOver = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objDragonfly);
					blnEnabled = true;
				}
				if (blnOnMouseOver == false) {
					elementOnMouseOver(objDragonfly);
					blnOnMouseOver = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jsonObjectStepPut("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnOnMouseOver = false;
						}
					} else {
						if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
							jsonObjectStepPut("strStatus", "warning");
							blnExit = true;
						} else {
							jsonObjectStepPut("strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					stepDuration(objDragonfly, "elementOnMouseOverSync", lngTimeStart, "mouseover");
					return;
				}
			}
		}
	}

	public static void elementSet(Dragonfly objDragonfly, String strOuterHTML) throws ElementTagNameNotSupportedException, ElementNotSetException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementSet " + dateTimestamp());
		long lngStartTimeElementSet = System.currentTimeMillis();
		Boolean blnSet = false;
		JavascriptExecutor objJavascriptExecutor = null;
		// String strOuterHTML = "";
		if (gobjWebElement != null) {
			objJavascriptExecutor = (JavascriptExecutor) gobjWebDriver;
		}
		try {
			// gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			// gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
			//long lngStartTimeOuterHTML = System.currentTimeMillis();
			// strOuterHTML = gobjWebElement.getAttribute("outerHTML");
			// objDragonfly.objLogger.setLogRow("elementSet outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeOuterHTML));
			// objDragonfly.objLogger.setLogRow(strOuterHTML);
			switch (gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
			case "a":
			case "button":
			case "div":
			case "h1":
			case "h2":
			case "h3":
			case "h4":
			case "h5":
			case "h6":
			case "img":
			case "input_button":
			case "input_image":
			case "input_reset":
			case "input_submit":
			case "li":
			case "p":
			case "span":
			case "td":
			case "th":
			case "tr":
				blnSet = true;
				objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", gobjWebElement);
				gobjWebElement.click();
				// ///objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
				break;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
				blnSet = true;
				objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
				objJavascriptExecutor.executeScript("arguments[0].value = '';", gobjWebElement);
				gobjWebElement.sendKeys(gobjJsonObjectStep.get("strInputValue").toString());
				objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
				break;
			// //gobjWebElement.click();
			// objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].value = '';", gobjWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].value = '" + gobjJsonObjectStep.get("strInputValue").toString() + "';", gobjWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].onkeydown();", gobjWebElement);
			// // objJavascriptExecutor.executeScript("arguments[0].onkeyup();", gobjWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
			// objDragonfly.objLogger.setLogRow("onchange before");
			// if (strOuterHTML.toLowerCase().contains("onchange")) {
			// try {
			// objJavascriptExecutor.executeScript("arguments[0].onchange();", gobjWebElement);
			// } catch (WebDriverException e) {
			// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
			// }
			// }
			// break;
			case "input_radio":
				blnSet = true;
				objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", gobjWebElement);
				gobjWebElement.click();
				objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
				// if (strOuterHTML.toLowerCase().contains("onchange")) {
				// try {
				// objJavascriptExecutor.executeScript("arguments[0].onchange();", gobjWebElement);
				//
				// } catch (WebDriverException e) {
				// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
				// }
				// }
				break;
			case "input_checkbox":
				blnSet = true;
				switch (gobjJsonObjectStep.get("strInputValue").toString().toLowerCase()) {
				case "<on>":
					if (gobjWebElement.isSelected() == false) {
						objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].click();", gobjWebElement);
						gobjWebElement.click();
						objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
						// if (strOuterHTML.toLowerCase().contains("onchange")) {
						// try {
						// objJavascriptExecutor.executeScript("arguments[0].onchange();", gobjWebElement);
						// } catch (WebDriverException e) {
						// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
						// }
						// }
					}
					break;
				case "<off>":
					blnSet = true;
					if (gobjWebElement.isSelected() == true) {
						objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].click();", gobjWebElement);
						gobjWebElement.click();
						objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
						// if (strOuterHTML.toLowerCase().contains("onchange")) {
						// try {
						// objJavascriptExecutor.executeScript("arguments[0].onchange();", gobjWebElement);
						// } catch (WebDriverException e) {
						// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
						// }
						// }
					}
					break;
				}
				break;
			case "select":
				int intOptionsEach;
				String strOptions = "";
				String[] arrOptions;
				strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", gobjWebElement);
				strOptions = strOptions.substring(1);
				arrOptions = strOptions.split("\\|");
				for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					objDragonfly.objLogger.setLogRow("elementSet: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					if (arrOptions[intOptionsEach].toString().equals(gobjJsonObjectStep.get("strInputValue").toString())) {
						blnSet = true;
						Select objSelect = new Select(gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].focus();", gobjWebElement);
						objSelect.selectByIndex(intOptionsEach);
						objJavascriptExecutor.executeScript("arguments[0].blur();", gobjWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", gobjWebElement);
						// if (strOuterHTML.toLowerCase().contains("onchange")) {
						// try {
						// objJavascriptExecutor.executeScript("arguments[0].onchange();", gobjWebElement);
						// } catch (WebDriverException e) {
						// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
						// }
						// }
						break;
					}
				}
				break;
			case "table":
				// Set gobjWebElement = gobjWebElement.AsTable
				break;
			case "alert":
				blnSet = true;
				//Alert alert = gobjWebDriver.switchTo().alert();
				//objDragonfly.objLogger.setLogRow(gobjAlert.getText()); // Print Alert popup
				objDragonfly.objLogger.setLogRow("elementSet: " + gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase());
				switch (gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
				case "edit":
					//gobjAlert.sendKeys(gobjJsonObjectStep.get("strInputValue").toString());
					gobjWebDriver.switchTo().alert().sendKeys(gobjJsonObjectStep.get("strInputValue").toString());
					break;
				case "accept":
					//	gobjAlert.accept(); // Close Alert popup
					gobjWebDriver.switchTo().alert().accept(); // Close Alert popup
					break;
				case "dismiss":
					//gobjAlert.dismiss();// Close Alert popup
					gobjWebDriver.switchTo().alert().dismiss();// Close Alert popup
					break;
				}
				break;
			default:
				throw new ElementTagNameNotSupportedException("Element tag not supported");
			}
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("elementSet: Exception = " + e.toString());
		} finally {
			if (blnSet == false) {
				throw new ElementNotSetException("Element not set");
			}
			objDragonfly.objLogger.setLogRow("elementSet: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
		}
	}

	public static void elementSetSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementSetSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnAssert = false;
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnSet = false;
		Boolean blnSetSync = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strOuterHTML = "";
		jsonObjectStepPut("strOutputValue", gobjJsonObjectStep.get("strInputValue").toString());
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					objDragonfly.objLogger.setLogRow("elementSetSync: elementFind over");
					if (gobjWebElement != null) {
						strOuterHTML = gobjWebElement.getAttribute("outerHTML");
						objDragonfly.objLogger.setLogRow("elementSetSync: " + strOuterHTML);
						objDragonfly.objLogger.setLogRow("elementSetSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					objDragonfly.objLogger.setLogRow("elementSetSync: strOuterHTML over");
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objDragonfly);
					blnEnabled = true;
				}
				switch (gobjJsonObjectStep.get("strAssert").toString().toLowerCase()) {
				case "off":
					jsonObjectStepPut("strStatus", "pass");
					// TODO complete Alert Set, move or consider how to handle assert
					if (blnSet == false) {
						// if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {coordinateHighlightScreenshot(gobjJsonObjectStep, gobjWebDriver, null, gobjJsonObjectStep);
						// } else {
						coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
						// }
						elementSet(objDragonfly, strOuterHTML);
						blnSet = true;
						blnAssert = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(objDragonfly, strOuterHTML);
						blnSetSync = true;
					}
					blnStatus = true;
					break;
				case "hidden":
					if (blnSet == false) {
						jsonObjectStepPut("strStatus", "pass");
						coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
						elementSet(objDragonfly, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(objDragonfly, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementHidden(objDragonfly);
						blnAssert = true;
					}
					blnStatus = true;
					break;
				case "value":
					if (blnSet == false) {
						elementSet(objDragonfly, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(objDragonfly, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVerifyValue(objDragonfly);
						blnAssert = true;
					}
					jsonObjectStepPut("strStatus", "pass");
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					blnStatus = true;
					break;
				case "visible":
					if (blnSet == false) {
						elementSet(objDragonfly, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(objDragonfly, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objDragonfly);
						blnAssert = true;
					}
					jsonObjectStepPut("strStatus", "pass");
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					blnStatus = true;
					break;
				case "enabled":
					if (blnSet == false) {
						elementSet(objDragonfly, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(objDragonfly, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objDragonfly);
						elementEnabled(objDragonfly);
						blnAssert = true;
					}
					jsonObjectStepPut("strStatus", "pass");
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					blnStatus = true;
					break;
				case "disabled":
					if (blnSet == false) {
						elementSet(objDragonfly, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(objDragonfly, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objDragonfly);
						elementDisabled(objDragonfly);
						blnAssert = true;
					}
					jsonObjectStepPut("strStatus", "pass");
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					blnStatus = true;
					break;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} catch (ElementNotHiddenException e) {
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnAssert = false;
			} catch (ValueNotMatchedException e) {
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnFound = false;
				blnAssert = false;
			} catch (ElementNotSetException e) {
				blnSet = true;
				blnAssert = false;
			} catch (ElementNotDisabledException e) {
				blnAssert = false;
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (DoPostBackNotCompleteException | JQueryAjaxNotCompleteException | JQueryAnimationNotCompleteException | AngularJsNotCompleteException e) {
				blnSetSync = false;
			} finally {
				if (blnExit == true) {
				} else {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnStatus == true) {
							blnExit = true;
						}
					} else {
						if (blnStatus == true) {
							jsonObjectStepPut("strStatus", "pass");
							blnExit = true;
						} else if (blnStatus == false) {
							if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
								jsonObjectStepPut("strStatus", "warning");
								coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
								blnExit = true;
							} else {
								jsonObjectStepPut("strStatus", "fail");
								coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					stepDuration(objDragonfly, "elementSetSync", lngTimeStart, "set");
					return;
				}
			}
		}
	}

	public static ExpectedCondition<Boolean> waitForAngularFinishProcessing(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>waitForAngularFinishProcessing " + dateTimestamp());
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
			}
		};
	}

	public static void waitForAngularRequestsToFinish(Dragonfly objDragonfly, JavascriptExecutor objDriver) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>waitForAngularRequestsToFinish " + dateTimestamp());
		objDriver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
	}

	public static boolean waitForReadyState(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>waitForReadyState " + dateTimestamp());
		objDragonfly.objLogger.setLogRow("waitForReadyState: document.readyState MillisecondsWaited = " + ((JavascriptExecutor) gobjWebDriver).executeScript("return document.readyState"));
		return false;
	}

	public static void elementSetSyncComplete(Dragonfly objDragonfly, String strOuterHTML) throws DoPostBackNotCompleteException, JQueryAjaxNotCompleteException, JQueryAnimationNotCompleteException, AngularJsNotCompleteException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementSetSyncComplete " + dateTimestamp());
		long lngTimeStart = System.currentTimeMillis();
		try {
			objDragonfly.objLogger.setLogRow("elementSetSyncComplete: alertFind Start");
			if (alertFind(objDragonfly) == true) {
				return;
			}
			objDragonfly.objLogger.setLogRow("elementSetSyncComplete: alertFind complete");
			waitForReadyState(objDragonfly);
			// JavascriptExecutor objJavascriptExecutor = null;
			// objJavascriptExecutor = (JavascriptExecutor) gobjWebDriver;
			// waitForAngularRequestsToFinish(objJavascriptExecutor);
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
				try {
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: __EVENTTARGET value = " + gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: Exception = " + e.toString());
				}
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: blnEventTarget = " + blnEventTarget);
				if (blnEventTarget == true) {
					throw new AngularJsNotCompleteException("");
				}
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));
			}
			//long lngStartTimeElementSetJQueryActive = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				// objDragonfly.objLogger.setLogRow("elementSet blnJquery = " + ((JavascriptExecutor) gobjWebDriver).executeScript("return (window.jQuery != null);"));
				blnJquery = (boolean) ((JavascriptExecutor) gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) gobjWebDriver).executeScript("return (jQuery.active);");
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: lngJqueryActive = " + lngJqueryActive);
					// objDragonfly.objLogger.setLogRow("elementSet both = " + ((JavascriptExecutor) gobjWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: JqueryActive Exception = " + e.toString());
			}
			if (lngJqueryActive > 0) {
				// blnResult = false;
				throw new JQueryAjaxNotCompleteException("");
			}
			// long lngStartTimeElementSetJQueryAnimate = System.currentTimeMillis();
			long lngElementsAnimated = 0;
			boolean blnJqueryExist = false;
			try {
				blnJqueryExist = (boolean) ((JavascriptExecutor) gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJqueryExist == true) {
					lngElementsAnimated = (long) ((JavascriptExecutor) gobjWebDriver).executeScript("return $(\":animated\").length");
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: JQueryAnimate = " + lngElementsAnimated);
					// objDragonfly.objLogger.setLogRow("elementSetSyncComplete JQueryAnimate = " + ((JavascriptExecutor) gobjWebDriver).executeScript("return $(\":animated\").length"));
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: JQueryAnimate Exception = " + e.toString());
			}
			if (lngElementsAnimated > 0) {
				throw new JQueryAnimationNotCompleteException("");
			}
			//long lngStartTimeElementSetAngularJS = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) gobjWebDriver).executeScript("return (window.angular != null);");
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: blnAngularJs = " + blnAngularJs);
				// boolean blnAngularJs2 = (boolean) ((JavascriptExecutor) gobjWebDriver).executeScript("return (window.angular == null);");
				// objDragonfly.objLogger.setLogRow("elementSet blnAngularJs2 = " + blnAngularJs2);
				// if (blnAngularJs == true) {
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) gobjWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: lngJqueryActive = " + lngAngularJsInjectorActive);
				// }
				// boolean blnAngularJsInjector = (boolean) ((JavascriptExecutor) gobjWebDriver).executeScript("return (angular.element(document).injector() != null);");
				// objDragonfly.objLogger.setLogRow("elementSet blnAngularJsInjector = " + blnAngularJsInjector);
				// blnAngularJS = (boolean) ((JavascriptExecutor) gobjWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
				// objDragonfly.objLogger.setLogRow("elementSet blnAngularJS = " + blnAngularJS);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: AngularJS Exception = " + e.toString());
			}
			if (lngAngularJsInjectorActive > 0) {
				throw new AngularJsNotCompleteException("");
			}
		} catch (NoSuchWindowException e) {
			objDragonfly.objLogger.setLogRow("elementSetSyncComplete: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
		} finally {
			objDragonfly.objLogger.setLogRow("elementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
		}
	}

	public static void elementDragSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementDragSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strOuterHTML = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					objDragonfly.objLogger.setLogRow("elementSetSync: elementFind over");
					if (gobjWebElement != null) {
						strOuterHTML = gobjWebElement.getAttribute("outerHTML");
						objDragonfly.objLogger.setLogRow("elementDragSync: outerHTML = " + strOuterHTML);
						objDragonfly.objLogger.setLogRow("elementDragSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					objDragonfly.objLogger.setLogRow("elementDragSync: strOuterHTML over");
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objDragonfly);
					blnEnabled = true;
				}
				gobjWebElementDrag = gobjWebElement;
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				objDragonfly.objLogger.setLogRow("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				objDragonfly.objLogger.setLogRow("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				objDragonfly.objLogger.setLogRow("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//} catch (ElementTagNameNotSupportedException e) {
				//objDragonfly.objLogger.setLogRow("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//	blnExit = true;
			} finally {
				if (blnExit == true) {
				} else {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnStatus == true) {
							blnExit = true;
						}
					} else {
						if (blnStatus == true) {
							jsonObjectStepPut("strStatus", "pass");
							blnExit = true;
						} else if (blnStatus == false) {
							if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
								jsonObjectStepPut("strStatus", "warning");
								coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
								blnExit = true;
							} else {
								jsonObjectStepPut("strStatus", "fail");
								coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					stepDuration(objDragonfly, "elementDragSync", lngTimeStart, "drag");
					return;
				}
			}
		}
	}

	public static void elementDropSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementDropSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strOuterHTML = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					objDragonfly.objLogger.setLogRow("elementDropSync: elementFind over");
					if (gobjWebElement != null) {
						strOuterHTML = gobjWebElement.getAttribute("outerHTML");
						objDragonfly.objLogger.setLogRow("elementDropSync: outerHTML = " + strOuterHTML);
						objDragonfly.objLogger.setLogRow("elementDropSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					objDragonfly.objLogger.setLogRow("elementDropSync: strOuterHTML over");
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objDragonfly);
					blnEnabled = true;
				}
				gobjWebElementDrop = gobjWebElement;
				//Actions actions = new Actions(gobjWebDriver);
				//actions.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).perform();
				//				Actions action = new Actions(gobjWebDriver);
				//				Action dragDrop = action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build();
				//				dragDrop.perform();
				Actions objActions = new Actions(gobjWebDriver);
				Action objDragAndDrop = objActions.clickAndHold(gobjWebElementDrag).moveToElement(gobjWebElementDrop).pause(2000).release(gobjWebElementDrop).build();
				objDragAndDrop.perform();
				//				Actions action = new Actions(gobjWebDriver);
				//				action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build().perform();
				sleepMilliseconds(objDragonfly, 10000);
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				objDragonfly.objLogger.setLogRow("elementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//} catch (ElementTagNameNotSupportedException e) {
				//objDragonfly.objLogger.setLogRow("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//	blnExit = true;
			} finally {
				if (blnExit == true) {
				} else {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnStatus == true) {
							blnExit = true;
						}
					} else {
						if (blnStatus == true) {
							jsonObjectStepPut("strStatus", "pass");
							blnExit = true;
						} else if (blnStatus == false) {
							if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
								jsonObjectStepPut("strStatus", "warning");
								coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
								blnExit = true;
							} else {
								jsonObjectStepPut("strStatus", "fail");
								coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					stepDuration(objDragonfly, "elementDropSync", lngTimeStart, "drop");
					return;
				}
			}
		}
	}

	public static String elementVerifyValue(Dragonfly objDragonfly) throws ValueNotMatchedException, ElementTagNameNotSupportedException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementVerifyValue " + dateTimestamp());
		long lngStartTimeElementVerify = System.currentTimeMillis();
		String strActualValue = "";
		String strGetValue = "";
		String strValueExpected = gobjJsonObjectStep.get("strInputValue").toString();
		try {
			strGetValue = elementGet(objDragonfly);
			strActualValue = verifyMatch(objDragonfly, strGetValue, strValueExpected);
		} finally {
			objDragonfly.objLogger.setLogRow("elementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeElementVerify));
		}
		return strActualValue;
	}

	public static void elementVerifyValueSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementVerifyValueSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVerified = false;
		Boolean blnVisible = false;
		String strActualValue = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnVerified == false) {
					strActualValue = elementVerifyValue(objDragonfly);
					blnVerified = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				blnStatus = false;
				objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} catch (ValueNotMatchedException e) {
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				blnStatus = false;
				objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnExit == true) {
					jsonObjectStepPut("strStatus", "fail");
					blnExit = true;
				}
				if (blnStatus == true) {
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: finally blnStatus = " + blnStatus);
					jsonObjectStepPut("strOutputValue", strActualValue);
					jsonObjectStepPut("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
							blnVerified = false;
						}
					} else {
						if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
							jsonObjectStepPut("strOutputValue", strActualValue);
							jsonObjectStepPut("strStatus", "warning");
							blnExit = true;
						} else {
							jsonObjectStepPut("strOutputValue", strActualValue);
							jsonObjectStepPut("strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					stepDuration(objDragonfly, "elementVerifyValueSync", lngTimeStart, "verify");
					return;
				}
			}
		}
	}

	public static String verifyMatch(Dragonfly objDragonfly, String strActual, String strExpected) throws ValueNotMatchedException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>verifyMatch " + dateTimestamp());
		long lngStartTimeVerifyMatch = System.currentTimeMillis();
		try {
			if (strExpected.toLowerCase().startsWith("re:")) {
				String strPattern = strExpected.substring(3);
				objDragonfly.objLogger.setLogRow("verifyMatch: regularExpressionMatch = " + regularExpressionMatch(objDragonfly, strPattern, strActual));
				return regularExpressionMatch(objDragonfly, strPattern, strActual);
			} else {
				if (strExpected.equals(strActual)) {
					return strActual;
				} else {
					throw new ValueNotMatchedException("verifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
				}
			}
		} finally {
			objDragonfly.objLogger.setLogRow("verifyMatch: strActual = {" + strActual + "} strExpected = {" + strExpected + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeVerifyMatch));
		}
	}

	public static String regularExpressionMatch(Dragonfly objDragonfly, String strPattern, String strActualValue) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>regularExpressionMatch " + dateTimestamp());
		Pattern objPattern = Pattern.compile(strPattern);
		Matcher objMatcher = objPattern.matcher(strActualValue);
		objMatcher.matches();
		String strMatchedString = objMatcher.group(0);
		return strMatchedString;
	}

	public static void sleep(Dragonfly objDragonfly) {
		sleepMilliseconds(objDragonfly, Integer.parseInt(gobjJsonObjectStep.get("strInputValue").toString()));
	}

	public static void sleepSync(Dragonfly objDragonfly) {
		sleep(objDragonfly);
	}

	public static void stepDuration(Dragonfly objDragonfly, String strMethodName, Long lngTimeStart, String strStepType) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>stepDuration " + dateTimestamp());
		Long lngTimeEnd = System.currentTimeMillis();
		jsonObjectStepPut("strStepExpected", stepCreateExpected(objDragonfly));
		jsonObjectStepPut("strStepActual", stepCreateActual(objDragonfly, strStepType));
		jsonObjectStepPut("strStartTimestamp", dateTimeFormat(objDragonfly, lngTimeStart));
		jsonObjectStepPut("strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
		jsonObjectStepPut("strEndTimestamp", dateTimeFormat(objDragonfly, lngTimeEnd));
		//objDragonfly.objLogger.setLogRow(strMetodName + ": Milliseconds Waited = " + strStepDuration);
		objDragonfly.objLogger.setLogRow("stepDuration: " + strMethodName + " strStatus = " + gobjJsonObjectStep.get("strStatus").toString() + " Milliseconds Waited = " + gobjJsonObjectStep.get("strStepDuration").toString());
	}

	public static void internetExplorerProcessKill(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>internetExplorerProcessKill " + dateTimestamp());
		//WebDriver gobjWebDriver = null;
		DesiredCapabilities desiredCapabilities = null;
		windowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
		sleepMilliseconds(objDragonfly, 1000);
		desiredCapabilities = DesiredCapabilities.internetExplorer();
		desiredCapabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
		gobjWebDriver = new InternetExplorerDriver(desiredCapabilities);
		gobjWebDriver.get("about:blank");
		gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
		// gobjWebDriver.navigate().to(gobjJsonObjectStep.get("strInputValue").toString());
		// gobjWebDriver.manage().window().maximize();
		// gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// // gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
		gobjWebDriver.close();
		gobjWebDriver.quit();
		windowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
		sleepMilliseconds(objDragonfly, 1000);
		windowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 1
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 32
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 4351
	}

	// 1 = Browsing History
	// 2 = Cookies
	// 4 = Temporary Internet Files
	// 8 = Offline favorites and download history
	// 16 = Form Data
	// 32 = Passwords
	// 64 = Phishing Filter Data
	// 128 = Web page Recovery Data
	// 256 = Do not Show GUI when running the cache clear
	// 512 = Do not use Multi-threading for deletion
	// 1024 = Valid only when browser is in private browsing mode
	// 2048 = Tracking Data
	// 4096 = Data stored by add-ons
	// 8192 = Preserves Cached data for Favorite websites
	// Delete only download history
	// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16384
	// Add values together to get aggregate functionality. For example '4' is
	// deleting all temporary internet files and '260' is doing the same without
	// the dialog being displayed while it purges.
	// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 260
	public static void commandLineExecution(Dragonfly objDragonfly) throws Exception {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>commandLineExecution " + dateTimestamp());
		Process p = Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
		p.waitFor();
		Process p5 = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 10");
		p5.waitFor();
		String strCookiesLowFolderPath = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Cookies\\Low\\";
		strCookiesLowFolderPath = strCookiesLowFolderPath.replaceAll("\\\\", "/");
		objDragonfly.objLogger.setLogRow("commandLineExecution: strCookiesLowFolderPath = " + strCookiesLowFolderPath);
		FileUtils.deleteDirectory(new File(strCookiesLowFolderPath));
		String strCacheLowFolderPath = System.getenv("APPDATA") + "Local/Microsoft/Windows/Temporary Internet Files/Low/";
		strCacheLowFolderPath = strCacheLowFolderPath.replaceAll("\\\\", "/");
		objDragonfly.objLogger.setLogRow("commandLineExecution: strCacheLowFolderPath = " + strCacheLowFolderPath);
		FileUtils.deleteDirectory(new File(strCacheLowFolderPath));
	}

	public static void clearMyTracksByProcessCookies(Dragonfly objDragonfly) throws Exception {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>clearMyTracksByProcessCookies " + dateTimestamp());
		String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
		Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
		objProcess.waitFor();
	}

	public static void clearMyTracksByProcessCache(Dragonfly objDragonfly) throws Exception {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>clearMyTracksByProcessCache " + dateTimestamp());
		String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
		Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
		objProcess.waitFor();
	}

	public static String clipboardGet(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>clipboardGet " + dateTimestamp());
		String strClipboardData = "";
		try {
			strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			objDragonfly.objLogger.setLogRow("clipboardGet: strClipboardData = " + strClipboardData);
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("clipboardGet: Exception = " + e.toString());
		}
		return strClipboardData;
	}

	public static boolean validateTagType(Dragonfly objDragonfly, String strTagType) {
		//Dragonfly objDragonfly = new Dragonfly(Dragonfly objDragonfly);
		objDragonfly.objLogger.setLogRow("  ==start==>validateTagType " + dateTimestamp());
		switch (strTagType) {
		case "a":
		case "accept":
		case "alert":
		case "button":
		case "dismiss":
		case "div":
		case "h1":
		case "h2":
		case "h3":
		case "h4":
		case "h5":
		case "h6":
		case "img":
		case "input_button":
		case "input_checkbox":
		case "input_email":
		case "input_image":
		case "input_password":
		case "input_radio":
		case "input_reset":
		case "input_submit":
		case "input_text":
		case "li":
		case "p":
		case "select":
		case "span":
		case "table":
		case "td":
		case "text":
		case "textarea":
		case "th":
		case "title":
		case "tr":
			return true;
		default:
			return false;
		}
	}

	public static void elementFind(Dragonfly objDragonfly) throws ElementNotFoundException, MultipleElementsFoundException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementFind " + dateTimestamp());
		if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
			// TODO elementFind finish alert handling --- will need to consider issue where gobjWebDriver no longer exists maybe place this after setting window
			jsonObjectStepPut("strTagType", "alert");
			if (alertFind(objDragonfly) == true) {
				jsonObjectStepPut("strHighlightArea", "alert");
				return;
			} else {
				jsonObjectStepPut("strHighlightArea", "screen");
				throw new ElementNotFoundException("Alert popup not found!");
			}
		}
		if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("title")) {
			jsonObjectStepPut("strTagType", "title");
			return;
		}
		//String strCurrentWindowHandle = gobjJsonObjectStep.get("strCurrentWindowHandle").toString();
		String strWindowHandle = "";
		//Boolean blnSwitch = false;
		Object[] arrHandles = gobjWebDriver.getWindowHandles().toArray();
		// objDragonfly.objLogger.setLogRow("elementFind arrHandles.length = " + arrHandles.length);
		// objDragonfly.objLogger.setLogRow("elementFind gobjWebDriver.getTitle = " + gobjWebDriver.getTitle());
		for (int intWindowHandlesEach = arrHandles.length - 1; intWindowHandlesEach >= 0; intWindowHandlesEach--) {
			objDragonfly.objLogger.setLogRow("elementFind: arrHandles[" + intWindowHandlesEach + "] = " + arrHandles[intWindowHandlesEach].toString());
		}
		for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
			try {
				strWindowHandle = arrHandles[intHandlesEach].toString();
				//long lngStartTimeSwitchTo = System.currentTimeMillis();
				//			if (!strCurrentWindowHandle.equals(strWindowHandle)) {
				//				blnSwitch = true;
				//			} else {
				//				if (Integer.parseInt(gobjJsonObjectStep.get("intFrame").toString()) >= 0) {
				//					blnSwitch = true;
				//				}
				//			}
				//	if (blnSwitch == true) {
				objDragonfly.objLogger.setLogRow("elementFind: gobjWebDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
				gobjWebDriver.switchTo().window(strWindowHandle);
				coordinatesBrowserInner(objDragonfly);
				// objDragonfly.objLogger.setLogRow("elementFind Switched = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				objDragonfly.objLogger.setLogRow("elementFind: gobjWebDriver.getTitle = " + gobjWebDriver.getTitle());
				jsonObjectStepPut("intFrame", "-1");
				//gobjWebDriver.manage().window().maximize();
				//}
				List<Integer> arrRouteOriginal = new ArrayList<Integer>();
				objDragonfly.objLogger.setLogRow("elementFind: routeOriginal = " + arrRouteOriginal);
				objDragonfly.objLogger.setLogRow("elementFind: routeOriginal.size() = " + arrRouteOriginal.size());
				objDragonfly.objLogger.setLogRow("elementFind: routeOriginal.add(0) = " + arrRouteOriginal);
				framesSearch(objDragonfly, arrRouteOriginal);
				if (gobjWebElement != null) {
					objDragonfly.objLogger.setLogRow("elementFind: gobjWebElement Not null ");
					return;
				} else {
					objDragonfly.objLogger.setLogRow("elementFind: gobjWebElement IS NULL");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				objDragonfly.objLogger.setLogRow("elementFind: Exception = " + e.toString());
			}
		}
		throw new ElementNotFoundException("Element properties did not return an element, try refining attributes");
	}

	public static boolean framesSearch(Dragonfly objDragonfly, List<Integer> arrFramePath) throws ElementNotFoundException, MultipleElementsFoundException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>framesSearch " + dateTimestamp());
		boolean blnReturn;
		int intMaximumDepth = 100;
		objDragonfly.objLogger.setLogRow("framesSearch: route = " + arrFramePath + " arrFramePath.size = " + arrFramePath.size());
		objDragonfly.objLogger.setLogRow("framesSearch: gobjWebDriver.getTitle = " + gobjWebDriver.getTitle());
		objDragonfly.objLogger.setLogRow("framesSearch: gobjWebDriver.getCurrentUrl = " + gobjWebDriver.getCurrentUrl());
		objDragonfly.objLogger.setLogRow("framesSearch: gobjWebDriver.getWindowHandle = " + gobjWebDriver.getWindowHandle());
		//	objDragonfly.objLogger.setLogRow("framesSearch gobjWebDriver.getPageSource = " + gobjWebDriver.getPageSource());
		try {
			elementFindXpath(objDragonfly);
			objDragonfly.objLogger.setLogRow("framesSearch: elementFindXpath gobjWebElement found");
			objDragonfly.objLogger.setLogRow("framesSearch: gobjWebElement outerHTML = " + gobjWebElement.getAttribute("outerHTML"));
			objDragonfly.objLogger.setLogRow("framesSearch: return");
			return true;
		} catch (ElementNotFoundException | MultipleElementsFoundException e) {
			blnReturn = false;
			objDragonfly.objLogger.setLogRow("framesSearch: Exception = " + e.toString());
		}
		if (arrFramePath.size() < intMaximumDepth) {
			int intFramesCount = gobjWebDriver.findElements(By.tagName("frame")).size();
			objDragonfly.objLogger.setLogRow("framesSearch intFramesCount =  " + intFramesCount);
			for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
				objDragonfly.objLogger.setLogRow("framesSearch intFramesEach =  " + intFramesEach);
				try {
					gobjWebDriver.switchTo().frame(intFramesEach);
					List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
					arrFramePathNew.add(intFramesEach);
					blnReturn = framesSearch(objDragonfly, arrFramePathNew);
					objDragonfly.objLogger.setLogRow("framesSearch: after framesSearch(gobjJsonObjectStep, arrFramePathNew) and before defaultContent blnReturn = " + blnReturn);
					if (blnReturn == true) {
						return true;
					}
					gobjWebDriver.switchTo().defaultContent();
					objDragonfly.objLogger.setLogRow("framesSearch: after defaultContent");
					for (int intFramesPathEach : arrFramePath)
						gobjWebDriver.switchTo().frame(intFramesPathEach);
				} catch (NoSuchFrameException error) {
					blnReturn = false;
					objDragonfly.objLogger.setLogRow("framesSearch: NoSuchFrameException = " + error.toString());
					break;
				} catch (Exception error) {
					objDragonfly.objLogger.setLogRow("framesSearch: Exception = " + error.toString());
				}
			}
		}
		objDragonfly.objLogger.setLogRow("framesSearch: the end of if (arrFramePath.size() < intMaximumDepth) =  " + arrFramePath.size());
		if (gobjWebElement != null) {
			objDragonfly.objLogger.setLogRow("framesSearch: gobjWebElement Not null ");
			objDragonfly.objLogger.setLogRow("framesSearch: gobjWebElement outerHTML = " + gobjWebElement.getAttribute("outerHTML"));
		} else {
			objDragonfly.objLogger.setLogRow("framesSearch: gobjWebElement IS NULL");
		}
		return blnReturn;
	}

	public static void elementFindXpath(Dragonfly objDragonfly) throws ElementNotFoundException, MultipleElementsFoundException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementFindXpath " + dateTimestamp());
		int intAttributeEach = 0;
		List<WebElement> objWebElementCollection = new ArrayList<WebElement>();
		String arrAttributeNames[] = gobjJsonObjectStep.get("strAttributeNames").toString().split("\\|", -1);
		String arrAttributeValues[] = gobjJsonObjectStep.get("strAttributeValues").toString().split("\\|", -1);
		String strIndex = "";
		String strIndexKeyword = "";
		String strTagName = gobjJsonObjectStep.get("strTagName").toString().toLowerCase();
		String strXpath = "";
		String strXpathAttributes = "";
		String strXpathAttributesTemp = "";
		for (intAttributeEach = 0; intAttributeEach < arrAttributeNames.length; intAttributeEach++) {
			strXpathAttributesTemp = "";
			switch (arrAttributeNames[intAttributeEach].toLowerCase()) {
			case "xpath":
				strXpathAttributesTemp = arrAttributeValues[intAttributeEach];
				break;
			case "index":
				if (arrAttributeValues[intAttributeEach].equals("<last>")) {
					strIndex = "";
					strIndexKeyword = "<last>";
				} else if (arrAttributeValues[intAttributeEach].equals("<random>")) {
					strIndex = "";
					strIndexKeyword = "<random>";
				} else {
					strIndex = "[" + arrAttributeValues[intAttributeEach] + "]";
				}
				break;
			case "text":
				if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
					strXpathAttributesTemp = "contains(text()" + ", '" + arrAttributeValues[intAttributeEach].substring(3) + "')";
				} else {
					strXpathAttributesTemp = "text()='" + arrAttributeValues[intAttributeEach] + "' ";
				}
				break;
			default:
				if (arrAttributeNames[intAttributeEach].toLowerCase().equals("type")) {
					jsonObjectStepPut("strType", arrAttributeValues[intAttributeEach]);
				}
				if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
					// strXpathAttributesTemp = "contains(@" + arrAttributeNames[intAttributeEach] + ", '" +arrAttributeValues[intAttributeEach].substring(3) + "')";
					// strXpathAttributesTemp = "contains(lower-case(@" +arrAttributeNames[intAttributeEach] + "), '" +arrAttributeValues[intAttributeEach].substring(3).toLowerCase() + "')";
					strXpathAttributesTemp = "contains(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + arrAttributeValues[intAttributeEach].substring(3).toLowerCase() + "')";
				} else {
					strXpathAttributesTemp = "@" + arrAttributeNames[intAttributeEach] + "='" + arrAttributeValues[intAttributeEach] + "'";
				}
				break;
			}
			if (arrAttributeNames[0].toLowerCase().equals("xpath")) {
			} else {
				if (strXpathAttributesTemp.trim().length() != 0) {
					if (strXpathAttributes.trim().length() == 0) {
						strXpathAttributes = strXpathAttributesTemp;
					} else {
						strXpathAttributes = strXpathAttributes + " and " + strXpathAttributesTemp;
					}
				}
			}
		}
		if (arrAttributeNames[0].toLowerCase().equals("xpath")) {
			strXpath = strXpathAttributesTemp;
		} else {
			if (strXpathAttributes.trim().length() == 0) {
				strXpathAttributes = "";
			} else {
				strXpathAttributes = "[" + strXpathAttributes + "]";
			}
			strXpath = "(//" + strTagName + strXpathAttributes + ")" + strIndex;
		}
		objDragonfly.objLogger.setLogRow("elementFindXpath: arrAttributeNames[0].toLowerCase() = " + arrAttributeNames[0].toLowerCase());
		objDragonfly.objLogger.setLogRow("elementFindXpath: strXpathAttributesTemp = " + strXpathAttributesTemp);
		objDragonfly.objLogger.setLogRow("elementFindXpath: strXpath = " + strXpath);
		objDragonfly.objLogger.setLogRow("elementFindXpath: strXpathAttributes = " + strXpathAttributes);
		//long lngStartTimegetElementsByTagName2 = System.currentTimeMillis();
		//List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) gobjWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
		//objDragonfly.objLogger.setLogRow("elementFindXpath objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
		//if (objCollectionJS2.size() > 0) {
		//	long lngStartTimeByXpath = System.currentTimeMillis();
		objWebElementCollection = gobjWebDriver.findElements(By.xpath(strXpath));
		//}
		switch (objWebElementCollection.size()) {
		case 0:
			throw new ElementNotFoundException("Element properties did not return an element, try refining attributes");
		case 1:
			gobjWebElement = objWebElementCollection.get(0);
			break;
		default:
			if (strIndexKeyword.equals("<last>")) {
				gobjWebElement = objWebElementCollection.get(objWebElementCollection.size() - 1);
				break;
			} else if (strIndexKeyword.equals("<random>")) {
				int intRandomElement = randomNumberRange(objDragonfly, 0, objWebElementCollection.size() - 1);
				gobjWebElement = objWebElementCollection.get(intRandomElement);
				break;
			} else {
				objDragonfly.objLogger.setLogRow("elementFindXpath: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
				throw new MultipleElementsFoundException(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
			}
		}
		jsonObjectStepPut("strCurrentWindowHandle", gobjWebDriver.getWindowHandle());
		if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("input")) {
			if (gobjJsonObjectStep.get("strType").toString().toLowerCase().length() == 0) {
				jsonObjectStepPut("strType", gobjWebElement.getAttribute("type"));
			}
			jsonObjectStepPut("strTagType", "input_" + gobjJsonObjectStep.get("strType").toString());
		} else {
			jsonObjectStepPut("strTagType", gobjJsonObjectStep.get("strTagName").toString());
		}
	}

	public static String elementJavascriptExecutorXPath(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementJavascriptExecutorXPath " + dateTimestamp());
		return (String) ((JavascriptExecutor) gobjWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", gobjWebElement);
	}

	public static void coordinatesAlert(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>coordinatesAlert " + dateTimestamp());
		AutoItX objAutoIt = objDragonfly.objAutoItSetObject2.getObject();
		long lngStartTimeElementCoordinatesAlert = System.currentTimeMillis();
		//Dragonfly objDragonfly = new Dragonfly();
		int intClientSizeHeight = 0;
		int intClientSizeWidth = 0;
		int intControlPosHeight = 0;
		int intControlPosWidth = 0;
		int intControlPosX = 0;
		int intControlPosY = 0;
		//AutoItSetObject objAutoItSetObject = new Dragonfly().new AutoItSetObject(objDragonfly);
		//AutoItX gobjAutoIt = null;
		//AutoItX gobjAutoIt = objAutoItSetObject.getObject();
		//AutoItX gobjAutoIt2 = objDragonfly.gobjAutoIt;
		//		AutoItSetObject objAutoIt = new Dragonfly().new AutoItSetObject();
		//		AutoItX gobjAutoIt = null;
		//		try {
		//			gobjAutoIt = objAutoIt.createObject();
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		int intWinPosHeight = objDragonfly.gobjAutoIt2.winGetPosHeight("[ACTIVE]");
		//		int intWinPosWidth = objDragonfly.gobjAutoIt2.winGetPosWidth("[ACTIVE]");
		//		int intWinPosX = objDragonfly.gobjAutoIt2.winGetPosX("[ACTIVE]");
		//		int intWinPosY = objDragonfly.gobjAutoIt2.winGetPosY("[ACTIVE]");
		int intWinPosHeight = objAutoIt.winGetPosHeight("[ACTIVE]");
		int intWinPosWidth = objAutoIt.winGetPosWidth("[ACTIVE]");
		int intWinPosX = objAutoIt.winGetPosX("[ACTIVE]");
		int intWinPosY = objAutoIt.winGetPosY("[ACTIVE]");
		String strControlID = "";
		String strText = "";
		//String strWinTitle = objDragonfly.gobjAutoIt2.winGetTitle("[ACTIVE]");
		String strWinTitle = objAutoIt.winGetTitle("[ACTIVE]");
		switch (gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
		case "accept":
			strText = "OK";
			strControlID = "[CLASS:Button]";
			break;
		case "dismiss":
			strText = "Cancel";
			strControlID = "[CLASS:Button; INSTANCE:2]";
			break;
		case "title":
			strText = "";
			strControlID = "";
			break;
		case "text":
			strText = "";
			strControlID = "[CLASS:Static; INSTANCE:2]";
			break;
		case "edit":
			strText = "";
			strControlID = "[CLASS:Edit; INSTANCE:1]";
			break;
		}
		objDragonfly.objLogger.setLogRow("coordinatesAlert: gobjJsonObjectStep.get(strAttributeValues).toString().toLowerCase(): = " + gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase());
		objDragonfly.objLogger.setLogRow("coordinatesAlert: strText: = " + strText);
		objDragonfly.objLogger.setLogRow("coordinatesAlert: strControlID: = " + strControlID);
		objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosHeight: = " + intWinPosHeight);
		objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosWidth: = " + intWinPosWidth);
		objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosX: = " + intWinPosX);
		objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosY: = " + intWinPosY);
		switch (gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
		case "accept":
		case "dismiss":
		case "edit":
		case "text":
			//			intControlPosHeight = objDragonfly.gobjAutoIt2.controlGetPosHeight("[ACTIVE]", strText, strControlID);
			//			intControlPosWidth = objDragonfly.gobjAutoIt2.controlGetPosWidth("[ACTIVE]", strText, strControlID);
			//			intControlPosX = objDragonfly.gobjAutoIt2.controlGetPosX("[ACTIVE]", strText, strControlID);
			//			intControlPosY = objDragonfly.gobjAutoIt2.controlGetPosY("[ACTIVE]", strText, strControlID);
			//			intClientSizeHeight = objDragonfly.gobjAutoIt2.winGetClientSizeHeight("[ACTIVE]");
			//			intClientSizeWidth = objDragonfly.gobjAutoIt2.winGetClientSizeWidth("[ACTIVE]");
			intControlPosHeight = objAutoIt.controlGetPosHeight("[ACTIVE]", strText, strControlID);
			intControlPosWidth = objAutoIt.controlGetPosWidth("[ACTIVE]", strText, strControlID);
			intControlPosX = objAutoIt.controlGetPosX("[ACTIVE]", strText, strControlID);
			intControlPosY = objAutoIt.controlGetPosY("[ACTIVE]", strText, strControlID);
			intClientSizeHeight = objAutoIt.winGetClientSizeHeight("[ACTIVE]");
			intClientSizeWidth = objAutoIt.winGetClientSizeWidth("[ACTIVE]");
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosHeight: = " + intControlPosHeight);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosWidth: = " + intControlPosWidth);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosX: = " + intControlPosX);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosY: = " + intControlPosY);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intClientSizeHeight: = " + intClientSizeHeight);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intClientSizeWidth: = " + intClientSizeWidth);
			intWinPosX = intWinPosX + intControlPosX + ((intWinPosWidth - intClientSizeWidth) / 2);
			intWinPosY = intWinPosY + intControlPosY + ((intWinPosHeight - intClientSizeHeight) - ((intWinPosWidth - intClientSizeWidth) / 2));
			intWinPosWidth = intControlPosWidth;
			intWinPosHeight = intControlPosHeight;
			break;
		case "title":
			//			intControlPosHeight = objDragonfly.gobjAutoIt2.controlGetPosHeight("[ACTIVE]", strText, strControlID);
			//			intControlPosWidth = objDragonfly.gobjAutoIt2.controlGetPosWidth("[ACTIVE]", strText, strControlID);
			//			intControlPosX = objDragonfly.gobjAutoIt2.controlGetPosX("[ACTIVE]", strText, strControlID);
			//			intControlPosY = objDragonfly.gobjAutoIt2.controlGetPosY("[ACTIVE]", strText, strControlID);
			//			intClientSizeHeight = objDragonfly.gobjAutoIt2.winGetClientSizeHeight("[ACTIVE]");
			//			intClientSizeWidth = objDragonfly.gobjAutoIt2.winGetClientSizeWidth("[ACTIVE]");
			intControlPosHeight = objAutoIt.controlGetPosHeight("[ACTIVE]", strText, strControlID);
			intControlPosWidth = objAutoIt.controlGetPosWidth("[ACTIVE]", strText, strControlID);
			intControlPosX = objAutoIt.controlGetPosX("[ACTIVE]", strText, strControlID);
			intControlPosY = objAutoIt.controlGetPosY("[ACTIVE]", strText, strControlID);
			intClientSizeHeight = objAutoIt.winGetClientSizeHeight("[ACTIVE]");
			intClientSizeWidth = objAutoIt.winGetClientSizeWidth("[ACTIVE]");
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosHeight: = " + intControlPosHeight);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosHeight: = " + intControlPosHeight);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosWidth: = " + intControlPosWidth);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosX: = " + intControlPosX);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intControlPosY: = " + intControlPosY);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intClientSizeHeight: = " + intClientSizeHeight);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intClientSizeWidth: = " + intClientSizeWidth);
			//intWinPosX = intWinPosX ;
			//intWinPosY = intWinPosY + intControlPosY + ((intWinPosHeight - intClientSizeHeight) - ((intWinPosWidth - intClientSizeWidth) / 2));
			//intWinPosWidth = intControlPosWidth;
			intWinPosHeight = ((intWinPosHeight - intClientSizeHeight) - ((intWinPosWidth - intClientSizeWidth) / 2));
			break;
		}
		jsonObjectStepPut("intElementScreenX", Integer.toString(intWinPosX));
		jsonObjectStepPut("intElementScreenY", Integer.toString(intWinPosY));
		jsonObjectStepPut("intElementWidth", Integer.toString(intWinPosWidth));
		jsonObjectStepPut("intElementHeight", Integer.toString(intWinPosHeight));
		objDragonfly.objLogger.setLogRow("coordinatesAlert: winGetTitle: = " + strWinTitle);
		objDragonfly.objLogger.setLogRow("coordinatesAlert: gobjJsonObjectStep.get(intElementHeight): = " + gobjJsonObjectStep.get("intElementHeight"));
		objDragonfly.objLogger.setLogRow("coordinatesAlert: gobjJsonObjectStep.get(intElementWidth): = " + gobjJsonObjectStep.get("intElementWidth"));
		objDragonfly.objLogger.setLogRow("coordinatesAlert: gobjJsonObjectStep.get(intElementScreenX): = " + gobjJsonObjectStep.get("intElementScreenX"));
		objDragonfly.objLogger.setLogRow("coordinatesAlert: gobjJsonObjectStep.get(intElementScreenY): = " + gobjJsonObjectStep.get("intElementScreenY"));
		objDragonfly.objLogger.setLogRow("coordinatesAlert: coordinatesAlert finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinatesAlert));
	}

	public static void coordinatesBrowserInner(Dragonfly objDragonfly) throws WebDriverException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>coordinatesBrowserInner " + dateTimestamp());
		long lngBrowserInnerWidth = 0;
		long lngBrowserInnerHeight = 0;
		try {
			lngBrowserInnerWidth = (long) ((JavascriptExecutor) gobjWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
			lngBrowserInnerHeight = (long) ((JavascriptExecutor) gobjWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			// objDragonfly.objLogger.setLogRow("lngBrowserInnerWidth = " + lngBrowserInnerWidth);
			// objDragonfly.objLogger.setLogRow("lngBrowserInnerHeight = " + lngBrowserInnerHeight);
		} catch (WebDriverException e) {
			throw new WebDriverException("WebDriverException returned");
		} catch (Exception e) {
			lngBrowserInnerWidth = (long) ((JavascriptExecutor) gobjWebDriver).executeScript("return document.body.offsetWidth;");
			lngBrowserInnerHeight = (long) ((JavascriptExecutor) gobjWebDriver).executeScript("return document.body.offsetHeight;");
			// objDragonfly.objLogger.setLogRow("BodyoffsetWidth = " + lngBrowserInnerWidth);
			// objDragonfly.objLogger.setLogRow("BodyoffsetHeight = " + lngBrowserInnerHeight);
		}
		jsonObjectStepPut("intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
		jsonObjectStepPut("intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
	}

	public static void coordinatesElement(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>coordinatesElement " + dateTimestamp());
		long lngStartTimeElementCoordinates = System.currentTimeMillis();
		try {
			int intScrollbar = 0;
			Point objWebDriverPoint = gobjWebDriver.manage().window().getPosition();
			int intBrowserOuterX = objWebDriverPoint.x;
			int intBrowserOuterY = objWebDriverPoint.y;
			Dimension objWebDriverDimension = gobjWebDriver.manage().window().getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			jsonObjectStepPut("intBrowserOuterX", Integer.toString(intBrowserOuterX));
			jsonObjectStepPut("intBrowserOuterY", Integer.toString(intBrowserOuterY));
			jsonObjectStepPut("intBrowserOuterWidth", Integer.toString(intBrowserOuterWidth));
			jsonObjectStepPut("intBrowserOuterHeight", Integer.toString(intBrowserOuterHeight));
			if (gobjWebElement != null) {
				Coordinates objElementCoordinates = ((Locatable) gobjWebElement).getCoordinates();
				Point objElementPoint = objElementCoordinates.inViewPort();
				Dimension objElementDimension = gobjWebElement.getSize();
				jsonObjectStepPut("intElementX", Integer.toString(objElementPoint.x));
				jsonObjectStepPut("intElementY", Integer.toString(objElementPoint.y));
				jsonObjectStepPut("intElementWidth", Integer.toString(objElementDimension.width));
				jsonObjectStepPut("intElementHeight", Integer.toString(objElementDimension.height));
			}
			objDragonfly.objLogger.setLogRow("coordinatesElement: coordinatesElement gobjJsonObjectStep.containsKey = " + gobjJsonObjectStep.containsKey("intElementX"));
			if (gobjJsonObjectStep.containsKey("intElementX")) {
				int intBrowserInnerWidth = Integer.parseInt(gobjJsonObjectStep.get("intBrowserInnerWidth").toString());
				int intBrowserInnerHeight = Integer.parseInt(gobjJsonObjectStep.get("intBrowserInnerHeight").toString());
				int intElementX = Integer.parseInt(gobjJsonObjectStep.get("intElementX").toString());
				int intElementY = Integer.parseInt(gobjJsonObjectStep.get("intElementY").toString());
				int intWindowBorder = (int) ((intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2);
				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (int) ((intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder);
				jsonObjectStepPut("intElementScreenX", Integer.toString(intElementScreenX));
				jsonObjectStepPut("intElementScreenY", Integer.toString(intElementScreenY));
			}
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("coordinatesElement: Exception = " + e.toString());
		} finally {
			objDragonfly.objLogger.setLogRow("coordinatesElement: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinates));
		}
	}

	public static boolean elementVisible(Dragonfly objDragonfly) throws ElementNotVisibleException {
		//Dragonfly objDragonfly = new Dragonfly();
		// TODO elementVisible add check for class and css, commented code needs to be tested
		objDragonfly.objLogger.setLogRow("  ==start==>elementVisible " + dateTimestamp());
		long lngStartTimeElementVisible = System.currentTimeMillis();
		Boolean blnVisible = false;
		try {
			// TODO Alert complete
			if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("title")) {
				blnVisible = true;
				return true;
			}
			if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				if (alertFind(objDragonfly) == true) {
					blnVisible = true;
					jsonObjectStepPut("strHighlightArea", "alert");
					coordinatesAlert(objDragonfly);
					return true;
				} else {
					throw new ElementNotVisibleException("Alert popup was not found.");
				}
			}
			if (gobjWebElement.isDisplayed()) {
				coordinatesElement(objDragonfly);
				blnVisible = true;
				return true;
				// if (gobjJsonObjectStep.containsKey("intElementWidth")) {
				// int intElementWidth = Integer.parseInt(gobjJsonObjectStep.get("intElementWidth").toString());
				// int intElementHeight = Integer.parseInt(gobjJsonObjectStep.get("intElementHeight").toString());
				// objDragonfly.objLogger.setLogRow("elementVisible intElementWidth = " + intElementWidth);
				// objDragonfly.objLogger.setLogRow("elementVisible intElementHeight = " + intElementHeight);
				// if (intElementWidth == 0 || intElementHeight == 0) {
				// throw new ElementNotVisibleException("Element's heigh or width is 0");
				// } else {
				// return true;
				// }
				// } else {
				// throw new ElementNotVisibleException("Element's heigh or width is 0");
				// }
			} else {
				throw new ElementNotVisibleException("Element isDisplayed failed");
			}
		} finally {
			objDragonfly.objLogger.setLogRow("elementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
		}
	}

	public static void elementVisibleSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementVisibleSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				objDragonfly.objLogger.setLogRow("elementVisibleSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					objDragonfly.objLogger.setLogRow("elementVisibleSync: finally blnStatus = " + blnStatus);
					jsonObjectStepPut("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
						}
					} else {
						if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
							jsonObjectStepPut("strStatus", "warning");
							blnExit = true;
						} else {
							jsonObjectStepPut("strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					stepDuration(objDragonfly, "elementVisibleSync", lngTimeStart, "syncvisible");
					return;
				}
			}
		}
	}

	public static boolean elementHidden(Dragonfly objDragonfly) throws ElementNotHiddenException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementHidden " + dateTimestamp());
		long lngStartTimeElementHidden = System.currentTimeMillis();
		try {
			// TODO Alert complete
			if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				if (alertFind(objDragonfly) == false) {
					jsonObjectStepPut("strHighlightArea", "screen");
					objDragonfly.objLogger.setLogRow("elementHidden: strAreaObjectName = " + gobjJsonObjectStep.get("strHighlightArea"));
					return true;
				} else {
					throw new ElementNotHiddenException("Alert popup was not hidden.");
				}
			}
			if (gobjWebElement.isDisplayed() == false) {
				return true;
			} else {
				objDragonfly.objLogger.setLogRow("elementHidden: gobjWebElement.isDisplayed() = return true MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
				throw new ElementNotHiddenException("Element is displayed.");
			}
		} catch (NullPointerException | WebDriverException e) {
			objDragonfly.objLogger.setLogRow("elementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
			return true;
		} finally {
			objDragonfly.objLogger.setLogRow("elementHidden: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
		}
	}

	public static void elementHiddenSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementHiddenSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnHidden = false;
		Boolean blnStatus = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					blnFound = true;
				}
				if (blnFound == true && blnHidden == false) {
					elementHidden(objDragonfly);
					blnHidden = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ElementNotFoundException e) {
				blnFound = false;
				blnHidden = true;
				blnStatus = true;
				objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (MultipleElementsFoundException e) {
				blnFound = false;
				blnHidden = false;
				objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotHiddenException e) {
				blnHidden = false;
				objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (Exception e) {
				blnFound = false;
				blnHidden = false;
				objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jsonObjectStepPut("strStatus", "pass");
					coordinatesElement(objDragonfly);
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnHidden = false;
						}
					} else {
						coordinatesElement(objDragonfly);
						if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
							jsonObjectStepPut("strStatus", "warning");
							blnExit = true;
						} else {
							jsonObjectStepPut("strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					stepDuration(objDragonfly, "elementHiddenSync", lngTimeStart, "synchidden");
					return;
				}
			}
		}
	}

	public static boolean elementEnabled(Dragonfly objDragonfly) throws ElementNotEnabledException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementEnabled " + dateTimestamp());
		long lngStartTimeElementEnabled = System.currentTimeMillis();
		try {
			if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				if (alertFind(objDragonfly) == true) {
					return true;
				} else {
					throw new ElementNotEnabledException("Alert popup was not found.");
				}
			}
			if (gobjWebElement.isEnabled()) {
				return true;
			} else {
				throw new ElementNotEnabledException("elementEnabled - Element is not enabled");
			}
		} finally {
			objDragonfly.objLogger.setLogRow("elementEnabled: finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementEnabled));
		}
	}

	public static void elementEnabledSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementEnabledSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objDragonfly);
					blnEnabled = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				blnEnabled = false;
				objDragonfly.objLogger.setLogRow("elementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				objDragonfly.objLogger.setLogRow("elementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jsonObjectStepPut("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnEnabled = false;
						}
					} else {
						if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
							jsonObjectStepPut("strStatus", "warning");
							blnExit = true;
						} else {
							jsonObjectStepPut("strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					stepDuration(objDragonfly, "elementEnabledSync", lngTimeStart, "syncenabled");
					return;
				}
			}
		}
	}

	public static boolean elementDisabled(Dragonfly objDragonfly) throws ElementNotDisabledException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementDisabled " + dateTimestamp());
		long lngStartTimeElementDisabled = System.currentTimeMillis();
		try {
			//			if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
			//				if (alertFind() == true) {
			//					return true;
			//				} else {
			//					throw new ElementNotDisabledException("Alert popup was not found.");
			//				}
			//			}
			if (gobjWebElement.isEnabled()) {
				throw new ElementNotDisabledException("elementDisabled - Element is not disabled");
			} else {
				return true;
			}
		} finally {
			objDragonfly.objLogger.setLogRow("elementDisabled: finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementDisabled));
		}
	}

	public static void elementDisabledSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementDisabledSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnDisabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnDisabled == false) {
					elementDisabled(objDragonfly);
					blnDisabled = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				blnDisabled = false;
				objDragonfly.objLogger.setLogRow("elementDisabledSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotDisabledException e) {
				blnDisabled = false;
				objDragonfly.objLogger.setLogRow("elementDisabledSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jsonObjectStepPut("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnDisabled = false;
						}
					} else {
						if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
							jsonObjectStepPut("strStatus", "warning");
							blnExit = true;
						} else {
							jsonObjectStepPut("strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					stepDuration(objDragonfly, "elementDisabledSync", lngTimeStart, "syncdisabled");
					return;
				}
			}
		}
	}

	public static String elementGet(Dragonfly objDragonfly) throws ElementTagNameNotSupportedException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementGet " + dateTimestamp());
		long lngStartTimeElementGet = System.currentTimeMillis();
		//Dragonfly objDragonfly = new Dragonfly();
		//AutoItSetObject objAutoItSetObject = new Dragonfly().new AutoItSetObject(objDragonfly);
		//AutoItX gobjAutoIt = null;
		//AutoItX gobjAutoIt = gobjAutoIt2.getObject();
		AutoItX objAutoIt = objDragonfly.objAutoItSetObject2.getObject();
		String strElementGet = "";
		try {
			switch (gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
			case "title":
				strElementGet = gobjWebDriver.getTitle();
				return strElementGet;
			case "img":
				strElementGet = gobjWebElement.getAttribute("src");
				return strElementGet;
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				strElementGet = gobjWebElement.getAttribute("value").trim();
				return strElementGet;
			case "a":
			case "th":
			case "tr":
			case "td":
			case "div":
			case "span":
			case "h1":
			case "h2":
			case "h3":
			case "h4":
			case "h5":
			case "h6":
			case "p":
			case "li":
				strElementGet = gobjWebElement.getText();
				return strElementGet;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
				strElementGet = gobjWebElement.getAttribute("value");
				return strElementGet;
			case "input_radio":
			case "input_checkbox":
				if (gobjWebElement.isSelected() == false) {
					strElementGet = "<off>";
				} else {
					strElementGet = "<on>";
				}
				return strElementGet;
			case "select":
				JavascriptExecutor objExecutor = (JavascriptExecutor) gobjWebDriver;
				// strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].innerHTML;return selection;", gobjWebElement);
				strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", gobjWebElement);
				strElementGet = strElementGet.trim();
				return strElementGet;
			case "table":
				strElementGet = gobjWebElement.getText();
				return strElementGet;
			case "alert":
				if (gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase().equals("title")) {
					//strElementGet = objDragonfly.gobjAutoIt2.winGetTitle("[ACTIVE]");
					strElementGet = objAutoIt.winGetTitle("[ACTIVE]");
					//objDragonfly.objLogger.setLogRow("winGetTitle: = " + objDragonfly.gobjAutoIt2.winGetTitle("[ACTIVE]"));
					objDragonfly.objLogger.setLogRow("winGetTitle: = " + objAutoIt.winGetTitle("[ACTIVE]"));
				} else {
					strElementGet = gobjWebDriver.switchTo().alert().getText();
				}
				return strElementGet;
			default:
				strElementGet = "elementGet tag not supported";
				throw new ElementTagNameNotSupportedException("Element tag not supported");
			}
			//		} catch (Exception e) {
			//			// TODO handle ElementGet Exception
			//			objDragonfly.objLogger.setLogRow("ElementGet: Exception = " + e.toString());
		} finally {
			objDragonfly.objLogger.setLogRow("ElementGet: finally strElementGet = {" + strElementGet + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementGet));
		}
		//		if (strElementGet.equals("elementGet tag not supported")) {
		//			throw new ElementTagNameNotSupportedException(strElementGet);
		//		} else {
		//			return strElementGet;
		//		}
		//return strElementGet;
	}

	public static void elementGetSync(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>elementGetSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnGet = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strGetValue = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objDragonfly);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objDragonfly);
					blnVisible = true;
				}
				if (blnGet == false) {
					strGetValue = elementGet(objDragonfly);
					jsonObjectStepPut("strOutputValue", strGetValue);
					blnGet = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				objDragonfly.objLogger.setLogRow("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				objDragonfly.objLogger.setLogRow("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				objDragonfly.objLogger.setLogRow("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} finally {
				if (blnExit == true) {
					jsonObjectStepPut("strStatus", "fail");
				} else {
					if (blnStatus == true) {
						jsonObjectStepPut("strStatus", "pass");
						blnExit = true;
					} else if (blnStatus == false) {
						if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
							if (blnFound == false) {
								blnVisible = false;
								blnGet = false;
							}
						} else {
							if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnOptional").toString()) == true) {
								jsonObjectStepPut("strStatus", "warning");
								blnExit = true;
							} else {
								jsonObjectStepPut("strStatus", "fail");
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objDragonfly, gobjJsonObjectStep);
					stepDuration(objDragonfly, "elementGetSync", lngTimeStart, "get");
					return;
				}
			}
		}
	}

	public class SyncTime {
		public long startTime;
		public long endTime;

		public long getDuration() {
			return endTime - startTime;
		}

		public void start() {
			startTime = System.currentTimeMillis();
		}

		public void stop() {
			endTime = System.currentTimeMillis();
		}
	}

	public static void coordinateHighlightScreenshot(Dragonfly objDragonfly, final JSONObject objJsonObjectStepHighlightArea) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>coordinateHighlightScreenshot " + dateTimestamp());
		long lngStartTimeCoordinateHighlightScreenshot = System.currentTimeMillis();
		JFrame objJFrame = new JFrame() {
			private static final long serialVersionUID = 1L;
			{
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				if (Boolean.parseBoolean(objJsonObjectStepHighlightArea.get("blnHighlight").toString()) == true) {
					int intThickness = 5;
					Color objHighlightColor = null;
					switch (objJsonObjectStepHighlightArea.get("strStatus").toString().toLowerCase()) {
					case "pass":
						if (objJsonObjectStepHighlightArea.get("strAction").toString().toLowerCase().equals("set") && objJsonObjectStepHighlightArea.get("strAssert").toString().toLowerCase().equals("off")) {
							objHighlightColor = Color.BLUE;
						} else {
							objHighlightColor = Color.GREEN;
						}
						break;
					case "fail":
						objHighlightColor = Color.RED;
						break;
					case "warning":
						objHighlightColor = Color.YELLOW;
						break;
					case "info":
						objHighlightColor = Color.MAGENTA;
						break;
					}
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: strHighlightArea = " + gobjJsonObjectStep.get("strHighlightArea").toString());
					rectangleAreaByName(objDragonfly, intThickness, gobjJsonObjectStep.get("strHighlightArea").toString(), objHighlightArea);
					setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
					setUndecorated(true);
					setBackground(new Color(0, 0, 0, 0));
					getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
					setVisible(true);
				}
			}
		};
		int intSleepMilliseconds = 0;
		if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnScreenshot").toString()) == true) {
			Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
			String strScreenshotFilePath = "";
			try {
				Robot robot = new Robot();
				rectangleAreaByName(objDragonfly, 0, gobjJsonObjectStep.get("strScreenshotArea").toString(), objHighlightArea);
				BufferedImage screenShot = robot.createScreenCapture(objHighlightArea);
				strScreenshotFilePath = gobjJsonObjectStep.get("strScreenshotFilePath").toString() + "Screenshot_" + dateTimestamp() + ".jpg";
				Thread objThread = new Thread(new threadSaveImage(screenShot, "jpg", strScreenshotFilePath));
				objThread.start();
				jsonObjectStepPut("strScreenshotFilePath", strScreenshotFilePath);
			} catch (AWTException e) {
				// TODO handle coordinateHighlightScreenshot AWTException
				objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: Exception " + e.toString());
			} catch (Exception e) {
				// TODO handle coordinateHighlightScreenshot Exception
				objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: Exception " + e.toString());
			}
		}
		if (Boolean.parseBoolean(gobjJsonObjectStep.get("blnHighlight").toString()) == true) {
			try {
				Thread.sleep(intSleepMilliseconds);
			} catch (InterruptedException e) {
				// TODO handle coordinateHighlightScreenshot InterruptedException
				objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: Exception " + e.toString());
			}
			objJFrame.setVisible(false);
			objJFrame.dispose();
		}
		objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeCoordinateHighlightScreenshot));
	}

	public static void rectangleAreaByName(Dragonfly objDragonfly, Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>rectangleAreaByName " + dateTimestamp());
		objDragonfly.objLogger.setLogRow("rectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
		long lngStartTimeGetRectangleAreaByName = System.currentTimeMillis();
		int intX = 0;
		int intY = 0;
		int intWidth = 0;
		int intHeight = 0;
		if (strAreaObjectName.equals("")) {
			if (gobjWebDriver == null) {
				strAreaObjectName = "screen";
			}
			if (gobjWebElement == null) {
				if (gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					strAreaObjectName = "element";
				} else {
					strAreaObjectName = "screen";
				}
			} else {
				if (gobjJsonObjectStep.containsKey("intElementScreenX") == false) {
					strAreaObjectName = "screen";
				} else {
					strAreaObjectName = "element";
				}
			}
		}
		try {
			switch (strAreaObjectName.toLowerCase()) {
			case "screen":
				intX = 0;
				intY = 0;
				intWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
				intHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
				break;
			case "window":
				intX = Integer.parseInt(gobjJsonObjectStep.get("intBrowserOuterX").toString());
				intY = Integer.parseInt(gobjJsonObjectStep.get("intBrowserOuterY").toString());
				intWidth = Integer.parseInt(gobjJsonObjectStep.get("intBrowserOuterWidth").toString());
				intHeight = Integer.parseInt(gobjJsonObjectStep.get("intBrowserOuterHeight").toString());
				break;
			case "page":
				// TODO change this to get absolute screen coordinates
				WebElement objWebElementPage = gobjWebDriver.findElement(By.xpath("//body"));
				intX = objWebElementPage.getLocation().getX() - intThickness;
				intY = objWebElementPage.getLocation().getY() - intThickness;
				intWidth = objWebElementPage.getSize().width + (2 * intThickness);
				intHeight = objWebElementPage.getSize().height + (2 * intThickness);
				break;
			case "element":
			case "alert":
				intX = Integer.parseInt(gobjJsonObjectStep.get("intElementScreenX").toString()) - intThickness;
				intY = Integer.parseInt(gobjJsonObjectStep.get("intElementScreenY").toString()) - intThickness;
				intWidth = Integer.parseInt(gobjJsonObjectStep.get("intElementWidth").toString()) + (2 * intThickness);
				intHeight = Integer.parseInt(gobjJsonObjectStep.get("intElementHeight").toString()) + (2 * intThickness);
				break;
			default:
				// TODO add reporting for default
				objDragonfly.objLogger.setLogRow("rectangleAreaByName: default screen, window, page and element not " + strAreaObjectName);
				break;
			}
		} finally {
			if (intX < 0) {
				intWidth = intWidth + 2 * intX;
				intX = 0;
			}
			if (intY < 0) {
				intHeight = intHeight + 2 * intY;
				intY = 0;
			}
			objRectangleArea.setBounds(intX, intY, intWidth, intHeight);
			objDragonfly.objLogger.setLogRow("rectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeGetRectangleAreaByName));
		}
	}

	public static class threadSaveImage implements Runnable {
		private BufferedImage objScreenShot;
		private String strImageType;
		private String strPathFileName;

		//Dragonfly objDragonfly = new Dragonfly();
		public threadSaveImage(BufferedImage objScreenShot, String strImageType, String strPathFileName) {
			this.objScreenShot = objScreenShot;
			this.strImageType = strImageType;
			this.strPathFileName = strPathFileName;
		}

		public void run() {
			//objDragonfly.objLogger.setLogRow("  ==start==>threadSaveImage " + dateTimestamp());
			try {
				ImageIO.write(objScreenShot, strImageType.toUpperCase(), new File(strPathFileName));
			} catch (IOException e) {
				//objDragonfly.objLogger.setLogRow("threadSaveImage: IOException = " + e.toString());
			}
		}
	}

	public static final String dateTimestamp() {
		//objDragonfly.objLogger.setLogRow("  ==start==>dateTimestamp " + dateTimestamp());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static final String dateTimeFormat(Dragonfly objDragonfly, Long lngStartTimeMillis) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>dateTimeFormat " + dateTimestamp());
		SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS");
		Date objFormattedDate = new Date(lngStartTimeMillis);
		objDragonfly.objLogger.setLogRow("dateTimeFormat: " + objSimpleDateFormat.format(objFormattedDate));
		return objSimpleDateFormat.format(objFormattedDate);
	}

	public static String monthGet(Dragonfly objDragonfly, int month) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>monthGet " + dateTimestamp());
		// return new DateFormatSymbols().setLocalPatternChars("es-MX");
		return new DateFormatSymbols().getMonths()[month];
	}

	public static void windowFocus(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>windowFocus " + dateTimestamp());
		// TODO debug gobjWebDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
		if (gobjWebDriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) gobjWebDriver).executeScript("window.focus();");
		}
	}

	public static void scrollToBottom() {
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>scrollToBottom " + dateTimestamp());
		// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
		JavascriptExecutor executor = (JavascriptExecutor) gobjWebDriver;
		executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public static String[] stepsNamesCompleteArray(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>StepsNamesArray " + dateTimestamp());
		String strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait|blnOptional|strAssert|";
		strKeys = strKeys + "blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail|strOutputLinkName|strOutputValue|intLoop|";
		strKeys = strKeys + "intBrowserInnerHeight|intBrowserInnerWidth|intBrowserOuterHeight|intBrowserOuterWidth|intBrowserOuterX|intBrowserOuterY|intElementHeight|";
		strKeys = strKeys + "intElementScreenX|intElementScreenY|intElementWidth|intElementX|intElementY|intFrame|strTagType|strType|strCurrentWindowHandle|";
		strKeys = strKeys + "strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strScreenshotFilePath|strStatus|blnStatus";
		return strKeys.split("\\|");
	}

	public static String[] stepsNamesOriginalArray(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>StepsNamesArray " + dateTimestamp());
		String strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait|blnOptional|strAssert|";
		strKeys = strKeys + "blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail|strOutputLinkName|strOutputValue|intLoop|";
		return strKeys.split("\\|");
	}

	public class stepsNames {
		private String strKeys;

		public String[] getOriginal() {
			strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait|blnOptional|strAssert|";
			strKeys = strKeys + "blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail|strOutputLinkName|strOutputValue|intLoop|";
			return strKeys.split("\\|");
		}

		public String[] getComplete() {
			strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait|blnOptional|strAssert|";
			strKeys = strKeys + "blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail|strOutputLinkName|strOutputValue|intLoop|";
			strKeys = strKeys + "intBrowserInnerHeight|intBrowserInnerWidth|intBrowserOuterHeight|intBrowserOuterWidth|intBrowserOuterX|intBrowserOuterY|intElementHeight|";
			strKeys = strKeys + "intElementScreenX|intElementScreenY|intElementWidth|intElementX|intElementY|intFrame|strTagType|strType|strCurrentWindowHandle|";
			strKeys = strKeys + "strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strScreenshotFilePath|strStatus|blnStatus";
			return strKeys.split("\\|");
		}
	}

	public static String stepCreateExpected(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>stepCreateExpected " + dateTimestamp());
		String strAction = gobjJsonObjectStep.get("strAction").toString();
		String strInputValue = gobjJsonObjectStep.get("strInputValue").toString();
		String strMillisecondsToWait = gobjJsonObjectStep.get("intMillisecondsToWait").toString();
		String strObjectName = gobjJsonObjectStep.get("strAttributeNames").toString() + "=" + gobjJsonObjectStep.get("strAttributeValues").toString();
		String strTagName = gobjJsonObjectStep.get("strTagName").toString();
		switch (strAction.toLowerCase()) {
		case "launch":
			return "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + strMillisecondsToWait + "} milliseconds";
		case "close":
			return "Close {" + strTagName + "} browser within {" + strMillisecondsToWait + "} milliseconds";
		case "get":
			return "Get {" + strTagName + "} tag with attributes {" + strObjectName + "} value" + " within {" + strMillisecondsToWait + "} milliseconds";
		case "set":
			return "Set  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "}" + " within " + strMillisecondsToWait + "} milliseconds";
		case "verify":
			return "Verify  {" + strTagName + "} tag with attributes {" + strObjectName + "} value is equal to {" + strInputValue + "}" + " within " + strMillisecondsToWait + "} milliseconds";
		case "mouse_over":
			return "Mouse over  {" + strTagName + "} tag with attributes {" + strObjectName + "} within " + strMillisecondsToWait + "} milliseconds";
		case "sync_visible":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is visible within {" + strMillisecondsToWait + "} milliseconds";
		case "sync_hidden":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is hidden within {" + strMillisecondsToWait + "} milliseconds";
		case "sync_enabled":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is enabled within {" + strMillisecondsToWait + "} milliseconds";
		case "sync_disabled":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is disabled within {" + strMillisecondsToWait + "} milliseconds";
		case "break":
		default:
			return strAction;
		}
	}

	public static String stepCreateActual(Dragonfly objDragonfly, String strStepType) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>stepCreateActual " + dateTimestamp());
		//String strStepDetails = gobjJsonObjectStep.get("strAttributeValues").toString();
		String intWaited = "";
		String strActualHtml = "";
		String strActualReturn = "";
		String strActualReturnHTML = "";
		String strActualText = "";
		String strInputParameterValueHTML = "";
		String strInputValue = gobjJsonObjectStep.get("strInputValue").toString();
		String strOutputValue = gobjJsonObjectStep.get("strOutputValue").toString();
		String strOutputValueHtml = gobjJsonObjectStep.get("strOutputValue").toString();
		String strParameterName = "";
		String strStepParameterName = "";
		String strTagName = gobjJsonObjectStep.get("strTagName").toString();
		// strStepParameterName & " " & strObjectToString
		// strObjectToString = objObjectDetailsHTML.GetTOProperty("TestObjGenType")
		// strInputParameterValueHTML = FormatHTML(strInputValue)
		// strActualReturnHTML = FormatHTML(strActualReturn)
		switch (strStepType.toUpperCase()) {
		case "LAUNCH":
			strActualHtml = "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + intWaited + "} milliseconds";
			strActualText = "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + intWaited + "} milliseconds";
			break;
		case "CLOSE":
			strActualHtml = "Close {" + strTagName + "} browser within {" + intWaited + "} milliseconds";
			strActualText = "Close {" + strTagName + "} browser within {" + intWaited + "} milliseconds";
			break;
		case "DEFAULT":
			strActualHtml = "The <b>" + strTagName + " </b> default value is {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>}.";
			strActualText = "The expected " + strTagName + " default value is " + strOutputValue + ".";
			break;
		case "CLICKED":
			strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was clicked.";
			strActualText = "The expected " + strTagName + "  value {" + strInputValue + "} was clicked.";
			break;
		case "EXPECTED":
			strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was not verified.<BR>The actual value was {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>}.";
			strActualText = "The expected " + strTagName + " value {" + strInputValue + "} was not verified.  The actual value was {" + strActualReturn + "}.";
			break;
		case "EXPECTEDTOOLTIP":
			strActualHtml = "The expected <b>" + strTagName + "</b>  tooltip value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was not verified.<BR>The actual value was {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>}.";
			strActualText = "The expected " + strTagName + " tooltip value {" + strInputValue + "} was not verified.  The actual value was {" + strActualReturn + "}.";
			break;
		case "FIND":
			strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was found.";
			strActualText = "The expected " + strTagName + "  value {" + strOutputValue + "} was found.";
			break;
		case "NOTFOUND":
			strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was not found.";
			strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} was not found.";
			break;
		case "VERIFY":
			strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was verified.";
			strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} was verified.";
			break;
		case "VERIFYTOOLTIP":
			strActualHtml = "The expected <b>" + strTagName + "</b> tooltip value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was verified.";
			strActualText = "The expected " + strTagName + " tooltip value {" + strOutputValue + "} was verified.";
			break;
		case "GET":
			strActualHtml = "The <b>" + strTagName + " </b> actual value is {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>}.";
			strActualText = "The " + strTagName + " actual value is {" + strOutputValue + "}";
			break;
		case "GETTOOLTIP":
			strActualHtml = "The <b>" + strTagName + " </b> tooltip actual value is {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>}.";
			strActualText = "The " + strTagName + " tooltip actual value is {" + strOutputValue + "}";
			break;
		case "SET":
			strActualHtml = "The expected <b>" + strTagName + " </b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was set.";
			strActualText = "The expected " + strTagName + " value {" + strInputValue + "} was set.";
			break;
		case "PERSISTED":
			strActualHtml = "The expected <b>" + strTagName + " </b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} persisted.";
			strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} persisted.";
			break;
		case "PASSWORD":
			strActualHtml = "The <b>" + strTagName + " </b> password value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} was set.";
			strActualText = "The " + strTagName + " password value {" + strOutputValue + "} was set.";
			break;
		case "NOTPERSISTED":
			strActualHtml = "The expected <b>" + strTagName + " </b> value  {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} did not persist.<BR>The actual value {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} was displayed.";
			strActualText = "The expected " + strTagName + " value {" + strInputValue + "} did not persist.  The actual value {" + strActualReturn + "} was displayed.";
			break;
		case "EXIST":
			strActualHtml = "The expected <b>" + strTagName + "</b> exists.";
			strActualText = "The expected " + strTagName + " exists.";
			break;
		case "NOTEXIST":
			strActualHtml = "The expected <b>" + strTagName + "</b> does not exist after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " does not exist after " + intWaited + " milliseconds.";
			break;
		case "NOTEXISTTOOLTIP":
			strActualHtml = "The expected <b>" + strTagName + "</b> tooltip does not exist after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " tooltip does not exist after " + intWaited + " milliseconds.";
			break;
		case "INVISIBLE":
			strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is invisible.";
			strActualText = "The expected " + strTagName + " is invisible.";
			break;
		case "ENABLED":
			strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is enabled.";
			strActualText = "The expected " + strTagName + " is enabled.";
			break;
		case "DISABLED":
			strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is disabled.";
			strActualText = "The expected " + strTagName + " is disabled.";
			break;
		case "VISIBLE":
			strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is visible.";
			strActualText = "The expected " + strTagName + " is visible.";
			break;
		case "HIDDEN":
			strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is hidden.";
			strActualText = "The expected " + strTagName + " is hidden.";
			break;
		case "SYNCNOTEXISTS":
			strActualHtml = "The expected <b>" + strTagName + "</b></b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} does not exist after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} does not exist after " + intWaited + " milliseconds.";
			break;
		case "SYNCEXISTS":
			strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} exists after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
			break;
		case "SYNCCLOSED":
			strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} closed after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} closed after " + intWaited + " milliseconds.";
			break;
		case "SYNCNOTCLOSED":
			strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} did not close after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} did not close after " + intWaited + " milliseconds.";
			break;
		case "SYNCHIDDEN":
			strActualHtml = "The expected <b>" + strTagName + "</b></b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} does not exist after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} does not exist after " + intWaited + " milliseconds.";
			break;
		case "SYNCVISIBLE":
			strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} exists after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
			break;
		case "SYNCOPTIONAL":
			strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} sync is optional after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
			break;
		case "SYNCDISABLED":
			strActualHtml = "The expected <b>" + strTagName + "</b></b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} does not exist after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} does not exist after " + intWaited + " milliseconds.";
			break;
		case "SYNCENABLED":
			strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} exists after " + intWaited + " milliseconds.";
			strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
			break;
		case "NAVIGATE":
			strActualHtml = "The expected <b>" + strTagName + " </b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} was set.<BR>No validation performed due to navigation.";
			strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} was set. No validation performed due to navigation.";
			break;
		case "KEYSTROKE":
			strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was pressed.";
			strActualText = "The expected " + strTagName + "  value {" + strInputValue + "} was pressed.";
			break;
		case "NOTINLIST":
			strActualHtml = "The list item {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} does not exist in the <b>" + strStepParameterName + "</b> list field.<BR>Please confirm the input value against the actual list values {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} is available for this field.";
			strActualText = "The list item {" + strInputValue + "} does not exist in the " + strParameterName + " list field.  Please confirm the input value against the actual list values {" + strActualReturn + "} is available for this field.";
			break;
		case "DRAG":
			strActualHtml = "The list item {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} does not exist in the <b>" + strStepParameterName + "</b> list field.<BR>Please confirm the input value against the actual list values {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} is available for this field.";
			strActualText = "The list item {" + strInputValue + "} does not exist in the " + strParameterName + " list field.  Please confirm the input value against the actual list values {" + strActualReturn + "} is available for this field.";
			break;
		case "DROP":
			strActualHtml = "The list item {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} does not exist in the <b>" + strStepParameterName + "</b> list field.<BR>Please confirm the input value against the actual list values {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} is available for this field.";
			strActualText = "The list item {" + strInputValue + "} does not exist in the " + strParameterName + " list field.  Please confirm the input value against the actual list values {" + strActualReturn + "} is available for this field.";
			break;
		case "break":
			break;
		}
		strActualHtml = "<DIV align='left/>" + strActualHtml + "</DIV>";
		return strActualText;
	}

	public static void webElementCollectionTable(Dragonfly objDragonfly, String strTagName) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>webElementCollectionTable " + dateTimestamp());
		// TODO webElementCollectionTable send output to html file
		int intCount = 0;
		//JSONObject objStepNew = null;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		objDragonfly.objLogger.setLogRow("webElementCollectionTable: lngStartTimeSwitchTo = " + gobjWebDriver.getTitle());
		gobjWebDriver.switchTo().defaultContent();
		for (String winHandle : gobjWebDriver.getWindowHandles()) {
			intCount = 0;
			// objDragonfly.objLogger.setLogRow("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
			objDragonfly.objLogger.setLogRow("webElementCollectionTable: winHandle = " + winHandle);
			long lngStartTimeSwitchTo = System.currentTimeMillis();
			// if (strCurrentWindowHandle.equals(winHandle)) {
			// } else {
			gobjWebDriver.switchTo().window(winHandle);
			objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			objDragonfly.objLogger.setLogRow("webElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
			// }
			objDragonfly.objLogger.setLogRow("webElementCollectionTable: gobjWebDriver.getTitle = " + gobjWebDriver.getTitle());
			//objDragonfly.objLogger.setLogRow("webElementCollectionTable gobjWebDriver.getPageSource = " + gobjWebDriver.getPageSource());
			objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			List<WebElement> objWebElementCollection = gobjWebDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				// try {
				// elementVisible(objStepNew, row);
				intCount = intCount + 1;
				objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
				// objDragonfly.objLogger.setLogRow("text:=  " + objWebElementEach.);
				objDragonfly.objLogger.setLogRow("webElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
				// objDragonfly.objLogger.setLogRow("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
				// objDragonfly.objLogger.setLogRow("TagName:= '" + row.getAttribute("TagName") + "'");
				// objDragonfly.objLogger.setLogRow("type:= '" + row.getAttribute("type") + "'");
				// objDragonfly.objLogger.setLogRow("Type:= '" + row.getAttribute("Type") + "'");
				// objDragonfly.objLogger.setLogRow("TYPE:= '" + row.getAttribute("TYPE") + "'");
				// objDragonfly.objLogger.setLogRow("id:= '" + row.getAttribute("id") + "'");
				// objDragonfly.objLogger.setLogRow("name:= '" + row.getAttribute("name") + "'");
				// objDragonfly.objLogger.setLogRow("text:= '" + row.getAttribute("text") + "'");
				objDragonfly.objLogger.setLogRow("webElementCollectionTable: getText:= '" + row.getText() + "'");
				// objDragonfly.objLogger.setLogRow("innerText:= '" + row.getAttribute("innerText") + "'");
				// objDragonfly.objLogger.setLogRow("outerText:= '" + row.getAttribute("outerText") + "'");
				// objDragonfly.objLogger.setLogRow("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
				objDragonfly.objLogger.setLogRow("webElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
				// objDragonfly.objLogger.setLogRow("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
				// objDragonfly.objLogger.setLogRow("class:= '" + row.getAttribute("class") + "'");
				// objDragonfly.objLogger.setLogRow("href:= '" + row.getAttribute("href") + "'");
				// objDragonfly.objLogger.setLogRow("NameProp:= '" + row.getAttribute("NameProp") + "'");
				// objDragonfly.objLogger.setLogRow("isDisplayed:= '" + row.isDisplayed() + "'");
				// objDragonfly.objLogger.setLogRow("isEnabled:= '" + row.isEnabled() + "'");
				// objDragonfly.objLogger.setLogRow("getLocation().x:= '" + row.getLocation().x + "'");
				// objDragonfly.objLogger.setLogRow("getLocation().y:= '" + row.getLocation().y + "'");
				// objDragonfly.objLogger.setLogRow("getSize().height:= '" + row.getSize().height + "'");
				// objDragonfly.objLogger.setLogRow("getSize().width:= '" + row.getSize().width + "'");
				// objDragonfly.objLogger.setLogRow("src:= '" + row.getAttribute("src") + "'");
				// if (objCollectionJS.size() > 0) {
				//
				// JavascriptExecutor objJavascriptExecutor = null;
				// objJavascriptExecutor = (JavascriptExecutor) gobjWebDriver;
				// long lngStartTimeJS = System.currentTimeMillis();
				// objDragonfly.objLogger.setLogRow("JS value = " +
				// objJavascriptExecutor.executeScript("return arguments[0].value;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// objDragonfly.objLogger.setLogRow("JS innerText = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// objDragonfly.objLogger.setLogRow("JS innerHTML = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// objDragonfly.objLogger.setLogRow("JS outerHTML = " +
				// objJavascriptExecutor.executeScript("return arguments[0].outerHTML;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				//
				// }
				// } catch (ElementNotVisibleException e) {
				// // e.printStackTrace();
				// }
			}
		}
	}

	public static void webElementCollectionAttributes(Dragonfly objDragonfly, String strTagName) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>webElementCollectionAttributes " + dateTimestamp());
		int intCount = 0;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		List<WebElement> objWebElementCollection = gobjWebDriver.findElements(By.tagName(strTagName));
		Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
		while (objWebElementEach.hasNext()) {
			WebElement row = objWebElementEach.next();
			intCount = intCount + 1;
			objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionAttributes " + intCount);
			// objDragonfly.objLogger.setLogRow("text:=  " + objWebElementEach.);
			objDragonfly.objLogger.setLogRow("text:=  " + row.getTagName());
			objDragonfly.objLogger.setLogRow("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
			objDragonfly.objLogger.setLogRow("TagName:=  " + row.getAttribute("TagName"));
			objDragonfly.objLogger.setLogRow("type:=  " + row.getAttribute("type"));
			objDragonfly.objLogger.setLogRow("id:=  " + row.getAttribute("id"));
			objDragonfly.objLogger.setLogRow("name:=  " + row.getAttribute("name"));
			objDragonfly.objLogger.setLogRow("text:=  " + row.getAttribute("text"));
			objDragonfly.objLogger.setLogRow("innerText:=  " + row.getAttribute("innerText"));
			objDragonfly.objLogger.setLogRow("outerText:=  " + row.getAttribute("outerText"));
			objDragonfly.objLogger.setLogRow("innerHTML:=  " + row.getAttribute("innerHTML"));
			objDragonfly.objLogger.setLogRow("outerHTML:=  " + row.getAttribute("outerHTML"));
			objDragonfly.objLogger.setLogRow("uniqueID:=  " + row.getAttribute("uniqueID"));
			objDragonfly.objLogger.setLogRow("class:=  " + row.getAttribute("class"));
			objDragonfly.objLogger.setLogRow("type:=  " + row.getAttribute("type"));
			objDragonfly.objLogger.setLogRow("TYPE:=  " + row.getAttribute("TYPE"));
			objDragonfly.objLogger.setLogRow("href:=  " + row.getAttribute("href"));
			objDragonfly.objLogger.setLogRow("NameProp:=  " + row.getAttribute("NameProp"));
			objDragonfly.objLogger.setLogRow("isDisplayed:=  " + row.isDisplayed());
			objDragonfly.objLogger.setLogRow("name:=  " + row.isEnabled());
			objDragonfly.objLogger.setLogRow("getLocation().x:=  " + row.getLocation().x);
			objDragonfly.objLogger.setLogRow("getLocation().y:=  " + row.getLocation().y);
			objDragonfly.objLogger.setLogRow("getSize().height:=  " + row.getSize().height);
			objDragonfly.objLogger.setLogRow("getLocation().y:=  " + row.getSize().width);
			objDragonfly.objLogger.setLogRow("src:=  " + row.getAttribute("src"));
		}
	}

	public static void webElementAttributes(Dragonfly objDragonfly) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>webElementAttributes " + dateTimestamp());
		// objDragonfly.objLogger.setLogRow("text:=  " + objWebElementEach.);
		objDragonfly.objLogger.setLogRow("text:=  " + gobjWebElement.getTagName());
		objDragonfly.objLogger.setLogRow("tag_type:=  " + gobjWebElement.getTagName() + "_" + gobjWebElement.getAttribute("type"));
		objDragonfly.objLogger.setLogRow("TagName:=  " + gobjWebElement.getAttribute("TagName"));
		objDragonfly.objLogger.setLogRow("type:=  " + gobjWebElement.getAttribute("type"));
		objDragonfly.objLogger.setLogRow("id:=  " + gobjWebElement.getAttribute("id"));
		objDragonfly.objLogger.setLogRow("name:=  " + gobjWebElement.getAttribute("name"));
		objDragonfly.objLogger.setLogRow("text:=  " + gobjWebElement.getAttribute("text"));
		objDragonfly.objLogger.setLogRow("innerText:=  " + gobjWebElement.getAttribute("innerText"));
		objDragonfly.objLogger.setLogRow("outerText:=  " + gobjWebElement.getAttribute("outerText"));
		objDragonfly.objLogger.setLogRow("innerHTML:=  " + gobjWebElement.getAttribute("innerHTML"));
		objDragonfly.objLogger.setLogRow("outerHTML:=  " + gobjWebElement.getAttribute("outerHTML"));
		objDragonfly.objLogger.setLogRow("uniqueID:=  " + gobjWebElement.getAttribute("uniqueID"));
		objDragonfly.objLogger.setLogRow("class:=  " + gobjWebElement.getAttribute("class"));
		objDragonfly.objLogger.setLogRow("type:=  " + gobjWebElement.getAttribute("type"));
		objDragonfly.objLogger.setLogRow("TYPE:=  " + gobjWebElement.getAttribute("TYPE"));
		objDragonfly.objLogger.setLogRow("href:=  " + gobjWebElement.getAttribute("href"));
		objDragonfly.objLogger.setLogRow("NameProp:=  " + gobjWebElement.getAttribute("NameProp"));
		objDragonfly.objLogger.setLogRow("isDisplayed:=  " + gobjWebElement.isDisplayed());
		objDragonfly.objLogger.setLogRow("name:=  " + gobjWebElement.isEnabled());
		objDragonfly.objLogger.setLogRow("getLocation().x:=  " + gobjWebElement.getLocation().x);
		objDragonfly.objLogger.setLogRow("getLocation().y:=  " + gobjWebElement.getLocation().y);
		objDragonfly.objLogger.setLogRow("getSize().height:=  " + gobjWebElement.getSize().height);
		objDragonfly.objLogger.setLogRow("getLocation().y:=  " + gobjWebElement.getSize().width);
		objDragonfly.objLogger.setLogRow("src:=  " + gobjWebElement.getAttribute("src"));
	}

	public static BufferedImage imageDecodeFromString(Dragonfly objDragonfly, String strImageString) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>imageDecodeFromString " + dateTimestamp());
		BufferedImage objBufferedImage = null;
		byte[] arrImageByte;
		try {
			BASE64Decoder objBASE64Decoder = new BASE64Decoder();
			arrImageByte = objBASE64Decoder.decodeBuffer(strImageString);
			ByteArrayInputStream objByteArrayInputStream = new ByteArrayInputStream(arrImageByte);
			objBufferedImage = ImageIO.read(objByteArrayInputStream);
			objByteArrayInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBufferedImage;
	}

	public static String imageEncodeToString(Dragonfly objDragonfly, BufferedImage objBufferedImage, String strImageType) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>imageEncodeToString " + dateTimestamp());
		String strImageString = null;
		ByteArrayOutputStream objByteArrayOutputStreams = new ByteArrayOutputStream();
		try {
			ImageIO.write(objBufferedImage, strImageType, objByteArrayOutputStreams);
			byte[] arrImageByte = objByteArrayOutputStreams.toByteArray();
			BASE64Encoder objBASE64Encoder = new BASE64Encoder();
			strImageString = objBASE64Encoder.encode(arrImageByte);
			objByteArrayOutputStreams.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strImageString;
	}

	public static Integer randomNumberRange(Dragonfly objDragonfly, int intNumberMinimum, int intNumberMaximum) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>randomNumberRange " + dateTimestamp());
		Random objRandom = new Random();
		return objRandom.nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
	}

	public static void webDriverTest() {
		System.setProperty("webdriver.ie.driver", "C:/Users/perrj115/Documents/GitHub/dragonfly/Dragonfly/Drivers/IEDriverServer.exe");
		WebDriver driver;
		driver = new InternetExplorerDriver();
		//		driver = new FirefoxDriver();
		//		driver = new HtmlUnitDriver(true);
		//	assertTrue(true);
		driver.close();
		driver.quit();
	}

	public static void writeFile(Dragonfly objDragonfly, String strPathFullFile, String strTextToWrite) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>writeFile " + dateTimestamp());
		objDragonfly.objLogger.setLogRow("writeFile: strPathFullFile = " + strPathFullFile);
		// objDragonfly.objLogger.setLogRow("writeFile strTextToWrite = " + strTextToWrite);
		BufferedWriter objBufferedWriter = null;
		try {
			objBufferedWriter = new BufferedWriter(new FileWriter(strPathFullFile));
			objBufferedWriter.write(strTextToWrite);
			objBufferedWriter.close();
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("writeReportToHtml: IOException" + e.getMessage());
		}
	}

	public static void writeJsonKeys(Dragonfly objDragonfly, JSONObject objJsonObjectKeySet, String file) throws IOException {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>writeJsonKeysToHtml " + dateTimestamp());
		for (Iterator<?> iterator = objJsonObjectKeySet.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			objDragonfly.objLogger.setLogRow("writeJsonKeysToHtml: " + key + " = " + objJsonObjectKeySet.get(key));
		}
	}

	//	public static void writeJsonStepsToHtml(String strStepHeader, JSONArray objTestSteps, String strPath, String strFileName) {
	//		objDragonfly.objLogger.setLogRow("  ==start==>writeJsonStepsAfterRunToHtml " + dateTimestamp());
	//		String strKey = "";
	//		String[] arrKeys = null;
	//		stepsNames StepsNames = new Dragonfly().new stepsNames();
	//		switch (strStepHeader) {
	//		case "original":
	//			//arrKeys = stepsNamesOriginalArray();
	//			arrKeys = StepsNames.getOriginal();
	//			break;
	//		case "complete":
	//			//arrKeys = stepsNamesCompleteArray();
	//			arrKeys = StepsNames.getComplete();
	//			break;
	//		}
	//		StringBuilder objStringBuilder = new StringBuilder();
	//		try {
	//			objStringBuilder.append("<!DOCTYPE html>");
	//			objStringBuilder.append("<html lang=\"en\">");
	//			objStringBuilder.append("<head><title> " + strFileName.replace(".html", "") + "</title></head>");
	//			objStringBuilder.append("<body><h1>");
	//			objStringBuilder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
	//			objStringBuilder.append("<tr>");
	//			objStringBuilder.append("<td>Step</td>");
	//			for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
	//				strKey = (String) arrKeys[intKeysEach].toString();
	//				objStringBuilder.append("<th>" + strKey + "</th>");
	//			}
	//			objStringBuilder.append(" </tr>  ");
	//			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
	//				objStringBuilder.append("</tr>");
	//				objStringBuilder.append("<td> " + (intTestStepRow + 1) + "</td>");
	//				JSONObject objStepReport = (JSONObject) objTestSteps.get(intTestStepRow);
	//				for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
	//					strKey = (String) arrKeys[intKeysEach].toString();
	//					if (objStepReport.containsKey(strKey) == true) {
	//						objStringBuilder.append("<td> " + objStepReport.get(strKey) + "</td>");
	//					} else {
	//						objStringBuilder.append("<td>  &nbsp; </td>");
	//					}
	//				}
	//				objStringBuilder.append(" </tr>  ");
	//			}
	//			objStringBuilder.append("</table>");
	//			objStringBuilder.append("</h1></body>");
	//			objStringBuilder.append("</html>");
	//			String html = objStringBuilder.toString();
	//			writeFile(strPath + strFileName, html);
	//		} catch (Exception e) {
	//			objDragonfly.objLogger.setLogRow("writeJsonStepsToHtml: Exception = " + e.toString());
	//			objDragonfly.objLogger.setLogRow("writeJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
	//		}
	//	}
	public class writeJsonStepsToHtml {
		public void createReport(Dragonfly objDragonfly, String strStepHeader, JSONArray objTestSteps, String strPath, String strFileName) {
			objLogger.setLogRow("  ==start==>writeJsonStepsAfterRunToHtml " + dateTimestamp());
			//Dragonfly objDragonfly = new Dragonfly();
			//objDragonfly.objLogger.setLogRow("  ==start==>writeJsonStepsAfterRunToHtml " + dateTimestamp());
			String strKey = "";
			String[] arrKeys = null;
			stepsNames StepsNames = new Dragonfly().new stepsNames();
			switch (strStepHeader) {
			case "original":
				//arrKeys = stepsNamesOriginalArray();
				arrKeys = StepsNames.getOriginal();
				break;
			case "complete":
				//arrKeys = stepsNamesCompleteArray();
				arrKeys = StepsNames.getComplete();
				break;
			}
			StringBuilder objStringBuilder = new StringBuilder();
			try {
				objStringBuilder.append("<!DOCTYPE html>");
				objStringBuilder.append("<html lang=\"en\">");
				objStringBuilder.append("<head><title> " + strFileName.replace(".html", "") + "</title></head>");
				objStringBuilder.append("<body><h1>");
				objStringBuilder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
				objStringBuilder.append("<tr>");
				objStringBuilder.append("<td>Step</td>");
				for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
					strKey = (String) arrKeys[intKeysEach].toString();
					objStringBuilder.append("<th>" + strKey + "</th>");
				}
				objStringBuilder.append(" </tr>  ");
				for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
					objStringBuilder.append("</tr>");
					objStringBuilder.append("<td> " + (intTestStepRow + 1) + "</td>");
					JSONObject objStepReport = (JSONObject) objTestSteps.get(intTestStepRow);
					for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
						strKey = (String) arrKeys[intKeysEach].toString();
						if (objStepReport.containsKey(strKey) == true) {
							objStringBuilder.append("<td> " + objStepReport.get(strKey) + "</td>");
						} else {
							objStringBuilder.append("<td>  &nbsp; </td>");
						}
					}
					objStringBuilder.append(" </tr>  ");
				}
				objStringBuilder.append("</table>");
				objStringBuilder.append("</h1></body>");
				objStringBuilder.append("</html>");
				String html = objStringBuilder.toString();
				writeFile(objDragonfly, strPath + strFileName, html);
			} catch (Exception e) {
				//objDragonfly.objLogger.setLogRow("writeJsonStepsToHtml: Exception = " + e.toString());
				//objDragonfly.objLogger.setLogRow("writeJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
				objLogger.setLogRow("writeJsonStepsToHtml: Exception = " + e.toString());
				objLogger.setLogRow("writeJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			}
		}
	}

	public static void writeReportToHtml(Dragonfly objDragonfly, JSONArray objJsonArrayReportSteps, String strFile) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>writeReportToHtml " + dateTimestamp());
		objDragonfly.objLogger.setLogRow("writeReportToHtml: strFile = " + strFile);
		long lngStartTimeWriteReportToHtml = System.currentTimeMillis();
		JSONObject objJsonObjectReportStep = null;
		String strScreenshotFilePath = "";
		String strStatus = "";
		String strStatusIcon = "";
		StringBuilder objStringBuilder = new StringBuilder();
		try {
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<head><title>Run Results</title></head>");
			objStringBuilder.append("<body>");
			for (int intTestStepRow = 0; intTestStepRow < objJsonArrayReportSteps.size(); intTestStepRow++) {
				objJsonObjectReportStep = (JSONObject) objJsonArrayReportSteps.get(intTestStepRow);
				objStringBuilder.append("<div id=step_" + intTestStepRow + ">");
				objStringBuilder.append("<TABLE border=1 width=100% height=10%>");
				objStringBuilder.append("<TR>");
				switch (objJsonObjectReportStep.get("strStatus").toString().toLowerCase()) {
				case "pass":
					strStatus = "Pass";
					if (objJsonObjectReportStep.get("strAction").toString().toLowerCase().equals("set") && objJsonObjectReportStep.get("strAssert").toString().toLowerCase().equals("off")) {
						strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:blue\">&#10043</span>";
					} else {
						strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:green\">&#10003</span>";
					}
					break;
				case "fail":
					strStatus = "Fail";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:red\">&#10007</span>";
					break;
				case "warning":
					strStatus = "Warning";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:gold\">!</span>";
					break;
				case "info":
					strStatus = "Info";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:magenta\">?</span>";
					break;
				}
				String strStartTimestamp = objJsonObjectReportStep.get("strStartTimestamp").toString();
				String strStepDuration = objJsonObjectReportStep.get("strStepDuration").toString();
				String strEndTimestamp = objJsonObjectReportStep.get("strEndTimestamp").toString();
				objStringBuilder.append("<TD rowspan=\"2\" width=60px align=center valign=middle>Step " + intTestStepRow + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=35px align=center valign=middle>" + strStatusIcon + "<br>" + strStatus + "</TD>");
				objStringBuilder.append("<TD width= 75px align=center valign=middle>Expected</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objJsonObjectReportStep.get("strStepExpected").toString() + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=150px align=left valign=middle>Start:" + strStartTimestamp + "<br>End: " + strEndTimestamp + "<br>Duration: " + strStepDuration + " ms</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("<TR>");
				objStringBuilder.append("<TD align=center valign=middle>Actual</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objJsonObjectReportStep.get("strStepActual").toString() + "</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("</TABLE> ");
				if (objJsonObjectReportStep.get("strScreenshotFilePath").toString().trim().length() != 0) {
					strScreenshotFilePath = objJsonObjectReportStep.get("strScreenshotFilePath").toString().replaceAll("\\\\\\\\", "\\");
					try {
						BufferedImage objBufferedImage = ImageIO.read(new File(strScreenshotFilePath));
						objStringBuilder.append("<img src=\"data:image/jpg;base64," + imageEncodeToString(objDragonfly, objBufferedImage, "jpg") + "\" alt=\"Step " + intTestStepRow + "\" > ");
					} catch (Exception e) {
						objDragonfly.objLogger.setLogRow("writeReportToHtml: Exception = " + e.toString());
					}
				}
				objStringBuilder.append("</div>");
				objStringBuilder.append("<br>");
				objStringBuilder.append("<br>");
				if (objJsonObjectReportStep.get("strAction").toString().toLowerCase().equals("break")) {
					break;
				}
			}
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("writeReportToHtml: " + e.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			String strHTML = objStringBuilder.toString();
			writeFile(objDragonfly, strFile, strHTML);
			objDragonfly.objLogger.setLogRow("writeReportToHtml: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeWriteReportToHtml));
		}
	}

	public String data_DateDaysOut(Dragonfly objDragonfly, String strDaysOut) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>data_DateDaysOut " + dateTimestamp());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat FormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (String) (FormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_EnvironmentURL(Dragonfly objDragonfly, String strApplication_Environment) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>data_EnvironmentURL " + dateTimestamp());
		String strURL = "";
		String strPathFullTestData = gstrPathTestData + "/Environment.json";
		try {
			JSONObject objJsonObjectFile = (JSONObject) gobjJsonParser.parse(new FileReader(strPathFullTestData));
			strURL = objJsonObjectFile.get(strApplication_Environment).toString();
			objDragonfly.objLogger.setLogRow("data_EnvironmentURL: strURL = " + strURL);
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("data_EnvironmentURL: Exception = " + e.toString());
		}
		return strURL;
	}

	public String data_localWebsiteFilePath(Dragonfly objDragonfly, String strWebsite) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>data_localWebsiteFilePath " + dateTimestamp());
		String strLocalWebsiteFilePath = "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		objDragonfly.objLogger.setLogRow("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public String data_RandomFourNumbers(Dragonfly objDragonfly, String strDaysOut) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>data_RandomFourNumbers " + dateTimestamp());
		return Integer.toString(randomNumberRange(objDragonfly, 1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(Dragonfly objDragonfly, String strDataInput) {
		//Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>data_RandomRangeFiveNumbers " + dateTimestamp());
		return Integer.toString(randomNumberRange(objDragonfly, 1, 99999));
	}
}