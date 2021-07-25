package org.DragonflyAutomation;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

class RemoteTest {
	public static void main(String[] args) throws Exception {
		Integer intTestInstanceEach;
		Integer intTestInstanceStart = 0;
		Integer intTestInstanceSize = 4;
		for (intTestInstanceEach = intTestInstanceStart; intTestInstanceEach < intTestInstanceSize; intTestInstanceEach++) {
			RemoteTest remoteTest = new RemoteTest();
			Thread objThread = new Thread(remoteTest.new RemoteTestRun());
			objThread.start();
		}
	}

	public class RemoteTestRun implements Runnable {
		public RemoteTestRun() {
		}

		public void run() {
			String IP = "";
			SessionId sessionId;
			URL hubURL = null;
			Integer PORT = null;
			String appURL = "";
			RemoteWebDriver driver = null;
			WebElement element = null;
			try {
				hubURL = new URL("http://" + IP + ":" + PORT + "/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			chromeOptions.addArguments("start-maximized");
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
			driver = new RemoteWebDriver(hubURL, chromeOptions);
			//driver = new RemoteWebDriver(hubURL, internetExplorerOptions);
			//ActiveNodeDeterminer activeNodeDeterminer = new ActiveNodeDeterminer(IP, PORT);
			sessionId = driver.getSessionId();
			System.out.println(sessionId);
			//System.out.println(activeNodeDeterminer.getNodeInfoForSession(driver.getSessionId()));
			try {
				URL url = new URL("http://" + IP + ":" + PORT + "/grid/api/testsession?session=" + sessionId);
				URLConnection con = url.openConnection();
				InputStream in = con.getInputStream();
				String encoding = con.getContentEncoding();
				encoding = encoding == null ? "UTF-8" : encoding;
				String body = IOUtils.toString(in, encoding);
				System.out.println(body);
			} catch (Exception e2) {
			}
			driver.get(appURL);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.quit();
			System.out.println("done");
		}
	}
}