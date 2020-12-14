package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementFindFramesSearch {
	boolean run(List<Integer> arrFramePath) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
		Logger.getInstance().add("  ==start==>ElementFindFramesSearch " + Util.getDateTimestamp());
		boolean blnReturn;
		int intMaximumDepth = 100;
		String strTagName = JSONS.getInstance().step.getLowerCase("strTagName");
		String strAttributeNames = JSONS.getInstance().step.getString("strAttributeNames");
		String strAttributeValues = JSONS.getInstance().step.getString("strAttributeValues");
		try {
			new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
			JSONS.getInstance().step.putValue("strCurrentWindowHandle", BrowserDriver.getInstance().browserDriver.getWindowHandle());
			if (JSONS.getInstance().step.verifyEquals("strTagName", "input")) {
				if (JSONS.getInstance().step.getString("strType").length() == 0) {
					JSONS.getInstance().step.putValue("strType", Element.getInstance().element.getAttribute("type"));
				}
				JSONS.getInstance().step.putValue("strTagType", "input_" + JSONS.getInstance().step.getString("strType"));
			} else {
				JSONS.getInstance().step.putValue("strTagType", JSONS.getInstance().step.getString("strTagName"));
			}
			Logger.getInstance().add("ElementFindFramesSearch: Element.getInstance().element outerHTML = " + Element.getInstance().element.getAttribute("outerHTML"));
			return true;
		} catch (ExceptionElementNotFound | ExceptionMultipleElementsFound | StaleElementReferenceException e) {
			blnReturn = false;
			Logger.getInstance().add("ElementFindFramesSearch: Exception = " + e.toString());
		}
		if (arrFramePath.size() < intMaximumDepth) {
			int intFramesCount = BrowserDriver.getInstance().browserDriver.findElements(By.tagName("frame")).size();
			for (int intFramesEach = 0; intFramesEach < intFramesCount; intFramesEach++) {
				try {
					BrowserDriver.getInstance().browserDriver.switchTo().frame(intFramesEach);
					List<Integer> arrFramePathNew = new ArrayList<Integer>(arrFramePath);
					arrFramePathNew.add(intFramesEach);
					blnReturn = new ElementFindFramesSearch().run(arrFramePathNew);
					if (blnReturn == true) {
						return true;
					}
					BrowserDriver.getInstance().browserDriver.switchTo().defaultContent();
					for (int intFramesPathEach : arrFramePath)
						BrowserDriver.getInstance().browserDriver.switchTo().frame(intFramesPathEach);
				} catch (NoSuchFrameException error) {
					blnReturn = false;
					Logger.getInstance().add("ElementFindFramesSearch: NoSuchFrameException = " + error.toString());
					break;
				} catch (Exception error) {
					Logger.getInstance().add("ElementFindFramesSearch: Exception = " + error.toString());
				}
			}
		}
		return blnReturn;
	}
}