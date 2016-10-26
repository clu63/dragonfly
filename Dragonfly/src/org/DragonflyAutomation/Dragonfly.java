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
package org.DragonflyAutomation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Base64Encoder;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import com.opera.core.systems.OperaDriver;

public class Dragonfly {
	private class AlertFind {
		private boolean run() {
			logger.add("  ==start==>AlertFind " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			try {
				String strAlertPresent = objVariablesSelenium.gobjWebDriver.switchTo().alert().getText();
				logger.add("AlertFind: alert found:  " + strAlertPresent);
				return true;
			} catch (UnhandledAlertException e) {
				logger.add("AlertFind: UnhandledAlertException = " + e.toString());
				return true;
			} catch (NoAlertPresentException e) {
				logger.add("AlertFind: NoAlertPresentException = " + e.toString());
				return false;
			} catch (Exception e) {
				logger.add("AlertFind: Exception = " + e.toString());
				return false;
			} finally {
				logger.add("AlertFind: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class AutoItSetObject {
		private AutoItX objAutoIt;

		private void createObject() {
			logger.add("  ==start==>AutoItSetObject " + getDateTimestamp());
			String strJacobDllVersionToUse;
			JvmBitVersion objJvmBitVersion = new JvmBitVersion();
			if (objJvmBitVersion.get().contains("32")) {
				strJacobDllVersionToUse = "jacob-1.18-x86.dll";
			} else {
				strJacobDllVersionToUse = "jacob-1.18-x64.dll";
			}
			logger.add("AutoItSetObject: " + System.getProperty("java.library.path") + " " + getDateTimestamp());
			logger.add("AutoItSetObject: " + strJacobDllVersionToUse + " " + getDateTimestamp());
			File objFile = new File("Libraries", strJacobDllVersionToUse);
			logger.add("AutoItSetObject: " + LibraryLoader.JACOB_DLL_PATH + " " + getDateTimestamp());
			logger.add("AutoItSetObject: " + objFile.getAbsolutePath() + " " + getDateTimestamp());
			System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
			objAutoIt = new AutoItX();
		}

		private AutoItX getObject() {
			return objAutoIt;
		}
	}

	private class BrowserClose {
		private BrowserClose() {
			objVariablesSelenium.gobjWebDriver.close();
			objVariablesSelenium.gobjWebDriver.quit();
			variablesJSON.objectStep.putValue("strStatus", "pass");
			new CoordinateHighlightScreenshot(variablesJSON.objectStep);
		}
	}

	private class BrowserCloseSync {
		private BrowserCloseSync() {
			// TODO create a browserCloseSync to manage reporting and sync close
			new BrowserClose();
		}
	}

	private class BrowserLaunch {
		private BrowserLaunch() throws ExceptionBrowserDriverNotSupported {
			// TODO combine duplicate code
			// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
			logger.add("  ==start==>BrowserLaunch " + getDateTimestamp());
			Long lngTimeStart = System.currentTimeMillis();
			logger.add("objVariablesCommon.gstrBrowserSelection = " + objVariablesCommon.gstrBrowserSelection);
			if (objVariablesCommon.gstrBrowserSelection != "TestValue") {
				variablesJSON.objectStep.putValue("strTagName", objVariablesCommon.gstrBrowserSelection);
			}
			DesiredCapabilities objDesiredCapabilities = null;
			try {
				variablesJSON.objectStep.putValue("strStatus", "pass");
				switch (variablesJSON.objectStep.getString("strTagName")) {
				case "firefox":
					objVariablesSelenium.gobjWebDriver = new FirefoxDriver();
					objVariablesSelenium.gobjWebDriver.get(variablesJSON.objectStep.getString("strInputValue"));
					objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					Actions myAction = new Actions(objVariablesSelenium.gobjWebDriver);
					myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
					break;
				case "ie":
					//new SleepMilliseconds(1000);
					logger.add("BrowserLaunch: DesiredCapabilities");
					objDesiredCapabilities = DesiredCapabilities.internetExplorer();
					logger.add("BrowserLaunch: objDesiredCapabilities.toString()" + objDesiredCapabilities);
					logger.add("BrowserLaunch: setJavascriptEnabled");
					objDesiredCapabilities.setJavascriptEnabled(true);
					logger.add("BrowserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
					logger.add("BrowserLaunch: IE_ENSURE_CLEAN_SESSION");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					logger.add("BrowserLaunch: REQUIRE_WINDOW_FOCUS");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					logger.add("BrowserLaunch: INITIAL_BROWSER_URL");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
					logger.add("BrowserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					logger.add("BrowserLaunch: new InternetExplorerDriver(desiredCapabilities)");
					objVariablesSelenium.gobjWebDriver = new InternetExplorerDriver(objDesiredCapabilities);
					//objVariablesSelenium.gobjWebDriver.manage().getCookieNamed("JSESSIONID");
					// objVariablesSelenium.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
					logger.add("BrowserLaunch: variablesJSON.objectStep.getString(strInputValue)  = " + variablesJSON.objectStep.getString("strInputValue"));
					objVariablesSelenium.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					//objVariablesSelenium.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
					objVariablesSelenium.gobjWebDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
					objVariablesSelenium.gobjWebDriver.get(variablesJSON.objectStep.getString("strInputValue"));
					// logger.add("browserLaunch: getCookieNamed(JSESSIONID) = " + objVariablesSelenium.gobjWebDriver.manage().getCookieNamed("JSESSIONID").toString());
					logger.add("BrowserLaunch: objVariablesSelenium.gobjWebDriver.manage().window().maximize()");
					objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					//Capabilities getCapabilities();
					break;
				case "chrome":
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					options.addArguments("disable-popup-blocking");
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					//WebDriver driver = new ChromeDriver(capabilities);
					switch (objOperatingSystem.strOS) {
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
					objVariablesSelenium.gobjWebDriver = new ChromeDriver(capabilities);
					objVariablesSelenium.gobjWebDriver.get(variablesJSON.objectStep.getString("strInputValue"));
					objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					break;
				case "safari":
					objVariablesSelenium.gobjWebDriver = new SafariDriver();
					objVariablesSelenium.gobjWebDriver.get(variablesJSON.objectStep.getString("strInputValue"));
					objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					break;
				case "opera":
					// TODO OperaDriver setup latest driver and test desiredCapabilities = DesiredCapabilities.internetExplorer();
					// desiredCapabilities.setJavascriptEnabled(true);
					//objVariablesSelenium.gobjWebDriver = new OperaDriver();
					//objVariablesSelenium.setGobjWebDriver(new OperaDriver());
					objVariablesSelenium.gobjWebDriver = new OperaDriver();
					objVariablesSelenium.gobjWebDriver.get(variablesJSON.objectStep.getString("strInputValue"));
					// objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					// objVariablesSelenium.gobjWebDriver.manage().window().setPosition(new Point(0, 0));
					// Dimension dim = new Dimension(1382, 754);
					// objVariablesSelenium.gobjWebDriver.manage().window().setSize(dim);
					// Selenium selenium;
					// objVariablesSelenium.gobjWebDriver = new OperaDriver();
					// selenium = new WebDriverBackedSelenium(objVariablesSelenium.gobjWebDriver, "https://www.google.com/");
					// return objVariablesSelenium.gobjWebDriver;
					break;
				default:
					variablesJSON.objectStep.putValue("strStatus", "fail");
					throw new ExceptionBrowserDriverNotSupported("Browser '" + variablesJSON.objectStep.getString("strTagName") + "' not supported");
				}
			} catch (Exception e) {
				logger.add("BrowserLaunch: Exception" + e.toString());
			} finally {
				variablesJSON.objectStep.putValue("strCurrentWindowHandle", objVariablesSelenium.gobjWebDriver.getWindowHandle());
				new CoordinatesElement();
				new CoordinateHighlightScreenshot(variablesJSON.objectStep);
				stepDuration("BrowserLaunch", lngTimeStart, "launch");
			}
		}
	}

	private class BrowserLaunchSync {
		private BrowserLaunchSync() {
			logger.add("  ==start==>BrowserLaunchSync " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			writeFile("c:\\temp\\DragonflyBrowser.log", logger.getLog());
			try {
				new BrowserLaunch();
			} catch (ExceptionBrowserDriverNotSupported e) {
				// TODO confirm the exceptions to catch in main some may need to be removed
				logger.add("main: " + e.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO create a BrowserLaunchSync to manage reporting and sync
				logger.add("BrowserLaunchSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class BrowserRefresh {
		private BrowserRefresh() {
			logger.add("  ==start==>BrowserRefresh " + getDateTimestamp());
			objVariablesSelenium.gobjWebDriver.navigate().refresh();
		}
	}

	private class BrowserRefreshSync {
		private BrowserRefreshSync() {
			new BrowserRefresh();
		}
	}

	private class ClearMyTracksByProcessCache {
		private ClearMyTracksByProcessCache() throws Exception {
			logger.add("  ==start==>ClearMyTracksByProcessCache " + getDateTimestamp());
			String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	private class ClearMyTracksByProcessCookies {
		private ClearMyTracksByProcessCookies() throws Exception {
			logger.add("  ==start==>ClearMyTracksByProcessCookies " + getDateTimestamp());
			String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	private class ClipboardGet {
		private String run() {
			logger.add("  ==start==>ClipboardGet " + getDateTimestamp());
			String strClipboardData = "";
			try {
				strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				logger.add("ClipboardGet: strClipboardData = " + strClipboardData);
			} catch (Exception e) {
				logger.add("ClipboardGet: Exception = " + e.toString());
			}
			return strClipboardData;
		}
	}

	private class CommandLineExecution {
		private CommandLineExecution() throws Exception {
			logger.add("  ==start==>CommandLineExecution " + getDateTimestamp());
			Process p = Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			p.waitFor();
			Process p5 = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 10");
			p5.waitFor();
			String strPathCookiesLow = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Cookies\\Low\\";
			strPathCookiesLow = strPathCookiesLow.replaceAll("\\\\", "/");
			logger.add("CommandLineExecution: strPathCookiesLow = " + strPathCookiesLow);
			FileUtils.deleteDirectory(new File(strPathCookiesLow));
			String strPathCacheLow = System.getenv("APPDATA") + "Local/Microsoft/Windows/Temporary Internet Files/Low/";
			strPathCacheLow = strPathCacheLow.replaceAll("\\\\", "/");
			logger.add("CommandLineExecution: strPathCacheLow = " + strPathCacheLow);
			FileUtils.deleteDirectory(new File(strPathCacheLow));
		}
	}

	private class ConvertPathByOperatingSystem {
		private void run(String strPath) {
			// logger.add("main: gstrOperatingSystem = " + objOperatingSystem.strOS);
			//				switch (gstrOperatingSystem) {
			//				case "Windows":
			//					strPathResults = objPaths.getPathSystemUserDir() + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\" + gstrPathResults + "\\";
			//					strPathImages = "images\\";
			//					break;
			//				case "Mac":
			//					strPathResults = objPaths.getPathSystemUserDir() + "/Results/" + strTestConfigurationFileName.replace(".json", "") + "/" + gstrPathResults + "/";
			//					strPathImages = "images/";
			//					break;
			//				default:
			//					 logger.add("main: switch gstrOperatingSystem = " + gstrOperatingSystem + "  not supported");
			//					return;
			//				}
		}
	}

	private class CoordinateHighlightScreenshot {
		private CoordinateHighlightScreenshot(final JSONObjectExtended objJsonObjectStepHighlightArea) {
			logger.add("  ==start==>CoordinateHighlightScreenshot " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			JFrame objJFrame = new JFrame() {
				private static final long serialVersionUID = 1L;
				{
					Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
					if (objJsonObjectStepHighlightArea.getBoolean("blnHighlight") == true) {
						int intThickness = 5;
						Color objHighlightColor = null;
						switch (objJsonObjectStepHighlightArea.getLowerCase("strStatus")) {
						case "pass":
							if (objJsonObjectStepHighlightArea.verifyEquals("strAction", "set") && objJsonObjectStepHighlightArea.verifyEquals("strAssert", "off")) {
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
						logger.add("CoordinateHighlightScreenshot: strHighlightArea = " + variablesJSON.objectStep.getString("strHighlightArea"));
						new RectangleAreaByName(intThickness, variablesJSON.objectStep.getString("strHighlightArea"), objHighlightArea);
						setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
						setUndecorated(true);
						setBackground(new Color(0, 0, 0, 0));
						getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
						setVisible(true);
					}
				}
			};
			int intSleepMilliseconds = 0;
			if (variablesJSON.objectStep.getBoolean("blnScreenshot") == true) {
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				String strScreenshotFilePath = "";
				try {
					new RectangleAreaByName(0, variablesJSON.objectStep.getString("strScreenshotArea"), objHighlightArea);
					BufferedImage objScreenShot = new Robot().createScreenCapture(objHighlightArea);
					strScreenshotFilePath = objPaths.gstrPathImages + "Screenshot_" + getDateTimestamp() + ".jpg";
					Thread objThread = new Thread(new ThreadSaveImage(objScreenShot, "jpg", strScreenshotFilePath));
					objThread.start();
					variablesJSON.objectStep.putValue("strScreenshotFilePath", strScreenshotFilePath);
				} catch (Exception e) {
					logger.add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
			}
			if (variablesJSON.objectStep.getBoolean("blnHighlight") == true) {
				try {
					Thread.sleep(intSleepMilliseconds);
				} catch (InterruptedException e) {
					logger.add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
				objJFrame.setVisible(false);
				objJFrame.dispose();
			}
			logger.add("CoordinateHighlightScreenshot: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	private class CoordinatesAlert {
		private CoordinatesAlert() {
			logger.add("  ==start==>CoordinatesAlert " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			AutoItX objAutoIt = objAutoItSetObject.getObject();
			int intClientSizeHeight = 0;
			int intClientSizeWidth = 0;
			int intControlPosHeight = 0;
			int intControlPosWidth = 0;
			int intControlPosX = 0;
			int intControlPosY = 0;
			int intWinPosHeight = objAutoIt.winGetPosHeight("[ACTIVE]");
			int intWinPosWidth = objAutoIt.winGetPosWidth("[ACTIVE]");
			int intWinPosX = objAutoIt.winGetPosX("[ACTIVE]");
			int intWinPosY = objAutoIt.winGetPosY("[ACTIVE]");
			String strControlID = "";
			String strText = "";
			String strWinTitle = objAutoIt.winGetTitle("[ACTIVE]");
			try {
				switch (variablesJSON.objectStep.getLowerCase("strAttributeValues")) {
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
				switch (variablesJSON.objectStep.getLowerCase("strAttributeValues")) {
				case "accept":
				case "dismiss":
				case "edit":
				case "text":
					intControlPosHeight = objAutoIt.controlGetPosHeight("[ACTIVE]", strText, strControlID);
					intControlPosWidth = objAutoIt.controlGetPosWidth("[ACTIVE]", strText, strControlID);
					intControlPosX = objAutoIt.controlGetPosX("[ACTIVE]", strText, strControlID);
					intControlPosY = objAutoIt.controlGetPosY("[ACTIVE]", strText, strControlID);
					intClientSizeHeight = objAutoIt.winGetClientSizeHeight("[ACTIVE]");
					intClientSizeWidth = objAutoIt.winGetClientSizeWidth("[ACTIVE]");
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
					intWinPosHeight = ((intWinPosHeight - intClientSizeHeight) - ((intWinPosWidth - intClientSizeWidth) / 2));
					break;
				}
				variablesJSON.objectStep.putInt("intElementScreenX", intWinPosX);
				variablesJSON.objectStep.putInt("intElementScreenY", intWinPosY);
				variablesJSON.objectStep.putInt("intElementWidth", intWinPosWidth);
				variablesJSON.objectStep.putInt("intElementHeight", intWinPosHeight);
			} catch (Exception e) {
				logger.add("CoordinatesAlert: Exception = " + e.toString());
			} finally {
				logger.add("CoordinatesAlert: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class CoordinatesBrowserInner {
		private CoordinatesBrowserInner() throws WebDriverException {
			logger.add("  ==start==>CoordinatesBrowserInner " + getDateTimestamp());
			//objVariablesSelenium.gobjWebDriverCoordinates = objVariablesSelenium.gobjWebDriver;
			//objVariablesSelenium.gobjWebDriverCoordinates.switchTo().defaultContent();
			long lngBrowserInnerWidth = 0;
			long lngBrowserInnerHeight = 0;
			try {
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			} catch (WebDriverException e) {
				logger.add("CoordinatesBrowserInner: WebDriverException = " + e.toString());
				throw new WebDriverException("WebDriverException returned");
			} catch (Exception e) {
				logger.add("CoordinatesBrowserInner: Exception = " + e.toString());
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return document.body.offsetWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return document.body.offsetHeight;");
			}
			variablesJSON.objectStep.putLong("intBrowserInnerWidth", lngBrowserInnerWidth);
			variablesJSON.objectStep.putLong("intBrowserInnerHeight", lngBrowserInnerHeight);
		}
	}

	private class CoordinatesElement {
		private CoordinatesElement() {
			logger.add("  ==start==>CoordinatesElement " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			try {
				//new CoordinatesBrowserInner(   );
				int intScrollbar = 0;
				Point objWebDriverPoint = objVariablesSelenium.gobjWebDriver.manage().window().getPosition();
				int intBrowserOuterX = objWebDriverPoint.x;
				int intBrowserOuterY = objWebDriverPoint.y;
				Dimension objWebDriverDimension = objVariablesSelenium.gobjWebDriver.manage().window().getSize();
				int intBrowserOuterWidth = objWebDriverDimension.width;
				int intBrowserOuterHeight = objWebDriverDimension.height;
				variablesJSON.objectStep.putInt("intBrowserOuterX", intBrowserOuterX);
				variablesJSON.objectStep.putInt("intBrowserOuterY", intBrowserOuterY);
				variablesJSON.objectStep.putInt("intBrowserOuterWidth", intBrowserOuterWidth);
				variablesJSON.objectStep.putInt("intBrowserOuterHeight", intBrowserOuterHeight);
				if (objVariablesSelenium.gobjWebElement != null) {
					Coordinates objElementCoordinates = ((Locatable) objVariablesSelenium.gobjWebElement).getCoordinates();
					Point objElementPoint = objElementCoordinates.inViewPort();
					Dimension objElementDimension = objVariablesSelenium.gobjWebElement.getSize();
					variablesJSON.objectStep.putInt("intElementX", objElementPoint.x);
					variablesJSON.objectStep.putInt("intElementY", objElementPoint.y);
					variablesJSON.objectStep.putInt("intElementWidth", objElementDimension.width);
					variablesJSON.objectStep.putInt("intElementHeight", objElementDimension.height);
				}
				int intBrowserInnerWidth = variablesJSON.objectStep.getInt("intBrowserInnerWidth");
				int intBrowserInnerHeight = variablesJSON.objectStep.getInt("intBrowserInnerHeight");
				int intElementX = variablesJSON.objectStep.getInt("intElementX");
				int intElementY = variablesJSON.objectStep.getInt("intElementY");
				int intWindowBorder = (intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2;
				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder;
				variablesJSON.objectStep.putInt("intElementScreenX", intElementScreenX);
				variablesJSON.objectStep.putInt("intElementScreenY", intElementScreenY);
			} catch (Exception e) {
				logger.add("CoordinatesElement: Exception = " + e.toString());
			} finally {
				logger.add("  ==end==>CoordinatesElement " + getDateTimestamp());
				logger.add("CoordinatesElement: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class DialogLaunch extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		private FilenameFilter objFilter;
		private JButton btnCancel = new JButton("Cancel");
		private JButton btnRun = new JButton("Run");
		private JComboBox<String> comboApplication = new JComboBox<String>();
		private JComboBox<String> comboTest = new JComboBox<String>();
		private JRadioButton rdbtnTestValue = new JRadioButton("Value in test", true);
		private JRadioButton rdbtnChrome = new JRadioButton("Chrome");
		private JRadioButton rdbtnFirefox = new JRadioButton("Firefox");
		private JRadioButton rdbtnIE = new JRadioButton("IE");
		private JRadioButton rdbtnInternal = new JRadioButton("internal");
		private JRadioButton rdbtnLocal = new JRadioButton("local");
		private JRadioButton rdbtnPublic = new JRadioButton("public");
		private String dirPath = "";
		private String[] arrDropEmpty = new String[0];
		private String gstrNameTest;
		private String gstrTestArea;

		private DialogLaunch() {
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setSize(750, 500);
			Toolkit tk = Toolkit.getDefaultToolkit();
			java.awt.Dimension dim = tk.getScreenSize();
			int xPos = (dim.width / 2) - (this.getWidth() / 2);
			int yPos = (dim.height / 2) - (this.getHeight() / 2);
			this.setLocation(xPos, yPos);
			setAlwaysOnTop(true);
			setTitle("Dragonfly Local Test Runner");
			getContentPane().setLayout(null);
			//SelectTheTestArea Group radio buttons.
			JLabel lblSelectTheTestArea = new JLabel("Select the test area");
			lblSelectTheTestArea.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTestArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSelectTheTestArea.setBounds(12, 15, 398, 35);
			getContentPane().add(lblSelectTheTestArea);
			rdbtnLocal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnLocal.setBounds(12, 45, 127, 25);
			rdbtnLocal.addActionListener(this);
			getContentPane().add(rdbtnLocal);
			rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnPublic.setBounds(12, 70, 127, 25);
			rdbtnPublic.addActionListener(this);
			getContentPane().add(rdbtnPublic);
			rdbtnInternal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnInternal.setBounds(12, 95, 127, 25);
			rdbtnInternal.addActionListener(this);
			getContentPane().add(rdbtnInternal);
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnLocal);
			group.add(rdbtnPublic);
			group.add(rdbtnInternal);
			//SelectTheBrowser Group radio buttons.
			JLabel lblSelectTheBrowser = new JLabel("Select the browser");
			lblSelectTheBrowser.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheBrowser.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSelectTheBrowser.setBounds(427, 15, 398, 35);
			getContentPane().add(lblSelectTheBrowser);
			rdbtnTestValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnTestValue.setBounds(427, 45, 150, 25);
			rdbtnTestValue.addActionListener(this);
			getContentPane().add(rdbtnTestValue);
			rdbtnIE.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnIE.setBounds(427, 70, 127, 25);
			rdbtnIE.addActionListener(this);
			getContentPane().add(rdbtnIE);
			rdbtnChrome.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnChrome.setBounds(427, 95, 127, 25);
			rdbtnChrome.addActionListener(this);
			getContentPane().add(rdbtnChrome);
			rdbtnFirefox.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnFirefox.setBounds(427, 120, 127, 25);
			getContentPane().add(rdbtnFirefox);
			rdbtnFirefox.addActionListener(this);
			ButtonGroup groupBrowser = new ButtonGroup();
			groupBrowser.add(rdbtnTestValue);
			groupBrowser.add(rdbtnIE);
			groupBrowser.add(rdbtnChrome);
			groupBrowser.add(rdbtnFirefox);
			//lblSelectTheApplication
			JLabel lblSelectTheApplication = new JLabel("Select the application");
			lblSelectTheApplication.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSelectTheApplication.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheApplication.setBounds(12, 141, 398, 35);
			getContentPane().add(lblSelectTheApplication);
			comboApplication.setFont(new Font("Tahoma", Font.PLAIN, 20));
			comboApplication.setToolTipText("Tip the tool");
			comboApplication.setBounds(12, 175, 410, 40);
			comboApplication.setEnabled(false);
			comboApplication.addActionListener(this);
			getContentPane().add(comboApplication);
			//lblSelectTheTest
			JLabel lblSelectTheTest = new JLabel("Select the test");
			lblSelectTheTest.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSelectTheTest.setBounds(12, 252, 398, 35);
			getContentPane().add(lblSelectTheTest);
			comboTest.setToolTipText("Tip the tool");
			comboTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
			comboTest.setBounds(12, 283, 708, 40);
			comboTest.setEnabled(false);
			comboTest.addActionListener(this);
			getContentPane().add(comboTest);
			btnRun.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnRun.setBounds(12, 373, 310, 55);
			btnRun.setEnabled(false);
			btnRun.addActionListener(this);
			getContentPane().add(btnRun);
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCancel.setBounds(410, 373, 310, 55);
			btnCancel.addActionListener(this);
			getContentPane().add(btnCancel);
			objVariablesCommon.gstrBrowserSelection = "TestValue";
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rdbtnLocal) {
				this.gstrTestArea = "local";
				objPaths.gstrTestArea = "local";
				objPaths.setDirectory("local");
				System.out.println("objPaths.gstrTestArea = " + objPaths.gstrTestArea);
				System.out.println(objPaths.gstrPathSystemUserDir);
				System.out.println(objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + objPaths.gstrPathTestConfiguration;
				System.out.println("dirPath = " + dirPath);
				this.getApplications();
			}
			if (e.getSource() == rdbtnPublic) {
				this.gstrTestArea = "public";
				objPaths.gstrTestArea = "public";
				objPaths.setDirectory("public");
				System.out.println("objPaths.gstrTestArea = " + objPaths.gstrTestArea);
				System.out.println(objPaths.gstrPathSystemUserDir);
				System.out.println(objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + objPaths.gstrPathTestConfiguration;
				System.out.println("dirPath = " + dirPath);
				this.getApplications();
			}
			if (e.getSource() == rdbtnInternal) {
				this.gstrTestArea = "internal";
				objPaths.gstrTestArea = "internal";
				objPaths.setDirectory("internal");
				System.out.println("objPaths.gstrTestArea = " + objPaths.gstrTestArea);
				System.out.println(objPaths.gstrPathSystemUserDir);
				System.out.println(objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + objPaths.gstrPathTestConfiguration;
				System.out.println("dirPath = " + dirPath);
				this.getApplications();
			}
			if (e.getSource() == comboApplication) {
				System.out.println(comboApplication.getSelectedItem());
				this.getTests();
			}
			if (e.getSource() == comboTest) {
				System.out.println("comboTest");
				btnRun.setEnabled(true);
			}
			if (e.getSource() == rdbtnTestValue) {
				objVariablesCommon.gstrBrowserSelection = "TestValue";
			}
			if (e.getSource() == rdbtnChrome) {
				objVariablesCommon.gstrBrowserSelection = "chrome";
			}
			if (e.getSource() == rdbtnFirefox) {
				objVariablesCommon.gstrBrowserSelection = "firefox";
			}
			if (e.getSource() == rdbtnIE) {
				objVariablesCommon.gstrBrowserSelection = "ie";
			}
			if (e.getSource() == btnRun) {
				System.out.println(comboTest.getSelectedItem());
				objPaths.gstrNameTest = (String) comboTest.getSelectedItem();
				dispose();
				return;
			}
			if (e.getSource() == btnCancel) {
				dispose();
				return;
			}
		}

		private void getApplications() {
			String[] arrDrop = null;
			HashSet<String> hs = new HashSet<String>();
			File dir = new File(dirPath);
			objFilter = new FilenameFilter() {
				@Override
				public boolean accept(File file, String name) {
					if (name.endsWith(".json")) {
						return true;
					} else {
						return false;
					}
				}
			};
			File[] files = dir.listFiles(objFilter);
			comboApplication.setEnabled(true);
			if (files.length == 0) {
				System.out.println("The directory is empty");
				comboApplication.setModel(new DefaultComboBoxModel<String>(arrDrop));
			} else {
				for (File aFile : files) {
					System.out.println(aFile.getName());
					String strKeyword = "";
					int intRightArrowPosition = aFile.getName().indexOf("_");
					if (intRightArrowPosition > -1) {
						strKeyword = aFile.getName().substring(0, intRightArrowPosition);
					}
					if (hs.contains(strKeyword) == false) {
						hs.add(strKeyword);
					}
				}
				arrDrop = hs.toArray(new String[0]);
				Arrays.sort(arrDrop);
				comboApplication.setModel(new DefaultComboBoxModel<String>(arrDrop));
			}
			System.out.println(hs);
			comboTest.setModel(new DefaultComboBoxModel<String>(arrDropEmpty));
			comboTest.setEnabled(false);
		}

		private void getTests() {
			int intCount = 0;
			File dir = new File(dirPath);
			objFilter = new FilenameFilter() {
				@Override
				public boolean accept(File file, String name) {
					if (name.startsWith((String) comboApplication.getSelectedItem())) {
						return true;
					} else {
						return false;
					}
				}
			};
			File[] files = dir.listFiles(objFilter);
			String[] arrDrop = new String[files.length];
			if (files.length == 0) {
				System.out.println("The directory is empty");
			} else {
				for (File aFile : files) {
					arrDrop[intCount] = aFile.getName();
					intCount++;
				}
				Arrays.sort(arrDrop);
			}
			comboTest.setModel(new DefaultComboBoxModel<String>(arrDrop));
			comboTest.setEnabled(true);
		}
	}

	private class ElementDisabled {
		private ElementDisabled() throws ExceptionElementNotDisabled {
			logger.add("  ==start==>ElementDisabled " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (objVariablesSelenium.gobjWebElement.isEnabled()) {
					throw new ExceptionElementNotDisabled("ElementDisabled - Element is not disabled");
				} else {
					return;
				}
			} finally {
				logger.add("ElementDisabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementDisabledSync {
		private ElementDisabledSync() {
			logger.add("  ==start==>ElementDisabledSync " + getDateTimestamp());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnDisabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnDisabled == false) {
						new ElementDisabled();
						blnDisabled = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					blnDisabled = false;
					logger.add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotDisabled e) {
					blnDisabled = false;
					logger.add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementDisabledSync", "syncdisabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnDisabled = false;
					}
				}
			}
		}
	}

	private class ElementDragSync {
		private ElementDragSync() {
			logger.add("  ==start==>ElementDragSync " + getDateTimestamp());
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
						new ElementFind();
						logger.add("ElementDragSync: elementFind over");
						if (objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							logger.add("ElementDragSync: outerHTML = " + strOuterHTML);
							logger.add("ElementDragSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						logger.add("ElementDragSync: strOuterHTML over");
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled();
						blnEnabled = true;
					}
					objVariablesSelenium.gobjWebElementDrag = objVariablesSelenium.gobjWebElement;
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementDragSync", "drag", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
					}
				}
			}
		}
	}

	private class ElementDropSync {
		private ElementDropSync() {
			logger.add("  ==start==>ElementDropSync " + getDateTimestamp());
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
						new ElementFind();
						logger.add("ElementDropSync: elementFind over");
						if (objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							logger.add("ElementDropSync: outerHTML = " + strOuterHTML);
							logger.add("ElementDropSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						logger.add("ElementDropSync: strOuterHTML over");
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled();
						blnEnabled = true;
					}
					objVariablesSelenium.gobjWebElementDrop = objVariablesSelenium.gobjWebElement;
					//Actions actions = new Actions(objVariablesSelenium.gobjWebDriver);
					//actions.dragAndDrop(objVariablesSelenium.gobjWebElementDrag, objVariablesSelenium.gobjWebElementDrop).perform();
					//				Actions action = new Actions(objVariablesSelenium.gobjWebDriver);
					//				Action dragDrop = action.dragAndDrop(gobjWebElementDrag, objVariablesSelenium.gobjWebElementDrop).build();
					//				dragDrop.perform();
					Actions objActions = new Actions(objVariablesSelenium.gobjWebDriver);
					Action objDragAndDrop = objActions.clickAndHold(objVariablesSelenium.gobjWebElementDrag).moveToElement(objVariablesSelenium.gobjWebElementDrop).release(objVariablesSelenium.gobjWebElementDrop).build();
					objDragAndDrop.perform();
					//				Actions action = new Actions(objVariablesSelenium.gobjWebDriver);
					//				action.dragAndDrop(objVariablesSelenium.gobjWebElementDrag, objVariablesSelenium.gobjWebElementDrop).build().perform();
					new SleepMilliseconds(10000);
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementDropSync", "drop", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					}
				}
			}
		}
	}

	private class ElementEnabled {
		private ElementEnabled() throws ExceptionElementNotEnabled {
			logger.add("  ==start==>ElementEnabled " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == true) {
						return;
					} else {
						throw new ExceptionElementNotEnabled("Alert popup was not found.");
					}
				}
				if (objVariablesSelenium.gobjWebElement.isEnabled()) {
					return;
				} else {
					throw new ExceptionElementNotEnabled("ElementEnabled - Element is not enabled");
				}
			} finally {
				logger.add("ElementEnabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementEnabledSync {
		private ElementEnabledSync() {
			logger.add("  ==start==>ElementEnabledSync " + getDateTimestamp());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnEnabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled();
						blnEnabled = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					blnEnabled = false;
					logger.add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					logger.add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (blnFound == false) {
						variablesJSON.objectStep.putValue("strStepActual", "visible");
					} else {
						variablesJSON.objectStep.putValue("strStepActual", "");
					}
					if (blnVisible == false) {
						variablesJSON.objectStep.putValue("strStepActual", "visible");
					} else {
						variablesJSON.objectStep.putValue("strStepActual", "");
					}
					logger.add("ElementEnabledSync: blnEnabled = " + blnEnabled);
					if (blnEnabled == false) {
						variablesJSON.objectStep.putValue("strStepActual", "disabled");
					} else {
						variablesJSON.objectStep.putValue("strStepActual", "");
					}
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementEnabledSync", "syncenabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnEnabled = false;
					}
				}
			}
		}
	}

	private class ElementFind {
		private ElementFind() throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			logger.add("  ==start==>ElementFind " + getDateTimestamp());
			if (variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
				variablesJSON.objectStep.putValue("strTagType", "alert");
				if (new AlertFind().run() == true) {
					variablesJSON.objectStep.putValue("strHighlightArea", "alert");
					return;
				} else {
					variablesJSON.objectStep.putValue("strHighlightArea", "screen");
					throw new ExceptionElementNotFound("Alert popup not found!");
				}
			}
			if (variablesJSON.objectStep.get("strTagName").toString().toLowerCase().equals("title")) {
				variablesJSON.objectStep.putValue("strTagType", "title");
				return;
			}
			String strWindowHandle = "";
			Object[] arrHandles = objVariablesSelenium.gobjWebDriver.getWindowHandles().toArray();
			for (Object objWindowHandlesEach : arrHandles) {
				logger.add("ElementFind: objWindowHandlesEach.toString() = " + objWindowHandlesEach.toString());
			}
			for (Object objWindowHandlesEach : arrHandles) {
				try {
					strWindowHandle = objWindowHandlesEach.toString();
					objVariablesSelenium.gobjWebDriver.switchTo().window(strWindowHandle);
					objVariablesSelenium.gobjWebDriverCoordinates = objVariablesSelenium.gobjWebDriver;
					new CoordinatesBrowserInner();
					List<Integer> arrRouteOriginal = new ArrayList<Integer>();
					new ElementFindFramesSearch().run(arrRouteOriginal);
					if (objVariablesSelenium.gobjWebElement != null) {
						// logger.add("elementFind: objVariablesSelenium.gobjWebDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
						// logger.add("elementFind: objVariablesSelenium.gobjWebDriver.getTitle = " + objVariablesSelenium.gobjWebDriver.getTitle());
						// logger.add("ElementFindFramesSearch: objVariablesSelenium.gobjWebDriver.getTitle = " + objVariablesSelenium.gobjWebDriver.getTitle());
						// logger.add("ElementFindFramesSearch: objVariablesSelenium.gobjWebDriver.getCurrentUrl = " + objVariablesSelenium.gobjWebDriver.getCurrentUrl());
						// logger.add("ElementFindFramesSearch: objVariablesSelenium.gobjWebDriver.getWindowHandle = " + objVariablesSelenium.gobjWebDriver.getWindowHandle());
						// logger.add("ElementFindFramesSearch objVariablesSelenium.gobjWebDriver.getPageSource = " + objVariablesSelenium.gobjWebDriver.getPageSource());
						return;
					}
				} catch (Exception e) {
					logger.add("ElementFind: Exception = " + e.toString());
				}
			}
			throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
		}
	}

	private class ElementFindBy {
		private ElementFindBy(String strAttributeNames, String strAttributeValues, String strTagName) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			logger.add("  ==start==>ElementFindBy " + getDateTimestamp());
			int intAttributeEach = 0;
			List<WebElement> objWebElementCollection = new ArrayList<WebElement>();
			String arrAttributeNames[] = strAttributeNames.toString().split("\\|", -1);
			String arrAttributeValues[] = strAttributeValues.toString().split("\\|", -1);
			String strIndex = "";
			String strIndexKeyword = "";
			String strXpath = "";
			String strXpathAttributes = "";
			String strXpathAttributesTemp = "";
			if (strAttributeNames.toLowerCase().equals("xpath")) {
				objWebElementCollection = objVariablesSelenium.gobjWebDriver.findElements(By.xpath(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("id")) {
				objWebElementCollection = objVariablesSelenium.gobjWebDriver.findElements(By.id(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("name")) {
				objWebElementCollection = objVariablesSelenium.gobjWebDriver.findElements(By.name(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("class")) {
				objWebElementCollection = objVariablesSelenium.gobjWebDriver.findElements(By.className(strAttributeValues));
			} else {
				for (intAttributeEach = 0; intAttributeEach < arrAttributeNames.length; intAttributeEach++) {
					strXpathAttributesTemp = "";
					switch (arrAttributeNames[intAttributeEach].toLowerCase()) {
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
						if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("<re>")) {
							strXpathAttributesTemp = "contains(text()" + ", '" + arrAttributeValues[intAttributeEach].substring(4) + "')";
						} else {
							strXpathAttributesTemp = "text()='" + arrAttributeValues[intAttributeEach] + "' ";
						}
						break;
					default:
						if (arrAttributeNames[intAttributeEach].toLowerCase().equals("type")) {
							variablesJSON.objectStep.putValue("strType", arrAttributeValues[intAttributeEach]);
						}
						if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("<re>")) {
							strXpathAttributesTemp = "contains(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + arrAttributeValues[intAttributeEach].substring(4).toLowerCase() + "')";
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
				}
				if (strXpathAttributes.trim().length() == 0) {
					strXpathAttributes = "";
				} else {
					strXpathAttributes = "[" + strXpathAttributes + "]";
				}
				strXpath = "(//" + strTagName + strXpathAttributes + ")" + strIndex;
				logger.add("ElementFindBy: strXpath = " + strXpath);
				objWebElementCollection = objVariablesSelenium.gobjWebDriver.findElements(By.xpath(strXpath));
			}
			switch (objWebElementCollection.size()) {
			case 0:
				throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
			case 1:
				objVariablesSelenium.gobjWebElement = objWebElementCollection.get(0);
				break;
			default:
				if (strIndexKeyword.equals("<last>")) {
					objVariablesSelenium.gobjWebElement = objWebElementCollection.get(objWebElementCollection.size() - 1);
					break;
				} else if (strIndexKeyword.equals("<random>")) {
					int intRandomElement = randomNumberRange(0, objWebElementCollection.size() - 1);
					objVariablesSelenium.gobjWebElement = objWebElementCollection.get(intRandomElement);
					break;
				} else {
					logger.add("ElementFindBy: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
					Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
					while (objWebElementEach.hasNext()) {
						WebElement row = objWebElementEach.next();
						logger.add("outerHTML:=  " + row.getAttribute("outerHTML"));
					}
					throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
				}
			}
		}
	}

	private class ElementFindFramesSearch {
		private boolean run(List<Integer> arrFramePath) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			logger.add("  ==start==>ElementFindFramesSearch " + getDateTimestamp());
			boolean blnReturn;
			int intMaximumDepth = 100;
			String strTagName = variablesJSON.objectStep.getLowerCase("strTagName");
			String strAttributeNames = variablesJSON.objectStep.getString("strAttributeNames");
			String strAttributeValues = variablesJSON.objectStep.getString("strAttributeValues");
			try {
				new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
				variablesJSON.objectStep.putValue("strCurrentWindowHandle", objVariablesSelenium.gobjWebDriver.getWindowHandle());
				if (variablesJSON.objectStep.verifyEquals("strTagName", "input")) {
					if (variablesJSON.objectStep.getString("strType").length() == 0) {
						variablesJSON.objectStep.putValue("strType", objVariablesSelenium.gobjWebElement.getAttribute("type"));
					}
					variablesJSON.objectStep.putValue("strTagType", "input_" + variablesJSON.objectStep.getString("strType"));
				} else {
					variablesJSON.objectStep.putValue("strTagType", variablesJSON.objectStep.getString("strTagName"));
				}
				logger.add("ElementFindFramesSearch: gobjWebElement outerHTML = " + objVariablesSelenium.gobjWebElement.getAttribute("outerHTML"));
				return true;
			} catch (ExceptionElementNotFound | ExceptionMultipleElementsFound | StaleElementReferenceException e) {
				blnReturn = false;
				logger.add("ElementFindFramesSearch: Exception = " + e.toString());
			}
			if (arrFramePath.size() < intMaximumDepth) {
				int intFramesCount = objVariablesSelenium.gobjWebDriver.findElements(By.tagName("frame")).size();
				for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
					try {
						objVariablesSelenium.gobjWebDriver.switchTo().frame(intFramesEach);
						List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
						arrFramePathNew.add(intFramesEach);
						blnReturn = new ElementFindFramesSearch().run(arrFramePathNew);
						if (blnReturn == true) {
							return true;
						}
						objVariablesSelenium.gobjWebDriver.switchTo().defaultContent();
						for (int intFramesPathEach : arrFramePath)
							objVariablesSelenium.gobjWebDriver.switchTo().frame(intFramesPathEach);
					} catch (NoSuchFrameException error) {
						blnReturn = false;
						logger.add("ElementFindFramesSearch: NoSuchFrameException = " + error.toString());
						break;
					} catch (Exception error) {
						logger.add("ElementFindFramesSearch: Exception = " + error.toString());
					}
				}
			}
			return blnReturn;
		}
	}

	private class ElementGet {
		private String run() throws ExceptionElementTagNameNotSupported {
			logger.add("  ==start==>ElementGet " + getDateTimestamp());
			AutoItX objAutoIt = objAutoItSetObject.getObject();
			switch (variablesJSON.objectStep.getLowerCase("strTagType")) {
			case "title":
				return objVariablesSelenium.gobjWebDriver.getTitle();
			case "img":
				return objVariablesSelenium.gobjWebElement.getAttribute("src");
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				return objVariablesSelenium.gobjWebElement.getAttribute("value").trim();
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
				return objVariablesSelenium.gobjWebElement.getText();
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
			case "input_textarea":
				return objVariablesSelenium.gobjWebElement.getAttribute("value");
			case "input_radio":
			case "input_checkbox":
				if (objVariablesSelenium.gobjWebElement.isSelected() == false) {
					return "<off>";
				} else {
					return "<on>";
				}
			case "select":
				//Select objSelect = new Select(objVariablesSelenium.gobjWebElement);
				//objSelect.getOptions();
				//WebElement option = ((Select) objVariablesSelenium.gobjWebElement).getFirstSelectedOption();
				//return	option.getText();
				return ((Select) objVariablesSelenium.gobjWebElement).getFirstSelectedOption().getText().replaceAll("\\s{2,}", " ");
				//				JavascriptExecutor objExecutor = (JavascriptExecutor) objVariablesSelenium.gobjWebDriver;
				//				return ((String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", objVariablesSelenium.gobjWebElement)).trim();
			case "table":
				return objVariablesSelenium.gobjWebElement.getText();
			case "alert":
				if (variablesJSON.objectStep.verifyEquals("strAttributeValues", "title")) {
					return objAutoIt.winGetTitle("[ACTIVE]");
				} else {
					return objVariablesSelenium.gobjWebDriver.switchTo().alert().getText();
				}
			default:
				throw new ExceptionElementTagNameNotSupported("Element tag not supported");
			}
		}
	}

	private class ElementGetSync {
		private ElementGetSync() {
			logger.add("  ==start==>ElementGetSync " + getDateTimestamp());
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
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnGet == false) {
						strGetValue = new ElementGet().run();
						variablesJSON.objectStep.putValue("strOutputValue", strGetValue);
						blnGet = true;
					}
					blnStatus = true;
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementGetSync", "get", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
						blnGet = false;
					}
				}
			}
		}
	}

	private class ElementHidden {
		private ElementHidden() throws ExceptionElementNotHidden {
			logger.add("  ==start==>ElementHidden " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == false) {
						variablesJSON.objectStep.putValue("strHighlightArea", "screen");
						return;
					} else {
						throw new ExceptionElementNotHidden("Alert popup was not hidden.");
					}
				}
				if (objVariablesSelenium.gobjWebElement.isDisplayed() == false) {
					return;
				} else {
					logger.add("ElementHidden: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					throw new ExceptionElementNotHidden("Element is displayed.");
				}
			} catch (NullPointerException | WebDriverException e) {
				logger.add("ElementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				return;
			} finally {
				logger.add("ElementHidden: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementHiddenSync {
		private ElementHiddenSync() {
			logger.add("  ==start==>ElementHiddenSync " + getDateTimestamp());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnHidden = false;
			Boolean blnStatus = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
					}
					if (blnHidden == false) {
						new ElementHidden();
						blnHidden = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ExceptionElementNotFound e) {
					blnFound = false;
					blnHidden = true;
					blnStatus = true;
					logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnHidden = false;
					logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnHidden = false;
					logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnFound = false;
					blnHidden = false;
					logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (blnHidden = false) {
						variablesJSON.objectStep.putValue("strStepActual", "visible");
					} else {
						variablesJSON.objectStep.putValue("strStepActual", "");
					}
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementHiddenSync", "synchidden", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnHidden = false;
					}
				}
			}
		}
	}

	private class ElementJavascriptExecutorGetElementsByTagName {
		private String run() {
			return null;
			//long lngStartTimegetElementsByTagName2 = System.currentTimeMillis();
			//List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
			// logger.add("ElementJavascriptExecutorGetElementsByTagName objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
			//if (objCollectionJS2.size() > 0) {
			//	long lngStartTimeByXpath = System.currentTimeMillis();
			//}
		}
	}

	private class ElementJavascriptExecutorXPath {
		private String run() {
			logger.add("  ==start==>ElementJavascriptExecutorXPath " + getDateTimestamp());
			return (String) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", objVariablesSelenium.gobjWebElement);
		}
	}

	private class ElementOnMouseOut {
		private ElementOnMouseOut() {
			logger.add("  ==start==>ElementOnMouseOut " + getDateTimestamp());
			JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) objVariablesSelenium.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseout();", objVariablesSelenium.gobjWebElement);
		}
	}

	private class ElementOnMouseOutSync {
		private ElementOnMouseOutSync() {
			logger.add("  ==start==>ElementOnMouseOutSync " + getDateTimestamp());
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
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled();
						blnEnabled = true;
					}
					if (blnOnMouseOver == false) {
						new ElementOnMouseOut();
						blnOnMouseOver = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementOnMouseOutSync", "mouse_out", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnOnMouseOver = false;
					}
				}
			}
		}
	}

	private class ElementOnMouseOver {
		private ElementOnMouseOver() {
			logger.add("  ==start==>ElementOnMouseOver " + getDateTimestamp());
			Actions objActions = new Actions(objVariablesSelenium.gobjWebDriver);
			objActions.moveToElement(objVariablesSelenium.gobjWebElement).build().perform();
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) objVariablesSelenium.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseover();", objVariablesSelenium.gobjWebElement);
		}
	}

	private class ElementOnMouseOverSync {
		private ElementOnMouseOverSync() {
			logger.add("  ==start==>ElementOnMouseOverSync " + getDateTimestamp());
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
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled();
						blnEnabled = true;
					}
					if (blnOnMouseOver == false) {
						new ElementOnMouseOver();
						blnOnMouseOver = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementOnMouseOverSync", "mouse_over", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnOnMouseOver = false;
					}
				}
			}
		}
	}

	private class ElementPleaseWait {
		private ElementPleaseWait() throws ExceptionElementNotHidden {
			logger.add("  ==start==>ElementPleaseWait " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnPleaseWait = Boolean.parseBoolean(variablesJSON.objectStep.getString("blnPleaseWait"));
			Integer intPleaseWaitEach;
			String strAttributeNames = null;
			String strAttributeValues = null;
			String strTagName = null;
			Boolean blnFound = false;
			String strMessage = "";
			try {
				objVariablesSelenium.gobjWebElementPleaseWait = objVariablesSelenium.gobjWebElement;
				logger.add("ElementPleaseWait: objectProcessing.size() = " + variablesJSON.objectProcessing.size());
				if (blnPleaseWait == true) {
					for (intPleaseWaitEach = 1; intPleaseWaitEach < variablesJSON.objectProcessing.size(); intPleaseWaitEach++) {
						JSONObjectExtended objJsonObjectPleaseWaitNode = (JSONObjectExtended) variablesJSON.objectProcessing.get("PleaseWait_" + intPleaseWaitEach);
						try {
							strAttributeNames = objJsonObjectPleaseWaitNode.getValue("strAttributeNames", "");
							strAttributeValues = objJsonObjectPleaseWaitNode.getValue("strAttributeValues", "");
							strTagName = objJsonObjectPleaseWaitNode.getValue("strTagName", "");
							logger.add("ElementPleaseWait: variables = " + strAttributeNames + " " + strAttributeValues + " " + strTagName);
						} catch (ExceptionJSONKeyNotPresent e1) {
							// TODO Auto-generated catch block
							logger.add("ElementPleaseWait: ExceptionJSONKeyNotPresent = " + e1.toString());
						}
						try {
							new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
							blnFound = true;
							strMessage = "Element found.";
						} catch (ExceptionElementNotFound e) {
							blnFound = false;
							logger.add("ElementPleaseWait: ElementFindBy = blnFound = false Milliseconds Waited = " + (System.currentTimeMillis()));
						} catch (ExceptionMultipleElementsFound e) {
							blnFound = true;
							strMessage = "Multiple elements found.";
							logger.add("ElementPleaseWait: ElementFindBy = blnFound = true Milliseconds Waited = " + (System.currentTimeMillis()));
						}
						if (blnFound == true) {
							if (objVariablesSelenium.gobjWebElement.isDisplayed() == true) {
								logger.add("ElementPleaseWait: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis()));
								//throw new ExceptionElementNotHidden("Element is displayed.");
								blnFound = true;
								strMessage = "Element is displayed.";
							} else {
								blnFound = false;
								logger.add("ElementPleaseWait: gobjWebElement.isDisplayed() = return false Milliseconds Waited = " + (System.currentTimeMillis()));
							}
						}
						if (blnFound == true) {
							return;
						}
					}
				}
			} finally {
				logger.add("ElementPleaseWait: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				objVariablesSelenium.gobjWebElement = objVariablesSelenium.gobjWebElementPleaseWait;
				if (blnFound == true) {
					throw new ExceptionElementNotHidden(strMessage);
				}
			}
		}
	}

	private class ElementScrollSync {
		private ElementScrollSync() {
			logger.add("  ==start==>ElementScrollSync " + getDateTimestamp());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
						logger.add("ElementScrollSync: blnFound = true");
					}
					JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) objVariablesSelenium.gobjWebDriver;
					objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", objVariablesSelenium.gobjWebElement);
					blnStatus = true;
					logger.add("ElementScrollSync: blnStatus = true");
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementScrollSync", "scroll", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					}
				}
			}
		}
	}

	private class ElementSet {
		private ElementSet(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionVisibleTextNotInSelectList, ExceptionKeywordNotValid {
			logger.add("  ==start==>ElementSet " + getDateTimestamp());
			logger.add("ElementSet: " + variablesJSON.objectStep.getLowerCase("strAttributeValues"));
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = variablesJSON.objectStep.getString("strInputValue");
			String strValueToSelect = strInputValue;
			String strAttributeValues = variablesJSON.objectStep.getLowerCase("strAttributeValues");
			String strTagType = variablesJSON.objectStep.getLowerCase("strTagType");
			String strSetType = "";
			Actions objActions = null;
			String strOptions = "";
			String strOptionsList = "";
			try {
				switch (strTagType) {
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
					//ToDo all click options
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<click>":
						variablesJSON.objectStep.putValue("strInputValue", "<click>");
						objVariablesSelenium.gobjWebElement.click();
						strSetType = "click";
						break;
					case "<doubleclick>":
						objActions = new Actions(objVariablesSelenium.gobjWebDriver);
						objActions.moveToElement(objVariablesSelenium.gobjWebElement).doubleClick().build().perform();
						strSetType = "double_click";
						break;
					case "<rightclick>":
						//ToDo add right click code
						objActions = new Actions(objVariablesSelenium.gobjWebDriver);
						objActions.contextClick(objVariablesSelenium.gobjWebElement).build().perform();
						//						Actions action= new Actions(objVariablesSelenium.gobjWebDriver);
						//						action.contextClick(objVariablesSelenium.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						strSetType = "right_click";
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <click>, <doubleclick>, <rightclick>");
					}
					break;
				case "input_text":
				case "input_password":
				case "textarea":
				case "input_email":
				case "input_textarea":
					if (objVariablesSelenium.gobjWebElement.getAttribute("value").isEmpty() == false) {
						objVariablesSelenium.gobjWebElement.clear();
					}
					objVariablesSelenium.gobjWebElement.sendKeys(strInputValue);
					strSetType = "Set";
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						variablesJSON.objectStep.putValue("strInputValue", "<on>");
						if (objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objVariablesSelenium.gobjWebElement.click();
						}
						strSetType = "Click";
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please use <on>");
					}
					break;
				case "input_checkbox":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						variablesJSON.objectStep.putValue("strInputValue", "<on>");
						if (objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objVariablesSelenium.gobjWebElement.click();
						}
						break;
					case "<off>":
						if (objVariablesSelenium.gobjWebElement.isSelected() == true) {
							objVariablesSelenium.gobjWebElement.click();
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					strSetType = "Click";
					break;
				case "select":
					//ToDo add throws UnexpectedTagNameException when element is not a SELECT   may be useless
					Select objSelect = new Select(objVariablesSelenium.gobjWebElement);
					objSelect.getOptions();
					int intOptionsLength = objSelect.getOptions().size();
					strOptions = objVariablesSelenium.gobjWebElement.getAttribute("innerHTML");
					strValueToSelect = strInputValue;
					String strKeywordValue = "";
					switch (getKeyword(strInputValue)) {
					case "<blank>":
						strValueToSelect = "";
						break;
					case "<first>":
						strValueToSelect = objSelect.getOptions().get(0).getText();
						break;
					case "<second>":
						strValueToSelect = objSelect.getOptions().get(1).getText();
						break;
					case "<third>":
						strValueToSelect = objSelect.getOptions().get(2).getText();
						break;
					case "<last>":
						strValueToSelect = objSelect.getOptions().get(intOptionsLength - 1).getText();
						break;
					case "<random>":
						int intStartRange = getKeywordIntValue(strInputValue);
						strValueToSelect = objSelect.getOptions().get(randomNumberRange(intStartRange, intOptionsLength - 1)).getText();
						logger.add("ElementSet strValueToSelect = " + strValueToSelect);
						break;
					//TODO add regex options
					case "<starts>":
						strKeywordValue = getKeywordValue(strInputValue);
						logger.add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						int intRightArrowPosition = strOptions.indexOf(">" + strKeywordValue);
						if (intRightArrowPosition > -1) {
							int intLeftArrowPosition = strOptions.indexOf("<", intRightArrowPosition);
							strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
						}
						logger.add("KeywordReturn: strKeywordValue2 " + strValueToSelect);
						logger.add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<ends>":
						strKeywordValue = getKeywordValue(strInputValue);
						logger.add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						int intMatchPosition = strOptions.indexOf(strKeywordValue + "<");
						intRightArrowPosition = strOptions.lastIndexOf(">", intMatchPosition);
						if (intRightArrowPosition > -1) {
							int intLeftArrowPosition = strOptions.indexOf("<", intRightArrowPosition);
							strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
						}
						logger.add("KeywordReturn: strValueToSelect " + strValueToSelect);
						logger.add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<contains>":
						int intStart = 0;
						strKeywordValue = getKeywordValue(strInputValue);
						logger.add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						int intKeywordCount = strOptions.length() - strOptions.replace(strKeywordValue, "").length();
						logger.add("KeywordReturn: intKeywordCount = " + intKeywordCount);
						for (int intTestInstanceEach = 0; intTestInstanceEach < intKeywordCount; intTestInstanceEach++) {
							logger.add("KeywordReturn: intStart = " + intStart);
							intMatchPosition = strOptions.indexOf(strKeywordValue, intStart);
							logger.add("KeywordReturn: intMatchPosition = " + intMatchPosition);
							intRightArrowPosition = strOptions.lastIndexOf(">", intMatchPosition);
							logger.add("KeywordReturn: intRightArrowPosition = " + intRightArrowPosition);
							if (intRightArrowPosition > -1) {
								int intLeftArrowPosition = strOptions.indexOf("<", intMatchPosition);
								logger.add("KeywordReturn: intLeftArrowPosition = " + intLeftArrowPosition);
								strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
							}
							logger.add("KeywordReturn: strValueToSelect = " + strValueToSelect);
							if (strValueToSelect.startsWith("<option")) {
								intStart = intMatchPosition + 1;
							} else {
								break;
							}
						}
						logger.add("KeywordReturn: strValueToSelect " + strValueToSelect);
						logger.add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<re>":
						break;
					default:
						break;
					}
					logger.add("KeywordReturn: strValueToSelect " + strValueToSelect);
					variablesJSON.objectStep.putString("strInputValue", strValueToSelect);
					try {
						strSetType = "Select";
						objSelect.selectByVisibleText(strValueToSelect);
					} catch (NoSuchElementException e) {
						//strSetType = "notinlist";
						variablesJSON.objectStep.putValue("strStepActual", "notinlist");
						strOptionsList = optionsList(strOptions);
						variablesJSON.objectStep.putValue("strOutputValue", strOptionsList);
						logger.add("ElementSet: options list removeTags = " + strOptionsList);
						throw new ExceptionVisibleTextNotInSelectList(e.getMessage());
					}
					break;
				case "table":
					break;
				case "alert":
					switch (strAttributeValues) {
					case "edit":
						objVariablesSelenium.gobjWebDriver.switchTo().alert().sendKeys(strInputValue);
						strSetType = "Set";
						break;
					case "accept":
						objVariablesSelenium.gobjWebDriver.switchTo().alert().accept();
						strSetType = "Click";
						break;
					case "dismiss":
						objVariablesSelenium.gobjWebDriver.switchTo().alert().dismiss();
						strSetType = "Click";
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strAttributeValues + " for the click event is not valid! Please us one of the following <edit>, <accept>, <dismiss>");
					}
					break;
				default:
					throw new ExceptionElementTagNameNotSupported("ElementSet: Element tag {" + strTagType + "} not supported");
				}
			} finally {
				variablesJSON.objectStep.putValue("strStepExpected", strSetType);
				logger.add("ElementSet: finally strSetType = " + strSetType);
				logger.add("ElementSet: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementSetJavascriptExecutor {
		private ElementSetJavascriptExecutor(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet, ExceptionKeywordNotValid {
			logger.add("  ==start==>ElementSetJavascriptExecutor " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = variablesJSON.objectStep.getString("strInputValue");
			String strValueToSelect = "";
			String strAttributeValues = variablesJSON.objectStep.getLowerCase("strAttributeValues");
			String strTagType = variablesJSON.objectStep.getLowerCase("strTagType");
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) objVariablesSelenium.gobjWebDriver;
			try {
				switch (strTagType) {
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
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<click>":
						objJavascriptExecutor.executeScript("arguments[0].focus();", objVariablesSelenium.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].click();", objVariablesSelenium.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].blur();", objVariablesSelenium.gobjWebElement);
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(objVariablesSelenium.gobjWebDriver);
						objAction.moveToElement(objVariablesSelenium.gobjWebElement).doubleClick().build().perform();
						break;
					case "<rightclick>":
						//ToDo add right click code javascript
						Actions action = new Actions(objVariablesSelenium.gobjWebDriver);
						action.contextClick(objVariablesSelenium.gobjWebElement).build().perform();
						//						Actions action= new Actions(objVariablesSelenium.gobjWebDriver);
						//						action.contextClick(objVariablesSelenium.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <click>, <doubleclick>, <rightclick>");
					}
					break;
				case "input_text":
				case "input_password":
				case "textarea":
				case "input_email":
				case "input_textarea":
					// logger.add("  ==start==>ElementSetJavascriptExecutor inputtext" + getDateTimestamp());
					objJavascriptExecutor.executeScript("arguments[0].focus();", objVariablesSelenium.gobjWebElement);
					// logger.add("  ==start==>ElementSetJavascriptExecutor focus" + getDateTimestamp());
					objJavascriptExecutor.executeScript("arguments[0].value = '';", objVariablesSelenium.gobjWebElement);
					// logger.add("  ==start==>ElementSetJavascriptExecutor value" + getDateTimestamp());
					objJavascriptExecutor.executeScript("arguments[0].value = '" + strInputValue + "';", objVariablesSelenium.gobjWebElement);
					// logger.add("  ==start==>ElementSetJavascriptExecutor value" + getDateTimestamp());
					objJavascriptExecutor.executeScript("arguments[0].blur();", objVariablesSelenium.gobjWebElement);
					// logger.add("onchange blur");
					if (strOuterHTML.toLowerCase().contains("onchange")) {
						try {
							// logger.add("  ==start==>ElementSetJavascriptExecutor strOuterHTML" + getDateTimestamp());
							objJavascriptExecutor.executeScript("arguments[0].onchange();", objVariablesSelenium.gobjWebElement);
						} catch (WebDriverException e) {
							logger.add("ElementSetJavascriptExecutor = WebDriverException: " + e.toString());
						}
					}
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						variablesJSON.objectStep.putValue("strInputValue", "<on>");
						if (objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									logger.add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please use <on>");
					}
					break;
				case "input_checkbox":
					switch (strInputValue.toLowerCase()) {
					case "<on>":
						if (objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									logger.add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					case "<off>":
						if (objVariablesSelenium.gobjWebElement.isSelected() == true) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									logger.add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					break;
				case "select":
					Select objSelect = new Select(objVariablesSelenium.gobjWebElement);
					objSelect.getOptions();
					objSelect.selectByVisibleText(strInputValue);
					// set_js
					//					int intOptionsEach;
					//					String strOptions = "";
					//					String[] arrOptions;
					//					strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objVariablesSelenium.gobjWebElement);
					//					strOptions = strOptions.substring(1);
					//					arrOptions = strOptions.split("\\|");
					//					for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					//						 logger.add("ElementSetJavascriptExecutor: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					//						if (arrOptions[intOptionsEach].toString().equals(variablesJSON.objectStep.get("strInputValue").toString())) {
					//							blnSet = true;
					//							Select objSelect = new Select(objVariablesSelenium.gobjWebElement);
					//							objJavascriptExecutor.executeScript("arguments[0].focus();", objVariablesSelenium.gobjWebElement);
					//							objSelect.selectByIndex(intOptionsEach);
					//							objJavascriptExecutor.executeScript("arguments[0].blur();", objVariablesSelenium.gobjWebElement);
					//							// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objVariablesSelenium.gobjWebElement);
					//							// if (strOuterHTML.toLowerCase().contains("onchange")) {
					//							// try {
					//							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objVariablesSelenium.gobjWebElement);
					//							// } catch (WebDriverException e) {
					//							//  logger.add("ElementSetJavascriptExecutor = " + e.toString());
					//							// }
					//							// }
					//							break;
					//						}
					//					}
					//					intOptionsLength = objObject.Object.Options.All.Length
					//					        ' switch based on keyword input
					//					        Select Case LCase(strValueToSelect)
					//					        Case "<blank>"
					//					            strValueToSelect = ""
					//					        Case "<first>"
					//					            strValueToSelect = objObject.Object.Options.All.Item(0).Innertext
					//					        Case "<second>"
					//					            strValueToSelect = objObject.Object.Options.All.Item(1).Innertext
					//					        Case "<third>"
					//					            strValueToSelect = objObject.Object.Options.All.Item(2).Innertext
					//					        Case "<last>"
					//					            strValueToSelect = objObject.Object.Options.All.Item(intOptionsLength - 1).Innertext
					//					        Case "<random>"
					//					            intRandom = GenerateRandomNumberBetween(0, intOptionsLength - 1)
					//					            strValueToSelect = objObject.Object.Options.All.Item(intRandom).Innertext
					//					        End Select
					//					        '  check if item is in the list
					//					        '  loop until object value exists in the list or the intMillisecondsWaited value is exceeded
					//					        Do Until CDbl(intMillisecondsWaited) > CDbl(intDefaultTimeOutMilliseconds)
					//					            '            strAllItems = ""
					//					            strAllItems = objObject.GetROProperty("all items")
					//					            ' refresh object each loop if can be refreshed
					//					            If blnShouldRefreshObject = True Then
					//					                objObject.RefreshObject
					//					            End If
					//					            For intOptionsEach = 0 To intOptionsLength - 1
					//					                If CStr(objObject.Object.Options.All.Item(intOptionsEach).Innertext) = CStr(strValueToSelect) Then
					//					                    blnItemFound = True
					//					                    gdtmStartTimeStep = Now
					//					                    objObject.Select strValueToSelect
					//					                    Exit For
					//					                    '                    If strAllItems = "" Then
					//					                    '                        strAllItems = objObject.Object.Options.All.Item(intOptionsEach).Innertext
					//					                    '                    Else
					//					                    '                        strAllItems = strAllItems & ";" & objObject.Object.Options.All.Item(intOptionsEach).Innertext
					//					                    '                    End If
					//					                End If
					//					            Next
					//					            If blnItemFound = True Then
					//					                Exit Do
					//					            End If
					//					            ' wait within the loop 100 milliseconds to allow loop to check 10 times per second if object does not exist
					//					            Wait 0, 100
					//					            '  sets the intMillisecondsWaited variable to the number of milliseconds waited from the point when the intTimerStart was set
					//					            intMilliseconds Waited = CDbl((Timer - intStartTime) * 1000)
					//					        Loop
					//					    End If    '===>   '   If blnEnabled = True Then
					//					    '  report pass or fail based on the boolean variables set above
					//					    If blnItemFound = True Then
					//					        WebListSelect = True
					//					        ReporterEventScreenShot micPass, strStep, "The selection of the  {" & strObjectToString & "} object with path {" & strObjectPath & "} item value {" & strValueToSelect & "} after {" & intMillisecondsWaited & "} milliseconds."
					//					    ElseIf blnVisible = False Then
					//					        WebListSelect = False
					//					        ReporterEventScreenShot micFail, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is hidden."
					//					        ReporterEventScreenShot micInfo, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is hidden after {" & intMillisecondsWaited & "} milliseconds."
					//					    ElseIf blnEnabled = False Then
					//					        WebListSelect = False
					//					        ReporterEventScreenShot micFail, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is disabled."
					//					        ReporterEventScreenShot micInfo, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is disabled after {" & intMillisecondsWaited & "} milliseconds."
					//					    ElseIf blnItemFound = False Then
					//					        WebListSelect = False
					//					        ReporterEventScreenShot micFail, strStep, "The selection of the {" & strValueToSelect & "} object with path {" & strObjectPath & "} failed due to item not found in list.  The following is a list of all items: {" & strAllItems & "}"
					//					        ReporterEventScreenShot micInfo, strStep, "The selection of the {" & strValueToSelect & "} object with path {" & strObjectPath & "} failed due to item not found in list.  The following is a list of all items: {" & strAllItems & "} after {" & intMillisecondsWaited & "} milliseconds."
					//					    End If
					break;
				case "table":
					break;
				default:
					throw new ExceptionElementTagNameNotSupported("ElementSetJavascriptExecutor: Element tag {" + strTagType + "} not supported");
				}
			} finally {
				logger.add("ElementSetJavascriptExecutor: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementSetSync {
		private ElementSetSync(boolean blnJavascriptExecutor) {
			logger.add("  ==start==>ElementSetSync " + getDateTimestamp());
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
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						if (objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							logger.add("ElementSetSync: " + strOuterHTML);
							logger.add("ElementSetSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled();
						blnEnabled = true;
					}
					switch (variablesJSON.objectStep.getLowerCase("strAssert")) {
					case "off":
						variablesJSON.objectStep.putValue("strStatus", "pass");
						if (blnSet == false) {
							new CoordinateHighlightScreenshot(variablesJSON.objectStep);
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(strOuterHTML);
							} else {
								new ElementSet(strOuterHTML);
							}
							blnSet = true;
							blnAssert = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(strOuterHTML);
							blnSetSync = true;
						}
						blnStatus = true;
						break;
					case "hidden":
						if (blnSet == false) {
							variablesJSON.objectStep.putValue("strStatus", "pass");
							new CoordinateHighlightScreenshot(variablesJSON.objectStep);
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(strOuterHTML);
							} else {
								new ElementSet(strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementHidden();
							blnAssert = true;
						}
						blnStatus = true;
						break;
					case "value":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(strOuterHTML);
							} else {
								new ElementSet(strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVerifyValue().run();
							blnAssert = true;
						}
						variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						blnStatus = true;
						break;
					case "visible":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(strOuterHTML);
							} else {
								new ElementSet(strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVisible();
							blnAssert = true;
						}
						variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						blnStatus = true;
						break;
					case "enabled":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(strOuterHTML);
							} else {
								new ElementSet(strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVisible();
							new ElementEnabled();
							blnAssert = true;
						}
						variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						blnStatus = true;
						break;
					case "disabled":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(strOuterHTML);
							} else {
								new ElementSet(strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVisible();
							new ElementDisabled();
							blnAssert = true;
						}
						variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						blnStatus = true;
						break;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported | ExceptionKeywordNotValid e) {
					blnExit = true;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionVisibleTextNotInSelectList e) {
					blnSet = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnAssert = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnSet = false;
					blnSetSync = false;
					blnAssert = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotSet e) {
					blnSet = false;
					blnAssert = false;
				} catch (ExceptionElementNotDisabled e) {
					blnAssert = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionAlertNotComplete | ExceptionDoPostBackNotComplete | ExceptionJQueryAjaxNotComplete | ExceptionJQueryAnimationNotComplete | ExceptionAngularJsNotComplete | ExceptionPleaseWaitNotComplete e) {
					blnSetSync = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnAssert = false;
					blnEnabled = false;
					blnFound = false;
					blnSet = false;
					blnSetSync = false;
					blnVisible = false;
					logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementSetSync", "set", lngTimeStart) == true) {
						if (blnStatus == false) {
							new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						}
						logger.add("elementSetSync: strOutputValue = " + variablesJSON.objectStep.getString("strOutputValue"));
						if (variablesJSON.objectStep.verifyEquals("strOutputValue", "")) {
							variablesJSON.objectStep.putValue("strOutputValue", variablesJSON.objectStep.getString("strInputValue"));
						}
						logger.add("elementSetSync: strOutputValue after = " + variablesJSON.objectStep.getString("strOutputValue"));
						return;
					}
				}
			}
		}
	}

	private class ElementSetSyncComplete {
		private ElementSetSyncComplete(String strOuterHTML) throws ExceptionAlertNotComplete, ExceptionDoPostBackNotComplete, ExceptionJQueryAjaxNotComplete, ExceptionJQueryAnimationNotComplete, ExceptionAngularJsNotComplete, ExceptionPleaseWaitNotComplete {
			logger.add("  ==start==>ElementSetSyncComplete " + getDateTimestamp());
			long lngTimeStart = System.currentTimeMillis();
			try {
				if (objVariablesSetSync.gblnSyncPleaseWait == false) {
					///SyncPleaseWait
					new SyncPleaseWait();
					objVariablesSetSync.gblnSyncPleaseWait = true;
				}
				//				if (objVariablesSetSync.gblnSyncAlert == false) {
				//					///SyncAlert
				//					new SyncAlert();
				//					objVariablesSetSync.gblnSyncAlert = true;
				//				}
				if (objVariablesSetSync.gblnSyncWaitForReadyState == false) {
					///SyncWaitForReadyState
					new SyncWaitForReadyState();
					objVariablesSetSync.gblnSyncWaitForReadyState = true;
				}
				if (objVariablesSetSync.gblnSyncDoPostBack == false) {
					///SyncDoPostBack
					new SyncDoPostBack(strOuterHTML);
					objVariablesSetSync.gblnSyncDoPostBack = true;
				}
				if (objVariablesSetSync.gblnSyncJQueryAjax == false) {
					///SyncJQueryAjax
					new SyncJQueryAjax();
					objVariablesSetSync.gblnSyncJQueryAjax = true;
				}
				if (objVariablesSetSync.gblnSyncJQueryAnimation == false) {
					///SyncJQueryAnimation
					new SyncJQueryAnimation();
					objVariablesSetSync.gblnSyncJQueryAnimation = true;
				}
				if (objVariablesSetSync.gblnSyncAngularJs == false) {
					///SyncAngularJs
					new SyncAngularJs();
					objVariablesSetSync.gblnSyncAngularJs = true;
				}
			} finally {
				logger.add("ElementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
			}
		}
	}

	private class ElementTooltipGet {
		private String run() {
			//new SleepMilliseconds(2000);
			//WebElement objWebElement = objWebDriver.findElement(By.id("tooltipID"));
			//			System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
			//			System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			//			System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
			//			System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("This is the tip"));
			Actions ToolTip1 = new Actions(objVariablesSelenium.gobjWebDriver);
			ToolTip1.moveToElement(objVariablesSelenium.gobjWebElement).build().perform();
			for (int intKeysEach = 0; intKeysEach < 10; intKeysEach++) {
				System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
				new SleepMilliseconds(500);
			}
			//ToolTip1.clickAndHold(objVariablesSelenium.gobjWebElement).build().perform();
			//Actions.moveToElement(objVariablesSelenium.gobjWebElement).build().clickAndHold()
			//			System.out.println(objWebElement.getLocation().getX());
			//			System.out.println(objWebElement.getLocation().getY());
			//			System.out.println(objWebElement.getSize().width);
			//			System.out.println(objWebElement.getSize().height);
			//System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
			new SleepMilliseconds(3000);
			//			String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("This is a tooltip", "", "");
			//			System.out.println(">>>>>>>>>>>>>>>>>");
			//			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText controlGetText value is: " + strToolTipAutoItText);
			//			System.out.println(">>>>>>>>>>>>>>>>>");
			//			System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
			//			System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			//			if (objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]")) {
			//				System.out.println("winExists yes");
			//			}
			boolean blnToolTipAutoItText = objAutoItSetObject.objAutoIt.winWaitActive("[TITLE:this is bold text]", "", 10);
			String strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPCLASS:(.*tooltips.*)]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle REGEXPCLASS class value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  class value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
			new SleepMilliseconds(9000);
			//System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
			//System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			//System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winActive("[CLASS:tooltips_class32]"));
			//System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
			//While 1
			//    ; Look for a window of that class to appear
			//    If WinExists("[CLASS:tooltips_class32]", "") Then ; You may need more specific information here <<<<<<<<<<<<<<<<<<<<<<
			//        ; Get the position and size of the TrayTip
			//        $aPos = WinGetPos("[CLASS:tooltips_class32]", "") ; And here <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			//        ; Exit the While...WEnd loop
			//        ExitLoop
			//    EndIf
			//WEnd
			//' Grab tooltip
			//ToolTip = Window("nativeclass:=tooltips_class32").GetROProperty("text")
			System.out.println("winGetState before tootip create = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			objAutoItSetObject.objAutoIt.toolTip("This is a AutoIt tooltip", 1000, 500);
			System.out.println("winGetState before 14 = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
			new SleepMilliseconds(14000);
			//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("This is a tooltip", "", "");
			//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("tooltips_class32", "", "");
			//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[ACTIVE]");
			//"[ACTIVE]"
			if (objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]")) {
				strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[CLASS:tooltips_class32]");
				System.out.println(">>>>>>>>>>>>>>>>>");
				System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText value is: " + strToolTipAutoItText);
				System.out.println(">>>>>>>>>>>>>>>>>");
			}
			System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:This is a AutoIt toolti]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  TITLE value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPTITLE:.*tooltip.*]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  REGEXPTITLE value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPCLASS:(.*tooltips.*)]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle REGEXPCLASS class value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
			Dimension objWebDriverDimension = objVariablesSelenium.gobjWebElement.getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			System.out.println(-((intBrowserOuterWidth / 2) + 1));
			System.out.println(-((intBrowserOuterHeight / 2) + 1));
			/////ToolTip1.moveByOffset(-((intBrowserOuterWidth / 2) + 1), -((intBrowserOuterHeight / 2) + 1)).build().perform();
			//ToolTip1.moveByOffset(-intBrowserOuterWidth + 1, -intBrowserOuterHeight + 1).build().perform();
			String ToolTipTitleText = objVariablesSelenium.gobjWebElement.getAttribute("title");
			System.out.println("ToolTipTitleText value is: " + ToolTipTitleText);
			//ToolTip1.release(objWebElement).perform();
			//ToolTip1.release().perform();
			//ToolTip1.moveByOffset(0, 0);
			String[][] arrWindows = objAutoItSetObject.objAutoIt.winList("");
			for (String[] arrResultsEach : arrWindows) {
				System.out.println("Window value is: " + arrResultsEach[1]);
			}
			return strToolTipAutoItText;
		}
	}

	private class ElementTooltipGetSync {
		private ElementTooltipGetSync() {
			logger.add("  ==start==>ElementGetSync " + getDateTimestamp());
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
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnGet == false) {
						strGetValue = new ElementTooltipGet().run();
						variablesJSON.objectStep.putValue("strOutputValue", strGetValue);
						blnGet = true;
					}
					blnStatus = true;
					//				} catch (ExceptionElementTagNameNotSupported e) {
					//					blnExit = true;
					//					 logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementGetSync", "get", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
						blnGet = false;
					}
				}
			}
		}
	}

	private class ElementVerifyNotValue {
		private String run() throws ExceptionValueMatched, ExceptionElementTagNameNotSupported {
			logger.add("  ==start==>ElementVerifyNotValue " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = variablesJSON.objectStep.getString("strInputValue");
			try {
				strGetValue = new ElementGet().run();
				strActualValue = new VerifyNotMatch().run(strGetValue, strValueExpected);
				logger.add("ElementVerifyNotValue: after VerifyNotMatch");
			} catch (ExceptionValueMatched e) {
				logger.add("ElementVerifyNotValue: " + e.toString());
				throw new ExceptionValueMatched("ElementVerifyNotValue: Exception strActualValue = {" + strActualValue + "}");
			} finally {
				logger.add("ElementVerifyNotValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	private class ElementVerifyNotValueSync {
		private ElementVerifyNotValueSync() {
			logger.add("  ==start==>ElementVerifyNotValueSync " + getDateTimestamp());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVerifiedNot = false;
			Boolean blnVisible = false;
			String strActualValue = "";
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnVerifiedNot == false) {
						strActualValue = new ElementVerifyNotValue().run();
						blnVerifiedNot = true;
					}
					blnStatus = true;
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueMatched e) {
					logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementVerifyNotValueSync", "verify_not", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
						blnVerifiedNot = false;
					}
				}
			}
		}
	}

	private class ElementVerifyValue {
		private String run() throws ExceptionValueNotMatched, ExceptionElementTagNameNotSupported {
			logger.add("  ==start==>ElementVerifyValue " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = variablesJSON.objectStep.getString("strInputValue");
			try {
				strGetValue = new ElementGet().run();
				strActualValue = new VerifyMatch().run(strGetValue, strValueExpected);
			} finally {
				logger.add("ElementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	private class ElementVerifyValueSync {
		private ElementVerifyValueSync() {
			logger.add("  ==start==>ElementVerifyValueSync " + getDateTimestamp());
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
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					if (blnVerified == false) {
						strActualValue = new ElementVerifyValue().run();
						blnVerified = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					blnVerified = false;
					logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnVerified = false;
					logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnVerified = false;
					logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementVerifyValueSync", "verify", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
						blnVerified = false;
					}
				}
			}
		}
	}

	private class ElementVisible {
		private ElementVisible() throws ExceptionElementNotVisible {
			// TODO elementVisible add check for class and css, commented code needs to be tested
			logger.add("  ==start==>ElementVisible " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnVisible = false;
			try {
				// TODO Alert complete
				if (variablesJSON.objectStep.verifyEquals("strTagName", "title")) {
					blnVisible = true;
					return;
				}
				if (variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == true) {
						blnVisible = true;
						variablesJSON.objectStep.putValue("strHighlightArea", "alert");
						new CoordinatesAlert();
						return;
					} else {
						throw new ExceptionElementNotVisible("Alert popup was not found.");
					}
				}
				if (objVariablesSelenium.gobjWebElement.isDisplayed()) {
					new CoordinatesElement();
					blnVisible = true;
					return;
					// if (variablesJSON.objectStep.containsKey("intElementWidth")) {
					// int intElementWidth = Integer.parseInt(variablesJSON.objectStep.get("intElementWidth").toString());
					// int intElementHeight = Integer.parseInt(variablesJSON.objectStep.get("intElementHeight").toString());
					//  logger.add("elementVisible intElementWidth = " + intElementWidth);
					//  logger.add("elementVisible intElementHeight = " + intElementHeight);
					// if (intElementWidth == 0 || intElementHeight == 0) {
					// throw new ExceptionElementNotVisible("Element's heigh or width is 0");
					// } else {
					// return true;
					// }
					// } else {
					// throw new ExceptionElementNotVisible("Element's heigh or width is 0");
					// }
				} else {
					throw new ExceptionElementNotVisible("Element isDisplayed failed");
				}
			} finally {
				logger.add("ElementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementVisibleSync {
		private ElementVisibleSync() {
			logger.add("  ==start==>ElementVisibleSync " + getDateTimestamp());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					logger.add("ElementVisibleSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementVisibleSync", "syncvisible", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
					}
				}
			}
		}
	}

	private class ExceptionAlertNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionAlertNotComplete(String message) {
			super(message);
		}
	}

	private class ExceptionAngularJsNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionAngularJsNotComplete(String message) {
			super(message);
		}
	}

	private class ExceptionBrowserDriverNotSupported extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionBrowserDriverNotSupported(String message) {
			super(message);
		}
	}

	private class ExceptionDoPostBackNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionDoPostBackNotComplete(String message) {
			super(message);
		}
	}

	private class ExceptionElementNotDisabled extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementNotDisabled(String message) {
			super(message);
		}
	}

	private class ExceptionElementNotEnabled extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementNotEnabled(String message) {
			super(message);
		}
	}

	private class ExceptionElementNotFound extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementNotFound(String message) {
			super(message);
		}
	}

	private class ExceptionElementNotHidden extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementNotHidden(String message) {
			super(message);
		}
	}

	private class ExceptionElementNotSet extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementNotSet(String message) {
			super(message);
		}
	}

	private class ExceptionElementNotVisible extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementNotVisible(String message) {
			super(message);
		}
	}

	private class ExceptionElementTagNameNotSupported extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementTagNameNotSupported(String message) {
			super(message);
		}
	}

	private class ExceptionElementValueNotVerified extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionElementValueNotVerified(String message) {
			super(message);
		}
	}

	private class ExceptionJQueryAjaxNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionJQueryAjaxNotComplete(String message) {
			super(message);
		}
	}

	private class ExceptionJQueryAnimationNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionJQueryAnimationNotComplete(String message) {
			super(message);
		}
	}

	private class ExceptionJSONKeyNotPresent extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionJSONKeyNotPresent(String message) {
			super(message);
		}
	}

	private class ExceptionKeywordNotValid extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionKeywordNotValid(String message) {
			super(message);
		}
	}

	private class ExceptionMultipleElementsFound extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionMultipleElementsFound(String message) {
			super(message);
		}
	}

	private class ExceptionPleaseWaitNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionPleaseWaitNotComplete(String message) {
			super(message);
		}
	}

	private class ExceptionValueMatched extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionValueMatched(String message) {
			super(message);
		}
	}

	private class ExceptionValueNotMatched extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionValueNotMatched(String message) {
			super(message);
		}
	}

