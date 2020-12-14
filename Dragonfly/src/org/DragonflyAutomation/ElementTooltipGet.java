package org.DragonflyAutomation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

class ElementTooltipGet {
	  String run() {
		  AutoItSetObject objAutoItSetObject = new AutoItSetObject();
		String strHandle = "";
		//new SleepMilliseconds(2000);
		//WebElement objWebElement = objWebDriver.findElement(By.id("tooltipID"));
		// System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
		// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		// System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("This is the tip"));
		// $oIE = _IECreate("about:blank")
		// 		$hWnd = _IEPropertyGet($oIE, "hwnd")
		// 		$aPos = WinGetPos( ControlGetHandle($hWnd, "", "[CLASS:Internet Explorer_Server; INSTANCE:1]") )
		// 		MouseMove($aPos[0], $aPOs[1])
		//
		System.out.println("winGetHandle: = " + objAutoItSetObject.objAutoIt.winGetHandle("[CLASS:Chrome_WidgetWin_1]"));
		strHandle = objAutoItSetObject.objAutoIt.controlGetHandle("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]");
		System.out.println("strHandle = " + strHandle);
		// WinDef.HWND strHandleChrome = (HWND(objAutoItSetObject.objAutoIt.controlGetHandle("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
		// System.out.println("strHandleChrome = " + strHandleChrome);
		//WinDef.RECT rectChrome = new WinDef.RECT();
		// User32.INSTANCE.GetWindowRect(strHandleChrome, rectChrome);
		// System.out.println("winGetPosX: = " + rectChrome.left);
		// System.out.println("winGetPosY: = " + rectChrome.top);
		System.out.println("controlGetPosX: = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
		System.out.println("controlGetPosY: = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", "[CLASS:Chrome_RenderWidgetHostHWND; INSTANCE:1]"));
		System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
		System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
		System.exit(0);
		//
		//String strHandle =objAutoItSetObject.objAutoIt.controlGetHandle("[CLASS:Internet Explorer_Server; INSTANCE:1]", "", null);
		strHandle = objAutoItSetObject.objAutoIt.winGetHandle("changed");
		System.out.println("winGetClientSizeHeight: = " + objAutoItSetObject.objAutoIt.winGetClientSizeHeight("changed"));
		System.out.println("winGetClientSizeWidth: = " + objAutoItSetObject.objAutoIt.winGetClientSizeWidth("changed"));
		System.out.println("winGetHandle: = " + objAutoItSetObject.objAutoIt.winGetHandle("changed"));
		System.out.println("winGetPosHeight: = " + objAutoItSetObject.objAutoIt.winGetPosHeight("changed"));
		System.out.println("winGetPosWidth: = " + objAutoItSetObject.objAutoIt.winGetPosWidth("changed"));
		System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX("changed"));
		System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY("changed"));
		System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle("[CLASS:IEFrame]"));
		System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle("[HANDLE:0x0001069A]"));
		//String strHandle = objAutoItSetObject.objAutoIt.winGetHandle("[CLASS:IEFrame]");
		System.out.println("strHandle = " + strHandle);
		strHandle = "[CLASS:IEFrame]";
		System.out.println("strHandle = " + strHandle);
		System.out.println("winGetPosHeight: = " + objAutoItSetObject.objAutoIt.winGetPosHeight(strHandle));
		System.out.println("winGetPosWidth: = " + objAutoItSetObject.objAutoIt.winGetPosWidth(strHandle));
		System.out.println("winGetPosX: = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
		System.out.println("winGetPosY: = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
		System.out.println("winGetTitle = " + objAutoItSetObject.objAutoIt.winGetTitle(strHandle));
		System.out.println("winGetClientSizeHeight = " + objAutoItSetObject.objAutoIt.winGetClientSizeHeight(strHandle));
		System.out.println("winGetClientSizeWidth = " + objAutoItSetObject.objAutoIt.winGetClientSizeWidth(strHandle));
		//System.out.println("winGetClientSizeWidth = " + objAutoItSetObject.objAutoIt.winGetCaretPosX(strHandle));
		///This works for control place Class in the last position
		strHandle = "[CLASS:Internet Explorer_Server; INSTANCE:1]";
		//strHandle=	"[CLASS:Internet Explorer_Server]";
		System.out.println("strHandle = " + strHandle);
		System.out.println("controlGetPosHeight = " + objAutoItSetObject.objAutoIt.controlGetPosHeight("", "", strHandle));
		System.out.println("controlGetPosWidth = " + objAutoItSetObject.objAutoIt.controlGetPosWidth("", "", strHandle));
		System.out.println("controlGetPosX = " + objAutoItSetObject.objAutoIt.controlGetPosX("", "", strHandle));
		System.out.println("controlGetPosY = " + objAutoItSetObject.objAutoIt.controlGetPosY("", "", strHandle));
		System.out.println("controlGetHandle = " + objAutoItSetObject.objAutoIt.controlGetHandle("", "", strHandle));
		System.out.println("winGetPosHeight = " + objAutoItSetObject.objAutoIt.winGetPosHeight(strHandle));
		System.out.println("winGetPosWidth = " + objAutoItSetObject.objAutoIt.winGetPosWidth(strHandle));
		System.out.println("winGetPosX = " + objAutoItSetObject.objAutoIt.winGetPosX(strHandle));
		System.out.println("winGetPosY = " + objAutoItSetObject.objAutoIt.winGetPosY(strHandle));
		System.exit(0);
		Actions ToolTip1 = new Actions(BrowserDriver.getInstance().browserDriver);
		ToolTip1.moveToElement(Element.getInstance().element).build().perform();
		for (int intKeysEach = 0; intKeysEach < 10; intKeysEach++) {
			System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
			new SleepMilliseconds(500);
		}
		//ToolTip1.clickAndHold(Element.getInstance().element).build().perform();
		//Actions.moveToElement(Element.getInstance().element).build().clickAndHold()
		// System.out.println(objWebElement.getLocation().getX());
		// System.out.println(objWebElement.getLocation().getY());
		// System.out.println(objWebElement.getSize().width);
		// System.out.println(objWebElement.getSize().height);
		//System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		new SleepMilliseconds(3000);
		// String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("This is a tooltip", "", "");
		// System.out.println(">>>>>>>>>>>>>>>>>");
		// System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText controlGetText value is: " + strToolTipAutoItText);
		// System.out.println(">>>>>>>>>>>>>>>>>");
		// System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
		// System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		// if (objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]")) {
		// 	System.out.println("winExists yes");
		// }
		boolean blnToolTipAutoItText = objAutoItSetObject.objAutoIt.winWaitActive("[TITLE:this is bold text]", "", 10);
		String strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText value is: " + strToolTipAutoItText);
		System.out.println(">>>>>>>>>>>>>>>>>");
		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPCLASS:(.*tooltips.*)]");
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle REGEXPCLASS class value is: " + strToolTipAutoItText);
		System.out.println(">>>>>>>>>>>>>>>>>");
		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle value is: " + strToolTipAutoItText);
		System.out.println(">>>>>>>>>>>>>>>>>");
		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:this is bold text]");
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  class value is: " + strToolTipAutoItText);
		System.out.println(">>>>>>>>>>>>>>>>>");
		new SleepMilliseconds(9000);
		//System.out.println("winExists = " + objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]"));
		//System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		//System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winActive("[CLASS:tooltips_class32]"));
		//System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		//While 1
		//    ; Look for a window of that class to appear
		//    If WinExists("[CLASS:tooltips_class32]", "") Then ; You may need more specific information here <<<<<<<<<<<<<<<<<<<<<<
		//        ; Get the position and size of the TrayTip
		//        $aPos = WinGetPos("[CLASS:tooltips_class32]", "") ; And here <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//        ; Exit the While...WEnd loop
		//        ExitLoop
		//    EndIf
		//WEnd
		//' Grab tooltip
		//ToolTip = Window("nativeclass:=tooltips_class32").GetROProperty("text")
		System.out.println("winGetState before tootip create = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		objAutoItSetObject.objAutoIt.toolTip("This is a AutoIt tooltip", 1000, 500);
		System.out.println("winGetState before 14 = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		System.out.println("winWaitActive = " + objAutoItSetObject.objAutoIt.winWaitActive("[CLASS:tooltips_class32]", "", 10));
		new SleepMilliseconds(14000);
		//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("This is a tooltip", "", "");
		//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.controlGetText("tooltips_class32", "", "");
		//String strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[ACTIVE]");
		//"[ACTIVE]"
		if (objAutoItSetObject.objAutoIt.winExists("[CLASS:tooltips_class32]")) {
			strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[CLASS:tooltips_class32]");
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText value is: " + strToolTipAutoItText);
			System.out.println(">>>>>>>>>>>>>>>>>");
		}
		System.out.println("winGetState = " + objAutoItSetObject.objAutoIt.winGetState("[CLASS:tooltips_class32]"));
		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[TITLE:This is a AutoIt toolti]");
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  TITLE value is: " + strToolTipAutoItText);
		System.out.println(">>>>>>>>>>>>>>>>>");
		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPTITLE:.*tooltip.*]");
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle  REGEXPTITLE value is: " + strToolTipAutoItText);
		System.out.println(">>>>>>>>>>>>>>>>>");
		strToolTipAutoItText = objAutoItSetObject.objAutoIt.winGetTitle("[REGEXPCLASS:(.*tooltips.*)]");
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>strToolTipAutoItText winGetTitle REGEXPCLASS class value is: " + strToolTipAutoItText);
		System.out.println(">>>>>>>>>>>>>>>>>");
		Dimension objWebDriverDimension = Element.getInstance().element.getSize();
		int intBrowserOuterWidth = objWebDriverDimension.width;
		int intBrowserOuterHeight = objWebDriverDimension.height;
		System.out.println(-((intBrowserOuterWidth / 2) + 1));
		System.out.println(-((intBrowserOuterHeight / 2) + 1));
		/////ToolTip1.moveByOffset(-((intBrowserOuterWidth / 2) + 1), -((intBrowserOuterHeight / 2) + 1)).build().perform();
		//ToolTip1.moveByOffset(-intBrowserOuterWidth + 1, -intBrowserOuterHeight + 1).build().perform();
		String ToolTipTitleText = Element.getInstance().element.getAttribute("title");
		System.out.println("ToolTipTitleText value is: " + ToolTipTitleText);
		//ToolTip1.release(objWebElement).perform();
		//ToolTip1.release().perform();
		//ToolTip1.moveByOffset(0, 0);
		String[][] arrWindows = objAutoItSetObject.objAutoIt.winList("");
		for (String[] arrResultsEach : arrWindows) {
			System.out.println("Window value is: " + arrResultsEach[1]);
		}
		return strToolTipAutoItText;
	}
}

