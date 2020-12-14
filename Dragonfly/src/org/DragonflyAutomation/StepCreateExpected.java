package org.DragonflyAutomation;

class StepCreateExpected {
	StepCreateExpected() {
		Logger.getInstance().add("  ==start==>StepCreateExpected " + Util.getDateTimestamp());
		String strStepExpected = "";
		String strAction = "";
		String strInputValue = Config.getInstance().originalInputValue;
		String strMillisecondsToWait = JSONS.getInstance().step.getString("intMillisecondsToWait");
		String strObjectName = Config.getInstance().originalAttributes;
		String strTagName = JSONS.getInstance().step.getString("strTagName");
		String strAssert = JSONS.getInstance().step.getString("strAssert");
		String strMillisecondsToWaitHtml = " within {<b>" + strMillisecondsToWait + "</b>} milliseconds.";
		String strTagAttributesHtml = " {<b>" + strTagName + "</b>} tag with attributes {<b>" + strObjectName + "</b>}";
		String strInputValueHtml = " {<b>" + strInputValue + "</b>}";
		String strAssertHtml = " assert {<b>" + strAssert + "</b>}";
		Logger.getInstance().add("stepCreateExpected: strStepExpected length = " + JSONS.getInstance().step.getString("strStepExpected").length());
		try {
			if (JSONS.getInstance().step.getString("strStepExpected").length() != 0) {
				strAction = JSONS.getInstance().step.getString("strStepExpected");
			} else {
				strAction = JSONS.getInstance().step.getString("strAction");
			}
			Logger.getInstance().add("stepCreateExpected: strAction = " + strAction);
			switch (strAction.toLowerCase()) {
			case "break":
				strStepExpected = "Break the execution.";
				break;
			case "click":
				strStepExpected = "Click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "close":
				strStepExpected = "Close {<b>" + strTagName + "</b>} browser" + strMillisecondsToWaitHtml;
				break;
			case "double_click":
				strStepExpected = "Double click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "drag":
				strStepExpected = "Drag" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "drop":
				strStepExpected = "Drop" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "get":
				strStepExpected = "Get" + strTagAttributesHtml + " value" + strMillisecondsToWaitHtml;
				//strStepExpected = "Get" + strMillisecondsToWaitHtml + " value" + strMillisecondsToWaitHtml;
				Logger.getInstance().add("stepCreateExpected: get strStepExpected = " + strStepExpected);
				break;
			case "kill_ie":
				strStepExpected = "The action kill_ie killed all IE processes.";
				break;
			case "launch":
				strStepExpected = "Launch {<b>" + strTagName + "</b>} browser to url" + strInputValueHtml + strMillisecondsToWaitHtml;
				break;
			case "mouse_out":
				strStepExpected = "Mouse out" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "mouse_over":
				strStepExpected = "Mouse over" + strTagAttributesHtml + strMillisecondsToWaitHtml;
				break;
			case "refresh":
				strStepExpected = "Refresh the browser" + strMillisecondsToWaitHtml;
				break;
			case "right_click":
				strStepExpected = "Right click" + strTagAttributesHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "scroll":
				strStepExpected = "Scroll the" + strTagAttributesHtml + " into view" + strMillisecondsToWaitHtml;
				break;
			case "select":
				strStepExpected = "Select" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "set":
				strStepExpected = "Set" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "set_js":
				strStepExpected = "Set" + strTagAttributesHtml + " to value" + strInputValueHtml + " and" + strAssertHtml + strMillisecondsToWaitHtml;
				break;
			case "sleep":
				strStepExpected = "Sleep execution for" + strInputValueHtml + " milliseconds.";
				break;
			case "sync_disabled":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is disabled" + strMillisecondsToWaitHtml;
				break;
			case "sync_enabled":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is enabled" + strMillisecondsToWaitHtml;
				break;
			case "sync_hidden":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is hidden" + strMillisecondsToWaitHtml;
				break;
			case "sync_visible":
				strStepExpected = "Sync until" + strTagAttributesHtml + " is visible" + strMillisecondsToWaitHtml;
				break;
			case "verify":
				strStepExpected = "Verify" + strTagAttributesHtml + " value is equal to" + strInputValueHtml + strMillisecondsToWaitHtml;
				break;
			case "verify_not":
				strStepExpected = "Verify" + strTagAttributesHtml + " value is not equal to" + strInputValueHtml + strMillisecondsToWaitHtml;
				break;
			default:
				strStepExpected = strAction;
				break;
			}
			strStepExpected = "<DIV align='left'><font size='5'>" + strStepExpected + "</font></DIV>";
			StepsManual.getInstance().set(Util.removeTags(strStepExpected));
			JSONS.getInstance().step.putValue("strStepExpected", strStepExpected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.getInstance().add("stepCreateExpected:Exception " + e.toString());
		}
	}
}
