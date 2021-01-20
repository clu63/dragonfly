package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementScrollSync {
	ElementScrollSync() {
		Logger.getInstance().add("  ==start==>ElementScrollSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
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
					Logger.getInstance().add("ElementScrollSync: blnFound = true");
				}
				if (blnVisible == false) {
					new ElementVisible();
					blnVisible = true;
				}
				new ElementScroll();
				// 		JavascriptExecutor objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
				// 		objJavascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", Element.getInstance().element);
				blnStatus = true;
				Logger.getInstance().add("ElementScrollSync: blnStatus = true");
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				strActualResult = "not_found";
				Logger.getInstance().add("ElementScrollSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				strActualResult = "not_visible";
				Logger.getInstance().add("ElementOnMouseOverSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "ElementScrollSync", "scroll", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				}
			}
		}
	}
}
