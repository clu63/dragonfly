package org.DragonflyAutomation;

enum EnumAttributeNames {
	XPATH("xpath"),
	ID("id"),
	NAME("name"),
	CLASS("class"),
	INDEX("index"),
	TEXT("text"),
	TYPE("type");
	private final String attributeName;

	private EnumAttributeNames(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeName() {
		return attributeName;
	}
}
