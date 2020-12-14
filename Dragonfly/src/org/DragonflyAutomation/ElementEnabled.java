package org.DragonflyAutomation;

class ElementEnabled {
	ElementEnabled() throws ExceptionElementNotEnabled {
		Logger.getInstance().add("  ==start==>ElementEnabled " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		try {
			if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
				if (new AlertFind().run() == true) {
					return;
				} else {
					throw new ExceptionElementNotEnabled("Alert popup was not found.");
				}
			}
			if (Element.getInstance().element.isEnabled()) {
				return;
			} else {
				throw new ExceptionElementNotEnabled("ElementEnabled - Element is not enabled");
			}
		} finally {
			Logger.getInstance().add("ElementEnabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}