package org.DragonflyAutomation;

class SyncAlert {
	SyncAlert() throws ExceptionAlertNotComplete {
		Logger.getInstance().add("  ==start==>SyncAlert " + Util.getDateTimestamp());
		if (new AlertFind().run() == true) {
			throw new ExceptionAlertNotComplete("");
		}
	}
}
