package org.DragonflyAutomation;

import org.openqa.selenium.WebElement;

class ElementDrag {
	private static volatile ElementDrag instance = null;
	WebElement elementDrag = null;

	private ElementDrag() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static ElementDrag getInstance() {
		if (instance == null) {
			instance = new ElementDrag();
			synchronized (ElementDrag.class) {
				if (instance == null) {
					instance = new ElementDrag();
				}
			}
		}
		return instance;
	}
}
