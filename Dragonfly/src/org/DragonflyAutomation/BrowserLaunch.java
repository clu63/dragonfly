package org.DragonflyAutomation;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import com.opera.core.systems.OperaDriver;

class BrowserLaunch {
	BrowserLaunch() throws ExceptionBrowserDriverNotSupported {
		Logger.getInstance().add("  ==start==>BrowserLaunch " + Util.getDateTimestamp());
		InternetExplorerOptions internetExplorerOptions = null;
		Long lngTimeStart = System.currentTimeMillis();
		Logger.getInstance().add("Config.getInstance().browserSelection) = " + Config.getInstance().browserSelection);
		if (Config.getInstance().browserSelection != "value in test") {
			JSONS.getInstance().step.putValue("strTagName", Config.getInstance().browserSelection);
		} else {
			Config.getInstance().browserSelection = JSONS.getInstance().step.getString("strTagName");
		}
		try {
			JSONS.getInstance().step.putValue("strStatus", "pass");
			switch (JSONS.getInstance().step.getString("strTagName")) {
			case "edge":
				System.setProperty("webdriver.edge.driver.loglevel", "DEBUG");
				System.setProperty("webdriver.edge.driver.logfile", Path.getInstance().results + "EdgeDriverLog.log");
				System.setProperty("webdriver.edge.driver", Path.getInstance().systemUserDir + "\\Drivers\\edgedriver_32.exe");
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
				BrowserDriver.getInstance().browserDriver = new EdgeDriver(edgeOptions);
				BrowserDriver.getInstance().browserDriver.manage().window().maximize();
				BrowserDriver.getInstance().browserDriver.manage().deleteAllCookies();
				BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
				break;
			case "firefox":
				//System.setProperty("webdriver.gecko.driver.loglevel", "DEBUG");
				System.setProperty("webdriver.gecko.driver.logfile", Path.getInstance().results + "GeckoDriverLog.log");
				System.setProperty("webdriver.gecko.driver", Path.getInstance().systemUserDir + "\\Drivers\\geckodriver.exe");
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setLogLevel(FirefoxDriverLogLevel.DEBUG);
				firefoxOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
				firefoxOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				firefoxOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
				BrowserDriver.getInstance().browserDriver = new FirefoxDriver(firefoxOptions);
				BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
				BrowserDriver.getInstance().browserDriver.manage().window().maximize();
				break;
			case "ie_64":
				System.setProperty("webdriver.ie.driver.loglevel", "DEBUG");
				System.setProperty("webdriver.ie.driver.logfile", Path.getInstance().results + "IEDriverLog.log");
				System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_64.exe");
				Logger.getInstance().add("BrowserLaunch: webdriver.ie.driver" + Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
				internetExplorerOptions = new InternetExplorerOptions();
				internetExplorerOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				internetExplorerOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
				internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
				internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
				BrowserDriver.getInstance().browserDriver = new InternetExplorerDriver(internetExplorerOptions);
				Logger.getInstance().add("BrowserLaunch: JSONS.getInstance().step.getString(strInputValue)  = " + JSONS.getInstance().step.getString("strInputValue"));
				BrowserDriver.getInstance().browserDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//BrowserDriver.getInstance().browserDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				BrowserDriver.getInstance().browserDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
				BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
				BrowserDriver.getInstance().browserDriver.manage().window().maximize();
				break;
			case "ie":
			case "internet explorer":
				System.setProperty("webdriver.ie.driver.loglevel", "DEBUG");
				System.setProperty("webdriver.ie.driver.logfile", Path.getInstance().results + "IEDriverLog.log");
				System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
				Logger.getInstance().add("BrowserLaunch: webdriver.ie.driver" + Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
				internetExplorerOptions = new InternetExplorerOptions();
				internetExplorerOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				internetExplorerOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
				internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
				internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
				System.out.println(">>>>>>>>>>>>>>>>>internetExplorerOptions.getCapability(InternetExplorerDriver.NATIVE_EVENTS) = " + internetExplorerOptions.getCapability(InternetExplorerDriver.NATIVE_EVENTS));
				BrowserDriver.getInstance().browserDriver = new InternetExplorerDriver(internetExplorerOptions);
				Logger.getInstance().add("BrowserLaunch: JSONS.getInstance().step.getString(strInputValue)  = " + JSONS.getInstance().step.getString("strInputValue"));
				BrowserDriver.getInstance().browserDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//BrowserDriver.getInstance().browserDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
				BrowserDriver.getInstance().browserDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
				BrowserDriver.getInstance().browserDriver.get(JSONS.getInstance().step.getString("strInputValue"));
				BrowserDriver.getInstance().browserDriver.manage().window().maximize();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver.loglevel", "DEBUG");
				System.setProperty("webdriver.chrome.driver.logfile", Path.getInstance().results + "ChromeDriverLog.log");
				System.setProperty("webdriver.chrome.driver", Path.getInstance().systemUserDir + "\\Drivers\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				chromeOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
				chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				//chromeOptions.setExperimentalOption("useAutomationExtension", false);
				chromeOptions.addArguments("test-type");
				chromeOptions.addArguments("--disable-popup-blocking");
				chromeOptions.addArguments("disable-infobars");
				BrowserDriver.getInstance().browserDriver = new ChromeDriver(chromeOptions);
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
