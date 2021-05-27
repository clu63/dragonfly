package org.DragonflyAutomation;

import com.google.gson.annotations.SerializedName;

class TestModule {
	@SerializedName("strAction")
	String Action;
	String strLogicalName;
	String strTagName;
	String strAttributeNames;
	String strAttributeValues;
	String strInputValue;
	String strAssert;
	Boolean blnOptional;
	String blnExitOnFail;
	String intMillisecondsToWait;
	String strFunction;
	String strOutputLinkName;
	String strLoopOrIf;
	String blnPleaseWait;
	String blnHighlight;
	String blnScreenshot;
	String strAssistiveProperties;
	String strOutputValue;
	transient Steps[] steps;
	String AddNull = "value";

	public String getStrAction() {
		return Action;
	}

	public void setStrAction(String strAction) {
		this.Action = strAction;
	}

	public String getStrLogicalName() {
		return strLogicalName;
	}

	public void setStrLogicalName(String strLogicalName) {
		this.strLogicalName = strLogicalName;
	}

	public String getStrTagName() {
		return strTagName;
	}

	public void setStrTagName(String strTagName) {
		this.strTagName = strTagName;
	}

	public String getStrAttributeNames() {
		return strAttributeNames;
	}

	public void setStrAttributeNames(String strAttributeNames) {
		this.strAttributeNames = strAttributeNames;
	}

	public String getStrAttributeValues() {
		return strAttributeValues;
	}

	public void setStrAttributeValues(String strAttributeValues) {
		this.strAttributeValues = strAttributeValues;
	}

	public String getStrInputValue() {
		return strInputValue;
	}

	public void setStrInputValue(String strInputValue) {
		this.strInputValue = strInputValue;
	}

	public String getStrAssert() {
		return strAssert;
	}

	public void setStrAssert(String strAssert) {
		this.strAssert = strAssert;
	}

	public Boolean getBlnOptional() {
		return blnOptional;
	}

	public void setBlnOptional(Boolean blnOptional) {
		this.blnOptional = blnOptional;
	}

	public String getBlnExitOnFail() {
		return blnExitOnFail;
	}

	public void setBlnExitOnFail(String blnExitOnFail) {
		this.blnExitOnFail = blnExitOnFail;
	}

	public String getIntMillisecondsToWait() {
		return intMillisecondsToWait;
	}

	public void setIntMillisecondsToWait(String intMillisecondsToWait) {
		this.intMillisecondsToWait = intMillisecondsToWait;
	}

	public String getStrFunction() {
		return strFunction;
	}

	public void setStrFunction(String strFunction) {
		this.strFunction = strFunction;
	}

	public String getStrOutputLinkName() {
		return strOutputLinkName;
	}

	public void setStrOutputLinkName(String strOutputLinkName) {
		this.strOutputLinkName = strOutputLinkName;
	}

	public String getStrLoopOrIf() {
		return strLoopOrIf;
	}

	public void setStrLoopOrIf(String strLoopOrIf) {
		this.strLoopOrIf = strLoopOrIf;
	}

	public String getBlnPleaseWait() {
		return blnPleaseWait;
	}

	public void setBlnPleaseWait(String blnPleaseWait) {
		this.blnPleaseWait = blnPleaseWait;
	}

	public String getBlnHighlight() {
		return blnHighlight;
	}

	public void setBlnHighlight(String blnHighlight) {
		this.blnHighlight = blnHighlight;
	}

	public String getBlnScreenshot() {
		return blnScreenshot;
	}

	public void setBlnScreenshot(String blnScreenshot) {
		this.blnScreenshot = blnScreenshot;
	}

	public String getStrAssistiveProperties() {
		return strAssistiveProperties;
	}

	public void setStrAssistiveProperties(String strAssistiveProperties) {
		this.strAssistiveProperties = strAssistiveProperties;
	}

	public String getStrOutputValue() {
		return strOutputValue;
	}

	public void setStrOutputValue(String strOutputValue) {
		this.strOutputValue = strOutputValue;
	}

	public Steps[] getSteps() {
		return steps;
	}

	public void setSteps(Steps[] steps) {
		this.steps = steps;
	}
}
