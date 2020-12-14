package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ElementFind {
	ElementFind() throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
		Logger.getInstance().add("  ==start==>ElementFind " + Util.getDateTimestamp());
		if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
			JSONS.getInstance().step.putValue("strTagType", "alert");
			if (new AlertFind().run() == true) {
				JSONS.getInstance().step.putValue("strHighlightArea", "alert");
				return;
			} else {
				JSONS.getInstance().step.putValue("strHighlightArea", "screen");
				throw new ExceptionElementNotFound("Alert popup not found!");
			}
		}
		if (JSONS.getInstance().step.getString("strTagName").toLowerCase().equals("title")) {
			JSONS.getInstance().step.putValue("strTagType", "title");
			return;
		}
		String strWindowHandle = "";
		Object[] arrHandles = BrowserDriver.getInstance().browserDriver.getWindowHandles().toArray();
		Collections.reverse(Arrays.asList(arrHandles));
		for (Object objWindowHandlesEach : arrHandles) {
			Logger.getInstance().add("ElementFind: objWindowHandlesEach.toString() = " + objWindowHandlesEach.toString());
		}
		for (Object objWindowHandlesEach : arrHandles) {
			try {
				strWindowHandle = objWindowHandlesEach.toString();
				BrowserDriver.getInstance().browserDriver.switchTo().window(strWindowHandle);
				new CoordinatesBrowserInner();
				List<Integer> arrRouteOriginal = new ArrayList<Integer>();
				new ElementFindFramesSearch().run(arrRouteOriginal);
				if (Element.getInstance().element != null) {
					// Logger.getInstance().add("elementFind: BrowserDriver.getInstance().browserDriver.switchTo().window(strWindowHandle) = " + strWindowHandle);
					// Logger.getInstance().add("elementFind: BrowserDriver.getInstance().browserDriver.getTitle = " + BrowserDriver.getInstance().browserDriver.getTitle());
					// Logger.getInstance().add("ElementFindFramesSearch: BrowserDriver.getInstance().browserDriver.getTitle = " + BrowserDriver.getInstance().browserDriver.getTitle());
					// Logger.getInstance().add("ElementFindFramesSearch: BrowserDriver.getInstance().browserDriver.getCurrentUrl = " + BrowserDriver.getInstance().browserDriver.getCurrentUrl());
					// Logger.getInstance().add("ElementFindFramesSearch: BrowserDriver.getInstance().browserDriver.getWindowHandle = " + BrowserDriver.getInstance().browserDriver.getWindowHandle());
					// Logger.getInstance().add("ElementFindFramesSearch BrowserDriver.getInstance().browserDriver.getPageSource = " + BrowserDriver.getInstance().browserDriver.getPageSource());
					return;
				}
			} catch (Exception e) {
				Logger.getInstance().add("ElementFind: Exception = " + e.toString());
			}
		}
		throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
	}
}