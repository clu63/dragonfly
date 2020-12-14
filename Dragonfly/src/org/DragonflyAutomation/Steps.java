package org.DragonflyAutomation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.JsonArray;

class Steps {
	private static volatile Steps instance = null;
	//private String strKeys1 = "strAction|strLogicalName|strTagName|strAttributeNames|strAttributeValues|strInputValue|strAssert|blnOptional|blnExitOnFail";
	//private String strKeys2 = "|intMillisecondsToWait|strFunction|strOutputLinkName|strLoopOrIf|blnPleaseWait|blnHighlight|blnScreenshot|strAssistiveProperties|strOutputValue";
	//private String strKeys3 = "intBrowserInnerWidth|intBrowserInnerHeight|intBrowserOuterX|intBrowserOuterY|intBrowserOuterWidth|intBrowserOuterHeight";
	//private String strKeys4 = "|intElementScreenX|intElementScreenY|intElementX|intElementY|intElementWidth|intElementHeight|strTagType|strType|strCurrentWindowHandle";
	//private String strKeys5 = "|strURL|strStepExpected|strStepActual|strStartTimestamp|strEndTimestamp|strStepDuration|strScreenshotArea|strHighlightArea|strScreenshotFilePath|strStatus|strTestModuleStep";
	//private String strKeysDefault = "intMillisecondsToWait|blnOptional|strAssert|blnExitOnFail|blnPleaseWait|blnHighlight|blnScreenshot|strScreenshotArea|strStatus";
	private int iterator = -1;
	private JsonArray jsonArray;
	private JSONObject jsonObject;
	//private int key;

	private Steps() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static Steps getInstance() {
		if (instance == null) {
			instance = new Steps();
			synchronized (Steps.class) {
				if (instance == null) {
					instance = new Steps();
				}
			}
		}
		return instance;
	}

	Boolean getValueBoolean(String key) {
		return Boolean.parseBoolean(this.jsonObject.get(key).toString());
	}

	Integer getValueInteger(String key) {
		if (this.jsonObject.get(key).equals("")) {
			return 0;
		}
		return Integer.parseInt(this.jsonObject.get(key).toString());
	}

	String getValueString(String key) {
		return (String) this.jsonObject.get(key);
	}

	void nextStep() {
		if (iterator < this.countSteps()) {
			iterator++;
			try {
				this.jsonObject = (JSONObject) new JSONParser().parse(jsonArray.get(iterator).toString());
				//new StepSetupDefaults(strCurrentWindowHandle);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void setValue(String key, boolean value) {
		this.jsonObject.put(key, Boolean.toString(value));
	}

	void setValue(String key, int value) {
		this.jsonObject.put(key, Integer.toString(value));
	}

	void setValue(String key, String value) {
		this.jsonObject.put(key, value);
	}

	Integer countSteps() {
		return jsonArray.size();
	}

	void setSteps() {
	}

	void setOutPutLink() {
		//if (gobjectStep.getString("strOutputLinkName").trim().length() != 0) {
		//	gobjectLinks.putValue(gobjectStep.getString("strOutputLinkName"), gobjectStep.getString("strOutputValue"));
		//}
		if (this.getValueString("strOutputLinkName").trim().length() != 0) {
			//gobjectLinks.putValue(gobjectStep.getString("strOutputLinkName"), this.getValueString("strOutputValue"));
		}
	}
}
