package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementDisabledSync {
	ElementDisabledSync() {
		Logger.getInstance().add("  ==start==>ElementDisabledSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnDisabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
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
				if (blnDisabled == false) {
					new ElementDisabled();
					blnDisabled = true;
				}
				blnStatus = true;
				strActualResult = "sync_disabled";
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				blnVisible = false;
				blnDisabled = false;
				strActualResult = "not_found";
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				blnDisabled = false;
				strActualResult = "not_visible";
				Logger.getInstance().add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotDisabled e) {
				blnDisabled = false;
				strActualResult = "not_disabled";
				Logger.getInstance().add("ElementDisabledSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "elementDisabledSync", "syncdisabled", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
					blnDisabled = false;
				}
			}
		}
	}
}