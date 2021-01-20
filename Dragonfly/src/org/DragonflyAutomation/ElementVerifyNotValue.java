package org.DragonflyAutomation;

class ElementVerifyNotValue {
	String run() throws ExceptionValueMatched, ExceptionElementTagNameNotSupported {
		Logger.getInstance().add("  ==start==>ElementVerifyNotValue " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		String strActualValue = "";
		String strGetValue = "";
		String strValueExpected = JSONS.getInstance().step.getString("strInputValue");
		try {
			strGetValue = new ElementGet().run();
			strActualValue = Compare.verifyNotMatch(strGetValue, strValueExpected);
			Logger.getInstance().add("ElementVerifyNotValue: after VerifyNotMatch");
		} catch (ExceptionValueMatched e) {
			Logger.getInstance().add("ElementVerifyNotValue: " + e.toString());
			throw new ExceptionValueMatched("ElementVerifyNotValue: Exception strActualValue = {" + strActualValue + "}");
		} finally {
			Logger.getInstance().add("ElementVerifyNotValue: finally strGetValue = {" + strGetValue + "} strValueExpected = {" + strValueExpected + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngStartTime));
		}
		return strActualValue;
	}
}
