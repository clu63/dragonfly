//package org.DragonflyAutomation;
//
//import java.util.Arrays;
//import java.util.Collections;
//import org.DragonflyAutomation.Dragonfly.ExceptionJSONKeyNotPresent;
//import org.DragonflyAutomation.Dragonfly.StepNames;
//
//class KeywordsValid{
//	//TODO KeywordsValid to check all
//	private String[] arrKV_strLogicalName = { "<te>" };
//	private String[] arrKV_strAttributeValues = { "<contains>", "<starts>", "<td>", "<ti>", "<tl>" };
//	private String[] arrKV_strInputValue = { "<re>", "<td>", "<ti>", "<tl>", "<click>", "<doubleclick>", "<rightclick>", "<on>", "<off>", "<blank>", "<first>", "<second>", "<third>", "<last>", "<random>", "<contains>", "<ends>", "<starts>", "<skip>" };
//	private String[] arrKV_strLoopOrIf = { "<if>", "<elseif>", "<else>", "<endif>", "<loopstart>", "<loopexit>", "<loopend>" };
//	private String[] arrResults;
//	private String strInputValueFromJson = "";
//	private String strKeywordEach = "";
//	private String strKeywordValue = "";
//
//	KeywordsValid(Dragonfly objDragonfly) {
//		String[] arrKeys = objDragonfly.new StepNames().getOriginal();
//		boolean blnValid = false;
//		String[] arrKeywordsValid;
//		Dragonfly.gstrOriginalAttributes = Dragonfly.createObjectName();
//		for (String strKey : arrKeys) {
//			switch (strKey) {
//			case "strAction":
//			case "strTagName":
//			case "strAttributeNames":
//			case "strAssert":
//			case "blnOptional":
//			case "blnExitOnFail":
//			case "intMillisecondsToWait":
//			case "strFunction":
//			case "strOutputLinkName":
//			case "blnPleaseWait":
//			case "blnHighlight":
//			case "blnScreenshot":
//			case "strAssistiveProperties":
//			case "strOutputValue":
//				this.getKeywordsAndValue(Dragonfly.gobjectStep.getString(strKey));
//				// 		if (arrResults.length > 0) {
//				// 			gobjectStep.putValue("strStatus", "fail");
//				// 			gobjectStep.putValue("blnExitOnFail", "true");
//				// 		}
//				break;
//			case "strLogicalName":
//				this.getKeywordsAndValue(Dragonfly.gobjectStep.getString(strKey));
//				for (String strResultsEach : arrResults) {
//					for (String strKeywordsValidEach : arrKV_strLogicalName) {
//						if (strResultsEach.equals(strKeywordsValidEach)) {
//							blnValid = true;
//							JSON objJsonObjectElementNode = new JSON(Dragonfly.gobjectElement.getNode(strKeywordValue));
//							try {
//								Dragonfly.gobjectStep.putValue("strTagName", objJsonObjectElementNode.getValue("strTagName", ""));
//								Dragonfly.gobjectStep.putValue("strAttributeNames", objJsonObjectElementNode.getValue("strAttributeNames", ""));
//								Dragonfly.gobjectStep.putValue("strAttributeValues", objJsonObjectElementNode.getValue("strAttributeValues", ""));
//							} catch (ExceptionJSONKeyNotPresent e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							break;
//						}
//					}
//				}
//				break;
//			case "strAttributeValues":
//				String strKeywordValueCombined = "";
//				String arrAttributeValues[] = Dragonfly.gobjectStep.getString(strKey).split("\\|", -1);
//				for (String strAttributeValuesEach : arrAttributeValues) {
//					this.getKeywordsAndValue(strAttributeValuesEach);
//					for (String strResultsEach : arrResults) {
//						// Logger.getInstance().add("strResultsEach = " + strResultsEach);
//						// Logger.getInstance().add("strKeywordValue = " + strKeywordValue);
//						for (String strKeywordsValidEach : arrKV_strAttributeValues) {
//							if (strResultsEach.equals(strKeywordsValidEach)) {
//								blnValid = true;
//								this.getJsonValue(strKeywordEach, strKeywordValue);
//								strKeywordValue = strInputValueFromJson;
//								break;
//							}
//						}
//					}
//					if (strKeywordValueCombined.trim().length() == 0) {
//						strKeywordValueCombined = strKeywordValue;
//					} else {
//						strKeywordValueCombined = strKeywordValueCombined + "|" + strKeywordValue;
//					}
//				}
//				Dragonfly.gobjectStep.putValue("strAttributeValues", strKeywordValueCombined);
//				break;
//			case "strInputValue":
//				Dragonfly.gstrOriginalInputValue = Dragonfly.gobjectStep.getString(strKey);
//				this.getKeywordsAndValue(Dragonfly.gobjectStep.getString(strKey));
//				for (String strResultsEach : arrResults) {
//					for (String strKeywordsValidEach : arrKV_strInputValue) {
//						if (strResultsEach.equals(strKeywordsValidEach)) {
//							blnValid = true;
//							this.getJsonValue(strResultsEach, strKeywordValue);
//							strKeywordValue = strInputValueFromJson;
//							break;
//						}
//					}
//				}
//				Logger.getInstance().add("KeywordsValid: blnValid = " + blnValid);
//				Dragonfly.gobjectStep.putValue("strInputValue", strKeywordValue);
//				// Logger.getInstance().add("strKeywordValue = " + strKeywordValue);
//				// Logger.getInstance().add("strInputValueFromJson = " + strInputValueFromJson);
//				break;
//			case "strLoopOrIf":
//				break;
//			}
//		}
//	}
//
//	private void getJsonValue(String strKeyword, String strInputValue) {
//		Logger.getInstance().add("getJsonValue strKeyword = " + strKeyword);
//		Logger.getInstance().add("getJsonValue strInputValue = " + strInputValue);
//		try {
//			switch (strKeyword) {
//			case "<td>":
//				strInputValueFromJson = Dragonfly.gobjectTestData.getValue(strInputValue, "<td>");
//				break;
//			case "<ti>":
//				strInputValueFromJson = Dragonfly.gobjectTestInstancesEach.getValue(strInputValue, "<ti>");
//				break;
//			case "<tl>":
//				strInputValueFromJson = Dragonfly.gobjectLinks.getValue(strInputValue, "<tl>");
//				break;
//			case "<re>":
//				strInputValueFromJson = strInputValue;
//				break;
//			case "<skip>":
//				strInputValueFromJson = "<skip>";
//				break;
//			default:
//				strInputValueFromJson = strKeyword + strInputValue;
//				break;
//			}
//		} catch (ExceptionJSONKeyNotPresent e) {
//			// TODO Auto-generated catch block
//			Logger.getInstance().add("StepSetupDefaults: Exception = " + e.toString());
//		}
//	}
//
//	private void getKeywordsAndValue(String strValueToFindKeyword) {
//		String strKeyword = "";
//		String strKeywordCombined = "";
//		int intLeftArrowPositionEach = 0;
//		int intLeftArrowPosition = -1;
//		int intRightArrowPosition = -1;
//		int intKeywordCount = strValueToFindKeyword.length() - strValueToFindKeyword.replace("<", "").length();
//		strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
//		for (int intKeywordEach = 0; intKeywordEach < intKeywordCount; intKeywordEach++) {
//			intLeftArrowPositionEach = intLeftArrowPosition + 1;
//			intLeftArrowPosition = strValueToFindKeyword.indexOf("<", intLeftArrowPositionEach);
//			intRightArrowPosition = strValueToFindKeyword.indexOf(">", intLeftArrowPosition);
//			if (intLeftArrowPosition > -1) {
//				strKeyword = strValueToFindKeyword.substring(intLeftArrowPosition, intRightArrowPosition + 1).toLowerCase();
//				strKeywordValue = strValueToFindKeyword.substring(intRightArrowPosition + 1, strValueToFindKeyword.length());
//				if (strKeyword.equals("<re>") || strKeyword.equals("<contains>") || strKeyword.equals("<starts>")) {
//					strKeywordValue = strKeyword + strKeywordValue;
//				}
//				Logger.getInstance().add("getKeywordsAndValue strKeyword = " + strKeyword);
//				if (strKeywordCombined.length() == 0) {
//					strKeywordCombined = strKeyword;
//				} else {
//					strKeywordCombined = strKeywordCombined + "|" + strKeyword;
//				}
//			}
//		}
//		arrResults = strKeywordCombined.split("\\|");
//		Collections.reverse(Arrays.asList(arrResults));
//	}
//}