package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementOnMouseOutSync {
	ElementOnMouseOutSync() {
		Logger.getInstance().add("  ==start==>ElementOnMouseOutSync " + Util.getDateTimestamp());
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
					new ElementOnMouseOut();
					blnOnMouseOver = true;
				}
				blnStatus = true;
				strActualResult = "mouse_out";
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				strActualResult = "not_found";
				Logger.getInstance().add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				strActualResult = "not_visible";
				Logger.getInstance().add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotEnabled e) {
				blnEnabled = false;
				strActualResult = "not_enabled";
				Logger.getInstance().add("ElementOnMouseOutSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "ElementOnMouseOutSync", "mouse_out", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
					blnOnMouseOver = false;
				}
			}
		}
	}
}
