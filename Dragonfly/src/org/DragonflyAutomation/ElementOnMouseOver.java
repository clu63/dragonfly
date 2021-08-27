package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Locatable;

class ElementOnMouseOver {
	ElementOnMouseOver() {
		Logger.getInstance().add("  ==start==>ElementOnMouseOver " + Util.getDateTimestamp());
		Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
		actions.moveToElement(Element.getInstance().element, -1, -1).perform();
		new SleepMilliseconds(5000);
		actions.moveToElement(Element.getInstance().element).perform();
		//		Locatable elementLocation = (Locatable) Element.getInstance().element;
		//		
		//		System.out.println(Element.getInstance().element.getLocation());
		//		System.out.println(Element.getInstance().element.getRect());
		//		System.out.println(Element.getInstance().element.getSize());
		//		
		//		int widthSize = Element.getInstance().element.getSize().getWidth();
		//		int heightSize = Element.getInstance().element.getSize().getHeight();
		//		actions.moveByOffset(widthSize / 2 + 1, heightSize / 2 + 1);
		//		//actions.moveByOffset(widthSize/2 +1, heightSize/2+1).perform();;
		//		actions.moveToElement(Element.getInstance().element).perform();
		//		new SleepMilliseconds(5000);
		//		actions.moveToElement(Element.getInstance().element, widthSize, 0).perform();
		//		new SleepMilliseconds(5000);
		//		actions.moveToElement(Element.getInstance().element, widthSize*2, 0).perform();
		//		new SleepMilliseconds(5000);
		//		actions.moveToElement(Element.getInstance().element, widthSize*3, 0).perform();
		//		new SleepMilliseconds(5000);
		//		
		//		try {
		//			Integer inViewPortX = elementLocation.getCoordinates().inViewPort().getX();
		//			Integer inViewPortY = elementLocation.getCoordinates().inViewPort().getY();
		//			System.out.println("<<<<<<<<<<<<<<<<<<inViewPortX = " + inViewPortX + " inViewPortY = " + inViewPortY);
		//		} catch (Exception e2) {
		//			System.out.println("XXXXXXXXXXXXXXXXXXinViewPort");
		//			e2.printStackTrace();
		//		}
		//		try {
		//			Integer onScreenX = elementLocation.getCoordinates().onScreen().getX();
		//			Integer onScreenY = elementLocation.getCoordinates().onScreen().getY();
		//			System.out.println("<<<<<<<<<<<<<<<<<<onScreenX = " + onScreenX + " onScreenY = " + onScreenY);
		//		} catch (Exception e1) {
		//			System.out.println("XXXXXXXXXXXXXXXXXXonScreen");
		//			e1.printStackTrace();
		//		}
		//		try {
		//			Integer onPageX = elementLocation.getCoordinates().onPage().getX();
		//			Integer onPageY = elementLocation.getCoordinates().onPage().getY();
		//			System.out.println("<<<<<<<<<<<<<<<<<<onPageX = " + onPageX + " onPageY = " + onPageY);
		//		} catch (Exception e) {
		//			System.out.println("XXXXXXXXXXXXXXXXXXonPage");
		//			e.printStackTrace();
		//		}
		//		//actions.moveByOffset(0, 0);
		//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
		//		javascriptExecutor.executeScript("arguments[0].onmouseover();", Element.getInstance().element);
	}
}
