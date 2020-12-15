package org.DragonflyAutomation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Compare {
	static String runRegularExpressionMatch(String strPattern, String strActualValue) throws ExceptionValueNotMatched {
		Boolean blnMatched = false;
		Long lngStartTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>RegularExpressionMatch " + Util.getDateTimestamp());
		String strMatchedString = "";
		try {
			Matcher objMatcher = Pattern.compile(strPattern).matcher(strActualValue);
			objMatcher.matches();
			strMatchedString = objMatcher.group(0);
			blnMatched = true;
			return strMatchedString;
		} catch (Exception e) {
			Logger.getInstance().add("RegularExpressionMatch: Exception " + e.toString());
			throw new ExceptionValueNotMatched("RegularExpressionMatch: Exception " + e.toString());
		} finally {
			Logger.getInstance().add("RegularExpressionMatch: finally Matched = {" + blnMatched + "} strMatchedString = {" + strMatchedString + "} strPattern = {" + strPattern + "} strActualValue = {" + strActualValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	static String verifyMatch(String strActual, String strExpected) throws ExceptionValueNotMatched {
		Logger.getInstance().add("  ==start==>VerifyMatch " + Util.getDateTimestamp());
		Logger.getInstance().add("VerifyMatch strActual = " + strActual);
		Boolean blnMatched = false;
		long lngStartTime = System.currentTimeMillis();
		try {
			if (strExpected.toLowerCase().startsWith("<re>")) {
				String strPattern = strExpected.substring(4);
				blnMatched = true;
				return Compare.runRegularExpressionMatch(strPattern, strActual);
			} else {
				if (strExpected.equals(strActual)) {
					blnMatched = true;
					return strActual;
				} else {
					throw new ExceptionValueNotMatched("VerifyMatch did not match strActual = {" + strActual + "} strExpected = {" + strExpected + "}");
				}
			}
		} catch (Exception e) {
			Logger.getInstance().add("VerifyMatch: Exception " + e.toString());
			throw new ExceptionValueNotMatched("VerifyMatch: Exception " + e.toString());
		} finally {
			Logger.getInstance().add("VerifyMatch: finally Matched = {" + blnMatched + "} strActual = {" + strActual + "} strExpected = {" + strExpected + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	static String verifyNotMatch(String strActual, String strExpected) throws ExceptionValueMatched {
		Logger.getInstance().add("  ==start==>VerifyNotMatch " + Util.getDateTimestamp());
		Boolean blnMatched = false;
		long lngStartTime = System.currentTimeMillis();
		String strMatchedValue = "";
		try {
			if (strExpected.toLowerCase().startsWith("<re>")) {
				String strPattern = strExpected.substring(4);
				try {
					strMatchedValue = Compare.runRegularExpressionMatch(strPattern, strActual);
				} catch (Exception e) {
					Logger.getInstance().add("VerifyNotMatch: Exception " + e.toString());
					return strMatchedValue;
				}
				blnMatched = true;
				Logger.getInstance().add("VerifyNotMatch: before throw blnMatched = " + blnMatched);
				throw new ExceptionValueMatched("VerifyNotMatch: Exception strMatchedValue = {" + strMatchedValue + "}");
			} else {
				if (strExpected.equals(strActual)) {
					strMatchedValue = strActual;
					blnMatched = true;
					throw new ExceptionValueMatched("VerifyNotMatch did not match strExpected = {" + strExpected + "} strActual = {" + strActual + "}");
				} else {
					return strMatchedValue;
				}
			}
		} finally {
			Logger.getInstance().add("VerifyNotMatch: finally Matched = {" + blnMatched + "} strExpected = {" + strExpected + "} strActual = {" + strActual + "} strMatchedValue = {" + strMatchedValue + "} Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
