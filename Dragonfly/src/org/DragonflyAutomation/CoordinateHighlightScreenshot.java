package org.DragonflyAutomation;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

class CoordinateHighlightScreenshot {
	CoordinateHighlightScreenshot(final JSON objJsonObjectStepHighlightArea) {
		Logger.getInstance().add("  ==start==>CoordinateHighlightScreenshot " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		//
		//
		// if (driver instanceof JavascriptExecutor) {
		// ((JavascriptExecutor)driver).executeScript("arguments[0].style.outline
		// = 'blue dotted 4px'", element);
		// }
		//
		//
		String outlineStyleOriginal = "";
		String outlineStyle = "";
		switch (objJsonObjectStepHighlightArea.getLowerCase("strStatus")) {
		case "pass":
			if (objJsonObjectStepHighlightArea.verifyEquals("strAction", "set") && objJsonObjectStepHighlightArea.verifyEquals("strAssert", "off")) {
				outlineStyle = "blue solid 4px"; // Color.BLUE;
			} else {
				outlineStyle = "green solid 4px"; //  Color.GREEN;
			}
			break;
		case "fail":
			outlineStyle = "red solid 4px"; // Color.RED;
			break;
		case "warning":
			outlineStyle = "yellow solid 4px"; //  Color.YELLOW;
			break;
		case "info":
			outlineStyle = "magenta solid 4px"; //  Color.MAGENTA;
			break;
		}
		if (Element.getInstance().element != null) {
			JavascriptExecutor objJavascriptExecutor = null;
			objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
			//objJavascriptExecutor.executeScript("arguments[0].style.outline = 'magenta solid 4px'", Element.getInstance().element);
			outlineStyleOriginal = (String) objJavascriptExecutor.executeScript("return arguments[0].style.outline", Element.getInstance().element);
			System.out.println("outlineStyleOriginal = " + outlineStyleOriginal);
			objJavascriptExecutor.executeScript("arguments[0].style.outline = '" + outlineStyle + "'", Element.getInstance().element);
			//objJavascriptExecutor.executeScript("arguments[0].style.outline = 'red solid 4px'",
		}
		//
		//
		// JDialog objJDialog = new JDialog() {
		// private static final long serialVersionUID = 1L;
		// {
		// Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
		// if (objJsonObjectStepHighlightArea.getBoolean("blnHighlight") ==
		// true) {
		// int intThickness = 5;
		// Color objHighlightColor = null;
		// switch (objJsonObjectStepHighlightArea.getLowerCase("strStatus")) {
		// case "pass":
		// if (objJsonObjectStepHighlightArea.verifyEquals("strAction", "set")
		// && objJsonObjectStepHighlightArea.verifyEquals("strAssert", "off")) {
		// objHighlightColor = Color.BLUE;
		// } else {
		// objHighlightColor = Color.GREEN;
		// }
		// break;
		// case "fail":
		// objHighlightColor = Color.RED;
		// break;
		// case "warning":
		// objHighlightColor = Color.YELLOW;
		// break;
		// case "info":
		// objHighlightColor = Color.MAGENTA;
		// break;
		// }
		// Logger.getInstance().add("CoordinateHighlightScreenshot:
		// strHighlightArea = " +
		// JSONS.getInstance().step.getString("strHighlightArea"));
		// new RectangleAreaByName(intThickness,
		// JSONS.getInstance().step.getString("strHighlightArea"),
		// objHighlightArea);
		// setBounds(objHighlightArea.x, objHighlightArea.y,
		// objHighlightArea.width, objHighlightArea.height);
		// setUndecorated(true);
		// setBackground(new Color(0, 0, 0, 0));
		// getRootPane().setBorder(BorderFactory.createLineBorder(objHighlightColor,
		// intThickness, false));
		// setVisible(true);
		// }
		// }
		// };
		int intSleepMilliseconds = 0;
		if (JSONS.getInstance().step.getBoolean("blnScreenshot") == true) {
			Rectangle objHighlightArea = new Rectangle(0, 0, 0, 0);
			String strScreenshotFilePath = "";
			try {
				new RectangleAreaByName(0, JSONS.getInstance().step.getString("strScreenshotArea"), objHighlightArea);
				//BufferedImage objScreenShot = new Robot().createScreenCapture(objHighlightArea);
				//BufferedImage objScreenShot =	(BufferedImage) ((TakesScreenshot) BrowserDriver.getInstance().browserDriver).getScreenshotAs(OutputType.BYTES);
				File screen = ((TakesScreenshot) BrowserDriver.getInstance().browserDriver).getScreenshotAs(OutputType.FILE);
				BufferedImage objScreenShot = ImageIO.read(screen);
				//
				//https://chercher.tech/java/take-screenshot-selenium-webdriver
				//				 //Used selenium Point class to get x y coordinates of Image element.
				//				  //get location(x y coordinates) of the element.
				//				  Point point = element.getLocation();
				//				  int xcordinate = point.getX();
				//				  int ycordinate = point.getY();
				//
				//				  //Used selenium getSize() method to get height and width of element.
				//				  //Retrieve width of element.
				//				  int imageWidth = element.getSize().getWidth();
				//				  //Retrieve height of element.
				//				  int imageHeight = element.getSize().getHeight();
				//
				//				  //Reading full image screenshot.
				//				  BufferedImage img = ImageIO.read(screen);
				//
				//				  //cut Image using height, width and x y coordinates parameters.
				//				  BufferedImage destination = img.getSubimage(xcordinate, ycordinate, imageWidth, imageHeight);
				//				  ImageIO.write(destination, "png", screen);
				//
				//				  //save Image screenshot In D: drive.
				//				  FileUtils.copyFile(screen, new File("D:screenshotOfElement.png"));
				//
				//	strScreenshotFilePath = Path.getInstance().images + "Screenshot_" + Util.getDateTimestamp() + ".jpg";
				strScreenshotFilePath = Path.getInstance().images + "Screenshot_" + Util.getDateTimestamp() + ".png";
				//Thread objThread = new Thread(new ThreadSaveImage(objScreenShot, "jpg", strScreenshotFilePath));
				Thread objThread = new Thread(new ThreadSaveImage(objScreenShot, "png", strScreenshotFilePath));
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
			// objJDialog.setVisible(false);
			// objJDialog.dispose();
			if (Element.getInstance().element != null) {
				JavascriptExecutor objJavascriptExecutor = null;
				objJavascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
				objJavascriptExecutor.executeScript("arguments[0].style.outline = '" + outlineStyleOriginal + "'", Element.getInstance().element);
			}
		}
		Logger.getInstance().add("CoordinateHighlightScreenshot: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
	}
}