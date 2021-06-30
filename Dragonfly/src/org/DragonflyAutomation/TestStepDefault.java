package org.DragonflyAutomation;



class TestStepDefault {
	private TestStepDefaultFields testStepDefault;

	TestStepDefaultFields getTestStepDefaultFields() {
		return this.testStepDefault;
	}


	String getTestStepDefaultAssertSet() {
		return  this.testStepDefault.getAssertSet();
	}

	class TestStepDefaultFields {
		private String assertSet;
		private Boolean optional;
		private Boolean exitOnFail;
		private Integer millisecondsToWait;
		private Boolean pleaseWait;
		private Boolean highlight;
		private Boolean screenshot;
		private String screenshotArea;
		private String status;

		String getAssertSet() {
			return this.assertSet;
		}

		Boolean getExitOnFail() {
			return this.exitOnFail;
		}

		Boolean getHighlight() {
			return this.highlight;
		}

		Integer getMillisecondsToWait() {
			return this.millisecondsToWait;
		}

		Boolean getOptional() {
			return this.optional;
		}

		Boolean getPleaseWait() {
			return this.pleaseWait;
		}

		Boolean getScreenshot() {
			return this.screenshot;
		}

		String getScreenshotArea() {
			return this.screenshotArea;
		}

		String getStatus() {
			return this.status;
		}

		void setAssertSet(String assertSet) {
			this.assertSet = assertSet;
		}

		void setExitOnFail(Boolean exitOnFail) {
			this.exitOnFail = exitOnFail;
		}

		void setHighlight(Boolean highlight) {
			this.highlight = highlight;
		}

		void setMillisecondsToWait(Integer millisecondsToWait) {
			this.millisecondsToWait = millisecondsToWait;
		}

		void setOptional(Boolean optional) {
			this.optional = optional;
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

		void setStatus(String status) {
			this.status = status;
		}
	}
}
