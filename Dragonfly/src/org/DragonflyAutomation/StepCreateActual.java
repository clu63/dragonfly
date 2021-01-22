package org.DragonflyAutomation;

//TODO start here alpabetically to check new step Actual
class StepCreateActual {
	StepCreateActual(String strStepType) {
		Logger.getInstance().add("  ==start==>stepCreateActual " + Util.getDateTimestamp());
		String intWaited = JSONS.getInstance().step.getString("strStepDuration");
		String strActualHtml = "";
		String strActualText = "";
		String strInputValue = JSONS.getInstance().step.getString("strInputValue");
		Logger.getInstance().add("stepCreateActual strStepType.toLowerCase() = " + strStepType.toLowerCase());
		String strOutputValue = JSONS.getInstance().step.getString("strOutputValue");
		String strTagName = JSONS.getInstance().step.getString("strTagName");
		String strObjectName = ObjectName.create();
		String strTagAttributesHtml = "The {<b>" + strTagName + "</b>} tag with attributes {<b>" + strObjectName + "</b>}";
		String strMsWaitedDetailHtml = " after {<b>" + intWaited + "</b>} milliseconds.";
		String strHtmlFailStart = "{<b><FONT COLOR='FF0000'>";
		String strHtmlPassStart = "{<b><FONT COLOR='008000'>";
		String strHtmlEnd = "</FONT></b>}";
		String strInputValueHtmlPass = " value " + strHtmlPassStart + strInputValue + strHtmlEnd;
		String strOutputValueHtmlPass = " value " + strHtmlPassStart + strOutputValue + strHtmlEnd;
		String strOutputValueHtmlFail = " " + strHtmlFailStart + strOutputValue + strHtmlEnd;
		Logger.getInstance().add("stepCreateActual strStepActual = " + JSONS.getInstance().step.getString("strStepActual"));
		strStepType = JSONS.getInstance().step.getString("strStepActual");
		Logger.getInstance().add("stepCreateActual strStepType.toLowerCase() = " + strStepType.toLowerCase());
		try {
			switch (strStepType.toLowerCase()) {
			case "assert":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " persisted" + strMsWaitedDetailHtml;
				break;
			case "assert_failed":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " did not persist" + strMsWaitedDetailHtml + "<BR>The actual value" + strOutputValueHtmlFail + " was displayed.";
				break;
			case "break":
				strActualHtml = "Take a break.";
				break;
			case "browser_close":
				strActualHtml = "The {<b>" + strTagName + "</b>} browser was closed" + strMsWaitedDetailHtml;
				break;
			case "browser_launch":
				strActualHtml = "The {<b>" + strTagName + "</b>} browser navigated to url" + strInputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "browser_refresh":
				strActualHtml = "The {<b>" + strTagName + "</b>} browser navigated to url" + strInputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "clicked":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was clicked" + strMsWaitedDetailHtml;
				break;
			case "default":
				strActualHtml = strTagAttributesHtml + " default" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "drag":
				strActualHtml = strTagAttributesHtml + " was dragged" + strMsWaitedDetailHtml;
				break;
			case "drop":
				strActualHtml = strTagAttributesHtml + " was dropped" + strMsWaitedDetailHtml;
				break;
			case "expected":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was not verified" + strMsWaitedDetailHtml + "<BR>The actual value was" + strOutputValueHtmlFail + ".";
				break;
			case "get":
				strActualHtml = strTagAttributesHtml + " actual value is" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
				Logger.getInstance().add("stepCreateActual get strActualHtml = " + strActualHtml);
				break;
			case "keystroke":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " key was pressed" + strMsWaitedDetailHtml;
				break;
			case "kill_ie":
				strActualHtml = "The action kill_ie killed all IE processes was executed.";
				break;
			case "mouse_out":
				strActualHtml = strTagAttributesHtml + " mouse out is complete" + strMsWaitedDetailHtml;
				break;
			case "mouse_over":
				strActualHtml = strTagAttributesHtml + " mouse over is complete" + strMsWaitedDetailHtml;
				break;
			case "navigate":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was set" + strMsWaitedDetailHtml + "<BR>No validation performed due to navigation.";
				break;
			case "not_closed":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlFail + " did not close" + strMsWaitedDetailHtml;
				break;
			case "not_disabled":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "enabled" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_enabled":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "disabled" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_exist_tooltip":
				strActualHtml = strTagAttributesHtml + " tooltip does not exist" + strMsWaitedDetailHtml;
				break;
			case "not_found":
				strActualHtml = strTagAttributesHtml + " was" + strHtmlFailStart + "not found" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_hidden":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "visible" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "not_in_list":
				strActualHtml = strTagAttributesHtml + "The list item " + strInputValueHtmlPass + " does not exist in the list field" + strMsWaitedDetailHtml + "<BR>Please confirm the input value against the actual list values " + strOutputValueHtmlFail + " is available for this field.";
				break;
			case "not_visible":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlFailStart + "hidden" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "scroll":
				strActualHtml = strTagAttributesHtml + strMsWaitedDetailHtml;
				break;
			case "secure":
				strActualHtml = strTagAttributesHtml + " password value" + strOutputValueHtmlPass + " was set" + strMsWaitedDetailHtml;
				break;
			case "set":
				strActualHtml = strTagAttributesHtml + strInputValueHtmlPass + " was set" + strMsWaitedDetailHtml;
				break;
			case "skip":
				strActualHtml = "The skip keyword was entered in the strInputValue field causing this step to be skipped.";
				break;
			case "sleep":
				strActualHtml = "The execution sleep is complete " + strMsWaitedDetailHtml;
				break;
			case "sync_closed":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " closed" + strMsWaitedDetailHtml;
				break;
			case "sync_disabled":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "disabled" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "sync_enabled":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "enabled" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "sync_hidden":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "hidden" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "sync_optional":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " sync is optional" + strMsWaitedDetailHtml;
				break;
			case "sync_visible":
				strActualHtml = strTagAttributesHtml + " is " + strHtmlPassStart + "visible" + strHtmlEnd + strMsWaitedDetailHtml;
				break;
			case "tag_not_supported":
				strActualHtml = strTagAttributesHtml + " is not supported";
				break;
			case "tooltip_expected":
				strActualHtml = strTagAttributesHtml + " tooltip" + strInputValueHtmlPass + " was not verified." + strMsWaitedDetailHtml + "<BR>The actual value was " + strOutputValueHtmlFail + ".";
				break;
			case "tooltip_get":
				strActualHtml = strTagAttributesHtml + " tooltip actual value is" + strOutputValueHtmlPass + strMsWaitedDetailHtml;
				break;
			case "tooltip_verify":
				strActualHtml = strTagAttributesHtml + " tooltip" + strOutputValueHtmlPass + " was verified" + strMsWaitedDetailHtml;
				break;
			case "verify_not":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was not verified" + strMsWaitedDetailHtml;
				break;
			case "verify_value":
				strActualHtml = strTagAttributesHtml + strOutputValueHtmlPass + " was verified" + strMsWaitedDetailHtml;
				break;
			default:
				strActualHtml = "<b><FONT COLOR='#FF69B4'>" + "StepType {" + strStepType + "} is not supported" + "</FONT></b>";
				break;
			}
			strActualHtml = "<DIV align='left'><font size='5'>" + strActualHtml + "</font></DIV>";
			strActualText = Util.removeTags(strActualHtml);
			Logger.getInstance().add("StepCreateActual: strActualText = " + strActualText);
			JSONS.getInstance().step.putValue("strStepActual", strActualHtml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.getInstance().add("stepCreateActual:Exception " + e.toString());
		}
	}
}
