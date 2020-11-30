package org.DragonflyAutomation;

class Config {
	private static volatile Config instance = null;
	String browserSelection;
	Double devicePixelRatio = (double) 1;
	String environment;
	Boolean syncAlert = false;
	Boolean syncAngularJs = false;
	Boolean syncDoPostBack = false;
	Boolean syncJQueryAjax = false;
	Boolean syncJQueryAnimation = false;
	Boolean syncPleaseWait = false;
	Boolean syncWaitForReadyState = false;
	//TODO fix this use of variable to store original values
	String originalAttributes;
	String originalInputValue;
	String testArea;
	String testName;
	
	private Config() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static Config getInstance() {
		if (instance == null) {
			instance = new Config();
			synchronized (Config.class) {
				if (instance == null) {
					instance = new Config();
				}
			}
		}
		return instance;
	}
}
