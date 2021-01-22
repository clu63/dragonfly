package org.DragonflyAutomation;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//Options for ClearMyTracksByProcessCookies
//1 = Browsing History
//2 = Cookies
//4 = Temporary Internet Files
//8 = Offline favorites and download history
//16 = Form Data
//32 = Passwords
//64 = Phishing Filter Data
//128 = Web page Recovery Data
//256 = Do not Show GUI when running the cache clear
//512 = Do not use Multi-threading for deletion
//1024 = Valid only when browser is in private browsing mode
//2048 = Tracking Data
//4096 = Data stored by add-ons
//8192 = Preserves Cached data for Favorite websites
//Delete only download history
//RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16384
//Add values together to get aggregate functionality. For example '4' is
//deleting all temporary internet files and '260' is doing the same without
//the dialog being displayed while it purges.
//RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 260
class UtilProcess {
	static void clearMyTracksCache() throws Exception {
		Logger.getInstance().add("  ==start==>ClearMyTracksByProcessCache " + Util.getDateTimestamp());
		String[] arrCommandLine = { "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 8\"" };
		Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
		objProcess.waitFor();
	}

	static void clearMyTracksCookies() throws Exception {
		Logger.getInstance().add("  ==start==>ClearMyTracksByProcessCookies " + Util.getDateTimestamp());
		String[] arrCommandLine = { "\"cmd.exe\"", "\"RunDll32.exe\"", "\"InetCpl.cpl,ClearMyTracksByProcess 2\"" };
		Process objProcess = Runtime.getRuntime().exec(arrCommandLine);
		objProcess.waitFor();
	}

	static void executeCommandLine() throws Exception {
		Logger.getInstance().add("  ==start==>CommandLineExecution " + Util.getDateTimestamp());
		Process p = Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
		p.waitFor();
		Process p5 = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 10");
		p5.waitFor();
		String strPathCookiesLow = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Cookies\\Low\\";
		strPathCookiesLow = strPathCookiesLow.replaceAll("\\\\", "/");
		Logger.getInstance().add("CommandLineExecution: strPathCookiesLow = " + strPathCookiesLow);
		FileUtils.deleteDirectory(new File(strPathCookiesLow));
		String strPathCacheLow = System.getenv("APPDATA") + "Local/Microsoft/Windows/Temporary Internet Files/Low/";
		strPathCacheLow = strPathCacheLow.replaceAll("\\\\", "/");
		Logger.getInstance().add("CommandLineExecution: strPathCacheLow = " + strPathCacheLow);
		FileUtils.deleteDirectory(new File(strPathCacheLow));
	}

	static void killInternetExplorer() {
		Logger.getInstance().add("  ==start==>ProcessKillInternetExplorer " + Util.getDateTimestamp());
		killWindowsProcess("taskkill /F /IM iexplore.exe");
		new SleepMilliseconds(1000);
		killWindowsProcess("taskkill /F /IM IEDriverServer_32.exe");
	}

	static void killInternetExplorerOld() {
		Logger.getInstance().add("  ==start==>InternetExplorerProcessKill " + Util.getDateTimestamp());
		DesiredCapabilities desiredCapabilities = null;
		killWindowsProcess("taskkill /F /IM iexplore.exe");
		new SleepMilliseconds(1000);
		desiredCapabilities = DesiredCapabilities.internetExplorer();
		desiredCapabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", Path.getInstance().systemUserDir + "\\Drivers\\IEDriverServer_32.exe");
		BrowserDriver.getInstance().browserDriver = new InternetExplorerDriver(desiredCapabilities);
		BrowserDriver.getInstance().browserDriver.get("about:blank");
		BrowserDriver.getInstance().browserDriver.manage().deleteCookieNamed("JSESSIONID");
		// BrowserDriver.getInstance().browserDriver.navigate().to(JSONS.getInstance().step.get("strInputValue").toString());
		// BrowserDriver.getInstance().browserDriver.manage().window().maximize();
		// BrowserDriver.getInstance().browserDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// // BrowserDriver.getInstance().browserDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
		BrowserDriver.getInstance().browserDriver.close();
		BrowserDriver.getInstance().browserDriver.quit();
		killWindowsProcess("taskkill /F /IM iexplore.exe");
		new SleepMilliseconds(1000);
		killWindowsProcess("taskkill /F /IM IEDriverServer_32.exe");
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 1
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 32
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255
		// RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 4351
	}

	static void killWindowsProcess(String strProcessToKill) {
		Logger.getInstance().add("  ==start==>WindowsProcessKill " + Util.getDateTimestamp());
		try {
			Runtime.getRuntime().exec(strProcessToKill);
			Logger.getInstance().add("WindowsProcessKill: process killed = " + strProcessToKill);
		} catch (Exception e) {
			Logger.getInstance().add("WindowsProcessKill: Exception = " + e.toString());
		}
	}

	void verifyInternetExplorerVersion() throws IOException {
		String strKeyName = "";
		Process objProcess;
		String strSvcUpdateVersion = "11.0.27";
		String strSvcvcVersion = "11.0.9600.18163";
		String strSvcvcKBNumber = "KB3124275";
		String strExpectedKeyValue = "";
		String strActualKeyValue = "";
		Logger.getInstance().add("  ==start==>InternetExplorerVersion " + Util.getDateTimestamp());
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
				Logger.getInstance().add(strFullRegistryKey.replaceAll("\\s+", " ").trim());
				Logger.getInstance().add(strActualKeyValue);
			}
		}
	}
}
