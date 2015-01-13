//TODO Highlight based on webelement null or json coordinates
//TODO Alert handling get and verify
//TODO Assert finish set method
//TODO Create an array json for link values from output link name
//TODO Remove json variables assignment
//TODO Pass json not variables
//TODO Update json with results status timing step details
//TODO Webtable for json file
//TODO Highlight based on status: pass, fail, info, warning, optional
//TODO Confirm all browsers work
//TODO Json Element properties combine , using json format for key and value
//TODO Switchto frames and iframes
//TODO Reporting add step details
//TODO Remove type from input
//TODO Sync state methods
//TODO Encryption
//TODO Add comment to file for changes
//TODO Check changes to library files and save backup.
//TODO Copy library files to local drive.
//TODO check for StaleElementReferenceException included

import com.opera.core.systems.*;
import com.opera.core.systems.scope.protos.SystemInputProtos.MouseInfo.MouseButton;
import com.thoughtworks.selenium.Wait;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

//import org.apache.bcel.generic.Select;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

//import java.util.Collections;
//import java.util.Set;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.ImmutableSet;

//import com.google.inject.Inject;

public class Evinrude {

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
			System.out.println("killWindowsProcess " + e.toString());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		WebDriver objWebDriver = null;
		WebElement objWebElement;
		boolean blnPass = false;
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
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		switch (OSType()) {
		case "Windows":
			strResultsPath = System.getProperty("user.dir") + "\\Results\\" + dateTimestamp() + "\\";
			strImagesPath = "images\\";
			break;
		case "Mac":
			strResultsPath = System.getProperty("user.dir") + "/Results/" + dateTimestamp() + "/";
			strImagesPath = "images/";
			break;
		default:
			// //TODO switch (OSType()) need to raise an error and log
			break;
		}
		new File(strResultsPath).mkdirs();
		new File(strResultsPath + strImagesPath).mkdirs();
		// System.out.println("ClipboardGet = " + ClipboardGet());
		try {
			// String strTestPath = "Data/public/local_jqueryFade.json";
			// String strTestPath = "Data/public/local_size_Visibility.json";
			// String strTestPath = "Data/public/public_mercury_tours.json";
			// String strTestPath = "Data/public/public_ranorex.json";
			// String strTestPath = "Data/public/public_w3s_FireEvents.json"
			// String strTestPath = "Data/public/public_w3s_JqueryAnimate.json";
			// String strTestPath = "Data/public/public_w3s_jquery.json";
			// String strTestPath = "Data/public/public_w3s_AngularJs.json";
			// String strTestPath = "Data/public/public_w3s_Visibility.json";
			String strTestPath = "Data/public/public_AngularJS_Calculator.json";
			// String strTestPath = "Data/public/public_GolfNow.json";
			Object objParser = parser.parse(new FileReader(strTestPath));
			objJsonFile = (JSONObject) objParser;
			objTestSteps = (JSONArray) objJsonFile.get("steps");
			JSONArray objLinkArray = (JSONArray) objJsonFile.get("link");
			JSONObject objLinks = (JSONObject) objLinkArray.get(0);
			writeJsonToHtml(objTestSteps, strResultsPath + "StepsOriginal.html");
			for (intStep = 0; intStep < objTestSteps.size(); intStep++) {
				objWebElement = null;
				blnPass = false;
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
				if (objStep.get("intLoop").toString().trim().length() == 0) {
					objStep.put("intLoop", "0");
				}
				objStep.put("strCurrentWindowHandle", strCurrentWindowHandle);
				objStep.put("strType", "");
				objStep.put("strScreenshotFilePath", strResultsPath + strImagesPath);
				objStep.put("strStatus", "info");
				objStep.put("intFrame", intFrame);

				// TODO consider moving the step println to a method and call
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
				System.out.println("main strAction = " + objStep.get("strAction").toString());
				System.out.println("main strTagName = " + objStep.get("strTagName").toString());
				System.out.println("main strAttributeNames = " + objStep.get("strAttributeNames").toString());
				System.out.println("main strAttributeValues = " + objStep.get("strAttributeValues").toString());
				System.out.println("main strInputValue = " + objStep.get("strInputValue").toString());
				System.out.println("main strLogicalName = " + objStep.get("strLogicalName").toString());
				System.out.println("main intMillisecondsToWait = " + objStep.get("intMillisecondsToWait").toString());
				System.out.println("main blnOptional = " + objStep.get("blnOptional").toString());
				System.out.println("main strAssert = " + objStep.get("strAssert").toString());
				System.out.println("main blnPleaseWait = " + objStep.get("blnPleaseWait").toString());
				System.out.println("main blnHighlight = " + objStep.get("blnHighlight").toString());
				System.out.println("main blnScreenshot = " + objStep.get("blnScreenshot").toString());
				System.out.println("main strFunction = " + objStep.get("strFunction").toString());
				System.out.println("main strAssistiveProperties = " + objStep.get("strAssistiveProperties").toString());
				System.out.println("main blnExitOnFail = " + objStep.get("blnExitOnFail").toString());
				System.out.println("main strOutputLinkName = " + objStep.get("strOutputLinkName").toString());
				System.out.println("main strOutputValue = " + objStep.get("strOutputValue").toString());
				System.out.println("main intLoop = " + objStep.get("intLoop").toString());
				System.out.println("main strCurrentWindowHandle = " + objStep.get("strCurrentWindowHandle").toString());
				if (!objStep.get("strFunction").toString().trim().equals("")) {
					String strMethodName = objStep.get("strFunction").toString();
					String arg1 = strInputValue;
					try {
						Class objClass = Class.forName("Evinrude");
						Class objParameterTypes[] = new Class[1];
						objParameterTypes[0] = String.class;
						Method objMethod = objClass.getMethod(strMethodName, objParameterTypes);
						Evinrude objEvinrude = new Evinrude();
						Object arrArgumentList[] = new Object[1];
						arrArgumentList[0] = new String(arg1);
						Object objReturn = objMethod.invoke(objEvinrude, arrArgumentList);
						String strReturnValue = (String) objReturn;
						strInputValue = strReturnValue;
						objStep.put("strInputValue", strInputValue);
						System.out.println(strReturnValue.toString());
					} catch (Throwable e) {
						System.out.println("main call function - " + e.toString());
					}
				}// the end of
				if (!strInputValue.equals("<skip>")) {
					switch (objStep.get("strAction").toString().toLowerCase()) {
					case "launch":
						// TODO create a browserLaunchSync to manage reporting and sync
						objWebDriver = browserLaunch(objStep);
						blnPass = Boolean.parseBoolean(objStep.get("blnStatus").toString());
						// long lngStartTimedocumenttitle = System.currentTimeMillis();
						// System.out.println("main objWebDriver.toString = " + objWebDriver.toString() + " " + (System.currentTimeMillis() - lngStartTimedocumenttitle));
						break;
					case "close":
						objWebDriver.close();
						objWebDriver.quit();
						blnPass = true;
						coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
						break;
					case "get":
						blnPass = elementGetSync(objStep, objWebDriver, objWebElement);
						break;
					case "set":
						blnPass = elementSetSync(objStep, objWebDriver, objWebElement);
						break;
					case "verify":
						blnPass = elementVerifyValueSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_visible":
						blnPass = elementVisibleSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_hidden":
						blnPass = elementHiddenSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_enabled":
						blnPass = elementEnabledSync(objStep, objWebDriver, objWebElement);
						break;
					case "sync_disabled":
						blnPass = elementDisabledSync(objStep, objWebDriver, objWebElement);
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
					if (blnPass == true) {
						System.out.println("main strCurrentWindowHandle = " + strCurrentWindowHandle);
					} else {
						// TODO call webElementCollectionTable cover all cases of fails
						if (Boolean.parseBoolean(objStep.get("blnExitOnFail").toString()) == true) {
							webElementCollectionTable(objStep.get("strTagName").toString(), objWebDriver);
							break;
						}
					}// the end of if (blnPass == true)
				}// the end of if (strInputValue != "<skip>")
				if (objStep.get("strOutputLinkName").toString().trim().length() != 0) {
					objLinks.put(objStep.get("strOutputLinkName").toString(), objStep.get("strOutputValue").toString());
					// System.out.println(objStep.get("strOutputLinkName").toString());
					// System.out.println(objLinks.get(objStep.get("strOutputLinkName").toString()).toString());
					// System.out.println(objStep.get("strOutputValue").toString());
				}
			}// for intStep
				// TODO confirm the exceptions to catch in main some may need to be removed
		} catch (IOException e) {
			System.out.println("main - " + e.toString());
		} catch (ParseException e) {
			System.out.println("main - " + e.toString());
		} catch (BrowserDriverNotSupportedException e) {
			System.out.println("main - " + e.toString());
		} finally {
			// TODO review how end of run is determined for reporting and cleanup
			// if (intStep == objTestSteps.size() || blnPass == false || objStep.get("strAction").toString().toLowerCase().equals("break")) {
			writeJsonToHtml(objTestSteps, strResultsPath + "StepsWithDefaults.html");
			writeReportToHtml(objTestSteps, strResultsPath + "Report.html");
			writeJsonToFile(objJsonFile, strResultsPath + "StepsAfterRun.json");
			if (objWebDriver.toString().contains("InternetExplorerDriver")) {
				killWindowsProcess("taskkill /F /IM IEDriverServer.exe");
			}
			// }
		}// the end of try
	}// the end of Main

