package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestStep {
	List<TestStepFields> testModule = new ArrayList<TestStepFields>();

	List<TestStepFields> getTestModule() {
		return this.testModule;
	}

	class TestStepFields {
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

		String getAction() {
			return action;
		}

		String getAssertSet() {
			return assertSet;
		}

		String getAssistiveProperties() {
			return assistiveProperties;
		}

		String getAttributeNames() {
			return attributeNames;
		}

		String getAttributeValues() {
			return attributeValues;
		}

		Integer getBrowserInnerHeight() {
			return browserInnerHeight;
		}

		Integer getBrowserInnerWidth() {
			return browserInnerWidth;
		}

		Integer getBrowserOuterHeight() {
			return browserOuterHeight;
		}

		Integer getBrowserOuterWidth() {
			return browserOuterWidth;
		}

		Integer getBrowserOuterX() {
			return browserOuterX;
		}

		Integer getBrowserOuterY() {
			return browserOuterY;
		}

		String getClassByName() {
			return classByName;
		}

		String getCurrentWindowHandle() {
			return currentWindowHandle;
		}

		Integer getElementHeight() {
			return elementHeight;
		}

		Integer getElementScreenX() {
			return elementScreenX;
		}

		Integer getElementScreenY() {
			return elementScreenY;
		}

		Integer getElementWidth() {
			return elementWidth;
		}

		Integer getElementX() {
			return elementX;
		}

		Integer getElementY() {
			return elementY;
		}

		String getEndTimestamp() {
			return endTimestamp;
		}

		Boolean getExitOnFail() {
			return exitOnFail;
		}

		Boolean getHighlight() {
			return highlight;
		}

		String getHighlightArea() {
			return highlightArea;
		}

		String getInputValue() {
			return inputValue;
		}

		String getLogicalName() {
			return logicalName;
		}

		String getLoopOrIf() {
			return loopOrIf;
		}

		Integer getMillisecondsToWait() {
			return millisecondsToWait;
		}

		Boolean getOptional() {
			return optional;
		}

		String getOutputLinkName() {
			return outputLinkName;
		}

		String getOutputValue() {
			return outputValue;
		}

		Boolean getPleaseWait() {
			return pleaseWait;
		}

		Boolean getScreenshot() {
			return screenshot;
		}

		String getScreenshotArea() {
			return screenshotArea;
		}

		String getScreenshotFilePath() {
			return screenshotFilePath;
		}

		String getStartTimestamp() {
			return startTimestamp;
		}

		String getStatus() {
			return status;
		}

		String getStepActual() {
			return stepActual;
		}

		String getStepDuration() {
			return stepDuration;
		}

		String getStepExpected() {
			return stepExpected;
		}

		String getTagName() {
			return tagName;
		}

		String getTagType() {
			return tagType;
		}

		String getTestModuleStep() {
			return testModuleStep;
		}

		String getTypeValue() {
			return typeValue;
		}

		String getUrlValue() {
			return urlValue;
		}

		void setAction(String action) {
			this.action = action;
		}

		void setAssertSet(String assertSet) {
			this.assertSet = assertSet;
		}

		void setAssistiveProperties(String assistiveProperties) {
			this.assistiveProperties = assistiveProperties;
		}

		void setAttributeNames(String attributeNames) {
			this.attributeNames = attributeNames;
		}

		void setAttributeValues(String attributeValues) {
			this.attributeValues = attributeValues;
		}

		void setBrowserInnerHeight(Integer browserInnerHeight) {
			this.browserInnerHeight = browserInnerHeight;
		}

		void setBrowserInnerWidth(Integer browserInnerWidth) {
			this.browserInnerWidth = browserInnerWidth;
		}

		void setBrowserOuterHeight(Integer browserOuterHeight) {
			this.browserOuterHeight = browserOuterHeight;
		}

		void setBrowserOuterWidth(Integer browserOuterWidth) {
			this.browserOuterWidth = browserOuterWidth;
		}

		void setBrowserOuterX(Integer browserOuterX) {
			this.browserOuterX = browserOuterX;
		}

		void setBrowserOuterY(Integer browserOuterY) {
			this.browserOuterY = browserOuterY;
		}

		void setClassByName(String classByName) {
			this.classByName = classByName;
		}

		void setCurrentWindowHandle(String currentWindowHandle) {
			this.currentWindowHandle = currentWindowHandle;
		}

		void setElementHeight(Integer elementHeight) {
			this.elementHeight = elementHeight;
		}

		void setElementScreenX(Integer elementScreenX) {
			this.elementScreenX = elementScreenX;
		}

		void setElementScreenY(Integer elementScreenY) {
			this.elementScreenY = elementScreenY;
		}

		void setElementWidth(Integer elementWidth) {
			this.elementWidth = elementWidth;
		}

		void setElementX(Integer elementX) {
			this.elementX = elementX;
		}

		void setElementY(Integer elementY) {
			this.elementY = elementY;
		}

		void setEndTimestamp(String endTimestamp) {
			this.endTimestamp = endTimestamp;
		}

		void setExitOnFail(Boolean exitOnFail) {
			this.exitOnFail = exitOnFail;
		}

		void setHighlight(Boolean highlight) {
			this.highlight = highlight;
		}

		void setHighlightArea(String highlightArea) {
			this.highlightArea = highlightArea;
		}

		void setInputValue(String inputValue) {
			this.inputValue = inputValue;
		}

		void setLogicalName(String logicalName) {
			this.logicalName = logicalName;
		}

		void setLoopOrIf(String loopOrIf) {
			this.loopOrIf = loopOrIf;
		}

		void setMillisecondsToWait(Integer millisecondsToWait) {
			this.millisecondsToWait = millisecondsToWait;
		}

		void setOptional(Boolean optional) {
			this.optional = optional;
		}

		void setOutputLinkName(String outputLinkName) {
			this.outputLinkName = outputLinkName;
		}

		void setOutputValue(String outputValue) {
			this.outputValue = outputValue;
		}

		void setPleaseWait(Boolean pleaseWait) {
			this.pleaseWait = pleaseWait;
		}

		void setScreenshot(Boolean screenshot) {
			this.screenshot = screenshot;
		}

		void setScreenshotArea(String screenshotArea) {
			this.screenshotArea = screenshotArea;
		}

		void setScreenshotFilePath(String screenshotFilePath) {
			this.screenshotFilePath = screenshotFilePath;
		}

		void setStartTimestamp(String startTimestamp) {
			this.startTimestamp = startTimestamp;
		}

		void setStatus(String status) {
			this.status = status;
		}

		void setStepActual(String stepActual) {
			this.stepActual = stepActual;
		}

		void setStepDuration(String stepDuration) {
			this.stepDuration = stepDuration;
		}

		void setStepExpected(String stepExpected) {
			this.stepExpected = stepExpected;
		}

		void setTagName(String tagName) {
			this.tagName = tagName;
		}

		void setTagType(String tagType) {
			this.tagType = tagType;
		}

		void setTestModuleStep(String testModuleStep) {
			this.testModuleStep = testModuleStep;
		}

		void setTypeValue(String typeValue) {
			this.typeValue = typeValue;
		}

		void setUrlValue(String urlValue) {
			this.urlValue = urlValue;
		}
	}
}
