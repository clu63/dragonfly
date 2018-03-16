package org.DragonflyAutomation;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

class RemoteTest {
	public static void main(String[] args) throws Exception {
		URL hubURL = new URL("http://XXXXXXXXXXXXXXXXX:5555/wd/hub");
		System.out.println("Connecting to " + hubURL);
		//
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addPreference("ui.popup.disable_autohide", false);
		firefoxOptions.setAcceptInsecureCerts(false);
		//
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("test-type");
		chromeOptions.addArguments("disable-popup-blocking");
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		//
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
		internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
		internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
		internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		internetExplorerOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
		internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
		internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		//
		WebDriver driver = new RemoteWebDriver(hubURL, chromeOptions);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("Cheese");
		element.submit();
		//driver.quit();
	}
}
