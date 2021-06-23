package org.DragonflyAutomation;

enum EnumStepDefault {
	ASSERTSET("AssertSet", "String", "assertSet"),
	OPTIONAL("Optional", "Boolean", "optional"),
	EXITONFAIL("ExitOnFail", "Boolean", "exitOnFail"),
	MILLISECONDSTOWAIT("MillisecondsToWait", "Integer", "millisecondsToWait"),
	PLEASEWAIT("PleaseWait", "Boolean", "pleaseWait"),
	HIGHLIGHT("Highlight", "Boolean", "highlight"),
	SCREENSHOT("Screenshot", "Boolean", "screenshot"),
	SCREENSHOTAREA("ScreenshotArea", "String", "screenshotArea"),
	STATUS("Status", "String", "status");
	private final String columnFieldName;
	private final String dataType;
	private final String fieldName;

	private EnumStepDefault(String columnFieldName, String dataType, String fieldName) {
		this.columnFieldName = columnFieldName;
		this.dataType = dataType;
		this.fieldName = fieldName;
	}

	String getColumnFieldName() {
		return this.columnFieldName;
	}

	String getDataType() {
		return this.dataType;
	}

	String getFieldName() {
		return this.fieldName;
	}
}
