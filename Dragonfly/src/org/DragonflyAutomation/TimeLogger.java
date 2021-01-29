package org.DragonflyAutomation;

class TimeLogger {
	private long endTime;
	private long startTime;

	TimeLogger() {
		start();
	}

	TimeLogger(String classMethodName) {
		startTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>" + classMethodName + " " + Util.formatDateTime(startTime));
	}

	long getDuration() {
		stop();
		return endTime - startTime;
	}

	void start() {
		startTime = System.currentTimeMillis();
	}

	void stop() {
		endTime = System.currentTimeMillis();
	}

	void stopFinallyLogger(String classMethodName) {
		Logger.getInstance().add(classMethodName + ": finally milliseconds duration = " + this.getDuration());
	}

	void stopLogger(String classMethodName) {
		Logger.getInstance().add(classMethodName + ": milliseconds duration = " + (System.currentTimeMillis() - startTime));
	}
	void end(String classMethodName) {
		Logger.getInstance().add("==end==>"+classMethodName + ": milliseconds duration = " + (System.currentTimeMillis() - startTime));
	}
}
