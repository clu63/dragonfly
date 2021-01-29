package org.DragonflyAutomation;

import java.io.BufferedWriter;
import java.io.FileWriter;

class UtilFile {
	static void write(String filePathFile, String textToWrite) {
		Logger.getInstance().add("  ==start==>FileUtil.write " + Util.getDateTimestamp());
		Logger.getInstance().add("UtilFile.write: filePathFile = " + filePathFile);
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathFile));
			bufferedWriter.write(textToWrite);
			bufferedWriter.close();
		} catch (Exception e) {
			Logger.getInstance().add("UtilFile.write: Exception" + e.toString());
		}
	}
}
