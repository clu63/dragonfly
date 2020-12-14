package org.DragonflyAutomation;

class BrowserLaunchSync {
	BrowserLaunchSync() {
		Logger.getInstance().add("  ==start==>BrowserLaunchSync " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		try {
			new BrowserLaunch();
		} catch (ExceptionBrowserDriverNotSupported e) {
			// TODO confirm the exceptions to catch in main some may need to be removed
			Logger.getInstance().add("BrowserLaunchSync: " + e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO create a BrowserLaunchSync to manage reporting and sync
			new CoordinatesElement();
			new CoordinateHighlightScreenshot(JSONS.getInstance().step);
			JSONS.getInstance().step.putValue("strStepActual", "browser_launch");
			new StepDuration("BrowserLaunchSync", lngStartTime, "browser_launch");
			Logger.getInstance().add("BrowserLaunchSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}