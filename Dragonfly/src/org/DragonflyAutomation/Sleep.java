package org.DragonflyAutomation;

class Sleep {
	Sleep() {
		new SleepMilliseconds(JSONS.getInstance().step.getInt("strInputValue"));
	}
}
