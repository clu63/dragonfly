package org.DragonflyAutomation;

class BrowserRefreshSync {
	BrowserRefreshSync() {
		long lngStartTime = System.currentTimeMillis();
		new BrowserRefresh();
		JSONS.getInstance().step.putValue("strStepActual", "browser_refresh");
		new StepDuration("BrowserRefreshSync", lngStartTime, "browser_refresh");
	}
}
