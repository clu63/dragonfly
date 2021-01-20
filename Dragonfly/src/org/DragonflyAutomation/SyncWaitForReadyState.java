package org.DragonflyAutomation;

class SyncWaitForReadyState {
	SyncWaitForReadyState() {
		long lngStartTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>SyncWaitForReadyState " + Util.getDateTimestamp());
		try {
			new WaitForReadyState().run();
		} catch (Exception e) {
			Logger.getInstance().add("SyncWaitForReadyState: Exception = " + e.toString());
		} finally {
			Logger.getInstance().add("SyncWaitForReadyState: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
