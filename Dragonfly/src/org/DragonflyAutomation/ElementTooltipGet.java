package org.DragonflyAutomation;

import org.openqa.selenium.interactions.Actions;

class ElementTooltipGet {
	String run() {
		//		  HTML: Use a container element (like <div>) and add the "tooltip" class to it. 
		//		  When the user mouse over this <div>, it will show the tooltip text. 
		//		  The tooltip text is placed inside an inline element (like <span>) with class="tooltiptext" .
		//
		//		  When a tooltip control receives a WM_MOUSEMOVE message, it determines whether the mouse pointer is in the bounding rectangle of a tool.
		//		  If it is, the tooltip control sets a timer. 
		//		  At the end of the time-out interval, the tooltip control checks the position of the pointer to see if it has moved. 
		//		  If it hasn't, the tooltip control retrieves the text for the tool and displays the tooltip. 
		//		  The tooltip control continues to show the window until it receives a relayed button-up or button-down message or 
		//		  until a WM_MOUSEMOVE message indicates that the pointer has moved outside the bounding rectangle of the tool.
		//
		//		  document.getElementsByClassName("tooltips_class32")
		//
		//     QTP solution =  Window("nativeclass:=tooltips_class32").GetROProperty("text")
		//                     Window("nativeclass:=tooltips_class32").GetROProperty("title")
		//
		//"[CLASS:tooltips_class32]"
		//' Grab tooltip
		//ToolTip = Window("nativeclass:=tooltips_class32").GetROProperty("text")
		//  https://www.geeksforgeeks.org/how-to-add-a-tooltip-to-a-div-using-javascript/
		//		  .tooltip(“show”): It is used to show the tooltip.
		//		  .tooltip(“hide”): It is used to hide the tooltip.
		//
		//
		//		Coordinates imageCoordinates =  new Coordinates(){
		//
		//			@Override
		//			public Object getAuxiliary() {
		//				// TODO Auto-generated method stub
		//				return null;
		//			}
		//
		//			@Override
		//			public Point inViewPort() {
		//				// TODO Auto-generated method stub
		//				return null;
		//			}
		//
		//			@Override
		//			public Point onPage() {
		//				// TODO Auto-generated method stub
		//				return null;
		//			}
		//
		//			@Override
		//			public Point onScreen() {
		//				// TODO Auto-generated method stub
		//				return null;
		//			}};
		//			
		//			Locatable elementLocation = (Locatable) Element.getInstance().element;
		//			Coordinates c = elementLocation.getCoordinates().;
		//			
		//		 Mouse mouse = ((HasInputDevices) BrowserDriver.getInstance().browserDriver).getMouse();
		//		 mouse.mouseMove(imageCoordinates);
		//
		//Locatable elementLocation = (Locatable) Element.getInstance().element;
		//		int getX = Element.getInstance().element.getLocation().getX() * -1;
		//		int getY = Element.getInstance().element.getLocation().getY() * -1;
		int getX = -1;
		int getY = -1;
		System.out.println("arguments[0].fireEvent('onmouseover'); start ");
		//new SleepMilliseconds(2000);
		Actions actions = new Actions(BrowserDriver.getInstance().browserDriver);
		actions.moveToElement(Element.getInstance().element, getX, getY).perform();
		actions.moveToElement(Element.getInstance().element).perform();
		new SleepMilliseconds(2000);
		System.out.println(BrowserDriver.getInstance().browserDriver.getWindowHandles());
		///////////////  possible option use webdriver to check for second window and get text.
		//		Set<String> win = driver.getWindowHandles();
		//	    String window1 = (String) window.toArray()[0];
		//		String window2 = (String) window.toArray()[1];
		//		driver.switchTo().window(window2);
		//	    String window3 = (String) window.toArray()[0];
		//	    driver.switchTo().window(window3);
		//	    System.out.println(driver.getTitle());
		//
		//
		//
		//
		//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BrowserDriver.getInstance().browserDriver;
		//		try {
		//			
		//			//String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		//			//String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		//			String mouseOverScript ="arguments[0].onmouseover();";
		//			javascriptExecutor.executeScript(mouseOverScript, Element.getInstance().element);
		//			//javascriptExecutor.executeScript("arguments[0].fireEvent('onmouseover');", Element.getInstance().element);
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			System.out.println("arguments[0].fireEvent('onmouseover'); = " + e);
		//		}
		//		new SleepMilliseconds(1500);
		//		WebElement	toolTipTitle = null;
		String toolTipTitleText = "";
		//		for (int intKeysEach = 0; intKeysEach < 10; intKeysEach++) {
		//			System.out.println("#####document.getElementsByClassName try " );
		//			try {
		//				//toolTipTitleText = (String) javascriptExecutor.executeScript("return document.getElementsByClassName(\"tooltips_class32\").innerHTML");
		//	
		//				
		//				toolTipTitle = (WebElement) javascriptExecutor.executeScript("return document.getElementsByClassName(\"tooltips_class32\")");
		//				if (toolTipTitle != null ){
		//					System.out.println("$$$$$$$$$$$$$$$$$document.getElementsByClassName found " );
		//					break;
		//				}
		//			
		//			} catch (Exception e) {
		//				// TODO Auto-generated catch block
		//				System.out.println("toolTipTitleText error = " + e);
		//			}
		//			new SleepMilliseconds(1500);
		//		}
		//		
		//		toolTipTitleText=toolTipTitle.getTagName();
		System.out.println("return document.getElementsByClassName = " + toolTipTitleText);
		return toolTipTitleText;
		//		//
		//		//
		//		//			ToolTip1.moveToElement(Element.getInstance().element).build().perform();
		//		//			for (int intKeysEach = 0; intKeysEach < 10; intKeysEach++) {
		//		//				System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//		//				new SleepMilliseconds(500);
		//		//			}
		//		AutoItSetObject objAutoItSetObject = new AutoItSetObject();
		//		String strHandle = "";
		//		//new SleepMilliseconds(2000);
		//		//WebElement objWebElement = objWebDriver.findElement(By.id("tooltipID"));
		//		// System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
		//		// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//		// System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		//		// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("This is the tip"));
		//		// $oIE = _IECreate("about:blank")
		//		// 		$hWnd = _IEPropertyGet($oIE, "hwnd")
		//		// 		$aPos = WinGetPos( ControlGetHandle($hWnd, "", "[CLASS:Internet Explorer_Server; INSTANCE:1]") )
		//		// 		MouseMove($aPos[0], $aPOs[1])
		//		//
		//		System.out.println("winGetHandle: = " + objAutoItSetObject.objAutoIt.winGetHandle("[CLASS:Chrome_WidgetWin_1]"));
		//		strHandle = objAutoItSetObject.objAutoIt.controlGetHandle("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]");
		//		System.out.println("strHandle = " + strHandle);
		//		// WinDef.HWND strHandleChrome = (HWND(objAutoItSetObject.objAutoIt.controlGetHandle("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
		//		// System.out.println("strHandleChrome = " + strHandleChrome);
		//		//WinDef.RECT rectChrome = new WinDef.RECT();
		//		// User32.INSTANCE.GetWindowRect(strHandleChrome, rectChrome);
		//		// System.out.println("winGetPosX: = " + rectChrome.left);
		//		// System.out.println("winGetPosY: = " + rectChrome.top);
		//		System.out.println("controlGetPosX: = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
		//		System.out.println("controlGetPosY: = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
		//		System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
		//		System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
		//		System.exit(0);
		//		//
		//		//String strHandle =objAutoItSetObject.objAutoIt.controlGetHandle("[CLASS:Internet Explorer_Server; INSTANCE:1]", "", null);
		//		strHandle = objAutoItSetObject.objAutoIt.winGetHandle("changed");
		//		System.out.println("winGetClientSizeHeight: = " + objAutoItSetObject.objAutoIt.winGetClientSizeHeight("changed"));
		//		System.out.println("winGetClientSizeWidth: = " + objAutoItSetObject.objAutoIt.winGetClientSizeWidth("changed"));
		//		System.out.println("winGetHandle: = " + objAutoItSetObject.objAutoIt.winGetHandle("changed"));
		//		System.out.println("winGetPosHeight: = " + objAutoItSetObject.objAutoIt.winGetPosHeight("changed"));
		//		System.out.println("winGetPosWidth: = " + objAutoItSetObject.objAutoIt.winGetPosWidth("changed"));
		//		System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX("changed"));
		//		System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY("changed"));
		//		System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle("[CLASS:IEFrame]"));
		//		System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle("[HANDLE:0x0001069A]"));
		//		//String strHandle = objAutoItSetObject.objAutoIt.winGetHandle("[CLASS:IEFrame]");
		//		System.out.println("strHandle = " + strHandle);
		//		strHandle = "[CLASS:IEFrame]";
		//		System.out.println("strHandle = " + strHandle);
		//		System.out.println("winGetPosHeight: = " + objAutoItSetObject.objAutoIt.winGetPosHeight(strHandle));
		//		System.out.println("winGetPosWidth: = " + objAutoItSetObject.objAutoIt.winGetPosWidth(strHandle));
		//		System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
		//		System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
		//		System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle(strHandle));
		//		System.out.println("winGetClientSizeHeight = " + objAutoItSetObject.objAutoIt.winGetClientSizeHeight(strHandle));
		//		System.out.println("winGetClientSizeWidth = " + objAutoItSetObject.objAutoIt.winGetClientSizeWidth(strHandle));
		//		//System.out.println("winGetClientSizeWidth = " + objAutoItSetObject.objAutoIt.winGetCaretPosX(strHandle));
		//		///This works for control place Class in the last position
		//		strHandle = "[CLASS:Internet Explorer_Server; INSTANCE:1]";
		//		//strHandle=	"[CLASS:Internet Explorer_Server]";
		//		System.out.println("strHandle = " + strHandle);
		//		System.out.println("controlGetPosHeight = " + objAutoItSetObject.objAutoIt.controlGetPosHeight("", "", strHandle));
		//		System.out.println("controlGetPosWidth = " + objAutoItSetObject.objAutoIt.controlGetPosWidth("", "", strHandle));
		//		System.out.println("controlGetPosX = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", strHandle));
		//		System.out.println("controlGetPosY = " + objAutoItSetObject.objAutoIt.controlGetPosY("", "", strHandle));
		//		System.out.println("controlGetHandle = " + objAutoItSetObject.objAutoIt.controlGetHandle("", "", strHandle));
		//		System.out.println("winGetPosHeight = " + objAutoItSetObject.objAutoIt.winGetPosHeight(strHandle));
		//		System.out.println("winGetPosWidth = " + objAutoItSetObject.objAutoIt.winGetPosWidth(strHandle));
		//		System.out.println("winGetPosX = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
		//		System.out.println("winGetPosY = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
		//		System.exit(0);
		//		Actions ToolTip1 = new Actions(BrowserDriver.getInstance().browserDriver);
		//		ToolTip1.moveToElement(Element.getInstance().element).build().perform();
		//		for (int intKeysEach = 0; intKeysEach < 10; intKeysEach++) {
		//			System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//			new SleepMilliseconds(500);
		//		}
		//		//ToolTip1.clickAndHold(Element.getInstance().element).build().perform();
		//		//Actions.moveToElement(Element.getInstance().element).build().clickAndHold()
		//		// System.out.println(objWebElement.getLocation().getX());
		//		// System.out.println(objWebElement.getLocation().getY());
		//		// System.out.println(objWebElement.getSize().width);
		//		// System.out.println(objWebElement.getSize().height);
		//		//System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		//		new SleepMilliseconds(3000);
		//		// String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("This is a tooltip", "", "");
		//		// System.out.println(">>>>>>>>>>>>>>>>>");
		//		// System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText controlGetText value is: " + strToolTipAutoItText);
		//		// System.out.println(">>>>>>>>>>>>>>>>>");
		//		// System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
		//		// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//		// if (objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]")) {
		//		// 	System.out.println("winExists yes");
		//		// }
		//		boolean blnToolTipAutoItText = objAutoItSetObject.objAutoIt.winWaitActive("[TITLE:this is bold text]", "", 10);
		//		String strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText value is: " + strToolTipAutoItText);
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPCLASS:(.*tooltips.*)]");
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle REGEXPCLASS class value is: " + strToolTipAutoItText);
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle value is: " + strToolTipAutoItText);
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  class value is: " + strToolTipAutoItText);
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		new SleepMilliseconds(9000);
		//		//System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
		//		//System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//		//System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winActive("[CLASS:tooltips_class32]"));
		//		//System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		//		//While 1
		//		//    ; Look for a window of that class to appear
		//		//    If WinExists("[CLASS:tooltips_class32]", "") Then ; You may need more specific information here <<<<<<<<<<<<<<<<<<<<<<
		//		//        ; Get the position and size of the TrayTip
		//		//        $aPos = WinGetPos("[CLASS:tooltips_class32]", "") ; And here <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//		//        ; Exit the While...WEnd loop
		//		//        ExitLoop
		//		//    EndIf
		//		//WEnd
		//		//' Grab tooltip
		//		//ToolTip = Window("nativeclass:=tooltips_class32").GetROProperty("text")
		//		System.out.println("winGetState before tootip create = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//		objAutoItSetObject.objAutoIt.toolTip("This is a AutoIt tooltip", 1000, 500);
		//		System.out.println("winGetState before 14 = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//		System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		//		new SleepMilliseconds(14000);
		//		//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("This is a tooltip", "", "");
		//		//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("tooltips_class32", "", "");
		//		//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[ACTIVE]");
		//		//"[ACTIVE]"
		//		if (objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]")) {
		//			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[CLASS:tooltips_class32]");
		//			System.out.println(">>>>>>>>>>>>>>>>>");
		//			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText value is: " + strToolTipAutoItText);
		//			System.out.println(">>>>>>>>>>>>>>>>>");
		//		}
		//		System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:This is a AutoIt toolti]");
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  TITLE value is: " + strToolTipAutoItText);
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPTITLE:.*tooltip.*]");
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  REGEXPTITLE value is: " + strToolTipAutoItText);
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPCLASS:(.*tooltips.*)]");
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle REGEXPCLASS class value is: " + strToolTipAutoItText);
		//		System.out.println(">>>>>>>>>>>>>>>>>");
		//		Dimension objWebDriverDimension = Element.getInstance().element.getSize();
		//		int intBrowserOuterWidth = objWebDriverDimension.width;
		//		int intBrowserOuterHeight = objWebDriverDimension.height;
		//		System.out.println(-((intBrowserOuterWidth / 2) + 1));
		//		System.out.println(-((intBrowserOuterHeight / 2) + 1));
		//		/////ToolTip1.moveByOffset(-((intBrowserOuterWidth / 2) + 1), -((intBrowserOuterHeight / 2) + 1)).build().perform();
		//		//ToolTip1.moveByOffset(-intBrowserOuterWidth + 1, -intBrowserOuterHeight + 1).build().perform();
		//		String ToolTipTitleText = Element.getInstance().element.getAttribute("title");
		//		System.out.println("ToolTipTitleText value is: " + ToolTipTitleText);
		//		//ToolTip1.release(objWebElement).perform();
		//		//ToolTip1.release().perform();
		//		//ToolTip1.moveByOffset(0, 0);
		//		String[][] arrWindows = objAutoItSetObject.objAutoIt.winList("");
		//		for (String[] arrResultsEach : arrWindows) {
		//			System.out.println("Window value is: " + arrResultsEach[1]);
		//		}
		//		return strToolTipAutoItText;
	}
}
