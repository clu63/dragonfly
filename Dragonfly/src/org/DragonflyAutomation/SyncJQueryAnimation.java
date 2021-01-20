package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class SyncJQueryAnimation {
	SyncJQueryAnimation() throws ExceptionJQueryAnimationNotComplete {
		Logger.getInstance().add("  ==start==>SyncJQueryAnimation " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		long lngElementsAnimated = 0;
		boolean blnJqueryExist = false;
		try {
			blnJqueryExist = (boolean) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return (window.jQuery != null);");
			if (blnJqueryExist == true) {
				lngElementsAnimated = (long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return $(\":animated\").length");
			}
			if (lngElementsAnimated > 0) {
				throw new ExceptionJQueryAnimationNotComplete("");
			}
		} catch (Exception e) {
			Logger.getInstance().add("SyncJQueryAnimation: Exception = " + e.toString());
		} finally {
			Logger.getInstance().add("SyncJQueryAnimation: lngElementsAnimated = " + lngElementsAnimated + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
