package org.DragonflyAutomation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class Path {
	private static volatile Path instance = null;
	String data;
	String images;
	String results;
	String resultsTop;
	String systemUserDir;
	String testConfiguration;
	String testData;
	String testElements;
	String testInstances;
	String testModules;
	String testSteps;

	private Path() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static Path getInstance() {
		if (instance == null) {
			instance = new Path();
			synchronized (Path.class) {
				if (instance == null) {
					instance = new Path();
				}
			}
		}
		return instance;
	}

	void changeDirectoryNameStatus(String testStatus) {
		Logger.getInstance().add("Path:changeDirectoryNameStatus results = " + this.results);
		File directoryOld = new File(this.results);
		String resultsNew = results.substring(0, this.results.length() - 1) + "_" + testStatus + "\\";
		Logger.getInstance().add("Path:changeDirectoryNameStatus resultsNew = " + resultsNew);
		File directoryNew = new File(resultsNew);
		if (directoryOld.renameTo(directoryNew)) {
			System.out.println("Path:changeDirectoryNameStatus - Directory renamed successfully");
			this.results = resultsNew;
		} else {
			System.out.println("Path:changeDirectoryNameStatus - Failed to rename directory");
		}
	}

	void setDirectory(String testArea) {
		this.data = "Data/" + testArea + "/";
		this.systemUserDir = System.getProperty("user.dir");
		this.testConfiguration = this.data + "test_configuration/";
		this.testData = this.data + "test_data/";
		this.testElements = this.data + "test_elements/";
		this.testInstances = this.data + "test_instances/";
		this.testModules = this.data + "test_modules/";
		this.testSteps = this.data + "test_steps/";
	}

	void setPathResults(int testInstanceSize, String testConfigurationFileName) {
		Logger.getInstance().add("Path:setPathResults testInstanceSize = " + testInstanceSize);
		Logger.getInstance().add("Path:setPathResults testConfigurationFileName = " + testConfigurationFileName);
		String dateTimestamp = Util.getDateTimestamp();
		Logger.getInstance().add("Path:setPathResults dateTimestamp = " + dateTimestamp);
		Logger.getInstance().add("Path:setPathResults this.images = " + this.images);
		if (this.images == null) {
			this.resultsTop = this.systemUserDir + "\\Results\\" + testConfigurationFileName.replace(".json", "") + "\\";
			Logger.getInstance().add("Path:setPathResults  this.results = " + this.results);
			if (testInstanceSize > 1) {
				this.resultsTop = this.resultsTop + dateTimestamp + "\\Iterations_" + testInstanceSize + "\\";
				Logger.getInstance().add("Path:setPathResults  this.results = " + this.results);
			}
		}
		this.results = this.resultsTop + dateTimestamp + "\\";
		Logger.getInstance().add("Path:setPathResults  this.results = " + this.results);
		images = results + "images\\";
		Logger.getInstance().add("Path:setPathResults  this.images = " + this.images);
		new File(images).mkdirs();
	}
}