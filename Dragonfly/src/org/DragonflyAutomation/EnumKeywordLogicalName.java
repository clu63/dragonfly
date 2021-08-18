package org.DragonflyAutomation;

enum EnumKeywordLogicalName {
	TE("<te>", "te");
	private final String keyword;
	private final String keywordValue;

	private EnumKeywordLogicalName(String keyword, String keywordValue) {
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
