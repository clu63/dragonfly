package org.DragonflyAutomation;

enum EnumKeywordLoopOrIf {
	IF("<if>", "if"),
	ELSEIF("<elseif>", "elseif"),
	ELSE("<else>", "else"),
	ENDIF("<endif>", "endif"),
	LOOPSTART("<loopstart>", "loopstart"),
	LOOPEXIT("<loopexit>", "loopexit"),
	LOOPEND("<loopend>", "loopend");
	private final String keyword;
	private final String keywordValue;

	private EnumKeywordLoopOrIf(String keyword, String keywordValue) {
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
