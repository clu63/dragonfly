//TODO Alert handling get and verify
//TODO Create an array json for link values from output link name
//TODO Update json with results status timing step details
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
//TODO create new method for attribute setup to only call once per step
//TODO alertFind complete, determine which is best approach and choose method delete one
package org.DragonflyAutomation;

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
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
	// System.exit(0);
	Logger objLogger = new Logger("  ==start==>Dragonfly ");
	PathCreation objPaths = new PathCreation();
	AutoItSetObject objAutoItSetObject = new AutoItSetObject();
	SeleniumVariables objSeleniumVariables = new SeleniumVariables();
	OperatingSystem objOperatingSystem = new OperatingSystem();
	TestConfigurationSetup objTestConfigurationSetup = new TestConfigurationSetup();
	JsonVariables objJsonVariables = new JsonVariables();
	SetSyncVariables objSetSyncVariables = new SetSyncVariables();
	JsonObjectStepPut objJsonObjectStepPut = new JsonObjectStepPut();

	public class ExceptionElementNotFound extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotFound(String message) {
			super(message);
		}
	}

	public class ExceptionMultipleElementsFound extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionMultipleElementsFound(String message) {
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

	public class ExceptionElementNotHidden extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotHidden(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotEnabled extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotEnabled(String message) {
			super(message);
		}
	}

	public class ExceptionElementNotDisabled extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementNotDisabled(String message) {
			super(message);
		}
	}

	public class ExceptionValueNotMatched extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionValueNotMatched(String message) {
			super(message);
		}
	}

	public class ExceptionValueMatched extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionValueMatched(String message) {
			super(message);
		}
	}

	public class ExceptionElementValueNotVerified extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementValueNotVerified(String message) {
			super(message);
		}
	}

	public class ExceptionElementTagNameNotSupported extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionElementTagNameNotSupported(String message) {
			super(message);
		}
	}

	public class ExceptionBrowserDriverNotSupported extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionBrowserDriverNotSupported(String message) {
			super(message);
		}
	}

	public class ExceptionAlertNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionAlertNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionDoPostBackNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionDoPostBackNotComplete(String message) {
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

	public class ExceptionAngularJsNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionAngularJsNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionJSONKeyNotPresent extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionJSONKeyNotPresent(String message) {
			super(message);
		}
	}

	public class ExceptionTestInstanceMoreThanOne extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionTestInstanceMoreThanOne(String message) {
			super(message);
		}
	}

	public class ExceptionPleaseWaitNotComplete extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionPleaseWaitNotComplete(String message) {
			super(message);
		}
	}

	public class ExceptionVisibleTextNotInSelectList extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionVisibleTextNotInSelectList(String message) {
			super(message);
		}
	}

	public class ExceptionKeywordNotValid extends Exception {
		private static final long serialVersionUID = 1L;

		public ExceptionKeywordNotValid(String message) {
			super(message);
		}
	}

	public static void main(String[] args) {
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
		JSONArray gobjJsonArrayTestSteps = null;
		JSONParser gobjJsonParser = new JSONParser();
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>main " + objDragonfly.new DateTimestamp().get());
		objDragonfly.objAutoItSetObject.createObject(objDragonfly);
		objDragonfly.objOperatingSystem.set(objDragonfly);
		String strTestConfigurationFileName = "";
		int intStep = 0;
		int intMillisecondsToWaitDefault = 20000;
		int intLoopCount = 0;
		int intLoopEach = 0;
		int intLoopStep = 0;
		int gintTestInstanceEach = 0;
		Boolean blnIf = true;
		String strCurrentWindowHandle = "";
		String strFolderPathTestSteps = "";
		String strTestStatus = "";
		String strLoopExitValue = "";
		JSONObject gobjJsonObjectTestInstancesEach = null;
		objDragonfly.new WindowsMinimizeAll().set(objDragonfly);
		objDragonfly.objTestConfigurationSetup.run(objDragonfly, strTestConfigurationFileName);
		int gintTestInstanceSize = objDragonfly.objTestConfigurationSetup.gintTestInstanceSize;
		objDragonfly.objLogger.setLogRow("main: gintTestInstanceSize = " + gintTestInstanceSize);
		objDragonfly.objLogger.setLogRow("main: gobjJsonArrayTestSteps.toString = " + objDragonfly.objJsonVariables.gobjJsonArrayTestSteps.toString());
		//String gstrTestStepsCombinedOriginal = objDragonfly.objTestConfigurationSetup.gstrTestStepsCombinedOriginal;
		String gstrTestStepsCombinedOriginal = objDragonfly.objJsonVariables.gobjJsonArrayTestSteps.toString();
		objDragonfly.objLogger.setLogRow("main: gstrTestStepsCombinedOriginal = " + gstrTestStepsCombinedOriginal);
		for (gintTestInstanceEach = 0; gintTestInstanceEach < gintTestInstanceSize; gintTestInstanceEach++) {
			try {
				objDragonfly.objPaths.setPathResults(objDragonfly, gintTestInstanceSize, strTestConfigurationFileName);
				objDragonfly.objLogger.setLogRow("main: gintTestInstanceEach = " + gintTestInstanceEach);
				objDragonfly.objSeleniumVariables.gobjWebElement = null;
				gobjJsonArrayTestSteps = null;
				gobjJsonArrayTestSteps = (JSONArray) gobjJsonParser.parse(gstrTestStepsCombinedOriginal);
				gobjJsonObjectTestInstancesEach = (JSONObject) objDragonfly.objJsonVariables.gobjJsonArrayTestInstances.get(gintTestInstanceEach);
				objDragonfly.objJsonVariables.gobjJsonObjectStep = null;
				intStep = 0;
				intMillisecondsToWaitDefault = 120000;
				intLoopCount = 0;
				intLoopEach = 0;
				intLoopStep = 0;
				strCurrentWindowHandle = "";
				strTestStatus = "pass";
				// TODO Rename Variable strFolderPathTestSteps to refelect the file it represents
				strFolderPathTestSteps = objDragonfly.objPaths.gstrPathTestSteps + strTestConfigurationFileName.replace(".json", ".html");
				objDragonfly.new WriteJsonStepsToHtml(objDragonfly, "original", gobjJsonArrayTestSteps, objDragonfly.objPaths.gstrPathResults, "StepsOriginal.html");
				objDragonfly.objLogger.setLogRow("main: gobjJsonArrayTestSteps.size() = " + gobjJsonArrayTestSteps.size());
				for (intStep = 0; intStep < gobjJsonArrayTestSteps.size(); intStep++) {
					objDragonfly.objLogger.setLogRow("main: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					objDragonfly.objSeleniumVariables.gobjWebElement = null;
					objDragonfly.objJsonVariables.gobjJsonObjectStep = (JSONObject) gobjJsonArrayTestSteps.get(intStep);
					String strInputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
					String strLogicalName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLogicalName").toString();
					if (strLogicalName.toLowerCase().startsWith("<te>") == true) {
						strLogicalName = strLogicalName.replace("<te>", "");
						objDragonfly.new JsonObjectValidateKey(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectElement, strLogicalName);
						JSONObject objJsonObjectElementNode = (JSONObject) objDragonfly.objJsonVariables.gobjJsonObjectElement.get(strLogicalName);
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strTagName", objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectElementNode, "strTagName", ""));
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strAttributeNames", objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectElementNode, "strAttributeNames", ""));
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strAttributeValues", objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectElementNode, "strAttributeValues", ""));
					}
					if (strInputValue.toLowerCase().startsWith("<link>") == true) {
						strInputValue = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectLinks, strInputValue, "<link>");
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", strInputValue);
					}
					if (strInputValue.toLowerCase().startsWith("<ti>") == true) {
						strInputValue = objDragonfly.new JsonObjectGetValue().run(objDragonfly, gobjJsonObjectTestInstancesEach, strInputValue, "<ti>");
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", strInputValue);
					}
					objDragonfly.objLogger.setLogRow("main: startsWith(<td>) strInputValue " + strInputValue);
					if (strInputValue.toLowerCase().startsWith("<td>") == true) {
						strInputValue = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectTestData, strInputValue, "<td>");
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", strInputValue);
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intMillisecondsToWait").toString().trim().length() == 0) {
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intMillisecondsToWait", Integer.toString(intMillisecondsToWaitDefault));
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("blnOptional").toString().trim().length() == 0) {
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnOptional", "false");
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAssert").toString().trim().length() == 0) {
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strAssert", "off");
					}
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnPleaseWait", "true");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnHighlight", "true");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnScreenshot", "true");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strScreenshotArea", "screen");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strHighlightArea", "");
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("blnExitOnFail").toString().trim().length() == 0) {
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnExitOnFail", "true");
					}
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strCurrentWindowHandle", strCurrentWindowHandle);
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strType", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strScreenshotFilePath", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "info");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStartTimestamp", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepDuration", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strEndTimestamp", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepExpected", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepActual", "");
					objDragonfly.new LogStepDetails(objDragonfly, intStep);
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().trim().length() > 0) {
						if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<loopstart>") == true) {
							if (intLoopEach == 0) {
								intLoopCount = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().substring(11));
								objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strLoopOrIf", "");
								intLoopEach = 1;
								intLoopStep = intStep;
							}
						}
					}
					objDragonfly.objLogger.setLogRow("main: intLoopCount = " + intLoopCount);
					objDragonfly.objLogger.setLogRow("main: intLoopEach = " + intLoopEach);
					objDragonfly.objLogger.setLogRow("main: intStep = " + intStep);
					objDragonfly.objLogger.setLogRow("main: intLoopStep = " + intLoopStep);
					if (!objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strFunction").toString().trim().equals("")) {
						String strMethodName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strFunction").toString();
						String strArguments = strInputValue;
						Class<?> objClass = Class.forName("org.DragonflyAutomation.Dragonfly");
						//						Class<?> objParameterTypes[] = new Class[1];
						//						objParameterTypes[0] = String.class;
						Class<?> objParameterTypes[] = new Class[2];
						objParameterTypes[0] = Dragonfly.class;
						objParameterTypes[1] = String.class;
						Method objMethod = objClass.getMethod(strMethodName, objParameterTypes);
						Object arrArgumentList[] = new Object[2];
						arrArgumentList[0] = objDragonfly;
						arrArgumentList[1] = new String(strArguments);
						//Object arrArgumentList[] = new Object[1];
						//arrArgumentList[0] = new String(strArguments);
						Object objReturn = objMethod.invoke(objDragonfly, arrArgumentList);
						String strReturnValue = (String) objReturn;
						strInputValue = strReturnValue.toString();
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", strInputValue);
						objDragonfly.objLogger.setLogRow("main: call function return value = " + strInputValue);
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<else if") == true) {
						objDragonfly.objLogger.setLogRow("main: blnIf = " + blnIf);
						if (blnIf == false) {
							blnIf = true;
						} else {
							blnIf = false;
						}
					}
					if (blnIf == true) {
						if (!strInputValue.toLowerCase().equals("<skip>")) {
							switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAction").toString().toLowerCase()) {
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
								objDragonfly.objLogger.setLogRow("main: switch strAction = break was entered to at this step to stop execution");
								return;
							default:
								objDragonfly.objLogger.setLogRow("main: switch strAction = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAction").toString().toLowerCase() + "  not supported");
								return;
							}
							strCurrentWindowHandle = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strCurrentWindowHandle").toString();
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strOutputLinkName").toString().trim().length() != 0) {
						objDragonfly.objJsonVariables.gobjJsonObjectLinks.put(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strOutputLinkName").toString(), objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strOutputValue").toString());
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strStatus").toString().equals("fail")) {
						strTestStatus = "fail";
						if (Boolean.parseBoolean(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("blnExitOnFail").toString()) == true) {
							objDragonfly.new WebElementCollectionTable(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString());
							break;
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<loopexit>") == true) {
						strLoopExitValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().substring(10);
						objDragonfly.objLogger.setLogRow("main: strLoopExitValue = " + strLoopExitValue);
						if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strOutputValue").toString().equals(strLoopExitValue)) {
							intLoopCount = 0;
							intLoopEach = 0;
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<loopend>") == true) {
						if (intLoopEach == intLoopCount) {
							intLoopCount = 0;
							intLoopEach = 0;
						} else {
							intLoopEach = intLoopEach + 1;
							intStep = intLoopStep - 1;
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<if") == true) {
						objDragonfly.objLogger.setLogRow("main: intLoopIf strStatus = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strStatus").toString());
						if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strStatus").toString().equals("pass")) {
							objDragonfly.objLogger.setLogRow("main: blnIf = true");
							blnIf = true;
						} else {
							blnIf = false;
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<else if") == true) {
						objDragonfly.objLogger.setLogRow("main: intLoopIf strStatus = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strStatus").toString());
						if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strStatus").toString().equals("pass")) {
							objDragonfly.objLogger.setLogRow("main: blnIf = true");
							blnIf = true;
						} else {
							blnIf = false;
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<else>") == true) {
						objDragonfly.objLogger.setLogRow("main: <else> blnIf = " + blnIf);
						if (blnIf.equals(true)) {
							blnIf = false;
						} else {
							blnIf = true;
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLoopOrIf").toString().toLowerCase().startsWith("<end if") == true) {
						objDragonfly.objLogger.setLogRow("main: blnIf = false");
						blnIf = true;
					}
					//}
					//					if (gobjJsonArrayTestStepsComplete == null) {
					//						gobjJsonArrayTestStepsComplete = (JSONObject) gobjJsonParser.parse(objDragonfly.objJsonVariables.gobjJsonObjectStep.toString());
					//					} else {
					//						gobjJsonArrayTestStepsComplete.putAll((JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestData)));
					//					}
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("main: Exception " + e.toString());
			} finally {
				objDragonfly.new WriteFile(objDragonfly, objDragonfly.objPaths.gstrPathResults + "StepsAfterRun.json", gobjJsonArrayTestSteps.toString());
				objDragonfly.new WriteFile(objDragonfly, objDragonfly.objPaths.gstrPathResults + "StepsWithDefaults.json", objDragonfly.objJsonVariables.gobjJsonArrayTestSteps.toString());
				objDragonfly.new WriteJsonStepsToHtml(objDragonfly, "original", gobjJsonArrayTestSteps, objDragonfly.objPaths.gstrPathResults, "StepsWithDefaults.html");
				objDragonfly.new WriteJsonStepsToHtml(objDragonfly, "complete", gobjJsonArrayTestSteps, objDragonfly.objPaths.gstrPathResults, "StepsAfterRun.html");
				objDragonfly.new WriteReportToHtml(objDragonfly, gobjJsonArrayTestSteps, objDragonfly.objPaths.gstrPathResults + "Report.html", strFolderPathTestSteps, strTestConfigurationFileName.replace(".json", ""));
				objDragonfly.objPaths.changeDirectoryNameStatus(objDragonfly, strTestStatus);
				if (objDragonfly.objSeleniumVariables.gobjWebDriver.toString().contains("InternetExplorerDriver")) {
					objDragonfly.new WindowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
				}
				objDragonfly.new WriteFile(objDragonfly, objDragonfly.objPaths.gstrPathResults + "Dragonfly.log", objDragonfly.objLogger.getLog());
			}
			objDragonfly.objLogger.deleteLog();
		}
	}

	public class PathCreation {
		private String gstrPathData = "Data/internal/";//"Data/public/";//
		private String gstrPathResults;
		private String gstrPathResultsTop;
		public String gstrPathSystemUserDir = System.getProperty("user.dir");
		public String gstrPathTestConfiguration = gstrPathData + "test_configuration/";
		public String gstrPathTestData = gstrPathData + "test_data/";
		public String gstrPathTestElements = gstrPathData + "test_elements/";
		public String gstrPathTestInstances = gstrPathData + "test_instances/";
		public String gstrPathTestModules = gstrPathData + "test_modules/";
		public String gstrPathTestSteps = gstrPathData + "test_steps/";
		public String gstrPathImages;

		public void setPathResults(Dragonfly objDragonfly, int intTestInstanceSize, String strTestConfigurationFileName) {
			objDragonfly.objLogger.setLogRow("PathCreation:setPathResults intTestInstanceSize = " + intTestInstanceSize);
			objDragonfly.objLogger.setLogRow("PathCreation:setPathResults strTestConfigurationFileName = " + strTestConfigurationFileName);
			String gstrDateTimestamp = new DateTimestamp().get();
			objDragonfly.objLogger.setLogRow("PathCreation:setPathResults gstrDateTimestamp = " + gstrDateTimestamp);
			objDragonfly.objLogger.setLogRow("PathCreation:setPathResults gstrPathImages==null = " + gstrPathImages);
			if (gstrPathImages == null) {
				gstrPathResultsTop = gstrPathSystemUserDir + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\";
				objDragonfly.objLogger.setLogRow("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				if (intTestInstanceSize > 1) {
					gstrPathResultsTop = gstrPathResultsTop + gstrDateTimestamp + "\\Iterations_" + intTestInstanceSize + "\\";
					objDragonfly.objLogger.setLogRow("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
				}
			}
			gstrPathResults = gstrPathResultsTop + gstrDateTimestamp + "\\";
			objDragonfly.objLogger.setLogRow("PathCreation:setPathResults gstrPathResults = " + gstrPathResults);
			gstrPathImages = gstrPathResults + "images\\";
			objDragonfly.objLogger.setLogRow("PathCreation:setPathResults gstrPathImages = " + gstrPathImages);
			new File(gstrPathImages).mkdirs();
		}

		public void changeDirectoryNameStatus(Dragonfly objDragonfly, String strTestStatus) {
			objDragonfly.objLogger.setLogRow("PathCreation:changeDirectoryNameStatus gstrPathResults = " + gstrPathResults);
			File objDirectoryOld = new File(gstrPathResults);
			String strPathResultsNew = gstrPathResults.substring(0, gstrPathResults.length() - 1) + "_" + strTestStatus + "\\";
			objDragonfly.objLogger.setLogRow("PathCreation:changeDirectoryNameStatus strPathResultsNew = " + strPathResultsNew);
			File objDirectoryNew = new File(strPathResultsNew);
			objDirectoryOld.renameTo(objDirectoryNew);
			gstrPathResults = strPathResultsNew;
		}
	}

	public class AlertFind {
		public boolean run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>alertFind " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				String strAlertPresent = objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().getText();
				objDragonfly.objLogger.setLogRow("alertFind: alert found:  " + strAlertPresent);
				return true;
			} catch (UnhandledAlertException e) {
				objDragonfly.objLogger.setLogRow("alertFind: UnhandledAlertException = " + e.toString());
				return true;
			} catch (NoAlertPresentException e) {
				objDragonfly.objLogger.setLogRow("alertFind: NoAlertPresentException = " + e.toString());
				return false;
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("alertFind: Exception = " + e.toString());
				return false;
			} finally {
				objDragonfly.objLogger.setLogRow("alertFind: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class AutoItSetObject {
		public AutoItX objAutoIt;

		public void createObject(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>autoItSetObject " + new DateTimestamp().get());
			String strJacobDllVersionToUse;
			JvmBitVersion objJvmBitVersion = new JvmBitVersion();
			if (objJvmBitVersion.get(objDragonfly).contains("32")) {
				strJacobDllVersionToUse = "jacob-1.18-x86.dll";
			} else {
				strJacobDllVersionToUse = "jacob-1.18-x64.dll";
			}
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + System.getProperty("java.library.path") + " " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + strJacobDllVersionToUse + " " + new DateTimestamp().get());
			File objFile = new File("Libraries", strJacobDllVersionToUse);
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + LibraryLoader.JACOB_DLL_PATH + " " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("autoItSetObject: " + objFile.getAbsolutePath() + " " + new DateTimestamp().get());
			System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
			objAutoIt = new AutoItX();
		}

		public AutoItX getObject() {
			return objAutoIt;
		}
	}

	public class BrowserClose {
		public BrowserClose(Dragonfly objDragonfly) {
			objDragonfly.objSeleniumVariables.gobjWebDriver.close();
			objDragonfly.objSeleniumVariables.gobjWebDriver.quit();
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
			new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
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
			objDragonfly.objLogger.setLogRow("  ==start==>browserLaunch " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			DesiredCapabilities objDesiredCapabilities = null;
			try {
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
				switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString()) {
				case "firefox":
					objDragonfly.objSeleniumVariables.gobjWebDriver = new FirefoxDriver();
					objDragonfly.objSeleniumVariables.gobjWebDriver.get(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize();
					Actions myAction = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					myAction.sendKeys(Keys.CONTROL, Keys.DIVIDE, Keys.CONTROL).build().perform();
					break;
				case "ie":
					// internetExplorerProcessKill();
					//windowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
					new SleepMilliseconds(objDragonfly, 1000);
					objDragonfly.objLogger.setLogRow("browserLaunch: DesiredCapabilities");
					objDesiredCapabilities = DesiredCapabilities.internetExplorer();
					objDragonfly.objLogger.setLogRow("browserLaunch: objDesiredCapabilities.toString()" + objDesiredCapabilities);
					objDragonfly.objLogger.setLogRow("browserLaunch: setJavascriptEnabled");
					objDesiredCapabilities.setJavascriptEnabled(true);
					objDragonfly.objLogger.setLogRow("browserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
					objDragonfly.objLogger.setLogRow("browserLaunch: IE_ENSURE_CLEAN_SESSION");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					objDragonfly.objLogger.setLogRow("browserLaunch: REQUIRE_WINDOW_FOCUS");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					objDragonfly.objLogger.setLogRow("browserLaunch: INITIAL_BROWSER_URL");
					objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
					objDragonfly.objLogger.setLogRow("browserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					objDragonfly.objLogger.setLogRow("browserLaunch: new InternetExplorerDriver(desiredCapabilities)");
					objDragonfly.objSeleniumVariables.gobjWebDriver = new InternetExplorerDriver(objDesiredCapabilities);
					//objDragonfly.objSeleniumVariables.gobjWebDriver.manage().getCookieNamed("JSESSIONID");
					// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
					objDragonfly.objLogger.setLogRow("browserLaunch: objDragonfly.objJsonVariables.gobjJsonObjectStep.get(strInputValue).toString() = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					//objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
					objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
					objDragonfly.objSeleniumVariables.gobjWebDriver.get(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					//objDragonfly.objLogger.setLogRow("browserLaunch: getCookieNamed(JSESSIONID) = " + objDragonfly.objSeleniumVariables.gobjWebDriver.manage().getCookieNamed("JSESSIONID").toString());
					objDragonfly.objLogger.setLogRow("browserLaunch: objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize()");
					objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize();
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
					objDragonfly.objSeleniumVariables.gobjWebDriver = new ChromeDriver();
					objDragonfly.objSeleniumVariables.gobjWebDriver.get(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize();
					break;
				case "safari":
					objDragonfly.objSeleniumVariables.gobjWebDriver = new SafariDriver();
					objDragonfly.objSeleniumVariables.gobjWebDriver.get(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize();
					break;
				case "opera":
					// TODO OperaDriver setup latest driver and test desiredCapabilities = DesiredCapabilities.internetExplorer();
					// desiredCapabilities.setJavascriptEnabled(true);
					//objDragonfly.objSeleniumVariables.gobjWebDriver = new OperaDriver();
					//objDragonfly.objSeleniumVariables.setGobjWebDriver(new OperaDriver());
					objDragonfly.objSeleniumVariables.gobjWebDriver = new OperaDriver();
					objDragonfly.objSeleniumVariables.gobjWebDriver.get(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize();
					// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().setPosition(new Point(0, 0));
					// Dimension dim = new Dimension(1382, 754);
					// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().setSize(dim);
					// Selenium selenium;
					// objDragonfly.objSeleniumVariables.gobjWebDriver = new OperaDriver();
					// selenium = new WebDriverBackedSelenium(objDragonfly.objSeleniumVariables.gobjWebDriver, "https://www.google.com/");
					// return objDragonfly.objSeleniumVariables.gobjWebDriver;
					break;
				default:
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "fail");
					throw new ExceptionBrowserDriverNotSupported("Browser '" + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString() + "' not supported");
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("browserLaunch: Exception" + e.toString());
			} finally {
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strCurrentWindowHandle", objDragonfly.objSeleniumVariables.gobjWebDriver.getWindowHandle());
				new CoordinatesElement(objDragonfly);
				new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
				new StepDuration(objDragonfly, "browserLaunch", lngTimeStart, "launch");
			}
		}
	}

	public class BrowserLaunchSync {
		public BrowserLaunchSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>BrowserLaunchSync " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			new WriteFile(objDragonfly, "c:\\temp\\DragonflyBrowser.log", objDragonfly.objLogger.getLog());
			try {
				new BrowserLaunch(objDragonfly);
			} catch (ExceptionBrowserDriverNotSupported e) {
				// TODO confirm the exceptions to catch in main some may need to be removed
				objDragonfly.objLogger.setLogRow("main: " + e.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO create a BrowserLaunchSync to manage reporting and sync
				objDragonfly.objLogger.setLogRow("BrowserLaunchSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SeleniumVariables {
		private WebDriver gobjWebDriver = null;
		private WebDriver gobjWebDriverCoordinates = null;
		private WebElement gobjWebElement = null;
		private WebElement gobjWebElementDrag = null;
		private WebElement gobjWebElementDrop = null;
		private WebElement gobjWebElementPleaseWait = null;
	}

	public class JsonVariables {
		private JSONArray gobjJsonArrayTestInstances = null;
		private JSONObject gobjJsonObjectElement = null;
		private JSONObject gobjJsonObjectProcessing = null;
		private JSONObject gobjJsonObjectTestData = null;
		private JSONObject gobjJsonObjectLinks = null;
		private JSONObject gobjJsonObjectStep = new JSONObject();
		private JSONArray gobjJsonArrayTestSteps = null;
	}

	public class SetSyncVariables {
		private Boolean gblnSyncPleaseWait = false;
		private Boolean gblnSyncAlert = false;
		private Boolean gblnSyncWaitForReadyState = false;
		private Boolean gblnSyncDoPostBack = false;
		private Boolean gblnSyncJQueryAjax = false;
		private Boolean gblnSyncJQueryAnimation = false;
		private Boolean gblnSyncAngularJs = false;
	}

	public class BrowserRefresh {
		public BrowserRefresh(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>webDriverRefresh " + new DateTimestamp().get());
			objDragonfly.objSeleniumVariables.gobjWebDriver.navigate().refresh();
		}
	}

	public class BrowserRefreshSync {
		public BrowserRefreshSync(Dragonfly objDragonfly) {
			new BrowserRefresh(objDragonfly);
		}
	}

	public class Logger {
		private StringBuilder objStringBuilder = new StringBuilder();;

		public Logger(String strTextToAdd) {
			System.out.println(strTextToAdd);
			this.objStringBuilder.append(strTextToAdd);
			this.objStringBuilder.append(System.getProperty("line.separator"));
		}

		public void setLogRow(String strTextToAdd) {
			System.out.println(strTextToAdd);
			objStringBuilder.append(strTextToAdd);
			objStringBuilder.append(System.getProperty("line.separator"));
		}

		public String getLog() {
			return objStringBuilder.toString();
		}

		public void deleteLog() {
			objStringBuilder.delete(0, objStringBuilder.length());
		}
	}

	public class OperatingSystem {
		String strOS = "";

		public void set(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>oSType " + new DateTimestamp().get());
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

	public class ConvertPathByOperatingSystem {
		public void run(Dragonfly objDragonfl, String strPath) {
			//objDragonfly.objLogger.setLogRow("main: gstrOperatingSystem = " + objDragonfly.objOperatingSystem.strOS);
			//				switch (gstrOperatingSystem) {
			//				case "Windows":
			//					strFolderPathResults = objDragonfly.objPaths.getPathSystemUserDir() + "\\Results\\" + strTestConfigurationFileName.replace(".json", "") + "\\" + gstrFolderPathResultsFolder + "\\";
			//					strFolderPathImages = "images\\";
			//					break;
			//				case "Mac":
			//					strFolderPathResults = objDragonfly.objPaths.getPathSystemUserDir() + "/Results/" + strTestConfigurationFileName.replace(".json", "") + "/" + gstrFolderPathResultsFolder + "/";
			//					strFolderPathImages = "images/";
			//					break;
			//				default:
			//					objDragonfly.objLogger.setLogRow("main: switch gstrOperatingSystem = " + gstrOperatingSystem + "  not supported");
			//					return;
			//				}
		}
	}

	public class JvmBitVersion {
		public String get(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("jvmBitVersion: System.getProperty(sun.arch.data.model) = " + System.getProperty("sun.arch.data.model") + " " + new DateTimestamp().get());
			return System.getProperty("sun.arch.data.model");
		}
	}

	public class WindowsMinimizeAll {
		public void set(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>windowsMinimizeAll " + new DateTimestamp().get());
			Robot objRobot = null;
			switch (objDragonfly.objOperatingSystem.strOS) {
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
			default:
				objDragonfly.objLogger.setLogRow("windowsMinimizeAll: the operating system not supported at this time " + objDragonfly.objOperatingSystem.strOS);
			}
		}
	}

	public class WindowsProcessKill {
		public WindowsProcessKill(Dragonfly objDragonfly, String strProcessToKill) {
			objDragonfly.objLogger.setLogRow("  ==start==>windowsProcessKill " + new DateTimestamp().get());
			try {
				Runtime.getRuntime().exec(strProcessToKill);
				objDragonfly.objLogger.setLogRow("windowsProcessKill: process killed = " + strProcessToKill);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("windowsProcessKill: Exception = " + e.toString());
			}
		}
	}

	public class SleepMilliseconds {
		public SleepMilliseconds(Dragonfly objDragonfly, int intMillisecondsToWait) {
			objDragonfly.objLogger.setLogRow("  ==start==>sleepMilliseconds " + new DateTimestamp().get());
			try {
				TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("sleepMilliseconds: Exception = " + e.toString());
			}
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
			objDragonfly.objLogger.setLogRow("  ==start==>internetExplorerVersion " + new DateTimestamp().get());
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
			}
		}
	}

	//	public static int loopEndFind(JSONObject objJSONObject) {
	//		objDragonfly.objLogger.setLogRow("  ==start==>loopEndFind " + new DateTimestamp().get());
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
	//		return 0;
	//	}
	public class JsonObjectValidateKey {
		public JsonObjectValidateKey(Dragonfly objDragonfly, JSONObject objJSONObject, String strKeyName) throws ExceptionJSONKeyNotPresent {
			objDragonfly.objLogger.setLogRow("  ==start==>jsonObjectValidateKey " + new DateTimestamp().get());
			if (!objJSONObject.containsKey(strKeyName)) {
				throw new ExceptionJSONKeyNotPresent("JSON Key " + strKeyName + " not present");
			}
		}
	}

	public class JsonObjectGetValue {
		public String run(Dragonfly objDragonfly, JSONObject objJSONObject, String strInputValue, String strKeywordName) throws ExceptionJSONKeyNotPresent {
			objDragonfly.objLogger.setLogRow("  ==start==>JsonObjectGetValue run " + new DateTimestamp().get());
			String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
			String strJSONObjectValue = "";
			objDragonfly.objLogger.setLogRow("JsonObjectGetValue run strJSONObjectKey = " + strJSONObjectKey);
			if (objJSONObject.containsKey(strJSONObjectKey)) {
				strJSONObjectValue = objJSONObject.get(strJSONObjectKey).toString();
				objDragonfly.objLogger.setLogRow("jsonObjectGetValue: strJSONObjectValue = " + strJSONObjectValue);
				return strJSONObjectValue;
			} else {
				objDragonfly.objLogger.setLogRow("jsonObjectGetValue: JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
				throw new ExceptionJSONKeyNotPresent("JSON Key " + strJSONObjectKey + " for keyword link name " + strKeywordName + " not present");
			}
		}
	}

	public class JsonObjectStepPut {
		@SuppressWarnings("unchecked")
		public void run(Dragonfly objDragonfly, String strKeyName, String strKeyValue) {
			objDragonfly.objJsonVariables.gobjJsonObjectStep.put(strKeyName, strKeyValue);
		}
	}

	public class TestConfigurationSetup {
		int gintTestInstanceSize;
		String gstrTestStepsCombinedOriginal;
		JSONObject objJsonObjectTestConfigurationFile = null;
		private JSONParser objJsonParser = new JSONParser();

		public void run(Dragonfly objDragonfly, String strFileNameTestConfiguration) {
			// TODO complete TestConfigurationSetup method to create json objects for test
			objDragonfly.objLogger.setLogRow("  ==start==>TestConfigurationSetup " + new DateTimestamp().get());
			//JSONArray gobjJsonArrayLink = null;
			long lngStartTime = System.currentTimeMillis();
			String strFilePathTestConfiguration = "";
			try {
				strFilePathTestConfiguration = objDragonfly.objPaths.gstrPathTestConfiguration + strFileNameTestConfiguration;
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: strPathTestConfiguration = " + strFilePathTestConfiguration);
				objJsonObjectTestConfigurationFile = (JSONObject) objJsonParser.parse(new FileReader(strFilePathTestConfiguration));
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: objJsonObjectTestConfigurationFile = " + objJsonObjectTestConfigurationFile);
				// test_instances
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: test_instances");
				objDragonfly.objJsonVariables.gobjJsonArrayTestInstances = this.putAllArrays(objDragonfly, "test_instances", "test_instances", objDragonfly.objPaths.gstrPathTestInstances);
				gintTestInstanceSize = objDragonfly.objJsonVariables.gobjJsonArrayTestInstances.size();
				// test_elements
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: test_elements");
				objDragonfly.objJsonVariables.gobjJsonObjectElement = this.putAllObjects(objDragonfly, "test_elements", "elements", objDragonfly.objPaths.gstrPathTestElements);
				// processing
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: processing");
				objDragonfly.objJsonVariables.gobjJsonObjectProcessing = this.putAllObjects(objDragonfly, "test_elements", "processing", objDragonfly.objPaths.gstrPathTestElements);
				// test_modules
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: test_modules");
				objDragonfly.objJsonVariables.gobjJsonArrayTestSteps = this.putAllArrays(objDragonfly, "test_modules", "steps", objDragonfly.objPaths.gstrPathTestModules);
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: gobjJsonArrayTestSteps.toString = " + objDragonfly.objJsonVariables.gobjJsonArrayTestSteps.toString());
				// TODO add error handling, report no test modules and fail
				// test_links
				objDragonfly.objJsonVariables.gobjJsonObjectLinks = (JSONObject) objJsonParser.parse("{\"link\":[{}]}");
				// test_data
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: test_data");
				objDragonfly.objJsonVariables.gobjJsonObjectTestData = this.putAllObjects(objDragonfly, "test_data", "test_data", objDragonfly.objPaths.gstrPathTestData);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}

		@SuppressWarnings("unchecked")
		private JSONObject putAllObjects(Dragonfly objDragonfly, String strJsonArrayName, String strJsonObjectName, String strPath) {
			objDragonfly.objLogger.setLogRow("  ==start==>putAllObjects " + new DateTimestamp().get());
			Integer intJsonObjectEach = 0;
			JSONArray objJsonArrayList = null;
			JSONObject objJsonObject = null;
			JSONObject objJsonObjectEach = null;
			JSONObject objJsonObjectFileEach = null;
			String strFileNameEach = "";
			String strFilePathJsonArray = "";
			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.get(strJsonArrayName);
			objDragonfly.objLogger.setLogRow("TestConfigurationSetup:putAllObjects objJsonArrayList.size() " + objJsonArrayList.size());
			for (intJsonObjectEach = 0; intJsonObjectEach < objJsonArrayList.size(); intJsonObjectEach++) {
				strFileNameEach = objJsonArrayList.get(intJsonObjectEach).toString();
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup:putAllObjects strFileNameEach " + strFileNameEach);
				strFilePathJsonArray = strPath + strFileNameEach;
				objDragonfly.objLogger.setLogRow("TestConfigurationSetup:putAllObjects strFilePathJsonArray " + strFilePathJsonArray);
				try {
					objJsonObjectFileEach = (JSONObject) objJsonParser.parse(new FileReader(strFilePathJsonArray));
					objJsonObjectEach = (JSONObject) objJsonObjectFileEach.get(strJsonObjectName);
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
			objDragonfly.objLogger.setLogRow("TestConfigurationSetup:putAllObjects objJsonObject = " + objJsonObject);
			return objJsonObject;
		}

		@SuppressWarnings("unchecked")
		private JSONArray putAllArrays(Dragonfly objDragonfly, String strJsonArrayName, String strJsonObjectName, String strPath) {
			int intJsonArrayEach = 0;
			JSONArray objJsonArray = null;
			JSONArray objJsonArrayEach = null;
			JSONArray objJsonArrayList = null;
			JSONObject objJsonObjectFileEach = null;
			String strFileNameEach = "";
			String strFilePathJsonArray = "";
			objJsonArrayList = (JSONArray) objJsonObjectTestConfigurationFile.get(strJsonArrayName);
			if (objJsonArrayList.size() == 0) {
				return null;
			} else {
				for (intJsonArrayEach = 0; intJsonArrayEach < objJsonArrayList.size(); intJsonArrayEach++) {
					strFileNameEach = objJsonArrayList.get(intJsonArrayEach).toString();
					strFilePathJsonArray = strPath + strFileNameEach;
					objDragonfly.objLogger.setLogRow("TestConfigurationSetup:putAllArrays strFilePathJsonArray = " + strFilePathJsonArray);
					try {
						objJsonObjectFileEach = (JSONObject) objJsonParser.parse(new FileReader(strFilePathJsonArray));
						objJsonArrayEach = (JSONArray) objJsonObjectFileEach.get(strJsonObjectName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						objDragonfly.objLogger.setLogRow("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
						e.printStackTrace();
					}
					if (intJsonArrayEach == 0) {
						objJsonArray = objJsonArrayEach;
					} else {
						objJsonArray.addAll(objJsonArrayEach);
					}
				}
			}
			objDragonfly.objLogger.setLogRow("TestConfigurationSetup:putAllArrays objJsonArray = " + objJsonArray);
			return objJsonArray;
		}
	}

	public class LogStepDetails {
		public LogStepDetails(Dragonfly objDragonfly, int intStep) {
			Long lngTimeStart = System.currentTimeMillis();
			objDragonfly.objLogger.setLogRow("  ==start==>logStepDetails " + new DateTimestamp().get());
			String[] arrKeys;
			String strKey = "";
			try {
				arrKeys = new StepNames().getOriginal();
				for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
					strKey = (String) arrKeys[intKeysEach].toString();
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey(strKey) == true) {
						objDragonfly.objLogger.setLogRow("logStepDetails: " + strKey + " = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get(strKey).toString());
					}
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("LogStepDetails: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				objDragonfly.objLogger.setLogRow("LogStepDetails: " + strKey + " Milliseconds Waited = " + (System.currentTimeMillis()));
			}
		}
	}

	public class ElementOnMouseOver {
		public ElementOnMouseOver(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementOnMouseOver " + new DateTimestamp().get());
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseover();", objDragonfly.objSeleniumVariables.gobjWebElement);
		}
	}

	public class ElementOnMouseOverSync {
		public ElementOnMouseOverSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementOnMouseOverSync " + new DateTimestamp().get());
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
					objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementOnMouseOverSync", "mouse_over", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnOnMouseOver = false;
					}
				}
			}
		}
	}

	public class ElementOnMouseOut {
		public ElementOnMouseOut(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementOnMouseOut " + new DateTimestamp().get());
			JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
			objJavascriptExecutor.executeScript("arguments[0].onmouseout();", objDragonfly.objSeleniumVariables.gobjWebElement);
		}
	}

	public class ElementOnMouseOutSync {
		public ElementOnMouseOutSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementOnMouseOutSync " + new DateTimestamp().get());
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
					objDragonfly.objLogger.setLogRow("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementOnMouseOutSync", "mouse_out", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
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
			objDragonfly.objLogger.setLogRow("  ==start==>ElementPleaseWait " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnPleaseWait = Boolean.parseBoolean(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("blnPleaseWait").toString());
			Integer intPleaseWaitEach;
			String strAttributeNames = null;
			String strAttributeValues = null;
			String strTagName = null;
			Boolean blnFound = false;
			String strMessage = "";
			try {
				objDragonfly.objSeleniumVariables.gobjWebElementPleaseWait = objDragonfly.objSeleniumVariables.gobjWebElement;
				objDragonfly.objLogger.setLogRow("ElementPleaseWait: gobjJsonObjectProcessing.size() = " + objDragonfly.objJsonVariables.gobjJsonObjectProcessing.size());
				if (blnPleaseWait == true) {
					for (intPleaseWaitEach = 1; intPleaseWaitEach < objDragonfly.objJsonVariables.gobjJsonObjectProcessing.size(); intPleaseWaitEach++) {
						JSONObject objJsonObjectPleaseWaitNode = (JSONObject) objDragonfly.objJsonVariables.gobjJsonObjectProcessing.get("PleaseWait_" + intPleaseWaitEach);
						try {
							strAttributeNames = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectPleaseWaitNode, "strAttributeNames", "");
							strAttributeValues = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectPleaseWaitNode, "strAttributeValues", "");
							strTagName = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objJsonObjectPleaseWaitNode, "strTagName", "");
							objDragonfly.objLogger.setLogRow("ElementPleaseWait: variables = " + strAttributeNames + " " + strAttributeValues + " " + strTagName);
						} catch (ExceptionJSONKeyNotPresent e1) {
							// TODO Auto-generated catch block
							objDragonfly.objLogger.setLogRow("ElementPleaseWait: ExceptionJSONKeyNotPresent = " + e1.toString());
						}
						try {
							new ElementFindBy(objDragonfly, strAttributeNames, strAttributeValues, strTagName);
							blnFound = true;
							strMessage = "Element found.";
						} catch (ExceptionElementNotFound e) {
							blnFound = false;
							objDragonfly.objLogger.setLogRow("ElementPleaseWait: ElementFindBy = blnFound = false Milliseconds Waited = " + (System.currentTimeMillis()));
						} catch (ExceptionMultipleElementsFound e) {
							blnFound = true;
							strMessage = "Multiple elements found.";
							objDragonfly.objLogger.setLogRow("ElementPleaseWait: ElementFindBy = blnFound = true Milliseconds Waited = " + (System.currentTimeMillis()));
						}
						if (blnFound == true) {
							if (objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed() == true) {
								objDragonfly.objLogger.setLogRow("ElementPleaseWait: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis()));
								//throw new ExceptionElementNotHidden("Element is displayed.");
								blnFound = true;
								strMessage = "Element is displayed.";
							} else {
								blnFound = false;
								objDragonfly.objLogger.setLogRow("ElementPleaseWait: gobjWebElement.isDisplayed() = return false Milliseconds Waited = " + (System.currentTimeMillis()));
							}
						}
						if (blnFound == true) {
							return;
						}
					}
				}
			} finally {
				objDragonfly.objLogger.setLogRow("ElementPleaseWait: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				objDragonfly.objSeleniumVariables.gobjWebElement = objDragonfly.objSeleniumVariables.gobjWebElementPleaseWait;
				if (blnFound == true) {
					throw new ExceptionElementNotHidden(strMessage);
				}
			}
		}
	}

	public class ElementSetJavascriptExecutor {
		public ElementSetJavascriptExecutor(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet, ExceptionKeywordNotValid {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementSetJavascriptExecutor " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			String strValueToSelect = "";
			String strAttributeValues = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase();
			String strTagType = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase();
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
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
						objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
						objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						objAction.moveToElement(objDragonfly.objSeleniumVariables.gobjWebElement).doubleClick().build().perform();
						break;
					case "<rightclick>":
						//ToDo add right click code javascript
						Actions action = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						action.contextClick(objDragonfly.objSeleniumVariables.gobjWebElement).build().perform();
						//						Actions action= new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						//						action.contextClick(objDragonfly.objSeleniumVariables.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
					//objDragonfly.objLogger.setLogRow("  ==start==>ElementSetJavascriptExecutor inputtext" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//objDragonfly.objLogger.setLogRow("  ==start==>ElementSetJavascriptExecutor focus" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '';", objDragonfly.objSeleniumVariables.gobjWebElement);
					//objDragonfly.objLogger.setLogRow("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].value = '" + strInputValue + "';", objDragonfly.objSeleniumVariables.gobjWebElement);
					//objDragonfly.objLogger.setLogRow("  ==start==>ElementSetJavascriptExecutor value" + new DateTimestamp().get());
					objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//objDragonfly.objLogger.setLogRow("onchange blur");
					if (strOuterHTML.toLowerCase().contains("onchange")) {
						try {
							//objDragonfly.objLogger.setLogRow("  ==start==>ElementSetJavascriptExecutor strOuterHTML" + new DateTimestamp().get());
							objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
						} catch (WebDriverException e) {
							objDragonfly.objLogger.setLogRow("ElementSetJavascriptExecutor = WebDriverException: " + e.toString());
						}
					}
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", "<on>");
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
								} catch (WebDriverException e) {
									objDragonfly.objLogger.setLogRow("ElementSetJavascriptExecutor = " + e.toString());
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
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
								} catch (WebDriverException e) {
									objDragonfly.objLogger.setLogRow("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					case "<off>":
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == true) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
							if (strOuterHTML.toLowerCase().contains("onchange")) {
								try {
									objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
								} catch (WebDriverException e) {
									objDragonfly.objLogger.setLogRow("ElementSetJavascriptExecutor = " + e.toString());
								}
							}
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					break;
				case "select":
					Select objSelect = new Select(objDragonfly.objSeleniumVariables.gobjWebElement);
					objSelect.getOptions();
					objSelect.selectByVisibleText(strInputValue);
					// set_js
					//					int intOptionsEach;
					//					String strOptions = "";
					//					String[] arrOptions;
					//					strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objDragonfly.objSeleniumVariables.gobjWebElement);
					//					strOptions = strOptions.substring(1);
					//					arrOptions = strOptions.split("\\|");
					//					for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					//						objDragonfly.objLogger.setLogRow("ElementSetJavascriptExecutor: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					//						if (arrOptions[intOptionsEach].toString().equals(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString())) {
					//							blnSet = true;
					//							Select objSelect = new Select(objDragonfly.objSeleniumVariables.gobjWebElement);
					//							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							objSelect.selectByIndex(intOptionsEach);
					//							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							// if (strOuterHTML.toLowerCase().contains("onchange")) {
					//							// try {
					//							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							// } catch (WebDriverException e) {
					//							// objDragonfly.objLogger.setLogRow("ElementSetJavascriptExecutor = " + e.toString());
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
				objDragonfly.objLogger.setLogRow("ElementSetJavascriptExecutor: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementSet {
		public ElementSet(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionVisibleTextNotInSelectList, ExceptionKeywordNotValid {
			objDragonfly.objLogger.setLogRow("  ==start==>elementSet " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("elementSet: " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase());
			long lngStartTime = System.currentTimeMillis();
			String strInputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			String strValueToSelect = "";
			String strAttributeValues = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase();
			String strTagType = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase();
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
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", "<click>");
						objDragonfly.objSeleniumVariables.gobjWebElement.click();
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						objAction.moveToElement(objDragonfly.objSeleniumVariables.gobjWebElement).doubleClick().build().perform();
						break;
					case "<rightclick>":
						//ToDo add right click code
						Actions action = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						action.contextClick(objDragonfly.objSeleniumVariables.gobjWebElement).build().perform();
						//						Actions action= new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						//						action.contextClick(objDragonfly.objSeleniumVariables.gobjWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
					if (objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value").isEmpty() == false) {
						objDragonfly.objSeleniumVariables.gobjWebElement.clear();
					}
					objDragonfly.objSeleniumVariables.gobjWebElement.sendKeys(strInputValue);
					break;
				case "input_radio":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", "<on>");
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please use <on>");
					}
					break;
				case "input_checkbox":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", "<on>");
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
						}
						break;
					case "<off>":
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == true) {
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
						}
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
					}
					break;
				case "select":
					//ToDo add throws UnexpectedTagNameException when element is not a SELECT
					Select objSelect = new Select(objDragonfly.objSeleniumVariables.gobjWebElement);
					objSelect.getOptions();
					//objSelect.selectByVisibleText(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					// set_js
					//					int intOptionsEach;
					//					String strOptions = "";
					//					String[] arrOptions;
					//					strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objDragonfly.objSeleniumVariables.gobjWebElement);
					//					strOptions = strOptions.substring(1);
					//					arrOptions = strOptions.split("\\|");
					//					for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
					//						objDragonfly.objLogger.setLogRow("elementSet: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
					//						if (arrOptions[intOptionsEach].toString().equals(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString())) {
					//							blnSet = true;
					//							Select objSelect = new Select(objDragonfly.objSeleniumVariables.gobjWebElement);
					//							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							objSelect.selectByIndex(intOptionsEach);
					//							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							// if (strOuterHTML.toLowerCase().contains("onchange")) {
					//							// try {
					//							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//							// } catch (WebDriverException e) {
					//							// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
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
					//List<WebElement> objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.tagName(strTagName));
					//Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
					//					b = objSelect.getOptions().iterator();
					//					while (b.hasNext()) {
					//						WebElement row = b.next();
					//						if (strInputValue.equalsIgnoreCase(row.getText())) {
					//						}
					//					}
					break;
				case "table":
					break;
				case "alert":
					switch (strAttributeValues) {
					case "edit":
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().sendKeys(strInputValue);
						break;
					case "accept":
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().accept();
						break;
					case "dismiss":
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().dismiss();
						break;
					default:
						throw new ExceptionKeywordNotValid("The keyword " + strAttributeValues + " for the click event is not valid! Please us one of the following <edit>, <accept>, <dismiss>");
					}
					break;
				default:
					throw new ExceptionElementTagNameNotSupported("elementSet: Element tag {" + strTagType + "} not supported");
				}
			} finally {
				objDragonfly.objLogger.setLogRow("elementSet: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementSetSync {
		public ElementSetSync(Dragonfly objDragonfly, boolean blnJavascriptExecutor) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementSetSync " + new DateTimestamp().get());
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
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strOutputValue", objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						if (objDragonfly.objSeleniumVariables.gobjWebElement != null) {
							strOuterHTML = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("outerHTML");
							objDragonfly.objLogger.setLogRow("elementSetSync: " + strOuterHTML);
							objDragonfly.objLogger.setLogRow("elementSetSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
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
					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAssert").toString().toLowerCase()) {
					case "off":
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
						if (blnSet == false) {
							new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
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
							objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
							new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
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
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
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
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
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
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
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
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						blnStatus = true;
						break;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported | ExceptionKeywordNotValid e) {
					blnExit = true;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionVisibleTextNotInSelectList e) {
					blnSet = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnAssert = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnSet = false;
					blnSetSync = false;
					blnAssert = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotSet e) {
					blnSet = false;
					blnAssert = false;
				} catch (ExceptionElementNotDisabled e) {
					blnAssert = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionAlertNotComplete | ExceptionDoPostBackNotComplete | ExceptionJQueryAjaxNotComplete | ExceptionJQueryAnimationNotComplete | ExceptionAngularJsNotComplete | ExceptionPleaseWaitNotComplete e) {
					blnSetSync = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnAssert = false;
					blnEnabled = false;
					blnFound = false;
					blnSet = false;
					blnSetSync = false;
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementSetSync", "set", lngTimeStart) == true) {
						if (blnStatus == false) {
							new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						}
						return;
					}
				}
			}
		}
	}

	public class SyncFinally {
		public Boolean run(Dragonfly objDragonfly, Boolean blnExit, Boolean blnStatus, Boolean blnFound, String strMethodeName, String strAction, Long lngTimeStart) {
			if (blnExit == true) {
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "fail");
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnExitOnFail", "true");
			} else {
				if (blnStatus == true) {
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "pass");
					blnExit = true;
				} else if (blnStatus == false) {
					if ((int) (System.currentTimeMillis() - lngTimeStart) <= Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intMillisecondsToWait").toString())) {
						if (blnFound == false) {
							blnExit = false;
						}
					} else {
						if (Boolean.parseBoolean(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("blnOptional").toString()) == true) {
							objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "warning");
							blnExit = true;
						} else {
							objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "fail");
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

	//	public static ExpectedCondition<Boolean> waitForAngularFinishProcessing(Dragonfly objDragonfly) {
	//		objDragonfly.objLogger.setLogRow("  ==start==>waitForAngularFinishProcessing " + new DateTimestamp().get());
	//		return new ExpectedCondition<Boolean>() {
	//			@Override
	//			public Boolean apply(WebDriver driver) {
	//				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)").toString());
	//			}
	//		};
	//	}
	public class WaitForAngularRequestsToFinish {
		public WaitForAngularRequestsToFinish(Dragonfly objDragonfly, JavascriptExecutor objDriver) {
			objDragonfly.objLogger.setLogRow("  ==start==>waitForAngularRequestsToFinish " + new DateTimestamp().get());
			objDriver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
		}
	}

	public class WaitForReadyState {
		public boolean run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>waitForReadyState " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("waitForReadyState: document.readyState Milliseconds Waited = " + ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return document.readyState"));
			return false;
		}
	}

	public class ElementSetSyncComplete {
		public ElementSetSyncComplete(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionAlertNotComplete, ExceptionDoPostBackNotComplete, ExceptionJQueryAjaxNotComplete, ExceptionJQueryAnimationNotComplete, ExceptionAngularJsNotComplete, ExceptionPleaseWaitNotComplete {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementSetSyncComplete " + new DateTimestamp().get());
			long lngTimeStart = System.currentTimeMillis();
			try {
				if (objDragonfly.objSetSyncVariables.gblnSyncPleaseWait == false) {
					///SyncPleaseWait
					new SyncPleaseWait(objDragonfly);
					objDragonfly.objSetSyncVariables.gblnSyncPleaseWait = true;
				}
				//				if (objDragonfly.objSetSyncVariables.gblnSyncAlert == false) {
				//					///SyncAlert
				//					new SyncAlert(objDragonfly);
				//					objDragonfly.objSetSyncVariables.gblnSyncAlert = true;
				//				}
				if (objDragonfly.objSetSyncVariables.gblnSyncWaitForReadyState == false) {
					///SyncWaitForReadyState
					new SyncWaitForReadyState(objDragonfly);
					objDragonfly.objSetSyncVariables.gblnSyncWaitForReadyState = true;
				}
				if (objDragonfly.objSetSyncVariables.gblnSyncDoPostBack == false) {
					///SyncDoPostBack
					new SyncDoPostBack(objDragonfly, strOuterHTML);
					objDragonfly.objSetSyncVariables.gblnSyncDoPostBack = true;
				}
				if (objDragonfly.objSetSyncVariables.gblnSyncJQueryAjax == false) {
					///SyncJQueryAjax
					new SyncJQueryAjax(objDragonfly);
					objDragonfly.objSetSyncVariables.gblnSyncJQueryAjax = true;
				}
				if (objDragonfly.objSetSyncVariables.gblnSyncJQueryAnimation == false) {
					///SyncJQueryAnimation
					new SyncJQueryAnimation(objDragonfly);
					objDragonfly.objSetSyncVariables.gblnSyncJQueryAnimation = true;
				}
				if (objDragonfly.objSetSyncVariables.gblnSyncAngularJs == false) {
					///SyncAngularJs
					new SyncAngularJs(objDragonfly);
					objDragonfly.objSetSyncVariables.gblnSyncAngularJs = true;
				}
			} finally {
				objDragonfly.objLogger.setLogRow("ElementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
			}
		}
	}

	public class SyncPleaseWait {
		public SyncPleaseWait(Dragonfly objDragonfly) throws ExceptionDoPostBackNotComplete {
			long lngStartTime = System.currentTimeMillis();
			objDragonfly.objLogger.setLogRow("  ==start==>SyncPleaseWait " + new DateTimestamp().get());
			try {
				new ElementPleaseWait(objDragonfly);
			} catch (ExceptionElementNotHidden e1) {
				objDragonfly.objLogger.setLogRow("SyncPleaseWait: ExceptionElementNotHidden = " + e1.toString());
				throw new ExceptionDoPostBackNotComplete("");
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("SyncPleaseWait: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("SyncPleaseWait: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SyncAlert {
		public SyncAlert(Dragonfly objDragonfly) throws ExceptionAlertNotComplete {
			objDragonfly.objLogger.setLogRow("  ==start==>SyncAlert " + new DateTimestamp().get());
			if (new AlertFind().run(objDragonfly) == true) {
				throw new ExceptionAlertNotComplete("");
			}
		}
	}

	public class SyncWaitForReadyState {
		public SyncWaitForReadyState(Dragonfly objDragonfly) {
			long lngStartTime = System.currentTimeMillis();
			objDragonfly.objLogger.setLogRow("  ==start==>SyncWaitForReadyState " + new DateTimestamp().get());
			try {
				new WaitForReadyState().run(objDragonfly);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("SyncPleaseWait: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("SyncPleaseWait: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SyncDoPostBack {
		public SyncDoPostBack(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionDoPostBackNotComplete {
			objDragonfly.objLogger.setLogRow("  ==start==>SyncDoPostBack " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnEventTarget = false;
			if (strOuterHTML.contains("__doPostBack")) {
				try {
					objDragonfly.objLogger.setLogRow("SyncDoPostBack: __EVENTTARGET value = " + objDragonfly.objSeleniumVariables.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
					blnEventTarget = !objDragonfly.objSeleniumVariables.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
					if (blnEventTarget == true) {
						throw new ExceptionDoPostBackNotComplete("");
					}
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("SyncDoPostBack: Exception = " + e.toString());
				} finally {
					objDragonfly.objLogger.setLogRow("SyncDoPostBack: blnEventTarget = " + blnEventTarget + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				}
			}
		}
	}

	public class SyncJQueryAjax {
		public SyncJQueryAjax(Dragonfly objDragonfly) throws ExceptionJQueryAjaxNotComplete {
			objDragonfly.objLogger.setLogRow("  ==start==>SyncJQueryAjax " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnJquery = false;
			long lngJqueryActive = 0;
			try {
				blnJquery = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJquery == true) {
					lngJqueryActive = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (jQuery.active);");
					objDragonfly.objLogger.setLogRow("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive);
					if (lngJqueryActive > 0) {
						throw new ExceptionJQueryAjaxNotComplete("");
					}
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("SyncJQueryAjax: JqueryActive Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SyncJQueryAnimation {
		public SyncJQueryAnimation(Dragonfly objDragonfly) throws ExceptionJQueryAnimationNotComplete {
			objDragonfly.objLogger.setLogRow("  ==start==>SyncJQueryAnimation " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			long lngElementsAnimated = 0;
			boolean blnJqueryExist = false;
			try {
				blnJqueryExist = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.jQuery != null);");
				if (blnJqueryExist == true) {
					lngElementsAnimated = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return $(\":animated\").length");
				}
				if (lngElementsAnimated > 0) {
					throw new ExceptionJQueryAnimationNotComplete("");
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("SyncJQueryAnimation: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("SyncJQueryAnimation: lngElementsAnimated = " + lngElementsAnimated + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class SyncAngularJs {
		public SyncAngularJs(Dragonfly objDragonfly) throws ExceptionAngularJsNotComplete {
			objDragonfly.objLogger.setLogRow("  ==start==>SyncAngularJs " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			boolean blnAngularJs = false;
			long lngAngularJsInjectorActive = 0;
			try {
				blnAngularJs = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.angular != null);");
				objDragonfly.objLogger.setLogRow("SyncAngularJs: = " + blnAngularJs);
				lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
				if (lngAngularJsInjectorActive > 0) {
					throw new ExceptionAngularJsNotComplete("");
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("SyncAngularJs: AngularJS Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("SyncAngularJs: lngAngularJsInjectorActive = " + lngAngularJsInjectorActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementDragSync {
		public ElementDragSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementDragSync " + new DateTimestamp().get());
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
						objDragonfly.objLogger.setLogRow("elementSetSync: elementFind over");
						if (objDragonfly.objSeleniumVariables.gobjWebElement != null) {
							strOuterHTML = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("outerHTML");
							objDragonfly.objLogger.setLogRow("elementDragSync: outerHTML = " + strOuterHTML);
							objDragonfly.objLogger.setLogRow("elementDragSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						objDragonfly.objLogger.setLogRow("elementDragSync: strOuterHTML over");
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
					objDragonfly.objSeleniumVariables.gobjWebElementDrag = objDragonfly.objSeleniumVariables.gobjWebElement;
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.objLogger.setLogRow("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("elementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					//} catch (ExceptionElementTagNameNotSupported e) {
					//objDragonfly.objLogger.setLogRow("elementSetSync - " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					//	blnExit = true;
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementDragSync", "drag", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
					}
				}
			}
		}
	}

	public class ElementDropSync {
		public ElementDropSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementDropSync " + new DateTimestamp().get());
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
						objDragonfly.objLogger.setLogRow("elementDropSync: elementFind over");
						if (objDragonfly.objSeleniumVariables.gobjWebElement != null) {
							strOuterHTML = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("outerHTML");
							objDragonfly.objLogger.setLogRow("elementDropSync: outerHTML = " + strOuterHTML);
							objDragonfly.objLogger.setLogRow("elementDropSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						objDragonfly.objLogger.setLogRow("elementDropSync: strOuterHTML over");
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
					objDragonfly.objSeleniumVariables.gobjWebElementDrop = objDragonfly.objSeleniumVariables.gobjWebElement;
					//Actions actions = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					//actions.dragAndDrop(objDragonfly.objSeleniumVariables.gobjWebElementDrag, objDragonfly.objSeleniumVariables.gobjWebElementDrop).perform();
					//				Actions action = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					//				Action dragDrop = action.dragAndDrop(gobjWebElementDrag, objDragonfly.objSeleniumVariables.gobjWebElementDrop).build();
					//				dragDrop.perform();
					Actions objActions = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					Action objDragAndDrop = objActions.clickAndHold(objDragonfly.objSeleniumVariables.gobjWebElementDrag).moveToElement(objDragonfly.objSeleniumVariables.gobjWebElementDrop).release(objDragonfly.objSeleniumVariables.gobjWebElementDrop).build();
					objDragAndDrop.perform();
					//				Actions action = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					//				action.dragAndDrop(objDragonfly.objSeleniumVariables.gobjWebElementDrag, objDragonfly.objSeleniumVariables.gobjWebElementDrop).build().perform();
					new SleepMilliseconds(objDragonfly, 10000);
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("elementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementDropSync", "drop", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					}
				}
			}
		}
	}

	public class ElementVerifyNotValue {
		public String run(Dragonfly objDragonfly) throws ExceptionValueMatched, ExceptionElementTagNameNotSupported {
			objDragonfly.objLogger.setLogRow("  ==start==>elementVerifyValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			try {
				strGetValue = new ElementGet().run(objDragonfly);
				strActualValue = new VerifyNotMatch().run(objDragonfly, strGetValue, strValueExpected);
			} finally {
				objDragonfly.objLogger.setLogRow("elementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	public class ElementVerifyNotValueSync {
		public ElementVerifyNotValueSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementVerifyNotValueSync " + new DateTimestamp().get());
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
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnVisible = false;
					blnVerifiedNot = false;
					blnStatus = false;
					objDragonfly.objLogger.setLogRow("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					objDragonfly.objLogger.setLogRow("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					blnExit = true;
				} catch (ExceptionValueMatched e) {
					blnVerifiedNot = false;
					blnStatus = false;
					objDragonfly.objLogger.setLogRow("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					blnVerifiedNot = false;
					blnStatus = false;
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementVerifyNotValueSync", "verify_not", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnVisible = false;
						blnVerifiedNot = false;
					}
				}
			}
		}
	}

	public class VerifyNotMatch {
		public String run(Dragonfly objDragonfly, String strActual, String strExpected) throws ExceptionValueMatched {
			objDragonfly.objLogger.setLogRow("  ==start==>VerifyNotMatch " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strMatchedValue = "";
			try {
				if (strExpected.toLowerCase().startsWith("re:")) {
					String strPattern = strExpected.substring(3);
					try {
						strMatchedValue = new RegularExpressionMatch().run(objDragonfly, strPattern, strActual);
						throw new ExceptionValueMatched("VerifyNotMatch: Exception strMatchedValue = {" + strMatchedValue + "}");
					} catch (Exception e) {
						return strActual;
					}
				} else {
					if (strExpected.equals(strActual)) {
						throw new ExceptionValueMatched("VerifyNotMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
					} else {
						return strActual;
					}
				}
			} finally {
				objDragonfly.objLogger.setLogRow("VerifyNotMatch: finally strExpected = {" + strExpected + "} strActual = {" + strActual + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementVerifyValue {
		public String run(Dragonfly objDragonfly) throws ExceptionValueNotMatched, ExceptionElementTagNameNotSupported {
			objDragonfly.objLogger.setLogRow("  ==start==>elementVerifyValue " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			try {
				strGetValue = new ElementGet().run(objDragonfly);
				strActualValue = new VerifyMatch().run(objDragonfly, strGetValue, strValueExpected);
			} finally {
				objDragonfly.objLogger.setLogRow("elementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
			}
			return strActualValue;
		}
	}

	public class ElementVerifyValueSync {
		public ElementVerifyValueSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementVerifyValueSync " + new DateTimestamp().get());
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
					blnStatus = false;
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					blnExit = true;
				} catch (ExceptionValueNotMatched e) {
					blnVerified = false;
					blnStatus = false;
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
					blnVerified = false;
					blnStatus = false;
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementVerifyValueSync", "verify", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnVisible = false;
						blnVerified = false;
					}
				}
			}
		}
	}

	public class VerifyMatch {
		public String run(Dragonfly objDragonfly, String strActual, String strExpected) throws ExceptionValueNotMatched {
			objDragonfly.objLogger.setLogRow("  ==start==>VerifyMatch " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (strExpected.toLowerCase().startsWith("re:")) {
					String strPattern = strExpected.substring(3);
					return new RegularExpressionMatch().run(objDragonfly, strPattern, strActual);
				} else {
					if (strExpected.equals(strActual)) {
						return strActual;
					} else {
						throw new ExceptionValueNotMatched("VerifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
					}
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("VerifyMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("VerifyMatch: Exception " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("VerifyMatch: finally strActual = {" + strActual + "} strExpected = {" + strExpected + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class RegularExpressionMatch {
		public String run(Dragonfly objDragonfly, String strPattern, String strActualValue) throws ExceptionValueNotMatched {
			Long lngStartTime = System.currentTimeMillis();
			objDragonfly.objLogger.setLogRow("  ==start==>regularExpressionMatch " + new DateTimestamp().get());
			String strMatchedString = "";
			try {
				Matcher objMatcher = Pattern.compile(strPattern).matcher(strActualValue);
				objMatcher.matches();
				strMatchedString = objMatcher.group(0);
				return strMatchedString;
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("RegularExpressionMatch: Exception " + e.toString());
				throw new ExceptionValueNotMatched("RegularExpressionMatch: Exception " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("RegularExpressionMatch: strMatchedString = {" + strMatchedString + "} strPattern = {" + strPattern + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class Sleep {
		public Sleep(Dragonfly objDragonfly) {
			new SleepMilliseconds(objDragonfly, Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString()));
		}
	}

	public class SleepSync {
		public SleepSync(Dragonfly objDragonfly) {
			Long lngTimeStart = System.currentTimeMillis();
			new Sleep(objDragonfly);
			new StepDuration(objDragonfly, "SleepSync", lngTimeStart, "sleep");
		}
	}

	public class StepDuration {
		public StepDuration(Dragonfly objDragonfly, String strMethodName, Long lngTimeStart, String strStepType) {
			objDragonfly.objLogger.setLogRow("  ==start==>StepDuration " + new DateTimestamp().get());
			Long lngTimeEnd = System.currentTimeMillis();
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepExpected", new StepCreateExpected().run(objDragonfly));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepActual", new StepCreateActual().run(objDragonfly, strStepType));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStartTimestamp", new DateTimeFormat().set(objDragonfly, lngTimeStart));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strEndTimestamp", new DateTimeFormat().set(objDragonfly, lngTimeEnd));
			objDragonfly.objLogger.setLogRow("StepDuration: " + strMethodName + " strStatus = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strStatus").toString() + " Milliseconds Waited = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strStepDuration").toString());
		}
	}

	public class ProcessKillInternetExplorer {
		public void run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ProcessKillInternetExplorer " + new DateTimestamp().get());
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(objDragonfly, 1000);
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
		}
	}

	public class InternetExplorerProcessKill {
		public InternetExplorerProcessKill(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>internetExplorerProcessKill " + new DateTimestamp().get());
			DesiredCapabilities desiredCapabilities = null;
			new WindowsProcessKill(objDragonfly, "taskkill /F /IM iexplore.exe");
			new SleepMilliseconds(objDragonfly, 1000);
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setJavascriptEnabled(true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			objDragonfly.objSeleniumVariables.gobjWebDriver = new InternetExplorerDriver(desiredCapabilities);
			objDragonfly.objSeleniumVariables.gobjWebDriver.get("about:blank");
			objDragonfly.objSeleniumVariables.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
			// objDragonfly.objSeleniumVariables.gobjWebDriver.navigate().to(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
			// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize();
			// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			// // objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
			objDragonfly.objSeleniumVariables.gobjWebDriver.close();
			objDragonfly.objSeleniumVariables.gobjWebDriver.quit();
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
	public class CommandLineExecution {
		public CommandLineExecution(Dragonfly objDragonfly) throws Exception {
			objDragonfly.objLogger.setLogRow("  ==start==>commandLineExecution " + new DateTimestamp().get());
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
	}

	public class ClearMyTracksByProcessCookies {
		public ClearMyTracksByProcessCookies(Dragonfly objDragonfly) throws Exception {
			objDragonfly.objLogger.setLogRow("  ==start==>clearMyTracksByProcessCookies " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	public class ClearMyTracksByProcessCache {
		public ClearMyTracksByProcessCache(Dragonfly objDragonfly) throws Exception {
			objDragonfly.objLogger.setLogRow("  ==start==>clearMyTracksByProcessCache " + new DateTimestamp().get());
			String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
			Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
			objProcess.waitFor();
		}
	}

	public class ClipboardGet {
		public String run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ClipboardGet " + new DateTimestamp().get());
			String strClipboardData = "";
			try {
				strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				objDragonfly.objLogger.setLogRow("ClipboardGet: strClipboardData = " + strClipboardData);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("ClipboardGet: Exception = " + e.toString());
			}
			return strClipboardData;
		}
	}

	public class ElementFind {
		public ElementFind(Dragonfly objDragonfly) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			objDragonfly.objLogger.setLogRow("  ==start==>elementFind " + new DateTimestamp().get());
			if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strTagType", "alert");
				if (new AlertFind().run(objDragonfly) == true) {
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strHighlightArea", "alert");
					return;
				} else {
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strHighlightArea", "screen");
					throw new ExceptionElementNotFound("Alert popup not found!");
				}
			}
			if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("title")) {
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strTagType", "title");
				return;
			}
			String strWindowHandle = "";
			Object[] arrHandles = objDragonfly.objSeleniumVariables.gobjWebDriver.getWindowHandles().toArray();
			for (int intWindowHandlesEach = arrHandles.length - 1; intWindowHandlesEach >= 0; intWindowHandlesEach--) {
				objDragonfly.objLogger.setLogRow("elementFind: arrHandles[" + intWindowHandlesEach + "] = " + arrHandles[intWindowHandlesEach].toString());
			}
			for (int intHandlesEach = arrHandles.length - 1; intHandlesEach >= 0; intHandlesEach--) {
				try {
					strWindowHandle = arrHandles[intHandlesEach].toString();
					objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().window(strWindowHandle);
					objDragonfly.objSeleniumVariables.gobjWebDriverCoordinates = objDragonfly.objSeleniumVariables.gobjWebDriver;
					new CoordinatesBrowserInner(objDragonfly);
					List<Integer> arrRouteOriginal = new ArrayList<Integer>();
					new ElementFindFramesSearch().run(objDragonfly, arrRouteOriginal);
					if (objDragonfly.objSeleniumVariables.gobjWebElement != null) {
						//objDragonfly.objLogger.setLogRow("elementFind: objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
						//objDragonfly.objLogger.setLogRow("elementFind: objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle());
						//objDragonfly.objLogger.setLogRow("ElementFindFramesSearch: objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle());
						//objDragonfly.objLogger.setLogRow("ElementFindFramesSearch: objDragonfly.objSeleniumVariables.gobjWebDriver.getCurrentUrl = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getCurrentUrl());
						//objDragonfly.objLogger.setLogRow("ElementFindFramesSearch: objDragonfly.objSeleniumVariables.gobjWebDriver.getWindowHandle = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getWindowHandle());
						//objDragonfly.objLogger.setLogRow("ElementFindFramesSearch objDragonfly.objSeleniumVariables.gobjWebDriver.getPageSource = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getPageSource());
						return;
					}
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("elementFind: Exception = " + e.toString());
				}
			}
			throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
		}
	}

	public class ElementFindFramesSearch {
		public boolean run(Dragonfly objDragonfly, List<Integer> arrFramePath) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementFindFramesSearch " + new DateTimestamp().get());
			boolean blnReturn;
			int intMaximumDepth = 100;
			String strTagName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase();
			String strAttributeNames = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeNames").toString();
			String strAttributeValues = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString();
			try {
				new ElementFindBy(objDragonfly, strAttributeNames, strAttributeValues, strTagName);
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strCurrentWindowHandle", objDragonfly.objSeleniumVariables.gobjWebDriver.getWindowHandle());
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("input")) {
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strType").toString().length() == 0) {
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strType", objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("type"));
					}
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strTagType", "input_" + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strType").toString());
				} else {
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strTagType", objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString());
				}
				objDragonfly.objLogger.setLogRow("ElementFindFramesSearch: gobjWebElement outerHTML = " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("outerHTML"));
				return true;
			} catch (ExceptionElementNotFound | ExceptionMultipleElementsFound | StaleElementReferenceException e) {
				blnReturn = false;
				objDragonfly.objLogger.setLogRow("ElementFindFramesSearch: Exception = " + e.toString());
			}
			if (arrFramePath.size() < intMaximumDepth) {
				int intFramesCount = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.tagName("frame")).size();
				for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
					try {
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().frame(intFramesEach);
						List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
						arrFramePathNew.add(intFramesEach);
						blnReturn = new ElementFindFramesSearch().run(objDragonfly, arrFramePathNew);
						if (blnReturn == true) {
							return true;
						}
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().defaultContent();
						for (int intFramesPathEach : arrFramePath)
							objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().frame(intFramesPathEach);
					} catch (NoSuchFrameException error) {
						blnReturn = false;
						objDragonfly.objLogger.setLogRow("ElementFindFramesSearch: NoSuchFrameException = " + error.toString());
						break;
					} catch (Exception error) {
						objDragonfly.objLogger.setLogRow("ElementFindFramesSearch: Exception = " + error.toString());
					}
				}
			}
			return blnReturn;
		}
	}

	public class ElementFindBy {
		public ElementFindBy(Dragonfly objDragonfly, String strAttributeNames, String strAttributeValues, String strTagName) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementFindBy " + new DateTimestamp().get());
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
				objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.xpath(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("id")) {
				objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.id(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("name")) {
				objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.name(strAttributeValues));
			} else if (strAttributeNames.toLowerCase().equals("class")) {
				objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.className(strAttributeValues));
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
						if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
							strXpathAttributesTemp = "contains(text()" + ", '" + arrAttributeValues[intAttributeEach].substring(3) + "')";
						} else {
							strXpathAttributesTemp = "text()='" + arrAttributeValues[intAttributeEach] + "' ";
						}
						break;
					default:
						if (arrAttributeNames[intAttributeEach].toLowerCase().equals("type")) {
							objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strType", arrAttributeValues[intAttributeEach]);
						}
						if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
							strXpathAttributesTemp = "contains(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + arrAttributeValues[intAttributeEach].substring(3).toLowerCase() + "')";
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
				objDragonfly.objLogger.setLogRow("ElementFindBy: strXpath = " + strXpath);
				objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.xpath(strXpath));
			}
			switch (objWebElementCollection.size()) {
			case 0:
				throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
			case 1:
				objDragonfly.objSeleniumVariables.gobjWebElement = objWebElementCollection.get(0);
				break;
			default:
				if (strIndexKeyword.equals("<last>")) {
					objDragonfly.objSeleniumVariables.gobjWebElement = objWebElementCollection.get(objWebElementCollection.size() - 1);
					break;
				} else if (strIndexKeyword.equals("<random>")) {
					int intRandomElement = new RandomNumberRange().run(objDragonfly, 0, objWebElementCollection.size() - 1);
					objDragonfly.objSeleniumVariables.gobjWebElement = objWebElementCollection.get(intRandomElement);
					break;
				} else {
					objDragonfly.objLogger.setLogRow("ElementFindBy: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
					Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
					while (objWebElementEach.hasNext()) {
						WebElement row = objWebElementEach.next();
						objDragonfly.objLogger.setLogRow("outerHTML:=  " + row.getAttribute("outerHTML"));
					}
					throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
				}
			}
		}
	}

	public class ElementJavascriptExecutorXPath {
		public String run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementJavascriptExecutorXPath " + new DateTimestamp().get());
			return (String) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", objDragonfly.objSeleniumVariables.gobjWebElement);
		}
	}

	public class ElementJavascriptExecutorGetElementsByTagName {
		public String run(Dragonfly objDragonfly) {
			return null;
			//long lngStartTimegetElementsByTagName2 = System.currentTimeMillis();
			//List<WebElement> objCollectionJS2 = (List<WebElement>) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return document.getElementsByTagName('" + strTagName + "');");
			//objDragonfly.objLogger.setLogRow("ElementJavascriptExecutorGetElementsByTagName objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
			//if (objCollectionJS2.size() > 0) {
			//	long lngStartTimeByXpath = System.currentTimeMillis();
			//}
		}
	}

	public class CoordinatesAlert {
		public CoordinatesAlert(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>coordinatesAlert " + new DateTimestamp().get());
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
				switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
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
				switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
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
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementScreenX", Integer.toString(intWinPosX));
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementScreenY", Integer.toString(intWinPosY));
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementWidth", Integer.toString(intWinPosWidth));
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementHeight", Integer.toString(intWinPosHeight));
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("coordinatesAlert: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("coordinatesAlert: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class CoordinatesBrowserInner {
		public CoordinatesBrowserInner(Dragonfly objDragonfly) throws WebDriverException {
			objDragonfly.objLogger.setLogRow("  ==start==>CoordinatesBrowserInner " + new DateTimestamp().get());
			//objDragonfly.objSeleniumVariables.gobjWebDriverCoordinates = objDragonfly.objSeleniumVariables.gobjWebDriver;
			//objDragonfly.objSeleniumVariables.gobjWebDriverCoordinates.switchTo().defaultContent();
			long lngBrowserInnerWidth = 0;
			long lngBrowserInnerHeight = 0;
			try {
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriverCoordinates).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriverCoordinates).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			} catch (WebDriverException e) {
				objDragonfly.objLogger.setLogRow("CoordinatesBrowserInner: WebDriverException = " + e.toString());
				throw new WebDriverException("WebDriverException returned");
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("CoordinatesBrowserInner: Exception = " + e.toString());
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriverCoordinates).executeScript("return document.body.offsetWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriverCoordinates).executeScript("return document.body.offsetHeight;");
			}
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
		}
	}

	public class CoordinatesElement {
		public CoordinatesElement(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>CoordinatesElement " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				//new CoordinatesBrowserInner(objDragonfly);
				int intScrollbar = 0;
				Point objWebDriverPoint = objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().getPosition();
				int intBrowserOuterX = objWebDriverPoint.x;
				int intBrowserOuterY = objWebDriverPoint.y;
				Dimension objWebDriverDimension = objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().getSize();
				int intBrowserOuterWidth = objWebDriverDimension.width;
				int intBrowserOuterHeight = objWebDriverDimension.height;
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserOuterX", Integer.toString(intBrowserOuterX));
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserOuterY", Integer.toString(intBrowserOuterY));
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserOuterWidth", Integer.toString(intBrowserOuterWidth));
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserOuterHeight", Integer.toString(intBrowserOuterHeight));
				if (objDragonfly.objSeleniumVariables.gobjWebElement != null) {
					Coordinates objElementCoordinates = ((Locatable) objDragonfly.objSeleniumVariables.gobjWebElement).getCoordinates();
					Point objElementPoint = objElementCoordinates.inViewPort();
					Dimension objElementDimension = objDragonfly.objSeleniumVariables.gobjWebElement.getSize();
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementX", Integer.toString(objElementPoint.x));
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementY", Integer.toString(objElementPoint.y));
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementWidth", Integer.toString(objElementDimension.width));
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementHeight", Integer.toString(objElementDimension.height));
				}
				objDragonfly.objLogger.setLogRow("CoordinatesElement: objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey("intElementX"));
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey("intElementX")) {
					int intBrowserInnerWidth = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intBrowserInnerWidth").toString());
					int intBrowserInnerHeight = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intBrowserInnerHeight").toString());
					int intElementX = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementX").toString());
					int intElementY = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementY").toString());
					int intWindowBorder = (int) ((intBrowserOuterWidth - intBrowserInnerWidth - intScrollbar) / 2);
					int intElementScreenX = ((intBrowserOuterX + intElementX) + intWindowBorder);
					int intElementScreenY = (int) ((intBrowserOuterY + intElementY) + (intBrowserOuterHeight - intBrowserInnerHeight) - intWindowBorder);
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementScreenX", Integer.toString(intElementScreenX));
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementScreenY", Integer.toString(intElementScreenY));
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("CoordinatesElement: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("  ==end==>CoordinatesElement " + new DateTimestamp().get());
				objDragonfly.objLogger.setLogRow("CoordinatesElement: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementVisible {
		public ElementVisible(Dragonfly objDragonfly) throws ExceptionElementNotVisible {
			// TODO elementVisible add check for class and css, commented code needs to be tested
			objDragonfly.objLogger.setLogRow("  ==start==>elementVisible " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			Boolean blnVisible = false;
			try {
				// TODO Alert complete
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("title")) {
					blnVisible = true;
					return;
				}
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					if (new AlertFind().run(objDragonfly) == true) {
						blnVisible = true;
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strHighlightArea", "alert");
						new CoordinatesAlert(objDragonfly);
						return;
					} else {
						throw new ExceptionElementNotVisible("Alert popup was not found.");
					}
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed()) {
					new CoordinatesElement(objDragonfly);
					blnVisible = true;
					return;
					// if (objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey("intElementWidth")) {
					// int intElementWidth = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementWidth").toString());
					// int intElementHeight = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementHeight").toString());
					// objDragonfly.objLogger.setLogRow("elementVisible intElementWidth = " + intElementWidth);
					// objDragonfly.objLogger.setLogRow("elementVisible intElementHeight = " + intElementHeight);
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
				objDragonfly.objLogger.setLogRow("elementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementVisibleSync {
		public ElementVisibleSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementVisibleSync " + new DateTimestamp().get());
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
					objDragonfly.objLogger.setLogRow("ElementVisibleSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementVisibleSync", "syncvisible", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnVisible = false;
					}
				}
			}
		}
	}

	public class ElementHidden {
		public ElementHidden(Dragonfly objDragonfly) throws ExceptionElementNotHidden {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementHidden " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					if (new AlertFind().run(objDragonfly) == false) {
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strHighlightArea", "screen");
						return;
					} else {
						throw new ExceptionElementNotHidden("Alert popup was not hidden.");
					}
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed() == false) {
					return;
				} else {
					objDragonfly.objLogger.setLogRow("ElementHidden: gobjWebElement.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					throw new ExceptionElementNotHidden("Element is displayed.");
				}
			} catch (NullPointerException | WebDriverException e) {
				objDragonfly.objLogger.setLogRow("ElementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				return;
			} finally {
				objDragonfly.objLogger.setLogRow("ElementHidden: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementHiddenSync {
		public ElementHiddenSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementHiddenSync " + new DateTimestamp().get());
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
					objDragonfly.objLogger.setLogRow("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnHidden = false;
					objDragonfly.objLogger.setLogRow("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnHidden = false;
					objDragonfly.objLogger.setLogRow("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnFound = false;
					blnHidden = false;
					objDragonfly.objLogger.setLogRow("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementHiddenSync", "synchidden", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnHidden = false;
					}
				}
			}
		}
	}

	public class ElementEnabled {
		public ElementEnabled(Dragonfly objDragonfly) throws ExceptionElementNotEnabled {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementEnabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					if (new AlertFind().run(objDragonfly) == true) {
						return;
					} else {
						throw new ExceptionElementNotEnabled("Alert popup was not found.");
					}
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isEnabled()) {
					return;
				} else {
					throw new ExceptionElementNotEnabled("ElementEnabled - Element is not enabled");
				}
			} finally {
				objDragonfly.objLogger.setLogRow("ElementEnabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementEnabledSync {
		public ElementEnabledSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementEnabledSync " + new DateTimestamp().get());
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
					objDragonfly.objLogger.setLogRow("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("ElementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementEnabledSync", "syncenabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnEnabled = false;
					}
				}
			}
		}
	}

	public class ElementDisabled {
		public ElementDisabled(Dragonfly objDragonfly) throws ExceptionElementNotDisabled {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementDisabled " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			try {
				//			if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				//				if (alertFind() == true) {
				//					return true;
				//				} else {
				//					throw new ExceptionElementNotDisabled("Alert popup was not found.");
				//				}
				//			}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isEnabled()) {
					throw new ExceptionElementNotDisabled("ElementDisabled - Element is not disabled");
				} else {
					return;
				}
			} finally {
				objDragonfly.objLogger.setLogRow("ElementDisabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public class ElementDisabledSync {
		public ElementDisabledSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementDisabledSync " + new DateTimestamp().get());
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
					objDragonfly.objLogger.setLogRow("elementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotDisabled e) {
					blnDisabled = false;
					objDragonfly.objLogger.setLogRow("elementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementDisabledSync", "syncdisabled", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnDisabled = false;
					}
				}
			}
		}
	}

	public class ElementGet {
		public String run(Dragonfly objDragonfly) throws ExceptionElementTagNameNotSupported {
			objDragonfly.objLogger.setLogRow("  ==start==>elementGet " + new DateTimestamp().get());
			AutoItX objAutoIt = objDragonfly.objAutoItSetObject.getObject();
			switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
			case "title":
				return objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle();
			case "img":
				return objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("src");
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				return objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value").trim();
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
				return objDragonfly.objSeleniumVariables.gobjWebElement.getText();
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
			case "input_textarea":
				return objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value");
			case "input_radio":
			case "input_checkbox":
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
					return "<off>";
				} else {
					return "<on>";
				}
			case "select":
				JavascriptExecutor objExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
				return ((String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", objDragonfly.objSeleniumVariables.gobjWebElement)).trim();
			case "table":
				return objDragonfly.objSeleniumVariables.gobjWebElement.getText();
			case "alert":
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase().equals("title")) {
					return objAutoIt.winGetTitle("[ACTIVE]");
				} else {
					return objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().getText();
				}
			default:
				throw new ExceptionElementTagNameNotSupported("Element tag not supported");
			}
		}
	}

	public class ElementGetWorking {
		public String run(Dragonfly objDragonfly) throws ExceptionElementTagNameNotSupported {
			objDragonfly.objLogger.setLogRow("  ==start==>elementGet " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
			AutoItX objAutoIt = objDragonfly.objAutoItSetObject.getObject();
			String strElementGet = "";
			switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
			case "title":
				strElementGet = objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle();
				break;
			case "img":
				strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("src");
				break;
			case "input_button":
			case "input_submit":
			case "input_reset":
			case "input_image":
			case "button":
				strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value").trim();
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
			case "li":
				strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getText();
				break;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
			case "input_textarea":
				strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value");
				break;
			case "input_radio":
			case "input_checkbox":
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
					strElementGet = "<off>";
				} else {
					strElementGet = "<on>";
				}
				break;
			case "select":
				JavascriptExecutor objExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
				strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", objDragonfly.objSeleniumVariables.gobjWebElement);
				strElementGet = strElementGet.trim();
				break;
			case "table":
				strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getText();
				break;
			case "alert":
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase().equals("title")) {
					strElementGet = objAutoIt.winGetTitle("[ACTIVE]");
					objDragonfly.objLogger.setLogRow("winGetTitle: = " + objAutoIt.winGetTitle("[ACTIVE]"));
				} else {
					strElementGet = objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().getText();
				}
				break;
			default:
				strElementGet = "Element tag not supported";
				break;
			}
			objDragonfly.objLogger.setLogRow("ElementGet: strElementGet = {" + strElementGet + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			if (strElementGet.equals("Element tag not supported")) {
				throw new ExceptionElementTagNameNotSupported("Element tag not supported");
			} else {
				return strElementGet;
			}
		}
	}

	public class ElementGetSync {
		public ElementGetSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementGetSync " + new DateTimestamp().get());
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
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strOutputValue", strGetValue);
						blnGet = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.objLogger.setLogRow("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					objDragonfly.objLogger.setLogRow("elementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					blnExit = true;
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementGetSync", "get", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					} else {
						blnVisible = false;
						blnGet = false;
					}
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

	public class CoordinateHighlightScreenshot {
		public CoordinateHighlightScreenshot(Dragonfly objDragonfly, final JSONObject objJsonObjectStepHighlightArea) {
			objDragonfly.objLogger.setLogRow("  ==start==>coordinateHighlightScreenshot " + new DateTimestamp().get());
			long lngStartTime = System.currentTimeMillis();
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
						objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: strHighlightArea = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strHighlightArea").toString());
						new RectangleAreaByName(objDragonfly, intThickness, objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strHighlightArea").toString(), objHighlightArea);
						setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
						setUndecorated(true);
						setBackground(new Color(0, 0, 0, 0));
						getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
						setVisible(true);
					}
				}
			};
			int intSleepMilliseconds = 0;
			if (Boolean.parseBoolean(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("blnScreenshot").toString()) == true) {
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				String strScreenshotFilePath = "";
				try {
					new RectangleAreaByName(objDragonfly, 0, objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strScreenshotArea").toString(), objHighlightArea);
					BufferedImage objScreenShot = new Robot().createScreenCapture(objHighlightArea);
					strScreenshotFilePath = objDragonfly.objPaths.gstrPathImages + "Screenshot_" + new DateTimestamp().get() + ".jpg";
					Thread objThread = new Thread(new ThreadSaveImage(objDragonfly, objScreenShot, "jpg", strScreenshotFilePath));
					objThread.start();
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strScreenshotFilePath", strScreenshotFilePath);
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: Exception " + e.toString());
				}
			}
			if (Boolean.parseBoolean(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("blnHighlight").toString()) == true) {
				try {
					Thread.sleep(intSleepMilliseconds);
				} catch (InterruptedException e) {
					objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: Exception " + e.toString());
				}
				objJFrame.setVisible(false);
				objJFrame.dispose();
			}
			objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	public class RectangleAreaByName {
		public RectangleAreaByName(Dragonfly objDragonfly, Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
			objDragonfly.objLogger.setLogRow("  ==start==>rectangleAreaByName " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("rectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
			long lngStartTime = System.currentTimeMillis();
			int intX = 0;
			int intY = 0;
			int intWidth = 0;
			int intHeight = 0;
			if (strAreaObjectName.equals("")) {
				if (objDragonfly.objSeleniumVariables.gobjWebDriver == null) {
					strAreaObjectName = "screen";
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement == null) {
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
						strAreaObjectName = "element";
					} else {
						strAreaObjectName = "screen";
					}
				} else {
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey("intElementScreenX") == false) {
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
					intX = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intBrowserOuterX").toString());
					intY = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intBrowserOuterY").toString());
					intWidth = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intBrowserOuterWidth").toString());
					intHeight = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intBrowserOuterHeight").toString());
					break;
				case "page":
					// TODO change this to get absolute screen coordinates
					WebElement objWebElementPage = objDragonfly.objSeleniumVariables.gobjWebDriver.findElement(By.xpath("//body"));
					intX = objWebElementPage.getLocation().getX() - intThickness;
					intY = objWebElementPage.getLocation().getY() - intThickness;
					intWidth = objWebElementPage.getSize().width + (2 * intThickness);
					intHeight = objWebElementPage.getSize().height + (2 * intThickness);
					break;
				case "element":
				case "alert":
					intX = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementScreenX").toString()) - intThickness;
					intY = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementScreenY").toString()) - intThickness;
					intWidth = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementWidth").toString()) + (2 * intThickness);
					intHeight = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementHeight").toString()) + (2 * intThickness);
					break;
				default:
					objDragonfly.objLogger.setLogRow("rectangleAreaByName: epected values = screen, window, page and element not " + strAreaObjectName);
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
				objDragonfly.objLogger.setLogRow("rectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
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

		public void run() {
			try {
				ImageIO.write(objScreenShot, strImageType.toUpperCase(), new File(strPathFileName));
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("threadSaveImage: Exception = " + e.toString());
			}
		}
	}

	public class DateTimestamp {
		public String get() {
			return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
		}
	}

	public class DateTimeFormat {
		public String set(Dragonfly objDragonfly, Long lngStartTimeMillis) {
			objDragonfly.objLogger.setLogRow("  ==start==>dateTimeFormat " + new DateTimestamp().get());
			return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS").format(new Date(lngStartTimeMillis));
		}
	}

	public class MonthGet {
		public String run(Dragonfly objDragonfly, int month) {
			objDragonfly.objLogger.setLogRow("  ==start==>monthGet " + new DateTimestamp().get());
			return new DateFormatSymbols().getMonths()[month];
		}
	}

	public class WindowFocus {
		public WindowFocus(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>windowFocus " + new DateTimestamp().get());
			// TODO debug gobjWebDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
			if (objDragonfly.objSeleniumVariables.gobjWebDriver instanceof JavascriptExecutor) {
				((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("window.focus();");
			}
		}
	}

	public class ScrollToBottom {
		public ScrollToBottom(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>scrollToBottom " + new DateTimestamp().get());
			// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
			JavascriptExecutor executor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		}
	}

	public class ElementScrollSync {
		public ElementScrollSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>ElementScrollSync " + new DateTimestamp().get());
			Long lngTimeStart = System.currentTimeMillis();
			Boolean blnExit = false;
			Boolean blnFound = false;
			Boolean blnStatus = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						blnFound = true;
						objDragonfly.objLogger.setLogRow("ElementScrollSync: blnFound = true");
					}
					JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
					objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", objDragonfly.objSeleniumVariables.gobjWebElement);
					blnStatus = true;
					objDragonfly.objLogger.setLogRow("ElementScrollSync: blnStatus = true");
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.objLogger.setLogRow("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "ElementScrollSync", "scroll", lngTimeStart) == true) {
						new CoordinateHighlightScreenshot(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectStep);
						return;
					}
				}
			}
		}
	}

	public class StepNames {
		private String strKeys1 = "strAction|strLogicalName|strTagName|strAttributeNames|strAttributeValues|strInputValue|strAssert|blnOptional|blnExitOnFail";
		private String strKeys2 = "|intMillisecondsToWait|strFunction|strOutputLinkName|strLoopOrIf|blnPleaseWait|blnHighlight|blnScreenshot|strAssistiveProperties|strOutputValue";
		private String strKeys3 = "|intBrowserInnerWidth|intBrowserInnerHeight|intBrowserOuterX|intBrowserOuterY|intBrowserOuterWidth|intBrowserOuterHeight";
		private String strKeys4 = "|intElementScreenX|intElementScreenY|intElementX|intElementY|intElementWidth|intElementHeight|strTagType|strType|strCurrentWindowHandle";
		private String strKeys5 = "|strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strScreenshotFilePath|strStatus";
		private StringBuilder objStringBuilder = new StringBuilder();

		public String[] getOriginal() {
			objStringBuilder.append(strKeys1);
			objStringBuilder.append(strKeys2);
			return objStringBuilder.toString().split("\\|");
		}

		public String[] getComplete() {
			objStringBuilder.append(strKeys1);
			objStringBuilder.append(strKeys2);
			objStringBuilder.append(strKeys3);
			objStringBuilder.append(strKeys4);
			objStringBuilder.append(strKeys5);
			return objStringBuilder.toString().split("\\|");
		}
	}

	public class StepCreateExpected {
		public String run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>StepCreateExpected " + new DateTimestamp().get());
			String strAction = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAction").toString();
			String strInputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			String strMillisecondsToWait = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intMillisecondsToWait").toString();
			String strObjectName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeNames").toString() + "=" + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString();
			String strTagName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString();
			String strAssert = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAssert").toString();
			switch (strAction.toLowerCase()) {
			case "launch":
				return "Launch {" + strTagName + "} browser to url {" + strInputValue + "} then expect navigation within {" + strMillisecondsToWait + "} milliseconds";
			case "close":
				return "Close {" + strTagName + "} browser within {" + strMillisecondsToWait + "} milliseconds";
			case "get":
				return "Get {" + strTagName + "} tag with attributes {" + strObjectName + "} value" + " within {" + strMillisecondsToWait + "} milliseconds";
			case "set":
				return "Set  {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
			case "verify":
				return "Verify  {" + strTagName + "} tag with attributes {" + strObjectName + "} value is equal to {" + strInputValue + "} within " + strMillisecondsToWait + "} milliseconds";
			case "verify_not":
				return "Verify Not {" + strTagName + "} tag with attributes {" + strObjectName + "} value is equal to {" + strInputValue + "} within " + strMillisecondsToWait + "} milliseconds";
			case "mouse_over":
				return "Mouse over  {" + strTagName + "} tag with attributes {" + strObjectName + "} within " + strMillisecondsToWait + "} milliseconds";
			case "mouse_out":
				return "Mouse out  {" + strTagName + "} tag with attributes {" + strObjectName + "} within " + strMillisecondsToWait + "} milliseconds";
			case "sync_visible":
				return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is visible within {" + strMillisecondsToWait + "} milliseconds";
			case "sync_hidden":
				return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is hidden within {" + strMillisecondsToWait + "} milliseconds";
			case "sync_enabled":
				return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is enabled within {" + strMillisecondsToWait + "} milliseconds";
			case "sync_disabled":
				return "Sync until  {" + strTagName + "} tag with attributes {" + strObjectName + "} is disabled within {" + strMillisecondsToWait + "} milliseconds";
			case "scroll":
				return "The expected " + strTagName + " exists.";
			case "break":
				return "The action break stopped the execution.";
			case "drag":
				return "Drag {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
			case "drop":
				return "Drop {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
			case "kill_ie":
				return "The action kill_ie killed all IE processes.";
			case "refresh":
				return "The browser was refreshed.";
			case "set_js":
				return "Set {" + strTagName + "} tag with attributes {" + strObjectName + "} to value {" + strInputValue + "} and assert {" + strAssert + "} within " + strMillisecondsToWait + "} milliseconds";
			case "sleep":
				return "The action sleep paused execution for {" + strInputValue + " milliseconds}";
			default:
				return strAction;
			}
		}
	}

	public class StepCreateActual {
		public String run(Dragonfly objDragonfly, String strStepType) {
			objDragonfly.objLogger.setLogRow("  ==start==>StepCreateActual " + new DateTimestamp().get());
			String intWaited = "";
			String strActualHtml = "";
			String strActualReturn = "";
			String strActualReturnHTML = "";
			String strActualText = "";
			String strInputParameterValueHTML = "";
			String strInputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			String strOutputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strOutputValue").toString();
			String strOutputValueHtml = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strOutputValue").toString();
			String strParameterName = "";
			String strStepParameterName = "";
			String strTagName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString();
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
			return strActualText;
		}
	}

	public class WebElementCollectionTable {
		public WebElementCollectionTable(Dragonfly objDragonfly, String strTagName) {
			boolean blnSkip = false;
			objDragonfly.objLogger.setLogRow("  ==start==>webElementCollectionTable " + new DateTimestamp().get());
			// TODO webElementCollectionTable send output to html file
			int intCount = 0;
			//JSONObject objStepNew = null;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			objDragonfly.objLogger.setLogRow("webElementCollectionTable: strTagName = " + strTagName);
			objDragonfly.objLogger.setLogRow("webElementCollectionTable: lngStartTimeSwitchTo = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle());
			objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().defaultContent();
			for (String winHandle : objDragonfly.objSeleniumVariables.gobjWebDriver.getWindowHandles()) {
				intCount = 0;
				// objDragonfly.objLogger.setLogRow("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
				objDragonfly.objLogger.setLogRow("webElementCollectionTable: winHandle = " + winHandle);
				long lngStartTimeSwitchTo = System.currentTimeMillis();
				// if (strCurrentWindowHandle.equals(winHandle)) {
				// } else {
				objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().window(winHandle);
				objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				objDragonfly.objLogger.setLogRow("webElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
				// }
				objDragonfly.objLogger.setLogRow("webElementCollectionTable: objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle());
				//objDragonfly.objLogger.setLogRow("webElementCollectionTable objDragonfly.objSeleniumVariables.gobjWebDriver.getPageSource = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getPageSource());
				objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				List<WebElement> objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.tagName(strTagName));
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
							objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
							objDragonfly.objLogger.setLogRow("webElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
							objDragonfly.objLogger.setLogRow("type:= '" + row.getAttribute("type") + "'");
							objDragonfly.objLogger.setLogRow("webElementCollectionTable: getText:= '" + row.getText() + "'");
							objDragonfly.objLogger.setLogRow("webElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
						}
					}
					// objDragonfly.objLogger.setLogRow("text:=  " + objWebElementEach.);
					// objDragonfly.objLogger.setLogRow("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
					// objDragonfly.objLogger.setLogRow("TagName:= '" + row.getAttribute("TagName") + "'");
					// objDragonfly.objLogger.setLogRow("Type:= '" + row.getAttribute("Type") + "'");
					// objDragonfly.objLogger.setLogRow("TYPE:= '" + row.getAttribute("TYPE") + "'");
					// objDragonfly.objLogger.setLogRow("id:= '" + row.getAttribute("id") + "'");
					// objDragonfly.objLogger.setLogRow("name:= '" + row.getAttribute("name") + "'");
					// objDragonfly.objLogger.setLogRow("text:= '" + row.getAttribute("text") + "'");
					// objDragonfly.objLogger.setLogRow("innerText:= '" + row.getAttribute("innerText") + "'");
					// objDragonfly.objLogger.setLogRow("outerText:= '" + row.getAttribute("outerText") + "'");
					// objDragonfly.objLogger.setLogRow("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
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
					// objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
					// long lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.objLogger.setLogRow("JS value = " +
					// objJavascriptExecutor.executeScript("return arguments[0].value;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.objLogger.setLogRow("JS innerText = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.objLogger.setLogRow("JS innerHTML = " +
					// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
					// objCollectionJS.get(0)) + " Milliseconds Waited = " +
					// (System.currentTimeMillis() - lngStartTimeJS));
					// lngStartTimeJS = System.currentTimeMillis();
					// objDragonfly.objLogger.setLogRow("JS outerHTML = " +
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

	public class WebElementCollectionAttributes {
		public WebElementCollectionAttributes(Dragonfly objDragonfly, String strTagName) {
			objDragonfly.objLogger.setLogRow("  ==start==>webElementCollectionAttributes " + new DateTimestamp().get());
			int intCount = 0;
			if (strTagName.toLowerCase().startsWith("input_")) {
				strTagName = "input";
			}
			List<WebElement> objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				intCount = intCount + 1;
				objDragonfly.objLogger.setLogRow("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionAttributes " + intCount);
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
	}

	public class WebElementAttributes {
		public WebElementAttributes(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>webElementAttributes " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("text:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getTagName());
			objDragonfly.objLogger.setLogRow("tag_type:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getTagName() + "_" + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("type"));
			objDragonfly.objLogger.setLogRow("TagName:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("TagName"));
			objDragonfly.objLogger.setLogRow("type:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("type"));
			objDragonfly.objLogger.setLogRow("id:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("id"));
			objDragonfly.objLogger.setLogRow("name:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("name"));
			objDragonfly.objLogger.setLogRow("text:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("text"));
			objDragonfly.objLogger.setLogRow("innerText:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("innerText"));
			objDragonfly.objLogger.setLogRow("outerText:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("outerText"));
			objDragonfly.objLogger.setLogRow("innerHTML:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("innerHTML"));
			objDragonfly.objLogger.setLogRow("outerHTML:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("outerHTML"));
			objDragonfly.objLogger.setLogRow("uniqueID:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("uniqueID"));
			objDragonfly.objLogger.setLogRow("class:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("class"));
			objDragonfly.objLogger.setLogRow("type:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("type"));
			objDragonfly.objLogger.setLogRow("TYPE:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("TYPE"));
			objDragonfly.objLogger.setLogRow("href:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("href"));
			objDragonfly.objLogger.setLogRow("NameProp:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("NameProp"));
			objDragonfly.objLogger.setLogRow("isDisplayed:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed());
			objDragonfly.objLogger.setLogRow("name:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.isEnabled());
			objDragonfly.objLogger.setLogRow("getLocation().x:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getLocation().x);
			objDragonfly.objLogger.setLogRow("getLocation().y:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getLocation().y);
			objDragonfly.objLogger.setLogRow("getSize().height:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getSize().height);
			objDragonfly.objLogger.setLogRow("getLocation().y:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getSize().width);
			objDragonfly.objLogger.setLogRow("src:=  " + objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("src"));
		}
	}

	public class ImageDecodeFromString {
		public BufferedImage run(Dragonfly objDragonfly, String strImageString) {
			objDragonfly.objLogger.setLogRow("  ==start==>imageDecodeFromString " + new DateTimestamp().get());
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
			objDragonfly.objLogger.setLogRow("  ==start==>imageEncodeToString " + new DateTimestamp().get());
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

	public class RandomNumberRange {
		public int run(Dragonfly objDragonfly, int intNumberMinimum, int intNumberMaximum) {
			objDragonfly.objLogger.setLogRow("  ==start==>randomNumberRange " + new DateTimestamp().get());
			return new Random().nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
		}
	}

	public class WebDriverTest {
		public WebDriverTest() {
			System.setProperty("webdriver.ie.driver", "C:/Users/perrj115/Documents/GitHub/dragonfly/Dragonfly/Drivers/IEDriverServer.exe");
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

	public class WriteFile {
		public WriteFile(Dragonfly objDragonfly, String strFilePathFile, String strTextToWrite) {
			objDragonfly.objLogger.setLogRow("  ==start==>writeFile " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("writeFile: strFilePathFile = " + strFilePathFile);
			try {
				BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(strFilePathFile));
				objBufferedWriter.write(strTextToWrite);
				objBufferedWriter.close();
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("WriteFile: Exception" + e.toString());
			}
		}
	}

	public class WriteJsonKeys {
		public WriteJsonKeys(Dragonfly objDragonfly, JSONObject objJsonObjectKeySet, String file) throws IOException {
			objDragonfly.objLogger.setLogRow("  ==start==>writeJsonKeysToHtml " + new DateTimestamp().get());
			for (Iterator<?> iterator = objJsonObjectKeySet.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				objDragonfly.objLogger.setLogRow("writeJsonKeysToHtml: " + key + " = " + objJsonObjectKeySet.get(key));
			}
		}
	}

	public class WriteJsonStepsToHtml {
		public WriteJsonStepsToHtml(Dragonfly objDragonfly, String strStepHeader, JSONArray objTestSteps, String strPath, String strFileName) {
			objDragonfly.objLogger.setLogRow("  ==start==>writeJsonStepsAfterRunToHtml " + new DateTimestamp().get());
			String strKey = "";
			String[] arrKeys = null;
			StepNames objStepNames = new StepNames();
			StringBuilder objStringBuilder = new StringBuilder();
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
					strKey = (String) arrKeys[intKeysEach].toString();
					objStringBuilder.append("<th>" + strKey + "</th>");
				}
				objStringBuilder.append(" </tr>  ");
				for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
					objStringBuilder.append("</tr>");
					objStringBuilder.append("<td> " + (intTestStepRow) + "</td>");
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
				new WriteFile(objDragonfly, strPath + strFileName, html);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("WriteJsonStepsToHtml: Exception = " + e.toString());
				objDragonfly.objLogger.setLogRow("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
				objLogger.setLogRow("WriteJsonStepsToHtml: Exception = " + e.toString());
				objLogger.setLogRow("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			}
		}
	}

	public class WriteReportToHtml {
		public WriteReportToHtml(Dragonfly objDragonfly, JSONArray objJsonArrayReportSteps, String strFile, String strTestStepsFile, String strTestName) {
			long lngStartTime = System.currentTimeMillis();
			objDragonfly.objLogger.setLogRow("  ==start==>writeReportToHtml " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("writeReportToHtml: strFile = " + strFile);
			JSONObject objJsonObjectReportStep = null;
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
				String strHTML = objStringBuilder.toString().replace("varImageCount = -1", "varImageCount = " + (intTestStepRow - 1));
				new WriteFile(objDragonfly, strFile, strHTML);
				new WriteFile(objDragonfly, strTestStepsFile, strHTML);
				objDragonfly.objLogger.setLogRow("writeReportToHtml: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}

	public String data_DateDaysOut(Dragonfly objDragonfly, String strDaysOut) {
		objDragonfly.objLogger.setLogRow("  ==start==>data_DateDaysOut " + new DateTimestamp().get());
		Integer intDaysOut = Integer.parseInt(strDaysOut);
		SimpleDateFormat objFormattedDATE = new SimpleDateFormat("MM/dd/yyyy");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.DATE, intDaysOut);
		String strNewDate = (String) (objFormattedDATE.format(objCalendar.getTime()));
		return strNewDate;
	}

	public String data_EnvironmentURL(Dragonfly objDragonfly, String strApplication_Environment) {
		JSONParser gobjJsonParser = new JSONParser();
		objDragonfly.objLogger.setLogRow("  ==start==>data_EnvironmentURL " + new DateTimestamp().get());
		String strURL = "";
		String strFilePathTestData = objDragonfly.objPaths.gstrPathTestData + "/Environment.json";
		try {
			JSONObject objJsonObjectFile = (JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestData));
			strURL = objJsonObjectFile.get(strApplication_Environment).toString();
			objDragonfly.objLogger.setLogRow("data_EnvironmentURL: strURL = " + strURL);
		} catch (Exception e) {
			objDragonfly.objLogger.setLogRow("data_EnvironmentURL: Exception = " + e.toString());
		}
		return strURL;
	}

	public String data_localWebsiteFilePath(Dragonfly objDragonfly, String strWebsite) {
		objDragonfly.objLogger.setLogRow("  ==start==>data_localWebsiteFilePath " + new DateTimestamp().get());
		String strLocalWebsiteFilePath = "file:///" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/Websites/" + strWebsite;
		objDragonfly.objLogger.setLogRow("data_localWebsiteFilePath: strLocalWebsiteFilePath = " + strLocalWebsiteFilePath);
		return strLocalWebsiteFilePath;
	}

	public String data_RandomFourNumbers(Dragonfly objDragonfly, String strDaysOut) {
		objDragonfly.objLogger.setLogRow("  ==start==>data_RandomFourNumbers " + new DateTimestamp().get());
		return Integer.toString(new RandomNumberRange().run(objDragonfly, 1000, 9999));
	}

	public String data_RandomRangeFiveNumbers(Dragonfly objDragonfly, String strDataInput) {
		objDragonfly.objLogger.setLogRow("  ==start==>data_RandomRangeFiveNumbers " + new DateTimestamp().get());
		return Integer.toString(new RandomNumberRange().run(objDragonfly, 1, 99999));
	}
}