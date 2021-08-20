package org.DragonflyAutomation;

class BrowserCloseSync {
	BrowserCloseSync() {
		// TODO create a browserCloseSync to manage reporting and sync close
		long lngStartTime = System.currentTimeMillis();
		new BrowserClose();
		JSONS.getInstance().step.putValue("strStepActual", "browser_close");
		new StepDuration("BrowserCloseSync", lngStartTime, "browser_close");
	}
}
