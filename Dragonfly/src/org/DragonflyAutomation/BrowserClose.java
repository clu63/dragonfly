package org.DragonflyAutomation;

class BrowserClose {
	BrowserClose() {
		BrowserDriver.getInstance().browserDriver.close();
		BrowserDriver.getInstance().browserDriver.quit();
		JSONS.getInstance().step.putValue("strStatus", "pass");
		new CoordinateHighlightScreenshot(JSONS.getInstance().step);
	}
}
