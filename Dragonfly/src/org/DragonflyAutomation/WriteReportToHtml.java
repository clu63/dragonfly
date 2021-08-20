package org.DragonflyAutomation;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.json.simple.JSONArray;

class WriteReportToHtml {
	WriteReportToHtml(String strFile, JSONArray objJsonArrayReportSteps, String strTestStepsFile, String strTestName) {
		long lngStartTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>WriteReportToHtml " + Util.getDateTimestamp());
		Logger.getInstance().add("WriteReportToHtml: strFile = " + strFile);
		JSON objJsonObjectReportStep = new JSON();
		String strScreenshotFilePath = "";
		String strStatus = "";
		String strStatusIcon = "";
		StringBuilder objStringBuilder = new StringBuilder();
		int intTestStepRow = 0;
		Logger.getInstance().add("WriteReportToHtml: objJsonArrayReportSteps = " + objJsonArrayReportSteps.toJSONString());
		try {
			// 	function popUp() {
			// 		var newWindow = window.open("", "Test", "width=300,height=300,scrollbars=1,resizable=1")
			// 		var text = "cat"
			// 		var html = "<html><head></head><body>Hello, <b>" + text + "</b>."
			// 		html += "How are you today?</body></html>"
			// 		newWindow.document.open()
			// 		newWindow.document.write(html)
			// 		newWindow.document.close()
			// 	}
			objStringBuilder.append("<!DOCTYPE html>");
			objStringBuilder.append("<html lang=\"en\">");
			objStringBuilder.append("<script language=\"javascript\" type=\"text/javascript\">");
			objStringBuilder.append("var varImageCount = -1;");
			objStringBuilder.append("var varStep = -1;");
			objStringBuilder.append("var intTimeoutInterval;");
			objStringBuilder.append("function slideShow() {");
			objStringBuilder.append("if (!document.images) {");
			objStringBuilder.append("return;");
			objStringBuilder.append("}");
			objStringBuilder.append("varStep++;");
			objStringBuilder.append("if (varStep <= varImageCount) {");
			objStringBuilder.append("if (document.getElementById(\"img_\" + varStep)) {");
			objStringBuilder.append("document.getElementById('imgSlideshow').src = document.getElementById(\"img_\" + varStep).src;");
			objStringBuilder.append("intTimeoutInterval = 1500;");
			objStringBuilder.append("} else {");
			objStringBuilder.append("intTimeoutInterval = 0;");
			objStringBuilder.append("}");
			objStringBuilder.append("} else {");
			objStringBuilder.append("varStep = -1;");
			objStringBuilder.append("}");
			objStringBuilder.append("setTimeout(\"slideShow()\", intTimeoutInterval);");
			objStringBuilder.append("}");
			objStringBuilder.append("function onLoadSlideshow() {");
			objStringBuilder.append("document.getElementById(\"imgSlideshow\").src = document.getElementById('img_0').src;");
			objStringBuilder.append("scrollToTop();");
			objStringBuilder.append("slideShow();");
			objStringBuilder.append("}");
			objStringBuilder.append("function scrollToStep() {");
			objStringBuilder.append("document.getElementById(\"step_\" + varStep).scrollIntoView(true);");
			objStringBuilder.append("}");
			objStringBuilder.append("function scrollToTop() {");
			objStringBuilder.append("document.getElementById('body').scrollIntoView();");
			objStringBuilder.append("}");
			objStringBuilder.append("</script>");
			objStringBuilder.append("<head><title>" + strTestName + "</title></head>");
			objStringBuilder.append("<body id=\"body\" onload=\"onLoadSlideshow()\">");
			objStringBuilder.append("<img id=\"imgSlideshow\" onclick=\"scrollToStep()\" src=\"\" alt=\"\"></img>");
			objStringBuilder.append("<br>");
			objStringBuilder.append("<br>");
			for (intTestStepRow = 0; intTestStepRow < objJsonArrayReportSteps.size(); intTestStepRow++) {
				objJsonObjectReportStep.parseString((String) objJsonArrayReportSteps.get(intTestStepRow));
				Logger.getInstance().add("WriteReportToHtml: objJsonObjectReportStep = " + objJsonObjectReportStep.toJSONString());
				objStringBuilder.append("<div id=step_" + intTestStepRow + ">");
				objStringBuilder.append("<TABLE border=1 width=100% height=10%>");
				objStringBuilder.append("<TR>");
				switch (objJsonObjectReportStep.getLowerCase("strStatus")) {
				case "pass":
					strStatus = "Pass";
					if (objJsonObjectReportStep.verifyEquals("strAction", "set") && objJsonObjectReportStep.verifyEquals("strAssert", "off")) {
						strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:blue\">&#10043</span>";
					} else {
						strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:green\">&#10003</span>";
					}
					break;
				case "fail":
					strStatus = "Fail";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:red\">&#10007</span>";
					break;
				case "warning":
					strStatus = "Warning";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:gold\">!</span>";
					break;
				case "info":
					strStatus = "Info";
					strStatusIcon = "<span style=\"font-weight:bold;font-size:40px;color:magenta\">?</span>";
					break;
				}
				String strStartTimestamp = objJsonObjectReportStep.getString("strStartTimestamp");
				String strStepDuration = objJsonObjectReportStep.getString("strStepDuration");
				String strEndTimestamp = objJsonObjectReportStep.getString("strEndTimestamp");
				objStringBuilder.append("<TD onclick=\"scrollToTop()\" rowspan=\"2\" width=60px align=center valign=middle>Step " + intTestStepRow + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=35px align=center valign=middle>" + strStatusIcon + "<br>" + strStatus + "</TD>");
				objStringBuilder.append("<TD width= 75px align=center valign=middle>Expected</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objJsonObjectReportStep.getString("strStepExpected") + "</TD>");
				objStringBuilder.append("<TD rowspan=\"2\" width=150px align=left valign=middle>Start:" + strStartTimestamp + "<br>End: " + strEndTimestamp + "<br>Duration: " + strStepDuration + " ms</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("<TR>");
				objStringBuilder.append("<TD align=center valign=middle>Actual</TD>");
				objStringBuilder.append("<TD align=left valign=middle>" + objJsonObjectReportStep.getString("strStepActual") + "</TD>");
				objStringBuilder.append("</TR>");
				objStringBuilder.append("</TABLE> ");
				if (objJsonObjectReportStep.getValueLength("strScreenshotFilePath") != 0) {
					strScreenshotFilePath = objJsonObjectReportStep.getString("strScreenshotFilePath").replaceAll("\\\\\\\\", "\\");
					try {
						BufferedImage objBufferedImage = ImageIO.read(new File(strScreenshotFilePath));
						objStringBuilder.append("<img id=img_" + intTestStepRow + " src=\"data:image/png;base64," + new ImageProcessing().encodeToString(objBufferedImage, "png") + "\" alt=\"Step " + intTestStepRow + "\" > ");
					} catch (Exception e) {
						Logger.getInstance().add("writeReportToHtml: Exception = " + e.toString());
					}
				}
				objStringBuilder.append("</div>");
				objStringBuilder.append("<br>");
				objStringBuilder.append("<br>");
			}
		} catch (Exception e) {
			Logger.getInstance().add("WriteReportToHtml: " + e.toString());
		} finally {
			objStringBuilder.append("</body>");
			objStringBuilder.append("</html>");
			String strHTML = objStringBuilder.toString().replace("varImageCount = -1", "varImageCount = " + (intTestStepRow - 1));
			UtilFile.write(strFile, strHTML);
			UtilFile.write(strTestStepsFile, strHTML);
			Logger.getInstance().add("WriteReportToHtml: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
