package org.DragonflyAutomation;

import java.awt.Rectangle;
import java.awt.Toolkit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class RectangleAreaByName {
	RectangleAreaByName(Integer intThickness, String strAreaObjectName, Rectangle objRectangleArea) {
		Logger.getInstance().add("  ==start==>RectangleAreaByName " + new DateTimestamp().get());
		Logger.getInstance().add("RectangleAreaByName: strAreaObjectName = " + strAreaObjectName);
		long lngStartTime = System.currentTimeMillis();
		int intX = 0;
		int intY = 0;
		int intWidth = 0;
		int intHeight = 0;
		if (strAreaObjectName.equals("")) {
			if (BrowserDriver.getInstance().browserDriver == null) {
				strAreaObjectName = "screen";
			}
			if (Element.getInstance().element == null) {
				if (JSONS.getInstance().step.verifyEquals("strTagName", "alert")) {
					strAreaObjectName = "element";
				} else {
					strAreaObjectName = "screen";
				}
			} else {
				if (JSONS.getInstance().step.containsKey("intElementScreenX") == false) {
					strAreaObjectName = "screen";
				} else {
					strAreaObjectName = "element";
				}
			}
		}
		try {
			switch (strAreaObjectName.toLowerCase()) {
			case "screen":
				intX = 0;
				intY = 0;
				intWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
				intHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
				break;
			case "window":
				intX = JSONS.getInstance().step.getInt("intBrowserOuterX");
				intY = JSONS.getInstance().step.getInt("intBrowserOuterY");
				intWidth = JSONS.getInstance().step.getInt("intBrowserOuterWidth");
				intHeight = JSONS.getInstance().step.getInt("intBrowserOuterHeight");
				break;
			case "page":
				// TODO change this to get absolute screen coordinates
				WebElement objWebElementPage = BrowserDriver.getInstance().browserDriver.findElement(By.xpath("//body"));
				intX = objWebElementPage.getLocation().getX() - intThickness;
				intY = objWebElementPage.getLocation().getY() - intThickness;
				intWidth = objWebElementPage.getSize().width + (2 * intThickness);
				intHeight = objWebElementPage.getSize().height + (2 * intThickness);
				break;
			case "element":
			case "alert":
				intX = JSONS.getInstance().step.getInt("intElementScreenX") - intThickness;
				intY = JSONS.getInstance().step.getInt("intElementScreenY") - intThickness;
				intWidth = JSONS.getInstance().step.getInt("intElementWidth") + (2 * intThickness);
				intHeight = JSONS.getInstance().step.getInt("intElementHeight") + (2 * intThickness);
				break;
			default:
				Logger.getInstance().add("RectangleAreaByName: epected values = screen, window, page and element not " + strAreaObjectName);
				break;
			}
		} finally {
			if (intX < 0) {
				intWidth = intWidth + 2 * intX;
				intX = 0;
			}
			if (intY < 0) {
				intHeight = intHeight + 2 * intY;
				intY = 0;
			}
			objRectangleArea.setBounds(intX, intY, intWidth, intHeight);
			Logger.getInstance().add("RectangleAreaByName: finally strAreaObjectName = " + strAreaObjectName.toLowerCase() + " objRectangleArea = " + objRectangleArea + " Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}