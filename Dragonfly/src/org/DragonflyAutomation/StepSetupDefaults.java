package org.DragonflyAutomation;

import java.lang.reflect.Field;

//class StepSetupDefaults {
//	String strDefault_blnExitOnFail = "true";
//	String strDefault_blnHighlight = "true";
//	String strDefault_blnOptional = "false";
//	String strDefault_blnPleaseWait = "true";
//	String strDefault_blnScreenshot = "true";
//	String strDefault_intMillisecondsToWait = "120000";
//	String strDefault_strAssert = "off";
//	String strDefault_strScreenshotArea = "screen";
//	String strDefault_strStatus = "info";
//
//	StepSetupDefaults(String strCurrentWindowHandle) {
//		String[] arrDefaultKeys = new StepNames().getDefault();
//		String[] arrKeys = new StepNames().getRuntime();
//		for (String strKey : arrKeys) {
//			if (!strKey.equals("strTestModuleStep")) {
//				JSONS.getInstance().step.putValue(strKey, "");
//			}
//		}
//		new KeywordsValid();
//		Class<?> objClass = null;
//		try {
//			objClass = Class.forName("org.DragonflyAutomation.Dragonfly$StepSetupDefaults");
//		} catch (ClassNotFoundException e) {
//			Logger.getInstance().add("StepSetupDefaults: ClassNotFoundException = " + e.toString());
//		} catch (Exception e) {
//			Logger.getInstance().add("StepSetupDefaults: Class.forName Exception = " + e.toString());
//		}
//		for (String strKey : arrDefaultKeys) {
//			Field objField = null;
//			try {
//				objField = objClass.getDeclaredField("strDefault_" + strKey);
//			} catch (NoSuchFieldException | SecurityException e) {
//				Logger.getInstance().add("StepSetupDefaults: NoSuchFieldException = " + e.toString());
//			} catch (Exception e) {
//				Logger.getInstance().add("StepSetupDefaults: Exception = " + e.toString());
//			}
//			if (JSONS.getInstance().step.getValueLength(strKey) == 0) {
//				try {
//					JSONS.getInstance().step.putValue(strKey, (String) objField.get(this));
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					Logger.getInstance().add("StepSetupDefaults: IllegalArgumentException = " + e.toString());
//					e.printStackTrace();
//				} catch (Exception e) {
//					Logger.getInstance().add("StepSetupDefaults: Exception = " + e.toString());
//				}
//			}
//		}
//		JSONS.getInstance().step.putValue("strCurrentWindowHandle", strCurrentWindowHandle);
//	}
//}
