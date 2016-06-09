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
import org.openqa.selenium.Capabilities;
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
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import com.opera.core.systems.OperaDriver;

public class Dragonfly {
	// System.exit(0);
	Logger objLogger = new Logger("  ==start==>Dragonfly ");
	PathCreation objPathCreation = new PathCreation();
	AutoItSetObject objAutoItSetObject = new AutoItSetObject();
	SeleniumVariables objSeleniumVariables = new SeleniumVariables();
	OperatingSystem objOperatingSystem = new OperatingSystem();
	TestMatrixSetup objTestMatrixSetup = new TestMatrixSetup();
	JsonVariables objJsonVariables = new JsonVariables();
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

	public static void main(String[] args) {
		//System.exit(0);
		//webDriverTest();
		JSONArray gobjJsonArrayTestSteps = null;
		JSONParser gobjJsonParser = new JSONParser();
		Dragonfly objDragonfly = new Dragonfly();
		objDragonfly.objLogger.setLogRow("  ==start==>main " + objDragonfly.new DateTimestamp().get());
		objDragonfly.objAutoItSetObject.createObject(objDragonfly);
		objDragonfly.objOperatingSystem.setOperatingSystem(objDragonfly);
		//System.exit(0);
		//OperatingSystem objOperatingSystem = new OperatingSystem(objDragonfly);
		//objDragonfly.Logger.("  ==start==>main " + objDragonfly.new DateTimestamp().get());
		//		SyncTime newSync = objDragonfly.new SyncTime();
		//		newSync.start();
		//		sleepMilliseconds(1000);
		//		newSync.stop();
		//		sleepMilliseconds(1000);
		//		System.out.println(newSync.getDuration());
		//		stepsNames StepsNames = objDragonfly.new stepsNames();
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
		String strTestMatixFileName = "local_ATW_AlertPopups.json";
		int intStep = 0;
		int intMillisecondsToWaitDefault = 20000;
		int intLoopCount = 0;
		int intLoopEach = 0;
		int intLoopStep = 0;
		int gintTestInstanceEach = 0;
		String strCurrentWindowHandle = "";
		String strFolderPathResults = "";
		String strFolderPathImages = "";
		String strTestStatus = "";
		String strLoopExitValue = "";
		JSONObject gobjJsonObjectTestInstancesEach = null;
		WriteJsonStepsToHtml objWriteJsonStepsToHtml = objDragonfly.new WriteJsonStepsToHtml();
		objDragonfly.new WindowsMinimizeAll().set(objDragonfly);
		objDragonfly.objTestMatrixSetup.setTestMatrix(objDragonfly, strTestMatixFileName);
		objDragonfly.objLogger.setLogRow("Main: setTestMatrix");
		int gintTestInstanceSize = objDragonfly.objTestMatrixSetup.gintTestInstanceSize;
		String gstrTestStepsCombinedOriginal = objDragonfly.objTestMatrixSetup.gstrTestStepsCombinedOriginal;
		for (gintTestInstanceEach = 0; gintTestInstanceEach < gintTestInstanceSize; gintTestInstanceEach++) {
			try {
				objDragonfly.objSeleniumVariables.gobjWebElement = null;
				gobjJsonArrayTestSteps = null;
				gobjJsonArrayTestSteps = (JSONArray) gobjJsonParser.parse(gstrTestStepsCombinedOriginal);
				objDragonfly.objLogger.setLogRow("main: gintTestInstanceSize = " + gintTestInstanceSize);
				gobjJsonObjectTestInstancesEach = (JSONObject) objDragonfly.objJsonVariables.gobjJsonArrayTestInstances.get(gintTestInstanceEach);
				objDragonfly.objJsonVariables.gobjJsonObjectStep = null;
				intStep = 0;
				intMillisecondsToWaitDefault = 120000;
				intLoopCount = 0;
				intLoopEach = 0;
				intLoopStep = 0;
				strCurrentWindowHandle = "";
				strFolderPathResults = "";
				strFolderPathImages = "";
				strTestStatus = "pass";
				//gstrFolderPathResultsFolder = gstrFolderPathResultsIterationsFolder + objDragonfly.new DateTimestamp().get();
				objDragonfly.objLogger.setLogRow("main: Working Directory = " + objDragonfly.objPathCreation.gstrFolderPathSystemUserDir);
				objDragonfly.objLogger.setLogRow("main: gstrOperatingSystem = " + objDragonfly.objOperatingSystem.strOS);
				//				switch (gstrOperatingSystem) {
				//				case "Windows":
				//					strFolderPathResults = objDragonfly.objPathCreation.getPathSystemUserDir() + "\\Results\\" + strTestMatixFileName.replace(".json", "") + "\\" + gstrFolderPathResultsFolder + "\\";
				//					strFolderPathImages = "images\\";
				//					break;
				//				case "Mac":
				//					strFolderPathResults = objDragonfly.objPathCreation.getPathSystemUserDir() + "/Results/" + strTestMatixFileName.replace(".json", "") + "/" + gstrFolderPathResultsFolder + "/";
				//					strFolderPathImages = "images/";
				//					break;
				//				default:
				//					objDragonfly.objLogger.setLogRow("main: switch gstrOperatingSystem = " + gstrOperatingSystem + "  not supported");
				//					return;
				//				}
				objDragonfly.objLogger.setLogRow("main: strFolderPathResults = " + strFolderPathResults);
				strFolderPathResults = objDragonfly.objPathCreation.getPathResults();
				objDragonfly.objLogger.setLogRow("main: strFolderPathResults = " + strFolderPathResults);
				strFolderPathImages = objDragonfly.objPathCreation.getPathImages();
				objDragonfly.objLogger.setLogRow("main: strFolderPathImages = " + strFolderPathImages);
				new File(strFolderPathImages).mkdirs();
				objWriteJsonStepsToHtml.createReport(objDragonfly, "original", gobjJsonArrayTestSteps, strFolderPathResults, "StepsOriginal.html");
				objDragonfly.objLogger.setLogRow("main: gobjJsonArrayTestSteps.size() = " + gobjJsonArrayTestSteps.size());
				for (intStep = 0; intStep < gobjJsonArrayTestSteps.size(); intStep++) {
					objDragonfly.objLogger.setLogRow("main: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Step " + intStep);
					objDragonfly.objSeleniumVariables.gobjWebElement = null;
					objDragonfly.objJsonVariables.gobjJsonObjectStep = (JSONObject) gobjJsonArrayTestSteps.get(intStep);
					String strInputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
					String strLogicalName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strLogicalName").toString();
					if (strLogicalName.toLowerCase().startsWith("<er>") == true) {
						strLogicalName = strLogicalName.replace("<er>", "");
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
					if (strInputValue.toLowerCase().startsWith("<td>") == true) {
						strInputValue = objDragonfly.new JsonObjectGetValue().run(objDragonfly, objDragonfly.objJsonVariables.gobjJsonObjectTestDataFile, strInputValue, "<td>");
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
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strScreenshotFilePath", strFolderPathImages);
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStatus", "info");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStartTimestamp", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepDuration", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strEndTimestamp", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepExpected", "");
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strStepActual", "");
					objDragonfly.new LogStepDetails(objDragonfly, intStep);
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intLoop").toString().trim().length() > 0) {
						if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intLoop").toString().toLowerCase().startsWith("<loopstart>") == true) {
							if (intLoopEach == 0) {
								intLoopCount = Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intLoop").toString().substring(11));
								objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intLoop", "");
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
					if (!strInputValue.toLowerCase().equals("<skip>")) {
						switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAction").toString().toLowerCase()) {
						case "kill_ie":
							//							ProcessKillInternetExplorer objProcessKillInternetExplorer = objDragonfly.new ProcessKillInternetExplorer();
							//							objProcessKillInternetExplorer.start(objDragonfly);
							objDragonfly.new ProcessKillInternetExplorer().start(objDragonfly);
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
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intLoop").toString().toLowerCase().startsWith("<loopexit>") == true) {
						strLoopExitValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intLoop").toString().substring(10);
						objDragonfly.objLogger.setLogRow("main: strLoopExitValue = " + strLoopExitValue);
						if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strOutputValue").toString().equals(strLoopExitValue)) {
							intLoopCount = 0;
							intLoopEach = 0;
						}
					}
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intLoop").toString().toLowerCase().startsWith("<loopend>") == true) {
						if (intLoopEach == intLoopCount) {
							intLoopCount = 0;
							intLoopEach = 0;
						} else {
							intLoopEach = intLoopEach + 1;
							intStep = intLoopStep - 1;
						}
					}
					//					if (gobjJsonArrayTestStepsComplete == null) {
					//						gobjJsonArrayTestStepsComplete = (JSONObject) gobjJsonParser.parse(objDragonfly.objJsonVariables.gobjJsonObjectStep.toString());
					//					} else {
					//						gobjJsonArrayTestStepsComplete.putAll((JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestData)));
					//					}
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("main: Exception " + e.toString());
			} finally {
				objDragonfly.new WriteFile(objDragonfly, strFolderPathResults + "StepsWithDefaults.json", gobjJsonArrayTestSteps.toString());
				objDragonfly.new WriteFile(objDragonfly, strFolderPathResults + "StepsAfterRun.json", objDragonfly.objJsonVariables.gobjJsonObjectStepsFile.toString());
				objWriteJsonStepsToHtml.createReport(objDragonfly, "original", gobjJsonArrayTestSteps, strFolderPathResults, "StepsWithDefaults.html");
				objWriteJsonStepsToHtml.createReport(objDragonfly, "complete", gobjJsonArrayTestSteps, strFolderPathResults, "StepsAfterRun.html");
				objDragonfly.new WriteReportToHtml(objDragonfly, gobjJsonArrayTestSteps, strFolderPathResults + "Report.html");
				File objDirectoryOld = new File(strFolderPathResults);
				String strFolderPathResultsNew = objDragonfly.objPathCreation.getPathStatus(strTestStatus);
				objDragonfly.objLogger.setLogRow("main: strFolderPathResultsNew = " + strFolderPathResultsNew);
				File objDirectoryNew = new File(strFolderPathResultsNew);
				objDirectoryOld.renameTo(objDirectoryNew);
				if (objDragonfly.objSeleniumVariables.gobjWebDriver.toString().contains("InternetExplorerDriver")) {
					objDragonfly.new WindowsProcessKill(objDragonfly, "taskkill /F /IM IEDriverServer.exe");
				}
				objDragonfly.new WriteFile(objDragonfly, strFolderPathResultsNew + "Dragonfly.log", objDragonfly.objLogger.getLog());
			}
			objDragonfly.objLogger.deleteLog();
		}
	}

	public class PathCreation {
		private String gstrFolderPathData = "Data/internal/";//"Data/public/";//
		private String gstrFolderPathResults = "";
		private String gstrFolderPathSystemUserDir = System.getProperty("user.dir");
		private String gstrDateTimestamp = "";

		public void setPathResults(Dragonfly objDragonfly, int intTestInstanceSize, String strTestMatixFileName) {
			gstrDateTimestamp = new DateTimestamp().get();
			if (intTestInstanceSize > 1) {
				gstrFolderPathResults = gstrFolderPathSystemUserDir + "\\Results\\" + strTestMatixFileName.replace(".json", "") + "\\" + gstrDateTimestamp + "\\" + "_Iterations_" + intTestInstanceSize + "\\" + new DateTimestamp().get() + "\\";
			} else {
				gstrFolderPathResults = gstrFolderPathSystemUserDir + "\\Results\\" + strTestMatixFileName.replace(".json", "") + "\\" + gstrDateTimestamp + "\\";
			}
		}

		public String getPathElementRepository() {
			return gstrFolderPathData + "element_repository/";
		}

		public String getPathTestData() {
			return gstrFolderPathData + "test_data/";
		}

		public String getPathTestInstances() {
			return gstrFolderPathData + "test_instances/";
		}

		public String getPathTestMatrix() {
			return gstrFolderPathData + "test_matrix/";
		}

		public String getPathTestModules() {
			return gstrFolderPathData + "test_modules/";
		}

		public String getPathResults() {
			return gstrFolderPathResults;
		}

		public String getPathImages() {
			return gstrFolderPathResults + "images\\";
		}

		public String getPathStatus(String strTestStatus) {
			System.out.println(gstrFolderPathResults);
			System.out.println(gstrFolderPathResults.substring(gstrFolderPathResults.length() - 2));
			return gstrFolderPathResults.substring(0, gstrFolderPathResults.length() - 1) + "_" + strTestStatus + "\\";
		}
	}

	public class AlertFind {
		public boolean run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>alertFind " + new DateTimestamp().get());
			try {
				objDragonfly.objLogger.setLogRow("alertFind: objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle() = " + objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle());
				objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				objDragonfly.objLogger.setLogRow("alertFind: implicitlyWait  ");
				String strAlertPresent = objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().getText();
				objDragonfly.objLogger.setLogRow("alertFind: alert switch to which did not fail:  " + strAlertPresent);
				return true;
			} catch (UnhandledAlertException e) {
				//objDragonfly.objLogger.setLogRow("alertFind getText " + objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().getText());
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
	}

	public class AutoItSetObject {
		public AutoItX objAutoIt;

		public void createObject(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>autoItSetObject " + new DateTimestamp().get());
			String strJacobDllVersionToUse;
			JvmBitVersion objJvmBitVersion = new JvmBitVersion();
			if (objJvmBitVersion.getJvmBitVersion(objDragonfly).contains("32")) {
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
				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnStatus", "true");
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
					objDragonfly.objLogger.setLogRow("browserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
					objDragonfly.objLogger.setLogRow("browserLaunch: new InternetExplorerDriver(desiredCapabilities)");
					objDragonfly.objSeleniumVariables.gobjWebDriver = new InternetExplorerDriver(objDesiredCapabilities);
					//objDragonfly.objSeleniumVariables.gobjWebDriver.manage().getCookieNamed("JSESSIONID");
					// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().deleteCookieNamed("JSESSIONID");
					objDragonfly.objLogger.setLogRow("browserLaunch: objDragonfly.objJsonVariables.gobjJsonObjectStep.get(strInputValue).toString() = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					objDragonfly.objSeleniumVariables.gobjWebDriver.get(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					//objDragonfly.objLogger.setLogRow("browserLaunch: getCookieNamed(JSESSIONID) = " + objDragonfly.objSeleniumVariables.gobjWebDriver.manage().getCookieNamed("JSESSIONID").toString());
					objDragonfly.objLogger.setLogRow("browserLaunch: objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize()");
					objDragonfly.objSeleniumVariables.gobjWebDriver.manage().window().maximize();
					//Capabilities getCapabilities();
					// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					// // objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
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
					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "blnStatus", "false");
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
			}
		}
	}

	public class SeleniumVariables {
		private WebDriver gobjWebDriver = null;
		private WebElement gobjWebElement = null;
		private WebElement gobjWebElementDrag = null;
		private WebElement gobjWebElementDrop = null;
		private WebElement gobjWebElementPleaseWait = null;
	}

	public class JsonVariables {
		private JSONArray gobjJsonArrayTestInstances = null;
		private JSONObject gobjJsonObjectElement = null;
		private JSONObject gobjJsonObjectProcessing = null;
		private JSONObject gobjJsonObjectStepsFile = null;
		private JSONObject gobjJsonObjectTestDataFile = null;
		private JSONObject gobjJsonObjectLinks = null;
		private JSONObject gobjJsonObjectStep = new JSONObject();
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

		public void setOperatingSystem(Dragonfly objDragonfly) {
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

	public class JvmBitVersion {
		public String getJvmBitVersion(Dragonfly objDragonfly) {
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
			case "default":
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

		public void verifyInternetExplorerVersion(Dragonfly objDragonfly) throws IOException {
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
	//			if (objStep2.get("intLoop").toString().toLowerCase().startsWith("<loopend>") == true) {
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
			String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
			String strJSONObjectValue = "";
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

	public class TestMatrixSetup {
		int gintTestInstanceSize;
		String gstrTestStepsCombinedOriginal;

		public void setTestMatrix(Dragonfly objDragonfly, String strFileNameTestMatrix) {
			// TODO complete testMatrixSetup method to create json objects for test
			objDragonfly.objLogger.setLogRow("  ==start==>testMatrixSetup " + new DateTimestamp().get());
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
			JSONArray gobjJsonArrayLink = null;
			JSONObject objJsonObjectProcessingEach = null;
			String strFileNameElementRepository = "";
			String strFileNameTestData = "";
			String strFileNameTestInstance = "";
			String strFileNameTestModules = "";
			String strFilePathTestData = "";
			String strFilePathTestInstances = "";
			String strFilePathTestModules = "";
			String strStepsToString = "";
			String strFilePathTestMatrix = "";
			JSONObject gobjJsonObjectElements = null;
			JSONObject gobjJsonObjectTestInstance = null;
			JSONParser gobjJsonParser = new JSONParser();
			JSONObject gobjJsonObjectProcessing = null;
			try {
				strFilePathTestMatrix = objDragonfly.objPathCreation.getPathTestMatrix() + strFileNameTestMatrix;
				objDragonfly.objLogger.setLogRow("testMatrixSetup: strPathTestMatix = " + strFilePathTestMatrix);
				objJsonObjectTestMatrixFile = (JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestMatrix));
				// test_instances
				objJsonArrayTestInstance = (JSONArray) objJsonObjectTestMatrixFile.get("test_instances");
				intJsonArrayTestInstanceSize = objJsonArrayTestInstance.size();
				objDragonfly.objPathCreation.setPathResults(objDragonfly, gintTestInstanceSize, strFileNameTestMatrix);
				if (intJsonArrayTestInstanceSize == 1) {
					strFileNameTestInstance = objJsonArrayTestInstance.get(0).toString();
					strFilePathTestInstances = objDragonfly.objPathCreation.getPathTestMatrix() + strFileNameTestInstance;
					gobjJsonObjectTestInstance = (JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestInstances));
					objDragonfly.objJsonVariables.gobjJsonArrayTestInstances = (JSONArray) gobjJsonObjectTestInstance.get("test_instances");
					gintTestInstanceSize = objDragonfly.objJsonVariables.gobjJsonArrayTestInstances.size();
				} else if (intJsonArrayTestInstanceSize == 0) {
					gintTestInstanceSize = 1;
					gobjJsonObjectTestInstance = (JSONObject) gobjJsonParser.parse("{\"test_instances\":[{}]}");
					objDragonfly.objJsonVariables.gobjJsonArrayTestInstances = (JSONArray) gobjJsonObjectTestInstance.get("test_instances");
				} else if (intJsonArrayTestInstanceSize > 1) {
					gintTestInstanceSize = 0;
					objDragonfly.objLogger.setLogRow("testMatrixSetup: " + intJsonArrayTestInstanceSize + " Test Instances " + objJsonArrayTestInstance.toString() + " exceeds requirements of one. Update test matrix to have only one test instance.");
					throw new ExceptionTestInstanceMoreThanOne(intJsonArrayTestInstanceSize + " Test Instances " + objJsonArrayTestInstance.toString() + " exceeds requirements of one. Update test matrix to have only one test instance.");
				}
				// element_repository
				objJsonArrayElementRepository = (JSONArray) objJsonObjectTestMatrixFile.get("element_repository");
				for (intElementRepositoryEach = 0; intElementRepositoryEach < objJsonArrayElementRepository.size(); intElementRepositoryEach++) {
					strFileNameElementRepository = objJsonArrayElementRepository.get(intElementRepositoryEach).toString();
					objDragonfly.objLogger.setLogRow("testMatrixSetup: strFileNameElementRepository = " + strFileNameElementRepository);
					gobjJsonObjectElements = (JSONObject) gobjJsonParser.parse(new FileReader(objDragonfly.objPathCreation.getPathElementRepository() + strFileNameElementRepository));
					objJsonObjectElementsEach = (JSONObject) gobjJsonObjectElements.get("elements");
					if (intElementRepositoryEach == 0) {
						objDragonfly.objJsonVariables.gobjJsonObjectElement = (JSONObject) gobjJsonObjectElements.get("elements");
					} else {
						objDragonfly.objJsonVariables.gobjJsonObjectElement.putAll(objJsonObjectElementsEach);
					}
					objDragonfly.objLogger.setLogRow("testMatrixSetup: gobjJsonObjectElement = " + objDragonfly.objJsonVariables.gobjJsonObjectElement);
				}
				// please_wait
				objJsonArrayElementRepository = (JSONArray) objJsonObjectTestMatrixFile.get("element_repository");
				for (intElementRepositoryEach = 0; intElementRepositoryEach < objJsonArrayElementRepository.size(); intElementRepositoryEach++) {
					strFileNameElementRepository = objJsonArrayElementRepository.get(intElementRepositoryEach).toString();
					objDragonfly.objLogger.setLogRow("testMatrixSetup: strFileNameElementRepository = " + strFileNameElementRepository);
					gobjJsonObjectProcessing = (JSONObject) gobjJsonParser.parse(new FileReader(objDragonfly.objPathCreation.getPathElementRepository() + strFileNameElementRepository));
					objJsonObjectProcessingEach = (JSONObject) gobjJsonObjectProcessing.get("processing");
					if (intElementRepositoryEach == 0) {
						objDragonfly.objJsonVariables.gobjJsonObjectProcessing = (JSONObject) gobjJsonObjectProcessing.get("processing");
					} else {
						objDragonfly.objJsonVariables.gobjJsonObjectProcessing.putAll(objJsonObjectProcessingEach);
					}
					objDragonfly.objLogger.setLogRow("testMatrixSetup: gobjJsonObjectProcessing = " + objDragonfly.objJsonVariables.gobjJsonObjectProcessing);
				}
				// test_modules
				objJsonArrayTestModules = (JSONArray) objJsonObjectTestMatrixFile.get("test_modules");
				if (objJsonArrayTestModules.size() == 0) {
					// TODO add error handling, report no test modules and fail
					objDragonfly.objLogger.setLogRow("testMatrixSetup: objJsonArrayTestModules.size() == 0.  At lease 1 test module must be includes in a dragonfly test");
				} else {
					for (intTestModulesEach = 0; intTestModulesEach < objJsonArrayTestModules.size(); intTestModulesEach++) {
						strFileNameTestModules = objJsonArrayTestModules.get(intTestModulesEach).toString();
						strFilePathTestModules = objDragonfly.objPathCreation.getPathTestModules() + strFileNameTestModules;
						objDragonfly.objLogger.setLogRow("testMatrixSetup: strFilePathTestModules = " + strFilePathTestModules);
						objDragonfly.objJsonVariables.gobjJsonObjectStepsFile = (JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestModules));
						objJsonArraySteps = (JSONArray) objDragonfly.objJsonVariables.gobjJsonObjectStepsFile.get("steps");
						strStepsToString = objJsonArraySteps.toString();
						objDragonfly.objLogger.setLogRow("testMatrixSetup: objJsonStepsEach = " + objJsonArraySteps.toString());
						if (intTestModulesEach > 0) {
							gstrTestStepsCombinedOriginal = gstrTestStepsCombinedOriginal.substring(0, gstrTestStepsCombinedOriginal.length() - 1) + "," + strStepsToString.substring(1);
						} else {
							gstrTestStepsCombinedOriginal = strStepsToString;
						}
					}
					objDragonfly.objLogger.setLogRow("testMatrixSetup: gstrTestStepsCombinedOriginal = " + gstrTestStepsCombinedOriginal);
					gobjJsonArrayLink = (JSONArray) objDragonfly.objJsonVariables.gobjJsonObjectStepsFile.get("link");
					objDragonfly.objJsonVariables.gobjJsonObjectLinks = (JSONObject) gobjJsonArrayLink.get(0);
				}
				// test_data
				objJsonArrayTestData = (JSONArray) objJsonObjectTestMatrixFile.get("test_data");
				if (objJsonArrayTestData.size() > 0) {
					for (intTestDataEach = 0; intTestDataEach < objJsonArrayTestData.size(); intTestDataEach++) {
						strFileNameTestData = objJsonArrayTestData.get(intTestDataEach).toString();
						strFilePathTestData = objDragonfly.objPathCreation.getPathTestData() + strFileNameTestData;
						objDragonfly.objJsonVariables.gobjJsonObjectTestDataFile = (JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestData));
						if (intTestDataEach > 0) {
							objDragonfly.objJsonVariables.gobjJsonObjectTestDataFile.putAll((JSONObject) gobjJsonParser.parse(new FileReader(strFilePathTestData)));
						}
					}
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("testMatrixSetup: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("testMatrixSetup: Finally");
			}
		}
	}

	public class LogStepDetails {
		public LogStepDetails(Dragonfly objDragonfly, int intStep) {
			objDragonfly.objLogger.setLogRow("  ==start==>logStepDetails " + new DateTimestamp().get());
			String[] arrKeys;
			String strKey = "";
			arrKeys = new StepNames().getOriginal();
			for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
				strKey = (String) arrKeys[intKeysEach].toString();
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey(strKey) == true) {
					objDragonfly.objLogger.setLogRow("logStepDetails: " + strKey + " = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get(strKey).toString());
				}
			}
		}
	}

	public class ElementOnMouseOver {
		public ElementOnMouseOver(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementOnMouseOver " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("elementOnMouseOverSync: " + objDragonfly.objSeleniumVariables.gobjWebElement.toString());
			JavascriptExecutor objJavascriptExecutor = null;
			if (objDragonfly.objSeleniumVariables.gobjWebElement != null) {
				objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
			}
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
						new ElementVisible().run(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled().run(objDragonfly);
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
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementOnMouseOverSync", "mouseover", lngTimeStart) == true) {
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

			try {
				objDragonfly.objSeleniumVariables.gobjWebElementPleaseWait = objDragonfly.objSeleniumVariables.gobjWebElement;
				try {
					new ElementFindBy(objDragonfly, "id", "", "div");
				} catch (ExceptionElementNotFound e) {
					return;
				} catch (ExceptionMultipleElementsFound e) {
					throw new ExceptionElementNotHidden("Multiple Element found.");
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed() == true) {
					objDragonfly.objLogger.setLogRow("ElementPleaseWait: gobjWebElement.isDisplayed() = return true MillisecondsWaited = " + (System.currentTimeMillis()));
					throw new ExceptionElementNotHidden("Element is displayed.");
				} else {
					objDragonfly.objLogger.setLogRow("ElementPleaseWait: gobjWebElement.isDisplayed() = return false MillisecondsWaited = " + (System.currentTimeMillis()));
				}
			} finally {
				objDragonfly.objSeleniumVariables.gobjWebElement = objDragonfly.objSeleniumVariables.gobjWebElementPleaseWait;
			}
			//			}
			//			if (blnFound == true && blnHidden == false) {
			//				new ElementHidden().run(objDragonfly);
			//				blnHidden = true;
			//			if (objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed() == false) {
			//			} else {
			//				//objDragonfly.objLogger.setLogRow("elementHidden: gobjWebElement.isDisplayed() = return true MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
			//				throw new ExceptionElementNotHidden("Element is displayed.");
			//			}
		}
	}

	public class ElementSetJavascriptExecutor {
		public ElementSetJavascriptExecutor(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet {
			objDragonfly.objLogger.setLogRow("  ==start==>elementSet " + new DateTimestamp().get());
			long lngStartTimeElementSet = System.currentTimeMillis();
			Boolean blnSet = false;
			JavascriptExecutor objJavascriptExecutor = null;
			// String strOuterHTML = "";
			if (objDragonfly.objSeleniumVariables.gobjWebElement != null) {
				objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
			}
			try {
				// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				//long lngStartTimeOuterHTML = System.currentTimeMillis();
				// strOuterHTML = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("outerHTML");
				// objDragonfly.objLogger.setLogRow("elementSet outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeOuterHTML));
				// objDragonfly.objLogger.setLogRow(strOuterHTML);
				switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
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
					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString().toLowerCase()) {
					case "":
					case "<click>":
						//objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
						objDragonfly.objSeleniumVariables.gobjWebElement.click();
						// set_js
						//objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
						// ///objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
						// objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						objAction.moveToElement(objDragonfly.objSeleniumVariables.gobjWebElement).doubleClick().build().perform();
						break;
					}
					break;
				case "input_text":
				case "input_password":
				case "textarea":
				case "input_email":
					blnSet = true;
					objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
					objJavascriptExecutor.executeScript("arguments[0].value = '';", objDragonfly.objSeleniumVariables.gobjWebElement);
					objDragonfly.objSeleniumVariables.gobjWebElement.sendKeys(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
					objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
					break;
				// //objDragonfly.objSeleniumVariables.gobjWebElement.click();
				// objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].value = '';", objDragonfly.objSeleniumVariables.gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].value = '" + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString() + "';", objDragonfly.objSeleniumVariables.gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].onkeydown();", objDragonfly.objSeleniumVariables.gobjWebElement);
				// // objJavascriptExecutor.executeScript("arguments[0].onkeyup();", objDragonfly.objSeleniumVariables.gobjWebElement);
				// objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
				// objDragonfly.objLogger.setLogRow("onchange before");
				// if (strOuterHTML.toLowerCase().contains("onchange")) {
				// try {
				// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
				// } catch (WebDriverException e) {
				// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
				// }
				// }
				// break;
				case "input_radio":
					blnSet = true;
					objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
					// objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
					objDragonfly.objSeleniumVariables.gobjWebElement.click();
					objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
					// if (strOuterHTML.toLowerCase().contains("onchange")) {
					// try {
					// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
					//
					// } catch (WebDriverException e) {
					// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
					// }
					// }
					break;
				case "input_checkbox":
					blnSet = true;
					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString().toLowerCase()) {
					case "<on>":
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
							// objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
							// if (strOuterHTML.toLowerCase().contains("onchange")) {
							// try {
							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
							// } catch (WebDriverException e) {
							// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
							// }
							// }
						}
						break;
					case "<off>":
						blnSet = true;
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == true) {
							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
							// objJavascriptExecutor.executeScript("arguments[0].click();", objDragonfly.objSeleniumVariables.gobjWebElement);
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
							// if (strOuterHTML.toLowerCase().contains("onchange")) {
							// try {
							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
							// } catch (WebDriverException e) {
							// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
							// }
							// }
						}
						break;
					}
					break;
				case "select":
					Select objSelect = new Select(objDragonfly.objSeleniumVariables.gobjWebElement);
					objSelect.getOptions();
					objSelect.selectByVisibleText(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
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
					//					            intMillisecondsWaited = CDbl((Timer - intStartTime) * 1000)
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
					// Set objDragonfly.objSeleniumVariables.gobjWebElement = objDragonfly.objSeleniumVariables.gobjWebElement.AsTable
					break;
				case "alert":
					blnSet = true;
					//Alert alert = objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert();
					//objDragonfly.objLogger.setLogRow(gobjAlert.getText()); // Print Alert popup
					objDragonfly.objLogger.setLogRow("elementSet: " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase());
					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
					case "edit":
						//gobjAlert.sendKeys(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().sendKeys(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
						break;
					case "accept":
						//	gobjAlert.accept(); // Close Alert popup
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().accept(); // Close Alert popup
						break;
					case "dismiss":
						//gobjAlert.dismiss();// Close Alert popup
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().dismiss();// Close Alert popup
						break;
					}
					break;
				default:
					throw new ExceptionElementTagNameNotSupported("Element tag not supported");
				}
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("elementSet: Exception = " + e.toString());
			} finally {
				if (blnSet == false) {
					throw new ExceptionElementNotSet("Element not set");
				}
				objDragonfly.objLogger.setLogRow("elementSet: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
			}
		}
	}

	public class ElementSet {
		public ElementSet(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionVisibleTextNotInSelectList {
			objDragonfly.objLogger.setLogRow("  ==start==>elementSet " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("elementSet: " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase());
			long lngStartTimeElementSet = System.currentTimeMillis();
			String strInputValue = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			String strValueToSelect = "";
			try {
				//Iterator<WebElement> b;
				// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
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
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", "<click>");
						objDragonfly.objSeleniumVariables.gobjWebElement.click();
						break;
					case "<doubleclick>":
						Actions objAction = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
						objAction.moveToElement(objDragonfly.objSeleniumVariables.gobjWebElement).doubleClick().build().perform();
						break;
					case "<rightclick>":
						//ToDo add right click code
						break;
					case "default":
						//ToDo add default error handling for non supported text
						break;
					}
					break;
				case "input_text":
				case "input_password":
				case "textarea":
				case "input_email":
					if (objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value").isEmpty() == false) {
						objDragonfly.objSeleniumVariables.gobjWebElement.clear();
					}
					objDragonfly.objSeleniumVariables.gobjWebElement.sendKeys(strInputValue);
					break;
				case "input_radio":
					//					//ToDo fix this to turn <on> and <off>
					//					objDragonfly.objSeleniumVariables.gobjWebElement.click();
					//					break;
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", "<click>");
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
						}
						break;
					case "default":
						//ToDo add default error handling for non supported text
						break;
					}
					break;
				case "input_checkbox":
					switch (strInputValue.toLowerCase()) {
					case "":
					case "<on>":
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strInputValue", "<click>");
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
						}
						break;
					case "<off>":
						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == true) {
							objDragonfly.objSeleniumVariables.gobjWebElement.click();
						}
						break;
					case "default":
						//ToDo add default error handling for non supported text
						break;
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
					// Set objDragonfly.objSeleniumVariables.gobjWebElement = objDragonfly.objSeleniumVariables.gobjWebElement.AsTable
					break;
				case "alert":
					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
					case "edit":
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().sendKeys(strInputValue);
						break;
					case "accept":
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().accept();
						break;
					case "dismiss":
						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().dismiss();
						break;
					}
					break;
				default:
					throw new ExceptionElementTagNameNotSupported("Element tag {" + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase() + "} not supported");
				}
			} finally {
				objDragonfly.objLogger.setLogRow("elementSet: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
			}
		}
	}

	//	public class ElementSetOriginal {
	//		public ElementSetOriginal(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet {
	//			objDragonfly.objLogger.setLogRow("  ==start==>elementSet " + new DateTimestamp().get());
	//			objDragonfly.objLogger.setLogRow("elementSet: " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase());
	//			long lngStartTimeElementSet = System.currentTimeMillis();
	//			Boolean blnSet = false;
	//			String strTagNameNotSupported = "";
	//			try {
	//				// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	//				// objDragonfly.objSeleniumVariables.gobjWebDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
	//				switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
	//				case "a":
	//				case "button":
	//				case "div":
	//				case "h1":
	//				case "h2":
	//				case "h3":
	//				case "h4":
	//				case "h5":
	//				case "h6":
	//				case "img":
	//				case "input_button":
	//				case "input_image":
	//				case "input_reset":
	//				case "input_submit":
	//				case "li":
	//				case "p":
	//				case "span":
	//				case "td":
	//				case "th":
	//				case "tr":
	//					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString().toLowerCase()) {
	//					case "":
	//					case "<click>":
	//						objDragonfly.objSeleniumVariables.gobjWebElement.click();
	//						break;
	//					case "<doubleclick>":
	//						Actions objAction = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
	//						objAction.moveToElement(objSeleniumVariables.gobjWebElement).doubleClick().build().perform();
	//						break;
	//					}
	//					blnSet = true;
	//					break;
	//				case "input_text":
	//				case "input_password":
	//				case "textarea":
	//				case "input_email":
	//					if (objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value").isEmpty() == false) {
	//						objDragonfly.objSeleniumVariables.gobjWebElement.clear();
	//					}
	//					objDragonfly.objSeleniumVariables.gobjWebElement.sendKeys(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
	//					blnSet = true;
	//					break;
	//				case "input_radio":
	//					objDragonfly.objSeleniumVariables.gobjWebElement.click();
	//					blnSet = true;
	//					break;
	//				case "input_checkbox":
	//					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString().toLowerCase()) {
	//					case "<on>":
	//						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
	//							objDragonfly.objSeleniumVariables.gobjWebElement.click();
	//						}
	//						break;
	//					case "<off>":
	//						blnSet = true;
	//						if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == true) {
	//							objDragonfly.objSeleniumVariables.gobjWebElement.click();
	//						}
	//						break;
	//					}
	//					blnSet = true;
	//					break;
	//				case "select":
	//					Select objSelect = new Select(objDragonfly.objSeleniumVariables.gobjWebElement);
	//					objSelect.getOptions();
	//					objSelect.selectByVisibleText(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
	//					// set_js
	//					//					int intOptionsEach;
	//					//					String strOptions = "";
	//					//					String[] arrOptions;
	//					//					strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", objDragonfly.objSeleniumVariables.gobjWebElement);
	//					//					strOptions = strOptions.substring(1);
	//					//					arrOptions = strOptions.split("\\|");
	//					//					for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
	//					//						objDragonfly.objLogger.setLogRow("elementSet: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
	//					//						if (arrOptions[intOptionsEach].toString().equals(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString())) {
	//					//							blnSet = true;
	//					//							Select objSelect = new Select(objDragonfly.objSeleniumVariables.gobjWebElement);
	//					//							objJavascriptExecutor.executeScript("arguments[0].focus();", objDragonfly.objSeleniumVariables.gobjWebElement);
	//					//							objSelect.selectByIndex(intOptionsEach);
	//					//							objJavascriptExecutor.executeScript("arguments[0].blur();", objDragonfly.objSeleniumVariables.gobjWebElement);
	//					//							// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", objDragonfly.objSeleniumVariables.gobjWebElement);
	//					//							// if (strOuterHTML.toLowerCase().contains("onchange")) {
	//					//							// try {
	//					//							// objJavascriptExecutor.executeScript("arguments[0].onchange();", objDragonfly.objSeleniumVariables.gobjWebElement);
	//					//							// } catch (WebDriverException e) {
	//					//							// objDragonfly.objLogger.setLogRow("elementSet = " + e.toString());
	//					//							// }
	//					//							// }
	//					//							break;
	//					//						}
	//					//					}
	//					blnSet = true;
	//					break;
	//				case "table":
	//					// Set objDragonfly.objSeleniumVariables.gobjWebElement = objDragonfly.objSeleniumVariables.gobjWebElement.AsTable
	//					break;
	//				case "alert":
	//					switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
	//					case "edit":
	//						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().sendKeys(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString());
	//						break;
	//					case "accept":
	//						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().accept();
	//						break;
	//					case "dismiss":
	//						objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().dismiss();
	//						break;
	//					}
	//					blnSet = true;
	//					break;
	//				default:
	//					strTagNameNotSupported = "Element tag {" + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase() + "} not supported";
	//				}
	//			} finally {
	//				if (strTagNameNotSupported.isEmpty() == false) {
	//					throw new ExceptionElementTagNameNotSupported(strTagNameNotSupported);
	//				} else {
	//					if (blnSet == false) {
	//						throw new ExceptionElementNotSet("Element not set");
	//					}
	//				}
	//				objDragonfly.objLogger.setLogRow("elementSet: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet));
	//			}
	//		}
	//	}
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
							objDragonfly.objLogger.setLogRow("elementSetSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible().run(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled().run(objDragonfly);
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
							new ElementHidden().run(objDragonfly);
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
							new ElementVisible().run(objDragonfly);
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
							new ElementVisible().run(objDragonfly);
							new ElementEnabled().run(objDragonfly);
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
							new ElementVisible().run(objDragonfly);
							new ElementDisabled().run(objDragonfly);
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
				} catch (ExceptionElementTagNameNotSupported e) {
					blnExit = true;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionVisibleTextNotInSelectList e) {
					blnSet = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnAssert = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionValueNotMatched e) {
					blnFound = false;
					blnAssert = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotSet e) {
					blnSet = false;
					blnAssert = false;
				} catch (ExceptionElementNotDisabled e) {
					blnAssert = false;
					objDragonfly.objLogger.setLogRow("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionDoPostBackNotComplete | ExceptionJQueryAjaxNotComplete | ExceptionJQueryAnimationNotComplete | ExceptionAngularJsNotComplete | ExceptionPleaseWaitNotComplete e) {
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
			objDragonfly.objLogger.setLogRow("waitForReadyState: document.readyState MillisecondsWaited = " + ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return document.readyState"));
			return false;
		}
	}

	public class ElementSetSyncComplete {
		public ElementSetSyncComplete(Dragonfly objDragonfly, String strOuterHTML) throws ExceptionDoPostBackNotComplete, ExceptionJQueryAjaxNotComplete, ExceptionJQueryAnimationNotComplete, ExceptionAngularJsNotComplete, ExceptionPleaseWaitNotComplete {
			objDragonfly.objLogger.setLogRow("  ==start==>elementSetSyncComplete " + new DateTimestamp().get());
			long lngTimeStart = System.currentTimeMillis();
			try {
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: ElementPleaseWait Start " + System.currentTimeMillis());
				try {
					new ElementPleaseWait(objDragonfly);
				} catch (ExceptionElementNotHidden e1) {
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: ExceptionElementNotHidden = " + e1.toString());
					throw new ExceptionPleaseWaitNotComplete("");
				}
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: ElementPleaseWait complete " + System.currentTimeMillis());
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: alertFind Start");
				if (new AlertFind().run(objDragonfly) == true) {
					return;
				}
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: alertFind complete");
				new WaitForReadyState().run(objDragonfly);
				// JavascriptExecutor objJavascriptExecutor = null;
				// objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
				// waitForAngularRequestsToFinish(objJavascriptExecutor);
				boolean blnEventTarget = false;
				if (strOuterHTML.contains("__doPostBack")) {
					long lngStartTimeElementSet__EVENTTARGET = System.currentTimeMillis();
					try {
						objDragonfly.objLogger.setLogRow("elementSetSyncComplete: __EVENTTARGET value = " + objDragonfly.objSeleniumVariables.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
						blnEventTarget = !objDragonfly.objSeleniumVariables.gobjWebDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
					} catch (Exception e) {
						objDragonfly.objLogger.setLogRow("elementSetSyncComplete: Exception = " + e.toString());
					}
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: blnEventTarget = " + blnEventTarget);
					if (blnEventTarget == true) {
						throw new ExceptionAngularJsNotComplete("");
					}
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: lngStartTimeElementSet__EVENTTARGET MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementSet__EVENTTARGET));
				}
				//long lngStartTimeElementSetJQueryActive = System.currentTimeMillis();
				boolean blnJquery = false;
				long lngJqueryActive = 0;
				try {
					// objDragonfly.objLogger.setLogRow("elementSet blnJquery = " + ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.jQuery != null);"));
					blnJquery = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.jQuery != null);");
					if (blnJquery == true) {
						lngJqueryActive = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (jQuery.active);");
						objDragonfly.objLogger.setLogRow("elementSetSyncComplete: lngJqueryActive = " + lngJqueryActive);
						// objDragonfly.objLogger.setLogRow("elementSet both = " + ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
					}
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: JqueryActive Exception = " + e.toString());
				}
				if (lngJqueryActive > 0) {
					// blnResult = false;
					throw new ExceptionJQueryAjaxNotComplete("");
				}
				// long lngStartTimeElementSetJQueryAnimate = System.currentTimeMillis();
				long lngElementsAnimated = 0;
				boolean blnJqueryExist = false;
				try {
					blnJqueryExist = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.jQuery != null);");
					if (blnJqueryExist == true) {
						lngElementsAnimated = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return $(\":animated\").length");
						objDragonfly.objLogger.setLogRow("elementSetSyncComplete: JQueryAnimate = " + lngElementsAnimated);
						// objDragonfly.objLogger.setLogRow("elementSetSyncComplete JQueryAnimate = " + ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return $(\":animated\").length"));
					}
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: JQueryAnimate Exception = " + e.toString());
				}
				if (lngElementsAnimated > 0) {
					throw new ExceptionJQueryAnimationNotComplete("");
				}
				//long lngStartTimeElementSetAngularJS = System.currentTimeMillis();
				boolean blnAngularJs = false;
				long lngAngularJsInjectorActive = 0;
				try {
					blnAngularJs = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.angular != null);");
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: blnAngularJs = " + blnAngularJs);
					// boolean blnAngularJs2 = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.angular == null);");
					// objDragonfly.objLogger.setLogRow("elementSet blnAngularJs2 = " + blnAngularJs2);
					// if (blnAngularJs == true) {
					lngAngularJsInjectorActive = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: lngJqueryActive = " + lngAngularJsInjectorActive);
					// }
					// boolean blnAngularJsInjector = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (angular.element(document).injector() != null);");
					// objDragonfly.objLogger.setLogRow("elementSet blnAngularJsInjector = " + blnAngularJsInjector);
					// blnAngularJS = (boolean) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get(‘$http’).pendingRequests.length === 0)");
					// objDragonfly.objLogger.setLogRow("elementSet blnAngularJS = " + blnAngularJS);
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("elementSetSyncComplete: AngularJS Exception = " + e.toString());
				}
				if (lngAngularJsInjectorActive > 0) {
					throw new ExceptionAngularJsNotComplete("");
				}
			} catch (NoSuchWindowException e) {
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				objDragonfly.objLogger.setLogRow("elementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
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
							objDragonfly.objLogger.setLogRow("elementDragSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						objDragonfly.objLogger.setLogRow("elementDragSync: strOuterHTML over");
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible().run(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled().run(objDragonfly);
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
							objDragonfly.objLogger.setLogRow("elementDropSync: outerHTML MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
						}
						objDragonfly.objLogger.setLogRow("elementDropSync: strOuterHTML over");
						blnFound = true;
					}
					if (blnVisible == false) {
						new ElementVisible().run(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled().run(objDragonfly);
						blnEnabled = true;
					}
					objDragonfly.objSeleniumVariables.gobjWebElementDrop = objDragonfly.objSeleniumVariables.gobjWebElement;
					//Actions actions = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					//actions.dragAndDrop(objDragonfly.objSeleniumVariables.gobjWebElementDrag, objDragonfly.objSeleniumVariables.gobjWebElementDrop).perform();
					//				Actions action = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					//				Action dragDrop = action.dragAndDrop(gobjWebElementDrag, objDragonfly.objSeleniumVariables.gobjWebElementDrop).build();
					//				dragDrop.perform();
					Actions objActions = new Actions(objDragonfly.objSeleniumVariables.gobjWebDriver);
					Action objDragAndDrop = objActions.clickAndHold(objDragonfly.objSeleniumVariables.gobjWebElementDrag).moveToElement(objDragonfly.objSeleniumVariables.gobjWebElementDrop).pause(2000).release(objDragonfly.objSeleniumVariables.gobjWebElementDrop).build();
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

	public class ElementVerifyValue {
		public String run(Dragonfly objDragonfly) throws ExceptionValueNotMatched, ExceptionElementTagNameNotSupported {
			objDragonfly.objLogger.setLogRow("  ==start==>elementVerifyValue " + new DateTimestamp().get());
			long lngStartTimeElementVerify = System.currentTimeMillis();
			String strActualValue = "";
			String strGetValue = "";
			String strValueExpected = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString();
			try {
				strGetValue = new ElementGet().run(objDragonfly);
				strActualValue = new VerifyMatch().run(objDragonfly, strGetValue, strValueExpected);
			} finally {
				objDragonfly.objLogger.setLogRow("elementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} intMillisecondsWaited = " + (int) (System.currentTimeMillis() - lngStartTimeElementVerify));
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
						new ElementVisible().run(objDragonfly);
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
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotVisible e) {
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementTagNameNotSupported e) {
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
					blnExit = true;
				} catch (ExceptionValueNotMatched e) {
					blnVerified = false;
					blnStatus = false;
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					objDragonfly.objLogger.setLogRow("elementVerifyValueSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
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
			objDragonfly.objLogger.setLogRow("  ==start==>verifyMatch " + new DateTimestamp().get());
			long lngStartTimeVerifyMatch = System.currentTimeMillis();
			try {
				if (strExpected.toLowerCase().startsWith("re:")) {
					String strPattern = strExpected.substring(3);
					return new RegularExpressionMatch().run(objDragonfly, strPattern, strActual);
				} else {
					if (strExpected.equals(strActual)) {
						return strActual;
					} else {
						throw new ExceptionValueNotMatched("verifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
					}
				}
			} catch (Exception e) {
				throw new ExceptionValueNotMatched("verifyMatch did not match strActual = {" + strActual + "} strExpected = {" + e.toString() + "}");
			} finally {
				objDragonfly.objLogger.setLogRow("verifyMatch: finally strActual = {" + strActual + "} strExpected = {" + strExpected + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeVerifyMatch));
			}
		}
	}

	public class RegularExpressionMatch {
		public String run(Dragonfly objDragonfly, String strPattern, String strActualValue) {
			objDragonfly.objLogger.setLogRow("  ==start==>regularExpressionMatch " + new DateTimestamp().get());
			Matcher objMatcher = Pattern.compile(strPattern).matcher(strActualValue);
			boolean blnMatches = objMatcher.matches();
			String strMatchedString = objMatcher.group(0);
			objDragonfly.objLogger.setLogRow("RegularExpressionMatch: regularExpressionMatch = " + strMatchedString);
			return strMatchedString;
		}
	}

	public class Sleep {
		public Sleep(Dragonfly objDragonfly) {
			new SleepMilliseconds(objDragonfly, Integer.parseInt(objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strInputValue").toString()));
		}
	}

	public class SleepSync {
		public SleepSync(Dragonfly objDragonfly) {
			new Sleep(objDragonfly);
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
		public void start(Dragonfly objDragonfly) {
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

	public class clipboardGet {
		public String run(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>clipboardGet " + new DateTimestamp().get());
			String strClipboardData = "";
			try {
				strClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				objDragonfly.objLogger.setLogRow("clipboardGet: strClipboardData = " + strClipboardData);
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("clipboardGet: Exception = " + e.toString());
			}
			return strClipboardData;
		}
	}

	public class ValidateTagType {
		public boolean run(Dragonfly objDragonfly, String strTagType) {
			objDragonfly.objLogger.setLogRow("  ==start==>validateTagType " + new DateTimestamp().get());
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
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strType").toString().toLowerCase().length() == 0) {
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
					throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
				}
			}
		}
	}

	//	public class ElementFindByXpath {
	//		public ElementFindByXpath(Dragonfly objDragonfly, String strAttributeNames, String strAttributeValues) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
	//			objDragonfly.objLogger.setLogRow("  ==start==>ElementFindByXpath " + new DateTimestamp().get());
	//			int intAttributeEach = 0;
	//			List<WebElement> objWebElementCollection = new ArrayList<WebElement>();
	//			//			String arrAttributeNames[] = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeNames").toString().split("\\|", -1);
	//			//			String arrAttributeValues[] = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().split("\\|", -1);
	//			String arrAttributeNames[] = strAttributeNames.toString().split("\\|", -1);
	//			String arrAttributeValues[] = strAttributeValues.toString().split("\\|", -1);
	//			String strIndex = "";
	//			String strIndexKeyword = "";
	//			String strTagName = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase();
	//			String strXpath = "";
	//			String strXpathAttributes = "";
	//			String strXpathAttributesTemp = "";
	//			for (intAttributeEach = 0; intAttributeEach < arrAttributeNames.length; intAttributeEach++) {
	//				strXpathAttributesTemp = "";
	//				switch (arrAttributeNames[intAttributeEach].toLowerCase()) {
	//				case "xpath":
	//					strXpathAttributesTemp = arrAttributeValues[intAttributeEach];
	//					break;
	//				case "index":
	//					if (arrAttributeValues[intAttributeEach].equals("<last>")) {
	//						strIndex = "";
	//						strIndexKeyword = "<last>";
	//					} else if (arrAttributeValues[intAttributeEach].equals("<random>")) {
	//						strIndex = "";
	//						strIndexKeyword = "<random>";
	//					} else {
	//						strIndex = "[" + arrAttributeValues[intAttributeEach] + "]";
	//					}
	//					break;
	//				case "text":
	//					if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
	//						strXpathAttributesTemp = "contains(text()" + ", '" + arrAttributeValues[intAttributeEach].substring(3) + "')";
	//					} else {
	//						strXpathAttributesTemp = "text()='" + arrAttributeValues[intAttributeEach] + "' ";
	//					}
	//					break;
	//				default:
	//					if (arrAttributeNames[intAttributeEach].toLowerCase().equals("type")) {
	//						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strType", arrAttributeValues[intAttributeEach]);
	//					}
	//					if (arrAttributeValues[intAttributeEach].toLowerCase().startsWith("re:")) {
	//						strXpathAttributesTemp = "contains(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + arrAttributeValues[intAttributeEach].substring(3).toLowerCase() + "')";
	//					} else {
	//						strXpathAttributesTemp = "@" + arrAttributeNames[intAttributeEach] + "='" + arrAttributeValues[intAttributeEach] + "'";
	//					}
	//					break;
	//				}
	//				if (arrAttributeNames[0].toLowerCase().equals("xpath") == false) {
	//					if (strXpathAttributesTemp.trim().length() != 0) {
	//						if (strXpathAttributes.trim().length() == 0) {
	//							strXpathAttributes = strXpathAttributesTemp;
	//						} else {
	//							strXpathAttributes = strXpathAttributes + " and " + strXpathAttributesTemp;
	//						}
	//					}
	//				}
	//			}
	//			
	//			
	//			if (arrAttributeNames[0].toLowerCase().equals("xpath")) {
	//				strXpath = strXpathAttributesTemp;
	//			} else {
	//				if (strXpathAttributes.trim().length() == 0) {
	//					strXpathAttributes = "";
	//				} else {
	//					strXpathAttributes = "[" + strXpathAttributes + "]";
	//				}
	//				strXpath = "(//" + strTagName + strXpathAttributes + ")" + strIndex;
	//			}
	//			objDragonfly.objLogger.setLogRow("ElementFindByXpath: arrAttributeNames[0].toLowerCase() = " + arrAttributeNames[0].toLowerCase());
	//			objDragonfly.objLogger.setLogRow("ElementFindByXpath: strXpathAttributesTemp = " + strXpathAttributesTemp);
	//			objDragonfly.objLogger.setLogRow("ElementFindByXpath: strXpath = " + strXpath);
	//			objDragonfly.objLogger.setLogRow("ElementFindByXpath: strXpathAttributes = " + strXpathAttributes);
	//			objWebElementCollection = objDragonfly.objSeleniumVariables.gobjWebDriver.findElements(By.xpath(strXpath));
	//			switch (objWebElementCollection.size()) {
	//			case 0:
	//				throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
	//			case 1:
	//				objDragonfly.objSeleniumVariables.gobjWebElement = objWebElementCollection.get(0);
	//				break;
	//			default:
	//				if (strIndexKeyword.equals("<last>")) {
	//					objDragonfly.objSeleniumVariables.gobjWebElement = objWebElementCollection.get(objWebElementCollection.size() - 1);
	//					break;
	//				} else if (strIndexKeyword.equals("<random>")) {
	//					int intRandomElement = new RandomNumberRange().run(objDragonfly, 0, objWebElementCollection.size() - 1);
	//					objDragonfly.objSeleniumVariables.gobjWebElement = objWebElementCollection.get(intRandomElement);
	//					break;
	//				} else {
	//					objDragonfly.objLogger.setLogRow("ElementFindByXpath: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
	//					throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
	//				}
	//			}
	//			//			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strCurrentWindowHandle", objDragonfly.objSeleniumVariables.gobjWebDriver.getWindowHandle());
	//			//			if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("input")) {
	//			//				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strType").toString().toLowerCase().length() == 0) {
	//			//					objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strType", objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("type"));
	//			//				}
	//			//				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strTagType", "input_" + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strType").toString());
	//			//			} else {
	//			//				objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strTagType", objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString());
	//			//			}
	//		}
	//	}
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
			//objDragonfly.objLogger.setLogRow("ElementJavascriptExecutorGetElementsByTagName objCollectionJS2 = " + objCollectionJS2.size() + " strTagName = " + strTagName + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimegetElementsByTagName2));
			//if (objCollectionJS2.size() > 0) {
			//	long lngStartTimeByXpath = System.currentTimeMillis();
			//}
		}
	}

	public class CoordinatesAlert {
		public CoordinatesAlert(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>coordinatesAlert " + new DateTimestamp().get());
			AutoItX objAutoIt = objDragonfly.objAutoItSetObject.getObject();
			long lngStartTimeElementCoordinatesAlert = System.currentTimeMillis();
			int intClientSizeHeight = 0;
			int intClientSizeWidth = 0;
			int intControlPosHeight = 0;
			int intControlPosWidth = 0;
			int intControlPosX = 0;
			int intControlPosY = 0;
			//AutoItSetObject objAutoItSetObject = objDragonfly.new AutoItSetObject(objDragonfly);
			//AutoItX gobjAutoIt = null;
			//AutoItX gobjAutoIt = objAutoItSetObject.getObject();
			//AutoItX gobjAutoIt2 = objDragonfly.gobjAutoIt;
			//		AutoItSetObject objAutoIt = objDragonfly.new AutoItSetObject();
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
			objDragonfly.objLogger.setLogRow("coordinatesAlert: objDragonfly.objJsonVariables.gobjJsonObjectStep.get(strAttributeValues).toString().toLowerCase(): = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase());
			objDragonfly.objLogger.setLogRow("coordinatesAlert: strText: = " + strText);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: strControlID: = " + strControlID);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosHeight: = " + intWinPosHeight);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosWidth: = " + intWinPosWidth);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosX: = " + intWinPosX);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: intWinPosY: = " + intWinPosY);
			switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase()) {
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
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementScreenX", Integer.toString(intWinPosX));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementScreenY", Integer.toString(intWinPosY));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementWidth", Integer.toString(intWinPosWidth));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intElementHeight", Integer.toString(intWinPosHeight));
			objDragonfly.objLogger.setLogRow("coordinatesAlert: winGetTitle: = " + strWinTitle);
			objDragonfly.objLogger.setLogRow("coordinatesAlert: objDragonfly.objJsonVariables.gobjJsonObjectStep.get(intElementHeight): = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementHeight"));
			objDragonfly.objLogger.setLogRow("coordinatesAlert: objDragonfly.objJsonVariables.gobjJsonObjectStep.get(intElementWidth): = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementWidth"));
			objDragonfly.objLogger.setLogRow("coordinatesAlert: objDragonfly.objJsonVariables.gobjJsonObjectStep.get(intElementScreenX): = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementScreenX"));
			objDragonfly.objLogger.setLogRow("coordinatesAlert: objDragonfly.objJsonVariables.gobjJsonObjectStep.get(intElementScreenY): = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("intElementScreenY"));
			objDragonfly.objLogger.setLogRow("coordinatesAlert: coordinatesAlert finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinatesAlert));
		}
	}

	public class CoordinatesBrowserInner {
		public CoordinatesBrowserInner(Dragonfly objDragonfly) throws WebDriverException {
			objDragonfly.objLogger.setLogRow("  ==start==>coordinatesBrowserInner " + new DateTimestamp().get());
			long lngBrowserInnerWidth = 0;
			long lngBrowserInnerHeight = 0;
			try {
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;");
			} catch (WebDriverException e) {
				throw new WebDriverException("WebDriverException returned");
			} catch (Exception e) {
				lngBrowserInnerWidth = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return document.body.offsetWidth;");
				lngBrowserInnerHeight = (long) ((JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver).executeScript("return document.body.offsetHeight;");
			}
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
			objDragonfly.objJsonObjectStepPut.run(objDragonfly, "intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
		}
	}

	public class CoordinatesElement {
		public CoordinatesElement(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>coordinatesElement " + new DateTimestamp().get());
			long lngStartTimeElementCoordinates = System.currentTimeMillis();
			try {
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
				objDragonfly.objLogger.setLogRow("coordinatesElement: coordinatesElement objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.containsKey("intElementX"));
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
				objDragonfly.objLogger.setLogRow("coordinatesElement: Exception = " + e.toString());
			} finally {
				objDragonfly.objLogger.setLogRow("coordinatesElement: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementCoordinates));
			}
		}
	}

	public class ElementVisible {
		public boolean run(Dragonfly objDragonfly) throws ExceptionElementNotVisible {
			// TODO elementVisible add check for class and css, commented code needs to be tested
			objDragonfly.objLogger.setLogRow("  ==start==>elementVisible " + new DateTimestamp().get());
			long lngStartTimeElementVisible = System.currentTimeMillis();
			Boolean blnVisible = false;
			try {
				// TODO Alert complete
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("title")) {
					blnVisible = true;
					return true;
				}
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					if (new AlertFind().run(objDragonfly) == true) {
						blnVisible = true;
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strHighlightArea", "alert");
						new CoordinatesAlert(objDragonfly);
						return true;
					} else {
						throw new ExceptionElementNotVisible("Alert popup was not found.");
					}
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed()) {
					new CoordinatesElement(objDragonfly);
					blnVisible = true;
					return true;
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
				objDragonfly.objLogger.setLogRow("elementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementVisible));
			}
		}
	}

	public class ElementVisibleSync {
		public ElementVisibleSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementVisibleSync " + new DateTimestamp().get());
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
						new ElementVisible().run(objDragonfly);
						blnVisible = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					objDragonfly.objLogger.setLogRow("elementVisibleSync: " + e.toString() + "  lngMillisecondsWaitedAll = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementVisibleSync", "syncvisible", lngTimeStart) == true) {
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
		public boolean run(Dragonfly objDragonfly) throws ExceptionElementNotHidden {
			objDragonfly.objLogger.setLogRow("  ==start==>elementHidden " + new DateTimestamp().get());
			long lngStartTimeElementHidden = System.currentTimeMillis();
			try {
				// TODO Alert complete
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					if (new AlertFind().run(objDragonfly) == false) {
						objDragonfly.objJsonObjectStepPut.run(objDragonfly, "strHighlightArea", "screen");
						objDragonfly.objLogger.setLogRow("elementHidden: strAreaObjectName = " + objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strHighlightArea"));
						return true;
					} else {
						throw new ExceptionElementNotHidden("Alert popup was not hidden.");
					}
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isDisplayed() == false) {
					return true;
				} else {
					objDragonfly.objLogger.setLogRow("elementHidden: gobjWebElement.isDisplayed() = return true MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
					throw new ExceptionElementNotHidden("Element is displayed.");
				}
			} catch (NullPointerException | WebDriverException e) {
				objDragonfly.objLogger.setLogRow("elementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
				return true;
			} finally {
				objDragonfly.objLogger.setLogRow("elementHidden: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementHidden));
			}
		}
	}

	public class ElementHiddenSync {
		public ElementHiddenSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementHiddenSync " + new DateTimestamp().get());
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
					if (blnFound == true && blnHidden == false) {
						new ElementHidden().run(objDragonfly);
						blnHidden = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ExceptionElementNotFound e) {
					blnFound = false;
					blnHidden = true;
					blnStatus = true;
					objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionMultipleElementsFound e) {
					blnFound = false;
					blnHidden = false;
					objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotHidden e) {
					blnHidden = false;
					objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (Exception e) {
					blnFound = false;
					blnHidden = false;
					objDragonfly.objLogger.setLogRow("elementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementHiddenSync", "synchidden", lngTimeStart) == true) {
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
		public boolean run(Dragonfly objDragonfly) throws ExceptionElementNotEnabled {
			objDragonfly.objLogger.setLogRow("  ==start==>elementEnabled " + new DateTimestamp().get());
			long lngStartTimeElementEnabled = System.currentTimeMillis();
			try {
				if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
					if (new AlertFind().run(objDragonfly) == true) {
						return true;
					} else {
						throw new ExceptionElementNotEnabled("Alert popup was not found.");
					}
				}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isEnabled()) {
					return true;
				} else {
					throw new ExceptionElementNotEnabled("elementEnabled - Element is not enabled");
				}
			} finally {
				objDragonfly.objLogger.setLogRow("elementEnabled: finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementEnabled));
			}
		}
	}

	public class ElementEnabledSync {
		public ElementEnabledSync(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>elementEnabledSync " + new DateTimestamp().get());
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
						new ElementVisible().run(objDragonfly);
						blnVisible = true;
					}
					if (blnEnabled == false) {
						new ElementEnabled().run(objDragonfly);
						blnEnabled = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("elementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotEnabled e) {
					blnEnabled = false;
					objDragonfly.objLogger.setLogRow("elementEnabledSync: " + e.toString() + " Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
				} finally {
					if (new SyncFinally().run(objDragonfly, blnExit, blnStatus, blnFound, "elementEnabledSync", "syncenabled", lngTimeStart) == true) {
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
		public boolean run(Dragonfly objDragonfly) throws ExceptionElementNotDisabled {
			objDragonfly.objLogger.setLogRow("  ==start==>elementDisabled " + new DateTimestamp().get());
			long lngStartTimeElementDisabled = System.currentTimeMillis();
			try {
				//			if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagName").toString().toLowerCase().equals("alert")) {
				//				if (alertFind() == true) {
				//					return true;
				//				} else {
				//					throw new ExceptionElementNotDisabled("Alert popup was not found.");
				//				}
				//			}
				if (objDragonfly.objSeleniumVariables.gobjWebElement.isEnabled()) {
					throw new ExceptionElementNotDisabled("elementDisabled - Element is not disabled");
				} else {
					return true;
				}
			} finally {
				objDragonfly.objLogger.setLogRow("elementDisabled: finally intMillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementDisabled));
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
						new ElementVisible().run(objDragonfly);
						blnVisible = true;
					}
					if (blnDisabled == false) {
						new ElementDisabled().run(objDragonfly);
						blnDisabled = true;
					}
					blnStatus = true;
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound | ExceptionElementNotVisible e) {
					blnFound = false;
					blnVisible = false;
					blnDisabled = false;
					objDragonfly.objLogger.setLogRow("elementDisabledSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
				} catch (ExceptionElementNotDisabled e) {
					blnDisabled = false;
					objDragonfly.objLogger.setLogRow("elementDisabledSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
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
			long lngStartTimeElementGet = System.currentTimeMillis();
			AutoItX objAutoIt = objDragonfly.objAutoItSetObject.getObject();
			String strElementGet = "";
			try {
				switch (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strTagType").toString().toLowerCase()) {
				case "title":
					strElementGet = objDragonfly.objSeleniumVariables.gobjWebDriver.getTitle();
					return strElementGet;
				case "img":
					strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("src");
					return strElementGet;
				case "input_button":
				case "input_submit":
				case "input_reset":
				case "input_image":
				case "button":
					strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value").trim();
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
					strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getText();
					return strElementGet;
				case "input_text":
				case "input_password":
				case "textarea":
				case "input_email":
					strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getAttribute("value");
					return strElementGet;
				case "input_radio":
				case "input_checkbox":
					if (objDragonfly.objSeleniumVariables.gobjWebElement.isSelected() == false) {
						strElementGet = "<off>";
					} else {
						strElementGet = "<on>";
					}
					return strElementGet;
				case "select":
					JavascriptExecutor objExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
					// strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].innerHTML;return selection;", objDragonfly.objSeleniumVariables.gobjWebElement);
					strElementGet = (String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", objDragonfly.objSeleniumVariables.gobjWebElement);
					strElementGet = strElementGet.trim();
					return strElementGet;
				case "table":
					strElementGet = objDragonfly.objSeleniumVariables.gobjWebElement.getText();
					return strElementGet;
				case "alert":
					if (objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString().toLowerCase().equals("title")) {
						strElementGet = objAutoIt.winGetTitle("[ACTIVE]");
						objDragonfly.objLogger.setLogRow("winGetTitle: = " + objAutoIt.winGetTitle("[ACTIVE]"));
					} else {
						strElementGet = objDragonfly.objSeleniumVariables.gobjWebDriver.switchTo().alert().getText();
					}
					return strElementGet;
				default:
					strElementGet = "elementGet tag not supported";
					throw new ExceptionElementTagNameNotSupported("Element tag not supported");
				}
			} finally {
				objDragonfly.objLogger.setLogRow("ElementGet: finally strElementGet = {" + strElementGet + "} MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeElementGet));
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
						new ElementVisible().run(objDragonfly);
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
					strScreenshotFilePath = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strScreenshotFilePath").toString() + "Screenshot_" + new DateTimestamp().get() + ".jpg";
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
			objDragonfly.objLogger.setLogRow("coordinateHighlightScreenshot: MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeCoordinateHighlightScreenshot));
		}
	}

	public class RectangleAreaByName {
		public RectangleAreaByName(Dragonfly objDragonfly, Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
			objDragonfly.objLogger.setLogRow("  ==start==>rectangleAreaByName " + new DateTimestamp().get());
			objDragonfly.objLogger.setLogRow("rectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
			long lngStartTimeGetRectangleAreaByName = System.currentTimeMillis();
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
				objDragonfly.objLogger.setLogRow("rectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeGetRectangleAreaByName));
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
			Boolean blnVisible = false;
			while (true) {
				try {
					if (blnFound == false) {
						new ElementFind(objDragonfly);
						blnFound = true;
						objDragonfly.objLogger.setLogRow("ElementScrollSync: blnFound = true");
					}
					//					if (blnVisible == false) {
					//						new ElementVisible().run(objDragonfly);
					//						blnVisible = true;
					//					}
					JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) objDragonfly.objSeleniumVariables.gobjWebDriver;
					objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", objDragonfly.objSeleniumVariables.gobjWebElement);
					blnStatus = true;
					objDragonfly.objLogger.setLogRow("ElementScrollSync: blnStatus = true");
				} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
					blnFound = false;
					objDragonfly.objLogger.setLogRow("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					//				} catch (ExceptionElementNotVisible e) {
					//					blnVisible = false;
					//					objDragonfly.objLogger.setLogRow("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
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
		private String strKeys1 = "strAction|strTagName|strAttributeNames|strAttributeValues|strInputValue|strLogicalName|intMillisecondsToWait|blnOptional|strAssert";
		private String strKeys2 = "|blnPleaseWait|blnHighlight|blnScreenshot|strFunction|strAssistiveProperties|blnExitOnFail|strOutputLinkName|strOutputValue|intLoop";
		private String strKeys3 = "|intBrowserInnerHeight|intBrowserInnerWidth|intBrowserOuterHeight|intBrowserOuterWidth|intBrowserOuterX|intBrowserOuterY|intElementHeight";
		private String strKeys4 = "|intElementScreenX|intElementScreenY|intElementWidth|intElementX|intElementY|strTagType|strType|strCurrentWindowHandle";
		private String strKeys5 = "|strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strScreenshotFilePath|strStatus|blnStatus";
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
			objDragonfly.objLogger.setLogRow("  ==start==>stepCreateExpected " + new DateTimestamp().get());
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
			case "SCROLL":
				return "The expected " + strTagName + " exists.";
			case "break":
			default:
				return strAction;
			}
		}
	}

	public class StepCreateActual {
		public String run(Dragonfly objDragonfly, String strStepType) {
			objDragonfly.objLogger.setLogRow("  ==start==>stepCreateActual " + new DateTimestamp().get());
			//String strStepDetails = objDragonfly.objJsonVariables.gobjJsonObjectStep.get("strAttributeValues").toString();
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
			case "BREAK":
				strActualHtml = "Take a break.";
				strActualText = "Take a break.";
				break;
			case "SCROLL":
				strActualHtml = "The expected <b>" + strTagName + "</b> exists.";
				strActualText = "The expected " + strTagName + " exists.";
				break;
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
	}

	public class WebElementAttributes {
		public WebElementAttributes(Dragonfly objDragonfly) {
			objDragonfly.objLogger.setLogRow("  ==start==>webElementAttributes " + new DateTimestamp().get());
			// objDragonfly.objLogger.setLogRow("text:=  " + objWebElementEach.);
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
			//			Random objRandom = new Random();
			//			return objRandom.nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
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
			//BufferedWriter objBufferedWriter = null;
			try {
				BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(strFilePathFile));
				objBufferedWriter.write(strTextToWrite);
				objBufferedWriter.close();
			} catch (Exception e) {
				objDragonfly.objLogger.setLogRow("writeReportToHtml: Exception" + e.toString());
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
		public void createReport(Dragonfly objDragonfly, String strStepHeader, JSONArray objTestSteps, String strPath, String strFileName) {
			objDragonfly.objLogger.setLogRow("  ==start==>writeJsonStepsAfterRunToHtml " + new DateTimestamp().get());
			String strKey = "";
			String[] arrKeys = null;
			StepNames objStepNames = new StepNames();
			switch (strStepHeader) {
			case "original":
				arrKeys = objStepNames.getOriginal();
				break;
			case "complete":
				arrKeys = objStepNames.getComplete();
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
		public WriteReportToHtml(Dragonfly objDragonfly, JSONArray objJsonArrayReportSteps, String strFile) {
			objDragonfly.objLogger.setLogRow("  ==start==>writeReportToHtml " + new DateTimestamp().get());
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
							objStringBuilder.append("<img src=\"data:image/jpg;base64," + new ImageEncodeToString().run(objDragonfly, objBufferedImage, "jpg") + "\" alt=\"Step " + intTestStepRow + "\" > ");
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
				new WriteFile(objDragonfly, strFile, strHTML);
				objDragonfly.objLogger.setLogRow("writeReportToHtml: finally MillisecondsWaited = " + (System.currentTimeMillis() - lngStartTimeWriteReportToHtml));
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
		//String strFilePathTestData = gstrPathTestData + "/Environment.json";
		String strFilePathTestData = objDragonfly.objPathCreation.getPathTestData() + "/Environment.json";
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