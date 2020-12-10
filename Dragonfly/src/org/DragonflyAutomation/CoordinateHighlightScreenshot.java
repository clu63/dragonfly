package org.DragonflyAutomation;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JDialog;

class CoordinateHighlightScreenshot {
	CoordinateHighlightScreenshot(final JSON objJsonObjectStepHighlightArea) {
		Logger.getInstance().add("  ==start==>CoordinateHighlightScreenshot " + new DateTimestamp().get());
		long lngStartTime = System.currentTimeMillis();
		JDialog objJDialog = new JDialog() {
			private static final long serialVersionUID = 1L;
			{
				Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
				if (objJsonObjectStepHighlightArea.getBoolean("blnHighlight") == true) {
					int intThickness = 5;
					Color objHighlightColor = null;
					switch (objJsonObjectStepHighlightArea.getLowerCase("strStatus")) {
					case "pass":
						if (objJsonObjectStepHighlightArea.verifyEquals("strAction", "set") && objJsonObjectStepHighlightArea.verifyEquals("strAssert", "off")) {
							objHighlightColor = Color.BLUE;
						} else {
							objHighlightColor = Color.GREEN;
						}
						break;
					case "fail":
						objHighlightColor = Color.RED;
						break;
					case "warning":
						objHighlightColor = Color.YELLOW;
						break;
					case "info":
						objHighlightColor = Color.MAGENTA;
						break;
					}
					Logger.getInstance().add("CoordinateHighlightScreenshot: strHighlightArea = " + JSONS.getInstance().step.getString("strHighlightArea"));
					new RectangleAreaByName(intThickness, JSONS.getInstance().step.getString("strHighlightArea"), objHighlightArea);
					setBounds(objHighlightArea.x, objHighlightArea.y, objHighlightArea.width, objHighlightArea.height);
					setUndecorated(true);
					setBackground(new Color(0, 0, 0, 0));
					getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor, intThickness, false));
					setVisible(true);
				}
			}
		};
		int intSleepMilliseconds = 0;
		if (JSONS.getInstance().step.getBoolean("blnScreenshot") == true) {
			Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
			String strScreenshotFilePath = "";
			try {
				new RectangleAreaByName(0, JSONS.getInstance().step.getString("strScreenshotArea"), objHighlightArea);
				BufferedImage objScreenShot = new Robot().createScreenCapture(objHighlightArea);
				strScreenshotFilePath = Path.getInstance().images + "Screenshot_" + new DateTimestamp().get() + ".jpg";
				Thread objThread = new Thread(new ThreadSaveImage(objScreenShot, "jpg", strScreenshotFilePath));
				objThread.start();
				JSONS.getInstance().step.putValue("strScreenshotFilePath", strScreenshotFilePath);
			} catch (Exception e) {
				Logger.getInstance().add("CoordinateHighlightScreenshot: Exception " + e.toString());
			}
		}
		if (JSONS.getInstance().step.getBoolean("blnHighlight") == true) {
			try {
				Thread.sleep(intSleepMilliseconds);
			} catch (InterruptedException e) {
				Logger.getInstance().add("CoordinateHighlightScreenshot: Exception " + e.toString());
			}
			objJDialog.setVisible(false);
			objJDialog.dispose();
		}
		Logger.getInstance().add("CoordinateHighlightScreenshot: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
	}
}