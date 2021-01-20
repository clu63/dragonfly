package org.DragonflyAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

class WebDriverTest {
	WebDriverTest() {
		UtilProcess.killInternetExplorer();
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer_32.exe");
		DesiredCapabilities objDesiredCapabilities = null;
		// Logger.getInstance().add("BrowserLaunch: DesiredCapabilities");
		objDesiredCapabilities = DesiredCapabilities.internetExplorer();
		// Logger.getInstance().add("BrowserLaunch: objDesiredCapabilities.toString()" + objDesiredCapabilities);
		// Logger.getInstance().add("BrowserLaunch: setJavascriptEnabled");
		objDesiredCapabilities.setJavascriptEnabled(true);
		// Logger.getInstance().add("BrowserLaunch: UNEXPECTED_ALERT_BEHAVIOR");
		objDesiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
		// Logger.getInstance().add("BrowserLaunch: IE_ENSURE_CLEAN_SESSION");
		objDesiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		// Logger.getInstance().add("BrowserLaunch: REQUIRE_WINDOW_FOCUS");
		objDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		// Logger.getInstance().add("BrowserLaunch: INITIAL_BROWSER_URL");
		objDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
		// Logger.getInstance().add("BrowserLaunch: webdriver.ie.driver" + System.getProperty("user.dir") + "\\Drivers\\IEDriverServer_32.exe");
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer_32.exe");
		// Logger.getInstance().add("BrowserLaunch: new InternetExplorerDriver(desiredCapabilities)");
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
		org.openqa.selenium.Dimension objWebDriverDimension = objWebElement.getSize();
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
