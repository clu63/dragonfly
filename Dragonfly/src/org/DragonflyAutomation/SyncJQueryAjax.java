package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class SyncJQueryAjax {
	SyncJQueryAjax() throws ExceptionJQueryAjaxNotComplete {
		Logger.getInstance().add("  ==start==>SyncJQueryAjax " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		boolean blnJquery = false;
		long lngJqueryActive = 0;
		try {
			blnJquery = (boolean) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (window.jQuery != null);");
			if (blnJquery == true) {
				lngJqueryActive = (long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (jQuery.active);");
				Logger.getInstance().add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive);
				if (lngJqueryActive > 0) {
					throw new ExceptionJQueryAjaxNotComplete("");
				}
			}
		} catch (Exception e) {
			Logger.getInstance().add("SyncJQueryAjax: JqueryActive Exception = " + e.toString());
		} finally {
			Logger.getInstance().add("SyncJQueryAjax: lngJqueryActive = " + lngJqueryActive + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
