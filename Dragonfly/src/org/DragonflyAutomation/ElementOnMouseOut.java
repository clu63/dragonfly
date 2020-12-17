package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

class ElementOnMouseOut {
	ElementOnMouseOut() {
		Logger.getInstance().add("  ==start==>ElementOnMouseOut " + Util.getDateTimestamp());
		Actions objActions = new Actions(BrowserDriver.getInstance().browserDriver);
		// Dimension objWebDriverDimension = Element.getInstance().element.getSize();
		// int intElementWidth = objWebDriverDimension.width;
		// int intElementHeight = objWebDriverDimension.height;
		int intElementWidth = JSONS.getInstance().step.getInt("intElementWidth");
		int intElementHeight = JSONS.getInstance().step.getInt("intElementHeight");
		objActions.moveByOffset(-((intElementWidth / 2) + 1), -((intElementHeight / 2) + 1)).build().perform();
		JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
		objJavascriptExecutor.executeScript("arguments[0].onmouseout();", Element.getInstance().element);
	}
}
