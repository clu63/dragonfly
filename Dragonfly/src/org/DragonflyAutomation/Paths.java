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
		directoryOld.renameTo(directoryNew);
		pathResults = pathResultsNew;
	}

	String getDateTimestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
	}

	void setDirectory(String testArea) {
		pathData = "Data/" + testArea + "/";
		pathSystemUserDir = System.getProperty("user.dir");
		pathTestConfiguration = pathData + "test_configuration/";
		pathTestData = pathData + "test_data/";
		pathTestElements = pathData + "test_elements/";
		pathTestInstances = pathData + "test_instances/";
		pathTestModules = pathData + "test_modules/";
		pathTestSteps = pathData + "test_steps/";
	}

	void setPathResults(int testInstanceSize, String testConfigurationFileName) {
		Logger.getInstance().add("Paths:setPathResults testInstanceSize = " + testInstanceSize);
		Logger.getInstance().add("Paths:setPathResults testConfigurationFileName = " + testConfigurationFileName);
		String dateTimestamp = getDateTimestamp();
		Logger.getInstance().add("Paths:setPathResults dateTimestamp = " + dateTimestamp);
		Logger.getInstance().add("Paths:setPathResults pathImages==null = " + pathImages);
		if (pathImages == null) {
			pathResultsTop = pathSystemUserDir + "\\Results\\" + testConfigurationFileName.replace(".json", "") + "\\";
			Logger.getInstance().add("Paths:setPathResults pathResults = " + pathResults);
			if (testInstanceSize > 1) {
				pathResultsTop = pathResultsTop + dateTimestamp + "\\Iterations_" + testInstanceSize + "\\";
				Logger.getInstance().add("Paths:setPathResults pathResults = " + pathResults);
			}
		}
		pathResults = pathResultsTop + dateTimestamp + "\\";
		Logger.getInstance().add("Paths:setPathResults pathResults = " + pathResults);
		pathImages = pathResults + "images\\";
		Logger.getInstance().add("Paths:setPathResults pathImages = " + pathImages);
		new File(pathImages).mkdirs();
	}
}