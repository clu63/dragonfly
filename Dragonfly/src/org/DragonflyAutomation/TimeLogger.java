package org.DragonflyAutomation;

class TimeLogger {
	private long startTime;

	TimeLogger() {
		startTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==> " + Util.formatDateTime(startTime));
	}

	TimeLogger(String textToDisplay) {
		startTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>" + textToDisplay + " " + Util.formatDateTime(startTime));
	}

	void end(String textToDisplay) {
		Logger.getInstance().add("==end==>" + textToDisplay + ": milliseconds duration = " + this.getDuration());
	}

	private long getDuration() {
		return System.currentTimeMillis() - startTime;
	}

	void stamp(String textToDisplay) {
		Logger.getInstance().add("==stamp==>" + textToDisplay + ": milliseconds duration = " + this.getDuration());
	}

	void stop(String textToDisplay) {
		Logger.getInstance().add("==stop==>" + textToDisplay + ": milliseconds duration = " + this.getDuration());
	}

	void stopFinally(String textToDisplay) {
		Logger.getInstance().add("  ==finally==>" + textToDisplay + ": milliseconds duration = " + this.getDuration());
	}
}