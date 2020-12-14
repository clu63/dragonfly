package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementDragSync {
	  ElementDragSync() {
		Logger.getInstance().add("  ==start==>ElementDragSync " + Util.getDateTimestamp());
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
					Logger.getInstance().add("ElementDragSync: elementFind over");
					if (Element.getInstance().element != null) {
						strOuterHTML = Element.getInstance().element.getAttribute("outerHTML");
						Logger.getInstance().add("ElementDragSync: outerHTML = " + strOuterHTML);
						Logger.getInstance().add("ElementDragSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					}
					Logger.getInstance().add("ElementDragSync: strOuterHTML over");
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
				ElementDrag.getInstance().elementDrag = Element.getInstance().element;
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				Logger.getInstance().add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				Logger.getInstance().add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotEnabled e) {
				blnEnabled = false;
				Logger.getInstance().add("ElementDragSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (Finally.sync(blnExit, blnStatus, blnFound, "elementDragSync", "drag", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
				}
			}
		}
	}
}