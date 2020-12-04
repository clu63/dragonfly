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
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
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
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.xml.parsers.DocumentBuilderFactory;
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
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import com.jacob.com.LibraryLoader;
import com.opera.core.systems.OperaDriver;
import autoitx4java.AutoItX;

public class Dragonfly {
	// System.exit(0);
	private AutoItSetObject objAutoItSetObject = new AutoItSetObject();
	//private JSONArray gobjJsonArrayTestInstances = null;
	//private JSONArray gobjJsonArrayTestSteps = null;
	private TestConfigurationSetup objTestConfigurationSetup = new TestConfigurationSetup();
	//private WebDriver BrowserDriver.getInstance().browserDriver = null;
	//private WebElement gobjWebElement = null;
	//private WebElement gobjWebElementDrag = null;
	//private WebElement gobjWebElementDrop = null;
	//private WebElement gobjWebElementPleaseWaitSync = null;
	//static JSON gobjectElement = new JSON();
	//static JSON gobjectLinks = new JSON();
	//private JSON gobjectProcessing = new JSON();
	//static JSON gobjectStep = new JSON();
	//static JSON gobjectTestData = new JSON();
	//static JSON gobjectTestInstancesEach = new JSON();

	private class AlertFind {
		private boolean run() {
			Logger.getInstance().add("  ==start==>AlertFind " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				String strAlertPresent = BrowserDriver.getInstance().browserDriver.switchTo().alert().getText();
				Logger.getInstance().add("AlertFind: alert found:  " + strAlertPresent);
				return true;
			} catch (UnhandledAlertException e) {
				Logger.getInstance().add("AlertFind: UnhandledAlertException = " + e.toString());
				return true;
			} catch (NoAlertPresentException e) {
				Logger.getInstance().add("AlertFind: NoAlertPresentException = " + e.toString());
				return false;
			} catch (Exception e) {
				Logger.getInstance().add("AlertFind: Exception = " + e.toString());
				return false;
			} finally {
				Logger.getInstance().add("AlertFind: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class AutoItSetObject {
		private AutoItX objAutoIt;

		private void createObject() {
			Logger.getInstance().add("  ==start==>AutoItSetObject " + new DateTimestamp().get());
			String strJacobDllVersionToUse;
			JvmBitVersion objJvmBitVersion = new JvmBitVersion();
			if (objJvmBitVersion.get().contains("32")) {
				strJacobDllVersionToUse = "jacob-1.18-x86.dll";
			} else {
				strJacobDllVersionToUse = "jacob-1.18-x64.dll";
			}
			Logger.getInstance().add("AutoItSetObject: System.getProperty(java.library.path) = " + System.getProperty("java.library.path") + " " + new DateTimestamp().get());
			Logger.getInstance().add("AutoItSetObject: strJacobDllVersionToUse = " + strJacobDllVersionToUse + " " + new DateTimestamp().get());
			File objFile = new File("Libraries", strJacobDllVersionToUse);
			Logger.getInstance().add("AutoItSetObject: LibraryLoader.JACOB_DLL_PATH = " + LibraryLoader.JACOB_DLL_PATH + " " + new DateTimestamp().get());
			Logger.getInstance().add("AutoItSetObject: objFile.getAbsolutePath() = " + objFile.getAbsolutePath() + " " + new DateTimestamp().get());
			System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
			objAutoIt = new AutoItX();
		}

		private AutoItX getObject() {
			return objAutoIt;
		}
	}

	private class BrowserClose {
		private BrowserClose() {
			BrowserDriver.getInstance().browserDriver.close();
			BrowserDriver.getInstance().browserDriver.quit();
			JSONS.getInstance().step.putValue("strStatus", "pass");
			new CoordinateHighlightScreenshot(JSONS.getInstance().step);
		}
	}

	private class BrowserCloseSync {
		private BrowserCloseSync() {
			// TODO create a browserCloseSync to manage reporting and sync close
			long lngStartTime = System.currentTimeMillis();
			JSONS.getInstance().step.putValue("strStepActual", "browser_close");
			stepDuration("BrowserCloseSync", lngStartTime, "browser_close");
		}
	}

	private class BrowserLaunch {
		private BrowserLaunch() throws ExceptionBrowserDriverNotSupported {
			// TODO combine duplicate code
			// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
			Logger.getInstance().add("  ==start==>BrowserLaunch " + new DateTimestamp().get());
			DesiredCapabilities objDesiredCapabilities = null;
			Long lngTimeStart = System.currentTimeMillis();
			Logger.getInstance().add("objVariablesCommon.gstrBrowserSelection = " + Config.getInstance().browserSelection);
			if (Config.getInstance().browserSelection != "value in test") {
				JSONS.getInstance().step.putValue("strTagName", Config.getInstance().browserSelection);
			} else {
				Config.getInstance().browserSelection = JSONS.getInstance().step.getString("strTagName");
			}
			try {
				JSONS.getInstance().step.putValue("strStatus", "pass");
				switch (JSONS.getInstance().step.getString("strTagName")) {
				case "firefox":
					BrowserDriver.getInstance().browserDriver = new FirefoxDriver();
					BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
					BrowserDriver.getInstance().browserDriver.manage().window().maximize();
					Actions myAction = new Actions(BrowserDriver.getInstance().browserDriver);
					myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
					break;
				case "ie_64":
					objDesiredCapabilities = DesiredCapabilities.internetExplorer();
					objDesiredCapabilities.setJavascriptEnabled(true);
					objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
					objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
					objDesiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
					//if (blnAttach == false) {
					System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_64.exe");
					BrowserDriver.getInstance().browserDriver = new InternetExplorerDriver(new InternetExplorerOptions().merge(objDesiredCapabilities));
					//}
					break;
				case "ie":
				case "internet explorer":
					//new SleepMilliseconds(1000);
					Logger.getInstance().add("BrowserLaunch: DesiredCapabilities");
					objDesiredCapabilities = DesiredCapabilities.internetExplorer();
					Logger.getInstance().add("BrowserLaunch: objDesiredCapabilities.toString()" + objDesiredCapabilities);
					Logger.getInstance().add("BrowserLaunch: setJavascriptEnabled");
					objDesiredCapabilities.setJavascriptEnabled(true);
					Logger.getInstance().add("BrowserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
					Logger.getInstance().add("BrowserLaunch: IE_ENSURE_CLEAN_SESSION");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					Logger.getInstance().add("BrowserLaunch: REQUIRE_WINDOW_FOCUS");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					Logger.getInstance().add("BrowserLaunch: INITIAL_BROWSER_URL");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
					Logger.getInstance().add("BrowserLaunch: webdriver.ie.driver" + Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
					System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
					System.setProperty("webdriver.ie.driver.loglevel", "DEBUG");
					//System.setProperty("webdriver.ie.driver.logfile", "C:\\temp\\IEDriverLog.log");
					System.setProperty("webdriver.ie.driver.logfile", Path.getInstance().results + "IEDriverLog.log");
					// System.setProperty("webdriver.ie.driver.host","5555");
					Logger.getInstance().add("BrowserLaunch: new InternetExplorerDriver(desiredCapabilities)");
					BrowserDriver.getInstance().browserDriver = new InternetExplorerDriver(objDesiredCapabilities);
					//					BrowserDriver.getInstance().browserDriver.manage().getCookieNamed("JSESSIONID");
					try {
						System.out.println("BrowserLaunch: getCookieNamed JSESSIONID " + BrowserDriver.getInstance().browserDriver.manage().getCookies().toString());
						//System.out.println("BrowserLaunch: getCookieNamed JSESSIONID " +BrowserDriver.getInstance().browserDriver.manage().getCookieNamed("JSESSIONID").toString());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Logger.getInstance().add("BrowserLaunch: Exception getCookieNamed " + e.toString());
					}
					// BrowserDriver.getInstance().browserDriver.manage().deleteCookieNamed("JSESSIONID");
					Logger.getInstance().add("BrowserLaunch: JSONS.getInstance().step.getString(strInputValue)  = " + JSONS.getInstance().step.getString("strInputValue"));
					BrowserDriver.getInstance().browserDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					//BrowserDriver.getInstance().browserDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
					BrowserDriver.getInstance().browserDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
					BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
					// Logger.getInstance().add("browserLaunch: getCookieNamed(JSESSIONID) = " + BrowserDriver.getInstance().browserDriver.manage().getCookieNamed("JSESSIONID").toString());
					Logger.getInstance().add("BrowserLaunch: BrowserDriver.getInstance().browserDriver.manage().window().maximize()");
					BrowserDriver.getInstance().browserDriver.manage().window().maximize();
					//Capabilities getCapabilities();
					break;
				//var myOptions = new InternetExplorerOptions()
				//                        {
				//                            BrowserAttachTimeout = TimeSpan.FromSeconds(60),
				//                            RequireWindowFocus = false,
				//                            IntroduceInstabilityByIgnoringProtectedModeSettings = true,
				//                            IgnoreZoomLevel = true,
				//                            EnsureCleanSession = true,
				//                            PageLoadStrategy = InternetExplorerPageLoadStrategy.Eager,
				//                            ValidateCookieDocumentType = true,
				//                            InitialBrowserUrl = "about:Tabs",
				//                            BrowserCommandLineArguments = "-noframemerging"
				//
				//                        };
				//                        myOptions.AddAdditionalCapability("INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", true);
				//                        myOptions.BrowserCommandLineArguments = "-private";
				//
				//                        originalWebdriver = new InternetExplorerDriver(@"C:\Download" + BrowserCtr + @"\IEDriverServer", myOptions);
				case "chrome":
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					options.addArguments("disable-popup-blocking");
					options.addArguments("disable-infobars");
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					//WebDriver driver = new ChromeDriver(capabilities);
					switch (OperatingSystem.get()) {
					case "Windows":
						System.setProperty("webdriver.chrome.driver", Path.getInstance().systemUserDir + "\\Drivers\\chromedriver.exe");
						break;
					case "Mac":
						System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
						break;
					default:
						// TODO need to raise an error and log
						break;
					}
					BrowserDriver.getInstance().browserDriver = new ChromeDriver(capabilities);
					BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
					BrowserDriver.getInstance().browserDriver.manage().window().maximize();
					break;
				case "safari":
					BrowserDriver.getInstance().browserDriver = new SafariDriver();
					BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
					BrowserDriver.getInstance().browserDriver.manage().window().maximize();
					break;
				case "opera":
					// TODO OperaDriver setup latest driver and test desiredCapabilities = DesiredCapabilities.internetExplorer();
					// 		System.setProperty("webdriver.opera.driver", "D:/Ripon/operadriver_win64/operadriver.exe");
					// 		WebDriver driver = new OperaDriver();
					// 		driver.get("https://duckduckgo.com/");
					// desiredCapabilities.setJavascriptEnabled(true);
					//BrowserDriver.getInstance().browserDriver = new OperaDriver();
					//setBrowserDriver.getInstance().browserDriver(new OperaDriver());
					BrowserDriver.getInstance().browserDriver = new OperaDriver();
					BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
					// BrowserDriver.getInstance().browserDriver.manage().window().maximize();
					// BrowserDriver.getInstance().browserDriver.manage().window().setPosition(new Point(0, 0));
					// Dimension dim = new Dimension(1382, 754);
					// BrowserDriver.getInstance().browserDriver.manage().window().setSize(dim);
					// Selenium selenium;
					// BrowserDriver.getInstance().browserDriver = new OperaDriver();
					// selenium = new WebDriverBackedSelenium(BrowserDriver.getInstance().browserDriver, "https://www.google.com/");
					// return BrowserDriver.getInstance().browserDriver;
					break;
				default:
					JSONS.getInstance().step.putValue("strStatus", "fail");
					throw new ExceptionBrowserDriverNotSupported("Browser '" + JSONS.getInstance().step.getString("strTagName") + "' not supported");
				}
			} catch (Exception e) {
				Logger.getInstance().add("BrowserLaunch: Exception" + e.toString());
			} finally {
				JSONS.getInstance().step.putValue("strCurrentWindowHandle", BrowserDriver.getInstance().browserDriver.getWindowHandle());
			}
		}
	}

	private class BrowserLaunchSync {
		private BrowserLaunchSync() {
			Logger.getInstance().add("  ==start==>BrowserLaunchSync " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				new BrowserLaunch();
			} catch (ExceptionBrowserDriverNotSupported e) {
				// TODO confirm the exceptions to catch in main some may need to be removed
				Logger.getInstance().add("BrowserLaunchSync: " + e.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO create a BrowserLaunchSync to manage reporting and sync
				new CoordinatesElement();
				new CoordinateHighlightScreenshot(JSONS.getInstance().step);
				JSONS.getInstance().step.putValue("strStepActual", "browser_launch");
				stepDuration("BrowserLaunchSync", lngStartTime, "browser_launch");
				Logger.getInstance().add("BrowserLaunchSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class BrowserRefresh {
		private BrowserRefresh() {
			Logger.getInstance().add("  ==start==>BrowserRefresh " + new DateTimestamp().get());
			BrowserDriver.getInstance().browserDriver.navigate().refresh();
		}
	}

	private class BrowserRefreshSync {
		private BrowserRefreshSync() {
			long lngStartTime = System.currentTimeMillis();
			new BrowserRefresh();
			JSONS.getInstance().step.putValue("strStepActual", "browser_refresh");
			stepDuration("BrowserRefreshSync", lngStartTime, "browser_refresh");
		}
	}

	private class ClearMyTracksByProcessCache {
		private ClearMyTracksByProcessCache() throws Exception {
			Logger.getInstance().add("  ==start==>ClearMyTracksByProcessCache " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	private class ClearMyTracksByProcessCookies {
		private ClearMyTracksByProcessCookies() throws Exception {
			Logger.getInstance().add("  ==start==>ClearMyTracksByProcessCookies " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	private class ClipboardGet {
		private String run() {
			Logger.getInstance().add("  ==start==>ClipboardGet " + new DateTimestamp().get());
			String strClipboardData = "";
			try {
				strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				Logger.getInstance().add("ClipboardGet: strClipboardData = " + strClipboardData);
			} catch (Exception e) {
				Logger.getInstance().add("ClipboardGet: Exception = " + e.toString());
			}
			return strClipboardData;
		}
	}

	private class CommandLineExecution {
		private CommandLineExecution() throws Exception {
			Logger.getInstance().add("  ==start==>CommandLineExecution " + new DateTimestamp().get());
			Process p = Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			p.waitFor();
			Process p5 = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 10");
			p5.waitFor();
			String strPathCookiesLow = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Cookies\\Low\\";
			strPathCookiesLow = strPathCookiesLow.replaceAll("\\\\", "/");
			Logger.getInstance().add("CommandLineExecution: strPathCookiesLow = " + strPathCookiesLow);
			FileUtils.deleteDirectory(new File(strPathCookiesLow));
			String strPathCacheLow = System.getenv("APPDATA") + "Local/Microsoft/Windows/Temporary Internet Files/Low/";
			strPathCacheLow = strPathCacheLow.replaceAll("\\\\", "/");
			Logger.getInstance().add("CommandLineExecution: strPathCacheLow = " + strPathCacheLow);
			FileUtils.deleteDirectory(new File(strPathCacheLow));
		}
	}

	private class ConvertPathByOperatingSystem {
		private void run(String strPath) {
			// Logger.getInstance().add("main: gstrOperatingSystem = " + gobjOperatingSystem.strOS);
			// 	switch (gstrOperatingSystem) {
			// 	case "Windows":
			// 		strPathResults = gobjPaths.getPathSystemUserDir() + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\" + gstrPathResults + "\\";
			// 		strPathImages = "images\\";
			// 		break;
			// 	case "Mac":
			// 		strPathResults = gobjPaths.getPathSystemUserDir() + "/Results/" + strTestConfigurationFileName.replace(".json", "") + "/" + gstrPathResults + "/";
			// 		strPathImages = "images/";
			// 		break;
			// 	default:
			// 		 Logger.getInstance().add("main: switch gstrOperatingSystem = " + gstrOperatingSystem + "  not supported");
			// 		return;
			// 	}
		}
	}

	private class CoordinateHighlightScreenshot {
		private CoordinateHighlightScreenshot(final JSON objJsonObjectStepHighlightArea) {
			Logger.getInstance().add("  ==start==>CoordinateHighlightScreenshot " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			JDialog objJDialog = new JDialog() {
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
						Logger.getInstance().add("CoordinateHighlightScreenshot: strHighlightArea = " + JSONS.getInstance().step.getString("strHighlightArea"));
						new RectangleAreaByName(intThickness, JSONS.getInstance().step.getString("strHighlightArea"), objHighlightArea);
						setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
						setUndecorated(true);
						setBackground(new Color(0, 0, 0, 0));
						getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
						setVisible(true);
					}
				}
			};
			int intSleepMilliseconds = 0;
			if (JSONS.getInstance().step.getBoolean("blnScreenshot") == true) {
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				String strScreenshotFilePath = "";
				try {
					new RectangleAreaByName(0, JSONS.getInstance().step.getString("strScreenshotArea"), objHighlightArea);
					BufferedImage objScreenShot = new Robot().createScreenCapture(objHighlightArea);
					strScreenshotFilePath = Path.getInstance().images + "Screenshot_" + new DateTimestamp().get() + ".jpg";
					Thread objThread = new Thread(new ThreadSaveImage(objScreenShot, "jpg", strScreenshotFilePath));
					objThread.start();
					JSONS.getInstance().step.putValue("strScreenshotFilePath", strScreenshotFilePath);
				} catch (Exception e) {
					Logger.getInstance().add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
			}
			if (JSONS.getInstance().step.getBoolean("blnHighlight") == true) {
				try {
					Thread.sleep(intSleepMilliseconds);
				} catch (InterruptedException e) {
					Logger.getInstance().add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
				objJDialog.setVisible(false);
				objJDialog.dispose();
			}
			Logger.getInstance().add("CoordinateHighlightScreenshot: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	private class CoordinatesAlert {
		private CoordinatesAlert() {
			Logger.getInstance().add("  ==start==>CoordinatesAlert " + new DateTimestamp().get());
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
				switch (JSONS.getInstance().step.getLowerCase("strAttributeValues")) {
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
				switch (JSONS.getInstance().step.getLowerCase("strAttributeValues")) {
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
				JSONS.getInstance().step.putValue("intElementScreenX", Integer.toString(intWinPosX));
				JSONS.getInstance().step.putValue("intElementScreenY", Integer.toString(intWinPosY));
				JSONS.getInstance().step.putValue("intElementWidth", Integer.toString(intWinPosWidth));
				JSONS.getInstance().step.putValue("intElementHeight", Integer.toString(intWinPosHeight));
			} catch (Exception e) {
				Logger.getInstance().add("CoordinatesAlert: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("CoordinatesAlert: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class CoordinatesBrowserInner {
		private CoordinatesBrowserInner() throws WebDriverException {
			Logger.getInstance().add("  ==start==>CoordinatesBrowserInner " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			long lngBrowserInnerWidth = 0;
			long lngBrowserInnerHeight = 0;
			try {
				switch (Config.getInstance().browserSelection.toLowerCase()) {
				case "ie":
				case "internet explorer":
					Logger.getInstance().add("CoordinatesBrowserInner: ie");
					lngBrowserInnerWidth = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.screenLeft;");
					lngBrowserInnerHeight = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.screenTop;");
					JSONS.getInstance().step.putValue("intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
					JSONS.getInstance().step.putValue("intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
					break;
				case "firefox":
					Logger.getInstance().add("CoordinatesBrowserInner: firefox");
					lngBrowserInnerWidth = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return Math.round(window.mozInnerScreenX * window.devicePixelRatio);");
					lngBrowserInnerHeight = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return Math.round(window.mozInnerScreenY * window.devicePixelRatio);");
					JSONS.getInstance().step.putValue("intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
					JSONS.getInstance().step.putValue("intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
					Config.getInstance().devicePixelRatio = (Double) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.devicePixelRatio;");
					Logger.getInstance().add("CoordinatesBrowserInner: gdblDevicePixelRatio = " + Config.getInstance().devicePixelRatio.toString());
					Logger.getInstance().add("CoordinatesBrowserInner: lngBrowserInnerWidth = " + lngBrowserInnerWidth);
					Logger.getInstance().add("CoordinatesBrowserInner: intBrowserInnerHeight = " + lngBrowserInnerHeight);
					break;
				case "chrome":
					lngBrowserInnerWidth = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return  Math.round((((window.outerWidth - window.innerWidth) / 2) + window.screenX) * window.devicePixelRatio);");
					lngBrowserInnerHeight = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return  Math.round(((window.outerHeight - window.innerHeight) - ((window.outerWidth - window.innerWidth) / 2) + window.screenY) * window.devicePixelRatio);");
					Long lngDevicePixelRatio = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.devicePixelRatio;");
					Logger.getInstance().add("CoordinatesBrowserInner: lngDevicePixelRatio = " + lngDevicePixelRatio.toString());
					//gdblDevicePixelRatio = (Double) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.devicePixelRatio;");
					Config.getInstance().devicePixelRatio = Double.parseDouble(lngDevicePixelRatio.toString());
					Logger.getInstance().add("CoordinatesBrowserInner: gdblDevicePixelRatio = " + Config.getInstance().devicePixelRatio.toString());
					JSONS.getInstance().step.putValue("intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
					JSONS.getInstance().step.putValue("intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
					break;
				}
			} catch (Exception e) {
				Logger.getInstance().add("CoordinatesBrowserInner: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("CoordinatesBrowserInner: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class CoordinatesElement {
		private CoordinatesElement() {
			Logger.getInstance().add("  ==start==>CoordinatesElement " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				Rectangle rect = new Rectangle(0, 0, -1, -1);
				//	WinDef.RECT rect = returnIECLientScreenXY();
				//WinDef.RECT rect = new WinDef.RECT();
				rect.height = JSONS.getInstance().step.getInt("intBrowserInnerHeight");
				rect.width = JSONS.getInstance().step.getInt("intBrowserInnerWidth");
				rect.x = 0;
				rect.y = 0;
				System.out.println("Solution = " + rect.getBounds().toString());
				System.out.println("Solution rect.left = " + rect.width);
				System.out.println("Solution rect.top = " + rect.height);
				if (Element.getInstance().element != null) {
					System.out.println("before objElementCoordinates");
					Coordinates objElementCoordinates = ((Locatable) Element.getInstance().element).getCoordinates();
					System.out.println("objElementCoordinates.toString() = " + objElementCoordinates.toString());
					System.out.println("objElementCoordinates.onPage() = " + objElementCoordinates.onPage());
					//System.out.println("objElementCoordinates.onScreen() = " + objElementCoordinates.onScreen());
					System.out.println("objElementCoordinates.inViewPort() = " + objElementCoordinates.inViewPort());
					System.out.println("before objElementPoint");
					Point objElementPoint = objElementCoordinates.inViewPort();
					System.out.println("before objElementDimension");
					Dimension objElementDimension = Element.getInstance().element.getSize();
					JSONS.getInstance().step.putValue("intElementX", Integer.toString((int) Math.round(objElementPoint.x * Config.getInstance().devicePixelRatio)));
					JSONS.getInstance().step.putValue("intElementY", Integer.toString((int) Math.round(objElementPoint.y * Config.getInstance().devicePixelRatio)));
					JSONS.getInstance().step.putValue("intElementWidth", Integer.toString((int) Math.round(objElementDimension.width * Config.getInstance().devicePixelRatio)));
					JSONS.getInstance().step.putValue("intElementHeight", Integer.toString((int) Math.round(objElementDimension.height * Config.getInstance().devicePixelRatio)));
					Logger.getInstance().add("  ==end==>CoordinatesElement objElementPoint.x " + objElementPoint.x);
					Logger.getInstance().add("  ==end==>CoordinatesElement objElementPoint.y " + objElementPoint.y);
					Logger.getInstance().add("  ==end==>CoordinatesElement objElementDimension.width " + objElementDimension.width);
					Logger.getInstance().add("  ==end==>CoordinatesElement objElementDimension.height " + objElementDimension.height);
					Logger.getInstance().add("  ==end==>CoordinatesElement gdblDevicePixelRatio " + Config.getInstance().devicePixelRatio.toString());
				}
				System.out.println("before intElementX");
				int intElementX = JSONS.getInstance().step.getInt("intElementX");
				int intElementY = JSONS.getInstance().step.getInt("intElementY");
				int intElementScreenX = rect.width + intElementX;
				int intElementScreenY = rect.height + intElementY;
				System.out.println("before putInt");
				JSONS.getInstance().step.putValue("intElementScreenX", Integer.toString(intElementScreenX));
				JSONS.getInstance().step.putValue("intElementScreenY", Integer.toString(intElementScreenY));
			} catch (Exception e) {
				Logger.getInstance().add("CoordinatesElement: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("  ==end==>CoordinatesElement " + new DateTimestamp().get());
				Logger.getInstance().add("CoordinatesElement: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class DialogLaunch extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		private ButtonGroup grpBrowser = new ButtonGroup();
		private ButtonGroup grpEnvironment = new ButtonGroup();
		private ButtonGroup grpTestArea = new ButtonGroup();
		private FilenameFilter objFilter;
		private Font fntDialog = new Font("Tahoma", Font.PLAIN, 20);
		private JButton btnCancel = new JButton("Cancel");
		private JButton btnRun = new JButton("Run");
		private JComboBox<String> cboApplication = new JComboBox<String>();
		private JComboBox<String> cboTest = new JComboBox<String>();
		private JLabel lblSelectTheApplication = new JLabel("Select the application");
		private JLabel lblSelectTheBrowser = new JLabel("Select the browser");
		private JLabel lblSelectTheEnvironment = new JLabel("Select the environment");
		private JLabel lblSelectTheTest = new JLabel("Select the test");
		private JLabel lblSelectTheTestArea = new JLabel("Select the test area");
		private JRadioButton rdoChrome = new JRadioButton("chrome");
		private JRadioButton rdoEnv1 = new JRadioButton("environment 1");
		private JRadioButton rdoEnv2 = new JRadioButton("environment 2");
		private JRadioButton rdoEnv3 = new JRadioButton("environment 3");
		private JRadioButton rdoEnv4 = new JRadioButton("environment 4");
		private JRadioButton rdoEnv5 = new JRadioButton("environment 5");
		private JRadioButton rdoEnv6 = new JRadioButton("environment 6");
		private JRadioButton rdoEnvTestValue = new JRadioButton("test value", true);
		private JRadioButton rdoFirefox = new JRadioButton("firefox");
		private JRadioButton rdoIE = new JRadioButton("internet explorer");
		private JRadioButton rdoInternal = new JRadioButton("internal");
		private JRadioButton rdoLocal = new JRadioButton("local");
		private JRadioButton rdoPublic = new JRadioButton("public");
		private JRadioButton rdoTestValue = new JRadioButton("value in test", true);
		private String mstrPath = "", mstrNameTest = "", mstrTestArea = "";
		private String[] arrDropEmpty = new String[0];
		private int intColumn1 = 12, intColumn2 = 245, intColumn3 = 465,
				intColumnWidth1 = 200, intColumnWidth2 = 200,
				intColumnWidth3 = 220;

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
			lblSelectTheTestArea.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTestArea.setFont(fntDialog);
			lblSelectTheTestArea.setBounds(intColumn1, 15, intColumnWidth1, 35);
			getContentPane().add(lblSelectTheTestArea);
			rdoLocal.setFont(fntDialog);
			rdoLocal.setBounds(intColumn1, 45, intColumnWidth1, 25);
			rdoLocal.addActionListener(this);
			getContentPane().add(rdoLocal);
			rdoPublic.setFont(fntDialog);
			rdoPublic.setBounds(intColumn1, 70, intColumnWidth1, 25);
			rdoPublic.addActionListener(this);
			getContentPane().add(rdoPublic);
			rdoInternal.setFont(fntDialog);
			rdoInternal.setBounds(intColumn1, 95, intColumnWidth1, 25);
			rdoInternal.addActionListener(this);
			getContentPane().add(rdoInternal);
			grpTestArea.add(rdoLocal);
			grpTestArea.add(rdoPublic);
			grpTestArea.add(rdoInternal);
			//SelectTheBrowser Group radio buttons.
			lblSelectTheBrowser.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheBrowser.setFont(fntDialog);
			lblSelectTheBrowser.setBounds(intColumn2, 15, intColumnWidth2, 35);
			getContentPane().add(lblSelectTheBrowser);
			rdoTestValue.setFont(fntDialog);
			rdoTestValue.setBounds(intColumn2, 45, intColumnWidth2, 25);
			rdoTestValue.addActionListener(this);
			getContentPane().add(rdoTestValue);
			rdoIE.setFont(fntDialog);
			rdoIE.setBounds(intColumn2, 70, intColumnWidth2, 25);
			rdoIE.addActionListener(this);
			getContentPane().add(rdoIE);
			rdoChrome.setFont(fntDialog);
			rdoChrome.setBounds(intColumn2, 95, intColumnWidth2, 25);
			rdoChrome.addActionListener(this);
			getContentPane().add(rdoChrome);
			rdoFirefox.setFont(fntDialog);
			rdoFirefox.setBounds(intColumn2, 120, intColumnWidth2, 25);
			getContentPane().add(rdoFirefox);
			rdoFirefox.addActionListener(this);
			grpBrowser.add(rdoTestValue);
			grpBrowser.add(rdoIE);
			grpBrowser.add(rdoChrome);
			grpBrowser.add(rdoFirefox);
			//SelectTheEnvironment Group radio buttons.
			lblSelectTheEnvironment.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheEnvironment.setFont(fntDialog);
			lblSelectTheEnvironment.setBounds(intColumn3, 15, intColumnWidth3, 35);
			getContentPane().add(lblSelectTheEnvironment);
			rdoEnvTestValue.setFont(fntDialog);
			rdoEnvTestValue.setBounds(intColumn3, 45, intColumnWidth3, 25);
			rdoEnvTestValue.addActionListener(this);
			getContentPane().add(rdoEnvTestValue);
			rdoEnv1.setFont(fntDialog);
			rdoEnv1.setBounds(intColumn3, 70, intColumnWidth3, 25);
			rdoEnv1.addActionListener(this);
			getContentPane().add(rdoEnv1);
			rdoEnv2.setFont(fntDialog);
			rdoEnv2.setBounds(intColumn3, 95, intColumnWidth3, 25);
			rdoEnv2.addActionListener(this);
			getContentPane().add(rdoEnv2);
			rdoEnv3.setFont(fntDialog);
			rdoEnv3.setBounds(intColumn3, 120, intColumnWidth3, 25);
			rdoEnv3.addActionListener(this);
			getContentPane().add(rdoEnv3);
			rdoEnv4.setFont(fntDialog);
			rdoEnv4.setBounds(intColumn3, 145, intColumnWidth3, 25);
			rdoEnv4.addActionListener(this);
			getContentPane().add(rdoEnv4);
			rdoEnv5.setFont(fntDialog);
			rdoEnv5.setBounds(intColumn3, 170, intColumnWidth3, 25);
			rdoEnv5.addActionListener(this);
			getContentPane().add(rdoEnv5);
			rdoEnv6.setFont(fntDialog);
			rdoEnv6.setBounds(intColumn3, 195, intColumnWidth3, 25);
			rdoEnv6.addActionListener(this);
			getContentPane().add(rdoEnv6);
			grpEnvironment.add(rdoEnvTestValue);
			grpEnvironment.add(rdoEnv1);
			grpEnvironment.add(rdoEnv2);
			grpEnvironment.add(rdoEnv3);
			grpEnvironment.add(rdoEnv4);
			grpEnvironment.add(rdoEnv5);
			grpEnvironment.add(rdoEnv6);
			//lblSelectTheApplication
			lblSelectTheApplication.setFont(fntDialog);
			lblSelectTheApplication.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheApplication.setBounds(12, 141, 398, 35);
			getContentPane().add(lblSelectTheApplication);
			cboApplication.setFont(fntDialog);
			cboApplication.setToolTipText("Tip the tool");
			cboApplication.setBounds(12, 175, 410, 40);
			cboApplication.setEnabled(false);
			cboApplication.addActionListener(this);
			getContentPane().add(cboApplication);
			//lblSelectTheTest
			lblSelectTheTest.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTest.setFont(fntDialog);
			lblSelectTheTest.setBounds(12, 252, 398, 35);
			getContentPane().add(lblSelectTheTest);
			cboTest.setToolTipText("Tip the tool");
			cboTest.setFont(fntDialog);
			cboTest.setBounds(12, 283, 708, 40);
			cboTest.setEnabled(false);
			cboTest.addActionListener(this);
			getContentPane().add(cboTest);
			btnRun.setFont(fntDialog);
			btnRun.setBounds(12, 373, 310, 55);
			btnRun.setEnabled(false);
			btnRun.addActionListener(this);
			getContentPane().add(btnRun);
			btnCancel.setFont(fntDialog);
			btnCancel.setBounds(410, 373, 310, 55);
			btnCancel.addActionListener(this);
			getContentPane().add(btnCancel);
			Config.getInstance().browserSelection = "value in test";
			//mstrTestEnvironment = "test value";
			Config.getInstance().environment = "test value";
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent objActionEvent) {
			ButtonGroup grpSelectedGroup = null;
			JRadioButton objJRadioButton = null;
			String strRadioButtonText = "";
			Object objObject = objActionEvent.getSource();
			if (objObject instanceof JRadioButton) {
				objJRadioButton = (JRadioButton) objObject;
				grpSelectedGroup = ((DefaultButtonModel) objJRadioButton.getModel()).getGroup();
				strRadioButtonText = objJRadioButton.getText();
				if (grpSelectedGroup.equals(grpTestArea)) {
					this.mstrTestArea = strRadioButtonText;
					Config.getInstance().testArea = strRadioButtonText;
					Path.getInstance().setDirectory(strRadioButtonText);
					Logger.getInstance().add("data_EnvironmentURL: Paths.getInstance().pathTestData = " + Path.getInstance().testData);
					mstrPath = (Path.getInstance().systemUserDir + "/" + Path.getInstance().testConfiguration).replaceAll("\\\\", "/");
					Logger.getInstance().add("DialogLaunch:actionPerformed mstrPath = " + mstrPath);
					this.getApplications();
				} else if (grpSelectedGroup.equals(grpBrowser)) {
					Config.getInstance().browserSelection = strRadioButtonText;
				} else if (grpSelectedGroup.equals(grpEnvironment)) {
					Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + Config.getInstance().environment);
					Config.getInstance().environment = strRadioButtonText;
					Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + Config.getInstance().environment);
				}
			}
			if (objActionEvent.getSource() == cboApplication) {
				this.getTests();
			}
			if (objActionEvent.getSource() == cboTest) {
				btnRun.setEnabled(true);
			}
			if (objActionEvent.getSource() == btnRun) {
				Config.getInstance().testName = (String) cboTest.getSelectedItem();
				if (!Config.getInstance().environment.equals("test value")) {
					Logger.getInstance().add("DialogLaunch:actionPerformed Paths.getInstance().pathTestData = " + Path.getInstance().testData);
					String strFilePathTestData = Path.getInstance().testData + "Environments.json";
					Logger.getInstance().add("DialogLaunch:actionPerformed strFilePathTestData = " + strFilePathTestData);
					try {
						JSON objJsonObjectFile = new JSON();
						objJsonObjectFile.replaceAllFromFile(strFilePathTestData);
						Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + Config.getInstance().environment);
						Config.getInstance().environment = objJsonObjectFile.getString(Config.getInstance().environment);
						Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + Config.getInstance().environment);
					} catch (Exception e) {
						Logger.getInstance().add("DialogLaunch:actionPerformed Exception = " + e.toString());
					}
				}
				dispose();
				return;
			}
			if (objActionEvent.getSource() == btnCancel) {
				dispose();
				return;
			}
		}

		private void getApplications() {
			String[] arrDrop = null;
			HashSet<String> hs = new HashSet<String>();
			File dir = new File(mstrPath);
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
			cboApplication.setEnabled(true);
			if (files.length == 0) {
				System.out.println("The directory is empty");
				cboApplication.setModel(new DefaultComboBoxModel<String>(arrDrop));
			} else {
				for (File aFile : files) {
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
				cboApplication.removeActionListener(this);
				cboApplication.setModel(new DefaultComboBoxModel<String>(arrDrop));
				cboApplication.setSelectedItem(null);
				cboApplication.addActionListener(this);
			}
			cboTest.setModel(new DefaultComboBoxModel<String>(arrDropEmpty));
			cboTest.setEnabled(false);
		}

		private void getTests() {
			int intCount = 0;
			File dir = new File(mstrPath);
			objFilter = new FilenameFilter() {
				@Override
				public boolean accept(File file, String name) {
					if (name.startsWith((String) cboApplication.getSelectedItem())) {
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
			cboTest.setModel(new DefaultComboBoxModel<String>(arrDrop));
			cboTest.setSelectedItem(null);
			cboTest.setEnabled(true);
		}
	}

	private class ElementDisabled {
		private ElementDisabled() throws ExceptionElementNotDisabled {
			Logger.getInstance().add("  ==start==>ElementDisabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (Element.getInstance().element.isEnabled()) {
					throw new ExceptionElementNotDisabled("ElementDisabled - Element is not disabled");
				} else {
					return;
				}
			} finally {
				Logger.getInstance().add("ElementDisabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementDisabledSync {
		private ElementDisabledSync() {
			Logger.getInstance().add("  ==start==>ElementDisabledSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnDisabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			String strActualResult = "";
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
					strActualResult = "sync_disabled";
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					blnDisabled = false;
					strActualResult = "not_found";
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					blnDisabled = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotDisabled e) {
					blnDisabled = false;
					strActualResult = "not_disabled";
					Logger.getInstance().add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "elementDisabledSync", "syncdisabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			Logger.getInstance().add("  ==start==>ElementDragSync " + new DateTimestamp().get());
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
						Logger.getInstance().add("ElementDragSync: elementFind over");
						if (Element.getInstance().element != null) {
							strOuterHTML = Element.getInstance().element.getAttribute("outerHTML");
							Logger.getInstance().add("ElementDragSync: outerHTML = " + strOuterHTML);
							Logger.getInstance().add("ElementDragSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						Logger.getInstance().add("ElementDragSync: strOuterHTML over");
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
					ElementDrag.getInstance().elementDrag = Element.getInstance().element;
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Logger.getInstance().add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Logger.getInstance().add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Logger.getInstance().add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementDragSync", "drag", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						return;
					} else {
					}
				}
			}
		}
	}

	private class ElementDropSync {
		private ElementDropSync() {
			Logger.getInstance().add("  ==start==>ElementDropSync " + new DateTimestamp().get());
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
						Logger.getInstance().add("ElementDropSync: elementFind over");
						if (Element.getInstance().element != null) {
							strOuterHTML = Element.getInstance().element.getAttribute("outerHTML");
							Logger.getInstance().add("ElementDropSync: outerHTML = " + strOuterHTML);
							Logger.getInstance().add("ElementDropSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						Logger.getInstance().add("ElementDropSync: strOuterHTML over");
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
					ElementDrop.getInstance().elementDrop = Element.getInstance().element;
					//Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
					//actions.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).perform();
					// 	Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
					// 	Action dragDrop = action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build();
					// 	dragDrop.perform();
					Actions objActions = new Actions(BrowserDriver.getInstance().browserDriver);
					Action objDragAndDrop = objActions.clickAndHold(ElementDrag.getInstance().elementDrag).moveToElement(ElementDrop.getInstance().elementDrop).release(ElementDrop.getInstance().elementDrop).build();
					objDragAndDrop.perform();
					// 	Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
					// 	action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build().perform();
					new SleepMilliseconds(10000);
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Logger.getInstance().add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Logger.getInstance().add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Logger.getInstance().add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "elementDropSync", "drop", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						return;
					}
				}
			}
		}
	}

	private class ElementEnabled {
		private ElementEnabled() throws ExceptionElementNotEnabled {
			Logger.getInstance().add("  ==start==>ElementEnabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == true) {
						return;
					} else {
						throw new ExceptionElementNotEnabled("Alert popup was not found.");
					}
				}
				if (Element.getInstance().element.isEnabled()) {
					return;
				} else {
					throw new ExceptionElementNotEnabled("ElementEnabled - Element is not enabled");
				}
			} finally {
				Logger.getInstance().add("ElementEnabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementEnabledSync {
		private ElementEnabledSync() {
			Logger.getInstance().add("  ==start==>ElementEnabledSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnEnabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			String strActualResult = "";
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
					strActualResult = "sync_enabled";
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					blnEnabled = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					strActualResult = "not_enabled";
					Logger.getInstance().add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementEnabledSync", "syncenabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			Logger.getInstance().add("  ==start==>ElementFind " + new DateTimestamp().get());
			if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
				JSONS.getInstance().step.putValue("strTagType", "alert");
				if (new AlertFind().run() == true) {
					JSONS.getInstance().step.putValue("strHighlightArea", "alert");
					return;
				} else {
					JSONS.getInstance().step.putValue("strHighlightArea", "screen");
					throw new ExceptionElementNotFound("Alert popup not found!");
				}
			}
			if (JSONS.getInstance().step.getString("strTagName").toLowerCase().equals("title")) {
				JSONS.getInstance().step.putValue("strTagType", "title");
				return;
			}
			String strWindowHandle = "";
			Object[] arrHandles = BrowserDriver.getInstance().browserDriver.getWindowHandles().toArray();
			Collections.reverse(Arrays.asList(arrHandles));
			for (Object objWindowHandlesEach : arrHandles) {
				Logger.getInstance().add("ElementFind: objWindowHandlesEach.toString() = " + objWindowHandlesEach.toString());
			}
			for (Object objWindowHandlesEach : arrHandles) {
				try {
					strWindowHandle = objWindowHandlesEach.toString();
					BrowserDriver.getInstance().browserDriver.switchTo().window(strWindowHandle);
					new CoordinatesBrowserInner();
					List<Integer> arrRouteOriginal = new ArrayList<Integer>();
					new ElementFindFramesSearch().run(arrRouteOriginal);
					if (Element.getInstance().element != null) {
						// Logger.getInstance().add("elementFind: BrowserDriver.getInstance().browserDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
						// Logger.getInstance().add("elementFind: BrowserDriver.getInstance().browserDriver.getTitle = " + BrowserDriver.getInstance().browserDriver.getTitle());
						// Logger.getInstance().add("ElementFindFramesSearch: BrowserDriver.getInstance().browserDriver.getTitle = " + BrowserDriver.getInstance().browserDriver.getTitle());
						// Logger.getInstance().add("ElementFindFramesSearch: BrowserDriver.getInstance().browserDriver.getCurrentUrl = " + BrowserDriver.getInstance().browserDriver.getCurrentUrl());
						// Logger.getInstance().add("ElementFindFramesSearch: BrowserDriver.getInstance().browserDriver.getWindowHandle = " + BrowserDriver.getInstance().browserDriver.getWindowHandle());
						// Logger.getInstance().add("ElementFindFramesSearch BrowserDriver.getInstance().browserDriver.getPageSource = " + BrowserDriver.getInstance().browserDriver.getPageSource());
						return;
					}
				} catch (Exception e) {
					Logger.getInstance().add("ElementFind: Exception = " + e.toString());
				}
			}
			throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
		}
	}

	private class ElementFindBy {
		private ElementFindBy(String strAttributeNames, String strAttributeValues, String strTagName) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			Logger.getInstance().add("  ==start==>ElementFindBy " + new DateTimestamp().get());
			int intAttributeEach = 0;
			List<WebElement> objWebElementCollection = new ArrayList<WebElement>();
			String arrAttributeNames[] = strAttributeNames.toString().split("\\|", -1);
			String arrAttributeValues[] = strAttributeValues.toString().split("\\|", -1);
			String strIndex = "";
			String strIndexKeyword = "";
			String strXpath = "";
			String strXpathAttributes = "";
			String strXpathAttributesTemp = "";
			Boolean blnRegularExpression = false;
			//TODO fix the <re>Input error. check attribute value for keyword and handle by creating xpath
			if (strAttributeValues.toLowerCase().contains("<contains>") || strAttributeValues.toLowerCase().contains("<starts>")) {
				blnRegularExpression = true;
			}
			if (strAttributeNames.toLowerCase().equals("xpath") && blnRegularExpression.equals(false)) {
				Logger.getInstance().add("ElementFindBy: xpath  " + strAttributeNames + " = " + strAttributeValues);
				objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.xpath(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("id") && blnRegularExpression.equals(false)) {
				Logger.getInstance().add("ElementFindBy: id  " + strAttributeNames + " = " + strAttributeValues);
				objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.id(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("name") && blnRegularExpression.equals(false)) {
				Logger.getInstance().add("ElementFindBy: name  " + strAttributeNames + " = " + strAttributeValues);
				objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.name(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("class") && blnRegularExpression.equals(false)) {
				Logger.getInstance().add("ElementFindBy: class  " + strAttributeNames + " = " + strAttributeValues);
				objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.className(strAttributeValues));
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
						switch (getKeyword(arrAttributeValues[intAttributeEach].toLowerCase())) {
						case "<contains>":
							strXpathAttributesTemp = "contains(text()" + ", '" + getKeywordValue(arrAttributeValues[intAttributeEach]) + "')";
							break;
						case "<starts>":
							strXpathAttributesTemp = "starts-with(text()" + ", '" + getKeywordValue(arrAttributeValues[intAttributeEach]) + "')";
							break;
						default:
							strXpathAttributesTemp = "text()='" + arrAttributeValues[intAttributeEach] + "' ";
							break;
						}
						break;
					default:
						if (arrAttributeNames[intAttributeEach].toLowerCase().equals("type")) {
							JSONS.getInstance().step.putValue("strType", arrAttributeValues[intAttributeEach]);
						}
						switch (getKeyword(arrAttributeValues[intAttributeEach].toLowerCase())) {
						case "<contains>":
							strXpathAttributesTemp = "contains(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + getKeywordValue(arrAttributeValues[intAttributeEach]).toLowerCase() + "')";
							break;
						case "<starts>":
							strXpathAttributesTemp = "starts-with(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + getKeywordValue(arrAttributeValues[intAttributeEach]).toLowerCase() + "')";
							break;
						default:
							strXpathAttributesTemp = "@" + arrAttributeNames[intAttributeEach] + "='" + arrAttributeValues[intAttributeEach] + "'";
							break;
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
				Logger.getInstance().add("ElementFindBy: strXpath = " + strXpath);
				objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.xpath(strXpath));
			}
			switch (objWebElementCollection.size()) {
			case 0:
				throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
			case 1:
				Element.getInstance().element = objWebElementCollection.get(0);
				break;
			default:
				if (strIndexKeyword.equals("<last>")) {
					Element.getInstance().element = objWebElementCollection.get(objWebElementCollection.size() - 1);
					break;
				} else if (strIndexKeyword.equals("<random>")) {
					int intRandomElement = randomNumberRange(0, objWebElementCollection.size() - 1);
					Element.getInstance().element = objWebElementCollection.get(intRandomElement);
					break;
				} else {
					Logger.getInstance().add("ElementFindBy: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
					Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
					while (objWebElementEach.hasNext()) {
						WebElement row = objWebElementEach.next();
						Logger.getInstance().add("ElementFindBy: outerHTML:=  " + row.getAttribute("outerHTML"));
					}
					throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
				}
			}
		}
	}

	private class ElementFindFramesSearch {
		private boolean run(List<Integer> arrFramePath) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			Logger.getInstance().add("  ==start==>ElementFindFramesSearch " + new DateTimestamp().get());
			boolean blnReturn;
			int intMaximumDepth = 100;
			String strTagName = JSONS.getInstance().step.getLowerCase("strTagName");
			String strAttributeNames = JSONS.getInstance().step.getString("strAttributeNames");
			String strAttributeValues = JSONS.getInstance().step.getString("strAttributeValues");
			try {
				new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
				JSONS.getInstance().step.putValue("strCurrentWindowHandle", BrowserDriver.getInstance().browserDriver.getWindowHandle());
				if (JSONS.getInstance().step.verifyEquals("strTagName", "input")) {
					if (JSONS.getInstance().step.getString("strType").length() == 0) {
						JSONS.getInstance().step.putValue("strType", Element.getInstance().element.getAttribute("type"));
					}
					JSONS.getInstance().step.putValue("strTagType", "input_" + JSONS.getInstance().step.getString("strType"));
				} else {
					JSONS.getInstance().step.putValue("strTagType", JSONS.getInstance().step.getString("strTagName"));
				}
				Logger.getInstance().add("ElementFindFramesSearch: Element.getInstance().element outerHTML = " + Element.getInstance().element.getAttribute("outerHTML"));
				return true;
			} catch (ExceptionElementNotFound | ExceptionMultipleElementsFound | StaleElementReferenceException e) {
				blnReturn = false;
				Logger.getInstance().add("ElementFindFramesSearch: Exception = " + e.toString());
			}
			if (arrFramePath.size() < intMaximumDepth) {
				int intFramesCount = BrowserDriver.getInstance().browserDriver.findElements(By.tagName("frame")).size();
				for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
					try {
						BrowserDriver.getInstance().browserDriver.switchTo().frame(intFramesEach);
						List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
						arrFramePathNew.add(intFramesEach);
						blnReturn = new ElementFindFramesSearch().run(arrFramePathNew);
						if (blnReturn == true) {
							return true;
						}
						BrowserDriver.getInstance().browserDriver.switchTo().defaultContent();
						for (int intFramesPathEach : arrFramePath)
							BrowserDriver.getInstance().browserDriver.switchTo().frame(intFramesPathEach);
					} catch (NoSuchFrameException error) {
						blnReturn = false;
						Logger.getInstance().add("ElementFindFramesSearch: NoSuchFrameException = " + error.toString());
						break;
					} catch (Exception error) {
						Logger.getInstance().add("ElementFindFramesSearch: Exception = " + error.toString());
					}
				}
			}
			return blnReturn;
		}
	}

	private class ElementGet {
		private String run() throws ExceptionElementTagNameNotSupported {
			Logger.getInstance().add("  ==start==>ElementGet " + new DateTimestamp().get());
			AutoItX objAutoIt = objAutoItSetObject.getObject();
			switch (JSONS.getInstance().step.getLowerCase("strTagType")) {
			case "title":
				return BrowserDriver.getInstance().browserDriver.getTitle();
			case "img":
				return Element.getInstance().element.getAttribute("src");
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				return Element.getInstance().element.getAttribute("value").trim();
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
				return Element.getInstance().element.getText();
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
			case "input_textarea":
				return Element.getInstance().element.getAttribute("value");
			case "input_radio":
			case "input_checkbox":
				if (Element.getInstance().element.isSelected() == false) {
					return "<off>";
				} else {
					return "<on>";
				}
			case "select":
				// 	Select objSelect = new Select(Element.getInstance().element);
				// 	objSelect.getOptions();
				// 	WebElement option = ((Select) Element.getInstance().element).getFirstSelectedOption();
				// 	Logger.getInstance().add("ElementGet: option.getText() = " + option.getText());
				//return ((Select) Element.getInstance().element).getFirstSelectedOption().getText().replaceAll("\\s{2,}", " ");
				JavascriptExecutor objExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
				return ((String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", Element.getInstance().element)).trim();
			case "table":
				return Element.getInstance().element.getText();
			case "alert":
				if (JSONS.getInstance().step.verifyEquals("strAttributeValues", "title")) {
					return objAutoIt.winGetTitle("[ACTIVE]");
				} else {
					return BrowserDriver.getInstance().browserDriver.switchTo().alert().getText();
				}
			default:
				throw new ExceptionElementTagNameNotSupported("Element tag not supported");
			}
		}
	}

	private class ElementGetSync {
		private ElementGetSync() {
			Logger.getInstance().add("  ==start==>ElementGetSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnGet = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			String strGetValue = "";
			String strActualResult = "";
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
						JSONS.getInstance().step.putValue("strOutputValue", strGetValue);
						blnGet = true;
					}
					blnStatus = true;
					strActualResult = "get";
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					strActualResult = "tag_not_supported";
					Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementGetSync", "get", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			Logger.getInstance().add("  ==start==>ElementHidden " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == false) {
						JSONS.getInstance().step.putValue("strHighlightArea", "screen");
						return;
					} else {
						throw new ExceptionElementNotHidden("Alert popup was not hidden.");
					}
				}
				if (Element.getInstance().element.isDisplayed() == false) {
					return;
				} else {
					Logger.getInstance().add("ElementHidden: Element.getInstance().element.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					throw new ExceptionElementNotHidden("Element is displayed.");
				}
			} catch (NullPointerException | WebDriverException e) {
				Logger.getInstance().add("ElementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				return;
			} finally {
				Logger.getInstance().add("ElementHidden: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementHiddenSync {
		private ElementHiddenSync() {
			Logger.getInstance().add("  ==start==>ElementHiddenSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnHidden = false;
			Boolean blnStatus = false;
			String strActualResult = "";
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
					strActualResult = "sync_hidden";
				} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ExceptionElementNotFound e) {
					blnFound = false;
					blnHidden = true;
					blnStatus = true;
					strActualResult = "sync_hidden";
					Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnHidden = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnHidden = false;
					strActualResult = "not_hidden";
					Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnFound = false;
					blnHidden = false;
					strActualResult = "exception";
					;
					Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementHiddenSync", "synchidden", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			//List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
			// Logger.getInstance().add("ElementJavascriptExecutorGetElementsByTagName objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
			//if (objCollectionJS2.size() > 0) {
			//	long lngStartTimeByXpath = System.currentTimeMillis();
			//}
		}
	}

	private class ElementJavascriptExecutorXPath {
		private String run() {
			Logger.getInstance().add("  ==start==>ElementJavascriptExecutorXPath " + new DateTimestamp().get());
			return (String) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", Element.getInstance().element);
		}
	}

	private class ElementOnMouseOut {
		private ElementOnMouseOut() {
			Logger.getInstance().add("  ==start==>ElementOnMouseOut " + new DateTimestamp().get());
			Actions objActions = new Actions(BrowserDriver.getInstance().browserDriver);
			// Dimension objWebDriverDimension = Element.getInstance().element.getSize();
			// int intElementWidth = objWebDriverDimension.width;
			// int intElementHeight = objWebDriverDimension.height;
			int intElementWidth = JSONS.getInstance().step.getInt("intElementWidth");
			int intElementHeight = JSONS.getInstance().step.getInt("intElementHeight");
			objActions.moveByOffset(-((intElementWidth / 2) + 1), -((intElementHeight / 2) + 1)).build().perform();
			JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseout();", Element.getInstance().element);
		}
	}

	private class ElementOnMouseOutSync {
		private ElementOnMouseOutSync() {
			Logger.getInstance().add("  ==start==>ElementOnMouseOutSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnEnabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnOnMouseOver = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			String strActualResult = "";
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
					strActualResult = "mouse_out";
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					strActualResult = "not_enabled";
					Logger.getInstance().add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementOnMouseOutSync", "mouse_out", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			Logger.getInstance().add("  ==start==>ElementOnMouseOver " + new DateTimestamp().get());
			Actions objActions = new Actions(BrowserDriver.getInstance().browserDriver);
			objActions.moveToElement(Element.getInstance().element).build().perform();
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseover();", Element.getInstance().element);
		}
	}

	private class ElementOnMouseOverSync {
		private ElementOnMouseOverSync() {
			Logger.getInstance().add("  ==start==>ElementOnMouseOverSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnEnabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnOnMouseOver = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			String strActualResult = "";
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
					strActualResult = "mouse_over";
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					strActualResult = "not_enabled";
					Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "elementOnMouseOverSync", "mouse_over", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						return;
					} else {
						blnOnMouseOver = false;
					}
				}
			}
		}
	}

	private class ElementPleaseWaitSync {
		private ElementPleaseWaitSync() throws ExceptionElementNotHidden {
			Logger.getInstance().add("  ==start==>ElementPleaseWaitSync " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnPleaseWait = Boolean.parseBoolean(JSONS.getInstance().step.getString("blnPleaseWait"));
			Integer intPleaseWaitEach;
			String strAttributeNames = null;
			String strAttributeValues = null;
			String strTagName = null;
			Boolean blnFound = false;
			String strMessage = "";
			JSON objJsonObjectPleaseWaitNode = new JSON();
			try {
				ElementPleaseWait.getInstance().elementPleaseWait = Element.getInstance().element;
				Logger.getInstance().add("ElementPleaseWaitSync: objectProcessing.size() = " + JSONS.getInstance().processing.size());
				if (blnPleaseWait == true) {
					for (intPleaseWaitEach = 1; intPleaseWaitEach < JSONS.getInstance().processing.size(); intPleaseWaitEach++) {
						objJsonObjectPleaseWaitNode.replaceAllFromJSONObject(JSONS.getInstance().processing.getNode("PleaseWait_" + intPleaseWaitEach));
						try {
							strAttributeNames = objJsonObjectPleaseWaitNode.getValue("strAttributeNames", "");
							strAttributeValues = objJsonObjectPleaseWaitNode.getValue("strAttributeValues", "");
							strTagName = objJsonObjectPleaseWaitNode.getValue("strTagName", "");
							Logger.getInstance().add("ElementPleaseWaitSync: variables = " + strAttributeNames + " " + strAttributeValues + " " + strTagName);
						} catch (ExceptionJSONKeyNotPresent e1) {
							// TODO Auto-generated catch block
							Logger.getInstance().add("ElementPleaseWaitSync: ExceptionJSONKeyNotPresent = " + e1.toString());
						}
						try {
							new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
							blnFound = true;
							strMessage = "Element found.";
						} catch (ExceptionElementNotFound e) {
							blnFound = false;
							Logger.getInstance().add("ElementPleaseWaitSync: ElementFindBy = blnFound = false Milliseconds Waited = " + (System.currentTimeMillis()));
						} catch (ExceptionMultipleElementsFound e) {
							blnFound = true;
							strMessage = "Multiple elements found.";
							Logger.getInstance().add("ElementPleaseWaitSync: ElementFindBy = blnFound = true Milliseconds Waited = " + (System.currentTimeMillis()));
						}
						if (blnFound == true) {
							if (Element.getInstance().element.isDisplayed() == true) {
								Logger.getInstance().add("ElementPleaseWaitSync: Element.getInstance().element.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis()));
								//throw new ExceptionElementNotHidden("Element is displayed.");
								blnFound = true;
								strMessage = "Element is displayed.";
							} else {
								blnFound = false;
								Logger.getInstance().add("ElementPleaseWaitSync: Element.getInstance().element.isDisplayed() = return false Milliseconds Waited = " + (System.currentTimeMillis()));
							}
						}
						if (blnFound == true) {
							return;
						}
					}
				}
			} finally {
				Logger.getInstance().add("ElementPleaseWaitSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				Element.getInstance().element = ElementPleaseWait.getInstance().elementPleaseWait;
				if (blnFound == true) {
					throw new ExceptionElementNotHidden(strMessage);
				}
			}
		}
	}

	//TODO start here alpabetically to check new step Actual
	private class ElementScroll {
		private ElementScroll() {
			JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
			objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", Element.getInstance().element);
		}
	}

	private class ElementScrollSync {
		private ElementScrollSync() {
			Logger.getInstance().add("  ==start==>ElementScrollSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			String strActualResult = "";
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
						Logger.getInstance().add("ElementScrollSync: blnFound = true");
					}
					if (blnVisible == false) {
						new ElementVisible();
						blnVisible = true;
					}
					new ElementScroll();
					// 		JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
					// 		objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", Element.getInstance().element);
					blnStatus = true;
					Logger.getInstance().add("ElementScrollSync: blnStatus = true");
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementScrollSync", "scroll", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						return;
					}
				}
			}
		}
	}

	private class ElementSet {
		private ElementSet(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionVisibleTextNotInSelectList, ExceptionKeywordNotValid {
			Logger.getInstance().add("  ==start==>ElementSet " + new DateTimestamp().get());
			Logger.getInstance().add("ElementSet: " + JSONS.getInstance().step.getLowerCase("strAttributeValues"));
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = JSONS.getInstance().step.getString("strInputValue");
			String strValueToSelect = strInputValue;
			String strAttributeValues = JSONS.getInstance().step.getLowerCase("strAttributeValues");
			String strTagType = JSONS.getInstance().step.getLowerCase("strTagType");
			String strStepExpected = "";
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
						JSONS.getInstance().step.putValue("strInputValue", "<click>");
						Element.getInstance().element.click();
						strStepExpected = "click";
						break;
					case "<doubleclick>":
						objActions = new Actions(BrowserDriver.getInstance().browserDriver);
						objActions.moveToElement(Element.getInstance().element).doubleClick().build().perform();
						strStepExpected = "double_click";
						break;
					case "<rightclick>":
						//ToDo add right click code
						objActions = new Actions(BrowserDriver.getInstance().browserDriver);
						objActions.contextClick(Element.getInstance().element).build().perform();
						// 			Actions action= new Actions(BrowserDriver.getInstance().browserDriver);
						// 			action.contextClick(Element.getInstance().element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						strStepExpected = "right_click";
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
					if (Element.getInstance().element.getAttribute("value").isEmpty() == false) {
						Element.getInstance().element.clear();
					}
					Element.getInstance().element.sendKeys(strInputValue);
					strStepExpected = "set";
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						JSONS.getInstance().step.putValue("strInputValue", "<on>");
						if (Element.getInstance().element.isSelected() == false) {
							Element.getInstance().element.click();
						}
						strStepExpected = "click";
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please use <on>");
					}
					break;
				case "input_checkbox":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						JSONS.getInstance().step.putValue("strInputValue", "<on>");
						if (Element.getInstance().element.isSelected() == false) {
							Element.getInstance().element.click();
						}
						break;
					case "<off>":
						if (Element.getInstance().element.isSelected() == true) {
							Element.getInstance().element.click();
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					strStepExpected = "click";
					break;
				case "select":
					//ToDo add throws UnexpectedTagNameException when element is not a SELECT   may be useless
					Select objSelect = new Select(Element.getInstance().element);
					objSelect.getOptions();
					int intOptionsLength = objSelect.getOptions().size();
					strOptions = Element.getInstance().element.getAttribute("innerHTML");
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
						Logger.getInstance().add("ElementSet strValueToSelect = " + strValueToSelect);
						break;
					case "<starts>":
						strKeywordValue = getKeywordValue(strInputValue);
						Logger.getInstance().add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						int intRightArrowPosition = strOptions.indexOf(">" + strKeywordValue);
						if (intRightArrowPosition > -1) {
							int intLeftArrowPosition = strOptions.indexOf("<", intRightArrowPosition);
							strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
						}
						Logger.getInstance().add("ElementSet: strKeywordValue2 " + strValueToSelect);
						Logger.getInstance().add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<ends>":
						strKeywordValue = getKeywordValue(strInputValue);
						Logger.getInstance().add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						int intMatchPosition = strOptions.indexOf(strKeywordValue + "<");
						intRightArrowPosition = strOptions.lastIndexOf(">", intMatchPosition);
						if (intRightArrowPosition > -1) {
							int intLeftArrowPosition = strOptions.indexOf("<", intRightArrowPosition);
							strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
						}
						Logger.getInstance().add("ElementSet: strValueToSelect " + strValueToSelect);
						Logger.getInstance().add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<contains>":
						int intStart = 0;
						strKeywordValue = getKeywordValue(strInputValue);
						Logger.getInstance().add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						int intKeywordCount = strOptions.length() - strOptions.replace(strKeywordValue, "").length();
						Logger.getInstance().add("ElementSet: intKeywordCount = " + intKeywordCount);
						for (int intTestInstanceEach = 0; intTestInstanceEach < intKeywordCount; intTestInstanceEach++) {
							Logger.getInstance().add("ElementSet: intStart = " + intStart);
							intMatchPosition = strOptions.indexOf(strKeywordValue, intStart);
							Logger.getInstance().add("ElementSet: intMatchPosition = " + intMatchPosition);
							intRightArrowPosition = strOptions.lastIndexOf(">", intMatchPosition);
							Logger.getInstance().add("ElementSet: intRightArrowPosition = " + intRightArrowPosition);
							if (intRightArrowPosition > -1) {
								int intLeftArrowPosition = strOptions.indexOf("<", intMatchPosition);
								Logger.getInstance().add("ElementSet: intLeftArrowPosition = " + intLeftArrowPosition);
								strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
							}
							Logger.getInstance().add("ElementSet: strValueToSelect = " + strValueToSelect);
							if (strValueToSelect.startsWith("<option")) {
								intStart = intMatchPosition + 1;
							} else {
								break;
							}
						}
						Logger.getInstance().add("ElementSet: strValueToSelect " + strValueToSelect);
						Logger.getInstance().add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<re>":
						//TODO add regex options
						break;
					default:
						break;
					}
					Logger.getInstance().add("ElementSet: strValueToSelect " + strValueToSelect);
					JSONS.getInstance().step.putValue("strInputValue", strValueToSelect);
					try {
						strStepExpected = "select";
						objSelect.selectByVisibleText(strValueToSelect);
					} catch (NoSuchElementException e) {
						//strStepActual = "notinlist";
						JSONS.getInstance().step.putValue("strStepActual", "notinlist");
						strOptionsList = optionsList(strOptions);
						JSONS.getInstance().step.putValue("strOutputValue", strOptionsList);
						Logger.getInstance().add("ElementSet: options list removeTags = " + strOptionsList);
						throw new ExceptionVisibleTextNotInSelectList(e.getMessage());
					}
					break;
				case "table":
					break;
				case "alert":
					switch (strAttributeValues) {
					case "edit":
						BrowserDriver.getInstance().browserDriver.switchTo().alert().sendKeys(strInputValue);
						strStepExpected = "set";
						break;
					case "accept":
						BrowserDriver.getInstance().browserDriver.switchTo().alert().accept();
						strStepExpected = "click";
						break;
					case "dismiss":
						BrowserDriver.getInstance().browserDriver.switchTo().alert().dismiss();
						strStepExpected = "click";
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strAttributeValues + " for the click event is not valid! Please us one of the following <edit>, <accept>, <dismiss>");
					}
					break;
				default:
					throw new ExceptionElementTagNameNotSupported("ElementSet: Element tag {" + strTagType + "} not supported");
				}
			} finally {
				JSONS.getInstance().step.putValue("strStepExpected", strStepExpected);
				Logger.getInstance().add("ElementSet: finally strStepExpected = " + strStepExpected);
				Logger.getInstance().add("ElementSet: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementSetJavascriptExecutor {
		private ElementSetJavascriptExecutor(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet, ExceptionKeywordNotValid {
			Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = JSONS.getInstance().step.getString("strInputValue");
			String strValueToSelect = "";
			String strAttributeValues = JSONS.getInstance().step.getLowerCase("strAttributeValues");
			String strTagType = JSONS.getInstance().step.getLowerCase("strTagType");
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
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
						objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(BrowserDriver.getInstance().browserDriver);
						objAction.moveToElement(Element.getInstance().element).doubleClick().build().perform();
						break;
					case "<rightclick>":
						//ToDo add right click code javascript
						Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
						action.contextClick(Element.getInstance().element).build().perform();
						// 			Actions action= new Actions(BrowserDriver.getInstance().browserDriver);
						// 			action.contextClick(Element.getInstance().element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
					// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor inputtext" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
					// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor focus" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '';", Element.getInstance().element);
					// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '" + strInputValue + "';", Element.getInstance().element);
					// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
					// Logger.getInstance().add("onchange blur");
					if (strOuterHTML.toLowerCase().contains("onchange")) {
						try {
							// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor strOuterHTML" + new DateTimestamp().get());
							objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
						} catch (WebDriverException e) {
							Logger.getInstance().add("ElementSetJavascriptExecutor = WebDriverException: " + e.toString());
						}
					}
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						JSONS.getInstance().step.putValue("strInputValue", "<on>");
						if (Element.getInstance().element.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
							objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
							objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
								} catch (WebDriverException e) {
									Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
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
						if (Element.getInstance().element.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
							objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
							objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
								} catch (WebDriverException e) {
									Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					case "<off>":
						if (Element.getInstance().element.isSelected() == true) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
							objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
							objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
								} catch (WebDriverException e) {
									Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					break;
				case "select":
					Select objSelect = new Select(Element.getInstance().element);
					objSelect.getOptions();
					objSelect.selectByVisibleText(strInputValue);
					// set_js
					// 		int intOptionsEach;
					// 		String strOptions = "";
					// 		String[] arrOptions;
					// 		strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", Element.getInstance().element);
					// 		strOptions = strOptions.substring(1);
					// 		arrOptions = strOptions.split("\\|");
					// 		for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					// 			 Logger.getInstance().add("ElementSetJavascriptExecutor: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					// 			if (arrOptions[intOptionsEach].toString().equals(JSONS.getInstance().step.get("strInputValue").toString())) {
					// 				blnSet = true;
					// 				Select objSelect = new Select(Element.getInstance().element);
					// 				objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
					// 				objSelect.selectByIndex(intOptionsEach);
					// 				objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
					// 				// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", Element.getInstance().element);
					// 				// if (strOuterHTML.toLowerCase().contains("onchange")) {
					// 				// try {
					// 				// objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
					// 				// } catch (WebDriverException e) {
					// 				//  Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
					// 				// }
					// 				// }
					// 				break;
					// 			}
					// 		}
					// 		intOptionsLength = objObject.Object.Options.All.Length
					// 		        ' switch based on keyword input
					// 		        Select Case LCase(strValueToSelect)
					// 		        Case "<blank>"
					// 		            strValueToSelect = ""
					// 		        Case "<first>"
					// 		            strValueToSelect = objObject.Object.Options.All.Item(0).Innertext
					// 		        Case "<second>"
					// 		            strValueToSelect = objObject.Object.Options.All.Item(1).Innertext
					// 		        Case "<third>"
					// 		            strValueToSelect = objObject.Object.Options.All.Item(2).Innertext
					// 		        Case "<last>"
					// 		            strValueToSelect = objObject.Object.Options.All.Item(intOptionsLength - 1).Innertext
					// 		        Case "<random>"
					// 		            intRandom = GenerateRandomNumberBetween(0, intOptionsLength - 1)
					// 		            strValueToSelect = objObject.Object.Options.All.Item(intRandom).Innertext
					// 		        End Select
					// 		        '  check if item is in the list
					// 		        '  loop until object value exists in the list or the intMillisecondsWaited value is exceeded
					// 		        Do Until CDbl(intMillisecondsWaited) > CDbl(intDefaultTimeOutMilliseconds)
					// 		            '            strAllItems = ""
					// 		            strAllItems = objObject.GetROProperty("all items")
					// 		            ' refresh object each loop if can be refreshed
					// 		            If blnShouldRefreshObject = True Then
					// 		                objObject.RefreshObject
					// 		            End If
					// 		            For intOptionsEach = 0 To intOptionsLength - 1
					// 		                If CStr(objObject.Object.Options.All.Item(intOptionsEach).Innertext) = CStr(strValueToSelect) Then
					// 		                    blnItemFound = True
					// 		                    gdtmStartTimeStep = Now
					// 		                    objObject.Select strValueToSelect
					// 		                    Exit For
					// 		                    '                    If strAllItems = "" Then
					// 		                    '                        strAllItems = objObject.Object.Options.All.Item(intOptionsEach).Innertext
					// 		                    '                    Else
					// 		                    '                        strAllItems = strAllItems & ";" & objObject.Object.Options.All.Item(intOptionsEach).Innertext
					// 		                    '                    End If
					// 		                End If
					// 		            Next
					// 		            If blnItemFound = True Then
					// 		                Exit Do
					// 		            End If
					// 		            ' wait within the loop 100 milliseconds to allow loop to check 10 times per second if object does not exist
					// 		            Wait 0, 100
					// 		            '  sets the intMillisecondsWaited variable to the number of milliseconds waited from the point when the intTimerStart was set
					// 		            intMilliseconds Waited = CDbl((Timer - intStartTime) * 1000)
					// 		        Loop
					// 		    End If    '===>   '   If blnEnabled = True Then
					// 		    '  report pass or fail based on the boolean variables set above
					// 		    If blnItemFound = True Then
					// 		        WebListSelect = True
					// 		        ReporterEventScreenShot micPass, strStep, "The selection of the  {" & strObjectToString & "} object with path {" & strObjectPath & "} item value {" & strValueToSelect & "} after {" & intMillisecondsWaited & "} milliseconds."
					// 		    ElseIf blnVisible = False Then
					// 		        WebListSelect = False
					// 		        ReporterEventScreenShot micFail, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is hidden."
					// 		        ReporterEventScreenShot micInfo, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is hidden after {" & intMillisecondsWaited & "} milliseconds."
					// 		    ElseIf blnEnabled = False Then
					// 		        WebListSelect = False
					// 		        ReporterEventScreenShot micFail, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is disabled."
					// 		        ReporterEventScreenShot micInfo, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is disabled after {" & intMillisecondsWaited & "} milliseconds."
					// 		    ElseIf blnItemFound = False Then
					// 		        WebListSelect = False
					// 		        ReporterEventScreenShot micFail, strStep, "The selection of the {" & strValueToSelect & "} object with path {" & strObjectPath & "} failed due to item not found in list.  The following is a list of all items: {" & strAllItems & "}"
					// 		        ReporterEventScreenShot micInfo, strStep, "The selection of the {" & strValueToSelect & "} object with path {" & strObjectPath & "} failed due to item not found in list.  The following is a list of all items: {" & strAllItems & "} after {" & intMillisecondsWaited & "} milliseconds."
					// 		    End If
					break;
				case "table":
					break;
				default:
					throw new ExceptionElementTagNameNotSupported("ElementSetJavascriptExecutor: Element tag {" + strTagType + "} not supported");
				}
			} finally {
				Logger.getInstance().add("ElementSetJavascriptExecutor: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementSetSync {
		private ElementSetSync(boolean blnJavascriptExecutor) {
			Logger.getInstance().add("  ==start==>ElementSetSync " + new DateTimestamp().get());
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
			String strActualResult = "";
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						if (Element.getInstance().element != null) {
							strOuterHTML = Element.getInstance().element.getAttribute("outerHTML");
							Logger.getInstance().add("ElementSetSync: " + strOuterHTML);
							Logger.getInstance().add("ElementSetSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
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
					switch (JSONS.getInstance().step.getLowerCase("strAssert")) {
					case "off":
						JSONS.getInstance().step.putValue("strStatus", "pass");
						if (blnSet == false) {
							new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
							JSONS.getInstance().step.putValue("strStatus", "pass");
							new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
						JSONS.getInstance().step.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
						JSONS.getInstance().step.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
						JSONS.getInstance().step.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
						JSONS.getInstance().step.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						blnStatus = true;
						break;
					}
					strActualResult = "set";
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					strActualResult = "not_found";
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					strActualResult = "not_enabled";
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					strActualResult = "tag_not_supported";
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionKeywordNotValid e) {
					blnExit = true;
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionVisibleTextNotInSelectList e) {
					blnSet = false;
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnAssert = false;
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnSet = false;
					blnSetSync = false;
					blnAssert = false;
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotSet e) {
					blnSet = false;
					blnAssert = false;
				} catch (ExceptionElementNotDisabled e) {
					blnAssert = false;
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionAlertNotComplete | ExceptionDoPostBackNotComplete | ExceptionJQueryAjaxNotComplete | ExceptionJQueryAnimationNotComplete | ExceptionAngularJsNotComplete | ExceptionPleaseWaitNotComplete e) {
					blnSetSync = false;
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnAssert = false;
					blnEnabled = false;
					blnFound = false;
					blnSet = false;
					blnSetSync = false;
					blnVisible = false;
					strActualResult = "exception";
					Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "elementSetSync", "set", lngTimeStart) == true) {
						if (blnStatus == false) {
							new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						}
						Logger.getInstance().add("elementSetSync: strOutputValue = " + JSONS.getInstance().step.getString("strOutputValue"));
						if (JSONS.getInstance().step.verifyEquals("strOutputValue", "")) {
							JSONS.getInstance().step.putValue("strOutputValue", JSONS.getInstance().step.getString("strInputValue"));
						}
						Logger.getInstance().add("elementSetSync: strOutputValue after = " + JSONS.getInstance().step.getString("strOutputValue"));
						return;
					}
				}
			}
		}
	}

	private class ElementSetSyncComplete {
		private ElementSetSyncComplete(String strOuterHTML) throws ExceptionAlertNotComplete, ExceptionDoPostBackNotComplete, ExceptionJQueryAjaxNotComplete, ExceptionJQueryAnimationNotComplete, ExceptionAngularJsNotComplete, ExceptionPleaseWaitNotComplete {
			Logger.getInstance().add("  ==start==>ElementSetSyncComplete " + new DateTimestamp().get());
			long lngTimeStart = System.currentTimeMillis();
			try {
				if (Config.getInstance().syncPleaseWait == false) {
					///SyncPleaseWait
					new SyncPleaseWait();
					Config.getInstance().syncPleaseWait = true;
				}
				// 	if (Config.getInstance().syncAlert == false) {
				// 		///SyncAlert
				// 		new SyncAlert();
				// 		Config.getInstance().syncAlert = true;
				// 	}
				if (Config.getInstance().syncWaitForReadyState == false) {
					///SyncWaitForReadyState
					new SyncWaitForReadyState();
					Config.getInstance().syncWaitForReadyState = true;
				}
				if (Config.getInstance().syncDoPostBack == false) {
					///SyncDoPostBack
					new SyncDoPostBack(strOuterHTML);
					Config.getInstance().syncDoPostBack = true;
				}
				if (Config.getInstance().syncJQueryAjax == false) {
					///SyncJQueryAjax
					new SyncJQueryAjax();
					Config.getInstance().syncJQueryAjax = true;
				}
				if (Config.getInstance().syncJQueryAnimation == false) {
					///SyncJQueryAnimation
					new SyncJQueryAnimation();
					Config.getInstance().syncJQueryAnimation = true;
				}
				if (Config.getInstance().syncAngularJs == false) {
					///SyncAngularJs
					new SyncAngularJs();
					Config.getInstance().syncAngularJs = true;
				}
			} finally {
				Logger.getInstance().add("ElementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
			}
		}
	}

	private class ElementTooltipGet {
		private String run() {
			String strHandle = "";
			//new SleepMilliseconds(2000);
			//WebElement objWebElement = objWebDriver.findElement(By.id("tooltipID"));
			// System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
			// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			// System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
			// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("This is the tip"));
			// $oIE = _IECreate("about:blank")
			// 		$hWnd = _IEPropertyGet($oIE, "hwnd")
			// 		$aPos = WinGetPos( ControlGetHandle($hWnd, "", "[CLASS:Internet Explorer_Server; INSTANCE:1]") )
			// 		MouseMove($aPos[0], $aPOs[1])
			//
			System.out.println("winGetHandle: = " + objAutoItSetObject.objAutoIt.winGetHandle("[CLASS:Chrome_WidgetWin_1]"));
			strHandle = objAutoItSetObject.objAutoIt.controlGetHandle("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]");
			System.out.println("strHandle = " + strHandle);
			// WinDef.HWND strHandleChrome = (HWND(objAutoItSetObject.objAutoIt.controlGetHandle("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
			// System.out.println("strHandleChrome = " + strHandleChrome);
			//WinDef.RECT rectChrome = new WinDef.RECT();
			// User32.INSTANCE.GetWindowRect(strHandleChrome, rectChrome);
			// System.out.println("winGetPosX: = " + rectChrome.left);
			// System.out.println("winGetPosY: = " + rectChrome.top);
			System.out.println("controlGetPosX: = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
			System.out.println("controlGetPosY: = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
			System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
			System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
			System.exit(0);
			//
			//String strHandle =objAutoItSetObject.objAutoIt.controlGetHandle("[CLASS:Internet Explorer_Server; INSTANCE:1]", "", null);
			strHandle = objAutoItSetObject.objAutoIt.winGetHandle("changed");
			System.out.println("winGetClientSizeHeight: = " + objAutoItSetObject.objAutoIt.winGetClientSizeHeight("changed"));
			System.out.println("winGetClientSizeWidth: = " + objAutoItSetObject.objAutoIt.winGetClientSizeWidth("changed"));
			System.out.println("winGetHandle: = " + objAutoItSetObject.objAutoIt.winGetHandle("changed"));
			System.out.println("winGetPosHeight: = " + objAutoItSetObject.objAutoIt.winGetPosHeight("changed"));
			System.out.println("winGetPosWidth: = " + objAutoItSetObject.objAutoIt.winGetPosWidth("changed"));
			System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX("changed"));
			System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY("changed"));
			System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle("[CLASS:IEFrame]"));
			System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle("[HANDLE:0x0001069A]"));
			//String strHandle = objAutoItSetObject.objAutoIt.winGetHandle("[CLASS:IEFrame]");
			System.out.println("strHandle = " + strHandle);
			strHandle = "[CLASS:IEFrame]";
			System.out.println("strHandle = " + strHandle);
			System.out.println("winGetPosHeight: = " + objAutoItSetObject.objAutoIt.winGetPosHeight(strHandle));
			System.out.println("winGetPosWidth: = " + objAutoItSetObject.objAutoIt.winGetPosWidth(strHandle));
			System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
			System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
			System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle(strHandle));
			System.out.println("winGetClientSizeHeight = " + objAutoItSetObject.objAutoIt.winGetClientSizeHeight(strHandle));
			System.out.println("winGetClientSizeWidth = " + objAutoItSetObject.objAutoIt.winGetClientSizeWidth(strHandle));
			//System.out.println("winGetClientSizeWidth = " + objAutoItSetObject.objAutoIt.winGetCaretPosX(strHandle));
			///This works for control place Class in the last position
			strHandle = "[CLASS:Internet Explorer_Server; INSTANCE:1]";
			//strHandle=	"[CLASS:Internet Explorer_Server]";
			System.out.println("strHandle = " + strHandle);
			System.out.println("controlGetPosHeight = " + objAutoItSetObject.objAutoIt.controlGetPosHeight("", "", strHandle));
			System.out.println("controlGetPosWidth = " + objAutoItSetObject.objAutoIt.controlGetPosWidth("", "", strHandle));
			System.out.println("controlGetPosX = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", strHandle));
			System.out.println("controlGetPosY = " + objAutoItSetObject.objAutoIt.controlGetPosY("", "", strHandle));
			System.out.println("controlGetHandle = " + objAutoItSetObject.objAutoIt.controlGetHandle("", "", strHandle));
			System.out.println("winGetPosHeight = " + objAutoItSetObject.objAutoIt.winGetPosHeight(strHandle));
			System.out.println("winGetPosWidth = " + objAutoItSetObject.objAutoIt.winGetPosWidth(strHandle));
			System.out.println("winGetPosX = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
			System.out.println("winGetPosY = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
			System.exit(0);
			Actions ToolTip1 = new Actions(BrowserDriver.getInstance().browserDriver);
			ToolTip1.moveToElement(Element.getInstance().element).build().perform();
			for (int intKeysEach = 0; intKeysEach < 10; intKeysEach++) {
				System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
				new SleepMilliseconds(500);
			}
			//ToolTip1.clickAndHold(Element.getInstance().element).build().perform();
			//Actions.moveToElement(Element.getInstance().element).build().clickAndHold()
			// System.out.println(objWebElement.getLocation().getX());
			// System.out.println(objWebElement.getLocation().getY());
			// System.out.println(objWebElement.getSize().width);
			// System.out.println(objWebElement.getSize().height);
			//System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
			new SleepMilliseconds(3000);
			// String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("This is a tooltip", "", "");
			// System.out.println(">>>>>>>>>>>>>>>>>");
			// System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText controlGetText value is: " + strToolTipAutoItText);
			// System.out.println(">>>>>>>>>>>>>>>>>");
			// System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
			// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			// if (objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]")) {
			// 	System.out.println("winExists yes");
			// }
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
			Dimension objWebDriverDimension = Element.getInstance().element.getSize();
			int intBrowserOuterWidth = objWebDriverDimension.width;
			int intBrowserOuterHeight = objWebDriverDimension.height;
			System.out.println(-((intBrowserOuterWidth / 2) + 1));
			System.out.println(-((intBrowserOuterHeight / 2) + 1));
			/////ToolTip1.moveByOffset(-((intBrowserOuterWidth / 2) + 1), -((intBrowserOuterHeight / 2) + 1)).build().perform();
			//ToolTip1.moveByOffset(-intBrowserOuterWidth + 1, -intBrowserOuterHeight + 1).build().perform();
			String ToolTipTitleText = Element.getInstance().element.getAttribute("title");
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
			Logger.getInstance().add("  ==start==>ElementGetSync " + new DateTimestamp().get());
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
						JSONS.getInstance().step.putValue("strOutputValue", strGetValue);
						blnGet = true;
					}
					blnStatus = true;
					// 	} catch (ExceptionElementTagNameNotSupported e) {
					// 		blnExit = true;
					// 		 Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementGetSync", "get", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			Logger.getInstance().add("  ==start==>ElementVerifyNotValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = JSONS.getInstance().step.getString("strInputValue");
			try {
				strGetValue = new ElementGet().run();
				strActualValue = new VerifyNotMatch().run(strGetValue, strValueExpected);
				Logger.getInstance().add("ElementVerifyNotValue: after VerifyNotMatch");
			} catch (ExceptionValueMatched e) {
				Logger.getInstance().add("ElementVerifyNotValue: " + e.toString());
				throw new ExceptionValueMatched("ElementVerifyNotValue: Exception strActualValue = {" + strActualValue + "}");
			} finally {
				Logger.getInstance().add("ElementVerifyNotValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	private class ElementVerifyNotValueSync {
		private ElementVerifyNotValueSync() {
			Logger.getInstance().add("  ==start==>ElementVerifyNotValueSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVerifiedNot = false;
			Boolean blnVisible = false;
			String strActualValue = "";
			String strActualResult = "";
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
					strActualResult = "verify_not";
					blnStatus = true;
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					strActualResult = "tag_not_supported";
					Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueMatched e) {
					strActualResult = "not_verify_not";
					Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					strActualResult = "exception";
					Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementVerifyNotValueSync", "verify_not", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			Logger.getInstance().add("  ==start==>ElementVerifyValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = JSONS.getInstance().step.getString("strInputValue");
			try {
				strGetValue = new ElementGet().run();
				strActualValue = new VerifyMatch().run(strGetValue, strValueExpected);
			} finally {
				Logger.getInstance().add("ElementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	private class ElementVerifyValueSync {
		private ElementVerifyValueSync() {
			Logger.getInstance().add("  ==start==>ElementVerifyValueSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVerified = false;
			Boolean blnVisible = false;
			String strActualValue = "";
			String strActualResult = "";
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
					strActualResult = "verify_value";
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					blnVerified = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					strActualResult = "tag_not_supported";
					Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnVerified = false;
					strActualResult = "not_verified";
					Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnVerified = false;
					strActualResult = "exception";
					Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "elementVerifyValueSync", "verify", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
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
			Logger.getInstance().add("  ==start==>ElementVisible " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnVisible = false;
			try {
				// TODO Alert complete
				if (JSONS.getInstance().step.verifyEquals("strTagName", "title")) {
					blnVisible = true;
					return;
				}
				if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == true) {
						blnVisible = true;
						JSONS.getInstance().step.putValue("strHighlightArea", "alert");
						new CoordinatesAlert();
						return;
					} else {
						throw new ExceptionElementNotVisible("Alert popup was not found.");
					}
				}
				if (Element.getInstance().element.isDisplayed()) {
					new CoordinatesElement();
					blnVisible = true;
					return;
					// if (JSONS.getInstance().step.containsKey("intElementWidth")) {
					// int intElementWidth = Integer.parseInt(JSONS.getInstance().step.get("intElementWidth").toString());
					// int intElementHeight = Integer.parseInt(JSONS.getInstance().step.get("intElementHeight").toString());
					//  Logger.getInstance().add("elementVisible intElementWidth = " + intElementWidth);
					//  Logger.getInstance().add("elementVisible intElementHeight = " + intElementHeight);
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
				Logger.getInstance().add("ElementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementVisibleSync {
		private ElementVisibleSync() {
			Logger.getInstance().add("  ==start==>ElementVisibleSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			String strActualResult = "";
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
					strActualResult = "sync_visible";
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					strActualResult = "not_found";
					Logger.getInstance().add("ElementVisibleSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					strActualResult = "not_visible";
					Logger.getInstance().add("ElementVisibleSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					JSONS.getInstance().step.putValue("strStepActual", strActualResult);
					if (syncFinally(blnExit, blnStatus, blnFound, "ElementVisibleSync", "syncvisible", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						return;
					} else {
						blnVisible = false;
					}
				}
			}
		}
	}

	//https://howtodoinjava.com/java/exception-handling/best-practices-for-for-exception-handling/
	class ExceptionAlertNotComplete extends Exception {
		static final long serialVersionUID = 1L;

		ExceptionAlertNotComplete(String message) {
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

	class ExceptionJSONKeyNotPresent extends Exception {
		private static final long serialVersionUID = 1L;

		ExceptionJSONKeyNotPresent(String message) {
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
			Logger.getInstance().add("  ==start==>ImageDecodeFromString " + new DateTimestamp().get());
			BufferedImage objBufferedImage = null;
			byte[] arrImageByte;
			try {
				arrImageByte = Base64.getDecoder().decode(strImageString);
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
			Logger.getInstance().add("  ==start==>ImageEncodeToString " + new DateTimestamp().get());
			String strImageString = null;
			ByteArrayOutputStream objByteArrayOutputStreams = new ByteArrayOutputStream();
			try {
				ImageIO.write(objBufferedImage, strImageType, objByteArrayOutputStreams);
				byte[] arrImageByte = objByteArrayOutputStreams.toByteArray();
				strImageString = Base64.getEncoder().encodeToString(arrImageByte);
				objByteArrayOutputStreams.close();
			} catch (Exception e) {
				e.toString();
			}
			return strImageString.toString();
		}
	}

	private class InternetExplorerProcessKill {
		private InternetExplorerProcessKill() {
			Logger.getInstance().add("  ==start==>InternetExplorerProcessKill " + new DateTimestamp().get());
			DesiredCapabilities desiredCapabilities = null;
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setJavascriptEnabled(true);
			System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
			BrowserDriver.getInstance().browserDriver = new InternetExplorerDriver(desiredCapabilities);
			BrowserDriver.getInstance().browserDriver.get("about:blank");
			BrowserDriver.getInstance().browserDriver.manage().deleteCookieNamed("JSESSIONID");
			// BrowserDriver.getInstance().browserDriver.navigate().to(JSONS.getInstance().step.get("strInputValue").toString());
			// BrowserDriver.getInstance().browserDriver.manage().window().maximize();
			// BrowserDriver.getInstance().browserDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			// // BrowserDriver.getInstance().browserDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
			BrowserDriver.getInstance().browserDriver.close();
			BrowserDriver.getInstance().browserDriver.quit();
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			new WindowsProcessKill("taskkill /F /IM IEDriverServer_32.exe");
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
			Logger.getInstance().add("  ==start==>InternetExplorerVersion " + new DateTimestamp().get());
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
					Logger.getInstance().add(strFullRegistryKey.replaceAll("\\s+", " ").trim());
					Logger.getInstance().add(strActualKeyValue);
				}
			}
		}
	}

	private class JvmBitVersion {
		private String get() {
			String strJvmBitVersion = System.getProperty("sun.arch.data.model");
			Logger.getInstance().add("JvmBitVersion: System.getProperty(sun.arch.data.model) = " + strJvmBitVersion + " " + new DateTimestamp().get());
			return strJvmBitVersion;
		}
	}

	private class KeywordsValid {
		//TODO KeywordsValid to check all
		private String[] arrKV_strLogicalName = { "<te>" };
		private String[] arrKV_strAttributeValues = { "<contains>", "<starts>", "<td>", "<ti>", "<tl>" };
		private String[] arrKV_strInputValue = { "<re>", "<td>", "<ti>", "<tl>", "<click>", "<doubleclick>", "<rightclick>", "<on>", "<off>", "<blank>", "<first>", "<second>", "<third>", "<last>", "<random>", "<contains>", "<ends>", "<starts>", "<skip>" };
		private String[] arrKV_strLoopOrIf = { "<if>", "<elseif>", "<else>", "<endif>", "<loopstart>", "<loopexit>", "<loopend>" };
		private String[] arrResults;
		private String strInputValueFromJson = "";
		private String strKeywordEach = "";
		private String strKeywordValue = "";

		private KeywordsValid() {
			String[] arrKeys = new StepNames().getOriginal();
			boolean blnValid = false;
			String[] arrKeywordsValid;
			Config.getInstance().originalAttributes = createObjectName();
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
					this.getKeywordsAndValue(JSONS.getInstance().step.getString(strKey));
					// 		if (arrResults.length > 0) {
					// 			JSONS.getInstance().step.putValue("strStatus", "fail");
					// 			JSONS.getInstance().step.putValue("blnExitOnFail", "true");
					// 		}
					break;
				case "strLogicalName":
					this.getKeywordsAndValue(JSONS.getInstance().step.getString(strKey));
					for (String strResultsEach : arrResults) {
						for (String strKeywordsValidEach : arrKV_strLogicalName) {
							if (strResultsEach.equals(strKeywordsValidEach)) {
								blnValid = true;
								JSON objJsonObjectElementNode = new JSON(JSONS.getInstance().element.getNode(strKeywordValue));
								try {
									JSONS.getInstance().step.putValue("strTagName", objJsonObjectElementNode.getValue("strTagName", ""));
									JSONS.getInstance().step.putValue("strAttributeNames", objJsonObjectElementNode.getValue("strAttributeNames", ""));
									JSONS.getInstance().step.putValue("strAttributeValues", objJsonObjectElementNode.getValue("strAttributeValues", ""));
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
					String arrAttributeValues[] = JSONS.getInstance().step.getString(strKey).split("\\|", -1);
					for (String strAttributeValuesEach : arrAttributeValues) {
						this.getKeywordsAndValue(strAttributeValuesEach);
						for (String strResultsEach : arrResults) {
							// Logger.getInstance().add("strResultsEach = " + strResultsEach);
							// Logger.getInstance().add("strKeywordValue = " + strKeywordValue);
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
					JSONS.getInstance().step.putValue("strAttributeValues", strKeywordValueCombined);
					break;
				case "strInputValue":
					Config.getInstance().originalInputValue = JSONS.getInstance().step.getString(strKey);
					this.getKeywordsAndValue(JSONS.getInstance().step.getString(strKey));
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
					Logger.getInstance().add("KeywordsValid: blnValid = " + blnValid);
					JSONS.getInstance().step.putValue("strInputValue", strKeywordValue);
					// Logger.getInstance().add("strKeywordValue = " + strKeywordValue);
					// Logger.getInstance().add("strInputValueFromJson = " + strInputValueFromJson);
					break;
				case "strLoopOrIf":
					break;
				}
			}
		}

		private void getJsonValue(String strKeyword, String strInputValue) {
			Logger.getInstance().add("getJsonValue strKeyword = " + strKeyword);
			Logger.getInstance().add("getJsonValue strInputValue = " + strInputValue);
			try {
				switch (strKeyword) {
				case "<td>":
					strInputValueFromJson = JSONS.getInstance().testData.getValue(strInputValue, "<td>");
					break;
				case "<ti>":
					strInputValueFromJson = JSONS.getInstance().testInstancesEach.getValue(strInputValue, "<ti>");
					break;
				case "<tl>":
					strInputValueFromJson = JSONS.getInstance().links.getValue(strInputValue, "<tl>");
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
				Logger.getInstance().add("StepSetupDefaults: Exception = " + e.toString());
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
					if (strKeyword.equals("<re>") || strKeyword.equals("<contains>") || strKeyword.equals("<starts>")) {
						strKeywordValue = strKeyword + strKeywordValue;
					}
					Logger.getInstance().add("getKeywordsAndValue strKeyword = " + strKeyword);
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

	private class MonthGet {
		private String run(int month) {
			Logger.getInstance().add("  ==start==>MonthGet " + new DateTimestamp().get());
			return new DateFormatSymbols().getMonths()[month];
		}
	}

	//	private class OperatingSystem {
	//		private String strOS = "";
	//
	//		private OperatingSystem() {
	//			Logger.getInstance().add("  ==start==>OperatingSystem " + new DateTimestamp().get());
	//			strOS = System.getProperty("os.name").toLowerCase();
	//			if (strOS.contains("win")) {
	//				strOS = "Windows";
	//			} else if (strOS.contains("nux") || strOS.contains("nix")) {
	//				strOS = "Linux";
	//			} else if (strOS.contains("mac")) {
	//				strOS = "Mac";
	//			} else if (strOS.contains("sunos")) {
	//				strOS = "Solaris";
	//			} else {
	//				strOS = "Other";
	//			}
	//		}
	//	}
	class ProcessKillInternetExplorer {
		void run() {
			Logger.getInstance().add("  ==start==>ProcessKillInternetExplorer " + new DateTimestamp().get());
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			new WindowsProcessKill("taskkill /F /IM IEDriverServer_32.exe");
		}
	}

	private class RectangleAreaByName {
		private RectangleAreaByName(Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
			Logger.getInstance().add("  ==start==>RectangleAreaByName " + new DateTimestamp().get());
			Logger.getInstance().add("RectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
			long lngStartTime = System.currentTimeMillis();
			int intX = 0;
			int intY = 0;
			int intWidth = 0;
			int intHeight = 0;
			if (strAreaObjectName.equals("")) {
				if (BrowserDriver.getInstance().browserDriver == null) {
					strAreaObjectName = "screen";
				}
				if (Element.getInstance().element == null) {
					if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
						strAreaObjectName = "element";
					} else {
						strAreaObjectName = "screen";
					}
				} else {
					if (JSONS.getInstance().step.containsKey("intElementScreenX") == false) {
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
					intX = JSONS.getInstance().step.getInt("intBrowserOuterX");
					intY = JSONS.getInstance().step.getInt("intBrowserOuterY");
					intWidth = JSONS.getInstance().step.getInt("intBrowserOuterWidth");
					intHeight = JSONS.getInstance().step.getInt("intBrowserOuterHeight");
					break;
				case "page":
					// TODO change this to get absolute screen coordinates
					WebElement objWebElementPage = BrowserDriver.getInstance().browserDriver.findElement(By.xpath("//body"));
					intX = objWebElementPage.getLocation().getX() - intThickness;
					intY = objWebElementPage.getLocation().getY() - intThickness;
					intWidth = objWebElementPage.getSize().width + (2 * intThickness);
					intHeight = objWebElementPage.getSize().height + (2 * intThickness);
					break;
				case "element":
				case "alert":
					intX = JSONS.getInstance().step.getInt("intElementScreenX") - intThickness;
					intY = JSONS.getInstance().step.getInt("intElementScreenY") - intThickness;
					intWidth = JSONS.getInstance().step.getInt("intElementWidth") + (2 * intThickness);
					intHeight = JSONS.getInstance().step.getInt("intElementHeight") + (2 * intThickness);
					break;
				default:
					Logger.getInstance().add("RectangleAreaByName: epected values = screen, window, page and element not " + strAreaObjectName);
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
				Logger.getInstance().add("RectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class RegularExpressionMatch {
		private String run(String strPattern, String strActualValue) throws ExceptionValueNotMatched {
			Boolean blnMatched = false;
			Long lngStartTime = System.currentTimeMillis();
			Logger.getInstance().add("  ==start==>RegularExpressionMatch " + new DateTimestamp().get());
			String strMatchedString = "";
			try {
				Matcher objMatcher = Pattern.compile(strPattern).matcher(strActualValue);
				objMatcher.matches();
				strMatchedString = objMatcher.group(0);
				blnMatched = true;
				return strMatchedString;
			} catch (Exception e) {
				Logger.getInstance().add("RegularExpressionMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("RegularExpressionMatch: Exception " + e.toString());
			} finally {
				Logger.getInstance().add("RegularExpressionMatch: finally Matched = {" + blnMatched + "} strMatchedString = {" + strMatchedString + "} strPattern = {" + strPattern + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ScrollToBottom {
		private ScrollToBottom() {
			Logger.getInstance().add("  ==start==>ScrollToBottom " + new DateTimestamp().get());
			// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
			JavascriptExecutor executor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		}
	}

	private class Sleep {
		private Sleep() {
			new SleepMilliseconds(JSONS.getInstance().step.getInt("strInputValue"));
		}
	}

	class SleepMilliseconds {
		SleepMilliseconds(int intMillisecondsToWait) {
			// Logger.getInstance().add("  ==start==>SleepMilliseconds " + new DateTimestamp().get());
			try {
				TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
				JSONS.getInstance().step.putValue("strStatus", "pass");
			} catch (Exception e) {
				JSONS.getInstance().step.putValue("strStatus", "fail");
				Logger.getInstance().add("SleepMilliseconds: Exception = " + e.toString());
			}
		}
	}

	private class SleepSync {
		private SleepSync() {
			Long lngTimeStart = System.currentTimeMillis();
			new Sleep();
			JSONS.getInstance().step.putValue("strStepActual", "sleep");
			stepDuration("SleepSync", lngTimeStart, "sleep");
		}
	}

	public class StepNames {
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

		String[] getOriginal() {
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

	private class SyncAlert {
		private SyncAlert() throws ExceptionAlertNotComplete {
			Logger.getInstance().add("  ==start==>SyncAlert " + new DateTimestamp().get());
			if (new AlertFind().run() == true) {
				throw new ExceptionAlertNotComplete("");
			}
		}
	}

	private class SyncAngularJs {
		private SyncAngularJs() throws ExceptionAngularJsNotComplete {
			Logger.getInstance().add("  ==start==>SyncAngularJs " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (window.angular != null);");
				Logger.getInstance().add("SyncAngularJs: = " + blnAngularJs);
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				if (lngAngularJsInjectorActive > 0) {
					throw new ExceptionAngularJsNotComplete("");
				}
			} catch (Exception e) {
				Logger.getInstance().add("SyncAngularJs: AngularJS Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("SyncAngularJs: lngAngularJsInjectorActive = " + lngAngularJsInjectorActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncDoPostBack {
		private SyncDoPostBack(String strOuterHTML) throws ExceptionDoPostBackNotComplete {
			Logger.getInstance().add("  ==start==>SyncDoPostBack " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				try {
					Logger.getInstance().add("SyncDoPostBack: __EVENTTARGET value = " + BrowserDriver.getInstance().browserDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !BrowserDriver.getInstance().browserDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
					if (blnEventTarget == true) {
						throw new ExceptionDoPostBackNotComplete("");
					}
				} catch (Exception e) {
					Logger.getInstance().add("SyncDoPostBack: Exception = " + e.toString());
				} finally {
					Logger.getInstance().add("SyncDoPostBack: blnEventTarget = " + blnEventTarget + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				}
			}
		}
	}

	private class SyncJQueryAjax {
		private SyncJQueryAjax() throws ExceptionJQueryAjaxNotComplete {
			Logger.getInstance().add("  ==start==>SyncJQueryAjax " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				blnJquery = (boolean) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (jQuery.active);");
					Logger.getInstance().add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive);
					if (lngJqueryActive > 0) {
						throw new ExceptionJQueryAjaxNotComplete("");
					}
				}
			} catch (Exception e) {
				Logger.getInstance().add("SyncJQueryAjax: JqueryActive Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncJQueryAnimation {
		private SyncJQueryAnimation() throws ExceptionJQueryAnimationNotComplete {
			Logger.getInstance().add("  ==start==>SyncJQueryAnimation " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			long lngElementsAnimated = 0;
			boolean blnJqueryExist = false;
			try {
				blnJqueryExist = (boolean) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (window.jQuery != null);");
				if (blnJqueryExist == true) {
					lngElementsAnimated = (long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return $(\":animated\").length");
				}
				if (lngElementsAnimated > 0) {
					throw new ExceptionJQueryAnimationNotComplete("");
				}
			} catch (Exception e) {
				Logger.getInstance().add("SyncJQueryAnimation: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("SyncJQueryAnimation: lngElementsAnimated = " + lngElementsAnimated + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncPleaseWait {
		private SyncPleaseWait() throws ExceptionDoPostBackNotComplete {
			long lngStartTime = System.currentTimeMillis();
			Logger.getInstance().add("  ==start==>SyncPleaseWait " + new DateTimestamp().get());
			try {
				new ElementPleaseWaitSync();
			} catch (ExceptionElementNotHidden e1) {
				Logger.getInstance().add("SyncPleaseWait: ExceptionElementNotHidden = " + e1.toString());
				throw new ExceptionDoPostBackNotComplete("");
			} catch (Exception e) {
				Logger.getInstance().add("SyncPleaseWait: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("SyncPleaseWait: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
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
			Logger.getInstance().add("  ==start==>SyncWaitForReadyState " + new DateTimestamp().get());
			try {
				new WaitForReadyState().run();
			} catch (Exception e) {
				Logger.getInstance().add("SyncWaitForReadyState: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("SyncWaitForReadyState: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class TestConfigurationSetup {
		private int intTestInstanceSize;
		private JSON objJsonObjectTestConfigurationFile = new JSON();

		@SuppressWarnings("unchecked")
		private JSONArray putAllArrays(String strJsonArrayName, String strJsonObjectName, String strPath) {
			int intJsonArrayEach = 0;
			JSONArray objJsonArray = null;
			JSONArray objJsonArrayEach = null;
			JSONArray objJsonArrayList = null;
			JSON objJsonObjectFileEach = new JSON();
			String strFileNameEach = "";
			String strFilePathJsonArray = "";
			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.getArray(strJsonArrayName);
			if (objJsonArrayList == null) {
				// if (objJsonArrayList.size() == 0) ||  (objJsonArrayList() == null){
				return null;
			} else {
				for (intJsonArrayEach = 0; intJsonArrayEach < objJsonArrayList.size(); intJsonArrayEach++) {
					strFileNameEach = objJsonArrayList.get(intJsonArrayEach).toString();
					strFilePathJsonArray = strPath + strFileNameEach;
					Logger.getInstance().add("TestConfigurationSetup:putAllArrays strFilePathJsonArray = " + strFilePathJsonArray);
					try {
						objJsonObjectFileEach.replaceAllFromFile(strFilePathJsonArray);
						objJsonArrayEach = (JSONArray) objJsonObjectFileEach.getArray(strJsonObjectName);
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
						Logger.getInstance().add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
						e.printStackTrace();
					}
					if (intJsonArrayEach == 0) {
						objJsonArray = objJsonArrayEach;
					} else {
						objJsonArray.addAll(objJsonArrayEach);
					}
				}
			}
			Logger.getInstance().add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
			return objJsonArray;
		}

		@SuppressWarnings("unchecked")
		private JSON putAllObjects(String strJsonArrayName, String strJsonObjectName, String strPath) {
			Logger.getInstance().add("  ==start==>putAllObjects " + new DateTimestamp().get());
			Integer intJsonObjectEach = 0;
			JSONArray objJsonArrayList = null;
			JSON objJsonObject = new JSON();
			JSON objJsonObjectEach = new JSON();
			JSON objJsonObjectFileEach = new JSON();
			String strFileNameEach = "";
			String strFilePathJsonArray = "";
			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.getArray(strJsonArrayName);
			//			if (objJsonArrayList == null) {
			//				Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonArrayList.size() = NULL" );
			//				return objJsonObject;
			//			}
			Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonArrayList.size() " + objJsonArrayList.size());
			for (intJsonObjectEach = 0; intJsonObjectEach < objJsonArrayList.size(); intJsonObjectEach++) {
				strFileNameEach = objJsonArrayList.get(intJsonObjectEach).toString();
				Logger.getInstance().add("TestConfigurationSetup:putAllObjects strFileNameEach " + strFileNameEach);
				strFilePathJsonArray = strPath + strFileNameEach;
				Logger.getInstance().add("TestConfigurationSetup:putAllObjects strFilePathJsonArray = " + strFilePathJsonArray);
				try {
					objJsonObjectFileEach.replaceAllFromFile(strFilePathJsonArray);
					Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonObjectFileEach = " + objJsonObjectFileEach);
					objJsonObjectEach.replaceAllFromMap((Map<String, String>) objJsonObjectFileEach.getArray(strJsonObjectName));
					Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonObjectEach = " + objJsonObjectEach);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				objJsonObject.replaceAllFromJSONObject(objJsonObjectEach.jSONObject);
			}
			Logger.getInstance().add("TestConfigurationSetup:putAllObjects objJsonObject = " + objJsonObject);
			return objJsonObject;
		}

		private void run(String strFileNameTestConfiguration) {
			// TODO complete TestConfigurationSetup method to create json objects for test
			Logger.getInstance().add("  ==start==>TestConfigurationSetup " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strFilePathTestConfiguration = "";
			try {
				strFilePathTestConfiguration = Path.getInstance().testConfiguration + strFileNameTestConfiguration;
				Logger.getInstance().add("TestConfigurationSetup: strPathTestConfiguration = " + strFilePathTestConfiguration);
				objJsonObjectTestConfigurationFile.replaceAllFromFile(strFilePathTestConfiguration);
				Logger.getInstance().add("TestConfigurationSetup: objJsonObjectTestConfigurationFile = " + objJsonObjectTestConfigurationFile.toJSONString());
				// test_instances
				Logger.getInstance().add("TestConfigurationSetup: test_instances");
				if (this.putAllArrays("test_instances", "test_instances", Path.getInstance().testInstances) == null) {
					JSONS.getInstance().testInstances = null;
					intTestInstanceSize = 0;
				} else {
					JSONS.getInstance().testInstances = this.putAllArrays("test_instances", "test_instances", Path.getInstance().testInstances);
					intTestInstanceSize = JSONS.getInstance().testInstances.size();
				}
				// test_elements
				Logger.getInstance().add("TestConfigurationSetup: test_elements");
				JSONS.getInstance().element = this.putAllObjects("test_elements", "elements", Path.getInstance().testElements);
				// processing
				Logger.getInstance().add("TestConfigurationSetup: processing");
				JSONS.getInstance().processing = this.putAllObjects("test_elements", "processing", Path.getInstance().testElements);
				// test_modules
				Logger.getInstance().add("TestConfigurationSetup: test_modules");
				JSONS.getInstance().testSteps = this.putAllArrays("test_modules", "steps", Path.getInstance().testModules);
				Logger.getInstance().add("TestConfigurationSetup: JSONS.getInstance().testSteps.toString = " + JSONS.getInstance().testSteps.toString());
				// TODO add error handling, report no test modules and fail
				// test_links
				JSONS.getInstance().links.parseString("{\"link\":[{}]}");
				// test_data
				Logger.getInstance().add("TestConfigurationSetup: test_data");
				JSONS.getInstance().testData = this.putAllObjects("test_data", "test_data", Path.getInstance().testData);
			} catch (Exception e) {
				Logger.getInstance().add("TestConfigurationSetup: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("TestConfigurationSetup: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class VerifyMatch {
		private String run(String strActual, String strExpected) throws ExceptionValueNotMatched {
			Logger.getInstance().add("  ==start==>VerifyMatch " + new DateTimestamp().get());
			Logger.getInstance().add("VerifyMatch strActual = " + strActual);
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
				Logger.getInstance().add("VerifyMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("VerifyMatch: Exception " + e.toString());
			} finally {
				Logger.getInstance().add("VerifyMatch: finally Matched = {" + blnMatched + "} strActual = {" + strActual + "} strExpected = {" + strExpected + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class VerifyNotMatch {
		private String run(String strActual, String strExpected) throws ExceptionValueMatched {
			Logger.getInstance().add("  ==start==>VerifyNotMatch " + new DateTimestamp().get());
			Boolean blnMatched = false;
			long lngStartTime = System.currentTimeMillis();
			String strMatchedValue = "";
			try {
				if (strExpected.toLowerCase().startsWith("<re>")) {
					String strPattern = strExpected.substring(4);
					try {
						strMatchedValue = new RegularExpressionMatch().run(strPattern, strActual);
					} catch (Exception e) {
						Logger.getInstance().add("VerifyNotMatch: Exception " + e.toString());
						return strMatchedValue;
					}
					blnMatched = true;
					Logger.getInstance().add("VerifyNotMatch: before throw blnMatched = " + blnMatched);
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
				Logger.getInstance().add("VerifyNotMatch: finally Matched = {" + blnMatched + "} strExpected = {" + strExpected + "} strActual = {" + strActual + "} strMatchedValue = {" + strMatchedValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class WaitForAngularRequestsToFinish {
		private WaitForAngularRequestsToFinish(JavascriptExecutor objDriver) {
			Logger.getInstance().add("  ==start==>WaitForAngularRequestsToFinish " + new DateTimestamp().get());
			objDriver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
		}
	}

	private class WaitForReadyState {
		private boolean run() {
			Logger.getInstance().add("  ==start==>WaitForReadyState " + new DateTimestamp().get());
			Logger.getInstance().add("waitForReadyState: document.readyState Milliseconds Waited = " + ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return document.readyState"));
			return false;
		}
	}

	private class WebElementAttributes {
		private WebElementAttributes() {
			Logger.getInstance().add("  ==start==>WebElementAttributes " + new DateTimestamp().get());
			Logger.getInstance().add("text:=  " + Element.getInstance().element.getTagName());
			Logger.getInstance().add("tag_type:=  " + Element.getInstance().element.getTagName() + "_" + Element.getInstance().element.getAttribute("type"));
			Logger.getInstance().add("TagName:=  " + Element.getInstance().element.getAttribute("TagName"));
			Logger.getInstance().add("type:=  " + Element.getInstance().element.getAttribute("type"));
			Logger.getInstance().add("id:=  " + Element.getInstance().element.getAttribute("id"));
			Logger.getInstance().add("name:=  " + Element.getInstance().element.getAttribute("name"));
			Logger.getInstance().add("text:=  " + Element.getInstance().element.getAttribute("text"));
			Logger.getInstance().add("innerText:=  " + Element.getInstance().element.getAttribute("innerText"));
			Logger.getInstance().add("outerText:=  " + Element.getInstance().element.getAttribute("outerText"));
			Logger.getInstance().add("innerHTML:=  " + Element.getInstance().element.getAttribute("innerHTML"));
			Logger.getInstance().add("outerHTML:=  " + Element.getInstance().element.getAttribute("outerHTML"));
			Logger.getInstance().add("uniqueID:=  " + Element.getInstance().element.getAttribute("uniqueID"));
			Logger.getInstance().add("class:=  " + Element.getInstance().element.getAttribute("class"));
			Logger.getInstance().add("type:=  " + Element.getInstance().element.getAttribute("type"));
			Logger.getInstance().add("TYPE:=  " + Element.getInstance().element.getAttribute("TYPE"));
			Logger.getInstance().add("href:=  " + Element.getInstance().element.getAttribute("href"));
			Logger.getInstance().add("NameProp:=  " + Element.getInstance().element.getAttribute("NameProp"));
			Logger.getInstance().add("isDisplayed:=  " + Element.getInstance().element.isDisplayed());
			Logger.getInstance().add("name:=  " + Element.getInstance().element.isEnabled());
			Logger.getInstance().add("getLocation().x:=  " + Element.getInstance().element.getLocation().x);
			Logger.getInstance().add("getLocation().y:=  " + Element.getInstance().element.getLocation().y);
			Logger.getInstance().add("getSize().height:=  " + Element.getInstance().element.getSize().height);
			Logger.getInstance().add("getLocation().y:=  " + Element.getInstance().element.getSize().width);
			Logger.getInstance().add("src:=  " + Element.getInstance().element.getAttribute("src"));
		}
	}

	private class WebElementCollectionAttributes {
		private WebElementCollectionAttributes(String strTagName) {
			Logger.getInstance().add("  ==start==>WebElementCollectionAttributes " + new DateTimestamp().get());
			int intCount = 0;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			List<WebElement> objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				intCount = intCount + 1;
				Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WebElementCollectionAttributes " + intCount);
				Logger.getInstance().add("text:=  " + row.getTagName());
				Logger.getInstance().add("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
				Logger.getInstance().add("TagName:=  " + row.getAttribute("TagName"));
				Logger.getInstance().add("type:=  " + row.getAttribute("type"));
				Logger.getInstance().add("id:=  " + row.getAttribute("id"));
				Logger.getInstance().add("name:=  " + row.getAttribute("name"));
				Logger.getInstance().add("text:=  " + row.getAttribute("text"));
				Logger.getInstance().add("innerText:=  " + row.getAttribute("innerText"));
				Logger.getInstance().add("outerText:=  " + row.getAttribute("outerText"));
				Logger.getInstance().add("innerHTML:=  " + row.getAttribute("innerHTML"));
				Logger.getInstance().add("outerHTML:=  " + row.getAttribute("outerHTML"));
				Logger.getInstance().add("uniqueID:=  " + row.getAttribute("uniqueID"));
				Logger.getInstance().add("class:=  " + row.getAttribute("class"));
				Logger.getInstance().add("type:=  " + row.getAttribute("type"));
				Logger.getInstance().add("TYPE:=  " + row.getAttribute("TYPE"));
				Logger.getInstance().add("href:=  " + row.getAttribute("href"));
				Logger.getInstance().add("NameProp:=  " + row.getAttribute("NameProp"));
				Logger.getInstance().add("isDisplayed:=  " + row.isDisplayed());
				Logger.getInstance().add("name:=  " + row.isEnabled());
				Logger.getInstance().add("getLocation().x:=  " + row.getLocation().x);
				Logger.getInstance().add("getLocation().y:=  " + row.getLocation().y);
				Logger.getInstance().add("getSize().height:=  " + row.getSize().height);
				Logger.getInstance().add("getLocation().y:=  " + row.getSize().width);
				Logger.getInstance().add("src:=  " + row.getAttribute("src"));
			}
		}
	}

	private class WebElementCollectionTable {
		private WebElementCollectionTable(String strTagName) {
			boolean blnSkip = false;
			Logger.getInstance().add("  ==start==>WebElementCollectionTable " + new DateTimestamp().get());
			// TODO webElementCollectionTable send output to html file
			int intCount = 0;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			Logger.getInstance().add("WebElementCollectionTable: strTagName = " + strTagName);
			Logger.getInstance().add("WebElementCollectionTable: lngStartTimeSwitchTo = " + BrowserDriver.getInstance().browserDriver.getTitle());
			BrowserDriver.getInstance().browserDriver.switchTo().defaultContent();
			for (String winHandle : BrowserDriver.getInstance().browserDriver.getWindowHandles()) {
				intCount = 0;
				//  Logger.getInstance().add("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				Logger.getInstance().add("WebElementCollectionTable: winHandle = " + winHandle);
				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// if (strCurrentWindowHandle.equals(winHandle)) {
				// } else {
				BrowserDriver.getInstance().browserDriver.switchTo().window(winHandle);
				Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				Logger.getInstance().add("WebElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// }
				Logger.getInstance().add("WebElementCollectionTable: BrowserDriver.getInstance().browserDriver.getTitle = " + BrowserDriver.getInstance().browserDriver.getTitle());
				// Logger.getInstance().add("webElementCollectionTable BrowserDriver.getInstance().browserDriver.getPageSource = " + BrowserDriver.getInstance().browserDriver.getPageSource());
				Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				List<WebElement> objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.tagName(strTagName));
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
							Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
							Logger.getInstance().add("WebElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
							Logger.getInstance().add("WebElementCollectionTable: type:= '" + row.getAttribute("type") + "'");
							Logger.getInstance().add("WebElementCollectionTable: getText:= '" + row.getText() + "'");
							Logger.getInstance().add("WebElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
						}
					}
					//  Logger.getInstance().add("text:=  " + objWebElementEach.);
					//  Logger.getInstance().add("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
					//  Logger.getInstance().add("TagName:= '" + row.getAttribute("TagName") + "'");
					//  Logger.getInstance().add("Type:= '" + row.getAttribute("Type") + "'");
					//  Logger.getInstance().add("TYPE:= '" + row.getAttribute("TYPE") + "'");
					//  Logger.getInstance().add("id:= '" + row.getAttribute("id") + "'");
					//  Logger.getInstance().add("name:= '" + row.getAttribute("name") + "'");
					//  Logger.getInstance().add("text:= '" + row.getAttribute("text") + "'");
					//  Logger.getInstance().add("innerText:= '" + row.getAttribute("innerText") + "'");
					//  Logger.getInstance().add("outerText:= '" + row.getAttribute("outerText") + "'");
					//  Logger.getInstance().add("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
					//  Logger.getInstance().add("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
					//  Logger.getInstance().add("class:= '" + row.getAttribute("class") + "'");
					//  Logger.getInstance().add("href:= '" + row.getAttribute("href") + "'");
					//  Logger.getInstance().add("NameProp:= '" + row.getAttribute("NameProp") + "'");
					//  Logger.getInstance().add("isDisplayed:= '" + row.isDisplayed() + "'");
					//  Logger.getInstance().add("isEnabled:= '" + row.isEnabled() + "'");
					//  Logger.getInstance().add("getLocation().x:= '" + row.getLocation().x + "'");
					//  Logger.getInstance().add("getLocation().y:= '" + row.getLocation().y + "'");
					//  Logger.getInstance().add("getSize().height:= '" + row.getSize().height + "'");
					//  Logger.getInstance().add("getSize().width:= '" + row.getSize().width + "'");
					//  Logger.getInstance().add("src:= '" + row.getAttribute("src") + "'");
					// if (objCollectionJS.size() > 0) {
					//
					// JavascriptExecutor objJavascriptExecutor = null;
					// objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
					// long lngStartTimeJS = System.currentTimeMillis();
					//  Logger.getInstance().add("JS value = " +
					// objJavascriptExecutor.executeScript("return arguments[0].value;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					//  Logger.getInstance().add("JS innerText = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					//  Logger.getInstance().add("JS innerHTML = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					//  Logger.getInstance().add("JS outerHTML = " +
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
			Logger.getInstance().add("  ==start==>WindowFocus " + new DateTimestamp().get());
			// TODO debug BrowserDriver.getInstance().browserDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
			if (BrowserDriver.getInstance().browserDriver instanceof JavascriptExecutor) {
				((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("window.focus();");
			}
		}
	}

	private class WindowsProcessKill {
		private WindowsProcessKill(String strProcessToKill) {
			Logger.getInstance().add("  ==start==>WindowsProcessKill " + new DateTimestamp().get());
			try {
				Runtime.getRuntime().exec(strProcessToKill);
				Logger.getInstance().add("WindowsProcessKill: process killed = " + strProcessToKill);
			} catch (Exception e) {
				Logger.getInstance().add("WindowsProcessKill: Exception = " + e.toString());
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
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.mainDragonfly(args, objDragonfly);
	}

	static String createObjectName() {
		String strAttributeValue = "";
		String strAttributeValues = ReplaceHtmlArrows(JSONS.getInstance().step.getString("strAttributeValues"));
		String strObjectsAttributes = "";
		String strObjectName = "";
		String strObjectNames = JSONS.getInstance().step.getString("strAttributeNames");
		String[] arrAttributeValues = strAttributeValues.split("\\|");
		String[] arrObjectNames = strObjectNames.split("\\|");
		for (int intEach = 0; intEach < arrObjectNames.length; intEach++) {
			strObjectName = arrObjectNames[intEach].toString();
			strAttributeValue = arrAttributeValues[intEach].toString();
			if (intEach == 0) {
				strObjectsAttributes = strObjectName + "=" + strAttributeValue;
				Logger.getInstance().add("createObjectName strObjectAttribute =" + strObjectsAttributes);
			} else {
				strObjectsAttributes = strObjectsAttributes + "|" + strObjectName + "=" + strAttributeValue;
				Logger.getInstance().add("createObjectName strObjectAttribute =" + strObjectsAttributes);
			}
		}
		return strObjectsAttributes;
	}

	public String data_DateDaysOut(String strDaysOut) {
		Logger.getInstance().add("  ==start==>data_DateDaysOut " + new DateTimestamp().get());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat objFormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (objFormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_EnvironmentURL(String strApplication_Environment) {
		Logger.getInstance().add("data_EnvironmentURL: gstrEnvironment = " + Config.getInstance().environment);
		Logger.getInstance().add("  ==start==>data_EnvironmentURL " + new DateTimestamp().get());
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
		Logger.getInstance().add("  ==start==>data_localWebsiteFilePath " + new DateTimestamp().get());
		String strLocalWebsiteFilePath = "file:///" + Path.getInstance().systemUserDir.replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		Logger.getInstance().add("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public String data_RandomFourNumbers(String strDaysOut) {
		Logger.getInstance().add("  ==start==>data_RandomFourNumbers " + new DateTimestamp().get());
		return Integer.toString(randomNumberRange(1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(String strDataInput) {
		Logger.getInstance().add("  ==start==>data_RandomRangeFiveNumbers " + new DateTimestamp().get());
		return Integer.toString(randomNumberRange(1, 99999));
	}

	private String formatDateTime(Long lngStartTimeMillis) {
		Logger.getInstance().add("  ==start==>DateTimeFormat " + new DateTimestamp().get());
		return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS").format(new Date(lngStartTimeMillis));
	}

	private String formatXML(String input) {
		try {
			final InputSource src = new InputSource(new StringReader(input));
			final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
			final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			final LSSerializer writer = impl.createLSSerializer();
			writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
			writer.getDomConfig().setParameter("xml-declaration", true);
			return writer.writeToString(document);
		} catch (Exception e) {
			e.printStackTrace();
			return input;
		}
	}

	//	String new DateTimestamp().get() {
	//		return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
	//	}
	private String getKeyword(String strValue) {
		String strValueToFindKeyword = strValue.toLowerCase();
		int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
		String strKeyword = "";
		if (intRightArrowPosition > -1) {
			strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
		}
		Logger.getInstance().add("getKeyword: strKeyword = " + strKeyword);
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
		Logger.getInstance().add("getKeywordIntValue: intKeywordValue " + intKeywordValue);
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
		Logger.getInstance().add("getKeywordValue: strKeywordValue " + strKeywordValue);
		return strKeywordValue;
	}

	private void logStepDetails() {
		for (String strKey : new StepNames().getOriginal()) {
			Logger.getInstance().add("LogStepDetails: " + strKey + " = " + JSONS.getInstance().step.getString(strKey));
		}
	}

	public void mainDragonfly(String[] args, Dragonfly objDragonfly) {
		JSONArray objJsonArrayTestSteps = null;
		JSONArray objJsonArrayTestStepsRun = new JSONArray();
		JSONParser objJsonParser = new JSONParser();
		Boolean blnExit = false;
		Logger.getInstance().add("  ==start==>mainDragonfly " + new DateTimestamp().get());
		objAutoItSetObject.createObject();
		windowsMinimizeAll();
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
				writeJsonStepsToHtml(Path.getInstance().results, "original", objJsonArrayTestSteps, "StepsOriginal.html");
				for (intStep = 0; intStep < objJsonArrayTestSteps.size(); intStep++) {
					Logger.getInstance().add("mainDragonfly: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					Element.getInstance().element = null;
					JSONS.getInstance().step.replaceAllFromString((String) objJsonArrayTestSteps.get(intStep).toString());
					new StepSetupDefaults(strCurrentWindowHandle);
					String strInputValue = JSONS.getInstance().step.getString("strInputValue");
					logStepDetails();
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
							stepDuration("<skip>", System.currentTimeMillis(), "skip");
						} else {
							switch (JSONS.getInstance().step.getLowerCase("strAction")) {
							case "break":
								Logger.getInstance().add("mainDragonfly: switch strAction = break was entered to at this step to stop execution");
								JSONS.getInstance().step.putValue("strStepActual", "break");
								stepDuration("break", System.currentTimeMillis(), "break");
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
								new ProcessKillInternetExplorer().run();
								JSONS.getInstance().step.putValue("strStepActual", "kill_ie");
								stepDuration("kill_ie", lngStartTime, "kill_ie");
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
								stepDuration("action", System.currentTimeMillis(), "action");
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
				writeFile(Path.getInstance().results + "StepsAfterRun.json", objJsonArrayTestStepsRun.toString());
				writeFile(Path.getInstance().results + "StepsWithDefaults.json", JSONS.getInstance().testSteps.toString());
				writeJsonStepsToHtml(Path.getInstance().results, "original", objJsonArrayTestStepsRun, "StepsWithDefaults.html");
				writeJsonStepsToHtml(Path.getInstance().results, "complete", objJsonArrayTestStepsRun, "StepsAfterRun.html");
				writeReportToHtml(Path.getInstance().results + "Report.html", objJsonArrayTestStepsRun, strFileTestSteps, strNameTestConfiguration.replace(".json", ""));
				writeFile(Path.getInstance().results + "Dragonfly.log", Logger.getInstance().getLog());
				writeFile(Path.getInstance().results + "StepsManual.txt", StepsManual.getInstance().get());
				Path.getInstance().changeDirectoryNameStatus(strTestStatus);
				if (BrowserDriver.getInstance().browserDriver.toString().contains("InternetExplorerDriver")) {
					//	new WindowsProcessKill("taskkill /F /IM IEDriverServer_32.exe");
				}
			}
			Logger.getInstance().deleteLog();
			StepsManual.getInstance().delete();
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
		// Logger.getInstance().add("optionsList: intOptionsCounts = " + intOptionsCounts);
		for (int intOptionEach = 0; intOptionEach < intOptionsCounts; intOptionEach++) {
			// Logger.getInstance().add("optionsList: intStart = " + intStart);
			intLeftArrowPosition = strOptionsToFindList.indexOf("<option", intStart);
			// Logger.getInstance().add("optionsList: intLeftArrowPosition <option = " + intLeftArrowPosition);
			if (intLeftArrowPosition > -1) {
				intRightArrowPosition = strOptionsToFindList.indexOf(">", intLeftArrowPosition);
				// Logger.getInstance().add("optionsList: intRightArrowPosition = " + intRightArrowPosition);
				intLeftArrowPosition = strOptionsToFindList.indexOf("<", intRightArrowPosition);
				// Logger.getInstance().add("optionsList: intLeftArrowPosition < = " + intLeftArrowPosition);
				strOptionsValue = strOptionsToFindList.substring(intRightArrowPosition + 1, intLeftArrowPosition);
				// Logger.getInstance().add("optionsList: strOptionsValue = " + strOptionsValue);
				if (strOptionsList.length() == 0) {
					strOptionsList = strOptionsValue.trim();
				} else {
					strOptionsList = strOptionsList + "; " + strOptionsValue.trim();
				}
				intStart = intRightArrowPosition + 1;
				// Logger.getInstance().add("optionsList: inside if intStart = " + intStart);
			}
		}
		Logger.getInstance().add("OptionsList: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
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
		// Logger.getInstance().add("removeTags: intKeywordCount = " + intKeywordCount);
		for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
			blnRemove = true;
			//Logger.getInstance().add("removeTags: intStart = " + intStart);
			intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intStart);
			if (intLeftArrowPosition > -1) {
				intRightArrowPosition = strValueToFindKeyword.indexOf(">");
				strTextToReplace = strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1);
				// Logger.getInstance().add("removeTags: strTextToReplace = " + strTextToReplace);
				for (String strKeywordsValidEach : arrKV_strInputValue) {
					if (strTextToReplace.equals(strKeywordsValidEach)) {
						blnRemove = false;
						intStart = intRightArrowPosition + 1;
						//Logger.getInstance().add("removeTags: inside if intStart = " + intStart);
						break;
					}
				}
				if (blnRemove.equals(true)) {
					strValueToFindKeyword = strValueToFindKeyword.replaceAll(strTextToReplace, "");
				}
				// Logger.getInstance().add("removeTags: strValueToFindKeyword = " + intKeywordEach + "  " + strValueToFindKeyword);
			}
		}
		// Logger.getInstance().add("removeTags: strValueToFindKeyword = " + strValueToFindKeyword);
		return strValueToFindKeyword;
	}

	private static String ReplaceHtmlArrows(String strText) {
		Logger.getInstance().add("ReplaceHtmlArrows: strText = " + strText);
		Logger.getInstance().add("ReplaceHtmlArrows: strText.replaceAll = " + strText.replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
		return strText.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

	private void stepCreateActual(String strStepType) {
		Logger.getInstance().add("  ==start==>stepCreateActual " + new DateTimestamp().get());
		String intWaited = JSONS.getInstance().step.getString("strStepDuration");
		String strActualHtml = "";
		String strActualText = "";
		String strInputValue = JSONS.getInstance().step.getString("strInputValue");
		Logger.getInstance().add("stepCreateActual strStepType.toLowerCase() = " + strStepType.toLowerCase());
		String strOutputValue = JSONS.getInstance().step.getString("strOutputValue");
		String strTagName = JSONS.getInstance().step.getString("strTagName");
		String strObjectName = this.createObjectName();
		String strTagAttributesHtml = "The {<b>" + strTagName + "</b>} tag with attributes {<b>" + strObjectName + "</b>}";
		String strMsWaitedDetailHtml = " after {<b>" + intWaited + "</b>} milliseconds.";
		String strHtmlFailStart = "{<b><FONT COLOR='FF0000'>";
		String strHtmlPassStart = "{<b><FONT COLOR='008000'>";
		String strHtmlEnd = "</FONT></b>}";
		String strInputValueHtmlPass = " value " + strHtmlPassStart + strInputValue + strHtmlEnd;
		String strOutputValueHtmlPass = " value " + strHtmlPassStart + strOutputValue + strHtmlEnd;
		String strOutputValueHtmlFail = " " + strHtmlFailStart + strOutputValue + strHtmlEnd;
		Logger.getInstance().add("stepCreateActual strStepActual = " + JSONS.getInstance().step.getString("strStepActual"));
		strStepType = JSONS.getInstance().step.getString("strStepActual");
		Logger.getInstance().add("stepCreateActual strStepType.toLowerCase() = " + strStepType.toLowerCase());
		try {
			switch (strStepType.toLowerCase()) {
			case "assert":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " persisted" + strMsWaitedDetailHtml;
				break;
			case "assert_failed":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " did not persist" + strMsWaitedDetailHtml + "<BR>The actual value" + strOutputValueHtmlFail + " was displayed.";
				break;
			case "break":
				strActualHtml = "Take a break.";
				break;
			case "browser_close":
				strActualHtml = "The {<b>" + strTagName + "</b>} browser was closed" + strMsWaitedDetailHtml;
				break;
			case "browser_launch":
				strActualHtml = "The {<b>" + strTagName + "</b>} browser navigated to url" + strInputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "browser_refresh":
				strActualHtml = "The {<b>" + strTagName + "</b>} browser navigated to url" + strInputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "clicked":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was clicked" + strMsWaitedDetailHtml;
				break;
			case "default":
				strActualHtml = strTagAttributesHtml + " default" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "drag":
				strActualHtml = strTagAttributesHtml + " was dragged" + strMsWaitedDetailHtml;
				break;
			case "drop":
				strActualHtml = strTagAttributesHtml + " was dropped" + strMsWaitedDetailHtml;
				break;
			case "expected":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was not verified" + strMsWaitedDetailHtml + "<BR>The actual value was" + strOutputValueHtmlFail + ".";
				break;
			case "get":
				strActualHtml = strTagAttributesHtml + " actual value is" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
				Logger.getInstance().add("stepCreateActual get strActualHtml = " + strActualHtml);
				break;
			case "keystroke":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " key was pressed" + strMsWaitedDetailHtml;
				break;
			case "kill_ie":
				strActualHtml = "The action kill_ie killed all IE processes was executed.";
				break;
			case "mouse_out":
				strActualHtml = strTagAttributesHtml + " mouse out is complete" + strMsWaitedDetailHtml;
				break;
			case "mouse_over":
				strActualHtml = strTagAttributesHtml + " mouse over is complete" + strMsWaitedDetailHtml;
				break;
			case "navigate":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was set" + strMsWaitedDetailHtml + "<BR>No validation performed due to navigation.";
				break;
			case "not_closed":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlFail + " did not close" + strMsWaitedDetailHtml;
				break;
			case "not_disabled":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "enabled" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_enabled":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "disabled" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_exist_tooltip":
				strActualHtml = strTagAttributesHtml + " tooltip does not exist" + strMsWaitedDetailHtml;
				break;
			case "not_found":
				strActualHtml = strTagAttributesHtml + " was" + strHtmlFailStart + "not found" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_hidden":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "visible" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_in_list":
				strActualHtml = strTagAttributesHtml + "The list item " + strInputValueHtmlPass + " does not exist in the list field" + strMsWaitedDetailHtml + "<BR>Please confirm the input value against the actual list values " + strOutputValueHtmlFail + " is available for this field.";
				break;
			case "not_visible":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "hidden" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "scroll":
				strActualHtml = strTagAttributesHtml + strMsWaitedDetailHtml;
				break;
			case "secure":
				strActualHtml = strTagAttributesHtml + " password value" + strOutputValueHtmlPass + " was set" + strMsWaitedDetailHtml;
				break;
			case "set":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was set" + strMsWaitedDetailHtml;
				break;
			case "skip":
				strActualHtml = "The skip keyword was entered in the strInputValue field causing this step to be skipped.";
				break;
			case "sleep":
				strActualHtml = "The execution sleep is complete " + strMsWaitedDetailHtml;
				break;
			case "sync_closed":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " closed" + strMsWaitedDetailHtml;
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
			case "sync_optional":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " sync is optional" + strMsWaitedDetailHtml;
				break;
			case "sync_visible":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "visible" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "tag_not_supported":
				strActualHtml = strTagAttributesHtml + " is not supported";
				break;
			case "tooltip_expected":
				strActualHtml = strTagAttributesHtml + " tooltip" + strInputValueHtmlPass + " was not verified." + strMsWaitedDetailHtml + "<BR>The actual value was " + strOutputValueHtmlFail + ".";
				break;
			case "tooltip_get":
				strActualHtml = strTagAttributesHtml + " tooltip actual value is" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "tooltip_verify":
				strActualHtml = strTagAttributesHtml + " tooltip" + strOutputValueHtmlPass + " was verified" + strMsWaitedDetailHtml;
				break;
			case "verify_not":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was not verified" + strMsWaitedDetailHtml;
				break;
			case "verify_value":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was verified" + strMsWaitedDetailHtml;
				break;
			default:
				strActualHtml = "<b><FONT COLOR='#FF69B4'>" + "StepType {" + strStepType + "} is not supported" + "</FONT></b>";
				break;
			}
			strActualHtml = "<DIV align='left'><font size='5'>" + strActualHtml + "</font></DIV>";
			strActualText = removeTags(strActualHtml);
			Logger.getInstance().add("StepCreateActual: strActualText = " + strActualText);
			JSONS.getInstance().step.putValue("strStepActual", strActualHtml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.getInstance().add("stepCreateActual:Exception " + e.toString());
		}
	}

	private void stepCreateExpected() {
		Logger.getInstance().add("  ==start==>StepCreateExpected " + new DateTimestamp().get());
		String strStepExpected = "";
		String strAction = "";
		String strInputValue = Config.getInstance().originalInputValue;
		String strMillisecondsToWait = JSONS.getInstance().step.getString("intMillisecondsToWait");
		String strObjectName = Config.getInstance().originalAttributes;
		String strTagName = JSONS.getInstance().step.getString("strTagName");
		String strAssert = JSONS.getInstance().step.getString("strAssert");
		String strMillisecondsToWaitHtml = " within {<b>" + strMillisecondsToWait + "</b>} milliseconds.";
		String strTagAttributesHtml = " {<b>" + strTagName + "</b>} tag with attributes {<b>" + strObjectName + "</b>}";
		String strInputValueHtml = " {<b>" + strInputValue + "</b>}";
		String strAssertHtml = " assert {<b>" + strAssert + "</b>}";
		Logger.getInstance().add("stepCreateExpected: strStepExpected length = " + JSONS.getInstance().step.getString("strStepExpected").length());
		try {
			if (JSONS.getInstance().step.getString("strStepExpected").length() != 0) {
				strAction = JSONS.getInstance().step.getString("strStepExpected");
			} else {
				strAction = JSONS.getInstance().step.getString("strAction");
			}
			Logger.getInstance().add("stepCreateExpected: strAction = " + strAction);
			switch (strAction.toLowerCase()) {
			case "break":
				strStepExpected = "Break the execution.";
				break;
			case "click":
				strStepExpected = "Click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "close":
				strStepExpected = "Close {<b>" + strTagName + "</b>} browser" + strMillisecondsToWaitHtml;
				break;
			case "double_click":
				strStepExpected = "Double click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "drag":
				strStepExpected = "Drag" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "drop":
				strStepExpected = "Drop" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "get":
				strStepExpected = "Get" + strTagAttributesHtml + " value" + strMillisecondsToWaitHtml;
				//strStepExpected = "Get" + strMillisecondsToWaitHtml + " value" + strMillisecondsToWaitHtml;
				Logger.getInstance().add("stepCreateExpected: get strStepExpected = " + strStepExpected);
				break;
			case "kill_ie":
				strStepExpected = "The action kill_ie killed all IE processes.";
				break;
			case "launch":
				strStepExpected = "Launch {<b>" + strTagName + "</b>} browser to url" + strInputValueHtml + strMillisecondsToWaitHtml;
				break;
			case "mouse_out":
				strStepExpected = "Mouse out" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "mouse_over":
				strStepExpected = "Mouse over" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "refresh":
				strStepExpected = "Refresh the browser" + strMillisecondsToWaitHtml;
				break;
			case "right_click":
				strStepExpected = "Right click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "scroll":
				strStepExpected = "Scroll the" + strTagAttributesHtml + " into view" + strMillisecondsToWaitHtml;
				break;
			case "select":
				strStepExpected = "Select" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "set":
				strStepExpected = "Set" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "set_js":
				strStepExpected = "Set" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "sleep":
				strStepExpected = "Sleep execution for" + strInputValueHtml + " milliseconds.";
				break;
			case "sync_disabled":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is disabled" + strMillisecondsToWaitHtml;
				break;
			case "sync_enabled":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is enabled" + strMillisecondsToWaitHtml;
				break;
			case "sync_hidden":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is hidden" + strMillisecondsToWaitHtml;
				break;
			case "sync_visible":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is visible" + strMillisecondsToWaitHtml;
				break;
			case "verify":
				strStepExpected = "Verify" + strTagAttributesHtml + " value is equal to" + strInputValueHtml + strMillisecondsToWaitHtml;
				break;
			case "verify_not":
				strStepExpected = "Verify" + strTagAttributesHtml + " value is not equal to" + strInputValueHtml + strMillisecondsToWaitHtml;
				break;
			default:
				strStepExpected = strAction;
				break;
			}
			strStepExpected = "<DIV align='left'><font size='5'>" + strStepExpected + "</font></DIV>";
			StepsManual.getInstance().set(removeTags(strStepExpected));
			JSONS.getInstance().step.putValue("strStepExpected", strStepExpected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.getInstance().add("stepCreateExpected:Exception " + e.toString());
		}
	}

	private void stepDuration(String strMethodName, Long lngTimeStart, String strStepType) {
		Logger.getInstance().add("  ==start==>StepDuration " + new DateTimestamp().get());
		stepCreateExpected();
		Long lngTimeEnd = System.currentTimeMillis();
		JSONS.getInstance().step.putValue("strStartTimestamp", formatDateTime(lngTimeStart));
		JSONS.getInstance().step.putValue("strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
		JSONS.getInstance().step.putValue("strEndTimestamp", formatDateTime(lngTimeEnd));
		stepCreateActual(strStepType);
		Logger.getInstance().add("StepDuration: " + strMethodName + " strStatus = " + JSONS.getInstance().step.getString("strStatus") + " Milliseconds Waited = " + JSONS.getInstance().step.getString("strStepDuration"));
	}

	private Boolean syncFinally(Boolean blnExit, Boolean blnStatus, Boolean blnFound, String strMethodeName, String strAction, Long lngTimeStart) {
		Logger.getInstance().add("SyncFinally:  blnExit = {" + blnExit + "} blnStatus = {" + blnStatus + "} blnFound = {" + blnFound + "} strMethodeName = {" + strMethodeName + "} strAction = {" + strAction + "}");
		if (blnExit == true) {
			JSONS.getInstance().step.putValue("strStatus", "fail");
			JSONS.getInstance().step.putValue("blnExitOnFail", "true");
		} else {
			if (blnStatus == true) {
				JSONS.getInstance().step.putValue("strStatus", "pass");
				blnExit = true;
			} else if (blnStatus == false) {
				if ((int) (System.currentTimeMillis() - lngTimeStart) <= JSONS.getInstance().step.getInt("intMillisecondsToWait")) {
					if (blnFound == false) {
						blnExit = false;
					}
				} else {
					if (JSONS.getInstance().step.getBoolean("blnOptional") == true) {
						JSONS.getInstance().step.putValue("strStatus", "warning");
						blnExit = true;
					} else {
						JSONS.getInstance().step.putValue("strStatus", "fail");
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
		Logger.getInstance().add("  ==start==>WindowsMinimizeAll " + new DateTimestamp().get());
		Robot objRobot = null;
		switch (OperatingSystem.get()) {
		case "Windows":
			try {
				objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_WINDOWS);
				objRobot.keyPress(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_WINDOWS);
				Logger.getInstance().add("windowsMinimizeAll: Windows operating system minimize all windows.");
			} catch (Exception e) {
				Logger.getInstance().add("windowsMinimizeAll: Exception = " + e.toString());
			}
			break;
		default:
			Logger.getInstance().add("WindowsMinimizeAll: the operating system not supported at this time " + OperatingSystem.get());
		}
	}

	private void writeFile(String strFilePathFile, String strTextToWrite) {
		Logger.getInstance().add("  ==start==>writeFile " + new DateTimestamp().get());
		Logger.getInstance().add("writeFile: strFilePathFile = " + strFilePathFile);
		try {
			BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(strFilePathFile));
			objBufferedWriter.write(strTextToWrite);
			objBufferedWriter.close();
		} catch (Exception e) {
			Logger.getInstance().add("writeFile: Exception" + e.toString());
		}
	}

	private void writeJsonStepsToHtml(String strPath, String strStepHeader, JSONArray objTestSteps, String strFileName) {
		Logger.getInstance().add("  ==start==>WriteJsonStepsToHtml " + new DateTimestamp().get());
		Logger.getInstance().add("WriteJsonStepsToHtml objTestSteps = " + objTestSteps);
		String strKey = "";
		String[] arrKeys = null;
		StepNames objStepNames = new StepNames();
		StringBuilder objStringBuilder = new StringBuilder();
		String strValue = "";
		JSON objStepReport = new JSON();
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
				objStepReport.replaceAllFromString((String) objTestSteps.get(intTestStepRow).toString());
				for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
					strKey = arrKeys[intKeysEach].toString();
					if (objStepReport.containsKey(strKey) == true) {
						strValue = objStepReport.getString(strKey).replaceAll("<", "&lt;");
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
			Logger.getInstance().add("WriteJsonStepsToHtml: Exception = " + e.toString());
			Logger.getInstance().add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			Logger.getInstance().add("WriteJsonStepsToHtml: Exception = " + e.toString());
			Logger.getInstance().add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
		}
	}

	private void writeReportToHtml(String strFile, JSONArray objJsonArrayReportSteps, String strTestStepsFile, String strTestName) {
		long lngStartTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>WriteReportToHtml " + new DateTimestamp().get());
		Logger.getInstance().add("WriteReportToHtml: strFile = " + strFile);
		JSON objJsonObjectReportStep = new JSON();
		String strScreenshotFilePath = "";
		String strStatus = "";
		String strStatusIcon = "";
		StringBuilder objStringBuilder = new StringBuilder();
		int intTestStepRow = 0;
		Logger.getInstance().add("WriteReportToHtml: objJsonArrayReportSteps = " + objJsonArrayReportSteps.toJSONString());
		try {
			// 	function popUp() {
			// 		var newWindow = window.open("", "Test", "width=300,height=300,scrollbars=1,resizable=1")
			// 		var text = "cat"
			// 		var html = "<html><head></head><body>Hello, <b>" + text + "</b>."
			// 		html += "How are you today?</body></html>"
			// 		newWindow.document.open()
			// 		newWindow.document.write(html)
			// 		newWindow.document.close()
			// 	}
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
				objJsonObjectReportStep.parseString((String) objJsonArrayReportSteps.get(intTestStepRow));
				Logger.getInstance().add("WriteReportToHtml: objJsonObjectReportStep = " + objJsonObjectReportStep.toJSONString());
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
				if (objJsonObjectReportStep.getValueLength("strScreenshotFilePath") != 0) {
					strScreenshotFilePath = objJsonObjectReportStep.getString("strScreenshotFilePath").replaceAll("\\\\\\\\", "\\");
					try {
						BufferedImage objBufferedImage = ImageIO.read(new File(strScreenshotFilePath));
						objStringBuilder.append("<img id=img_" + intTestStepRow + " src=\"data:image/jpg;base64," + new ImageEncodeToString().run(objBufferedImage, "jpg") + "\" alt=\"Step " + intTestStepRow + "\" > ");
					} catch (Exception e) {
						Logger.getInstance().add("writeReportToHtml: Exception = " + e.toString());
					}
				}
				objStringBuilder.append("</div>");
				objStringBuilder.append("<br>");
				objStringBuilder.append("<br>");
			}
		} catch (Exception e) {
			Logger.getInstance().add("WriteReportToHtml: " + e.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			String strHTML = objStringBuilder.toString().replace("varImageCount = -1", "varImageCount = " + (intTestStepRow - 1));
			writeFile(strFile, strHTML);
			writeFile(strTestStepsFile, strHTML);
			Logger.getInstance().add("WriteReportToHtml: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
//	private static ExpectedCondition<Boolean> waitForAngularFinishProcessing() {
//		 Logger.getInstance().add("  ==start==>waitForAngularFinishProcessing " + new DateTimestamp().get());
//		return new ExpectedCondition<Boolean>() {
// @Override
// private Boolean apply(WebDriver driver) {
// 	return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
// }
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