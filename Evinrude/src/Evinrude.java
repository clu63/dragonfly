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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.CompoundBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
import org.openqa.selenium.Dimension;

import java.awt.image.BufferedImage;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Object;
import java.lang.reflect.Method;

import org.openqa.selenium.safari.SafariDriver;

import com.opera.core.systems.*;

import java.awt.HeadlessException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

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
			// String strTestPath = "Data/public/local_size_Visibility.json";
			// String strTestPath = "Data/public/public_w3c_Visibility.json";
			// String strTestPath = "Data/public/public_mercury_tours.json";
			String strTestPath = "Data/public/public_ranorex.json";
			// String strTestPath = "Data/public/public_w3c_fireevents.json"
			// String strTestPath = "Data/public/public_w3c_fireevents.json";
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
				objStep.put("strCurrentWindowHandle", strCurrentWindowHandle);
				objStep.put("strType", "");
				objStep.put("strScreenshotFilePath", strResultsPath + strImagesPath);
				System.out.println("strScreenshotFilePath = " + objStep.get("strScreenshotFilePath").toString());
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
						long lngStartTimedocumenttitle = System.currentTimeMillis();
						System.out.println("main objWebDriver.toString = " + objWebDriver.toString() + " " + (System.currentTimeMillis() - lngStartTimedocumenttitle));
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
						// TODO call webElementCollectionTable cover all cases
						// of fails
						if (Boolean.parseBoolean(objStep.get("blnExitOnFail").toString()) == true) {
							webElementCollectionTable(objStep.get("strTagName").toString(), objWebDriver);
							break;
						}
					}// the end of if (blnPass = true)
				}// the end of if (strInputValue != "<skip>")
				if (objStep.get("strOutputLinkName").toString().trim().length() != 0) {
					objLinks.put(objStep.get("strOutputLinkName").toString(), objStep.get("strOutputValue").toString());
					System.out.println(objStep.get("strOutputLinkName").toString());
					System.out.println(objLinks.get(objStep.get("strOutputLinkName").toString()).toString());
					System.out.println(objStep.get("strOutputValue").toString());
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
			if (intStep == objTestSteps.size() || blnPass == false || objStep.get("strAction").toString().toLowerCase().equals("break")) {
				writeJsonToHtml(objTestSteps, strResultsPath + "StepsWithDefaults.html");
				writeReportToHtml(objTestSteps, strResultsPath + "Report.html");
				writeJsonToFile(objJsonFile, strResultsPath + "StepsAfterRun.json");
				if (objWebDriver.toString().contains("InternetExplorerDriver")) {
					killWindowsProcess("taskkill /F /IM IEDriverServer.exe");
				}
			}
		}// the end of try
	}// the end of Main

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

	public static Boolean elementSetSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeSetSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnEnabled = false;
		Boolean blnSet = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		Boolean blnHidden = false;
		Boolean blnAssert = false;
		Boolean blnDisabled = false;
		objStep.put("strOutputValue", objStep.get("strInputValue").toString());
		while (true) {
			try {
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					System.out.println("elementSetSync - elementFind");
					blnFound = true;
				}
				if (blnVisible == false) {
					elementVisible(objStep, objWebDriver, objWebElement);
					System.out.println("elementSetSync - elementVisible");
					blnVisible = true;
				}
				if (blnEnabled == false) {
					elementEnabled(objStep, objWebDriver, objWebElement);
					System.out.println("elementSetSync - elementEnabled");
					blnEnabled = true;
				}
				switch (objStep.get("strAssert").toString().toLowerCase()) {
				case "off":
					objStep.put("strStatus", "pass");
					if (objStep.get("strTagName").toString().toLowerCase().equals("alert")) {
						coordinateHighlightScreenshot(objStep, "screen", objWebDriver, null, objStep);
					} else {
						coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					}
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement);
						blnSet = true;
						blnAssert = true;
					}
					break;
				case "hidden":
					objStep.put("strStatus", "pass");
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement);
						blnSet = true;
					}
					if (blnAssert == false) {
						elementHidden(objStep, objWebDriver, objWebElement);
						blnHidden = true;
						blnAssert = true;
					}
					break;
				case "value":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement);
						blnSet = true;
					}
					if (blnAssert == false) {
						elementVerifyValue(objStep, objWebDriver, objWebElement);
						blnAssert = true;
					}
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					break;
				case "visible":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement);
						blnSet = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep, objWebDriver, objWebElement);
						blnVisible = true;
						blnAssert = true;
					}
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					break;
				case "enabled":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement);
						blnSet = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep, objWebDriver, objWebElement);
						blnVisible = true;
						elementEnabled(objStep, objWebDriver, objWebElement);
						// blnVisible = true;
						blnAssert = true;
					}
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
					break;
				case "disabled":
					if (blnSet == false) {
						elementSet(objStep, objWebDriver, objWebElement);
						blnSet = true;
					}
					if (blnAssert == false) {
						elementVisible(objStep, objWebDriver, objWebElement);
						blnVisible = true;
						elementDisabled(objWebElement);
						// blnVisible = true;
						blnAssert = true;
					}
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
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
				// blnSet = true;
				// blnHidden = false;
				blnAssert = false;
			} catch (ValueNotMatchedException e) {
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
				blnAssert = false;
			} catch (ElementNotSetException e) {
				blnSet = true;
				blnAssert = false;
			} catch (ElementNotDisabledException e) {
				blnDisabled = false;
				blnAssert = false;
				System.out.println("elementSetSync - " + e.toString() + "  lngStartTimeSetSync = " + (System.currentTimeMillis() - lngStartTimeSetSync));
			} finally {
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeSetSync);
				System.out.println("elementSetSync finally intMillisecondsWaited = " + intMillisecondsWaited);
				if (blnExit == true) {
					System.out.println("elementSetSync finally blnExit = true");
					return false;
				}
				if (intMillisecondsWaited <= Integer.parseInt(objStep.get("intMillisecondsToWait").toString())) {
					if (blnStatus == true) {
						System.out.println("elementSetSync finally blnStatus = " + blnStatus);
						objStep.put("strStatus", "pass");
						return true;
					} else if (blnStatus == false) {

						if (blnFound == false) {
							blnVisible = false;
							blnEnabled = false;
							// blnAssert = false;
							blnSet = false;
							blnHidden = false;
						}
					}
				} else {
					System.out.println("elementSetSync finally blnStatus = " + blnStatus);
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

	public static String elementVerifyValue(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ValueNotMatchedException, ElementTagNameNotSupportedException {
		long lngStartTimeElementVerify = System.currentTimeMillis();
		String strGetValue = "";
		String strActualValue = "";
		String strValueExpected = objStep.get("strInputValue").toString();
		try {
			strGetValue = elementGet(objStep, objWebDriver, objWebElement);
			strActualValue = verifyMatch(strGetValue, strValueExpected);
		} finally {
			System.out.println("elementVerifyValue finally strValueActual = " + strActualValue + " elementVerifyValue strValueExpected = " + strValueExpected + " intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeElementVerify));
		}
		return strActualValue;
	}// the end of elementVerifyValue

	public static Boolean elementVerifyValueSync(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		Long lngStartTimeVerifyValueSync = System.currentTimeMillis();
		Integer intMillisecondsWaited = null;
		Boolean blnFound = false;
		Boolean blnVisible = false;
		Boolean blnStatus = false;
		Boolean blnExit = false;
		Boolean blnVerified = false;
		String strActualValue = "";
		String strValueExpected = objStep.get("strInputValue").toString();
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
				blnStatus = false;
				blnExit = false;
				blnVerified = false;
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
				blnStatus = false;
				blnExit = false;
				blnVerified = false;
			} finally {
				// System.out.println("elementVerifyValueSync strValueActual = "
				// + strGetValue + " elementVerifyValue strValueExpected = " +
				// strValueExpected);
				intMillisecondsWaited = (int) (System.currentTimeMillis() - lngStartTimeVerifyValueSync);
				System.out.println("elementVerifyValueSync finally intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeVerifyValueSync));
				if (blnExit == true) {
					System.out.println("elementVerifyValueSync finally blnExit = true");
					objStep.put("strStatus", "fail");
					coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
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
							coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
							return true;
						} else {
							objStep.put("strOutputValue", strActualValue);
							objStep.put("strStatus", "fail");
							if (blnFound == false || blnVisible == false) {
								coordinateHighlightScreenshot(objStep, "screen", objWebDriver, objWebElement, objStep);
							} else {
								coordinateHighlightScreenshot(objStep, "element", objWebDriver, objWebElement, objStep);
							}
							return false;
						}
					}// the end of if (intMillisecondsWaited <=
						// intMillisecondsToWait)
				}// the end of if (blnStatus == true)
			}// the end of try
		}// the end of While
	}// the end of elementVerifyValueSync

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
					}// the end of if (intMillisecondsWaited <=
						// intMillisecondsToWait)
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
				if (blnFound == false) {
					objWebElement = elementFind(objStep, objWebDriver);
					blnFound = true;
				}
				if (blnFound = true && blnHidden == false) {
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
					}// the end of if (intMillisecondsWaited <=
						// intMillisecondsToWait)
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
				System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
				objWebDriver = new InternetExplorerDriver(desiredCapabilities);
				objWebDriver.navigate().to(objStep.get("strInputValue").toString());
				objWebDriver.manage().window().maximize();
				objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
				elementCoordinates(objStep, objWebDriver, null);
				coordinateHighlightScreenshot(objStep, "window", objWebDriver, null, objStep);
				objStep.put("blnStatus", "true");
				objWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				// objWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				return objWebDriver;
			case "chrome":
				switch (OSType()) {
				case "Windows":
					System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
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
		} finally {

			windowFocus(objWebDriver);
			Long lngEndTimeBrowserLaunch = System.currentTimeMillis();
			objStep.put("strStepDuration", (lngEndTimeBrowserLaunch - lngStartTimeBrowserLaunch));
			System.out.println("browserLaunch finally intMillisecondsWaited = " + objStep.get("strStepDuration").toString());
			objStep.put("strEndTimestamp", currentTimeMillisToDateTimestamp(lngEndTimeBrowserLaunch));
		}
	} // the end of browserLaunch

	public static String ClipboardGet() {
		String data = "";
		try {
			data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}// the end of ClipboardGet

	public static void elementSet(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementTagNameNotSupportedException, ElementNotSetException {
		long lngStartTimeElementSet = System.currentTimeMillis();
		JavascriptExecutor objJavascriptExecutor = null;
		Boolean blnSet = false;
		if (objWebElement != null) {
			objJavascriptExecutor = (JavascriptExecutor) objWebDriver;
		}
		try {
			System.out.println(objStep.get("strTagType").toString().toLowerCase());
			long lngStartTimeSwitchSet = System.currentTimeMillis();
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
				objWebElement.click();
				// objJavascriptExecutor.executeScript("arguments[0].focus();",
				// objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].click();",
				// objWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].blur();",
				// objWebElement);
				break;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
				blnSet = true;
				// Actions builder = new Actions(objWebDriver);
				// // Action action1 =
				// builder.click(objWebElement).sendKeys(Keys.CONTROL +
				// "a").sendKeys(Keys.DELETE).sendKeys(strInputValue).moveToElement(objWebElement,
				// -1, -1).click().build();
				// // action1.perform();
				// if (objWebElement.getAttribute("value").trim().isEmpty() ==
				// false) {
				// Action action1 =
				// builder.click(objWebElement).sendKeys(Keys.CONTROL +
				// "a").sendKeys(Keys.DELETE).build();
				// action1.perform();
				// // objWebElement.click();
				// // objWebElement.sendKeys(Keys.CONTROL + "a");
				// // objWebElement.sendKeys(Keys.DELETE);
				// // //objWebElement.clear();
				// }
				// objWebElement.sendKeys(objStep.get("strInputValue").toString());
				// Action action = builder.moveToElement(objWebElement, -1,
				// -1).click().build();
				// action.perform();

				// executor.executeScript("arguments[0].value = 'tegan';",
				// objWebElement);
				// JavascriptExecutor executor27 = (JavascriptExecutor)
				// objWebDriver;
				objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				objJavascriptExecutor.executeScript("arguments[0].value = '';", objWebElement);
				objJavascriptExecutor.executeScript("arguments[0].value = '" + objStep.get("strInputValue").toString() + "';", objWebElement);
				objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				System.out.println("onchange before");
				try {
					// ((JavascriptExecutor)
					// objWebDriver).executeScript("arguments[0].onchange();",
					// objWebElement);
					objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
				} catch (WebDriverException e) {
					System.out.println("elementSet = " + e.toString());
				}
				System.out.println("onchange after");
				// executor.executeScript("$(arguments[0]).change();",
				// objWebElement);
				// SeleneseCommand Selenium = (SeleneseCommand) objWebDriver;
				// Selenium.FireEvent(objWebElement.toString(),"onchange");
				// Selenium.fireEvent(objWebElement, "onchange");
				// // jQuery
				// selenium.runScript("$('#MyInputElement').trigger('change')");
				//
				// // Vanilla JavaScript
				// document.getElementById('MyInputElement').onchange();
				// objWebElement.sendKeys(Keys.TAB);
				// Actions builder = new Actions(objWebDriver);
				// Point imageCoordinates =new Point(0, 0);
				// Mouse mouse = ((HasInputDevices) objWebDriver).getMouse();
				// mouse.mouseMove(imageCoordinates);
				// mouse.click(imageCoordinates);
				break;
			// /simulate(document.getElementById("btn"), "click", { pointerX:
			// 123, pointerY: 321 })
			case "input_radio":
				blnSet = true;
				// objWebElement.click();
				objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
				objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
				objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
				try {
					// ((JavascriptExecutor)
					// objWebDriver).executeScript("arguments[0].onchange();",
					// objWebElement);
					objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
				} catch (WebDriverException e) {
					System.out.println("elementSet = " + e.toString());
				}
				break;
			case "input_checkbox":
				blnSet = true;
				System.out.println("elementSet IT'S A input_checkbox" + (System.currentTimeMillis() - lngStartTimeSwitchSet));
				// System.out.println("objWebElement.isSelected() = " +
				// objWebElement.isSelected());
				switch (objStep.get("strInputValue").toString().toLowerCase()) {
				case "<on>":
					long lngStartTimeisSelected = System.currentTimeMillis();
					if (objWebElement.isSelected() == false) {
						System.out.println("elementSet objWebElement.isSelected()" + (System.currentTimeMillis() - lngStartTimeisSelected));
						long lngStartTimeclick = System.currentTimeMillis();
						// Actions builder1 = new Actions(objWebDriver);
						// // Action action1 =
						// builder1.click(objWebElement).build();
						// // action1.perform();
						//
						// Action action1 =
						// builder1.moveToElement(objWebElement).click().build();
						// action1.perform();
						// // objWebElement.click();
						// System.out.println("elementSet objWebElement.click()"
						// + (System.currentTimeMillis() - lngStartTimeclick));
						// ((JavascriptExecutor)
						// objWebDriver).executeScript("arguments[0].scrollIntoView(true);",
						// objWebElement);
						// JavascriptExecutor executor = (JavascriptExecutor)
						// objWebDriver;
						// executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
						// ( function x() { //do something & return value } )()
						// executor.executeScript("arguments[0].scrollIntoView(false);",
						// objWebElement);
						// JavascriptExecutor executor2 = (JavascriptExecutor)
						// objWebDriver;
						// executor2.executeScript("arguments[0].click();",
						// objWebElement);
						objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
						objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
						objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
						try {
							// ((JavascriptExecutor)
							// objWebDriver).executeScript("arguments[0].onchange();",
							// objWebElement);
							objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
						} catch (WebDriverException e) {
							System.out.println("elementSet = " + e.toString());
						}
						System.out.println("elementSet JavascriptExecutor" + (System.currentTimeMillis() - lngStartTimeclick));
					}
					break;
				case "<off>":
					blnSet = true;
					if (objWebElement.isSelected() == true) {
						// objWebElement.click();
						objJavascriptExecutor.executeScript("arguments[0].focus();", objWebElement);
						objJavascriptExecutor.executeScript("arguments[0].click();", objWebElement);
						objJavascriptExecutor.executeScript("arguments[0].blur();", objWebElement);
						try {
							// ((JavascriptExecutor)
							// objWebDriver).executeScript("arguments[0].onchange();",
							// objWebElement);
							objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
						} catch (WebDriverException e) {
							System.out.println("elementSet = " + e.toString());
						}
					}
					break;
				}// the end of switch (strInputValue.toLowerCase())
				break;
			case "select":
				// objWebElement.click();
				int intOptionsEach;
				// JavascriptExecutor executor3 = (JavascriptExecutor)
				// objWebDriver;
				// this works use it
				long lngStartTimeElementOptionCount = System.currentTimeMillis();
				String strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objWebElement);
				// System.out.println("strOptions = " + strOptions +
				// " intMillisecondsWaited = " + (System.currentTimeMillis() -
				// lngStartTimeElementOptionCount));
				strOptions = strOptions.substring(1);
				// System.out.println("strOptions = " + strOptions +
				// " intMillisecondsWaited = " + (System.currentTimeMillis() -
				// lngStartTimeElementOptionCount));
				String[] arrOptions;
				arrOptions = strOptions.split("\\|");
				// arrOptions = strOptions.split("|");
				// System.out.println("arrOptions.length = " +
				// arrOptions.length);
				// blnFound = False
				// System.out.println("elementSet IT'S A SELECT");
				// Select objSelect = new Select((WebElement) objWebElement);
				// JavascriptExecutor js = (JavascriptExecutor)driver();
				// js.executeScript("document.getElementById("actionTypeList").selectedIndex=1");
				// selenium.fireEvent("actionTypeList","change");
				for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					// System.out.println("elementSet dropdown.getOptions() " +
					// intOptionsEach + " =  " +
					// arrOptions[intOptionsEach].toString());
					if (arrOptions[intOptionsEach].toString().equals(objStep.get("strInputValue").toString())) {
						blnSet = true;
						// objSelect.selectByIndex(intOptionsEach);
						// executor3.executeScript("arguments[0].options.index="
						// + intOptionsEach + ";", objWebElement);
						objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objWebElement);
						try {
							objJavascriptExecutor.executeScript("arguments[0].onchange();", objWebElement);
						} catch (WebDriverException e) {
							System.out.println("elementSet = " + e.toString());
						}
						// element.onchange();
						// if ("createEvent" in document) {
						// var evt = document.createEvent("HTMLEvents");
						// evt.initEvent("change", false, true);
						// element.dispatchEvent(evt);
						// }
						// else
						// element.fireEvent("onchange");
						break;
					}
				}
				// // objSelect.selectByVisibleText("DVC Pay With Cash");
				// List<WebElement> options = objSelect.getOptions();
				//
				// for (WebElement el : options) {
				// System.out.println(el.getText());
				// }
				// .options[3].text;
				// System.out.println("elementSet dropdown.getOptions().size() = "
				// + objSelect.getOptions().size());
				// for (intOptionsEach = 0; intOptionsEach <
				// objSelect.getOptions().size(); intOptionsEach++) {
				// System.out.println("elementSet dropdown.getOptions() " +
				// intOptionsEach + " =  " +
				// objSelect.getOptions().get(intOptionsEach).getText());
				// if
				// (objSelect.getOptions().get(intOptionsEach).getText().equals(objStep.get("strInputValue").toString()))
				// {
				// objSelect.selectByIndex(intOptionsEach);
				// break;
				// }
				// }
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
		} finally {
			if (blnSet = false) {
				throw new ElementNotSetException("Element not set");
			}
			System.out.println("elementSet finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
		}
	}// the end of elementSet

	// public static Boolean elementVerifyValue(String strTagName, WebElement
	// objWebElement, String strValueExpected) throws
	// ElementValueNotVerifiedException {
	// String strValueActual = "";
	// try {
	// strValueActual = elementGet(objWebElement);
	// } catch (ElementTagNameNotSupportedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println("elementVerifyValue strValueActual = " +
	// strValueActual);
	// if (strValueActual == null) {
	// throw new ElementValueNotVerifiedException("Element value not verified");
	// } else {
	// System.out.println("elementVerifyValue strValueActual = " +
	// strValueActual + " elementVerifyValue strValueExpected = " +
	// strValueExpected);
	// if (verifyMatch(strValueActual, strValueExpected) != null) {
	// return true;
	// } else {
	// throw new ElementValueNotVerifiedException("Element value not verified");
	// }
	// }
	// } // the end of elementVerifyValue

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

	@SuppressWarnings({ "unchecked" })
	public static WebElement elementFind(JSONObject objStep, WebDriver objWebDriver) throws ElementNotFoundException, MultipleElementsFoundException {
		long lngStartTimeElementFind = System.currentTimeMillis();
		objWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.NANOSECONDS);
		Boolean blnSwitch = false;
		// objWebDriver.
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
			if (strTagName.toLowerCase().equals("alert")) {
				// TODO elementFind finish alert handling
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
			// System.out.println("elementFind before loop strCurrentWindowHandle = " + strCurrentWindowHandle);

			Object[] arrHandles = objWebDriver.getWindowHandles().toArray();
			// System.out.println("arrHandles.length = " + arrHandles.length);
			for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
				String strWindowHandle = arrHandles[intHandlesEach].toString();
				// System.out.println("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				// System.out.println("elementFind winHandle = " + winHandle);
				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// objWebDriver.switchTo().window(strWindowHandle);
				// System.out.println("elementFind lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// System.out.println("elementFind objWebDriver.getTitle = " + objWebDriver.getTitle());

				System.out.println("objStep.get(\"inFrame\") = " + Integer.parseInt(objStep.get("intFrame").toString()));
				if (strCurrentWindowHandle.equals(strWindowHandle)) {
					blnSwitch = true;
				} else {
					if (Integer.parseInt(objStep.get("intFrame").toString()) >= 0) {
						blnSwitch = true;
					}
				}
				if (blnSwitch = true) {
					objWebDriver.switchTo().window(strWindowHandle);
					System.out.println("elementFind Switched = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
					objStep.put("intFrame", -1);
				}

				// }
				// if (strCurrentWindowHandle.equals(strWindowHandle) || Integer.parseInt(objStep.get("intFrame").toString()) < 0) {
				// System.out.println("elementFind No Switch = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				//
				// } else {
				// objWebDriver.switchTo().window(strWindowHandle);
				// System.out.println("elementFind Switched = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
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
					// if (intFramesCount >= 1) {
					// intFramesCount = intFramesCount + 1;
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

					System.out.println("strCurrentWindowHandle = " + objStep.get("strCurrentWindowHandle").toString());

					System.out.println("objWebDriver.getWindowHandle = " + objWebDriver.getWindowHandle());

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
	// "return '//' + node.tagName.toLowerCase() + '[@id=\"' + node.id + '\"]'" +
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

	// working with commented code 20141209 copied to have reference for code removal of function above
	// @SuppressWarnings({ "unchecked" })
	// public static WebElement elementFind(JSONObject objStep, WebDriver objWebDriver) throws ElementNotFoundException, MultipleElementsFoundException {
	// long lngStartTimeElementFind = System.currentTimeMillis();
	// try {
	// String strXpath = "";
	// String strTag;
	// String strIndex = "";
	// Boolean blnFound = false;
	// //Boolean blnSwitchWindow = false;
	// WebElement objWebElement = null;
	// List<WebElement> objWebElementCollection;
	// List<WebElement> objFrameCollection;
	// String strCurrentWindowHandle = objStep.get("strCurrentWindowHandle").toString();
	// strTag = objStep.get("strTagName").toString().toLowerCase();
	// String arrAttributeNames[] = objStep.get("strAttributeNames").toString().split("\\|", -1);
	// String arrAttributeValues[] = objStep.get("strAttributeValues").toString().split("\\|", -1);
	// String strXpathAttributesTemp = "";
	// String strXpathAttributes = "";
	// if (strTag.toLowerCase().equals("alert")) {
	// // try {
	// // Alert alert = objWebDriver.switchTo().alert();
	// // // System.out.println(alert.getText()); // Print Alert popup
	// // // alert.sendKeys("tegan");
	// // // alert.accept(); // Close Alert popup
	// // // alert.dismiss();; // Close Alert popup
	// // return null;
	// //
	// // } catch (Exception e) {
	// // System.out.println(e.toString());
	// // }
	// // TODO elementFind finish alert handling
	// try {
	// // objWebDriver.switchTo().alert();
	// objStep.put("strTagType", "alert");
	// @SuppressWarnings("unused")
	// Alert alert = objWebDriver.switchTo().alert();
	// System.out.println("this is the alert switch to which did not fail");
	// // System.out.println(objWebDriver.manage().window().getPosition());
	// // System.out.println(objWebDriver.manage().window().getSize());
	// return null;
	// } // try
	// catch (NoAlertPresentException e) {
	// // return false;
	// System.out.println("this is the alert switch to which did fail");
	// System.out.println(e.toString());
	// throw new ElementNotFoundException("Alert popup was not found.");
	// } // catch
	// }
	// for (int intAttributeEach = 0; intAttributeEach < arrAttributeNames.length; intAttributeEach++) {
	// strXpathAttributesTemp = "";
	// switch (arrAttributeNames[intAttributeEach].toLowerCase()) {
	// case "index":
	// strIndex = "[" + arrAttributeValues[intAttributeEach] + "]";
	// break;
	// case "text":
	// if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
	// strXpathAttributesTemp = "contains(text()" + ", '" + arrAttributeValues[intAttributeEach].substring(3) + "')";
	// } else {
	// strXpathAttributesTemp = "text()='" + arrAttributeValues[intAttributeEach] + "' ";
	// }
	// break;
	// default:
	// if (arrAttributeNames[intAttributeEach].toLowerCase().equals("type")) {
	// objStep.put("strType", arrAttributeValues[intAttributeEach]);
	// }
	// if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
	// strXpathAttributesTemp = "contains(@" + arrAttributeNames[intAttributeEach] + ", '" + arrAttributeValues[intAttributeEach].substring(3) + "')";
	// } else {
	// strXpathAttributesTemp = "@" + arrAttributeNames[intAttributeEach] + "='" + arrAttributeValues[intAttributeEach] + "'";
	// }
	// break;
	// }
	// if (strXpathAttributesTemp.trim().length() != 0) {
	// if (strXpathAttributes.trim().length() == 0) {
	// strXpathAttributes = strXpathAttributesTemp;
	// } else {
	// strXpathAttributes = strXpathAttributes + " and " + strXpathAttributesTemp;
	// }
	// }
	// }// for (int intAttributeEach
	// if (strXpathAttributes.trim().length() == 0) {
	// strXpathAttributes = "";
	// } else {
	// strXpathAttributes = "[" + strXpathAttributes + "]";
	// }
	// strXpath = "(//" + strTag + strXpathAttributes + ")" + strIndex;
	// System.out.println("elementFind strXpath = " + strXpath);
	// // System.out.println("elementFind lngMillisecondsWaitedByCreateXpath = "
	// // + (System.currentTimeMillis() - lngStartTimeByCreateXpath));
	// // long lngStartTimeByCreateForGetWindowHandles =
	// // System.currentTimeMillis();
	// // objWebDriver.getWindowHandles()
	// // Set<String> arrHandles = objWebDriver.getWindowHandles();
	// // <String> st =
	// // objWebDriver.getWindowHandles().iterator().hasNext();
	// // ArrayList<String> arrHandles = new ArrayList<String>();
	// // @SuppressWarnings("unchecked")
	// // ArrayList<String> arrHandles = (ArrayList<String>)
	// // objWebDriver.getWindowHandles();
	// // List<WebElement> objWebElementCollection =
	// // objWebDriver.findElements(By.tagName(strTagName));
	// // Iterator<String> arrHandlesEach = ((Collection<String>)
	// // arrHandles).iterator();
	// // objWebDriver.getWindowHandles().iterator().hasNext()
	// // Iterator<String> objWebElementEach = (Iterator<String>)
	// // ((Collection<String>) objWebDriver.getWindowHandles().iterator();
	// // Object[] arrHandles = objWebDriver.getWindowHandles().toArray();
	// // for (int intHandlesEach = 0; intHandlesEach < arrHandles.length;
	// // intHandlesEach++)
	// // while (objWebDriver.getWindowHandles().iterator().hasNext()) {
	// // string winHandle = arrHandles[intHandlesEach].toString();
	// // //for (String winHandle ;arrHandles ;1++) {
	// // for (int intHandlesEach = 0; intHandlesEach <
	// // arrHandles.size(); intHandlesEach++)
	// // String strCurrentWindowHandle = objWebDriver.getWindowHandle();
	// System.out.println("elementFind before loop strCurrentWindowHandle = " + strCurrentWindowHandle);
	// // System.out.println("elementFind before defaultContent strCurrentWindowHandle = "
	// // + objWebDriver.getWindowHandles().size());
	// // objWebDriver.switchTo().defaultContent();
	// // System.out.println("elementFind after defaultContent strCurrentWindowHandle = "
	// // + objWebDriver.getWindowHandles().size());
	// // objWebDriver.switchTo().defaultContent();
	// Object[] arrHandles = objWebDriver.getWindowHandles().toArray();
	// System.out.println("arrHandles.length = " + arrHandles.length);
	// for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
	// // objWebDriver.switchTo().defaultContent();
	// String winHandle = arrHandles[intHandlesEach].toString();
	// System.out.println("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
	// System.out.println("elementFind winHandle = " + winHandle);
	// long lngStartTimeSwitchTo = System.currentTimeMillis();
	// objWebDriver.switchTo().window(winHandle);
	// // if (strCurrentWindowHandle.equals(winHandle)) {
	// // } else {
	// // objWebDriver.switchTo().window(winHandle);
	// // System.out.println("elementFind lngStartTimeSwitchTo = " +
	// // (System.currentTimeMillis() - lngStartTimeSwitchTo));
	// // blnSwitchWindow = true;
	// // }
	// System.out.println("elementFind lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
	// System.out.println("elementFind objWebDriver.getTitle = " + objWebDriver.getTitle());
	// long intBrowserInnerWidth = 0;
	// long intBrowserInnerHeight = 0;
	// try {
	// intBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
	// intBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
	// System.out.println("intBrowserInnerWidth = " + intBrowserInnerWidth);
	// System.out.println("intBrowserInnerHeight = " + intBrowserInnerHeight);
	// } catch (WebDriverException e) {
	// throw new ElementNotFoundException("WebDriverException returned");
	// } catch (Exception e) {
	// System.out.println("BodyoffsetHeight = " + e.toString());
	// intBrowserInnerWidth = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetWidth;");
	// intBrowserInnerHeight = (long) ((JavascriptExecutor) objWebDriver).executeScript("return document.body.offsetHeight;");
	// System.out.println("BodyoffsetWidth = " + intBrowserInnerWidth);
	// System.out.println("BodyoffsetHeight = " + intBrowserInnerHeight);
	// }
	// objStep.put("intBrowserInnerWidth", intBrowserInnerWidth);
	// objStep.put("intBrowserInnerHeight", intBrowserInnerHeight);
	// // TODO cleanup old code from get absolute coordinates attempts
	// // int intWebElementBodyX =
	// // Integer.parseInt(objStep.get("intWebElementBodyX").toString());
	// // int intWebElementBodyY =
	// // Integer.parseInt(objStep.get("intWebElementBodyY").toString());
	// // int intWebElementBodyWidth =
	// // Integer.parseInt(objStep.get("intWebElementBodyWidth").toString());
	// // int intWebElementBodyHeight =
	// // Integer.parseInt(objStep.get("intWebElementBodyHeight").toString());
	// // if (blnSwitchWindow == true || intWebElementBodyX +
	// // intWebElementBodyY + intWebElementBodyWidth +
	// // intWebElementBodyHeight == 0) {
	// // blnSwitchWindow = false;
	// // long lngStartTimeManageWindow = System.currentTimeMillis();
	// // Point objWebDriverPoint =
	// // objWebDriver.manage().window().getPosition();
	// // int intBrowserOuterX = objWebDriverPoint.x;
	// // int intBrowserOuterY = objWebDriverPoint.y;
	// // Dimension objWebDriverDimension =
	// // objWebDriver.manage().window().getSize();
	// // int intBrowserOuterWidth = objWebDriverDimension.width;
	// // int intBrowserOuterHeight = objWebDriverDimension.height;
	// // System.out.println("elementAbsoluteCoordinates intBrowserOuterX, Y  intBrowserOuterWidth, Height = "
	// // + objWebDriverPoint + " " + objWebDriverDimension + " " +
	// // (System.currentTimeMillis() - lngStartTimeManageWindow));
	// //
	// // long innerWidth = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
	// // long innerHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
	// //
	// // objStep.put("intoffsetWidth", innerWidth);
	// // objStep.put("intoffsetHeight", innerHeight);
	// //
	// // objStep.put("intBrowserOuterX", intBrowserOuterX);
	// // objStep.put("intBrowserOuterY", intBrowserOuterY);
	// // objStep.put("intBrowserOuterWidth", intBrowserOuterWidth);
	// // objStep.put("intBrowserOuterHeight", intBrowserOuterHeight);
	// // long lngWindowInnerHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return window.innerHeight;");
	// // long lngDocumentElementClientHeight = (long)
	// // ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.documentElement.clientHeight;");
	// // long lngBodyClientHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.body.clientHeight;");
	// //
	// // long offsetWidth = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.body.offsetWidth;");
	// // long offsetHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.body.offsetHeight;");
	// // long offsetTop = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.body.offsetTop;");
	// // long offsetLeft = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.body.offsetLeft;");
	// //
	// // long clientWidth = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.body.clientWidth;");
	// // long clientHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.body.clientHeight;");
	// //
	// // long htmlOffsetWidth = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.documentElement.offsetWidth;");
	// // long htmlOffsetHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.documentElement.offsetHeight;");
	// // long htmlClientWidth = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.documentElement.clientWidth;");
	// // long htmlClientHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.documentElement.clientHeight;");
	//
	// // var body = document.body, html = document.documentElement;
	// // var height = Math.max(body.scrollHeight, body.offsetHeight,
	// // html.clientHeight, html.scrollHeight, html.offsetHeight);
	//
	// // System.out.println("innerWidth = " + innerWidth);
	// // System.out.println("innerHeight = " + innerHeight);
	//
	// // System.out.println("lngWindowInnerHeight = " +
	// // lngWindowInnerHeight);
	// // System.out.println("lngDocumentElementClientHeight = " +
	// // lngDocumentElementClientHeight);
	// // System.out.println("lngBodyClientHeight = " +
	// // lngBodyClientHeight);
	// //
	// // System.out.println("BodyoffsetWidth = " + offsetWidth);
	// // System.out.println("BodyoffsetHeight = " + offsetHeight);
	// // System.out.println("BodyoffsetTop = " + offsetTop);
	// // System.out.println("BodyoffsetLeft = " + offsetLeft);
	// //
	// // System.out.println("BodyclientWidth = " + clientWidth);
	// // System.out.println("BodyclientHeight = " + clientHeight);
	// //
	// // System.out.println("htmlOffsetWidth = " + htmlOffsetWidth);
	// // System.out.println("htmlOffsetHeight = " + htmlOffsetHeight);
	// // System.out.println("htmlClientWidth = " + htmlClientWidth);
	// // System.out.println("htmlClientHeight = " + htmlClientHeight);
	// // objStep.put("intoffsetWidth", offsetWidth);
	// // objStep.put("intoffsetHeight", offsetHeight);
	// // objStep.put("intoffsetWidth", htmlOffsetWidth);
	// // objStep.put("intoffsetHeight", htmlOffsetHeight);
	// // long scrollBarWidth = offsetWidth - clientWidth;
	// // long scrollBarHeight = offsetHeight - clientHeight;
	// // System.out.println("scrollBarWidth = " + scrollBarWidth);
	// // System.out.println("scrollBarHeight = " + scrollBarHeight);
	// // window.screenX
	// // window.screenY
	// // long innerWidth = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return window.innerWidth;");
	// // long innerHeight = (long) ((JavascriptExecutor)
	// // objWebDriver).executeScript("return window.innerHeight;");
	// // System.out.println("elementFind innerWidth innerHeight  = " +
	// // innerWidth + " " + innerHeight);
	// // long lngStartTimeHtmlXpath = System.currentTimeMillis();
	// // WebElement objWebElementHtml =
	// // objWebDriver.findElement(By.xpath("/html"));
	// // System.out.println("elementFind objWebElementHtml intMillisecondsWaited = "
	// // + (System.currentTimeMillis() - lngStartTimeHtmlXpath));
	// // long lngStartTimeHtmlCoordinates =
	// // System.currentTimeMillis();
	// // Coordinates objWebElementHtmlCoordinates = ((Locatable)
	// // objWebElementHtml).getCoordinates();
	// // Point objHtmlViewPortPoint =
	// // objWebElementHtmlCoordinates.inViewPort();
	// // System.out.println("elementFind objHtmlViewPortPoint.x = " +
	// // objHtmlViewPortPoint.x);
	// // System.out.println("elementFind objHtmlViewPortPoint.y = " +
	// // objHtmlViewPortPoint.y);
	// // // objStep.put("intWebElementBodyX", objHtmlViewPortPoint.x);
	// // // objStep.put("intWebElementBodyY", objHtmlViewPortPoint.y);
	// // System.out.println("elementFind objBodyViewPortPoint X & Y intMillisecondsWaited = "
	// // + objWebElementHtmlCoordinates + " " +
	// // (System.currentTimeMillis() - lngStartTimeHtmlCoordinates));
	// // long lngStartTimeHtmlDimension = System.currentTimeMillis();
	// // Dimension objWebElementHtmlDimension =
	// // objWebElementHtml.getSize();
	// // System.out.println("elementFind objWebElementHtmlDimension.width = "
	// // + objWebElementHtmlDimension.width);
	// // System.out.println("elementFind objWebElementHtmlDimension.height = "
	// // + objWebElementHtmlDimension.height);
	// // objStep.put("intWebElementBodyWidth",
	// // objWebElementBodyDimension.width);
	// // objStep.put("intWebElementBodyHeight",
	// // objWebElementBodyDimension.height);
	// // long lngStartTimeBodyXpath = System.currentTimeMillis();
	// // WebElement objWebElementBody =
	// // objWebDriver.findElement(By.xpath("/html/body"));
	// // System.out.println("elementFind objWebElementBody intMillisecondsWaited = "
	// // + (System.currentTimeMillis() - lngStartTimeBodyXpath));
	// // long lngStartTimeBodyCoordinates =
	// // System.currentTimeMillis();
	// // Coordinates objWebElementBodyCoordinates = ((Locatable)
	// // objWebElementBody).getCoordinates();
	// // Point objBodyViewPortPoint =
	// // objWebElementBodyCoordinates.inViewPort();
	// // objStep.put("intWebElementBodyX", objBodyViewPortPoint.x);
	// // objStep.put("intWebElementBodyY", objBodyViewPortPoint.y);
	// // System.out.println("elementFind objBodyViewPortPoint X & Y intMillisecondsWaited = "
	// // + objWebElementBodyCoordinates + " " +
	// // (System.currentTimeMillis() - lngStartTimeBodyCoordinates));
	// // long lngStartTimeBodyDimension = System.currentTimeMillis();
	// // Dimension objWebElementBodyDimension =
	// // objWebElementBody.getSize();
	// // System.out.println("elementFind objWebElementBodyDimension.width = "
	// // + objWebElementBodyDimension.width);
	// // System.out.println("elementFind objWebElementBodyDimension.height = "
	// // + objWebElementBodyDimension.height);
	// // objStep.put("intWebElementBodyWidth",
	// // objWebElementBodyDimension.width);
	// // objStep.put("intWebElementBodyHeight",
	// // objWebElementBodyDimension.height);
	// // objStep.put("intWebElementBodyWidth", innerWidth);
	// // objStep.put("intWebElementBodyHeight", innerHeight);
	// // System.out.println("elementFind objWebElementBodyDimension intMillisecondsWaited = "
	// // + objWebElementBodyDimension + " " +
	// // (System.currentTimeMillis() - lngStartTimeBodyDimension));
	// // } // if (blnSwitchWindow == true
	// // long lngStartTimeFrameCollection =
	// // System.currentTimeMillis();
	// // objFrameCollection =
	// // objWebDriver.findElements(By.xpath("//frame"));
	// // //objFrameCollection =
	// // objWebDriver.findElements(By.cssSelector("css=frame"));
	// // int intFramesCount = objFrameCollection.size();
	// // System.out.println("elementFind objFrameCollection = " +
	// // intFramesCount + "  " + (System.currentTimeMillis() -
	// // lngStartTimeFrameCollection));
	// //
	// // if (intFramesCount >= 1) {
	// // intFramesCount = intFramesCount + 1;
	// // System.out.println("elementFind objFrameCollection = " +
	// // intFramesCount + "  " + (System.currentTimeMillis() -
	// // lngStartTimeFrameCollection));
	// // }
	// int intFramesCount = 0;
	// long lngStartTimeFrameCollection = System.currentTimeMillis();
	// // objWebDriver.switchTo().defaultContent();
	// // TODO add iFrame handling, return a collection of both frame
	// // and iframe
	// // objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('iframe');");
	//
	// // Can you just combine the two lists?
	// // List<WebElement> act = driver.findElements(By.className("act"));
	// // List<WebElement> dact = driver.findElements(By.className("dact"));
	// // List<WebElement> all = new ArrayList<WebElement>();
	// // all.addAll(act);
	// // all.addAll(dact);
	// //
	// //
	// // Alternatively, you could use an xpath locator as suggested by @Alejandro
	// // List<WebElement> all = driver.findElements(By.xpath("//*[@class='act' or @class='dact']"));
	//
	// // try {
	// objFrameCollection = objWebDriver.findElements(By.tagName("frame"));
	// //List<WebElement> objFrames = objWebDriver.findElements(By.tagName("frame"));
	// System.out.println("elementFind objFrames.size() = " + objFrameCollection.size());
	// List<WebElement> objIframes = objWebDriver.findElements(By.tagName("iframe"));
	// System.out.println("elementFind objIframes.size() = " + objIframes.size());
	// // objFrameCollection.clear();
	// // System.out.println("elementFind objFrameCollection.clear(); ");
	// intFramesCount = 0;
	// //objFrameCollection.clear;
	// if (objFrameCollection.size() > 0) {
	// //objFrameCollection.addAll(objFrames);
	// intFramesCount = objFrameCollection.size();
	// }
	// if (objIframes.size() > 0) {
	// objFrameCollection.addAll(objIframes);
	// intFramesCount = intFramesCount + objIframes.size();
	// }
	//
	// // System.out.println("elementFind ==null; " + objFrameCollection == null);
	// // if (objFrameCollection == null) {
	// // intFramesCount = 0;
	// // } else {
	// // intFramesCount = objFrameCollection.size();
	// // }
	// // objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('frame');");
	//
	// // objFrameCollection = objWebDriver.findElements(By.xpath("//frame or //iframe"));
	//
	// // objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('frame');");
	// // objFrameCollection = objWebDriver.findElements(By.cssSelector("css=frame"));
	// // objFrameCollection = objWebDriver.findElements(By.xpath("//frame|//iframe"));
	// // objFrameCollection = objWebDriver.findElements(By.tagName("frame"));
	// // objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.getElementsByTagName('frame');");
	// // objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.querySelectorAll('frame');");
	//
	// // objFrameCollection = (List<WebElement>) ((JavascriptExecutor) objWebDriver).executeScript("return document.querySelectorAll(\"frame,iframe\");");
	// // intFramesCount = objFrameCollection.size();
	// // } catch (WebDriverException e) {
	// // // objFrameCollection = 0;
	// // intFramesCount = 0;
	// // System.out.println("elementFind objFrameCollection exception = " + e.toString());
	// //
	// // }
	// // var elems = document.querySelectorAll('frame,iframe')
	//
	// // objFrameCollection =
	// // objWebDriver.findElements(By.xpath("//frame"));
	// // objFrameCollection =
	// // objWebDriver.findElements(By.cssSelector("css=frame"));
	// // intFramesCount = objFrameCollection.size();
	// System.out.println("elementFind objFrameCollection = " + intFramesCount + "  " + (System.currentTimeMillis() - lngStartTimeFrameCollection));
	// if (intFramesCount >= 1) {
	// intFramesCount = intFramesCount + 1;
	// System.out.println("elementFind objFrameCollection = " + intFramesCount + "  " + (System.currentTimeMillis() - lngStartTimeFrameCollection));
	// }
	// for (int intFramesEach = -1; intFramesEach < intFramesCount; intFramesEach++) {
	// System.out.println("elementFind intFramesEach = " + intFramesEach);
	// if (intFramesEach >= 0) {
	// System.out.println("elementFind frames objWebDriver.getWindowHandle = " + objWebDriver.getWindowHandle());
	// objWebDriver.switchTo().defaultContent();
	// objWebDriver.switchTo().frame(intFramesEach);
	// // objWebDriver.switchTo().frame(0);
	// }
	// // strXpath = "(//" + strTag + "[" + strXpathAttributes +
	// // "])" + strIndex;
	// // System.out.println("elementFind strXpath = " + strXpath);
	// long lngStartTimeByXpath = System.currentTimeMillis();
	// objWebElementCollection = objWebDriver.findElements(By.xpath(strXpath));
	// System.out.println("elementFind lngMillisecondsWaitedXpath = " + (System.currentTimeMillis() - lngStartTimeByXpath));
	// System.out.println("elementFind objWebElementCollection.size = " + objWebElementCollection.size());
	// if (objWebElementCollection.size() == 1) {
	// blnFound = true;
	// break;
	// }
	// // long lngStartTimeFrameCollection =
	// // System.currentTimeMillis();
	// //
	// // objFrameCollection = (List<WebElement>)
	// // ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.getElementsByTagName('frame');");
	// //
	// // // objFrameCollection =
	// // objWebDriver.findElements(By.xpath("//frame"));
	// // // objFrameCollection =
	// // objWebDriver.findElements(By.cssSelector("css=frame"));
	// // intFramesCount = objFrameCollection.size();
	// // System.out.println("elementFind objFrameCollection = " +
	// // intFramesCount + "  " + (System.currentTimeMillis() -
	// // lngStartTimeFrameCollection));
	// //
	// // if (intFramesCount >= 1) {
	// // intFramesCount = intFramesCount + 1;
	// // System.out.println("elementFind objFrameCollection = " +
	// // intFramesCount + "  " + (System.currentTimeMillis() -
	// // lngStartTimeFrameCollection));
	// // }
	// // long lngStartTimegetElementsByTagName =
	// // System.currentTimeMillis();
	// // List<WebElement> objFrameCollection2 = (List<WebElement>)
	// // ((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.getElementsByTagName('frame');");
	// // System.out.println("elementFind objFrameCollection2 = " +
	// // objFrameCollection2.size() + " " +
	// // (System.currentTimeMillis() -
	// // lngStartTimegetElementsByTagName));
	// }// the end of for (String intFramesEach
	// switch (objWebElementCollection.size()) {
	// case 0:
	// System.out.println("elementFind - Element properties did not return an element, try refining attributes.");
	// throw new ElementNotFoundException("Element properties did not return an element, try refining attributes");
	// case 1:
	// objWebElement = objWebElementCollection.get(0);
	// objStep.put("strCurrentWindowHandle", objWebDriver.getWindowHandle());
	// if (objStep.get("strTagName").toString().toLowerCase().equals("input")) {
	// if (objStep.get("strType").toString().toLowerCase().length() == 0) {
	// objStep.put("strType", objWebElement.getAttribute("type"));
	// }
	// objStep.put("strTagType", "input_" + objStep.get("strType").toString());
	// } else {
	// objStep.put("strTagType", objStep.get("strTagName").toString());
	// }
	// // objWebElement =
	// // objWebDriver.findElement(By.xpath(strXpath));
	// // break;
	// // JavascriptExecutor executor = (JavascriptExecutor)
	// // objWebDriver;
	// // //
	// // executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	// // // ( function x() { //do something & return value } )()
	// // //
	// // executor.executeScript("arguments[0].scrollIntoView(false);",
	// // objWebElement);
	// // System.out.println("elementFind JavascriptExecutor clientHeight = "
	// // + executor.executeScript("arguments[0].clientHeight;",
	// // objWebElement));
	// // long lngStartTimeElementFindclientWidth =
	// // System.currentTimeMillis();
	// // System.out.println(((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.documentElement.clientWidth")
	// // + " " + (System.currentTimeMillis() -
	// // lngStartTimeElementFindclientWidth));
	// // long lngStartTimeElementFindclientHeight =
	// // System.currentTimeMillis();
	// // System.out.println(((JavascriptExecutor)
	// // objWebDriver).executeScript("return document.documentElement.clientHeight")
	// // + " " + (System.currentTimeMillis() -
	// // lngStartTimeElementFindclientHeight));
	// // String strTitle = (String)
	// // js.executeScript("return document.title");
	// return objWebElement;
	// default:
	// System.out.println("elementFind - Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
	// throw new MultipleElementsFoundException("Element properties did not return an element, try refining attributes");
	// }// the end of switch (objWebElementCollection.size())
	// }// the end of for win Handles
	// } catch (NoSuchFrameException e) {
	// throw new ElementNotFoundException("elementFind " + e.toString());
	// } finally {
	// System.out.println("elementFind finally lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngStartTimeElementFind));
	// }
	// return null;
	// }// the end of elementFind

	// public static WebElement elementFindOriginalWithCommentedCodeToUse(String
	// strTagName, String strAttributeNames, String strAttributeValues,
	// WebDriver objWebDriver, Boolean blnDebugMode) {
	// String strTag;
	// boolean blnFound = false;
	// String strIndex = "";
	// // boolean blnDebugMode = false;
	// WebElement objWebElement = null;
	// List<WebElement> objWebElementCollection = null;
	// try {
	// ArrayList<WebElement> arrWebElements = new ArrayList<WebElement>();
	// System.out.println("elementFind blnDebugMode = " + blnDebugMode);
	// // System.out.println(objWebDriver.getWindowHandle());
	// System.out.println("elementFind strTagName.toLowerCase().startsWith(input_) = "
	// + strTagName.toLowerCase().startsWith("input_"));
	// // String arrHandles[] = objWebDriver.getWindowHandles();
	// // ArrayList <String> arrHandles
	// // arrHandles = objWebDriver.getWindowHandles()
	// if (strTagName.toLowerCase().startsWith("input_")) {
	// strTag = "input";
	// String strType = strTagName.substring(6);
	// strAttributeNames = "type|" + strAttributeNames;
	// strAttributeValues = strType + "|" + strAttributeValues;
	// System.out.println("elementFind strTag = " + strTag);
	// System.out.println("elementFind strType = " + strType);
	// System.out.println("elementFind strAttributeNames = " +
	// strAttributeNames);
	// System.out.println("elementFind strAttributeValues = " +
	// strAttributeValues);
	// } else {
	// strTag = strTagName.toLowerCase();
	// }
	// System.out.println("elementFind strTag = " + strTag);
	// // ArrayList<String> arrHandles = new ArrayList<String>();
	// // arrHandles = (ArrayList<String>) objWebDriver.getWindowHandles();
	// // System.out.println("arrHandles.size() = " + arrHandles.size());
	// // System.out.println("arrHandles.get(0) = " + arrHandles.get(0));
	// // ReadOnlyCollection<string> handles = driver.WindowHandles;
	// // foreach (string handle in handles)
	// // {
	// // if (handle != BaseWindow)
	// // {
	// // string title = driver.SwitchTo().Window(handle).Title;
	// // Thread.Sleep(3000);
	// // driver.SwitchTo().Window(handle).Title.Equals(title);
	// // Thread.Sleep(3000);
	// // }
	// // }
	// for (String winHandle : objWebDriver.getWindowHandles()) {
	// System.out.println("elementFind winHandle = " + winHandle);
	// objWebDriver.switchTo().window(winHandle);
	// // locateElement("Frame", "name", "frame_link", driver);
	// // // webElementCollectionAttributes( "Frame", driver) ;
	// // // driver.switchTo().frame(2);
	// // switchFrame2(driver);
	// // try {
	// // // System.out.println(objWebDriver.getWindowHandle());
	// // objWebDriver.switchTo().window(winHandle);
	// // } catch (NoSuchWindowException e) {
	// // // handle the unsavoriness if needed
	// // System.out
	// // .println("elementFind NoSuchWindowException winHandle = "
	// // + winHandle);
	// // }
	// // }
	// // for (int intHandlesEach = 0; intHandlesEach <
	// // arrHandles.size();
	// // intHandlesEach++) {
	// // objWebDriver.switchTo().window(arrHandles.get(intHandlesEach));
	// // List<WebElement> objWebElementCollection = objWebDriver
	// // .findElements(By.xpath("//" + strTag)[@id='cardNumber']);
	// //
	// // Iterator<WebElement> objWebElementEach =
	// // ((Collection<WebElement>) objWebElementCollection)
	// // .iterator();
	// String arrAttributeNames[] = strAttributeNames.split("\\|", -1);
	// System.out.println("elementFind arrAttributeNames.length = " +
	// arrAttributeNames.length);
	// String arrAttributeValues[] = strAttributeValues.split("\\|", -1);
	// // String strXpath = "//" + strTag + "[@" + arrAttributeNames[0]
	// // + "='" + arrAttributeValues[0] + "']";
	// String strXpathAttributes = null;
	// for (int intAttributeEach = 0; intAttributeEach <
	// arrAttributeNames.length; intAttributeEach++) {
	// if (arrAttributeNames[intAttributeEach].toLowerCase().equals("index")) {
	// strIndex = "[" + arrAttributeValues[intAttributeEach] + "]";
	// } else {
	//
	// if (strXpathAttributes == null) {
	// strXpathAttributes = "@" + arrAttributeNames[intAttributeEach] + "='" +
	// arrAttributeValues[intAttributeEach] + "'";
	// } else {
	// strXpathAttributes = strXpathAttributes + " and @" +
	// arrAttributeNames[intAttributeEach] + "='" +
	// arrAttributeValues[intAttributeEach] + "'";
	// }
	// }
	// // E[@foo="bar" and @foo1="bar1"]
	// }// for (int intAttributeEach
	// // workd but not case insensitive
	// String strXpath = "(//" + strTag + "[" + strXpathAttributes + "])" +
	// strIndex;
	// // String strXpath = "//" + strTag + "[" +
	// // strXpathAttributes.toLowerCase()
	// // + "]";
	// System.out.println("elementFind arrAttributeNames.length = " + strXpath);
	// objWebElementCollection = objWebDriver.findElements(By.xpath(strXpath));
	//
	// if (objWebElementCollection.size() == 0) {
	// break;
	// }
	//
	// // Iterator<WebElement> objWebElementEach =
	// // ((Collection<WebElement>)
	// // objWebElementCollection).iterator();
	// // while (objWebElementEach.hasNext()) {
	// // objWebElement = objWebElementEach.next();
	// // arrWebElements.add(objWebElement);
	// // }
	//
	// // System.out.println("elementFind objWebElementCollection.size() = "
	// // + objWebElementCollection.size());
	// // System.out.println("elementFind arrAttributeValues length = "
	// // + arrAttributeValues.length);
	//
	// }// the end of for (String winHandle :
	// // objWebDriver.getWindowHandles())
	//
	// switch (objWebElementCollection.size()) {
	// case 0:
	// return null;
	// case 1:
	// objWebElement = objWebElementCollection.get(0);
	// if (objWebElement.getSize().width == 0 || objWebElement.getSize().height
	// == 0) {
	// return null;
	// } else {
	// // int intX = objWebElement.getLocation().getX();
	// // int intY = objWebElement.getLocation().getY();
	// // int width = objWebElement.getSize().width;
	// // int height = objWebElement.getSize().height;
	// //
	// // System.out.println("elementFind objWebElement x = " +
	// // objWebElement.getLocation().x);
	// // System.out.println("elementFind objWebElement y = " +
	// // objWebElement.getLocation().y);
	// // System.out.println("elementFind objWebElement intX = " +
	// // intX);
	// // System.out.println("elementFind objWebElement intY = " +
	// // intY);
	// // System.out.println("elementFind objWebElement width = " +
	// // width);
	// // System.out.println("elementFind objWebElement height = "
	// // + height);
	// //
	// // System.out.println("elementFind objWebElement TagName = "
	// // + objWebElement.getAttribute("tagName"));
	//
	// // elementAbsoluteCoordinates(objWebDriver,
	// // objWebElement);
	//
	// // WebElement objParent;
	// // objParent = objWebElement;
	// // while (objParent != null) {
	// // objParent = getParentElement(objWebDriver, objParent);
	// // }
	// return objWebElement;
	//
	// // try {
	// // elementHighlight(intX, intY, width, height, Color.GREEN,
	// // 5, 100);
	// // } catch (InterruptedException e) {
	// // // TODO Auto-generated catch block
	// // }
	// // return objWebElementCollection.get(0);
	// }
	// default:
	// System.out.println("elementFind Element properties did not return a unique element, try again with more attributes.  "
	// + arrWebElements.size());
	// return null;
	// }// the end of switch (objWebElementCollection.size())
	//
	// // if (arrWebElements.size() == 1) {
	// // if (arrWebElements.get(0).getSize().width == 0 ||
	// // arrWebElements.get(0).getSize().height == 0) {
	// // return null;
	// // } else {
	// // int width = arrWebElements.get(0).getSize().width;
	// // int height = arrWebElements.get(0).getSize().height;
	// // int intX = arrWebElements.get(0).getLocation().getX();
	// // int intY = arrWebElements.get(0).getLocation().getY();
	// // try {
	// // elementHighlight(intX, intY, width, height, Color.GREEN, 5, 100);
	// // } catch (InterruptedException e) {
	// // // TODO Auto-generated catch block
	// // }
	// // return arrWebElements.get(0);
	// // }
	// // } else {
	// //
	// System.out.println("elementFind Element properties did not return a unique element, try again with more attributes.  "
	// // + arrWebElements.size());
	// // return null;
	// // }
	// // if (blnDebugMode == false) {
	// // break;
	// // }
	// // System.out.println(objWebDriver.getWindowHandle());
	// } catch (NoSuchWindowException e) {
	// // handle the unsavoriness if needed
	// System.out.println("elementFind NoSuchWindowException ");
	// return null;
	// } catch (StaleElementReferenceException e) {
	// System.out.println("elementFind StaleElementReferenceException ");
	// return null;
	// } catch (NoSuchElementException e) {
	// System.out.println("elementFind NoSuchElementException ");
	// return null;
	// }// the end of try
	// }// the end of elementFind

	// public static WebElement getParentElement(WebDriver objWebDriver,
	// WebElement objWebElement) {
	// try {
	//
	// // int WebDriverwidth =
	// // objWebDriver.manage().window().getSize().width;
	// // int WebDriverheight =
	// // objWebDriver.manage().window().getSize().height;
	// // int WebDriverintX =
	// // objWebDriver.manage().window().getPosition().getX();
	// // int WebDriverintY =
	// // objWebDriver.manage().window().getPosition().getY();
	//
	// WebElement parent = objWebElement.findElement(By.xpath(".."));
	// // int width = parent.getSize().width;
	// // int height = parent.getSize().height;
	// // int intX = parent.getLocation().getX();
	// // int intY = parent.getLocation().getY();
	// // System.out.println("getParentElement parent width = " + width);
	// // System.out.println("getParentElement parent height = " + height);
	// // System.out.println("getParentElement parent intX = " + intX);
	// // System.out.println("getParentElement parent intY = " + intY);
	// // System.out.println("getParentElement parent TagName = " +
	// // parent.getAttribute("tagName"));
	// //
	// // int DriverWidth = 923;
	// // int DriverHeight = 699;
	// // int ParentWidth = 907;
	// // int ParentHeight = 585;
	//
	// // Rectangle newRect = elementAbsoluteCoordinates(objWebDriver,
	// // objWebElement);
	// Rectangle newRect = elementAbsoluteCoordinates(objWebDriver,
	// objWebElement);
	//
	// try {
	// // elementHighlight(WebDriverintX + intX + (DriverWidth -
	// // ParentWidth), WebDriverintY + intY + (DriverHeight -
	// // ParentHeight), width, height, Color.GREEN, 5, 10);
	// // elementHighlight(newRect.x, newRect.y, newRect.width, newRect.height,
	// Color.GREEN, 5, 10);
	// // coordinateScreenshot("element", objWebDriver, objWebElement);
	// } catch (InterruptedException e) {
	// System.out.println("getParentElement InterruptedException ");
	// }
	// return parent;
	// } catch (NoSuchWindowException e) {
	// // handle the unsavoriness if needed
	// System.out.println("getParentElement NoSuchWindowException ");
	// return null;
	// } catch (StaleElementReferenceException e) {
	// System.out.println("getParentElement StaleElementReferenceException ");
	// return null;
	// } catch (NoSuchElementException e) {
	// System.out.println("getParentElement NoSuchElementException ");
	// return null;
	// }
	// }// the end of getParentElement
	// public static Rectangle elementAbsoluteCoordinates(WebDriver
	// objWebDriver, WebElement objWebElement) {
	// int intWebDriverX = objWebDriver.manage().window().getPosition().getX();
	// int intWebDriverY = objWebDriver.manage().window().getPosition().getY();
	// int intWebDriverWidth = objWebDriver.manage().window().getSize().width;
	// int intWebDriverHeight = objWebDriver.manage().window().getSize().height;
	// int intWebElementParentX = 0;
	// int intWebElementParentY = 0;
	// int intWebElementParentWidth = 0;
	// int intWebElementParentHeight = 0;
	// WebElement objWebElementParent;
	// WebElement objWebElementParentLast = null;
	// objWebElementParent = objWebElement;
	// while (objWebElementParent != null) {
	// try {
	// objWebElementParent = objWebElementParent.findElement(By.xpath(".."));
	// objWebElementParentLast = objWebElementParent;
	// // objWebElementParentLast.getCssValue(arg0)
	// // intWebElementParentX =
	// // objWebElementParent.getLocation().getX();
	// // intWebElementParentY =
	// // objWebElementParent.getLocation().getY();
	// // intWebElementParentWidth =
	// // objWebElementParent.getSize().width;
	// // intWebElementParentHeight =
	// // objWebElementParent.getSize().height;
	// // System.out.println("getParentElement objWebElementParent intX = "
	// // + intWebElementParentX);
	// // System.out.println("getParentElement objWebElementParent intY = "
	// // + intWebElementParentY);
	// // System.out.println("getParentElement objWebElementParent width = "
	// // + intWebElementParentWidth);
	// // System.out.println("getParentElement objWebElementParent height = "
	// // + intWebElementParentHeight);
	// // System.out.println("getParentElement objWebElementParent TagName = "
	// // + objWebElementParent.getAttribute("tagName"));
	// // int WebDriverwidth = 923;
	// // int DriverHeight = 699;
	// // int ParentWidth = 907;
	// // int ParentHeight = 585;
	// // try {
	// // elementHighlight(WebDriverintX + intX + WebDriverwidth -
	// // ParentWidth), WebDriverintY + intY + (DriverHeight -
	// // ParentHeight), width, height, Color.GREEN, 5, 10);
	// // } catch (InterruptedException e) {
	// // // TODO Auto-generated catch block
	// // System.out.println("getParentElement InterruptedException ");
	// // }
	// //
	// // Rectangle area2 = new Rectangle(intWebDriverX +
	// // intWebElementParentX + (intWebDriverWidth -
	// // intWebElementParentWidth), intWebDriverY +
	// // intWebElementParentY
	// // + (intWebDriverHeight - intWebElementParentHeight),
	// // intWebElementParentWidth, intWebElementParentHeight);
	// // return area2;
	// } catch (NoSuchWindowException e) {
	// System.out.println("elementAbsoluteCoordinates NoSuchWindowException ");
	// return null;
	// } catch (StaleElementReferenceException e) {
	// System.out.println("elementAbsoluteCoordinates StaleElementReferenceException ");
	// return null;
	// } catch (NoSuchElementException e) {
	// System.out.println("elementAbsoluteCoordinates NoSuchElementException ");
	// objWebElementParent = null;
	// break;
	// }
	// }
	// intWebElementParentX = objWebElementParentLast.getLocation().getX();
	// intWebElementParentY = objWebElementParentLast.getLocation().getY();
	// intWebElementParentWidth = objWebElementParentLast.getSize().width;
	// intWebElementParentHeight = objWebElementParentLast.getSize().height;
	//
	// int intWebElementX = objWebElement.getLocation().getX();
	// int intWebElementY = objWebElement.getLocation().getY();
	// int intWebElementWidth = objWebElement.getSize().width;
	// int intWebElementHeight = objWebElement.getSize().height;
	//
	// Rectangle area2 = new Rectangle(intWebDriverX + intWebElementX +
	// (intWebDriverWidth - intWebElementParentWidth), intWebDriverY +
	// intWebElementY + (intWebDriverHeight - intWebElementParentHeight),
	// intWebElementWidth, intWebElementHeight);
	// return area2;
	// }// the end of elementAbsoluteCoordinates

	// public static Rectangle elementAbsoluteCoordinatesAncestor2(WebDriver
	// objWebDriver, WebElement objWebElement) {
	// int intWebElementX = ((Locatable)
	// objWebElement).getCoordinates().onScreen().x;
	// int intWebElementY = ((Locatable)
	// objWebElement).getCoordinates().onScreen().y;
	// // int intWebElementX = ((Locatable)
	// // objWebElement).getCoordinates().inViewPort().x;
	// // int intWebElementY = ((Locatable)
	// // objWebElement).getCoordinates().inViewPort().y;
	// // int intWebElementX = ((Locatable)
	// // objWebElement).getCoordinates().onPage().x;
	// // int intWebElementY = ((Locatable)
	// // objWebElement).getCoordinates().onPage().y;
	//
	// // int intWebElementX = ((Locatable)
	// // objWebElement).getCoordinates().inViewPort().x;
	// // int intWebElementY = ((Locatable)
	// // objWebElement).getCoordinates().inViewPort().y;
	//
	// // Point p = ((Locatable)
	// // objWebElement).getLocationOnScreenOnceScrolledIntoView();
	//
	// int intWebElementWidth = objWebElement.getSize().width;
	// int intWebElementHeight = objWebElement.getSize().height;
	//
	// int intX = intWebElementX;
	// int intY = intWebElementY;
	// int intWidth = intWebElementWidth;
	// int intHeight = intWebElementHeight;
	//
	// Rectangle area2 = new Rectangle(intX, intY, intWidth, intHeight);
	// return area2;
	// }// the end of elementAbsoluteCoordinates

	// public static void elementAbsoluteCoordinates(JSONObject objStep, Integer intThickness, WebDriver objWebDriver, WebElement objWebElement, Rectangle objRectangleArea) {
	// long lngStartTimeElementAbsoluteCoordinatesAncestor = System.currentTimeMillis();
	// try {
	// // int intBottomWindowAdjustment = 0;
	// // int intLeftWindowAdjustment = 0;
	// // int intScrollbar = 0;
	// // int intBrowserOuterX =
	// // Integer.parseInt(objStep.get("intBrowserOuterX").toString());
	// // int intBrowserOuterY =
	// // Integer.parseInt(objStep.get("intBrowserOuterY").toString());
	// // int intBrowserOuterWidth =
	// // Integer.parseInt(objStep.get("intBrowserOuterWidth").toString());
	// // int intBrowserOuterHeight =
	// // Integer.parseInt(objStep.get("intBrowserOuterHeight").toString());
	// //
	// // int intWebElementX =
	// // Integer.parseInt(objStep.get("intWebElementX").toString());
	// // int intWebElementY =
	// // Integer.parseInt(objStep.get("intWebElementY").toString());
	// // int intWebElementWidth =
	// // Integer.parseInt(objStep.get("intElementWidth").toString());
	// // int intWebElementHeight =
	// // Integer.parseInt(objStep.get("intElementHeight").toString());
	// //
	// // int intoffsetWidth =
	// // Integer.parseInt(objStep.get("intoffsetWidth").toString());
	// // int intoffsetHeight =
	// // Integer.parseInt(objStep.get("intoffsetHeight").toString());
	// //
	// // intLeftWindowAdjustment = ((intBrowserOuterWidth - intoffsetWidth
	// // - intScrollbar) / 2);
	// // intBottomWindowAdjustment = ((intBrowserOuterWidth -
	// // intoffsetWidth - intScrollbar) / 2);
	// // int intX = ((intBrowserOuterX + intWebElementX) +
	// // intLeftWindowAdjustment) - intThickness;
	// // int intY = ((intBrowserOuterY + intWebElementY) +
	// // (intBrowserOuterHeight - intoffsetHeight) -
	// // intBottomWindowAdjustment) - intThickness;
	// // int intWidth = intWebElementWidth + (2 * intThickness);
	// // int intHeight = intWebElementHeight + (2 * intThickness);
	// int intX = Integer.parseInt(objStep.get("intElementScreenX").toString()) - intThickness;
	// int intY = Integer.parseInt(objStep.get("intElementScreenY").toString()) - intThickness;
	// int intWidth = Integer.parseInt(objStep.get("intElementWidth").toString()) + (2 * intThickness);
	// int intHeight = Integer.parseInt(objStep.get("intElementHeight").toString()) + (2 * intThickness);
	// System.out.println("elementAbsoluteCoordinates  = " + intX + " " + intY + " " + intWidth + " " + intHeight);
	// objRectangleArea.setBounds(intX, intY, intWidth, intHeight);
	// } finally {
	// System.out.println("elementAbsoluteCoordinates finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementAbsoluteCoordinatesAncestor));
	// // System.out.println("intBrowserOuterWidth = " +
	// // intBrowserOuterWidth);
	// // System.out.println("intBrowserOuterHeight = " +
	// // intBrowserOuterHeight);
	// // System.out.println("elementAbsoluteCoordinates intThickness = " +
	// // intThickness);
	// }
	// }// the end of elementAbsoluteCoordinates

	@SuppressWarnings("unchecked")
	public static void elementCoordinates(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) {
		long lngStartTimeElementAbsoluteCoordinatesAncestor = System.currentTimeMillis();
		try {
			int intScrollbar = 0;
			long lngStartTimeManageWindow = System.currentTimeMillis();
			Point objWebDriverPoint = objWebDriver.manage().window().getPosition();
			int intBrowserOuterX = objWebDriverPoint.x;
			int intBrowserOuterY = objWebDriverPoint.y;
			Dimension objWebDriverDimension = objWebDriver.manage().window().getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			System.out.println("elementCoordinates intBrowserOuterX, Y  intBrowserOuterWidth, Height = " + objWebDriverPoint + " " + objWebDriverDimension + " " + (System.currentTimeMillis() - lngStartTimeManageWindow));
			objStep.put("intBrowserOuterX", intBrowserOuterX);
			objStep.put("intBrowserOuterY", intBrowserOuterY);
			objStep.put("intBrowserOuterWidth", intBrowserOuterWidth);
			objStep.put("intBrowserOuterHeight", intBrowserOuterHeight);
			System.out.println("elementCoordinates intBrowserOuterX = " + intBrowserOuterX);
			System.out.println("elementCoordinates intBrowserOuterY = " + intBrowserOuterY);
			System.out.println("elementCoordinates intBrowserOuterWidth = " + intBrowserOuterWidth);
			System.out.println("elementCoordinates intBrowserOuterHeight = " + intBrowserOuterHeight);
			if (objWebElement != null) {
				Coordinates objElementCoordinates = ((Locatable) objWebElement).getCoordinates();
				Point objElementPoint = objElementCoordinates.inViewPort();
				Dimension objElementDimension = objWebElement.getSize();
				objStep.put("intElementX", objElementPoint.x);
				objStep.put("intElementY", objElementPoint.y);
				objStep.put("intElementWidth", objElementDimension.width);
				objStep.put("intElementHeight", objElementDimension.height);
			}
			// long intBrowserInnerWidth = 0;
			// long intBrowserInnerHeight = 0;
			// try {
			// intBrowserInnerWidth = (long) ((JavascriptExecutor)
			// objWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
			// intBrowserInnerHeight = (long) ((JavascriptExecutor)
			// objWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			// System.out.println("intBrowserInnerWidth = " +
			// intBrowserInnerWidth);
			// System.out.println("intBrowserInnerHeight = " +
			// intBrowserInnerHeight);
			// } catch (Exception e) {
			// System.out.println("BodyoffsetHeight = " + e.toString());
			// intBrowserInnerWidth = (long) ((JavascriptExecutor)
			// objWebDriver).executeScript("return document.body.offsetWidth;");
			// intBrowserInnerHeight = (long) ((JavascriptExecutor)
			// objWebDriver).executeScript("return document.body.offsetHeight;");
			// System.out.println("BodyoffsetWidth = " + intBrowserInnerWidth);
			// System.out.println("BodyoffsetHeight = " +
			// intBrowserInnerHeight);
			// }
			// objStep.put("intBrowserInnerWidth", intBrowserInnerWidth);
			// objStep.put("intBrowserInnerHeight", intBrowserInnerHeight);
			System.out.println("elementCoordinates objStep.containsKey = " + objStep.containsKey("intElementX"));
			if (objStep.containsKey("intElementX")) {

				int intBrowserInnerWidth = Integer.parseInt(objStep.get("intBrowserInnerWidth").toString());
				int intBrowserInnerHeight = Integer.parseInt(objStep.get("intBrowserInnerHeight").toString());

				int intElementX = Integer.parseInt(objStep.get("intElementX").toString());
				int intElementY = Integer.parseInt(objStep.get("intElementY").toString());
				int intElementWidth = Integer.parseInt(objStep.get("intElementWidth").toString());
				int intElementHeight = Integer.parseInt(objStep.get("intElementHeight").toString());
				System.out.println("elementCoordinates intElementX = " + intElementX);
				System.out.println("elementCoordinates intElementY = " + intElementY);
				System.out.println("elementCoordinates intElementWidth = " + intElementWidth);
				System.out.println("elementCoordinates intElementHeight = " + intElementHeight);

				int intWindowBorder = (int) ((intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2);

				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (int) ((intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder);

				objStep.put("intElementScreenX", intElementScreenX);
				objStep.put("intElementScreenY", intElementScreenY);

				System.out.println("elementCoordinates intWindowBorder = " + intWindowBorder);
				System.out.println("elementCoordinates intElementScreenX = " + intElementScreenX);
				System.out.println("elementCoordinates intElementScreenY = " + intElementScreenY);
			}
			// intBottomWindowAdjustment = ((intBrowserOuterWidth -
			// intoffsetWidth - intScrollbar) / 2);
			// int intElementHighlightX = ((intBrowserOuterX + intElementX) +
			// intWindowBorder) - intThickness;
			// int intElementHighlightY = ((intBrowserOuterY + intElementY) +
			// (intBrowserOuterHeight - intBrowserInnerHeight) -
			// intWindowBorder) - intThickness;
			// int intElementHighlightWidth = intElementWidth + (2 *
			// intThickness);
			// int intElementHighlightHeight = intElementHeight + (2 *
			// intThickness);

			// objStep.put("intElementWidth", intElementWidth);
			// objStep.put("intElementHeight", intElementHeight);

			// objStep.put("intElementHighlightX", intElementHighlightX);
			// objStep.put("intElementHighlightY", intElementHighlightY);
			// objStep.put("intElementHighlightWidth",
			// intElementHighlightWidth);
			// objStep.put("intElementHighlightHeight",
			// intElementHighlightHeight);
			//
			// System.out.println("elementAbsoluteCoordinates  = " +
			// intElementHighlightX + " " + intElementHighlightY + " " +
			// intElementHighlightWidth + " " + intElementHighlightHeight);
			// objRectangleArea.setBounds(intElementHighlightX,
			// intElementHighlightY, intElementHighlightWidth,
			// intElementHighlightHeight);
		} finally {
			System.out.println("elementCoordinates finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementAbsoluteCoordinatesAncestor));
			// System.out.println("intBrowserOuterWidth = " +
			// intBrowserOuterWidth);
			// System.out.println("intBrowserOuterHeight = " +
			// intBrowserOuterHeight);
			// System.out.println("elementAbsoluteCoordinates intThickness = " +
			// intThickness);
		}
	}// the end of elementCoordinates

	@SuppressWarnings("unchecked")
	public static boolean elementVisibleOriginal(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotVisibleException {
		long lngStartTimeElementVisible = System.currentTimeMillis();
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
				} // try
				catch (NoAlertPresentException e) {
					// return false;
					System.out.println(e.toString());
					throw new ElementNotVisibleException("Alert popup was not found.");
				} // catch
			}
			String[] arrClassNameHidden;
			String[] arrClassNameVisible;
			Integer intClassNameEach;
			Integer intClassNameHiddenEach;
			Integer intClassNameVisibleEach;
			// Dim objWebObject;
			String strClassName;
			String strObjectStyleDisplay;
			String strObjectStyleVisibility;
			String strClassNameHidden;
			String strClassNameVisible;
			String[] arrClassName;
			// Set objWebObject = objObject.Object
			// list of classnames to make the object hidden seperated by '|'
			strClassNameHidden = "";
			// list of classnames to make the object visible seperated by '|'
			strClassNameVisible = "";
			strClassName = objWebElement.getAttribute("class");
			arrClassName = strClassName.split(" ");
			arrClassNameHidden = strClassNameHidden.split("|");
			arrClassNameVisible = strClassNameVisible.split("|");
			// TODO elementVisible add check for class and css, commented code
			// needs to be tested
			if (objWebElement.isDisplayed()) {
				// System.out.println("elementVisible objWebElement.isDisplayed() = "
				// + objWebElement.isDisplayed());
				// for (intClassNameEach = 0; intClassNameEach <
				// arrClassName.length; intClassNameEach++) {
				//
				// for (intClassNameHiddenEach = 0; intClassNameHiddenEach <
				// arrClassNameHidden.length; intClassNameHiddenEach++) {
				// // check for a empty value in the case a pipe is left
				// // hanging
				// if (arrClassName[intClassNameEach].trim() != "") {
				// if
				// (arrClassName[intClassNameEach].toLowerCase().equals(arrClassNameHidden[intClassNameHiddenEach].toLowerCase()))
				// {
				// return false;
				// }
				// }
				// }// the end of for (intClassNameHiddenEach = 0;
				//
				// for (intClassNameVisibleEach = 0; intClassNameVisibleEach <
				// arrClassNameVisible.length; intClassNameVisibleEach++) {
				// if (arrClassName[intClassNameEach].trim() != "") {
				// if
				// (arrClassName[intClassNameEach].toLowerCase().equals(arrClassNameVisible[intClassNameVisibleEach].toLowerCase()))
				// {
				//
				//
				// // return true;
				// }
				// }
				// }
				//
				// }// the end of for (intClassNameEach = 0; intClassNameEach <
				// // arrClassName.length; intClassNameEach++)
				// // check the objects visibility style, return false and exit
				// function if value is hidden or collapse
				// strObjectStyleVisibility =
				// LCase(objWebObject.Style.visibility)
				// If strObjectStyleVisibility = "hidden" Or
				// strObjectStyleVisibility = "collapse" Then
				// elementVisible = False
				// Err.Clear
				// On Error GoTo 0
				// Exit Function
				// End If
				// // check the objects display style, return false and exit
				// function if value is none
				// strObjectStyleDisplay = LCase(objWebObject.Style.display)
				// If strObjectStyleDisplay = "none" Then
				// elementVisible = False
				// Err.Clear
				// On Error GoTo 0
				// Exit Function
				// End If
				// checks if object has height and width (some objects are
				// hidden by
				// settting either of these values to 0
				// System.out.println("elementVisible getSize = " +
				// objWebElement.getSize().width + "  " +
				// objWebElement.getSize().height);
				// this works and is needed but costs a couple of hundred ms to
				// return
				// long lngStartTimeElementWidth = System.currentTimeMillis();
				// int intElementWidth = objWebElement.getSize().width;
				// System.out.println("elementVisible intElementWidth  = " +
				// intElementWidth + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeElementWidth));
				//
				// long lngStartTimeElementHeight = System.currentTimeMillis();
				// int intElementHeight = objWebElement.getSize().height;
				// System.out.println("elementVisible intElementHeight  = " +
				// intElementHeight + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeElementHeight));

				// WebElement element =
				// driver.findElement(By.id("tabs")).findElement(By.className("youarehere"));
				// Point p = element.getLocation();
				// ((JavascriptExecutor) driver).executeScript("window.scroll("
				// + p.getX() + "," + (p.getY() + 200) + ");");

				// long lngStartTimeWebElementinViewPort =
				// System.currentTimeMillis();
				// Coordinates objWebElementCoordinates = ((Locatable)
				// objWebElement).getCoordinates();
				// Point objWebElementPoint =
				// objWebElementCoordinates.inViewPort();
				// System.out.println("elementVisible objWebElementPoint  = " +
				// objWebElementPoint + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() -
				// lngStartTimeWebElementinViewPort));
				// int intElementX = objWebElementPoint.x;
				// int intElementY = objWebElementPoint.y;
				// System.out.println("elementVisible intWebElementinViewPortX  = "
				// + intWebElementX + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() -
				// lngStartTimeWebElementinViewPort));
				// System.out.println("elementVisible intWebElementinViewPortY  = "
				// + intWebElementY + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() -
				// lngStartTimeWebElementinViewPort));
				// long lngStartTimeElementDimension =
				// System.currentTimeMillis();
				// Dimension objElementDimensions = objWebElement.getSize();
				// System.out.println("elementVisible dimensions  = " +
				// dimensions + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeElementDimension));
				// long lngStartTimeElementWidth = System.currentTimeMillis();
				// int intElementWidth = objElementDimensions.width;
				// System.out.println("elementVisible intElementWidth  = " +
				// intElementWidth + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeElementWidth));
				// long lngStartTimeElementHeight = System.currentTimeMillis();
				// int intElementHeight = objElementDimensions.height;
				// System.out.println("elementVisible intElementHeight  = " +
				// intElementHeight + " intMillisecondsWaited = " +
				// (System.currentTimeMillis() - lngStartTimeElementHeight));
				Coordinates objElementCoordinates = ((Locatable) objWebElement).getCoordinates();
				Point objElementPoint = objElementCoordinates.inViewPort();
				Dimension objElementDimension = objWebElement.getSize();
				objStep.put("intElementX", objElementPoint.x);
				objStep.put("intElementY", objElementPoint.y);
				objStep.put("intElementWidth", objElementDimension.width);
				objStep.put("intElementHeight", objElementDimension.height);
				if (objElementDimension.width == 0 || objElementDimension.height == 0) {
					System.out.println("elementVisible getSize = " + objWebElement.getSize().width + "  " + objWebElement.getSize().height);
					System.out.println("elementVisible intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
					throw new ElementNotVisibleException("Element size failed");
				} else {
					elementCoordinates(objStep, objWebDriver, objWebElement);
					// System.out.println("elementVisible getSize = " +
					// objWebElement.getSize().width + "  " +
					// objWebElement.getSize().height);
					// System.out.println("elementVisible intMillisecondsWaited = "
					// + (System.currentTimeMillis() -
					// lngStartTimeElementVisible));
					return true;
				}// the end of objWebElement.getSize
			} else {
				System.out.println("elementVisible objWebElement.isDisplayed() = return false");
				// System.out.println("elementVisible intMillisecondsWaited = "
				// + (System.currentTimeMillis() - lngStartTimeElementVisible));
				throw new ElementNotVisibleException("Element isDisplayed failed");
			}// the end of if (objWebElement.isDisplayed())
		} finally {
			System.out.println("elementVisible finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
		}
	}// the end of elementVisibleOriginal

	@SuppressWarnings("unchecked")
	public static boolean elementVisible(JSONObject objStep, WebDriver objWebDriver, WebElement objWebElement) throws ElementNotVisibleException {
		long lngStartTimeElementVisible = System.currentTimeMillis();
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
				} // try
				catch (NoAlertPresentException e) {
					System.out.println(e.toString());
					throw new ElementNotVisibleException("Alert popup was not found.");
				} // catch
			}
			if (objWebElement.isDisplayed()) {
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

	@SuppressWarnings("unchecked")
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
				} // try
				catch (NoAlertPresentException e) {
					System.out.println(e.toString());
					throw new ElementNotHiddenException("Alert popup was not found.");
				} // catch
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

	public static boolean elementHiddenOriginal(WebElement objWebElement) throws ElementNotHiddenException {
		long lngStartTimeElementHidden = System.currentTimeMillis();
		Dimension objDimensions = null;
		try {
			if (objWebElement.isDisplayed()) {
				System.out.println("elementHidden objWebElement.isDisplayed = true");
				try {
					objDimensions = objWebElement.getSize();
				} catch (Exception e) {
					System.out.println("elementHiddenSync - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
					// elementCoordinates(objStep, objWebDriver);
					return true;
				}
				if (objDimensions.width == 0 || objDimensions.height == 0) {
					System.out.println("elementHidden size 0");
					// elementCoordinates(objStep, objWebDriver);
					return true;
				} else {
					System.out.println("elementHidden size not 0 " + objDimensions);
					throw new ElementNotHiddenException("Element size not 0 " + objDimensions);
				}// the end of objWebElement.getSize
			} else {
				System.out.println("elementHidden objWebElement.isDisplayed = false");
				// elementCoordinates(objStep, objWebDriver);
				return true;
				// throw new
				// ElementNotHiddenException("Element isDisplayed failed");
			}// the end of if (objWebElement.isDisplayed())
				// }catch(WebDriverException){
		} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException e) {
			System.out.println("elementHiddenSync - " + e.toString() + "  lngStartTimeHiddenSync = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
			// elementCoordinates(objStep, objWebDriver);
			return true;
		} finally {
			System.out.println("elementHidden finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
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

	public static String verifyMatch(String strActual, String strExpected) throws ValueNotMatchedException {
		long lngStartTimeVerifyMatch = System.currentTimeMillis();
		try {
			if (strExpected.toLowerCase().startsWith("re:")) {
				String strPattern = strExpected.substring(3);
				System.out.println("verifyMatch RegularExpressionMatch = " + RegularExpressionMatch(strPattern, strActual));
				return RegularExpressionMatch(strPattern, strActual);
			} else {
				if (strExpected.equals(strActual)) {
					System.out.println("verifyMatch matched strActual = " + strActual);
					return strActual;
				} else {
					System.out.println("verifyMatch strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
					throw new ValueNotMatchedException("verifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
				}
			}
		} finally {
			System.out.println("verifyMatch finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeVerifyMatch));
		}
	}// the end of VerifyMatch

	public static String RegularExpressionMatch(String strPattern, String strActualValue) {
		Pattern objPattern = Pattern.compile(strPattern);
		Matcher objMatcher = objPattern.matcher(strActualValue);
		objMatcher.matches();
		String strMatchedString = objMatcher.group(0);
		return strMatchedString;
		// On Error Resume Next
		// '**********************************************************************
		// 'Variable Declaration
		// '**********************************************************************
		// Dim objRegularExpression
		// Dim objMatches
		// Dim objFirstMatch
		// '**********************************************************************
		// 'Variable Assignment
		// '**********************************************************************
		// Set objRegularExpression = CreateObject("vbscript.regexp")
		// ' Set objRegularExpression = New RegExp
		// objRegularExpression.Pattern = "^" & strPattern
		// objRegularExpression.IgnoreCase = False
		// objRegularExpression.Global = False
		// Set objMatches = objRegularExpression.Execute(strActualValue)
		// '**********************************************************************
		// ' Process
		// '**********************************************************************
		// If objMatches.Count <> 0 Then
		// Set objFirstMatch = objMatches.Item(0)
		// RegularExpressionMatch = objFirstMatch.Value
		// Set objFirstMatch = Nothing
		// Else
		// RegularExpressionMatch = False
		// End If
		// Set objMatches = Nothing
		// Set objRegularExpression = Nothing
		// Err.Clear
		// On Error GoTo 0
		// End Function
		// Function TestRegExp()
		// MsgBox
		// RegularExpressionMatch("re:specialRequestPage:specialRequestContinueButton_ID|specialRequestPage:submitButton_ID",
		// "specialRequestPage:submitButton_ID")
	} // the end of RegularExpressionMatch

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
			System.out.println("ElementGet finally strElementGet = " + strElementGet + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementGet));
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
		long lngStartTimeCoordinateHighlightScreenshot = System.currentTimeMillis();
		JFrame objJFrame = new JFrame() {
			{
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				if (Boolean.parseBoolean(objStepHighlightArea.get("blnHighlight").toString()) == true) {
					int intThickness = 5;
					Color objColor2 = null;
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
		// TODO debug objWebDriver instanceof JavascriptExecutor, what does it
		// do and is it needed and debug all browser types
		if (objWebDriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) objWebDriver).executeScript("window.focus();");
		}
	}// the end of windowFocus

	public static void scrollToBottom(WebDriver objWebDriver) {
		// TODO debug all browser types, should use instanceof from
		// windowFocus???? should combine into 1 line?
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

	public static void writeReportToHtml(JSONArray objTestSteps, String file) {
		String strScreenshotFilePath = "";
		StringBuilder builder = new StringBuilder();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			builder.append("<!DOCTYPE html>");
			builder.append("<html lang=\"en\">");
			builder.append("<head><title>Run Results</title></head>");
			builder.append("<body>");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				JSONObject objStep = (JSONObject) objTestSteps.get(intTestStepRow);
				builder.append("<div id=step_" + intTestStepRow + ">");
				builder.append("<TABLE border=1 width=100% height=10%>");
				builder.append("<TR>");
				builder.append("<TD width= 100px align=center valign=middle>Expected</TD>");
				builder.append("<TD align=left valign=middle>" + objStep.get("strAction").toString() + "</TD>");
				builder.append("</TR>");
				builder.append("<TR>");
				builder.append("<TD align=center valign=middle>Actual</TD>");
				builder.append("<TD align=left valign=middle>" + objStep.get("strStatus").toString() + "</TD>");
				builder.append("</TR>");
				builder.append("</TABLE> ");
				if (objStep.get("strScreenshotFilePath").toString().trim().length() != 0) {
					strScreenshotFilePath = objStep.get("strScreenshotFilePath").toString().replaceAll("\\\\\\\\", "\\");
					builder.append("<IMG alt=\"ReporterScreenShot_1\" src=\"" + strScreenshotFilePath + "\" width=1100 height=700> ");
				}
				// System.out.println("writeReportToHtml strScreenshotFilePath = "
				// + objStep.get("strScreenshotFilePath").toString());
				builder.append("</div>");
				builder.append("<br>");
				builder.append("<br>");
				if (objStep.get("strAction").toString().toLowerCase().equals("break")) {
					break;
				}
			}
			builder.append("</body>");
			builder.append("</html>");
			String html = builder.toString();
			System.out.println(file);
			bw.write(html);
		} catch (Exception e) {
			System.out.println("writeReportToHtml - " + e.toString());
			System.out.println(builder.toString());
		}
	}// the end of writeReportToHtml

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
				// System.out.println("JS value = " + objJavascriptExecutor.executeScript("return arguments[0].value;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// System.out.println("JS innerText = " + objJavascriptExecutor.executeScript("return arguments[0].innerText;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// System.out.println("JS innerHTML = " + objJavascriptExecutor.executeScript("return arguments[0].innerHTML;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				// System.out.println("JS outerHTML = " + objJavascriptExecutor.executeScript("return arguments[0].outerHTML;", objCollectionJS.get(0)) + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeJS));
				//
				// }
				// } catch (ElementNotVisibleException e) {
				// // TODO Auto-generated catch block
				// // e.printStackTrace();
				// }
			}
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

} // the end of Evinrude
