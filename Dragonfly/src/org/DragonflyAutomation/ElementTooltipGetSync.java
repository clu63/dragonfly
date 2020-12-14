package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementTooltipGetSync {
	ElementTooltipGetSync() {
		Logger.getInstance().add("  ==start==>ElementGetSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnGet = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strGetValue = "";
		while (true) {
			try {
				if (blnFound == false) {
					new ElementFind();
					blnFound = true;
				}
				if (blnVisible == false) {
					new ElementVisible();
					blnVisible = true;
				}
				if (blnGet == false) {
					strGetValue = new ElementTooltipGet().run();
					JSONS.getInstance().step.putValue("strOutputValue", strGetValue);
					blnGet = true;
				}
				blnStatus = true;
				// 	} catch (ExceptionElementTagNameNotSupported e) {
				// 		blnExit = true;
				// 		 Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				if (Finally.sync(blnExit, blnStatus, blnFound, "ElementGetSync", "get", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
					blnVisible = false;
					blnGet = false;
				}
			}
		}
	}
}
