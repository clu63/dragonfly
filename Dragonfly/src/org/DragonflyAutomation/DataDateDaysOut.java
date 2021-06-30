package org.DragonflyAutomation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataDateDaysOut {
	public String returnString(String daysOut) {
		//Logger.getInstance().add("  ==start==> " + Util.getDateTimestamp());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, Integer.parseInt(daysOut));
		return new SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime());
	}
}