	private class ExceptionVisibleTextNotInSelectList extends Exception {
		private static final long serialVersionUID = 1L;

		private ExceptionVisibleTextNotInSelectList(String message) {
			super(message);
		}
	}

	private class ImageDecodeFromString {
		private BufferedImage run(String strImageString) {
			logger.add("  ==start==>ImageDecodeFromString " + getDateTimestamp());
			BufferedImage objBufferedImage = null;
			byte[] arrImageByte;
			try {
				Base64Encoder objBASE64Decoder = new Base64Encoder();
				arrImageByte = objBASE64Decoder.decode(strImageString);
				ByteArrayInputStream objByteArrayInputStream = new ByteArrayInputStream(arrImageByte);
				objBufferedImage = ImageIO.read(objByteArrayInputStream);
				objByteArrayInputStream.close();
			} catch (Exception e) {
				e.toString();
			}
			return objBufferedImage;
		}
	}

	private class ImageEncodeToString {
		private String run(BufferedImage objBufferedImage, String strImageType) {
			logger.add("  ==start==>ImageEncodeToString " + getDateTimestamp());
			String strImageString = null;
			ByteArrayOutputStream objByteArrayOutputStreams = new ByteArrayOutputStream();
			try {
				ImageIO.write(objBufferedImage, strImageType, objByteArrayOutputStreams);
				byte[] arrImageByte = objByteArrayOutputStreams.toByteArray();
				Base64Encoder objBASE64Encoder = new Base64Encoder();
				strImageString = objBASE64Encoder.encode(arrImageByte);
				objByteArrayOutputStreams.close();
			} catch (IOException e) {
				e.toString();
			}
			return strImageString;
		}
	}

