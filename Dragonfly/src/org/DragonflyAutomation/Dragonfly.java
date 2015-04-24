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
package org.DragonflyAutomation;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
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
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

import com.opera.core.systems.OperaDriver;

public class Dragonfly {
	static String strLog = "";

	public static void logger(String strTextToAdd) {
		System.out.println(strTextToAdd);
		if (strLog.length() == 0) {
			strLog = strTextToAdd;
		} else {
			strLog = strLog + System.getProperty("line.separator") + strTextToAdd;
		}
	}

	@SuppressWarnings("serial")
	public static class ElementNotFoundException extends Exception {
		public ElementNotFoundException(String message) {
			super(message);
		}
	}// the end of ElementNotFoundException

	@SuppressWarnings("serial")
	public static class MultipleElementsFoundException extends Exception {
		public MultipleElementsFoundException(String message) {
			super(message);
		}
	}// the end of MultipleElementsFoundException

	@SuppressWarnings("serial")
	public static class ElementNotSetException extends Exception {
		public ElementNotSetException(String message) {
			super(message);
		}
	}// the end of ElementNotVisibleException

	@SuppressWarnings("serial")
	public static class ElementNotVisibleException extends Exception {
		public ElementNotVisibleException(String message) {
			super(message);
		}
	}// the end of ElementNotVisibleException

	@SuppressWarnings("serial")
	public static class ElementNotHiddenException extends Exception {
		public ElementNotHiddenException(String message) {
			super(message);
		}
	}// the end of ElementNotHiddenException

	@SuppressWarnings("serial")
	public static class ElementNotEnabledException extends Exception {
		public ElementNotEnabledException(String message) {
			super(message);
		}
	}// the end of ElementNotEnabledException

	@SuppressWarnings("serial")
	public static class ElementNotDisabledException extends Exception {
		public ElementNotDisabledException(String message) {
			super(message);
		}
	}// the end of ElementNotDisabledException

	@SuppressWarnings("serial")
	public static class ValueNotMatchedException extends Exception {
		public ValueNotMatchedException(String message) {
			super(message);
		}
	}// the end of ValueNotMatchedException

	@SuppressWarnings("serial")
	public static class ElementValueNotVerifiedException extends Exception {
		public ElementValueNotVerifiedException(String message) {
			super(message);
		}
	}// the end of ElementValueNotVerifiedException

	@SuppressWarnings("serial")
	public static class ElementTagNameNotSupportedException extends Exception {
		public ElementTagNameNotSupportedException(String message) {
			super(message);
		}
	}// the end of ElementTagNameNotSupportedException

	@SuppressWarnings("serial")
	public static class BrowserDriverNotSupportedException extends Exception {
		public BrowserDriverNotSupportedException(String message) {
			super(message);
		}
	}// the end of BrowserDriverNotSupportedException

	@SuppressWarnings("serial")
	public static class DoPostBackNotCompleteException extends Exception {
		public DoPostBackNotCompleteException(String message) {
			super(message);
		}
	}// the end of DoPostBackNotCompleteException

	@SuppressWarnings("serial")
	public static class JQueryAjaxNotCompleteException extends Exception {
		public JQueryAjaxNotCompleteException(String message) {
			super(message);
		}
	}// the end of JQueryAjaxNotCompleteException

	@SuppressWarnings("serial")
	public static class JQueryAnimationNotCompleteException extends Exception {
		public JQueryAnimationNotCompleteException(String message) {
			super(message);
		}
	}// the end of JQueryAnimationNotCompleteException

	@SuppressWarnings("serial")
	public static class AngularJsNotCompleteException extends Exception {
		public AngularJsNotCompleteException(String message) {
			super(message);
		}
	}// the end of AngularJsNotCompleteException

	public String data_DateDaysOut(String strDaysOut) {
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat FormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (String) (FormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}// the end of data_DateDaysOut

	public String data_EnvironmentURL(String strApplication_Environment) {
		String strURL = "";
		String testPath = "Data/internal/Environment.json";
		JSONParser objJsonParser = new JSONParser();
		Object objJsonParsedFile = null;
		try {
			objJsonParsedFile = objJsonParser.parse(new FileReader(testPath));
		} catch (IOException | ParseException e) {
			// TODO add meaningful error handling and reporting
			e.printStackTrace();
		}
		JSONObject objJsonFile = (JSONObject) objJsonParsedFile;
		JSONArray objEnvironmentArray = (JSONArray) objJsonFile.get("environment");
		JSONObject objEnvironments = (JSONObject) objEnvironmentArray.get(0);
		strURL = objEnvironments.get(strApplication_Environment).toString();
		return strURL;
	}// the end of data_EnvironmentURL

	public String data_localWebsiteFilePath(String strWebsite) {
		logger("file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite);
		return "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
	}// the end of data_localWebsiteFilePath

	public static String OSType() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}
	}// the end of OSType

	public static void killWindowsProcess(String strProcessToKill) {
		try {
			Runtime.getRuntime().exec(strProcessToKill);
		} catch (IOException e) {
			// TODO killWindowsProcess Auto-generated catch block
			logger("killWindowsProcess " + e.toString());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_WINDOWS);

		WebDriver objWebDriver = null;
		WebElement objWebElement;
		String strTestPath = "";
		JSONParser parser = new JSONParser();
		JSONObject objJsonFile = null;
		JSONArray objTestSteps = null;
		JSONObject objStep = null;
		int intStep = 0;
		int intMillisecondsToWaitDefault = 20000;
		String strCurrentWindowHandle = "";
		int intFrame = -1;
		String strResultsPath = "";
		String strImagesPath = "";
		logger("Working Directory = " + System.getProperty("user.dir"));
		String strReturnOSType = OSType();
		int intLoopCount = 0;
		int intLoopEach = 0;
		int intLoopStep = 0;
		switch (strReturnOSType) {
		case "Windows":
			strResultsPath = System.getProperty("user.dir") + "\\Results\\" + dateTimestamp() + "\\";
			strImagesPath = "images\\";
			break;
		case "Mac":
			strResultsPath = System.getProperty("user.dir") + "/Results/" + dateTimestamp() + "/";
			strImagesPath = "images/";
			break;
		default:
			logger("main switch OSType = " + strReturnOSType + "  not supported");
			System.exit(0);
		}
		new File(strResultsPath).mkdirs();
		new File(strResultsPath + strImagesPath).mkdirs();
		// logger("ClipboardGet = " + ClipboardGet());
		try {
			strTestPath = "Data/public/local_ATW_window.json";
			// strTestPath = "Data/public/local_ATW_AlertPopups.json";
			// strTestPath = "Data/public/local_ATW.json";
			// strTestPath = "Data/public/local_ATW_frames.json";
			// strTestPath = "Data/public/public_SeaWorld.json";
			// strTestPath = "Data/public/local_jqueryFade.json";
			// strTestPath = "Data/public/local_size_Visibility.json";
			// strTestPath = "Data/public/local_AngularJS_Calculator.json";
			// strTestPath = "Data/public/public_mercury_tours.json";
			// strTestPath = "Data/public/public_ranorex.json";
			// strTestPath = "Data/public/public_w3s_FireEvents.json"
			// strTestPath = "Data/public/public_w3s_JqueryAnimate.json";
			// strTestPath = "Data/public/public_w3s_jquery.json";
			// strTestPath = "Data/public/public_w3s_AngularJs.json";
			// strTestPath = "Data/public/public_w3s_Visibility.json";
			// strTestPath = "Data/public/public_GolfNow.json";
			Object objParser = parser.parse(new FileReader(strTestPath));
			objJsonFile = (JSONObject) objParser;
			objTestSteps = (JSONArray) objJsonFile.get("steps");
			JSONArray objLinkArray = (JSONArray) objJsonFile.get("link");
			JSONObject objLinks = (JSONObject) objLinkArray.get(0);
			writeJsonToHtml(objTestSteps, strResultsPath + "StepsOriginal.html");
			for (intStep = 0; intStep < objTestSteps.size(); intStep++) {
				objWebElement = null;
				objStep = (JSONObject) objTestSteps.get(intStep);

				String strInputValue = objStep.get("strInputValue").toString();
				if (strInputValue.toLowerCase().startsWith("<link>") == true) {
					strInputValue = objLinks.get(strInputValue.replace("<link>", "")).toString();
					objStep.put("strInputValue", strInputValue);
				}
				if (objStep.get("intMillisecondsToWait").toString().trim().length() == 0) {
					objStep.put("intMillisecondsToWait", intMillisecondsToWaitDefault);
				}
				if (objStep.get("blnOptional").toString().trim().length() == 0) {
					objStep.put("blnOptional", false);
				}
				if (objStep.get("strAssert").toString().trim().length() == 0) {
					objStep.put("strAssert", "off");
				}
				objStep.put("blnPleaseWait", "true");
				objStep.put("blnHighlight", "true");

				objStep.put("blnScreenshot", "true");
				objStep.put("strScreenshotArea", "screen");
				if (objStep.get("blnExitOnFail").toString().trim().length() == 0) {
					objStep.put("blnExitOnFail", "true");
				}

				objStep.put("strCurrentWindowHandle", strCurrentWindowHandle);
				objStep.put("strType", "");
				objStep.put("strScreenshotFilePath", strResultsPath + strImagesPath);
				objStep.put("strStatus", "info");
				objStep.put("intFrame", intFrame);

				objStep.put("strStartTimestamp", "");
				objStep.put("strStepDuration", "");
				objStep.put("strEndTimestamp", "");

				objStep.put("strStepExpected", "");
				objStep.put("strStepActual", "");

				logStepDetails(objStep, intStep);

				if (objStep.get("intLoop").toString().trim().length() > 0) {
					if (objStep.get("intLoop").toString().startsWith("<loopStart>") == true) {
						if (intLoopEach == 0) {
							intLoopCount = Integer.parseInt(objStep.get("intLoop").toString().replace("<loopStart>", ""));
							objStep.put("intLoop", "");
							intLoopEach = 1;
							intLoopStep = intStep;
							// } else {
							// intLoopEach = intLoopEach + 1;
						}
					}
				}

				logger("main intLoopCount = " + intLoopCount);
				logger("main intLoopEach = " + intLoopEach);
				logger("main intStep = " + intStep);
				logger("main intLoopStep = " + intLoopStep);

				if (!objStep.get("strFunction").toString().trim().equals("")) {
					String strMethodName = objStep.get("strFunction").toString();
					String arguments = strInputValue;
					try {
						Class objClass = Class.forName("org.DragonflyAutomation.Dragonfly");
						Class objParameterTypes[] = new Class[1];
						objParameterTypes[0] = String.class;
						Method objMethod = objClass.getMethod(strMethodName, objParameterTypes);
						Dragonfly objDragonfly = new Dragonfly();
						Object arrArgumentList[] = new Object[1];
						arrArgumentList[0] = new String(arguments);
						Object objReturn = objMethod.invoke(objDragonfly, arrArgumentList);
						String strReturnValue = (String) objReturn;
						strInputValue = strReturnValue;
						objStep.put("strInputValue", strInputValue);
						logger("main call function retrun value = " + strReturnValue.toString());
					} catch (Throwable e) {
						logger("main call function - " + e.toString());
					}
				}// the end of
				if (!strInputValue.equals("<skip>")) {
					switch (objStep.get("strAction").toString().toLowerCase()) {
					case "launch":
						// TODO create a browserLaunchSync to manage reporting and sync
						objWebDriver = browserLaunch(objStep);
						break;
					case "close":
						// TODO create a browserCloseSync to manage reporting and sync close
						objWebDriver.close();
						objWebDriver.quit();
						objStep.put("strStatus", "pass");
						coordinateHighlightScreenshot(objStep, objWebDriver, null, objStep);
						break;
					case "get":
						elementGetSync(objStep, objWebDriver, objWebElement);
						break;
					case "set":
						elementSetSync(objStep, objWebDriver, objWebElement);
						break;
					case "verify":
						elementVerifyValueSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_visible":
						elementVisibleSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_hidden":
						elementHiddenSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_enabled":
						elementEnabledSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_disabled":
						elementDisabledSync(objStep, objWebDriver, objWebElement);
						break;
					case "mouse_over":
						elementOnMouseOverSync(objStep, objWebDriver, objWebElement);
						break;
					case "sleep":
						try {
							TimeUnit.MILLISECONDS.sleep(Integer.parseInt(objStep.get("strInputValue").toString()));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "break":
						break;
					default:
						// TODO action not supported add exit test and reporting
						break;
					}// the end of switch (strAction.toLowerCase())
					if (objStep.get("strAction").toString().toLowerCase().equals("break")) {
						break;
					}// the end of if (strAction.toLowerCase().equals("break"))
					strCurrentWindowHandle = objStep.get("strCurrentWindowHandle").toString();
					intFrame = Integer.parseInt(objStep.get("intFrame").toString());
				}// the end of if (strInputValue != "<skip>")
				if (objStep.get("strOutputLinkName").toString().trim().length() != 0) {
					objLinks.put(objStep.get("strOutputLinkName").toString(), objStep.get("strOutputValue").toString());
				}
				if (objStep.get("strStatus").toString() == "fail") {
					if (Boolean.parseBoolean(objStep.get("blnExitOnFail").toString()) == true) {
						webElementCollectionTable(objStep.get("strTagName").toString(), objWebDriver);
						break;
					}
				}

				if (objStep.get("intLoop").toString().startsWith("<loopExit>") == true) {
				}

				if (objStep.get("intLoop").toString().startsWith("<loopEnd>") == true) {
					if (intLoopEach == intLoopCount) {
						intLoopCount = 0;
						intLoopEach = 0;

					} else {
						intLoopEach = intLoopEach + 1;
						intStep = intLoopStep - 1;
					}
				}

			}// for intStep
				// TODO confirm the exceptions to catch in main some may need to be removed
		} catch (IOException e) {
			logger("main - " + e.toString());
		} catch (ParseException e) {
			logger("main - " + e.toString());
		} catch (BrowserDriverNotSupportedException e) {
			logger("main - " + e.toString());
		} finally {
			// TODO review how end of run is determined for reporting and cleanup
			writeJsonToHtml(objTestSteps, strResultsPath + "StepsWithDefaults.html");
			writeReportToHtml(objTestSteps, strResultsPath + "Report.html");
			writeJsonToFile(objJsonFile, strResultsPath + "StepsAfterRun.json");
			writeJsonStepsAfterRunToHtml(objTestSteps, strResultsPath + "StepsAfterRun.html");
			writeLogger(strResultsPath + "DragonflyLog.txt");
			if (objWebDriver.toString().contains("InternetExplorerDriver")) {
				killWindowsProcess("taskkill /F /IM IEDriverServer.exe");
			}
		}// the end of try
	}// the end of Main

	public static void logStepDetails(JSONObject objStep, int intStep) {
		String[] arrKeys;
		String strKeys = "";
		String strKey = "";
		strKeys = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait";
		strKeys = strKeys + "|blnOptional|strAssert|blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail";
		strKeys = strKeys + "|strOutputLinkName|strOutputValue|intLoop|strCurrentWindowHandle";
		logger("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
		arrKeys = strKeys.split("\\|");
		for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
			strKey = (String) arrKeys[intKeysEach].toString();
			if (objStep.containsKey(strKey) == true) {
				logger("main " + strKey + " = " + objStep.get(strKey).toString());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void elementGetSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnGet = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		String strGetValue = "";
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					blnVisible = true;
				}
				if (blnGet == false) {
					strGetValue = elementGet(objStep, objWebDriver, objWebElement);
					objStep.put("strOutputValue", strGetValue);
					blnGet = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementGetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementGetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				logger("elementGetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} finally {
				if (blnExit == true) {
					objStep.put("strStatus", "fail");
				} else {
					if (blnStatus == true) {
						objStep.put("strStatus", "pass");
						blnExit = true;
					} else if (blnStatus == false) {
						if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
							if (blnFound == false) {
								blnVisible = false;
								blnGet = false;
							}
						} else {
							if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
								objStep.put("strStatus", "warning");
								blnExit = true;
							} else {
								objStep.put("strStatus", "fail");
								blnExit = true;
							}
						}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
					}// the end of if (blnStatus == true)
				}
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "get"));
					logger("elementGetSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}// the end of try
		}// the end of While
	}// the end of elementGetSync

