package org.DragonflyAutomation;

class BrowserRefresh {
	BrowserRefresh() {
		Logger.getInstance().add("  ==start==>BrowserRefresh " + Util.getDateTimestamp());
		BrowserDriver.getInstance().browserDriver.navigate().refresh();
	}
}