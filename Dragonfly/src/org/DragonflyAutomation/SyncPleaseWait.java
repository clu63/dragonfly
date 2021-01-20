package org.DragonflyAutomation;

class SyncPleaseWait {
	SyncPleaseWait() throws ExceptionDoPostBackNotComplete {
		long lngStartTime = System.currentTimeMillis();
		Logger.getInstance().add("  ==start==>SyncPleaseWait " + Util.getDateTimestamp());
		try {
			new ElementPleaseWaitSync();
		} catch (ExceptionElementNotHidden e1) {
			Logger.getInstance().add("SyncPleaseWait: ExceptionElementNotHidden = " + e1.toString());
			throw new ExceptionDoPostBackNotComplete("");
		} catch (Exception e) {
			Logger.getInstance().add("SyncPleaseWait: Exception = " + e.toString());
		} finally {
			Logger.getInstance().add("SyncPleaseWait: Milliseconds Waited = " + (System.currentTimeMillis() - lngStartTime));
		}
	}
}
