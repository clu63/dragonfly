package org.DragonflyAutomation;

import org.openqa.selenium.WebElement;

class Element {
	private static volatile Element instance = null;
	WebElement element = null;

	private Element() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static Element getInstance() {
		if (instance == null) {
			instance = new Element();
			synchronized (Element.class) {
				if (instance == null) {
					instance = new Element();
				}
			}
		}
		return instance;
	}
}
