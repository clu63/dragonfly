package org.DragonflyAutomation;

import java.util.concurrent.TimeUnit;

class SleepMilliseconds {
	SleepMilliseconds(int intMillisecondsToWait) {
		// Logger.getInstance().add("  ==start==>SleepMilliseconds " + Util.getDateTimestamp());
		try {
			TimeUnit.MILLISECONDS.sleep(intMillisecondsToWait);
			JSONS.getInstance().step.putValue("strStatus", "pass");
		} catch (Exception e) {
			JSONS.getInstance().step.putValue("strStatus", "fail");
			Logger.getInstance().add("SleepMilliseconds: Exception = " + e.toString());
		}
	}
}