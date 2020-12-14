package org.DragonflyAutomation;

import java.io.BufferedWriter;
import java.io.FileWriter;

class FileUtil {
	static void write(String filePathFile, String textToWrite) {
		Logger.getInstance().add("  ==start==>FileUtil.write " + Util.getDateTimestamp());
		Logger.getInstance().add("FileUtil.write: filePathFile = " + filePathFile);
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathFile));
			bufferedWriter.write(textToWrite);
			bufferedWriter.close();
		} catch (Exception e) {
			Logger.getInstance().add("FileUtil.write: Exception" + e.toString());
		}
	}
}
