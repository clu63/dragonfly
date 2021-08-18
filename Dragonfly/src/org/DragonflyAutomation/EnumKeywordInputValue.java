package org.DragonflyAutomation;

enum EnumKeywordInputValue {
	RE("<re> ", "re "),
	TD("<td> ", "td "),
	TI("<ti> ", "ti "),
	TL("<tl> ", "tl "),
	CLICK("<click> ", "click "),
	DOUBLECLICK("<doubleclick> ", "doubleclick "),
	RIGHTCLICK("<rightclick> ", "rightclick "),
	ON("<on> ", "on "),
	OFF("<off> ", "off "),
	BLANK("<blank> ", "blank "),
	FIRST("<first> ", "first "),
	SECOND("<second> ", "second "),
	THIRD("<third> ", "third "),
	LAST("<last> ", "last "),
	RANDOM("<random> ", "random "),
	CONTAINS("<contains> ", "contains "),
	ENDS("<ends> ", "ends "),
	STARTS("<starts> ", "starts "),
	SKIP("<skip>", "skip");
	private final String keyword;
	private final String keywordValue;

	private EnumKeywordInputValue(String keyword, String keywordValue) {
		this.keyword = keyword;
		this.keywordValue = keywordValue;
	}

	public String getKeyword() {
		return keyword;
	}
}
