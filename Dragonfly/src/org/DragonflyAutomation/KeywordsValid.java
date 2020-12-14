package org.DragonflyAutomation;

import java.util.Arrays;
import java.util.Collections;

class KeywordsValid {
	//TODO KeywordsValid to check all
	private String[] arrKV_strLogicalName = { "<te>" };
	private String[] arrKV_strAttributeValues = { "<contains>", "<starts>", "<td>", "<ti>", "<tl>" };
	private String[] arrKV_strInputValue = { "<re>", "<td>", "<ti>", "<tl>", "<click>", "<doubleclick>", "<rightclick>", "<on>", "<off>", "<blank>", "<first>", "<second>", "<third>", "<last>", "<random>", "<contains>", "<ends>", "<starts>", "<skip>" };
	private String[] arrKV_strLoopOrIf = { "<if>", "<elseif>", "<else>", "<endif>", "<loopstart>", "<loopexit>", "<loopend>" };
	private String[] arrResults;
	private String strInputValueFromJson = "";
	private String strKeywordEach = "";
	private String strKeywordValue = "";

	KeywordsValid() {
		String[] arrKeys = new StepNames().getOriginal();
		boolean blnValid = false;
		String[] arrKeywordsValid;
		Config.getInstance().originalAttributes = ObjectName.create();
		for (String strKey : arrKeys) {
			switch (strKey) {
			case "strAction":
			case "strTagName":
			case "strAttributeNames":
			case "strAssert":
			case "blnOptional":
			case "blnExitOnFail":
			case "intMillisecondsToWait":
			case "strFunction":
			case "strOutputLinkName":
			case "blnPleaseWait":
			case "blnHighlight":
			case "blnScreenshot":
			case "strAssistiveProperties":
			case "strOutputValue":
				this.getKeywordsAndValue(JSONS.getInstance().step.getString(strKey));
				// 		if (arrResults.length > 0) {
				// 			JSONS.getInstance().step.putValue("strStatus", "fail");
				// 			JSONS.getInstance().step.putValue("blnExitOnFail", "true");
				// 		}
				break;
			case "strLogicalName":
				this.getKeywordsAndValue(JSONS.getInstance().step.getString(strKey));
				for (String strResultsEach : arrResults) {
					for (String strKeywordsValidEach : arrKV_strLogicalName) {
						if (strResultsEach.equals(strKeywordsValidEach)) {
							blnValid = true;
							JSON objJsonObjectElementNode = new JSON(JSONS.getInstance().element.getNode(strKeywordValue));
							try {
								JSONS.getInstance().step.putValue("strTagName", objJsonObjectElementNode.getValue("strTagName", ""));
								JSONS.getInstance().step.putValue("strAttributeNames", objJsonObjectElementNode.getValue("strAttributeNames", ""));
								JSONS.getInstance().step.putValue("strAttributeValues", objJsonObjectElementNode.getValue("strAttributeValues", ""));
							} catch (ExceptionJSONKeyNotPresent e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
					}
				}
				break;
			case "strAttributeValues":
				String strKeywordValueCombined = "";
				String arrAttributeValues[] = JSONS.getInstance().step.getString(strKey).split("\\|", -1);
				for (String strAttributeValuesEach : arrAttributeValues) {
					this.getKeywordsAndValue(strAttributeValuesEach);
					for (String strResultsEach : arrResults) {
						// Logger.getInstance().add("strResultsEach = " + strResultsEach);
						// Logger.getInstance().add("strKeywordValue = " + strKeywordValue);
						for (String strKeywordsValidEach : arrKV_strAttributeValues) {
							if (strResultsEach.equals(strKeywordsValidEach)) {
								blnValid = true;
								this.getJsonValue(strKeywordEach, strKeywordValue);
								strKeywordValue = strInputValueFromJson;
								break;
							}
						}
					}
					if (strKeywordValueCombined.trim().length() == 0) {
						strKeywordValueCombined = strKeywordValue;
					} else {
						strKeywordValueCombined = strKeywordValueCombined + "|" + strKeywordValue;
					}
				}
				JSONS.getInstance().step.putValue("strAttributeValues", strKeywordValueCombined);
				break;
			case "strInputValue":
				Config.getInstance().originalInputValue = JSONS.getInstance().step.getString(strKey);
				this.getKeywordsAndValue(JSONS.getInstance().step.getString(strKey));
				for (String strResultsEach : arrResults) {
					for (String strKeywordsValidEach : arrKV_strInputValue) {
						if (strResultsEach.equals(strKeywordsValidEach)) {
							blnValid = true;
							this.getJsonValue(strResultsEach, strKeywordValue);
							strKeywordValue = strInputValueFromJson;
							break;
						}
					}
				}
				Logger.getInstance().add("KeywordsValid: blnValid = " + blnValid);
				JSONS.getInstance().step.putValue("strInputValue", strKeywordValue);
				// Logger.getInstance().add("strKeywordValue = " + strKeywordValue);
				// Logger.getInstance().add("strInputValueFromJson = " + strInputValueFromJson);
				break;
			case "strLoopOrIf":
				break;
			}
		}
	}

	private void getJsonValue(String strKeyword, String strInputValue) {
		Logger.getInstance().add("getJsonValue strKeyword = " + strKeyword);
		Logger.getInstance().add("getJsonValue strInputValue = " + strInputValue);
		try {
			switch (strKeyword) {
			case "<td>":
				strInputValueFromJson = JSONS.getInstance().testData.getValue(strInputValue, "<td>");
				break;
			case "<ti>":
				strInputValueFromJson = JSONS.getInstance().testInstancesEach.getValue(strInputValue, "<ti>");
				break;
			case "<tl>":
				strInputValueFromJson = JSONS.getInstance().links.getValue(strInputValue, "<tl>");
				break;
			case "<re>":
				strInputValueFromJson = strInputValue;
				break;
			case "<skip>":
				strInputValueFromJson = "<skip>";
				break;
			default:
				strInputValueFromJson = strKeyword + strInputValue;
				break;
			}
		} catch (ExceptionJSONKeyNotPresent e) {
			// TODO Auto-generated catch block
			Logger.getInstance().add("StepSetupDefaults: Exception = " + e.toString());
		}
	}

	private void getKeywordsAndValue(String strValueToFindKeyword) {
		String strKeyword = "";
		String strKeywordCombined = "";
		int intLeftArrowPositionEach = 0;
		int intLeftArrowPosition = -1;
		int intRightArrowPosition = -1;
		int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace("<", "").length();
		strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
		for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
			intLeftArrowPositionEach = intLeftArrowPosition + 1;
			intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intLeftArrowPositionEach);
			intRightArrowPosition = strValueToFindKeyword.indexOf(">", intLeftArrowPosition);
			if (intLeftArrowPosition > -1) {
				strKeyword = strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1).toLowerCase();
				strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
				if (strKeyword.equals("<re>") || strKeyword.equals("<contains>") || strKeyword.equals("<starts>")) {
					strKeywordValue = strKeyword + strKeywordValue;
				}
				Logger.getInstance().add("getKeywordsAndValue strKeyword = " + strKeyword);
				if (strKeywordCombined.length() == 0) {
					strKeywordCombined = strKeyword;
				} else {
					strKeywordCombined = strKeywordCombined + "|" + strKeyword;
				}
			}
		}
		arrResults = strKeywordCombined.split("\\|");
		Collections.reverse(Arrays.asList(arrResults));
	}
}