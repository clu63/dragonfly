package org.DragonflyAutomation;

class TestStepDefault {
	private TestStepDefaultBuild testStepDefault;

	String getAssertSet() {
		return this.testStepDefault.assertSet;
	}

	Boolean getExitOnFail() {
		return this.testStepDefault.exitOnFail;
	}

	Boolean getHighlight() {
		return this.testStepDefault.highlight;
	}

	Integer getMillisecondsToWait() {
		return this.testStepDefault.millisecondsToWait;
	}

	Boolean getOptional() {
		return this.testStepDefault.optional;
	}

	Boolean getPleaseWait() {
		return this.testStepDefault.pleaseWait;
	}

	Boolean getScreenshot() {
		return this.testStepDefault.screenshot;
	}

	String getScreenshotArea() {
		return this.testStepDefault.screenshotArea;
	}

	String getStatus() {
		return this.testStepDefault.status;
	}

	void setAssertSet(String assertSet) {
		this.testStepDefault.assertSet = assertSet;
	}

	void setExitOnFail(Boolean exitOnFail) {
		this.testStepDefault.exitOnFail = exitOnFail;
	}

	void setHighlight(Boolean highlight) {
		this.testStepDefault.highlight = highlight;
	}

	void setMillisecondsToWait(Integer millisecondsToWait) {
		this.testStepDefault.millisecondsToWait = millisecondsToWait;
	}

	void setOptional(Boolean optional) {
		this.testStepDefault.optional = optional;
	}

	void setPleaseWait(Boolean pleaseWait) {
		this.testStepDefault.pleaseWait = pleaseWait;
	}

	void setScreenshot(Boolean screenshot) {
		this.testStepDefault.screenshot = screenshot;
	}

	void setScreenshotArea(String screenshotArea) {
		this.testStepDefault.screenshotArea = screenshotArea;
	}

	void setStatus(String status) {
		this.testStepDefault.status = status;
	}

	class TestStepDefaultBuild {
		private String assertSet;
		private Boolean optional;
		private Boolean exitOnFail;
		private Integer millisecondsToWait;
		private Boolean pleaseWait;
		private Boolean highlight;
		private Boolean screenshot;
		private String screenshotArea;
		private String status;
	}
}
