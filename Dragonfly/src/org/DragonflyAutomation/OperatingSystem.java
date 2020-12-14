package org.DragonflyAutomation;

class OperatingSystem {
	static String get() {
		String nameOS;
		Logger.getInstance().add("  ==start==>OperatingSystem " + Util.getDateTimestamp());
		nameOS = System.getProperty("os.name").toLowerCase();
		if (nameOS.contains("win")) {
			nameOS = "Windows";
		} else if (nameOS.contains("nux") || nameOS.contains("nix")) {
			nameOS = "Linux";
		} else if (nameOS.contains("mac")) {
			nameOS = "Mac";
		} else if (nameOS.contains("sunos")) {
			nameOS = "Solaris";
		} else {
			nameOS = "Other";
		}
		return nameOS;
	}
}
