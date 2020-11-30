package org.DragonflyAutomation;

import org.openqa.selenium.WebDriver;

class BrowserDriver {
	private static volatile BrowserDriver instance = null;
	WebDriver browserDriver = null;
	private BrowserDriver() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static BrowserDriver getInstance() {
		if (instance == null) {
			instance = new BrowserDriver();
			synchronized (BrowserDriver.class) {
				if (instance == null) {
					instance = new BrowserDriver();
				}
			}
		}
		return instance;
	}
}
