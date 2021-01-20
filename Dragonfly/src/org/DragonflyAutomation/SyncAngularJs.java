package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class SyncAngularJs {
	SyncAngularJs() throws ExceptionAngularJsNotComplete {
		Logger.getInstance().add("  ==start==>SyncAngularJs " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		boolean blnAngularJs = false;
		long lngAngularJsInjectorActive = 0;
		try {
			blnAngularJs = (boolean) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (window.angular != null);");
			Logger.getInstance().add("SyncAngularJs: = " + blnAngularJs);
			lngAngularJsInjectorActive = (long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (angular.element(document).injector().get(‘$http’).pendingRequests.length);");
			if (lngAngularJsInjectorActive > 0) {
				throw new ExceptionAngularJsNotComplete("");
			}
		} catch (Exception e) {
			Logger.getInstance().add("SyncAngularJs: AngularJS Exception = " + e.toString());
		} finally {
			Logger.getInstance().add("SyncAngularJs: lngAngularJsInjectorActive = " + lngAngularJsInjectorActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
