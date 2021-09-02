package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;

class CoordinatesBrowserInner {
	CoordinatesBrowserInner() throws WebDriverException {
		Logger.getInstance().add("  ==start==>CoordinatesBrowserInner " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		long lngBrowserInnerWidth = 0;
		long lngBrowserInnerHeight = 0;
		try {
			switch (Config.getInstance().browserSelection.toLowerCase()) {
			case "ie":
			case "internet explorer":
				Logger.getInstance().add("CoordinatesBrowserInner: ie");
				lngBrowserInnerWidth = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.screenLeft;");
				Logger.getInstance().add("CoordinatesBrowserInner: lngBrowserInnerWidth " + lngBrowserInnerWidth);
				lngBrowserInnerHeight = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.screenTop;");
				Logger.getInstance().add("CoordinatesBrowserInner: lngBrowserInnerHeight " + lngBrowserInnerHeight);
				JSONS.getInstance().step.putValue("intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
				JSONS.getInstance().step.putValue("intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
				break;
			case "firefox":
				Logger.getInstance().add("CoordinatesBrowserInner: firefox");
				lngBrowserInnerWidth = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return Math.round(window.mozInnerScreenX * window.devicePixelRatio);");
				lngBrowserInnerHeight = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return Math.round(window.mozInnerScreenY * window.devicePixelRatio);");
				JSONS.getInstance().step.putValue("intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
				JSONS.getInstance().step.putValue("intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
				Config.getInstance().devicePixelRatio = (Double) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.devicePixelRatio;");
				Logger.getInstance().add("CoordinatesBrowserInner: gdblDevicePixelRatio = " + Config.getInstance().devicePixelRatio.toString());
				Logger.getInstance().add("CoordinatesBrowserInner: lngBrowserInnerWidth = " + lngBrowserInnerWidth);
				Logger.getInstance().add("CoordinatesBrowserInner: intBrowserInnerHeight = " + lngBrowserInnerHeight);
				break;
			case "chrome":
				lngBrowserInnerWidth = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return  Math.round((((window.outerWidth - window.innerWidth) / 2) + window.screenX) * window.devicePixelRatio);");
				lngBrowserInnerHeight = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return  Math.round(((window.outerHeight - window.innerHeight) - ((window.outerWidth - window.innerWidth) / 2) + window.screenY) * window.devicePixelRatio);");
				Long lngDevicePixelRatio = (Long) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.devicePixelRatio;");
				Logger.getInstance().add("CoordinatesBrowserInner: lngDevicePixelRatio = " + lngDevicePixelRatio.toString());
				//gdblDevicePixelRatio = (Double) ((JavascriptExecutor) BrowserDriver.getInstance().browserDriver).executeScript("return window.devicePixelRatio;");
				Config.getInstance().devicePixelRatio = Double.parseDouble(lngDevicePixelRatio.toString());
				Logger.getInstance().add("CoordinatesBrowserInner: gdblDevicePixelRatio = " + Config.getInstance().devicePixelRatio.toString());
				JSONS.getInstance().step.putValue("intBrowserInnerWidth", Long.toString(lngBrowserInnerWidth));
				JSONS.getInstance().step.putValue("intBrowserInnerHeight", Long.toString(lngBrowserInnerHeight));
				break;
			}
		} catch (Exception e) {
			Logger.getInstance().add("CoordinatesBrowserInner: Exception = " + e.toString());
		} finally {
			Logger.getInstance().add("CoordinatesBrowserInner: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}