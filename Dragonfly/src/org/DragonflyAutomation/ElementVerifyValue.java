package org.DragonflyAutomation;

class ElementVerifyValue {
	String run() throws ExceptionValueNotMatched, ExceptionElementTagNameNotSupported {
		Logger.getInstance().add("  ==start==>ElementVerifyValue " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		String strActualValue = "";
		String strGetValue = "";
		String strValueExpected = JSONS.getInstance().step.getString("strInputValue");
		try {
			strGetValue = new ElementGet().run();
			strActualValue = Compare.verifyMatch(strGetValue, strValueExpected);
		} finally {
			Logger.getInstance().add("ElementVerifyValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
		}
		return strActualValue;
	}
}
