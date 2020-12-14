package org.DragonflyAutomation;

class StepNames {
	private String strKeys1 = "strAction|strLogicalName|strTagName|strAttributeNames|strAttributeValues|strInputValue|strAssert|blnOptional|blnExitOnFail";
	private String strKeys2 = "|intMillisecondsToWait|strFunction|strOutputLinkName|strLoopOrIf|blnPleaseWait|blnHighlight|blnScreenshot|strAssistiveProperties|strOutputValue";
	private String strKeys3 = "intBrowserInnerWidth|intBrowserInnerHeight|intBrowserOuterX|intBrowserOuterY|intBrowserOuterWidth|intBrowserOuterHeight";
	private String strKeys4 = "|intElementScreenX|intElementScreenY|intElementX|intElementY|intElementWidth|intElementHeight|strTagType|strType|strCurrentWindowHandle";
	private String strKeys5 = "|strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strHighlightArea|strScreenshotFilePath|strStatus|strTestModuleStep";
	private String strKeysDefault = "intMillisecondsToWait|blnOptional|strAssert|blnExitOnFail|blnPleaseWait|blnHighlight|blnScreenshot|strScreenshotArea|strStatus";
	private StringBuilder objStringBuilder = new StringBuilder();

	String[] getComplete() {
		objStringBuilder.append(strKeys1);
		objStringBuilder.append(strKeys2);
		objStringBuilder.append("|");
		objStringBuilder.append(strKeys3);
		objStringBuilder.append(strKeys4);
		objStringBuilder.append(strKeys5);
		return objStringBuilder.toString().split("\\|");
	}

	String[] getDefault() {
		return strKeysDefault.toString().split("\\|");
	}

	String[] getOriginal() {
		objStringBuilder.append(strKeys1);
		objStringBuilder.append(strKeys2);
		return objStringBuilder.toString().split("\\|");
	}

	String[] getRuntime() {
		objStringBuilder.append(strKeys3);
		objStringBuilder.append(strKeys4);
		objStringBuilder.append(strKeys5);
		return objStringBuilder.toString().split("\\|");
	}
}
