package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class ScrollToBottom {
	ScrollToBottom() {
		Logger.getInstance().add("  ==start==>ScrollToBottom " + Util.getDateTimestamp());
		// TODO debug all browser types, should use instanceof from windowFocus???? should combine into 1 line?
		JavascriptExecutor executor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
		executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}
}
