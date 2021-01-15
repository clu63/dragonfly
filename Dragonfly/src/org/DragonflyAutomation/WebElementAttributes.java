package org.DragonflyAutomation;

class WebElementAttributes {
	WebElementAttributes() {
		Logger.getInstance().add("  ==start==>WebElementAttributes " + Util.getDateTimestamp());
		Logger.getInstance().add("text:=  " + Element.getInstance().element.getTagName());
		Logger.getInstance().add("tag_type:=  " + Element.getInstance().element.getTagName() + "_" + Element.getInstance().element.getAttribute("type"));
		Logger.getInstance().add("TagName:=  " + Element.getInstance().element.getAttribute("TagName"));
		Logger.getInstance().add("type:=  " + Element.getInstance().element.getAttribute("type"));
		Logger.getInstance().add("id:=  " + Element.getInstance().element.getAttribute("id"));
		Logger.getInstance().add("name:=  " + Element.getInstance().element.getAttribute("name"));
		Logger.getInstance().add("text:=  " + Element.getInstance().element.getAttribute("text"));
		Logger.getInstance().add("innerText:=  " + Element.getInstance().element.getAttribute("innerText"));
		Logger.getInstance().add("outerText:=  " + Element.getInstance().element.getAttribute("outerText"));
		Logger.getInstance().add("innerHTML:=  " + Element.getInstance().element.getAttribute("innerHTML"));
		Logger.getInstance().add("outerHTML:=  " + Element.getInstance().element.getAttribute("outerHTML"));
		Logger.getInstance().add("uniqueID:=  " + Element.getInstance().element.getAttribute("uniqueID"));
		Logger.getInstance().add("class:=  " + Element.getInstance().element.getAttribute("class"));
		Logger.getInstance().add("type:=  " + Element.getInstance().element.getAttribute("type"));
		Logger.getInstance().add("TYPE:=  " + Element.getInstance().element.getAttribute("TYPE"));
		Logger.getInstance().add("href:=  " + Element.getInstance().element.getAttribute("href"));
		Logger.getInstance().add("NameProp:=  " + Element.getInstance().element.getAttribute("NameProp"));
		Logger.getInstance().add("isDisplayed:=  " + Element.getInstance().element.isDisplayed());
		Logger.getInstance().add("name:=  " + Element.getInstance().element.isEnabled());
		Logger.getInstance().add("getLocation().x:=  " + Element.getInstance().element.getLocation().x);
		Logger.getInstance().add("getLocation().y:=  " + Element.getInstance().element.getLocation().y);
		Logger.getInstance().add("getSize().height:=  " + Element.getInstance().element.getSize().height);
		Logger.getInstance().add("getLocation().y:=  " + Element.getInstance().element.getSize().width);
		Logger.getInstance().add("src:=  " + Element.getInstance().element.getAttribute("src"));
	}
}
