package org.DragonflyAutomation;

import java.util.Collections;
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
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.opera.core.systems.OperaDriver;
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
		String browser = "chrome";
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
			System.setProperty("webdriver.ie.driver.loglevel", "DEBUG");
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
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		String localWebsiteFilePath = "file:///C:/workspace-joseph/dragonfly/Dragonfly/Websites/ATW/Automation_Test_Website.html";
		//String localWebsiteFilePath = "file:///C:/workspace-joseph/dragonfly/Dragonfly/Websites/ATW/SupportingFiles/page1.html";
		webDriver.get(localWebsiteFilePath);
		ThreadSleep(2000);
		//		webElement = webDriver.findElement(By.id("page1_title"));
		//		System.out.println(webElement.getAttribute("outerHTML"));
		//		getScreenXY(webDriver, webElement, browser);
		//		javascriptExecutor = (JavascriptExecutor) webDriver;
		//		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "purple solid 4px" + "'", webElement);
		//		System.exit(0);
		String windowHandle = webDriver.getWindowHandle();
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("link"));
		System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		//webElement.click();
		ThreadSleep(2000);
		System.exit(0);
		//
		webDriver.switchTo().frame(0);
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("page2_title"));
		System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "orange solid 4px" + "'", webElement);
		System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
		//
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame(1);
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("page3_title"));
		System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "green solid 4px" + "'", webElement);
		System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
		//
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame(2);
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("submitted_title"));
		System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "violet solid 4px" + "'", webElement);
		//
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame(3);
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("page1_title"));
		System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "purple solid 4px" + "'", webElement);
		//System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
		//
		webElement = webDriver.findElement(By.name("check1"));
		System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		System.out.println(webDriver.getWindowHandle());
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "red solid 4px" + "'", webElement);
		System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
		//
		ThreadSleep(5000);
		webElement = webDriver.findElement(By.id("buttonCoordinates"));
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "blue solid 4px" + "'", webElement);
		System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		//
		webElement = webDriver.findElement(By.xpath("/html/body"));
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "yellow solid 4px" + "'", webElement);
		//System.out.println(webElement.getAttribute("outerHTML"));
		getScreenXY(webDriver, webElement, browser);
		ThreadSleep(10000);
		//
		webElement = webDriver.findElement(By.id("buttonRemoveElement"));
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
		getScreenXY(webDriver, webElement, browser);
		//
		Actions actions = new Actions(webDriver);
		Long lngBrowserInnerWidth = (Long) ((JavascriptExecutor) webDriver).executeScript("return (window.outerWidth - window.innerWidth);");
		Long lngBrowserInnerHeight = (Long) ((JavascriptExecutor) webDriver).executeScript("return (window.outerHeight - window.innerHeight);");
		System.out.println("lngBrowserInnerWidth " + lngBrowserInnerWidth);
		System.out.println("lngBrowserInnerHeight " + lngBrowserInnerHeight);
		Integer yOffsetValue = (lngBrowserInnerHeight).intValue();
		//actions.moveToElement(webElement).perform();
		//actions.moveToElement(webElement, 0, yOffsetValue).perform();
		actions.moveToElement(webElement, 0, 0).perform();
		System.out.println("move the mouse");
		ThreadSleep(15000);
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
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
		Actions actions = new Actions(webDriver);
		String screenXY = null;
		int webElementOffsetXNew = 0;
		int webElementOffsetYNew = 0;
		//		Integer webElementOffsetX = ((-1 * (webElement.getSize().width / 2)) - 1);
		//		Integer webElementOffsetY = ((-1 * (webElement.getSize().height / 2)) - 1);
		//		
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", webElement);
		Integer webElementOffsetX = ((-1 * (webElement.getSize().width / 2)));
		Integer webElementOffsetY = ((-1 * (webElement.getSize().height / 2)));
		System.out.println("getScreenXY start method ");
		System.out.println("webElementSizeWidth " + webElement.getSize().width);
		System.out.println("webElementSizeHeight " + webElement.getSize().height);
		System.out.println("webElement.getLocation().getX() " + webElement.getLocation().getX());
		System.out.println("webElement.getLocation().getY() " + webElement.getLocation().getY());
		long getBoundingClientRectLeft = (long) javascriptExecutor.executeScript("return arguments[0].getBoundingClientRect().left", webElement);
		double getBoundingClientRectTop = (double) javascriptExecutor.executeScript("return arguments[0].getBoundingClientRect().top", webElement);
		System.out.println("getBoundingClientRect().left " + getBoundingClientRectLeft);
		System.out.println("getBoundingClientRect().top " + getBoundingClientRectTop);
		System.out.println("webElementOffsetX " + webElementOffsetX);
		System.out.println("webElementOffsetY " + webElementOffsetY);
		//@formatter:off
		String javaScript =
		"function createCaptureScreenXY() {\n"
		+ "	if (window.elementScreenXY == undefined) {\n"
		+ "		window.captureScreenXY = function(event) {\n"
		+ "			window.elementScreenXY = event.screenX + '|' + event.screenY;\n"
		+ "		}\n"
		+ "	}\n"
		+ "}\n"
		+ "\n"
		+ "\n"
		+ "function screenXY(createRemove) {\n"
		+ "	if (createRemove == 'create') {\n"
		+ "		createCaptureScreenXY();\n"
		+ "		if (window.elementScreenXY == undefined) {\n"
		+ "			window.elementScreenXY = null\n"
		+ "			if ('addEventListener' in window) {\n"
		+ "				document.addEventListener('mousemove', window.captureScreenXY);\n"
		+ "			} else if ('attachEvent' in window) {\n"
		+ "				document.attachEvent('onmousemove', window.captureScreenXY);\n"
		+ "			}\n"
		+ "		}\n"
		+ "	} else {\n"
