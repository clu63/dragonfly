package org.DragonflyAutomation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import com.opera.core.systems.OperaDriver;

class BrowserLaunch {
	BrowserLaunch() throws ExceptionBrowserDriverNotSupported {
		// TODO combine duplicate code
		// TODO add desiredCapabilities.setJavascriptEnabled(true); to all browsers
		Logger.getInstance().add("  ==start==>BrowserLaunch " + Util.getDateTimestamp());
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
