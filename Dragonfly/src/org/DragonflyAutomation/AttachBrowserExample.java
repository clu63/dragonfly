package org.DragonflyAutomation;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.URL;
//
//class RemoteTest {
//
//  public static void main(String[] args) throws Exception {
//    // Change this to match the location of your server
//    URL server = new URL("");
//
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//    capabilities.setBrowserName("firefox");
//
//    System.out.println("Connecting to " + server);
//
//    WebDriver driver = new RemoteWebDriver(server, capabilities);
//
//    driver.get("http://www.google.com");
//
//    driver.quit();
//  }
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.JsonHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;
import com.google.common.base.Splitter;

class AttachBrowserExample {
	class FileManagement {
		File fileToCreate = null;

		public FileManagement(String pathFile) {
			fileToCreate = new File(pathFile);
		}

		private void delete() {
			if (this.exists()) {
				fileToCreate.delete();
			}
		}

		private boolean exists() {
			if (fileToCreate.exists()) {
				return true;
			} else {
				return false;
			}
		}

		private String read() {
			String strReturn = null;
			BufferedReader objBufferedRead = null;
			try {
				objBufferedRead = new BufferedReader(new FileReader(fileToCreate.getPath()));
				strReturn = objBufferedRead.readLine();
				objBufferedRead.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return strReturn;
		}

		private void write(String stringToWrite) {
			try {
				BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(fileToCreate.getPath()));
				objBufferedWriter.write(stringToWrite);
				objBufferedWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new AttachBrowserExample().testBrowser();
	}
	boolean blnAttach;
	String browserName = null;
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	Map<String, String> desiredCapabilitiesMap;
	WebDriver objWebDriver = null;
	String pathCapabilitiesMap = "c:\\temp\\map.txt";
	String pathSessionId = "c:\\temp\\session_id.txt";
	String pathURL = "c:\\temp\\url.ser";
	String pathGeckoDriver = "C:\\SeleniumTest\\drivers\\geckodriver.exe";

	private void createDriverFromSession(String sessionId, URL command_executor) {
		CommandExecutor executor = new HttpCommandExecutor(command_executor) {
			@Override
			public Response execute(Command command) throws IOException {
				Response response = null;
				//System.out.println("command.getName() " + command.getName());
				if (command.getName() == "newSession") {
					response = new Response();
					response.setSessionId(sessionId);
					response.setStatus(0);
					response.setValue(desiredCapabilitiesMap);
					try {
						Field commandCodec = null;
						commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
						commandCodec.setAccessible(true);
						switch (browserName) {
						case "chrome":
							commandCodec.set(this, new JsonHttpCommandCodec());
							break;
						case "firefox":
							commandCodec.set(this, new W3CHttpCommandCodec());
							break;
						case "ie_32":
						case "ie_64":
							commandCodec.set(this, new W3CHttpCommandCodec());
							break;
						case "opera":
							break;
						case "safari":
							break;
						}
						Field responseCodec = null;
						responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
						responseCodec.setAccessible(true);
						responseCodec.set(this, new W3CHttpResponseCodec());
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				} else {
					response = super.execute(command);
				}
				return response;
			}
		};
		objWebDriver = new RemoteWebDriver(executor, new DesiredCapabilities());
	}

	private void launchBrowser() {
		URL url = null;
		SessionId session_id;
		String sessionId = "";
		switch (browserName) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("disable-popup-blocking");
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
			//options.addArguments("--start-fullscreen");
			if (blnAttach == false) {
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTest\\drivers\\chromedriver.exe");
				objWebDriver = new ChromeDriver(chromeOptions);
				//desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			}
			break;
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("ui.popup.disable_autohide", true);
			firefoxOptions.setAcceptInsecureCerts(true);
			if (blnAttach == false) {
				System.setProperty("webdriver.gecko.driver", pathGeckoDriver);
				objWebDriver = new FirefoxDriver(firefoxOptions);
			}
			break;
		case "ie_32":
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setJavascriptEnabled(true);
			desiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
			desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			desiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
			desiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			if (blnAttach == false) {
				System.setProperty("webdriver.ie.driver", "C:\\SeleniumTest\\drivers\\IEDriverServer_32.exe");
				objWebDriver = new InternetExplorerDriver(new InternetExplorerOptions().merge(desiredCapabilities));
			}
			break;
		case "ie_64":
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setJavascriptEnabled(true);
			desiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "ignore");
			desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			desiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
			desiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			if (blnAttach == false) {
				System.setProperty("webdriver.ie.driver", "C:\\SeleniumTest\\drivers\\IEDriverServer_64.exe");
				objWebDriver = new InternetExplorerDriver(new InternetExplorerOptions().merge(desiredCapabilities));
			}
			break;
		case "opera":
			break;
		case "safari":
			break;
		}
		if (blnAttach == false) {
			new FileManagement(pathSessionId).delete();
			new FileManagement(pathURL).delete();
			new FileManagement(pathCapabilitiesMap).delete();
			//System.exit(0);
			HttpCommandExecutor executor = (HttpCommandExecutor) ((RemoteWebDriver) objWebDriver).getCommandExecutor();
			url = executor.getAddressOfRemoteServer();
			try {
				FileOutputStream fosURL = new FileOutputStream(pathURL);
				ObjectOutputStream oosURL = new ObjectOutputStream(fosURL);
				oosURL.writeObject(url);
				oosURL.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session_id = ((RemoteWebDriver) objWebDriver).getSessionId();
			new FileManagement(pathSessionId).write(session_id.toString());
			String strMapFile = null;
			Map<String, String> theMap2;
			theMap2 = (Map<String, String>) ((RemoteWebDriver) objWebDriver).getCapabilities().asMap();
			for (String key : theMap2.keySet()) {
				if (strMapFile != null) {
					strMapFile = strMapFile + "~~~~~~~~~~" + key + "++++++++++" + String.valueOf(theMap2.get(key));
				} else {
					strMapFile = key + "++++++++++" + String.valueOf(theMap2.get(key));
				}
			}
			new FileManagement(pathCapabilitiesMap).write(strMapFile);
		} else {
			try {
				FileInputStream fisURL = new FileInputStream(pathURL);
				ObjectInputStream oisURL = new ObjectInputStream(fisURL);
				url = (URL) oisURL.readObject();
				oisURL.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sessionId = new FileManagement(pathSessionId).read();
			desiredCapabilitiesMap = Splitter.on("~~~~~~~~~~").withKeyValueSeparator("++++++++++").split(new FileManagement(pathCapabilitiesMap).read());
			for (String key : desiredCapabilitiesMap.keySet()) {
			}
			createDriverFromSession(sessionId, url);
		}
	}

	private void testBrowser() {
		//blnAttach = false;
		blnAttach = true;
		browserName = "chrome";
		//browserName = "firefox";
		//browserName = "ie_32";
		//browserName = "ie_64";
		//browserName = "opera";
		//browserName = "safari";
		//
		try {
			launchBrowser();
			System.out.println("objWebDriver.getCapabilities() = " + ((RemoteWebDriver) objWebDriver).getCapabilities().asMap());
			if (blnAttach == true) {
				objWebDriver.manage().window().maximize();
				objWebDriver.get("https://www.google.com/");
				objWebDriver.findElement(By.name("q")).sendKeys("Selenium Grid Tutorial");
				objWebDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			} else {
				objWebDriver.manage().window().maximize();
				objWebDriver.get("https://www.google.com/");
				objWebDriver.findElement(By.name("q")).sendKeys("Selenium Grid Tutorial");
				objWebDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
				//objWebDriver.manage().window().fullscreen();
				objWebDriver.get("http://www.seleniumhq.org/");
				objWebDriver.get("https://www.google.com/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
