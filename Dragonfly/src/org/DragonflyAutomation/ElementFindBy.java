package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class ElementFindBy {
	ElementFindBy(String strAttributeNames, String strAttributeValues, String strTagName) throws ExceptionElementNotFound, ExceptionMultipleElementsFound {
		Logger.getInstance().add("  ==start==>ElementFindBy " + new DateTimestamp().get());
		int intAttributeEach = 0;
		List<WebElement> objWebElementCollection = new ArrayList<WebElement>();
		String arrAttributeNames[] = strAttributeNames.toString().split("\\|", -1);
		String arrAttributeValues[] = strAttributeValues.toString().split("\\|", -1);
		String strIndex = "";
		String strIndexKeyword = "";
		String strXpath = "";
		String strXpathAttributes = "";
		String strXpathAttributesTemp = "";
		Boolean blnRegularExpression = false;
		//TODO fix the <re>Input error. check attribute value for keyword and handle by creating xpath
		if (strAttributeValues.toLowerCase().contains("<contains>") || strAttributeValues.toLowerCase().contains("<starts>")) {
			blnRegularExpression = true;
		}
		if (strAttributeNames.toLowerCase().equals("xpath") && blnRegularExpression.equals(false)) {
			Logger.getInstance().add("ElementFindBy: xpath  " + strAttributeNames + " = " + strAttributeValues);
			objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.xpath(strAttributeValues));
		} else if (strAttributeNames.toLowerCase().equals("id") && blnRegularExpression.equals(false)) {
			Logger.getInstance().add("ElementFindBy: id  " + strAttributeNames + " = " + strAttributeValues);
			objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.id(strAttributeValues));
		} else if (strAttributeNames.toLowerCase().equals("name") && blnRegularExpression.equals(false)) {
			Logger.getInstance().add("ElementFindBy: name  " + strAttributeNames + " = " + strAttributeValues);
			objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.name(strAttributeValues));
		} else if (strAttributeNames.toLowerCase().equals("class") && blnRegularExpression.equals(false)) {
			Logger.getInstance().add("ElementFindBy: class  " + strAttributeNames + " = " + strAttributeValues);
			objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.className(strAttributeValues));
		} else {
			for (intAttributeEach = 0; intAttributeEach < arrAttributeNames.length; intAttributeEach++) {
				strXpathAttributesTemp = "";
				switch (arrAttributeNames[intAttributeEach].toLowerCase()) {
				case "index":
					if (arrAttributeValues[intAttributeEach].equals("<last>")) {
						strIndex = "";
						strIndexKeyword = "<last>";
					} else if (arrAttributeValues[intAttributeEach].equals("<random>")) {
						strIndex = "";
						strIndexKeyword = "<random>";
					} else {
						strIndex = "[" + arrAttributeValues[intAttributeEach] + "]";
					}
					break;
				case "text":
					switch (Keyword.getKeyword(arrAttributeValues[intAttributeEach].toLowerCase())) {
					case "<contains>":
						strXpathAttributesTemp = "contains(text()" + ", '" + Keyword.getKeywordValue(arrAttributeValues[intAttributeEach]) + "')";
						break;
					case "<starts>":
						strXpathAttributesTemp = "starts-with(text()" + ", '" + Keyword.getKeywordValue(arrAttributeValues[intAttributeEach]) + "')";
						break;
					default:
						strXpathAttributesTemp = "text()='" + arrAttributeValues[intAttributeEach] + "' ";
						break;
					}
					break;
				default:
					if (arrAttributeNames[intAttributeEach].toLowerCase().equals("type")) {
						JSONS.getInstance().step.putValue("strType", arrAttributeValues[intAttributeEach]);
					}
					switch (Keyword.getKeyword(arrAttributeValues[intAttributeEach].toLowerCase())) {
					case "<contains>":
						strXpathAttributesTemp = "contains(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + Keyword.getKeywordValue(arrAttributeValues[intAttributeEach]).toLowerCase() + "')";
						break;
					case "<starts>":
						strXpathAttributesTemp = "starts-with(translate(@" + arrAttributeNames[intAttributeEach] + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + Keyword.getKeywordValue(arrAttributeValues[intAttributeEach]).toLowerCase() + "')";
						break;
					default:
						strXpathAttributesTemp = "@" + arrAttributeNames[intAttributeEach] + "='" + arrAttributeValues[intAttributeEach] + "'";
						break;
					}
					break;
				}
				if (strXpathAttributesTemp.trim().length() != 0) {
					if (strXpathAttributes.trim().length() == 0) {
						strXpathAttributes = strXpathAttributesTemp;
					} else {
						strXpathAttributes = strXpathAttributes + " and " + strXpathAttributesTemp;
					}
				}
			}
			if (strXpathAttributes.trim().length() == 0) {
				strXpathAttributes = "";
			} else {
				strXpathAttributes = "[" + strXpathAttributes + "]";
			}
			strXpath = "(//" + strTagName + strXpathAttributes + ")" + strIndex;
			Logger.getInstance().add("ElementFindBy: strXpath = " + strXpath);
			objWebElementCollection = BrowserDriver.getInstance().browserDriver.findElements(By.xpath(strXpath));
		}
		switch (objWebElementCollection.size()) {
		case 0:
			throw new ExceptionElementNotFound("Element properties did not return an element, try refining attributes");
		case 1:
			Element.getInstance().element = objWebElementCollection.get(0);
			break;
		default:
			if (strIndexKeyword.equals("<last>")) {
				Element.getInstance().element = objWebElementCollection.get(objWebElementCollection.size() - 1);
				break;
			} else if (strIndexKeyword.equals("<random>")) {
				int intRandomElement = Util.randomNumberRange(0, objWebElementCollection.size() - 1);
				Element.getInstance().element = objWebElementCollection.get(intRandomElement);
				break;
			} else {
				Logger.getInstance().add("ElementFindBy: Element properties did not return a unique element, try again with more attributes.  " + objWebElementCollection.size());
				Iterator<WebElement> objWebElementEach = ((Collection<WebElement>) objWebElementCollection).iterator();
				while (objWebElementEach.hasNext()) {
					WebElement row = objWebElementEach.next();
					Logger.getInstance().add("ElementFindBy: outerHTML:=  " + row.getAttribute("outerHTML"));
				}
				throw new ExceptionMultipleElementsFound(objWebElementCollection.size() + " elements found. Element properties did not return an element, try refining attributes");
			}
		}
	}
}
