package org.DragonflyAutomation;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;

class AlertFind {
	boolean run() {
		Logger.getInstance().add("  ==start==>AlertFind " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		try {
			String strAlertPresent = BrowserDriver.getInstance().browserDriver.switchTo().alert().getText();
			Logger.getInstance().add("AlertFind: alert found:  " + strAlertPresent);
			return true;
		} catch (UnhandledAlertException e) {
			Logger.getInstance().add("AlertFind: UnhandledAlertException = " + e.toString());
			return true;
		} catch (NoAlertPresentException e) {
			Logger.getInstance().add("AlertFind: NoAlertPresentException = " + e.toString());
			return false;
		} catch (Exception e) {
			Logger.getInstance().add("AlertFind: Exception = " + e.toString());
			return false;
		} finally {
			Logger.getInstance().add("AlertFind: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}