	@SuppressWarnings("unchecked")
	public static Boolean elementGetSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeGetSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
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
				System.out.println("elementGetSync - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeGetSync));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				System.out.println("elementGetSync - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeGetSync));
			} catch (ElementTagNameNotSupportedException e) {
				System.out.println("elementGetSync - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeGetSync));
				blnExit = true;
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeGetSync);
				System.out.println("elementGetSync finally intMillisecondsWaited = " + intMillisecondsWaited);
				if (blnExit == true) {
					System.out.println("elementGetSync finally blnExit = true");
					objStep.put("strStatus", "fail");
					// if
					// (objStep.get("strTagName").toString().toLowerCase().equals("alert"))
					// {
					// coordinateHighlightScreenshot(objStep, "screen",
					// Color.GREEN, "screen", objWebDriver, null, objStep);
					//
					// } else {
					// coordinateHighlightScreenshot(objStep, "element",
					// Color.GREEN, "screen", objWebDriver, objWebElement,
					// objStep);
					// }
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					return false;
				}
				if (blnStatus == true) {
					System.out.println("elementGetSync finally blnStatus = " + blnStatus);
					objStep.put("strStatus", "pass");
					if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
						coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
					} else {
						coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					}
					return true;
				} else if (blnStatus == false) {
					if (intMillisecondsWaited <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
							blnGet = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
							return true;
						} else {
							objStep.put("strStatus", "fail");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
							return false;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
			}// the end of try
		}// the end of While
	}// the end of elementGetSync

	// public static void elementSet(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementTagNameNotSupportedException, ElementNotSetException {
	// long lngStartTimeElementSet = System.currentTimeMillis();
	// JavascriptExecutor objJavascriptExecutor = null;
	// Boolean blnSet = false;
	// String strOuterHTML = "";
	// if (objWebElement != null) {
	// objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
	// }
	// try {
	// long lngStartTimeOuterHTML = System.currentTimeMillis();
	// strOuterHTML = objWebElement.getAttribute("outerHTML");
	// System.out.println("elementSet outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeOuterHTML));
	// System.out.println(strOuterHTML);
	// switch (objStep.get("strTagType").toString().toLowerCase()) {
	// case "input_button":
	// case "input_submit":
	// case "input_reset":
	// case "input_image":
	// case "tr":
	// case "td":
	// case "div":
	// case "span":
	// case "img":
	// case "button":
	// case "a":
	// case "h1":
	// case "h2":
	// case "h3":
	// case "h4":
	// case "h5":
	// case "h6":
	// case "p":
	// blnSet = true;
	// objWebElement.click();
	// // objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
	// // objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
	// // objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
	// break;
	// case "input_text":
	// case "input_password":
	// case "textarea":
	// case "input_email":
	// blnSet = true;
	// objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].value = '';", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].value = '" + objStep.get("strInputValue").toString() + "';", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
	// System.out.println("onchange before");
	// try {
	// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
	// } catch (WebDriverException e) {
	// System.out.println("elementSet = " + e.toString());
	// }
	// break;
	// case "input_radio":
	// blnSet = true;
	// objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
	// try {
	// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
	// } catch (WebDriverException e) {
	// System.out.println("elementSet = " + e.toString());
	// }
	// break;
	// case "input_checkbox":
	// blnSet = true;
	// switch (objStep.get("strInputValue").toString().toLowerCase()) {
	// case "<on>":
	// if (objWebElement.isSelected() == false) {
	// objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
	// try {
	// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
	// } catch (WebDriverException e) {
	// System.out.println("elementSet = " + e.toString());
	// }
	// }
	// break;
	// case "<off>":
	// blnSet = true;
	// if (objWebElement.isSelected() == true) {
	// objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
	// objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
	// try {
	// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
	// } catch (WebDriverException e) {
	// System.out.println("elementSet = " + e.toString());
	// }
	// }
	// break;
	// }// the end of switch (strInputValue.toLowerCase())
	// break;
	// case "select":
	// int intOptionsEach;
	// String strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objWebElement);
	// strOptions = strOptions.substring(1);
	// String[] arrOptions;
	// arrOptions = strOptions.split("\\|");
	// for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
	// if (arrOptions[intOptionsEach].toString().equals(objStep.get("strInputValue").toString())) {
	// blnSet = true;
	// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objWebElement);
	// try {
	// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
	// } catch (WebDriverException e) {
	// System.out.println("elementSet = " + e.toString());
	// }
	// break;
	// }
	// }
	// break;
	// case "table":
	// // Set objWebElement = gobjWebElement.AsTable
	// break;
	// case "alert":
	// blnSet = true;
	// Alert alert = objWebDriver.switchTo().alert();
	// System.out.println(alert.getText()); // Print Alert popup
	// System.out.println(objStep.get("strAttributeValues").toString().toLowerCase());
	// switch (objStep.get("strAttributeValues").toString().toLowerCase()) {
	// case "text":
	// alert.sendKeys(objStep.get("strInputValue").toString());
	// break;
	// case "accept":
	// alert.accept(); // Close Alert popup
	// break;
	// case "dismiss":
	// alert.dismiss();// Close Alert popup
	// break;
	// }
	// break;
	// default:
	// throw new ElementTagNameNotSupportedException("Element tag not supported");
	// }// the end of switch (strTagName.toLowerCase())
	// if (blnSet == true) {
	// System.out.println("elementSet document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return document.readyState"));
	// // Thread.sleep(Integer.parseInt(objStep.get("intLoop").toString()));
	// if (strOuterHTML.contains("__doPostBack")) {
	// long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
	// while (true) {
	// try {
	// System.out.println("elementSet __EVENTTARGET value = " + objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
	// if (objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("")) {
	// break;
	// }
	// } catch (StaleElementReferenceException e) {
	// System.out.println("elementSet StaleElementReferenceException = " + e.toString());
	// }
	// if (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET > Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
	// break;
	// }
	// }
	// System.out.println("elementSet lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));
	// }// the end of (strOuterHTML.contains("__doPostBack"))
	// // browser.wait_for_condition("selenium.browserbot.getCurrentWindow().jQuery.active === 0;", '30000')
	// long lngStartTimeElementSetJQueryActive = System.currentTimeMillis();
	// while (true) {
	// boolean blnJquery = false;
	// long lngJqueryActive = 0;
	// try {
	//
	// System.out.println("elementSet blnJquery = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);"));
	// blnJquery = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);");
	// if (blnJquery == true) {
	//
	// lngJqueryActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (jQuery.active);");
	// System.out.println("elementSet lngJqueryActive = " + lngJqueryActive);
	// // System.out.println("elementSet both = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
	// }
	// } catch (Exception e) {
	// System.out.println("elementSet JqueryActive Exception = " + e.toString());
	// }
	// if (lngJqueryActive == 0) {
	// break;
	// }
	// if (System.currentTimeMillis() - lngStartTimeElementSetJQueryActive > Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
	// break;
	// }
	// }
	// long lngStartTimeElementSetJQueryAnimate = System.currentTimeMillis();
	// while (true) {
	// long lngElementsAnimated = 0;
	// boolean blnJqueryExist = false;
	// try {
	// blnJqueryExist = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);");
	// if (blnJqueryExist == true) {
	// lngElementsAnimated = (long) ((JavascriptExecutor) objWebDriver).executeScript("return $(\":animated\").length");
	// System.out.println("elementSet JQueryAnimate = " + lngElementsAnimated);
	// // System.out.println("elementSet JQueryAnimate = " + ((JavascriptExecutor) objWebDriver).executeScript("return $(\":animated\").length"));
	// }
	//
	// } catch (Exception e) {
	// System.out.println("elementSet JQueryAnimate Exception = " + e.toString());
	// }
	// if (lngElementsAnimated == 0) {
	// break;
	// }
	// if (System.currentTimeMillis() - lngStartTimeElementSetJQueryAnimate > Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
	// break;
	// }
	// }
	// long lngStartTimeElementSetAngularJS = System.currentTimeMillis();
	// while (true) {
	// boolean blnAngularJs = false;
	// long lngAngularJsInjectorActive = 0;
	// try {
	// blnAngularJs = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null);");
	// System.out.println("elementSet blnAngularJs = " + blnAngularJs);
	//
	// // boolean blnAngularJs2 = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular == null);");
	// // System.out.println("elementSet blnAngularJs2 = " + blnAngularJs2);
	// if (blnAngularJs == true) {
	// lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
	// System.out.println("elementSet lngJqueryActive = " + lngAngularJsInjectorActive);
	// }
	// // boolean blnAngularJsInjector = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector() != null);");
	// // System.out.println("elementSet blnAngularJsInjector = " + blnAngularJsInjector);
	//
	// // break;
	// // blnAngularJS = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
	//
	// // System.out.println("elementSet blnAngularJS = " + blnAngularJS);
	// } catch (Exception e) {
	// System.out.println("elementSet AngularJS Exception = " + e.toString());
	// }
	// if (lngAngularJsInjectorActive == 0) {
	// break;
	// }
	// if (System.currentTimeMillis() - lngStartTimeElementSetAngularJS > Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
	// break;
	// }
	// }
	//
	// // ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
	// //
	//
	// // "return $(":animated").length"
	// // "return $('#{0}').is(':animated')"
	//
	// // long lngStartTimeElementSetJQueryAJAXCallsHaveCompleted = System.currentTimeMillis();
	// // System.out.println("elementVisible jQuery.active MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
	// // // ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
	// // System.out.println("elementVisible document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return document.readyState"));
	// // long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
	// // while (((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);")!=null) {
	// //
	// //
	// // // try {
	// // // System.out.println("elementVisible jQuery.active = " + objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
	// // // blnJquery = (Boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
	// // // if (blnJquery == false) {
	// // // break;
	// // // }
	// // // } catch (Exception e) {
	// // // System.out.println("elementVisible Exception = " + e.toString());
	// // // }
	// // }// the end of
	// // System.out.println("elementVisible lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));
	//
	// // long lngStartTimeElementSetJQueryAJAXCallsHaveCompleted = System.currentTimeMillis();
	// // ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
	//
	// // ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
	//
	// // System.out.println("elementSet document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return document.readyState"));
	//
	// // wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(objWebElement)));
	// // System.out.println("elementSet finally jQueryAJAXCallsHaveCompleted = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
	//
	// // IWait<IWebDriver> wait = new OpenQA.Selenium.Support.UI.WebDriverWait(driver, TimeSpan.FromSeconds(30.00));
	// // wait.Until(driver1 => ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
	//
	// // System.out.println("elementSet jQueryAJAXCallsHaveCompleted MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSetJQueryAJAXCallsHaveCompleted));
	// }// the end of if (blnSet == true)
	//
	// } catch (Exception e) {
	// System.out.println("elementSet Exception = " + e.toString());
	// } finally {
	// if (blnSet == false) {
	// throw new ElementNotSetException("Element not set");
	// }
	// System.out.println("elementSet finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
	// }
	// }// the end of elementSet

	public static void elementSet(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement, String strOuterHTML) throws ElementTagNameNotSupportedException, ElementNotSetException {
		long lngStartTimeElementSet = System.currentTimeMillis();
		JavascriptExecutor objJavascriptExecutor = null;
		Boolean blnSet = false;
		// String strOuterHTML = "";
		if (objWebElement != null) {
			objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
		}
		try {
			long lngStartTimeOuterHTML = System.currentTimeMillis();
			// strOuterHTML = objWebElement.getAttribute("outerHTML");
			// System.out.println("elementSet outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeOuterHTML));
			// System.out.println(strOuterHTML);
			switch (objStep.get("strTagType").toString().toLowerCase()) {
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "tr":
			case "td":
			case "div":
			case "span":
			case "img":
			case "button":
			case "a":
			case "h1":
			case "h2":
			case "h3":
			case "h4":
			case "h5":
			case "h6":
			case "p":
				blnSet = true;
				objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
				objWebElement.click();
				objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				break;
			case "input_text":
				// blnSet = true;
				// // http://codepen.io/xmlilley/pen/KwKqqj
				// objWebElement.sendKeys(objStep.get("strInputValue").toString());
				// break;
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
			// System.out.println("onchange before");
			// if (strOuterHTML.toLowerCase().contains("onchange")) {
			// try {
			// objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
			// } catch (WebDriverException e) {
			// System.out.println("elementSet = " + e.toString());
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
				// System.out.println("elementSet = " + e.toString());
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
						// System.out.println("elementSet = " + e.toString());
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
						// System.out.println("elementSet = " + e.toString());
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
						// System.out.println("elementSet = " + e.toString());
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
				System.out.println(alert.getText()); // Print Alert popup
				System.out.println(objStep.get("strAttributeValues").toString().toLowerCase());
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
			System.out.println("elementSet Exception = " + e.toString());
		} finally {
			if (blnSet == false) {
				throw new ElementNotSetException("Element not set");
			}
			System.out.println("elementSet finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
		}
	}// the end of elementSet

	public static void waitForAngularRequestsToFinish(JavascriptExecutor driver) {
		driver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
	}

	public static void SetSyncComplete(WebDriver objWebDriver, String strOuterHTML) throws DoPostBackNotCompleteException, JQueryAjaxNotCompleteException, JQueryAnimationNotCompleteException, AngularJsNotCompleteException {
		WaitForReadyState(objWebDriver);
		JavascriptExecutor objJavascriptExecutor = null;
		objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
		waitForAngularRequestsToFinish(objJavascriptExecutor);
		boolean blnEventTarget = false;
		if (strOuterHTML.contains("__doPostBack")) {
			long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
			try {
				System.out.println("SetSyncComplete __EVENTTARGET value = " + objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
				blnEventTarget = !objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
			} catch (Exception e) {
				System.out.println("SetSyncComplete Exception = " + e.toString());
			}
			System.out.println("SetSyncComplete blnEventTarget = " + blnEventTarget);
			if (blnEventTarget == true) {
				// blnResult = false;
				throw new AngularJsNotCompleteException("");
			}
			System.out.println("SetSyncComplete lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));
		}// the end of (strOuterHTML.contains("__doPostBack"))
		long lngStartTimeElementSetJQueryActive = System.currentTimeMillis();
		boolean blnJquery = false;
		long lngJqueryActive = 0;
		try {
			// System.out.println("elementSet blnJquery = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);"));
			blnJquery = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null);");
			if (blnJquery == true) {
				lngJqueryActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (jQuery.active);");
				System.out.println("SetSyncComplete lngJqueryActive = " + lngJqueryActive);
				// System.out.println("elementSet both = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));

			}
		} catch (Exception e) {
			System.out.println("SetSyncComplete JqueryActive Exception = " + e.toString());
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
				System.out.println("SetSyncComplete JQueryAnimate = " + lngElementsAnimated);
				// System.out.println("SetSyncComplete JQueryAnimate = " + ((JavascriptExecutor) objWebDriver).executeScript("return $(\":animated\").length"));
			}
		} catch (Exception e) {
			System.out.println("SetSyncComplete JQueryAnimate Exception = " + e.toString());
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
			System.out.println("SetSyncComplete blnAngularJs = " + blnAngularJs);
			// boolean blnAngularJs2 = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular == null);");
			// System.out.println("elementSet blnAngularJs2 = " + blnAngularJs2);
			if (blnAngularJs == true) {
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				System.out.println("SetSyncComplete lngJqueryActive = " + lngAngularJsInjectorActive);
			}
			// boolean blnAngularJsInjector = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (angular.element(document).injector() != null);");
			// System.out.println("elementSet blnAngularJsInjector = " + blnAngularJsInjector);
			// blnAngularJS = (boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
			// System.out.println("elementSet blnAngularJS = " + blnAngularJS);
		} catch (Exception e) {
			System.out.println("SetSyncComplete AngularJS Exception = " + e.toString());
		}
		if (lngAngularJsInjectorActive > 0) {
			// blnResult = false;
			throw new AngularJsNotCompleteException("");
		}
		// if (blnResult == true) {
		// return true;
		// } else {
		// return false;
		// }
	}

	// public class Wait
	// {
	// private const bool Debug = true;
	// private const int ImplicitWaitInSeconds = 30;
	//
	// private readonly IWebDriver _driver;
	//
	// public Wait(IWebDriver webDriver)
	// {
	// _driver = webDriver;
	// }
	//
	// public void Until(Func<IWebDriver, bool> waitCondition, int timeoutInSeconds = Constants.ImplicitWaitInSeconds)
	// {
	// var wait = new WebDriverWait(_driver, TimeSpan.FromSeconds(timeoutInSeconds));
	// wait.Until(waitCondition);
	// }
	//
	// public void UntilAnimationIsDone(string elementId, int timeoutInSeconds = ImplicitWaitInSeconds)
	// {
	// Until(driver =>
	// {
	// var javaScriptExecutor = (IJavaScriptExecutor)driver;
	// var isAnimated = javaScriptExecutor
	// .ExecuteScript(string.Format("return $('#{0}').is(':animated')", elementId))
	// .ToString().ToLower();
	//
	// if (Debug)
	// Console.WriteLine(string.Format("Element: '{0}' Is Animated: {1}", elementId, isAnimated));
	//
	// // return true when finished animating
	// return !bool.Parse(isAnimated);
	// }, timeoutInSeconds);
	// }
	// }

	// internal static void WaitForAllAjaxCalls(this ISelenium selenium, IWebDriver driver, int timeout = 40)
	// {
	// Stopwatch sw = new Stopwatch();
	// sw.Start();
	// while (true)
	// {
	// if (sw.Elapsed.Seconds > timeout) throw new Exception("Timeout");
	// var ajaxIsComplete = (bool)driver.ExecuteScript("return jQuery.active == 0");
	// if (ajaxIsComplete)
	// break;
	// Thread.Sleep(100);
	// }
	// }

	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
			}
		};
	}

	public static ExpectedCondition<Boolean> jQueryAJAXCallsHaveCompleted() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
	}

	public static boolean WaitForReadyState(WebDriver objWebDriver) {
		System.out.println("elementSet document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return document.readyState"));
		return false;
	}

	@SuppressWarnings("unchecked")
	public static Boolean elementSetSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeSetSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
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
					strOuterHTML = objWebElement.getAttribute("outerHTML");
					System.out.println("elementSetSync outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeSetSync));
					System.out.println(strOuterHTML);
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
						if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
						} else {
							coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
						}
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
						coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
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
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
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
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
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
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
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
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					blnStatus = true;
					break;
				}// the end of switch (strAssert.toLowerCase())
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ElementNotFoundException | MultipleElementsFoundException e) {
				blnFound = false;
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
			} catch (ElementTagNameNotSupportedException e) {
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
				blnExit = true;
			} catch (ElementNotHiddenException e) {
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
				blnAssert = false;
			} catch (ValueNotMatchedException e) {
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
				blnFound = false;
				blnAssert = false;
			} catch (ElementNotSetException e) {
				blnSet = true;
				blnAssert = false;
			} catch (ElementNotDisabledException e) {
				blnAssert = false;
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
			} catch (DoPostBackNotCompleteException | JQueryAjaxNotCompleteException | JQueryAnimationNotCompleteException | AngularJsNotCompleteException e) {
				blnSetSync = false;
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeSetSync);
				System.out.println("elementSetSync finally MillisecondsWaited = " + intMillisecondsWaited);
				if (blnExit == true) {
					return false;
				}
				if (intMillisecondsWaited <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
					if (blnStatus == true) {
						// objStep.put("strStatus", "pass");
						return true;
					}
				} else {
					if (blnStatus == true) {
						objStep.put("strStatus", "pass");
						return true;
					} else if (blnStatus == false) {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
							return true;
						} else {
							objStep.put("strStatus", "fail");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
							return false;
						}
					}
				}
			}// the end of try
		}// the end of While
	}// the end of elementSetSync

	@SuppressWarnings("unchecked")
	public static Boolean elementVerifyValueSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeVerifyValueSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		Boolean blnVerified = false;
		Boolean blnValueNotMatched = false;
		String strActualValue = "";
		// String strValueExpected = objStep.get("strInputValue").toString();
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
				System.out.println("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeVerifyValueSync));
			} catch (ElementNotVisibleException e) {
				blnVisible = false;
				System.out.println("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeVerifyValueSync));
			} catch (ElementTagNameNotSupportedException e) {
				System.out.println("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeVerifyValueSync));
				blnExit = true;
			} catch (ValueNotMatchedException e) {
				System.out.println("elementVerifyValueSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeVerifyValueSync));
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				blnStatus = false;
				blnValueNotMatched = false;
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeVerifyValueSync);
				System.out.println("elementVerifyValueSync finally intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeVerifyValueSync));
				if (blnExit == true) {
					System.out.println("elementVerifyValueSync finally blnExit = true");
					objStep.put("strStatus", "fail");
					coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
					return false;
				}
				if (blnStatus == true) {
					System.out.println("elementVerifyValueSync finally blnStatus = " + blnStatus);
					objStep.put("strOutputValue", strActualValue);
					objStep.put("strStatus", "pass");
					if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
						coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
					} else {
						coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					}
					return true;
				} else if (blnStatus == false) {
					if (intMillisecondsWaited <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
							blnVerified = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strOutputValue", strActualValue);
							objStep.put("strStatus", "warning");
							if (blnFound == false || blnVisible == false) {
								coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
							} else {
								System.out.println("elementVerifyValueSync finally coordinateHighlightScreenshot element ");
								coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
							}
							return true;
						} else {
							objStep.put("strOutputValue", strActualValue);
							objStep.put("strStatus", "fail");

							if (blnValueNotMatched == false) {
								if (blnFound == false || blnVisible == false) {
									coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
								} else {
									coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
								}

							} else {
								coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
							}
							return false;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
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
			System.out.println("elementVerifyValue finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeElementVerify));
		}
		return strActualValue;
	}// the end of elementVerifyValue

	public static String verifyMatch(String strActual, String strExpected) throws ValueNotMatchedException {
		long lngStartTimeVerifyMatch = System.currentTimeMillis();
		try {
			if (strExpected.toLowerCase().startsWith("re:")) {
				String strPattern = strExpected.substring(3);
				System.out.println("verifyMatch RegularExpressionMatch = " + RegularExpressionMatch(strPattern, strActual));
				return RegularExpressionMatch(strPattern, strActual);
			} else {
				if (strExpected.equals(strActual)) {
					return strActual;
				} else {
					throw new ValueNotMatchedException("verifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
				}
			}
		} finally {
			System.out.println("verifyMatch strActual = {" + strActual + "} strExpected = {" + strExpected + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeVerifyMatch));
		}
	}// the end of VerifyMatch

	public static String RegularExpressionMatch(String strPattern, String strActualValue) {
		Pattern objPattern = Pattern.compile(strPattern);
		Matcher objMatcher = objPattern.matcher(strActualValue);
		objMatcher.matches();
		String strMatchedString = objMatcher.group(0);
		return strMatchedString;
	} // the end of RegularExpressionMatch

	public static Boolean elementVisibleSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeVisibleSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnStatus = false;
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
				System.out.println("elementVisibleSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeVisibleSync));
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeVisibleSync);
				System.out.println("elementVisibleSync finally intMillisecondsWaited = " + intMillisecondsWaited);
				if (blnStatus == true) {
					System.out.println("elementVisibleSync finally blnStatus = " + blnStatus);
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, null, objStep);
					return true;
				} else if (blnStatus == false) {
					if (intMillisecondsWaited <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnVisible = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
							return true;
						} else {
							objStep.put("strStatus", "fail");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
							return false;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
			}// the end of try
		}// the end of While
	}// the end of elementVisibleSync

	public static Boolean elementHiddenSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeHiddenSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
		Boolean blnFound = false;
		Boolean blnHidden = false;
		Boolean blnStatus = false;
		while (true) {
			try {
				System.out.println("elementHiddenSync - blnFound = " + blnFound);
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
				blnFound = true;
				blnHidden = true;
				System.out.println("elementHiddenSync - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeHiddenSync));
			} catch (MultipleElementsFoundException | ElementNotHiddenException e) {
				blnFound = false;
				blnHidden = false;
				System.out.println("elementHiddenSync - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeHiddenSync));
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeHiddenSync);
				System.out.println("elementHiddenSync finally intMillisecondsWaited = " + intMillisecondsWaited);
				if (blnStatus == true) {
					System.out.println("elementHiddenSync finally blnStatus = " + blnStatus);
					objStep.put("strStatus", "pass");
					elementCoordinates(objStep, objWebDriver, null);
					coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
					return true;
				} else if (blnStatus == false) {
					if (intMillisecondsWaited <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnHidden = false;
						}
					} else {
						elementCoordinates(objStep, objWebDriver, objWebElement);
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
							return true;
						} else {
							objStep.put("strStatus", "fail");
							coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
							return false;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
			}// the end of try
		}// the end of While
	}// the end of elementHiddenSync

	public static Boolean elementEnabledSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeEnabledSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnStatus = false;
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
				System.out.println("elementEnabledSync - " + e.toString() + " MillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeEnabledSync));
			} catch (ElementNotEnabledException e) {
				blnEnabled = false;
				System.out.println("elementEnabledSync - " + e.toString() + " MillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeEnabledSync));
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeEnabledSync);
				System.out.println("elementEnabledSync finally MillisecondsWaited = " + intMillisecondsWaited);
				if (blnStatus == true) {
					System.out.println("elementEnabledSync finally blnStatus = " + blnStatus);
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, null, objStep);
					return true;
				} else if (blnStatus == false) {
					if (intMillisecondsWaited <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnEnabled = false;
						}
					} else {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
							return true;
						} else {
							objStep.put("strStatus", "fail");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
							return false;
						}
					}// the end of if (intMillisecondsWaited <= intMillisecondsToWait)
				}// the end of if (blnStatus == true)
			}// the end of try
		}// the end of While
	}// the end of elementEnabledSync

	@SuppressWarnings("unchecked")
	public static Boolean elementDisabledSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeDisabledSync = System.currentTimeMillis();
		objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngStartTimeDisabledSync));
		objStep.put("strStatus", "");
		Integer intMillisecondsWaited = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnDisabled = false;
		Boolean blnStatus = false;
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
				System.out.println("elementDisabledSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeDisabledSync));
			} catch (ElementNotDisabledException e) {
				blnDisabled = false;
				System.out.println("elementDisabledSync - " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeDisabledSync));
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeDisabledSync);
				if (blnStatus == true) {
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
				}
				if (blnStatus == true) {
					if (intMillisecondsWaited > Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
						if (Boolean.parseBoolean(objStep.get("blnOptional").toString()) == true) {
							objStep.put("strStatus", "warning");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
						} else {
							objStep.put("strStatus", "fail");
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
						}
					}// the end of if (intMillisecondsWaited > intMillisecondsToWait)
				}// the end of if (blnStatus == true)
				if (objStep.get("strStatus").toString() != "") {
					Long lngMillisecondsWaited = System.currentTimeMillis();
					objStep.put("strStepDuration", (lngMillisecondsWaited - lngStartTimeDisabledSync));
					System.out.println("browserLaunch finally intMillisecondsWaited = " + objStep.get("strStepDuration").toString());
					objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngMillisecondsWaited));
					System.out.println("elementDisabledSync finally blnStatus = " + blnStatus);
				}
				if (objStep.get("strStatus").toString().equals("pass")) {
					return true;
				}
				if (objStep.get("strStatus").toString().equals("fail")) {
					return false;
				}
				System.out.println("elementDisabledSync finally intMillisecondsWaited = " + intMillisecondsWaited);
			}// the end of try
		}// the end of While
	}// the end of elementDisabledSync

	// TODO combine duplicate code
	// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
	@SuppressWarnings("unchecked")
	public static WebDriver browserLaunch(JSONObject objStep) throws BrowserDriverNotSupportedException {
		WebDriver objWebDriver = null;
		DesiredCapabilities desiredCapabilities = null;
		long lngStartTimeBrowserLaunch = System.currentTimeMillis();
		objStep.put("strStartTimestamp", currentTimeMillisToDateTimestamp(lngStartTimeBrowserLaunch));
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
				objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
				elementCoordinates(objStep, objWebDriver, null);
				coordinateHighlightScreenshot(objStep, "window", objWebDriver, null, objStep);
				objStep.put("blnStatus", true);
				return objWebDriver;
			case "ie":
				desiredCapabilities = DesiredCapabilities.internetExplorer();
				desiredCapabilities.setJavascriptEnabled(true);
				// System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				objWebDriver = new InternetExplorerDriver(desiredCapabilities);
				objWebDriver.get(objStep.get("strInputValue").toString());
				// objWebDriver.navigate().to(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
				elementCoordinates(objStep, objWebDriver, null);
				coordinateHighlightScreenshot(objStep, "window", objWebDriver, null, objStep);
				objStep.put("blnStatus", true);
				objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				// objWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				return objWebDriver;
			case "chrome":
				switch (OSType()) {
				case "Windows":
					// objWebDriver = new
					// RemoteWebDriver(DesiredCapabilities.chrome());
					// objWebDriver.get("http://www.google.com");
					// System.setProperty("webdriver.chrome.driver",
					// "C:\\Selenium\\chromedriver.exe");
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
				objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
				elementCoordinates(objStep, objWebDriver, null);
				coordinateHighlightScreenshot(objStep, "window", objWebDriver, null, objStep);
				objStep.put("blnStatus", true);
				return objWebDriver;
			case "safari":
				objWebDriver = new SafariDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
				elementCoordinates(objStep, objWebDriver, null);
				coordinateHighlightScreenshot(objStep, "window", objWebDriver, null, objStep);
				objStep.put("blnStatus", true);
				return objWebDriver;
			case "opera":
				// TODO OperaDriver setup latest driver and test
				// desiredCapabilities = DesiredCapabilities.internetExplorer();
				// desiredCapabilities.setJavascriptEnabled(true);
				// System.setProperty("webdriver.opera.driver",
				// "C:\\Selenium\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
				objWebDriver = new OperaDriver();
				objWebDriver.get(objStep.get("strInputValue").toString());
				// objWebDriver.manage().window().maximize();
				// objWebDriver.manage().window().setPosition(new Point(0, 0));
				// Dimension dim = new Dimension(1382, 754);
				// objWebDriver.manage().window().setSize(dim);
				objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
				elementCoordinates(objStep, objWebDriver, null);
				coordinateHighlightScreenshot(objStep, "window", objWebDriver, null, objStep);
				objStep.put("blnStatus", true);
				return objWebDriver;
				// // WebDriver objWebDriver;
				// Selenium selenium;
				// objWebDriver = new OperaDriver();
				// selenium = new WebDriverBackedSelenium(objWebDriver,
				// "https://www.google.com/");
				// return objWebDriver;
			default:
				throw new BrowserDriverNotSupportedException("Browser '" + objStep.get("strTagName").toString() + "' not supported");
			}
		} catch (Exception e) {
			System.out.println("browserLaunch " + e.toString());
		} finally {

			// windowFocus(objWebDriver);
			Long lngEndTimeBrowserLaunch = System.currentTimeMillis();
			objStep.put("strStepDuration", (lngEndTimeBrowserLaunch - lngStartTimeBrowserLaunch));
			System.out.println("browserLaunch finally intMillisecondsWaited = " + objStep.get("strStepDuration").toString());
			objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngEndTimeBrowserLaunch));
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

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}// the end of isAlertPresent()

	public static WebElement isAlertPresent2(WebDriver objWebDriver) throws ElementNotFoundException {
		try {

			@SuppressWarnings("unused")
			Alert alert = objWebDriver.switchTo().alert();
			System.out.println("this is the alert switch to which did not fail");
			return null;
		} // try
		catch (NoAlertPresentException e) {
			System.out.println("this is the alert switch to which did fail");
			System.out.println(e.toString());
			throw new ElementNotFoundException("Alert popup was not found.");
		} // catch
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static WebElement elementFind(JSONObject objStep, WebDriver objWebDriver) throws ElementNotFoundException, MultipleElementsFoundException {
		long lngStartTimeElementFind = System.currentTimeMillis();
		// objWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.NANOSECONDS);
		Boolean blnSwitch = false;
		try {
			int intFramesCount = 0;
			String strXpath = "";
			String strTagName;
			String strIndex = "";
			Boolean blnFound = false;
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
			System.out.println("elementFind strXpath = " + strXpath);
			System.out.println("elementFind before loop strCurrentWindowHandle = " + strCurrentWindowHandle);

			Object[] arrHandles = objWebDriver.getWindowHandles().toArray();
			System.out.println("elementFind arrHandles.length = " + arrHandles.length);

			for (int i = arrHandles.length - 1; i >= 0; i--) {
				// System.out.println(stack.get(i));
				System.out.println("elementFind arrHandles[i] = " + arrHandles[i].toString());
			}
			// if (arrHandles.length == 2) {
			// System.out.println("elementFind arrHandles[0] = " +arrHandles[0].toString());
			// System.out.println("elementFind arrHandles[1] = " +arrHandles[1].toString());
			// }
			//
			// if (arrHandles.length == 1) {
			// System.out.println("elementFind arrHandles[0] = " +arrHandles[0].toString());
			// }

			for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
				strWindowHandle = arrHandles[intHandlesEach].toString();

				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// objWebDriver.switchTo().window(strWindowHandle);
				System.out.println("elementFind intHandlesEach = " + intHandlesEach);

				System.out.println("elementFind lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				//
				System.out.println("elementFind objStep.get(\"inFrame\") = " + Integer.parseInt(objStep.get("intFrame").toString()));

				System.out.println("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				System.out.println("elementFind strWindowHandle = " + strWindowHandle);
				if (!strCurrentWindowHandle.equals(strWindowHandle)) {
					blnSwitch = true;
				} else {
					if (Integer.parseInt(objStep.get("intFrame").toString()) >= 0) {
						blnSwitch = true;
					}
				}
				if (blnSwitch == true) {
					objWebDriver.switchTo().window(strWindowHandle);
					System.out.println("elementFind Switched = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
					System.out.println("elementFind objWebDriver.getTitle = " + objWebDriver.getTitle());
					objStep.put("intFrame", -1);
				}

				// }
				// if (strCurrentWindowHandle.equals(strWindowHandle) ||
				// Integer.parseInt(objStep.get("intFrame").toString()) < 0) {
				// System.out.println("elementFind No Switch = " +
				// (System.currentTimeMillis() - lngStartTimeSwitchTo));
				//
				// } else {
				// objWebDriver.switchTo().window(strWindowHandle);
				// System.out.println("elementFind Switched = " +
				// (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// objStep.put("intFrame", -1);
				// // blnSwitchWindow = true;
				// }

				long intBrowserInnerWidth = 0;
				long intBrowserInnerHeight = 0;
				try {
					intBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
					intBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
					// System.out.println("intBrowserInnerWidth = " + intBrowserInnerWidth);
					// System.out.println("intBrowserInnerHeight = " + intBrowserInnerHeight);
				} catch (WebDriverException e) {
					throw new ElementNotFoundException("WebDriverException returned");
				} catch (Exception e) {
					// System.out.println("BodyoffsetHeight = " + e.toString());
					intBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetWidth;");
					intBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetHeight;");
					// System.out.println("BodyoffsetWidth = " + intBrowserInnerWidth);
					// System.out.println("BodyoffsetHeight = " + intBrowserInnerHeight);
				}
				objStep.put("intBrowserInnerWidth", intBrowserInnerWidth);
				objStep.put("intBrowserInnerHeight", intBrowserInnerHeight);

				long lngStartTimegetElementsByTagName = System.currentTimeMillis();
				List<WebElement> objCollectionJS = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
				System.out.println("elementFind objCollectionJS = " + objCollectionJS.size() + " strTagName = " + strTagName + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName));
				if (objCollectionJS.size() > 0) {
					long lngStartTimeByXpath = System.currentTimeMillis();
					objWebElementCollection = objWebDriver.findElements(By.xpath(strXpath));
					System.out.println("elementFind objWebElementCollection.size = " + objWebElementCollection.size() + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeByXpath));
				}

				if (objWebElementCollection.size() == 0) {

					long lngStartTimeFrameCollection = System.currentTimeMillis();
					// TODO add iFrame handling, return a collection of both frame
					// objFrameCollection = objWebDriver.findElements(By.tagName("frame"));
					objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('frame');");

					System.out.println("elementFind Frames = " + objFrameCollection.size() + " MillisecondsWaitedFrame " + (System.currentTimeMillis() - lngStartTimeFrameCollection));

					objFrameCollection.addAll((List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('iframe');"));
					// objFrameCollection.addAll(objWebDriver.findElements(By.tagName("iframe")));
					intFramesCount = objFrameCollection.size();
					System.out.println("elementFind objFrameCollection = " + intFramesCount + " MillisecondsWaitedIframe " + (System.currentTimeMillis() - lngStartTimeFrameCollection));
					// if (intFramesCount >= 1) {intFramesCount = intFramesCount + 1;
					// System.out.println("elementFind objFrameCollection = " + intFramesCount + "  " + (System.currentTimeMillis() - lngStartTimeFrameCollection));
					// }
					for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
						System.out.println("elementFind intFramesEach = " + intFramesEach);
						// if (intFramesEach >= 0) {
						long lngStartTimeSwitchToFrame = System.currentTimeMillis();
						objWebDriver.switchTo().defaultContent();
						objWebDriver.switchTo().frame(objFrameCollection.get(intFramesEach));
						objStep.put("intFrame", intFramesEach);
						System.out.println("elementFind frames objWebDriver.getWindowHandle = " + objWebDriver.getWindowHandle() + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeSwitchToFrame));
						// }

						long lngStartTimegetElementsByTagName2 = System.currentTimeMillis();
						List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
						System.out.println("elementFind objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));

						// long lngStartTimegetElementsByXpath = System.currentTimeMillis();
						// List<WebElement> objCollectionJS = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElements(By.xpath('" + strXpath + "');");
						// System.out.println("elementFind objCollectionJS = " + objCollectionJS.size() + " " + (System.currentTimeMillis() - lngStartTimegetElementsByXpath));
						// jse.executeScript("document.getElement(By.xpath(\"//div[@class='btnContr']/input[@onclick='return cancel();']\")");

						// long lngStartTimeTagName = System.currentTimeMillis();
						// objTagNameCollection = objWebDriver.findElements(By.tagName(strTagName));
						// System.out.println("elementFind objWebElementCollection.size = " + objTagNameCollection.size() + " MillisecondsWaitedTagName = " + (System.currentTimeMillis() - lngStartTimeTagName));

						// if (objCollectionJS.size() > 0) {
						// long lngStartTimeByTagNameByXpath = System.currentTimeMillis();
						// List<WebElement> objWebElementCollectionByTagNameByXpath = objCollectionJS.get(0).findElements(By.xpath(strXpath));
						// System.out.println("elementFind objWebElementCollectionByTagNameByXpath.size = " + objWebElementCollectionByTagNameByXpath.size() + " MillisecondsWaitedTagName = " + (System.currentTimeMillis() - lngStartTimeByTagNameByXpath));
						// }

						// if (objCollectionJS.size() > 0) {
						//
						// JavascriptExecutor objJavascriptExecutor = null;
						// objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
						// long lngStartTimeJS = System.currentTimeMillis();
						// System.out.println("JS value = " + objJavascriptExecutor.executeScript("return arguments[0].value;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						// lngStartTimeJS = System.currentTimeMillis();
						// System.out.println("JS innerText = " + objJavascriptExecutor.executeScript("return arguments[0].innerText;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						// lngStartTimeJS = System.currentTimeMillis();
						// System.out.println("JS innerHTML = " + objJavascriptExecutor.executeScript("return arguments[0].innerHTML;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						// lngStartTimeJS = System.currentTimeMillis();
						// System.out.println("JS outerHTML = " + objJavascriptExecutor.executeScript("return arguments[0].outerHTML;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
						//
						// }

						if (objCollectionJS2.size() > 0) {
							long lngStartTimeByXpath = System.currentTimeMillis();
							objWebElementCollection = objWebDriver.findElements(By.xpath(strXpath));
							System.out.println("elementFind objWebElementCollection.size = " + objWebElementCollection.size() + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeByXpath));
						}

						if (objWebElementCollection.size() > 0) {
							blnFound = true;
							break;
						}
					}
				}

				switch (objWebElementCollection.size()) {
				case 0:
					// System.out.println("elementFind - Element properties did not return an element, try refining attributes.");
					throw new ElementNotFoundException("Element properties did not return an element, try refining attributes");
				case 1:
					// System.out.println(objWebElementCollection.get(0));
					objWebElement = objWebElementCollection.get(0);
					// long lngStartTimeGetXpath = System.currentTimeMillis();
					// System.out.println("xpath = " + getElementXPath(objWebDriver, objWebElement) + " MillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeGetXpath));

					// TODO add title and url to each element found in the objStep json
					// JavascriptExecutor js = (JavascriptExecutor) objWebDriver;
					// String strTitle = (String) js.executeScript("return document.title");
					// System.out.println("main JavascriptExecutor strTitle  = " + strTitle + " intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimedocumenttitle));

					// System.out.println("strCurrentWindowHandle = " + objStep.get("strCurrentWindowHandle").toString());
					// System.out.println("objWebDriver.getWindowHandle = " + objWebDriver.getWindowHandle());

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
					// System.out.println("elementFind - Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
					throw new MultipleElementsFoundException("Element properties did not return an element, try refining attributes");
				}// the end of switch (objWebElementCollection.size())
			}// the end of for win Handles
		} catch (NoSuchFrameException e) {
			throw new ElementNotFoundException("elementFind " + e.toString());
		} finally {
			System.out.println("elementFind finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementFind));
		}
		return null;
	}// the end of elementFind

	public static String getElementXPath(WebDriver driver, WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
	}

	// public String GetElementXPath(WebElement element, WebDriver driver)
	// {
	// return (String) ((JavascriptExecutor) driver).executeScript(
	// "getXPath=function(node)" +
	// "{" +
	// "if (node.id !== '')" +
	// "{" +
	// "return '//' + node.tagName.toLowerCase() + '[@id=\"' + node.id + '\"]'"
	// +
	// "}" +
	//
	// "if (node === document.body)" +
	// "{" +
	// "return node.tagName.toLowerCase()" +
	// "}" +
	//
	// "var nodeCount = 0;" +
	// "var childNodes = node.parentNode.childNodes;" +
	//
	// "for (var i=0; i<childNodes.length; i++)" +
	// "{" +
	// "var currentNode = childNodes[i];" +
	//
	// "if (currentNode === node)" +
	// "{" +
	// return getXPath(node.parentNode) +
	// '/' + node.tagName.toLowerCase() +
	// '[' + (nodeCount+1) + ']'" +
	// "}" +
	//
	// "if (currentNode.nodeType === 1 && " +
	// "currentNode.tagName.toLowerCase() === node.tagName.toLowerCase())" +
	// "{" +
	// "nodeCount++" +
	// "}" +
	// "}" +
	// "};" +
	//
	// "return getXPath(arguments[0]);", element);
	// }

	@SuppressWarnings("unchecked")
	public static void elementCoordinates(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		long lngStartTimeElementCoordinates = System.currentTimeMillis();
		try {
			int intScrollbar = 0;
			// long lngStartTimeManageWindow = System.currentTimeMillis();
			Point objWebDriverPoint = objWebDriver.manage().window().getPosition();
			int intBrowserOuterX = objWebDriverPoint.x;
			int intBrowserOuterY = objWebDriverPoint.y;
			Dimension objWebDriverDimension = objWebDriver.manage().window().getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			// System.out.println("elementCoordinates intBrowserOuterX, Y  intBrowserOuterWidth, Height = " + objWebDriverPoint + " " + objWebDriverDimension + " " + (System.currentTimeMillis() - lngStartTimeManageWindow));
			objStep.put("intBrowserOuterX", intBrowserOuterX);
			objStep.put("intBrowserOuterY", intBrowserOuterY);
			objStep.put("intBrowserOuterWidth", intBrowserOuterWidth);
			objStep.put("intBrowserOuterHeight", intBrowserOuterHeight);
			// System.out.println("elementCoordinates intBrowserOuterX = " + intBrowserOuterX);
			// System.out.println("elementCoordinates intBrowserOuterY = " + intBrowserOuterY);
			// System.out.println("elementCoordinates intBrowserOuterWidth = " + intBrowserOuterWidth);
			// System.out.println("elementCoordinates intBrowserOuterHeight = " + intBrowserOuterHeight);
			if (objWebElement != null) {
				Coordinates objElementCoordinates = ((Locatable) objWebElement).getCoordinates();
				Point objElementPoint = objElementCoordinates.inViewPort();
				Dimension objElementDimension = objWebElement.getSize();
				objStep.put("intElementX", objElementPoint.x);
				objStep.put("intElementY", objElementPoint.y);
				objStep.put("intElementWidth", objElementDimension.width);
				objStep.put("intElementHeight", objElementDimension.height);
			}
			System.out.println("elementCoordinates objStep.containsKey = " + objStep.containsKey("intElementX"));
			if (objStep.containsKey("intElementX")) {
				int intBrowserInnerWidth = Integer.parseInt(objStep.get("intBrowserInnerWidth").toString());
				int intBrowserInnerHeight = Integer.parseInt(objStep.get("intBrowserInnerHeight").toString());
				int intElementX = Integer.parseInt(objStep.get("intElementX").toString());
				int intElementY = Integer.parseInt(objStep.get("intElementY").toString());
				int intElementWidth = Integer.parseInt(objStep.get("intElementWidth").toString());
				int intElementHeight = Integer.parseInt(objStep.get("intElementHeight").toString());
				// System.out.println("elementCoordinates intElementX = " + intElementX);
				// System.out.println("elementCoordinates intElementY = " + intElementY);
				// System.out.println("elementCoordinates intElementWidth = " + intElementWidth);
				// System.out.println("elementCoordinates intElementHeight = " + intElementHeight);
				int intWindowBorder = (int) ((intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2);
				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (int) ((intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder);
				objStep.put("intElementScreenX", intElementScreenX);
				objStep.put("intElementScreenY", intElementScreenY);
				// System.out.println("elementCoordinates intWindowBorder = " + intWindowBorder);
				// System.out.println("elementCoordinates intElementScreenX = " + intElementScreenX);
				// System.out.println("elementCoordinates intElementScreenY = " + intElementScreenY);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("elementCoordinates finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinates));
		}
	}// the end of elementCoordinates

	public static boolean elementVisible(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotVisibleException {
		long lngStartTimeElementVisible = System.currentTimeMillis();
		Boolean blnJquery = false;
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				try {
					// @SuppressWarnings("unused")
					Alert alert = objWebDriver.switchTo().alert();
					System.out.println("elementVisible alert passed");
					// System.out.println(objWebDriver.manage().window().getPosition());
					// System.out.println(objWebDriver.manage().window().getSize());
					return true;
				} catch (NoAlertPresentException e) {
					System.out.println(e.toString());
					throw new ElementNotVisibleException("Alert popup was not found.");
				}
			}
			if (objWebElement.isDisplayed()) {
				// // long lngStartTimeElementSetJQueryAJAXCallsHaveCompleted = System.currentTimeMillis();
				// // System.out.println("elementVisible jQuery.active MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
				// // // ((JavascriptExecutor) objWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
				// // System.out.println("elementVisible document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objWebDriver).executeScript("return document.readyState"));
				// long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
				// // while (((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);")!=null) {
				// //
				// //
				// // // try {
				// // // System.out.println("elementVisible jQuery.active = " + objWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
				// // // blnJquery = (Boolean) ((JavascriptExecutor) objWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
				// // // if (blnJquery == false) {
				// // // break;
				// // // }
				// // // } catch (Exception e) {
				// // // System.out.println("elementVisible Exception = " + e.toString());
				// // // }
				// // }
				// System.out.println("elementVisible lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));

				elementCoordinates(objStep, objWebDriver, objWebElement);
				return true;
			} else {
				System.out.println("elementVisible objWebElement.isDisplayed() = return false MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
				throw new ElementNotVisibleException("Element isDisplayed failed");
			}// the end of if (objWebElement.isDisplayed())
		} finally {
			System.out.println("elementVisible finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
		}
	}// the end of elementVisible

	public static boolean elementHidden(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotHiddenException {
		long lngStartTimeElementHidden = System.currentTimeMillis();
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				try {
					@SuppressWarnings("unused")
					Alert alert = objWebDriver.switchTo().alert();
					System.out.println("elementVisible alert passed");
					// System.out.println(objWebDriver.manage().window().getPosition());
					// System.out.println(objWebDriver.manage().window().getSize());
					return true;
				} catch (NoAlertPresentException e) {
					System.out.println(e.toString());
					throw new ElementNotHiddenException("Alert popup was not found.");
				}
			}
			if (objWebElement.isDisplayed() == false) {
				return true;
			} else {
				System.out.println("elementHidden objWebElement.isDisplayed() = return false MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
				throw new ElementNotHiddenException("Element is displayed.");
			}// the end of if (objWebElement.isDisplayed())
		} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException e) {
			System.out.println("elementHidden - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
			return true;
		} finally {
			System.out.println("elementHidden finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
		}
	}// the end of elementHidden

	public static boolean elementEnabled(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotEnabledException {
		long lngStartTimeElementEnabled = System.currentTimeMillis();
		try {
			// TODO Alert complete
			if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				try {
					Alert alert = objWebDriver.switchTo().alert();
					// System.out.println(objWebDriver.manage().window().getPosition());
					// System.out.println(objWebDriver.manage().window().getSize());
					return true;
				} // try
				catch (NoAlertPresentException e) {
					// return false;
					System.out.println(e.toString());
					throw new ElementNotEnabledException("Alert popup was not found.");
				} // catch
			}
			if (objWebElement.isEnabled()) {
				return true;
			} else {
				throw new ElementNotEnabledException("elementEnabled - Element is not enabled");
			}// the end of if (objWebElement.isEnabled())
		} finally {
			System.out.println("elementEnabled finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementEnabled));
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
			System.out.println("elementDisabled finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementDisabled));
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

	@SuppressWarnings("finally")
	public static String elementGet(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementTagNameNotSupportedException {
		long lngStartTimeElementGet = System.currentTimeMillis();
		String strElementGet = "";
		try {
			switch (objStep.get("strTagType").toString().toLowerCase()) {
			case "img":
				strElementGet = objWebElement.getAttribute("src");
				break;
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				strElementGet = objWebElement.getAttribute("value").trim();
				break;
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
				strElementGet = objWebElement.getText();
				break;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
				strElementGet = objWebElement.getAttribute("value");
				break;
			case "input_radio":
			case "input_checkbox":
				if (objWebElement.isSelected() == false) {
					strElementGet = "<off>";
				} else {
					strElementGet = "<on>";
				}
				break;
			case "select":
				JavascriptExecutor objExecutor = (JavascriptExecutor) objWebDriver;
				strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].innerHTML;return selection;", objWebElement);
				strElementGet = strElementGet.trim();
				break;
			case "table":
				strElementGet = objWebElement.getText();
				break;
			case "alert":
				Alert alert = objWebDriver.switchTo().alert();
				strElementGet = alert.getText();
				break;
			default:
				strElementGet = "elementGet tag not supported";
				throw new ElementTagNameNotSupportedException("Element tag not supported");
			}
		} finally {
			System.out.println("ElementGet finally strElementGet = {" + strElementGet + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementGet));
			return strElementGet;
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
	public static void coordinateHighlightScreenshot(final JSONObject objStepHighlightArea, final String strHighlightArea, final WebDriver objWebDriver, final WebElement objWebElement, JSONObject objStep) {
		System.out.println("coordinateHighlightScreenshot start");

		long lngStartTimeCoordinateHighlightScreenshot = System.currentTimeMillis();
		JFrame objJFrame = new JFrame() {
			{
				System.out.println("coordinateHighlightScreenshot before Rectangle objHighlightArea");
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				if (Boolean.parseBoolean(objStepHighlightArea.get("blnHighlight").toString()) == true) {
					int intThickness = 5;
					Color objColor2 = null;
					System.out.println("coordinateHighlightScreenshot before color switch");
					switch (objStepHighlightArea.get("strStatus").toString().toLowerCase()) {
					case "pass":
						if (objStepHighlightArea.get("strAction").toString().toLowerCase().equals("set") && objStepHighlightArea.get("strAssert").toString().toLowerCase().equals("off")) {
							objColor2 = Color.BLUE;
						} else {
							objColor2 = Color.GREEN;
						}
						break;
					case "fail":
						objColor2 = Color.RED;
						break;
					case "warning":
						objColor2 = Color.YELLOW;
						break;
					case "info":
						objColor2 = Color.MAGENTA;
						break;
					}
					System.out.println("coordinateHighlightScreenshot intThickness = " + intThickness);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					getRectangleAreaByName(objStepHighlightArea, intThickness, strHighlightArea, objHighlightArea, objWebDriver, objWebElement);
					setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
					setUndecorated(true);
					setBackground(new Color(0, 0, 0, 0));
					getRootPane().setBorder(BorderFactory.createLineBorder(objColor2, intThickness, false));
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
				objStep.put("strScreenshotFilePath", strScreenshotFilePath);
				Thread objThread = new Thread(new threadSaveImage(screenShot, "jpg", strScreenshotFilePath));
				objThread.start();
			} catch (AWTException e) {
				// TODO handle coordinateHighlightScreenshot AWTException
				System.out.println("coordinateHighlightScreenshot " + e.toString());
			} catch (Exception e) {
				// TODO handle coordinateHighlightScreenshot Exception
				System.out.println("coordinateHighlightScreenshot " + e.toString());
			}
		}// the end of if (blnScreenshot == true)
		if (Boolean.parseBoolean(objStep.get("blnHighlight").toString()) == true) {
			try {
				Thread.sleep(intSleepMilliseconds);
			} catch (InterruptedException e) {
				// TODO handle coordinateHighlightScreenshot InterruptedException
				System.out.println("coordinateHighlightScreenshot " + e.toString());
			}
			objJFrame.setVisible(false);
			objJFrame.dispose();
		}
		System.out.println("coordinateHighlightScreenshot MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeCoordinateHighlightScreenshot));
	}// the end of coordinateHighlightScreenshot

	public static void getRectangleAreaByName(JSONObject objStep, Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea, WebDriver objWebDriver, WebElement objWebElement) {
		long lngStartTimeGetRectangleAreaByName = System.currentTimeMillis();
		int intX = 0;
		int intY = 0;
		int intWidth = 0;
		int intHeight = 0;
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
				System.out.println("getRectangleAreaByName default screen, window, page and element not " + strAreaObjectName);
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
			System.out.println("getRectangleAreaByName finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeGetRectangleAreaByName));
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
				System.out.println("threadSaveImage IOException = ");
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
		System.out.println(objSimpleDateFormat.format(objFormattedDate));
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
	// strFullPath = gstrEvinrudePathFolderLocal & "Playlist.asx"
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

	public static void writeJsonToHtml(JSONArray objTestSteps, String file) {
		StringBuilder builder = new StringBuilder();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			builder.append("<!DOCTYPE html>");
			builder.append("<html lang=\"en\">");
			builder.append("<head><title>Evinrude steps</title></head>");
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
				// System.out.println(intTestStepRow);
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
			// System.out.println(html);
			System.out.println(file);
			bw.write(html);
		} catch (Exception e) {
			System.out.println(builder.toString());
			System.out.println(e.toString());
		}
	}// the end of writeJsonToHtml

	public static void writeReportToHtml(JSONArray objTestSteps, String strFile) {
		long lngStartTimeWriteReportToHtml = System.currentTimeMillis();
		String strScreenshotFilePath = "";
		StringBuilder objStringBuilder = new StringBuilder();
		BufferedWriter objBufferedWriter = null;
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
				objStringBuilder.append("<TD width= 100px align=center valign=middle>Expected</TD>");
				// objStringBuilder.append("<TD align=left valign=middle>" + objStep.get("strAction").toString() + "</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + createStepExpected(objStep) + "</TD>");

				objStringBuilder.append("</TR>");
				objStringBuilder.append("<TR>");
				objStringBuilder.append("<TD align=center valign=middle>Actual</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objStep.get("strStatus").toString() + "</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("</TABLE> ");
				if (objStep.get("strScreenshotFilePath").toString().trim().length() != 0) {
					strScreenshotFilePath = objStep.get("strScreenshotFilePath").toString().replaceAll("\\\\\\\\", "\\");
					objStringBuilder.append("<IMG alt=\"ReporterScreenShot_1\" src=\"" + strScreenshotFilePath + "\" width=1100 height=700> ");
				}
				// System.out.println("writeReportToHtml strScreenshotFilePath = " + objStep.get("strScreenshotFilePath").toString());
				objStringBuilder.append("</div>");
				objStringBuilder.append("<br>");
				objStringBuilder.append("<br>");
				if (objStep.get("strAction").toString().toLowerCase().equals("break")) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("writeReportToHtml - " + e.toString());
			System.out.println(objStringBuilder.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			// System.out.println(objStringBuilder.toString());
			try {
				String strHTML = objStringBuilder.toString();
				System.out.println(strHTML);
				objBufferedWriter.write(strHTML);
				objBufferedWriter.close();
			} catch (Exception e2) {
				System.out.println("writeReportToHtml - IOException" + e2.getMessage());
			}
			System.out.println("writeReportToHtml finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeWriteReportToHtml));
		}
	}// the end of writeReportToHtml

	public static String createStepExpected(JSONObject objStep) {
		String strAction = objStep.get("strAction").toString();
		String intMillisecondsToWait = objStep.get("intMillisecondsToWait").toString();
		String strInputValue = objStep.get("strInputValue").toString();
		String strTagName = objStep.get("strTagName").toString();
		String strObjectName = objStep.get("strAttributeValues").toString();
		switch (strAction.toLowerCase()) {
		case "launch":
			return "Launch " + strTagName + " browser to url {" + strInputValue + "} then expect navigation" + " within " + intMillisecondsToWait + " milliseconds";
		case "close":
			return "Close " + strTagName + " browser within " + intMillisecondsToWait + " milliseconds";
		case "get":
			return "Get " + strObjectName + " " + strTagName + " actual value" + " within " + intMillisecondsToWait + " milliseconds";
		case "set":
			return "Set " + strObjectName + " " + strTagName + " to value {" + strInputValue + "}" + " within " + intMillisecondsToWait + " milliseconds";
		case "verify":
			return "Verify " + strObjectName + " " + strTagName + " value is equal to {" + strInputValue + "}" + " within " + intMillisecondsToWait + " milliseconds";
		case "sync_visible":
			return "Sync until " + strObjectName + " " + strTagName + " is visible within " + intMillisecondsToWait + " milliseconds";
		case "sync_hidden":
			return "Sync until " + strObjectName + " " + strTagName + " is hidden within " + intMillisecondsToWait + " milliseconds";
		case "sync_enabled":
			return "Sync until " + strObjectName + " " + strTagName + " is enabled within " + intMillisecondsToWait + " milliseconds";
		case "sync_disabled":
			return "Sync until " + strObjectName + " " + strTagName + " is disabled within " + intMillisecondsToWait + " milliseconds";
		case "break":
		default:
			return strAction;
		}
	}

	public static String createStepActual(JSONArray objTestSteps) {
		return null;

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
	// strDetailsNoHTML = "The expected " & strToString & "  value {" & strInputParameterValue & "} was clicked."
	// Case "EXPECTED"
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
			System.out.println("main final " + e.toString());
		}
	}// the end of writeJsonKeysToHtml
		// TODO Learn how to iterate over jason keys

	public static void writeJsonKeysToHtml(JSONObject objTestStep, String file) throws IOException {
		for (Iterator iterator = objTestStep.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			System.out.println(key + " = " + objTestStep.get(key));
		}
	}// the end of writeJsonKeysToHtml

	// TODO webElementCollectionTable send output to html file
	public static void webElementCollectionTable(String strTagName, WebDriver objWebDriver) {
		int intCount = 0;
		JSONObject objStepNew = null;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		System.out.println("webElementCollectionTable lngStartTimeSwitchTo = " + objWebDriver.getTitle());
		objWebDriver.switchTo().defaultContent();
		for (String winHandle : objWebDriver.getWindowHandles()) {
			intCount = 0;
			// System.out.println("elementFind strCurrentWindowHandle = " +
			// strCurrentWindowHandle);
			System.out.println("webElementCollectionTable winHandle = " + winHandle);
			long lngStartTimeSwitchTo = System.currentTimeMillis();
			// if (strCurrentWindowHandle.equals(winHandle)) {
			// } else {
			objWebDriver.switchTo().window(winHandle);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("webElementCollectionTable lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
			// }
			System.out.println("webElementCollectionTable lngStartTimeSwitchTo = " + objWebDriver.getTitle());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			List<WebElement> objWebElementCollection = objWebDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				// try {
				// elementVisible(objStepNew, row);
				intCount = intCount + 1;
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
				// System.out.println("text:=  " + objWebElementEach.);
				System.out.println("getTagName:= '" + row.getTagName() + "'");
				System.out.println("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
				System.out.println("TagName:= '" + row.getAttribute("TagName") + "'");
				System.out.println("type:= '" + row.getAttribute("type") + "'");
				System.out.println("Type:= '" + row.getAttribute("Type") + "'");
				System.out.println("TYPE:= '" + row.getAttribute("TYPE") + "'");
				System.out.println("id:= '" + row.getAttribute("id") + "'");
				System.out.println("name:= '" + row.getAttribute("name") + "'");
				System.out.println("text:= '" + row.getAttribute("text") + "'");
				System.out.println("getText:= '" + row.getText() + "'");
				System.out.println("innerText:= '" + row.getAttribute("innerText") + "'");
				System.out.println("outerText:= '" + row.getAttribute("outerText") + "'");
				System.out.println("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
				System.out.println("outerHTML:= '" + row.getAttribute("outerHTML") + "'");
				System.out.println("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
				System.out.println("class:= '" + row.getAttribute("class") + "'");
				System.out.println("href:= '" + row.getAttribute("href") + "'");
				System.out.println("NameProp:= '" + row.getAttribute("NameProp") + "'");
				System.out.println("isDisplayed:= '" + row.isDisplayed() + "'");
				System.out.println("isEnabled:= '" + row.isEnabled() + "'");
				System.out.println("getLocation().x:= '" + row.getLocation().x + "'");
				System.out.println("getLocation().y:= '" + row.getLocation().y + "'");
				System.out.println("getSize().height:= '" + row.getSize().height + "'");
				System.out.println("getSize().width:= '" + row.getSize().width + "'");
				System.out.println("src:= '" + row.getAttribute("src") + "'");
				// if (objCollectionJS.size() > 0) {
				//
				// JavascriptExecutor objJavascriptExecutor = null;
				// objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
				// long lngStartTimeJS = System.currentTimeMillis();
				// System.out.println("JS value = " +
				// objJavascriptExecutor.executeScript("return arguments[0].value;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// System.out.println("JS innerText = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// System.out.println("JS innerHTML = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
				// objCollectionJS.get(0)) + " MillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// System.out.println("JS outerHTML = " +
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
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionAttributes " + intCount);
			// System.out.println("text:=  " + objWebElementEach.);
			System.out.println("text:=  " + row.getTagName());
			System.out.println("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
			System.out.println("TagName:=  " + row.getAttribute("TagName"));
			System.out.println("type:=  " + row.getAttribute("type"));
			System.out.println("id:=  " + row.getAttribute("id"));
			System.out.println("name:=  " + row.getAttribute("name"));
			System.out.println("text:=  " + row.getAttribute("text"));
			System.out.println("innerText:=  " + row.getAttribute("innerText"));
			System.out.println("outerText:=  " + row.getAttribute("outerText"));
			System.out.println("innerHTML:=  " + row.getAttribute("innerHTML"));
			System.out.println("outerHTML:=  " + row.getAttribute("outerHTML"));
			System.out.println("uniqueID:=  " + row.getAttribute("uniqueID"));
			System.out.println("class:=  " + row.getAttribute("class"));
			System.out.println("type:=  " + row.getAttribute("type"));
			System.out.println("TYPE:=  " + row.getAttribute("TYPE"));
			System.out.println("href:=  " + row.getAttribute("href"));
			System.out.println("NameProp:=  " + row.getAttribute("NameProp"));
			System.out.println("isDisplayed:=  " + row.isDisplayed());
			System.out.println("name:=  " + row.isEnabled());
			System.out.println("getLocation().x:=  " + row.getLocation().x);
			System.out.println("getLocation().y:=  " + row.getLocation().y);
			System.out.println("getSize().height:=  " + row.getSize().height);
			System.out.println("getLocation().y:=  " + row.getSize().width);
			System.out.println("src:=  " + row.getAttribute("src"));
		}
	} // the end of webElementCollectionAttributes

	public static void webElementAttributes(WebElement objWebElement) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementAttributes ");
		// System.out.println("text:=  " + objWebElementEach.);
		System.out.println("text:=  " + objWebElement.getTagName());
		System.out.println("tag_type:=  " + objWebElement.getTagName() + "_" + objWebElement.getAttribute("type"));
		System.out.println("TagName:=  " + objWebElement.getAttribute("TagName"));
		System.out.println("type:=  " + objWebElement.getAttribute("type"));
		System.out.println("id:=  " + objWebElement.getAttribute("id"));
		System.out.println("name:=  " + objWebElement.getAttribute("name"));
		System.out.println("text:=  " + objWebElement.getAttribute("text"));
		System.out.println("innerText:=  " + objWebElement.getAttribute("innerText"));
		System.out.println("outerText:=  " + objWebElement.getAttribute("outerText"));
		System.out.println("innerHTML:=  " + objWebElement.getAttribute("innerHTML"));
		System.out.println("outerHTML:=  " + objWebElement.getAttribute("outerHTML"));
		System.out.println("uniqueID:=  " + objWebElement.getAttribute("uniqueID"));
		System.out.println("class:=  " + objWebElement.getAttribute("class"));
		System.out.println("type:=  " + objWebElement.getAttribute("type"));
		System.out.println("TYPE:=  " + objWebElement.getAttribute("TYPE"));
		System.out.println("href:=  " + objWebElement.getAttribute("href"));
		System.out.println("NameProp:=  " + objWebElement.getAttribute("NameProp"));
		System.out.println("isDisplayed:=  " + objWebElement.isDisplayed());
		System.out.println("name:=  " + objWebElement.isEnabled());
		System.out.println("getLocation().x:=  " + objWebElement.getLocation().x);
		System.out.println("getLocation().y:=  " + objWebElement.getLocation().y);
		System.out.println("getSize().height:=  " + objWebElement.getSize().height);
		System.out.println("getLocation().y:=  " + objWebElement.getSize().width);
		System.out.println("src:=  " + objWebElement.getAttribute("src"));
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

} // the end of Evinrude
