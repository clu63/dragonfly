package org.DragonflyAutomation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;

class ElementSetSync {
	ElementSetSync(boolean blnJavascriptExecutor) {
		Logger.getInstance().add("  ==start==>ElementSetSync " + Util.getDateTimestamp());
		Long lngTimeStart = System.currentTimeMillis();
		Boolean blnAssert = false;
		Boolean blnEnabled = false;
		Boolean blnExit = false;
		Boolean blnFound = false;
		Boolean blnSet = false;
		Boolean blnSetSync = false;
		Boolean blnStatus = false;
		Boolean blnVisible = false;
		String strOuterHTML = "";
		String strActualResult = "";
		while (true) {
			try {
				if (blnFound == false) {
					new ElementFind();
					if (Element.getInstance().element != null) {
						strOuterHTML = Element.getInstance().element.getAttribute("outerHTML");
						Logger.getInstance().add("ElementSetSync: " + strOuterHTML);
						Logger.getInstance().add("ElementSetSync: outerHTML Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
					}
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
				switch (JSONS.getInstance().step.getLowerCase("strAssert")) {
				case "off":
					JSONS.getInstance().step.putValue("strStatus", "pass");
					if (blnSet == false) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						if (blnJavascriptExecutor == true) {
							new ElementSetJavascriptExecutor(strOuterHTML);
						} else {
							new ElementSet(strOuterHTML);
						}
						blnSet = true;
						blnAssert = true;
					}
					if (blnSetSync == false) {
						new ElementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					blnStatus = true;
					break;
				case "hidden":
					if (blnSet == false) {
						JSONS.getInstance().step.putValue("strStatus", "pass");
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
						if (blnJavascriptExecutor == true) {
							new ElementSetJavascriptExecutor(strOuterHTML);
						} else {
							new ElementSet(strOuterHTML);
						}
						blnSet = true;
					}
					if (blnSetSync == false) {
						new ElementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						new ElementHidden();
						blnAssert = true;
					}
					blnStatus = true;
					break;
				case "value":
					if (blnSet == false) {
						if (blnJavascriptExecutor == true) {
							new ElementSetJavascriptExecutor(strOuterHTML);
						} else {
							new ElementSet(strOuterHTML);
						}
						blnSet = true;
					}
					if (blnSetSync == false) {
						new ElementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						new ElementVerifyValue().run();
						blnAssert = true;
					}
					JSONS.getInstance().step.putValue("strStatus", "pass");
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					blnStatus = true;
					break;
				case "visible":
					if (blnSet == false) {
						if (blnJavascriptExecutor == true) {
							new ElementSetJavascriptExecutor(strOuterHTML);
						} else {
							new ElementSet(strOuterHTML);
						}
						blnSet = true;
					}
					if (blnSetSync == false) {
						new ElementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						new ElementVisible();
						blnAssert = true;
					}
					JSONS.getInstance().step.putValue("strStatus", "pass");
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					blnStatus = true;
					break;
				case "enabled":
					if (blnSet == false) {
						if (blnJavascriptExecutor == true) {
							new ElementSetJavascriptExecutor(strOuterHTML);
						} else {
							new ElementSet(strOuterHTML);
						}
						blnSet = true;
					}
					if (blnSetSync == false) {
						new ElementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						new ElementVisible();
						new ElementEnabled();
						blnAssert = true;
					}
					JSONS.getInstance().step.putValue("strStatus", "pass");
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					blnStatus = true;
					break;
				case "disabled":
					if (blnSet == false) {
						if (blnJavascriptExecutor == true) {
							new ElementSetJavascriptExecutor(strOuterHTML);
						} else {
							new ElementSet(strOuterHTML);
						}
						blnSet = true;
					}
					if (blnSetSync == false) {
						new ElementSetSyncComplete(strOuterHTML);
						blnSetSync = true;
					}
					if (blnAssert == false) {
						new ElementVisible();
						new ElementDisabled();
						blnAssert = true;
					}
					JSONS.getInstance().step.putValue("strStatus", "pass");
					new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					blnStatus = true;
					break;
				}
				strActualResult = "set";
				blnStatus = true;
			} catch (NoSuchWindowException | StaleElementReferenceException | NoSuchElementException | NullPointerException | ExceptionElementNotFound | ExceptionMultipleElementsFound e) {
				blnFound = false;
				strActualResult = "not_found";
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotVisible e) {
				blnVisible = false;
				strActualResult = "not_visible";
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotEnabled e) {
				blnEnabled = false;
				strActualResult = "not_enabled";
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementTagNameNotSupported e) {
				blnExit = true;
				strActualResult = "tag_not_supported";
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionKeywordNotValid e) {
				blnExit = true;
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionVisibleTextNotInSelectList e) {
				blnSet = false;
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotHidden e) {
				blnAssert = false;
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionValueNotMatched e) {
				blnSet = false;
				blnSetSync = false;
				blnAssert = false;
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionElementNotSet e) {
				blnSet = false;
				blnAssert = false;
			} catch (ExceptionElementNotDisabled e) {
				blnAssert = false;
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (ExceptionAlertNotComplete | ExceptionDoPostBackNotComplete | ExceptionJQueryAjaxNotComplete | ExceptionJQueryAnimationNotComplete | ExceptionAngularJsNotComplete | ExceptionPleaseWaitNotComplete e) {
				blnSetSync = false;
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} catch (Exception e) {
				blnAssert = false;
				blnEnabled = false;
				blnFound = false;
				blnSet = false;
				blnSetSync = false;
				blnVisible = false;
				strActualResult = "exception";
				Logger.getInstance().add("elementSetSync: " + e.toString() + "  Milliseconds Waited = " + (System.currentTimeMillis() - lngTimeStart));
			} finally {
				JSONS.getInstance().step.putValue("strStepActual", strActualResult);
				if (Finally.sync(blnExit, blnStatus, blnFound, "elementSetSync", "set", lngTimeStart) == true) {
					if (blnStatus == false) {
						new CoordinateHighlightScreenshot(JSONS.getInstance().step);
					}
					Logger.getInstance().add("elementSetSync: strOutputValue = " + JSONS.getInstance().step.getString("strOutputValue"));
					if (JSONS.getInstance().step.verifyEquals("strOutputValue", "")) {
						JSONS.getInstance().step.putValue("strOutputValue", JSONS.getInstance().step.getString("strInputValue"));
					}
					Logger.getInstance().add("elementSetSync: strOutputValue after = " + JSONS.getInstance().step.getString("strOutputValue"));
					return;
				}
			}
		}
	}
}
