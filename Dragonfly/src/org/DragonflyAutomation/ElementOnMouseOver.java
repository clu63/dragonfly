package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

class ElementOnMouseOver {
	ElementOnMouseOver() {
		Logger.getInstance().add("  ==start==>ElementOnMouseOver " + Util.getDateTimestamp());
		Actions objActions = new Actions(BrowserDriver.getInstance().browserDriver);
		objActions.moveToElement(Element.getInstance().element).build().perform();
		JavascriptExecutor objJavascriptExecutor = null;
		objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
		objJavascriptExecutor.executeScript("arguments[0].onmouseover();", Element.getInstance().element);
	}
}
