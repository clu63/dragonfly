package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class WaitForAngularRequestsToFinish {
	WaitForAngularRequestsToFinish(JavascriptExecutor objDriver) {
		Logger.getInstance().add("  ==start==>WaitForAngularRequestsToFinish " + Util.getDateTimestamp());
		objDriver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
	}
}
