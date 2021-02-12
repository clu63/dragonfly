package org.DragonflyAutomation;

class TimeLogger {
	private long startTime;
	private String textToDisplay;

	TimeLogger(String textToDisplay) {
		this.textToDisplay = textToDisplay;
		startTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>" + textToDisplay + " " + Util.formatDateTime(startTime));
	}

	void end() {
		Logger.getInstance().add("==end==>" + this.textToDisplay + ": duration = " + this.getDuration() + " milliseconds");
	}

	void end(String textToDisplay) {
		Logger.getInstance().add("==end==>" + textToDisplay + ": duration = " + this.getDuration() + " milliseconds");
	}

	private long getDuration() {
		return System.currentTimeMillis() - startTime;
	}

	void stamp(String textToDisplay) {
		Logger.getInstance().add("==stamp==>" + textToDisplay + " " + Util.formatDateTime(startTime));
	}

	//	void stop(String textToDisplay) {
	//		Logger.getInstance().add("==stop==>" + textToDisplay + ": duration = " + this.getDuration() + " milliseconds");
	//	}
	void stopFinally(String textToDisplay) {
		Logger.getInstance().add("  ==finally==>" + textToDisplay + ": duration = " + this.getDuration() + " milliseconds");
	}
}