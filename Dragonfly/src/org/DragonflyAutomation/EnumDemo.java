package org.DragonflyAutomation;

class EnumDemo {
	public static void main(String[] args) throws Exception {
		System.out.println(" lists of constants");
		EnumKeywordAttributeValues keywordAttributeValues[] = EnumKeywordAttributeValues.values();
		for (EnumKeywordAttributeValues keywordAttributeValue : keywordAttributeValues) {
			System.out.println(keywordAttributeValue + " " + keywordAttributeValue.getKeyword() + " " + keywordAttributeValue.getKeywordValue());
		}
		System.out.println();
		EnumKeywordAttributeValues valueOfKeywordAttributeValue = EnumKeywordAttributeValues.valueOf("STARTS");
		System.out.println("valueOf \"STARTS\": " + valueOfKeywordAttributeValue + " " + valueOfKeywordAttributeValue.getKeyword() + " " + valueOfKeywordAttributeValue.getKeywordValue());
	}
}
