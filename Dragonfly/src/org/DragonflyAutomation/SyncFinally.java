package org.DragonflyAutomation;

class Finally {
	static boolean sync(boolean exit, boolean status, boolean found, String methodeName, String action, long timeStart) {
		Logger.getInstance().add("SyncFinally:  blnExit = {" + exit + "} blnStatus = {" + status + "} blnFound = {" + found + "} strMethodeName = {" + methodeName + "} strAction = {" + action + "}");
		if (exit == true) {
			JSONS.getInstance().step.putValue("strStatus", "fail");
			JSONS.getInstance().step.putValue("blnExitOnFail", "true");
		} else {
			if (status == true) {
				JSONS.getInstance().step.putValue("strStatus", "pass");
				exit = true;
			} else if (status == false) {
				if ((int) (System.currentTimeMillis() - timeStart) <= JSONS.getInstance().step.getInt("intMillisecondsToWait")) {
					if (found == false) {
						exit = false;
					}
				} else {
					if (JSONS.getInstance().step.getBoolean("blnOptional") == true) {
						JSONS.getInstance().step.putValue("strStatus", "warning");
						exit = true;
					} else {
						JSONS.getInstance().step.putValue("strStatus", "fail");
						exit = true;
					}
				}
			}
		}
		if (exit == true) {
			new StepDuration(methodeName, timeStart, action);
		}
		return exit;
	}
}
