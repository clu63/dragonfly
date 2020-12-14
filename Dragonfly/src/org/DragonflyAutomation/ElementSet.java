package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class ElementSet {
	ElementSet(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionVisibleTextNotInSelectList, ExceptionKeywordNotValid {
		Logger.getInstance().add("  ==start==>ElementSet " + Util.getDateTimestamp());
		Logger.getInstance().add("ElementSet: " + JSONS.getInstance().step.getLowerCase("strAttributeValues"));
		long lngStartTime = System.currentTimeMillis();
		String strInputValue = JSONS.getInstance().step.getString("strInputValue");
		String strValueToSelect = strInputValue;
		String strAttributeValues = JSONS.getInstance().step.getLowerCase("strAttributeValues");
		String strTagType = JSONS.getInstance().step.getLowerCase("strTagType");
		String strStepExpected = "";
		Actions objActions = null;
		String strOptions = "";
		String strOptionsList = "";
		try {
			switch (strTagType) {
			case "a":
			case "button":
			case "div":
			case "h1":
			case "h2":
			case "h3":
			case "h4":
			case "h5":
			case "h6":
			case "img":
			case "input_button":
			case "input_image":
			case "input_reset":
			case "input_submit":
			case "li":
			case "p":
			case "span":
			case "td":
			case "th":
			case "tr":
				//ToDo all click options
				switch (strInputValue.toLowerCase()) {
				case "":
				case "<click>":
					JSONS.getInstance().step.putValue("strInputValue", "<click>");
					Element.getInstance().element.click();
					strStepExpected = "click";
					break;
				case "<doubleclick>":
					objActions = new Actions(BrowserDriver.getInstance().browserDriver);
					objActions.moveToElement(Element.getInstance().element).doubleClick().build().perform();
					strStepExpected = "double_click";
					break;
				case "<rightclick>":
					//ToDo add right click code
					objActions = new Actions(BrowserDriver.getInstance().browserDriver);
					objActions.contextClick(Element.getInstance().element).build().perform();
					// 			Actions action= new Actions(BrowserDriver.getInstance().browserDriver);
					// 			action.contextClick(Element.getInstance().element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
					strStepExpected = "right_click";
					break;
				default:
					throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <click>, <doubleclick>, <rightclick>");
				}
				break;
			case "input_text":
			case "input_password":
			case "textarea":
			case "input_email":
			case "input_textarea":
				if (Element.getInstance().element.getAttribute("value").isEmpty() == false) {
					Element.getInstance().element.clear();
				}
				Element.getInstance().element.sendKeys(strInputValue);
				strStepExpected = "set";
				break;
			case "input_radio":
				switch (strInputValue.toLowerCase()) {
				case "":
				case "<on>":
					JSONS.getInstance().step.putValue("strInputValue", "<on>");
					if (Element.getInstance().element.isSelected() == false) {
						Element.getInstance().element.click();
					}
					strStepExpected = "click";
					break;
				default:
					throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please use <on>");
				}
				break;
			case "input_checkbox":
				switch (strInputValue.toLowerCase()) {
				case "":
				case "<on>":
					JSONS.getInstance().step.putValue("strInputValue", "<on>");
					if (Element.getInstance().element.isSelected() == false) {
						Element.getInstance().element.click();
					}
					break;
				case "<off>":
					if (Element.getInstance().element.isSelected() == true) {
						Element.getInstance().element.click();
					}
					break;
				default:
					throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
				}
				strStepExpected = "click";
				break;
			case "select":
				//ToDo add throws UnexpectedTagNameException when element is not a SELECT   may be useless
				Select objSelect = new Select(Element.getInstance().element);
				objSelect.getOptions();
				int intOptionsLength = objSelect.getOptions().size();
				strOptions = Element.getInstance().element.getAttribute("innerHTML");
				strValueToSelect = strInputValue;
				String strKeywordValue = "";
				switch (Keyword.getKeyword(strInputValue)) {
				case "<blank>":
					strValueToSelect = "";
					break;
				case "<first>":
					strValueToSelect = objSelect.getOptions().get(0).getText();
					break;
				case "<second>":
					strValueToSelect = objSelect.getOptions().get(1).getText();
					break;
				case "<third>":
					strValueToSelect = objSelect.getOptions().get(2).getText();
					break;
				case "<last>":
					strValueToSelect = objSelect.getOptions().get(intOptionsLength - 1).getText();
					break;
				case "<random>":
					int intStartRange = Keyword.getKeywordIntValue(strInputValue);
					strValueToSelect = objSelect.getOptions().get(Util.randomNumberRange(intStartRange, intOptionsLength - 1)).getText();
					Logger.getInstance().add("ElementSet strValueToSelect = " + strValueToSelect);
					break;
				case "<starts>":
					strKeywordValue = Keyword.getKeywordValue(strInputValue);
					Logger.getInstance().add("ElementSet strKeywordValue = " + strKeywordValue);
					lngStartTime = System.currentTimeMillis();
					int intRightArrowPosition = strOptions.indexOf(">" + strKeywordValue);
					if (intRightArrowPosition > -1) {
						int intLeftArrowPosition = strOptions.indexOf("<", intRightArrowPosition);
						strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
					}
					Logger.getInstance().add("ElementSet: strKeywordValue2 " + strValueToSelect);
					Logger.getInstance().add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					break;
				case "<ends>":
					strKeywordValue = Keyword.getKeywordValue(strInputValue);
					Logger.getInstance().add("ElementSet strKeywordValue = " + strKeywordValue);
					lngStartTime = System.currentTimeMillis();
					int intMatchPosition = strOptions.indexOf(strKeywordValue + "<");
					intRightArrowPosition = strOptions.lastIndexOf(">", intMatchPosition);
					if (intRightArrowPosition > -1) {
						int intLeftArrowPosition = strOptions.indexOf("<", intRightArrowPosition);
						strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
					}
					Logger.getInstance().add("ElementSet: strValueToSelect " + strValueToSelect);
					Logger.getInstance().add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					break;
				case "<contains>":
					int intStart = 0;
					strKeywordValue = Keyword.getKeywordValue(strInputValue);
					Logger.getInstance().add("ElementSet strKeywordValue = " + strKeywordValue);
					lngStartTime = System.currentTimeMillis();
					int intKeywordCount = strOptions.length() - strOptions.replace(strKeywordValue, "").length();
					Logger.getInstance().add("ElementSet: intKeywordCount = " + intKeywordCount);
					for (int intTestInstanceEach = 0; intTestInstanceEach < intKeywordCount; intTestInstanceEach++) {
						Logger.getInstance().add("ElementSet: intStart = " + intStart);
						intMatchPosition = strOptions.indexOf(strKeywordValue, intStart);
						Logger.getInstance().add("ElementSet: intMatchPosition = " + intMatchPosition);
						intRightArrowPosition = strOptions.lastIndexOf(">", intMatchPosition);
						Logger.getInstance().add("ElementSet: intRightArrowPosition = " + intRightArrowPosition);
						if (intRightArrowPosition > -1) {
							int intLeftArrowPosition = strOptions.indexOf("<", intMatchPosition);
							Logger.getInstance().add("ElementSet: intLeftArrowPosition = " + intLeftArrowPosition);
							strValueToSelect = strOptions.substring(intRightArrowPosition + 1, intLeftArrowPosition);
						}
						Logger.getInstance().add("ElementSet: strValueToSelect = " + strValueToSelect);
						if (strValueToSelect.startsWith("<option")) {
							intStart = intMatchPosition + 1;
						} else {
							break;
						}
					}
					Logger.getInstance().add("ElementSet: strValueToSelect " + strValueToSelect);
					Logger.getInstance().add("ElementSet: KeywordReturn Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
					break;
				case "<re>":
					//TODO add regex options
					break;
				default:
					break;
				}
				Logger.getInstance().add("ElementSet: strValueToSelect " + strValueToSelect);
				JSONS.getInstance().step.putValue("strInputValue", strValueToSelect);
				try {
					strStepExpected = "select";
					objSelect.selectByVisibleText(strValueToSelect);
				} catch (NoSuchElementException e) {
					//strStepActual = "notinlist";
					JSONS.getInstance().step.putValue("strStepActual", "notinlist");
					strOptionsList = this.optionsList(strOptions);
					JSONS.getInstance().step.putValue("strOutputValue", strOptionsList);
					Logger.getInstance().add("ElementSet: options list removeTags = " + strOptionsList);
					throw new ExceptionVisibleTextNotInSelectList(e.getMessage());
				}
				break;
			case "table":
				break;
			case "alert":
				switch (strAttributeValues) {
				case "edit":
					BrowserDriver.getInstance().browserDriver.switchTo().alert().sendKeys(strInputValue);
					strStepExpected = "set";
					break;
				case "accept":
					BrowserDriver.getInstance().browserDriver.switchTo().alert().accept();
					strStepExpected = "click";
					break;
				case "dismiss":
					BrowserDriver.getInstance().browserDriver.switchTo().alert().dismiss();
					strStepExpected = "click";
					break;
				default:
					throw new ExceptionKeywordNotValid("The keyword " + strAttributeValues + " for the click event is not valid! Please us one of the following <edit>, <accept>, <dismiss>");
				}
				break;
			default:
				throw new ExceptionElementTagNameNotSupported("ElementSet: Element tag {" + strTagType + "} not supported");
			}
		} finally {
			JSONS.getInstance().step.putValue("strStepExpected", strStepExpected);
			Logger.getInstance().add("ElementSet: finally strStepExpected = " + strStepExpected);
			Logger.getInstance().add("ElementSet: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}

	private String optionsList(String strOptions) {
		long lngStartTime = System.currentTimeMillis();
		String strOptionsToFindList = strOptions;
		int intLeftArrowPosition = -1;
		int intRightArrowPosition = -1;
		String strOptionsList = "";
		int intOptionsCounts = 0;
		int intStart = 0;
		String strOptionsValue = "";
		strOptionsToFindList = strOptionsToFindList.replaceAll("\\s{2,}", " ");
		intOptionsCounts = (strOptionsToFindList.length() - strOptionsToFindList.replace("<option", "").length()) / 7;
		// Logger.getInstance().add("optionsList: intOptionsCounts = " + intOptionsCounts);
		for (int intOptionEach = 0; intOptionEach < intOptionsCounts; intOptionEach++) {
			// Logger.getInstance().add("optionsList: intStart = " + intStart);
			intLeftArrowPosition = strOptionsToFindList.indexOf("<option", intStart);
			// Logger.getInstance().add("optionsList: intLeftArrowPosition <option = " + intLeftArrowPosition);
			if (intLeftArrowPosition > -1) {
				intRightArrowPosition = strOptionsToFindList.indexOf(">", intLeftArrowPosition);
				// Logger.getInstance().add("optionsList: intRightArrowPosition = " + intRightArrowPosition);
				intLeftArrowPosition = strOptionsToFindList.indexOf("<", intRightArrowPosition);
				// Logger.getInstance().add("optionsList: intLeftArrowPosition < = " + intLeftArrowPosition);
				strOptionsValue = strOptionsToFindList.substring(intRightArrowPosition + 1, intLeftArrowPosition);
				// Logger.getInstance().add("optionsList: strOptionsValue = " + strOptionsValue);
				if (strOptionsList.length() == 0) {
					strOptionsList = strOptionsValue.trim();
				} else {
					strOptionsList = strOptionsList + "; " + strOptionsValue.trim();
				}
				intStart = intRightArrowPosition + 1;
				// Logger.getInstance().add("optionsList: inside if intStart = " + intStart);
			}
		}
		Logger.getInstance().add("OptionsList: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		return strOptionsList.substring(0, strOptionsList.length());
	}
}