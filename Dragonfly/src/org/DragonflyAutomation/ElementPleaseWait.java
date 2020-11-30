package org.DragonflyAutomation;

import org.openqa.selenium.WebElement;

class ElementPleaseWait {
	private static volatile ElementPleaseWait instance = null;
	 WebElement elementPleaseWait = null;

	private ElementPleaseWait() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static ElementPleaseWait getInstance() {
		if (instance == null) {
			instance = new ElementPleaseWait();
			synchronized (ElementPleaseWait.class) {
				if (instance == null) {
					instance = new ElementPleaseWait();
				}
			}
		}
		return instance;
	}
}
