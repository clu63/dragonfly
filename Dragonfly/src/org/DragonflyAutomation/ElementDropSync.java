package org.DragonflyAutomation;

import org.openqa.selenium.By;
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
				ElementDrop.getInstance().elementDrop = Element.getInstance().element;
				Logger.getInstance().add("++++++++++++++ElementDrag: outerHTML = " + ElementDrag.getInstance().elementDrag.getAttribute("outerHTML"));
				Logger.getInstance().add("++++++++++++++ElementDrop: outerHTML = " + ElementDrop.getInstance().elementDrop.getAttribute("outerHTML"));
				//
				WebElement webElementBody = null;
				webElementBody = BrowserDriver.getInstance().browserDriver.findElement(By.xpath("/html/body"));
				//
				int dragX = ElementDrag.getInstance().elementDrag.getLocation().getX();
				int dragY = ElementDrag.getInstance().elementDrag.getLocation().getY();
				int dropX = ElementDrop.getInstance().elementDrop.getLocation().getX();
				int dropY = ElementDrop.getInstance().elementDrop.getLocation().getY();
				int bodyX = webElementBody.getLocation().getX();
				int bodyY = webElementBody.getLocation().getY();
				//
				int dragHeight = ElementDrag.getInstance().elementDrag.getSize().getHeight();
				int dragWidth = ElementDrag.getInstance().elementDrag.getSize().getWidth();
				int dropHeight = ElementDrop.getInstance().elementDrop.getSize().getHeight();
				int dropWidth = ElementDrop.getInstance().elementDrop.getSize().getWidth();
				int bodyHeight = webElementBody.getSize().getHeight();
				int bodyWidth = webElementBody.getSize().getWidth();
				//
				int dragMiddleX = dragX + (dragWidth / 2);
				int dragMiddleY = dragY + (dragHeight / 2);
				int dropMiddleX = dropX + (dropWidth / 2);
				int dropMiddleY = dropY + (dropHeight / 2);
				int bodyMiddleX = dropX + (bodyHeight / 2);
				int bodyMiddleY = dropY + (bodyWidth / 2);
				//
				Logger.getInstance().add("++++++++++++++ElementBody: x,y = " + bodyX + "," + bodyY);
				Logger.getInstance().add("++++++++++++++ElementBody: Width,Height = " + bodyWidth + "," + bodyHeight);
				Logger.getInstance().add("++++++++++++++ElementDrag: x,y = " + dragX + "," + dragY);
				Logger.getInstance().add("++++++++++++++ElementDrag: Width,Height = " + dragWidth + "," + dragHeight);
				Logger.getInstance().add("++++++++++++++ElementDrop: x,y = " + dropX + "," + dropY);
				Logger.getInstance().add("++++++++++++++ElementDrop: Width,Height = " + dropWidth + "," + dropHeight);
				//
				Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
				Logger.getInstance().add("++++++++++++++ElementDrag: moveToElement = " + dragMiddleX + "," + dragMiddleY);
				actions.moveToElement(ElementDrag.getInstance().elementDrag).perform();
				new SleepMilliseconds(10000);
				Logger.getInstance().add("++++++++++++++webElementDrag moveByOffset distance= " + (dropMiddleX - dragMiddleX) + "," + (dropMiddleY - dragMiddleY));
				Logger.getInstance().add("++++++++++++++webElementDrop middle x,y = " + (dragMiddleX + (dropMiddleX - dragMiddleX)) + "," + (dragMiddleY + (dropMiddleY - dragMiddleY)));
				actions.moveByOffset((dropMiddleX - dragMiddleX), (dropMiddleY - dragMiddleY)).perform();
				new SleepMilliseconds(10000);
				//actions.moveToElement(ElementDrag.getInstance().elementDrag).pause(2000).clickAndHold().pause(2000).moveByOffset((dropMiddleX - dragMiddleX), (dropMiddleY - dragMiddleY)).pause(2000).release().perform();
				//
				actions.moveToElement(ElementDrag.getInstance().elementDrag).perform();
				new SleepMilliseconds(2000);
				actions.clickAndHold().perform();
				new SleepMilliseconds(2000);
				actions.moveByOffset((dropMiddleX - dragMiddleX), (dropMiddleY - dragMiddleY)).perform();
				new SleepMilliseconds(2000);
				actions.release().perform();
				//
				//				//
				//				Logger.getInstance().add("++++++++++++++Test moves body");
				//				Logger.getInstance().add("++++++++++++++webElementBody: moveToElement = " + bodyMiddleX + "," + bodyMiddleY);
				//				actions.moveToElement(webElementBody).perform();
				//				new SleepMilliseconds(20000);
				//				Logger.getInstance().add("++++++++++++++webElementBody moveToElement: x+5, y+5 = " + (bodyX + 5) + "," + (bodyY + 5));
				//				actions.moveToElement(webElementBody, 5, 5).perform();
				//				new SleepMilliseconds(20000);
				//				Logger.getInstance().add("++++++++++++++webElementBody moveToElement: x-1, y-1 = " + (bodyX - 1) + "," + (bodyY - 1));
				//				actions.moveToElement(webElementBody, -1, -1).perform();
				//				new SleepMilliseconds(20000);
				//				Logger.getInstance().add("++++++++++++++webElementBody moveToElement = " + (bodyX * -1) + "," + (bodyY * -1));
				//				actions.moveToElement(ElementDrag.getInstance().elementDrag, (bodyX * -1), (bodyY * -1)).perform();
				//				new SleepMilliseconds(20000);
				//				Logger.getInstance().add("++++++++++++++webElementBody moveByOffset = " + dragMiddleX + "," + dragMiddleY);
				//				actions.moveByOffset(dragMiddleX, dragMiddleY).perform();
				//				new SleepMilliseconds(20000);
				//				//
				//				Logger.getInstance().add("++++++++++++++Test moves Drag");
				//				Logger.getInstance().add("++++++++++++++ElementDrag: moveToElement = " + dragMiddleX + "," + dragMiddleY);
				//				actions.moveToElement(ElementDrag.getInstance().elementDrag).perform();
				//				new SleepMilliseconds(20000);
				//				Logger.getInstance().add("++++++++++++++ElementDrag moveToElement: x+5, y+5 = " + (dragX + 5) + "," + (dragY + 5));
				//				actions.moveToElement(ElementDrag.getInstance().elementDrag, 5, 5).perform();
				//				new SleepMilliseconds(20000);
				//				Logger.getInstance().add("++++++++++++++ElementDrag moveToElement: x+1, y+1 = " + (dragX + 1) + "," + (dragY + 1));
				//				actions.moveToElement(ElementDrag.getInstance().elementDrag, 1, 1).perform();
				//				new SleepMilliseconds(20000);
				//				Logger.getInstance().add("++++++++++++++ElementDrag moveToElement: x-1, y-1 = " + (dragX - 1) + "," + (dragY - 1));
				//				actions.moveToElement(ElementDrag.getInstance().elementDrag, -1, -1).perform();
				//				new SleepMilliseconds(20000);
				//				actions.moveToElement(ElementDrag.getInstance().elementDrag, dragX * -1, dragY * -1).perform();
				//				new SleepMilliseconds(20000);
				//				//Logger.getInstance().add("++++++++++++++ElementDrop: Rect = " + ElementDrop.getInstance().elementDrop.getRect());
				//				//
				//				Logger.getInstance().add("++++++++++++++Test moves Drop");
				//				Logger.getInstance().add("++++++++++++++ElementDrop: middle = " + dropMiddleX + "," + dropMiddleY);
				//				actions.moveToElement(ElementDrop.getInstance().elementDrop).perform();
				//				new SleepMilliseconds(20000);
				//				actions.moveToElement(ElementDrop.getInstance().elementDrop, -1, -1).perform();
				//				new SleepMilliseconds(20000);
				//				actions.moveToElement(ElementDrop.getInstance().elementDrop, -10, -10).perform();
				//				new SleepMilliseconds(20000);
				//				actions.moveToElement(ElementDrop.getInstance().elementDrop, 10, 10).perform();
				//				new SleepMilliseconds(20000);
				//				actions.moveToElement(ElementDrop.getInstance().elementDrop, dropX * -1, dropY * -1).perform();
				//				new SleepMilliseconds(10000);
				//				//
				//
				//actions.moveToElement(ElementDrag.getInstance().elementDrag).perform();
				//				actions.moveByOffset(getDragX, getDragY).build().perform();
				//				new SleepMilliseconds(10000);
				//				actions.moveByOffset(getDropX, getDropY).build().perform();
				//				new SleepMilliseconds(10000);
				//actions.moveByOffset(getDropX - getDragX, getDropY - getDragY).perform();
				//				getDragX = ElementDrag.getInstance().elementDrag.getLocation().getX();
				//				getDragY = ElementDrag.getInstance().elementDrag.getLocation().getY();
				//				getDropX = ElementDrop.getInstance().elementDrop.getLocation().getX();
				//				getDropY = ElementDrop.getInstance().elementDrop.getLocation().getY();
				//				//
				//				new SleepMilliseconds(10000);
				//				//
				//				Logger.getInstance().add("++++++++++++++ElementDrag: x,y = " + getDragX + "," + getDragY);
				//				Logger.getInstance().add("++++++++++++++ElementDrop: x,y = " + getDropX + "," + getDropY);
				//.release().perform();
				//new SleepMilliseconds(10000);
				//actions.moveToElement(Element.getInstance().element).perform();
				//Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
				/////actions.dragAndDrop(ElementDrag.getInstance().elementDrag, ElementDrop.getInstance().elementDrop).perform();
				//actions.clickAndHold(ElementDrag.getInstance().elementDrag).moveToElement(ElementDrop.getInstance().elementDrop).release(ElementDrop.getInstance().elementDrop).perform();
				//				
				//				actions.moveToElement(ElementDrag.getInstance().elementDrag)
				//				.clickAndHold()
				//				.moveToElement(ElementDrop.getInstance().elementDrop)
				//				.release().perform();
				//				
				//				
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
