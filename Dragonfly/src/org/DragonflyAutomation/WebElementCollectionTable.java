package org.DragonflyAutomation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class WebElementCollectionTable {
	WebElementCollectionTable(String strTagName) {
		boolean blnSkip = false;
		Logger.getInstance().add("  ==start==>WebElementCollectionTable " + Util.getDateTimestamp());
		// TODO webElementCollectionTable send output to html file
		int intCount = 0;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		Logger.getInstance().add("WebElementCollectionTable: strTagName = " + strTagName);
		Logger.getInstance().add("WebElementCollectionTable: lngStartTimeSwitchTo = " + BrowserDriver.getInstance().browserDriver.getTitle());
		BrowserDriver.getInstance().browserDriver.switchTo().defaultContent();
		for (String winHandle : BrowserDriver.getInstance().browserDriver.getWindowHandles()) {
			intCount = 0;
			//  Logger.getInstance().add("elementFind strCurrentWindowHandle = " + strCurrentWindowHandle);
			Logger.getInstance().add("WebElementCollectionTable: winHandle = " + winHandle);
			long lngStartTimeSwitchTo = System.currentTimeMillis();
			// if (strCurrentWindowHandle.equals(winHandle)) {
			// } else {
			BrowserDriver.getInstance().browserDriver.switchTo().window(winHandle);
			Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Logger.getInstance().add("WebElementCollectionTable: lngStartTimeSwitchTo = " + (System.currentTimeMillis() - lngStartTimeSwitchTo));
			// }
			Logger.getInstance().add("WebElementCollectionTable: BrowserDriver.getInstance().browserDriver.getTitle = " + BrowserDriver.getInstance().browserDriver.getTitle());
			// Logger.getInstance().add("webElementCollectionTable BrowserDriver.getInstance().browserDriver.getPageSource = " + BrowserDriver.getInstance().browserDriver.getPageSource());
			Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			List<WebElement> objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.tagName(strTagName));
			Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
			while (objWebElementEach.hasNext()) {
				WebElement row = objWebElementEach.next();
				// try {
				// elementVisible(objStepNew, row);
				intCount = intCount + 1;
				if (row.isDisplayed() == true) {
					if (strTagName.equals("input") == true) {
						if (row.getAttribute("type").toLowerCase().equals("hidden") == true) {
							blnSkip = true;
						}
					}
					if (blnSkip == false) {
						Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~webElementCollectionTable " + intCount);
						Logger.getInstance().add("WebElementCollectionTable: getTagName:= '" + row.getTagName() + "'");
						Logger.getInstance().add("WebElementCollectionTable: type:= '" + row.getAttribute("type") + "'");
						Logger.getInstance().add("WebElementCollectionTable: getText:= '" + row.getText() + "'");
						Logger.getInstance().add("WebElementCollectionTable: outerHTML = '" + row.getAttribute("outerHTML") + "'");
					}
				}
				//  Logger.getInstance().add("text:=  " + objWebElementEach.);
				//  Logger.getInstance().add("tag_type:= '" + row.getTagName() + "_" + row.getAttribute("type") + "'");
				//  Logger.getInstance().add("TagName:= '" + row.getAttribute("TagName") + "'");
				//  Logger.getInstance().add("Type:= '" + row.getAttribute("Type") + "'");
				//  Logger.getInstance().add("TYPE:= '" + row.getAttribute("TYPE") + "'");
				//  Logger.getInstance().add("id:= '" + row.getAttribute("id") + "'");
				//  Logger.getInstance().add("name:= '" + row.getAttribute("name") + "'");
				//  Logger.getInstance().add("text:= '" + row.getAttribute("text") + "'");
				//  Logger.getInstance().add("innerText:= '" + row.getAttribute("innerText") + "'");
				//  Logger.getInstance().add("outerText:= '" + row.getAttribute("outerText") + "'");
				//  Logger.getInstance().add("innerHTML:= '" + row.getAttribute("innerHTML") + "'");
				//  Logger.getInstance().add("uniqueID:= '" + row.getAttribute("uniqueID") + "'");
				//  Logger.getInstance().add("class:= '" + row.getAttribute("class") + "'");
				//  Logger.getInstance().add("href:= '" + row.getAttribute("href") + "'");
				//  Logger.getInstance().add("NameProp:= '" + row.getAttribute("NameProp") + "'");
				//  Logger.getInstance().add("isDisplayed:= '" + row.isDisplayed() + "'");
				//  Logger.getInstance().add("isEnabled:= '" + row.isEnabled() + "'");
				//  Logger.getInstance().add("getLocation().x:= '" + row.getLocation().x + "'");
				//  Logger.getInstance().add("getLocation().y:= '" + row.getLocation().y + "'");
				//  Logger.getInstance().add("getSize().height:= '" + row.getSize().height + "'");
				//  Logger.getInstance().add("getSize().width:= '" + row.getSize().width + "'");
				//  Logger.getInstance().add("src:= '" + row.getAttribute("src") + "'");
				// if (objCollectionJS.size() > 0) {
				//
				// JavascriptExecutor objJavascriptExecutor = null;
				// objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
				// long lngStartTimeJS = System.currentTimeMillis();
				//  Logger.getInstance().add("JS value = " +
				// objJavascriptExecutor.executeScript("return arguments[0].value;",
				// objCollectionJS.get(0)) + " Milliseconds Waited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				//  Logger.getInstance().add("JS innerText = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerText;",
				// objCollectionJS.get(0)) + " Milliseconds Waited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				//  Logger.getInstance().add("JS innerHTML = " +
				// objJavascriptExecutor.executeScript("return arguments[0].innerHTML;",
				// objCollectionJS.get(0)) + " Milliseconds Waited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				// lngStartTimeJS = System.currentTimeMillis();
				//  Logger.getInstance().add("JS outerHTML = " +
				// objJavascriptExecutor.executeScript("return arguments[0].outerHTML;",
				// objCollectionJS.get(0)) + " Milliseconds Waited = " +
				// (System.currentTimeMillis() - lngStartTimeJS));
				//
				// }
				// } catch (ExceptionElementNotVisible e) {
				// // e.printStackTrace();
				// }
			}
		}
	}
}
