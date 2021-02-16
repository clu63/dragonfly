package org.DragonflyAutomation;

class TimeLogger {
	private String classMethodName = "";
	private long startTime;

	TimeLogger(String classMethodName) {
		startTime = System.currentTimeMillis();
		this.classMethodName = classMethodName;
		//Logger.getInstance().add("=start=======> " + this.classMethodName + " " + Util.formatDateTime(startTime) + " >");
		Logger.getInstance().add("=start=======> " + this.getNameTime());
	}

	private String getDuration() {
		//return System.currentTimeMillis() - startTime;
		//return " <duration = " + Long.toString(System.currentTimeMillis() - startTime) + " milliseconds> ";
		return " <duration = " + String.format("%,d", (System.currentTimeMillis() - startTime)) + " ms> ";
		//String.format("%,d", value)
	}

	private String getNameTime() {
		return this.classMethodName + " " + Util.formatDateTime(startTime);
	}

	void stamp(String textToDisplay) {
		//Logger.getInstance().add("=stamp=======>" + Util.getDateTimestamp() + " " + classMethodName + ": " + textToDisplay);
		Logger.getInstance().add("=stamp=======> " + this.getNameTime() + " <> " + textToDisplay);
	}

	void stop(String textToDisplay) {
		//Logger.getInstance().add("=stop========>" + classMethodName + ": " + textToDisplay + ": duration = " + this.getDuration() + " milliseconds");
		//Logger.getInstance().add("=stop========>" + this.getNameTime() + textToDisplay + " duration = " + this.getDuration() + " milliseconds");
		Logger.getInstance().add("=stop========> " + this.getNameTime() + this.getDuration() + textToDisplay);
	}

	void stopCatch(String textToDisplay) {
		//Logger.getInstance().add("==stopCatch==>" + classMethodName + ": " + textToDisplay + ": duration = " + this.getDuration() + " milliseconds");
		//Logger.getInstance().add("=stopCatch===>" + this.getNameTime() + textToDisplay + " duration = " + this.getDuration() + " milliseconds");
		Logger.getInstance().add("=stopCatch===> " + this.getNameTime() + this.getDuration() + textToDisplay);
	}

	void stopFinally(String textToDisplay) {
		//Logger.getInstance().add("==stopFinally==>" + classMethodName + ": " + textToDisplay + ": duration = " + this.getDuration() + " milliseconds");
		//Logger.getInstance().add("=stopFinally=>" + this.getNameTime() + textToDisplay + " " + ": duration = " + this.getDuration() + " milliseconds");
		Logger.getInstance().add("=stopFinally=> " + this.getNameTime() + this.getDuration() + textToDisplay);
	}
}