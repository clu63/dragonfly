package org.DragonflyAutomation;

enum EnumHighlight {
	ON("on"),
	OFF("off"),
	FAIL("fail"),
	DEFAULT("default"),
	INTEST("intest");
	private final String highlightOption;

	private EnumHighlight(String highlightOption) {
		this.highlightOption = highlightOption;
	}

	String getHighlightOption() {
		return highlightOption;
	}
}
