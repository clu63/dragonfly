package org.DragonflyAutomation;

import java.io.File;
import com.jacob.com.LibraryLoader;
import autoitx4java.AutoItX;

class AutoItSetObject {
	AutoItX objAutoIt;

	AutoItX createObject() {
		Logger.getInstance().add("  ==start==>AutoItSetObject " + Util.getDateTimestamp());
		String strJacobDllVersionToUse;
		if (System.getProperty("sun.arch.data.model").contains("32")) {
			strJacobDllVersionToUse = "jacob-1.18-x86.dll";
		} else {
			strJacobDllVersionToUse = "jacob-1.18-x64.dll";
		}
		Logger.getInstance().add("AutoItSetObject: System.getProperty(java.library.path) = " + System.getProperty("java.library.path") + " " + Util.getDateTimestamp());
		Logger.getInstance().add("AutoItSetObject: strJacobDllVersionToUse = " + strJacobDllVersionToUse + " " + Util.getDateTimestamp());
		File objFile = new File("Libraries", strJacobDllVersionToUse);
		Logger.getInstance().add("AutoItSetObject: LibraryLoader.JACOB_DLL_PATH = " + LibraryLoader.JACOB_DLL_PATH + " " + Util.getDateTimestamp());
		Logger.getInstance().add("AutoItSetObject: objFile.getAbsolutePath() = " + objFile.getAbsolutePath() + " " + Util.getDateTimestamp());
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, objFile.getAbsolutePath());
		return objAutoIt = new AutoItX();
	}

	AutoItX getObject() {
		return objAutoIt;
	}
}