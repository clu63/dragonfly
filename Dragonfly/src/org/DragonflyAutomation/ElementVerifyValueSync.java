package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementVerifyValueSync {
	ElementVerifyValueSync() {
		Logger.getInstance().add("  ==start==>ElementVerifyValueSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnStatus = false;
		Boolean blnVerified = false;
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
				if (blnVerified == false) {
					strActualValue = new ElementVerifyValue().run();
					blnVerified = true;
				}
				blnStatus = true;
				strActualResult = "verify_value";
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				blnVisible = false;
				blnVerified = false;
				strActualResult = "not_found";
				Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				strActualResult = "not_visible";
				Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementTagNameNotSupported e) {
				blnExit = true;
				strActualResult = "tag_not_supported";
				Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionValueNotMatched e) {
				blnVerified = false;
				strActualResult = "not_verified";
				Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (Exception e) {
				blnVerified = false;
				strActualResult = "exception";
				Logger.getInstance().add("ElementVerifyValueSync: " + e.toString() + "  MillisecondsWaited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "elementVerifyValueSync", "verify", lngTimeStart) == true) {
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					return;
				} else {
					blnVisible = false;
					blnVerified = false;
				}
			}
		}
	}
}
