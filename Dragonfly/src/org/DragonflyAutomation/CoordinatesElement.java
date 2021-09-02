package org.DragonflyAutomation;

import java.awt.Rectangle;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
//import org.openqa.selenium.interactions.internal.Coordinates;
//import org.openqa.selenium.interactions.internal.Locatable;

class CoordinatesElement {
	CoordinatesElement() {
		Logger.getInstance().add("  ==start==>CoordinatesElement " + Util.getDateTimestamp());
		long lngStartTime = System.currentTimeMillis();
		try {
			Rectangle rect = new Rectangle(0, 0, -1, -1);
			//	WinDef.RECT rect = returnIECLientScreenXY();
			//WinDef.RECT rect = new WinDef.RECT();
			rect.height = JSONS.getInstance().step.getInt("intBrowserInnerHeight");
			rect.width = JSONS.getInstance().step.getInt("intBrowserInnerWidth");
			rect.x = 0;
			rect.y = 0;
			System.out.println("Solution = " + rect.getBounds().toString());
			System.out.println("Solution rect.left = " + rect.width);
			System.out.println("Solution rect.top = " + rect.height);
			if (Element.getInstance().element != null) {
				System.out.println("before objElementCoordinates");
				Coordinates objElementCoordinates = ((Locatable) Element.getInstance().element).getCoordinates();
				//	Coordinates objElementCoordinates = ((Locatable) Element.getInstance().element).getCoordinates();
				System.out.println("objElementCoordinates.toString() = " + objElementCoordinates.toString());
				System.out.println("objElementCoordinates.onPage() = " + objElementCoordinates.onPage());
				//System.out.println("objElementCoordinates.onScreen() = " + objElementCoordinates.onScreen());
				System.out.println("objElementCoordinates.inViewPort() = " + objElementCoordinates.inViewPort());
				System.out.println("before objElementPoint");
				Point objElementPoint = objElementCoordinates.inViewPort();
				System.out.println("before objElementDimension");
				Dimension objElementDimension = Element.getInstance().element.getSize();
				JSONS.getInstance().step.putValue("intElementX", Integer.toString((int) Math.round(objElementPoint.x * Config.getInstance().devicePixelRatio)));
				JSONS.getInstance().step.putValue("intElementY", Integer.toString((int) Math.round(objElementPoint.y * Config.getInstance().devicePixelRatio)));
				JSONS.getInstance().step.putValue("intElementWidth", Integer.toString((int) Math.round(objElementDimension.width * Config.getInstance().devicePixelRatio)));
				JSONS.getInstance().step.putValue("intElementHeight", Integer.toString((int) Math.round(objElementDimension.height * Config.getInstance().devicePixelRatio)));
				Logger.getInstance().add("  ==end==>CoordinatesElement objElementPoint.x " + objElementPoint.x);
				Logger.getInstance().add("  ==end==>CoordinatesElement objElementPoint.y " + objElementPoint.y);
				Logger.getInstance().add("  ==end==>CoordinatesElement objElementDimension.width " + objElementDimension.width);
				Logger.getInstance().add("  ==end==>CoordinatesElement objElementDimension.height " + objElementDimension.height);
				Logger.getInstance().add("  ==end==>CoordinatesElement gdblDevicePixelRatio " + Config.getInstance().devicePixelRatio.toString());
			}
			System.out.println("before intElementX");
			int intElementX = JSONS.getInstance().step.getInt("intElementX");
			int intElementY = JSONS.getInstance().step.getInt("intElementY");
			int intElementScreenX = rect.width + intElementX;
			int intElementScreenY = rect.height + intElementY;
			System.out.println("before putInt");
			JSONS.getInstance().step.putValue("intElementScreenX", Integer.toString(intElementScreenX));
			JSONS.getInstance().step.putValue("intElementScreenY", Integer.toString(intElementScreenY));
		} catch (Exception e) {
			Logger.getInstance().add("CoordinatesElement: Exception = " + e.toString());
		} finally {
			Logger.getInstance().add("  ==end==>CoordinatesElement " + Util.getDateTimestamp());
			Logger.getInstance().add("CoordinatesElement: finally Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
