package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;
import autoitx4java.AutoItX;

class ElementGet {
	String run() throws ExceptionElementTagNameNotSupported {
		Logger.getInstance().add("  ==start==>ElementGet " + Util.getDateTimestamp());
		switch (JSONS.getInstance().step.getLowerCase("strTagType")) {
		case "title":
			return BrowserDriver.getInstance().browserDriver.getTitle();
		case "img":
			return Element.getInstance().element.getAttribute("src");
		case "input_button":
		case "input_submit":
		case "input_reset":
		case "input_image":
		case "button":
			return Element.getInstance().element.getAttribute("value").trim();
		case "a":
		case "th":
		case "tr":
		case "td":
		case "div":
		case "span":
		case "h1":
		case "h2":
		case "h3":
		case "h4":
		case "h5":
		case "h6":
		case "p":
		case "li":
			return Element.getInstance().element.getText();
		case "input_text":
		case "input_password":
		case "textarea":
		case "input_email":
		case "input_textarea":
			return Element.getInstance().element.getAttribute("value");
		case "input_radio":
		case "input_checkbox":
			if (Element.getInstance().element.isSelected() == false) {
				return "<off>";
			} else {
				return "<on>";
			}
		case "select":
			// 	Select objSelect = new Select(Element.getInstance().element);
			// 	objSelect.getOptions();
			// 	WebElement option = ((Select) Element.getInstance().element).getFirstSelectedOption();
			// 	Logger.getInstance().add("ElementGet: option.getText() = " + option.getText());
			//return ((Select) Element.getInstance().element).getFirstSelectedOption().getText().replaceAll("\\s{2,}", " ");
			JavascriptExecutor objExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
			return ((String) objExecutor.executeScript("var select = arguments[0];var selection=select.options[select.selectedIndex].text;return selection;", Element.getInstance().element)).trim();
		case "table":
			return Element.getInstance().element.getText();
		case "alert":
			AutoItX autoIt = new AutoItSetObject().createObject();
			if (JSONS.getInstance().step.verifyEquals("strAttributeValues", "title")) {
				return autoIt.winGetTitle("[ACTIVE]");
			} else {
				return BrowserDriver.getInstance().browserDriver.switchTo().alert().getText();
			}
		default:
			throw new ExceptionElementTagNameNotSupported("Element tag not supported");
		}
	}
}
