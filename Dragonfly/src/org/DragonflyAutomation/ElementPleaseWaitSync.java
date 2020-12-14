package org.DragonflyAutomation;

class ElementPleaseWaitSync {
	ElementPleaseWaitSync() throws ExceptionElementNotHidden {
		Logger.getInstance().add("  ==start==>ElementPleaseWaitSync " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		Boolean blnPleaseWait = Boolean.parseBoolean(JSONS.getInstance().step.getString("blnPleaseWait"));
		Integer intPleaseWaitEach;
		String strAttributeNames = null;
		String strAttributeValues = null;
		String strTagName = null;
		Boolean blnFound = false;
		String strMessage = "";
		JSON objJsonObjectPleaseWaitNode = new JSON();
		try {
			ElementPleaseWait.getInstance().elementPleaseWait = Element.getInstance().element;
			Logger.getInstance().add("ElementPleaseWaitSync: objectProcessing.size() = " + JSONS.getInstance().processing.size());
			if (blnPleaseWait == true) {
				for (intPleaseWaitEach = 1; intPleaseWaitEach < JSONS.getInstance().processing.size(); intPleaseWaitEach++) {
					objJsonObjectPleaseWaitNode.replaceAllFromJSONObject(JSONS.getInstance().processing.getNode("PleaseWait_" + intPleaseWaitEach));
					try {
						strAttributeNames = objJsonObjectPleaseWaitNode.getValue("strAttributeNames", "");
						strAttributeValues = objJsonObjectPleaseWaitNode.getValue("strAttributeValues", "");
						strTagName = objJsonObjectPleaseWaitNode.getValue("strTagName", "");
						Logger.getInstance().add("ElementPleaseWaitSync: variables = " + strAttributeNames + " " + strAttributeValues + " " + strTagName);
					} catch (ExceptionJSONKeyNotPresent e1) {
						// TODO Auto-generated catch block
						Logger.getInstance().add("ElementPleaseWaitSync: ExceptionJSONKeyNotPresent = " + e1.toString());
					}
					try {
						new ElementFindBy(strAttributeNames, strAttributeValues, strTagName);
						blnFound = true;
						strMessage = "Element found.";
					} catch (ExceptionElementNotFound e) {
						blnFound = false;
						Logger.getInstance().add("ElementPleaseWaitSync: ElementFindBy = blnFound = false Milliseconds Waited = " + (System.currentTimeMillis()));
					} catch (ExceptionMultipleElementsFound e) {
						blnFound = true;
						strMessage = "Multiple elements found.";
						Logger.getInstance().add("ElementPleaseWaitSync: ElementFindBy = blnFound = true Milliseconds Waited = " + (System.currentTimeMillis()));
					}
					if (blnFound == true) {
						if (Element.getInstance().element.isDisplayed() == true) {
							Logger.getInstance().add("ElementPleaseWaitSync: Element.getInstance().element.isDisplayed() = return true Milliseconds Waited = " + (System.currentTimeMillis()));
							//throw new ExceptionElementNotHidden("Element is displayed.");
							blnFound = true;
							strMessage = "Element is displayed.";
						} else {
							blnFound = false;
							Logger.getInstance().add("ElementPleaseWaitSync: Element.getInstance().element.isDisplayed() = return false Milliseconds Waited = " + (System.currentTimeMillis()));
						}
					}
					if (blnFound == true) {
						return;
					}
				}
			}
		} finally {
			Logger.getInstance().add("ElementPleaseWaitSync: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
			Element.getInstance().element = ElementPleaseWait.getInstance().elementPleaseWait;
			if (blnFound == true) {
				throw new ExceptionElementNotHidden(strMessage);
			}
		}
	}
}