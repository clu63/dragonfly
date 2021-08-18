package org.DragonflyAutomation;

enum EnumBrowser {
	CHROME("chrome"),
	EDGE("edge"),
	IE32("ie32"),
	IE64("ie64"),
	GECKO("gecko");
	private final String browserName;

	private EnumBrowser(String browserName) {
		this.browserName = browserName;
	}

	String getBrowserName() {
		return browserName;
	}
}
