package org.DragonflyAutomation;

class Keyword {
	static String getKeyword(String value) {
		String strValueToFindKeyword = value.toLowerCase();
		int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
		String strKeyword = "";
		if (intRightArrowPosition > -1) {
			strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
		}
		Logger.getInstance().add("getKeyword: strKeyword = " + strKeyword);
		return strKeyword;
	}

	static int getKeywordIntValue(String value) {
		String strValueToFindInt = "";
		int intRightArrowPosition = value.indexOf(">");
		int intKeywordValue = 0;
		if (intRightArrowPosition > -1) {
			strValueToFindInt = value.substring(intRightArrowPosition + 1);
			if (Util.isNumeric(strValueToFindInt) == true) {
				intKeywordValue = Integer.parseInt(strValueToFindInt);
			}
		}
		Logger.getInstance().add("getKeywordIntValue: intKeywordValue " + intKeywordValue);
		return intKeywordValue;
	}

	static String getKeywordValue(String value) {
		int intRightArrowPosition = value.indexOf(">");
		String strKeywordValue = "";
		if (intRightArrowPosition > -1) {
			strKeywordValue = value.substring(intRightArrowPosition + 1);
		} else {
			strKeywordValue = value;
		}
		Logger.getInstance().add("getKeywordValue: value " + value);
		return strKeywordValue;
	}
}
