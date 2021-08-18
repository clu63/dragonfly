package org.DragonflyAutomation;

enum EnumScreenshots {
	ON("on"),
	OFF("off"),
	FAIL("fail"),
	DEFAULT("default"),
	INTEST("intest");
	private final String screenshotOption;

	private EnumScreenshots(String screenshotOption) {
		this.screenshotOption = screenshotOption;
	}

	String getScreenshotOption() {
		return screenshotOption;
	}
}
