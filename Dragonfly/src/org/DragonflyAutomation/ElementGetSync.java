package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementGetSync {
	ElementGetSync() {
		Logger.getInstance().add("  ==start==>ElementGetSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnGet = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strGetValue = "";
		String strActualResult = "";
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
					strGetValue = new ElementGet().run();
					JSONS.getInstance().step.putValue("strOutputValue", strGetValue);
					blnGet = true;
				}
				blnStatus = true;
				strActualResult = "get";
			} catch (ExceptionElementTagNameNotSupported e) {
				blnExit = true;
				strActualResult = "tag_not_supported";
				Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				strActualResult = "not_found";
				Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				strActualResult = "not_visible";
				Logger.getInstance().add("ElementGetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
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
