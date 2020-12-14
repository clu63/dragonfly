package org.DragonflyAutomation;

class ElementVisible {
	ElementVisible() throws ExceptionElementNotVisible {
		// TODO elementVisible add check for class and css, commented code needs to be tested
		Logger.getInstance().add("  ==start==>ElementVisible " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		Boolean blnVisible = false;
		try {
			// TODO Alert complete
			if (JSONS.getInstance().step.verifyEquals("strTagName", "title")) {
				blnVisible = true;
				return;
			}
			if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
				if (new AlertFind().run() == true) {
					blnVisible = true;
					JSONS.getInstance().step.putValue("strHighlightArea", "alert");
					new CoordinatesAlert();
					return;
				} else {
					throw new ExceptionElementNotVisible("Alert popup was not found.");
				}
			}
			if (Element.getInstance().element.isDisplayed()) {
				new CoordinatesElement();
				blnVisible = true;
				return;
				// if (JSONS.getInstance().step.containsKey("intElementWidth")) {
				// int intElementWidth = Integer.parseInt(JSONS.getInstance().step.get("intElementWidth").toString());
				// int intElementHeight = Integer.parseInt(JSONS.getInstance().step.get("intElementHeight").toString());
				//  Logger.getInstance().add("elementVisible intElementWidth = " + intElementWidth);
				//  Logger.getInstance().add("elementVisible intElementHeight = " + intElementHeight);
				// if (intElementWidth == 0 || intElementHeight == 0) {
				// throw new ExceptionElementNotVisible("Element's heigh or width is 0");
				// } else {
				// return true;
				// }
				// } else {
				// throw new ExceptionElementNotVisible("Element's heigh or width is 0");
				// }
			} else {
				throw new ExceptionElementNotVisible("Element isDisplayed failed");
			}
		} finally {
			Logger.getInstance().add("ElementVisible: finally blnVisible = " + blnVisible + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}