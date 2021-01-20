package org.DragonflyAutomation;

class ElementSetSyncComplete {
	ElementSetSyncComplete(String strOuterHTML) throws ExceptionAlertNotComplete, ExceptionDoPostBackNotComplete, ExceptionJQueryAjaxNotComplete, ExceptionJQueryAnimationNotComplete, ExceptionAngularJsNotComplete, ExceptionPleaseWaitNotComplete {
		Logger.getInstance().add("  ==start==>ElementSetSyncComplete " + Util.getDateTimestamp());
		long lngTimeStart = System.currentTimeMillis();
		try {
			if (Config.getInstance().syncPleaseWait == false) {
				///SyncPleaseWait
				new SyncPleaseWait();
				Config.getInstance().syncPleaseWait = true;
			}
			// 	if (Config.getInstance().syncAlert == false) {
			// 		///SyncAlert
			// 		new SyncAlert();
			// 		Config.getInstance().syncAlert = true;
			// 	}
			if (Config.getInstance().syncWaitForReadyState == false) {
				///SyncWaitForReadyState
				new SyncWaitForReadyState();
				Config.getInstance().syncWaitForReadyState = true;
			}
			if (Config.getInstance().syncDoPostBack == false) {
				///SyncDoPostBack
				new SyncDoPostBack(strOuterHTML);
				Config.getInstance().syncDoPostBack = true;
			}
			if (Config.getInstance().syncJQueryAjax == false) {
				///SyncJQueryAjax
				new SyncJQueryAjax();
				Config.getInstance().syncJQueryAjax = true;
			}
			if (Config.getInstance().syncJQueryAnimation == false) {
				///SyncJQueryAnimation
				new SyncJQueryAnimation();
				Config.getInstance().syncJQueryAnimation = true;
			}
			if (Config.getInstance().syncAngularJs == false) {
				///SyncAngularJs
				new SyncAngularJs();
				Config.getInstance().syncAngularJs = true;
			}
		} finally {
			Logger.getInstance().add("ElementSetSyncComplete: finally Milliseconds Waited = " + (int) (System.currentTimeMillis() - lngTimeStart));
		}
	}
}