//		+ "		if ('removeEventListener' in window) {\n"
//		+ "			document.removeEventListener('mousemove', window.captureScreenXY);\n"
//		+ "		} else if ('detachEvent' in window) {\n"
//		+ "			document.detachEvent('onmousemove', window.captureScreenXY);\n"
//		+ "		}\n"
		+ "		console.log(window.elementScreenXY);\n"
		+ "		return window.elementScreenXY;\n"
		+ "	}\n"
		+ "}\n"
		+ "return screenXY(arguments[0]);";	
		//@formatter:on
		switch (browser) {
		case "edge":
		case "chrome":
			javascriptExecutor.executeScript(javaScript, "create");
			long browserInnerWidth = (long) ((JavascriptExecutor) webDriver).executeScript("return (window.outerWidth - window.innerWidth);");
			long browserInnerHeight = (long) ((JavascriptExecutor) webDriver).executeScript("return (window.outerHeight - window.innerHeight);");
			int yOffsetValue = (int) browserInnerHeight;
			webElementOffsetYNew = webElementOffsetY + yOffsetValue;
			System.out.println("browserInnerWidth " + browserInnerWidth);
			System.out.println("browserInnerHeight " + browserInnerHeight);
			System.out.println("yOffsetValue " + yOffsetValue);
			System.out.println("webElementOffsetX " + webElementOffsetX);
			System.out.println("webElementOffsetY " + webElementOffsetY);
			webElementOffsetXNew = (int) (webElementOffsetX + (-1 * getBoundingClientRectLeft));
			System.out.println("webElementOffsetX " + webElementOffsetX);
			actions.moveToElement(webElement, webElementOffsetXNew, 0).perform();
			//actions.moveToElement(webElement).perform();
			//actions.moveToElement(webElement, webElementOffsetX, webElementOffsetY).perform();
			screenXY = (String) javascriptExecutor.executeScript(javaScript, "remove");
			break;
		case "firefox":
			String javaScriptFirefox = "return (Math.round((window.mozInnerScreenX * window.devicePixelRatio) + arguments[0].getBoundingClientRect().left)) + '|' + (Math.round((window.mozInnerScreenY * window.devicePixelRatio) + arguments[0].getBoundingClientRect().top));";
			screenXY = (String) javascriptExecutor.executeScript(javaScriptFirefox, webElement);
			break;
		case "ie":
		case "internet explorer":
			javascriptExecutor.executeScript(javaScript, "create");
			actions.moveToElement(webElement, webElementOffsetX, webElementOffsetY).perform();
			screenXY = (String) javascriptExecutor.executeScript(javaScript, "remove");
			break;
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>screenXY " + screenXY);
		String[] arrScreen = screenXY.split("\\|");
		int screenX = Integer.parseInt(arrScreen[0]);
		int screenY = Integer.parseInt(arrScreen[1]);
		screenX = (int) (screenX + getBoundingClientRectLeft);
		screenY = (screenY + webElementOffsetYNew);
		System.out.println(">>>>>>>>>>>>>>>>>>>screenX " + screenX);
		System.out.println(">>>>>>>>>>>>>>>>>>>screenY " + screenY);
	}

	private static void ThreadSleep(Integer millisecondsToWait) {
		try {
			Thread.sleep(millisecondsToWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
