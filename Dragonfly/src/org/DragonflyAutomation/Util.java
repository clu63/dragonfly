package org.DragonflyAutomation;

import java.util.Random;

class Util {
	static int randomNumberRange(int intNumberMinimum, int intNumberMaximum) {
		return new Random().nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
	}

	static boolean isNumeric(String value) {
		if (value == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			Logger.getInstance().add("isNumeric: not a number, value " + value);
			return false;
		}
		return true;
	}
}
