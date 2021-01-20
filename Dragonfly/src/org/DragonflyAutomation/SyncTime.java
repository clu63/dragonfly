package org.DragonflyAutomation;

class SyncTime {
	private long startTime;
	private long endTime;

	private long getDuration() {
		return endTime - startTime;
	}

	private void start() {
		startTime = System.currentTimeMillis();
	}

	private void stop() {
		endTime = System.currentTimeMillis();
	}
}