	private class InternetExplorerProcessKill {
		private InternetExplorerProcessKill() {
			logger.add("  ==start==>InternetExplorerProcessKill " + getDateTimestamp());
			DesiredCapabilities desiredCapabilities = null;
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setJavascriptEnabled(true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			objVariablesSelenium.gobjWebDriver = new InternetExplorerDriver(desiredCapabilities);
			objVariablesSelenium.gobjWebDriver.get("about:blank");
			objVariablesSelenium.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
			// objVariablesSelenium.gobjWebDriver.navigate().to(variablesJSON.objectStep.get("strInputValue").toString());
			// objVariablesSelenium.gobjWebDriver.manage().window().maximize();
			// objVariablesSelenium.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			// // objVariablesSelenium.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
			objVariablesSelenium.gobjWebDriver.close();
			objVariablesSelenium.gobjWebDriver.quit();
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			new WindowsProcessKill("taskkill /F /IM IEDriverServer.exe");
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 1
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 32
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 4351
		}
	}

	private class InternetExplorerVersion {
		private String strKeyName = "";
		private Process objProcess;
		private String strSvcUpdateVersion = "11.0.27";
		private String strSvcvcVersion = "11.0.9600.18163";
		private String strSvcvcKBNumber = "KB3124275";
		private String strExpectedKeyValue = "";
		private String strActualKeyValue = "";

