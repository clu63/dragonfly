package org.DragonflyAutomation;

class ObjectName {
	static String create() {
		String attributeValue = "";
		String attributeValues = Util.replaceHtmlArrows(JSONS.getInstance().step.getString("strAttributeValues"));
		String objectsAttributes = "";
		String objectName = "";
		String objectNames = JSONS.getInstance().step.getString("strAttributeNames");
		String[] arrayAttributeValues = attributeValues.split("\\|");
		String[] arrayObjectNames = objectNames.split("\\|");
		for (int intEach = 0; intEach < arrayObjectNames.length; intEach++) {
			objectName = arrayObjectNames[intEach].toString();
			attributeValue = arrayAttributeValues[intEach].toString();
			if (intEach == 0) {
				objectsAttributes = objectName + "=" + attributeValue;
				Logger.getInstance().add("ObjectName.create objectAttribute =" + objectsAttributes);
			} else {
				objectsAttributes = objectsAttributes + "|" + objectName + "=" + attributeValue;
				Logger.getInstance().add("ObjectName.create objectAttribute =" + objectsAttributes);
			}
		}
		return objectsAttributes;
	}
}
