package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

class ElementDropSync {
	ElementDropSync() {
		Logger.getInstance().add("  ==start==>ElementDropSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strOuterHTML = "";
		while (true) {
			try {
				if (blnFound == false) {
					new ElementFind();
					Logger.getInstance().add("ElementDropSync: elementFind over");
					if (Element.getInstance().element != null) {
						strOuterHTML = Element.getInstance().element.getAttribute("outerHTML");
						Logger.getInstance().add("ElementDropSync: outerHTML = " + strOuterHTML);
						Logger.getInstance().add("ElementDropSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					Logger.getInstance().add("ElementDropSync: strOuterHTML over");
					blnFound = true;
				}
				if (blnVisible == false) {
					new ElementVisible();
					blnVisible = true;
				}
				if (blnEnabled == false) {
					new ElementEnabled();
					blnEnabled = true;
				}
				Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
				actions.moveToElement(Element.getInstance().element).perform();
				
				//				function createEvent(typeOfEvent) {
				//				    var event = document.createEvent("CustomEvent");
				//				    event.initCustomEvent(typeOfEvent, true, true, null);
				//				    event.dataTransfer = {
				//				        data: {},
				//				        setData: function (key, value) {
				//				            this.data[key] = value;
				//				        },
				//				        getData: function (key) {
				//				            return this.data[key];
				//				        }
				//				    };
				//				    return event;
				//				}
				//				function dispatchEvent(element, event, transferData) {
				//				    if (transferData !== undefined) {
				//				        event.dataTransfer = transferData;
				//				    }
				//				    if (element.dispatchEvent) {
				//				        element.dispatchEvent(event);
				//				    } else if (element.fireEvent) {
				//				        element.fireEvent("on" + event.type, event);
				//				    }
				//				}
				//				function simulateHTML5DragAndDrop(element, target) {
				//				    var dragStartEvent = createEvent('dragstart');
				//				    dispatchEvent(element, dragStartEvent);
				//				    var dropEvent = createEvent('drop');
				//				    dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);
				//				    var dragEndEvent = createEvent('dragend');
				//				    dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);
				//				}
//				try {
//					//simulateDragAndDrop(ElementDrag.getInstance().elementDrag, ElementDrop.getInstance().elementDrop);
//					simulateDragAndDrop();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				//				ElementDrop.getInstance().elementDrop = Element.getInstance().element;
				//				//Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
				//				//actions.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).perform();
				//				// 	Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
				//				// 	Action dragDrop = action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build();
				//				// 	dragDrop.perform();
				//				Actions objActions = new Actions(BrowserDriver.getInstance().browserDriver);
				//				Action objDragAndDrop = objActions.clickAndHold(ElementDrag.getInstance().elementDrag).moveToElement(ElementDrop.getInstance().elementDrop).release(ElementDrop.getInstance().elementDrop).build();
				//				objDragAndDrop.perform();
				//				// 	Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
				//				// 	action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build().perform();
				new SleepMilliseconds(10000);
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				Logger.getInstance().add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				Logger.getInstance().add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotEnabled e) {
				blnEnabled = false;
				Logger.getInstance().add("ElementDropSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (Finally.sync(blnExit, blnStatus, blnFound, "elementDropSync", "drop", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				}
			}
		}
	}

	private void simulateDragAndDrop() throws Exception {
		//private void simulateDragAndDrop(WebElement elementToDrag, WebElement target) throws Exception {
		// WebDriver driver = getDriver();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
		//@formatter:off
		String javaScript = 
		  "function createEvent(typeOfEvent) {\n" 
		+ "var event = document.createEvent(\"CustomEvent\");\n" 
		+ "event.initCustomEvent(typeOfEvent, true, true, null);\n" 
		+ "   event.dataTransfer = {\n" 
		+ "       data: {},\n" 
		+ "       setData: function (key, value) {\n" 
		+ "           this.data[key] = value;\n" 
		+ "       },\n" 
		+ "       getData: function (key) {\n" 
		+ "           return this.data[key];\n" 
		+ "       }\n" 
		+ "   };\n" 
		+ "   return event;\n" 
		+ "}\n" 
		+ "\n" 
		+ "function dispatchEvent(element, event, transferData) {\n" 
		+ "   if (transferData !== undefined) {\n" 
		+ "       event.dataTransfer = transferData;\n" 
		+ "   }\n" 
		+ "   if (element.dispatchEvent) {\n" 
		+ "       element.dispatchEvent(event);\n" 
		+ "   } else if (element.fireEvent) {\n" 
		+ "       element.fireEvent(\"on\" + event.type, event);\n" 
		+ "   }\n" 
		+ "}\n" 
		+ "\n" 
		+ "function simulateHTML5DragAndDrop(element, target) {\n" 
		+ "   var dragStartEvent = createEvent('dragstart');\n" 
		+ "   dispatchEvent(element, dragStartEvent);\n" 
		+ "   var dropEvent = createEvent('drop');\n" 
		+ "   dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);\n" 
		+ "   var dragEndEvent = createEvent('dragend');\n" 
		+ "   dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);\n" 
		+ "}\n" 
		+ "\n" 
		

		//+ "var elementToDrag = arguments[0];\n"
		//+ "var target = arguments[1];\n"
		//+ "simulateHTML5DragAndDrop(elementToDrag, target);";
		+ "simulateHTML5DragAndDrop(arguments[0], arguments[1]);";
		//@formatter:on
		System.out.println(javaScript);
		javascriptExecutor.executeScript(javaScript, ElementDrag.getInstance().elementDrag, ElementDrop.getInstance().elementDrop);
	}
}
