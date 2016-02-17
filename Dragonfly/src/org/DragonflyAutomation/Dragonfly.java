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
//TODO create a level for logging and add a global variable and a switch statement to logger with several levels to filter what calls are added to logger with a new input parameter intLevel
//TODO clean up unneeded code for new methods and limit comments to logger as needed for normal execution
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
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	static int intTestInstanceEach = 0;
	static int intTestInstanceSize = 0;
	static JSONArray objLinkArray = null;
	static JSONArray objTestInstances = null;
	static JSONArray objTestSteps = null;
	static JSONArray objTestStepsCombinedOriginal = null;
	static JSONObject objElement = null;
	static JSONObject objElements = null;
	static JSONObject objJsonStepsFile = null;
	static JSONObject objJsonTestDataFile = null;
	static JSONObject objLinks = null;
	static JSONObject objTestInstance = null;
	static JSONParser objJsonParser = new JSONParser();
	static String strLog = "";
	static String strOperatingSystem = "";
	static String strPathData = "Data/internal/";//"Data/public/";//
	static String strPathElementRepository = strPathData + "element_repository/";
	static String strPathSystemUserDir = System.getProperty("user.dir");
	static String strPathTestData = strPathData + "test_data/";
	static String strPathTestInstances = strPathData + "test_instances/";
	static String strPathTestMatrix = strPathData + "test_matrix/";
	static String strPathTestModules = strPathData + "test_modules/";
	static String strTestStepsCombinedOriginal = "";
	static String strPathResultsFolder = "";
	static String strPathResultsIterationsFolder = "";
	static WebDriver objWebDriver = null;
	static WebElement objWebElement;
	static WebElement objWebElementDrag;
	static WebElement objWebElementDrop;
	static Alert objAlert = null;
	static AutoItX objAutoIt;

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

	public static void logger(String strTextToAdd) {
		System.out.println(strTextToAdd);
		if (strLog.length() == 0) {
			strLog = strTextToAdd;
		} else {
			strLog = strLog + System.getProperty("line.separator") + strTextToAdd;
		}
	}

	public String data_DateDaysOut(String strDaysOut) {
		logger("  ==start==>data_DateDaysOut " + dateTimestamp());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat FormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (String) (FormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_RandomFourNumbers(String strDaysOut) {
		logger("  ==start==>data_RandomFourNumbers " + dateTimestamp());
		return Integer.toString(randomNumberRange(1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(String strDataInput) {
		logger("  ==start==>data_RandomRangeFiveNumbers " + dateTimestamp());
		return Integer.toString(randomNumberRange(1, 99999));
	}

	public String data_EnvironmentURL(String strApplication_Environment) {
		logger("  ==start==>data_EnvironmentURL " + dateTimestamp());
		String strURL = "";
		String strPathFullTestData = strPathTestData + "/Environment.json";
		JSONParser objJsonParser = new JSONParser();
		try {
			JSONObject objJsonFile = (JSONObject) objJsonParser.parse(new FileReader(strPathFullTestData));
			strURL = objJsonFile.get(strApplication_Environment).toString();
			logger("data_EnvironmentURL: strURL = " + strURL);
		} catch (Exception e) {
			logger("data_EnvironmentURL: Exception = " + e.toString());
		}
		return strURL;
	}

	public String data_localWebsiteFilePath(String strWebsite) {
		logger("  ==start==>data_localWebsiteFilePath " + dateTimestamp());
		String strLocalWebsiteFilePath = "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		logger("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public static String oSType() {
		logger("  ==start==>oSType " + dateTimestamp());
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

	public static String jvmBitVersion() {
		logger("jvmBitVersion: System.getProperty(sun.arch.data.model) =" + System.getProperty("sun.arch.data.model"));
		return System.getProperty("sun.arch.data.model");
	}

	public static void autoItSetObject() throws InterruptedException {
		logger("  ==start==>autoItSetObject " + dateTimestamp());
		String jacobDllVersionToUse;
		if (jvmBitVersion().contains("32")) {
			jacobDllVersionToUse = "jacob-1.18-x86.dll";
		} else {
			jacobDllVersionToUse = "jacob-1.18-x64.dll";
		}
		logger("autoItSetObject: " + System.getProperty("java.library.path"));
		logger("autoItSetObject: " + jacobDllVersionToUse);
		File file = new File("Libraries", jacobDllVersionToUse);
		logger("autoItSetObject: " + LibraryLoader.JACOB_DLL_PATH);
		logger("autoItSetObject: " + file.getAbsolutePath());
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		objAutoIt = new AutoItX();
	}

	public static void windowsMinimizeAll() {
		logger("  ==start==>windowsMinimizeAll " + dateTimestamp());
		Robot objRobot = null;
		switch (strOperatingSystem) {
		case "Windows":
			try {
				objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_WINDOWS);
				objRobot.keyPress(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_WINDOWS);
				logger("windowsMinimizeAll: Windows operating system minimize all windows.");
			} catch (Exception e) {
				logger("windowsMinimizeAll: Exception = " + e.toString());
			}
			break;
		case "default":
			logger("windowsMinimizeAll: the operating system not supported at this time " + strOperatingSystem);
		}
	}

	public static void windowsProcessKill(String strProcessToKill) {
		logger("  ==start==>windowsProcessKill " + dateTimestamp());
		try {
			Runtime.getRuntime().exec(strProcessToKill);
			logger("windowsProcessKill: process killed = " + strProcessToKill);
		} catch (Exception e) {
			logger("windowsProcessKill: Exception = " + e.toString());
		}
	}

	public static void sleepMilliseconds(int intMillisecondsToWait) {
		logger("  ==start==>sleepMilliseconds " + dateTimestamp());
		try {
			TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
		} catch (Exception e) {
			logger("sleepMilliseconds: Exception = " + e.toString());
		}
	}

	public static void main(String[] args) {
		logger("  ==start==>main " + dateTimestamp());
		//testPage();
		// try {
		// logger("clearMyTracksByProcessCookies start = ");
		// commandLineExecution();
		// // clearMyTracksByProcessCookies();
		// // clearMyTracksByProcessCache();
		// } catch (Exception e1) {
		// logger("clearMyTracksByProcessCookies Exception = " + e1.toString());
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//webDriverTest();
		//System.exit(0);
		JSONObject objTestInstancesEach = null;
		JSONObject objStep = new JSONObject();
		String strPathFullTestMatix = "";
		String strTestMatixFileName = "";
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
		try {
			autoItSetObject();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		strOperatingSystem = oSType();
		windowsMinimizeAll();
		strPathFullTestMatix = strPathTestMatrix + strTestMatixFileName;
		logger("main: strPathFullTestMatix = " + strPathFullTestMatix);
		testMatrixSetup(strPathFullTestMatix);
		for (intTestInstanceEach = 0; intTestInstanceEach < intTestInstanceSize; intTestInstanceEach++) {
			try {
				objWebElement = null;
				objTestSteps = null;
				objTestSteps = (JSONArray) objJsonParser.parse(strTestStepsCombinedOriginal);
				logger("main: intTestInstanceSize = " + intTestInstanceSize);
				objTestInstancesEach = (JSONObject) objTestInstances.get(intTestInstanceEach);
				objStep = null;
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
				strPathResultsFolder = strPathResultsIterationsFolder + dateTimestamp();
				logger("main: Working Directory = " + strPathSystemUserDir);
				switch (strOperatingSystem) {
				case "Windows":
					strPathResults = strPathSystemUserDir + "\\Results\\" + strTestMatixFileName.replace(".json", "") + "\\" + strPathResultsFolder + "\\";
					strPathImages = "images\\";
					break;
				case "Mac":
					strPathResults = strPathSystemUserDir + "/Results/" + strTestMatixFileName.replace(".json", "") + "/" + strPathResultsFolder + "/";
					strPathImages = "images/";
					break;
				default:
					logger("main: switch strOperatingSystem = " + strOperatingSystem + "  not supported");
					return;
				}
				new File(strPathResults).mkdirs();
				new File(strPathResults + strPathImages).mkdirs();
				writeJsonToHtml(objTestSteps, strPathResults + "StepsOriginal.html");
				logger("main: objTestSteps.size() = " + objTestSteps.size());
				for (intStep = 0; intStep < objTestSteps.size(); intStep++) {
					logger("main: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					objWebElement = null;
					objStep = (JSONObject) objTestSteps.get(intStep);
					String strInputValue = objStep.get("strInputValue").toString();
					String strLogicalName = objStep.get("strLogicalName").toString();
					if (strLogicalName.toLowerCase().startsWith("<er>") == true) {
						strLogicalName = strLogicalName.replace("<er>", "");
						jSONObjectValidateKey(objElement, strLogicalName);
						JSONObject objElementNode = (JSONObject) objElement.get(strLogicalName);
						jSONObjectStepPut(objStep, "strTagName", jSONObjectGetValue(objElementNode, "strTagName", ""));
						jSONObjectStepPut(objStep, "strAttributeNames", jSONObjectGetValue(objElementNode, "strAttributeNames", ""));
						jSONObjectStepPut(objStep, "strAttributeValues", jSONObjectGetValue(objElementNode, "strAttributeValues", ""));
					}
					if (strInputValue.toLowerCase().startsWith("<link>") == true) {
						strInputValue = jSONObjectGetValue(objLinks, strInputValue, "<link>");
						jSONObjectStepPut(objStep, "strInputValue", strInputValue);
					}
					if (strInputValue.toLowerCase().startsWith("<ti>") == true) {
						strInputValue = jSONObjectGetValue(objTestInstancesEach, strInputValue, "<ti>");
						jSONObjectStepPut(objStep, "strInputValue", strInputValue);
					}
					if (strInputValue.toLowerCase().startsWith("<td>") == true) {
						strInputValue = jSONObjectGetValue(objJsonTestDataFile, strInputValue, "<td>");
						jSONObjectStepPut(objStep, "strInputValue", strInputValue);
					}
					if (objStep.get("intMillisecondsToWait").toString().trim().length() == 0) {
						jSONObjectStepPut(objStep, "intMillisecondsToWait", Integer.toString(intMillisecondsToWaitDefault));
					}
					if (objStep.get("blnOptional").toString().trim().length() == 0) {
						jSONObjectStepPut(objStep, "blnOptional", "false");
					}
					if (objStep.get("strAssert").toString().trim().length() == 0) {
						jSONObjectStepPut(objStep, "strAssert", "off");
					}
					jSONObjectStepPut(objStep, "blnPleaseWait", "true");
					jSONObjectStepPut(objStep, "blnHighlight", "true");
					jSONObjectStepPut(objStep, "blnScreenshot", "true");
					jSONObjectStepPut(objStep, "strScreenshotArea", "screen");
					jSONObjectStepPut(objStep, "strHighlightArea", "");
					if (objStep.get("blnExitOnFail").toString().trim().length() == 0) {
						jSONObjectStepPut(objStep, "blnExitOnFail", "true");
					}
					jSONObjectStepPut(objStep, "strCurrentWindowHandle", strCurrentWindowHandle);
					jSONObjectStepPut(objStep, "strType", "");
					jSONObjectStepPut(objStep, "strScreenshotFilePath", strPathResults + strPathImages);
					jSONObjectStepPut(objStep, "strStatus", "info");
					jSONObjectStepPut(objStep, "intFrame", Integer.toString(intFrame));
					jSONObjectStepPut(objStep, "strStartTimestamp", "");
					jSONObjectStepPut(objStep, "strStepDuration", "");
					jSONObjectStepPut(objStep, "strEndTimestamp", "");
					jSONObjectStepPut(objStep, "strStepExpected", "");
					jSONObjectStepPut(objStep, "strStepActual", "");
					logStepDetails(objStep, intStep);
					if (objStep.get("intLoop").toString().trim().length() > 0) {
						if (objStep.get("intLoop").toString().toLowerCase().startsWith("<loopstart>") == true) {
							if (intLoopEach == 0) {
								intLoopCount = Integer.parseInt(objStep.get("intLoop").toString().substring(11));
								jSONObjectStepPut(objStep, "intLoop", "");
								intLoopEach = 1;
								intLoopStep = intStep;
							}
						}
					}
					logger("main: intLoopCount = " + intLoopCount);
					logger("main: intLoopEach = " + intLoopEach);
					logger("main: intStep = " + intStep);
					logger("main: intLoopStep = " + intLoopStep);
					if (!objStep.get("strFunction").toString().trim().equals("")) {
						String strMethodName = objStep.get("strFunction").toString();
						String arguments = strInputValue;
						Class<?> objClass = Class.forName("org.DragonflyAutomation.Dragonfly");
						Class<?> objParameterTypes[] = new Class[1];
						objParameterTypes[0] = String.class;
						Method objMethod = objClass.getMethod(strMethodName, objParameterTypes);
						Dragonfly objDragonfly = new Dragonfly();
						Object arrArgumentList[] = new Object[1];
						arrArgumentList[0] = new String(arguments);
						Object objReturn = objMethod.invoke(objDragonfly, arrArgumentList);
						String strReturnValue = (String) objReturn;
						strInputValue = strReturnValue.toString();
						jSONObjectStepPut(objStep, "strInputValue", strInputValue);
						logger("main: call function return value = " + strInputValue);
					}
					if (!strInputValue.toLowerCase().equals("<skip>")) {
						switch (objStep.get("strAction").toString().toLowerCase()) {
						case "launch":
							// TODO create a browserLaunchSync to manage reporting and sync
							objWebDriver = browserLaunch(objStep);
							break;
						case "close":
							// TODO create a browserCloseSync to manage reporting and sync close
							objWebDriver.close();
							objWebDriver.quit();
							jSONObjectStepPut(objStep, "strStatus", "pass");
							coordinateHighlightScreenshot(objStep, objWebDriver, null, objStep);
							break;
						case "get":
							elementGetSync(objStep);
							break;
						case "set":
							elementSetSync(objStep);
							break;
						case "verify":
							elementVerifyValueSync(objStep);
							break;
						case "sync_visible":
							elementVisibleSync(objStep);
							break;
						case "sync_hidden":
							elementHiddenSync(objStep);
							break;
						case "sync_enabled":
							elementEnabledSync(objStep);
							break;
						case "sync_disabled":
							elementDisabledSync(objStep);
							break;
						case "mouse_over":
							elementOnMouseOverSync(objStep);
							break;
						case "drag":
							elementDragSync(objStep);
							break;
						case "drop":
							elementDropSync(objStep);
							break;
						case "sleep":
							sleepMilliseconds(Integer.parseInt(objStep.get("strInputValue").toString()));
							break;
						case "break":
							logger("main: switch strAction = break was entered to at this step to stop execution");
							return;
						default:
							logger("main: switch strAction = " + objStep.get("strAction").toString().toLowerCase() + "  not supported");
							return;
						}
						strCurrentWindowHandle = objStep.get("strCurrentWindowHandle").toString();
						intFrame = Integer.parseInt(objStep.get("intFrame").toString());
					}
					if (objStep.get("strOutputLinkName").toString().trim().length() != 0) {
						objLinks.put(objStep.get("strOutputLinkName").toString(), objStep.get("strOutputValue").toString());
					}
					if (objStep.get("strStatus").toString().equals("fail")) {
						strTestStatus = "fail";
						if (Boolean.parseBoolean(objStep.get("blnExitOnFail").toString()) == true) {
							webElementCollectionTable(objStep.get("strTagName").toString());
							break;
						}
					}
					if (objStep.get("intLoop").toString().toLowerCase().startsWith("<loopexit>") == true) {
						strLoopExitValue = objStep.get("intLoop").toString().substring(10);
						logger("main: strLoopExitValue = " + strLoopExitValue);
						if (objStep.get("strOutputValue").toString().equals(strLoopExitValue)) {
							intLoopCount = 0;
							intLoopEach = 0;
						}
					}
					if (objStep.get("intLoop").toString().toLowerCase().startsWith("<loopend>") == true) {
						if (intLoopEach == intLoopCount) {
							intLoopCount = 0;
							intLoopEach = 0;
						} else {
							intLoopEach = intLoopEach + 1;
							intStep = intLoopStep - 1;
						}
					}
				}
			} catch (BrowserDriverNotSupportedException e) {
				// TODO confirm the exceptions to catch in main some may need to be removed
				logger("main: " + e.toString());
			} catch (Exception e) {
				logger("main: " + e.toString());
			} finally {
				writeFile(strPathResults + "DragonflyLog.log", Dragonfly.strLog);
				writeJsonToHtml(objTestSteps, strPathResults + "StepsWithDefaults.html");
				writeFile(strPathResults + "StepsWithDefaults.json", objTestSteps.toString());
				writeReportToHtml(objTestSteps, strPathResults + "Report.html");
				writeFile(strPathResults + "StepsAfterRun.json", objJsonStepsFile.toString());
				writeJsonStepsAfterRunToHtml(objTestSteps, strPathResults + "StepsAfterRun.html");
				File objDirectoryOld = new File(strPathResults);
				String strPathResultsNew = strPathResults.replace(strPathResultsFolder, strPathResultsFolder + "_" + strTestStatus);
				logger("main: strPathResultsNew = " + strPathResultsNew);
				File objDirectoryNew = new File(strPathResultsNew);
				objDirectoryOld.renameTo(objDirectoryNew);
				if (objWebDriver.toString().contains("InternetExplorerDriver")) {
					windowsProcessKill("taskkill /F /IM IEDriverServer.exe");
				}
			}
			strLog = "";
		}
	}

	public static int loopEndFind(JSONObject objJSONObject) {
		logger("  ==start==>loopEndFind " + dateTimestamp());
		JSONArray objTestSteps2 = null;
		int intStep2 = 0;
		JSONObject objStep2 = null;
		try {
			objTestSteps2 = (JSONArray) objJsonParser.parse(strTestStepsCombinedOriginal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (intStep2 = 0; intStep2 < objTestSteps2.size(); intStep2++) {
			objStep2 = (JSONObject) objTestSteps.get(intStep2);
			if (objStep2.get("intLoop").toString().toLowerCase().startsWith("<loopend>") == true) {
				return intStep2;
			}
		}
		return 0;
	}

	public static void jSONObjectValidateKey(JSONObject objJSONObject, String strKeyName) throws JSONKeyNotPresentException {
		logger("  ==start==>jSONObjectValidateKey " + dateTimestamp());
		if (!objJSONObject.containsKey(strKeyName)) {
			throw new JSONKeyNotPresentException("JSON Key " + strKeyName + " not present");
		}
	}

	public static String jSONObjectGetValue(JSONObject objJSONObject, String strInputValue, String strKeywordName) throws JSONKeyNotPresentException {
		logger("  ==start==>jSONObjectGetValue " + dateTimestamp());
		String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
		String strJSONObjectValue = "";
		if (objJSONObject.containsKey(strJSONObjectKey)) {
			strJSONObjectValue = objJSONObject.get(strJSONObjectKey).toString();
			logger("jSONObjectGetValue: strJSONObjectValue = " + strJSONObjectValue);
			return strJSONObjectValue;
		} else {
			logger("jSONObjectGetValue: JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
			throw new JSONKeyNotPresentException("JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
		}
	}

	@SuppressWarnings("unchecked")
	public static void jSONObjectStepPut(JSONObject objStep, String strKeyName, String strKeyValue) {
		logger("  ==start==>jSONObjectGetValue " + dateTimestamp());
		objStep.put(strKeyName, strKeyValue);
	}

	public static void testMatrixSetup(String strPathTestMatix) {
		// TODO complete testMatrixSetup method to create json objects for test
		logger("  ==start==>testMatrixSetup " + dateTimestamp());
		int intElementRepositoryEach = 0;
		int intTestDataEach = 0;
		int intTestModulesEach = 0;
		int intJsonArrayTestInstanceSize = 0;
		JSONArray objJsonArrayElementRepository = null;
		JSONArray objJsonArrayTestData = null;
		JSONArray objJsonArrayTestInstance = null;
		JSONArray objJsonArrayTestModules = null;
		JSONObject objJsonElementsEach = null;
		JSONObject objJsonTestMatrixFile = null;
		String strFileNameElementRepository = "";
		String strFileNameTestData = "";
		String strFileNameTestInstance = "";
		String strFileNameTestModules = "";
		String strPathFullTestData = "";
		String strPathFullTestInstances = "";
		String strPathFullTestModules = "";
		try {
			logger("testMatrixSetup: strPathTestMatix = " + strPathTestMatix);
			objJsonTestMatrixFile = (JSONObject) objJsonParser.parse(new FileReader(strPathTestMatix));
			// test_instances
			objJsonArrayTestInstance = (JSONArray) objJsonTestMatrixFile.get("test_instances");
			intJsonArrayTestInstanceSize = objJsonArrayTestInstance.size();
			if (intJsonArrayTestInstanceSize == 1) {
				strFileNameTestInstance = objJsonArrayTestInstance.get(0).toString();
				strPathFullTestInstances = strPathTestInstances + strFileNameTestInstance;
				objTestInstance = (JSONObject) objJsonParser.parse(new FileReader(strPathFullTestInstances));
				objTestInstances = (JSONArray) objTestInstance.get("test_instances");
				intTestInstanceSize = objTestInstances.size();
			} else if (intJsonArrayTestInstanceSize == 0) {
				intTestInstanceSize = 1;
				objTestInstance = (JSONObject) objJsonParser.parse("{\"test_instances\":[{}]}");
				objTestInstances = (JSONArray) objTestInstance.get("test_instances");
			} else if (intJsonArrayTestInstanceSize > 1) {
				intTestInstanceSize = 0;
				logger("testMatrixSetup: " + intJsonArrayTestInstanceSize + " Test Instances " + objJsonArrayTestInstance.toString() + " exceeds requirements of one. Update test matrix to have only one test instance.");
				throw new TestInstanceMoreThanOneException(intJsonArrayTestInstanceSize + " Test Instances " + objJsonArrayTestInstance.toString() + " exceeds requirements of one. Update test matrix to have only one test instance.");
			}
			if (intTestInstanceSize > 1) {
				strPathResultsIterationsFolder = dateTimestamp() + "_Iterations_" + intTestInstanceSize + "\\";
			}
			// element_repository
			objJsonArrayElementRepository = (JSONArray) objJsonTestMatrixFile.get("element_repository");
			for (intElementRepositoryEach = 0; intElementRepositoryEach < objJsonArrayElementRepository.size(); intElementRepositoryEach++) {
				strFileNameElementRepository = objJsonArrayElementRepository.get(intElementRepositoryEach).toString();
				logger("testMatrixSetup: strFileNameElementRepository = " + strFileNameElementRepository);
				objElements = (JSONObject) objJsonParser.parse(new FileReader(strPathElementRepository + strFileNameElementRepository));
				objJsonElementsEach = (JSONObject) objElements.get("elements");
				if (intElementRepositoryEach == 0) {
					objElement = (JSONObject) objElements.get("elements");
				} else {
					objElement.putAll(objJsonElementsEach);
				}
				logger("testMatrixSetup: objElement = " + objElement);
			}
			// test_modules
			objJsonArrayTestModules = (JSONArray) objJsonTestMatrixFile.get("test_modules");
			if (objJsonArrayTestModules.size() == 0) {
				// TODO add error handling, report no test modules and fail
				logger("testMatrixSetup: objJsonArrayTestModules.size() == 0.  At lease 1 test module must be includes in a dragonfly test");
			} else {
				for (intTestModulesEach = 0; intTestModulesEach < objJsonArrayTestModules.size(); intTestModulesEach++) {
					strFileNameTestModules = objJsonArrayTestModules.get(intTestModulesEach).toString();
					strPathFullTestModules = strPathTestModules + strFileNameTestModules;
					logger("testMatrixSetup: strPathFullTestModules = " + strPathFullTestModules);
					objJsonStepsFile = (JSONObject) objJsonParser.parse(new FileReader(strPathFullTestModules));
					JSONArray objJsonStepsARRAY = (JSONArray) objJsonStepsFile.get("steps");
					String strStepsToString = objJsonStepsARRAY.toString();
					logger("testMatrixSetup: objJsonStepsEach = " + objJsonStepsARRAY.toString());
					if (intTestModulesEach > 0) {
						strTestStepsCombinedOriginal = strTestStepsCombinedOriginal.substring(0, strTestStepsCombinedOriginal.length() - 1) + "," + strStepsToString.substring(1);
					} else {
						strTestStepsCombinedOriginal = strStepsToString;
					}
				}
				logger("testMatrixSetup: strTestStepsCombinedOriginal = " + strTestStepsCombinedOriginal);
				objLinkArray = (JSONArray) objJsonStepsFile.get("link");
				objLinks = (JSONObject) objLinkArray.get(0);
			}
			// test_data
			objJsonArrayTestData = (JSONArray) objJsonTestMatrixFile.get("test_data");
			if (objJsonArrayTestData.size() > 0) {
				for (intTestDataEach = 0; intTestDataEach < objJsonArrayTestData.size(); intTestDataEach++) {
					strFileNameTestData = objJsonArrayTestData.get(intTestDataEach).toString();
					strPathFullTestData = strPathTestData + strFileNameTestData;
					objJsonTestDataFile = (JSONObject) objJsonParser.parse(new FileReader(strPathFullTestData));
					if (intTestDataEach > 0) {
						objJsonTestDataFile.putAll((JSONObject) objJsonParser.parse(new FileReader(strPathFullTestData)));
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void logStepDetails(JSONObject objStep, int intStep) {
		logger("  ==start==>logStepDetails " + dateTimestamp());
		String[] arrKeys;
		String strKeys = "";
		String strKey = "";
		strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait";
		strKeys = strKeys + "|blnOptional|strAssert|blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail";
		strKeys = strKeys + "|strOutputLinkName|strOutputValue|intLoop|strCurrentWindowHandle";
		// logger("logStepDetails: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
		arrKeys = strKeys.split("\\|");
		for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
			strKey = (String) arrKeys[intKeysEach].toString();
			if (objStep.containsKey(strKey) == true) {
				logger("logStepDetails: " + strKey + " = " + objStep.get(strKey).toString());
			}
		}
	}

	public static void elementGetSync(JSONObject objStep) {
		logger("  ==start==>elementGetSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnGet = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		String strGetValue = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnGet == false) {
					strGetValue = elementGet(objStep);
					jSONObjectStepPut(objStep, "strOutputValue", strGetValue);
					blnGet = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				logger("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} finally {
				if (blnExit == true) {
					jSONObjectStepPut(objStep, "strStatus", "fail");
				} else {
					if (blnStatus == true) {
						jSONObjectStepPut(objStep, "strStatus", "pass");
						blnExit = true;
					} else if (blnStatus == false) {
						if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
							if (blnFound == false) {
								blnVisible = false;
								blnGet = false;
							}
						} else {
							if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
								jSONObjectStepPut(objStep, "strStatus", "warning");
								blnExit = true;
							} else {
								jSONObjectStepPut(objStep, "strStatus", "fail");
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					stepDuration(objStep, "elementGetSync", lngTimeStart, "get");
					return;
				}
			}
		}
	}

	public static void elementOnMouseOver(JSONObject objStep) {
		logger("  ==start==>elementOnMouseOver " + dateTimestamp());
		logger("elementOnMouseOverSync: " + objWebElement.toString());
		JavascriptExecutor objJavascriptExecutor = null;
		if (objWebElement != null) {
			objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
		}
		objJavascriptExecutor.executeScript("arguments[0].onmouseover();", objWebElement);
	}

	public static void elementOnMouseOverSync(JSONObject objStep) {
		logger("  ==start==>elementOnMouseOverSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnOnMouseOver = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep);
					blnEnabled = true;
				}
				if (blnOnMouseOver == false) {
					elementOnMouseOver(objStep);
					blnOnMouseOver = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jSONObjectStepPut(objStep, "strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnOnMouseOver = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							jSONObjectStepPut(objStep, "strStatus", "warning");
							blnExit = true;
						} else {
							jSONObjectStepPut(objStep, "strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					stepDuration(objStep, "elementOnMouseOverSync", lngTimeStart, "mouseover");
					return;
				}
			}
		}
	}

	public static void elementSet(JSONObject objStep, String strOuterHTML) throws ElementTagNameNotSupportedException, ElementNotSetException {
		logger("  ==start==>elementSet " + dateTimestamp());
		long lngStartTimeElementSet = System.currentTimeMillis();
		JavascriptExecutor objJavascriptExecutor = null;
		Boolean blnSet = false;
		// String strOuterHTML = "";
		if (objWebElement != null) {
			objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
		}
		try {
			// objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			// objWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
			long lngStartTimeOuterHTML = System.currentTimeMillis();
			// strOuterHTML = objWebElement.getAttribute("outerHTML");
			// logger("elementSet outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeOuterHTML));
			// logger(strOuterHTML);
			switch (objStep.get("strTagType").toString().toLowerCase()) {
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
				objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
				objWebElement.click();
				// ///objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				break;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
				blnSet = true;
				objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				objJavascriptExecutor.executeScript("arguments[0].value = '';", objWebElement);
				objWebElement.sendKeys(objStep.get("strInputValue").toString());
				objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				break;
			// //objWebElement.click();
			// objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].value = '';", objWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].value = '" + objStep.get("strInputValue").toString() + "';", objWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].onkeydown();", objWebElement);
			// // objJavascriptExecutor.executeScript("arguments[0].onkeyup();", objWebElement);
			// objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
			// logger("onchange before");
			// if (strOuterHTML.toLowerCase().contains("onchange")) {
			// try {
			// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
			// } catch (WebDriverException e) {
			// logger("elementSet = " + e.toString());
			// }
			// }
			// break;
			case "input_radio":
				blnSet = true;
				objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
				objWebElement.click();
				objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				// if (strOuterHTML.toLowerCase().contains("onchange")) {
				// try {
				// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
				//
				// } catch (WebDriverException e) {
				// logger("elementSet = " + e.toString());
				// }
				// }
				break;
			case "input_checkbox":
				blnSet = true;
				switch (objStep.get("strInputValue").toString().toLowerCase()) {
				case "<on>":
					if (objWebElement.isSelected() == false) {
						objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
						objWebElement.click();
						objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
						// if (strOuterHTML.toLowerCase().contains("onchange")) {
						// try {
						// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
						// } catch (WebDriverException e) {
						// logger("elementSet = " + e.toString());
						// }
						// }
					}
					break;
				case "<off>":
					blnSet = true;
					if (objWebElement.isSelected() == true) {
						objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
						objWebElement.click();
						objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
						// if (strOuterHTML.toLowerCase().contains("onchange")) {
						// try {
						// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
						// } catch (WebDriverException e) {
						// logger("elementSet = " + e.toString());
						// }
						// }
					}
					break;
				}
				break;
			case "select":
				int intOptionsEach;
				String strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objWebElement);
				strOptions = strOptions.substring(1);
				String[] arrOptions;
				arrOptions = strOptions.split("\\|");
				for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					logger("elementSet: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					if (arrOptions[intOptionsEach].toString().equals(objStep.get("strInputValue").toString())) {
						blnSet = true;
						Select objSelect = new Select(objWebElement);
						objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
						objSelect.selectByIndex(intOptionsEach);
						objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objWebElement);
						// if (strOuterHTML.toLowerCase().contains("onchange")) {
						// try {
						// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
						// } catch (WebDriverException e) {
						// logger("elementSet = " + e.toString());
						// }
						// }
						break;
					}
				}
				break;
			case "table":
				// Set objWebElement = gobjWebElement.AsTable
				break;
			case "alert":
				blnSet = true;
				//Alert alert = objWebDriver.switchTo().alert();
				//logger(objAlert.getText()); // Print Alert popup
				logger("elementSet: " + objStep.get("strAttributeValues").toString().toLowerCase());
				switch (objStep.get("strAttributeValues").toString().toLowerCase()) {
				case "text":
					//objAlert.sendKeys(objStep.get("strInputValue").toString());
					objWebDriver.switchTo().alert().sendKeys(objStep.get("strInputValue").toString());
					break;
				case "accept":
					//	objAlert.accept(); // Close Alert popup
					objWebDriver.switchTo().alert().accept(); // Close Alert popup
					break;
				case "dismiss":
					//objAlert.dismiss();// Close Alert popup
					objWebDriver.switchTo().alert().dismiss();// Close Alert popup
					break;
				}
				break;
			default:
				throw new ElementTagNameNotSupportedException("Element tag not supported");
			}
		} catch (Exception e) {
			logger("elementSet: Exception = " + e.toString());
		} finally {
			if (blnSet == false) {
				throw new ElementNotSetException("Element not set");
			}
			logger("elementSet: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
		}
	}

	public static void waitForAngularRequestsToFinish(JavascriptExecutor driver) {
		logger("  ==start==>waitForAngularRequestsToFinish " + dateTimestamp());
		driver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
	}

	public static void elementSetSyncComplete(String strOuterHTML) throws DoPostBackNotCompleteException, JQueryAjaxNotCompleteException, JQueryAnimationNotCompleteException, AngularJsNotCompleteException {
		logger("  ==start==>elementSetSyncComplete " + dateTimestamp());
		long lngTimeStart = System.currentTimeMillis();
		try {
			logger("elementSetSyncComplete: alertFind Start");
			if (alertFind() == true) {
				return;
			}
			logger("elementSetSyncComplete: alertFind complete");
			waitForReadyState();
			// JavascriptExecutor objJavascriptExecutor = null;
			// objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
			// waitForAngularRequestsToFinish(objJavascriptExecutor);
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
				try {
					logger("elementSetSyncComplete: __EVENTTARGET value = " + objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
				} catch (Exception e) {
					logger("elementSetSyncComplete: Exception = " + e.toString());
				}
				logger("elementSetSyncComplete: blnEventTarget = " + blnEventTarget);
				if (blnEventTarget == true) {
					throw new AngularJsNotCompleteException("");
				}
				logger("elementSetSyncComplete: lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));
			}
			long lngStartTimeElementSetJQueryActive = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				// logger("elementSet blnJquery = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);"));
				blnJquery = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (jQuery.active);");
					logger("elementSetSyncComplete: lngJqueryActive = " + lngJqueryActive);
					// logger("elementSet both = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
				}
			} catch (Exception e) {
				logger("elementSetSyncComplete: JqueryActive Exception = " + e.toString());
			}
			if (lngJqueryActive > 0) {
				// blnResult = false;
				throw new JQueryAjaxNotCompleteException("");
			}
			// long lngStartTimeElementSetJQueryAnimate = System.currentTimeMillis();
			long lngElementsAnimated = 0;
			boolean blnJqueryExist = false;
			try {
				blnJqueryExist = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJqueryExist == true) {
					lngElementsAnimated = (long) ((JavascriptExecutor) objWebDriver).executeScript("return $(\":animated\").length");
					logger("elementSetSyncComplete: JQueryAnimate = " + lngElementsAnimated);
					// logger("elementSetSyncComplete JQueryAnimate = " + ((JavascriptExecutor) objWebDriver).executeScript("return $(\":animated\").length"));
				}
			} catch (Exception e) {
				logger("elementSetSyncComplete: JQueryAnimate Exception = " + e.toString());
			}
			if (lngElementsAnimated > 0) {
				throw new JQueryAnimationNotCompleteException("");
			}
			long lngStartTimeElementSetAngularJS = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null);");
				logger("elementSetSyncComplete: blnAngularJs = " + blnAngularJs);
				// boolean blnAngularJs2 = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular == null);");
				// logger("elementSet blnAngularJs2 = " + blnAngularJs2);
				// if (blnAngularJs == true) {
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				logger("elementSetSyncComplete: lngJqueryActive = " + lngAngularJsInjectorActive);
				// }
				// boolean blnAngularJsInjector = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector() != null);");
				// logger("elementSet blnAngularJsInjector = " + blnAngularJsInjector);
				// blnAngularJS = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
				// logger("elementSet blnAngularJS = " + blnAngularJS);
			} catch (Exception e) {
				logger("elementSetSyncComplete: AngularJS Exception = " + e.toString());
			}
			if (lngAngularJsInjectorActive > 0) {
				throw new AngularJsNotCompleteException("");
			}
		} catch (NoSuchWindowException e) {
			logger("elementSetSyncComplete: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
		} finally {
			logger("elementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
		}
	}

	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		logger("  ==start==>ExpectedCondition " + dateTimestamp());
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
			}
		};
	}

	public static boolean waitForReadyState() {
		logger("  ==start==>waitForReadyState " + dateTimestamp());
		logger("waitForReadyState: document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return document.readyState"));
		return false;
	}

	public static void elementSetSync(JSONObject objStep) {
		logger("  ==start==>elementSetSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnSet = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		Boolean blnAssert = false;
		Boolean blnSetSync = false;
		String strOuterHTML = "";
		jSONObjectStepPut(objStep, "strOutputValue", objStep.get("strInputValue").toString());
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					logger("elementSetSync: elementFind over");
					if (objWebElement != null) {
						strOuterHTML = objWebElement.getAttribute("outerHTML");
						logger("elementSetSync: " + strOuterHTML);
						logger("elementSetSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					logger("elementSetSync: strOuterHTML over");
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep);
					blnEnabled = true;
				}
				switch (objStep.get("strAssert").toString().toLowerCase()) {
				case "off":
					jSONObjectStepPut(objStep, "strStatus", "pass");
					// TODO complete Alert Set, move or consider how to handle assert
					if (blnSet == false) {
						// if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {coordinateHighlightScreenshot(objStep, objWebDriver, null, objStep);
						// } else {
						coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
						// }
						elementSet(objStep, strOuterHTML);
						blnSet = true;
						blnAssert = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					blnStatus = true;
					break;
				case "hidden":
					if (blnSet == false) {
						jSONObjectStepPut(objStep, "strStatus", "pass");
						coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
						elementSet(objStep, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementHidden(objStep);
						blnAssert = true;
					}
					blnStatus = true;
					break;
				case "value":
					if (blnSet == false) {
						elementSet(objStep, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVerifyValue(objStep);
						blnAssert = true;
					}
					jSONObjectStepPut(objStep, "strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				case "visible":
					if (blnSet == false) {
						elementSet(objStep, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep);
						blnAssert = true;
					}
					jSONObjectStepPut(objStep, "strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				case "enabled":
					if (blnSet == false) {
						elementSet(objStep, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep);
						elementEnabled(objStep);
						blnAssert = true;
					}
					jSONObjectStepPut(objStep, "strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				case "disabled":
					if (blnSet == false) {
						elementSet(objStep, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						elementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep);
						elementDisabled();
						blnAssert = true;
					}
					jSONObjectStepPut(objStep, "strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} catch (ElementNotHiddenException e) {
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnAssert = false;
			} catch (ValueNotMatchedException e) {
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnFound = false;
				blnAssert = false;
			} catch (ElementNotSetException e) {
				blnSet = true;
				blnAssert = false;
			} catch (ElementNotDisabledException e) {
				blnAssert = false;
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (DoPostBackNotCompleteException | JQueryAjaxNotCompleteException | JQueryAnimationNotCompleteException | AngularJsNotCompleteException e) {
				blnSetSync = false;
			} finally {
				if (blnExit == true) {
				} else {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnStatus == true) {
							blnExit = true;
						}
					} else {
						if (blnStatus == true) {
							jSONObjectStepPut(objStep, "strStatus", "pass");
							blnExit = true;
						} else if (blnStatus == false) {
							if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
								jSONObjectStepPut(objStep, "strStatus", "warning");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							} else {
								jSONObjectStepPut(objStep, "strStatus", "fail");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					stepDuration(objStep, "elementSetSync", lngTimeStart, "set");
					return;
				}
			}
		}
	}

	public static void elementDragSync(JSONObject objStep) {
		logger("  ==start==>elementDragSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		String strOuterHTML = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					logger("elementSetSync: elementFind over");
					if (objWebElement != null) {
						strOuterHTML = objWebElement.getAttribute("outerHTML");
						logger("elementDragSync: outerHTML = " + strOuterHTML);
						logger("elementDragSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					logger("elementDragSync: strOuterHTML over");
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep);
					blnEnabled = true;
				}
				objWebElementDrag = objWebElement;
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//} catch (ElementTagNameNotSupportedException e) {
				//logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//	blnExit = true;
			} finally {
				if (blnExit == true) {
				} else {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnStatus == true) {
							blnExit = true;
						}
					} else {
						if (blnStatus == true) {
							jSONObjectStepPut(objStep, "strStatus", "pass");
							blnExit = true;
						} else if (blnStatus == false) {
							if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
								jSONObjectStepPut(objStep, "strStatus", "warning");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							} else {
								jSONObjectStepPut(objStep, "strStatus", "fail");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					stepDuration(objStep, "elementDragSync", lngTimeStart, "drag");
					return;
				}
			}
		}
	}

	public static void elementDropSync(JSONObject objStep) {
		logger("  ==start==>elementDropSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		String strOuterHTML = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					logger("elementDropSync: elementFind over");
					if (objWebElement != null) {
						strOuterHTML = objWebElement.getAttribute("outerHTML");
						logger("elementDropSync: outerHTML = " + strOuterHTML);
						logger("elementDropSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					logger("elementDropSync: strOuterHTML over");
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep);
					blnEnabled = true;
				}
				objWebElementDrop = objWebElement;
				//Actions actions = new Actions(objWebDriver);
				//actions.dragAndDrop(objWebElementDrag, objWebElementDrop).perform();
				//				Actions action = new Actions(objWebDriver);
				//				Action dragDrop = action.dragAndDrop(objWebElementDrag, objWebElementDrop).build();
				//				dragDrop.perform();
				Actions objActions = new Actions(objWebDriver);
				Action objDragAndDrop = objActions.clickAndHold(objWebElementDrag).moveToElement(objWebElementDrop).pause(2000).release(objWebElementDrop).build();
				objDragAndDrop.perform();
				//				Actions action = new Actions(objWebDriver);
				//				action.dragAndDrop(objWebElementDrag, objWebElementDrop).build().perform();
				sleepMilliseconds(10000);
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//} catch (ElementTagNameNotSupportedException e) {
				//logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				//	blnExit = true;
			} finally {
				if (blnExit == true) {
				} else {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnStatus == true) {
							blnExit = true;
						}
					} else {
						if (blnStatus == true) {
							jSONObjectStepPut(objStep, "strStatus", "pass");
							blnExit = true;
						} else if (blnStatus == false) {
							if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
								jSONObjectStepPut(objStep, "strStatus", "warning");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							} else {
								jSONObjectStepPut(objStep, "strStatus", "fail");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					stepDuration(objStep, "elementDropSync", lngTimeStart, "drop");
					return;
				}
			}
		}
	}

	public static void elementVerifyValueSync(JSONObject objStep) {
		logger("  ==start==>elementVerifyValueSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		Boolean blnVerified = false;
		String strActualValue = "";
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnVerified == false) {
					strActualValue = elementVerifyValue(objStep);
					blnVerified = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				blnStatus = false;
				logger("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				logger("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} catch (ValueNotMatchedException e) {
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				blnStatus = false;
				logger("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnExit == true) {
					jSONObjectStepPut(objStep, "strStatus", "fail");
					blnExit = true;
				}
				if (blnStatus == true) {
					logger("elementVerifyValueSync: finally blnStatus = " + blnStatus);
					jSONObjectStepPut(objStep, "strOutputValue", strActualValue);
					jSONObjectStepPut(objStep, "strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
							blnVerified = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							jSONObjectStepPut(objStep, "strOutputValue", strActualValue);
							jSONObjectStepPut(objStep, "strStatus", "warning");
							blnExit = true;
						} else {
							jSONObjectStepPut(objStep, "strOutputValue", strActualValue);
							jSONObjectStepPut(objStep, "strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					stepDuration(objStep, "elementVerifyValueSync", lngTimeStart, "verify");
					return;
				}
			}
		}
	}

	public static String elementVerifyValue(JSONObject objStep) throws ValueNotMatchedException, ElementTagNameNotSupportedException {
		logger("  ==start==>elementVerifyValue " + dateTimestamp());
		long lngStartTimeElementVerify = System.currentTimeMillis();
		String strGetValue = "";
		String strActualValue = "";
		String strValueExpected = objStep.get("strInputValue").toString();
		try {
			strGetValue = elementGet(objStep);
			strActualValue = verifyMatch(strGetValue, strValueExpected);
		} finally {
			logger("elementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeElementVerify));
		}
		return strActualValue;
	}

	public static String verifyMatch(String strActual, String strExpected) throws ValueNotMatchedException {
		logger("  ==start==>verifyMatch " + dateTimestamp());
		long lngStartTimeVerifyMatch = System.currentTimeMillis();
		try {
			if (strExpected.toLowerCase().startsWith("re:")) {
				String strPattern = strExpected.substring(3);
				logger("verifyMatch: regularExpressionMatch = " + regularExpressionMatch(strPattern, strActual));
				return regularExpressionMatch(strPattern, strActual);
			} else {
				if (strExpected.equals(strActual)) {
					return strActual;
				} else {
					throw new ValueNotMatchedException("verifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
				}
			}
		} finally {
			logger("verifyMatch: strActual = {" + strActual + "} strExpected = {" + strExpected + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeVerifyMatch));
		}
	}

	public static String regularExpressionMatch(String strPattern, String strActualValue) {
		logger("  ==start==>regularExpressionMatch " + dateTimestamp());
		Pattern objPattern = Pattern.compile(strPattern);
		Matcher objMatcher = objPattern.matcher(strActualValue);
		objMatcher.matches();
		String strMatchedString = objMatcher.group(0);
		return strMatchedString;
	}

	public static void elementVisibleSync(JSONObject objStep) {
		logger("  ==start==>elementVisibleSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				logger("elementVisibleSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					logger("elementVisibleSync: finally blnStatus = " + blnStatus);
					jSONObjectStepPut(objStep, "strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							jSONObjectStepPut(objStep, "strStatus", "warning");
							blnExit = true;
						} else {
							jSONObjectStepPut(objStep, "strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					stepDuration(objStep, "elementVisibleSync", lngTimeStart, "syncvisible");
					return;
				}
			}
		}
	}

	public static void elementHiddenSync(JSONObject objStep) {
		logger("  ==start==>elementHiddenSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnHidden = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					blnFound = true;
				}
				if (blnFound == true && blnHidden == false) {
					elementHidden(objStep);
					blnHidden = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ElementNotFoundException e) {
				blnFound = false;
				blnHidden = true;
				blnStatus = true;
				logger("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (MultipleElementsFoundException e) {
				blnFound = false;
				blnHidden = false;
				logger("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotHiddenException e) {
				blnHidden = false;
				logger("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (Exception e) {
				blnFound = false;
				blnHidden = false;
				logger("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jSONObjectStepPut(objStep, "strStatus", "pass");
					coordinatesElement(objStep);
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnHidden = false;
						}
					} else {
						coordinatesElement(objStep);
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							jSONObjectStepPut(objStep, "strStatus", "warning");
							blnExit = true;
						} else {
							jSONObjectStepPut(objStep, "strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					stepDuration(objStep, "elementHiddenSync", lngTimeStart, "synchidden");
					return;
				}
			}
		}
	}

	public static void elementEnabledSync(JSONObject objStep) {
		logger("  ==start==>elementEnabledSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep);
					blnEnabled = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				blnEnabled = false;
				logger("elementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jSONObjectStepPut(objStep, "strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnEnabled = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							jSONObjectStepPut(objStep, "strStatus", "warning");
							blnExit = true;
						} else {
							jSONObjectStepPut(objStep, "strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					stepDuration(objStep, "elementEnabledSync", lngTimeStart, "syncenabled");
					return;
				}
			}
		}
	}

	public static void elementDisabledSync(JSONObject objStep) {
		logger("  ==start==>elementDisabledSync " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnDisabled = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					elementFind(objStep);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep);
					blnVisible = true;
				}
				if (blnDisabled == false) {
					elementDisabled();
					blnDisabled = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				blnDisabled = false;
				logger("elementDisabledSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotDisabledException e) {
				blnDisabled = false;
				logger("elementDisabledSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					jSONObjectStepPut(objStep, "strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnDisabled = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							jSONObjectStepPut(objStep, "strStatus", "warning");
							blnExit = true;
						} else {
							jSONObjectStepPut(objStep, "strStatus", "fail");
							blnExit = true;
						}
					}
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					stepDuration(objStep, "elementDisabledSync", lngTimeStart, "syncdisabled");
					return;
				}
			}
		}
	}

	public static WebDriver browserLaunch(JSONObject objStep) throws BrowserDriverNotSupportedException {
		// TODO combine duplicate code
		// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
		logger("  ==start==>browserLaunch " + dateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		DesiredCapabilities desiredCapabilities = null;
		try {
			jSONObjectStepPut(objStep, "blnStatus", "true");
			jSONObjectStepPut(objStep, "strStatus", "pass");
			jSONObjectStepPut(objStep, "intFrame", "-1");
			switch (objStep.get("strTagName").toString()) {
			case "firefox":
				objWebDriver = new FirefoxDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				Actions myAction = new Actions(objWebDriver);
				myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
				break;
			case "ie":
				// internetExplorerProcessKill();
				windowsProcessKill("taskkill /F /IM iexplore.exe");
				sleepMilliseconds(1000);
				logger("browserLaunch: DesiredCapabilities");
				desiredCapabilities = DesiredCapabilities.internetExplorer();
				logger("browserLaunch: setJavascriptEnabled");
				desiredCapabilities.setJavascriptEnabled(true);
				//desiredCapabilities.setCapability("unexpectedAlertBehaviour", "ignore");
				logger("browserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
				desiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
				logger("browserLaunch: IE_ENSURE_CLEAN_SESSION");
				desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				logger("browserLaunch: REQUIRE_WINDOW_FOCUS");
				desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				logger("browserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				logger("browserLaunch: new InternetExplorerDriver(desiredCapabilities)");
				objWebDriver = new InternetExplorerDriver(desiredCapabilities);
				//try {
				//C:\Users\perrj115\Documents\GitHub\dragonfly\Dragonfly\Drivers\IEDriverServer.exe
				//	File file = new File(System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				//	logger("browserLaunch file.getAbsolutePath() " + file.getAbsolutePath());
				//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				//	WebDriver driver = new InternetExplorerDriver();
				//	objWebDriver = new InternetExplorerDriver();
				//} catch (Exception e) {
				//	logger("browserLaunch new InternetExplorerDriver " + e.toString());
				//	}
				// objWebDriver.manage().deleteCookieNamed("JSESSIONID");
				logger("browserLaunch: objStep.get(strInputValue).toString() = " + objStep.get("strInputValue").toString());
				objWebDriver.get(objStep.get("strInputValue").toString());
				// objWebDriver.navigate().to(objStep.get("strInputValue").toString());
				logger("browserLaunch: objWebDriver.manage().window().maximize()");
				objWebDriver.manage().window().maximize();
				//	Capabilities getCapabilities();
				// objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				// // objWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				break;
			case "chrome":
				switch (strOperatingSystem) {
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
				objWebDriver = new ChromeDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				break;
			case "safari":
				objWebDriver = new SafariDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				break;
			case "opera":
				// TODO OperaDriver setup latest driver and test desiredCapabilities = DesiredCapabilities.internetExplorer();
				// desiredCapabilities.setJavascriptEnabled(true);
				objWebDriver = new OperaDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				// objWebDriver.manage().window().maximize();
				// objWebDriver.manage().window().setPosition(new Point(0, 0));
				// Dimension dim = new Dimension(1382, 754);
				// objWebDriver.manage().window().setSize(dim);
				// Selenium selenium;
				// objWebDriver = new OperaDriver();
				// selenium = new WebDriverBackedSelenium(objWebDriver, "https://www.google.com/");
				// return objWebDriver;
				break;
			default:
				jSONObjectStepPut(objStep, "blnStatus", "false");
				jSONObjectStepPut(objStep, "strStatus", "fail");
				throw new BrowserDriverNotSupportedException("Browser '" + objStep.get("strTagName").toString() + "' not supported");
			}
		} catch (Exception e) {
			logger("browserLaunch: Exception" + e.toString());
		} finally {
			jSONObjectStepPut(objStep, "strCurrentWindowHandle", objWebDriver.getWindowHandle());
			coordinatesElement(objStep);
			coordinateHighlightScreenshot(objStep, objWebDriver, null, objStep);
			stepDuration(objStep, "browserLaunch", lngTimeStart, "launch");
		}
		return objWebDriver;
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

	public static void stepDuration(JSONObject objStep, String strMethodName, Long lngTimeStart, String strStepType) {
		logger("  ==start==>stepDuration " + dateTimestamp());
		Long lngTimeEnd = System.currentTimeMillis();
		jSONObjectStepPut(objStep, "strStartTimestamp", dateTimeFormat(lngTimeStart));
		jSONObjectStepPut(objStep, "strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
		jSONObjectStepPut(objStep, "strEndTimestamp", dateTimeFormat(lngTimeEnd));
		jSONObjectStepPut(objStep, "strStepActual", stepCreateActual(objStep, strStepType));
		//logger(strMetodName + ": Milliseconds Waited = " + strStepDuration);
		logger("stepDuration: " + strMethodName + " strStatus = " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
	}

	public static void internetExplorerProcessKill() {
		logger("  ==start==>internetExplorerProcessKill " + dateTimestamp());
		//WebDriver objWebDriver = null;
		DesiredCapabilities desiredCapabilities = null;
		windowsProcessKill("taskkill /F /IM iexplore.exe");
		sleepMilliseconds(1000);
		desiredCapabilities = DesiredCapabilities.internetExplorer();
		desiredCapabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
		objWebDriver = new InternetExplorerDriver(desiredCapabilities);
		objWebDriver.get("about:blank");
		objWebDriver.manage().deleteCookieNamed("JSESSIONID");
		// objWebDriver.navigate().to(objStep.get("strInputValue").toString());
		// objWebDriver.manage().window().maximize();
		// objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// // objWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
		objWebDriver.close();
		objWebDriver.quit();
		windowsProcessKill("taskkill /F /IM iexplore.exe");
		sleepMilliseconds(1000);
		windowsProcessKill("taskkill /F /IM IEDriverServer.exe");
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
	public static void commandLineExecution() throws Exception {
		logger("  ==start==>commandLineExecution " + dateTimestamp());
		Process p = Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
		p.waitFor();
		Process p5 = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 10");
		p5.waitFor();
		String strCookiesLowFolderPath = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Cookies\\Low\\";
		strCookiesLowFolderPath = strCookiesLowFolderPath.replaceAll("\\\\", "/");
		logger("commandLineExecution: strCookiesLowFolderPath = " + strCookiesLowFolderPath);
		FileUtils.deleteDirectory(new File(strCookiesLowFolderPath));
		String strCacheLowFolderPath = System.getenv("APPDATA") + "Local/Microsoft/Windows/Temporary Internet Files/Low/";
		strCacheLowFolderPath = strCacheLowFolderPath.replaceAll("\\\\", "/");
		logger("commandLineExecution: strCacheLowFolderPath = " + strCacheLowFolderPath);
		FileUtils.deleteDirectory(new File(strCacheLowFolderPath));
	}

	public static void clearMyTracksByProcessCookies() throws Exception {
		logger("  ==start==>clearMyTracksByProcessCookies " + dateTimestamp());
		String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
		Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
		objProcess.waitFor();
	}

	public static void clearMyTracksByProcessCache() throws Exception {
		logger("  ==start==>clearMyTracksByProcessCache " + dateTimestamp());
		String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
		Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
		objProcess.waitFor();
	}

	public static String clipboardGet() {
		logger("  ==start==>clipboardGet " + dateTimestamp());
		String strClipboardData = "";
		try {
			strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			logger("clipboardGet: strClipboardData = " + strClipboardData);
		} catch (Exception e) {
			logger("clipboardGet: Exception = " + e.toString());
		}
		return strClipboardData;
	}

	public static boolean alertFind() {
		logger("  ==start==>alertFind " + dateTimestamp());
		try {
			logger("alertFind: objWebDriver.getTitle() = " + objWebDriver.getTitle());
			objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			logger("alertFind: implicitlyWait  ");
			String strAlertPresent = objWebDriver.switchTo().alert().getText();
			logger("alertFind: alert switch to which did not fail:  " + strAlertPresent);
			return true;
		} catch (UnhandledAlertException e) {
			//logger("alertFind getText " + objWebDriver.switchTo().alert().getText());
			logger("alertFind: UnhandledAlertException = " + e.toString());
			return true;
		} catch (NoAlertPresentException e) {
			logger("alertFind: NoAlertPresentException = " + e.toString());
			return false;
		} catch (Exception e) {
			logger("alertFind: Exception = " + e.toString());
			return false;
		}
	}

	public static boolean validateTagType(String strTagType) {
		logger("  ==start==>validateTagType " + dateTimestamp());
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

	public static void browserInnerDimensions(JSONObject objStep) throws WebDriverException {
		logger("  ==start==>browserInnerDimensions " + dateTimestamp());
		long lngBrowserInnerWidth = 0;
		long lngBrowserInnerHeight = 0;
		try {
			lngBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
			lngBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			// logger("lngBrowserInnerWidth = " + lngBrowserInnerWidth);
			// logger("lngBrowserInnerHeight = " + lngBrowserInnerHeight);
		} catch (WebDriverException e) {
			throw new WebDriverException("WebDriverException returned");
		} catch (Exception e) {
			lngBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetWidth;");
			lngBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetHeight;");
			// logger("BodyoffsetWidth = " + lngBrowserInnerWidth);
			// logger("BodyoffsetHeight = " + lngBrowserInnerHeight);
		}
		jSONObjectStepPut(objStep, "intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
		jSONObjectStepPut(objStep, "intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
	}

	public static void elementFind(JSONObject objStep) throws ElementNotFoundException, MultipleElementsFoundException {
		logger("  ==start==>elementFind " + dateTimestamp());
		if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
			// TODO elementFind finish alert handling --- will need to consider issue where objWebDriver no longer exists maybe place this after setting window
			jSONObjectStepPut(objStep, "strTagType", "alert");
			if (alertFind() == true) {
				jSONObjectStepPut(objStep, "strHighlightArea", "alert");
				return;
			} else {
				jSONObjectStepPut(objStep, "strHighlightArea", "screen");
				throw new ElementNotFoundException("Alert popup not found!");
			}
		}
		if (objStep.get("strTagName").toString().toLowerCase().equals("title")) {
			jSONObjectStepPut(objStep, "strTagType", "title");
			return;
		}
		//String strCurrentWindowHandle = objStep.get("strCurrentWindowHandle").toString();
		String strWindowHandle = "";
		//Boolean blnSwitch = false;
		Object[] arrHandles = objWebDriver.getWindowHandles().toArray();
		// logger("elementFind arrHandles.length = " + arrHandles.length);
		// logger("elementFind objWebDriver.getTitle = " + objWebDriver.getTitle());
		for (int intWindowHandlesEach = arrHandles.length - 1; intWindowHandlesEach >= 0; intWindowHandlesEach--) {
			logger("elementFind: arrHandles[" + intWindowHandlesEach + "] = " + arrHandles[intWindowHandlesEach].toString());
		}
		for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
			try {
				strWindowHandle = arrHandles[intHandlesEach].toString();
				//long lngStartTimeSwitchTo = System.currentTimeMillis();
				//			if (!strCurrentWindowHandle.equals(strWindowHandle)) {
				//				blnSwitch = true;
				//			} else {
				//				if (Integer.parseInt(objStep.get("intFrame").toString()) >= 0) {
				//					blnSwitch = true;
				//				}
				//			}
				//	if (blnSwitch == true) {
				logger("elementFind: objWebDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
				objWebDriver.switchTo().window(strWindowHandle);
				browserInnerDimensions(objStep);
				// logger("elementFind Switched = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				logger("elementFind: objWebDriver.getTitle = " + objWebDriver.getTitle());
				jSONObjectStepPut(objStep, "intFrame", "-1");
				//objWebDriver.manage().window().maximize();
				//}
				List<Integer> arrRouteOriginal = new ArrayList<Integer>();
				logger("elementFind: routeOriginal = " + arrRouteOriginal);
				logger("elementFind: routeOriginal.size() = " + arrRouteOriginal.size());
				logger("elementFind: routeOriginal.add(0) = " + arrRouteOriginal);
				framesSearch(objStep, arrRouteOriginal);
				if (objWebElement != null) {
					logger("elementFind: objWebElement Not null ");
					return;
				} else {
					logger("elementFind: objWebElement IS NULL");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger("elementFind: Exception = " + e.toString());
			}
		}
		throw new ElementNotFoundException("Element properties did not return an element, try refining attributes");
	}

	public static boolean framesSearch(JSONObject objStep, List<Integer> arrFramePath) throws ElementNotFoundException, MultipleElementsFoundException {
		logger("  ==start==>framesSearch " + dateTimestamp());
		boolean blnReturn;
		int intMaximumDepth = 100;
		logger("framesSearch: route = " + arrFramePath + " arrFramePath.size = " + arrFramePath.size());
		logger("framesSearch: objWebDriver.getTitle = " + objWebDriver.getTitle());
		logger("framesSearch: objWebDriver.getCurrentUrl = " + objWebDriver.getCurrentUrl());
		logger("framesSearch: objWebDriver.getWindowHandle = " + objWebDriver.getWindowHandle());
		//	logger("framesSearch objWebDriver.getPageSource = " + objWebDriver.getPageSource());
		try {
			elementFindXpath(objStep);
			logger("framesSearch: elementFindXpath objWebElement found");
			logger("framesSearch: objWebElement outerHTML = " + objWebElement.getAttribute("outerHTML"));
			logger("framesSearch: return");
			return true;
		} catch (ElementNotFoundException | MultipleElementsFoundException e) {
			blnReturn = false;
			logger("framesSearch: Exception = " + e.toString());
		}
		if (arrFramePath.size() < intMaximumDepth) {
			int intFramesCount = objWebDriver.findElements(By.tagName("frame")).size();
			logger("framesSearch intFramesCount =  " + intFramesCount);
			for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
				logger("framesSearch intFramesEach =  " + intFramesEach);
				try {
					objWebDriver.switchTo().frame(intFramesEach);
					List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
					arrFramePathNew.add(intFramesEach);
					blnReturn = framesSearch(objStep, arrFramePathNew);
					logger("framesSearch: after framesSearch(objStep, arrFramePathNew) and before defaultContent blnReturn = " + blnReturn);
					if (blnReturn == true) {
						return true;
					}
					objWebDriver.switchTo().defaultContent();
					logger("framesSearch: after defaultContent");
					for (int intFramesPathEach : arrFramePath)
						objWebDriver.switchTo().frame(intFramesPathEach);
				} catch (NoSuchFrameException error) {
					blnReturn = false;
					logger("framesSearch: NoSuchFrameException = " + error.toString());
					break;
				} catch (Exception error) {
					logger("framesSearch: Exception = " + error.toString());
				}
			}
		}
		logger("framesSearch: the end of if (arrFramePath.size() < intMaximumDepth) =  " + arrFramePath.size());
		if (objWebElement != null) {
			logger("framesSearch: objWebElement Not null ");
			logger("framesSearch: objWebElement outerHTML = " + objWebElement.getAttribute("outerHTML"));
		} else {
			logger("framesSearch: objWebElement IS NULL");
		}
		return blnReturn;
	}

	public static void elementFindXpath(JSONObject objStep) throws ElementNotFoundException, MultipleElementsFoundException {
		logger("  ==start==>elementFindXpath " + dateTimestamp());
		int intAttributeEach = 0;
		List<WebElement> objWebElementCollection = new ArrayList<WebElement>();
		String arrAttributeNames[] = objStep.get("strAttributeNames").toString().split("\\|", -1);
		String arrAttributeValues[] = objStep.get("strAttributeValues").toString().split("\\|", -1);
		String strIndex = "";
		String strIndexKeyword = "";
		String strTagName = objStep.get("strTagName").toString().toLowerCase();
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
					jSONObjectStepPut(objStep, "strType", arrAttributeValues[intAttributeEach]);
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
		logger("elementFindXpath: arrAttributeNames[0].toLowerCase() = " + arrAttributeNames[0].toLowerCase());
		logger("elementFindXpath: strXpathAttributesTemp = " + strXpathAttributesTemp);
		logger("elementFindXpath: strXpath = " + strXpath);
		logger("elementFindXpath: strXpathAttributes = " + strXpathAttributes);
		//long lngStartTimegetElementsByTagName2 = System.currentTimeMillis();
		//List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
		//logger("elementFindXpath objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
		//if (objCollectionJS2.size() > 0) {
		long lngStartTimeByXpath = System.currentTimeMillis();
		objWebElementCollection = objWebDriver.findElements(By.xpath(strXpath));
		//}
		switch (objWebElementCollection.size()) {
		case 0:
			throw new ElementNotFoundException("Element properties did not return an element, try refining attributes");
		case 1:
			objWebElement = objWebElementCollection.get(0);
			break;
		default:
			if (strIndexKeyword.equals("<last>")) {
				objWebElement = objWebElementCollection.get(objWebElementCollection.size() - 1);
				break;
			} else if (strIndexKeyword.equals("<random>")) {
				int intRandomElement = randomNumberRange(0, objWebElementCollection.size() - 1);
				objWebElement = objWebElementCollection.get(intRandomElement);
				break;
			} else {
				logger("elementFindXpath: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
				throw new MultipleElementsFoundException(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
			}
		}
		jSONObjectStepPut(objStep, "strCurrentWindowHandle", objWebDriver.getWindowHandle());
		if (objStep.get("strTagName").toString().toLowerCase().equals("input")) {
			if (objStep.get("strType").toString().toLowerCase().length() == 0) {
				jSONObjectStepPut(objStep, "strType", objWebElement.getAttribute("type"));
			}
			jSONObjectStepPut(objStep, "strTagType", "input_" + objStep.get("strType").toString());
		} else {
			jSONObjectStepPut(objStep, "strTagType", objStep.get("strTagName").toString());
		}
	}

	public static String elementJavascriptExecutorXPath() {
		logger("  ==start==>elementJavascriptExecutorXPath " + dateTimestamp());
		return (String) ((JavascriptExecutor) objWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", objWebElement);
	}

	public static void coordinatesAlert(JSONObject objStep) {
		logger("  ==start==>coordinatesAlert " + dateTimestamp());
		long lngStartTimeElementCoordinatesAlert = System.currentTimeMillis();
		int intControlPosHeight = 0;
		int intControlPosWidth = 0;
		int intControlPosX = 0;
		int intControlPosY = 0;
		int intClientSizeHeight = 0;
		int intClientSizeWidth = 0;
		String strText = "";
		String strControlID = "";
		String strWinTitle = objAutoIt.winGetTitle("[ACTIVE]");
		int intWinPosHeight = objAutoIt.winGetPosHeight("[ACTIVE]");
		int intWinPosWidth = objAutoIt.winGetPosWidth("[ACTIVE]");
		int intWinPosX = objAutoIt.winGetPosX("[ACTIVE]");
		int intWinPosY = objAutoIt.winGetPosY("[ACTIVE]");
		switch (objStep.get("strAttributeValues").toString().toLowerCase()) {
		case "accept":
			strText = "OK";
			strControlID = "[CLASS:Button]";
			break;
		case "dismiss":
			strText = "Cancel";
			strControlID = "[CLASS:Button; INSTANCE:2]";
			break;
		case "title":
			strText = "OK";
			strControlID = "[CLASS:Button]";
			break;
		case "text":
			strText = "";
			strControlID = "[CLASS:Static; INSTANCE:2]";
			break;
		case "edit":
			strText = "";
			strControlID = "[CLASS:Edit]";
			break;
		}
		logger("coordinatesAlert: objStep.get(strAttributeValues).toString().toLowerCase(): = " + objStep.get("strAttributeValues").toString().toLowerCase());
		logger("coordinatesAlert: strText: = " + strText);
		logger("coordinatesAlert: strControlID: = " + strControlID);
		switch (objStep.get("strAttributeValues").toString().toLowerCase()) {
		case "accept":
		case "dismiss":
		case "text":
			intControlPosHeight = objAutoIt.controlGetPosHeight("[ACTIVE]", strText, strControlID);
			intControlPosWidth = objAutoIt.controlGetPosWidth("[ACTIVE]", strText, strControlID);
			intControlPosX = objAutoIt.controlGetPosX("[ACTIVE]", strText, strControlID);
			intControlPosY = objAutoIt.controlGetPosY("[ACTIVE]", strText, strControlID);
			intClientSizeHeight = objAutoIt.winGetClientSizeHeight("[ACTIVE]");
			intClientSizeWidth = objAutoIt.winGetClientSizeWidth("[ACTIVE]");
			logger("coordinatesAlert: intControlPosHeight: = " + intControlPosHeight);
			logger("coordinatesAlert: intControlPosWidth: = " + intControlPosWidth);
			logger("coordinatesAlert: intControlPosX: = " + intControlPosX);
			logger("coordinatesAlert: intControlPosY: = " + intControlPosY);
			logger("coordinatesAlert: intClientSizeHeight: = " + intClientSizeHeight);
			logger("coordinatesAlert: intClientSizeWidth: = " + intClientSizeWidth);
			intWinPosX = intWinPosX + intControlPosX + ((intWinPosWidth - intClientSizeWidth) / 2);
			intWinPosY = intWinPosY + intControlPosY + ((intWinPosHeight - intClientSizeHeight) - ((intWinPosWidth - intClientSizeWidth) / 2));
			intWinPosWidth = intControlPosWidth;
			intWinPosHeight = intControlPosHeight;
			break;
		case "title":
			intControlPosHeight = objAutoIt.controlGetPosHeight("[ACTIVE]", strText, strControlID);
			intControlPosWidth = objAutoIt.controlGetPosWidth("[ACTIVE]", strText, strControlID);
			intControlPosX = objAutoIt.controlGetPosX("[ACTIVE]", strText, strControlID);
			intControlPosY = objAutoIt.controlGetPosY("[ACTIVE]", strText, strControlID);
			intClientSizeHeight = objAutoIt.winGetClientSizeHeight("[ACTIVE]");
			intClientSizeWidth = objAutoIt.winGetClientSizeWidth("[ACTIVE]");
			logger("coordinatesAlert: intControlPosHeight: = " + intControlPosHeight);
			logger("coordinatesAlert: intControlPosWidth: = " + intControlPosWidth);
			logger("coordinatesAlert: intControlPosX: = " + intControlPosX);
			logger("coordinatesAlert: intControlPosY: = " + intControlPosY);
			logger("coordinatesAlert: intClientSizeHeight: = " + intClientSizeHeight);
			logger("coordinatesAlert: intClientSizeWidth: = " + intClientSizeWidth);
			intWinPosX = intWinPosX + intControlPosX + ((intWinPosWidth - intClientSizeWidth) / 2);
			intWinPosY = intWinPosY + intControlPosY + ((intWinPosHeight - intClientSizeHeight) - ((intWinPosWidth - intClientSizeWidth) / 2));
			intWinPosWidth = intControlPosWidth;
			intWinPosHeight = intControlPosHeight;
			break;
		}
		jSONObjectStepPut(objStep, "intElementScreenX", Integer.toString(intWinPosX));
		jSONObjectStepPut(objStep, "intElementScreenY", Integer.toString(intWinPosY));
		jSONObjectStepPut(objStep, "intElementWidth", Integer.toString(intWinPosWidth));
		jSONObjectStepPut(objStep, "intElementHeight", Integer.toString(intWinPosHeight));
		logger("coordinatesAlert: winGetTitle: = " + strWinTitle);
		logger("coordinatesAlert: objStep.get(intElementHeight): = " + objStep.get("intElementHeight"));
		logger("coordinatesAlert: objStep.get(intElementWidth): = " + objStep.get("intElementWidth"));
		logger("coordinatesAlert: objStep.get(intElementScreenX): = " + objStep.get("intElementScreenX"));
		logger("coordinatesAlert: objStep.get(intElementScreenY): = " + objStep.get("intElementScreenY"));
		logger("coordinatesAlert: coordinatesAlert finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinatesAlert));
	}

	public static void coordinatesElement(JSONObject objStep) {
		logger("  ==start==>coordinatesElement " + dateTimestamp());
		long lngStartTimeElementCoordinates = System.currentTimeMillis();
		try {
			int intScrollbar = 0;
			Point objWebDriverPoint = objWebDriver.manage().window().getPosition();
			int intBrowserOuterX = objWebDriverPoint.x;
			int intBrowserOuterY = objWebDriverPoint.y;
			Dimension objWebDriverDimension = objWebDriver.manage().window().getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			jSONObjectStepPut(objStep, "intBrowserOuterX", Integer.toString(intBrowserOuterX));
			jSONObjectStepPut(objStep, "intBrowserOuterY", Integer.toString(intBrowserOuterY));
			jSONObjectStepPut(objStep, "intBrowserOuterWidth", Integer.toString(intBrowserOuterWidth));
			jSONObjectStepPut(objStep, "intBrowserOuterHeight", Integer.toString(intBrowserOuterHeight));
			if (objWebElement != null) {
				Coordinates objElementCoordinates = ((Locatable) objWebElement).getCoordinates();
				Point objElementPoint = objElementCoordinates.inViewPort();
				Dimension objElementDimension = objWebElement.getSize();
				jSONObjectStepPut(objStep, "intElementX", Integer.toString(objElementPoint.x));
				jSONObjectStepPut(objStep, "intElementY", Integer.toString(objElementPoint.y));
				jSONObjectStepPut(objStep, "intElementWidth", Integer.toString(objElementDimension.width));
				jSONObjectStepPut(objStep, "intElementHeight", Integer.toString(objElementDimension.height));
			}
			logger("coordinatesElement: coordinatesElement objStep.containsKey = " + objStep.containsKey("intElementX"));
			if (objStep.containsKey("intElementX")) {
				int intBrowserInnerWidth = Integer.parseInt(objStep.get("intBrowserInnerWidth").toString());
				int intBrowserInnerHeight = Integer.parseInt(objStep.get("intBrowserInnerHeight").toString());
				int intElementX = Integer.parseInt(objStep.get("intElementX").toString());
				int intElementY = Integer.parseInt(objStep.get("intElementY").toString());
				int intWindowBorder = (int) ((intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2);
				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (int) ((intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder);
				jSONObjectStepPut(objStep, "intElementScreenX", Integer.toString(intElementScreenX));
				jSONObjectStepPut(objStep, "intElementScreenY", Integer.toString(intElementScreenY));
			}
		} catch (Exception e) {
			logger("coordinatesElement: Exception = " + e.toString());
		} finally {
			logger("coordinatesElement: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinates));
		}
	}

	public static boolean elementVisible(JSONObject objStep) throws ElementNotVisibleException {
		// TODO elementVisible add check for class and css, commented code needs to be tested
		logger("  ==start==>elementVisible " + dateTimestamp());
		long lngStartTimeElementVisible = System.currentTimeMillis();
		Boolean blnVisible = false;
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("title")) {
				blnVisible = true;
				return true;
			}
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				if (alertFind() == true) {
					blnVisible = true;
					jSONObjectStepPut(objStep, "strHighlightArea", "alert");
					coordinatesAlert(objStep);
					return true;
				} else {
					throw new ElementNotVisibleException("Alert popup was not found.");
				}
			}
			if (objWebElement.isDisplayed()) {
				coordinatesElement(objStep);
				blnVisible = true;
				return true;
				// if (objStep.containsKey("intElementWidth")) {
				// int intElementWidth = Integer.parseInt(objStep.get("intElementWidth").toString());
				// int intElementHeight = Integer.parseInt(objStep.get("intElementHeight").toString());
				// logger("elementVisible intElementWidth = " + intElementWidth);
				// logger("elementVisible intElementHeight = " + intElementHeight);
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
			logger("elementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
		}
	}

	public static boolean elementHidden(JSONObject objStep) throws ElementNotHiddenException {
		logger("  ==start==>elementHidden " + dateTimestamp());
		long lngStartTimeElementHidden = System.currentTimeMillis();
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				if (alertFind() == false) {
					jSONObjectStepPut(objStep, "strHighlightArea", "screen");
					logger("elementHidden: strAreaObjectName = " + objStep.get("strHighlightArea"));
					return true;
				} else {
					throw new ElementNotHiddenException("Alert popup was not hidden.");
				}
			}
			if (objWebElement.isDisplayed() == false) {
				return true;
			} else {
				logger("elementHidden: objWebElement.isDisplayed() = return true MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
				throw new ElementNotHiddenException("Element is displayed.");
			}
		} catch (NullPointerException | WebDriverException e) {
			logger("elementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
			return true;
		} finally {
			logger("elementHidden: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
		}
	}

	public static boolean elementEnabled(JSONObject objStep) throws ElementNotEnabledException {
		logger("  ==start==>elementEnabled " + dateTimestamp());
		long lngStartTimeElementEnabled = System.currentTimeMillis();
		try {
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				if (alertFind() == true) {
					return true;
				} else {
					throw new ElementNotEnabledException("Alert popup was not found.");
				}
			}
			if (objWebElement.isEnabled()) {
				return true;
			} else {
				throw new ElementNotEnabledException("elementEnabled - Element is not enabled");
			}
		} finally {
			logger("elementEnabled: finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementEnabled));
		}
	}

	public static boolean elementDisabled() throws ElementNotDisabledException {
		logger("  ==start==>elementDisabled " + dateTimestamp());
		long lngStartTimeElementDisabled = System.currentTimeMillis();
		try {
			//			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
			//				if (alertFind() == true) {
			//					return true;
			//				} else {
			//					throw new ElementNotDisabledException("Alert popup was not found.");
			//				}
			//			}
			if (objWebElement.isEnabled()) {
				throw new ElementNotDisabledException("elementDisabled - Element is not disabled");
			} else {
				return true;
			}
		} finally {
			logger("elementDisabled: finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementDisabled));
		}
	}

	public static String elementGet(JSONObject objStep) throws ElementTagNameNotSupportedException {
		logger("  ==start==>elementGet " + dateTimestamp());
		long lngStartTimeElementGet = System.currentTimeMillis();
		String strElementGet = "";
		try {
			switch (objStep.get("strTagType").toString().toLowerCase()) {
			case "title":
				strElementGet = objWebDriver.getTitle();
				return strElementGet;
			case "img":
				strElementGet = objWebElement.getAttribute("src");
				return strElementGet;
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				strElementGet = objWebElement.getAttribute("value").trim();
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
				strElementGet = objWebElement.getText();
				return strElementGet;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
				strElementGet = objWebElement.getAttribute("value");
				return strElementGet;
			case "input_radio":
			case "input_checkbox":
				if (objWebElement.isSelected() == false) {
					strElementGet = "<off>";
				} else {
					strElementGet = "<on>";
				}
				return strElementGet;
			case "select":
				JavascriptExecutor objExecutor = (JavascriptExecutor) objWebDriver;
				// strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].innerHTML;return selection;", objWebElement);
				strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", objWebElement);
				strElementGet = strElementGet.trim();
				return strElementGet;
			case "table":
				strElementGet = objWebElement.getText();
				return strElementGet;
			case "alert":
				strElementGet = objWebDriver.switchTo().alert().getText();
				return strElementGet;
			default:
				strElementGet = "elementGet tag not supported";
				throw new ElementTagNameNotSupportedException("Element tag not supported");
			}
		} finally {
			logger("ElementGet: finally strElementGet = {" + strElementGet + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementGet));
		}
	}

	public class syncTime {
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

	public static void coordinateHighlightScreenshot(final JSONObject objStepHighlightArea, final WebDriver objWebDriver, final WebElement objWebElement, JSONObject objStep) {
		logger("  ==start==>coordinateHighlightScreenshot " + dateTimestamp());
		long lngStartTimeCoordinateHighlightScreenshot = System.currentTimeMillis();
		JFrame objJFrame = new JFrame() {
			private static final long serialVersionUID = 1L;
			{
				logger("coordinateHighlightScreenshot: before Rectangle objHighlightArea");
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				if (Boolean.parseBoolean(objStepHighlightArea.get("blnHighlight").toString()) == true) {
					int intThickness = 5;
					Color objHighlightColor = null;
					logger("coordinateHighlightScreenshot: before color switch");
					switch (objStepHighlightArea.get("strStatus").toString().toLowerCase()) {
					case "pass":
						if (objStepHighlightArea.get("strAction").toString().toLowerCase().equals("set") && objStepHighlightArea.get("strAssert").toString().toLowerCase().equals("off")) {
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
					logger("coordinateHighlightScreenshot: intThickness = " + intThickness);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					logger("coordinateHighlightScreenshot: strHighlightArea = " + objStep.get("strHighlightArea").toString());
					rectangleAreaByName(objStepHighlightArea, intThickness, objStep.get("strHighlightArea").toString(), objHighlightArea);
					setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
					setUndecorated(true);
					setBackground(new Color(0, 0, 0, 0));
					getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
					setVisible(true);
				}
			}
		};
		int intSleepMilliseconds = 0;
		if (Boolean.parseBoolean(objStep.get("blnScreenshot").toString()) == true) {
			Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
			String strScreenshotFilePath = "";
			try {
				Robot robot = new Robot();
				rectangleAreaByName(objStep, 0, objStep.get("strScreenshotArea").toString(), objHighlightArea);
				BufferedImage screenShot = robot.createScreenCapture(objHighlightArea);
				strScreenshotFilePath = objStep.get("strScreenshotFilePath").toString() + "Screenshot_" + dateTimestamp() + ".jpg";
				Thread objThread = new Thread(new threadSaveImage(screenShot, "jpg", strScreenshotFilePath));
				objThread.start();
				jSONObjectStepPut(objStep, "strScreenshotFilePath", strScreenshotFilePath);
			} catch (AWTException e) {
				// TODO handle coordinateHighlightScreenshot AWTException
				logger("coordinateHighlightScreenshot: " + e.toString());
			} catch (Exception e) {
				// TODO handle coordinateHighlightScreenshot Exception
				logger("coordinateHighlightScreenshot: " + e.toString());
			}
		}
		if (Boolean.parseBoolean(objStep.get("blnHighlight").toString()) == true) {
			try {
				Thread.sleep(intSleepMilliseconds);
			} catch (InterruptedException e) {
				// TODO handle coordinateHighlightScreenshot InterruptedException
				logger("coordinateHighlightScreenshot: " + e.toString());
			}
			objJFrame.setVisible(false);
			objJFrame.dispose();
		}
		logger("coordinateHighlightScreenshot: MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeCoordinateHighlightScreenshot));
	}

	public static void rectangleAreaByName(JSONObject objStep, Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
		logger("  ==start==>rectangleAreaByName " + dateTimestamp());
		logger("rectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
		long lngStartTimeGetRectangleAreaByName = System.currentTimeMillis();
		int intX = 0;
		int intY = 0;
		int intWidth = 0;
		int intHeight = 0;
		if (strAreaObjectName.equals("")) {
			if (objWebDriver == null) {
				strAreaObjectName = "screen";
			}
			if (objWebElement == null) {
				if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					strAreaObjectName = "element";
				} else {
					strAreaObjectName = "screen";
				}
			} else {
				if (objStep.containsKey("intElementScreenX") == false) {
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
				intX = Integer.parseInt(objStep.get("intBrowserOuterX").toString());
				intY = Integer.parseInt(objStep.get("intBrowserOuterY").toString());
				intWidth = Integer.parseInt(objStep.get("intBrowserOuterWidth").toString());
				intHeight = Integer.parseInt(objStep.get("intBrowserOuterHeight").toString());
				break;
			case "page":
				// TODO change this to get absolute screen coordinates
				WebElement objWebElementPage = objWebDriver.findElement(By.xpath("//body"));
				intX = objWebElementPage.getLocation().getX() - intThickness;
				intY = objWebElementPage.getLocation().getY() - intThickness;
				intWidth = objWebElementPage.getSize().width + (2 * intThickness);
				intHeight = objWebElementPage.getSize().height + (2 * intThickness);
				break;
			case "element":
			case "alert":
				intX = Integer.parseInt(objStep.get("intElementScreenX").toString()) - intThickness;
				intY = Integer.parseInt(objStep.get("intElementScreenY").toString()) - intThickness;
				intWidth = Integer.parseInt(objStep.get("intElementWidth").toString()) + (2 * intThickness);
				intHeight = Integer.parseInt(objStep.get("intElementHeight").toString()) + (2 * intThickness);
				break;
			default:
				// TODO add reporting for default
				logger("rectangleAreaByName: default screen, window, page and element not " + strAreaObjectName);
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
			logger("rectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeGetRectangleAreaByName));
		}
	}

	public static class threadSaveImage implements Runnable {
		private BufferedImage objScreenShot;
		private String strImageType;
		private String strPathFileName;

		public threadSaveImage(BufferedImage objScreenShot, String strImageType, String strPathFileName) {
			this.objScreenShot = objScreenShot;
			this.strImageType = strImageType;
			this.strPathFileName = strPathFileName;
		}

		public void run() {
			logger("  ==start==>threadSaveImage " + dateTimestamp());
			try {
				ImageIO.write(objScreenShot, strImageType.toUpperCase(), new File(strPathFileName));
			} catch (IOException e) {
				logger("threadSaveImage: IOException = " + e.toString());
			}
		}
	}

	public static final String dateTimestamp() {
		//logger("  ==start==>dateTimestamp " + dateTimestamp());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static final String dateTimeFormat(Long lngStartTimeMillis) {
		logger("  ==start==>dateTimeFormat " + dateTimestamp());
		SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS");
		Date objFormattedDate = new Date(lngStartTimeMillis);
		logger("dateTimeFormat: " + objSimpleDateFormat.format(objFormattedDate));
		return objSimpleDateFormat.format(objFormattedDate);
	}

	public static String monthGet(int month) {
		logger("  ==start==>monthGet " + dateTimestamp());
		// return new DateFormatSymbols().setLocalPatternChars("es-MX");
		return new DateFormatSymbols().getMonths()[month];
	}

	public static void windowFocus() {
		logger("  ==start==>windowFocus " + dateTimestamp());
		// TODO debug objWebDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
		if (objWebDriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) objWebDriver).executeScript("window.focus();");
		}
	}

	public static void scrollToBottom() {
		logger("  ==start==>scrollToBottom " + dateTimestamp());
		// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
		JavascriptExecutor executor = (JavascriptExecutor) objWebDriver;
		executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public static void writeJsonToHtml(JSONArray objTestSteps, String file) {
		logger("  ==start==>writeJsonToHtml " + dateTimestamp());
		StringBuilder objStringBuilder = new StringBuilder();
		try {
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<head><title>Dragonfly steps</title></head>");
			objStringBuilder.append("<body><h1>");
			objStringBuilder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
			objStringBuilder.append("<tr>");
			objStringBuilder.append("<td>Step</td>");
			objStringBuilder.append("<th>strAction</th>");
			objStringBuilder.append("<th>strTagName</th>");
			objStringBuilder.append("<th>strAttributeNames</th>");
			objStringBuilder.append("<th>strAttributeValues</th>");
			objStringBuilder.append("<th>strInputValue</th>");
			objStringBuilder.append("<th>strLogicalName</th>");
			objStringBuilder.append("<th>intMillisecondsToWait</th>");
			objStringBuilder.append("<th>blnOptional</th>");
			objStringBuilder.append("<th>strAssert</th>");
			objStringBuilder.append("<th>blnPleaseWait</th>");
			objStringBuilder.append("<th>blnHighlight</th>");
			objStringBuilder.append("<th>blnScreenshot</th>");
			objStringBuilder.append("<th>strFunction</th>");
			objStringBuilder.append("<th>strAssistiveProperties</th>");
			objStringBuilder.append("<th>blnExitOnFail</th>");
			objStringBuilder.append("<th>strOutputLinkName</th>");
			objStringBuilder.append("<th>strOutputValue</th>");
			objStringBuilder.append("<th>intLoop</th>");
			objStringBuilder.append("</tr>");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				JSONObject objStep = (JSONObject) objTestSteps.get(intTestStepRow);
				objStringBuilder.append("</tr>");
				objStringBuilder.append("<td> " + (intTestStepRow + 1) + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strAction").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strTagName").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strAttributeNames").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strAttributeValues").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strInputValue").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strLogicalName").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("intMillisecondsToWait").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("blnOptional").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strAssert").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("blnPleaseWait").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("blnHighlight").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("blnScreenshot").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strFunction").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strAssistiveProperties").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("blnExitOnFail").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strOutputLinkName").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("strOutputValue").toString() + "</td>");
				objStringBuilder.append("<td> " + objStep.get("intLoop").toString() + "</td>");
				objStringBuilder.append(" </tr>  ");
			}
			objStringBuilder.append("</table>");
			objStringBuilder.append("</h1></body>");
			objStringBuilder.append("</html>");
			String html = objStringBuilder.toString();
			writeFile(file, html);
		} catch (Exception e) {
			logger("writeJsonToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			logger("writeJsonToHtml: Exception = " + e.toString());
		}
	}

	public static void writeJsonStepsAfterRunToHtml(JSONArray objTestSteps, String strFile) {
		logger("  ==start==>writeJsonStepsAfterRunToHtml " + dateTimestamp());
		String strKeys = "intBrowserOuterHeight|strOutputLinkName|intBrowserInnerWidth|strType|intBrowserOuterX|intBrowserOuterY|strFunction";
		strKeys = strKeys + "|strAttributeValues|blnHighlight|intElementX|strScreenshotFilePath|intElementY|strAssert|intLoop|strAssistiveProperties";
		strKeys = strKeys + "|intElementHeight|intElementScreenY|strAttributeNames|strLogicalName|intElementScreenX|strStepActual|strOutputValue";
		strKeys = strKeys + "|strAction|strScreenshotArea|strStartTimestamp|strTagType|intMillisecondsToWait|intElementWidth|intBrowserOuterWidth";
		strKeys = strKeys + "|blnOptional|strCurrentWindowHandle|strStepExpected|blnScreenshot|blnExitOnFail|intFrame|intBrowserInnerHeight";
		strKeys = strKeys + "|strEndTimestamp|blnPleaseWait|strStepDuration|strInputValue|strTagName|strStatus";
		String strKey = "";
		String[] arrKeys;
		arrKeys = strKeys.split("\\|");
		StringBuilder objStringBuilder = new StringBuilder();
		try {
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<head><title>Dragonfly Steps After Run</title></head>");
			objStringBuilder.append("<body><h1>");
			objStringBuilder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
			objStringBuilder.append("<tr>");
			objStringBuilder.append("<td>Step</td>");
			for (int intKeysEach = 0; intKeysEach < arrKeys.length - 1; intKeysEach++) {
				strKey = (String) arrKeys[intKeysEach].toString();
				objStringBuilder.append("<th>" + strKey + "</th>");
			}
			objStringBuilder.append(" </tr>  ");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				objStringBuilder.append("</tr>");
				objStringBuilder.append("<td> " + (intTestStepRow + 1) + "</td>");
				JSONObject objStep = (JSONObject) objTestSteps.get(intTestStepRow);
				for (int intKeysEach = 0; intKeysEach < arrKeys.length - 1; intKeysEach++) {
					strKey = (String) arrKeys[intKeysEach].toString();
					if (objStep.containsKey(strKey) == true) {
						objStringBuilder.append("<td> " + objStep.get(strKey) + "</td>");
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
			writeFile(strFile, html);
		} catch (Exception e) {
			logger("writeJsonStepsAfterRunToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			logger("writeJsonStepsAfterRunToHtml: Exception = " + e.toString());
		}
	}

	public static void writeReportToHtml(JSONArray objTestSteps, String strFile) {
		logger("  ==start==>writeReportToHtml " + dateTimestamp());
		logger("writeReportToHtml: strFile = " + strFile);
		long lngStartTimeWriteReportToHtml = System.currentTimeMillis();
		String strScreenshotFilePath = "";
		StringBuilder objStringBuilder = new StringBuilder();
		String strColor = "";
		String strStatusIcon = "";
		String strStatus = "";
		try {
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<head><title>Run Results</title></head>");
			objStringBuilder.append("<body>");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				JSONObject objStep = (JSONObject) objTestSteps.get(intTestStepRow);
				objStringBuilder.append("<div id=step_" + intTestStepRow + ">");
				objStringBuilder.append("<TABLE border=1 width=100% height=10%>");
				objStringBuilder.append("<TR>");
				// style="background-color: green"
				switch (objStep.get("strStatus").toString().toLowerCase()) {
				case "pass":
					strStatus = "Pass";
					if (objStep.get("strAction").toString().toLowerCase().equals("set") && objStep.get("strAssert").toString().toLowerCase().equals("off")) {
						strColor = "blue";
						strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:blue\">&#10043</span>";
					} else {
						strColor = "green";
						strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:green\">&#10003</span>";
					}
					break;
				case "fail":
					strStatus = "Fail";
					strColor = "red";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:red\">&#10007</span>";
					break;
				case "warning":
					strStatus = "Warning";
					strColor = "gold";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:gold\">!</span>";
					break;
				case "info":
					strStatus = "Info";
					strColor = "magenta";
					break;
				}
				String strStartTimestamp = objStep.get("strStartTimestamp").toString();
				String strStepDuration = objStep.get("strStepDuration").toString();
				String strEndTimestamp = objStep.get("strEndTimestamp").toString();
				objStringBuilder.append("<TD rowspan=\"2\" width=60px align=center valign=middle>Step " + intTestStepRow + "</TD>");
				// objStringBuilder.append("<TD rowspan=\"2\" width=35px align=center valign=middle>" + strStatusIcon + "</TD>");
				// objStringBuilder.append("<TD style=\"background-color:" + strColor + ";color:black\" rowspan=\"2\" width=75px align=center valign=middle>" + objStep.get("strStatus").toString() + "</TD>");
				// objStringBuilder.append("<TD style=\"color:" + strColor + ";\" rowspan=\"2\" width=75px align=center valign=middle>" + objStep.get("strStatus").toString() + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=35px align=center valign=middle>" + strStatusIcon + "<br>" + strStatus + "</TD>");
				// objStringBuilder.append("<TD rowspan=\"2\" width=60px align=center valign=middle>" + objStep.get("strStatus").toString() + "</TD>");
				objStringBuilder.append("<TD width= 75px align=center valign=middle>Expected</TD>");
				// objStringBuilder.append("<TD align=left valign=middle>" + objStep.get("strAction").toString() + "</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + stepCreateExpected(objStep) + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=150px align=left valign=middle>Start:" + strStartTimestamp + "<br>End: " + strEndTimestamp + "<br>Duration: " + strStepDuration + " ms</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("<TR>");
				objStringBuilder.append("<TD align=center valign=middle>Actual</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objStep.get("strStepActual").toString() + "</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("</TABLE> ");
				// if (objStep.get("strScreenshotFilePath").toString().trim().length() != 0) {
				// strScreenshotFilePath = objStep.get("strScreenshotFilePath").toString().replaceAll("\\\\\\\\", "\\");
				// objStringBuilder.append("<IMG alt=\"ReporterScreenShot_1\" src=\"" + strScreenshotFilePath + "\" width=1100 height=700> ");
				// }
				if (objStep.get("strScreenshotFilePath").toString().trim().length() != 0) {
					strScreenshotFilePath = objStep.get("strScreenshotFilePath").toString().replaceAll("\\\\\\\\", "\\");
					BufferedImage img = null;
					try {
						// img = ImageIO.read(new File("C:\\Users\\perrj115\\Documents\\GitHub\\dragonfly\\Dragonfly\\Results\\20150506_002445914\\images\\Screenshot_20150506_002610161.jpg"));
						img = ImageIO.read(new File(strScreenshotFilePath));
						String imgstr;
						imgstr = imageEncodeToString(img, "jpg");
						// objStringBuilder.append("<IMG alt=\"ReporterScreenShot_1\" src=\"" + strScreenshotFilePath + "\" width=1100 height=700> ");
						objStringBuilder.append("<img src=\"data:image/jpg;base64," + imgstr + "\" alt=\"Step " + intTestStepRow + "\" > ");
					} catch (Exception e) {
						logger("writeReportToHtml: Exception = " + e.toString());
					}
				}
				// logger("writeReportToHtml strScreenshotFilePath = " + objStep.get("strScreenshotFilePath").toString());
				objStringBuilder.append("</div>");
				objStringBuilder.append("<br>");
				objStringBuilder.append("<br>");
				if (objStep.get("strAction").toString().toLowerCase().equals("break")) {
					break;
				}
			}
		} catch (Exception e) {
			logger("writeReportToHtml: " + e.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			String strHTML = objStringBuilder.toString();
			writeFile(strFile, strHTML);
			logger("writeReportToHtml: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeWriteReportToHtml));
		}
	}

	public static void writeFile(String strPathFullFile, String strTextToWrite) {
		logger("  ==start==>writeFile " + dateTimestamp());
		logger("writeFile: strPathFullFile = " + strPathFullFile);
		// logger("writeFile strTextToWrite = " + strTextToWrite);
		BufferedWriter objBufferedWriter = null;
		try {
			objBufferedWriter = new BufferedWriter(new FileWriter(strPathFullFile));
			objBufferedWriter.write(strTextToWrite);
			objBufferedWriter.close();
		} catch (Exception e) {
			logger("writeReportToHtml: IOException" + e.getMessage());
		}
	}

	public static String stepCreateExpected(JSONObject objStep) {
		logger("  ==start==>stepCreateExpected " + dateTimestamp());
		String strAction = objStep.get("strAction").toString();
		String intMillisecondsToWait = objStep.get("intMillisecondsToWait").toString();
		String strInputValue = objStep.get("strInputValue").toString();
		String strTagName = objStep.get("strTagName").toString();
		String strObjectName = objStep.get("strAttributeNames").toString() + "=" + objStep.get("strAttributeValues").toString();
		switch (strAction.toLowerCase()) {
		case "launch":
			return "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + intMillisecondsToWait + "} milliseconds";
		case "close":
			return "Close {" + strTagName + "} browser within {" + intMillisecondsToWait + "} milliseconds";
		case "get":
			return "Get {" + strTagName + "} tag with attributes {" + strObjectName + "} value" + " within {" + intMillisecondsToWait + "} milliseconds";
		case "set":
			return "Set  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "}" + " within " + intMillisecondsToWait + "} milliseconds";
		case "verify":
			return "Verify  {" + strTagName + "} tag with attributes {" + strObjectName + "} value is equal to {" + strInputValue + "}" + " within " + intMillisecondsToWait + "} milliseconds";
		case "mouse_over":
			return "Mouse over  {" + strTagName + "} tag with attributes {" + strObjectName + "} within " + intMillisecondsToWait + "} milliseconds";
		case "sync_visible":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is visible within {" + intMillisecondsToWait + "} milliseconds";
		case "sync_hidden":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is hidden within {" + intMillisecondsToWait + "} milliseconds";
		case "sync_enabled":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is enabled within {" + intMillisecondsToWait + "} milliseconds";
		case "sync_disabled":
			return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is disabled within {" + intMillisecondsToWait + "} milliseconds";
		case "break":
		default:
			return strAction;
		}
	}

	public static String stepCreateActual(JSONObject objStep, String strStepType) {
		logger("  ==start==>stepCreateActual " + dateTimestamp());
		String strActualHtml = "";
		String strActualText = "";
		String strStepDetails = objStep.get("strAttributeValues").toString();
		String strOutputValue = objStep.get("strOutputValue").toString();
		String strInputParameterValueHTML = "";
		String strInputValue = objStep.get("strInputValue").toString();
		String strActualReturn = "";
		String strActualReturnHTML = "";
		String strStepParameterName = "";
		String intWaited = "";
		String strParameterName = "";
		String strTagName = objStep.get("strTagName").toString();// strStepParameterName & " " & strObjectToString
		String strOutputValueHtml = objStep.get("strOutputValue").toString();
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

	public static void writeJsonKeysToHtml(JSONObject objTestStep, String file) throws IOException {
		logger("  ==start==>writeJsonKeysToHtml " + dateTimestamp());
		for (Iterator<?> iterator = objTestStep.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			logger("writeJsonKeysToHtml: " + key + " = " + objTestStep.get(key));
		}
	}

	public static void webElementCollectionTable(String strTagName) {
		logger("  ==start==>webElementCollectionTable " + dateTimestamp());
		// TODO webElementCollectionTable send output to html file
		int intCount = 0;
		JSONObject objStepNew = null;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		logger("webElementCollectionTable: lngStartTimeSwitchTo = " + objWebDriver.getTitle());
		objWebDriver.switchTo().defaultContent();
		for (String winHandle : objWebDriver.getWindowHandles()) {
			intCount = 0;
			// logger("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
			logger("webElementCollectionTable: winHandle = " + winHandle);
			long lngStartTimeSwitchTo = System.currentTimeMillis();
			// if (strCurrentWindowHandle.equals(winHandle)) {
			// } else {
			objWebDriver.switchTo().window(winHandle);
			logger("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			logger("webElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
			// }
			logger("webElementCollectionTable: objWebDriver.getTitle = " + objWebDriver.getTitle());
			//logger("webElementCollectionTable objWebDriver.getPageSource = " + objWebDriver.getPageSource());
			logger("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			List<WebElement> objWebElementCollection = objWebDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				// try {
				// elementVisible(objStepNew, row);
				intCount = intCount + 1;
				logger("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
				// logger("text:=  " + objWebElementEach.);
				logger("webElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
				// logger("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
				// logger("TagName:= '" + row.getAttribute("TagName") + "'");
				// logger("type:= '" + row.getAttribute("type") + "'");
				// logger("Type:= '" + row.getAttribute("Type") + "'");
				// logger("TYPE:= '" + row.getAttribute("TYPE") + "'");
				// logger("id:= '" + row.getAttribute("id") + "'");
				// logger("name:= '" + row.getAttribute("name") + "'");
				// logger("text:= '" + row.getAttribute("text") + "'");
				logger("webElementCollectionTable: getText:= '" + row.getText() + "'");
				// logger("innerText:= '" + row.getAttribute("innerText") + "'");
				// logger("outerText:= '" + row.getAttribute("outerText") + "'");
				// logger("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
				logger("webElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
				// logger("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
				// logger("class:= '" + row.getAttribute("class") + "'");
				// logger("href:= '" + row.getAttribute("href") + "'");
				// logger("NameProp:= '" + row.getAttribute("NameProp") + "'");
				// logger("isDisplayed:= '" + row.isDisplayed() + "'");
				// logger("isEnabled:= '" + row.isEnabled() + "'");
				// logger("getLocation().x:= '" + row.getLocation().x + "'");
				// logger("getLocation().y:= '" + row.getLocation().y + "'");
				// logger("getSize().height:= '" + row.getSize().height + "'");
				// logger("getSize().width:= '" + row.getSize().width + "'");
				// logger("src:= '" + row.getAttribute("src") + "'");
				// if (objCollectionJS.size() > 0) {
				//
				// JavascriptExecutor objJavascriptExecutor = null;
				// objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
				// long lngStartTimeJS = System.currentTimeMillis();
				// logger("JS value = " +
				// objJavascriptExecutor.executeScript("return arguments[0].value;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// logger("JS innerText = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// logger("JS innerHTML = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// logger("JS outerHTML = " +
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

	public static void webElementCollectionAttributes(String strTagName) {
		logger("  ==start==>webElementCollectionAttributes " + dateTimestamp());
		int intCount = 0;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		List<WebElement> objWebElementCollection = objWebDriver.findElements(By.tagName(strTagName));
		Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
		while (objWebElementEach.hasNext()) {
			WebElement row = objWebElementEach.next();
			intCount = intCount + 1;
			logger("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionAttributes " + intCount);
			// logger("text:=  " + objWebElementEach.);
			logger("text:=  " + row.getTagName());
			logger("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
			logger("TagName:=  " + row.getAttribute("TagName"));
			logger("type:=  " + row.getAttribute("type"));
			logger("id:=  " + row.getAttribute("id"));
			logger("name:=  " + row.getAttribute("name"));
			logger("text:=  " + row.getAttribute("text"));
			logger("innerText:=  " + row.getAttribute("innerText"));
			logger("outerText:=  " + row.getAttribute("outerText"));
			logger("innerHTML:=  " + row.getAttribute("innerHTML"));
			logger("outerHTML:=  " + row.getAttribute("outerHTML"));
			logger("uniqueID:=  " + row.getAttribute("uniqueID"));
			logger("class:=  " + row.getAttribute("class"));
			logger("type:=  " + row.getAttribute("type"));
			logger("TYPE:=  " + row.getAttribute("TYPE"));
			logger("href:=  " + row.getAttribute("href"));
			logger("NameProp:=  " + row.getAttribute("NameProp"));
			logger("isDisplayed:=  " + row.isDisplayed());
			logger("name:=  " + row.isEnabled());
			logger("getLocation().x:=  " + row.getLocation().x);
			logger("getLocation().y:=  " + row.getLocation().y);
			logger("getSize().height:=  " + row.getSize().height);
			logger("getLocation().y:=  " + row.getSize().width);
			logger("src:=  " + row.getAttribute("src"));
		}
	}

	public static void webElementAttributes() {
		logger("  ==start==>webElementAttributes " + dateTimestamp());
		// logger("text:=  " + objWebElementEach.);
		logger("text:=  " + objWebElement.getTagName());
		logger("tag_type:=  " + objWebElement.getTagName() + "_" + objWebElement.getAttribute("type"));
		logger("TagName:=  " + objWebElement.getAttribute("TagName"));
		logger("type:=  " + objWebElement.getAttribute("type"));
		logger("id:=  " + objWebElement.getAttribute("id"));
		logger("name:=  " + objWebElement.getAttribute("name"));
		logger("text:=  " + objWebElement.getAttribute("text"));
		logger("innerText:=  " + objWebElement.getAttribute("innerText"));
		logger("outerText:=  " + objWebElement.getAttribute("outerText"));
		logger("innerHTML:=  " + objWebElement.getAttribute("innerHTML"));
		logger("outerHTML:=  " + objWebElement.getAttribute("outerHTML"));
		logger("uniqueID:=  " + objWebElement.getAttribute("uniqueID"));
		logger("class:=  " + objWebElement.getAttribute("class"));
		logger("type:=  " + objWebElement.getAttribute("type"));
		logger("TYPE:=  " + objWebElement.getAttribute("TYPE"));
		logger("href:=  " + objWebElement.getAttribute("href"));
		logger("NameProp:=  " + objWebElement.getAttribute("NameProp"));
		logger("isDisplayed:=  " + objWebElement.isDisplayed());
		logger("name:=  " + objWebElement.isEnabled());
		logger("getLocation().x:=  " + objWebElement.getLocation().x);
		logger("getLocation().y:=  " + objWebElement.getLocation().y);
		logger("getSize().height:=  " + objWebElement.getSize().height);
		logger("getLocation().y:=  " + objWebElement.getSize().width);
		logger("src:=  " + objWebElement.getAttribute("src"));
	}

	public static BufferedImage imageDecodeFromString(String imageString) {
		logger("  ==start==>imageDecodeFromString " + dateTimestamp());
		BufferedImage image = null;
		byte[] imageByte;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	public static String imageEncodeToString(BufferedImage image, String type) {
		logger("  ==start==>imageEncodeToString " + dateTimestamp());
		String imageString = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, type, bos);
			byte[] imageBytes = bos.toByteArray();
			BASE64Encoder encoder = new BASE64Encoder();
			imageString = encoder.encode(imageBytes);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageString;
	}

	public static Integer randomNumberRange(int intNumberMinimum, int intNumberMaximum) {
		logger("  ==start==>randomNumberRange " + dateTimestamp());
		Random objRandom = new Random();
		return objRandom.nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
	}
}