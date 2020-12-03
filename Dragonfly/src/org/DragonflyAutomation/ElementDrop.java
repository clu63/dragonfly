package org.DragonflyAutomation;

import org.openqa.selenium.WebElement;

class ElementDrop {
	private static volatile ElementDrop instance = null;
	WebElement elementDrop = null;

	private ElementDrop() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static ElementDrop getInstance() {
		if (instance == null) {
			instance = new ElementDrop();
			synchronized (ElementDrop.class) {
				if (instance == null) {
					instance = new ElementDrop();
				}
			}
		}
		return instance;
	}
}