		private void verify() throws IOException {
			logger.add("  ==start==>InternetExplorerVersion " + getDateTimestamp());
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
					logger.add(strFullRegistryKey.replaceAll("\\s+", " ").trim());
					logger.add(strActualKeyValue);
				}
			}
		}
	}

	private class JSONArrayExtended extends JSONArray {
		private JSONArrayExtended(JSONObject parent) {
			super();
		}
	}

	private class JSONObjectExtended extends JSONObject {
		private static final long serialVersionUID = 1L;

		private JSONObjectExtended(JSONObject parent) {
			super(parent);
		}

		private JSONObjectExtended(JSONObjectExtended parent) {
			super(parent);
		}

		private JSONObjectExtended(Map<String, String> map) {
			super(map);
		}

		@SuppressWarnings("unchecked")
		private void addJsonObject(JSONObjectExtended objJsonObjectToAdd) {
			if (this.isEmpty() == true) {
			} else {
				this.putAll(objJsonObjectToAdd);
			}
		}

		private Boolean getBoolean(String strKeyName) {
			return Boolean.parseBoolean(this.get(strKeyName).toString());
		}

		private int getInt(String strKeyName) {
			if (this.getString(strKeyName).equals("")) {
				return 0;
			}
			return Integer.parseInt(this.get(strKeyName).toString());
		}

		private String getLowerCase(String strKeyName) {
			return this.getString(strKeyName).toLowerCase();
		}

		private String getString(String strKeyName) {
			String strJSONObjectValue = "";
			if (this.containsKey(strKeyName)) {
				strJSONObjectValue = this.get(strKeyName).toString();
				// logger.add("JSONObjectExtended:getString strJSONObjectValue = " + strJSONObjectValue);
				return strJSONObjectValue;
			} else {
				// logger.add("JSONObjectExtended:getString JSON Key " + strKeyName + " for keyword link name " + strKeyName + " not present");
				return "";
			}
		}

		private String getValue(String strInputValue, String strKeywordName) throws ExceptionJSONKeyNotPresent {
			String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
			String strJSONObjectValue = "";
			this.validateKey(strJSONObjectKey);
			strJSONObjectValue = this.getString(strJSONObjectKey);
			return strJSONObjectValue;
		}

		@SuppressWarnings({ "unused", "unchecked" })
		private void putAllReplace(Map<String, String> map) {
			this.clear();
			this.putAll(map);
		}

		@SuppressWarnings("unchecked")
		private void putInt(String strKeyName, int intKeyValue) {
			this.put(strKeyName, Integer.toString(intKeyValue));
		}

		@SuppressWarnings("unchecked")
		private void putLong(String strKeyName, Long lngKeyValue) {
			this.put(strKeyName, Long.toString(lngKeyValue));
		}

		@SuppressWarnings("unchecked")
		private void putString(String strKeyName, String strKeyValue) {
			this.put(strKeyName, strKeyValue);
		}

		@SuppressWarnings("unchecked")
		private void putValue(String strKeyName, String strKeyValue) {
			this.put(strKeyName, strKeyValue);
		}

		private String returnKeyword(String strKeyName1) {
			String strValueToFindKeyword = this.getLowerCase(strKeyName1);
			int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
			String strKeyword = "";
			if (intRightArrowPosition > -1) {
				strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
			}
			return strKeyword;
		}

		private void validateKey(String strKeyName) throws ExceptionJSONKeyNotPresent {
			if (!this.containsKey(strKeyName)) {
				throw new ExceptionJSONKeyNotPresent("JSON Key " + strKeyName + " not present");
			}
		}

		private Boolean verifyEquals(String strKeyName, String strLowerCaseValue) {
			return this.get(strKeyName).toString().trim().toLowerCase().equals(strLowerCaseValue);
		}

		private Boolean verifyKeyValue(String file) {
			return null;
		}

		private void writeKeys(String file) throws IOException {
			for (Iterator<?> iterator = this.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				logger.add("WriteJsonKeys: " + key + " = " + this.get(key));
			}
		}
	}

