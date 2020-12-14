package org.DragonflyAutomation;

class ElementDisabled {
	ElementDisabled() throws ExceptionElementNotDisabled {
		Logger.getInstance().add("  ==start==>ElementDisabled " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		try {
			if (Element.getInstance().element.isEnabled()) {
				throw new ExceptionElementNotDisabled("ElementDisabled - Element is not disabled");
			} else {
				return;
			}
		} finally {
			Logger.getInstance().add("ElementDisabled: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}