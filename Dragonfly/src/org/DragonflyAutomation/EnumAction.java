package org.DragonflyAutomation;

enum EnumAction {
	BREAK("break"),
	CLOSE("close"),
	DRAG("drag"),
	DROP("drop"),
	GET("get"),
	KILL_IE("kill_ie"),
	LAUNCH("launch"),
	MOUSE_OUT("mouse_out"),
	MOUSE_OVER("mouse_over"),
	REFRESH("refresh"),
	SCROLL("scroll"),
	SET("set"),
	SET_JS("set_js"),
	SLEEP("sleep"),
	SYNC_DISABLED("sync_disabled"),
	SYNC_ENABLED("sync_enabled"),
	SYNC_HIDDEN("sync_hidden"),
	SYNC_VISIBLE("sync_visible"),
	TOOLTIP_GET("tooltip_get"),
	TOOLTIP_VERIFY("tooltip_verify"),
	VERIFY("verify"),
	VERIFY_NOT("verify_not");
	private final String actionOption;

	private EnumAction(String actionOption) {
		this.actionOption = actionOption;
	}

	String getActionOption() {
		return actionOption;
	}
}
