package org.DragonflyAutomation;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateTimestamp {
	String get() {
		return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
	}
}
