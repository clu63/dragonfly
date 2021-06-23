package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestStep {
	List<TestStepDetails> testModule = new ArrayList<TestStepDetails>();

	List<TestStepDetails> getTestModule() {
		return this.testModule;
	}

	class TestStepDetails {
		private String action;
		private String logicalName;
		private String tagName;
		private String attributeNames;
		private String attributeValues;
		private String inputValue;
		private String assertSet;
		private Boolean optional;
		private Boolean exitOnFail;
		private Integer millisecondsToWait;
		private String classByName;
		private String outputLinkName;
		private String loopOrIf;
		private Boolean pleaseWait;
		private Boolean highlight;
		private Boolean screenshot;
		private String assistiveProperties;
		private String outputValue;
		private Integer browserInnerWidth;
		private Integer browserInnerHeight;
		private Integer browserOuterX;
		private Integer browserOuterY;
		private Integer browserOuterWidth;
		private Integer browserOuterHeight;
		private Integer elementScreenX;
		private Integer elementScreenY;
		private Integer elementX;
		private Integer elementY;
		private Integer elementWidth;
		private Integer elementHeight;
		private String tagType;
		private String typeValue;
		private String currentWindowHandle;
		private String urlValue;
		private String stepExpected;
		private String stepActual;
		private String startTimestamp;
		private String endTimestamp;
		private String stepDuration;
		private String screenshotArea;
		private String highlightArea;
		private String screenshotFilePath;
		private String status;
		private String testModuleStep;
	}
}
