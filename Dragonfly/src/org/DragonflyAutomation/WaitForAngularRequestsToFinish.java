package org.DragonflyAutomation;

import org.openqa.selenium.JavascriptExecutor;

class WaitForAngularRequestsToFinish {
	WaitForAngularRequestsToFinish(JavascriptExecutor driver) {
		Logger.getInstance().add("  ==start==>WaitForAngularRequestsToFinish " + Util.getDateTimestamp());
		driver.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
	}
}
