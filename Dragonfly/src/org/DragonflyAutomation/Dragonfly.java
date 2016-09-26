//TODO Alert handling get and verify
//TODO alertFind complete, determine which is best approach and choose method delete one
//TODO Create an array json for link values from output link name
//TODO Update json with results status timing step details
//TODO Confirm all browsers work
//TODO Json Element properties combine , using json format for key and value
//TODO Reporting add step details
//TODO Encryption
//TODO Add comment to file for changes
//TODO create a level for logging and add a global variable and a switch statement to objDragonfly.logger.add with several levels to filter what calls are added to objDragonfly.logger.add with a new input parameter intLevel
//TODO add recursive method for iframes
//TODO create new method for attribute setup to only call once per step
//TODO class to validate keywords for all standard
//strPathTestSteps
//strFileTestSteps
//strNameTestSteps
//strValueTestSteps
//		long startTime = System.nanoTime();
//		try {
//			TimeUnit.MILLISECONDS.sleep(2192);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		long elapsedTime = System.nanoTime() - startTime;
//		double seconds = (double)elapsedTime / 1000000000.0;
//		System.out.println("nano " + elapsedTime);
//		System.out.println("seconds " + seconds);
//		 startTime = System.currentTimeMillis();
//		try {
//			TimeUnit.MILLISECONDS.sleep(2192);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		 elapsedTime = System.currentTimeMillis() - startTime;
//		 seconds = (double)elapsedTime / 1000.0;
//		System.out.println("millis " + elapsedTime);
//		System.out.println("seconds " + seconds);
//
//
//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.nanoTime());
//		System.exit(0);
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
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import com.opera.core.systems.OperaDriver;

public class Dragonfly {
	public int x = 1;

