package org.DragonflyAutomation;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.io.StringReader;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

class Util {
	static String formatDateTime(Long lngStartTimeMillis) {
		return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SSS").format(new Date(lngStartTimeMillis));
	}

	static String formatXML(String input) {
		try {
			final InputSource src = new InputSource(new StringReader(input));
			final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
			final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			final LSSerializer writer = impl.createLSSerializer();
			writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
			writer.getDomConfig().setParameter("xml-declaration", true);
			return writer.writeToString(document);
		} catch (Exception e) {
			e.printStackTrace();
			return input;
		}
	}

	static String getClipboardGet() {
		String clipboardData = "";
		try {
			clipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			Logger.getInstance().add("getClipboardGet: strClipboardData = " + clipboardData);
		} catch (Exception e) {
			Logger.getInstance().add("getClipboardGet: Exception = " + e.toString());
		}
		return clipboardData;
	}

	static String getDateTimestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
	}

	static String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month];
	}

	static boolean isNumeric(String value) {
		if (value == null) {
			return false;
		}
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			Logger.getInstance().add("isNumeric: not a number, value " + value);
			return false;
		}
		return true;
	}

	static int randomNumberRange(int intNumberMinimum, int intNumberMaximum) {
		return new Random().nextInt((intNumberMaximum - intNumberMinimum) + 1) + intNumberMinimum;
	}

	static String removeTags(String strValue) {
		String strValueToFindKeyword = strValue;
		int intLeftArrowPosition = -1;
		int intRightArrowPosition = -1;
		String strTextToReplace = "";
		Boolean blnRemove = true;
		int intStart = 0;
		String[] arrKV_strInputValue = { "<re>", "<td>", "<ti>", "<tl>", "<click>", "<doubleclick>", "<rightclick>", "<on>", "<off>", "<blank>", "<first>", "<second>", "<third>", "<last>", "<random>", "<contains>", "<ends>", "<starts>", "<skip>" };
		int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace("<", "").length();
		// Logger.getInstance().add("removeTags: intKeywordCount = " + intKeywordCount);
		for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
			blnRemove = true;
			//Logger.getInstance().add("removeTags: intStart = " + intStart);
			intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intStart);
			if (intLeftArrowPosition > -1) {
				intRightArrowPosition = strValueToFindKeyword.indexOf(">");
				strTextToReplace = strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1);
				// Logger.getInstance().add("removeTags: strTextToReplace = " + strTextToReplace);
				for (String strKeywordsValidEach : arrKV_strInputValue) {
					if (strTextToReplace.equals(strKeywordsValidEach)) {
						blnRemove = false;
						intStart = intRightArrowPosition + 1;
						//Logger.getInstance().add("removeTags: inside if intStart = " + intStart);
						break;
					}
				}
				if (blnRemove.equals(true)) {
					strValueToFindKeyword = strValueToFindKeyword.replaceAll(strTextToReplace, "");
				}
				// Logger.getInstance().add("removeTags: strValueToFindKeyword = " + intKeywordEach + "  " + strValueToFindKeyword);
			}
		}
		// Logger.getInstance().add("removeTags: strValueToFindKeyword = " + strValueToFindKeyword);
		return strValueToFindKeyword;
	}

	static String replaceHtmlArrows(String strText) {
		Logger.getInstance().add("ReplaceHtmlArrows: strText.replaceAll = " + strText.replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
		return strText.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

	static void windowsMinimizeAll() {
		Logger.getInstance().add("  ==start==>WindowsMinimizeAll " + Util.getDateTimestamp());
		Robot objRobot = null;
		switch (OperatingSystem.get()) {
		case "Windows":
			try {
				objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_WINDOWS);
				objRobot.keyPress(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_D);
				objRobot.keyRelease(KeyEvent.VK_WINDOWS);
				Logger.getInstance().add("windowsMinimizeAll: Windows operating system minimize all windows.");
			} catch (Exception e) {
				Logger.getInstance().add("windowsMinimizeAll: Exception = " + e.toString());
			}
			break;
		default:
			Logger.getInstance().add("WindowsMinimizeAll: the operating system not supported at this time " + OperatingSystem.get());
		}
	}
}
