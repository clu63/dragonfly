package org.DragonflyAutomation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;

class WebDriverTest {
	public static void main(String[] args) {
		WebDriverTestRun();
	}

	static void WebDriverTestRun() {
		InternetExplorerOptions internetExplorerOptions = null;
		//		System.setProperty("webdriver.ie.driver.loglevel", "DEBUG");
		//		System.setProperty("webdriver.ie.driver.logfile", Path.getInstance().results + "IEDriverLog.log");
		//		System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
		//	System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
		//		System.setProperty("webdriver.ie.driver", "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Drivers\\IEDriverServer_32.exe");
		//		internetExplorerOptions = new InternetExplorerOptions();
		//		internetExplorerOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		//		internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		//		internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		//		internetExplorerOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
		//		internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
		//		internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		//		internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
		//		WebDriver webDriver = new InternetExplorerDriver(internetExplorerOptions);
		//		webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//		//webDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
		//		webDriver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		//		webDriver.manage().window().maximize();
		//		//
		System.setProperty("webdriver.gecko.driver", "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Drivers\\geckodriver_32.exe");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		//firefoxOptions.setLogLevel(FirefoxDriverLogLevel.DEBUG);
		firefoxOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
		firefoxOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		firefoxOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
		WebDriver webDriver = new FirefoxDriver(firefoxOptions);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//webDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
		webDriver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		//
		String localWebsiteFilePath = "file:///C:/workspace-joseph/dragonfly/Dragonfly/Websites/ATW/Automation_Test_Website.html";
		webDriver.get(localWebsiteFilePath);
		ThreadSleep(2000);
		String windowHandle = webDriver.getWindowHandle();
		System.out.println(webDriver.getWindowHandle());
		WebElement webElement = null;
		webElement = webDriver.findElement(By.id("frame_link"));
		webElement.click();
		ThreadSleep(2000);
		webDriver.switchTo().frame(0);
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("page2_title"));
		System.out.println(webElement.getText());
		//String outlineStyle = "green solid 4px";
		JavascriptExecutor javascriptExecutor = null;
		//
		javascriptExecutor = (JavascriptExecutor) webDriver;
		//outlineStyleOriginal = (String) javascriptExecutor.executeScript("return arguments[0].style.outline", Element.getInstance().element);
		//System.out.println("outlineStyleOriginal = " + outlineStyleOriginal);
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "orange solid 4px" + "'", webElement);
		System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
		//
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame(1);
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("page3_title"));
		System.out.println(webElement.getText());
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "green solid 4px" + "'", webElement);
		System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
		//
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame(2);
		System.out.println(webDriver.getWindowHandle());
		webElement = webDriver.findElement(By.id("page1_title"));
		System.out.println(webElement.getText());
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "purple solid 4px" + "'", webElement);
		System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
		//
		//webDriver.switchTo().defaultContent();
		//webDriver.switchTo().frame(2);
		webElement = webDriver.findElement(By.name("check1"));
		System.out.println(webElement.getText());
		//webDriver.switchTo().defaultContent();
		System.out.println(webDriver.getWindowHandle());
		javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("arguments[0].style.outline = '" + "red solid 4px" + "'", webElement);
		System.out.println((String) javascriptExecutor.executeScript("return arguments[0].outerHTML", webElement));
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

	private static void ThreadSleep(Integer millisecondsToWait) {
		try {
			Thread.sleep(millisecondsToWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
