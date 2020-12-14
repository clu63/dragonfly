package org.DragonflyAutomation;

class StepDuration {
	StepDuration(String strMethodName, Long lngTimeStart, String strStepType) {
		Logger.getInstance().add("  ==start==>StepDuration " + Util.getDateTimestamp());
		new StepCreateExpected();
		Long lngTimeEnd = System.currentTimeMillis();
		JSONS.getInstance().step.putValue("strStartTimestamp", Util.formatDateTime(lngTimeStart));
		JSONS.getInstance().step.putValue("strStepDuration", Long.toString(lngTimeEnd - lngTimeStart));
		JSONS.getInstance().step.putValue("strEndTimestamp", Util.formatDateTime(lngTimeEnd));
		new StepCreateActual(strStepType);
		Logger.getInstance().add("StepDuration: " + strMethodName + " strStatus = " + JSONS.getInstance().step.getString("strStatus") + " Milliseconds Waited = " + JSONS.getInstance().step.getString("strStepDuration"));
	}
}