	public class AlertFind {
		public boolean run(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>AlertFind " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				String strAlertPresent = objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().alert().getText();
				objDragonfly.logger.add("AlertFind: alert found:  " + strAlertPresent);
				return true;
			} catch (UnhandledAlertException e) {
				objDragonfly.logger.add("AlertFind: UnhandledAlertException = " + e.toString());
				return true;
			} catch (NoAlertPresentException e) {
				objDragonfly.logger.add("AlertFind: NoAlertPresentException = " + e.toString());
				return false;
			} catch (Exception e) {
				objDragonfly.logger.add("AlertFind: Exception = " + e.toString());
				return false;
			} finally {
				objDragonfly.logger.add("AlertFind: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class AutoItSetObject {
		public AutoItX objAutoIt;

		public void createObject(Dragonfly objDragonfly) {
			Dragonfly.this.logger.add("  ==start==>AutoItSetObject " + new DateTimestamp().get());
			String strJacobDllVersionToUse;
			JvmBitVersion objJvmBitVersion = new JvmBitVersion();
			if (objJvmBitVersion.get().contains("32")) {
				strJacobDllVersionToUse = "jacob-1.18-x86.dll";
			} else {
				strJacobDllVersionToUse = "jacob-1.18-x64.dll";
			}
			Dragonfly.this.logger.add("AutoItSetObject: " + System.getProperty("java.library.path") + " " + new DateTimestamp().get());
			Dragonfly.this.logger.add("AutoItSetObject: " + strJacobDllVersionToUse + " " + new DateTimestamp().get());
			File objFile = new File("Libraries", strJacobDllVersionToUse);
			Dragonfly.this.logger.add("AutoItSetObject: " + LibraryLoader.JACOB_DLL_PATH + " " + new DateTimestamp().get());
			Dragonfly.this.logger.add("AutoItSetObject: " + objFile.getAbsolutePath() + " " + new DateTimestamp().get());
			System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
			objAutoIt = new AutoItX();
		}

		public AutoItX getObject() {
			return objAutoIt;
		}
	}

	public class BrowserClose {
		public BrowserClose(Dragonfly objDragonfly) {
			objDragonfly.objVariablesSelenium.gobjWebDriver.close();
			objDragonfly.objVariablesSelenium.gobjWebDriver.quit();
			//objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
			objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
			new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
		}
	}

	public class BrowserCloseSync {
		public BrowserCloseSync(Dragonfly objDragonfly) {
			// TODO create a browserCloseSync to manage reporting and sync close
			new BrowserClose(objDragonfly);
		}
	}

	public class BrowserLaunch {
		public BrowserLaunch(Dragonfly objDragonfly) throws ExceptionBrowserDriverNotSupported {
			// TODO combine duplicate code
			// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
			objDragonfly.logger.add("  ==start==>BrowserLaunch " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			objDragonfly.logger.add(" objDragonfly.objVariablesCommon.gstrBrowserSelection = " + objDragonfly.objVariablesCommon.gstrBrowserSelection);
			if (objDragonfly.objVariablesCommon.gstrBrowserSelection != "TestValue") {
				//objDragonfly.new JsonObjectStepPut().run(objDragonfly, "strTagName", objDragonfly.objVariablesCommon.gstrBrowserSelection);
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strTagName", objDragonfly.objVariablesCommon.gstrBrowserSelection);
			}
			DesiredCapabilities objDesiredCapabilities = null;
			try {
				//objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
				switch (objDragonfly.variablesJSON.objectStep.get("strTagName").toString()) {
				case "firefox":
					objDragonfly.objVariablesSelenium.gobjWebDriver = new FirefoxDriver();
					objDragonfly.objVariablesSelenium.gobjWebDriver.get(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
					objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					Actions myAction = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
					myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
					break;
				case "ie":
					// internetExplorerProcessKill();
					//windowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
					new SleepMilliseconds(objDragonfly, 1000);
					objDragonfly.logger.add("BrowserLaunch: DesiredCapabilities");
					objDesiredCapabilities = DesiredCapabilities.internetExplorer();
					objDragonfly.logger.add("BrowserLaunch: objDesiredCapabilities.toString()" + objDesiredCapabilities);
					objDragonfly.logger.add("BrowserLaunch: setJavascriptEnabled");
					objDesiredCapabilities.setJavascriptEnabled(true);
					objDragonfly.logger.add("BrowserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
					objDragonfly.logger.add("BrowserLaunch: IE_ENSURE_CLEAN_SESSION");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					objDragonfly.logger.add("BrowserLaunch: REQUIRE_WINDOW_FOCUS");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					objDragonfly.logger.add("BrowserLaunch: INITIAL_BROWSER_URL");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
					objDragonfly.logger.add("BrowserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					objDragonfly.logger.add("BrowserLaunch: new InternetExplorerDriver(desiredCapabilities)");
					objDragonfly.objVariablesSelenium.gobjWebDriver = new InternetExplorerDriver(objDesiredCapabilities);
					//objDragonfly.objVariablesSelenium.gobjWebDriver.manage().getCookieNamed("JSESSIONID");
					// objDragonfly.objVariablesSelenium.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
					objDragonfly.logger.add("BrowserLaunch: objDragonfly.variablesJSON.objectStep.get(strInputValue).toString() = " + objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
					objDragonfly.objVariablesSelenium.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					//objDragonfly.objVariablesSelenium.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
					objDragonfly.objVariablesSelenium.gobjWebDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
					objDragonfly.objVariablesSelenium.gobjWebDriver.get(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
					//objDragonfly.logger.add("browserLaunch: getCookieNamed(JSESSIONID) = " + objDragonfly.objVariablesSelenium.gobjWebDriver.manage().getCookieNamed("JSESSIONID").toString());
					objDragonfly.logger.add("BrowserLaunch: objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().maximize()");
					objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					//Capabilities getCapabilities();
					break;
				case "chrome":
					switch (objDragonfly.objOperatingSystem.strOS) {
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
					objDragonfly.objVariablesSelenium.gobjWebDriver = new ChromeDriver();
					objDragonfly.objVariablesSelenium.gobjWebDriver.get(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
					objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					break;
				case "safari":
					objDragonfly.objVariablesSelenium.gobjWebDriver = new SafariDriver();
					objDragonfly.objVariablesSelenium.gobjWebDriver.get(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
					objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					break;
				case "opera":
					// TODO OperaDriver setup latest driver and test desiredCapabilities = DesiredCapabilities.internetExplorer();
					// desiredCapabilities.setJavascriptEnabled(true);
					//objDragonfly.objVariablesSelenium.gobjWebDriver = new OperaDriver();
					//objDragonfly.objVariablesSelenium.setGobjWebDriver(new OperaDriver());
					objDragonfly.objVariablesSelenium.gobjWebDriver = new OperaDriver();
					objDragonfly.objVariablesSelenium.gobjWebDriver.get(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
					// objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					// objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().setPosition(new Point(0, 0));
					// Dimension dim = new Dimension(1382, 754);
					// objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().setSize(dim);
					// Selenium selenium;
					// objDragonfly.objVariablesSelenium.gobjWebDriver = new OperaDriver();
					// selenium = new WebDriverBackedSelenium(objDragonfly.objVariablesSelenium.gobjWebDriver, "https://www.google.com/");
					// return objDragonfly.objVariablesSelenium.gobjWebDriver;
					break;
				default:
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
					throw new ExceptionBrowserDriverNotSupported("Browser '" + objDragonfly.variablesJSON.objectStep.get("strTagName").toString() + "' not supported");
				}
			} catch (Exception e) {
				objDragonfly.logger.add("BrowserLaunch: Exception" + e.toString());
			} finally {
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strCurrentWindowHandle", objDragonfly.objVariablesSelenium.gobjWebDriver.getWindowHandle());
				new CoordinatesElement(objDragonfly);
				new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
				new StepDuration(objDragonfly, "BrowserLaunch", lngTimeStart, "launch");
			}
		}
	}

	public class BrowserLaunchSync {
		public BrowserLaunchSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>BrowserLaunchSync " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			new WriteFile(objDragonfly, "c:\\temp\\DragonflyBrowser.log", objDragonfly.logger.getLog());
			try {
				new BrowserLaunch(objDragonfly);
			} catch (ExceptionBrowserDriverNotSupported e) {
				// TODO confirm the exceptions to catch in main some may need to be removed
				objDragonfly.logger.add("main: " + e.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO create a BrowserLaunchSync to manage reporting and sync
				objDragonfly.logger.add("BrowserLaunchSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class BrowserRefresh {
		public BrowserRefresh(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>BrowserRefresh " + new DateTimestamp().get());
			objDragonfly.objVariablesSelenium.gobjWebDriver.navigate().refresh();
		}
	}

	public class BrowserRefreshSync {
		public BrowserRefreshSync(Dragonfly objDragonfly) {
			new BrowserRefresh(objDragonfly);
		}
	}

	public class ClearMyTracksByProcessCache {
		public ClearMyTracksByProcessCache(Dragonfly objDragonfly) throws Exception {
			objDragonfly.logger.add("  ==start==>ClearMyTracksByProcessCache " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	public class ClearMyTracksByProcessCookies {
		public ClearMyTracksByProcessCookies(Dragonfly objDragonfly) throws Exception {
			objDragonfly.logger.add("  ==start==>ClearMyTracksByProcessCookies " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	public class ClipboardGet {
		public String run(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ClipboardGet " + new DateTimestamp().get());
			String strClipboardData = "";
			try {
				strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				objDragonfly.logger.add("ClipboardGet: strClipboardData = " + strClipboardData);
			} catch (Exception e) {
				objDragonfly.logger.add("ClipboardGet: Exception = " + e.toString());
			}
			return strClipboardData;
		}
	}

	public class CommandLineExecution {
		public CommandLineExecution(Dragonfly objDragonfly) throws Exception {
			objDragonfly.logger.add("  ==start==>CommandLineExecution " + new DateTimestamp().get());
			Process p = Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			p.waitFor();
			Process p5 = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 10");
			p5.waitFor();
			String strPathCookiesLow = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Cookies\\Low\\";
			strPathCookiesLow = strPathCookiesLow.replaceAll("\\\\", "/");
			objDragonfly.logger.add("CommandLineExecution: strPathCookiesLow = " + strPathCookiesLow);
			FileUtils.deleteDirectory(new File(strPathCookiesLow));
			String strPathCacheLow = System.getenv("APPDATA") + "Local/Microsoft/Windows/Temporary Internet Files/Low/";
			strPathCacheLow = strPathCacheLow.replaceAll("\\\\", "/");
			objDragonfly.logger.add("CommandLineExecution: strPathCacheLow = " + strPathCacheLow);
			FileUtils.deleteDirectory(new File(strPathCacheLow));
		}
	}

	public class ConvertPathByOperatingSystem {
		public void run(Dragonfly objDragonfl, String strPath) {
			//objDragonfly.logger.add("main: gstrOperatingSystem = " + objDragonfly.objOperatingSystem.strOS);
			//				switch (gstrOperatingSystem) {
			//				case "Windows":
			//					strPathResults = objDragonfly.objPaths.getPathSystemUserDir() + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\" + gstrPathResults + "\\";
			//					strPathImages = "images\\";
			//					break;
			//				case "Mac":
			//					strPathResults = objDragonfly.objPaths.getPathSystemUserDir() + "/Results/" + strTestConfigurationFileName.replace(".json", "") + "/" + gstrPathResults + "/";
			//					strPathImages = "images/";
			//					break;
			//				default:
			//					objDragonfly.logger.add("main: switch gstrOperatingSystem = " + gstrOperatingSystem + "  not supported");
			//					return;
			//				}
		}
	}

	public class CoordinateHighlightScreenshot {
		public CoordinateHighlightScreenshot(Dragonfly objDragonfly, final JSONObjectExtended objJsonObjectStepHighlightArea) {
			objDragonfly.logger.add("  ==start==>CoordinateHighlightScreenshot " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			JFrame objJFrame = new JFrame() {
				private static final long serialVersionUID = 1L;
				{
					Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
					//if (Boolean.parseBoolean(objJsonObjectStepHighlightArea.get("blnHighlight").toString()) == true) {
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
						objDragonfly.logger.add("CoordinateHighlightScreenshot: strHighlightArea = " + objDragonfly.variablesJSON.objectStep.get("strHighlightArea").toString());
						new RectangleAreaByName(objDragonfly, intThickness, objDragonfly.variablesJSON.objectStep.get("strHighlightArea").toString(), objHighlightArea);
						setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
						setUndecorated(true);
						setBackground(new Color(0, 0, 0, 0));
						getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
						setVisible(true);
					}
				}
			};
			int intSleepMilliseconds = 0;
			if (Boolean.parseBoolean(objDragonfly.variablesJSON.objectStep.get("blnScreenshot").toString()) == true) {
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				String strScreenshotFilePath = "";
				try {
					new RectangleAreaByName(objDragonfly, 0, objDragonfly.variablesJSON.objectStep.get("strScreenshotArea").toString(), objHighlightArea);
					BufferedImage objScreenShot = new Robot().createScreenCapture(objHighlightArea);
					strScreenshotFilePath = objDragonfly.objPaths.gstrPathImages + "Screenshot_" + new DateTimestamp().get() + ".jpg";
					Thread objThread = new Thread(new ThreadSaveImage(objDragonfly, objScreenShot, "jpg", strScreenshotFilePath));
					objThread.start();
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strScreenshotFilePath", strScreenshotFilePath);
				} catch (Exception e) {
					objDragonfly.logger.add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
			}
			if (Boolean.parseBoolean(objDragonfly.variablesJSON.objectStep.get("blnHighlight").toString()) == true) {
				try {
					Thread.sleep(intSleepMilliseconds);
				} catch (InterruptedException e) {
					objDragonfly.logger.add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
				objJFrame.setVisible(false);
				objJFrame.dispose();
			}
			objDragonfly.logger.add("CoordinateHighlightScreenshot: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	public class CoordinatesAlert {
		public CoordinatesAlert(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>CoordinatesAlert " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			AutoItX objAutoIt = objDragonfly.objAutoItSetObject.getObject();
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
				switch (objDragonfly.variablesJSON.objectStep.getLowerCase("strAttributeValues")) {
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
				switch (objDragonfly.variablesJSON.objectStep.getLowerCase("strAttributeValues")) {
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
				objDragonfly.variablesJSON.objectStep.putInt("intElementScreenX", intWinPosX);
				objDragonfly.variablesJSON.objectStep.putInt("intElementScreenY", intWinPosY);
				objDragonfly.variablesJSON.objectStep.putInt("intElementWidth", intWinPosWidth);
				objDragonfly.variablesJSON.objectStep.putInt("intElementHeight", intWinPosHeight);
			} catch (Exception e) {
				objDragonfly.logger.add("CoordinatesAlert: Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("CoordinatesAlert: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class CoordinatesBrowserInner {
		public CoordinatesBrowserInner(Dragonfly objDragonfly) throws WebDriverException {
			objDragonfly.logger.add("  ==start==>CoordinatesBrowserInner " + new DateTimestamp().get());
			//objDragonfly.objVariablesSelenium.gobjWebDriverCoordinates = objDragonfly.objVariablesSelenium.gobjWebDriver;
			//objDragonfly.objVariablesSelenium.gobjWebDriverCoordinates.switchTo().defaultContent();
			long lngBrowserInnerWidth = 0;
			long lngBrowserInnerHeight = 0;
			try {
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			} catch (WebDriverException e) {
				objDragonfly.logger.add("CoordinatesBrowserInner: WebDriverException = " + e.toString());
				throw new WebDriverException("WebDriverException returned");
			} catch (Exception e) {
				objDragonfly.logger.add("CoordinatesBrowserInner: Exception = " + e.toString());
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return document.body.offsetWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return document.body.offsetHeight;");
			}
			objDragonfly.variablesJSON.objectStep.putLong("intBrowserInnerWidth", lngBrowserInnerWidth);
			objDragonfly.variablesJSON.objectStep.putLong("intBrowserInnerHeight", lngBrowserInnerHeight);
		}
	}

	public class CoordinatesElement {
		public CoordinatesElement(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>CoordinatesElement " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				//new CoordinatesBrowserInner(objDragonfly);
				int intScrollbar = 0;
				Point objWebDriverPoint = objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().getPosition();
				int intBrowserOuterX = objWebDriverPoint.x;
				int intBrowserOuterY = objWebDriverPoint.y;
				Dimension objWebDriverDimension = objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().getSize();
				int intBrowserOuterWidth = objWebDriverDimension.width;
				int intBrowserOuterHeight = objWebDriverDimension.height;
				objDragonfly.variablesJSON.objectStep.putInt("intBrowserOuterX", intBrowserOuterX);
				objDragonfly.variablesJSON.objectStep.putInt("intBrowserOuterY", intBrowserOuterY);
				objDragonfly.variablesJSON.objectStep.putInt("intBrowserOuterWidth", intBrowserOuterWidth);
				objDragonfly.variablesJSON.objectStep.putInt("intBrowserOuterHeight", intBrowserOuterHeight);
				if (objDragonfly.objVariablesSelenium.gobjWebElement != null) {
					Coordinates objElementCoordinates = ((Locatable) objDragonfly.objVariablesSelenium.gobjWebElement).getCoordinates();
					Point objElementPoint = objElementCoordinates.inViewPort();
					Dimension objElementDimension = objDragonfly.objVariablesSelenium.gobjWebElement.getSize();
					objDragonfly.variablesJSON.objectStep.putInt("intElementX", objElementPoint.x);
					objDragonfly.variablesJSON.objectStep.putInt("intElementY", objElementPoint.y);
					objDragonfly.variablesJSON.objectStep.putInt("intElementWidth", objElementDimension.width);
					objDragonfly.variablesJSON.objectStep.putInt("intElementHeight", objElementDimension.height);
				}
				//objDragonfly.logger.add("CoordinatesElement: objDragonfly.variablesJSON.objectStep.containsKey = " + objDragonfly.variablesJSON.objectStep.containsKey("intElementX"));
				//if (objDragonfly.variablesJSON.objectStep.containsKey("intElementX")) {
				//TODO this is the error
				int intBrowserInnerWidth = objDragonfly.variablesJSON.objectStep.getInt("intBrowserInnerWidth");
				int intBrowserInnerHeight = objDragonfly.variablesJSON.objectStep.getInt("intBrowserInnerHeight");
				int intElementX = objDragonfly.variablesJSON.objectStep.getInt("intElementX");
				int intElementY = objDragonfly.variablesJSON.objectStep.getInt("intElementY");
				int intWindowBorder = (intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2;
				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder;
				objDragonfly.variablesJSON.objectStep.putInt("intElementScreenX", intElementScreenX);
				objDragonfly.variablesJSON.objectStep.putInt("intElementScreenY", intElementScreenY);
				//}
			} catch (Exception e) {
				objDragonfly.logger.add("CoordinatesElement: Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("  ==end==>CoordinatesElement " + new DateTimestamp().get());
				objDragonfly.logger.add("CoordinatesElement: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class DateTimeFormat {
		public String set(Dragonfly objDragonfly, Long lngStartTimeMillis) {
			objDragonfly.logger.add("  ==start==>DateTimeFormat " + new DateTimestamp().get());
			return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS").format(new Date(lngStartTimeMillis));
		}
	}

	public class DateTimestamp {
		public String get() {
			return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
		}
	}

	public class DialogLaunch extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		Dragonfly objDragonfly;
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
		public String gstrNameTest;
		public String gstrTestArea;

		public DialogLaunch(Dragonfly objDragonfly) {
			this.objDragonfly = objDragonfly;
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
			objDragonfly.objVariablesCommon.gstrBrowserSelection = "TestValue";
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rdbtnLocal) {
				this.gstrTestArea = "local";
				objDragonfly.objPaths.gstrTestArea = "local";
				objDragonfly.objPaths.setDirectory("local");
				System.out.println("objDragonfly.objPaths.gstrTestArea = " + objDragonfly.objPaths.gstrTestArea);
				System.out.println(objDragonfly.objPaths.gstrPathSystemUserDir);
				System.out.println(objDragonfly.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = objDragonfly.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + objDragonfly.objPaths.gstrPathTestConfiguration;
				System.out.println("dirPath = " + dirPath);
				this.getApplications();
			}
			if (e.getSource() == rdbtnPublic) {
				this.gstrTestArea = "public";
				objDragonfly.objPaths.gstrTestArea = "public";
				objDragonfly.objPaths.setDirectory("public");
				System.out.println("objDragonfly.objPaths.gstrTestArea = " + objDragonfly.objPaths.gstrTestArea);
				System.out.println(objDragonfly.objPaths.gstrPathSystemUserDir);
				System.out.println(objDragonfly.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = objDragonfly.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + objDragonfly.objPaths.gstrPathTestConfiguration;
				System.out.println("dirPath = " + dirPath);
				this.getApplications();
			}
			if (e.getSource() == rdbtnInternal) {
				this.gstrTestArea = "internal";
				objDragonfly.objPaths.gstrTestArea = "internal";
				objDragonfly.objPaths.setDirectory("internal");
				System.out.println("objDragonfly.objPaths.gstrTestArea = " + objDragonfly.objPaths.gstrTestArea);
				System.out.println(objDragonfly.objPaths.gstrPathSystemUserDir);
				System.out.println(objDragonfly.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = objDragonfly.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + objDragonfly.objPaths.gstrPathTestConfiguration;
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
				objDragonfly.objVariablesCommon.gstrBrowserSelection = "TestValue";
			}
			if (e.getSource() == rdbtnChrome) {
				objDragonfly.objVariablesCommon.gstrBrowserSelection = "chrome";
			}
			if (e.getSource() == rdbtnFirefox) {
				objDragonfly.objVariablesCommon.gstrBrowserSelection = "firefox";
			}
			if (e.getSource() == rdbtnIE) {
				objDragonfly.objVariablesCommon.gstrBrowserSelection = "ie";
			}
			if (e.getSource() == btnRun) {
				System.out.println(comboTest.getSelectedItem());
				objDragonfly.objPaths.gstrNameTest = (String) comboTest.getSelectedItem();
				dispose();
				return;
			}
			if (e.getSource() == btnCancel) {
				dispose();
				return;
			}
		}

		public void getApplications() {
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

		public void getTests() {
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

	public class ElementDisabled {
		public ElementDisabled(Dragonfly objDragonfly) throws ExceptionElementNotDisabled {
			objDragonfly.logger.add("  ==start==>ElementDisabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				//			if (objDragonfly.variablesJSON.objectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				//				if (alertFind() == true) {
				//					return true;
				//				} else {
				//					throw new ExceptionElementNotDisabled("Alert popup was not found.");
				//				}
				//			}
				if (objDragonfly.objVariablesSelenium.gobjWebElement.isEnabled()) {
					throw new ExceptionElementNotDisabled("ElementDisabled - Element is not disabled");
				} else {
					return;
				}
			} finally {
				objDragonfly.logger.add("ElementDisabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementDisabledSync {
		public ElementDisabledSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementDisabledSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnDisabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnDisabled == false) {
						new ElementDisabled(objDragonfly);
						blnDisabled = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					blnDisabled = false;
					objDragonfly.logger.add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotDisabled e) {
					blnDisabled = false;
					objDragonfly.logger.add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementDisabledSync", "syncdisabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnDisabled = false;
					}
				}
			}
		}
	}

	public class ElementDragSync {
		public ElementDragSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementDragSync " + new DateTimestamp().get());
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
						new ElementFind(objDragonfly);
						objDragonfly.logger.add("ElementDragSync: elementFind over");
						if (objDragonfly.objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							objDragonfly.logger.add("ElementDragSync: outerHTML = " + strOuterHTML);
							objDragonfly.logger.add("ElementDragSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						objDragonfly.logger.add("ElementDragSync: strOuterHTML over");
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled(objDragonfly);
						blnEnabled = true;
					}
					objDragonfly.objVariablesSelenium.gobjWebElementDrag = objDragonfly.objVariablesSelenium.gobjWebElement;
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					//} catch (ExceptionElementTagNameNotSupported e) {
					//objDragonfly.logger.add("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					//	blnExit = true;
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementDragSync", "drag", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
					}
				}
			}
		}
	}

	public class ElementDropSync {
		public ElementDropSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementDropSync " + new DateTimestamp().get());
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
						new ElementFind(objDragonfly);
						objDragonfly.logger.add("ElementDropSync: elementFind over");
						if (objDragonfly.objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							objDragonfly.logger.add("ElementDropSync: outerHTML = " + strOuterHTML);
							objDragonfly.logger.add("ElementDropSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						objDragonfly.logger.add("ElementDropSync: strOuterHTML over");
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled(objDragonfly);
						blnEnabled = true;
					}
					objDragonfly.objVariablesSelenium.gobjWebElementDrop = objDragonfly.objVariablesSelenium.gobjWebElement;
					//Actions actions = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
					//actions.dragAndDrop(objDragonfly.objVariablesSelenium.gobjWebElementDrag, objDragonfly.objVariablesSelenium.gobjWebElementDrop).perform();
					//				Actions action = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
					//				Action dragDrop = action.dragAndDrop(gobjWebElementDrag, objDragonfly.objVariablesSelenium.gobjWebElementDrop).build();
					//				dragDrop.perform();
					Actions objActions = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
					Action objDragAndDrop = objActions.clickAndHold(objDragonfly.objVariablesSelenium.gobjWebElementDrag).moveToElement(objDragonfly.objVariablesSelenium.gobjWebElementDrop).release(objDragonfly.objVariablesSelenium.gobjWebElementDrop).build();
					objDragAndDrop.perform();
					//				Actions action = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
					//				action.dragAndDrop(objDragonfly.objVariablesSelenium.gobjWebElementDrag, objDragonfly.objVariablesSelenium.gobjWebElementDrop).build().perform();
					new SleepMilliseconds(objDragonfly, 10000);
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementDropSync", "drop", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					}
				}
			}
		}
	}

	public class ElementEnabled {
		public ElementEnabled(Dragonfly objDragonfly) throws ExceptionElementNotEnabled {
			objDragonfly.logger.add("  ==start==>ElementEnabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (objDragonfly.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run(objDragonfly) == true) {
						return;
					} else {
						throw new ExceptionElementNotEnabled("Alert popup was not found.");
					}
				}
				if (objDragonfly.objVariablesSelenium.gobjWebElement.isEnabled()) {
					return;
				} else {
					throw new ExceptionElementNotEnabled("ElementEnabled - Element is not enabled");
				}
			} finally {
				objDragonfly.logger.add("ElementEnabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementEnabledSync {
		public ElementEnabledSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementEnabledSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnEnabled = false;
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled(objDragonfly);
						blnEnabled = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					blnEnabled = false;
					objDragonfly.logger.add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.logger.add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementEnabledSync", "syncenabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnEnabled = false;
					}
				}
			}
		}
	}

	public class ElementFind {
		public ElementFind(Dragonfly objDragonfly) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			objDragonfly.logger.add("  ==start==>ElementFind " + new DateTimestamp().get());
			if (objDragonfly.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strTagType", "alert");
				if (new AlertFind().run(objDragonfly) == true) {
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strHighlightArea", "alert");
					return;
				} else {
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strHighlightArea", "screen");
					throw new ExceptionElementNotFound("Alert popup not found!");
				}
			}
			if (objDragonfly.variablesJSON.objectStep.get("strTagName").toString().toLowerCase().equals("title")) {
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strTagType", "title");
				return;
			}
			String strWindowHandle = "";
			Object[] arrHandles = objDragonfly.objVariablesSelenium.gobjWebDriver.getWindowHandles().toArray();
			for (int intWindowHandlesEach = arrHandles.length - 1; intWindowHandlesEach >= 0; intWindowHandlesEach--) {
				objDragonfly.logger.add("ElementFind: arrHandles[" + intWindowHandlesEach + "] = " + arrHandles[intWindowHandlesEach].toString());
			}
			for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
				try {
					strWindowHandle = arrHandles[intHandlesEach].toString();
					objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().window(strWindowHandle);
					objDragonfly.objVariablesSelenium.gobjWebDriverCoordinates = objDragonfly.objVariablesSelenium.gobjWebDriver;
					new CoordinatesBrowserInner(objDragonfly);
					List<Integer> arrRouteOriginal = new ArrayList<Integer>();
					new ElementFindFramesSearch().run(objDragonfly, arrRouteOriginal);
					if (objDragonfly.objVariablesSelenium.gobjWebElement != null) {
						//objDragonfly.logger.add("elementFind: objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
						//objDragonfly.logger.add("elementFind: objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle());
						//objDragonfly.logger.add("ElementFindFramesSearch: objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle());
						//objDragonfly.logger.add("ElementFindFramesSearch: objDragonfly.objVariablesSelenium.gobjWebDriver.getCurrentUrl = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getCurrentUrl());
						//objDragonfly.logger.add("ElementFindFramesSearch: objDragonfly.objVariablesSelenium.gobjWebDriver.getWindowHandle = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getWindowHandle());
						//objDragonfly.logger.add("ElementFindFramesSearch objDragonfly.objVariablesSelenium.gobjWebDriver.getPageSource = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getPageSource());
						return;
					}
				} catch (Exception e) {
					objDragonfly.logger.add("ElementFind: Exception = " + e.toString());
				}
			}
			throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
		}
	}

	public class ElementFindBy {
		public ElementFindBy(Dragonfly objDragonfly, String strAttributeNames, String strAttributeValues, String strTagName) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			objDragonfly.logger.add("  ==start==>ElementFindBy " + new DateTimestamp().get());
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
				objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.xpath(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("id")) {
				objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.id(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("name")) {
				objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.name(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("class")) {
				objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.className(strAttributeValues));
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
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strType", arrAttributeValues[intAttributeEach]);
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
				objDragonfly.logger.add("ElementFindBy: strXpath = " + strXpath);
				objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.xpath(strXpath));
			}
			switch (objWebElementCollection.size()) {
			case 0:
				throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
			case 1:
				objDragonfly.objVariablesSelenium.gobjWebElement = objWebElementCollection.get(0);
				break;
			default:
				if (strIndexKeyword.equals("<last>")) {
					objDragonfly.objVariablesSelenium.gobjWebElement = objWebElementCollection.get(objWebElementCollection.size() - 1);
					break;
				} else if (strIndexKeyword.equals("<random>")) {
					int intRandomElement = new RandomNumberRange().run(objDragonfly, 0, objWebElementCollection.size() - 1);
					objDragonfly.objVariablesSelenium.gobjWebElement = objWebElementCollection.get(intRandomElement);
					break;
				} else {
					objDragonfly.logger.add("ElementFindBy: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
					Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
					while (objWebElementEach.hasNext()) {
						WebElement row = objWebElementEach.next();
						objDragonfly.logger.add("outerHTML:=  " + row.getAttribute("outerHTML"));
					}
					throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
				}
			}
		}
	}

	public class ElementFindFramesSearch {
		public boolean run(Dragonfly objDragonfly, List<Integer> arrFramePath) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			objDragonfly.logger.add("  ==start==>ElementFindFramesSearch " + new DateTimestamp().get());
			boolean blnReturn;
			int intMaximumDepth = 100;
			String strTagName = objDragonfly.variablesJSON.objectStep.getLowerCase("strTagName");
			String strAttributeNames = objDragonfly.variablesJSON.objectStep.get("strAttributeNames").toString();
			String strAttributeValues = objDragonfly.variablesJSON.objectStep.get("strAttributeValues").toString();
			try {
				new ElementFindBy(objDragonfly, strAttributeNames, strAttributeValues, strTagName);
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strCurrentWindowHandle", objDragonfly.objVariablesSelenium.gobjWebDriver.getWindowHandle());
				if (objDragonfly.variablesJSON.objectStep.verifyEquals("strTagName", "input")) {
					if (objDragonfly.variablesJSON.objectStep.get("strType").toString().length() == 0) {
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strType", objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("type"));
					}
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strTagType", "input_" + objDragonfly.variablesJSON.objectStep.get("strType").toString());
				} else {
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strTagType", objDragonfly.variablesJSON.objectStep.get("strTagName").toString());
				}
				objDragonfly.logger.add("ElementFindFramesSearch: gobjWebElement outerHTML = " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML"));
				return true;
			} catch (ExceptionElementNotFound | ExceptionMultipleElementsFound | StaleElementReferenceException e) {
				blnReturn = false;
				objDragonfly.logger.add("ElementFindFramesSearch: Exception = " + e.toString());
			}
			if (arrFramePath.size() < intMaximumDepth) {
				int intFramesCount = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.tagName("frame")).size();
				for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
					try {
						objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().frame(intFramesEach);
						List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
						arrFramePathNew.add(intFramesEach);
						blnReturn = new ElementFindFramesSearch().run(objDragonfly, arrFramePathNew);
						if (blnReturn == true) {
							return true;
						}
						objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().defaultContent();
						for (int intFramesPathEach : arrFramePath)
							objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().frame(intFramesPathEach);
					} catch (NoSuchFrameException error) {
						blnReturn = false;
						objDragonfly.logger.add("ElementFindFramesSearch: NoSuchFrameException = " + error.toString());
						break;
					} catch (Exception error) {
						objDragonfly.logger.add("ElementFindFramesSearch: Exception = " + error.toString());
					}
				}
			}
			return blnReturn;
		}
	}

	public class ElementGet {
		public String run(Dragonfly objDragonfly) throws ExceptionElementTagNameNotSupported {
			objDragonfly.logger.add("  ==start==>ElementGet " + new DateTimestamp().get());
			AutoItX objAutoIt = objDragonfly.objAutoItSetObject.getObject();
			switch (objDragonfly.variablesJSON.objectStep.getLowerCase("strTagType")) {
			case "title":
				return objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle();
			case "img":
				return objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("src");
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				return objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("value").trim();
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
				return objDragonfly.objVariablesSelenium.gobjWebElement.getText();
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
			case "input_textarea":
				return objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("value");
			case "input_radio":
			case "input_checkbox":
				if (objDragonfly.objVariablesSelenium.gobjWebElement.isSelected() == false) {
					return "<off>";
				} else {
					return "<on>";
				}
			case "select":
				JavascriptExecutor objExecutor = (JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver;
				return ((String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", objDragonfly.objVariablesSelenium.gobjWebElement)).trim();
			case "table":
				return objDragonfly.objVariablesSelenium.gobjWebElement.getText();
			case "alert":
				if (objDragonfly.variablesJSON.objectStep.verifyEquals("strAttributeValues", "title")) {
					return objAutoIt.winGetTitle("[ACTIVE]");
				} else {
					return objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().alert().getText();
				}
			default:
				throw new ExceptionElementTagNameNotSupported("Element tag not supported");
			}
		}
	}

	public class ElementGetSync {
		public ElementGetSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementGetSync " + new DateTimestamp().get());
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
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnGet == false) {
						strGetValue = new ElementGet().run(objDragonfly);
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strOutputValue", strGetValue);
						blnGet = true;
					}
					blnStatus = true;
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					objDragonfly.logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementGetSync", "get", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
						blnGet = false;
					}
				}
			}
		}
	}

	public class ElementHidden {
		public ElementHidden(Dragonfly objDragonfly) throws ExceptionElementNotHidden {
			objDragonfly.logger.add("  ==start==>ElementHidden " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (objDragonfly.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run(objDragonfly) == false) {
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strHighlightArea", "screen");
						return;
					} else {
						throw new ExceptionElementNotHidden("Alert popup was not hidden.");
					}
				}
				if (objDragonfly.objVariablesSelenium.gobjWebElement.isDisplayed() == false) {
					return;
				} else {
					objDragonfly.logger.add("ElementHidden: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					throw new ExceptionElementNotHidden("Element is displayed.");
				}
			} catch (NullPointerException | WebDriverException e) {
				objDragonfly.logger.add("ElementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				return;
			} finally {
				objDragonfly.logger.add("ElementHidden: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementHiddenSync {
		public ElementHiddenSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementHiddenSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnHidden = false;
			Boolean blnStatus = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnHidden == false) {
						new ElementHidden(objDragonfly);
						blnHidden = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ExceptionElementNotFound e) {
					blnFound = false;
					blnHidden = true;
					blnStatus = true;
					objDragonfly.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnHidden = false;
					objDragonfly.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnHidden = false;
					objDragonfly.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnFound = false;
					blnHidden = false;
					objDragonfly.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementHiddenSync", "synchidden", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnHidden = false;
					}
				}
			}
		}
	}

	public class ElementJavascriptExecutorGetElementsByTagName {
		public String run(Dragonfly objDragonfly) {
			return null;
			//long lngStartTimegetElementsByTagName2 = System.currentTimeMillis();
			//List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
			//objDragonfly.logger.add("ElementJavascriptExecutorGetElementsByTagName objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
			//if (objCollectionJS2.size() > 0) {
			//	long lngStartTimeByXpath = System.currentTimeMillis();
			//}
		}
	}

	public class ElementJavascriptExecutorXPath {
		public String run(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementJavascriptExecutorXPath " + new DateTimestamp().get());
			return (String) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", objDragonfly.objVariablesSelenium.gobjWebElement);
		}
	}

	public class ElementOnMouseOut {
		public ElementOnMouseOut(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementOnMouseOut " + new DateTimestamp().get());
			JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseout();", objDragonfly.objVariablesSelenium.gobjWebElement);
		}
	}

	public class ElementOnMouseOutSync {
		public ElementOnMouseOutSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementOnMouseOutSync " + new DateTimestamp().get());
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
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled(objDragonfly);
						blnEnabled = true;
					}
					if (blnOnMouseOver == false) {
						new ElementOnMouseOut(objDragonfly);
						blnOnMouseOver = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementOnMouseOutSync", "mouse_out", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnOnMouseOver = false;
					}
				}
			}
		}
	}

	public class ElementOnMouseOver {
		public ElementOnMouseOver(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementOnMouseOver " + new DateTimestamp().get());
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseover();", objDragonfly.objVariablesSelenium.gobjWebElement);
		}
	}

	public class ElementOnMouseOverSync {
		public ElementOnMouseOverSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementOnMouseOverSync " + new DateTimestamp().get());
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
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled(objDragonfly);
						blnEnabled = true;
					}
					if (blnOnMouseOver == false) {
						new ElementOnMouseOver(objDragonfly);
						blnOnMouseOver = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementOnMouseOverSync", "mouse_over", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnOnMouseOver = false;
					}
				}
			}
		}
	}

	public class ElementPleaseWait {
		public ElementPleaseWait(Dragonfly objDragonfly) throws ExceptionElementNotHidden {
			objDragonfly.logger.add("  ==start==>ElementPleaseWait " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnPleaseWait = Boolean.parseBoolean(objDragonfly.variablesJSON.objectStep.get("blnPleaseWait").toString());
			Integer intPleaseWaitEach;
			String strAttributeNames = null;
			String strAttributeValues = null;
			String strTagName = null;
			Boolean blnFound = false;
			String strMessage = "";
			try {
				objDragonfly.objVariablesSelenium.gobjWebElementPleaseWait = objDragonfly.objVariablesSelenium.gobjWebElement;
				objDragonfly.logger.add("ElementPleaseWait: objectProcessing.size() = " + objDragonfly.variablesJSON.objectProcessing.size());
				if (blnPleaseWait == true) {
					for (intPleaseWaitEach = 1; intPleaseWaitEach < objDragonfly.variablesJSON.objectProcessing.size(); intPleaseWaitEach++) {
						JSONObjectExtended objJsonObjectPleaseWaitNode = (JSONObjectExtended) objDragonfly.variablesJSON.objectProcessing.get("PleaseWait_" + intPleaseWaitEach);
						try {
							//strAttributeNames = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectPleaseWaitNode, "strAttributeNames", "");
							strAttributeNames = objJsonObjectPleaseWaitNode.getValue("strAttributeNames", "");
							strAttributeValues = objJsonObjectPleaseWaitNode.getValue("strAttributeValues", "");
							strTagName = objJsonObjectPleaseWaitNode.getValue("strTagName", "");
							objDragonfly.logger.add("ElementPleaseWait: variables = " + strAttributeNames + " " + strAttributeValues + " " + strTagName);
						} catch (ExceptionJSONKeyNotPresent e1) {
							// TODO Auto-generated catch block
							objDragonfly.logger.add("ElementPleaseWait: ExceptionJSONKeyNotPresent = " + e1.toString());
						}
						try {
							new ElementFindBy(objDragonfly, strAttributeNames, strAttributeValues, strTagName);
							blnFound = true;
							strMessage = "Element found.";
						} catch (ExceptionElementNotFound e) {
							blnFound = false;
							objDragonfly.logger.add("ElementPleaseWait: ElementFindBy = blnFound = false Milliseconds Waited = " + (System.currentTimeMillis()));
						} catch (ExceptionMultipleElementsFound e) {
							blnFound = true;
							strMessage = "Multiple elements found.";
							objDragonfly.logger.add("ElementPleaseWait: ElementFindBy = blnFound = true Milliseconds Waited = " + (System.currentTimeMillis()));
						}
						if (blnFound == true) {
							if (objDragonfly.objVariablesSelenium.gobjWebElement.isDisplayed() == true) {
								objDragonfly.logger.add("ElementPleaseWait: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis()));
								//throw new ExceptionElementNotHidden("Element is displayed.");
								blnFound = true;
								strMessage = "Element is displayed.";
							} else {
								blnFound = false;
								objDragonfly.logger.add("ElementPleaseWait: gobjWebElement.isDisplayed() = return false Milliseconds Waited = " + (System.currentTimeMillis()));
							}
						}
						if (blnFound == true) {
							return;
						}
					}
				}
			} finally {
				objDragonfly.logger.add("ElementPleaseWait: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				objDragonfly.objVariablesSelenium.gobjWebElement = objDragonfly.objVariablesSelenium.gobjWebElementPleaseWait;
				if (blnFound == true) {
					throw new ExceptionElementNotHidden(strMessage);
				}
			}
		}
	}

	public class ElementScrollSync {
		public ElementScrollSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementScrollSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						blnFound = true;
						objDragonfly.logger.add("ElementScrollSync: blnFound = true");
					}
					JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver;
					objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", objDragonfly.objVariablesSelenium.gobjWebElement);
					blnStatus = true;
					objDragonfly.logger.add("ElementScrollSync: blnStatus = true");
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.logger.add("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementScrollSync", "scroll", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					}
				}
			}
		}
	}

	public class ElementSet {
		public ElementSet(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionVisibleTextNotInSelectList, ExceptionKeywordNotValid {
			objDragonfly.logger.add("  ==start==>ElementSet " + new DateTimestamp().get());
			objDragonfly.logger.add("ElementSet: " + objDragonfly.variablesJSON.objectStep.getLowerCase("strAttributeValues"));
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
			String strValueToSelect = "";
			String strAttributeValues = objDragonfly.variablesJSON.objectStep.getLowerCase("strAttributeValues");
			String strTagType = objDragonfly.variablesJSON.objectStep.getLowerCase("strTagType");
			String strSetType = "";
			try {
				//Iterator<WebElement> b;
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
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", "<click>");
						objDragonfly.objVariablesSelenium.gobjWebElement.click();
						strSetType = "click";
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
						objAction.moveToElement(objDragonfly.objVariablesSelenium.gobjWebElement).doubleClick().build().perform();
						strSetType = "double_click";
						break;
					case "<rightclick>":
						//ToDo add right click code
						Actions action = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
						action.contextClick(objDragonfly.objVariablesSelenium.gobjWebElement).build().perform();
						//						Actions action= new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
						//						action.contextClick(objDragonfly.objVariablesSelenium.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
					if (objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("value").isEmpty() == false) {
						objDragonfly.objVariablesSelenium.gobjWebElement.clear();
					}
					objDragonfly.objVariablesSelenium.gobjWebElement.sendKeys(strInputValue);
					strSetType = "Set";
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", "<on>");
						if (objDragonfly.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objDragonfly.objVariablesSelenium.gobjWebElement.click();
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
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", "<on>");
						if (objDragonfly.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objDragonfly.objVariablesSelenium.gobjWebElement.click();
						}
						break;
					case "<off>":
						if (objDragonfly.objVariablesSelenium.gobjWebElement.isSelected() == true) {
							objDragonfly.objVariablesSelenium.gobjWebElement.click();
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					strSetType = "Click";
					break;
				case "select":
					//ToDo add throws UnexpectedTagNameException when element is not a SELECT
					Select objSelect = new Select(objDragonfly.objVariablesSelenium.gobjWebElement);
					objSelect.getOptions();
					//objSelect.selectByVisibleText(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
					// set_js
					//					int intOptionsEach;
					//					String strOptions = "";
					//					String[] arrOptions;
					//					strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objDragonfly.objVariablesSelenium.gobjWebElement);
					//					strOptions = strOptions.substring(1);
					//					arrOptions = strOptions.split("\\|");
					//					for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					//						objDragonfly.logger.add("elementSet: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					//						if (arrOptions[intOptionsEach].toString().equals(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString())) {
					//							blnSet = true;
					//							Select objSelect = new Select(objDragonfly.objVariablesSelenium.gobjWebElement);
					//							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							objSelect.selectByIndex(intOptionsEach);
					//							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							// if (strOuterHTML.toLowerCase().contains("onchange")) {
					//							// try {
					//							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							// } catch (WebDriverException e) {
					//							// objDragonfly.logger.add("elementSet = " + e.toString());
					//							// }
					//							// }
					//							break;
					//						}
					//					}
					int intOptionsLength = objSelect.getOptions().size();
					strValueToSelect = strInputValue;
					switch (strInputValue.toLowerCase()) {
					case "":
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
						int intRandom = new RandomNumberRange().run(objDragonfly, 0, intOptionsLength - 1);
						strValueToSelect = objSelect.getOptions().get(intRandom).getText();
						break;
					}
					try {
						objSelect.selectByVisibleText(strValueToSelect);
					} catch (NoSuchElementException e) {
						throw new ExceptionVisibleTextNotInSelectList(e.getMessage());
					}
					//					b = objSelect.getOptions().iterator();
					//					for (WebElement we : b) {
					//						if (strInputValue.equalsIgnoreCase(we.getText())) {
					//						}
					//					}
					//List<WebElement> objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.tagName(strTagName));
					//Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
					//					b = objSelect.getOptions().iterator();
					//					while (b.hasNext()) {
					//						WebElement row = b.next();
					//						if (strInputValue.equalsIgnoreCase(row.getText())) {
					//						}
					//					}
					strSetType = "Select";
					break;
				case "table":
					break;
				case "alert":
					switch (strAttributeValues) {
					case "edit":
						objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().alert().sendKeys(strInputValue);
						strSetType = "Set";
						break;
					case "accept":
						objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().alert().accept();
						strSetType = "Click";
						break;
					case "dismiss":
						objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().alert().dismiss();
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
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStepExpected", strSetType);
				objDragonfly.logger.add("ElementSet: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementSetJavascriptExecutor {
		public ElementSetJavascriptExecutor(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet, ExceptionKeywordNotValid {
			objDragonfly.logger.add("  ==start==>ElementSetJavascriptExecutor " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
			String strValueToSelect = "";
			String strAttributeValues = objDragonfly.variablesJSON.objectStep.getLowerCase("strAttributeValues");
			String strTagType = objDragonfly.variablesJSON.objectStep.getLowerCase("strTagType");
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver;
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
						objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objVariablesSelenium.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objVariablesSelenium.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objVariablesSelenium.gobjWebElement);
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
						objAction.moveToElement(objDragonfly.objVariablesSelenium.gobjWebElement).doubleClick().build().perform();
						break;
					case "<rightclick>":
						//ToDo add right click code javascript
						Actions action = new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
						action.contextClick(objDragonfly.objVariablesSelenium.gobjWebElement).build().perform();
						//						Actions action= new Actions(objDragonfly.objVariablesSelenium.gobjWebDriver);
						//						action.contextClick(objDragonfly.objVariablesSelenium.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
					//objDragonfly.logger.add("  ==start==>ElementSetJavascriptExecutor inputtext" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//objDragonfly.logger.add("  ==start==>ElementSetJavascriptExecutor focus" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '';", objDragonfly.objVariablesSelenium.gobjWebElement);
					//objDragonfly.logger.add("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '" + strInputValue + "';", objDragonfly.objVariablesSelenium.gobjWebElement);
					//objDragonfly.logger.add("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//objDragonfly.logger.add("onchange blur");
					if (strOuterHTML.toLowerCase().contains("onchange")) {
						try {
							//objDragonfly.logger.add("  ==start==>ElementSetJavascriptExecutor strOuterHTML" + new DateTimestamp().get());
							objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objVariablesSelenium.gobjWebElement);
						} catch (WebDriverException e) {
							objDragonfly.logger.add("ElementSetJavascriptExecutor = WebDriverException: " + e.toString());
						}
					}
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", "<on>");
						if (objDragonfly.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									objDragonfly.logger.add("ElementSetJavascriptExecutor = " + e.toString());
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
						if (objDragonfly.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									objDragonfly.logger.add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					case "<off>":
						if (objDragonfly.objVariablesSelenium.gobjWebElement.isSelected() == true) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									objDragonfly.logger.add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					break;
				case "select":
					Select objSelect = new Select(objDragonfly.objVariablesSelenium.gobjWebElement);
					objSelect.getOptions();
					objSelect.selectByVisibleText(strInputValue);
					// set_js
					//					int intOptionsEach;
					//					String strOptions = "";
					//					String[] arrOptions;
					//					strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objDragonfly.objVariablesSelenium.gobjWebElement);
					//					strOptions = strOptions.substring(1);
					//					arrOptions = strOptions.split("\\|");
					//					for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					//						objDragonfly.logger.add("ElementSetJavascriptExecutor: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					//						if (arrOptions[intOptionsEach].toString().equals(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString())) {
					//							blnSet = true;
					//							Select objSelect = new Select(objDragonfly.objVariablesSelenium.gobjWebElement);
					//							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							objSelect.selectByIndex(intOptionsEach);
					//							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							// if (strOuterHTML.toLowerCase().contains("onchange")) {
					//							// try {
					//							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objVariablesSelenium.gobjWebElement);
					//							// } catch (WebDriverException e) {
					//							// objDragonfly.logger.add("ElementSetJavascriptExecutor = " + e.toString());
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
				objDragonfly.logger.add("ElementSetJavascriptExecutor: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementSetSync {
		public ElementSetSync(Dragonfly objDragonfly, boolean blnJavascriptExecutor) {
			objDragonfly.logger.add("  ==start==>ElementSetSync " + new DateTimestamp().get());
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
			objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strOutputValue", objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						if (objDragonfly.objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							objDragonfly.logger.add("ElementSetSync: " + strOuterHTML);
							objDragonfly.logger.add("ElementSetSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled(objDragonfly);
						blnEnabled = true;
					}
					switch (objDragonfly.variablesJSON.objectStep.getLowerCase("strAssert")) {
					case "off":
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
						if (blnSet == false) {
							new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(objDragonfly, strOuterHTML);
							} else {
								new ElementSet(objDragonfly, strOuterHTML);
							}
							blnSet = true;
							blnAssert = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(objDragonfly, strOuterHTML);
							blnSetSync = true;
						}
						blnStatus = true;
						break;
					case "hidden":
						if (blnSet == false) {
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
							new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(objDragonfly, strOuterHTML);
							} else {
								new ElementSet(objDragonfly, strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(objDragonfly, strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementHidden(objDragonfly);
							blnAssert = true;
						}
						blnStatus = true;
						break;
					case "value":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(objDragonfly, strOuterHTML);
							} else {
								new ElementSet(objDragonfly, strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(objDragonfly, strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVerifyValue().run(objDragonfly);
							blnAssert = true;
						}
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						blnStatus = true;
						break;
					case "visible":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(objDragonfly, strOuterHTML);
							} else {
								new ElementSet(objDragonfly, strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(objDragonfly, strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVisible(objDragonfly);
							blnAssert = true;
						}
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						blnStatus = true;
						break;
					case "enabled":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(objDragonfly, strOuterHTML);
							} else {
								new ElementSet(objDragonfly, strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(objDragonfly, strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVisible(objDragonfly);
							new ElementEnabled(objDragonfly);
							blnAssert = true;
						}
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						blnStatus = true;
						break;
					case "disabled":
						if (blnSet == false) {
							if (blnJavascriptExecutor == true) {
								new ElementSetJavascriptExecutor(objDragonfly, strOuterHTML);
							} else {
								new ElementSet(objDragonfly, strOuterHTML);
							}
							blnSet = true;
						}
						if (blnSetSync == false) {
							new ElementSetSyncComplete(objDragonfly, strOuterHTML);
							blnSetSync = true;
						}
						if (blnAssert == false) {
							new ElementVisible(objDragonfly);
							new ElementDisabled(objDragonfly);
							blnAssert = true;
						}
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						blnStatus = true;
						break;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported | ExceptionKeywordNotValid e) {
					blnExit = true;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionVisibleTextNotInSelectList e) {
					blnSet = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnAssert = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnSet = false;
					blnSetSync = false;
					blnAssert = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotSet e) {
					blnSet = false;
					blnAssert = false;
				} catch (ExceptionElementNotDisabled e) {
					blnAssert = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionAlertNotComplete | ExceptionDoPostBackNotComplete | ExceptionJQueryAjaxNotComplete | ExceptionJQueryAnimationNotComplete | ExceptionAngularJsNotComplete | ExceptionPleaseWaitNotComplete e) {
					blnSetSync = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnAssert = false;
					blnEnabled = false;
					blnFound = false;
					blnSet = false;
					blnSetSync = false;
					blnVisible = false;
					objDragonfly.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementSetSync", "set", lngTimeStart) == true) {
						if (blnStatus == false) {
							new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						}
						return;
					}
				}
			}
		}
	}

	public class ElementSetSyncComplete {
		public ElementSetSyncComplete(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionAlertNotComplete, ExceptionDoPostBackNotComplete, ExceptionJQueryAjaxNotComplete, ExceptionJQueryAnimationNotComplete, ExceptionAngularJsNotComplete, ExceptionPleaseWaitNotComplete {
			objDragonfly.logger.add("  ==start==>ElementSetSyncComplete " + new DateTimestamp().get());
			long lngTimeStart = System.currentTimeMillis();
			try {
				if (objDragonfly.objVariablesSetSync.gblnSyncPleaseWait == false) {
					///SyncPleaseWait
					new SyncPleaseWait(objDragonfly);
					objDragonfly.objVariablesSetSync.gblnSyncPleaseWait = true;
				}
				//				if (objDragonfly.objVariablesSetSync.gblnSyncAlert == false) {
				//					///SyncAlert
				//					new SyncAlert(objDragonfly);
				//					objDragonfly.objVariablesSetSync.gblnSyncAlert = true;
				//				}
				if (objDragonfly.objVariablesSetSync.gblnSyncWaitForReadyState == false) {
					///SyncWaitForReadyState
					new SyncWaitForReadyState(objDragonfly);
					objDragonfly.objVariablesSetSync.gblnSyncWaitForReadyState = true;
				}
				if (objDragonfly.objVariablesSetSync.gblnSyncDoPostBack == false) {
					///SyncDoPostBack
					new SyncDoPostBack(objDragonfly, strOuterHTML);
					objDragonfly.objVariablesSetSync.gblnSyncDoPostBack = true;
				}
				if (objDragonfly.objVariablesSetSync.gblnSyncJQueryAjax == false) {
					///SyncJQueryAjax
					new SyncJQueryAjax(objDragonfly);
					objDragonfly.objVariablesSetSync.gblnSyncJQueryAjax = true;
				}
				if (objDragonfly.objVariablesSetSync.gblnSyncJQueryAnimation == false) {
					///SyncJQueryAnimation
					new SyncJQueryAnimation(objDragonfly);
					objDragonfly.objVariablesSetSync.gblnSyncJQueryAnimation = true;
				}
				if (objDragonfly.objVariablesSetSync.gblnSyncAngularJs == false) {
					///SyncAngularJs
					new SyncAngularJs(objDragonfly);
					objDragonfly.objVariablesSetSync.gblnSyncAngularJs = true;
				}
			} finally {
				objDragonfly.logger.add("ElementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
			}
		}
	}

	public class ElementVerifyNotValue {
		public String run(Dragonfly objDragonfly) throws ExceptionValueMatched, ExceptionElementTagNameNotSupported {
			objDragonfly.logger.add("  ==start==>ElementVerifyNotValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
			try {
				strGetValue = new ElementGet().run(objDragonfly);
				strActualValue = new VerifyNotMatch().run(objDragonfly, strGetValue, strValueExpected);
				objDragonfly.logger.add("ElementVerifyNotValue: after VerifyNotMatch");
			} catch (ExceptionValueMatched e) {
				objDragonfly.logger.add("ElementVerifyNotValue: " + e.toString());
				throw new ExceptionValueMatched("ElementVerifyNotValue: Exception strActualValue = {" + strActualValue + "}");
			} finally {
				objDragonfly.logger.add("ElementVerifyNotValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	public class ElementVerifyNotValueSync {
		public ElementVerifyNotValueSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementVerifyNotValueSync " + new DateTimestamp().get());
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
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnVerifiedNot == false) {
						strActualValue = new ElementVerifyNotValue().run(objDragonfly);
						blnVerifiedNot = true;
					}
					blnStatus = true;
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					objDragonfly.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					//blnVerifiedNot = false;
					objDragonfly.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					//blnVisible = false;
					objDragonfly.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueMatched e) {
					//blnVerifiedNot = false;
					objDragonfly.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					//blnVerifiedNot = false;
					objDragonfly.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementVerifyNotValueSync", "verify_not", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
						blnVerifiedNot = false;
					}
				}
			}
		}
	}

	public class ElementVerifyValue {
		public String run(Dragonfly objDragonfly) throws ExceptionValueNotMatched, ExceptionElementTagNameNotSupported {
			objDragonfly.logger.add("  ==start==>ElementVerifyValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
			try {
				strGetValue = new ElementGet().run(objDragonfly);
				strActualValue = new VerifyMatch().run(objDragonfly, strGetValue, strValueExpected);
			} finally {
				objDragonfly.logger.add("ElementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	public class ElementVerifyValueSync {
		public ElementVerifyValueSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementVerifyValueSync " + new DateTimestamp().get());
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
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					if (blnVerified == false) {
						strActualValue = new ElementVerifyValue().run(objDragonfly);
						blnVerified = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					blnVerified = false;
					objDragonfly.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					objDragonfly.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnVerified = false;
					objDragonfly.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnVerified = false;
					objDragonfly.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementVerifyValueSync", "verify", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
						blnVerified = false;
					}
				}
			}
		}
	}

	public class ElementVisible {
		public ElementVisible(Dragonfly objDragonfly) throws ExceptionElementNotVisible {
			// TODO elementVisible add check for class and css, commented code needs to be tested
			objDragonfly.logger.add("  ==start==>ElementVisible " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnVisible = false;
			try {
				// TODO Alert complete
				if (objDragonfly.variablesJSON.objectStep.verifyEquals("strTagName", "title")) {
					blnVisible = true;
					return;
				}
				if (objDragonfly.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run(objDragonfly) == true) {
						blnVisible = true;
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strHighlightArea", "alert");
						new CoordinatesAlert(objDragonfly);
						return;
					} else {
						throw new ExceptionElementNotVisible("Alert popup was not found.");
					}
				}
				if (objDragonfly.objVariablesSelenium.gobjWebElement.isDisplayed()) {
					new CoordinatesElement(objDragonfly);
					blnVisible = true;
					return;
					// if (objDragonfly.variablesJSON.objectStep.containsKey("intElementWidth")) {
					// int intElementWidth = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intElementWidth").toString());
					// int intElementHeight = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intElementHeight").toString());
					// objDragonfly.logger.add("elementVisible intElementWidth = " + intElementWidth);
					// objDragonfly.logger.add("elementVisible intElementHeight = " + intElementHeight);
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
				objDragonfly.logger.add("ElementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementVisibleSync {
		public ElementVisibleSync(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ElementVisibleSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			Boolean blnVisible = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible(objDragonfly);
						blnVisible = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					objDragonfly.logger.add("ElementVisibleSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementVisibleSync", "syncvisible", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.variablesJSON.objectStep);
						return;
					} else {
						blnVisible = false;
					}
				}
			}
		}
	}

	public class ExceptionAlertNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionAlertNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionAngularJsNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionAngularJsNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionBrowserDriverNotSupported extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionBrowserDriverNotSupported(String message) {
			super(message);
		}
	}

	public class ExceptionDoPostBackNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionDoPostBackNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotDisabled extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotDisabled(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotEnabled extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotEnabled(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotFound extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotFound(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotHidden extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotHidden(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotSet extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotSet(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotVisible extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotVisible(String message) {
			super(message);
		}
	}

	public class ExceptionElementTagNameNotSupported extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementTagNameNotSupported(String message) {
			super(message);
		}
	}

	public class ExceptionElementValueNotVerified extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementValueNotVerified(String message) {
			super(message);
		}
	}

	public class ExceptionJQueryAjaxNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionJQueryAjaxNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionJQueryAnimationNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionJQueryAnimationNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionJSONKeyNotPresent extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionJSONKeyNotPresent(String message) {
			super(message);
		}
	}

	public class ExceptionKeywordNotValid extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionKeywordNotValid(String message) {
			super(message);
		}
	}

	public class ExceptionMultipleElementsFound extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionMultipleElementsFound(String message) {
			super(message);
		}
	}

	public class ExceptionPleaseWaitNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionPleaseWaitNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionTestInstanceMoreThanOne extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionTestInstanceMoreThanOne(String message) {
			super(message);
		}
	}

	public class ExceptionValueMatched extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionValueMatched(String message) {
			super(message);
		}
	}

	public class ExceptionValueNotMatched extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionValueNotMatched(String message) {
			super(message);
		}
	}

	public class ExceptionVisibleTextNotInSelectList extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionVisibleTextNotInSelectList(String message) {
			super(message);
		}
	}

	public class ImageDecodeFromString {
		public BufferedImage run(Dragonfly objDragonfly, String strImageString) {
			objDragonfly.logger.add("  ==start==>ImageDecodeFromString " + new DateTimestamp().get());
			BufferedImage objBufferedImage = null;
			byte[] arrImageByte;
			try {
				BASE64Decoder objBASE64Decoder = new BASE64Decoder();
				arrImageByte = objBASE64Decoder.decodeBuffer(strImageString);
				ByteArrayInputStream objByteArrayInputStream = new ByteArrayInputStream(arrImageByte);
				objBufferedImage = ImageIO.read(objByteArrayInputStream);
				objByteArrayInputStream.close();
			} catch (Exception e) {
				e.toString();
			}
			return objBufferedImage;
		}
	}

	public class ImageEncodeToString {
		public String run(Dragonfly objDragonfly, BufferedImage objBufferedImage, String strImageType) {
			objDragonfly.logger.add("  ==start==>ImageEncodeToString " + new DateTimestamp().get());
			String strImageString = null;
			ByteArrayOutputStream objByteArrayOutputStreams = new ByteArrayOutputStream();
			try {
				ImageIO.write(objBufferedImage, strImageType, objByteArrayOutputStreams);
				byte[] arrImageByte = objByteArrayOutputStreams.toByteArray();
				BASE64Encoder objBASE64Encoder = new BASE64Encoder();
				strImageString = objBASE64Encoder.encode(arrImageByte);
				objByteArrayOutputStreams.close();
			} catch (IOException e) {
				e.toString();
			}
			return strImageString;
		}
	}

	public class InternetExplorerProcessKill {
		public InternetExplorerProcessKill(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>InternetExplorerProcessKill " + new DateTimestamp().get());
			DesiredCapabilities desiredCapabilities = null;
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(objDragonfly, 1000);
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setJavascriptEnabled(true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			objDragonfly.objVariablesSelenium.gobjWebDriver = new InternetExplorerDriver(desiredCapabilities);
			objDragonfly.objVariablesSelenium.gobjWebDriver.get("about:blank");
			objDragonfly.objVariablesSelenium.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
			// objDragonfly.objVariablesSelenium.gobjWebDriver.navigate().to(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString());
			// objDragonfly.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
			// objDragonfly.objVariablesSelenium.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			// // objDragonfly.objVariablesSelenium.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
			objDragonfly.objVariablesSelenium.gobjWebDriver.close();
			objDragonfly.objVariablesSelenium.gobjWebDriver.quit();
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(objDragonfly, 1000);
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 1
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 32
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255
			// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 4351
		}
	}

	public class InternetExplorerVersion {
		private String strKeyName = "";
		private Process objProcess;
		private String strSvcUpdateVersion = "11.0.27";
		private String strSvcvcVersion = "11.0.9600.18163";
		private String strSvcvcKBNumber = "KB3124275";
		private String strExpectedKeyValue = "";
		private String strActualKeyValue = "";

		public void verify(Dragonfly objDragonfly) throws IOException {
			objDragonfly.logger.add("  ==start==>InternetExplorerVersion " + new DateTimestamp().get());
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
					objDragonfly.logger.add(strFullRegistryKey.replaceAll("\\s+", " ").trim());
					objDragonfly.logger.add(strActualKeyValue);
				}
			}
		}
	}

	public class JSONObjectExtended extends JSONObject {
		private static final long serialVersionUID = 1L;

		public JSONObjectExtended(JSONObject parent) {
			super(parent);
		}

		public Boolean getBoolean(String strKeyName) {
			return Boolean.parseBoolean(this.get(strKeyName).toString());
		}

		public int getInt(String strKeyName) {
			if (this.get(strKeyName).toString().equals("")) {
				return 0;
			}
			return Integer.parseInt(this.get(strKeyName).toString());
		}

		public String getLowerCase(String strKeyName) {
			return this.get(strKeyName).toString().toLowerCase();
		}

		public String getValue(String strInputValue, String strKeywordName) throws ExceptionJSONKeyNotPresent {
			Dragonfly.this.logger.add("  ==start==>JSONObjectExtended: getValue " + new DateTimestamp().get());
			String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
			String strJSONObjectValue = "";
			Dragonfly.this.logger.add("JSONObjectExtended: getValue strJSONObjectKey = " + strJSONObjectKey);
			this.validateKey(strJSONObjectKey);
			strJSONObjectValue = this.get(strJSONObjectKey).toString();
			Dragonfly.this.logger.add("JSONObjectExtended: getValue strJSONObjectValue = " + strJSONObjectValue);
			//objDragonfly.logger.add(super().objVariablesCommon.gstrBrowserSelection);
			//			
			//super().logger.add("test");
			return strJSONObjectValue;
			//			if (objJSONObject.containsKey(strJSONObjectKey)) {
			//				strJSONObjectValue = objJSONObject.get(strJSONObjectKey).toString();
			//				objDragonfly.logger.add("JsonObjectGetValue: strJSONObjectValue = " + strJSONObjectValue);
			//				return strJSONObjectValue;
			//			} else {
			//				objDragonfly.logger.add("JsonObjectGetValue: JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
			//				throw new ExceptionJSONKeyNotPresent("JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
			//			}
		}

		@SuppressWarnings("unchecked")
		public void putInt(String strKeyName, int intKeyValue) {
			this.put(strKeyName, Integer.toString(intKeyValue));
		}

		@SuppressWarnings("unchecked")
		public void putLong(String strKeyName, Long lngKeyValue) {
			this.put(strKeyName, Long.toString(lngKeyValue));
		}

		@SuppressWarnings("unchecked")
		public void putValue(Dragonfly objDragonfly, String strKeyName, String strKeyValue) {
			this.put(strKeyName, strKeyValue);
		}

		public void validateKey(String strKeyName) throws ExceptionJSONKeyNotPresent {
			Dragonfly.this.logger.add("  ==start==>JSONObjectExtended: validateKey " + new DateTimestamp().get());
			if (!this.containsKey(strKeyName)) {
				throw new ExceptionJSONKeyNotPresent("JSON Key " + strKeyName + " not present");
			}
		}

		public Boolean verifyEquals(String strKeyName, String strLowerCaseValue) {
			return this.get(strKeyName).toString().toLowerCase().equals(strLowerCaseValue);
		}

		public Boolean verifyKeyValue(String file) throws IOException {
			Dragonfly.this.logger.add("  ==start==>WriteJsonKeys " + new DateTimestamp().get());
			return null;
		}

		public void writeKeys(String file) throws IOException {
			Dragonfly.this.logger.add("  ==start==>WriteJsonKeys " + new DateTimestamp().get());
			for (Iterator<?> iterator = this.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				Dragonfly.this.logger.add("WriteJsonKeys: " + key + " = " + this.get(key));
			}
		}
	}

	//	public class JsonObjectGetValue {
	//		public String run(Dragonfly objDragonfly, JSONObject objJSONObject, String strInputValue, String strKeywordName) throws ExceptionJSONKeyNotPresent {
	//			objDragonfly.logger.add("  ==start==>JsonObjectGetValue run " + new DateTimestamp().get());
	//			String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
	//			String strJSONObjectValue = "";
	//			objDragonfly.logger.add("JsonObjectGetValue run strJSONObjectKey = " + strJSONObjectKey);
	//			if (objJSONObject.containsKey(strJSONObjectKey)) {
	//				strJSONObjectValue = objJSONObject.get(strJSONObjectKey).toString();
	//				objDragonfly.logger.add("JsonObjectGetValue: strJSONObjectValue = " + strJSONObjectValue);
	//				return strJSONObjectValue;
	//			} else {
	//				objDragonfly.logger.add("JsonObjectGetValue: JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
	//				throw new ExceptionJSONKeyNotPresent("JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
	//			}
	//		}
	//	}
	//	public class JsonObjectStepPut {
	//		@SuppressWarnings("unchecked")
	//		public void run(Dragonfly objDragonfly, String strKeyName, String strKeyValue) {
	//			objDragonfly.variablesJSON.objectStep.put(strKeyName, strKeyValue);
	//		}
	//	}
	//	public class JsonObjectValidateKey {
	//		public JsonObjectValidateKey(Dragonfly objDragonfly, JSONObject objJSONObject, String strKeyName) throws ExceptionJSONKeyNotPresent {
	//			objDragonfly.logger.add("  ==start==>JsonObjectValidateKey " + new DateTimestamp().get());
	//			if (!objJSONObject.containsKey(strKeyName)) {
	//				throw new ExceptionJSONKeyNotPresent("JSON Key " + strKeyName + " not present");
	//			}
	//		}
	//	}
	public class JvmBitVersion {
		public String get() {
			String strJvmBitVersion = System.getProperty("sun.arch.data.model");
			Dragonfly.this.logger.add("JvmBitVersion: System.getProperty(sun.arch.data.model) = " + strJvmBitVersion + " " + new DateTimestamp().get());
			return strJvmBitVersion;
		}
	}

	public class KeywordAndValue {
		private String strKeyword;
		private String strValue;

		public KeywordAndValue(Dragonfly objDragonfly, String strValueToFindKeyword) {
			strKeyword = "";
			strValue = strValueToFindKeyword;
			int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
			if (intRightArrowPosition > -1) {
				strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
				strValue = strValueToFindKeyword.replace(strKeyword, "");
			}
			objDragonfly.logger.add("KeywordAndValue: strKeyword = " + strKeyword);
			objDragonfly.logger.add("KeywordAndValue: strValue = " + strValue);
		}
	}

	public class KeywordReturn {
		public String run(Dragonfly objDragonfly, String strValueToFindKeyword) {
			String strKeyword = "";
			int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
			if (intRightArrowPosition > -1) {
				strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
			}
			objDragonfly.logger.add("KeywordReturn: strKeyword " + strKeyword);
			return strKeyword;
		}
	}

	public class KeywordsValid {
		//TODO KeywordsValid to check all
		private String strValidKeyword_strLogicalName = "<te>";
		private String strValidKeyword_strAttributeValues = "<re>|<td>|<ti>|<tl>";
		private String strValidKeyword_strInputValue = "<re>|<td>|<ti>|<tl>|<click>|<doubleclick>|<rightclick>|<on>|<off>|<blank>|<first>|<second>|<third>|<last>|<random>";
		private String strValidKeyword_strLoopOrIf = "<if>|<else if>|<else>|<end if>|<loopstart>|<loopexit>|<loopend>";
		private String strKeywordValue = "";
		//private String strValueReturnedByKeyword = "";
		private String strInputValueFromJson = "";
		private String strKeywordEach = "";
		private String[] arrResults;

		public KeywordsValid(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>KeywordsValid " + new DateTimestamp().get());
			String strKey = "";
			String[] arrKeys = new StepNames().getOriginal();
			String strValueToFindKeyword;
			//String[] arrKeywords;
			boolean blnValid = false;
			String[] arrKeywordsValid;
			for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
				strKey = arrKeys[intKeysEach].toString();
				objDragonfly.logger.add("KeywordsValid: ----------------->strKey = " + strKey);
				//objDragonfly.objJsonObjectStepPut.run(objDragonfly, strKey, "");
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
					strValueToFindKeyword = objDragonfly.variablesJSON.objectStep.get(strKey).toString();
					String[] arrKeywords1 = this.getKeywordsAndValue(objDragonfly, strValueToFindKeyword);
					if (arrKeywords1.length > 0) {
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "blnExitOnFail", "true");
					}
					break;
				case "strLogicalName":
					arrKeywordsValid = strValidKeyword_strLogicalName.split("\\|");
					strValueToFindKeyword = objDragonfly.variablesJSON.objectStep.get(strKey).toString();
					String[] arrKeywords2 = this.getKeywordsAndValue(objDragonfly, strValueToFindKeyword);
					objDragonfly.logger.add("KeywordsValid: arrKeywords2.length = " + arrKeywords2.length);
					for (int intKeywordsEach = 0; intKeywordsEach < arrKeywords2.length; intKeywordsEach++) {
						objDragonfly.logger.add("KeywordsValid: arrKeywords2[intKeywordsEach].toString() = " + arrKeywords2[intKeywordsEach].toString());
						for (int intKeywordsValidEach = 0; intKeywordsValidEach < arrKeywordsValid.length; intKeywordsValidEach++) {
							if (arrKeywords2[intKeywordsEach].toString().equals(arrKeywordsValid[intKeywordsValidEach].toString())) {
								blnValid = true;
								//TODO this should be moved to the TestConfiguration setup
								JSONObjectExtended objJsonObjectElementNode = objDragonfly.new JSONObjectExtended((JSONObject) objDragonfly.variablesJSON.objectElement.get(strKeywordValue));
								try {
									objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strTagName", objJsonObjectElementNode.getValue("strTagName", ""));
									objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strAttributeNames", objJsonObjectElementNode.getValue("strAttributeNames", ""));
									objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strAttributeValues", objJsonObjectElementNode.getValue("strAttributeValues", ""));
								} catch (ExceptionJSONKeyNotPresent e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
						}
						if (blnValid = false) {
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "blnExitOnFail", "true");
							break;
						}
					}
					break;
				case "strAttributeValues":
					arrKeywordsValid = strValidKeyword_strAttributeValues.split("\\|");
					strValueToFindKeyword = objDragonfly.variablesJSON.objectStep.get(strKey).toString();
					strKeywordValue = strValueToFindKeyword;
					String[] arrKeywords3 = this.getKeywordsAndValue(objDragonfly, strValueToFindKeyword);
					for (int intKeywordsEach = 0; intKeywordsEach < arrKeywords3.length; intKeywordsEach++) {
						objDragonfly.logger.add("KeywordsValid: arrKeywords3[intKeywordsEach].toString() = " + arrKeywords3[intKeywordsEach].toString());
						//for (int intKeywordsValidEach = 0; intKeywordsValidEach < arrKeywordsValid.length; intKeywordsValidEach++) {
						for (int intKeywordsValidEach = arrKeywordsValid.length; intKeywordsValidEach < 0; intKeywordsValidEach--) {
							strKeywordEach = arrKeywords3[intKeywordsEach].toString();
							if (strKeywordEach.equals(arrKeywordsValid[intKeywordsValidEach].toString())) {
								blnValid = true;
								strKeywordValue = this.getJsonValue(objDragonfly, strKeywordEach, strKeywordValue);
								break;
							}
						}
						if (blnValid = false) {
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "blnExitOnFail", "true");
							break;
						}
						//strValueReturnedByKeyword= objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJSONObject, strInputValue, arrKeywords[intKeywordsEach].toString());
					}
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strAttributeValues", strKeywordValue);
					break;
				case "strInputValue":
					arrKeywordsValid = strValidKeyword_strInputValue.split("\\|");
					strValueToFindKeyword = objDragonfly.variablesJSON.objectStep.get(strKey).toString();
					strKeywordValue = strValueToFindKeyword;
					String[] arrKeywords4 = this.getKeywordsAndValue(objDragonfly, strValueToFindKeyword);
					objDragonfly.logger.add("KeywordsValid: arrKeywords.length = " + arrKeywords4.length);
					objDragonfly.logger.add("KeywordsValid: arrResults.length = " + arrResults.length);
					for (int intKeywordsEach = arrKeywords4.length - 1; intKeywordsEach >= 0; intKeywordsEach--) {
						//for (int intKeywordsEach = 0; intKeywordsEach < arrKeywords.length; intKeywordsEach++) {
						objDragonfly.logger.add("KeywordsValid: intKeywordsEach = " + intKeywordsEach);
						objDragonfly.logger.add("KeywordsValid: arrKeywords4[intKeywordsEach].toString() = " + arrKeywords4[intKeywordsEach].toString());
						objDragonfly.logger.add("KeywordsValid: arrKeywordsValid.length = " + arrKeywordsValid.length);
						for (int intKeywordsValidEach = 0; intKeywordsValidEach < arrKeywordsValid.length; intKeywordsValidEach++) {
							strKeywordEach = arrKeywords4[intKeywordsEach].toString();
							objDragonfly.logger.add("KeywordsValid: strInputValue strKeywordEach = " + strKeywordEach);
							if (strKeywordEach.equals(arrKeywordsValid[intKeywordsValidEach].toString())) {
								blnValid = true;
								strKeywordValue = this.getJsonValue(objDragonfly, strKeywordEach, strKeywordValue);
								objDragonfly.logger.add("KeywordsValid: strInputValue strKeywordValue = " + strKeywordValue);
								break;
							}
						}
						if (blnValid = false) {
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "blnExitOnFail", "true");
							break;
						}
						//strValueReturnedByKeyword= objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJSONObject, strInputValue, arrKeywords[intKeywordsEach].toString());
					}
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", strKeywordValue);
					break;
				//					strValueToFindKeyword = objDragonfly.variablesJSON.objectStep.get(strKey).toString();
				//					//arrKeywords = objDragonfly.new KeywordReturnArray().run(objDragonfly, strValueToFindKeyword);
				//					arrKeywords = this.getKeywordsAndValue(objDragonfly, strValueToFindKeyword);
				//					for (int intKeywordsEach = 0; intKeysEach < arrKeywords.length; intKeysEach++) {
				//						objDragonfly.logger.add("KeywordsValid: arrKeywords[intKeywordsEach].toString() = " + arrKeywords[intKeywordsEach].toString());
				//						for (int intKeywordsValidEach = 0; intKeywordsValidEach < arrKeywordsValid.length; intKeywordsValidEach++) {
				//							if (arrKeywords[intKeywordsEach].toString().equals(arrKeywordsValid[intKeywordsValidEach].toString())) {
				//								blnValid = true;
				//								strKeywordValue = strValueToFindKeyword.replace(strValueToFindKeyword, arrKeywords[intKeywordsEach].toString());
				//								break;
				//							}
				//						}
				//						if (blnValid = false) {
				//							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
				//							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "blnExitOnFail", "true");
				//						}
				//					}
				//					break;
				case "strLoopOrIf":
					//					arrKeywordsValid = strValidKeyword_strLoopOrIf.split("\\|");
					//					strValueToFindKeyword = objDragonfly.variablesJSON.objectStep.get(strKey).toString();
					//					//arrKeywords = objDragonfly.new KeywordReturnArray().run(objDragonfly, strValueToFindKeyword);
					//					arrKeywords = this.getKeywordsAndValue(objDragonfly, strValueToFindKeyword);
					//					for (int intKeywordsEach = 0; intKeysEach < arrKeywords.length; intKeysEach++) {
					//						objDragonfly.logger.add("KeywordsValid: arrKeywords[intKeywordsEach].toString() = " + arrKeywords[intKeywordsEach].toString());
					//						for (int intKeywordsValidEach = 0; intKeywordsValidEach < arrKeywordsValid.length; intKeywordsValidEach++) {
					//							if (arrKeywords[intKeywordsEach].toString().equals(arrKeywordsValid[intKeywordsValidEach].toString())) {
					//								blnValid = true;
					//								break;
					//							}
					//						}
					//					}
					//					if (blnValid = false) {
					//						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
					//						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "blnExitOnFail", "true");
					//					}
					break;
				}
			}
		}

		public String getJsonValue(Dragonfly objDragonfly, String strKeyword, String strInputValue) {
			Dragonfly.this.logger.add("  ==start==>getJsonValue " + new DateTimestamp().get());
			try {
				switch (strKeyword) {
				case "<td>":
					strInputValueFromJson = Dragonfly.this.variablesJSON.objectTestData.getValue(strInputValue, "<td>");
					break;
				case "<ti>":
					strInputValueFromJson = Dragonfly.this.variablesJSON.objectTestInstancesEach.getValue(strInputValue, "<ti>");
					break;
				case "<tl>":
					strInputValueFromJson = Dragonfly.this.variablesJSON.objectLinks.getValue(strInputValue, "<tl>");
					break;
				case "<re>":
					strInputValueFromJson = null;
					break;
				}
			} catch (ExceptionJSONKeyNotPresent e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return strInputValueFromJson;
		}

		public String[] getKeywordsAndValue(Dragonfly objDragonfly, String strValueToFindKeyword) {
			objDragonfly.logger.add("  ==start==>getKeywordsAndValue " + new DateTimestamp().get());
			String strKeyword = "";
			//String[] arrResults = null;
			int intLeftArrowPositionEach = 0;
			int intLeftArrowPosition = -1;
			int intRightArrowPosition = -1;
			int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace("<", "").length();
			for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
				intLeftArrowPositionEach = intLeftArrowPosition + 1;
				intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intLeftArrowPositionEach);
				intRightArrowPosition = strValueToFindKeyword.indexOf(">", intLeftArrowPosition);
				if (intLeftArrowPosition > -1) {
					if (strKeyword.length() == 0) {
						strKeyword = strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1);
					} else {
						strKeyword = strKeyword + "|" + strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1);
					}
				}
			}
			//TODO start here need to search for > from the right to get keyword
			strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
			objDragonfly.logger.add("getKeywordsAndValue: strValueToFindKeyword = " + strValueToFindKeyword);
			objDragonfly.logger.add("getKeywordsAndValue: strKeywordValue = " + strKeywordValue);
			arrResults = strKeyword.split("\\|");
			objDragonfly.logger.add("getKeywordsAndValue: strKeyword = " + strKeyword);
			objDragonfly.logger.add("getKeywordsAndValue: arrResults.length = " + arrResults.length);
			for (int intKeysEach = 0; intKeysEach < arrResults.length; intKeysEach++) {
				objDragonfly.logger.add("getKeywordsAndValue: arrResults[intKeysEach].toString() = " + arrResults[intKeysEach].toString());
			}
			return arrResults;
		}
	}

	public class Logger {
		private StringBuilder objStringBuilder = new StringBuilder();;

		public Logger(String strTextToAdd) {
			System.out.println(strTextToAdd);
			this.objStringBuilder.append(strTextToAdd);
			this.objStringBuilder.append(System.getProperty("line.separator"));
		}

		public void add(String strTextToAdd) {
			System.out.println(strTextToAdd);
			objStringBuilder.append(strTextToAdd);
			objStringBuilder.append(System.getProperty("line.separator"));
		}

		public void deleteLog() {
			objStringBuilder.delete(0, objStringBuilder.length());
		}

		public String getLog() {
			return objStringBuilder.toString();
		}
	}

	public class LogStepDetails {
		public LogStepDetails(Dragonfly objDragonfly, int intStep) {
			Long lngTimeStart = System.currentTimeMillis();
			Dragonfly.this.logger.add("  ==start==>LogStepDetails " + new DateTimestamp().get());
			String[] arrKeys;
			String strKey = "";
			try {
				arrKeys = new StepNames().getOriginal();
				for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
					strKey = arrKeys[intKeysEach].toString();
					if (Dragonfly.this.variablesJSON.objectStep.containsKey(strKey) == true) {
						Dragonfly.this.logger.add("LogStepDetails: " + strKey + " = " + objDragonfly.variablesJSON.objectStep.get(strKey).toString());
					}
				}
			} catch (Exception e) {
				Dragonfly.this.logger.add("LogStepDetails: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				Dragonfly.this.logger.add("LogStepDetails: " + strKey + " Milliseconds Waited = " + (System.currentTimeMillis()));
			}
		}
	}

	public class MonthGet {
		public String run(Dragonfly objDragonfly, int month) {
			objDragonfly.logger.add("  ==start==>MonthGet " + new DateTimestamp().get());
			return new DateFormatSymbols().getMonths()[month];
		}
	}

	public class OperatingSystem {
		String strOS = "";

		public void set(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>OperatingSystem " + new DateTimestamp().get());
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

	public class PathCreation {
		//		private String gstrPathData="Data/internal/";//"Data/";  //public/";//"Data/internal/";//
		//		public String gstrTestArea;
		//		//public String gstrPathData = "Data/" + gstrTestArea + "/";
		//
		//		public String gstrPathSystemUserDir = System.getProperty("user.dir");
		//		public String gstrPathTestConfiguration = gstrPathData + "test_configuration/";
		//		//public String gstrPathTestConfiguration = "Data/" + gstrTestArea + "/test_configuration/";
		//		public String gstrPathTestData = gstrPathData + "test_data/";
		//		public String gstrPathTestElements = gstrPathData + "test_elements/";
		//		public String gstrPathTestInstances = gstrPathData + "test_instances/";
		//		public String gstrPathTestModules = gstrPathData + "test_modules/";
		//		public String gstrPathTestSteps = gstrPathData + "test_steps/";
		public String gstrPathSystemUserDir = System.getProperty("user.dir");
		public String gstrTestArea;
		private String gstrPathData;
		public String gstrPathTestConfiguration;
		public String gstrPathTestData;
		public String gstrPathTestElements;
		public String gstrPathTestInstances;
		public String gstrPathTestModules;
		public String gstrPathTestSteps;
		public String gstrPathImages;
		private String gstrPathResults;
		private String gstrPathResultsTop;
		public String gstrNameTest;

		public void changeDirectoryNameStatus(Dragonfly objDragonfly, String strTestStatus) {
			objDragonfly.logger.add("PathCreation:changeDirectoryNameStatus gstrPathResults = " + gstrPathResults);
			File objDirectoryOld = new File(gstrPathResults);
			String strPathResultsNew = gstrPathResults.substring(0, gstrPathResults.length() - 1) + "_" + strTestStatus + "\\";
			objDragonfly.logger.add("PathCreation:changeDirectoryNameStatus strPathResultsNew = " + strPathResultsNew);
			File objDirectoryNew = new File(strPathResultsNew);
			objDirectoryOld.renameTo(objDirectoryNew);
			gstrPathResults = strPathResultsNew;
		}

		public void setDirectory(String strTestArea) {
			gstrPathData = "Data/" + strTestArea + "/";
			gstrPathTestConfiguration = gstrPathData + "test_configuration/";
			gstrPathTestData = gstrPathData + "test_data/";
			gstrPathTestElements = gstrPathData + "test_elements/";
			gstrPathTestInstances = gstrPathData + "test_instances/";
			gstrPathTestModules = gstrPathData + "test_modules/";
			gstrPathTestSteps = gstrPathData + "test_steps/";
		}

		public void setPathResults(Dragonfly objDragonfly, int intTestInstanceSize, String strTestConfigurationFileName) {
			objDragonfly.logger.add("PathCreation:setPathResults intTestInstanceSize = " + intTestInstanceSize);
			objDragonfly.logger.add("PathCreation:setPathResults strTestConfigurationFileName = " + strTestConfigurationFileName);
			String gstrDateTimestamp = new DateTimestamp().get();
			objDragonfly.logger.add("PathCreation:setPathResults gstrDateTimestamp = " + gstrDateTimestamp);
			objDragonfly.logger.add("PathCreation:setPathResults gstrPathImages==null = " + gstrPathImages);
			if (gstrPathImages == null) {
				gstrPathResultsTop = gstrPathSystemUserDir + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\";
				objDragonfly.logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				if (intTestInstanceSize > 1) {
					gstrPathResultsTop = gstrPathResultsTop + gstrDateTimestamp + "\\Iterations_" + intTestInstanceSize + "\\";
					objDragonfly.logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				}
			}
			gstrPathResults = gstrPathResultsTop + gstrDateTimestamp + "\\";
			objDragonfly.logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
			gstrPathImages = gstrPathResults + "images\\";
			objDragonfly.logger.add("PathCreation:setPathResults gstrPathImages = " + gstrPathImages);
			new File(gstrPathImages).mkdirs();
		}
	}

	public class ProcessKillInternetExplorer {
		public void run(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ProcessKillInternetExplorer " + new DateTimestamp().get());
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(objDragonfly, 1000);
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
		}
	}

	public class RandomNumberRange {
		public int run(Dragonfly objDragonfly, int intNumberMinimum, int intNumberMaximum) {
			objDragonfly.logger.add("  ==start==>RandomNumberRange " + new DateTimestamp().get());
			return new Random().nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
		}
	}

	public class RectangleAreaByName {
		public RectangleAreaByName(Dragonfly objDragonfly, Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
			objDragonfly.logger.add("  ==start==>RectangleAreaByName " + new DateTimestamp().get());
			objDragonfly.logger.add("RectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
			long lngStartTime = System.currentTimeMillis();
			int intX = 0;
			int intY = 0;
			int intWidth = 0;
			int intHeight = 0;
			if (strAreaObjectName.equals("")) {
				if (objDragonfly.objVariablesSelenium.gobjWebDriver == null) {
					strAreaObjectName = "screen";
				}
				if (objDragonfly.objVariablesSelenium.gobjWebElement == null) {
					if (objDragonfly.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
						strAreaObjectName = "element";
					} else {
						strAreaObjectName = "screen";
					}
				} else {
					if (objDragonfly.variablesJSON.objectStep.containsKey("intElementScreenX") == false) {
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
					intX = objDragonfly.variablesJSON.objectStep.getInt("intBrowserOuterX");
					intX = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intBrowserOuterX").toString());
					intY = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intBrowserOuterY").toString());
					intWidth = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intBrowserOuterWidth").toString());
					intHeight = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intBrowserOuterHeight").toString());
					break;
				case "page":
					// TODO change this to get absolute screen coordinates
					WebElement objWebElementPage = objDragonfly.objVariablesSelenium.gobjWebDriver.findElement(By.xpath("//body"));
					intX = objWebElementPage.getLocation().getX() - intThickness;
					intY = objWebElementPage.getLocation().getY() - intThickness;
					intWidth = objWebElementPage.getSize().width + (2 * intThickness);
					intHeight = objWebElementPage.getSize().height + (2 * intThickness);
					break;
				case "element":
				case "alert":
					intX = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intElementScreenX").toString()) - intThickness;
					intY = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intElementScreenY").toString()) - intThickness;
					intWidth = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intElementWidth").toString()) + (2 * intThickness);
					intHeight = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intElementHeight").toString()) + (2 * intThickness);
					break;
				default:
					objDragonfly.logger.add("RectangleAreaByName: epected values = screen, window, page and element not " + strAreaObjectName);
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
				objDragonfly.logger.add("RectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class RegularExpressionMatch {
		public String run(Dragonfly objDragonfly, String strPattern, String strActualValue) throws ExceptionValueNotMatched {
			Boolean blnMatched = false;
			Long lngStartTime = System.currentTimeMillis();
			objDragonfly.logger.add("  ==start==>RegularExpressionMatch " + new DateTimestamp().get());
			String strMatchedString = "";
			try {
				Matcher objMatcher = Pattern.compile(strPattern).matcher(strActualValue);
				objMatcher.matches();
				strMatchedString = objMatcher.group(0);
				blnMatched = true;
				return strMatchedString;
			} catch (Exception e) {
				objDragonfly.logger.add("RegularExpressionMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("RegularExpressionMatch: Exception " + e.toString());
			} finally {
				objDragonfly.logger.add("RegularExpressionMatch: finally Matched = {" + blnMatched + "} strMatchedString = {" + strMatchedString + "} strPattern = {" + strPattern + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ScrollToBottom {
		public ScrollToBottom(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>ScrollToBottom " + new DateTimestamp().get());
			// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
			JavascriptExecutor executor = (JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver;
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		}
	}

	public class Sleep {
		public Sleep(Dragonfly objDragonfly) {
			new SleepMilliseconds(objDragonfly, Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("strInputValue").toString()));
		}
	}

	public class SleepMilliseconds {
		public SleepMilliseconds(Dragonfly objDragonfly, int intMillisecondsToWait) {
			objDragonfly.logger.add("  ==start==>SleepMilliseconds " + new DateTimestamp().get());
			try {
				TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
			} catch (Exception e) {
				objDragonfly.logger.add("SleepMilliseconds: Exception = " + e.toString());
			}
		}
	}

	public class SleepSync {
		public SleepSync(Dragonfly objDragonfly) {
			Long lngTimeStart = System.currentTimeMillis();
			new Sleep(objDragonfly);
			new StepDuration(objDragonfly, "SleepSync", lngTimeStart, "sleep");
		}
	}

	public class StepCreateActual {
		public StepCreateActual(Dragonfly objDragonfly, String strStepType) {
			objDragonfly.logger.add("  ==start==>StepCreateActual " + new DateTimestamp().get());
			String intWaited = "";
			String strActualHtml = "";
			String strActualReturn = "";
			String strActualReturnHTML = "";
			String strActualText = "";
			String strInputParameterValueHTML = "";
			String strInputValue = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
			String strOutputValue = objDragonfly.variablesJSON.objectStep.get("strOutputValue").toString();
			String strOutputValueHtml = objDragonfly.variablesJSON.objectStep.get("strOutputValue").toString();
			String strParameterName = "";
			String strStepParameterName = "";
			String strTagName = objDragonfly.variablesJSON.objectStep.get("strTagName").toString();
			switch (strStepType.toLowerCase()) {
			case "launch":
				strActualHtml = "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + intWaited + "} milliseconds";
				strActualText = "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + intWaited + "} milliseconds";
				break;
			case "close":
				strActualHtml = "Close {" + strTagName + "} browser within {" + intWaited + "} milliseconds";
				strActualText = "Close {" + strTagName + "} browser within {" + intWaited + "} milliseconds";
				break;
			case "default":
				strActualHtml = "The <b>" + strTagName + " </b> default value is {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>}.";
				strActualText = "The expected " + strTagName + " default value is " + strOutputValue + ".";
				break;
			case "clicked":
				strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was clicked.";
				strActualText = "The expected " + strTagName + "  value {" + strInputValue + "} was clicked.";
				break;
			case "expected":
				strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was not verified.<BR>The actual value was {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>}.";
				strActualText = "The expected " + strTagName + " value {" + strInputValue + "} was not verified.  The actual value was {" + strActualReturn + "}.";
				break;
			case "expectedtooltip":
				strActualHtml = "The expected <b>" + strTagName + "</b>  tooltip value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was not verified.<BR>The actual value was {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>}.";
				strActualText = "The expected " + strTagName + " tooltip value {" + strInputValue + "} was not verified.  The actual value was {" + strActualReturn + "}.";
				break;
			case "find":
				strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was found.";
				strActualText = "The expected " + strTagName + "  value {" + strOutputValue + "} was found.";
				break;
			case "notfound":
				strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was not found.";
				strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} was not found.";
				break;
			case "verify":
				strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was verified.";
				strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} was verified.";
				break;
			case "verify_not":
				strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was not verified.";
				strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} was not verified.";
				break;
			case "verifytooltip":
				strActualHtml = "The expected <b>" + strTagName + "</b> tooltip value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b><b><FONT COLOR='FF0000'></FONT></b>} was verified.";
				strActualText = "The expected " + strTagName + " tooltip value {" + strOutputValue + "} was verified.";
				break;
			case "get":
				strActualHtml = "The <b>" + strTagName + " </b> actual value is {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>}.";
				strActualText = "The " + strTagName + " actual value is {" + strOutputValue + "}";
				break;
			case "gettooltip":
				strActualHtml = "The <b>" + strTagName + " </b> tooltip actual value is {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>}.";
				strActualText = "The " + strTagName + " tooltip actual value is {" + strOutputValue + "}";
				break;
			case "set":
				strActualHtml = "The expected <b>" + strTagName + " </b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was set.";
				strActualText = "The expected " + strTagName + " value {" + strInputValue + "} was set.";
				break;
			case "persisted":
				strActualHtml = "The expected <b>" + strTagName + " </b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} persisted.";
				strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} persisted.";
				break;
			case "password":
				strActualHtml = "The <b>" + strTagName + " </b> password value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} was set.";
				strActualText = "The " + strTagName + " password value {" + strOutputValue + "} was set.";
				break;
			case "notpersisted":
				strActualHtml = "The expected <b>" + strTagName + " </b> value  {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} did not persist.<BR>The actual value {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} was displayed.";
				strActualText = "The expected " + strTagName + " value {" + strInputValue + "} did not persist.  The actual value {" + strActualReturn + "} was displayed.";
				break;
			case "exist":
				strActualHtml = "The expected <b>" + strTagName + "</b> exists.";
				strActualText = "The expected " + strTagName + " exists.";
				break;
			case "notexist":
				strActualHtml = "The expected <b>" + strTagName + "</b> does not exist after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " does not exist after " + intWaited + " milliseconds.";
				break;
			case "notexisttooltip":
				strActualHtml = "The expected <b>" + strTagName + "</b> tooltip does not exist after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " tooltip does not exist after " + intWaited + " milliseconds.";
				break;
			case "invisible":
				strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is invisible.";
				strActualText = "The expected " + strTagName + " is invisible.";
				break;
			case "enabled":
				strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is enabled.";
				strActualText = "The expected " + strTagName + " is enabled.";
				break;
			case "disabled":
				strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is disabled.";
				strActualText = "The expected " + strTagName + " is disabled.";
				break;
			case "visible":
				strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is visible.";
				strActualText = "The expected " + strTagName + " is visible.";
				break;
			case "hidden":
				strActualHtml = "The expected <b>" + strTagName + "</b> <b><FONT COLOR='008000'></FONT></b> is hidden.";
				strActualText = "The expected " + strTagName + " is hidden.";
				break;
			case "syncnotexists":
				strActualHtml = "The expected <b>" + strTagName + "</b></b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} does not exist after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} does not exist after " + intWaited + " milliseconds.";
				break;
			case "syncexists":
				strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} exists after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
				break;
			case "syncclosed":
				strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} closed after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} closed after " + intWaited + " milliseconds.";
				break;
			case "syncnotclosed":
				strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} did not close after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} did not close after " + intWaited + " milliseconds.";
				break;
			case "synchidden":
				strActualHtml = "The expected <b>" + strTagName + "</b></b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} does not exist after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} does not exist after " + intWaited + " milliseconds.";
				break;
			case "syncvisible":
				strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} exists after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
				break;
			case "syncoptional":
				strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} sync is optional after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
				break;
			case "syncdisabled":
				strActualHtml = "The expected <b>" + strTagName + "</b></b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} does not exist after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} does not exist after " + intWaited + " milliseconds.";
				break;
			case "syncenabled":
				strActualHtml = "The expected <b>" + strTagName + "</b> {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} exists after " + intWaited + " milliseconds.";
				strActualText = "The expected " + strTagName + " {" + strOutputValue + "} exists after " + intWaited + " milliseconds.";
				break;
			case "navigate":
				strActualHtml = "The expected <b>" + strTagName + " </b>  value {<b><FONT COLOR='008000'>" + strOutputValueHtml + "</FONT></b>} was set.<BR>No validation performed due to navigation.";
				strActualText = "The expected " + strTagName + " value {" + strOutputValue + "} was set. No validation performed due to navigation.";
				break;
			case "keystroke":
				strActualHtml = "The expected <b>" + strTagName + "</b>  value {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} was pressed.";
				strActualText = "The expected " + strTagName + "  value {" + strInputValue + "} was pressed.";
				break;
			case "notinlist":
				strActualHtml = "The list item {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} does not exist in the <b>" + strStepParameterName + "</b> list field.<BR>Please confirm the input value against the actual list values {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} is available for this field.";
				strActualText = "The list item {" + strInputValue + "} does not exist in the " + strParameterName + " list field.  Please confirm the input value against the actual list values {" + strActualReturn + "} is available for this field.";
				break;
			case "drag":
				strActualHtml = "The list item {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} does not exist in the <b>" + strStepParameterName + "</b> list field.<BR>Please confirm the input value against the actual list values {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} is available for this field.";
				strActualText = "The list item {" + strInputValue + "} does not exist in the " + strParameterName + " list field.  Please confirm the input value against the actual list values {" + strActualReturn + "} is available for this field.";
				break;
			case "drop":
				strActualHtml = "The list item {<b><FONT COLOR='008000'>" + strInputParameterValueHTML + "</FONT></b>} does not exist in the <b>" + strStepParameterName + "</b> list field.<BR>Please confirm the input value against the actual list values {<b><FONT COLOR='FF0000'>" + strActualReturnHTML + "</FONT></b>} is available for this field.";
				strActualText = "The list item {" + strInputValue + "} does not exist in the " + strParameterName + " list field.  Please confirm the input value against the actual list values {" + strActualReturn + "} is available for this field.";
				break;
			case "break":
				strActualHtml = "Take a break.";
				strActualText = "Take a break.";
				break;
			case "scroll":
				strActualHtml = "The expected <b>" + strTagName + "</b> exists.";
				strActualText = "The expected " + strTagName + " exists.";
				break;
			case "sleep":
				strActualHtml = "The action sleep paused execution for {<b>" + strTagName + "</b>} milliseconds.";
				strActualText = "The action sleep paused execution for {" + strInputValue + "} milliseconds.";
				break;
			case "mouse_over":
				strActualText = "Mouse over  {" + strTagName + "} tag complete";
				break;
			case "mouse_out":
				strActualText = "Mouse out  {" + strTagName + "} tag complete";
				break;
			default:
			}
			strActualHtml = "<DIV align='left/>" + strActualHtml + "</DIV>";
			//return strActualText;
			objDragonfly.logger.add("StepCreateActual: strActualText = " + strActualText);
			objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStepActual", strActualText);
			objDragonfly.logger.add("StepCreateActual: objectStep.get(strStepActual) = " + objDragonfly.variablesJSON.objectStep.get("strStepActual").toString());
		}
	}

	public class StepCreateExpected {
		public StepCreateExpected(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>StepCreateExpected " + new DateTimestamp().get());
			String strStepExpected = "";
			String strAction = "";
			//String strAction = objDragonfly.variablesJSON.objectStep.get("strAction").toString();
			String strInputValue = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
			String strMillisecondsToWait = objDragonfly.variablesJSON.objectStep.get("intMillisecondsToWait").toString();
			String strObjectName = this.createObjectName(objDragonfly);
			String strTagName = objDragonfly.variablesJSON.objectStep.get("strTagName").toString();
			String strAssert = objDragonfly.variablesJSON.objectStep.get("strAssert").toString();
			if (objDragonfly.variablesJSON.objectStep.get("strStepExpected").toString().length() != 0) {
				strAction = objDragonfly.variablesJSON.objectStep.get("strStepExpected").toString();
			} else {
				strAction = objDragonfly.variablesJSON.objectStep.get("strAction").toString();
			}
			switch (strAction.toLowerCase()) {
			case "launch":
				strStepExpected = "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + strMillisecondsToWait + "} milliseconds";
				break;
			case "close":
				strStepExpected = "Close {" + strTagName + "} browser within {" + strMillisecondsToWait + "} milliseconds";
				break;
			case "get":
				strStepExpected = "Get {" + strTagName + "} tag with attributes {" + strObjectName + "} value" + " within {" + strMillisecondsToWait + "} milliseconds";
				break;
			case "set":
				strStepExpected = "Set  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "select":
				strStepExpected = "select  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "click":
				strStepExpected = "click  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "double_click":
				strStepExpected = "click  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "right_click":
				strStepExpected = "click  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "verify":
				strStepExpected = "Verify  {" + strTagName + "} tag with attributes {" + strObjectName + "} value is equal to {" + strInputValue + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "verify_not":
				strStepExpected = "Verify Not {" + strTagName + "} tag with attributes {" + strObjectName + "} value is equal to {" + strInputValue + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "mouse_over":
				strStepExpected = "Mouse over  {" + strTagName + "} tag with attributes {" + strObjectName + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "mouse_out":
				strStepExpected = "Mouse out  {" + strTagName + "} tag with attributes {" + strObjectName + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "sync_visible":
				strStepExpected = "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is visible within {" + strMillisecondsToWait + "} milliseconds";
				break;
			case "sync_hidden":
				strStepExpected = "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is hidden within {" + strMillisecondsToWait + "} milliseconds";
				break;
			case "sync_enabled":
				strStepExpected = "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is enabled within {" + strMillisecondsToWait + "} milliseconds";
				break;
			case "sync_disabled":
				strStepExpected = "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is disabled within {" + strMillisecondsToWait + "} milliseconds";
				break;
			case "scroll":
				strStepExpected = "The expected " + strTagName + " exists.";
				break;
			case "break":
				strStepExpected = "The action break stopped the execution.";
				break;
			case "drag":
				strStepExpected = "Drag {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "drop":
				strStepExpected = "Drop {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "kill_ie":
				strStepExpected = "The action kill_ie killed all IE processes.";
				break;
			case "refresh":
				strStepExpected = "The browser was refreshed.";
				break;
			case "set_js":
				strStepExpected = "Set {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
				break;
			case "sleep":
				strStepExpected = "The action sleep paused execution for {" + strInputValue + " milliseconds}";
				break;
			default:
				strStepExpected = strAction;
				break;
			}
			objDragonfly.objStepsManual.set(strStepExpected);
			objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStepExpected", strStepExpected);
		}

		public String createObjectName(Dragonfly objDragonfly) {
			String strAttributeValue = "";
			String strAttributeValues = objDragonfly.variablesJSON.objectStep.get("strAttributeValues").toString();
			String strObjectsAttributes = "";
			String strObjectName = "";
			String strObjectNames = objDragonfly.variablesJSON.objectStep.get("strAttributeNames").toString();
			String[] arrAttributeValues = strAttributeValues.split("\\|");
			String[] arrObjectNames = strObjectNames.split("\\|");
			for (int intEach = 0; intEach < arrObjectNames.length; intEach++) {
				strObjectName = arrObjectNames[intEach].toString();
				strAttributeValue = arrAttributeValues[intEach].toString();
				if (intEach == 0) {
					strObjectsAttributes = strObjectName + "=" + strAttributeValue;
					objDragonfly.logger.add("createObjectName strObjectAttribute =" + strObjectsAttributes);
				} else {
					strObjectsAttributes = strObjectsAttributes + "|" + strObjectName + "=" + strAttributeValue;
					objDragonfly.logger.add("createObjectName strObjectAttribute =" + strObjectsAttributes);
				}
			}
			return strObjectsAttributes;
		}

		public String switchAction(Dragonfly objDragonfly) {
			return null;
		}
	}

	public class StepDuration {
		public StepDuration(Dragonfly objDragonfly, String strMethodName, Long lngTimeStart, String strStepType) {
			Dragonfly.this.logger.add("  ==start==>StepDuration " + new DateTimestamp().get());
			Long lngTimeEnd = System.currentTimeMillis();
			new StepCreateExpected(objDragonfly);
			new StepCreateActual(objDragonfly, strStepType);
			//objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStepActual", new StepCreateActual().run(objDragonfly, strStepType));
			Dragonfly.this.variablesJSON.objectStep.putValue(objDragonfly, "strStartTimestamp", new DateTimeFormat().set(objDragonfly, lngTimeStart));
			Dragonfly.this.variablesJSON.objectStep.putValue(objDragonfly, "strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
			Dragonfly.this.variablesJSON.objectStep.putValue(objDragonfly, "strEndTimestamp", new DateTimeFormat().set(objDragonfly, lngTimeEnd));
			Dragonfly.this.logger.add("StepDuration: " + strMethodName + " strStatus = " + objDragonfly.variablesJSON.objectStep.get("strStatus").toString() + " Milliseconds Waited = " + objDragonfly.variablesJSON.objectStep.get("strStepDuration").toString());
		}
	}

	public class StepNames {
		private String strKeys1 = "strAction|strLogicalName|strTagName|strAttributeNames|strAttributeValues|strInputValue|strAssert|blnOptional|blnExitOnFail";
		private String strKeys2 = "|intMillisecondsToWait|strFunction|strOutputLinkName|strLoopOrIf|blnPleaseWait|blnHighlight|blnScreenshot|strAssistiveProperties|strOutputValue";
		private String strKeys3 = "intBrowserInnerWidth|intBrowserInnerHeight|intBrowserOuterX|intBrowserOuterY|intBrowserOuterWidth|intBrowserOuterHeight";
		private String strKeys4 = "|intElementScreenX|intElementScreenY|intElementX|intElementY|intElementWidth|intElementHeight|strTagType|strType|strCurrentWindowHandle";
		private String strKeys5 = "|strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strHighlightArea|strScreenshotFilePath|strStatus";
		private String strKeysDefault = "intMillisecondsToWait|blnOptional|strAssert|blnExitOnFail|blnPleaseWait|blnHighlight|blnScreenshot|strScreenshotArea|strStatus";
		private StringBuilder objStringBuilder = new StringBuilder();

		public String[] getComplete() {
			objStringBuilder.append(strKeys1);
			objStringBuilder.append(strKeys2);
			objStringBuilder.append("|");
			objStringBuilder.append(strKeys3);
			objStringBuilder.append(strKeys4);
			objStringBuilder.append(strKeys5);
			return objStringBuilder.toString().split("\\|");
		}

		public String[] getDefault() {
			return strKeysDefault.toString().split("\\|");
		}

		public String[] getOriginal() {
			objStringBuilder.append(strKeys1);
			objStringBuilder.append(strKeys2);
			return objStringBuilder.toString().split("\\|");
		}

		public String[] getRuntime() {
			objStringBuilder.append(strKeys3);
			objStringBuilder.append(strKeys4);
			objStringBuilder.append(strKeys5);
			return objStringBuilder.toString().split("\\|");
		}
	}

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

		public StepSetupDefaults(Dragonfly objDragonfly, String strCurrentWindowHandle) {
			objDragonfly.logger.add("  ==start==>StepSetupDefaults " + new DateTimestamp().get());
			String[] arrDefaultKeys = new StepNames().getDefault();
			String[] arrKeys = new StepNames().getRuntime();
			String strKey = "";
			String strInputValue = "";
			String strLogicalName = "";
			for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
				strKey = arrKeys[intKeysEach].toString();
				//objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, strKey, "");
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, strKey, "");
			}
			try {
				strInputValue = objDragonfly.variablesJSON.objectStep.getValue("strInputValue", "");
				strLogicalName = objDragonfly.variablesJSON.objectStep.getValue("strLogicalName", "");
			} catch (ExceptionJSONKeyNotPresent e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//String strInputValue = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
			//String strLogicalName = objDragonfly.variablesJSON.objectStep.get("strLogicalName").toString();
			objDragonfly.logger.add("StepSetupDefaults: strLogicalName = " + strLogicalName);
			//objDragonfly.logger.add("StepSetupDefaults: new KeywordAndValue(objDragonfly, strLogicalName).strKeyword = " + new KeywordAndValue(objDragonfly, strLogicalName).strKeyword);
			objDragonfly.new KeywordsValid(objDragonfly);
			//			try {
			//				if (new KeywordAndValue(objDragonfly, strLogicalName).strKeyword == "<te>") {
			//					strLogicalName = new KeywordAndValue(objDragonfly, strLogicalName).strValue;
			//					objDragonfly.new JsonObjectValidateKey(objDragonfly, objDragonfly.variablesJSON.objectElement, strLogicalName);
			//					JSONObject objJsonObjectElementNode = (JSONObject) objDragonfly.variablesJSON.objectElement.get(strLogicalName);
			//					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strTagName", objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectElementNode, "strTagName", ""));
			//					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strAttributeNames", objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectElementNode, "strAttributeNames", ""));
			//					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strAttributeValues", objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectElementNode, "strAttributeValues", ""));
			//					//objDragonfly.logger.add(	objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectElementNode, "strAttributeValues", "");
			//				}
			//				switch (new KeywordAndValue(objDragonfly, strInputValue).strKeyword) {
			//				case "<td>":
			//					strInputValue = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objDragonfly.variablesJSON.objectTestData, strInputValue, "<td>");
			//					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", strInputValue);
			//					break;
			//				case "<ti>":
			//					strInputValue = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objDragonfly.variablesJSON.objectTestInstancesEach, strInputValue, "<ti>");
			//					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", strInputValue);
			//					break;
			//				case "<tl>":
			//					strInputValue = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objDragonfly.variablesJSON.objectLinks, strInputValue, "<tl>");
			//					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", strInputValue);
			//					break;
			//				}
			//			} catch (Exception e) {
			//				objDragonfly.logger.add("StepSetupDefaults: Keyword strInputValue = " + strInputValue + " Exception = " + e.toString());
			//			}
			Class<?> objClass = null;
			try {
				objDragonfly.logger.add("StepSetupDefaults: Class.forName start");
				objClass = Class.forName("org.DragonflyAutomation.Dragonfly$StepSetupDefaults");
			} catch (ClassNotFoundException e) {
				objDragonfly.logger.add("StepSetupDefaults: ClassNotFoundException = " + e.toString());
			} catch (Exception e) {
				objDragonfly.logger.add("StepSetupDefaults: Class.forName Exception = " + e.toString());
			}
			for (int intKeysEach = 0; intKeysEach < arrDefaultKeys.length; intKeysEach++) {
				strKey = arrDefaultKeys[intKeysEach].toString();
				Field objField = null;
				try {
					//objDragonfly.logger.add("StepSetupDefaults strDefault_ + strKey = " + "strDefault_" + strKey);
					objField = objClass.getDeclaredField("strDefault_" + strKey);
				} catch (NoSuchFieldException | SecurityException e) {
					objDragonfly.logger.add("StepSetupDefaults: NoSuchFieldException = " + e.toString());
				} catch (Exception e) {
					objDragonfly.logger.add("StepSetupDefaults: Exception = " + e.toString());
				}
				if (objDragonfly.variablesJSON.objectStep.get(strKey).toString().trim().length() == 0) {
					try {
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, strKey, (String) objField.get(this));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						objDragonfly.logger.add("StepSetupDefaults: IllegalArgumentException = " + e.toString());
						e.printStackTrace();
					} catch (Exception e) {
						objDragonfly.logger.add("StepSetupDefaults: Exception = " + e.toString());
					}
				}
			}
			objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strCurrentWindowHandle", strCurrentWindowHandle);
		}
	}

	public class StepsManual {
		private StringBuilder objStringBuilder = new StringBuilder();;

		public void delete() {
			objStringBuilder.delete(0, objStringBuilder.length());
		}

		public String get() {
			return objStringBuilder.toString();
		}

		//		public void add(String strTextToAdd) {
		//			this.objStringBuilder.append(strTextToAdd);
		//			this.objStringBuilder.append(System.getProperty("line.separator"));
		//		}
		public void set(String strTextToAdd) {
			System.out.println(strTextToAdd);
			objStringBuilder.append(strTextToAdd);
			objStringBuilder.append(System.getProperty("line.separator"));
		}
	}

	public class SyncAlert {
		public SyncAlert(Dragonfly objDragonfly) throws ExceptionAlertNotComplete {
			objDragonfly.logger.add("  ==start==>SyncAlert " + new DateTimestamp().get());
			if (new AlertFind().run(objDragonfly) == true) {
				throw new ExceptionAlertNotComplete("");
			}
		}
	}

	public class SyncAngularJs {
		public SyncAngularJs(Dragonfly objDragonfly) throws ExceptionAngularJsNotComplete {
			objDragonfly.logger.add("  ==start==>SyncAngularJs " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return (window.angular != null);");
				objDragonfly.logger.add("SyncAngularJs: = " + blnAngularJs);
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				if (lngAngularJsInjectorActive > 0) {
					throw new ExceptionAngularJsNotComplete("");
				}
			} catch (Exception e) {
				objDragonfly.logger.add("SyncAngularJs: AngularJS Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("SyncAngularJs: lngAngularJsInjectorActive = " + lngAngularJsInjectorActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SyncDoPostBack {
		public SyncDoPostBack(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionDoPostBackNotComplete {
			objDragonfly.logger.add("  ==start==>SyncDoPostBack " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				try {
					objDragonfly.logger.add("SyncDoPostBack: __EVENTTARGET value = " + objDragonfly.objVariablesSelenium.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !objDragonfly.objVariablesSelenium.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
					if (blnEventTarget == true) {
						throw new ExceptionDoPostBackNotComplete("");
					}
				} catch (Exception e) {
					objDragonfly.logger.add("SyncDoPostBack: Exception = " + e.toString());
				} finally {
					objDragonfly.logger.add("SyncDoPostBack: blnEventTarget = " + blnEventTarget + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				}
			}
		}
	}

	public class SyncFinally {
		public Boolean run(Dragonfly objDragonfly, Boolean blnExit, Boolean blnStatus, Boolean blnFound, String strMethodeName, String strAction, Long lngTimeStart) {
			objDragonfly.logger.add("SyncFinally:  blnExit = {" + blnExit + "} blnStatus = {" + blnStatus + "} blnFound = {" + blnFound + "} strMethodeName = {" + strMethodeName + "} strAction = {" + strAction + "}");
			if (blnExit == true) {
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
				objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "blnExitOnFail", "true");
			} else {
				if (blnStatus == true) {
					objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnExit = false;
						}
					} else {
						if (Boolean.parseBoolean(objDragonfly.variablesJSON.objectStep.get("blnOptional").toString()) == true) {
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "warning");
							blnExit = true;
						} else {
							objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strStatus", "fail");
							blnExit = true;
						}
					}
				}
			}
			if (blnExit == true) {
				new StepDuration(objDragonfly, strMethodeName, lngTimeStart, strAction);
			}
			return blnExit;
		}
	}

	public class SyncJQueryAjax {
		public SyncJQueryAjax(Dragonfly objDragonfly) throws ExceptionJQueryAjaxNotComplete {
			objDragonfly.logger.add("  ==start==>SyncJQueryAjax " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				blnJquery = (boolean) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return (jQuery.active);");
					objDragonfly.logger.add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive);
					if (lngJqueryActive > 0) {
						throw new ExceptionJQueryAjaxNotComplete("");
					}
				}
			} catch (Exception e) {
				objDragonfly.logger.add("SyncJQueryAjax: JqueryActive Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SyncJQueryAnimation {
		public SyncJQueryAnimation(Dragonfly objDragonfly) throws ExceptionJQueryAnimationNotComplete {
			objDragonfly.logger.add("  ==start==>SyncJQueryAnimation " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			long lngElementsAnimated = 0;
			boolean blnJqueryExist = false;
			try {
				blnJqueryExist = (boolean) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJqueryExist == true) {
					lngElementsAnimated = (long) ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return $(\":animated\").length");
				}
				if (lngElementsAnimated > 0) {
					throw new ExceptionJQueryAnimationNotComplete("");
				}
			} catch (Exception e) {
				objDragonfly.logger.add("SyncJQueryAnimation: Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("SyncJQueryAnimation: lngElementsAnimated = " + lngElementsAnimated + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SyncPleaseWait {
		public SyncPleaseWait(Dragonfly objDragonfly) throws ExceptionDoPostBackNotComplete {
			long lngStartTime = System.currentTimeMillis();
			objDragonfly.logger.add("  ==start==>SyncPleaseWait " + new DateTimestamp().get());
			try {
				new ElementPleaseWait(objDragonfly);
			} catch (ExceptionElementNotHidden e1) {
				objDragonfly.logger.add("SyncPleaseWait: ExceptionElementNotHidden = " + e1.toString());
				throw new ExceptionDoPostBackNotComplete("");
			} catch (Exception e) {
				objDragonfly.logger.add("SyncPleaseWait: Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("SyncPleaseWait: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
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

	public class SyncWaitForReadyState {
		public SyncWaitForReadyState(Dragonfly objDragonfly) {
			long lngStartTime = System.currentTimeMillis();
			objDragonfly.logger.add("  ==start==>SyncWaitForReadyState " + new DateTimestamp().get());
			try {
				new WaitForReadyState().run(objDragonfly);
			} catch (Exception e) {
				objDragonfly.logger.add("SyncWaitForReadyState: Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("SyncWaitForReadyState: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class TestConfigurationSetup {
		int intTestInstanceSize;
		String gstrTestStepsCombinedOriginal;
		JSONObjectExtended objJsonObjectTestConfigurationFile = null;
		private JSONParser objJsonParser = new JSONParser();

		public void run(Dragonfly objDragonfly, String strFileNameTestConfiguration) {
			// TODO complete TestConfigurationSetup method to create json objects for test
			objDragonfly.logger.add("  ==start==>TestConfigurationSetup " + new DateTimestamp().get());
			//JSONArray gobjJsonArrayLink = null;
			long lngStartTime = System.currentTimeMillis();
			String strFilePathTestConfiguration = "";
			try {
				strFilePathTestConfiguration = objDragonfly.objPaths.gstrPathTestConfiguration + strFileNameTestConfiguration;
				objDragonfly.logger.add("TestConfigurationSetup: strPathTestConfiguration = " + strFilePathTestConfiguration);
				//objJsonObjectTestConfigurationFile = (JSONObjectExtended) objJsonParser.parse(new FileReader(strFilePathTestConfiguration));
				objJsonObjectTestConfigurationFile = objDragonfly.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathTestConfiguration)));
				objDragonfly.logger.add("TestConfigurationSetup: objJsonObjectTestConfigurationFile = " + objJsonObjectTestConfigurationFile);
				// test_instances
				//				objDragonfly.logger.add("TestConfigurationSetup: test_instances");
				//				objDragonfly.variablesJSON.gobjJsonArrayTestInstances = this.putAllArrays(objDragonfly, "test_instances", "test_instances", objDragonfly.objPaths.gstrPathTestInstances);
				//				intTestInstanceSize = objDragonfly.variablesJSON.gobjJsonArrayTestInstances.size();
				//
				objDragonfly.logger.add("TestConfigurationSetup: test_instances");
				if (this.putAllArrays(objDragonfly, "test_instances", "test_instances", objDragonfly.objPaths.gstrPathTestInstances) == null) {
					objDragonfly.variablesJSON.gobjJsonArrayTestInstances = null;
					intTestInstanceSize = 0;
				} else {
					objDragonfly.variablesJSON.gobjJsonArrayTestInstances = this.putAllArrays(objDragonfly, "test_instances", "test_instances", objDragonfly.objPaths.gstrPathTestInstances);
					intTestInstanceSize = objDragonfly.variablesJSON.gobjJsonArrayTestInstances.size();
				}
				// test_elements
				objDragonfly.logger.add("TestConfigurationSetup: test_elements");
				objDragonfly.variablesJSON.objectElement = this.putAllObjects(objDragonfly, "test_elements", "elements", objDragonfly.objPaths.gstrPathTestElements);
				// processing
				objDragonfly.logger.add("TestConfigurationSetup: processing");
				objDragonfly.variablesJSON.objectProcessing = this.putAllObjects(objDragonfly, "test_elements", "processing", objDragonfly.objPaths.gstrPathTestElements);
				// test_modules
				objDragonfly.logger.add("TestConfigurationSetup: test_modules");
				objDragonfly.variablesJSON.gobjJsonArrayTestSteps = this.putAllArrays(objDragonfly, "test_modules", "steps", objDragonfly.objPaths.gstrPathTestModules);
				objDragonfly.logger.add("TestConfigurationSetup: gobjJsonArrayTestSteps.toString = " + objDragonfly.variablesJSON.gobjJsonArrayTestSteps.toString());
				// TODO add error handling, report no test modules and fail
				// test_links
				//objDragonfly.variablesJSON.objectLinks = (JSONObjectExtended) objJsonParser.parse("{\"link\":[{}]}");
				objDragonfly.variablesJSON.objectLinks = objDragonfly.new JSONObjectExtended((JSONObject) objJsonParser.parse("{\"link\":[{}]}"));
				// test_data
				objDragonfly.logger.add("TestConfigurationSetup: test_data");
				objDragonfly.variablesJSON.objectTestData = this.putAllObjects(objDragonfly, "test_data", "test_data", objDragonfly.objPaths.gstrPathTestData);
			} catch (Exception e) {
				objDragonfly.logger.add("TestConfigurationSetup: Exception = " + e.toString());
			} finally {
				objDragonfly.logger.add("TestConfigurationSetup: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}

		@SuppressWarnings("unchecked")
		private JSONArray putAllArrays(Dragonfly objDragonfly, String strJsonArrayName, String strJsonObjectName, String strPath) {
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
					objDragonfly.logger.add("TestConfigurationSetup:putAllArrays strFilePathJsonArray = " + strFilePathJsonArray);
					try {
						//objJsonObjectFileEach = (JSONObjectExtended) objJsonParser.parse(new FileReader(strFilePathJsonArray));
						objJsonObjectFileEach = objDragonfly.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathJsonArray)));
						objJsonArrayEach = (JSONArray) objJsonObjectFileEach.get(strJsonObjectName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						objDragonfly.logger.add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
						e.printStackTrace();
					}
					if (intJsonArrayEach == 0) {
						objJsonArray = objJsonArrayEach;
					} else {
						objJsonArray.addAll(objJsonArrayEach);
					}
				}
			}
			objDragonfly.logger.add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
			return objJsonArray;
		}

		@SuppressWarnings("unchecked")
		private JSONObjectExtended putAllObjects(Dragonfly objDragonfly, String strJsonArrayName, String strJsonObjectName, String strPath) {
			objDragonfly.logger.add("  ==start==>putAllObjects " + new DateTimestamp().get());
			Integer intJsonObjectEach = 0;
			JSONArray objJsonArrayList = null;
			JSONObjectExtended objJsonObject = null;
			JSONObjectExtended objJsonObjectEach = null;
			JSONObjectExtended objJsonObjectFileEach = null;
			String strFileNameEach = "";
			String strFilePathJsonArray = "";
			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.get(strJsonArrayName);
			objDragonfly.logger.add("TestConfigurationSetup:putAllObjects objJsonArrayList.size() " + objJsonArrayList.size());
			for (intJsonObjectEach = 0; intJsonObjectEach < objJsonArrayList.size(); intJsonObjectEach++) {
				strFileNameEach = objJsonArrayList.get(intJsonObjectEach).toString();
				objDragonfly.logger.add("TestConfigurationSetup:putAllObjects strFileNameEach " + strFileNameEach);
				strFilePathJsonArray = strPath + strFileNameEach;
				objDragonfly.logger.add("TestConfigurationSetup:putAllObjects strFilePathJsonArray = " + strFilePathJsonArray);
				try {
					//objJsonObjectFileEach = (JSONObjectExtended) objJsonParser.parse(new FileReader(strFilePathJsonArray));
					//objJsonObjectEach = (JSONObjectExtended) objJsonObjectFileEach.get(strJsonObjectName);
					objJsonObjectFileEach = objDragonfly.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathJsonArray)));
					objJsonObjectEach = objDragonfly.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathJsonArray)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (intJsonObjectEach == 0) {
					objJsonObject = objJsonObjectEach;
				} else {
					objJsonObject.putAll(objJsonObjectEach);
				}
			}
			objDragonfly.logger.add("TestConfigurationSetup:putAllObjects objJsonObject = " + objJsonObject);
			return objJsonObject;
		}
	}

	public class ThreadSaveImage implements Runnable {
		private BufferedImage objScreenShot;
		private String strImageType;
		private String strPathFileName;
		private Dragonfly objDragonfly;

		public ThreadSaveImage(Dragonfly objDragonfly, BufferedImage objScreenShot, String strImageType, String strPathFileName) {
			this.objScreenShot = objScreenShot;
			this.strImageType = strImageType;
			this.strPathFileName = strPathFileName;
			this.objDragonfly = objDragonfly;
		}

		@Override
		public void run() {
			try {
				ImageIO.write(objScreenShot, strImageType.toUpperCase(), new File(strPathFileName));
			} catch (Exception e) {
				objDragonfly.logger.add("ThreadSaveImage:run Exception = " + e.toString());
			}
		}
	}

	public class VariablesCommon {
		public String gstrBrowserSelection;
	}

	public class VariablesJSON {
		//JSONObjectExtended
		//objDragonfly.VariablesJSON.JSONObjectStep
		public JSONArray gobjJsonArrayTestInstances = null;
		public JSONArray gobjJsonArrayTestSteps = null;
		public JSONObjectExtended objectElement = null;
		public JSONObjectExtended objectLinks = null;
		public JSONObjectExtended objectProcessing = null;
		public JSONObjectExtended objectStep = null;
		public JSONObjectExtended objectTestData = null;
		public JSONObjectExtended objectTestInstancesEach = null;
	}

	public class VariablesSelenium {
		public WebDriver gobjWebDriver = null;
		public WebDriver gobjWebDriverCoordinates = null;
		public WebElement gobjWebElement = null;
		public WebElement gobjWebElementDrag = null;
		public WebElement gobjWebElementDrop = null;
		public WebElement gobjWebElementPleaseWait = null;
	}

	public class VariablesSetSync {
		public Boolean gblnSyncAlert = false;
		public Boolean gblnSyncAngularJs = false;
		public Boolean gblnSyncDoPostBack = false;
		public Boolean gblnSyncJQueryAjax = false;
		public Boolean gblnSyncJQueryAnimation = false;
		public Boolean gblnSyncPleaseWait = false;
		public Boolean gblnSyncWaitForReadyState = false;
	}

	public class VerifyMatch {
		public String run(Dragonfly objDragonfly, String strActual, String strExpected) throws ExceptionValueNotMatched {
			objDragonfly.logger.add("  ==start==>VerifyMatch " + new DateTimestamp().get());
			Boolean blnMatched = false;
			long lngStartTime = System.currentTimeMillis();
			try {
				if (strExpected.toLowerCase().startsWith("<re>")) {
					String strPattern = strExpected.substring(4);
					blnMatched = true;
					return new RegularExpressionMatch().run(objDragonfly, strPattern, strActual);
				} else {
					if (strExpected.equals(strActual)) {
						blnMatched = true;
						return strActual;
					} else {
						throw new ExceptionValueNotMatched("VerifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
					}
				}
			} catch (Exception e) {
				objDragonfly.logger.add("VerifyMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("VerifyMatch: Exception " + e.toString());
			} finally {
				objDragonfly.logger.add("VerifyMatch: finally Matched = {" + blnMatched + "} strActual = {" + strActual + "} strExpected = {" + strExpected + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class VerifyNotMatch {
		public String run(Dragonfly objDragonfly, String strActual, String strExpected) throws ExceptionValueMatched {
			objDragonfly.logger.add("  ==start==>VerifyNotMatch " + new DateTimestamp().get());
			Boolean blnMatched = false;
			long lngStartTime = System.currentTimeMillis();
			String strMatchedValue = "";
			try {
				if (strExpected.toLowerCase().startsWith("<re>")) {
					String strPattern = strExpected.substring(4);
					try {
						strMatchedValue = new RegularExpressionMatch().run(objDragonfly, strPattern, strActual);
					} catch (Exception e) {
						objDragonfly.logger.add("VerifyNotMatch: Exception " + e.toString());
						return strMatchedValue;
					}
					blnMatched = true;
					objDragonfly.logger.add("VerifyNotMatch: before throw blnMatched = " + blnMatched);
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
				objDragonfly.logger.add("VerifyNotMatch: finally Matched = {" + blnMatched + "} strExpected = {" + strExpected + "} strActual = {" + strActual + "} strMatchedValue = {" + strMatchedValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class WaitForAngularRequestsToFinish {
		public WaitForAngularRequestsToFinish(Dragonfly objDragonfly, JavascriptExecutor objDriver) {
			objDragonfly.logger.add("  ==start==>WaitForAngularRequestsToFinish " + new DateTimestamp().get());
			objDriver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
		}
	}

	public class WaitForReadyState {
		public boolean run(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>WaitForReadyState " + new DateTimestamp().get());
			objDragonfly.logger.add("waitForReadyState: document.readyState Milliseconds Waited = " + ((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("return document.readyState"));
			return false;
		}
	}

	public class WebDriverTest {
		public WebDriverTest() {
			System.setProperty("webdriver.ie.driver", "");
			WebDriver objWebDriver;
			objWebDriver = new InternetExplorerDriver();
			//DesiredCapabilities desiredCapabilities = null;
			//desiredCapabilities = DesiredCapabilities.internetExplorer();
			//desiredCapabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			//desiredCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-noframemerging");
			//objWebDriver = new InternetExplorerDriver(desiredCapabilities);
			objWebDriver.get("http://liloui-latest.wdw.disney.com/PMS/");
			//Capabilities getCapabilities();
			//		driver = new FirefoxDriver();
			//		driver = new HtmlUnitDriver(true);
			//	assertTrue(true);
			//driver.close();
			//driver.quit();
		}
	}

	public class WebElementAttributes {
		public WebElementAttributes(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>WebElementAttributes " + new DateTimestamp().get());
			objDragonfly.logger.add("text:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getTagName());
			objDragonfly.logger.add("tag_type:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getTagName() + "_" + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("type"));
			objDragonfly.logger.add("TagName:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("TagName"));
			objDragonfly.logger.add("type:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("type"));
			objDragonfly.logger.add("id:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("id"));
			objDragonfly.logger.add("name:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("name"));
			objDragonfly.logger.add("text:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("text"));
			objDragonfly.logger.add("innerText:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("innerText"));
			objDragonfly.logger.add("outerText:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("outerText"));
			objDragonfly.logger.add("innerHTML:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("innerHTML"));
			objDragonfly.logger.add("outerHTML:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML"));
			objDragonfly.logger.add("uniqueID:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("uniqueID"));
			objDragonfly.logger.add("class:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("class"));
			objDragonfly.logger.add("type:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("type"));
			objDragonfly.logger.add("TYPE:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("TYPE"));
			objDragonfly.logger.add("href:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("href"));
			objDragonfly.logger.add("NameProp:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("NameProp"));
			objDragonfly.logger.add("isDisplayed:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.isDisplayed());
			objDragonfly.logger.add("name:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.isEnabled());
			objDragonfly.logger.add("getLocation().x:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getLocation().x);
			objDragonfly.logger.add("getLocation().y:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getLocation().y);
			objDragonfly.logger.add("getSize().height:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getSize().height);
			objDragonfly.logger.add("getLocation().y:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getSize().width);
			objDragonfly.logger.add("src:=  " + objDragonfly.objVariablesSelenium.gobjWebElement.getAttribute("src"));
		}
	}

	public class WebElementCollectionAttributes {
		public WebElementCollectionAttributes(Dragonfly objDragonfly, String strTagName) {
			objDragonfly.logger.add("  ==start==>WebElementCollectionAttributes " + new DateTimestamp().get());
			int intCount = 0;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			List<WebElement> objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				intCount = intCount + 1;
				objDragonfly.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WebElementCollectionAttributes " + intCount);
				objDragonfly.logger.add("text:=  " + row.getTagName());
				objDragonfly.logger.add("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
				objDragonfly.logger.add("TagName:=  " + row.getAttribute("TagName"));
				objDragonfly.logger.add("type:=  " + row.getAttribute("type"));
				objDragonfly.logger.add("id:=  " + row.getAttribute("id"));
				objDragonfly.logger.add("name:=  " + row.getAttribute("name"));
				objDragonfly.logger.add("text:=  " + row.getAttribute("text"));
				objDragonfly.logger.add("innerText:=  " + row.getAttribute("innerText"));
				objDragonfly.logger.add("outerText:=  " + row.getAttribute("outerText"));
				objDragonfly.logger.add("innerHTML:=  " + row.getAttribute("innerHTML"));
				objDragonfly.logger.add("outerHTML:=  " + row.getAttribute("outerHTML"));
				objDragonfly.logger.add("uniqueID:=  " + row.getAttribute("uniqueID"));
				objDragonfly.logger.add("class:=  " + row.getAttribute("class"));
				objDragonfly.logger.add("type:=  " + row.getAttribute("type"));
				objDragonfly.logger.add("TYPE:=  " + row.getAttribute("TYPE"));
				objDragonfly.logger.add("href:=  " + row.getAttribute("href"));
				objDragonfly.logger.add("NameProp:=  " + row.getAttribute("NameProp"));
				objDragonfly.logger.add("isDisplayed:=  " + row.isDisplayed());
				objDragonfly.logger.add("name:=  " + row.isEnabled());
				objDragonfly.logger.add("getLocation().x:=  " + row.getLocation().x);
				objDragonfly.logger.add("getLocation().y:=  " + row.getLocation().y);
				objDragonfly.logger.add("getSize().height:=  " + row.getSize().height);
				objDragonfly.logger.add("getLocation().y:=  " + row.getSize().width);
				objDragonfly.logger.add("src:=  " + row.getAttribute("src"));
			}
		}
	}

	public class WebElementCollectionTable {
		public WebElementCollectionTable(Dragonfly objDragonfly, String strTagName) {
			boolean blnSkip = false;
			objDragonfly.logger.add("  ==start==>WebElementCollectionTable " + new DateTimestamp().get());
			// TODO webElementCollectionTable send output to html file
			int intCount = 0;
			//JSONObjectExtended objStepNew = null;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			objDragonfly.logger.add("WebElementCollectionTable: strTagName = " + strTagName);
			objDragonfly.logger.add("WebElementCollectionTable: lngStartTimeSwitchTo = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle());
			objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().defaultContent();
			for (String winHandle : objDragonfly.objVariablesSelenium.gobjWebDriver.getWindowHandles()) {
				intCount = 0;
				// objDragonfly.logger.add("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				objDragonfly.logger.add("WebElementCollectionTable: winHandle = " + winHandle);
				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// if (strCurrentWindowHandle.equals(winHandle)) {
				// } else {
				objDragonfly.objVariablesSelenium.gobjWebDriver.switchTo().window(winHandle);
				objDragonfly.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				objDragonfly.logger.add("WebElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// }
				objDragonfly.logger.add("WebElementCollectionTable: objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getTitle());
				//objDragonfly.logger.add("webElementCollectionTable objDragonfly.objVariablesSelenium.gobjWebDriver.getPageSource = " + objDragonfly.objVariablesSelenium.gobjWebDriver.getPageSource());
				objDragonfly.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				List<WebElement> objWebElementCollection = objDragonfly.objVariablesSelenium.gobjWebDriver.findElements(By.tagName(strTagName));
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
							objDragonfly.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
							objDragonfly.logger.add("WebElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
							objDragonfly.logger.add("WebElementCollectionTable: type:= '" + row.getAttribute("type") + "'");
							objDragonfly.logger.add("WebElementCollectionTable: getText:= '" + row.getText() + "'");
							objDragonfly.logger.add("WebElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
						}
					}
					// objDragonfly.logger.add("text:=  " + objWebElementEach.);
					// objDragonfly.logger.add("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
					// objDragonfly.logger.add("TagName:= '" + row.getAttribute("TagName") + "'");
					// objDragonfly.logger.add("Type:= '" + row.getAttribute("Type") + "'");
					// objDragonfly.logger.add("TYPE:= '" + row.getAttribute("TYPE") + "'");
					// objDragonfly.logger.add("id:= '" + row.getAttribute("id") + "'");
					// objDragonfly.logger.add("name:= '" + row.getAttribute("name") + "'");
					// objDragonfly.logger.add("text:= '" + row.getAttribute("text") + "'");
					// objDragonfly.logger.add("innerText:= '" + row.getAttribute("innerText") + "'");
					// objDragonfly.logger.add("outerText:= '" + row.getAttribute("outerText") + "'");
					// objDragonfly.logger.add("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
					// objDragonfly.logger.add("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
					// objDragonfly.logger.add("class:= '" + row.getAttribute("class") + "'");
					// objDragonfly.logger.add("href:= '" + row.getAttribute("href") + "'");
					// objDragonfly.logger.add("NameProp:= '" + row.getAttribute("NameProp") + "'");
					// objDragonfly.logger.add("isDisplayed:= '" + row.isDisplayed() + "'");
					// objDragonfly.logger.add("isEnabled:= '" + row.isEnabled() + "'");
					// objDragonfly.logger.add("getLocation().x:= '" + row.getLocation().x + "'");
					// objDragonfly.logger.add("getLocation().y:= '" + row.getLocation().y + "'");
					// objDragonfly.logger.add("getSize().height:= '" + row.getSize().height + "'");
					// objDragonfly.logger.add("getSize().width:= '" + row.getSize().width + "'");
					// objDragonfly.logger.add("src:= '" + row.getAttribute("src") + "'");
					// if (objCollectionJS.size() > 0) {
					//
					// JavascriptExecutor objJavascriptExecutor = null;
					// objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver;
					// long lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.logger.add("JS value = " +
					// objJavascriptExecutor.executeScript("return arguments[0].value;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.logger.add("JS innerText = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.logger.add("JS innerHTML = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.logger.add("JS outerHTML = " +
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

	public class WindowFocus {
		public WindowFocus(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>WindowFocus " + new DateTimestamp().get());
			// TODO debug gobjWebDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
			if (objDragonfly.objVariablesSelenium.gobjWebDriver instanceof JavascriptExecutor) {
				((JavascriptExecutor) objDragonfly.objVariablesSelenium.gobjWebDriver).executeScript("window.focus();");
			}
		}
	}

	public class WindowsMinimizeAll {
		public WindowsMinimizeAll(Dragonfly objDragonfly) {
			objDragonfly.logger.add("  ==start==>WindowsMinimizeAll " + new DateTimestamp().get());
			Robot objRobot = null;
			switch (objDragonfly.objOperatingSystem.strOS) {
			case "Windows":
				try {
					objRobot = new Robot();
					objRobot.keyPress(KeyEvent.VK_WINDOWS);
					objRobot.keyPress(KeyEvent.VK_D);
					objRobot.keyRelease(KeyEvent.VK_D);
					objRobot.keyRelease(KeyEvent.VK_WINDOWS);
					objDragonfly.logger.add("windowsMinimizeAll: Windows operating system minimize all windows.");
				} catch (Exception e) {
					objDragonfly.logger.add("windowsMinimizeAll: Exception = " + e.toString());
				}
				break;
			default:
				objDragonfly.logger.add("WindowsMinimizeAll: the operating system not supported at this time " + objDragonfly.objOperatingSystem.strOS);
			}
		}
	}

	public class WindowsProcessKill {
		public WindowsProcessKill(Dragonfly objDragonfly, String strProcessToKill) {
			objDragonfly.logger.add("  ==start==>WindowsProcessKill " + new DateTimestamp().get());
			try {
				Runtime.getRuntime().exec(strProcessToKill);
				objDragonfly.logger.add("WindowsProcessKill: process killed = " + strProcessToKill);
			} catch (Exception e) {
				objDragonfly.logger.add("WindowsProcessKill: Exception = " + e.toString());
			}
		}
	}

	public class WriteFile {
		public WriteFile(Dragonfly objDragonfly, String strFilePathFile, String strTextToWrite) {
			objDragonfly.logger.add("  ==start==>WriteFile " + new DateTimestamp().get());
			objDragonfly.logger.add("WriteFile: strFilePathFile = " + strFilePathFile);
			try {
				BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(strFilePathFile));
				objBufferedWriter.write(strTextToWrite);
				objBufferedWriter.close();
			} catch (Exception e) {
				objDragonfly.logger.add("WriteFile: Exception" + e.toString());
			}
		}
	}

	//	public class WriteJsonKeys {
	//		public WriteJsonKeys(Dragonfly objDragonfly, JSONObject objJsonObjectKeySet, String file) throws IOException {
	//			objDragonfly.logger.add("  ==start==>WriteJsonKeys " + new DateTimestamp().get());
	//			for (Iterator<?> iterator = objJsonObjectKeySet.keySet().iterator(); iterator.hasNext();) {
	//				String key = (String) iterator.next();
	//				objDragonfly.logger.add("WriteJsonKeys: " + key + " = " + objJsonObjectKeySet.get(key));
	//			}
	//		}
	//	}
	public class WriteJsonStepsToHtml {
		public WriteJsonStepsToHtml(Dragonfly objDragonfly, String strStepHeader, JSONArray objTestSteps, String strPath, String strFileName) {
			objDragonfly.logger.add("  ==start==>WriteJsonStepsToHtml " + new DateTimestamp().get());
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
					JSONObjectExtended objStepReport = objDragonfly.new JSONObjectExtended((JSONObject) objTestSteps.get(intTestStepRow));
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
				new WriteFile(objDragonfly, strPath + strFileName, html);
			} catch (Exception e) {
				objDragonfly.logger.add("WriteJsonStepsToHtml: Exception = " + e.toString());
				objDragonfly.logger.add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
				logger.add("WriteJsonStepsToHtml: Exception = " + e.toString());
				logger.add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			}
		}
	}

	public class WriteReportToHtml {
		public WriteReportToHtml(Dragonfly objDragonfly, JSONArray objJsonArrayReportSteps, String strFile, String strTestStepsFile, String strTestName) {
			long lngStartTime = System.currentTimeMillis();
			objDragonfly.logger.add("  ==start==>WriteReportToHtml " + new DateTimestamp().get());
			objDragonfly.logger.add("WriteReportToHtml: strFile = " + strFile);
			JSONObjectExtended objJsonObjectReportStep = null;
			//JSONObjectExtended objJsonObjectReportStep = objDragonfly.new JSONObjectExtended((JSONObject) null);
			String strScreenshotFilePath = "";
			String strStatus = "";
			String strStatusIcon = "";
			StringBuilder objStringBuilder = new StringBuilder();
			int intTestStepRow = 0;
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
					//objJsonObjectReportStep = (JSONObjectExtended) objJsonArrayReportSteps.get(intTestStepRow)
					objJsonObjectReportStep = objDragonfly.new JSONObjectExtended((JSONObject) objJsonArrayReportSteps.get(intTestStepRow));
					//objJsonObjectReportStep = (JSONObjectExtended) objJsonArrayReportSteps.get(intTestStepRow);
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
					String strStartTimestamp = objJsonObjectReportStep.get("strStartTimestamp").toString();
					String strStepDuration = objJsonObjectReportStep.get("strStepDuration").toString();
					String strEndTimestamp = objJsonObjectReportStep.get("strEndTimestamp").toString();
					objStringBuilder.append("<TD onclick=\"scrollToTop()\" rowspan=\"2\" width=60px align=center valign=middle>Step " + intTestStepRow + "</TD>");
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
							objStringBuilder.append("<img id=img_" + intTestStepRow + " src=\"data:image/jpg;base64," + new ImageEncodeToString().run(objDragonfly, objBufferedImage, "jpg") + "\" alt=\"Step " + intTestStepRow + "\" > ");
						} catch (Exception e) {
							objDragonfly.logger.add("writeReportToHtml: Exception = " + e.toString());
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
				objDragonfly.logger.add("WriteReportToHtml: " + e.toString());
			} finally {
				objStringBuilder.append("</body>");
				objStringBuilder.append("</html>");
				String strHTML = objStringBuilder.toString().replace("varImageCount = -1", "varImageCount = " + (intTestStepRow - 1));
				new WriteFile(objDragonfly, strFile, strHTML);
				new WriteFile(objDragonfly, strTestStepsFile, strHTML);
				objDragonfly.logger.add("WriteReportToHtml: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public static void main(String[] args) {
		JSONArray objJsonArrayTestSteps = null;
		JSONArray objJsonArrayTestStepsRun = new JSONArray();
		JSONParser objJsonParser = new JSONParser();
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.logger.add("  ==start==>main " + objDragonfly.new DateTimestamp().get());
		//String strValueToFindKeyword = "<ti><td><tl>key value";
		//String strValueToFindKeyword = "<ti><td>key value";
		//String strValueToFindKeyword = "<re>key value";
		//String[] arrKeywords = objDragonfly.new KeywordReturnArray().run(objDragonfly, strValueToFindKeyword);
		//System.out.println("	arrKeywords.length = " + arrKeywords.length);
		//System.exit(0);
		objDragonfly.objAutoItSetObject.createObject(objDragonfly);
		objDragonfly.objOperatingSystem.set(objDragonfly);
		String strNameTestConfiguration;
		try {
			objDragonfly.new DialogLaunch(objDragonfly);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objDragonfly.logger.add("main while dialog open");
		System.out.println("objDragonfly.objPaths.gstrTestArea = " + objDragonfly.objPaths.gstrTestArea);
		System.out.println("objDragonfly.objPaths.gstrPathData = " + objDragonfly.objPaths.gstrPathData);
		System.out.println("objDragonfly.objPaths.gstrPathTestConfiguration = " + objDragonfly.objPaths.gstrPathTestConfiguration);
		System.out.println("objDragonfly.objPaths.gstrPathSystemUserDir = " + objDragonfly.objPaths.gstrPathSystemUserDir);
		strNameTestConfiguration = objDragonfly.objPaths.gstrNameTest;
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
		String strCurrentWindowHandle = "";
		String strFileTestSteps = "";
		String strTestStatus = "";
		String strLoopExitValue = "";
		objDragonfly.new WindowsMinimizeAll(objDragonfly);
		objDragonfly.objTestConfigurationSetup.run(objDragonfly, strNameTestConfiguration);
		int intTestInstanceSize = objDragonfly.objTestConfigurationSetup.intTestInstanceSize;
		objDragonfly.logger.add("main: intTestInstanceSize = " + intTestInstanceSize);
		String strTestStepsCombinedOriginal = objDragonfly.variablesJSON.gobjJsonArrayTestSteps.toString();
		for (intTestInstanceEach = 0; intTestInstanceEach <= intTestInstanceSize; intTestInstanceEach++) {
			try {
				intStep = 0;
				intLoopCount = 0;
				intLoopEach = 0;
				intLoopStep = 0;
				strCurrentWindowHandle = "";
				strTestStatus = "pass";
				objDragonfly.logger.add("main: intTestInstanceEach = " + intTestInstanceEach);
				objDragonfly.objPaths.setPathResults(objDragonfly, intTestInstanceSize, strNameTestConfiguration);
				objJsonArrayTestSteps = (JSONArray) objJsonParser.parse(strTestStepsCombinedOriginal);
				if (intTestInstanceEach != 0) {
					objDragonfly.variablesJSON.objectTestInstancesEach = objDragonfly.new JSONObjectExtended((JSONObject) objDragonfly.variablesJSON.gobjJsonArrayTestInstances.get(intTestInstanceEach));
				}
				strFileTestSteps = objDragonfly.objPaths.gstrPathTestSteps + strNameTestConfiguration.replace(".json", ".html");
				objDragonfly.new WriteJsonStepsToHtml(objDragonfly, "original", objJsonArrayTestSteps, objDragonfly.objPaths.gstrPathResults, "StepsOriginal.html");
				//objDragonfly.logger.add("main: objJsonArrayTestSteps.size() = " + objJsonArrayTestSteps.size());
				for (intStep = 0; intStep < objJsonArrayTestSteps.size(); intStep++) {
					objDragonfly.logger.add("main: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					objDragonfly.objVariablesSelenium.gobjWebElement = null;
					objDragonfly.variablesJSON.objectStep = objDragonfly.new JSONObjectExtended((JSONObject) objJsonArrayTestSteps.get(intStep));
					//objDragonfly.variablesJSON.objectStep =   (  JSONObjectExtended) objJsonParser.parse(objJsonArrayTestSteps.get(intStep).toString());
					objDragonfly.new StepSetupDefaults(objDragonfly, strCurrentWindowHandle);
					String strInputValue = objDragonfly.variablesJSON.objectStep.get("strInputValue").toString();
					objDragonfly.new LogStepDetails(objDragonfly, intStep);
					if (objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().trim().length() > 0) {
						if (objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<loopstart>") == true) {
							if (intLoopEach == 0) {
								intLoopCount = Integer.parseInt(objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().substring(11));
								objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strLoopOrIf", "");
								intLoopEach = 1;
								intLoopStep = intStep;
							}
						}
					}
					if (!objDragonfly.variablesJSON.objectStep.get("strFunction").toString().trim().equals("")) {
						String strMethodName = objDragonfly.variablesJSON.objectStep.get("strFunction").toString();
						String strArguments = strInputValue;
						Class<?> objClass = Class.forName("org.DragonflyAutomation.Dragonfly");
						Class<?> objParameterTypes[] = new Class[2];
						objParameterTypes[0] = Dragonfly.class;
						objParameterTypes[1] = String.class;
						Method objMethod = objClass.getMethod(strMethodName, objParameterTypes);
						Object arrArgumentList[] = new Object[2];
						arrArgumentList[0] = objDragonfly;
						arrArgumentList[1] = new String(strArguments);
						Object objReturn = objMethod.invoke(objDragonfly, arrArgumentList);
						String strReturnValue = (String) objReturn;
						strInputValue = strReturnValue.toString();
						objDragonfly.variablesJSON.objectStep.putValue(objDragonfly, "strInputValue", strInputValue);
						objDragonfly.logger.add("main: call function return value = " + strInputValue);
					}
					if (objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<else if") == true) {
						objDragonfly.logger.add("main: blnIf = " + blnIf);
						if (blnIf == false) {
							blnIf = true;
						} else {
							blnIf = false;
						}
					}
					if (blnIf == true) {
						if (!strInputValue.toLowerCase().equals("<skip>")) {
							switch (objDragonfly.variablesJSON.objectStep.getLowerCase("strAction")) {
							case "kill_ie":
								objDragonfly.new ProcessKillInternetExplorer().run(objDragonfly);
								break;
							case "launch":
								objDragonfly.new BrowserLaunchSync(objDragonfly);
								break;
							case "close":
								objDragonfly.new BrowserCloseSync(objDragonfly);
								break;
							case "get":
								objDragonfly.new ElementGetSync(objDragonfly);
								break;
							case "set":
								objDragonfly.new ElementSetSync(objDragonfly, false);
								break;
							case "set_js":
								objDragonfly.new ElementSetSync(objDragonfly, true);
								break;
							case "verify":
								objDragonfly.new ElementVerifyValueSync(objDragonfly);
								break;
							case "verify_not":
								objDragonfly.new ElementVerifyNotValueSync(objDragonfly);
								break;
							case "sync_visible":
								objDragonfly.new ElementVisibleSync(objDragonfly);
								break;
							case "sync_hidden":
								objDragonfly.new ElementHiddenSync(objDragonfly);
								break;
							case "sync_enabled":
								objDragonfly.new ElementEnabledSync(objDragonfly);
								break;
							case "sync_disabled":
								objDragonfly.new ElementDisabledSync(objDragonfly);
								break;
							case "mouse_over":
								objDragonfly.new ElementOnMouseOverSync(objDragonfly);
								break;
							case "mouse_out":
								objDragonfly.new ElementOnMouseOutSync(objDragonfly);
								break;
							case "drag":
								objDragonfly.new ElementDragSync(objDragonfly);
								break;
							case "drop":
								objDragonfly.new ElementDropSync(objDragonfly);
								break;
							case "sleep":
								objDragonfly.new SleepSync(objDragonfly);
								break;
							case "refresh":
								objDragonfly.new BrowserRefreshSync(objDragonfly);
								break;
							case "scroll":
								objDragonfly.new ElementScrollSync(objDragonfly);
								break;
							case "break":
								objDragonfly.logger.add("main: switch strAction = break was entered to at this step to stop execution");
								return;
							default:
								objDragonfly.logger.add("main: switch strAction = " + objDragonfly.variablesJSON.objectStep.getLowerCase("strAction") + "  not supported");
								return;
							}
							strCurrentWindowHandle = objDragonfly.variablesJSON.objectStep.get("strCurrentWindowHandle").toString();
						}
					}
					if (objDragonfly.variablesJSON.objectStep.get("strOutputLinkName").toString().trim().length() != 0) {
						objDragonfly.variablesJSON.objectLinks.put(objDragonfly.variablesJSON.objectStep.get("strOutputLinkName").toString(), objDragonfly.variablesJSON.objectStep.get("strOutputValue").toString());
					}
					if (objDragonfly.variablesJSON.objectStep.verifyEquals("strStatus", "fail")) {
						strTestStatus = "fail";
						if (Boolean.parseBoolean(objDragonfly.variablesJSON.objectStep.get("blnExitOnFail").toString()) == true) {
							objDragonfly.new WebElementCollectionTable(objDragonfly, objDragonfly.variablesJSON.objectStep.get("strTagName").toString());
							break;
						}
					}
					switch (objDragonfly.new KeywordReturn().run(objDragonfly, objDragonfly.variablesJSON.objectStep.getLowerCase("strLoopOrIf"))) {
					case "<loopexit>":
						strLoopExitValue = objDragonfly.variablesJSON.objectStep.get("strLoopOrIf").toString().substring(10);
						if (objDragonfly.variablesJSON.objectStep.get("strOutputValue").toString().equals(strLoopExitValue)) {
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
						} else {
							blnIf = false;
						}
						break;
					case "<else if>":
						if (objDragonfly.variablesJSON.objectStep.verifyEquals("strStatus", "pass")) {
							blnIf = true;
						} else {
							blnIf = false;
						}
						break;
					case "<else>":
						objDragonfly.logger.add("main: <else> blnIf = " + blnIf);
						if (blnIf.equals(true)) {
							blnIf = false;
						} else {
							blnIf = true;
						}
						break;
					case "<end if>":
						objDragonfly.logger.add("main: blnIf = false");
						blnIf = true;
						break;
					}
					objDragonfly.logger.add("main: objectStep " + objDragonfly.variablesJSON.objectStep);
					objJsonArrayTestStepsRun.add(objDragonfly.variablesJSON.objectStep);
				}
			} catch (Exception e) {
				objDragonfly.logger.add("main: Exception " + e.toString());
			} finally {
				objDragonfly.new WriteFile(objDragonfly, objDragonfly.objPaths.gstrPathResults + "StepsAfterRun.json", objJsonArrayTestStepsRun.toString());
				objDragonfly.new WriteFile(objDragonfly, objDragonfly.objPaths.gstrPathResults + "StepsWithDefaults.json", objDragonfly.variablesJSON.gobjJsonArrayTestSteps.toString());
				objDragonfly.new WriteJsonStepsToHtml(objDragonfly, "original", objJsonArrayTestStepsRun, objDragonfly.objPaths.gstrPathResults, "StepsWithDefaults.html");
				objDragonfly.new WriteJsonStepsToHtml(objDragonfly, "complete", objJsonArrayTestStepsRun, objDragonfly.objPaths.gstrPathResults, "StepsAfterRun.html");
				objDragonfly.new WriteReportToHtml(objDragonfly, objJsonArrayTestStepsRun, objDragonfly.objPaths.gstrPathResults + "Report.html", strFileTestSteps, strNameTestConfiguration.replace(".json", ""));
				objDragonfly.new WriteFile(objDragonfly, objDragonfly.objPaths.gstrPathResults + "Dragonfly.log", objDragonfly.logger.getLog());
				objDragonfly.new WriteFile(objDragonfly, objDragonfly.objPaths.gstrPathResults + "StepsManual.txt", objDragonfly.objStepsManual.get());
				objDragonfly.objPaths.changeDirectoryNameStatus(objDragonfly, strTestStatus);
				if (objDragonfly.objVariablesSelenium.gobjWebDriver.toString().contains("InternetExplorerDriver")) {
					objDragonfly.new WindowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
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
	//JsonObjectStepPut objJsonObjectStepPut = new JsonObjectStepPut();
	StepsManual objStepsManual = new StepsManual();
	VariablesCommon objVariablesCommon = new VariablesCommon();

	public String data_DateDaysOut(Dragonfly objDragonfly, String strDaysOut) {
		objDragonfly.logger.add("  ==start==>data_DateDaysOut " + new DateTimestamp().get());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat objFormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (objFormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_EnvironmentURL(Dragonfly objDragonfly, String strApplication_Environment) {
		JSONParser objJsonParser = new JSONParser();
		objDragonfly.logger.add("  ==start==>data_EnvironmentURL " + new DateTimestamp().get());
		String strURL = "";
		objDragonfly.logger.add("data_EnvironmentURL: objDragonfly.objPaths.gstrPathTestData = " + objDragonfly.objPaths.gstrPathTestData);
		String strFilePathTestData = objDragonfly.objPaths.gstrPathTestData + "Environment.json";
		objDragonfly.logger.add("data_EnvironmentURL: strFilePathTestData = " + strFilePathTestData);
		try {
			JSONObjectExtended objJsonObjectFile = objDragonfly.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathTestData)));
			objDragonfly.logger.add("data_EnvironmentURL: strApplication_Environment = " + strApplication_Environment);
			strURL = objJsonObjectFile.get(strApplication_Environment).toString();
			objDragonfly.logger.add("data_EnvironmentURL: strURL = " + strURL);
		} catch (Exception e) {
			objDragonfly.logger.add("data_EnvironmentURL: Exception = " + e.toString());
		}
		return strURL;
	}

	public String data_localWebsiteFilePath(Dragonfly objDragonfly, String strWebsite) {
		objDragonfly.logger.add("  ==start==>data_localWebsiteFilePath " + new DateTimestamp().get());
		String strLocalWebsiteFilePath = "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		objDragonfly.logger.add("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public String data_RandomFourNumbers(Dragonfly objDragonfly, String strDaysOut) {
		objDragonfly.logger.add("  ==start==>data_RandomFourNumbers " + new DateTimestamp().get());
		return Integer.toString(new RandomNumberRange().run(objDragonfly, 1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(Dragonfly objDragonfly, String strDataInput) {
		objDragonfly.logger.add("  ==start==>data_RandomRangeFiveNumbers " + new DateTimestamp().get());
		return Integer.toString(new RandomNumberRange().run(objDragonfly, 1, 99999));
	}
}
//	public class KeywordReturnArray {
//		public String[] run(Dragonfly objDragonfly, String strValueToFindKeyword) {
//			String strKeyword = "";
//			String[] arrResults = null;
//			String strKeywordValue = "";
//			int intLeftArrowPositionEach = 0;
//			int intLeftArrowPosition = -1;
//			int intRightArrowPosition = 0;
//			int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace("<", "").length();
//			for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
//				intLeftArrowPositionEach = intLeftArrowPosition + 1;
//				intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intLeftArrowPositionEach);
//				intRightArrowPosition = strValueToFindKeyword.indexOf(">", intLeftArrowPosition);
//				if (intLeftArrowPosition > -1) {
//					if (strKeyword.length() == 0) {
//						strKeyword = strValueToFindKeyword.substring(intRightArrowPosition + 1, intRightArrowPosition + 1);
//					} else {
//						strKeyword = strKeyword + "|" + strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1);
//					}
//				}
//			}
//			strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
//			arrResults = strKeyword.split("\\|");
//			objDragonfly.logger.add("KeywordReturnArray: strKeyword " + strKeyword);
//			objDragonfly.logger.add("KeywordReturnArray: arrResults " + arrResults.toString());
//			for (int intKeysEach = 0; intKeysEach < arrResults.length; intKeysEach++) {
//				objDragonfly.logger.add("KeywordReturnArray: arrResults[intKeysEach].toString() " + arrResults[intKeysEach].toString());
//			}
//			return arrResults;
//		}
//	}
//	public static ExpectedCondition<Boolean> waitForAngularFinishProcessing(Dragonfly objDragonfly) {
//		objDragonfly.logger.add("  ==start==>waitForAngularFinishProcessing " + new DateTimestamp().get());
//		return new ExpectedCondition<Boolean>() {
//			@Override
//			public Boolean apply(WebDriver driver) {
//				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
//			}
//		};
//	}
//public static int loopEndFind(JSONObject objJSONObject) {
//		objDragonfly.logger.add("  ==start==>loopEndFind " + new DateTimestamp().get());
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
//			if (objStep2.get("strLoopOrIf").toString().toLowerCase().startsWith("<loopend>") == true) {
//				return intStep2;
//			}
//		}
//return 0;
//}
//Options for public class ClearMyTracksByProcessCookies
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