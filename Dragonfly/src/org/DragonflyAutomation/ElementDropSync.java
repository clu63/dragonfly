package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
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
				//Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
				//actions.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).perform();
				// 	Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
				// 	Action dragDrop = action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build();
				// 	dragDrop.perform();
				Actions objActions = new Actions(BrowserDriver.getInstance().browserDriver);
				Action objDragAndDrop = objActions.clickAndHold(ElementDrag.getInstance().elementDrag).moveToElement(ElementDrop.getInstance().elementDrop).release(ElementDrop.getInstance().elementDrop).build();
				objDragAndDrop.perform();
				// 	Actions action = new Actions(BrowserDriver.getInstance().browserDriver);
				// 	action.dragAndDrop(gobjWebElementDrag, gobjWebElementDrop).build().perform();
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
}
