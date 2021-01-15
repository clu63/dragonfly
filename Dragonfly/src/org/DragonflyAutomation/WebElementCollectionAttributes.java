package org.DragonflyAutomation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class WebElementCollectionAttributes {
	WebElementCollectionAttributes(String strTagName) {
		Logger.getInstance().add("  ==start==>WebElementCollectionAttributes " + Util.getDateTimestamp());
		int intCount = 0;
		if (strTagName.toLowerCase().startsWith("input_")) {
			strTagName = "input";
		}
		List<WebElement> objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.tagName(strTagName));
		Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
		while (objWebElementEach.hasNext()) {
			WebElement row = objWebElementEach.next();
			intCount = intCount + 1;
			Logger.getInstance().add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WebElementCollectionAttributes " + intCount);
			Logger.getInstance().add("text:=  " + row.getTagName());
			Logger.getInstance().add("tag_type:=  " + row.getTagName() + "_" + row.getAttribute("type"));
			Logger.getInstance().add("TagName:=  " + row.getAttribute("TagName"));
			Logger.getInstance().add("type:=  " + row.getAttribute("type"));
			Logger.getInstance().add("id:=  " + row.getAttribute("id"));
			Logger.getInstance().add("name:=  " + row.getAttribute("name"));
			Logger.getInstance().add("text:=  " + row.getAttribute("text"));
			Logger.getInstance().add("innerText:=  " + row.getAttribute("innerText"));
			Logger.getInstance().add("outerText:=  " + row.getAttribute("outerText"));
			Logger.getInstance().add("innerHTML:=  " + row.getAttribute("innerHTML"));
			Logger.getInstance().add("outerHTML:=  " + row.getAttribute("outerHTML"));
			Logger.getInstance().add("uniqueID:=  " + row.getAttribute("uniqueID"));
			Logger.getInstance().add("class:=  " + row.getAttribute("class"));
			Logger.getInstance().add("type:=  " + row.getAttribute("type"));
			Logger.getInstance().add("TYPE:=  " + row.getAttribute("TYPE"));
			Logger.getInstance().add("href:=  " + row.getAttribute("href"));
			Logger.getInstance().add("NameProp:=  " + row.getAttribute("NameProp"));
			Logger.getInstance().add("isDisplayed:=  " + row.isDisplayed());
			Logger.getInstance().add("name:=  " + row.isEnabled());
			Logger.getInstance().add("getLocation().x:=  " + row.getLocation().x);
			Logger.getInstance().add("getLocation().y:=  " + row.getLocation().y);
			Logger.getInstance().add("getSize().height:=  " + row.getSize().height);
			Logger.getInstance().add("getLocation().y:=  " + row.getSize().width);
			Logger.getInstance().add("src:=  " + row.getAttribute("src"));
		}
	}
}
