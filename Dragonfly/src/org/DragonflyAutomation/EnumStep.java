package org.DragonflyAutomation;

enum EnumStep {
	ACTION("Action", "String", "action"),
	LOGICALNAME("LogicalName", "String", "logicalName"),
	TAGNAME("TagName", "String", "tagName"),
	ATTRIBUTENAMES("AttributeNames", "String", "attributeNames"),
	ATTRIBUTEVALUES("AttributeValues", "String", "attributeValues"),
	INPUTVALUE("InputValue", "String", "inputValue"),
	ASSERTSET("AssertSet", "String", "assertSet"),
	OPTIONAL("Optional", "Boolean", "optional"),
	EXITONFAIL("ExitOnFail", "Boolean", "exitOnFail"),
	MILLISECONDSTOWAIT("MillisecondsToWait", "Integer", "millisecondsToWait"),
	CLASSBYNAME("ClassByName", "String", "classByName"),
	OUTPUTLINKNAME("OutputLinkName", "String", "outputLinkName"),
	LOOPORIF("LoopOrIf", "String", "loopOrIf"),
	PLEASEWAIT("PleaseWait", "Boolean", "pleaseWait"),
	HIGHLIGHT("Highlight", "Boolean", "highlight"),
	SCREENSHOT("Screenshot", "Boolean", "screenshot"),
	ASSISTIVEPROPERTIES("AssistiveProperties", "String", "assistiveProperties"),
	OUTPUTVALUE("OutputValue", "String", "outputValue"),
	BROWSERINNERWIDTH("BrowserInnerWidth", "Integer", "browserInnerWidth"),
	BROWSERINNERHEIGHT("BrowserInnerHeight", "Integer", "browserInnerHeight"),
	BROWSEROUTERX("BrowserOuterX", "Integer", "browserOuterX"),
	BROWSEROUTERY("BrowserOuterY", "Integer", "browserOuterY"),
	BROWSEROUTERWIDTH("BrowserOuterWidth", "Integer", "browserOuterWidth"),
	BROWSEROUTERHEIGHT("BrowserOuterHeight", "Integer", "browserOuterHeight"),
	ELEMENTSCREENX("ElementScreenX", "Integer", "elementScreenX"),
	ELEMENTSCREENY("ElementScreenY", "Integer", "elementScreenY"),
	ELEMENTX("ElementX", "Integer", "elementX"),
	ELEMENTY("ElementY", "Integer", "elementY"),
	ELEMENTWIDTH("ElementWidth", "Integer", "elementWidth"),
	ELEMENTHEIGHT("ElementHeight", "Integer", "elementHeight"),
	TAGTYPE("TagType", "String", "tagType"),
	TYPEVALUE("TypeValue", "String", "typeValue"),
	CURRENTWINDOWHANDLE("CurrentWindowHandle", "String", "currentWindowHandle"),
	URLVALUE("UrlValue", "String", "urlValue"),
	STEPEXPECTED("StepExpected", "String", "stepExpected"),
	STEPACTUAL("StepActual", "String", "stepActual"),
	STARTTIMESTAMP("StartTimestamp", "String", "startTimestamp"),
	ENDTIMESTAMP("EndTimestamp", "String", "endTimestamp"),
	STEPDURATION("StepDuration", "String", "stepDuration"),
	SCREENSHOTAREA("ScreenshotArea", "String", "screenshotArea"),
	HIGHLIGHTAREA("HighlightArea", "String", "highlightArea"),
	SCREENSHOTFILEPATH("ScreenshotFilePath", "String", "screenshotFilePath"),
	STATUS("Status", "String", "status"),
	TESTMODULESTEP("TestModuleStep", "String", "testModuleStep");
	private final String columnFieldName;
	private final String dataType;
	private final String fieldName;

	private EnumStep(String columnFieldName, String dataType, String fieldName) {
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
