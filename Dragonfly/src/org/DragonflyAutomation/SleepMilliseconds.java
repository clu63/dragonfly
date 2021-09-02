package org.DragonflyAutomation;
//TODO change to static and push json reporting to Sleep call
class SleepMilliseconds {
	SleepMilliseconds(int intMillisecondsToWait) {
		try {
			Thread.sleep(intMillisecondsToWait);
			JSONS.getInstance().step.putValue("strStatus", "pass");
		} catch (Exception e) {
			JSONS.getInstance().step.putValue("strStatus", "fail");
			Logger.getInstance().add("SleepMilliseconds: Exception = " + e.toString());
		}
	}
}