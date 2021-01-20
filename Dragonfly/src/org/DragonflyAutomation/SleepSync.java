package org.DragonflyAutomation;

class SleepSync {
	SleepSync() {
		Long lngTimeStart = System.currentTimeMillis();
		new Sleep();
		JSONS.getInstance().step.putValue("strStepActual", "sleep");
		new StepDuration("SleepSync", lngTimeStart, "sleep");
	}
}
