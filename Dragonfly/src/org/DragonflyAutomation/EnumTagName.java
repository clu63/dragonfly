package org.DragonflyAutomation;

enum EnumTagName {
	CHROME("chrome"),
	FIREFOX("firefox"),
	IE("ie"),
	OPERA("opera"),
	SAFARI("safari"),
	A("a"),
	ALERT("alert"),
	BODY("body"),
	BUTTON("button"),
	DIV("div"),
	H1("h1"),
	H2("h2"),
	H3("h3"),
	H4("h4"),
	H5("h5"),
	H6("h6"),
	IMG("img"),
	INPUT("input"),
	LI("li"),
	P("p"),
	SELECT("select"),
	SPAN("span"),
	TABLE("table"),
	TD("td"),
	TEXTAREA("textarea"),
	TH("th"),
	TITLE("title"),
	TR("tr");
	private final String tagNameOption;

	private EnumTagName(String tagNameOption) {
		this.tagNameOption = tagNameOption;
	}

	String getTagName() {
		return tagNameOption;
	}
}
