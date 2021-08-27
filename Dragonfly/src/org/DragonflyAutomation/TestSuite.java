package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestSuite {
	private TestSuiteBuild testSuite;

	String getBrowser() {
		return this.testSuite.testSuiteDetails.browser;
	}

	String getEnvironment() {
		return this.testSuite.testSuiteDetails.environment;
	}

	String getHighlight() {
		return this.testSuite.testSuiteDetails.highlight;
	}

	String getHost() {
		return this.testSuite.testSuiteDetails.host;
	}

	Integer getMillisecondsToWait() {
		return this.testSuite.testSuiteDetails.millisecondsToWait;
	}

	Integer getPort() {
		return this.testSuite.testSuiteDetails.port;
	}

	String getScreenshots() {
		return this.testSuite.testSuiteDetails.screenshots;
	}

	Integer getThreads() {
		return this.testSuite.testSuiteDetails.threads;
	}

	void setBrowser(String browser) {
		this.testSuite.testSuiteDetails.browser = browser;
	}

	void setEnvironment(String environment) {
		this.testSuite.testSuiteDetails.environment = environment;
	}

	void setHighlight(String highlight) {
		this.testSuite.testSuiteDetails.highlight = highlight;
	}

	void setHost(String host) {
		this.testSuite.testSuiteDetails.host = host;
	}

	void setMillisecondsToWait(Integer millisecondsToWait) {
		this.testSuite.testSuiteDetails.millisecondsToWait = millisecondsToWait;
	}

	void setPort(Integer port) {
		this.testSuite.testSuiteDetails.port = port;
	}

	void setScreenshots(String screenshots) {
		this.testSuite.testSuiteDetails.screenshots = screenshots;
	}

	void setThreads(Integer threads) {
		this.testSuite.testSuiteDetails.threads = threads;
	}

	class TestIteration {
		private String testconfiguration;
		private String testInstance;
		private String browser;
	}

	class TestSuiteBuild {
		private TestSuiteDetails testSuiteDetails;
		private List<List<TestIteration>> testIterations = new ArrayList<List<TestIteration>>();
	}

	class TestSuiteDetails {
		private Integer millisecondsToWait;
		private String browser;
		private String screenshots;
		private String highlight;
		private String environment;
		private Integer threads;
		private String host;
		private Integer port;
	}
}