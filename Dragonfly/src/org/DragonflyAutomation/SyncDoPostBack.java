package org.DragonflyAutomation;

import org.openqa.selenium.By;

class SyncDoPostBack {
	SyncDoPostBack(String strOuterHTML) throws ExceptionDoPostBackNotComplete {
		Logger.getInstance().add("  ==start==>SyncDoPostBack " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		boolean blnEventTarget = false;
		if (strOuterHTML.contains("__doPostBack")) {
			try {
				Logger.getInstance().add("SyncDoPostBack: __EVENTTARGET value = " + BrowserDriver.getInstance().browserDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value"));
				blnEventTarget = !BrowserDriver.getInstance().browserDriver.findElement(By.id("__EVENTTARGET")).getAttribute("value").equals("");
				if (blnEventTarget == true) {
					throw new ExceptionDoPostBackNotComplete("");
				}
			} catch (Exception e) {
				Logger.getInstance().add("SyncDoPostBack: Exception = " + e.toString());
			} finally {
				Logger.getInstance().add("SyncDoPostBack: blnEventTarget = " + blnEventTarget + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			}
		}
	}
}
