package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementOnMouseOverSync {
	ElementOnMouseOverSync() {
		Logger.getInstance().add("  ==start==>ElementOnMouseOverSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnOnMouseOver = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
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
				if (blnEnabled == false) {
					new ElementEnabled();
					blnEnabled = true;
				}
				if (blnOnMouseOver == false) {
					new ElementOnMouseOver();
					blnOnMouseOver = true;
				}
				strActualResult = "mouse_over";
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				strActualResult = "not_found";
				Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				strActualResult = "not_visible";
				Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotEnabled e) {
				blnEnabled = false;
				strActualResult = "not_enabled";
				Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "elementOnMouseOverSync", "mouse_over", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
					blnOnMouseOver = false;
				}
			}
		}
	}
}
