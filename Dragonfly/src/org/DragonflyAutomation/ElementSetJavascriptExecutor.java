package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class ElementSetJavascriptExecutor {
	ElementSetJavascriptExecutor(String strOuterHTML) throws ExceptionElementTagNameNotSupported, ExceptionElementNotSet, ExceptionKeywordNotValid {
		Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		String strInputValue = JSONS.getInstance().step.getString("strInputValue");
		String strValueToSelect = "";
		String strAttributeValues = JSONS.getInstance().step.getLowerCase("strAttributeValues");
		String strTagType = JSONS.getInstance().step.getLowerCase("strTagType");
		JavascriptExecutor objJavascriptExecutor = null;
		objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
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
				switch (strInputValue.toLowerCase()) {
				case "":
				case "<click>":
					objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
					objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
					objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
					break;
				case "<doubleclick>":
					Actions objAction = new Actions(BrowserDriver.getInstance().browserDriver);
					objAction.moveToElement(Element.getInstance().element).doubleClick().build().perform();
					break;
				case "<rightclick>":
					//ToDo add right click code javascript
					Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
					action.contextClick(Element.getInstance().element).build().perform();
					// 			Actions action= new Actions(BrowserDriver.getInstance().browserDriver);
					// 			action.contextClick(Element.getInstance().element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
				// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor inputtext" + Util.getDateTimestamp());
				objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
				// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor focus" + Util.getDateTimestamp());
				objJavascriptExecutor.executeScript("arguments[0].value = '';", Element.getInstance().element);
				// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor value" + Util.getDateTimestamp());
				objJavascriptExecutor.executeScript("arguments[0].value = '" + strInputValue + "';", Element.getInstance().element);
				// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor value" + Util.getDateTimestamp());
				objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
				// Logger.getInstance().add("onchange blur");
				if (strOuterHTML.toLowerCase().contains("onchange")) {
					try {
						// Logger.getInstance().add("  ==start==>ElementSetJavascriptExecutor strOuterHTML" + Util.getDateTimestamp());
						objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
					} catch (WebDriverException e) {
						Logger.getInstance().add("ElementSetJavascriptExecutor = WebDriverException: " + e.toString());
					}
				}
				break;
			case "input_radio":
				switch (strInputValue.toLowerCase()) {
				case "":
				case "<on>":
					JSONS.getInstance().step.putValue("strInputValue", "<on>");
					if (Element.getInstance().element.isSelected() == false) {
						objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
						if (strOuterHTML.toLowerCase().contains("onchange")) {
							try {
								objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
							} catch (WebDriverException e) {
								Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
							}
						}
					}
					break;
				default:
					throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please use <on>");
				}
				break;
			case "input_checkbox":
				switch (strInputValue.toLowerCase()) {
				case "<on>":
					if (Element.getInstance().element.isSelected() == false) {
						objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
						if (strOuterHTML.toLowerCase().contains("onchange")) {
							try {
								objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
							} catch (WebDriverException e) {
								Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
							}
						}
					}
					break;
				case "<off>":
					if (Element.getInstance().element.isSelected() == true) {
						objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].click();", Element.getInstance().element);
						objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
						if (strOuterHTML.toLowerCase().contains("onchange")) {
							try {
								objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
							} catch (WebDriverException e) {
								Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
							}
						}
					}
					break;
				default:
					throw new ExceptionKeywordNotValid("The keyword " + strInputValue + " for the click event is not valid! Please us one of the following <on> or <off>");
				}
				break;
			case "select":
				Select objSelect = new Select(Element.getInstance().element);
				objSelect.getOptions();
				objSelect.selectByVisibleText(strInputValue);
				// set_js
				// 		int intOptionsEach;
				// 		String strOptions = "";
				// 		String[] arrOptions;
				// 		strOptions = (String) objJavascriptExecutor.executeScript("var txt = '';var x = arguments[0];var i;for (i = 0; i < x.length; i++)" + "{txt = txt + '|' + x.options[i].text;}" + "return txt;", Element.getInstance().element);
				// 		strOptions = strOptions.substring(1);
				// 		arrOptions = strOptions.split("\\|");
				// 		for (intOptionsEach = 0; intOptionsEach < arrOptions.length; intOptionsEach++) {
				// 			 Logger.getInstance().add("ElementSetJavascriptExecutor: arrOptions[intOptionsEach].toString() = " + arrOptions[intOptionsEach].toString());
				// 			if (arrOptions[intOptionsEach].toString().equals(JSONS.getInstance().step.get("strInputValue").toString())) {
				// 				blnSet = true;
				// 				Select objSelect = new Select(Element.getInstance().element);
				// 				objJavascriptExecutor.executeScript("arguments[0].focus();", Element.getInstance().element);
				// 				objSelect.selectByIndex(intOptionsEach);
				// 				objJavascriptExecutor.executeScript("arguments[0].blur();", Element.getInstance().element);
				// 				// objJavascriptExecutor.executeScript("arguments[0].selectedIndex=" + intOptionsEach + ";", Element.getInstance().element);
				// 				// if (strOuterHTML.toLowerCase().contains("onchange")) {
				// 				// try {
				// 				// objJavascriptExecutor.executeScript("arguments[0].onchange();", Element.getInstance().element);
				// 				// } catch (WebDriverException e) {
				// 				//  Logger.getInstance().add("ElementSetJavascriptExecutor = " + e.toString());
				// 				// }
				// 				// }
				// 				break;
				// 			}
				// 		}
				// 		intOptionsLength = objObject.Object.Options.All.Length
				// 		        ' switch based on keyword input
				// 		        Select Case LCase(strValueToSelect)
				// 		        Case "<blank>"
				// 		            strValueToSelect = ""
				// 		        Case "<first>"
				// 		            strValueToSelect = objObject.Object.Options.All.Item(0).Innertext
				// 		        Case "<second>"
				// 		            strValueToSelect = objObject.Object.Options.All.Item(1).Innertext
				// 		        Case "<third>"
				// 		            strValueToSelect = objObject.Object.Options.All.Item(2).Innertext
				// 		        Case "<last>"
				// 		            strValueToSelect = objObject.Object.Options.All.Item(intOptionsLength - 1).Innertext
				// 		        Case "<random>"
				// 		            intRandom = GenerateRandomNumberBetween(0, intOptionsLength - 1)
				// 		            strValueToSelect = objObject.Object.Options.All.Item(intRandom).Innertext
				// 		        End Select
				// 		        '  check if item is in the list
				// 		        '  loop until object value exists in the list or the intMillisecondsWaited value is exceeded
				// 		        Do Until CDbl(intMillisecondsWaited) > CDbl(intDefaultTimeOutMilliseconds)
				// 		            '            strAllItems = ""
				// 		            strAllItems = objObject.GetROProperty("all items")
				// 		            ' refresh object each loop if can be refreshed
				// 		            If blnShouldRefreshObject = True Then
				// 		                objObject.RefreshObject
				// 		            End If
				// 		            For intOptionsEach = 0 To intOptionsLength - 1
				// 		                If CStr(objObject.Object.Options.All.Item(intOptionsEach).Innertext) = CStr(strValueToSelect) Then
				// 		                    blnItemFound = True
				// 		                    gdtmStartTimeStep = Now
				// 		                    objObject.Select strValueToSelect
				// 		                    Exit For
				// 		                    '                    If strAllItems = "" Then
				// 		                    '                        strAllItems = objObject.Object.Options.All.Item(intOptionsEach).Innertext
				// 		                    '                    Else
				// 		                    '                        strAllItems = strAllItems & ";" & objObject.Object.Options.All.Item(intOptionsEach).Innertext
				// 		                    '                    End If
				// 		                End If
				// 		            Next
				// 		            If blnItemFound = True Then
				// 		                Exit Do
				// 		            End If
				// 		            ' wait within the loop 100 milliseconds to allow loop to check 10 times per second if object does not exist
				// 		            Wait 0, 100
				// 		            '  sets the intMillisecondsWaited variable to the number of milliseconds waited from the point when the intTimerStart was set
				// 		            intMilliseconds Waited = CDbl((Timer - intStartTime) * 1000)
				// 		        Loop
				// 		    End If    '===>   '   If blnEnabled = True Then
				// 		    '  report pass or fail based on the boolean variables set above
				// 		    If blnItemFound = True Then
				// 		        WebListSelect = True
				// 		        ReporterEventScreenShot micPass, strStep, "The selection of the  {" & strObjectToString & "} object with path {" & strObjectPath & "} item value {" & strValueToSelect & "} after {" & intMillisecondsWaited & "} milliseconds."
				// 		    ElseIf blnVisible = False Then
				// 		        WebListSelect = False
				// 		        ReporterEventScreenShot micFail, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is hidden."
				// 		        ReporterEventScreenShot micInfo, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is hidden after {" & intMillisecondsWaited & "} milliseconds."
				// 		    ElseIf blnEnabled = False Then
				// 		        WebListSelect = False
				// 		        ReporterEventScreenShot micFail, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is disabled."
				// 		        ReporterEventScreenShot micInfo, strStep, "The {" & strObjectToString & "} object with path {" & strObjectPath & "} is disabled after {" & intMillisecondsWaited & "} milliseconds."
				// 		    ElseIf blnItemFound = False Then
				// 		        WebListSelect = False
				// 		        ReporterEventScreenShot micFail, strStep, "The selection of the {" & strValueToSelect & "} object with path {" & strObjectPath & "} failed due to item not found in list.  The following is a list of all items: {" & strAllItems & "}"
				// 		        ReporterEventScreenShot micInfo, strStep, "The selection of the {" & strValueToSelect & "} object with path {" & strObjectPath & "} failed due to item not found in list.  The following is a list of all items: {" & strAllItems & "} after {" & intMillisecondsWaited & "} milliseconds."
				// 		    End If
				break;
			case "table":
				break;
			default:
				throw new ExceptionElementTagNameNotSupported("ElementSetJavascriptExecutor: Element tag {" + strTagType + "} not supported");
			}
		} finally {
			Logger.getInstance().add("ElementSetJavascriptExecutor: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
