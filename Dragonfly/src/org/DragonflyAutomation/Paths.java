package org.DragonflyAutomation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class Paths {
	private static volatile Paths instance = null;
	String nameTest;
	String pathData;
	String pathImages;
	String pathResults;
	String pathResultsTop;
	String pathSystemUserDir;
	String pathTestConfiguration;
	String pathTestData;
	String pathTestElements;
	String pathTestInstances;
	String pathTestModules;
	String pathTestSteps;
	String testArea;

	private Paths() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static Paths getInstance() {
		if (instance == null) {
			instance = new Paths();
			synchronized (Paths.class) {
				if (instance == null) {
					instance = new Paths();
				}
			}
		}
		return instance;
	}

	void changeDirectoryNameStatus(String testStatus) {
		Logger.getInstance().add("Paths:changeDirectoryNameStatus pathResults = " + pathResults);
		File directoryOld = new File(pathResults);
		String pathResultsNew = pathResults.substring(0, pathResults.length() - 1) + "_" + testStatus + "\\";
		Logger.getInstance().add("Paths:changeDirectoryNameStatus pathResultsNew = " + pathResultsNew);
		File directoryNew = new File(pathResultsNew);
		if (directoryOld.renameTo(directoryNew)) {
			System.out.println("Paths:changeDirectoryNameStatus - Directory renamed successfully");
			this.pathResults = pathResultsNew;
		} else {
			System.out.println("Paths:changeDirectoryNameStatus - Failed to rename directory");
		}
	}

	void setDirectory(String testArea) {
		this.pathData = "Data/" + testArea + "/";
		this.pathSystemUserDir = System.getProperty("user.dir");
		this.pathTestConfiguration = this.pathData + "test_configuration/";
		this.pathTestData = this.pathData + "test_data/";
		this.pathTestElements = this.pathData + "test_elements/";
		this.pathTestInstances = this.pathData + "test_instances/";
		this.pathTestModules = this.pathData + "test_modules/";
		this.pathTestSteps = this.pathData + "test_steps/";
	}

	void setPathResults(int testInstanceSize, String testConfigurationFileName) {
		Logger.getInstance().add("Paths:setPathResults testInstanceSize = " + testInstanceSize);
		Logger.getInstance().add("Paths:setPathResults testConfigurationFileName = " + testConfigurationFileName);
		String dateTimestamp = new DateTimestamp().get();
		Logger.getInstance().add("Paths:setPathResults dateTimestamp = " + dateTimestamp);
		Logger.getInstance().add("Paths:setPathResults this.pathImages = " + this.pathImages);
		if (this.pathImages == null) {
			this.pathResultsTop = this.pathSystemUserDir + "\\Results\\" + testConfigurationFileName.replace(".json", "") + "\\";
			Logger.getInstance().add("Paths:setPathResults  this.pathResults = " + this.pathResults);
			if (testInstanceSize > 1) {
				this.pathResultsTop = this.pathResultsTop + dateTimestamp + "\\Iterations_" + testInstanceSize + "\\";
				Logger.getInstance().add("Paths:setPathResults  this.pathResults = " + this.pathResults);
			}
		}
		this.pathResults = this.pathResultsTop + dateTimestamp + "\\";
		Logger.getInstance().add("Paths:setPathResults  this.pathResults = " + this.pathResults);
		pathImages = pathResults + "images\\";
		Logger.getInstance().add("Paths:setPathResults  this.pathImages = " + this.pathImages);
		new File(pathImages).mkdirs();
	}
}