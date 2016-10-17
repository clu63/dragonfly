//TODO Alert handling get and verify
//TODO alertFind complete, determine which is best approach and choose method delete one
//TODO Create an array json for link values from output link name
//TODO Update json with results status timing step details
//TODO Confirm all browsers work
//TODO Json Element properties combine , using json format for key and value
//TODO Reporting add step details
//TODO Encryption
//TODO Add comment to file for changes
//TODO create a level for logging and add a global variable and a switch statement to Dragonfly.this.logger.add with several levels to filter what calls are added to Dragonfly.this.logger.add with a new input parameter intLevel
//TODO add recursive method for iframes
//TODO create new method for attribute setup to only call once per step
//TODO class to validate keywords for all standard
// sample of variable names
//strPathTestSteps
//strFileTestSteps
//strNameTestSteps
//strValueTestSteps
//
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
	private class AlertFind {
		private boolean run() {
			Dragonfly.this.logger.add("  ==start==>AlertFind " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				String strAlertPresent = Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().alert().getText();
				Dragonfly.this.logger.add("AlertFind: alert found:  " + strAlertPresent);
				return true;
			} catch (UnhandledAlertException e) {
				Dragonfly.this.logger.add("AlertFind: UnhandledAlertException = " + e.toString());
				return true;
			} catch (NoAlertPresentException e) {
				Dragonfly.this.logger.add("AlertFind: NoAlertPresentException = " + e.toString());
				return false;
			} catch (Exception e) {
				Dragonfly.this.logger.add("AlertFind: Exception = " + e.toString());
				return false;
			} finally {
				Dragonfly.this.logger.add("AlertFind: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class AutoItSetObject {
		private AutoItX objAutoIt;

		private void createObject() {
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

		private AutoItX getObject() {
			return objAutoIt;
		}
	}

	private class BrowserClose {
		private BrowserClose() {
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.close();
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.quit();
			//Dragonfly.this.objJsonObjectStepPut.run( "strStatus", "pass");
			Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
			new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>BrowserLaunch " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Dragonfly.this.logger.add(" Dragonfly.this.objVariablesCommon.gstrBrowserSelection = " + Dragonfly.this.objVariablesCommon.gstrBrowserSelection);
			if (Dragonfly.this.objVariablesCommon.gstrBrowserSelection != "TestValue") {
				//Dragonfly.this.new JsonObjectStepPut().run( "strTagName", Dragonfly.this.objVariablesCommon.gstrBrowserSelection);
				Dragonfly.this.variablesJSON.objectStep.putValue("strTagName", Dragonfly.this.objVariablesCommon.gstrBrowserSelection);
			}
			DesiredCapabilities objDesiredCapabilities = null;
			try {
				//Dragonfly.this.objJsonObjectStepPut.run( "strStatus", "pass");
				Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
				switch (Dragonfly.this.variablesJSON.objectStep.getString("strTagName")) {
				case "firefox":
					Dragonfly.this.objVariablesSelenium.gobjWebDriver = new FirefoxDriver();
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.get(Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					Actions myAction = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
					myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
					break;
				case "ie":
					// internetExplorerProcessKill();
					//windowsProcessKill( "taskkill /F /IM iexplore.exe");
					new SleepMilliseconds(1000);
					Dragonfly.this.logger.add("BrowserLaunch: DesiredCapabilities");
					objDesiredCapabilities = DesiredCapabilities.internetExplorer();
					Dragonfly.this.logger.add("BrowserLaunch: objDesiredCapabilities.toString()" + objDesiredCapabilities);
					Dragonfly.this.logger.add("BrowserLaunch: setJavascriptEnabled");
					objDesiredCapabilities.setJavascriptEnabled(true);
					Dragonfly.this.logger.add("BrowserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
					Dragonfly.this.logger.add("BrowserLaunch: IE_ENSURE_CLEAN_SESSION");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					Dragonfly.this.logger.add("BrowserLaunch: REQUIRE_WINDOW_FOCUS");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					Dragonfly.this.logger.add("BrowserLaunch: INITIAL_BROWSER_URL");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
					Dragonfly.this.logger.add("BrowserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					Dragonfly.this.logger.add("BrowserLaunch: new InternetExplorerDriver(desiredCapabilities)");
					Dragonfly.this.objVariablesSelenium.gobjWebDriver = new InternetExplorerDriver(objDesiredCapabilities);
					//Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().getCookieNamed("JSESSIONID");
					// Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
					Dragonfly.this.logger.add("BrowserLaunch: Dragonfly.this.variablesJSON.objectStep.getString(strInputValue)  = " + Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					//Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.get(Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
					//Dragonfly.this.logger.add("browserLaunch: getCookieNamed(JSESSIONID) = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().getCookieNamed("JSESSIONID").toString());
					Dragonfly.this.logger.add("BrowserLaunch: Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().maximize()");
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					//Capabilities getCapabilities();
					break;
				case "chrome":
					switch (Dragonfly.this.objOperatingSystem.strOS) {
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
					Dragonfly.this.objVariablesSelenium.gobjWebDriver = new ChromeDriver();
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.get(Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					break;
				case "safari":
					Dragonfly.this.objVariablesSelenium.gobjWebDriver = new SafariDriver();
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.get(Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					break;
				case "opera":
					// TODO OperaDriver setup latest driver and test desiredCapabilities = DesiredCapabilities.internetExplorer();
					// desiredCapabilities.setJavascriptEnabled(true);
					//Dragonfly.this.objVariablesSelenium.gobjWebDriver = new OperaDriver();
					//Dragonfly.this.objVariablesSelenium.setGobjWebDriver(new OperaDriver());
					Dragonfly.this.objVariablesSelenium.gobjWebDriver = new OperaDriver();
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.get(Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
					// Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
					// Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().setPosition(new Point(0, 0));
					// Dimension dim = new Dimension(1382, 754);
					// Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().setSize(dim);
					// Selenium selenium;
					// Dragonfly.this.objVariablesSelenium.gobjWebDriver = new OperaDriver();
					// selenium = new WebDriverBackedSelenium(Dragonfly.this.objVariablesSelenium.gobjWebDriver, "https://www.google.com/");
					// return Dragonfly.this.objVariablesSelenium.gobjWebDriver;
					break;
				default:
					Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "fail");
					throw new ExceptionBrowserDriverNotSupported("Browser '" + Dragonfly.this.variablesJSON.objectStep.getString("strTagName") + "' not supported");
				}
			} catch (Exception e) {
				Dragonfly.this.logger.add("BrowserLaunch: Exception" + e.toString());
			} finally {
				Dragonfly.this.variablesJSON.objectStep.putValue("strCurrentWindowHandle", Dragonfly.this.objVariablesSelenium.gobjWebDriver.getWindowHandle());
				new CoordinatesElement();
				new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
				new StepDuration("BrowserLaunch", lngTimeStart, "launch");
			}
		}
	}

	private class BrowserLaunchSync {
		private BrowserLaunchSync() {
			Dragonfly.this.logger.add("  ==start==>BrowserLaunchSync " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Dragonfly.this.writeFile("c:\\temp\\DragonflyBrowser.log", Dragonfly.this.logger.getLog());
			try {
				new BrowserLaunch();
			} catch (ExceptionBrowserDriverNotSupported e) {
				// TODO confirm the exceptions to catch in main some may need to be removed
				Dragonfly.this.logger.add("main: " + e.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO create a BrowserLaunchSync to manage reporting and sync
				Dragonfly.this.logger.add("BrowserLaunchSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class BrowserRefresh {
		private BrowserRefresh() {
			Dragonfly.this.logger.add("  ==start==>BrowserRefresh " + new DateTimestamp().get());
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.navigate().refresh();
		}
	}

	private class BrowserRefreshSync {
		private BrowserRefreshSync() {
			new BrowserRefresh();
		}
	}

	private class ClearMyTracksByProcessCache {
		private ClearMyTracksByProcessCache() throws Exception {
			Dragonfly.this.logger.add("  ==start==>ClearMyTracksByProcessCache " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	private class ClearMyTracksByProcessCookies {
		private ClearMyTracksByProcessCookies() throws Exception {
			Dragonfly.this.logger.add("  ==start==>ClearMyTracksByProcessCookies " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	private class ClipboardGet {
		private String run() {
			Dragonfly.this.logger.add("  ==start==>ClipboardGet " + new DateTimestamp().get());
			String strClipboardData = "";
			try {
				strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				Dragonfly.this.logger.add("ClipboardGet: strClipboardData = " + strClipboardData);
			} catch (Exception e) {
				Dragonfly.this.logger.add("ClipboardGet: Exception = " + e.toString());
			}
			return strClipboardData;
		}
	}

	private class CommandLineExecution {
		private CommandLineExecution() throws Exception {
			Dragonfly.this.logger.add("  ==start==>CommandLineExecution " + new DateTimestamp().get());
			Process p = Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			p.waitFor();
			Process p5 = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 10");
			p5.waitFor();
			String strPathCookiesLow = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Cookies\\Low\\";
			strPathCookiesLow = strPathCookiesLow.replaceAll("\\\\", "/");
			Dragonfly.this.logger.add("CommandLineExecution: strPathCookiesLow = " + strPathCookiesLow);
			FileUtils.deleteDirectory(new File(strPathCookiesLow));
			String strPathCacheLow = System.getenv("APPDATA") + "Local/Microsoft/Windows/Temporary Internet Files/Low/";
			strPathCacheLow = strPathCacheLow.replaceAll("\\\\", "/");
			Dragonfly.this.logger.add("CommandLineExecution: strPathCacheLow = " + strPathCacheLow);
			FileUtils.deleteDirectory(new File(strPathCacheLow));
		}
	}

	private class ConvertPathByOperatingSystem {
		private void run(String strPath) {
			//Dragonfly.this.logger.add("main: gstrOperatingSystem = " + Dragonfly.this.objOperatingSystem.strOS);
			//				switch (gstrOperatingSystem) {
			//				case "Windows":
			//					strPathResults = Dragonfly.this.objPaths.getPathSystemUserDir() + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\" + gstrPathResults + "\\";
			//					strPathImages = "images\\";
			//					break;
			//				case "Mac":
			//					strPathResults = Dragonfly.this.objPaths.getPathSystemUserDir() + "/Results/" + strTestConfigurationFileName.replace(".json", "") + "/" + gstrPathResults + "/";
			//					strPathImages = "images/";
			//					break;
			//				default:
			//					Dragonfly.this.logger.add("main: switch gstrOperatingSystem = " + gstrOperatingSystem + "  not supported");
			//					return;
			//				}
		}
	}

	private class CoordinateHighlightScreenshot {
		private CoordinateHighlightScreenshot(final JSONObjectExtended objJsonObjectStepHighlightArea) {
			Dragonfly.this.logger.add("  ==start==>CoordinateHighlightScreenshot " + new DateTimestamp().get());
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
						Dragonfly.this.logger.add("CoordinateHighlightScreenshot: strHighlightArea = " + Dragonfly.this.variablesJSON.objectStep.getString("strHighlightArea"));
						new RectangleAreaByName(intThickness, Dragonfly.this.variablesJSON.objectStep.getString("strHighlightArea"), objHighlightArea);
						setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
						setUndecorated(true);
						setBackground(new Color(0, 0, 0, 0));
						getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
						setVisible(true);
					}
				}
			};
			int intSleepMilliseconds = 0;
			if (Dragonfly.this.variablesJSON.objectStep.getBoolean("blnScreenshot") == true) {
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				String strScreenshotFilePath = "";
				try {
					new RectangleAreaByName(0, Dragonfly.this.variablesJSON.objectStep.getString("strScreenshotArea"), objHighlightArea);
					BufferedImage objScreenShot = new Robot().createScreenCapture(objHighlightArea);
					strScreenshotFilePath = Dragonfly.this.objPaths.gstrPathImages + "Screenshot_" + new DateTimestamp().get() + ".jpg";
					Thread objThread = new Thread(new ThreadSaveImage(objScreenShot, "jpg", strScreenshotFilePath));
					objThread.start();
					Dragonfly.this.variablesJSON.objectStep.putValue("strScreenshotFilePath", strScreenshotFilePath);
				} catch (Exception e) {
					Dragonfly.this.logger.add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
			}
			if (Dragonfly.this.variablesJSON.objectStep.getBoolean("blnHighlight") == true) {
				try {
					Thread.sleep(intSleepMilliseconds);
				} catch (InterruptedException e) {
					Dragonfly.this.logger.add("CoordinateHighlightScreenshot: Exception " + e.toString());
				}
				objJFrame.setVisible(false);
				objJFrame.dispose();
			}
			Dragonfly.this.logger.add("CoordinateHighlightScreenshot: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	private class CoordinatesAlert {
		private CoordinatesAlert() {
			Dragonfly.this.logger.add("  ==start==>CoordinatesAlert " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			AutoItX objAutoIt = Dragonfly.this.objAutoItSetObject.getObject();
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
				switch (Dragonfly.this.variablesJSON.objectStep.getLowerCase("strAttributeValues")) {
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
				switch (Dragonfly.this.variablesJSON.objectStep.getLowerCase("strAttributeValues")) {
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
				Dragonfly.this.variablesJSON.objectStep.putInt("intElementScreenX", intWinPosX);
				Dragonfly.this.variablesJSON.objectStep.putInt("intElementScreenY", intWinPosY);
				Dragonfly.this.variablesJSON.objectStep.putInt("intElementWidth", intWinPosWidth);
				Dragonfly.this.variablesJSON.objectStep.putInt("intElementHeight", intWinPosHeight);
			} catch (Exception e) {
				Dragonfly.this.logger.add("CoordinatesAlert: Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("CoordinatesAlert: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class CoordinatesBrowserInner {
		private CoordinatesBrowserInner() throws WebDriverException {
			Dragonfly.this.logger.add("  ==start==>CoordinatesBrowserInner " + new DateTimestamp().get());
			//Dragonfly.this.objVariablesSelenium.gobjWebDriverCoordinates = Dragonfly.this.objVariablesSelenium.gobjWebDriver;
			//Dragonfly.this.objVariablesSelenium.gobjWebDriverCoordinates.switchTo().defaultContent();
			long lngBrowserInnerWidth = 0;
			long lngBrowserInnerHeight = 0;
			try {
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			} catch (WebDriverException e) {
				Dragonfly.this.logger.add("CoordinatesBrowserInner: WebDriverException = " + e.toString());
				throw new WebDriverException("WebDriverException returned");
			} catch (Exception e) {
				Dragonfly.this.logger.add("CoordinatesBrowserInner: Exception = " + e.toString());
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return document.body.offsetWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriverCoordinates).executeScript("return document.body.offsetHeight;");
			}
			Dragonfly.this.variablesJSON.objectStep.putLong("intBrowserInnerWidth", lngBrowserInnerWidth);
			Dragonfly.this.variablesJSON.objectStep.putLong("intBrowserInnerHeight", lngBrowserInnerHeight);
		}
	}

	private class CoordinatesElement {
		private CoordinatesElement() {
			Dragonfly.this.logger.add("  ==start==>CoordinatesElement " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				//new CoordinatesBrowserInner(   );
				int intScrollbar = 0;
				Point objWebDriverPoint = Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().getPosition();
				int intBrowserOuterX = objWebDriverPoint.x;
				int intBrowserOuterY = objWebDriverPoint.y;
				Dimension objWebDriverDimension = Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().getSize();
				int intBrowserOuterWidth = objWebDriverDimension.width;
				int intBrowserOuterHeight = objWebDriverDimension.height;
				Dragonfly.this.variablesJSON.objectStep.putInt("intBrowserOuterX", intBrowserOuterX);
				Dragonfly.this.variablesJSON.objectStep.putInt("intBrowserOuterY", intBrowserOuterY);
				Dragonfly.this.variablesJSON.objectStep.putInt("intBrowserOuterWidth", intBrowserOuterWidth);
				Dragonfly.this.variablesJSON.objectStep.putInt("intBrowserOuterHeight", intBrowserOuterHeight);
				if (Dragonfly.this.objVariablesSelenium.gobjWebElement != null) {
					Coordinates objElementCoordinates = ((Locatable) Dragonfly.this.objVariablesSelenium.gobjWebElement).getCoordinates();
					Point objElementPoint = objElementCoordinates.inViewPort();
					Dimension objElementDimension = Dragonfly.this.objVariablesSelenium.gobjWebElement.getSize();
					Dragonfly.this.variablesJSON.objectStep.putInt("intElementX", objElementPoint.x);
					Dragonfly.this.variablesJSON.objectStep.putInt("intElementY", objElementPoint.y);
					Dragonfly.this.variablesJSON.objectStep.putInt("intElementWidth", objElementDimension.width);
					Dragonfly.this.variablesJSON.objectStep.putInt("intElementHeight", objElementDimension.height);
				}
				//Dragonfly.this.logger.add("CoordinatesElement: Dragonfly.this.variablesJSON.objectStep.containsKey = " + Dragonfly.this.variablesJSON.objectStep.containsKey("intElementX"));
				//if (Dragonfly.this.variablesJSON.objectStep.containsKey("intElementX")) {
				//TODO this is the error
				int intBrowserInnerWidth = Dragonfly.this.variablesJSON.objectStep.getInt("intBrowserInnerWidth");
				int intBrowserInnerHeight = Dragonfly.this.variablesJSON.objectStep.getInt("intBrowserInnerHeight");
				int intElementX = Dragonfly.this.variablesJSON.objectStep.getInt("intElementX");
				int intElementY = Dragonfly.this.variablesJSON.objectStep.getInt("intElementY");
				int intWindowBorder = (intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2;
				int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
				int intElementScreenY = (intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder;
				Dragonfly.this.variablesJSON.objectStep.putInt("intElementScreenX", intElementScreenX);
				Dragonfly.this.variablesJSON.objectStep.putInt("intElementScreenY", intElementScreenY);
				//}
			} catch (Exception e) {
				Dragonfly.this.logger.add("CoordinatesElement: Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("  ==end==>CoordinatesElement " + new DateTimestamp().get());
				Dragonfly.this.logger.add("CoordinatesElement: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class DateTimeFormat {
		private String set(Long lngStartTimeMillis) {
			Dragonfly.this.logger.add("  ==start==>DateTimeFormat " + new DateTimestamp().get());
			return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS").format(new Date(lngStartTimeMillis));
		}
	}

	private class DateTimestamp {
		private String get() {
			return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
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
			Dragonfly.this.objVariablesCommon.gstrBrowserSelection = "TestValue";
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rdbtnLocal) {
				this.gstrTestArea = "local";
				Dragonfly.this.objPaths.gstrTestArea = "local";
				Dragonfly.this.objPaths.setDirectory("local");
				System.out.println("Dragonfly.this.objPaths.gstrTestArea = " + Dragonfly.this.objPaths.gstrTestArea);
				System.out.println(Dragonfly.this.objPaths.gstrPathSystemUserDir);
				System.out.println(Dragonfly.this.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = Dragonfly.this.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + Dragonfly.this.objPaths.gstrPathTestConfiguration;
				System.out.println("dirPath = " + dirPath);
				this.getApplications();
			}
			if (e.getSource() == rdbtnPublic) {
				this.gstrTestArea = "public";
				Dragonfly.this.objPaths.gstrTestArea = "public";
				Dragonfly.this.objPaths.setDirectory("public");
				System.out.println("Dragonfly.this.objPaths.gstrTestArea = " + Dragonfly.this.objPaths.gstrTestArea);
				System.out.println(Dragonfly.this.objPaths.gstrPathSystemUserDir);
				System.out.println(Dragonfly.this.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = Dragonfly.this.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + Dragonfly.this.objPaths.gstrPathTestConfiguration;
				System.out.println("dirPath = " + dirPath);
				this.getApplications();
			}
			if (e.getSource() == rdbtnInternal) {
				this.gstrTestArea = "internal";
				Dragonfly.this.objPaths.gstrTestArea = "internal";
				Dragonfly.this.objPaths.setDirectory("internal");
				System.out.println("Dragonfly.this.objPaths.gstrTestArea = " + Dragonfly.this.objPaths.gstrTestArea);
				System.out.println(Dragonfly.this.objPaths.gstrPathSystemUserDir);
				System.out.println(Dragonfly.this.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/"));
				dirPath = Dragonfly.this.objPaths.gstrPathSystemUserDir.replaceAll("\\\\", "/");
				dirPath = dirPath + "/" + Dragonfly.this.objPaths.gstrPathTestConfiguration;
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
				Dragonfly.this.objVariablesCommon.gstrBrowserSelection = "TestValue";
			}
			if (e.getSource() == rdbtnChrome) {
				Dragonfly.this.objVariablesCommon.gstrBrowserSelection = "chrome";
			}
			if (e.getSource() == rdbtnFirefox) {
				Dragonfly.this.objVariablesCommon.gstrBrowserSelection = "firefox";
			}
			if (e.getSource() == rdbtnIE) {
				Dragonfly.this.objVariablesCommon.gstrBrowserSelection = "ie";
			}
			if (e.getSource() == btnRun) {
				System.out.println(comboTest.getSelectedItem());
				Dragonfly.this.objPaths.gstrNameTest = (String) comboTest.getSelectedItem();
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
			Dragonfly.this.logger.add("  ==start==>ElementDisabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				//			if (Dragonfly.this.variablesJSON.objectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				//				if (alertFind() == true) {
				//					return true;
				//				} else {
				//					throw new ExceptionElementNotDisabled("Alert popup was not found.");
				//				}
				//			}
				if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isEnabled()) {
					throw new ExceptionElementNotDisabled("ElementDisabled - Element is not disabled");
				} else {
					return;
				}
			} finally {
				Dragonfly.this.logger.add("ElementDisabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementDisabledSync {
		private ElementDisabledSync() {
			Dragonfly.this.logger.add("  ==start==>ElementDisabledSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotDisabled e) {
					blnDisabled = false;
					Dragonfly.this.logger.add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "elementDisabledSync", "syncdisabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>ElementDragSync " + new DateTimestamp().get());
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
						Dragonfly.this.logger.add("ElementDragSync: elementFind over");
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							Dragonfly.this.logger.add("ElementDragSync: outerHTML = " + strOuterHTML);
							Dragonfly.this.logger.add("ElementDragSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						Dragonfly.this.logger.add("ElementDragSync: strOuterHTML over");
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
					Dragonfly.this.objVariablesSelenium.gobjWebElementDrag = Dragonfly.this.objVariablesSelenium.gobjWebElement;
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Dragonfly.this.logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Dragonfly.this.logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Dragonfly.this.logger.add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					//} catch (ExceptionElementTagNameNotSupported e) {
					//Dragonfly.this.logger.add("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					//	blnExit = true;
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "elementDragSync", "drag", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
						return;
					} else {
					}
				}
			}
		}
	}

	private class ElementDropSync {
		private ElementDropSync() {
			Dragonfly.this.logger.add("  ==start==>ElementDropSync " + new DateTimestamp().get());
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
						Dragonfly.this.logger.add("ElementDropSync: elementFind over");
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							Dragonfly.this.logger.add("ElementDropSync: outerHTML = " + strOuterHTML);
							Dragonfly.this.logger.add("ElementDropSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						Dragonfly.this.logger.add("ElementDropSync: strOuterHTML over");
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
					Dragonfly.this.objVariablesSelenium.gobjWebElementDrop = Dragonfly.this.objVariablesSelenium.gobjWebElement;
					//Actions actions = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
					//actions.dragAndDrop(Dragonfly.this.objVariablesSelenium.gobjWebElementDrag, Dragonfly.this.objVariablesSelenium.gobjWebElementDrop).perform();
					//				Actions action = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
					//				Action dragDrop = action.dragAndDrop(gobjWebElementDrag, Dragonfly.this.objVariablesSelenium.gobjWebElementDrop).build();
					//				dragDrop.perform();
					Actions objActions = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
					Action objDragAndDrop = objActions.clickAndHold(Dragonfly.this.objVariablesSelenium.gobjWebElementDrag).moveToElement(Dragonfly.this.objVariablesSelenium.gobjWebElementDrop).release(Dragonfly.this.objVariablesSelenium.gobjWebElementDrop).build();
					objDragAndDrop.perform();
					//				Actions action = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
					//				action.dragAndDrop(Dragonfly.this.objVariablesSelenium.gobjWebElementDrag, Dragonfly.this.objVariablesSelenium.gobjWebElementDrop).build().perform();
					new SleepMilliseconds(10000);
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Dragonfly.this.logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Dragonfly.this.logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Dragonfly.this.logger.add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "elementDropSync", "drop", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
						return;
					}
				}
			}
		}
	}

	private class ElementEnabled {
		private ElementEnabled() throws ExceptionElementNotEnabled {
			Dragonfly.this.logger.add("  ==start==>ElementEnabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == true) {
						return;
					} else {
						throw new ExceptionElementNotEnabled("Alert popup was not found.");
					}
				}
				if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isEnabled()) {
					return;
				} else {
					throw new ExceptionElementNotEnabled("ElementEnabled - Element is not enabled");
				}
			} finally {
				Dragonfly.this.logger.add("ElementEnabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementEnabledSync {
		private ElementEnabledSync() {
			Dragonfly.this.logger.add("  ==start==>ElementEnabledSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Dragonfly.this.logger.add("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "ElementEnabledSync", "syncenabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>ElementFind " + new DateTimestamp().get());
			if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
				Dragonfly.this.variablesJSON.objectStep.putValue("strTagType", "alert");
				if (new AlertFind().run() == true) {
					Dragonfly.this.variablesJSON.objectStep.putValue("strHighlightArea", "alert");
					return;
				} else {
					Dragonfly.this.variablesJSON.objectStep.putValue("strHighlightArea", "screen");
					throw new ExceptionElementNotFound("Alert popup not found!");
				}
			}
			if (Dragonfly.this.variablesJSON.objectStep.get("strTagName").toString().toLowerCase().equals("title")) {
				Dragonfly.this.variablesJSON.objectStep.putValue("strTagType", "title");
				return;
			}
			String strWindowHandle = "";
			Object[] arrHandles = Dragonfly.this.objVariablesSelenium.gobjWebDriver.getWindowHandles().toArray();
			for (Object objWindowHandlesEach : arrHandles) {
				Dragonfly.this.logger.add("ElementFind: objWindowHandlesEach.toString() = " + objWindowHandlesEach.toString());
			}
			for (Object objWindowHandlesEach : arrHandles) {
				try {
					strWindowHandle = objWindowHandlesEach.toString();
					Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().window(strWindowHandle);
					Dragonfly.this.objVariablesSelenium.gobjWebDriverCoordinates = Dragonfly.this.objVariablesSelenium.gobjWebDriver;
					new CoordinatesBrowserInner();
					List<Integer> arrRouteOriginal = new ArrayList<Integer>();
					new ElementFindFramesSearch().run(arrRouteOriginal);
					if (Dragonfly.this.objVariablesSelenium.gobjWebElement != null) {
						//Dragonfly.this.logger.add("elementFind: Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
						//Dragonfly.this.logger.add("elementFind: Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle());
						//Dragonfly.this.logger.add("ElementFindFramesSearch: Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle());
						//Dragonfly.this.logger.add("ElementFindFramesSearch: Dragonfly.this.objVariablesSelenium.gobjWebDriver.getCurrentUrl = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getCurrentUrl());
						//Dragonfly.this.logger.add("ElementFindFramesSearch: Dragonfly.this.objVariablesSelenium.gobjWebDriver.getWindowHandle = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getWindowHandle());
						//Dragonfly.this.logger.add("ElementFindFramesSearch Dragonfly.this.objVariablesSelenium.gobjWebDriver.getPageSource = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getPageSource());
						return;
					}
				} catch (Exception e) {
					Dragonfly.this.logger.add("ElementFind: Exception = " + e.toString());
				}
			}
			throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
		}
	}

	private class ElementFindBy {
		private ElementFindBy(String strAttributeNames, String strAttributeValues, String strTagName) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			Dragonfly.this.logger.add("  ==start==>ElementFindBy " + new DateTimestamp().get());
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
				objWebElementCollection = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.xpath(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("id")) {
				objWebElementCollection = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.id(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("name")) {
				objWebElementCollection = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.name(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("class")) {
				objWebElementCollection = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.className(strAttributeValues));
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
							Dragonfly.this.variablesJSON.objectStep.putValue("strType", arrAttributeValues[intAttributeEach]);
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
				Dragonfly.this.logger.add("ElementFindBy: strXpath = " + strXpath);
				objWebElementCollection = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.xpath(strXpath));
			}
			switch (objWebElementCollection.size()) {
			case 0:
				throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
			case 1:
				Dragonfly.this.objVariablesSelenium.gobjWebElement = objWebElementCollection.get(0);
				break;
			default:
				if (strIndexKeyword.equals("<last>")) {
					Dragonfly.this.objVariablesSelenium.gobjWebElement = objWebElementCollection.get(objWebElementCollection.size() - 1);
					break;
				} else if (strIndexKeyword.equals("<random>")) {
					int intRandomElement = randomNumberRange(0, objWebElementCollection.size() - 1);
					Dragonfly.this.objVariablesSelenium.gobjWebElement = objWebElementCollection.get(intRandomElement);
					break;
				} else {
					Dragonfly.this.logger.add("ElementFindBy: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
					Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
					while (objWebElementEach.hasNext()) {
						WebElement row = objWebElementEach.next();
						Dragonfly.this.logger.add("outerHTML:=  " + row.getAttribute("outerHTML"));
					}
					throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
				}
			}
		}
	}

	private class ElementFindFramesSearch {
		private boolean run(List<Integer> arrFramePath) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			Dragonfly.this.logger.add("  ==start==>ElementFindFramesSearch " + new DateTimestamp().get());
			boolean blnReturn;
			int intMaximumDepth = 100;
			String strTagName = Dragonfly.this.variablesJSON.objectStep.getLowerCase("strTagName");
			String strAttributeNames = Dragonfly.this.variablesJSON.objectStep.getString("strAttributeNames");
			String strAttributeValues = Dragonfly.this.variablesJSON.objectStep.getString("strAttributeValues");
			try {
				new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
				Dragonfly.this.variablesJSON.objectStep.putValue("strCurrentWindowHandle", Dragonfly.this.objVariablesSelenium.gobjWebDriver.getWindowHandle());
				if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strTagName", "input")) {
					if (Dragonfly.this.variablesJSON.objectStep.getString("strType").length() == 0) {
						Dragonfly.this.variablesJSON.objectStep.putValue("strType", Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("type"));
					}
					Dragonfly.this.variablesJSON.objectStep.putValue("strTagType", "input_" + Dragonfly.this.variablesJSON.objectStep.getString("strType"));
				} else {
					Dragonfly.this.variablesJSON.objectStep.putValue("strTagType", Dragonfly.this.variablesJSON.objectStep.getString("strTagName"));
				}
				Dragonfly.this.logger.add("ElementFindFramesSearch: gobjWebElement outerHTML = " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML"));
				return true;
			} catch (ExceptionElementNotFound | ExceptionMultipleElementsFound | StaleElementReferenceException e) {
				blnReturn = false;
				Dragonfly.this.logger.add("ElementFindFramesSearch: Exception = " + e.toString());
			}
			if (arrFramePath.size() < intMaximumDepth) {
				int intFramesCount = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.tagName("frame")).size();
				for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
					try {
						Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().frame(intFramesEach);
						List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
						arrFramePathNew.add(intFramesEach);
						blnReturn = new ElementFindFramesSearch().run(arrFramePathNew);
						if (blnReturn == true) {
							return true;
						}
						Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().defaultContent();
						for (int intFramesPathEach : arrFramePath)
							Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().frame(intFramesPathEach);
					} catch (NoSuchFrameException error) {
						blnReturn = false;
						Dragonfly.this.logger.add("ElementFindFramesSearch: NoSuchFrameException = " + error.toString());
						break;
					} catch (Exception error) {
						Dragonfly.this.logger.add("ElementFindFramesSearch: Exception = " + error.toString());
					}
				}
			}
			return blnReturn;
		}
	}

	private class ElementGet {
		private String run() throws ExceptionElementTagNameNotSupported {
			Dragonfly.this.logger.add("  ==start==>ElementGet " + new DateTimestamp().get());
			AutoItX objAutoIt = Dragonfly.this.objAutoItSetObject.getObject();
			switch (Dragonfly.this.variablesJSON.objectStep.getLowerCase("strTagType")) {
			case "title":
				return Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle();
			case "img":
				return Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("src");
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				return Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("value").trim();
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
				return Dragonfly.this.objVariablesSelenium.gobjWebElement.getText();
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
			case "input_textarea":
				return Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("value");
			case "input_radio":
			case "input_checkbox":
				if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isSelected() == false) {
					return "<off>";
				} else {
					return "<on>";
				}
			case "select":
				JavascriptExecutor objExecutor = (JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver;
				return ((String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", Dragonfly.this.objVariablesSelenium.gobjWebElement)).trim();
			case "table":
				return Dragonfly.this.objVariablesSelenium.gobjWebElement.getText();
			case "alert":
				if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strAttributeValues", "title")) {
					return objAutoIt.winGetTitle("[ACTIVE]");
				} else {
					return Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().alert().getText();
				}
			default:
				throw new ExceptionElementTagNameNotSupported("Element tag not supported");
			}
		}
	}

	private class ElementGetSync {
		private ElementGetSync() {
			Dragonfly.this.logger.add("  ==start==>ElementGetSync " + new DateTimestamp().get());
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
						Dragonfly.this.variablesJSON.objectStep.putValue("strOutputValue", strGetValue);
						blnGet = true;
					}
					blnStatus = true;
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					Dragonfly.this.logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Dragonfly.this.logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Dragonfly.this.logger.add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "ElementGetSync", "get", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>ElementHidden " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == false) {
						Dragonfly.this.variablesJSON.objectStep.putValue("strHighlightArea", "screen");
						return;
					} else {
						throw new ExceptionElementNotHidden("Alert popup was not hidden.");
					}
				}
				if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isDisplayed() == false) {
					return;
				} else {
					Dragonfly.this.logger.add("ElementHidden: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					throw new ExceptionElementNotHidden("Element is displayed.");
				}
			} catch (NullPointerException | WebDriverException e) {
				Dragonfly.this.logger.add("ElementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				return;
			} finally {
				Dragonfly.this.logger.add("ElementHidden: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementHiddenSync {
		private ElementHiddenSync() {
			Dragonfly.this.logger.add("  ==start==>ElementHiddenSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnHidden = false;
					Dragonfly.this.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnHidden = false;
					Dragonfly.this.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnFound = false;
					blnHidden = false;
					Dragonfly.this.logger.add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "ElementHiddenSync", "synchidden", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			//List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
			//Dragonfly.this.logger.add("ElementJavascriptExecutorGetElementsByTagName objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
			//if (objCollectionJS2.size() > 0) {
			//	long lngStartTimeByXpath = System.currentTimeMillis();
			//}
		}
	}

	private class ElementJavascriptExecutorXPath {
		private String run() {
			Dragonfly.this.logger.add("  ==start==>ElementJavascriptExecutorXPath " + new DateTimestamp().get());
			return (String) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
		}
	}

	private class ElementOnMouseOut {
		private ElementOnMouseOut() {
			Dragonfly.this.logger.add("  ==start==>ElementOnMouseOut " + new DateTimestamp().get());
			JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseout();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
		}
	}

	private class ElementOnMouseOutSync {
		private ElementOnMouseOutSync() {
			Dragonfly.this.logger.add("  ==start==>ElementOnMouseOutSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Dragonfly.this.logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Dragonfly.this.logger.add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "ElementOnMouseOutSync", "mouse_out", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>ElementOnMouseOver " + new DateTimestamp().get());
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseover();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
		}
	}

	private class ElementOnMouseOverSync {
		private ElementOnMouseOverSync() {
			Dragonfly.this.logger.add("  ==start==>ElementOnMouseOverSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Dragonfly.this.logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Dragonfly.this.logger.add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "elementOnMouseOverSync", "mouse_over", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>ElementPleaseWait " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnPleaseWait = Boolean.parseBoolean(Dragonfly.this.variablesJSON.objectStep.getString("blnPleaseWait"));
			Integer intPleaseWaitEach;
			String strAttributeNames = null;
			String strAttributeValues = null;
			String strTagName = null;
			Boolean blnFound = false;
			String strMessage = "";
			try {
				Dragonfly.this.objVariablesSelenium.gobjWebElementPleaseWait = Dragonfly.this.objVariablesSelenium.gobjWebElement;
				Dragonfly.this.logger.add("ElementPleaseWait: objectProcessing.size() = " + Dragonfly.this.variablesJSON.objectProcessing.size());
				if (blnPleaseWait == true) {
					for (intPleaseWaitEach = 1; intPleaseWaitEach < Dragonfly.this.variablesJSON.objectProcessing.size(); intPleaseWaitEach++) {
						JSONObjectExtended objJsonObjectPleaseWaitNode = (JSONObjectExtended) Dragonfly.this.variablesJSON.objectProcessing.get("PleaseWait_" + intPleaseWaitEach);
						try {
							//strAttributeNames = Dragonfly.this.new JsonObjectGetValue().run( objJsonObjectPleaseWaitNode, "strAttributeNames", "");
							strAttributeNames = objJsonObjectPleaseWaitNode.getValue("strAttributeNames", "");
							strAttributeValues = objJsonObjectPleaseWaitNode.getValue("strAttributeValues", "");
							strTagName = objJsonObjectPleaseWaitNode.getValue("strTagName", "");
							Dragonfly.this.logger.add("ElementPleaseWait: variables = " + strAttributeNames + " " + strAttributeValues + " " + strTagName);
						} catch (ExceptionJSONKeyNotPresent e1) {
							// TODO Auto-generated catch block
							Dragonfly.this.logger.add("ElementPleaseWait: ExceptionJSONKeyNotPresent = " + e1.toString());
						}
						try {
							new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
							blnFound = true;
							strMessage = "Element found.";
						} catch (ExceptionElementNotFound e) {
							blnFound = false;
							Dragonfly.this.logger.add("ElementPleaseWait: ElementFindBy = blnFound = false Milliseconds Waited = " + (System.currentTimeMillis()));
						} catch (ExceptionMultipleElementsFound e) {
							blnFound = true;
							strMessage = "Multiple elements found.";
							Dragonfly.this.logger.add("ElementPleaseWait: ElementFindBy = blnFound = true Milliseconds Waited = " + (System.currentTimeMillis()));
						}
						if (blnFound == true) {
							if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isDisplayed() == true) {
								Dragonfly.this.logger.add("ElementPleaseWait: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis()));
								//throw new ExceptionElementNotHidden("Element is displayed.");
								blnFound = true;
								strMessage = "Element is displayed.";
							} else {
								blnFound = false;
								Dragonfly.this.logger.add("ElementPleaseWait: gobjWebElement.isDisplayed() = return false Milliseconds Waited = " + (System.currentTimeMillis()));
							}
						}
						if (blnFound == true) {
							return;
						}
					}
				}
			} finally {
				Dragonfly.this.logger.add("ElementPleaseWait: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				Dragonfly.this.objVariablesSelenium.gobjWebElement = Dragonfly.this.objVariablesSelenium.gobjWebElementPleaseWait;
				if (blnFound == true) {
					throw new ExceptionElementNotHidden(strMessage);
				}
			}
		}
	}

	private class ElementScrollSync {
		private ElementScrollSync() {
			Dragonfly.this.logger.add("  ==start==>ElementScrollSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						blnFound = true;
						Dragonfly.this.logger.add("ElementScrollSync: blnFound = true");
					}
					JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver;
					objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					blnStatus = true;
					Dragonfly.this.logger.add("ElementScrollSync: blnStatus = true");
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Dragonfly.this.logger.add("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "ElementScrollSync", "scroll", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
						return;
					}
				}
			}
		}
	}

	private class ElementSet {
		private ElementSet(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionVisibleTextNotInSelectList, ExceptionKeywordNotValid {
			Dragonfly.this.logger.add("  ==start==>ElementSet " + new DateTimestamp().get());
			Dragonfly.this.logger.add("ElementSet: " + Dragonfly.this.variablesJSON.objectStep.getLowerCase("strAttributeValues"));
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = Dragonfly.this.variablesJSON.objectStep.getString("strInputValue");
			String strValueToSelect = "";
			String strAttributeValues = Dragonfly.this.variablesJSON.objectStep.getLowerCase("strAttributeValues");
			String strTagType = Dragonfly.this.variablesJSON.objectStep.getLowerCase("strTagType");
			String strSetType = "";
			Actions objActions = null;
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
						Dragonfly.this.variablesJSON.objectStep.putValue("strInputValue", "<click>");
						Dragonfly.this.objVariablesSelenium.gobjWebElement.click();
						strSetType = "click";
						break;
					case "<doubleclick>":
						objActions = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
						objActions.moveToElement(Dragonfly.this.objVariablesSelenium.gobjWebElement).doubleClick().build().perform();
						strSetType = "double_click";
						break;
					case "<rightclick>":
						//ToDo add right click code
						objActions = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
						objActions.contextClick(Dragonfly.this.objVariablesSelenium.gobjWebElement).build().perform();
						//						Actions action= new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
						//						action.contextClick(Dragonfly.this.objVariablesSelenium.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
					if (Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("value").isEmpty() == false) {
						Dragonfly.this.objVariablesSelenium.gobjWebElement.clear();
					}
					Dragonfly.this.objVariablesSelenium.gobjWebElement.sendKeys(strInputValue);
					strSetType = "Set";
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						Dragonfly.this.variablesJSON.objectStep.putValue("strInputValue", "<on>");
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							Dragonfly.this.objVariablesSelenium.gobjWebElement.click();
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
						Dragonfly.this.variablesJSON.objectStep.putValue("strInputValue", "<on>");
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							Dragonfly.this.objVariablesSelenium.gobjWebElement.click();
						}
						break;
					case "<off>":
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isSelected() == true) {
							Dragonfly.this.objVariablesSelenium.gobjWebElement.click();
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					strSetType = "Click";
					break;
				case "select":
					//ToDo add throws UnexpectedTagNameException when element is not a SELECT   may be useless
					Select objSelect = new Select(Dragonfly.this.objVariablesSelenium.gobjWebElement);
					objSelect.getOptions();
					int intOptionsLength = objSelect.getOptions().size();
					strValueToSelect = strInputValue;
					String strKeywordValue = "";
					switch (getKeyword(strInputValue)) {
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
						strValueToSelect = objSelect.getOptions().get(randomNumberRange(0, intOptionsLength - 1)).getText();
						Dragonfly.this.logger.add("ElementSet strValueToSelect = " + strValueToSelect);
						break;
					case "<randomstartsecond>":
						strValueToSelect = objSelect.getOptions().get(randomNumberRange(1, intOptionsLength - 1)).getText();
						Dragonfly.this.logger.add("ElementSet strValueToSelect = " + strValueToSelect);
						break;
					case "<randomstartthird>":
						strValueToSelect = objSelect.getOptions().get(randomNumberRange(2, intOptionsLength - 1)).getText();
						Dragonfly.this.logger.add("ElementSet strValueToSelect = " + strValueToSelect);
						break;
					//TODO add ignoreCase/start/ends/contains/regex options
					case "<startswith>":
						strKeywordValue = getKeywordValue(strInputValue);
						Dragonfly.this.logger.add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						String strValueToFindKeyword = Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("innerHTML");
						int intRightArrowPosition = strValueToFindKeyword.indexOf(">" + strKeywordValue);
						if (intRightArrowPosition > -1) {
							int intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intRightArrowPosition);
							strValueToSelect = strValueToFindKeyword.substring(intRightArrowPosition + 1, intLeftArrowPosition);
						}
						Dragonfly.this.logger.add("KeywordReturn: strKeywordValue2 " + strValueToSelect);
						Dragonfly.this.logger.add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<endswith>":
						strKeywordValue = getKeywordValue(strInputValue);
						Dragonfly.this.logger.add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						strValueToFindKeyword = Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("innerHTML");
						int intMatchPosition = strValueToFindKeyword.indexOf(strKeywordValue + "<");
						intRightArrowPosition = strValueToFindKeyword.lastIndexOf(">", intMatchPosition);
						if (intRightArrowPosition > -1) {
							int intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intRightArrowPosition);
							strValueToSelect = strValueToFindKeyword.substring(intRightArrowPosition + 1, intLeftArrowPosition);
						}
						Dragonfly.this.logger.add("KeywordReturn: strValueToSelect " + strValueToSelect);
						Dragonfly.this.logger.add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<contains>":
						int intStart = 0;
						strKeywordValue = getKeywordValue(strInputValue);
						Dragonfly.this.logger.add("ElementSet strKeywordValue = " + strKeywordValue);
						lngStartTime = System.currentTimeMillis();
						strValueToFindKeyword = Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("innerHTML");
						int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace(strKeywordValue, "").length();
						Dragonfly.this.logger.add("KeywordReturn: intKeywordCount = " + intKeywordCount);
						for (int intTestInstanceEach = 0; intTestInstanceEach < intKeywordCount; intTestInstanceEach++) {
							Dragonfly.this.logger.add("KeywordReturn: intStart = " + intStart);
							intMatchPosition = strValueToFindKeyword.indexOf(strKeywordValue, intStart);
							Dragonfly.this.logger.add("KeywordReturn: intMatchPosition = " + intMatchPosition);
							intRightArrowPosition = strValueToFindKeyword.lastIndexOf(">", intMatchPosition);
							Dragonfly.this.logger.add("KeywordReturn: intRightArrowPosition = " + intRightArrowPosition);
							if (intRightArrowPosition > -1) {
								int intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intMatchPosition);
								Dragonfly.this.logger.add("KeywordReturn: intLeftArrowPosition = " + intLeftArrowPosition);
								strValueToSelect = strValueToFindKeyword.substring(intRightArrowPosition + 1, intLeftArrowPosition);
							}
							Dragonfly.this.logger.add("KeywordReturn: strValueToSelect = " + strValueToSelect);
							if (strValueToSelect.startsWith("<option")) {
								intStart = intMatchPosition + 1;
							} else {
								break;
							}
						}
						Dragonfly.this.logger.add("KeywordReturn: strValueToSelect " + strValueToSelect);
						Dragonfly.this.logger.add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
						break;
					case "<re>":
						break;
					default:
						break;
					}
					Dragonfly.this.variablesJSON.objectStep.putString("strInputValue", strValueToSelect);
					try {
						objSelect.selectByVisibleText(strValueToSelect);
					} catch (NoSuchElementException e) {
						throw new ExceptionVisibleTextNotInSelectList(e.getMessage());
					}
					strSetType = "Select";
					break;
				case "table":
					break;
				case "alert":
					switch (strAttributeValues) {
					case "edit":
						Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().alert().sendKeys(strInputValue);
						strSetType = "Set";
						break;
					case "accept":
						Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().alert().accept();
						strSetType = "Click";
						break;
					case "dismiss":
						Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().alert().dismiss();
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
				Dragonfly.this.variablesJSON.objectStep.putValue("strStepExpected", strSetType);
				Dragonfly.this.logger.add("ElementSet: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementSetJavascriptExecutor {
		private ElementSetJavascriptExecutor(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet, ExceptionKeywordNotValid {
			Dragonfly.this.logger.add("  ==start==>ElementSetJavascriptExecutor " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = Dragonfly.this.variablesJSON.objectStep.getString("strInputValue");
			String strValueToSelect = "";
			String strAttributeValues = Dragonfly.this.variablesJSON.objectStep.getLowerCase("strAttributeValues");
			String strTagType = Dragonfly.this.variablesJSON.objectStep.getLowerCase("strTagType");
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver;
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
						objJavascriptExecutor.executeScript("arguments[0].focus();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].click();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].blur();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
						objAction.moveToElement(Dragonfly.this.objVariablesSelenium.gobjWebElement).doubleClick().build().perform();
						break;
					case "<rightclick>":
						//ToDo add right click code javascript
						Actions action = new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
						action.contextClick(Dragonfly.this.objVariablesSelenium.gobjWebElement).build().perform();
						//						Actions action= new Actions(Dragonfly.this.objVariablesSelenium.gobjWebDriver);
						//						action.contextClick(Dragonfly.this.objVariablesSelenium.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
					//Dragonfly.this.logger.add("  ==start==>ElementSetJavascriptExecutor inputtext" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].focus();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//Dragonfly.this.logger.add("  ==start==>ElementSetJavascriptExecutor focus" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '';", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//Dragonfly.this.logger.add("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '" + strInputValue + "';", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//Dragonfly.this.logger.add("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].blur();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//Dragonfly.this.logger.add("onchange blur");
					if (strOuterHTML.toLowerCase().contains("onchange")) {
						try {
							//Dragonfly.this.logger.add("  ==start==>ElementSetJavascriptExecutor strOuterHTML" + new DateTimestamp().get());
							objJavascriptExecutor.executeScript("arguments[0].onchange();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
						} catch (WebDriverException e) {
							Dragonfly.this.logger.add("ElementSetJavascriptExecutor = WebDriverException: " + e.toString());
						}
					}
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						Dragonfly.this.variablesJSON.objectStep.putValue("strInputValue", "<on>");
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									Dragonfly.this.logger.add("ElementSetJavascriptExecutor = " + e.toString());
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
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									Dragonfly.this.logger.add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					case "<off>":
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isSelected() == true) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
								} catch (WebDriverException e) {
									Dragonfly.this.logger.add("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					break;
				case "select":
					Select objSelect = new Select(Dragonfly.this.objVariablesSelenium.gobjWebElement);
					objSelect.getOptions();
					objSelect.selectByVisibleText(strInputValue);
					// set_js
					//					int intOptionsEach;
					//					String strOptions = "";
					//					String[] arrOptions;
					//					strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//					strOptions = strOptions.substring(1);
					//					arrOptions = strOptions.split("\\|");
					//					for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					//						Dragonfly.this.logger.add("ElementSetJavascriptExecutor: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					//						if (arrOptions[intOptionsEach].toString().equals(Dragonfly.this.variablesJSON.objectStep.get("strInputValue").toString())) {
					//							blnSet = true;
					//							Select objSelect = new Select(Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//							objJavascriptExecutor.executeScript("arguments[0].focus();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//							objSelect.selectByIndex(intOptionsEach);
					//							objJavascriptExecutor.executeScript("arguments[0].blur();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//							// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//							// if (strOuterHTML.toLowerCase().contains("onchange")) {
					//							// try {
					//							// objJavascriptExecutor.executeScript("arguments[0].onchange();", Dragonfly.this.objVariablesSelenium.gobjWebElement);
					//							// } catch (WebDriverException e) {
					//							// Dragonfly.this.logger.add("ElementSetJavascriptExecutor = " + e.toString());
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
				Dragonfly.this.logger.add("ElementSetJavascriptExecutor: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementSetSync {
		private ElementSetSync(boolean blnJavascriptExecutor) {
			Dragonfly.this.logger.add("  ==start==>ElementSetSync " + new DateTimestamp().get());
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
			//Dragonfly.this.variablesJSON.objectStep.putValue("strOutputValue", Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind();
						if (Dragonfly.this.objVariablesSelenium.gobjWebElement != null) {
							strOuterHTML = Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML");
							Dragonfly.this.logger.add("ElementSetSync: " + strOuterHTML);
							Dragonfly.this.logger.add("ElementSetSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
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
					switch (Dragonfly.this.variablesJSON.objectStep.getLowerCase("strAssert")) {
					case "off":
						Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
						if (blnSet == false) {
							new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
							Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
							new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
						Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
						Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
						Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
						Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
						blnStatus = true;
						break;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported | ExceptionKeywordNotValid e) {
					blnExit = true;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionVisibleTextNotInSelectList e) {
					blnSet = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnAssert = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnSet = false;
					blnSetSync = false;
					blnAssert = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotSet e) {
					blnSet = false;
					blnAssert = false;
				} catch (ExceptionElementNotDisabled e) {
					blnAssert = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionAlertNotComplete | ExceptionDoPostBackNotComplete | ExceptionJQueryAjaxNotComplete | ExceptionJQueryAnimationNotComplete | ExceptionAngularJsNotComplete | ExceptionPleaseWaitNotComplete e) {
					blnSetSync = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnAssert = false;
					blnEnabled = false;
					blnFound = false;
					blnSet = false;
					blnSetSync = false;
					blnVisible = false;
					Dragonfly.this.logger.add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "elementSetSync", "set", lngTimeStart) == true) {
						if (blnStatus == false) {
							new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
						}
						Dragonfly.this.variablesJSON.objectStep.putValue("strOutputValue", Dragonfly.this.variablesJSON.objectStep.getString("strInputValue"));
						return;
					}
				}
			}
		}
	}

	private class ElementSetSyncComplete {
		private ElementSetSyncComplete(String strOuterHTML) throws ExceptionAlertNotComplete, ExceptionDoPostBackNotComplete, ExceptionJQueryAjaxNotComplete, ExceptionJQueryAnimationNotComplete, ExceptionAngularJsNotComplete, ExceptionPleaseWaitNotComplete {
			Dragonfly.this.logger.add("  ==start==>ElementSetSyncComplete " + new DateTimestamp().get());
			long lngTimeStart = System.currentTimeMillis();
			try {
				if (Dragonfly.this.objVariablesSetSync.gblnSyncPleaseWait == false) {
					///SyncPleaseWait
					new SyncPleaseWait();
					Dragonfly.this.objVariablesSetSync.gblnSyncPleaseWait = true;
				}
				//				if (Dragonfly.this.objVariablesSetSync.gblnSyncAlert == false) {
				//					///SyncAlert
				//					new SyncAlert();
				//					Dragonfly.this.objVariablesSetSync.gblnSyncAlert = true;
				//				}
				if (Dragonfly.this.objVariablesSetSync.gblnSyncWaitForReadyState == false) {
					///SyncWaitForReadyState
					new SyncWaitForReadyState();
					Dragonfly.this.objVariablesSetSync.gblnSyncWaitForReadyState = true;
				}
				if (Dragonfly.this.objVariablesSetSync.gblnSyncDoPostBack == false) {
					///SyncDoPostBack
					new SyncDoPostBack(strOuterHTML);
					Dragonfly.this.objVariablesSetSync.gblnSyncDoPostBack = true;
				}
				if (Dragonfly.this.objVariablesSetSync.gblnSyncJQueryAjax == false) {
					///SyncJQueryAjax
					new SyncJQueryAjax();
					Dragonfly.this.objVariablesSetSync.gblnSyncJQueryAjax = true;
				}
				if (Dragonfly.this.objVariablesSetSync.gblnSyncJQueryAnimation == false) {
					///SyncJQueryAnimation
					new SyncJQueryAnimation();
					Dragonfly.this.objVariablesSetSync.gblnSyncJQueryAnimation = true;
				}
				if (Dragonfly.this.objVariablesSetSync.gblnSyncAngularJs == false) {
					///SyncAngularJs
					new SyncAngularJs();
					Dragonfly.this.objVariablesSetSync.gblnSyncAngularJs = true;
				}
			} finally {
				Dragonfly.this.logger.add("ElementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
			}
		}
	}

	private class ElementVerifyNotValue {
		private String run() throws ExceptionValueMatched, ExceptionElementTagNameNotSupported {
			Dragonfly.this.logger.add("  ==start==>ElementVerifyNotValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = Dragonfly.this.variablesJSON.objectStep.getString("strInputValue");
			try {
				strGetValue = new ElementGet().run();
				strActualValue = new VerifyNotMatch().run(strGetValue, strValueExpected);
				Dragonfly.this.logger.add("ElementVerifyNotValue: after VerifyNotMatch");
			} catch (ExceptionValueMatched e) {
				Dragonfly.this.logger.add("ElementVerifyNotValue: " + e.toString());
				throw new ExceptionValueMatched("ElementVerifyNotValue: Exception strActualValue = {" + strActualValue + "}");
			} finally {
				Dragonfly.this.logger.add("ElementVerifyNotValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	private class ElementVerifyNotValueSync {
		private ElementVerifyNotValueSync() {
			Dragonfly.this.logger.add("  ==start==>ElementVerifyNotValueSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					//blnVerifiedNot = false;
					Dragonfly.this.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					//blnVisible = false;
					Dragonfly.this.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueMatched e) {
					//blnVerifiedNot = false;
					Dragonfly.this.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					//blnVerifiedNot = false;
					Dragonfly.this.logger.add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "ElementVerifyNotValueSync", "verify_not", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>ElementVerifyValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = Dragonfly.this.variablesJSON.objectStep.getString("strInputValue");
			try {
				strGetValue = new ElementGet().run();
				strActualValue = new VerifyMatch().run(strGetValue, strValueExpected);
			} finally {
				Dragonfly.this.logger.add("ElementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	private class ElementVerifyValueSync {
		private ElementVerifyValueSync() {
			Dragonfly.this.logger.add("  ==start==>ElementVerifyValueSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					Dragonfly.this.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					Dragonfly.this.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnVerified = false;
					Dragonfly.this.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnVerified = false;
					Dragonfly.this.logger.add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "elementVerifyValueSync", "verify", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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
			Dragonfly.this.logger.add("  ==start==>ElementVisible " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnVisible = false;
			try {
				// TODO Alert complete
				if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strTagName", "title")) {
					blnVisible = true;
					return;
				}
				if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
					if (new AlertFind().run() == true) {
						blnVisible = true;
						Dragonfly.this.variablesJSON.objectStep.putValue("strHighlightArea", "alert");
						new CoordinatesAlert();
						return;
					} else {
						throw new ExceptionElementNotVisible("Alert popup was not found.");
					}
				}
				if (Dragonfly.this.objVariablesSelenium.gobjWebElement.isDisplayed()) {
					new CoordinatesElement();
					blnVisible = true;
					return;
					// if (Dragonfly.this.variablesJSON.objectStep.containsKey("intElementWidth")) {
					// int intElementWidth = Integer.parseInt(Dragonfly.this.variablesJSON.objectStep.get("intElementWidth").toString());
					// int intElementHeight = Integer.parseInt(Dragonfly.this.variablesJSON.objectStep.get("intElementHeight").toString());
					// Dragonfly.this.logger.add("elementVisible intElementWidth = " + intElementWidth);
					// Dragonfly.this.logger.add("elementVisible intElementHeight = " + intElementHeight);
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
				Dragonfly.this.logger.add("ElementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ElementVisibleSync {
		private ElementVisibleSync() {
			Dragonfly.this.logger.add("  ==start==>ElementVisibleSync " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add("ElementVisibleSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(blnExit, blnStatus, blnFound, "ElementVisibleSync", "syncvisible", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(Dragonfly.this.variablesJSON.objectStep);
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

	//	private class ExceptionTestInstanceMoreThanOne extends Exception {
	//		private static final long serialVersionUID = 1L;
	//
	//		private ExceptionTestInstanceMoreThanOne(String message) {
	//			super(message);
	//		}
	//	}
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
			Dragonfly.this.logger.add("  ==start==>ImageDecodeFromString " + new DateTimestamp().get());
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

	private class ImageEncodeToString {
		private String run(BufferedImage objBufferedImage, String strImageType) {
			Dragonfly.this.logger.add("  ==start==>ImageEncodeToString " + new DateTimestamp().get());
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

	private class InternetExplorerProcessKill {
		private InternetExplorerProcessKill() {
			Dragonfly.this.logger.add("  ==start==>InternetExplorerProcessKill " + new DateTimestamp().get());
			DesiredCapabilities desiredCapabilities = null;
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setJavascriptEnabled(true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			Dragonfly.this.objVariablesSelenium.gobjWebDriver = new InternetExplorerDriver(desiredCapabilities);
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.get("about:blank");
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
			// Dragonfly.this.objVariablesSelenium.gobjWebDriver.navigate().to(Dragonfly.this.variablesJSON.objectStep.get("strInputValue").toString());
			// Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().window().maximize();
			// Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			// // Dragonfly.this.objVariablesSelenium.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.close();
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.quit();
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
			Dragonfly.this.logger.add("  ==start==>InternetExplorerVersion " + new DateTimestamp().get());
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
					Dragonfly.this.logger.add(strFullRegistryKey.replaceAll("\\s+", " ").trim());
					Dragonfly.this.logger.add(strActualKeyValue);
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
				//this. = objJsonObjectToAdd;
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
				//Dragonfly.this.logger.add("JSONObjectExtended:getString strJSONObjectValue = " + strJSONObjectValue);
				return strJSONObjectValue;
			} else {
				//Dragonfly.this.logger.add("JSONObjectExtended:getString JSON Key " + strKeyName + " for keyword link name " + strKeyName + " not present");
				return "";
			}
		}

		private String getValue(String strInputValue, String strKeywordName) throws ExceptionJSONKeyNotPresent {
			//Dragonfly.this.logger.add("  ==start==>JSONObjectExtended:getValue " + new DateTimestamp().get());
			String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
			String strJSONObjectValue = "";
			//Dragonfly.this.logger.add("JSONObjectExtended:getValue strJSONObjectKey = " + strJSONObjectKey);
			this.validateKey(strJSONObjectKey);
			strJSONObjectValue = this.getString(strJSONObjectKey);
			//Dragonfly.this.logger.add("JSONObjectExtended:getValue strJSONObjectValue = " + strJSONObjectValue);
			return strJSONObjectValue;
			//			if (objJSONObject.containsKey(strJSONObjectKey)) {
			//				strJSONObjectValue = objJSONObject.get(strJSONObjectKey).toString();
			//				Dragonfly.this.logger.add("JsonObjectGetValue: strJSONObjectValue = " + strJSONObjectValue);
			//				return strJSONObjectValue;
			//			} else {
			//				Dragonfly.this.logger.add("JsonObjectGetValue: JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
			//				throw new ExceptionJSONKeyNotPresent("JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
			//			}
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
			//Dragonfly.this.logger.add("KeywordReturn: strKeyword " + strKeyword);
			return strKeyword;
		}

		private void validateKey(String strKeyName) throws ExceptionJSONKeyNotPresent {
			//Dragonfly.this.logger.add("  ==start==>JSONObjectExtended: validateKey " + new DateTimestamp().get());
			if (!this.containsKey(strKeyName)) {
				throw new ExceptionJSONKeyNotPresent("JSON Key " + strKeyName + " not present");
			}
		}

		private Boolean verifyEquals(String strKeyName, String strLowerCaseValue) {
			return this.get(strKeyName).toString().trim().toLowerCase().equals(strLowerCaseValue);
		}

		private Boolean verifyKeyValue(String file) {
			//Dragonfly.this.logger.add("  ==start==>WriteJsonKeys " + new DateTimestamp().get());
			return null;
		}

		private void writeKeys(String file) throws IOException {
			//Dragonfly.this.logger.add("  ==start==>WriteJsonKeys " + new DateTimestamp().get());
			for (Iterator<?> iterator = this.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				Dragonfly.this.logger.add("WriteJsonKeys: " + key + " = " + this.get(key));
			}
		}
	}

	private class JvmBitVersion {
		private String get() {
			String strJvmBitVersion = System.getProperty("sun.arch.data.model");
			Dragonfly.this.logger.add("JvmBitVersion: System.getProperty(sun.arch.data.model) = " + strJvmBitVersion + " " + new DateTimestamp().get());
			return strJvmBitVersion;
		}
	}

	private class KeywordsValid {
		//TODO KeywordsValid to check all
		private String[] arrKV_strLogicalName = { "<te>" };
		private String[] arrKV_strAttributeValues = { "<re>", "<td>", "<ti>", "<tl>" };
		private String[] arrKV_strInputValue = { "<re>", "<td>", "<ti>", "<tl>", "<click>", "<doubleclick>", "<rightclick>", "<on>", "<off>", "<blank>", "<first>", "<second>", "<third>", "<last>", "<random>", "<contains>", "<endswith>", "<startswith>", "<randomstartthird>", "<randomstartsecond>" };
		private String[] arrKV_strLoopOrIf = { "<if>", "<else if>", "<else>", "<end if>", "<loopstart>", "<loopexit>", "<loopend>" };
		private String[] arrResults;
		private String strInputValueFromJson = "";
		private String strKeywordEach = "";
		private String strKeywordValue = "";

		private KeywordsValid() {
			//Dragonfly.this.logger.add("  ==start==>KeywordsValid " + new DateTimestamp().get());
			//String strKey = "";
			String[] arrKeys = new StepNames().getOriginal();
			boolean blnValid = false;
			String[] arrKeywordsValid;
			//for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
			//strKey = arrKeys[intKeysEach].toString();
			for (String strKey : arrKeys) {
				//Dragonfly.this.logger.add("KeywordsValid: ----------------->strKey = " + strKey);
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
					this.getKeywordsAndValue(Dragonfly.this.variablesJSON.objectStep.getString(strKey));
					//					if (arrResults.length > 0) {
					//						Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "fail");
					//						Dragonfly.this.variablesJSON.objectStep.putValue("blnExitOnFail", "true");
					//					}
					break;
				case "strLogicalName":
					this.getKeywordsAndValue(Dragonfly.this.variablesJSON.objectStep.getString(strKey));
					for (String strResultsEach : arrResults) {
						for (String strKeywordsValidEach : arrKV_strLogicalName) {
							if (strResultsEach.equals(strKeywordsValidEach)) {
								blnValid = true;
								JSONObjectExtended objJsonObjectElementNode = Dragonfly.this.new JSONObjectExtended((JSONObject) Dragonfly.this.variablesJSON.objectElement.get(strKeywordValue));
								try {
									Dragonfly.this.variablesJSON.objectStep.putValue("strTagName", objJsonObjectElementNode.getValue("strTagName", ""));
									Dragonfly.this.variablesJSON.objectStep.putValue("strAttributeNames", objJsonObjectElementNode.getValue("strAttributeNames", ""));
									Dragonfly.this.variablesJSON.objectStep.putValue("strAttributeValues", objJsonObjectElementNode.getValue("strAttributeValues", ""));
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
					String arrAttributeValues[] = Dragonfly.this.variablesJSON.objectStep.getString(strKey).split("\\|", -1);
					for (String strAttributeValuesEach : arrAttributeValues) {
						//Dragonfly.this.logger.add("strAttributeValuesEach = " + strAttributeValuesEach);
						this.getKeywordsAndValue(strAttributeValuesEach);
						for (String strResultsEach : arrResults) {
							//Dragonfly.this.logger.add("strResultsEach = " + strResultsEach);
							//Dragonfly.this.logger.add("strKeywordValue = " + strKeywordValue);
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
					Dragonfly.this.variablesJSON.objectStep.putValue("strAttributeValues", strKeywordValueCombined);
					//Dragonfly.this.logger.add("strKeywordValueCombined = " + strKeywordValueCombined);
					break;
				case "strInputValue":
					this.getKeywordsAndValue(Dragonfly.this.variablesJSON.objectStep.getString(strKey));
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
					Dragonfly.this.variablesJSON.objectStep.putValue("strInputValue", strKeywordValue);
					//Dragonfly.this.logger.add("strKeywordValue = " + strKeywordValue);
					//Dragonfly.this.logger.add("strInputValueFromJson = " + strInputValueFromJson);
					break;
				case "strLoopOrIf":
					//					arrKeywordsValid = strValidKeyword_strLoopOrIf.split("\\|");
					//					strValueToFindKeyword = Dragonfly.this.variablesJSON.objectStep.get(strKey).toString();
					//					//arrKeywords = Dragonfly.this.new KeywordReturnArray().run( strValueToFindKeyword);
					//					arrKeywords = this.getKeywordsAndValue( strValueToFindKeyword);
					//					for (int intKeywordsEach = 0; intKeysEach < arrKeywords.length; intKeysEach++) {
					//						Dragonfly.this.logger.add("KeywordsValid: arrKeywords[intKeywordsEach].toString() = " + arrKeywords[intKeywordsEach].toString());
					//						for (int intKeywordsValidEach = 0; intKeywordsValidEach < arrKeywordsValid.length; intKeywordsValidEach++) {
					//							if (arrKeywords[intKeywordsEach].toString().equals(arrKeywordsValid[intKeywordsValidEach].toString())) {
					//								blnValid = true;
					//								break;
					//							}
					//						}
					//					}
					//						if (blnValid = false) {
					//							Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "fail");
					//							Dragonfly.this.variablesJSON.objectStep.putValue("blnExitOnFail", "true");
					//							break;
					//						}
					break;
				}
			}
		}

		private void getJsonValue(String strKeyword, String strInputValue) {
			//Dragonfly.this.logger.add("  ==start==>getJsonValue " + new DateTimestamp().get());
			//Dragonfly.this.logger.add("getJsonValue strKeyword = " + strKeyword);
			//Dragonfly.this.logger.add("getJsonValue strInputValue = " + strInputValue);
			try {
				switch (strKeyword) {
				case "<td>":
					strInputValueFromJson = Dragonfly.this.variablesJSON.objectTestData.getValue(strInputValue, "<td>");
					break;
				case "<ti>":
					Dragonfly.this.logger.add(">getJsonValue:<ti> " + Dragonfly.this.variablesJSON.objectTestInstancesEach);
					strInputValueFromJson = Dragonfly.this.variablesJSON.objectTestInstancesEach.getValue(strInputValue, "<ti>");
					break;
				case "<tl>":
					strInputValueFromJson = Dragonfly.this.variablesJSON.objectLinks.getValue(strInputValue, "<tl>");
					break;
				case "<re>":
					strInputValueFromJson = strInputValue;
					break;
				default:
					strInputValueFromJson = strKeyword + strInputValue;
					break;
				}
			} catch (ExceptionJSONKeyNotPresent e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Dragonfly.this.logger.add("StepSetupDefaults: Exception = " + e.toString());
			}
		}

		private void getKeywordsAndValue(String strValueToFindKeyword) {
			//Dragonfly.this.logger.add("  ==start==>getKeywordsAndValue " + new DateTimestamp().get());
			//Dragonfly.this.logger.add("getKeywordsAndValue strValueToFindKeyword = " + strValueToFindKeyword);
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
					Dragonfly.this.logger.add("getKeywordsAndValue strKeyword = " + strKeyword);
					//Dragonfly.this.logger.add("getKeywordsAndValue strKeywordValue = " + strKeywordValue);
					if (strKeywordCombined.length() == 0) {
						strKeywordCombined = strKeyword;
					} else {
						strKeywordCombined = strKeywordCombined + "|" + strKeyword;
					}
				}
			}
			//Dragonfly.this.logger.add("getKeywordsAndValue after for strKeyword = " + strKeywordCombined);
			//strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
			//Dragonfly.this.logger.add("getKeywordsAndValue strKeywordValue = " + strKeywordValue);
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
			Dragonfly.this.logger.add("  ==start==>MonthGet " + new DateTimestamp().get());
			return new DateFormatSymbols().getMonths()[month];
		}
	}

	private class OperatingSystem {
		private String strOS = "";

		private OperatingSystem() {
			Dragonfly.this.logger.add("  ==start==>OperatingSystem " + new DateTimestamp().get());
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
			Dragonfly.this.logger.add("PathCreation:changeDirectoryNameStatus gstrPathResults = " + gstrPathResults);
			File objDirectoryOld = new File(gstrPathResults);
			String strPathResultsNew = gstrPathResults.substring(0, gstrPathResults.length() - 1) + "_" + strTestStatus + "\\";
			Dragonfly.this.logger.add("PathCreation:changeDirectoryNameStatus strPathResultsNew = " + strPathResultsNew);
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
			Dragonfly.this.logger.add("PathCreation:setPathResults intTestInstanceSize = " + intTestInstanceSize);
			Dragonfly.this.logger.add("PathCreation:setPathResults strTestConfigurationFileName = " + strTestConfigurationFileName);
			String gstrDateTimestamp = new DateTimestamp().get();
			Dragonfly.this.logger.add("PathCreation:setPathResults gstrDateTimestamp = " + gstrDateTimestamp);
			Dragonfly.this.logger.add("PathCreation:setPathResults gstrPathImages==null = " + gstrPathImages);
			if (gstrPathImages == null) {
				gstrPathResultsTop = gstrPathSystemUserDir + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\";
				Dragonfly.this.logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				if (intTestInstanceSize > 1) {
					gstrPathResultsTop = gstrPathResultsTop + gstrDateTimestamp + "\\Iterations_" + intTestInstanceSize + "\\";
					Dragonfly.this.logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				}
			}
			gstrPathResults = gstrPathResultsTop + gstrDateTimestamp + "\\";
			Dragonfly.this.logger.add("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
			gstrPathImages = gstrPathResults + "images\\";
			Dragonfly.this.logger.add("PathCreation:setPathResults gstrPathImages = " + gstrPathImages);
			new File(gstrPathImages).mkdirs();
		}
	}

	private class ProcessKillInternetExplorer {
		private void run() {
			Dragonfly.this.logger.add("  ==start==>ProcessKillInternetExplorer " + new DateTimestamp().get());
			new WindowsProcessKill("taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(1000);
			new WindowsProcessKill("taskkill /F /IM IEDriverServer.exe");
		}
	}

	private class RectangleAreaByName {
		private RectangleAreaByName(Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
			Dragonfly.this.logger.add("  ==start==>RectangleAreaByName " + new DateTimestamp().get());
			Dragonfly.this.logger.add("RectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
			long lngStartTime = System.currentTimeMillis();
			int intX = 0;
			int intY = 0;
			int intWidth = 0;
			int intHeight = 0;
			if (strAreaObjectName.equals("")) {
				if (Dragonfly.this.objVariablesSelenium.gobjWebDriver == null) {
					strAreaObjectName = "screen";
				}
				if (Dragonfly.this.objVariablesSelenium.gobjWebElement == null) {
					if (Dragonfly.this.variablesJSON.objectStep.verifyEquals("strTagName", "alert")) {
						strAreaObjectName = "element";
					} else {
						strAreaObjectName = "screen";
					}
				} else {
					if (Dragonfly.this.variablesJSON.objectStep.containsKey("intElementScreenX") == false) {
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
					intX = Dragonfly.this.variablesJSON.objectStep.getInt("intBrowserOuterX");
					intY = Dragonfly.this.variablesJSON.objectStep.getInt("intBrowserOuterY");
					intWidth = Dragonfly.this.variablesJSON.objectStep.getInt("intBrowserOuterWidth");
					intHeight = Dragonfly.this.variablesJSON.objectStep.getInt("intBrowserOuterHeight");
					break;
				case "page":
					// TODO change this to get absolute screen coordinates
					WebElement objWebElementPage = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElement(By.xpath("//body"));
					intX = objWebElementPage.getLocation().getX() - intThickness;
					intY = objWebElementPage.getLocation().getY() - intThickness;
					intWidth = objWebElementPage.getSize().width + (2 * intThickness);
					intHeight = objWebElementPage.getSize().height + (2 * intThickness);
					break;
				case "element":
				case "alert":
					intX = Dragonfly.this.variablesJSON.objectStep.getInt("intElementScreenX") - intThickness;
					intY = Dragonfly.this.variablesJSON.objectStep.getInt("intElementScreenY") - intThickness;
					intWidth = Dragonfly.this.variablesJSON.objectStep.getInt("intElementWidth") + (2 * intThickness);
					intHeight = Dragonfly.this.variablesJSON.objectStep.getInt("intElementHeight") + (2 * intThickness);
					break;
				default:
					Dragonfly.this.logger.add("RectangleAreaByName: epected values = screen, window, page and element not " + strAreaObjectName);
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
				Dragonfly.this.logger.add("RectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class RegularExpressionMatch {
		private String run(String strPattern, String strActualValue) throws ExceptionValueNotMatched {
			Boolean blnMatched = false;
			Long lngStartTime = System.currentTimeMillis();
			Dragonfly.this.logger.add("  ==start==>RegularExpressionMatch " + new DateTimestamp().get());
			String strMatchedString = "";
			try {
				Matcher objMatcher = Pattern.compile(strPattern).matcher(strActualValue);
				objMatcher.matches();
				strMatchedString = objMatcher.group(0);
				blnMatched = true;
				return strMatchedString;
			} catch (Exception e) {
				Dragonfly.this.logger.add("RegularExpressionMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("RegularExpressionMatch: Exception " + e.toString());
			} finally {
				Dragonfly.this.logger.add("RegularExpressionMatch: finally Matched = {" + blnMatched + "} strMatchedString = {" + strMatchedString + "} strPattern = {" + strPattern + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class ScrollToBottom {
		private ScrollToBottom() {
			Dragonfly.this.logger.add("  ==start==>ScrollToBottom " + new DateTimestamp().get());
			// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
			JavascriptExecutor executor = (JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver;
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		}
	}

	private class Sleep {
		private Sleep() {
			new SleepMilliseconds(Dragonfly.this.variablesJSON.objectStep.getInt("strInputValue"));
		}
	}

	private class SleepMilliseconds {
		private SleepMilliseconds(int intMillisecondsToWait) {
			Dragonfly.this.logger.add("  ==start==>SleepMilliseconds " + new DateTimestamp().get());
			try {
				TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
				Dragonfly.this.variablesJSON.objectStep.putString("strStatus", "pass");
			} catch (Exception e) {
				Dragonfly.this.variablesJSON.objectStep.putString("strStatus", "fail");
				Dragonfly.this.logger.add("SleepMilliseconds: Exception = " + e.toString());
			}
		}
	}

	private class SleepSync {
		private SleepSync() {
			Long lngTimeStart = System.currentTimeMillis();
			new Sleep();
			new StepDuration("SleepSync", lngTimeStart, "sleep");
		}
	}

	private class StepCreateActual {
		private StepCreateActual(String strStepType) {
			Dragonfly.this.logger.add("  ==start==>StepCreateActual " + new DateTimestamp().get());
			String intWaited = "";
			String strActualHtml = "";
			String strActualReturn = "";
			String strActualReturnHTML = "";
			String strActualText = "";
			String strInputParameterValueHTML = "";
			String strInputValue = Dragonfly.this.variablesJSON.objectStep.getString("strInputValue");
			String strOutputValue = Dragonfly.this.variablesJSON.objectStep.getString("strOutputValue");
			String strOutputValueHtml = Dragonfly.this.variablesJSON.objectStep.getString("strOutputValue");
			String strParameterName = "";
			String strStepParameterName = "";
			String strTagName = Dragonfly.this.variablesJSON.objectStep.getString("strTagName");
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
			Dragonfly.this.logger.add("StepCreateActual: strActualText = " + strActualText);
			Dragonfly.this.variablesJSON.objectStep.putValue("strStepActual", strActualText);
			Dragonfly.this.logger.add("StepCreateActual: objectStep.getString(strStepActual) = " + Dragonfly.this.variablesJSON.objectStep.getString("strStepActual"));
		}
	}

	private class StepCreateExpected {
		private StepCreateExpected() {
			Dragonfly.this.logger.add("  ==start==>StepCreateExpected " + new DateTimestamp().get());
			String strStepExpected = "";
			String strAction = "";
			String strInputValue = Dragonfly.this.variablesJSON.objectStep.getString("strInputValue");
			String strMillisecondsToWait = Dragonfly.this.variablesJSON.objectStep.getString("intMillisecondsToWait");
			String strObjectName = this.createObjectName();
			String strTagName = Dragonfly.this.variablesJSON.objectStep.getString("strTagName");
			String strAssert = Dragonfly.this.variablesJSON.objectStep.getString("strAssert");
			if (Dragonfly.this.variablesJSON.objectStep.get("strStepExpected").toString().length() != 0) {
				strAction = Dragonfly.this.variablesJSON.objectStep.getString("strStepExpected");
			} else {
				strAction = Dragonfly.this.variablesJSON.objectStep.getString("strAction");
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
			Dragonfly.this.objStepsManual.set(strStepExpected);
			Dragonfly.this.variablesJSON.objectStep.putValue("strStepExpected", strStepExpected);
		}

		private String createObjectName() {
			String strAttributeValue = "";
			String strAttributeValues = Dragonfly.this.variablesJSON.objectStep.getString("strAttributeValues");
			String strObjectsAttributes = "";
			String strObjectName = "";
			String strObjectNames = Dragonfly.this.variablesJSON.objectStep.getString("strAttributeNames");
			String[] arrAttributeValues = strAttributeValues.split("\\|");
			String[] arrObjectNames = strObjectNames.split("\\|");
			for (int intEach = 0; intEach < arrObjectNames.length; intEach++) {
				strObjectName = arrObjectNames[intEach].toString();
				strAttributeValue = arrAttributeValues[intEach].toString();
				if (intEach == 0) {
					strObjectsAttributes = strObjectName + "=" + strAttributeValue;
					Dragonfly.this.logger.add("createObjectName strObjectAttribute =" + strObjectsAttributes);
				} else {
					strObjectsAttributes = strObjectsAttributes + "|" + strObjectName + "=" + strAttributeValue;
					Dragonfly.this.logger.add("createObjectName strObjectAttribute =" + strObjectsAttributes);
				}
			}
			return strObjectsAttributes;
		}

		private String switchAction() {
			return null;
		}
	}

	private class StepDuration {
		private StepDuration(String strMethodName, Long lngTimeStart, String strStepType) {
			Dragonfly.this.logger.add("  ==start==>StepDuration " + new DateTimestamp().get());
			Long lngTimeEnd = System.currentTimeMillis();
			new StepCreateExpected();
			new StepCreateActual(strStepType);
			//Dragonfly.this.variablesJSON.objectStep.putValue( "strStepActual", new StepCreateActual().run( strStepType));
			Dragonfly.this.variablesJSON.objectStep.putValue("strStartTimestamp", new DateTimeFormat().set(lngTimeStart));
			Dragonfly.this.variablesJSON.objectStep.putValue("strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
			Dragonfly.this.variablesJSON.objectStep.putValue("strEndTimestamp", new DateTimeFormat().set(lngTimeEnd));
			Dragonfly.this.logger.add("StepDuration: " + strMethodName + " strStatus = " + Dragonfly.this.variablesJSON.objectStep.getString("strStatus") + " Milliseconds Waited = " + Dragonfly.this.variablesJSON.objectStep.getString("strStepDuration"));
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
			//Dragonfly.this.logger.add("  ==start==>StepSetupDefaults " + new DateTimestamp().get());
			String[] arrDefaultKeys = new StepNames().getDefault();
			String[] arrKeys = new StepNames().getRuntime();
			for (String strKey : arrKeys) {
				if (!strKey.equals("strTestModuleStep")) {
					Dragonfly.this.variablesJSON.objectStep.putValue(strKey, "");
					//Dragonfly.this.logger.add("StepSetupDefaults: .putValue(strKey = " + strKey);
				}
			}
			Dragonfly.this.new KeywordsValid();
			Class<?> objClass = null;
			try {
				//Dragonfly.this.logger.add("StepSetupDefaults: Class.forName start");
				objClass = Class.forName("org.DragonflyAutomation.Dragonfly$StepSetupDefaults");
			} catch (ClassNotFoundException e) {
				Dragonfly.this.logger.add("StepSetupDefaults: ClassNotFoundException = " + e.toString());
			} catch (Exception e) {
				Dragonfly.this.logger.add("StepSetupDefaults: Class.forName Exception = " + e.toString());
			}
			for (String strKey : arrDefaultKeys) {
				Field objField = null;
				try {
					objField = objClass.getDeclaredField("strDefault_" + strKey);
				} catch (NoSuchFieldException | SecurityException e) {
					Dragonfly.this.logger.add("StepSetupDefaults: NoSuchFieldException = " + e.toString());
				} catch (Exception e) {
					Dragonfly.this.logger.add("StepSetupDefaults: Exception = " + e.toString());
				}
				if (Dragonfly.this.variablesJSON.objectStep.get(strKey).toString().trim().length() == 0) {
					try {
						Dragonfly.this.variablesJSON.objectStep.putValue(strKey, (String) objField.get(this));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						Dragonfly.this.logger.add("StepSetupDefaults: IllegalArgumentException = " + e.toString());
						e.printStackTrace();
					} catch (Exception e) {
						Dragonfly.this.logger.add("StepSetupDefaults: Exception = " + e.toString());
					}
				}
			}
			Dragonfly.this.variablesJSON.objectStep.putValue("strCurrentWindowHandle", strCurrentWindowHandle);
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

		//		private void add(String strTextToAdd) {
		//			this.objStringBuilder.append(strTextToAdd);
		//			this.objStringBuilder.append(System.getProperty("line.separator"));
		//		}
		private void set(String strTextToAdd) {
			System.out.println(strTextToAdd);
			objStringBuilder.append(strTextToAdd);
			objStringBuilder.append(System.getProperty("line.separator"));
		}
	}

	private class SyncAlert {
		private SyncAlert() throws ExceptionAlertNotComplete {
			Dragonfly.this.logger.add("  ==start==>SyncAlert " + new DateTimestamp().get());
			if (new AlertFind().run() == true) {
				throw new ExceptionAlertNotComplete("");
			}
		}
	}

	private class SyncAngularJs {
		private SyncAngularJs() throws ExceptionAngularJsNotComplete {
			Dragonfly.this.logger.add("  ==start==>SyncAngularJs " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return (window.angular != null);");
				Dragonfly.this.logger.add("SyncAngularJs: = " + blnAngularJs);
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				if (lngAngularJsInjectorActive > 0) {
					throw new ExceptionAngularJsNotComplete("");
				}
			} catch (Exception e) {
				Dragonfly.this.logger.add("SyncAngularJs: AngularJS Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("SyncAngularJs: lngAngularJsInjectorActive = " + lngAngularJsInjectorActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncDoPostBack {
		private SyncDoPostBack(String strOuterHTML) throws ExceptionDoPostBackNotComplete {
			Dragonfly.this.logger.add("  ==start==>SyncDoPostBack " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				try {
					Dragonfly.this.logger.add("SyncDoPostBack: __EVENTTARGET value = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
					if (blnEventTarget == true) {
						throw new ExceptionDoPostBackNotComplete("");
					}
				} catch (Exception e) {
					Dragonfly.this.logger.add("SyncDoPostBack: Exception = " + e.toString());
				} finally {
					Dragonfly.this.logger.add("SyncDoPostBack: blnEventTarget = " + blnEventTarget + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				}
			}
		}
	}

	private class SyncFinally {
		private Boolean run(Boolean blnExit, Boolean blnStatus, Boolean blnFound, String strMethodeName, String strAction, Long lngTimeStart) {
			Dragonfly.this.logger.add("SyncFinally:  blnExit = {" + blnExit + "} blnStatus = {" + blnStatus + "} blnFound = {" + blnFound + "} strMethodeName = {" + strMethodeName + "} strAction = {" + strAction + "}");
			if (blnExit == true) {
				Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "fail");
				Dragonfly.this.variablesJSON.objectStep.putValue("blnExitOnFail", "true");
			} else {
				if (blnStatus == true) {
					Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Dragonfly.this.variablesJSON.objectStep.getInt("intMillisecondsToWait")) {
						if (blnFound == false) {
							blnExit = false;
						}
					} else {
						if (Dragonfly.this.variablesJSON.objectStep.getBoolean("blnOptional") == true) {
							Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "warning");
							blnExit = true;
						} else {
							Dragonfly.this.variablesJSON.objectStep.putValue("strStatus", "fail");
							blnExit = true;
						}
					}
				}
			}
			if (blnExit == true) {
				new StepDuration(strMethodeName, lngTimeStart, strAction);
			}
			return blnExit;
		}
	}

	private class SyncJQueryAjax {
		private SyncJQueryAjax() throws ExceptionJQueryAjaxNotComplete {
			Dragonfly.this.logger.add("  ==start==>SyncJQueryAjax " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				blnJquery = (boolean) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return (jQuery.active);");
					Dragonfly.this.logger.add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive);
					if (lngJqueryActive > 0) {
						throw new ExceptionJQueryAjaxNotComplete("");
					}
				}
			} catch (Exception e) {
				Dragonfly.this.logger.add("SyncJQueryAjax: JqueryActive Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncJQueryAnimation {
		private SyncJQueryAnimation() throws ExceptionJQueryAnimationNotComplete {
			Dragonfly.this.logger.add("  ==start==>SyncJQueryAnimation " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			long lngElementsAnimated = 0;
			boolean blnJqueryExist = false;
			try {
				blnJqueryExist = (boolean) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJqueryExist == true) {
					lngElementsAnimated = (long) ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return $(\":animated\").length");
				}
				if (lngElementsAnimated > 0) {
					throw new ExceptionJQueryAnimationNotComplete("");
				}
			} catch (Exception e) {
				Dragonfly.this.logger.add("SyncJQueryAnimation: Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("SyncJQueryAnimation: lngElementsAnimated = " + lngElementsAnimated + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class SyncPleaseWait {
		private SyncPleaseWait() throws ExceptionDoPostBackNotComplete {
			long lngStartTime = System.currentTimeMillis();
			Dragonfly.this.logger.add("  ==start==>SyncPleaseWait " + new DateTimestamp().get());
			try {
				new ElementPleaseWait();
			} catch (ExceptionElementNotHidden e1) {
				Dragonfly.this.logger.add("SyncPleaseWait: ExceptionElementNotHidden = " + e1.toString());
				throw new ExceptionDoPostBackNotComplete("");
			} catch (Exception e) {
				Dragonfly.this.logger.add("SyncPleaseWait: Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("SyncPleaseWait: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
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
			Dragonfly.this.logger.add("  ==start==>SyncWaitForReadyState " + new DateTimestamp().get());
			try {
				new WaitForReadyState().run();
			} catch (Exception e) {
				Dragonfly.this.logger.add("SyncWaitForReadyState: Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("SyncWaitForReadyState: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class TestConfigurationSetup {
		private int intTestInstanceSize;
		//private String gstrTestStepsCombinedOriginal;
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
					Dragonfly.this.logger.add("TestConfigurationSetup:putAllArrays strFilePathJsonArray = " + strFilePathJsonArray);
					try {
						objJsonObjectFileEach = Dragonfly.this.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathJsonArray)));
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
						Dragonfly.this.logger.add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
						e.printStackTrace();
					}
					if (intJsonArrayEach == 0) {
						objJsonArray = objJsonArrayEach;
					} else {
						objJsonArray.addAll(objJsonArrayEach);
					}
				}
			}
			Dragonfly.this.logger.add("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
			return objJsonArray;
		}

		@SuppressWarnings("unchecked")
		private JSONObjectExtended putAllObjects(String strJsonArrayName, String strJsonObjectName, String strPath) {
			Dragonfly.this.logger.add("  ==start==>putAllObjects " + new DateTimestamp().get());
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
			Dragonfly.this.logger.add("TestConfigurationSetup:putAllObjects objJsonArrayList.size() " + objJsonArrayList.size());
			for (intJsonObjectEach = 0; intJsonObjectEach < objJsonArrayList.size(); intJsonObjectEach++) {
				strFileNameEach = objJsonArrayList.get(intJsonObjectEach).toString();
				Dragonfly.this.logger.add("TestConfigurationSetup:putAllObjects strFileNameEach " + strFileNameEach);
				strFilePathJsonArray = strPath + strFileNameEach;
				Dragonfly.this.logger.add("TestConfigurationSetup:putAllObjects strFilePathJsonArray = " + strFilePathJsonArray);
				try {
					objJsonObjectFileEach.putAllReplace((Map<String, String>) objJsonParser.parse(new FileReader(strFilePathJsonArray)));
					Dragonfly.this.logger.add("TestConfigurationSetup:putAllObjects objJsonObjectFileEach = " + objJsonObjectFileEach);
					objJsonObjectEach.putAllReplace((Map<String, String>) objJsonObjectFileEach.get(strJsonObjectName));
					Dragonfly.this.logger.add("TestConfigurationSetup:putAllObjects objJsonObjectEach = " + objJsonObjectEach);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				objJsonObject.putAll(objJsonObjectEach);
			}
			Dragonfly.this.logger.add("TestConfigurationSetup:putAllObjects objJsonObject = " + objJsonObject);
			return objJsonObject;
		}

		private void run(String strFileNameTestConfiguration) {
			// TODO complete TestConfigurationSetup method to create json objects for test
			Dragonfly.this.logger.add("  ==start==>TestConfigurationSetup " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strFilePathTestConfiguration = "";
			try {
				strFilePathTestConfiguration = Dragonfly.this.objPaths.gstrPathTestConfiguration + strFileNameTestConfiguration;
				Dragonfly.this.logger.add("TestConfigurationSetup: strPathTestConfiguration = " + strFilePathTestConfiguration);
				objJsonObjectTestConfigurationFile = Dragonfly.this.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathTestConfiguration)));
				Dragonfly.this.logger.add("TestConfigurationSetup: objJsonObjectTestConfigurationFile = " + objJsonObjectTestConfigurationFile);
				// test_instances
				Dragonfly.this.logger.add("TestConfigurationSetup: test_instances");
				if (this.putAllArrays("test_instances", "test_instances", Dragonfly.this.objPaths.gstrPathTestInstances) == null) {
					Dragonfly.this.variablesJSON.gobjJsonArrayTestInstances = null;
					intTestInstanceSize = 0;
				} else {
					Dragonfly.this.variablesJSON.gobjJsonArrayTestInstances = this.putAllArrays("test_instances", "test_instances", Dragonfly.this.objPaths.gstrPathTestInstances);
					intTestInstanceSize = Dragonfly.this.variablesJSON.gobjJsonArrayTestInstances.size();
				}
				// test_elements
				Dragonfly.this.logger.add("TestConfigurationSetup: test_elements");
				Dragonfly.this.variablesJSON.objectElement = this.putAllObjects("test_elements", "elements", Dragonfly.this.objPaths.gstrPathTestElements);
				// processing
				Dragonfly.this.logger.add("TestConfigurationSetup: processing");
				Dragonfly.this.variablesJSON.objectProcessing = this.putAllObjects("test_elements", "processing", Dragonfly.this.objPaths.gstrPathTestElements);
				// test_modules
				Dragonfly.this.logger.add("TestConfigurationSetup: test_modules");
				Dragonfly.this.variablesJSON.gobjJsonArrayTestSteps = this.putAllArrays("test_modules", "steps", Dragonfly.this.objPaths.gstrPathTestModules);
				Dragonfly.this.logger.add("TestConfigurationSetup: gobjJsonArrayTestSteps.toString = " + Dragonfly.this.variablesJSON.gobjJsonArrayTestSteps.toString());
				// TODO add error handling, report no test modules and fail
				// test_links
				Dragonfly.this.variablesJSON.objectLinks.putAllReplace((Map<String, String>) objJsonParser.parse("{\"link\":[{}]}"));
				// test_data
				Dragonfly.this.logger.add("TestConfigurationSetup: test_data");
				Dragonfly.this.variablesJSON.objectTestData = this.putAllObjects("test_data", "test_data", Dragonfly.this.objPaths.gstrPathTestData);
			} catch (Exception e) {
				Dragonfly.this.logger.add("TestConfigurationSetup: Exception = " + e.toString());
			} finally {
				Dragonfly.this.logger.add("TestConfigurationSetup: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
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
				Dragonfly.this.logger.add("ThreadSaveImage:run Exception = " + e.toString());
			}
		}
	}

	private class VariablesCommon {
		private String gstrBrowserSelection;
		private String strExitTest;
		private String strExitTestIterations;
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
			Dragonfly.this.logger.add("  ==start==>VerifyMatch " + new DateTimestamp().get());
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
				Dragonfly.this.logger.add("VerifyMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("VerifyMatch: Exception " + e.toString());
			} finally {
				Dragonfly.this.logger.add("VerifyMatch: finally Matched = {" + blnMatched + "} strActual = {" + strActual + "} strExpected = {" + strExpected + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class VerifyNotMatch {
		private String run(String strActual, String strExpected) throws ExceptionValueMatched {
			Dragonfly.this.logger.add("  ==start==>VerifyNotMatch " + new DateTimestamp().get());
			Boolean blnMatched = false;
			long lngStartTime = System.currentTimeMillis();
			String strMatchedValue = "";
			try {
				if (strExpected.toLowerCase().startsWith("<re>")) {
					String strPattern = strExpected.substring(4);
					try {
						strMatchedValue = new RegularExpressionMatch().run(strPattern, strActual);
					} catch (Exception e) {
						Dragonfly.this.logger.add("VerifyNotMatch: Exception " + e.toString());
						return strMatchedValue;
					}
					blnMatched = true;
					Dragonfly.this.logger.add("VerifyNotMatch: before throw blnMatched = " + blnMatched);
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
				Dragonfly.this.logger.add("VerifyNotMatch: finally Matched = {" + blnMatched + "} strExpected = {" + strExpected + "} strActual = {" + strActual + "} strMatchedValue = {" + strMatchedValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	private class WaitForAngularRequestsToFinish {
		private WaitForAngularRequestsToFinish(JavascriptExecutor objDriver) {
			Dragonfly.this.logger.add("  ==start==>WaitForAngularRequestsToFinish " + new DateTimestamp().get());
			objDriver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
		}
	}

	private class WaitForReadyState {
		private boolean run() {
			Dragonfly.this.logger.add("  ==start==>WaitForReadyState " + new DateTimestamp().get());
			Dragonfly.this.logger.add("waitForReadyState: document.readyState Milliseconds Waited = " + ((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("return document.readyState"));
			return false;
		}
	}

	private class WebDriverTest {
		private WebDriverTest() {
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

	private class WebElementAttributes {
		private WebElementAttributes() {
			Dragonfly.this.logger.add("  ==start==>WebElementAttributes " + new DateTimestamp().get());
			Dragonfly.this.logger.add("text:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getTagName());
			Dragonfly.this.logger.add("tag_type:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getTagName() + "_" + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("type"));
			Dragonfly.this.logger.add("TagName:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("TagName"));
			Dragonfly.this.logger.add("type:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("type"));
			Dragonfly.this.logger.add("id:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("id"));
			Dragonfly.this.logger.add("name:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("name"));
			Dragonfly.this.logger.add("text:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("text"));
			Dragonfly.this.logger.add("innerText:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("innerText"));
			Dragonfly.this.logger.add("outerText:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("outerText"));
			Dragonfly.this.logger.add("innerHTML:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("innerHTML"));
			Dragonfly.this.logger.add("outerHTML:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("outerHTML"));
			Dragonfly.this.logger.add("uniqueID:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("uniqueID"));
			Dragonfly.this.logger.add("class:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("class"));
			Dragonfly.this.logger.add("type:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("type"));
			Dragonfly.this.logger.add("TYPE:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("TYPE"));
			Dragonfly.this.logger.add("href:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("href"));
			Dragonfly.this.logger.add("NameProp:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("NameProp"));
			Dragonfly.this.logger.add("isDisplayed:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.isDisplayed());
			Dragonfly.this.logger.add("name:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.isEnabled());
			Dragonfly.this.logger.add("getLocation().x:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getLocation().x);
			Dragonfly.this.logger.add("getLocation().y:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getLocation().y);
			Dragonfly.this.logger.add("getSize().height:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getSize().height);
			Dragonfly.this.logger.add("getLocation().y:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getSize().width);
			Dragonfly.this.logger.add("src:=  " + Dragonfly.this.objVariablesSelenium.gobjWebElement.getAttribute("src"));
		}
	}

	private class WebElementCollectionAttributes {
		private WebElementCollectionAttributes(String strTagName) {
			Dragonfly.this.logger.add("  ==start==>WebElementCollectionAttributes " + new DateTimestamp().get());
			int intCount = 0;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			List<WebElement> objWebElementCollection = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				intCount = intCount + 1;
				Dragonfly.this.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WebElementCollectionAttributes " + intCount);
				Dragonfly.this.logger.add("text:=  " + row.getTagName());
				Dragonfly.this.logger.add("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
				Dragonfly.this.logger.add("TagName:=  " + row.getAttribute("TagName"));
				Dragonfly.this.logger.add("type:=  " + row.getAttribute("type"));
				Dragonfly.this.logger.add("id:=  " + row.getAttribute("id"));
				Dragonfly.this.logger.add("name:=  " + row.getAttribute("name"));
				Dragonfly.this.logger.add("text:=  " + row.getAttribute("text"));
				Dragonfly.this.logger.add("innerText:=  " + row.getAttribute("innerText"));
				Dragonfly.this.logger.add("outerText:=  " + row.getAttribute("outerText"));
				Dragonfly.this.logger.add("innerHTML:=  " + row.getAttribute("innerHTML"));
				Dragonfly.this.logger.add("outerHTML:=  " + row.getAttribute("outerHTML"));
				Dragonfly.this.logger.add("uniqueID:=  " + row.getAttribute("uniqueID"));
				Dragonfly.this.logger.add("class:=  " + row.getAttribute("class"));
				Dragonfly.this.logger.add("type:=  " + row.getAttribute("type"));
				Dragonfly.this.logger.add("TYPE:=  " + row.getAttribute("TYPE"));
				Dragonfly.this.logger.add("href:=  " + row.getAttribute("href"));
				Dragonfly.this.logger.add("NameProp:=  " + row.getAttribute("NameProp"));
				Dragonfly.this.logger.add("isDisplayed:=  " + row.isDisplayed());
				Dragonfly.this.logger.add("name:=  " + row.isEnabled());
				Dragonfly.this.logger.add("getLocation().x:=  " + row.getLocation().x);
				Dragonfly.this.logger.add("getLocation().y:=  " + row.getLocation().y);
				Dragonfly.this.logger.add("getSize().height:=  " + row.getSize().height);
				Dragonfly.this.logger.add("getLocation().y:=  " + row.getSize().width);
				Dragonfly.this.logger.add("src:=  " + row.getAttribute("src"));
			}
		}
	}

	private class WebElementCollectionTable {
		private WebElementCollectionTable(String strTagName) {
			boolean blnSkip = false;
			Dragonfly.this.logger.add("  ==start==>WebElementCollectionTable " + new DateTimestamp().get());
			// TODO webElementCollectionTable send output to html file
			int intCount = 0;
			//JSONObjectExtended objStepNew = null;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			Dragonfly.this.logger.add("WebElementCollectionTable: strTagName = " + strTagName);
			Dragonfly.this.logger.add("WebElementCollectionTable: lngStartTimeSwitchTo = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle());
			Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().defaultContent();
			for (String winHandle : Dragonfly.this.objVariablesSelenium.gobjWebDriver.getWindowHandles()) {
				intCount = 0;
				// Dragonfly.this.logger.add("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				Dragonfly.this.logger.add("WebElementCollectionTable: winHandle = " + winHandle);
				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// if (strCurrentWindowHandle.equals(winHandle)) {
				// } else {
				Dragonfly.this.objVariablesSelenium.gobjWebDriver.switchTo().window(winHandle);
				Dragonfly.this.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				Dragonfly.this.logger.add("WebElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// }
				Dragonfly.this.logger.add("WebElementCollectionTable: Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getTitle());
				//Dragonfly.this.logger.add("webElementCollectionTable Dragonfly.this.objVariablesSelenium.gobjWebDriver.getPageSource = " + Dragonfly.this.objVariablesSelenium.gobjWebDriver.getPageSource());
				Dragonfly.this.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				List<WebElement> objWebElementCollection = Dragonfly.this.objVariablesSelenium.gobjWebDriver.findElements(By.tagName(strTagName));
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
							Dragonfly.this.logger.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
							Dragonfly.this.logger.add("WebElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
							Dragonfly.this.logger.add("WebElementCollectionTable: type:= '" + row.getAttribute("type") + "'");
							Dragonfly.this.logger.add("WebElementCollectionTable: getText:= '" + row.getText() + "'");
							Dragonfly.this.logger.add("WebElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
						}
					}
					// Dragonfly.this.logger.add("text:=  " + objWebElementEach.);
					// Dragonfly.this.logger.add("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
					// Dragonfly.this.logger.add("TagName:= '" + row.getAttribute("TagName") + "'");
					// Dragonfly.this.logger.add("Type:= '" + row.getAttribute("Type") + "'");
					// Dragonfly.this.logger.add("TYPE:= '" + row.getAttribute("TYPE") + "'");
					// Dragonfly.this.logger.add("id:= '" + row.getAttribute("id") + "'");
					// Dragonfly.this.logger.add("name:= '" + row.getAttribute("name") + "'");
					// Dragonfly.this.logger.add("text:= '" + row.getAttribute("text") + "'");
					// Dragonfly.this.logger.add("innerText:= '" + row.getAttribute("innerText") + "'");
					// Dragonfly.this.logger.add("outerText:= '" + row.getAttribute("outerText") + "'");
					// Dragonfly.this.logger.add("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
					// Dragonfly.this.logger.add("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
					// Dragonfly.this.logger.add("class:= '" + row.getAttribute("class") + "'");
					// Dragonfly.this.logger.add("href:= '" + row.getAttribute("href") + "'");
					// Dragonfly.this.logger.add("NameProp:= '" + row.getAttribute("NameProp") + "'");
					// Dragonfly.this.logger.add("isDisplayed:= '" + row.isDisplayed() + "'");
					// Dragonfly.this.logger.add("isEnabled:= '" + row.isEnabled() + "'");
					// Dragonfly.this.logger.add("getLocation().x:= '" + row.getLocation().x + "'");
					// Dragonfly.this.logger.add("getLocation().y:= '" + row.getLocation().y + "'");
					// Dragonfly.this.logger.add("getSize().height:= '" + row.getSize().height + "'");
					// Dragonfly.this.logger.add("getSize().width:= '" + row.getSize().width + "'");
					// Dragonfly.this.logger.add("src:= '" + row.getAttribute("src") + "'");
					// if (objCollectionJS.size() > 0) {
					//
					// JavascriptExecutor objJavascriptExecutor = null;
					// objJavascriptExecutor = (JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver;
					// long lngStartTimeJS = System.currentTimeMillis();
					// Dragonfly.this.logger.add("JS value = " +
					// objJavascriptExecutor.executeScript("return arguments[0].value;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// Dragonfly.this.logger.add("JS innerText = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// Dragonfly.this.logger.add("JS innerHTML = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// Dragonfly.this.logger.add("JS outerHTML = " +
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
			Dragonfly.this.logger.add("  ==start==>WindowFocus " + new DateTimestamp().get());
			// TODO debug gobjWebDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
			if (Dragonfly.this.objVariablesSelenium.gobjWebDriver instanceof JavascriptExecutor) {
				((JavascriptExecutor) Dragonfly.this.objVariablesSelenium.gobjWebDriver).executeScript("window.focus();");
			}
		}
	}

	private class WindowsProcessKill {
		private WindowsProcessKill(String strProcessToKill) {
			Dragonfly.this.logger.add("  ==start==>WindowsProcessKill " + new DateTimestamp().get());
			try {
				Runtime.getRuntime().exec(strProcessToKill);
				Dragonfly.this.logger.add("WindowsProcessKill: process killed = " + strProcessToKill);
			} catch (Exception e) {
				Dragonfly.this.logger.add("WindowsProcessKill: Exception = " + e.toString());
			}
		}
	}

	public static void main(String[] args) {
		JSONArray objJsonArrayTestSteps = null;
		JSONArray objJsonArrayTestStepsRun = new JSONArray();
		JSONParser objJsonParser = new JSONParser();
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.logger.add("  ==start==>main " + objDragonfly.new DateTimestamp().get());
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
						if (!strInputValue.toLowerCase().equals("<skip>")) {
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
								return;
							default:
								objDragonfly.logger.add("main: switch strAction = " + objDragonfly.variablesJSON.objectStep.getLowerCase("strAction") + "  not supported");
								return;
							}
							strCurrentWindowHandle = objDragonfly.variablesJSON.objectStep.getString("strCurrentWindowHandle");
						}
						if (objDragonfly.variablesJSON.objectStep.getString("strOutputLinkName").trim().length() != 0) {
							objDragonfly.variablesJSON.objectLinks.putValue(objDragonfly.variablesJSON.objectStep.getString("strOutputLinkName"), objDragonfly.variablesJSON.objectStep.getString("strOutputValue"));
						}
						objJsonArrayTestStepsRun.add(objDragonfly.variablesJSON.objectStep);
						objDragonfly.logger.add("main: objJsonArrayTestStepsRun - " + objJsonArrayTestStepsRun);
						if (objDragonfly.variablesJSON.objectStep.verifyEquals("strStatus", "fail")) {
							strTestStatus = "fail";
							if (objDragonfly.variablesJSON.objectStep.getBoolean("blnExitOnFail") == true) {
								//objJsonArrayTestStepsRun.add(objDragonfly.variablesJSON.objectStep);
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
					//					objJsonArrayTestStepsRun.add(objDragonfly.variablesJSON.objectStep);
					//					objDragonfly.logger.add("main: objJsonArrayTestStepsRun - " + objJsonArrayTestStepsRun);
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
		Dragonfly.this.logger.add("  ==start==>data_DateDaysOut " + new DateTimestamp().get());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat objFormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (objFormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_EnvironmentURL(String strApplication_Environment) {
		JSONParser objJsonParser = new JSONParser();
		Dragonfly.this.logger.add("  ==start==>data_EnvironmentURL " + new DateTimestamp().get());
		String strURL = "";
		Dragonfly.this.logger.add("data_EnvironmentURL: Dragonfly.this.objPaths.gstrPathTestData = " + Dragonfly.this.objPaths.gstrPathTestData);
		String strFilePathTestData = Dragonfly.this.objPaths.gstrPathTestData + "Environment.json";
		Dragonfly.this.logger.add("data_EnvironmentURL: strFilePathTestData = " + strFilePathTestData);
		try {
			JSONObjectExtended objJsonObjectFile = Dragonfly.this.new JSONObjectExtended((JSONObject) objJsonParser.parse(new FileReader(strFilePathTestData)));
			Dragonfly.this.logger.add("data_EnvironmentURL: strApplication_Environment = " + strApplication_Environment);
			strURL = objJsonObjectFile.getString(strApplication_Environment);
			Dragonfly.this.logger.add("data_EnvironmentURL: strURL = " + strURL);
		} catch (Exception e) {
			Dragonfly.this.logger.add("data_EnvironmentURL: Exception = " + e.toString());
		}
		return strURL;
	}

	public String data_localWebsiteFilePath(String strWebsite) {
		Dragonfly.this.logger.add("  ==start==>data_localWebsiteFilePath " + new DateTimestamp().get());
		String strLocalWebsiteFilePath = "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		Dragonfly.this.logger.add("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public String data_RandomFourNumbers(String strDaysOut) {
		Dragonfly.this.logger.add("  ==start==>data_RandomFourNumbers " + new DateTimestamp().get());
		return Integer.toString(randomNumberRange(1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(String strDataInput) {
		Dragonfly.this.logger.add("  ==start==>data_RandomRangeFiveNumbers " + new DateTimestamp().get());
		return Integer.toString(randomNumberRange(1, 99999));
	}

	private String getKeyword(String strValue) {
		String strValueToFindKeyword = strValue.toLowerCase();
		int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
		String strKeyword = "";
		if (intRightArrowPosition > -1) {
			strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
		}
		Dragonfly.this.logger.add("KeywordReturn: strKeyword = " + strKeyword);
		return strKeyword;
	}

	private String getKeywordValue(String strValue) {
		String strValueToFindKeyword = strValue.toLowerCase();
		int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
		String strKeywordValue = "";
		if (intRightArrowPosition > -1) {
			strKeywordValue = strValue.substring(intRightArrowPosition + 1);
		} else {
			strKeywordValue = strValue;
		}
		Dragonfly.this.logger.add("KeywordReturn: strKeywordValue " + strKeywordValue);
		return strKeywordValue;
	}

	private void logStepDetails() {
		//		Dragonfly.this.logger.add("  ==start==>logStepDetails " + new DateTimestamp().get());
		//String[] arrKeys;
		//arrKeys = new StepNames().getOriginal();
		for (String strKey : new StepNames().getOriginal()) {
			Dragonfly.this.logger.add("LogStepDetails: " + strKey + " = " + Dragonfly.this.variablesJSON.objectStep.getString(strKey));
		}
	}

	//	private class RandomNumberRange {
	//		private int run(int intNumberMinimum, int intNumberMaximum) {
	//			Dragonfly.this.logger.add("  ==start==>RandomNumberRange " + new DateTimestamp().get());
	//			return new Random().nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
	//		}
	//	}
	private int randomNumberRange(int intNumberMinimum, int intNumberMaximum) {
		return new Random().nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
	}

	private void windowsMinimizeAll() {
		Dragonfly.this.logger.add("  ==start==>WindowsMinimizeAll " + new DateTimestamp().get());
		Robot objRobot = null;
		switch (Dragonfly.this.objOperatingSystem.strOS) {
		case "Windows":
			try {
				objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_WINDOWS);
				objRobot.keyPress(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_WINDOWS);
				Dragonfly.this.logger.add("windowsMinimizeAll: Windows operating system minimize all windows.");
			} catch (Exception e) {
				Dragonfly.this.logger.add("windowsMinimizeAll: Exception = " + e.toString());
			}
			break;
		default:
			Dragonfly.this.logger.add("WindowsMinimizeAll: the operating system not supported at this time " + Dragonfly.this.objOperatingSystem.strOS);
		}
	}

	private void writeFile(String strFilePathFile, String strTextToWrite) {
		Dragonfly.this.logger.add("  ==start==>writeFile " + new DateTimestamp().get());
		Dragonfly.this.logger.add("writeFile: strFilePathFile = " + strFilePathFile);
		try {
			BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(strFilePathFile));
			objBufferedWriter.write(strTextToWrite);
			objBufferedWriter.close();
		} catch (Exception e) {
			Dragonfly.this.logger.add("writeFile: Exception" + e.toString());
		}
	}

	private void writeJsonStepsToHtml(String strStepHeader, JSONArray objTestSteps, String strPath, String strFileName) {
		Dragonfly.this.logger.add("  ==start==>WriteJsonStepsToHtml " + new DateTimestamp().get());
		Dragonfly.this.logger.add("WriteJsonStepsToHtml objTestSteps = " + objTestSteps);
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
				JSONObjectExtended objStepReport = Dragonfly.this.new JSONObjectExtended((JSONObject) objTestSteps.get(intTestStepRow));
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
			Dragonfly.this.writeFile(strPath + strFileName, html);
		} catch (Exception e) {
			Dragonfly.this.logger.add("WriteJsonStepsToHtml: Exception = " + e.toString());
			Dragonfly.this.logger.add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			logger.add("WriteJsonStepsToHtml: Exception = " + e.toString());
			logger.add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
		}
	}

	private void writeReportToHtml(JSONArray objJsonArrayReportSteps, String strFile, String strTestStepsFile, String strTestName) {
		long lngStartTime = System.currentTimeMillis();
		Dragonfly.this.logger.add("  ==start==>WriteReportToHtml " + new DateTimestamp().get());
		Dragonfly.this.logger.add("WriteReportToHtml: strFile = " + strFile);
		JSONObjectExtended objJsonObjectReportStep = null;
		String strScreenshotFilePath = "";
		String strStatus = "";
		String strStatusIcon = "";
		StringBuilder objStringBuilder = new StringBuilder();
		int intTestStepRow = 0;
		Dragonfly.this.logger.add("WriteReportToHtml: objJsonArrayReportSteps = " + objJsonArrayReportSteps);
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
				objJsonObjectReportStep = Dragonfly.this.new JSONObjectExtended((JSONObject) objJsonArrayReportSteps.get(intTestStepRow));
				Dragonfly.this.logger.add("WriteReportToHtml: objJsonObjectReportStep = " + objJsonObjectReportStep);
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
						Dragonfly.this.logger.add("writeReportToHtml: Exception = " + e.toString());
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
			Dragonfly.this.logger.add("WriteReportToHtml: " + e.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			String strHTML = objStringBuilder.toString().replace("varImageCount = -1", "varImageCount = " + (intTestStepRow - 1));
			Dragonfly.this.writeFile(strFile, strHTML);
			Dragonfly.this.writeFile(strTestStepsFile, strHTML);
			Dragonfly.this.logger.add("WriteReportToHtml: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
//	private static ExpectedCondition<Boolean> waitForAngularFinishProcessing() {
//		Dragonfly.this.logger.add("  ==start==>waitForAngularFinishProcessing " + new DateTimestamp().get());
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