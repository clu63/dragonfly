package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementHiddenSync {
	ElementHiddenSync() {
		Logger.getInstance().add("  ==start==>ElementHiddenSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnHidden = false;
		Boolean blnStatus = false;
		String strActualResult = "";
		while (true) {
			try {
				if (blnFound == false) {
					new ElementFind();
					blnFound = true;
				}
				if (blnHidden == false) {
					new ElementHidden();
					blnHidden = true;
				}
				blnStatus = true;
				strActualResult = "sync_hidden";
			} catch (NoSuchWindowException | StaleElementReferenceException | NullPointerException | NoSuchElementException | ExceptionElementNotFound e) {
				blnFound = false;
				blnHidden = true;
				blnStatus = true;
				strActualResult = "sync_hidden";
				Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionMultipleElementsFound e) {
				blnFound = false;
				blnHidden = false;
				strActualResult = "not_found";
				Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotHidden e) {
				blnHidden = false;
				strActualResult = "not_hidden";
				Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (Exception e) {
				blnFound = false;
				blnHidden = false;
				strActualResult = "exception";
				;
				Logger.getInstance().add("ElementHiddenSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "ElementHiddenSync", "synchidden", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
					blnHidden = false;
				}
			}
		}
	}
}