	public static void elementOnMouseOver(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		logger("elementOnMouseOverSync - " + objWebElement.toString());
		JavascriptExecutor objJavascriptExecutor = null;
		if (objWebElement != null) {
			objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
		}
		objJavascriptExecutor.executeScript("arguments[0].onmouseover();", objWebElement);
	}

	@SuppressWarnings("unchecked")
	public static void elementOnMouseOverSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnOnMouseOver = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep, objWebDriver, objWebElement);
					blnEnabled = true;
				}
				if (blnOnMouseOver == false) {
					elementOnMouseOver(objStep, objWebDriver, objWebElement);
					blnOnMouseOver = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementOnMouseOverSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementOnMouseOverSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementOnMouseOverSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					objStep.put("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnOnMouseOver = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							blnExit = true;
						} else {
							objStep.put("strStatus", "fail");
							blnExit = true;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "mouseover"));
					logger("elementOnMouseOverSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}
		}
	}// the end of elementOnMouseOverSync

	public static void elementSet(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement, String strOuterHTML) throws ElementTagNameNotSupportedException, ElementNotSetException {
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
			// // objJavascriptExecutor.executeScript("arguments[0].onkeydown();", objWebElement);
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
				}// the end of switch (strInputValue.toLowerCase())
				break;
			case "select":
				int intOptionsEach;
				String strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objWebElement);
				strOptions = strOptions.substring(1);
				String[] arrOptions;
				arrOptions = strOptions.split("\\|");
				for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
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
				Alert alert = objWebDriver.switchTo().alert();

				logger(alert.getText()); // Print Alert popup
				logger(objStep.get("strAttributeValues").toString().toLowerCase());
				switch (objStep.get("strAttributeValues").toString().toLowerCase()) {
				case "text":
					alert.sendKeys(objStep.get("strInputValue").toString());
					break;
				case "accept":
					alert.accept(); // Close Alert popup
					break;
				case "dismiss":
					alert.dismiss();// Close Alert popup
					break;
				}
				break;
			default:
				throw new ElementTagNameNotSupportedException("Element tag not supported");
			}// the end of switch (strTagName.toLowerCase())
		} catch (Exception e) {
			logger("elementSet Exception = " + e.toString());
		} finally {
			if (blnSet == false) {
				throw new ElementNotSetException("Element not set");
			}
			logger("elementSet finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
		}
	}// the end of elementSet

	public static void waitForAngularRequestsToFinish(JavascriptExecutor driver) {
		driver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
	}

	public static void SetSyncComplete(WebDriver objWebDriver, String strOuterHTML) throws DoPostBackNotCompleteException, JQueryAjaxNotCompleteException, JQueryAnimationNotCompleteException, AngularJsNotCompleteException {
		logger("SetSyncComplete Start");
		long lngTimeStart = System.currentTimeMillis();
		try {
			logger("SetSyncComplete isAlertPresent Start");
			if (isAlertPresent(objWebDriver) == true) {
				// Object[] arrHandles = objWebDriver.getWindowHandles().toArray();
				// logger("elementFind arrHandles.length = " + arrHandles.length);
				return;
			}
			logger("SetSyncComplete isAlertPresent complete");
			WaitForReadyState(objWebDriver);
			// JavascriptExecutor objJavascriptExecutor = null;
			// objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
			// waitForAngularRequestsToFinish(objJavascriptExecutor);
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
				try {
					logger("SetSyncComplete __EVENTTARGET value = " + objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
				} catch (Exception e) {
					logger("SetSyncComplete Exception = " + e.toString());
				}
				logger("SetSyncComplete blnEventTarget = " + blnEventTarget);
				if (blnEventTarget == true) {
					// blnResult = false;
					throw new AngularJsNotCompleteException("");
				}
				logger("SetSyncComplete lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));
			}// the end of (strOuterHTML.contains("__doPostBack"))
			long lngStartTimeElementSetJQueryActive = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				// logger("elementSet blnJquery = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);"));
				blnJquery = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (jQuery.active);");
					logger("SetSyncComplete lngJqueryActive = " + lngJqueryActive);
					// logger("elementSet both = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));

				}
			} catch (Exception e) {
				logger("SetSyncComplete JqueryActive Exception = " + e.toString());
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
					logger("SetSyncComplete JQueryAnimate = " + lngElementsAnimated);
					// logger("SetSyncComplete JQueryAnimate = " + ((JavascriptExecutor) objWebDriver).executeScript("return $(\":animated\").length"));
				}
			} catch (Exception e) {
				logger("SetSyncComplete JQueryAnimate Exception = " + e.toString());
			}
			if (lngElementsAnimated > 0) {
				// blnResult = false;
				throw new JQueryAnimationNotCompleteException("");
			}
			long lngStartTimeElementSetAngularJS = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null);");
				logger("SetSyncComplete blnAngularJs = " + blnAngularJs);
				// boolean blnAngularJs2 = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular == null);");
				// logger("elementSet blnAngularJs2 = " + blnAngularJs2);
				// if (blnAngularJs == true) {
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				logger("SetSyncComplete lngJqueryActive = " + lngAngularJsInjectorActive);
				// }
				// boolean blnAngularJsInjector = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector() != null);");
				// logger("elementSet blnAngularJsInjector = " + blnAngularJsInjector);
				// blnAngularJS = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
				// logger("elementSet blnAngularJS = " + blnAngularJS);
			} catch (Exception e) {
				logger("SetSyncComplete AngularJS Exception = " + e.toString());
			}
			if (lngAngularJsInjectorActive > 0) {
				// blnResult = false;
				throw new AngularJsNotCompleteException("");
			}

		} catch (NoSuchWindowException e) {
			logger("SetSyncComplete - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));

		} finally {
			logger("SetSyncComplete finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
		}
		// if (blnResult == true) {
		// return true;
		// } else {
		// return false;
		// }
	}

	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
			}
		};
	}

	public static boolean WaitForReadyState(WebDriver objWebDriver) {
		logger("elementSet document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return document.readyState"));
		return false;
	}

	@SuppressWarnings("unchecked")
	public static void elementSetSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnSet = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		Boolean blnAssert = false;
		Boolean blnSetSync = false;
		String strOuterHTML = "";
		objStep.put("strOutputValue", objStep.get("strInputValue").toString());
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					logger("elementSetSync elementFind over");
					if (objWebElement != null) {
						strOuterHTML = objWebElement.getAttribute("outerHTML");
						logger(strOuterHTML);
						logger("elementSetSync outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					logger("elementSetSync strOuterHTML over");

					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep, objWebDriver, objWebElement);
					blnEnabled = true;
				}
				switch (objStep.get("strAssert").toString().toLowerCase()) {
				case "off":
					objStep.put("strStatus", "pass");
					// TODO complete Alert Set, move or consider how to handle assert
					if (blnSet == false) {
						// if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
						// coordinateHighlightScreenshot(objStep, objWebDriver, null, objStep);
						// } else {
						coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
						// }
						elementSet(objStep, objWebDriver, objWebElement, strOuterHTML);
						blnSet = true;
						blnAssert = true;
					}
					if (blnSetSync == false) {
						SetSyncComplete(objWebDriver, strOuterHTML);
						blnSetSync = true;
					}
					blnStatus = true;
					break;
				case "hidden":
					if (blnSet == false) {
						objStep.put("strStatus", "pass");
						coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
						elementSet(objStep, objWebDriver, objWebElement, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						SetSyncComplete(objWebDriver, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementHidden(objStep, objWebDriver, objWebElement);
						blnAssert = true;
					}
					blnStatus = true;
					break;
				case "value":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						SetSyncComplete(objWebDriver, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVerifyValue(objStep, objWebDriver, objWebElement);
						blnAssert = true;
					}
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				case "visible":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						SetSyncComplete(objWebDriver, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep, objWebDriver, objWebElement);
						blnAssert = true;
					}
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				case "enabled":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						SetSyncComplete(objWebDriver, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep, objWebDriver, objWebElement);
						elementEnabled(objStep, objWebDriver, objWebElement);
						blnAssert = true;
					}
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				case "disabled":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement, strOuterHTML);
						blnSet = true;
					}
					if (blnSetSync == false) {
						SetSyncComplete(objWebDriver, strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep, objWebDriver, objWebElement);
						elementDisabled(objWebElement);
						blnAssert = true;
					}
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				}// the end of switch (strAssert.toLowerCase())
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} catch (ElementNotHiddenException e) {
				logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnAssert = false;
			} catch (ValueNotMatchedException e) {
				logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				blnFound = false;
				blnAssert = false;
			} catch (ElementNotSetException e) {
				blnSet = true;
				blnAssert = false;
			} catch (ElementNotDisabledException e) {
				blnAssert = false;
				logger("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
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
							objStep.put("strStatus", "pass");
							blnExit = true;
						} else if (blnStatus == false) {
							if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
								objStep.put("strStatus", "warning");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							} else {
								objStep.put("strStatus", "fail");
								coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
								blnExit = true;
							}
						}
					}
				}
				if (blnExit == true) {
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "SET"));
					logger("elementSetSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}// the end of try
		}// the end of While
	}// the end of elementSetSync

	@SuppressWarnings("unchecked")
	public static void elementVerifyValueSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		Boolean blnVerified = false;
		// Boolean blnValueNotMatched = false;
		String strActualValue = "";
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					blnVisible = true;
				}
				if (blnVerified == false) {
					strActualValue = elementVerifyValue(objStep, objWebDriver, objWebElement);
					blnVerified = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				blnStatus = false;
				logger("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				logger("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementTagNameNotSupportedException e) {
				logger("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
				blnExit = true;
			} catch (ValueNotMatchedException e) {
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				blnStatus = false;
				// blnValueNotMatched = false;
				logger("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnExit == true) {
					objStep.put("strStatus", "fail");
					blnExit = true;
				}
				if (blnStatus == true) {
					logger("elementVerifyValueSync finally blnStatus = " + blnStatus);
					objStep.put("strOutputValue", strActualValue);
					objStep.put("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
							blnVerified = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strOutputValue", strActualValue);
							objStep.put("strStatus", "warning");
							blnExit = true;
						} else {
							objStep.put("strOutputValue", strActualValue);
							objStep.put("strStatus", "fail");
							blnExit = true;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "verify"));
					logger("elementVerifyValueSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}// the end of try
		}// the end of While
	}// the end of elementVerifyValueSync

	public static String elementVerifyValue(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ValueNotMatchedException, ElementTagNameNotSupportedException {
		long lngStartTimeElementVerify = System.currentTimeMillis();
		String strGetValue = "";
		String strActualValue = "";
		String strValueExpected = objStep.get("strInputValue").toString();
		try {
			strGetValue = elementGet(objStep, objWebDriver, objWebElement);
			strActualValue = verifyMatch(strGetValue, strValueExpected);
		} finally {
			logger("elementVerifyValue finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeElementVerify));
		}
		return strActualValue;
	}// the end of elementVerifyValue

	public static String verifyMatch(String strActual, String strExpected) throws ValueNotMatchedException {
		long lngStartTimeVerifyMatch = System.currentTimeMillis();
		try {
			if (strExpected.toLowerCase().startsWith("re:")) {
				String strPattern = strExpected.substring(3);
				logger("verifyMatch RegularExpressionMatch = " + RegularExpressionMatch(strPattern, strActual));
				return RegularExpressionMatch(strPattern, strActual);
			} else {
				if (strExpected.equals(strActual)) {
					return strActual;
				} else {
					throw new ValueNotMatchedException("verifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
				}
			}
		} finally {
			logger("verifyMatch strActual = {" + strActual + "} strExpected = {" + strExpected + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeVerifyMatch));
		}
	}// the end of VerifyMatch

	public static String RegularExpressionMatch(String strPattern, String strActualValue) {
		Pattern objPattern = Pattern.compile(strPattern);
		Matcher objMatcher = objPattern.matcher(strActualValue);
		objMatcher.matches();
		String strMatchedString = objMatcher.group(0);
		return strMatchedString;
	} // the end of RegularExpressionMatch

	@SuppressWarnings("unchecked")
	public static void elementVisibleSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					blnVisible = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				logger("elementVisibleSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					logger("elementVisibleSync finally blnStatus = " + blnStatus);
					objStep.put("strStatus", "pass");
					// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
							blnExit = true;
						} else {
							objStep.put("strStatus", "fail");
							// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
							blnExit = true;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "syncvisible"));
					logger("elementVisibleSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}// the end of try
		}// the end of While
	}// the end of elementVisibleSync

	@SuppressWarnings("unchecked")
	public static void elementHiddenSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnHidden = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				// logger("elementHiddenSync - blnFound = " + blnFound);
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnFound == true && blnHidden == false) {
					elementHidden(objStep, objWebDriver, objWebElement);
					blnHidden = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ElementNotFoundException e) {
				blnFound = false;
				blnHidden = true;
				blnStatus = true;
				logger("elementHiddenSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (MultipleElementsFoundException e) {
				blnFound = false;
				blnHidden = false;
				logger("elementHiddenSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotHiddenException e) {
				// blnFound = false;
				blnHidden = false;
				logger("elementHiddenSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (Exception e) {
				blnFound = false;
				blnHidden = false;
				logger("elementHiddenSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					objStep.put("strStatus", "pass");
					elementCoordinates(objStep, objWebDriver, null);
					// coordinateHighlightScreenshot(objStep, objWebDriver, null, objStep);
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnHidden = false;
						}
					} else {
						elementCoordinates(objStep, objWebDriver, objWebElement);
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
							blnExit = true;
						} else {
							objStep.put("strStatus", "fail");
							// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
							blnExit = true;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "synchidden"));
					logger("elementHiddenSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}// the end of try
		}// the end of While
	}// the end of elementHiddenSync

	@SuppressWarnings("unchecked")
	public static void elementEnabledSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep, objWebDriver, objWebElement);
					blnEnabled = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				blnEnabled = false;
				logger("elementEnabledSync - " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				logger("elementEnabledSync - " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					objStep.put("strStatus", "pass");
					// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnEnabled = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
							blnExit = true;
						} else {
							objStep.put("strStatus", "fail");
							// coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
							blnExit = true;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "syncenabled"));

					logger("elementEnabledSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}// the end of try
		}// the end of While
	}// the end of elementEnabledSync

	@SuppressWarnings("unchecked")
	public static void elementDisabledSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnDisabled = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					blnVisible = true;
				}
				if (blnDisabled == false) {
					elementDisabled(objWebElement);
					blnDisabled = true;
				}
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException | ElementNotVisibleException e) {
				blnFound = false;
				blnVisible = false;
				blnDisabled = false;
				logger("elementDisabledSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ElementNotDisabledException e) {
				blnDisabled = false;
				logger("elementDisabledSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (blnStatus == true) {
					objStep.put("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnDisabled = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							blnExit = true;
						} else {
							objStep.put("strStatus", "fail");
							blnExit = true;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
				if (blnExit == true) {
					coordinateHighlightScreenshot(objStep, objWebDriver, objWebElement, objStep);
					lngTimeEnd = System.currentTimeMillis();
					objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
					objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
					objStep.put("strStepActual", createStepActual(objStep, "syncdisabled"));
					logger("elementDisabledSync finally strStatus " + objStep.get("strStatus").toString() + " Milliseconds Waited = " + objStep.get("strStepDuration").toString());
					return;
				}
			}// the end of try
		}// the end of While
	}// the end of elementDisabledSync

	// TODO combine duplicate code
	// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
	@SuppressWarnings("unchecked")
	public static WebDriver browserLaunch(JSONObject objStep) throws BrowserDriverNotSupportedException {
		Long lngTimeStart = System.currentTimeMillis();
		Long lngTimeEnd = null;
		WebDriver objWebDriver = null;
		DesiredCapabilities desiredCapabilities = null;
		try {
			objStep.put("strStatus", "pass");
			objStep.put("intFrame", -1);
			switch (objStep.get("strTagName").toString()) {
			case "firefox":
				objWebDriver = new FirefoxDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				Actions myAction = new Actions(objWebDriver);
				myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
				break;
			case "ie":
				killWindowsProcess("taskkill /F /IM iexplore.exe");
				desiredCapabilities = DesiredCapabilities.internetExplorer();
				desiredCapabilities.setJavascriptEnabled(true);
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				objWebDriver = new InternetExplorerDriver(desiredCapabilities);
				objWebDriver.get(objStep.get("strInputValue").toString());
				// objWebDriver.navigate().to(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				// objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				// // objWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				break;
			case "chrome":
				switch (OSType()) {
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
				// TODO OperaDriver setup latest driver and test
				// desiredCapabilities = DesiredCapabilities.internetExplorer();
				// desiredCapabilities.setJavascriptEnabled(true);
				objWebDriver = new OperaDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				// objWebDriver.manage().window().maximize();
				// objWebDriver.manage().window().setPosition(new Point(0, 0));
				// Dimension dim = new Dimension(1382, 754);
				// objWebDriver.manage().window().setSize(dim);
				// // WebDriver objWebDriver;
				// Selenium selenium;
				// objWebDriver = new OperaDriver();
				// selenium = new WebDriverBackedSelenium(objWebDriver,
				// "https://www.google.com/");
				// return objWebDriver;
				break;
			default:
				throw new BrowserDriverNotSupportedException("Browser '" + objStep.get("strTagName").toString() + "' not supported");
			}
		} catch (Exception e) {
			logger("browserLaunch " + e.toString());
		} finally {
			// windowFocus(objWebDriver);
			objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
			elementCoordinates(objStep, objWebDriver, null);
			coordinateHighlightScreenshot(objStep, objWebDriver, null, objStep);
			objStep.put("blnStatus", true);

			// System.out.println(createStepActual(objStep,"LAUNCH"));

			lngTimeEnd = System.currentTimeMillis();
			objStep.put("strStepDuration", (lngTimeEnd - lngTimeStart));
			objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngTimeStart));
			objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngTimeEnd));
			objStep.put("strStepActual", createStepActual(objStep, "LAUNCH"));
			logger("browserLaunch finally Milliseconds Waited = " + objStep.get("strStepDuration").toString());
			// return objWebDriver;
		}
		return objWebDriver;
	} // the end of browserLaunch

	public static String clipboardGet() {
		String data = "";
		try {
			data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}// the end of ClipboardGet

	public static boolean isAlertPresent(WebDriver objWebDriver) {
		logger("isAlertPresent Start");
		try {
			// objWebDriver.switchTo().alert();
			// logger(objWebDriver.getTitle());
			// logger(objWebDriver.manage().window().getPosition());
			// logger(objWebDriver.manage().window().getSize());
			objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Alert alert = objWebDriver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		} catch (Exception e) {
			logger("isAlertPresent " + e.toString());
			return false;
		}
	}// the end of isAlertPresent()

	public static WebElement isAlertPresent2(WebDriver objWebDriver) throws ElementNotFoundException {
		try {

			Alert alert = objWebDriver.switchTo().alert();

			logger("isAlertPresent2 - alert switch to which did not fail:  " + alert.toString());
			// return (WebElement) alert;
			return null;
		} // try
		catch (NoAlertPresentException e) {
			logger("this is the alert switch to which did fail");
			logger(e.toString());
			throw new ElementNotFoundException("Alert popup was not found.");
		} // catch
	}

	public static boolean validateTagType(String strTagType) {
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

	@SuppressWarnings({ "unchecked", "unused" })
	public static WebElement elementFind(JSONObject objStep, WebDriver objWebDriver) throws ElementNotFoundException, MultipleElementsFoundException {
		long lngStartTimeElementFind = System.currentTimeMillis();
		// objWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.NANOSECONDS);
		Boolean blnSwitch = false;
		Boolean blnFound = false;
		String strXpath = "";
		try {
			int intFramesCount = 0;
			String strTagName;
			String strIndex = "";
			WebElement objWebElement;
			List<WebElement> objWebElementCollection = new ArrayList<WebElement>();
			List<WebElement> objFrameCollection = new ArrayList<WebElement>();
			List<WebElement> objTagNameCollection = new ArrayList<WebElement>();
			String strCurrentWindowHandle = objStep.get("strCurrentWindowHandle").toString();
			strTagName = objStep.get("strTagName").toString().toLowerCase();
			String arrAttributeNames[] = objStep.get("strAttributeNames").toString().split("\\|", -1);
			String arrAttributeValues[] = objStep.get("strAttributeValues").toString().split("\\|", -1);
			String strXpathAttributesTemp = "";
			String strXpathAttributes = "";
			String strWindowHandle = "";
			if (strTagName.toLowerCase().equals("alert")) {
				// TODO elementFind finish alert handling --- will need to consider issue where objWebDriver no longer exists maybe place this after setting window
				objStep.put("strTagType", "alert");
				return isAlertPresent2(objWebDriver);
			}
			if (strTagName.toLowerCase().equals("title")) {
				objStep.put("strTagType", "title");
				return null;
			}
			for (int intAttributeEach = 0; intAttributeEach < arrAttributeNames.length; intAttributeEach++) {
				strXpathAttributesTemp = "";
				switch (arrAttributeNames[intAttributeEach].toLowerCase()) {
				case "index":
					strIndex = "[" + arrAttributeValues[intAttributeEach] + "]";
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
						objStep.put("strType", arrAttributeValues[intAttributeEach]);
					}
					if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
						strXpathAttributesTemp = "contains(@" + arrAttributeNames[intAttributeEach] + ", '" + arrAttributeValues[intAttributeEach].substring(3) + "')";
					} else {
						strXpathAttributesTemp = "@" + arrAttributeNames[intAttributeEach] + "='" + arrAttributeValues[intAttributeEach] + "'";
					}
					break;
				}
				if (strXpathAttributesTemp.trim().length() != 0) {
					if (strXpathAttributes.trim().length() == 0) {
						strXpathAttributes = strXpathAttributesTemp;
					} else {
						strXpathAttributes = strXpathAttributes + " and " + strXpathAttributesTemp;
					}
				}
			}// for (int intAttributeEach
			if (strXpathAttributes.trim().length() == 0) {
				strXpathAttributes = "";
			} else {
				strXpathAttributes = "[" + strXpathAttributes + "]";
			}
			strXpath = "(//" + strTagName + strXpathAttributes + ")" + strIndex;
			// logger("elementFind strXpath = " + strXpath);
			// logger("elementFind before loop strCurrentWindowHandle = " + strCurrentWindowHandle);

			Object[] arrHandles = objWebDriver.getWindowHandles().toArray();
			// logger("elementFind arrHandles.length = " + arrHandles.length);

			for (int i = arrHandles.length - 1; i >= 0; i--) {
				logger("elementFind arrHandles[i] = " + arrHandles[i].toString());
			}
			// if (arrHandles.length == 2) {
			// logger("elementFind arrHandles[0] = " +arrHandles[0].toString());
			// logger("elementFind arrHandles[1] = " +arrHandles[1].toString());
			// }
			//
			// if (arrHandles.length == 1) {
			// logger("elementFind arrHandles[0] = " +arrHandles[0].toString());
			// }

			for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
				strWindowHandle = arrHandles[intHandlesEach].toString();

				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// objWebDriver.switchTo().window(strWindowHandle);
				// logger("elementFind intHandlesEach = " + intHandlesEach);
				// logger("elementFind lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// logger("elementFind objStep.get(\"inFrame\") = " + Integer.parseInt(objStep.get("intFrame").toString()));
				// logger("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				// logger("elementFind strWindowHandle = " + strWindowHandle);
				if (!strCurrentWindowHandle.equals(strWindowHandle)) {
					blnSwitch = true;
				} else {
					if (Integer.parseInt(objStep.get("intFrame").toString()) >= 0) {
						blnSwitch = true;
					}
				}
				if (blnSwitch == true) {
					objWebDriver.switchTo().window(strWindowHandle);
					// logger("elementFind Switched = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
					// logger("elementFind objWebDriver.getTitle = " + objWebDriver.getTitle());
					objStep.put("intFrame", -1);
					objWebDriver.manage().window().maximize();
				}

				// }
				// if (strCurrentWindowHandle.equals(strWindowHandle) ||
				// Integer.parseInt(objStep.get("intFrame").toString()) < 0) {
				// logger("elementFind No Switch = " +
				// (System.currentTimeMillis() - lngStartTimeSwitchTo));
				//
				// } else {
				// objWebDriver.switchTo().window(strWindowHandle);
				// logger("elementFind Switched = " +
				// (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// objStep.put("intFrame", -1);
				// // blnSwitchWindow = true;
				// }

				long intBrowserInnerWidth = 0;
				long intBrowserInnerHeight = 0;
				try {
					intBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
					intBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
					// logger("intBrowserInnerWidth = " + intBrowserInnerWidth);
					// logger("intBrowserInnerHeight = " + intBrowserInnerHeight);
				} catch (WebDriverException e) {
					throw new ElementNotFoundException("WebDriverException returned");
				} catch (Exception e) {
					// logger("BodyoffsetHeight = " + e.toString());
					intBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetWidth;");
					intBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetHeight;");
					// logger("BodyoffsetWidth = " + intBrowserInnerWidth);
					// logger("BodyoffsetHeight = " + intBrowserInnerHeight);
				}
				objStep.put("intBrowserInnerWidth", intBrowserInnerWidth);
				objStep.put("intBrowserInnerHeight", intBrowserInnerHeight);

				long lngStartTimegetElementsByTagName = System.currentTimeMillis();
				List<WebElement> objCollectionJS = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
				// logger("elementFind objCollectionJS = " + objCollectionJS.size() + " strTagName = " + strTagName + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName));
				if (objCollectionJS.size() > 0) {
					long lngStartTimeByXpath = System.currentTimeMillis();
					objWebElementCollection = objWebDriver.findElements(By.xpath(strXpath));
					// logger("elementFind objWebElementCollection.size = " + objWebElementCollection.size() + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeByXpath));
				}

				if (objWebElementCollection.size() == 0) {

					long lngStartTimeFrameCollection = System.currentTimeMillis();
					// objFrameCollection = objWebDriver.findElements(By.tagName("frame"));
					objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('frame');");

					// logger("elementFind Frames = " + objFrameCollection.size() + " MillisecondsWaitedFrame " + (System.currentTimeMillis() - lngStartTimeFrameCollection));

					objFrameCollection.addAll((List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('iframe');"));
					// objFrameCollection.addAll(objWebDriver.findElements(By.tagName("iframe")));
					intFramesCount = objFrameCollection.size();
					// logger("elementFind objFrameCollection = " + intFramesCount + " MillisecondsWaitedIframe " + (System.currentTimeMillis() - lngStartTimeFrameCollection));
					// if (intFramesCount >= 1) {intFramesCount = intFramesCount + 1;
					// logger("elementFind objFrameCollection = " + intFramesCount + "  " + (System.currentTimeMillis() - lngStartTimeFrameCollection));
					// }
					for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
						// logger("elementFind intFramesEach = " + intFramesEach);
						// if (intFramesEach >= 0) {
						long lngStartTimeSwitchToFrame = System.currentTimeMillis();
						objWebDriver.switchTo().defaultContent();
						objWebDriver.switchTo().frame(objFrameCollection.get(intFramesEach));
						objStep.put("intFrame", intFramesEach);
						logger("elementFind frames objWebDriver.getWindowHandle = " + objWebDriver.getWindowHandle() + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeSwitchToFrame));
						// }

						long lngStartTimegetElementsByTagName2 = System.currentTimeMillis();
						List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
						logger("elementFind objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));

						// long lngStartTimegetElementsByXpath = System.currentTimeMillis();
						// List<WebElement> objCollectionJS = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElements(By.xpath('" + strXpath + "');");
						// logger("elementFind objCollectionJS = " + objCollectionJS.size() + " " + (System.currentTimeMillis() - lngStartTimegetElementsByXpath));
						// jse.executeScript("document.getElement(By.xpath(\"//div[@class='btnContr']/input[@onclick='return cancel();']\")");

						// long lngStartTimeTagName = System.currentTimeMillis();
						// objTagNameCollection = objWebDriver.findElements(By.tagName(strTagName));
						// logger("elementFind objWebElementCollection.size = " + objTagNameCollection.size() + " MillisecondsWaitedTagName = " + (System.currentTimeMillis() - lngStartTimeTagName));

						// if (objCollectionJS.size() > 0) {
						// long lngStartTimeByTagNameByXpath = System.currentTimeMillis();
						// List<WebElement> objWebElementCollectionByTagNameByXpath = objCollectionJS.get(0).findElements(By.xpath(strXpath));
						// logger("elementFind objWebElementCollectionByTagNameByXpath.size = " + objWebElementCollectionByTagNameByXpath.size() + " MillisecondsWaitedTagName = " + (System.currentTimeMillis() - lngStartTimeByTagNameByXpath));
						// }

						// if (objCollectionJS.size() > 0) {
						//
						// JavascriptExecutor objJavascriptExecutor = null;
						// objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
						// long lngStartTimeJS = System.currentTimeMillis();
						// logger("JS value = " + objJavascriptExecutor.executeScript("return arguments[0].value;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						// lngStartTimeJS = System.currentTimeMillis();
						// logger("JS innerText = " + objJavascriptExecutor.executeScript("return arguments[0].innerText;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						// lngStartTimeJS = System.currentTimeMillis();
						// logger("JS innerHTML = " + objJavascriptExecutor.executeScript("return arguments[0].innerHTML;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						// lngStartTimeJS = System.currentTimeMillis();
						// logger("JS outerHTML = " + objJavascriptExecutor.executeScript("return arguments[0].outerHTML;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						//
						// }

						if (objCollectionJS2.size() > 0) {
							long lngStartTimeByXpath = System.currentTimeMillis();
							objWebElementCollection = objWebDriver.findElements(By.xpath(strXpath));
							// logger("elementFind objWebElementCollection.size = " + objWebElementCollection.size() + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeByXpath));
						}

						if (objWebElementCollection.size() > 0) {
							blnFound = true;
							break;
						}
					}
				} else if (objWebElementCollection.size() == 1) {
					break;

				}// the end of if (objWebElementCollection.size() == 0) {
			}// the end of for win Handles
			switch (objWebElementCollection.size()) {
			case 0:
				// logger("elementFind - Element properties did not return an element, try refining attributes.");
				throw new ElementNotFoundException("Element properties did not return an element, try refining attributes");
			case 1:
				blnFound = true;
				// logger(objWebElementCollection.get(0));
				objWebElement = objWebElementCollection.get(0);
				// long lngStartTimeGetXpath = System.currentTimeMillis();
				// logger("xpath = " + getElementXPath(objWebDriver, objWebElement) + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeGetXpath));

				// TODO add title and url to each element found in the objStep json
				// JavascriptExecutor js = (JavascriptExecutor) objWebDriver;
				// String strTitle = (String) js.executeScript("return document.title");
				// logger("main JavascriptExecutor strTitle  = " + strTitle + " intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimedocumenttitle));

				// logger("strCurrentWindowHandle = " + objStep.get("strCurrentWindowHandle").toString());
				// logger("objWebDriver.getWindowHandle = " + objWebDriver.getWindowHandle());

				objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
				if (objStep.get("strTagName").toString().toLowerCase().equals("input")) {
					if (objStep.get("strType").toString().toLowerCase().length() == 0) {
						objStep.put("strType", objWebElement.getAttribute("type"));
					}
					objStep.put("strTagType", "input_" + objStep.get("strType").toString());
				} else {
					objStep.put("strTagType", objStep.get("strTagName").toString());
				}
				return objWebElement;
			default:
				// logger("elementFind - Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
				throw new MultipleElementsFoundException("Element properties did not return an element, try refining attributes");
			}// the end of switch (objWebElementCollection.size())

		} catch (NoSuchFrameException e) {
			throw new ElementNotFoundException("elementFind " + e.toString());
		} finally {
			logger("elementFind finally strXpath = " + strXpath + " blnFound = " + blnFound + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementFind));
		}
	}// the end of elementFind

	public static String getElementXPath(WebDriver objWebDriver, WebElement objWebElement) {
		return (String) ((JavascriptExecutor) objWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", objWebElement);
	}

	@SuppressWarnings("unchecked")
	public static void elementCoordinates(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		long lngStartTimeElementCoordinates = System.currentTimeMillis();
		try {
			int intScrollbar = 0;
			Point objWebDriverPoint = objWebDriver.manage().window().getPosition();
			int intBrowserOuterX = objWebDriverPoint.x;
			int intBrowserOuterY = objWebDriverPoint.y;
			Dimension objWebDriverDimension = objWebDriver.manage().window().getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			objStep.put("intBrowserOuterX", intBrowserOuterX);
			objStep.put("intBrowserOuterY", intBrowserOuterY);
			objStep.put("intBrowserOuterWidth", intBrowserOuterWidth);
			objStep.put("intBrowserOuterHeight", intBrowserOuterHeight);
			if (objWebElement != null) {
				Coordinates objElementCoordinates = ((Locatable) objWebElement).getCoordinates();
				Point objElementPoint = objElementCoordinates.inViewPort();
				Dimension objElementDimension = objWebElement.getSize();
				objStep.put("intElementX", objElementPoint.x);
				objStep.put("intElementY", objElementPoint.y);
				objStep.put("intElementWidth", objElementDimension.width);
				objStep.put("intElementHeight", objElementDimension.height);
			}
			logger("elementCoordinates objStep.containsKey = " + objStep.containsKey("intElementX"));
			if (objStep.containsKey("intElementX")) {
				int intBrowserInnerWidth = Integer.parseInt(objStep.get("intBrowserInnerWidth").toString());
				int intBrowserInnerHeight = Integer.parseInt(objStep.get("intBrowserInnerHeight").toString());
				int intElementX = Integer.parseInt(objStep.get("intElementX").toString());
				int intElementY = Integer.parseInt(objStep.get("intElementY").toString());
				// int intElementWidth = Integer.parseInt(objStep.get("intElementWidth").toString());
				// int intElementHeight = Integer.parseInt(objStep.get("intElementHeight").toString());
				int intWindowBorder = (int) ((intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2);
				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (int) ((intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder);
				objStep.put("intElementScreenX", intElementScreenX);
				objStep.put("intElementScreenY", intElementScreenY);
			}
		} catch (Exception e) {
			logger(e.toString());
		} finally {
			logger("elementCoordinates finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinates));
		}
	}// the end of elementCoordinates

	public static boolean elementVisible(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotVisibleException {
		long lngStartTimeElementVisible = System.currentTimeMillis();
		Boolean blnVisible = false;
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("title")) {
				blnVisible = true;
				return true;
			}
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {

				if (isAlertPresent(objWebDriver) == true) {
					blnVisible = true;
					return true;
				} else {
					throw new ElementNotVisibleException("Alert popup was not found.");
				}
			}
			if (objWebElement.isDisplayed()) {
				elementCoordinates(objStep, objWebDriver, objWebElement);
				blnVisible = true;
				return true;

				// if (objStep.containsKey("intElementWidth")) {
				// int intElementWidth = Integer.parseInt(objStep.get("intElementWidth").toString());
				// int intElementHeight = Integer.parseInt(objStep.get("intElementHeight").toString());
				//
				// logger("elementVisible intElementWidth = " + intElementWidth);
				// logger("elementVisible intElementHeight = " + intElementHeight);
				//
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
			}// the end of if (objWebElement.isDisplayed())
		} finally {
			logger("elementVisible finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
		}
	}// the end of elementVisible

	public static boolean elementHidden(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotHiddenException {
		long lngStartTimeElementHidden = System.currentTimeMillis();
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {

				if (isAlertPresent(objWebDriver) == false) {
					return true;
				} else {
					throw new ElementNotHiddenException("Alert popup was not found.");
				}
			}
			if (objWebElement.isDisplayed() == false) {
				return true;
			} else {
				logger("elementHidden objWebElement.isDisplayed() = return true MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
				throw new ElementNotHiddenException("Element is displayed.");
			}// the end of if (objWebElement.isDisplayed())
		} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException e) {
			logger("elementHidden - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
			return true;
		} finally {
			logger("elementHidden finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
		}
	}// the end of elementHidden

	public static boolean elementEnabled(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotEnabledException {
		long lngStartTimeElementEnabled = System.currentTimeMillis();
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {

				if (isAlertPresent(objWebDriver) == true) {
					return true;
				} else {
					throw new ElementNotEnabledException("Alert popup was not found.");
				}
			}
			if (objWebElement.isEnabled()) {
				return true;
			} else {
				throw new ElementNotEnabledException("elementEnabled - Element is not enabled");
			}// the end of if (objWebElement.isEnabled())
		} finally {
			logger("elementEnabled finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementEnabled));
		}
	}// the end of elementEnabled

	public static boolean elementDisabled(WebElement objWebElement) throws ElementNotDisabledException {
		long lngStartTimeElementDisabled = System.currentTimeMillis();
		try {
			if (objWebElement.isEnabled()) {
				throw new ElementNotDisabledException("elementDisabled - Element is not disabled");
			} else {
				return true;
			}// the end of if (objWebElement.isEnabled())
		} finally {
			logger("elementDisabled finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementDisabled));
		}
	}// the end of elementDisabled

	// TODO elementVisible add check for class and css, commented code needs to
	// be tested
	// Function WebObjectEnabled()
	// On Error Resume Next
	// '******************************************************************************
	// 'Variables Declaration
	// '******************************************************************************
	// Dim strClassName
	// Dim arrClassNameDisabled
	// Dim arrClassNameEnabled
	// Dim intClassNameEach
	// Dim intClassNameDisabledEach
	// Dim intClassNameEnabledEach
	// Dim objWebObject
	// '******************************************************************************
	// 'Variable Assignment
	// '******************************************************************************
	// If blnObjectShouldRefresh = True Then
	// objObject.RefreshObject
	// End If
	// Set objWebObject = objObject.Object
	// ' list of classnames to disable the object seperated by '|'
	// strClassNameDisabled = "disabled-true"
	// 'list of classnames to enable the object seperated by '|'
	// strClassNameEnabled = "disabled-false"
	// strClassName = objWebObject.ClassName
	// arrClassName = Split(strClassName, " ")
	// arrClassNameDisabled = Split(strClassNameDisabled, "|")
	// arrClassNameEnabled = Split(strClassNameEnabled, "|")
	// '******************************************************************************
	// 'Process
	// '******************************************************************************
	// For intClassNameEach = 0 To UBound(arrClassName)
	// For intClassNameDisabledEach = 0 To UBound(arrClassNameDisabled)
	// 'check for a empty value in the case a pipe is left hanging
	// If Trim(arrClassName(intClassNameEach)) <> "" Then
	// If LCase(arrClassName(intClassNameEach)) =
	// LCase(arrClassNameDisabled(intClassNameDisabledEach)) Then
	// WebObjectEnabled = False
	// Err.Clear
	// On Error GoTo 0
	// Exit Function
	// End If
	// End If
	// Next
	// For intClassNameEnabledEach = 0 To UBound(arrClassNameEnabled)
	// If Trim(arrClassName(intClassNameEach)) <> "" Then
	// If LCase(arrClassName(intClassNameEach)) =
	// LCase(arrClassNameEnabled(intClassNameEnabledEach)) Then
	// WebObjectEnabled = True
	// Err.Clear
	// On Error GoTo 0
	// Exit Function
	// End If
	// End If
	// Next
	// Next
	//
	// ' If LCase(objWebObject.tagName) = "a" Then
	// ' If InStr(LCase(objWebObject.onclick), "return false") > 0 Then
	// ' WebObjectEnabled = False
	// ' Err.Clear
	// ' On Error GoTo 0
	// ' Exit Function
	// ' End If
	// '
	// ' If InStr(LCase(objWebObject.onclick), "return true") > 0 Then
	// ' WebObjectEnabled = True
	// ' Err.Clear
	// ' On Error GoTo 0
	// ' Exit Function
	// ' End If
	// ' End If
	//
	// If objWebObject.IsDisabled = True Then
	// WebObjectEnabled = False
	// Err.Clear
	// On Error GoTo 0
	// Exit Function
	// Else
	// WebObjectEnabled = True
	// End If
	// Set objWebObject = Nothing
	// Err.Clear
	// On Error GoTo 0
	// '******************************************************************************
	// 'EndFile
	// '******************************************************************************
	// End Function '==> WebObjectEnabled

	public static String elementGet(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementTagNameNotSupportedException {
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
				strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].innerHTML;return selection;", objWebElement);
				strElementGet = strElementGet.trim();
				return strElementGet;
			case "table":
				strElementGet = objWebElement.getText();
				return strElementGet;
			case "alert":
				Alert alert = objWebDriver.switchTo().alert();
				strElementGet = alert.getText();
				return strElementGet;
			default:
				strElementGet = "elementGet tag not supported";
				throw new ElementTagNameNotSupportedException("Element tag not supported");
			}
		} finally {
			logger("ElementGet finally strElementGet = {" + strElementGet + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementGet));
		}
	} // the end of ElementGet

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
	}// the end of syncTime

	@SuppressWarnings({ "serial", "unchecked" })
	public static void coordinateHighlightScreenshot(final JSONObject objStepHighlightArea, final WebDriver objWebDriver, final WebElement objWebElement, JSONObject objStep) {
		logger("coordinateHighlightScreenshot start");

		long lngStartTimeCoordinateHighlightScreenshot = System.currentTimeMillis();
		JFrame objJFrame = new JFrame() {
			{
				logger("coordinateHighlightScreenshot before Rectangle objHighlightArea");
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				if (Boolean.parseBoolean(objStepHighlightArea.get("blnHighlight").toString()) == true) {
					int intThickness = 5;
					Color objHighlightColor = null;
					logger("coordinateHighlightScreenshot before color switch");
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
					logger("coordinateHighlightScreenshot intThickness = " + intThickness);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					getRectangleAreaByName(objStepHighlightArea, intThickness, "", objHighlightArea, objWebDriver, objWebElement);
					setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
					setUndecorated(true);
					setBackground(new Color(0, 0, 0, 0));
					getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
					setVisible(true);
				}// the end of if (blnHighlight == true)
			}
		};
		int intSleepMilliseconds = 0;
		if (Boolean.parseBoolean(objStep.get("blnScreenshot").toString()) == true) {
			Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
			String strScreenshotFilePath = "";
			try {
				Robot robot = new Robot();
				getRectangleAreaByName(objStep, 0, objStep.get("strScreenshotArea").toString(), objHighlightArea, objWebDriver, objWebElement);
				BufferedImage screenShot = robot.createScreenCapture(objHighlightArea);
				strScreenshotFilePath = objStep.get("strScreenshotFilePath").toString() + "Screenshot_" + dateTimestamp() + ".jpg";
				Thread objThread = new Thread(new threadSaveImage(screenShot, "jpg", strScreenshotFilePath));
				objThread.start();
				objStep.put("strScreenshotFilePath", strScreenshotFilePath);
			} catch (AWTException e) {
				// TODO handle coordinateHighlightScreenshot AWTException
				logger("coordinateHighlightScreenshot " + e.toString());
			} catch (Exception e) {
				// TODO handle coordinateHighlightScreenshot Exception
				logger("coordinateHighlightScreenshot " + e.toString());
			}
		}// the end of if (blnScreenshot == true)
		if (Boolean.parseBoolean(objStep.get("blnHighlight").toString()) == true) {
			try {
				Thread.sleep(intSleepMilliseconds);
			} catch (InterruptedException e) {
				// TODO handle coordinateHighlightScreenshot InterruptedException
				logger("coordinateHighlightScreenshot " + e.toString());
			}
			objJFrame.setVisible(false);
			objJFrame.dispose();
		}
		logger("coordinateHighlightScreenshot MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeCoordinateHighlightScreenshot));
	}// the end of coordinateHighlightScreenshot

	public static void getRectangleAreaByName(JSONObject objStep, Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea, WebDriver objWebDriver, WebElement objWebElement) {
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
				strAreaObjectName = "screen";
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
				intX = Integer.parseInt(objStep.get("intElementScreenX").toString()) - intThickness;
				intY = Integer.parseInt(objStep.get("intElementScreenY").toString()) - intThickness;
				intWidth = Integer.parseInt(objStep.get("intElementWidth").toString()) + (2 * intThickness);
				intHeight = Integer.parseInt(objStep.get("intElementHeight").toString()) + (2 * intThickness);
				break;
			default:
				// TODO add reporting for default
				logger("getRectangleAreaByName default screen, window, page and element not " + strAreaObjectName);
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
			logger("getRectangleAreaByName finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeGetRectangleAreaByName));
		}
	}// the end of getRectangleAreaByName

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
			try {
				ImageIO.write(objScreenShot, strImageType.toUpperCase(), new File(strPathFileName));
			} catch (IOException e) {
				logger("threadSaveImage IOException = ");
			}
		}
	}// the end of threadSaveImage

	public static final String dateTimestamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}// the end of dateTimestamp

	public static final String currentTimeMillisToDateTimestamp(Long lngStartTimeMillis) {
		SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS");
		Date objFormattedDate = new Date(lngStartTimeMillis);
		logger(objSimpleDateFormat.format(objFormattedDate));
		return objSimpleDateFormat.format(objFormattedDate);
	}// the end of currentTimeMillisToDateTimestamp

	public static String getMonth(int month) {
		// return new DateFormatSymbols().setLocalPatternChars("es-MX");
		return new DateFormatSymbols().getMonths()[month];
	} // the end of getMonth

	public static void windowFocus(WebDriver objWebDriver) {
		// TODO debug objWebDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
		if (objWebDriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) objWebDriver).executeScript("window.focus();");
		}
	}// the end of windowFocus

	public static void scrollToBottom(WebDriver objWebDriver) {
		// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
		JavascriptExecutor executor = (JavascriptExecutor) objWebDriver;
		executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}// the end of scrollToBottom

	// Function DevelopmentModeSlideShow()
	// On Error Resume Next
	// ' strPath = ConstServerAttachmentPath
	// ' strFile = "RUN_" & ConstRunID
	// ' Set objRunList =
	// QCUtil.QCConnection.RunFactory.NewList("SELECT * FROM RUN WHERE RN_RUN_ID = "
	// & Chr(39) & ConstRunID & Chr(39))
	// strText = "<ASX Version = " & Chr(34) & "3.0" & Chr(34) & ">" & vbCrLf
	//
	// If UBound(arrSlideShow) >= 0 Then
	// ' If objRunList.Count >= 1 Then
	// '' Set objAttachmentList = objRunList.Item(1).Attachments.NewList("")
	// ' If objAttachmentList.Count >= 1 Then
	// For intAttachmentListEach = 0 To UBound(arrSlideShow)
	// strText = strText & "<ENTRY>" & vbCrLf
	// strText = strText & "<Duration value = " & Chr(34) & "00:00:3.000" &
	// Chr(34) & " />" & vbCrLf
	// strText = strText & "  <REF HREF = " & Chr(34) &
	// arrSlideShow(intAttachmentListEach) & Chr(34) & " />" & vbCrLf
	// strText = strText & "</ENTRY>" & vbCrLf
	// Next
	// End If
	// ' End If
	//
	// strText = strText & "</ASX>"
	// strFullPath = gstrDragonflyPathFolderLocal & "Playlist.asx"
	// FileCreate strFullPath, strText
	// strFullAttachPath = strFullPath
	//
	// If Environment("TestExecutionSource") <> "QTP" Then
	// ' strFile = "RUN_" & ConstRunID
	// ' If Environment("TestExecutionSource") <> "QTP" Then
	// strFullAttachPath = AttachmentSaveToRun(strFullPath,
	// "Playlist of screen shots for this run")
	// CurrentTestInstanceFieldSet "Playlist", strFullAttachPath
	// CurrentRunFieldSet "Playlist", strFullAttachPath
	// ' End If
	// End If
	//
	// ReporterModify micDone, "Slide Show Run " & ConstRunID, Joseph &
	// " <a href=" & Chr(34) & strFullAttachPath & Chr(34) & " />" &
	// strFullAttachPath & "</a><br /><br />" & EmbedVideo(strFullAttachPath)
	//
	// ' Set objRunList = Nothing
	// ' Set objAttachmentListItem = Nothing
	// Err.Clear
	// On Error GoTo 0
	// End Function
	//
	// Function EmbedVideo(strFullPath)
	// strText = strText & "<OBJECT id=" & Chr(34) & "VIDEO" & Chr(34) &
	// " width=" & Chr(34) & ConstScreenWidth * 0.85 & Chr(34) & " height=" &
	// Chr(34) & ConstScreenHeight * 0.85 & Chr(34) & " CLASSID=" & Chr(34) &
	// "CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" & Chr(34) & " type=" &
	// Chr(34) & "application/x-oleobject" & Chr(34) & ">"
	// strText = strText & "<PARAM NAME=" & Chr(34) & "URL" & Chr(34) &
	// " VALUE=" & Chr(34) & strFullPath & Chr(34) & ">"
	// strText = strText & "<PARAM NAME=" & Chr(34) &
	// "SendPlayStateChangeEvents" & Chr(34) & " VALUE=" & Chr(34) & "False" &
	// Chr(34) & ">"
	// strText = strText & "<PARAM NAME=" & Chr(34) & "AutoStart" & Chr(34) &
	// " VALUE=" & Chr(34) & "True" & Chr(34) & ">"
	// strText = strText & "<PARAM NAME=" & Chr(34) & "uiMode" & Chr(34) &
	// " value=" & Chr(34) & "none" & Chr(34) & ">"
	// strText = strText & "<PARAM NAME=" & Chr(34) & "PlayCount" & Chr(34) &
	// " value=" & Chr(34) & "9999" & Chr(34) & ">"
	// strText = strText & "<PARAM NAME=" & Chr(34) & "VideoBorderColor" &
	// Chr(34) & " value=" & Chr(34) & "False" & Chr(34) & "></OBJECT>"
	// EmbedVideo = strText
	// End Function

	public static void writeLogger(String file) {
		try {
			BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(file));
			objBufferedWriter.write(Dragonfly.strLog);
			objBufferedWriter.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}// the end of writeLogger

	public static void writeJsonToHtml(JSONArray objTestSteps, String file) {
		StringBuilder builder = new StringBuilder();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			builder.append("<!DOCTYPE html>");
			builder.append("<html lang=\"en\">");
			builder.append("<head><title>Dragonfly steps</title></head>");
			builder.append("<body><h1>");
			builder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
			builder.append("<tr>");
			builder.append("<td>Step</td>");
			builder.append("<th>strAction</th>");
			builder.append("<th>strTagName</th>");
			builder.append("<th>strAttributeNames</th>");
			builder.append("<th>strAttributeValues</th>");
			builder.append("<th>strInputValue</th>");
			builder.append("<th>strLogicalName</th>");
			builder.append("<th>intMillisecondsToWait</th>");
			builder.append("<th>blnOptional</th>");
			builder.append("<th>strAssert</th>");
			builder.append("<th>blnPleaseWait</th>");
			builder.append("<th>blnHighlight</th>");
			builder.append("<th>blnScreenshot</th>");
			builder.append("<th>strFunction</th>");
			builder.append("<th>strAssistiveProperties</th>");
			builder.append("<th>blnExitOnFail</th>");
			builder.append("<th>strOutputLinkName</th>");
			builder.append("<th>strOutputValue</th>");
			builder.append("<th>intLoop</th>");
			builder.append("</tr>");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				// logger(intTestStepRow);
				JSONObject objStep = (JSONObject) objTestSteps.get(intTestStepRow);
				builder.append("</tr>");
				builder.append("<td> " + (intTestStepRow + 1) + "</td>");
				builder.append("<td> " + objStep.get("strAction").toString() + "</td>");
				builder.append("<td> " + objStep.get("strTagName").toString() + "</td>");
				builder.append("<td> " + objStep.get("strAttributeNames").toString() + "</td>");
				builder.append("<td> " + objStep.get("strAttributeValues").toString() + "</td>");
				builder.append("<td> " + objStep.get("strInputValue").toString() + "</td>");
				builder.append("<td> " + objStep.get("strLogicalName").toString() + "</td>");
				builder.append("<td> " + objStep.get("intMillisecondsToWait").toString() + "</td>");
				builder.append("<td> " + objStep.get("blnOptional").toString() + "</td>");
				builder.append("<td> " + objStep.get("strAssert").toString() + "</td>");
				builder.append("<td> " + objStep.get("blnPleaseWait").toString() + "</td>");
				builder.append("<td> " + objStep.get("blnHighlight").toString() + "</td>");
				builder.append("<td> " + objStep.get("blnScreenshot").toString() + "</td>");
				builder.append("<td> " + objStep.get("strFunction").toString() + "</td>");
				builder.append("<td> " + objStep.get("strAssistiveProperties").toString() + "</td>");
				builder.append("<td> " + objStep.get("blnExitOnFail").toString() + "</td>");
				builder.append("<td> " + objStep.get("strOutputLinkName").toString() + "</td>");
				builder.append("<td> " + objStep.get("strOutputValue").toString() + "</td>");
				builder.append("<td> " + objStep.get("intLoop").toString() + "</td>");
				builder.append(" </tr>  ");
			}
			builder.append("</table>");
			builder.append("</h1></body>");
			builder.append("</html>");
			String html = builder.toString();
			logger(file);
			bw.write(html);
		} catch (Exception e) {
			logger(builder.toString());
			logger(e.toString());
		}
	}// the end of writeJsonToHtml

	public static void writeJsonStepsAfterRunToHtml(JSONArray objTestSteps, String strFile) {
		String strKeys = "intBrowserOuterHeight|strOutputLinkName|intBrowserInnerWidth|strType|intBrowserOuterX|intBrowserOuterY|strFunction";
		strKeys = strKeys + "|strAttributeValues|blnHighlight|intElementX|strScreenshotFilePath|intElementY|strAssert|intLoop|strAssistiveProperties";
		strKeys = strKeys + "|intElementHeight|intElementScreenY|strAttributeNames|strLogicalName|intElementScreenX|strStepActual|strOutputValue";
		strKeys = strKeys + "|strAction|strScreenshotArea|strStartTimestamp|strTagType|intMillisecondsToWait|intElementWidth|intBrowserOuterWidth";
		strKeys = strKeys + "|blnOptional|strCurrentWindowHandle|strStepExpected|blnScreenshot|blnExitOnFail|intFrame|intBrowserInnerHeight";
		strKeys = strKeys + "|strEndTimestamp|blnPleaseWait|strStepDuration|strInputValue|strTagName|strStatus";
		String strKey = "";
		String[] arrKeys;
		arrKeys = strKeys.split("\\|");
		StringBuilder builder = new StringBuilder();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strFile));) {
			builder.append("<!DOCTYPE html>");
			builder.append("<html lang=\"en\">");
			builder.append("<head><title>Dragonfly Steps After Run</title></head>");
			builder.append("<body><h1>");
			builder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
			builder.append("<tr>");
			builder.append("<td>Step</td>");
			for (int intKeysEach = 0; intKeysEach < arrKeys.length - 1; intKeysEach++) {
				strKey = (String) arrKeys[intKeysEach].toString();
				builder.append("<th>" + strKey + "</th>");
			}
			builder.append(" </tr>  ");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				builder.append("</tr>");
				builder.append("<td> " + (intTestStepRow + 1) + "</td>");
				JSONObject objStep = (JSONObject) objTestSteps.get(intTestStepRow);
				for (int intKeysEach = 0; intKeysEach < arrKeys.length - 1; intKeysEach++) {
					strKey = (String) arrKeys[intKeysEach].toString();
					if (objStep.containsKey(strKey) == true) {
						builder.append("<td> " + objStep.get(strKey) + "</td>");
					} else {
						builder.append("<td>  &nbsp; </td>");
					}
				}
				builder.append(" </tr>  ");
			}
			builder.append("</table>");
			builder.append("</h1></body>");
			builder.append("</html>");
			String html = builder.toString();
			logger(strFile);
			bw.write(html);
		} catch (Exception e) {
			logger(builder.toString());
			logger(e.toString());
		}
	}// the end of writeJsonStepsAfterRunToHtml

	public static void writeReportToHtml(JSONArray objTestSteps, String strFile) {
		long lngStartTimeWriteReportToHtml = System.currentTimeMillis();
		String strScreenshotFilePath = "";
		StringBuilder objStringBuilder = new StringBuilder();
		BufferedWriter objBufferedWriter = null;
		String strColor = "";
		String strStatusIcon = "";
		String strStatus = "";
		try {
			objBufferedWriter = new BufferedWriter(new FileWriter(strFile));
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
				objStringBuilder.append("<TD align=left valign=middle>" + createStepExpected(objStep) + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=150px align=left valign=middle>Start:" + strStartTimestamp + "<br>End: " + strEndTimestamp + "<br>Duration: " + strStepDuration + " ms</TD>");

				objStringBuilder.append("</TR>");
				objStringBuilder.append("<TR>");

				objStringBuilder.append("<TD align=center valign=middle>Actual</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objStep.get("strStepActual").toString() + "</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("</TABLE> ");
				if (objStep.get("strScreenshotFilePath").toString().trim().length() != 0) {
					strScreenshotFilePath = objStep.get("strScreenshotFilePath").toString().replaceAll("\\\\\\\\", "\\");
					objStringBuilder.append("<IMG alt=\"ReporterScreenShot_1\" src=\"" + strScreenshotFilePath + "\" width=1100 height=700> ");
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
			logger("writeReportToHtml - " + e.toString());
			logger(objStringBuilder.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			// logger(objStringBuilder.toString());
			try {
				String strHTML = objStringBuilder.toString();
				logger(strHTML);
				objBufferedWriter.write(strHTML);
				objBufferedWriter.close();
			} catch (Exception e2) {
				logger("writeReportToHtml - IOException" + e2.getMessage());
			}
			logger("writeReportToHtml finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeWriteReportToHtml));
		}
	}// the end of writeReportToHtml

	public static String createStepExpected(JSONObject objStep) {
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

	public static String createStepActual(JSONObject objStep, String strStepType) {
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
		case "break":
			break;
		}
		strActualHtml = "<DIV align='left/>" + strActualHtml + "</DIV>";
		return strActualText;
	}

	// Function DetailsHTML(objObjectDetailsHTML, strStepAction, strStepParameterName, strActualReturn, intWaited)
	// On Error Resume Next
	// strObjectToString = objObjectDetailsHTML.GetTOProperty("TestObjGenType")
	// strToString = strStepParameterName & " " & strObjectToString
	// strInputParameterValue = strParameterValue
	// strOutputParameterValueHTML = FormatHTML(strOutputParameterValue)
	// strInputParameterValueHTML = FormatHTML(strInputParameterValue)
	// strActualReturnHTML = FormatHTML(strActualReturn)
	// Select Case UCase(strStepAction)
	// Case "DEFAULT"
	// DetailsHTML = "The <b>" & strToString & " </b> default value is {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>}."
	// strDetailsNoHTML = "The expected " & strToString & " default value is " & strOutputParameterValue& "."
	// Case "CLICKED"
	// DetailsHTML = "The expected <b>" & strToString & "</b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strInputParameterValueHTML & "</FONT></b>} was clicked."
	// strDetailsNoHTML = "The expected " & strToString & "  value {" & strInputParameterValue & "} was clickecase / Case "EXPECTED"
	// DetailsHTML = "The expected <b>" & strToString & "</b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strInputParameterValueHTML & "</FONT></b>} was not verified.<BR>The actual value was {<b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & ">" & strActualReturnHTML & "</FONT></b>}."
	// strDetailsNoHTML = "The expected " & strToString & " value {" & strInputParameterValue & "} was not verified.  The actual value was {" & strActualReturn & "}."
	// Case "EXPECTEDTOOLTIP"
	// DetailsHTML = "The expected <b>" & strToString & "</b>  tooltip value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strInputParameterValueHTML & "</FONT></b>} was not verified.<BR>The actual value was {<b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & ">" & strActualReturnHTML & "</FONT></b>}."
	// strDetailsNoHTML = "The expected " & strToString & " tooltip value {" & strInputParameterValue & "} was not verified.  The actual value was {" & strActualReturn & "}."
	// Case "FIND"
	// DetailsHTML = "The expected <b>" & strToString & "</b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b><b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & "></FONT></b>} was found."
	// strDetailsNoHTML = "The expected " & strToString & "  value {" & strOutputParameterValue & "} was found."
	// Case "NOTFOUND"
	// DetailsHTML = "The expected <b>" & strToString & "</b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b><b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & "></FONT></b>} was not found."
	// strDetailsNoHTML = "The expected " & strToString & " value {" & strOutputParameterValue & "} was not found."
	// Case "VERIFY"
	// DetailsHTML = "The expected <b>" & strToString & "</b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b><b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & "></FONT></b>} was verified."
	// strDetailsNoHTML = "The expected " & strToString & " value {" & strOutputParameterValue & "} was verified."
	// Case "VERIFYTOOLTIP"
	// DetailsHTML = "The expected <b>" & strToString & "</b> tooltip value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b><b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & "></FONT></b>} was verified."
	// strDetailsNoHTML = "The expected " & strToString & " tooltip value {" & strOutputParameterValue & "} was verified."
	// Case "GET"
	// DetailsHTML = "The <b>" & strToString & " </b> actual value is {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>}."
	// strDetailsNoHTML = "The " & strToString & " actual value is {" & strOutputParameterValue & "}"
	// Case "GETTOOLTIP"
	// DetailsHTML = "The <b>" & strToString & " </b> tooltip actual value is {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>}."
	// strDetailsNoHTML = "The " & strToString & " tooltip actual value is {" & strOutputParameterValue & "}"
	// Case "SET"
	// DetailsHTML = "The expected <b>" & strToString & " </b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strInputParameterValueHTML & "</FONT></b>} was set."
	// strDetailsNoHTML = "The expected " & strToString & " value {" & strInputParameterValue & "} was set."
	// Case "PERSISTED"
	// DetailsHTML = "The expected <b>" & strToString & " </b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} persisted."
	// strDetailsNoHTML = "The expected " & strToString & " value {" & strOutputParameterValue & "} persisted."
	// Case "PASSWORD"
	// DetailsHTML = "The <b>" & strToString & " </b> password value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} was set."
	// strDetailsNoHTML = "The " & strToString & " password value {" & strOutputParameterValue & "} was set."
	// Case "NOTPERSISTED"
	// DetailsHTML = "The expected <b>" & strToString & " </b> value  {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strInputParameterValueHTML & "</FONT></b>} did not persist.<BR>The actual value {<b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & ">" & strActualReturnHTML & "</FONT></b>} was displayed."
	// strDetailsNoHTML = "The expected " & strToString & " value {" & strInputParameterValue & "} did not persist.  The actual value {" & strActualReturn & "} was displayed."
	// Case "EXIST"
	// DetailsHTML = "The expected <b>" & strToString & "</b> exists."
	// strDetailsNoHTML = "The expected " & strToString & " exists."
	// Case "NOTEXIST"
	// DetailsHTML = "The expected <b>" & strToString & "</b> does not exist after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " does not exist after " & intWaited & " milliseconds."
	// Case "NOTEXISTTOOLTIP"
	// DetailsHTML = "The expected <b>" & strToString & "</b> tooltip does not exist after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " tooltip does not exist after " & intWaited & " milliseconds."
	// Case "INVISIBLE"
	// DetailsHTML = "The expected <b>" & strToString & "</b> <b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & "></FONT></b> is invisible."
	// strDetailsNoHTML = "The expected " & strToString & " is invisible."
	// Case "ENABLED"
	// DetailsHTML = "The expected <b>" & strToString & "</b> <b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & "></FONT></b> is enabled."
	// strDetailsNoHTML = "The expected " & strToString & " is enabled."
	// Case "DISABLED"
	// DetailsHTML = "The expected <b>" & strToString & "</b> <b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & "></FONT></b> is disabled."
	// strDetailsNoHTML = "The expected " & strToString & " is disabled."
	// Case "VISIBLE"
	// DetailsHTML = "The expected <b>" & strToString & "</b> <b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & "></FONT></b> is visible."
	// strDetailsNoHTML = "The expected " & strToString & " is visible."
	// Case "HIDDEN"
	// DetailsHTML = "The expected <b>" & strToString & "</b> <b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & "></FONT></b> is hidden."
	// strDetailsNoHTML = "The expected " & strToString & " is hidden."
	// Case "SYNCNOTEXISTS"
	// DetailsHTML = "The expected <b>" & strToString & "</b></b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} does not exist after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} does not exist after " & intWaited & " milliseconds."
	// Case "SYNCEXISTS"
	// DetailsHTML = "The expected <b>" & strToString & "</b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} exists after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} exists after " & intWaited & " milliseconds."
	// Case "SYNCCLOSED"
	// DetailsHTML = "The expected <b>" & strToString & "</b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} closed after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} closed after " & intWaited & " milliseconds."
	// Case "SYNCNOTCLOSED"
	// DetailsHTML = "The expected <b>" & strToString & "</b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} did not close after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} did not close after " & intWaited & " milliseconds."
	// Case "SYNCHIDDEN"
	// DetailsHTML = "The expected <b>" & strToString & "</b></b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} does not exist after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} does not exist after " & intWaited & " milliseconds."
	// Case "SYNCVISIBLE"
	// DetailsHTML = "The expected <b>" & strToString & "</b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} exists after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} exists after " & intWaited & " milliseconds."
	// Case "SYNCOPTIONAL"
	// DetailsHTML = "The expected <b>" & strToString & "</b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} sync is optional after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} exists after " & intWaited & " milliseconds."
	// Case "SYNCDISABLED"
	// DetailsHTML = "The expected <b>" & strToString & "</b></b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} does not exist after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} does not exist after " & intWaited & " milliseconds."
	// Case "SYNCENABLED"
	// DetailsHTML = "The expected <b>" & strToString & "</b> {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} exists after " & intWaited & " milliseconds."
	// strDetailsNoHTML = "The expected " & strToString & " {" & strOutputParameterValue & "} exists after " & intWaited & " milliseconds."
	// Case "NAVIGATE"
	// DetailsHTML = "The expected <b>" & strToString & " </b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strOutputParameterValueHTML & "</FONT></b>} was set.<BR>No validation performed due to navigation."
	// strDetailsNoHTML = "The expected " & strToString & " value {" & strOutputParameterValue & "} was set. No validation performed due to navigation."
	// Case "KEYSTROKE"
	// DetailsHTML = "The expected <b>" & strToString & "</b>  value {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strInputParameterValueHTML & "</FONT></b>} was pressed."
	// strDetailsNoHTML = "The expected " & strToString & "  value {" & strInputParameterValue & "} was pressed."
	// Case "NOTINLIST"
	// DetailsHTML = "The list item {<b><FONT COLOR=" & Chr(34) & "008000" & Chr(34) & ">" & strInputParameterValueHTML & "</FONT></b>} does not exist in the <b>" & strStepParameterName & "</b> list field.<BR>Please confirm the input value against the actual list values {<b><FONT COLOR=" & Chr(34) & "FF0000" & Chr(34) & ">" & strActualReturnHTML & "</FONT></b>} is available for this field."
	// strDetailsNoHTML = "The list item {" & strInputParameterValue & "} does not exist in the " & strParameterName & " list field.  Please confirm the input value against the actual list values {" & strActualReturn & "} is available for this field."
	// End Select
	// DetailsHTML = "<DIV align=" & Chr(34) & "left" & Chr(34) & ">" & DetailsHTML & "</DIV>"
	// On Error GoTo 0
	// End Function

	// Function CreateStepDataTableRow()
	// CreateStepDataTableRow = "Step " & intDataTableStep & " row " & intDataTableRow & " "
	// End Function
	//
	//
	// Function CreateStepNameGetToolTip()
	// strStepName = CreateStepDataTableRow & "get " & ObjectName & " " & strObjectMicClass & " tooltip value" & " within " & intWait & " seconds"
	// CreateStepNameGetToolTip = strStepName
	// End Function
	//
	// Function CreateStepNameVerifyToolTip()
	// strStepName = CreateStepDataTableRow & "verify " & ObjectName & " " & strObjectMicClass & " tooltip value is equal to {" & strParameterValue & "}" & " within " & intWait & " seconds"
	// CreateStepNameVerifyToolTip = strStepName
	// End Function
	//
	// Function CreateStepNameExistsToolTip()
	// strStepName = CreateStepDataTableRow & "verify " & ObjectName & " " & strObjectMicClass & " tooltip value exists within " & intWait & " seconds"
	// CreateStepNameExistsToolTip = strStepName
	// End Function
	//
	//
	// Function CreateStepNameSetClicked()
	// strStepName = CreateStepDataTableRow & "set " & ObjectName & " " & strObjectMicClass & " to value {Clicked}" & " within " & intWait & " seconds"
	// CreateStepNameSetClicked = strStepName
	// End Function
	//
	// Function CreateStepNameSetPassword()
	// strStepName = CreateStepDataTableRow & "set " & ObjectName & " " & strObjectMicClass & " to password value {" & strParameterValue & "}" & " within " & intWait & " seconds"
	// CreateStepNameSetPassword = strStepName
	// End Function
	//
	// Function CreateStepNameVerifyObjectState()
	// strStepName = CreateStepDataTableRow & "verify " & ObjectName & " " & strObjectMicClass & " object state is  {" & strParameterValue & "}" & " within " & intWait & " seconds"
	// CreateStepNameVerifyObjectState = strStepName
	// End Function
	//
	// Function CreateStepNameSync()
	// strStepName = CreateStepDataTableRow & "sync " & ObjectName & " " & strObjectMicClass & " within " & intWait & " seconds"
	// CreateStepNameSync = strStepName
	// End Function
	//
	// Function CreateStepNameSyncOptional()
	// strStepName = CreateStepDataTableRow & "sync optional " & ObjectName & " " & strObjectMicClass & " within " & intWait & " seconds"
	// CreateStepNameSyncOptional = strStepName
	// End Function
	//

	public static void writeJsonToFile(JSONObject objJsonFile, String file) {
		try {
			// file = new File(strResultsPath + "UpdatedJson.json");
			// writeJsonKeysToHtml(JSONObject objTestStep, file);
			BufferedWriter out;
			out = new BufferedWriter(new FileWriter(file));
			out.write(objJsonFile.toString());
			out.close();

		} catch (IOException e) {
			logger("main final " + e.toString());
		}
	}// the end of writeJsonKeysToHtml
		// TODO Learn how to iterate over jason keys

	public static void writeJsonKeysToHtml(JSONObject objTestStep, String file) throws IOException {
		for (Iterator iterator = objTestStep.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			logger(key + " = " + objTestStep.get(key));
		}
	}// the end of writeJsonKeysToHtml

	// TODO webElementCollectionTable send output to html file
	public static void webElementCollectionTable(String strTagName, WebDriver objWebDriver) {
		int intCount = 0;
		JSONObject objStepNew = null;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		logger("webElementCollectionTable lngStartTimeSwitchTo = " + objWebDriver.getTitle());
		objWebDriver.switchTo().defaultContent();
		for (String winHandle : objWebDriver.getWindowHandles()) {
			intCount = 0;
			// logger("elementFind strCurrentWindowHandle = " +
			// strCurrentWindowHandle);
			logger("webElementCollectionTable winHandle = " + winHandle);
			long lngStartTimeSwitchTo = System.currentTimeMillis();
			// if (strCurrentWindowHandle.equals(winHandle)) {
			// } else {
			objWebDriver.switchTo().window(winHandle);
			logger("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			logger("webElementCollectionTable lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
			// }
			logger("webElementCollectionTable lngStartTimeSwitchTo = " + objWebDriver.getTitle());
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
				logger("getTagName:= '" + row.getTagName() + "'");
				// logger("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
				// logger("TagName:= '" + row.getAttribute("TagName") + "'");
				// logger("type:= '" + row.getAttribute("type") + "'");
				// logger("Type:= '" + row.getAttribute("Type") + "'");
				// logger("TYPE:= '" + row.getAttribute("TYPE") + "'");
				// logger("id:= '" + row.getAttribute("id") + "'");
				// logger("name:= '" + row.getAttribute("name") + "'");
				// logger("text:= '" + row.getAttribute("text") + "'");
				logger("getText:= '" + row.getText() + "'");
				// logger("innerText:= '" + row.getAttribute("innerText") + "'");
				// logger("outerText:= '" + row.getAttribute("outerText") + "'");
				// logger("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
				logger("outerHTML:= '" + row.getAttribute("outerHTML") + "'");
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
				// // TODO Auto-generated catch block
				// // e.printStackTrace();
				// }
			}
		}
	} // the end of webElementCollectionTable

	public static void webElementCollectionAttributes(String strTagName, WebDriver objWebDriver) {
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
	} // the end of webElementCollectionAttributes

	public static void webElementAttributes(WebElement objWebElement) {
		logger("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementAttributes ");
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
	} // the end of webElementAttributes

	// public class JavascriptActions extends Actions {
	//
	// final protected WebDriver webDriver;
	//
	// final protected JavascriptExecutor javascriptExecutor;
	//
	// @Inject
	// public JavascriptActions(WebDriver webDriver) {
	// super(webDriver);
	// this.webDriver = webDriver;
	// javascriptExecutor = (JavascriptExecutor) webDriver;
	// }
	//
	// public JavascriptActions click(JQuery target) {
	// mouseClick(target, MouseButton.LEFT);
	// return this;
	// }
	//
	// public JavascriptActions ctrlCopy(JQuery target) {
	// int keyCode = Keycode.C.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlCut(JQuery target) {
	// int keyCode = Keycode.X.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlPaste(JQuery target) {
	// int keyCode = Keycode.V.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlD(JQuery target) {
	// int keyCode = Keycode.D.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlDelete(JQuery target) {
	// int keyCode = Keycode.DELETE.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlFontBold(JQuery target) {
	// int keyCode = Keycode.B.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlFontItalic(JQuery target) {
	// int keyCode = Keycode.I.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlFontUnderline(JQuery target) {
	// int keyCode = Keycode.U.intValue();
	// ctrlKeyDown(target, keyCode);
	// ctrlKeyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions enter(JQuery target) {
	// int keyCode = Keycode.ENTER.intValue();
	// keyDown(target, keyCode);
	// keyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions esc(JQuery target) {
	// int keyCode = Keycode.ESC.intValue();
	// keyDown(target, keyCode);
	// keyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions delete(JQuery target) {
	// int keyCode = Keycode.DELETE.intValue();
	// keyDown(target, keyCode);
	// keyUp(target, keyCode);
	// return this;
	// }
	//
	// public JavascriptActions ctrlKeyDown(JQuery target, int combinationKeyCode) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.KEYDOWN, combinationKeyCode, MouseButton.IGNORE, new CompundKey[] { CompundKey.CTRL }, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions ctrlKeyUp(JQuery target, int combinationKeyCode) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.KEYUP, combinationKeyCode, MouseButton.IGNORE, new CompundKey[] { CompundKey.CTRL }, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions shiftKeyUp(JQuery target, int combinationKeyCode) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.KEYUP, combinationKeyCode, MouseButton.IGNORE, new CompundKey[] { CompundKey.SHIFT }, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions shiftKeyDown(JQuery target, int combinationKeyCode) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.KEYDOWN, combinationKeyCode, MouseButton.IGNORE, new CompundKey[] { CompundKey.SHIFT }, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions mouseDown(JQuery target, MouseButton type, CompundKey... compundKeys) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.MOUSEDOWN, -1, type, compundKeys, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions mouseUp(JQuery target, MouseButton type, CompundKey... compundKeys) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.MOUSEUP, -1, type, compundKeys, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions mouseClick(JQuery target, MouseButton type, CompundKey... compundKeys) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.CLICK, -1, type, compundKeys, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions contextClick(JQuery target) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.CONTEXTMENU, -1, MouseButton.RIGHT, null, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions mouseOver(JQuery target, MouseButton type) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.MOUSEOVER, -1, type, null, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions mouseMove(JQuery target, MouseButton type) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.MOUSEMOVE, -1, type, null, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions mouseMove(JQuery target, MouseButton type, int xOffset, int yOffset) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.MOUSEMOVE, -1, type, null, xOffset, yOffset)));
	// return this;
	// }
	//
	// public JavascriptActions mouseMove(int xOffset, int yOffset, JQuery target, MouseButton type) {
	// return this;
	// }
	//
	// public JavascriptActions keyDown(JQuery target, int keyCode) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.KEYDOWN, keyCode, MouseButton.IGNORE, null, 0, 0)));
	// return this;
	// }
	//
	// public JavascriptActions keyUp(JQuery target, int keyCode) {
	// action.addAction(new ScriptAction(triggerEventScript(target, EventType.KEYUP, keyCode, MouseButton.IGNORE, null, 0, 0)));
	// return this;
	// }
	//
	// private String triggerEventScript(JQuery target, EventType eventType, int combinationKeyCode, MouseButton type, CompundKey[] compundKeys, int xOffset, int yOffset) {
	// final String eventName = eventType.toString();
	// Set<CompundKey> keys = compundKeys == null ? Collections.EMPTY_SET : ImmutableSet.copyOf(compundKeys);
	//
	// String script = "var evt = jq.Event('%eventName');" + " evt.keyCode = %evtKeyCode; evt.metaKey = %evtMetaKey; evt.ctrlKey = %evtCtrlKey; evt.shiftKey = %evtShiftKey;" + " evt.which = %evtWhich;" + "jq(%domTarget).trigger(evt);";
	//
	// script = script.replace("%domTarget", target.elementScript());
	// script = script.replace("%eventName", eventName);
	// if (combinationKeyCode < 0)
	// script = script.replace("evt.keyCode = %evtKeyCode;", "");
	// else
	// script = script.replace("%evtKeyCode", "" + combinationKeyCode);
	// int which = type.getWhich();
	// if (which < 0) {
	// script = script.replace("evt.which = %evtWhich;", "");
	// } else {
	// String offsetScript = "var ofs = " + target.zk().revisedOffsetScript();
	// script = script.replace("%evtWhich;", "" + which + "; " + offsetScript + " evt.pageX=ofs[0]+" + xOffset + ";evt.pageY=ofs[1]+" + yOffset + ";evt.clientX=ofs[0]+ " + xOffset + ";evt.clientY=ofs[1]+ " + yOffset + ";");
	// }
	// boolean ctrlKey = keys.contains(CompundKey.CTRL), shiftKey = keys.contains(CompundKey.SHIFT);
	// script = script.replace("%evtCtrlKey", Boolean.valueOf(ctrlKey).toString());
	// script = script.replace("%evtShiftKey", Boolean.valueOf(shiftKey).toString());
	// script = script.replace("%evtMetaKey", Boolean.valueOf(ctrlKey || shiftKey).toString());
	// return script;
	// }
	//
	// private class ScriptAction implements Action {
	// String script;
	//
	// public ScriptAction(String script) {
	// this.script = script;
	// }
	//
	// public void perform() {
	// javascriptExecutor.executeScript(script);
	// }
	// }
	// }

} // the end of Dragonfly