	private class JvmBitVersion {
		private String get() {
			String strJvmBitVersion = System.getProperty("sun.arch.data.model");
			logger.add("JvmBitVersion: System.getProperty(sun.arch.data.model) = " + strJvmBitVersion + " " + getDateTimestamp());
			return strJvmBitVersion;
		}
	}

	private class KeywordsValid {
		//TODO KeywordsValid to check all
		private String[] arrKV_strLogicalName = { "<te>" };
		private String[] arrKV_strAttributeValues = { "<re>", "<td>", "<ti>", "<tl>" };
		private String[] arrKV_strInputValue = { "<re>", "<td>", "<ti>", "<tl>", "<click>", "<doubleclick>", "<rightclick>", "<on>", "<off>", "<blank>", "<first>", "<second>", "<third>", "<last>", "<random>", "<contains>", "<ends>", "<starts>", "<skip>" };
		private String[] arrKV_strLoopOrIf = { "<if>", "<else if>", "<else>", "<end if>", "<loopstart>", "<loopexit>", "<loopend>" };
		private String[] arrResults;
		private String strInputValueFromJson = "";
		private String strKeywordEach = "";
		private String strKeywordValue = "";

		private KeywordsValid() {
			String[] arrKeys = new StepNames().getOriginal();
			boolean blnValid = false;
			String[] arrKeywordsValid;
			objVariablesCommon.strOriginalAttributes = createObjectName();
			for (String strKey : arrKeys) {
				switch (strKey) {
				case "strAction":
				case "strTagName":
				case "strAttributeNames":
				case "strAssert":
				case "blnOptional":
				case "blnExitOnFail":
				case "intMillisecondsToWait":
				case "strFunction":
				case "strOutputLinkName":
				case "blnPleaseWait":
				case "blnHighlight":
				case "blnScreenshot":
				case "strAssistiveProperties":
				case "strOutputValue":
					this.getKeywordsAndValue(variablesJSON.objectStep.getString(strKey));
					//					if (arrResults.length > 0) {
					//						variablesJSON.objectStep.putValue("strStatus", "fail");
					//						variablesJSON.objectStep.putValue("blnExitOnFail", "true");
					//					}
					break;
				case "strLogicalName":
					this.getKeywordsAndValue(variablesJSON.objectStep.getString(strKey));
					for (String strResultsEach : arrResults) {
						for (String strKeywordsValidEach : arrKV_strLogicalName) {
							if (strResultsEach.equals(strKeywordsValidEach)) {
								blnValid = true;
								JSONObjectExtended objJsonObjectElementNode = new JSONObjectExtended((JSONObject) variablesJSON.objectElement.get(strKeywordValue));
								try {
									variablesJSON.objectStep.putValue("strTagName", objJsonObjectElementNode.getValue("strTagName", ""));
									variablesJSON.objectStep.putValue("strAttributeNames", objJsonObjectElementNode.getValue("strAttributeNames", ""));
									variablesJSON.objectStep.putValue("strAttributeValues", objJsonObjectElementNode.getValue("strAttributeValues", ""));
								} catch (ExceptionJSONKeyNotPresent e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
						}
					}
					break;
				case "strAttributeValues":
					String strKeywordValueCombined = "";
					String arrAttributeValues[] = variablesJSON.objectStep.getString(strKey).split("\\|", -1);
					for (String strAttributeValuesEach : arrAttributeValues) {
						this.getKeywordsAndValue(strAttributeValuesEach);
						for (String strResultsEach : arrResults) {
							// logger.add("strResultsEach = " + strResultsEach);
							// logger.add("strKeywordValue = " + strKeywordValue);
							for (String strKeywordsValidEach : arrKV_strAttributeValues) {
								if (strResultsEach.equals(strKeywordsValidEach)) {
									blnValid = true;
									this.getJsonValue(strKeywordEach, strKeywordValue);
									strKeywordValue = strInputValueFromJson;
									break;
								}
							}
						}
						if (strKeywordValueCombined.trim().length() == 0) {
							strKeywordValueCombined = strKeywordValue;
						} else {
							strKeywordValueCombined = strKeywordValueCombined + "|" + strKeywordValue;
						}
					}
					variablesJSON.objectStep.putValue("strAttributeValues", strKeywordValueCombined);
					break;
				case "strInputValue":
					objVariablesCommon.strOriginalInputValue = variablesJSON.objectStep.getString(strKey);
					this.getKeywordsAndValue(variablesJSON.objectStep.getString(strKey));
					for (String strResultsEach : arrResults) {
						for (String strKeywordsValidEach : arrKV_strInputValue) {
							if (strResultsEach.equals(strKeywordsValidEach)) {
								blnValid = true;
								this.getJsonValue(strResultsEach, strKeywordValue);
								strKeywordValue = strInputValueFromJson;
								break;
							}
						}
					}
					logger.add("KeywordsValid: blnValid = " + blnValid);
					variablesJSON.objectStep.putValue("strInputValue", strKeywordValue);
					// logger.add("strKeywordValue = " + strKeywordValue);
					// logger.add("strInputValueFromJson = " + strInputValueFromJson);
					break;
				case "strLoopOrIf":
					break;
				}
			}
		}

		private void getJsonValue(String strKeyword, String strInputValue) {
			logger.add("getJsonValue strKeyword = " + strKeyword);
			logger.add("getJsonValue strInputValue = " + strInputValue);
			try {
				switch (strKeyword) {
				case "<td>":
					strInputValueFromJson = variablesJSON.objectTestData.getValue(strInputValue, "<td>");
					break;
				case "<ti>":
					strInputValueFromJson = variablesJSON.objectTestInstancesEach.getValue(strInputValue, "<ti>");
					break;
				case "<tl>":
					strInputValueFromJson = variablesJSON.objectLinks.getValue(strInputValue, "<tl>");
					break;
				case "<re>":
					strInputValueFromJson = strInputValue;
					break;
				case "<skip>":
					strInputValueFromJson = "<skip>";
					break;
				default:
					strInputValueFromJson = strKeyword + strInputValue;
					break;
				}
			} catch (ExceptionJSONKeyNotPresent e) {
				// TODO Auto-generated catch block
				logger.add("StepSetupDefaults: Exception = " + e.toString());
			}
		}

		private void getKeywordsAndValue(String strValueToFindKeyword) {
			String strKeyword = "";
			String strKeywordCombined = "";
			int intLeftArrowPositionEach = 0;
			int intLeftArrowPosition = -1;
			int intRightArrowPosition = -1;
			int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace("<", "").length();
			strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
			for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
				intLeftArrowPositionEach = intLeftArrowPosition + 1;
				intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intLeftArrowPositionEach);
				intRightArrowPosition = strValueToFindKeyword.indexOf(">", intLeftArrowPosition);
				if (intLeftArrowPosition > -1) {
					strKeyword = strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1).toLowerCase();
					strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
					if (strKeyword.equals("<re>")) {
						strKeywordValue = strKeyword + strKeywordValue;
					}
					logger.add("getKeywordsAndValue strKeyword = " + strKeyword);
					if (strKeywordCombined.length() == 0) {
						strKeywordCombined = strKeyword;
					} else {
						strKeywordCombined = strKeywordCombined + "|" + strKeyword;
					}
				}
			}
			arrResults = strKeywordCombined.split("\\|");
			Collections.reverse(Arrays.asList(arrResults));
		}
	}

	private class Logger {
		private StringBuilder objStringBuilder = new StringBuilder();;

		private Logger(String strTextToAdd) {
			System.out.println(strTextToAdd);
			this.objStringBuilder.append(strTextToAdd);
			this.objStringBuilder.append(System.getProperty("line.separator"));
		}

		private void add(String strTextToAdd) {
			System.out.println(strTextToAdd);
			objStringBuilder.append(strTextToAdd);
			objStringBuilder.append(System.getProperty("line.separator"));
		}

		private void deleteLog() {
			objStringBuilder.delete(0, objStringBuilder.length());
		}

		private String getLog() {
			return objStringBuilder.toString();
		}
	}

	private class MonthGet {
		private String run(int month) {
			logger.add("  ==start==>MonthGet " + getDateTimestamp());
			return new DateFormatSymbols().getMonths()[month];
		}
	}

	private class OperatingSystem {
		private String strOS = "";

		private OperatingSystem() {
			logger.add("  ==start==>OperatingSystem " + getDateTimestamp());
			strOS = System.getProperty("os.name").toLowerCase();
			if (strOS.contains("win")) {
				strOS = "Windows";
			} else if (strOS.contains("nux") || strOS.contains("nix")) {
				strOS = "Linux";
			} else if (strOS.contains("mac")) {
				strOS = "Mac";
			} else if (strOS.contains("sunos")) {
				strOS = "Solaris";
			} else {
				strOS = "Other";
			}
		}
	}

	private class PathCreation {
		private String gstrPathSystemUserDir = System.getProperty("user.dir");
		private String gstrTestArea;
		private String gstrPathData;
		private String gstrPathTestConfiguration;
		private String gstrPathTestData;
		private String gstrPathTestElements;
		private String gstrPathTestInstances;
		private String gstrPathTestModules;
		private String gstrPathTestSteps;
		private String gstrPathImages;
		private String gstrPathResults;
		private String gstrPathResultsTop;
		private String gstrNameTest;

		private void changeDirectoryNameStatus(String strTestStatus) {
			logger.add("PathCreation:changeDirectoryNameStatus gstrPathResults = " + gstrPathResults);
			File objDirectoryOld = new File(gstrPathResults);
			String strPathResultsNew = gstrPathResults.substring(0, gstrPathResults.length() - 1) + "_" + strTestStatus + "\\";
			logger.add("PathCreation:changeDirectoryNameStatus strPathResultsNew = " + strPathResultsNew);
			File objDirectoryNew = new File(strPathResultsNew);
			objDirectoryOld.renameTo(objDirectoryNew);
			gstrPathResults = strPathResultsNew;
		}

		private void setDirectory(String strTestArea) {
			gstrPathData = "Data/" + strTestArea + "/";
			gstrPathTestConfiguration = gstrPathData + "test_configuration/";
			gstrPathTestData = gstrPathData + "test_data/";
			gstrPathTestElements = gstrPathData + "test_elements/";
			gstrPathTestInstances = gstrPathData + "test_instances/";
			gstrPathTestModules = gstrPathData + "test_modules/";
			gstrPathTestSteps = gstrPathData + "test_steps/";
		}

		private void setPathResults(int intTestInstanceSize, String strTestConfigurationFileName) {
			logger.add("PathCreation:setPathResults intTestInstanceSize = " + intTestInstanceSize);
			logger.add("PathCreation:setPathResults strTestConfigurationFileName = " + strTestConfigurationFileName);
			String gstrDateTimestamp = getDateTimestamp();
			logger.add("PathCreation:setPathResults gstrDateTimestamp = " + gstrDateTimestamp);
			logger.add("PathCreation:setPathResults gstrPathImages==null = " + gstrPathImages);
			if (gstrPathImages == null) {
				gstrPathResultsTop = gstrPathSystemUserDir + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\";
				logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				if (intTestInstanceSize > 1) {
					gstrPathResultsTop = gstrPathResultsTop + gstrDateTimestamp + "\\Iterations_" + intTestInstanceSize + "\\";
					logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				}
			}
			gstrPathResults = gstrPathResultsTop + gstrDateTimestamp + "\\";
			logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
			gstrPathImages = gstrPathResults + "images\\";
			logger.add("PathCreation:setPathResults gstrPathImages = " + gstrPathImages);
			new File(gstrPathImages).mkdirs();
		}
	}

	private class ProcessKillInternetExplorer {
		private void run() {
			logger.add("  ==start==>ProcessKillInternetExplorer " + getDateTimestamp());
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			new WindowsProcessKill("taskkill /F /IM IEDriverServer.exe");
		}
	}

	private class RectangleAreaByName {
		private RectangleAreaByName(Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
			logger.add("  ==start==>RectangleAreaByName " + getDateTimestamp());
			logger.add("RectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
			long lngStartTime = System.currentTimeMillis();
			int intX = 0;
			int intY = 0;
			int intWidth = 0;
			int intHeight = 0;
			if (strAreaObjectName.equals("")) {
				if (objVariablesSelenium.gobjWebDriver == null) {
					strAreaObjectName = "screen";
				}
				if (objVariablesSelenium.gobjWebElement == null) {
					if (variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
						strAreaObjectName = "element";
					} else {
						strAreaObjectName = "screen";
					}
				} else {
					if (variablesJSON.objectStep.containsKey("intElementScreenX") == false) {
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
					intX = variablesJSON.objectStep.getInt("intBrowserOuterX");
					intY = variablesJSON.objectStep.getInt("intBrowserOuterY");
					intWidth = variablesJSON.objectStep.getInt("intBrowserOuterWidth");
					intHeight = variablesJSON.objectStep.getInt("intBrowserOuterHeight");
					break;
				case "page":
					// TODO change this to get absolute screen coordinates
					WebElement objWebElementPage = objVariablesSelenium.gobjWebDriver.findElement(By.xpath("//body"));
					intX = objWebElementPage.getLocation().getX() - intThickness;
					intY = objWebElementPage.getLocation().getY() - intThickness;
					intWidth = objWebElementPage.getSize().width + (2 * intThickness);
					intHeight = objWebElementPage.getSize().height + (2 * intThickness);
					break;
				case "element":
				case "alert":
					intX = variablesJSON.objectStep.getInt("intElementScreenX") - intThickness;
					intY = variablesJSON.objectStep.getInt("intElementScreenY") - intThickness;
					intWidth = variablesJSON.objectStep.getInt("intElementWidth") + (2 * intThickness);
					intHeight = variablesJSON.objectStep.getInt("intElementHeight") + (2 * intThickness);
					break;
				default:
					logger.add("RectangleAreaByName: epected values = screen, window, page and element not " + strAreaObjectName);
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
				logger.add("RectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class RegularExpressionMatch {
		private String run(String strPattern, String strActualValue) throws ExceptionValueNotMatched {
			Boolean blnMatched = false;
			Long lngStartTime = System.currentTimeMillis();
			logger.add("  ==start==>RegularExpressionMatch " + getDateTimestamp());
			String strMatchedString = "";
			try {
				Matcher objMatcher = Pattern.compile(strPattern).matcher(strActualValue);
				objMatcher.matches();
				strMatchedString = objMatcher.group(0);
				blnMatched = true;
				return strMatchedString;
			} catch (Exception e) {
				logger.add("RegularExpressionMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("RegularExpressionMatch: Exception " + e.toString());
			} finally {
				logger.add("RegularExpressionMatch: finally Matched = {" + blnMatched + "} strMatchedString = {" + strMatchedString + "} strPattern = {" + strPattern + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ScrollToBottom {
		private ScrollToBottom() {
			logger.add("  ==start==>ScrollToBottom " + getDateTimestamp());
			// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
			JavascriptExecutor executor = (JavascriptExecutor) objVariablesSelenium.gobjWebDriver;
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		}
	}

	private class Sleep {
		private Sleep() {
			new SleepMilliseconds(variablesJSON.objectStep.getInt("strInputValue"));
		}
	}

	private class SleepMilliseconds {
		private SleepMilliseconds(int intMillisecondsToWait) {
			// logger.add("  ==start==>SleepMilliseconds " + getDateTimestamp());
			try {
				TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
				variablesJSON.objectStep.putString("strStatus", "pass");
			} catch (Exception e) {
				variablesJSON.objectStep.putString("strStatus", "fail");
				logger.add("SleepMilliseconds: Exception = " + e.toString());
			}
		}
	}

	private class SleepSync {
		private SleepSync() {
			Long lngTimeStart = System.currentTimeMillis();
			new Sleep();
			stepDuration("SleepSync", lngTimeStart, "sleep");
		}
	}

	private class StepNames {
		private String strKeys1 = "strAction|strLogicalName|strTagName|strAttributeNames|strAttributeValues|strInputValue|strAssert|blnOptional|blnExitOnFail";
		private String strKeys2 = "|intMillisecondsToWait|strFunction|strOutputLinkName|strLoopOrIf|blnPleaseWait|blnHighlight|blnScreenshot|strAssistiveProperties|strOutputValue";
		private String strKeys3 = "intBrowserInnerWidth|intBrowserInnerHeight|intBrowserOuterX|intBrowserOuterY|intBrowserOuterWidth|intBrowserOuterHeight";
		private String strKeys4 = "|intElementScreenX|intElementScreenY|intElementX|intElementY|intElementWidth|intElementHeight|strTagType|strType|strCurrentWindowHandle";
		private String strKeys5 = "|strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strHighlightArea|strScreenshotFilePath|strStatus|strTestModuleStep";
		private String strKeysDefault = "intMillisecondsToWait|blnOptional|strAssert|blnExitOnFail|blnPleaseWait|blnHighlight|blnScreenshot|strScreenshotArea|strStatus";
		private StringBuilder objStringBuilder = new StringBuilder();

		private String[] getComplete() {
			objStringBuilder.append(strKeys1);
			objStringBuilder.append(strKeys2);
			objStringBuilder.append("|");
			objStringBuilder.append(strKeys3);
			objStringBuilder.append(strKeys4);
			objStringBuilder.append(strKeys5);
			return objStringBuilder.toString().split("\\|");
		}

		private String[] getDefault() {
			return strKeysDefault.toString().split("\\|");
		}

		private String[] getOriginal() {
			objStringBuilder.append(strKeys1);
			objStringBuilder.append(strKeys2);
			return objStringBuilder.toString().split("\\|");
		}

		private String[] getRuntime() {
			objStringBuilder.append(strKeys3);
			objStringBuilder.append(strKeys4);
			objStringBuilder.append(strKeys5);
			return objStringBuilder.toString().split("\\|");
		}
	}

	@SuppressWarnings("unused")
	private class StepSetupDefaults {
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
					variablesJSON.objectStep.putValue(strKey, "");
				}
			}
			new KeywordsValid();
			Class<?> objClass = null;
			try {
				objClass = Class.forName("org.DragonflyAutomation.Dragonfly$StepSetupDefaults");
			} catch (ClassNotFoundException e) {
				logger.add("StepSetupDefaults: ClassNotFoundException = " + e.toString());
			} catch (Exception e) {
				logger.add("StepSetupDefaults: Class.forName Exception = " + e.toString());
			}
			for (String strKey : arrDefaultKeys) {
				Field objField = null;
				try {
					objField = objClass.getDeclaredField("strDefault_" + strKey);
				} catch (NoSuchFieldException | SecurityException e) {
					logger.add("StepSetupDefaults: NoSuchFieldException = " + e.toString());
				} catch (Exception e) {
					logger.add("StepSetupDefaults: Exception = " + e.toString());
				}
				if (variablesJSON.objectStep.get(strKey).toString().trim().length() == 0) {
					try {
						variablesJSON.objectStep.putValue(strKey, (String) objField.get(this));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.add("StepSetupDefaults: IllegalArgumentException = " + e.toString());
						e.printStackTrace();
					} catch (Exception e) {
						logger.add("StepSetupDefaults: Exception = " + e.toString());
					}
				}
			}
			variablesJSON.objectStep.putValue("strCurrentWindowHandle", strCurrentWindowHandle);
		}
	}

	private class StepsManual {
		private StringBuilder objStringBuilder = new StringBuilder();;

		private void delete() {
			objStringBuilder.delete(0, objStringBuilder.length());
		}

		private String get() {
			return objStringBuilder.toString();
		}

		private void set(String strTextToAdd) {
			System.out.println(strTextToAdd);
			objStringBuilder.append(strTextToAdd);
			objStringBuilder.append(System.getProperty("line.separator"));
		}
	}

	private class SyncAlert {
		private SyncAlert() throws ExceptionAlertNotComplete {
			logger.add("  ==start==>SyncAlert " + getDateTimestamp());
			if (new AlertFind().run() == true) {
				throw new ExceptionAlertNotComplete("");
			}
		}
	}

	private class SyncAngularJs {
		private SyncAngularJs() throws ExceptionAngularJsNotComplete {
			logger.add("  ==start==>SyncAngularJs " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return (window.angular != null);");
				logger.add("SyncAngularJs: = " + blnAngularJs);
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				if (lngAngularJsInjectorActive > 0) {
					throw new ExceptionAngularJsNotComplete("");
				}
			} catch (Exception e) {
				logger.add("SyncAngularJs: AngularJS Exception = " + e.toString());
			} finally {
				logger.add("SyncAngularJs: lngAngularJsInjectorActive = " + lngAngularJsInjectorActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncDoPostBack {
		private SyncDoPostBack(String strOuterHTML) throws ExceptionDoPostBackNotComplete {
			logger.add("  ==start==>SyncDoPostBack " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				try {
					logger.add("SyncDoPostBack: __EVENTTARGET value = " + objVariablesSelenium.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !objVariablesSelenium.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
					if (blnEventTarget == true) {
						throw new ExceptionDoPostBackNotComplete("");
					}
				} catch (Exception e) {
					logger.add("SyncDoPostBack: Exception = " + e.toString());
				} finally {
					logger.add("SyncDoPostBack: blnEventTarget = " + blnEventTarget + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				}
			}
		}
	}

	private class SyncJQueryAjax {
		private SyncJQueryAjax() throws ExceptionJQueryAjaxNotComplete {
			logger.add("  ==start==>SyncJQueryAjax " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				blnJquery = (boolean) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return (jQuery.active);");
					logger.add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive);
					if (lngJqueryActive > 0) {
						throw new ExceptionJQueryAjaxNotComplete("");
					}
				}
			} catch (Exception e) {
				logger.add("SyncJQueryAjax: JqueryActive Exception = " + e.toString());
			} finally {
				logger.add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncJQueryAnimation {
		private SyncJQueryAnimation() throws ExceptionJQueryAnimationNotComplete {
			logger.add("  ==start==>SyncJQueryAnimation " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			long lngElementsAnimated = 0;
			boolean blnJqueryExist = false;
			try {
				blnJqueryExist = (boolean) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJqueryExist == true) {
					lngElementsAnimated = (long) ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return $(\":animated\").length");
				}
				if (lngElementsAnimated > 0) {
					throw new ExceptionJQueryAnimationNotComplete("");
				}
			} catch (Exception e) {
				logger.add("SyncJQueryAnimation: Exception = " + e.toString());
			} finally {
				logger.add("SyncJQueryAnimation: lngElementsAnimated = " + lngElementsAnimated + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncPleaseWait {
		private SyncPleaseWait() throws ExceptionDoPostBackNotComplete {
			long lngStartTime = System.currentTimeMillis();
			logger.add("  ==start==>SyncPleaseWait " + getDateTimestamp());
			try {
				new ElementPleaseWait();
			} catch (ExceptionElementNotHidden e1) {
				logger.add("SyncPleaseWait: ExceptionElementNotHidden = " + e1.toString());
				throw new ExceptionDoPostBackNotComplete("");
			} catch (Exception e) {
				logger.add("SyncPleaseWait: Exception = " + e.toString());
			} finally {
				logger.add("SyncPleaseWait: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncTime {
		private long startTime;
		private long endTime;

		private long getDuration() {
			return endTime - startTime;
		}

		private void start() {
			startTime = System.currentTimeMillis();
		}

		private void stop() {
			endTime = System.currentTimeMillis();
		}
	}

	private class SyncWaitForReadyState {
		private SyncWaitForReadyState() {
			long lngStartTime = System.currentTimeMillis();
			logger.add("  ==start==>SyncWaitForReadyState " + getDateTimestamp());
			try {
				new WaitForReadyState().run();
			} catch (Exception e) {
				logger.add("SyncWaitForReadyState: Exception = " + e.toString());
			} finally {
				logger.add("SyncWaitForReadyState: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class TestConfigurationSetup {
		private int intTestInstanceSize;
		private JSONObjectExtended objJsonObjectTestConfigurationFile = null;
		private JSONParser objJsonParser = new JSONParser();

		@SuppressWarnings("unchecked")
		private JSONArray putAllArrays(String strJsonArrayName, String strJsonObjectName, String strPath) {
			int intJsonArrayEach = 0;
			JSONArray objJsonArray = null;
			JSONArray objJsonArrayEach = null;
			JSONArray objJsonArrayList = null;
			JSONObjectExtended objJsonObjectFileEach = null;
			String strFileNameEach = "";
			String strFilePathJsonArray = "";
			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.get(strJsonArrayName);
			if (objJsonArrayList.size() == 0) {
				return null;
			} else {
				for (intJsonArrayEach = 0; intJsonArrayEach < objJsonArrayList.size(); intJsonArrayEach++) {
					strFileNameEach = objJsonArrayList.get(intJsonArrayEach).toString();
					strFilePathJsonArray = strPath + strFileNameEach;
					logger.add("TestConfigurationSetup:putAllArrays strFilePathJsonArray = " + strFilePathJsonArray);
					try {
						objJsonObjectFileEach = new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathJsonArray)));
						objJsonArrayEach = (JSONArray) objJsonObjectFileEach.get(strJsonObjectName);
						int intStep = -1;
						Iterator<JSONObject> iterator = objJsonArrayEach.iterator();
						while (iterator.hasNext()) {
							intStep++;
							iterator.next().put("strTestModuleStep", strFileNameEach.replace(".json", "") + ": " + intStep);
						}
						Iterator<JSONObject> iterator2 = objJsonArrayEach.iterator();
						while (iterator2.hasNext()) {
							System.out.println(iterator2.next());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logger.add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
						e.printStackTrace();
					}
					if (intJsonArrayEach == 0) {
						objJsonArray = objJsonArrayEach;
					} else {
						objJsonArray.addAll(objJsonArrayEach);
					}
				}
			}
			logger.add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
			return objJsonArray;
		}

		@SuppressWarnings("unchecked")
		private JSONObjectExtended putAllObjects(String strJsonArrayName, String strJsonObjectName, String strPath) {
			logger.add("  ==start==>putAllObjects " + getDateTimestamp());
			JSONParser objJsonParser = new JSONParser();
			JSONObject obj = new JSONObject();
			Integer intJsonObjectEach = 0;
			JSONArray objJsonArrayList = null;
			JSONObjectExtended objJsonObject = new JSONObjectExtended(obj);
			JSONObjectExtended objJsonObjectEach = new JSONObjectExtended(obj);
			JSONObjectExtended objJsonObjectFileEach = new JSONObjectExtended(obj);
			String strFileNameEach = "";
			String strFilePathJsonArray = "";
			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.get(strJsonArrayName);
			logger.add("TestConfigurationSetup:putAllObjects objJsonArrayList.size() " + objJsonArrayList.size());
			for (intJsonObjectEach = 0; intJsonObjectEach < objJsonArrayList.size(); intJsonObjectEach++) {
				strFileNameEach = objJsonArrayList.get(intJsonObjectEach).toString();
				logger.add("TestConfigurationSetup:putAllObjects strFileNameEach " + strFileNameEach);
				strFilePathJsonArray = strPath + strFileNameEach;
				logger.add("TestConfigurationSetup:putAllObjects strFilePathJsonArray = " + strFilePathJsonArray);
				try {
					objJsonObjectFileEach.putAllReplace((Map<String, String>) objJsonParser.parse(new FileReader(strFilePathJsonArray)));
					logger.add("TestConfigurationSetup:putAllObjects objJsonObjectFileEach = " + objJsonObjectFileEach);
					objJsonObjectEach.putAllReplace((Map<String, String>) objJsonObjectFileEach.get(strJsonObjectName));
					logger.add("TestConfigurationSetup:putAllObjects objJsonObjectEach = " + objJsonObjectEach);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				objJsonObject.putAll(objJsonObjectEach);
			}
			logger.add("TestConfigurationSetup:putAllObjects objJsonObject = " + objJsonObject);
			return objJsonObject;
		}

		private void run(String strFileNameTestConfiguration) {
			// TODO complete TestConfigurationSetup method to create json objects for test
			logger.add("  ==start==>TestConfigurationSetup " + getDateTimestamp());
			long lngStartTime = System.currentTimeMillis();
			String strFilePathTestConfiguration = "";
			try {
				strFilePathTestConfiguration = objPaths.gstrPathTestConfiguration + strFileNameTestConfiguration;
				logger.add("TestConfigurationSetup: strPathTestConfiguration = " + strFilePathTestConfiguration);
				objJsonObjectTestConfigurationFile = new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathTestConfiguration)));
				logger.add("TestConfigurationSetup: objJsonObjectTestConfigurationFile = " + objJsonObjectTestConfigurationFile);
				// test_instances
				logger.add("TestConfigurationSetup: test_instances");
				if (this.putAllArrays("test_instances", "test_instances", objPaths.gstrPathTestInstances) == null) {
					variablesJSON.gobjJsonArrayTestInstances = null;
					intTestInstanceSize = 0;
				} else {
					variablesJSON.gobjJsonArrayTestInstances = this.putAllArrays("test_instances", "test_instances", objPaths.gstrPathTestInstances);
					intTestInstanceSize = variablesJSON.gobjJsonArrayTestInstances.size();
				}
				// test_elements
				logger.add("TestConfigurationSetup: test_elements");
				variablesJSON.objectElement = this.putAllObjects("test_elements", "elements", objPaths.gstrPathTestElements);
				// processing
				logger.add("TestConfigurationSetup: processing");
				variablesJSON.objectProcessing = this.putAllObjects("test_elements", "processing", objPaths.gstrPathTestElements);
				// test_modules
				logger.add("TestConfigurationSetup: test_modules");
				variablesJSON.gobjJsonArrayTestSteps = this.putAllArrays("test_modules", "steps", objPaths.gstrPathTestModules);
				logger.add("TestConfigurationSetup: gobjJsonArrayTestSteps.toString = " + variablesJSON.gobjJsonArrayTestSteps.toString());
				// TODO add error handling, report no test modules and fail
				// test_links
				variablesJSON.objectLinks.putAllReplace((Map<String, String>) objJsonParser.parse("{\"link\":[{}]}"));
				// test_data
				logger.add("TestConfigurationSetup: test_data");
				variablesJSON.objectTestData = this.putAllObjects("test_data", "test_data", objPaths.gstrPathTestData);
			} catch (Exception e) {
				logger.add("TestConfigurationSetup: Exception = " + e.toString());
			} finally {
				logger.add("TestConfigurationSetup: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ThreadSaveImage implements Runnable {
		private BufferedImage objScreenShot;
		private String strImageType;
		private String strPathFileName;

		private ThreadSaveImage(BufferedImage objScreenShot, String strImageType, String strPathFileName) {
			this.objScreenShot = objScreenShot;
			this.strImageType = strImageType;
			this.strPathFileName = strPathFileName;
		}

		@Override
		public void run() {
			try {
				ImageIO.write(objScreenShot, strImageType.toUpperCase(), new File(strPathFileName));
			} catch (Exception e) {
				logger.add("ThreadSaveImage:run Exception = " + e.toString());
			}
		}
	}

	private class VariablesCommon {
		private String gstrBrowserSelection;
		private String strExitTest;
		private String strExitTestIterations;
		private String strOriginalInputValue;
		private String strOriginalAttributes;
	}

	private class VariablesJSON {
		private JSONObject obj = new JSONObject();
		private JSONArray gobjJsonArrayTestInstances = null;
		private JSONArray gobjJsonArrayTestSteps = null;
		private JSONObjectExtended objectElement = new JSONObjectExtended(obj);
		private JSONObjectExtended objectLinks = new JSONObjectExtended(obj);
		private JSONObjectExtended objectProcessing = new JSONObjectExtended(obj);
		private JSONObjectExtended objectStep = new JSONObjectExtended(obj);
		private JSONObjectExtended objectTestData = new JSONObjectExtended(obj);
		private JSONObjectExtended objectTestInstancesEach = new JSONObjectExtended(obj);
	}

	private class VariablesSelenium {
		private WebDriver gobjWebDriver = null;
		private WebDriver gobjWebDriverCoordinates = null;
		private WebElement gobjWebElement = null;
		private WebElement gobjWebElementDrag = null;
		private WebElement gobjWebElementDrop = null;
		private WebElement gobjWebElementPleaseWait = null;
	}

	private class VariablesSetSync {
		private Boolean gblnSyncAlert = false;
		private Boolean gblnSyncAngularJs = false;
		private Boolean gblnSyncDoPostBack = false;
		private Boolean gblnSyncJQueryAjax = false;
		private Boolean gblnSyncJQueryAnimation = false;
		private Boolean gblnSyncPleaseWait = false;
		private Boolean gblnSyncWaitForReadyState = false;
	}

	private class VerifyMatch {
		private String run(String strActual, String strExpected) throws ExceptionValueNotMatched {
			logger.add("  ==start==>VerifyMatch " + getDateTimestamp());
			logger.add("VerifyMatch strActual = " + strActual);
			Boolean blnMatched = false;
			long lngStartTime = System.currentTimeMillis();
			try {
				if (strExpected.toLowerCase().startsWith("<re>")) {
					String strPattern = strExpected.substring(4);
					blnMatched = true;
					return new RegularExpressionMatch().run(strPattern, strActual);
				} else {
					if (strExpected.equals(strActual)) {
						blnMatched = true;
						return strActual;
					} else {
						throw new ExceptionValueNotMatched("VerifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
					}
				}
			} catch (Exception e) {
				logger.add("VerifyMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("VerifyMatch: Exception " + e.toString());
			} finally {
				logger.add("VerifyMatch: finally Matched = {" + blnMatched + "} strActual = {" + strActual + "} strExpected = {" + strExpected + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class VerifyNotMatch {
		private String run(String strActual, String strExpected) throws ExceptionValueMatched {
			logger.add("  ==start==>VerifyNotMatch " + getDateTimestamp());
			Boolean blnMatched = false;
			long lngStartTime = System.currentTimeMillis();
			String strMatchedValue = "";
			try {
				if (strExpected.toLowerCase().startsWith("<re>")) {
					String strPattern = strExpected.substring(4);
					try {
						strMatchedValue = new RegularExpressionMatch().run(strPattern, strActual);
					} catch (Exception e) {
						logger.add("VerifyNotMatch: Exception " + e.toString());
						return strMatchedValue;
					}
					blnMatched = true;
					logger.add("VerifyNotMatch: before throw blnMatched = " + blnMatched);
					throw new ExceptionValueMatched("VerifyNotMatch: Exception strMatchedValue = {" + strMatchedValue + "}");
				} else {
					if (strExpected.equals(strActual)) {
						strMatchedValue = strActual;
						blnMatched = true;
						throw new ExceptionValueMatched("VerifyNotMatch did not match strExpected = {" + strExpected + "} strActual = {" + strActual + "}");
					} else {
						return strMatchedValue;
					}
				}
			} finally {
				logger.add("VerifyNotMatch: finally Matched = {" + blnMatched + "} strExpected = {" + strExpected + "} strActual = {" + strActual + "} strMatchedValue = {" + strMatchedValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class WaitForAngularRequestsToFinish {
		private WaitForAngularRequestsToFinish(JavascriptExecutor objDriver) {
			logger.add("  ==start==>WaitForAngularRequestsToFinish " + getDateTimestamp());
			objDriver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
		}
	}

	private class WaitForReadyState {
		private boolean run() {
			logger.add("  ==start==>WaitForReadyState " + getDateTimestamp());
			logger.add("waitForReadyState: document.readyState Milliseconds Waited = " + ((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("return document.readyState"));
			return false;
		}
	}

	private class WebDriverTest {
		private WebDriverTest() {
			new ProcessKillInternetExplorer().run();
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			DesiredCapabilities objDesiredCapabilities = null;
			// logger.add("BrowserLaunch: DesiredCapabilities");
			objDesiredCapabilities = DesiredCapabilities.internetExplorer();
			// logger.add("BrowserLaunch: objDesiredCapabilities.toString()" + objDesiredCapabilities);
			// logger.add("BrowserLaunch: setJavascriptEnabled");
			objDesiredCapabilities.setJavascriptEnabled(true);
			// logger.add("BrowserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
			objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
			// logger.add("BrowserLaunch: IE_ENSURE_CLEAN_SESSION");
			objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			// logger.add("BrowserLaunch: REQUIRE_WINDOW_FOCUS");
			objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			// logger.add("BrowserLaunch: INITIAL_BROWSER_URL");
			objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			// logger.add("BrowserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			// logger.add("BrowserLaunch: new InternetExplorerDriver(desiredCapabilities)");
			WebDriver objWebDriver = new InternetExplorerDriver(objDesiredCapabilities);
			//objWebDriver = new InternetExplorerDriver();
			//DesiredCapabilities desiredCapabilities = null;
			//desiredCapabilities = DesiredCapabilities.internetExplorer();
			//desiredCapabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			//desiredCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-noframemerging");
			//objWebDriver = new InternetExplorerDriver(desiredCapabilities);
			//objWebDriver.get("https://www.google.com/");
			String strLocalWebsiteFilePath = "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/tooltip.html";
			objWebDriver.get(strLocalWebsiteFilePath);
			//Capabilities getCapabilities();
			//		driver = new FirefoxDriver();
			//		driver = new HtmlUnitDriver(true);
			//	assertTrue(true);
			//driver.close();
			//driver.quit();
			new SleepMilliseconds(2000);
			WebElement objWebElement = objWebDriver.findElement(By.id("tooltipID"));
			Actions ToolTip1 = new Actions(objWebDriver);
			ToolTip1.moveToElement(objWebElement).build().perform();
			//ToolTip1.clickAndHold(objWebElement).build().perform();
			new SleepMilliseconds(1000);
			System.out.println(objWebElement.getLocation().getX());
			System.out.println(objWebElement.getLocation().getY());
			System.out.println(objWebElement.getSize().width);
			System.out.println(objWebElement.getSize().height);
			Dimension objWebDriverDimension = objWebElement.getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			//' Grab tooltip
			//ToolTip = Window("nativeclass:=tooltips_class32").GetROProperty("text")
			//String strToolTip = objAutoItSetObject.objAutoIt.controlGetText("tooltips_class32", "", "");
			System.out.println(-((intBrowserOuterWidth / 2) + 1));
			System.out.println(-((intBrowserOuterHeight / 2) + 1));
			ToolTip1.moveByOffset(-((intBrowserOuterWidth / 2) + 1), -((intBrowserOuterHeight / 2) + 1)).build().perform();
			String ToolTipText = objWebElement.getAttribute("title");
			//Assert.assertEquals(ToolTipText, "Google");
			System.out.println("Tooltip value is: " + ToolTipText);
			//ToolTip1.release(objWebElement).perform();
			//ToolTip1.release().perform();
			//ToolTip1.moveByOffset(0, 0);
		}
	}

	private class WebElementAttributes {
		private WebElementAttributes() {
			logger.add("  ==start==>WebElementAttributes " + getDateTimestamp());
			logger.add("text:=  " + objVariablesSelenium.gobjWebElement.getTagName());
			logger.add("tag_type:=  " + objVariablesSelenium.gobjWebElement.getTagName() + "_" + objVariablesSelenium.gobjWebElement.getAttribute("type"));
			logger.add("TagName:=  " + objVariablesSelenium.gobjWebElement.getAttribute("TagName"));
			logger.add("type:=  " + objVariablesSelenium.gobjWebElement.getAttribute("type"));
			logger.add("id:=  " + objVariablesSelenium.gobjWebElement.getAttribute("id"));
			logger.add("name:=  " + objVariablesSelenium.gobjWebElement.getAttribute("name"));
			logger.add("text:=  " + objVariablesSelenium.gobjWebElement.getAttribute("text"));
			logger.add("innerText:=  " + objVariablesSelenium.gobjWebElement.getAttribute("innerText"));
			logger.add("outerText:=  " + objVariablesSelenium.gobjWebElement.getAttribute("outerText"));
			logger.add("innerHTML:=  " + objVariablesSelenium.gobjWebElement.getAttribute("innerHTML"));
			logger.add("outerHTML:=  " + objVariablesSelenium.gobjWebElement.getAttribute("outerHTML"));
			logger.add("uniqueID:=  " + objVariablesSelenium.gobjWebElement.getAttribute("uniqueID"));
			logger.add("class:=  " + objVariablesSelenium.gobjWebElement.getAttribute("class"));
			logger.add("type:=  " + objVariablesSelenium.gobjWebElement.getAttribute("type"));
			logger.add("TYPE:=  " + objVariablesSelenium.gobjWebElement.getAttribute("TYPE"));
			logger.add("href:=  " + objVariablesSelenium.gobjWebElement.getAttribute("href"));
			logger.add("NameProp:=  " + objVariablesSelenium.gobjWebElement.getAttribute("NameProp"));
			logger.add("isDisplayed:=  " + objVariablesSelenium.gobjWebElement.isDisplayed());
			logger.add("name:=  " + objVariablesSelenium.gobjWebElement.isEnabled());
			logger.add("getLocation().x:=  " + objVariablesSelenium.gobjWebElement.getLocation().x);
			logger.add("getLocation().y:=  " + objVariablesSelenium.gobjWebElement.getLocation().y);
			logger.add("getSize().height:=  " + objVariablesSelenium.gobjWebElement.getSize().height);
			logger.add("getLocation().y:=  " + objVariablesSelenium.gobjWebElement.getSize().width);
			logger.add("src:=  " + objVariablesSelenium.gobjWebElement.getAttribute("src"));
		}
	}

	private class WebElementCollectionAttributes {
		private WebElementCollectionAttributes(String strTagName) {
			logger.add("  ==start==>WebElementCollectionAttributes " + getDateTimestamp());
			int intCount = 0;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			List<WebElement> objWebElementCollection = objVariablesSelenium.gobjWebDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				intCount = intCount + 1;
				logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WebElementCollectionAttributes " + intCount);
				logger.add("text:=  " + row.getTagName());
				logger.add("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
				logger.add("TagName:=  " + row.getAttribute("TagName"));
				logger.add("type:=  " + row.getAttribute("type"));
				logger.add("id:=  " + row.getAttribute("id"));
				logger.add("name:=  " + row.getAttribute("name"));
				logger.add("text:=  " + row.getAttribute("text"));
				logger.add("innerText:=  " + row.getAttribute("innerText"));
				logger.add("outerText:=  " + row.getAttribute("outerText"));
				logger.add("innerHTML:=  " + row.getAttribute("innerHTML"));
				logger.add("outerHTML:=  " + row.getAttribute("outerHTML"));
				logger.add("uniqueID:=  " + row.getAttribute("uniqueID"));
				logger.add("class:=  " + row.getAttribute("class"));
				logger.add("type:=  " + row.getAttribute("type"));
				logger.add("TYPE:=  " + row.getAttribute("TYPE"));
				logger.add("href:=  " + row.getAttribute("href"));
				logger.add("NameProp:=  " + row.getAttribute("NameProp"));
				logger.add("isDisplayed:=  " + row.isDisplayed());
				logger.add("name:=  " + row.isEnabled());
				logger.add("getLocation().x:=  " + row.getLocation().x);
				logger.add("getLocation().y:=  " + row.getLocation().y);
				logger.add("getSize().height:=  " + row.getSize().height);
				logger.add("getLocation().y:=  " + row.getSize().width);
				logger.add("src:=  " + row.getAttribute("src"));
			}
		}
	}

	private class WebElementCollectionTable {
		private WebElementCollectionTable(String strTagName) {
			boolean blnSkip = false;
			logger.add("  ==start==>WebElementCollectionTable " + getDateTimestamp());
			// TODO webElementCollectionTable send output to html file
			int intCount = 0;
			//JSONObjectExtended objStepNew = null;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			logger.add("WebElementCollectionTable: strTagName = " + strTagName);
			logger.add("WebElementCollectionTable: lngStartTimeSwitchTo = " + objVariablesSelenium.gobjWebDriver.getTitle());
			objVariablesSelenium.gobjWebDriver.switchTo().defaultContent();
			for (String winHandle : objVariablesSelenium.gobjWebDriver.getWindowHandles()) {
				intCount = 0;
				//  logger.add("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				logger.add("WebElementCollectionTable: winHandle = " + winHandle);
				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// if (strCurrentWindowHandle.equals(winHandle)) {
				// } else {
				objVariablesSelenium.gobjWebDriver.switchTo().window(winHandle);
				logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				logger.add("WebElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// }
				logger.add("WebElementCollectionTable: objVariablesSelenium.gobjWebDriver.getTitle = " + objVariablesSelenium.gobjWebDriver.getTitle());
				// logger.add("webElementCollectionTable objVariablesSelenium.gobjWebDriver.getPageSource = " + objVariablesSelenium.gobjWebDriver.getPageSource());
				logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				List<WebElement> objWebElementCollection = objVariablesSelenium.gobjWebDriver.findElements(By.tagName(strTagName));
				Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
				while (objWebElementEach.hasNext()) {
					WebElement row = objWebElementEach.next();
					// try {
					// elementVisible(objStepNew, row);
					intCount = intCount + 1;
					if (row.isDisplayed() == true) {
						if (strTagName.equals("input") == true) {
							if (row.getAttribute("type").toLowerCase().equals("hidden") == true) {
								blnSkip = true;
							}
						}
						if (blnSkip == false) {
							logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
							logger.add("WebElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
							logger.add("WebElementCollectionTable: type:= '" + row.getAttribute("type") + "'");
							logger.add("WebElementCollectionTable: getText:= '" + row.getText() + "'");
							logger.add("WebElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
						}
					}
					//  logger.add("text:=  " + objWebElementEach.);
					//  logger.add("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
					//  logger.add("TagName:= '" + row.getAttribute("TagName") + "'");
					//  logger.add("Type:= '" + row.getAttribute("Type") + "'");
					//  logger.add("TYPE:= '" + row.getAttribute("TYPE") + "'");
					//  logger.add("id:= '" + row.getAttribute("id") + "'");
					//  logger.add("name:= '" + row.getAttribute("name") + "'");
					//  logger.add("text:= '" + row.getAttribute("text") + "'");
					//  logger.add("innerText:= '" + row.getAttribute("innerText") + "'");
					//  logger.add("outerText:= '" + row.getAttribute("outerText") + "'");
					//  logger.add("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
					//  logger.add("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
					//  logger.add("class:= '" + row.getAttribute("class") + "'");
					//  logger.add("href:= '" + row.getAttribute("href") + "'");
					//  logger.add("NameProp:= '" + row.getAttribute("NameProp") + "'");
					//  logger.add("isDisplayed:= '" + row.isDisplayed() + "'");
					//  logger.add("isEnabled:= '" + row.isEnabled() + "'");
					//  logger.add("getLocation().x:= '" + row.getLocation().x + "'");
					//  logger.add("getLocation().y:= '" + row.getLocation().y + "'");
					//  logger.add("getSize().height:= '" + row.getSize().height + "'");
					//  logger.add("getSize().width:= '" + row.getSize().width + "'");
					//  logger.add("src:= '" + row.getAttribute("src") + "'");
					// if (objCollectionJS.size() > 0) {
					//
					// JavascriptExecutor objJavascriptExecutor = null;
					// objJavascriptExecutor = (JavascriptExecutor) objVariablesSelenium.gobjWebDriver;
					// long lngStartTimeJS = System.currentTimeMillis();
					//  logger.add("JS value = " +
					// objJavascriptExecutor.executeScript("return arguments[0].value;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					//  logger.add("JS innerText = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					//  logger.add("JS innerHTML = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					//  logger.add("JS outerHTML = " +
					// objJavascriptExecutor.executeScript("return arguments[0].outerHTML;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					//
					// }
					// } catch (ExceptionElementNotVisible e) {
					// // e.printStackTrace();
					// }
				}
			}
		}
	}

	private class WindowFocus {
		private WindowFocus() {
			logger.add("  ==start==>WindowFocus " + getDateTimestamp());
			// TODO debug gobjWebDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
			if (objVariablesSelenium.gobjWebDriver instanceof JavascriptExecutor) {
				((JavascriptExecutor) objVariablesSelenium.gobjWebDriver).executeScript("window.focus();");
			}
		}
	}

	private class WindowsProcessKill {
		private WindowsProcessKill(String strProcessToKill) {
			logger.add("  ==start==>WindowsProcessKill " + getDateTimestamp());
			try {
				Runtime.getRuntime().exec(strProcessToKill);
				logger.add("WindowsProcessKill: process killed = " + strProcessToKill);
			} catch (Exception e) {
				logger.add("WindowsProcessKill: Exception = " + e.toString());
			}
		}
	}

	public static boolean isNum(String strNum) {
		boolean ret = true;
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException e) {
			ret = false;
		}
		return ret;
	}

	public static void main(String[] args) {
		//		new Dragonfly().new WebDriverTest();
		//		BufferedImage objBufferedImage = null;
		//		try {
		//			objBufferedImage = ImageIO.read(new File("C:/Users/perrj115/Documents/GitHub/dragonfly/Dragonfly/Websites/dragonfly.jpg"));
		//		} catch (IOException e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}
		//		Dragonfly objDragonfly = new Dragonfly();
		//		objDragonfly.logger.add(objDragonfly.new ImageEncodeToString().run(objBufferedImage, "jpg"));
		//		System.exit(0);
		JSONArray objJsonArrayTestSteps = null;
		JSONArray objJsonArrayTestStepsRun = new JSONArray();
		JSONParser objJsonParser = new JSONParser();
		Dragonfly objDragonfly = new Dragonfly();
		Boolean blnExit = false;
		objDragonfly.logger.add("  ==start==>main " + objDragonfly.getDateTimestamp());
		objDragonfly.objAutoItSetObject.createObject();
		objDragonfly.windowsMinimizeAll();
		String strNameTestConfiguration;
		try {
			objDragonfly.new DialogLaunch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//objDragonfly.logger.add("main while dialog open");
		//System.out.println("objDragonfly.objPaths.gstrTestArea = " + objDragonfly.objPaths.gstrTestArea);
		//System.out.println("objDragonfly.objPaths.gstrPathData = " + objDragonfly.objPaths.gstrPathData);
		//System.out.println("objDragonfly.objPaths.gstrPathTestConfiguration = " + objDragonfly.objPaths.gstrPathTestConfiguration);
		//System.out.println("objDragonfly.objPaths.gstrPathSystemUserDir = " + objDragonfly.objPaths.gstrPathSystemUserDir);
		strNameTestConfiguration = objDragonfly.objPaths.gstrNameTest;
		//System.out.println("strNameTestConfiguration = " + strNameTestConfiguration);
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
		objDragonfly.objTestConfigurationSetup.run(strNameTestConfiguration);
		int intTestInstanceSize = objDragonfly.objTestConfigurationSetup.intTestInstanceSize;
		if (intTestInstanceSize == 0) {
			intTestInstanceStart = -1;
		}
		String strTestStepsCombinedOriginal = objDragonfly.variablesJSON.gobjJsonArrayTestSteps.toString();
		for (intTestInstanceEach = intTestInstanceStart; intTestInstanceEach < intTestInstanceSize; intTestInstanceEach++) {
			try {
				objDragonfly.logger.add(">>>>>>main: objDragonfly.variablesJSON.objectStep " + objDragonfly.variablesJSON.objectStep);
				objJsonArrayTestStepsRun.clear();
				intStep = 0;
				intLoopCount = 0;
				intLoopEach = 0;
				intLoopStep = 0;
				strCurrentWindowHandle = "";
				strTestStatus = "pass";
				objDragonfly.objPaths.setPathResults(intTestInstanceSize, strNameTestConfiguration);
				objJsonArrayTestSteps = (JSONArray) objJsonParser.parse(strTestStepsCombinedOriginal);
				if (intTestInstanceSize > 0) {
					objDragonfly.variablesJSON.objectTestInstancesEach.putAllReplace((Map<String, String>) objDragonfly.variablesJSON.gobjJsonArrayTestInstances.get(intTestInstanceEach));
				}
				strFileTestSteps = objDragonfly.objPaths.gstrPathTestSteps + strNameTestConfiguration.replace(".json", ".html");
				objDragonfly.writeJsonStepsToHtml("original", objJsonArrayTestSteps, objDragonfly.objPaths.gstrPathResults, "StepsOriginal.html");
				for (intStep = 0; intStep < objJsonArrayTestSteps.size(); intStep++) {
					objDragonfly.logger.add("main: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					objDragonfly.objVariablesSelenium.gobjWebElement = null;
					objDragonfly.variablesJSON.objectStep = objDragonfly.new JSONObjectExtended((JSONObject) objJsonArrayTestSteps.get(intStep));
					objDragonfly.new StepSetupDefaults(strCurrentWindowHandle);
					String strInputValue = objDragonfly.variablesJSON.objectStep.getString("strInputValue");
					objDragonfly.logStepDetails();
					if (objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().trim().length() > 0) {
						if (objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<loopstart>") == true) {
							if (intLoopEach == 0) {
								intLoopCount = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().substring(11));
								objDragonfly.variablesJSON.objectStep.putValue("strLoopOrIf", "");
								intLoopEach = 1;
								intLoopStep = intStep;
							}
						}
					}
					if (!objDragonfly.variablesJSON.objectStep.verifyEquals("strFunction", "")) {
						String strMethodName = objDragonfly.variablesJSON.objectStep.getString("strFunction");
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
						objDragonfly.variablesJSON.objectStep.putValue("strInputValue", strInputValue);
					}
					switch (objDragonfly.variablesJSON.objectStep.returnKeyword("strLoopOrIf")) {
					case "<else if>":
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
						objDragonfly.logger.add("main: strInputValue = " + strInputValue);
						if (strInputValue.trim().equalsIgnoreCase("<skip>")) {
							objDragonfly.variablesJSON.objectStep.put("strStepActual", "skip");
							objDragonfly.stepDuration("<skip>", System.currentTimeMillis(), "skip");
						} else {
							switch (objDragonfly.variablesJSON.objectStep.getLowerCase("strAction")) {
							case "kill_ie":
								objDragonfly.new ProcessKillInternetExplorer().run();
								break;
							case "launch":
								objDragonfly.new BrowserLaunchSync();
								break;
							case "close":
								objDragonfly.new BrowserCloseSync();
								break;
							case "get":
								objDragonfly.new ElementGetSync();
								break;
							case "set":
								objDragonfly.new ElementSetSync(false);
								break;
							case "set_js":
								objDragonfly.new ElementSetSync(true);
								break;
							case "verify":
								objDragonfly.new ElementVerifyValueSync();
								break;
							case "verify_not":
								objDragonfly.new ElementVerifyNotValueSync();
								break;
							case "sync_visible":
								objDragonfly.new ElementVisibleSync();
								break;
							case "sync_hidden":
								objDragonfly.new ElementHiddenSync();
								break;
							case "sync_enabled":
								objDragonfly.new ElementEnabledSync();
								break;
							case "sync_disabled":
								objDragonfly.new ElementDisabledSync();
								break;
							case "mouse_over":
								objDragonfly.new ElementOnMouseOverSync();
								break;
							case "mouse_out":
								objDragonfly.new ElementOnMouseOutSync();
								break;
							case "drag":
								objDragonfly.new ElementDragSync();
								break;
							case "drop":
								objDragonfly.new ElementDropSync();
								break;
							case "sleep":
								objDragonfly.new SleepSync();
								break;
							case "refresh":
								objDragonfly.new BrowserRefreshSync();
								break;
							case "scroll":
								objDragonfly.new ElementScrollSync();
								break;
							case "break":
								objDragonfly.logger.add("main: switch strAction = break was entered to at this step to stop execution");
								objDragonfly.stepDuration("break", System.currentTimeMillis(), "break");
								blnExit = true;
								break;
							case "tooltip_get":
								objDragonfly.new ElementTooltipGetSync();
								break;
							default:
								objDragonfly.logger.add("main: switch strAction = " + objDragonfly.variablesJSON.objectStep.getLowerCase("strAction") + "  not supported");
								objDragonfly.stepDuration("action", System.currentTimeMillis(), "action");
								blnExit = true;
								break;
							}
							strCurrentWindowHandle = objDragonfly.variablesJSON.objectStep.getString("strCurrentWindowHandle");
						}
						if (objDragonfly.variablesJSON.objectStep.getString("strOutputLinkName").trim().length() != 0) {
							objDragonfly.variablesJSON.objectLinks.putValue(objDragonfly.variablesJSON.objectStep.getString("strOutputLinkName"), objDragonfly.variablesJSON.objectStep.getString("strOutputValue"));
						}
						objJsonArrayTestStepsRun.add(objDragonfly.variablesJSON.objectStep);
						objDragonfly.logger.add("main: objJsonArrayTestStepsRun - " + objJsonArrayTestStepsRun);
						if (blnExit == true) {
							break;
						}
						if (objDragonfly.variablesJSON.objectStep.verifyEquals("strStatus", "fail")) {
							strTestStatus = "fail";
							if (objDragonfly.variablesJSON.objectStep.getBoolean("blnExitOnFail") == true) {
								objDragonfly.new WebElementCollectionTable(objDragonfly.variablesJSON.objectStep.getString("strTagName"));
								break;
							}
						}
					}
					switch (objDragonfly.variablesJSON.objectStep.returnKeyword("strLoopOrIf")) {
					case "<loopexit>":
						strLoopExitValue = objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().substring(10);
						if (objDragonfly.variablesJSON.objectStep.verifyEquals("strOutputValue", strLoopExitValue)) {
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
						if (objDragonfly.variablesJSON.objectStep.verifyEquals("strStatus", "pass")) {
							blnIf = true;
							blnIfSet = true;
						} else {
							blnIf = false;
						}
						break;
					case "<else if>":
						if (blnIfSet.equals(false)) {
							if (objDragonfly.variablesJSON.objectStep.verifyEquals("strStatus", "pass")) {
								blnIf = true;
								blnIfSet = true;
							} else {
								blnIf = false;
							}
						}
						break;
					case "<end if>":
						blnIf = true;
						blnIfSet = false;
						break;
					}
				}
			} catch (Exception e) {
				objDragonfly.logger.add("main: Exception " + e.toString());
			} finally {
				objDragonfly.writeFile(objDragonfly.objPaths.gstrPathResults + "StepsAfterRun.json", objJsonArrayTestStepsRun.toString());
				objDragonfly.writeFile(objDragonfly.objPaths.gstrPathResults + "StepsWithDefaults.json", objDragonfly.variablesJSON.gobjJsonArrayTestSteps.toString());
				objDragonfly.writeJsonStepsToHtml("original", objJsonArrayTestStepsRun, objDragonfly.objPaths.gstrPathResults, "StepsWithDefaults.html");
				objDragonfly.writeJsonStepsToHtml("complete", objJsonArrayTestStepsRun, objDragonfly.objPaths.gstrPathResults, "StepsAfterRun.html");
				objDragonfly.writeReportToHtml(objJsonArrayTestStepsRun, objDragonfly.objPaths.gstrPathResults + "Report.html", strFileTestSteps, strNameTestConfiguration.replace(".json", ""));
				objDragonfly.writeFile(objDragonfly.objPaths.gstrPathResults + "Dragonfly.log", objDragonfly.logger.getLog());
				objDragonfly.writeFile(objDragonfly.objPaths.gstrPathResults + "StepsManual.txt", objDragonfly.objStepsManual.get());
				objDragonfly.objPaths.changeDirectoryNameStatus(strTestStatus);
				if (objDragonfly.objVariablesSelenium.gobjWebDriver.toString().contains("InternetExplorerDriver")) {
					objDragonfly.new WindowsProcessKill("taskkill /F /IM IEDriverServer.exe");
				}
			}
			objDragonfly.logger.deleteLog();
			objDragonfly.objStepsManual.delete();
		}
	}
	// System.exit(0);
	Logger logger = new Logger("  ==start==>Dragonfly ");
	PathCreation objPaths = new PathCreation();
	AutoItSetObject objAutoItSetObject = new AutoItSetObject();
	VariablesSelenium objVariablesSelenium = new VariablesSelenium();
	OperatingSystem objOperatingSystem = new OperatingSystem();
	TestConfigurationSetup objTestConfigurationSetup = new TestConfigurationSetup();
	VariablesJSON variablesJSON = new VariablesJSON();
	VariablesSetSync objVariablesSetSync = new VariablesSetSync();
	StepsManual objStepsManual = new StepsManual();
	VariablesCommon objVariablesCommon = new VariablesCommon();

	public String data_DateDaysOut(String strDaysOut) {
		logger.add("  ==start==>data_DateDaysOut " + getDateTimestamp());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat objFormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (objFormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_EnvironmentURL(String strApplication_Environment) {
		JSONParser objJsonParser = new JSONParser();
		logger.add("  ==start==>data_EnvironmentURL " + getDateTimestamp());
		String strURL = "";
		logger.add("data_EnvironmentURL: objPaths.gstrPathTestData = " + objPaths.gstrPathTestData);
		String strFilePathTestData = objPaths.gstrPathTestData + "Environment.json";
		logger.add("data_EnvironmentURL: strFilePathTestData = " + strFilePathTestData);
		try {
			JSONObjectExtended objJsonObjectFile = new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathTestData)));
			logger.add("data_EnvironmentURL: strApplication_Environment = " + strApplication_Environment);
			strURL = objJsonObjectFile.getString(strApplication_Environment);
			logger.add("data_EnvironmentURL: strURL = " + strURL);
		} catch (Exception e) {
			logger.add("data_EnvironmentURL: Exception = " + e.toString());
		}
		return strURL;
	}

	public String data_localWebsiteFilePath(String strWebsite) {
		logger.add("  ==start==>data_localWebsiteFilePath " + getDateTimestamp());
		String strLocalWebsiteFilePath = "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		logger.add("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public String data_RandomFourNumbers(String strDaysOut) {
		logger.add("  ==start==>data_RandomFourNumbers " + getDateTimestamp());
		return Integer.toString(randomNumberRange(1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(String strDataInput) {
		logger.add("  ==start==>data_RandomRangeFiveNumbers " + getDateTimestamp());
		return Integer.toString(randomNumberRange(1, 99999));
	}

	private String createObjectName() {
		String strAttributeValue = "";
		String strAttributeValues = variablesJSON.objectStep.getString("strAttributeValues");
		String strObjectsAttributes = "";
		String strObjectName = "";
		String strObjectNames = variablesJSON.objectStep.getString("strAttributeNames");
		String[] arrAttributeValues = strAttributeValues.split("\\|");
		String[] arrObjectNames = strObjectNames.split("\\|");
		for (int intEach = 0; intEach < arrObjectNames.length; intEach++) {
			strObjectName = arrObjectNames[intEach].toString();
			strAttributeValue = arrAttributeValues[intEach].toString();
			if (intEach == 0) {
				strObjectsAttributes = strObjectName + "=" + strAttributeValue;
				logger.add("createObjectName strObjectAttribute =" + strObjectsAttributes);
			} else {
				strObjectsAttributes = strObjectsAttributes + "|" + strObjectName + "=" + strAttributeValue;
				logger.add("createObjectName strObjectAttribute =" + strObjectsAttributes);
			}
		}
		return strObjectsAttributes;
	}

	private String formatDateTime(Long lngStartTimeMillis) {
		logger.add("  ==start==>DateTimeFormat " + getDateTimestamp());
		return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS").format(new Date(lngStartTimeMillis));
	}

	private String getDateTimestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
	}

	private String getKeyword(String strValue) {
		String strValueToFindKeyword = strValue.toLowerCase();
		int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
		String strKeyword = "";
		if (intRightArrowPosition > -1) {
			strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
		}
		logger.add("KeywordReturn: strKeyword = " + strKeyword);
		return strKeyword;
	}

	private int getKeywordIntValue(String strValue) {
		String strValueToFindInt = "";
		int intRightArrowPosition = strValue.indexOf(">");
		int intKeywordValue = 0;
		if (intRightArrowPosition > -1) {
			strValueToFindInt = strValue.substring(intRightArrowPosition + 1);
			if (isNum(strValueToFindInt) == true) {
				intKeywordValue = Integer.parseInt(strValueToFindInt);
			}
		}
		logger.add("KeywordReturn: intKeywordValue " + intKeywordValue);
		return intKeywordValue;
	}

	private String getKeywordValue(String strValue) {
		int intRightArrowPosition = strValue.indexOf(">");
		String strKeywordValue = "";
		if (intRightArrowPosition > -1) {
			strKeywordValue = strValue.substring(intRightArrowPosition + 1);
		} else {
			strKeywordValue = strValue;
		}
		logger.add("KeywordReturn: strKeywordValue " + strKeywordValue);
		return strKeywordValue;
	}

	private void logStepDetails() {
		for (String strKey : new StepNames().getOriginal()) {
			logger.add("LogStepDetails: " + strKey + " = " + variablesJSON.objectStep.getString(strKey));
		}
	}

	private String optionsList(String strOptions) {
		long lngStartTime = System.currentTimeMillis();
		String strOptionsToFindList = strOptions;
		int intLeftArrowPosition = -1;
		int intRightArrowPosition = -1;
		String strOptionsList = "";
		int intOptionsCounts = 0;
		int intStart = 0;
		String strOptionsValue = "";
		strOptionsToFindList = strOptionsToFindList.replaceAll("\\s{2,}", " ");
		intOptionsCounts = (strOptionsToFindList.length() - strOptionsToFindList.replace("<option", "").length()) / 7;
		// logger.add("optionsList: intOptionsCounts = " + intOptionsCounts);
		for (int intOptionEach = 0; intOptionEach < intOptionsCounts; intOptionEach++) {
			// logger.add("optionsList: intStart = " + intStart);
			intLeftArrowPosition = strOptionsToFindList.indexOf("<option", intStart);
			// logger.add("optionsList: intLeftArrowPosition <option = " + intLeftArrowPosition);
			if (intLeftArrowPosition > -1) {
				intRightArrowPosition = strOptionsToFindList.indexOf(">", intLeftArrowPosition);
				// logger.add("optionsList: intRightArrowPosition = " + intRightArrowPosition);
				intLeftArrowPosition = strOptionsToFindList.indexOf("<", intRightArrowPosition);
				// logger.add("optionsList: intLeftArrowPosition < = " + intLeftArrowPosition);
				strOptionsValue = strOptionsToFindList.substring(intRightArrowPosition + 1, intLeftArrowPosition);
				// logger.add("optionsList: strOptionsValue = " + strOptionsValue);
				if (strOptionsList.length() == 0) {
					strOptionsList = strOptionsValue.trim();
				} else {
					strOptionsList = strOptionsList + "; " + strOptionsValue.trim();
				}
				intStart = intRightArrowPosition + 1;
				// logger.add("optionsList: inside if intStart = " + intStart);
			}
		}
		logger.add("OptionsList: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		return strOptionsList.substring(0, strOptionsList.length());
	}

	private int randomNumberRange(int intNumberMinimum, int intNumberMaximum) {
		return new Random().nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
	}

	private String removeTags(String strValue) {
		String strValueToFindKeyword = strValue;
		int intLeftArrowPosition = -1;
		int intRightArrowPosition = -1;
		String strTextToReplace = "";
		Boolean blnRemove = true;
		int intStart = 0;
		String[] arrKV_strInputValue = { "<re>", "<td>", "<ti>", "<tl>", "<click>", "<doubleclick>", "<rightclick>", "<on>", "<off>", "<blank>", "<first>", "<second>", "<third>", "<last>", "<random>", "<contains>", "<ends>", "<starts>", "<skip>" };
		int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace("<", "").length();
		// logger.add("removeTags: intKeywordCount = " + intKeywordCount);
		for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
			blnRemove = true;
			//logger.add("removeTags: intStart = " + intStart);
			intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intStart);
			if (intLeftArrowPosition > -1) {
				intRightArrowPosition = strValueToFindKeyword.indexOf(">");
				strTextToReplace = strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1);
				// logger.add("removeTags: strTextToReplace = " + strTextToReplace);
				for (String strKeywordsValidEach : arrKV_strInputValue) {
					if (strTextToReplace.equals(strKeywordsValidEach)) {
						blnRemove = false;
						intStart = intRightArrowPosition + 1;
						//logger.add("removeTags: inside if intStart = " + intStart);
						break;
					}
				}
				if (blnRemove.equals(true)) {
					strValueToFindKeyword = strValueToFindKeyword.replaceAll(strTextToReplace, "");
				}
				// logger.add("removeTags: strValueToFindKeyword = " + intKeywordEach + "  " + strValueToFindKeyword);
			}
		}
		// logger.add("removeTags: strValueToFindKeyword = " + strValueToFindKeyword);
		return strValueToFindKeyword;
	}

	private void stepCreateActual(String strStepType) {
		logger.add("  ==start==>stepCreateActual " + getDateTimestamp());
		String intWaited = variablesJSON.objectStep.getString("strStepDuration");
		String strActualHtml = "";
		String strActualText = "";
		String strInputValue = variablesJSON.objectStep.getString("strInputValue");
		String strOutputValue = variablesJSON.objectStep.getString("strOutputValue");
		String strTagName = variablesJSON.objectStep.getString("strTagName");
		String strObjectName = this.createObjectName();
		String strTagAttributesHtml = "The {<b>" + strTagName + "</b>} tag with attributes {<b>" + strObjectName + "</b>}";
		String strMsWaitedDetailHtml = " after {<b>" + intWaited + "</b>} milliseconds.";
		String strHtmlFailStart = "{<b><FONT COLOR='FF0000'>";
		String strHtmlPassStart = "{<b><FONT COLOR='008000'>";
		String strHtmlEnd = "</FONT></b>}";
		String strInputValueHtmlPass = " value " + strHtmlPassStart + strInputValue + strHtmlEnd;
		String strOutputValueHtmlPass = " value " + strHtmlPassStart + strOutputValue + strHtmlEnd;
		String strOutputValueHtmlFail = " " + strOutputValue + strHtmlFailStart + strHtmlEnd;
		logger.add("stepCreateActual strStepActual = " + variablesJSON.objectStep.getString("strStepActual"));
		if (variablesJSON.objectStep.verifyEquals("strStepActual", "")) {
			strStepType = variablesJSON.objectStep.getString("strAction");
		} else {
			strStepType = variablesJSON.objectStep.getString("strStepActual");
		}
		//String strFail2 =variablesJSON.objectStep.getString("strTagName");
		logger.add("stepCreateActual strStepType.toLowerCase() = " + strStepType.toLowerCase());
		switch (strStepType.toLowerCase()) {
		case "launch":
			strActualHtml = "The {<b>" + strTagName + "</b>} browser navigated to url" + strInputValueHtmlPass + strMsWaitedDetailHtml;
			break;
		case "close":
			strActualHtml = "The {<b>" + strTagName + "</b>} browser was closed" + strMsWaitedDetailHtml;
			break;
		case "default":
			strActualHtml = strTagAttributesHtml + " default" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
			break;
		case "clicked":
			strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was clicked" + strMsWaitedDetailHtml;
			break;
		case "expected":
			strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was not verified" + strMsWaitedDetailHtml + "<BR>The actual value was" + strOutputValueHtmlFail + ".";
			break;
		case "expectedtooltip":
			strActualHtml = strTagAttributesHtml + " tooltip" + strInputValueHtmlPass + " was not verified." + strMsWaitedDetailHtml + "<BR>The actual value was " + strOutputValueHtmlFail + ".";
			break;
		case "not_found":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlFail + " was not found" + strMsWaitedDetailHtml;
			break;
		case "verify":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was verified" + strMsWaitedDetailHtml;
			break;
		case "verify_not":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was not verified" + strMsWaitedDetailHtml;
			break;
		case "verifytooltip":
			strActualHtml = strTagAttributesHtml + " tooltip" + strOutputValueHtmlPass + " was verified" + strMsWaitedDetailHtml;
			break;
		case "get":
			strActualHtml = strTagAttributesHtml + " actual value is" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
			break;
		case "gettooltip":
			strActualHtml = strTagAttributesHtml + " tooltip actual value is" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
			break;
		case "set":
			strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was set" + strMsWaitedDetailHtml;
			break;
		case "persisted":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " persisted" + strMsWaitedDetailHtml;
			break;
		case "password":
			strActualHtml = strTagAttributesHtml + " password value" + strOutputValueHtmlPass + " was set" + strMsWaitedDetailHtml;
			break;
		case "not_persisted":
			strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " did not persist" + strMsWaitedDetailHtml + "<BR>The actual value" + strOutputValueHtmlFail + " was displayed.";
			break;
		case "notexisttooltip":
			strActualHtml = strTagAttributesHtml + " tooltip does not exist" + strMsWaitedDetailHtml;
			break;
		case "sync_disabled":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "disabled" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "sync_enabled":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "enabled" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "sync_hidden":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "hidden" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "sync_visible":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "visible" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "sync_closed":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " closed" + strMsWaitedDetailHtml;
			break;
		case "not_closed":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlFail + " did not close" + strMsWaitedDetailHtml;
			break;
		case "enabled":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "enabled" + "}" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "disabled":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "disabled" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "visible":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "visible" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "hidden":
			strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "hidden" + strHtmlEnd + strMsWaitedDetailHtml;
			break;
		case "syncoptional":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " sync is optional" + strMsWaitedDetailHtml;
			break;
		case "navigate":
			strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was set" + strMsWaitedDetailHtml + "<BR>No validation performed due to navigation.";
			break;
		case "keystroke":
			strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " key was pressed" + strMsWaitedDetailHtml;
			break;
		case "notinlist":
			strActualHtml = strTagAttributesHtml + "The list item " + strInputValueHtmlPass + " does not exist in the list field" + strMsWaitedDetailHtml + "<BR>Please confirm the input value against the actual list values " + strOutputValueHtmlFail + " is available for this field.";
			break;
		case "drag":
			strActualHtml = strTagAttributesHtml + " was dragged" + strMsWaitedDetailHtml;
			break;
		case "drop":
			strActualHtml = strTagAttributesHtml + " was dropped" + strMsWaitedDetailHtml;
			break;
		case "break":
			strActualHtml = "Take a break.";
			break;
		case "skip":
			strActualHtml = "Skip it.";
			break;
		case "scroll":
			strActualHtml = strTagAttributesHtml + strMsWaitedDetailHtml;
			break;
		case "sleep":
			strActualHtml = "Sleep paused execution" + strMsWaitedDetailHtml;
			break;
		case "mouse_over":
			strActualHtml = "Mouse over" + strInputValueHtmlPass + " is complete" + strMsWaitedDetailHtml;
			break;
		case "mouse_out":
			strActualHtml = "Mouse out" + strInputValueHtmlPass + " is complete" + strMsWaitedDetailHtml;
			break;
		default:
		}
		strActualHtml = "<DIV align='left'><font size='5'>" + strActualHtml + "</font></DIV>";
		strActualText = removeTags(strActualHtml);
		logger.add("StepCreateActual: strActualText = " + strActualText);
		variablesJSON.objectStep.putValue("strStepActual", strActualHtml);
	}

	private void stepCreateExpected() {
		logger.add("  ==start==>StepCreateExpected " + getDateTimestamp());
		String strStepExpected = "";
		String strAction = "";
		//String strInputValue = variablesJSON.objectStep.getString("strInputValue");
		String strInputValue = objVariablesCommon.strOriginalInputValue;
		String strMillisecondsToWait = variablesJSON.objectStep.getString("intMillisecondsToWait");
		//String strObjectName = this.createObjectName();
		String strObjectName = objVariablesCommon.strOriginalAttributes;
		logger.add("StepCreateExpected strObjectName = " + strObjectName);
		String strTagName = variablesJSON.objectStep.getString("strTagName");
		String strAssert = variablesJSON.objectStep.getString("strAssert");
		String strMillisecondsToWaitHtml = " within {<b>" + strMillisecondsToWait + "</b>} milliseconds.";
		String strTagAttributesHtml = " {<b>" + strTagName + "</b>} tag with attributes {<b>" + strObjectName + "</b>}";
		String strInputValueHtml = " {<b>" + strInputValue + "</b>}";
		String strAssertHtml = " assert {<b>" + strAssert + "</b>}";
		if (variablesJSON.objectStep.get("strStepExpected").toString().length() != 0) {
			strAction = variablesJSON.objectStep.getString("strStepExpected");
		} else {
			strAction = variablesJSON.objectStep.getString("strAction");
		}
		switch (strAction.toLowerCase()) {
		case "launch":
			strStepExpected = "Launch {<b>" + strTagName + "</b>} browser to url" + strInputValueHtml + " then expect navigation" + strMillisecondsToWaitHtml;
			break;
		case "close":
			strStepExpected = "Close {<b>" + strTagName + "</b>} browser" + strMillisecondsToWaitHtml;
			break;
		case "get":
			strStepExpected = "Get" + strTagAttributesHtml + " value" + strMillisecondsToWaitHtml;
			break;
		case "set":
			strStepExpected = "Set" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
			break;
		case "select":
			strStepExpected = "Select" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
			break;
		case "click":
			strStepExpected = "Click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
			break;
		case "double_click":
			strStepExpected = "Double click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
			break;
		case "right_click":
			strStepExpected = "Right click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
			break;
		case "verify":
			strStepExpected = "Verify" + strTagAttributesHtml + " value is equal to" + strInputValueHtml + strMillisecondsToWaitHtml;
			break;
		case "verify_not":
			strStepExpected = "Verify" + strTagAttributesHtml + " value is not equal to" + strInputValueHtml + strMillisecondsToWaitHtml;
			break;
		case "mouse_over":
			strStepExpected = "Mouse over" + strTagAttributesHtml + strMillisecondsToWaitHtml;
			break;
		case "mouse_out":
			strStepExpected = "Mouse out" + strTagAttributesHtml + strMillisecondsToWaitHtml;
			break;
		case "sync_visible":
			strStepExpected = "Sync until" + strTagAttributesHtml + " is visible" + strMillisecondsToWaitHtml;
			break;
		case "sync_hidden":
			strStepExpected = "Sync until" + strTagAttributesHtml + " is hidden" + strMillisecondsToWaitHtml;
			break;
		case "sync_enabled":
			strStepExpected = "Sync until" + strTagAttributesHtml + " is enabled" + strMillisecondsToWaitHtml;
			break;
		case "sync_disabled":
			strStepExpected = "Sync until" + strTagAttributesHtml + " is disabled" + strMillisecondsToWaitHtml;
			break;
		case "scroll":
			strStepExpected = "Scroll the" + strTagAttributesHtml + " into view" + strMillisecondsToWaitHtml;
			break;
		case "break":
			strStepExpected = "Break the execution.";
			break;
		case "drag":
			strStepExpected = "Drag" + strTagAttributesHtml + strMillisecondsToWaitHtml;
			break;
		case "drop":
			strStepExpected = "Drop" + strTagAttributesHtml + strMillisecondsToWaitHtml;
			break;
		case "kill_ie":
			strStepExpected = "The action kill_ie killed all IE processes.";
			break;
		case "refresh":
			strStepExpected = "Refresh the browser.";
			break;
		case "set_js":
			strStepExpected = "Set" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
			break;
		case "sleep":
			strStepExpected = "Sleep execution for" + strInputValueHtml + " milliseconds.";
			break;
		default:
			strStepExpected = strAction;
			break;
		}
		strStepExpected = "<DIV align='left'><font size='5'>" + strStepExpected + "</font></DIV>";
		objStepsManual.set(removeTags(strStepExpected));
		variablesJSON.objectStep.putValue("strStepExpected", strStepExpected);
	}

	private void stepDuration(String strMethodName, Long lngTimeStart, String strStepType) {
		logger.add("  ==start==>StepDuration " + getDateTimestamp());
		stepCreateExpected();
		Long lngTimeEnd = System.currentTimeMillis();
		variablesJSON.objectStep.putValue("strStartTimestamp", formatDateTime(lngTimeStart));
		variablesJSON.objectStep.putValue("strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
		variablesJSON.objectStep.putValue("strEndTimestamp", formatDateTime(lngTimeEnd));
		stepCreateActual(strStepType);
		logger.add("StepDuration: " + strMethodName + " strStatus = " + variablesJSON.objectStep.getString("strStatus") + " Milliseconds Waited = " + variablesJSON.objectStep.getString("strStepDuration"));
	}

	private Boolean syncFinally(Boolean blnExit, Boolean blnStatus, Boolean blnFound, String strMethodeName, String strAction, Long lngTimeStart) {
		logger.add("SyncFinally:  blnExit = {" + blnExit + "} blnStatus = {" + blnStatus + "} blnFound = {" + blnFound + "} strMethodeName = {" + strMethodeName + "} strAction = {" + strAction + "}");
		if (blnExit == true) {
			variablesJSON.objectStep.putValue("strStatus", "fail");
			variablesJSON.objectStep.putValue("blnExitOnFail", "true");
		} else {
			if (blnStatus == true) {
				variablesJSON.objectStep.putValue("strStatus", "pass");
				blnExit = true;
			} else if (blnStatus == false) {
				if ((int) (System.currentTimeMillis() - lngTimeStart) <= variablesJSON.objectStep.getInt("intMillisecondsToWait")) {
					if (blnFound == false) {
						blnExit = false;
					}
				} else {
					if (variablesJSON.objectStep.getBoolean("blnOptional") == true) {
						variablesJSON.objectStep.putValue("strStatus", "warning");
						blnExit = true;
					} else {
						variablesJSON.objectStep.putValue("strStatus", "fail");
						blnExit = true;
					}
				}
			}
		}
		if (blnExit == true) {
			stepDuration(strMethodeName, lngTimeStart, strAction);
		}
		return blnExit;
	}

	private void windowsMinimizeAll() {
		logger.add("  ==start==>WindowsMinimizeAll " + getDateTimestamp());
		Robot objRobot = null;
		switch (objOperatingSystem.strOS) {
		case "Windows":
			try {
				objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_WINDOWS);
				objRobot.keyPress(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_WINDOWS);
				logger.add("windowsMinimizeAll: Windows operating system minimize all windows.");
			} catch (Exception e) {
				logger.add("windowsMinimizeAll: Exception = " + e.toString());
			}
			break;
		default:
			logger.add("WindowsMinimizeAll: the operating system not supported at this time " + objOperatingSystem.strOS);
		}
	}

	private void writeFile(String strFilePathFile, String strTextToWrite) {
		logger.add("  ==start==>writeFile " + getDateTimestamp());
		logger.add("writeFile: strFilePathFile = " + strFilePathFile);
		try {
			BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(strFilePathFile));
			objBufferedWriter.write(strTextToWrite);
			objBufferedWriter.close();
		} catch (Exception e) {
			logger.add("writeFile: Exception" + e.toString());
		}
	}

	private void writeJsonStepsToHtml(String strStepHeader, JSONArray objTestSteps, String strPath, String strFileName) {
		logger.add("  ==start==>WriteJsonStepsToHtml " + getDateTimestamp());
		logger.add("WriteJsonStepsToHtml objTestSteps = " + objTestSteps);
		String strKey = "";
		String[] arrKeys = null;
		StepNames objStepNames = new StepNames();
		StringBuilder objStringBuilder = new StringBuilder();
		String strValue = "";
		switch (strStepHeader) {
		case "original":
			arrKeys = objStepNames.getOriginal();
			break;
		case "complete":
			arrKeys = objStepNames.getComplete();
			break;
		}
		try {
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<head><title> " + strFileName.replace(".html", "") + "</title></head>");
			objStringBuilder.append("<body><h1>");
			objStringBuilder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
			objStringBuilder.append("<tr>");
			objStringBuilder.append("<td>Step</td>");
			for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
				strKey = arrKeys[intKeysEach].toString();
				objStringBuilder.append("<th>" + strKey + "</th>");
			}
			objStringBuilder.append(" </tr>  ");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				objStringBuilder.append("</tr>");
				objStringBuilder.append("<td> " + (intTestStepRow) + "</td>");
				JSONObjectExtended objStepReport = new JSONObjectExtended((JSONObject) objTestSteps.get(intTestStepRow));
				for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
					strKey = arrKeys[intKeysEach].toString();
					if (objStepReport.containsKey(strKey) == true) {
						strValue = objStepReport.get(strKey).toString().replaceAll("<", "&lt;");
						strValue.replaceAll(">", "&gt;");
						objStringBuilder.append("<td> " + strValue + "</td>");
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
			writeFile(strPath + strFileName, html);
		} catch (Exception e) {
			logger.add("WriteJsonStepsToHtml: Exception = " + e.toString());
			logger.add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			logger.add("WriteJsonStepsToHtml: Exception = " + e.toString());
			logger.add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
		}
	}

	private void writeReportToHtml(JSONArray objJsonArrayReportSteps, String strFile, String strTestStepsFile, String strTestName) {
		long lngStartTime = System.currentTimeMillis();
		logger.add("  ==start==>WriteReportToHtml " + getDateTimestamp());
		logger.add("WriteReportToHtml: strFile = " + strFile);
		JSONObjectExtended objJsonObjectReportStep = null;
		String strScreenshotFilePath = "";
		String strStatus = "";
		String strStatusIcon = "";
		StringBuilder objStringBuilder = new StringBuilder();
		int intTestStepRow = 0;
		logger.add("WriteReportToHtml: objJsonArrayReportSteps = " + objJsonArrayReportSteps);
		try {
			//				function popUp() {
			//					var newWindow = window.open("", "Test", "width=300,height=300,scrollbars=1,resizable=1")
			//					var text = "cat"
			//					var html = "<html><head></head><body>Hello, <b>" + text + "</b>."
			//					html += "How are you today?</body></html>"
			//					newWindow.document.open()
			//					newWindow.document.write(html)
			//					newWindow.document.close()
			//				}
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<script language=\"javascript\" type=\"text/javascript\">");
			objStringBuilder.append("var varImageCount = -1;");
			objStringBuilder.append("var varStep = -1;");
			objStringBuilder.append("var intTimeoutInterval;");
			objStringBuilder.append("function slideShow() {");
			objStringBuilder.append("if (!document.images) {");
			objStringBuilder.append("return;");
			objStringBuilder.append("}");
			objStringBuilder.append("varStep++;");
			objStringBuilder.append("if (varStep <= varImageCount) {");
			objStringBuilder.append("if (document.getElementById(\"img_\" + varStep)) {");
			objStringBuilder.append("document.getElementById('imgSlideshow').src = document.getElementById(\"img_\" + varStep).src;");
			objStringBuilder.append("intTimeoutInterval = 1500;");
			objStringBuilder.append("} else {");
			objStringBuilder.append("intTimeoutInterval = 0;");
			objStringBuilder.append("}");
			objStringBuilder.append("} else {");
			objStringBuilder.append("varStep = -1;");
			objStringBuilder.append("}");
			objStringBuilder.append("setTimeout(\"slideShow()\", intTimeoutInterval);");
			objStringBuilder.append("}");
			objStringBuilder.append("function onLoadSlideshow() {");
			objStringBuilder.append("document.getElementById(\"imgSlideshow\").src = document.getElementById('img_0').src;");
			objStringBuilder.append("scrollToTop();");
			objStringBuilder.append("slideShow();");
			objStringBuilder.append("}");
			objStringBuilder.append("function scrollToStep() {");
			objStringBuilder.append("document.getElementById(\"step_\" + varStep).scrollIntoView(true);");
			objStringBuilder.append("}");
			objStringBuilder.append("function scrollToTop() {");
			objStringBuilder.append("document.getElementById('body').scrollIntoView();");
			objStringBuilder.append("}");
			objStringBuilder.append("</script>");
			objStringBuilder.append("<head><title>" + strTestName + "</title></head>");
			objStringBuilder.append("<body id=\"body\" onload=\"onLoadSlideshow()\">");
			objStringBuilder.append("<img id=\"imgSlideshow\" onclick=\"scrollToStep()\" src=\"\" alt=\"\"></img>");
			objStringBuilder.append("<br>");
			objStringBuilder.append("<br>");
			for (intTestStepRow = 0; intTestStepRow < objJsonArrayReportSteps.size(); intTestStepRow++) {
				objJsonObjectReportStep = new JSONObjectExtended((JSONObject) objJsonArrayReportSteps.get(intTestStepRow));
				logger.add("WriteReportToHtml: objJsonObjectReportStep = " + objJsonObjectReportStep);
				objStringBuilder.append("<div id=step_" + intTestStepRow + ">");
				objStringBuilder.append("<TABLE border=1 width=100% height=10%>");
				objStringBuilder.append("<TR>");
				switch (objJsonObjectReportStep.getLowerCase("strStatus")) {
				case "pass":
					strStatus = "Pass";
					if (objJsonObjectReportStep.verifyEquals("strAction", "set") && objJsonObjectReportStep.verifyEquals("strAssert", "off")) {
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
				String strStartTimestamp = objJsonObjectReportStep.getString("strStartTimestamp");
				String strStepDuration = objJsonObjectReportStep.getString("strStepDuration");
				String strEndTimestamp = objJsonObjectReportStep.getString("strEndTimestamp");
				objStringBuilder.append("<TD onclick=\"scrollToTop()\" rowspan=\"2\" width=60px align=center valign=middle>Step " + intTestStepRow + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=35px align=center valign=middle>" + strStatusIcon + "<br>" + strStatus + "</TD>");
				objStringBuilder.append("<TD width= 75px align=center valign=middle>Expected</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objJsonObjectReportStep.getString("strStepExpected") + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=150px align=left valign=middle>Start:" + strStartTimestamp + "<br>End: " + strEndTimestamp + "<br>Duration: " + strStepDuration + " ms</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("<TR>");
				objStringBuilder.append("<TD align=center valign=middle>Actual</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objJsonObjectReportStep.getString("strStepActual") + "</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("</TABLE> ");
				if (objJsonObjectReportStep.get("strScreenshotFilePath").toString().trim().length() != 0) {
					strScreenshotFilePath = objJsonObjectReportStep.get("strScreenshotFilePath").toString().replaceAll("\\\\\\\\", "\\");
					try {
						BufferedImage objBufferedImage = ImageIO.read(new File(strScreenshotFilePath));
						objStringBuilder.append("<img id=img_" + intTestStepRow + " src=\"data:image/jpg;base64," + new ImageEncodeToString().run(objBufferedImage, "jpg") + "\" alt=\"Step " + intTestStepRow + "\" > ");
					} catch (Exception e) {
						logger.add("writeReportToHtml: Exception = " + e.toString());
					}
				}
				objStringBuilder.append("</div>");
				objStringBuilder.append("<br>");
				objStringBuilder.append("<br>");
				//TODO this should be removed.  check what happens and add step details for the break.
				//					if (objJsonObjectReportStep.get("strAction").toString().toLowerCase().equals("break")) {
				//						break;
				//					}
			}
		} catch (Exception e) {
			logger.add("WriteReportToHtml: " + e.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			String strHTML = objStringBuilder.toString().replace("varImageCount = -1", "varImageCount = " + (intTestStepRow - 1));
			writeFile(strFile, strHTML);
			writeFile(strTestStepsFile, strHTML);
			logger.add("WriteReportToHtml: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
//	private static ExpectedCondition<Boolean> waitForAngularFinishProcessing() {
//		 logger.add("  ==start==>waitForAngularFinishProcessing " + getDateTimestamp());
//		return new ExpectedCondition<Boolean>() {
//			@Override
//			private Boolean apply(WebDriver driver) {
//				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
//			}
//		};
//	}
//Options for private class ClearMyTracksByProcessCookies
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