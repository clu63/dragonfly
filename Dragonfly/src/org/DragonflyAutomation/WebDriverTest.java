package org.DragonflyAutomation;

import java.awt.Dimension;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.google.common.collect.Maps;
import com.opera.core.systems.OperaDriver;
import org.DragonflyAutomation.TestStep.TestStepFields;
//import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.*;

class WebDriverTest {
	public static void main(String[] args) {
		WebDriverTestRun();
	}

	static void WebDriverTestRun() {
		WebDriver webDriver = null;
		WebElement webElement = null;
		JavascriptExecutor javascriptExecutor = null;
		InternetExplorerOptions internetExplorerOptions = null;
		String browser = "ie";
		String driverPath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Drivers\\";
		switch (browser) {
		case "edge":
			System.setProperty("webdriver.edge.driver.loglevel", "DEBUG");
			System.setProperty("webdriver.edge.driver.logfile", Path.getInstance().results + "EdgeDriverLog.log");
			System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver_32.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			System.out.println("edgeOptions.getCapability(CapabilityType.SUPPORTS_JAVASCRIPT) = " + edgeOptions.getCapability(CapabilityType.SUPPORTS_JAVASCRIPT));
			System.out.println("edgeOptions.getCapability(CapabilityType.HAS_NATIVE_EVENTS) = " + edgeOptions.getCapability(CapabilityType.HAS_NATIVE_EVENTS));
			System.out.println("edgeOptions.getCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR) = " + edgeOptions.getCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR));
			edgeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			edgeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			edgeOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
			System.out.println("edgeOptions.getCapability(CapabilityType.SUPPORTS_JAVASCRIPT) = " + edgeOptions.getCapability(CapabilityType.SUPPORTS_JAVASCRIPT));
			System.out.println("edgeOptions.getCapability(CapabilityType.HAS_NATIVE_EVENTS) = " + edgeOptions.getCapability(CapabilityType.HAS_NATIVE_EVENTS));
			System.out.println("edgeOptions.getCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR) = " + edgeOptions.getCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR));
			webDriver = new EdgeDriver(edgeOptions);
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver.loglevel", "DEBUG");
			//				System.setProperty("webdriver.gecko.driver.logfile", Path.getInstance().results + "GeckoDriverLog.log");
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver_32.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.setLogLevel(FirefoxDriverLogLevel.DEBUG);
			firefoxOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			firefoxOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			firefoxOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
			webDriver = new FirefoxDriver(firefoxOptions);
			break;
		case "ie_64":
			System.setProperty("webdriver.ie.driver.loglevel", "DEBUG");
			//System.setProperty("webdriver.ie.driver.logfile", Path.getInstance().results + "IEDriverLog.log");
			System.setProperty("webdriver.ie.driver", driverPath + "\\Drivers\\IEDriverServer_64.exe");
			Logger.getInstance().add("BrowserLaunch: webdriver.ie.driver" + driverPath + "IEDriverServer_32.exe");
			internetExplorerOptions = new InternetExplorerOptions();
			internetExplorerOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			internetExplorerOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
			internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
			webDriver = new InternetExplorerDriver(internetExplorerOptions);
			break;
		case "ie":
		case "internet explorer":
			//System.setProperty("webdriver.ie.driver.loglevel", "DEBUG");
			//System.setProperty("webdriver.ie.driver.logfile", Path.getInstance().results + "IEDriverLog.log");
			System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer_32.exe");
			Logger.getInstance().add("BrowserLaunch: webdriver.ie.driver" + driverPath + "IEDriverServer_32.exe");
			internetExplorerOptions = new InternetExplorerOptions();
			internetExplorerOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			internetExplorerOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
			internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
			webDriver = new InternetExplorerDriver(internetExplorerOptions);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver.loglevel", "DEBUG");
			//System.setProperty("webdriver.chrome.driver.logfile", Path.getInstance().results + "ChromeDriverLog.log");
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver_32.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			chromeOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			//chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("--disable-popup-blocking");
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.addArguments("--allow-file-access-from-files");
			webDriver = new ChromeDriver(chromeOptions);
			break;
		case "safari":
			webDriver = new SafariDriver();
			break;
		case "opera":
			webDriver = new OperaDriver();
			break;
		default:
		}
		webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		//webDriver.manage().window().maximize();
		//webDriver.manage().deleteAllCookies();
		String localWebsiteFilePath = "file:///C:/workspace-joseph/dragonfly/Dragonfly/Websites/ATW/Automation_Test_Website.html";
		//String localWebsiteFilePath = "file:///C:/workspace-joseph/dragonfly/Dragonfly/Websites/ATW/SupportingFiles/page1.html";
		webDriver.get(localWebsiteFilePath);
		ThreadSleep(12000);
		//
		//
		//
		//		System.out.println("html");
		//		webElement = webDriver.findElement(By.xpath("/html"));
		//		getCoordinates(webElement);
		//		getScreenXY(webDriver, webElement, browser);
		//		ThreadSleep(2000);

		
		getWebdriverWindowRect(webDriver);
		//System.exit(0);
		//		webElement = webDriver.findElement(By.id("page1_title"));
		//		getScreenXY(webDriver, webElement, browser);
		//		javascriptExecutor = (JavascriptExecutor) webDriver;
		//		System.exit(0);
		webElement = webDriver.findElement(By.id("link"));
		getScreenXY(webDriver, webElement, browser);
		//webElement.click();
		ThreadSleep(2000);
		//System.exit(0);
		//
		webElement = webDriver.findElement(By.id("frame_link"));
		getScreenXY(webDriver, webElement, browser);
		webElement.click();
		ThreadSleep(2000);
		//
		//		webElement = webDriver.findElement(By.xpath("/html/frameset"));
		//		getCoordinates(webElement);
		//		System.exit(0);
		////
		List<WebElement> webElements = webDriver.findElements(By.tagName("frame"));
		int intFramesCount = webElements.size();
		System.out.println("frame intFramesCount " + intFramesCount);
		for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
			System.out.println("````````````frame intFramesEach " + intFramesEach);
			getFrameXY(webDriver, webElements.get(intFramesEach), browser);
		}
		//
		Number windowWidthBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerWidth - window.innerWidth);");
		Number windowHeightBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerHeight - window.innerHeight);");
		System.out.println("frame 0 windowWidthBorder " + windowWidthBorder);
		System.out.println("frame 0 windowHeightBorder " + windowHeightBorder);
		webElement = webDriver.findElement(By.xpath("/html/frameset/frameset/frame[1]"));
		//		/html/frameset/frameset/frame[2]
		//				/html/frameset/frame[1]
		getCoordinates(webElement);
		webDriver.switchTo().frame(0);
		getWebdriverWindowRect(webDriver);
		//		System.out.println("html");
		//		webElement = webDriver.findElement(By.xpath("/html"));
		//		getScreenXY(webDriver, webElement, browser);
		;
		webElement = webDriver.findElement(By.id("page2_title"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "orange solid 4px" + "'", webElement);
		//
		webDriver.switchTo().defaultContent();
		windowWidthBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerWidth - window.innerWidth);");
		windowHeightBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerHeight - window.innerHeight);");
		System.out.println("frame 1 windowWidthBorder " + windowWidthBorder);
		System.out.println("frame 1 windowHeightBorder " + windowHeightBorder);
		//System.out.println("html");
		webDriver.switchTo().frame(1);
		getWebdriverWindowRect(webDriver);
		//webElement = webDriver.findElement(By.xpath("/html"));
		//getScreenXY(webDriver, webElement, browser);
		webElement = webDriver.findElement(By.id("page3_title"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "green solid 4px" + "'", webElement);
		Actions actionsRelease = new Actions(webDriver);
		actionsRelease.release(webElement).perform();
		//
		webDriver.switchTo().defaultContent();
		windowWidthBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerWidth - window.innerWidth);");
		windowHeightBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerHeight - window.innerHeight);");
		webDriver.switchTo().frame(2);
		getWebdriverWindowRect(webDriver);
		System.out.println("frame 2 windowWidthBorder " + windowWidthBorder);
		System.out.println("frame 2 windowHeightBorder " + windowHeightBorder);
		//		System.out.println("html");
		//		webElement = webDriver.findElement(By.xpath("/html"));
		//		getScreenXY(webDriver, webElement, browser);
		webElement = webDriver.findElement(By.id("submitted_title"));
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "violet solid 4px" + "'", webElement);
		//ThreadSleep(15000);
		getScreenXY(webDriver, webElement, browser);
		//
		webDriver.switchTo().defaultContent();
		windowWidthBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerWidth - window.innerWidth);");
		windowHeightBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerHeight - window.innerHeight);");
		System.out.println("defaultContent windowWidthBorder " + windowWidthBorder);
		System.out.println("defaultContent windowHeightBorder " + windowHeightBorder);
		//		webElement = webDriver.findElement(By.xpath("/html/frameset/frame[2]"));
		//		getFrameXY(webDriver, webElement, browser);
		//webElement = (WebElement) webDriver.findElements(By.tagName("frame"))[2];
		//
		//
		//getFrameXY(webDriver, webElement, browser);
		//
		webDriver.switchTo().frame(3);
		getWebdriverWindowRect(webDriver);
		windowWidthBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerWidth - window.innerWidth);");
		windowHeightBorder = (Number) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerHeight - window.innerHeight);");
		
		System.out.println("frame 3 windowWidthBorder " + windowWidthBorder);
		System.out.println("frame 3 windowHeightBorder " + windowHeightBorder);
		//System.out.println("html");
		//webElement = webDriver.findElement(By.xpath("/html"));
		//getScreenXY(webDriver, webElement, browser);
		webElement = webDriver.findElement(By.id("page1_title"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "purple solid 4px" + "'", webElement);
		//
		webElement = webDriver.findElement(By.name("check1"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "red solid 4px" + "'", webElement);
		//
		//ThreadSleep(5000);
		webElement = webDriver.findElement(By.id("buttonCoordinates"));
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "blue solid 4px" + "'", webElement);
		getScreenXY(webDriver, webElement, browser);
		//
		webElement = webDriver.findElement(By.xpath("/html/body"));
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "yellow solid 4px" + "'", webElement);
		getScreenXY(webDriver, webElement, browser);
		//ThreadSleep(10000);
		//
		webElement = webDriver.findElement(By.id("buttonRemoveElement"));
		getScreenXY(webDriver, webElement, browser);
		//
		System.exit(0);
		Actions actions = new Actions(webDriver);
		Number lngBrowserInnerWidth = (Number) ((JavascriptExecutor) webDriver).executeScript("return (window.outerWidth - window.innerWidth);");
		Number lngBrowserInnerHeight = (Number) ((JavascriptExecutor) webDriver).executeScript("return (window.outerHeight - window.innerHeight);");
		System.out.println("lngBrowserInnerWidth " + lngBrowserInnerWidth);
		System.out.println("lngBrowserInnerHeight " + lngBrowserInnerHeight);
		Integer yOffsetValue = (lngBrowserInnerHeight).intValue();
		actions.moveToElement(webElement).perform();
		//actions.moveToElement(webElement, 0, yOffsetValue).perform();
		//actions.moveToElement(webElement, 0, 0).perform();
		System.out.println("move the mouse");
		//ThreadSleep(15000);
		actions.click().perform();
		//actions.click(webElement).perform();
		//actions.click(webElement).perform();
		//actions.moveToElement(webElement).perform();
		//
		//
		//parent.frames[0].fAlert() 
		//parent.leftframe.document.getElementById("information");
		//		WebElement webElement = webDriver.findElement(By.id("tooltipID"));
		//		Actions toolTip1 = new Actions(webDriver);
		//		toolTip1.moveToElement(webElement).build().perform();
		//		//toolTip1.clickAndHold(objWebElement).build().perform();
		//		new SleepMilliseconds(1000);
		//		System.out.println(webElement.getLocation().getX());
		//		System.out.println(webElement.getLocation().getY());
		//		System.out.println(webElement.getSize().width);
		//		System.out.println(webElement.getSize().height);
		//		org.openqa.selenium.Dimension webDriverDimension = webElement.getSize();
		//		int browserOuterWidth = webDriverDimension.width;
		//		int browserOuterHeight = webDriverDimension.height;
		//		//' Grab tooltip
		//		//ToolTip = Window("nativeclass:=tooltips_class32").GetROProperty("text")
		//		//String strToolTip = objAutoItSetObject.objAutoIt.controlGetText("tooltips_class32", "", "");
		//		System.out.println(-((browserOuterWidth / 2) + 1));
		//		System.out.println(-((browserOuterHeight / 2) + 1));
		//		toolTip1.moveByOffset(-((browserOuterWidth / 2) + 1), -((browserOuterHeight / 2) + 1)).build().perform();
		//		String toolTipText = webElement.getAttribute("title");
		//		//Assert.assertEquals(ToolTipText, "Google");
		//		System.out.println("Tooltip value is: " + toolTipText);
		//		//toolTip1.release(objWebElement).perform();
		//		//toolTip1.release().perform();
		//		//toolTip1.moveByOffset(0, 0);
	}

	static void getScreenXY(WebDriver webDriver, WebElement webElement, String browser) {
		//System.exit(0);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("<<<<<<<<<<<getScreenXY start method ");
//		System.out.println(webElement.getAttribute("outerHTML"));
//		System.out.println(webDriver.getWindowHandle());
//		WebElement webElementHTML = webDriver.findElement(By.xpath("/html"));
//		System.out.println("webElementHTMLSizeWidth " + webElementHTML.getSize().width);
//		System.out.println("webElementHTMLSizeHeight " + webElementHTML.getSize().height);
//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
//		long browserInnerWidth = (long) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerWidth - window.innerWidth);");
//		long browserInnerHeight = (long) ((JavascriptExecutor) webDriver).executeScript("return Math.round(window.outerHeight - window.innerHeight);");
//		System.out.println("browserInnerWidth " + browserInnerWidth);
//		System.out.println("browserInnerHeight " + browserInnerHeight);
//		Actions actions = new Actions(webDriver);
//		String screenXY = null;
//		int webElementOffsetXNew = 0;
//		int webElementOffsetYNew = 0;
//		int yOffsetValue = 0;
//		int screenX = 0;
//		int screenY = 0;
//		//		Integer webElementOffsetX = ((-1 * (webElement.getSize().width / 2)) - 1);
//		//		Integer webElementOffsetY = ((-1 * (webElement.getSize().height / 2)) - 1);
//		//		
//		//javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", webElement);
//		Integer webElementOffsetX = ((-1 * (webElement.getSize().width / 2)));
//		Integer webElementOffsetY = ((-1 * (webElement.getSize().height / 2)));
//		System.out.println("webElementSizeWidth " + webElement.getSize().width);
//		System.out.println("webElementSizeHeight " + webElement.getSize().height);
//		System.out.println("webElement.getLocation().getX() " + webElement.getLocation().getX());
//		System.out.println("webElement.getLocation().getY() " + webElement.getLocation().getY());
//		long getBoundingClientRectLeft = (long) javascriptExecutor.executeScript("return Math.floor(arguments[0].getBoundingClientRect().left)", webElement);
//		long getBoundingClientRectTop = (long) javascriptExecutor.executeScript("return Math.floor(arguments[0].getBoundingClientRect().top)", webElement);
//		long getBoundingClientRectWidth = (long) javascriptExecutor.executeScript("return Math.floor(arguments[0].getBoundingClientRect().width)", webElement);
//		long getBoundingClientRectHeight = (long) javascriptExecutor.executeScript("return Math.floor(arguments[0].getBoundingClientRect().height)", webElement);
//		System.out.println("getBoundingClientRect().left Math.floor " + getBoundingClientRectLeft);
//		System.out.println("getBoundingClientRect().top Math.floor " + getBoundingClientRectTop);
//		System.out.println("getBoundingClientRect().width Math.floor " + getBoundingClientRectWidth);
//		System.out.println("getBoundingClientRect().height Math.floor " + getBoundingClientRectHeight);
//		System.out.println("webElementOffsetX " + webElementOffsetX);
//		System.out.println("webElementOffsetY " + webElementOffsetY);
//		//
//		//System.out.println("objElementCoordinates.inViewPort() = " + ((Coordinates) webElement).inViewPort());
//		//System.out.println("before objElementPoint");
//		//Point elementPoint = ((Coordinates) webElement).inViewPort();
//		//		Integer inViewPortX = ((Locatable) webElement).getCoordinates().inViewPort().getX();
//		//		Integer inViewPortY = ((Locatable) webElement).getCoordinates().inViewPort().getY();
//		//		System.out.println("<<<<<<<<<<<<<<<<<<inViewPortX = " + inViewPortX + " inViewPortY = " + inViewPortY);
//		//		
//		//@formatter:off
//		String javaScript =
//		  "function createCaptureScreenXY() {\n"
//		+ "	if (window.elementScreenXY == undefined) {\n"
//		+ "		window.captureScreenXY = function(event) {\n"
//		+ "			window.elementScreenXY = event.screenX + '|' + event.screenY;\n"
//		+ "		}\n"
//		+ "	}\n"
//		+ "}\n"
//		+ "\n"
//		+ "\n"
//		+ "function screenXY(createRemove) {\n"
//		+ "	if (createRemove == 'create') {\n"
//		+ "		createCaptureScreenXY();\n"
//		+ "		if (window.elementScreenXY == undefined) {\n"
//		+ "			window.elementScreenXY = null\n"
//		+ "			if ('addEventListener' in window) {\n"
//		+ "				document.addEventListener('mousemove', window.captureScreenXY);\n"
//		+ "			} else if ('attachEvent' in window) {\n"
//		+ "				document.attachEvent('onmousemove', window.captureScreenXY);\n"
//		+ "			}\n"
//		+ "		}\n"
//		+ "	} else {\n"
////		+ "		if ('removeEventListener' in window) {\n"
////		+ "			document.removeEventListener('mousemove', window.captureScreenXY);\n"
////		+ "		} else if ('detachEvent' in window) {\n"
////		+ "			document.detachEvent('onmousemove', window.captureScreenXY);\n"
////		+ "		}\n"
//		+ "		console.log(window.elementScreenXY);\n"
//		+ "		return window.elementScreenXY;\n"
//		+ "	}\n"
//		+ "}\n"
//		+ "return screenXY(arguments[0]);";	
//		//@formatter:on
//		switch (browser) {
//		case "edge":
//		case "chrome":
//			javascriptExecutor.executeScript(javaScript, "create");
//			///
//			//actions.moveToElement(webElementHTML).perform();
//			//screenXY = (String) javascriptExecutor.executeScript(javaScript, "remove");
//			//System.out.println(">>>>>>>>>>>>>>>>>>>screenXY HTML1 " + screenXY);
//			//String[] arrScreen = screenXY.split("\\|");
//			//screenX = Integer.parseInt(arrScreen[0]);
//			//screenY = Integer.parseInt(arrScreen[1]);
//			//webElementOffsetX = -1 * screenX;
//			//webElementOffsetY = -1 * screenY;
//			//screenX = (int) (screenX + getBoundingClientRectLeft);
//			//screenY = (screenY + webElementOffsetYNew);
//			//actions.moveToElement(webElementHTML, webElementOffsetX, webElementOffsetY).perform();
//			//screenXY = (String) javascriptExecutor.executeScript(javaScript, "remove");
//			//System.out.println(">>>>>>>>>>>>>>>>>>>screenXY HTML2 " + screenXY);
//			///
//			//long windowHeightBorder = (long) ((JavascriptExecutor) webDriver).executeScript("return (window.outerWidth - window.innerWidth);");
//			//long browserInnerHeight = (long) ((JavascriptExecutor) webDriver).executeScript("return (window.outerHeight - window.innerHeight);");
//			//yOffsetValue = (int) browserInnerHeight;
//			//System.out.println("browserInnerWidth " + browserInnerWidth);
//			//System.out.println("browserInnerHeight " + browserInnerHeight);
//			//System.out.println("yOffsetValue " + yOffsetValue);
//			//System.out.println("webElementOffsetX " + webElementOffsetX);
//			//System.out.println("webElementOffsetY " + webElementOffsetY);
//			webElementOffsetXNew = (int) (webElementOffsetX + (-1 * getBoundingClientRectLeft));
//			System.out.println("webElementOffsetX " + webElementOffsetX);
//			//actions.moveToElement(webElement, webElementOffsetXNew, 0).perform();
//			//actions.moveToElement(webElement, 0, 80).perform();
//			actions.moveToElement(webElement).perform();
//			ThreadSleep(1000);
//			//actions.moveToElement(webElement, webElementOffsetX, webElementOffsetY).perform();
//			screenXY = (String) javascriptExecutor.executeScript(javaScript, "remove");
//			System.out.println(">>>>>>>>>>>>>>>>>>>screenXY " + screenXY);
//			String[] arrScreen = screenXY.split("\\|");
//			screenX = Integer.parseInt(arrScreen[0]);
//			screenY = Integer.parseInt(arrScreen[1]);
//			int getBoundingClientRectWidthInt = (int) (-1 * (getBoundingClientRectWidth / 2));
//			int getBoundingClientRectHeightInt = (int) (-1 * (getBoundingClientRectHeight / 2));
//			actions.moveByOffset(getBoundingClientRectWidthInt, getBoundingClientRectHeightInt).perform();
//			break;
//		case "firefox":
//			String javaScriptFirefox = "return (Math.round((window.mozInnerScreenX * window.devicePixelRatio) + arguments[0].getBoundingClientRect().left)) + '|' + (Math.round((window.mozInnerScreenY * window.devicePixelRatio) + arguments[0].getBoundingClientRect().top));";
//			screenXY = (String) javascriptExecutor.executeScript(javaScriptFirefox, webElement);
//			break;
//		case "ie":
//		case "internet explorer":
//			javascriptExecutor.executeScript(javaScript, "create");
//			actions.moveToElement(webElement, webElementOffsetX, webElementOffsetY).perform();
//			screenXY = (String) javascriptExecutor.executeScript(javaScript, "remove");
//			break;
//		}
//		screenXY = (String) javascriptExecutor.executeScript(javaScript, "remove");
//		System.out.println(">>>>>>>>>>>>>>>>>>>screenXY " + screenXY);
//		String[] arrScreen = screenXY.split("\\|");
//		screenX = Integer.parseInt(arrScreen[0]);
//		screenY = Integer.parseInt(arrScreen[1]);
//		//webElementOffsetYNew = webElementOffsetY + yOffsetValue;
//		//screenX = (int) (screenX + getBoundingClientRectLeft);
//		//webElementOffsetYNew = 71 + webElementOffsetY;
//		webElementOffsetYNew = 0;
//		getBoundingClientRectLeft = 0;
//		screenY = (screenY + webElementOffsetYNew);
//		screenX = (int) (screenX + getBoundingClientRectLeft);
//		System.out.println(">>>>>>>>>>>>>>>>>>>screenX " + screenX);
//		System.out.println(">>>>>>>>>>>>>>>>>>>screenY " + screenY);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private static void ThreadSleep(Integer millisecondsToWait) {
		try {
			Thread.sleep(millisecondsToWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void getCoordinates(WebElement webElement) {
		Integer webElementX = webElement.getLocation().getX();
		Integer webElementY = webElement.getLocation().getY();
		Integer webElementWidth = webElement.getSize().width;
		Integer webElementHeight = webElement.getSize().height;
		System.out.println("webElementX " + webElementX);
		System.out.println("webElementY " + webElementY);
		System.out.println("webElementWidth " + webElementWidth);
		System.out.println("webElementHeight " + webElementHeight);
		Point viewPortLocation = ((Locatable) webElement).getCoordinates().inViewPort();
		Integer viewPortLocationX = viewPortLocation.getX();
		Integer viewPortLocationY = viewPortLocation.getY();
		System.out.println("viewPortLocationX " + viewPortLocationX);
		System.out.println("viewPortLocationY " + viewPortLocationY);
		Point pageLocation = ((Locatable) webElement).getCoordinates().onPage();
		Integer pageLocationX = pageLocation.getX();
		Integer pageLocationY = pageLocation.getY();
		System.out.println("pageLocationX " + pageLocationX);
		System.out.println("pageLocationY " + pageLocationY);
		Integer webElementOffsetX = ((-1 * (webElementWidth / 2)) - 1);
		Integer webElementOffsetY = ((-1 * (webElementHeight / 2)) - 1);
		System.out.println("webElementOffsetX " + webElementOffsetX);
		System.out.println("webElementOffsetY " + webElementOffsetY);
		System.out.println(webElement.getAttribute("outerHTML"));
	}

	static void getFrameXY(WebDriver webDriver, WebElement webElement, String browser) {
		//http://www.gtalbot.org/DHTMLSection/WindowEventsNS6.html
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
		//@formatter:off
		String javaScript =
		  "function getPosition(element, browser) {\n"
		+ "	var xPosition = 0;\n"
        + "	var yPosition = 0;\n"
        + "	var borderWidth = 0;\n"
        + "	var borderMenu = 0;\n"
        + "	var windowLeft = 0;\n"
        + "	var windowTop = 0;\n"
        + "	var screenPageX = 0;\n"
        + "	var screenPageY = 0;\n"
        + "	var boundLeft = 0;\n"
        + "	var boundTop = 0;\n"
        + "	var boundWidth = 0;\n"
        + "	var boundHeight = 0;\n"
        + "	var adjustedLeft = 0;\n"
        + "	var frameOuterWidth = 0;\n"
        + "	var frameOuterHeight = 0;\n"  
        + "	var frameInnerWidth = 0;\n"
        + "	var frameInnerHeight = 0;\n"       
        
        
		+ "	if (browser == 'ie') {\n"
        + "		xPosition += (element.offsetLeft - element.scrollLeft + element.clientLeft);\n"
        + "		yPosition += (element.offsetTop - element.scrollTop + element.clientTop);\n"
		+ "	} else {\n"



        
        + "	while(element) {\n"
        + "		xPosition += (element.offsetLeft - element.scrollLeft + element.clientLeft);\n"
        + "		yPosition += (element.offsetTop - element.scrollTop + element.clientTop);\n"
        + "		element = element.offsetParent;\n"
        + "	}\n"
        
		+ "	}\n"
		+ "boundLeft = element.getBoundingClientRect().left;\n"
		+ "boundTop = element.getBoundingClientRect().top;\n"
		+ "boundWidth = element.getBoundingClientRect().width;\n"
		+ "boundHeight = element.getBoundingClientRect().height;\n"
		
		+ "frameOuterWidth = element.getBoundingClientRect().width;\n"
		+ "frameOuterHeight = element.getBoundingClientRect().height;\n"
		+ "frameInnerWidth = element.contentWindow.innerWidth;\n"
		+ "frameInnerHeight = element.contentWindow.innerHeight;\n"
		
		
		+ "	borderWidth = ((window.outerWidth - window.innerWidth) / 2);\n"
		+ "	borderMenu = ((window.outerHeight - window.innerHeight) - borderWidth);\n"
		+ "	windowLeft = window.screenLeft;\n"
		+ "	windowTop = window.screenTop;\n"
		+ "	screenPageX = windowLeft + borderWidth + xPosition;\n"
		+ "	screenPageY = windowTop + borderMenu + yPosition;\n"
		+ "adjustedLeft =(window.outerWidth - (boundLeft + element.getBoundingClientRect().width + (window.outerWidth - window.innerWidth)) ) + window.screenLeft\n"
		
		
		
		+ "	return {\n"
		+ "		x : xPosition,\n"
		+ "		y : yPosition,\n"
		+ "		borderWidth : borderWidth,\n"
		+ "		borderMenu : borderMenu,\n"
		+ "		windowLeft : windowLeft,\n"
		+ "		windowTop : windowTop,\n"
		+ "		screenPageX : screenPageX,\n"
		+ "		screenPageY : screenPageY,\n"
		+ "		boundLeft : boundLeft,\n"
		+ "		boundTop : boundTop,\n"
		+ "		boundWidth : boundWidth,\n"
		+ "		boundHeight : boundHeight,\n"
		+ "		adjustedLeft : adjustedLeft,\n"
		+ "		frameOuterWidth : frameOuterWidth,\n"
		+ "		frameOuterHeight : frameOuterHeight,\n"
		+ "		frameInnerWidth : frameInnerWidth,\n"
		+ "		frameInnerHeight : frameInnerHeight\n"
		
		
		
		+ "	};\n"
		+ "}\n"
	    + "return getPosition(arguments[0], arguments[1]);";
		//@formatter:on
		//System.out.println(javaScript);
		Map<String, Long> FrameXY = (Map<String, Long>) javascriptExecutor.executeScript(javaScript, webElement, browser);
		System.out.println("FrameX " + FrameXY.get("x") + " FrameY " + FrameXY.get("y"));
		System.out.println("borderWidth " + FrameXY.get("borderWidth") + " borderMenu " + FrameXY.get("borderMenu"));
		System.out.println("windowLeft " + FrameXY.get("windowLeft") + " windowTop " + FrameXY.get("windowTop"));
		System.out.println("screenPageX " + FrameXY.get("screenPageX") + " screenPageY " + FrameXY.get("screenPageY"));
		System.out.println("boundLeft " + FrameXY.get("boundLeft") + " boundTop " + FrameXY.get("boundTop"));
		System.out.println("boundWidth " + FrameXY.get("boundWidth") + " boundHeight " + FrameXY.get("boundHeight"));
		System.out.println("adjustedLeft " + FrameXY.get("adjustedLeft") + " adjustedLeft " + FrameXY.get("adjustedLeft"));
		System.out.println("frameOuterWidth " + FrameXY.get("frameOuterWidth") + " frameOuterHeight " + FrameXY.get("frameOuterHeight"));
		System.out.println("frameInnerWidth " + FrameXY.get("frameInnerWidth") + " frameInnerHeight " + FrameXY.get("frameInnerHeight"));
	}
	
	
	static void getWebdriverWindowRect(WebDriver webDriver) {
		System.out.println("================getWebdriverWindowRect================");
		System.out.println("webDriver window().toString = " + webDriver.manage().window().toString());
		System.out.println("webDriver Title = " + webDriver.getTitle());
		System.out.println("webDriver Width = " + webDriver.manage().window().getSize().getWidth());
		System.out.println("webDriver Height = " + webDriver.manage().window().getSize().getHeight());
		
		System.out.println("webDriver X = " + webDriver.manage().window().getPosition().getX());
		System.out.println("webDriver Y = " + webDriver.manage().window().getPosition().getY());
		
		System.out.println("==============end getWebdriverWindowRect==============");
	
	}	
}
