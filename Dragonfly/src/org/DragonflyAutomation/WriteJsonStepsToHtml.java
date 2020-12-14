package org.DragonflyAutomation;

import org.json.simple.JSONArray;

class WriteJsonStepsToHtml {
	WriteJsonStepsToHtml(String strPath, String strStepHeader, JSONArray objTestSteps, String strFileName) {
		Logger.getInstance().add("  ==start==>WriteJsonStepsToHtml " + Util.getDateTimestamp());
		Logger.getInstance().add("WriteJsonStepsToHtml objTestSteps = " + objTestSteps);
		String strKey = "";
		String[] arrKeys = null;
		StepNames objStepNames = new StepNames();
		StringBuilder objStringBuilder = new StringBuilder();
		String strValue = "";
		JSON objStepReport = new JSON();
		switch (strStepHeader) {
		case "original":
			arrKeys = objStepNames.getOriginal();
			break;
		case "complete":
			arrKeys = objStepNames.getComplete();
			break;
		}
		try {
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<head><title> " + strFileName.replace(".html", "") + "</title></head>");
			objStringBuilder.append("<body><h1>");
			objStringBuilder.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\">");
			objStringBuilder.append("<tr>");
			objStringBuilder.append("<td>Step</td>");
			for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
				strKey = arrKeys[intKeysEach].toString();
				objStringBuilder.append("<th>" + strKey + "</th>");
			}
			objStringBuilder.append(" </tr>  ");
			for (int intTestStepRow = 0; intTestStepRow < objTestSteps.size(); intTestStepRow++) {
				objStringBuilder.append("</tr>");
				objStringBuilder.append("<td> " + (intTestStepRow) + "</td>");
				objStepReport.replaceAllFromString((String) objTestSteps.get(intTestStepRow).toString());
				for (int intKeysEach = 0; intKeysEach < arrKeys.length; intKeysEach++) {
					strKey = arrKeys[intKeysEach].toString();
					if (objStepReport.containsKey(strKey) == true) {
						strValue = objStepReport.getString(strKey).replaceAll("<", "&lt;");
						strValue.replaceAll(">", "&gt;");
						objStringBuilder.append("<td> " + strValue + "</td>");
					} else {
						objStringBuilder.append("<td>  &nbsp; </td>");
					}
				}
				objStringBuilder.append(" </tr>  ");
			}
			objStringBuilder.append("</table>");
			objStringBuilder.append("</h1></body>");
			objStringBuilder.append("</html>");
			String html = objStringBuilder.toString();
			FileUtil.write(strPath + strFileName, html);
		} catch (Exception e) {
			Logger.getInstance().add("WriteJsonStepsToHtml: Exception = " + e.toString());
			Logger.getInstance().add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
			Logger.getInstance().add("WriteJsonStepsToHtml: Exception = " + e.toString());
			Logger.getInstance().add("WriteJsonStepsToHtml: objStringBuilder.toString() = " + objStringBuilder.toString());
		}
	}
}
