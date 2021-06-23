package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

public class TestModule {
	private List<TestModuleDetails> testModule = new ArrayList<TestModuleDetails>();

	class TestModuleDetails {
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

		Boolean getExitOnFail() {
			return exitOnFail;
		}

		String getFunction() {
			return classByName;
		}

		Boolean getHighlight() {
			return highlight;
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

		String getTagName() {
			return tagName;
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

		void setExitOnFail(Boolean exitOnFail) {
			this.exitOnFail = exitOnFail;
		}

		void setFunction(String classByName) {
			this.classByName = classByName;
		}

		void setHighlight(Boolean highlight) {
			this.highlight = highlight;
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

		void setTagName(String tagName) {
			this.tagName = tagName;
		}
	}
}