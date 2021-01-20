package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class WaitForReadyState {
	boolean run() {
		Logger.getInstance().add("  ==start==>WaitForReadyState " + Util.getDateTimestamp());
		Logger.getInstance().add("waitForReadyState: document.readyState Milliseconds Waited = " + ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return document.readyState"));
		return false;
	}
}
