package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementVerifyNotValueSync {
	ElementVerifyNotValueSync() {
		Logger.getInstance().add("  ==start==>ElementVerifyNotValueSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVerifiedNot = false;
		Boolean blnVisible = false;
		String strActualValue = "";
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
				if (blnVerifiedNot == false) {
					strActualValue = new ElementVerifyNotValue().run();
					blnVerifiedNot = true;
				}
				strActualResult = "verify_not";
				blnStatus = true;
			} catch (ExceptionElementTagNameNotSupported e) {
				blnExit = true;
				strActualResult = "tag_not_supported";
				Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				blnVisible = false;
				strActualResult = "not_found";
				Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				strActualResult = "not_visible";
				Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionValueMatched e) {
				strActualResult = "not_verify_not";
				Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (Exception e) {
				strActualResult = "exception";
				Logger.getInstance().add("ElementVerifyNotValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "ElementVerifyNotValueSync", "verify_not", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
					blnVisible = false;
					blnVerifiedNot = false;
				}
			}
		}
	}
}
