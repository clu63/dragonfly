package org.DragonflyAutomation;

import org.openqa.selenium.WebDriverException;

class ElementHidden {
	 ElementHidden() throws ExceptionElementNotHidden {
		Logger.getInstance().add("  ==start==>ElementHidden " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		try {
			if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
				if (new AlertFind().run() == false) {
					JSONS.getInstance().step.putValue("strHighlightArea", "screen");
					return;
				} else {
					throw new ExceptionElementNotHidden("Alert popup was not hidden.");
				}
			}
			if (Element.getInstance().element.isDisplayed() == false) {
				return;
			} else {
				Logger.getInstance().add("ElementHidden: Element.getInstance().element.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
				throw new ExceptionElementNotHidden("Element is displayed.");
			}
		} catch (NullPointerException | WebDriverException e) {
			Logger.getInstance().add("ElementHidden: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			return;
		} finally {
			Logger.getInstance().add("ElementHidden: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}