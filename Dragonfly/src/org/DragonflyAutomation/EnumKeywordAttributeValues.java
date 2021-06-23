package org.DragonflyAutomation;

enum EnumKeywordAttributeValues {
	CONTAINS("<contains>", "contains"),
	STARTS("<starts>", "starts"),
	TD("<td>", "td"),
	TI("<ti>", "ti"),
	TL("<tl>", "tl");
	private final String keyword;
	private final String keywordValue;

	private EnumKeywordAttributeValues(String keyword, String keywordValue) {
		this.keyword = keyword;
		this.keywordValue = keywordValue;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getKeywordValue() {
		return keywordValue;
	}
}
