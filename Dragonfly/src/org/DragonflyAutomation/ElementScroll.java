package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

//TODO start here alpabetically to check new step Actual
class ElementScroll {
	ElementScroll() {
		JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
		objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", Element.getInstance().element);
	}
}
