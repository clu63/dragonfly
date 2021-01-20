package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class WindowFocus {
	WindowFocus() {
		Logger.getInstance().add("  ==start==>WindowFocus " + Util.getDateTimestamp());
		// TODO debug BrowserDriver.getInstance().browserDriver instanceof JavascriptExecutor, what does it do and is it needed and debug all browser types
		if (BrowserDriver.getInstance().browserDriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("window.focus();");
		}
	}
}
