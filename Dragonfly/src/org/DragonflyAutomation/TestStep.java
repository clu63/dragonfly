package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestStep {
	public List<TestStepDetails> testModule = new ArrayList<TestStepDetails>();

	public class TestStepDetails {
		public String action;
		public String logicalName;
		public String tagName;
		public String attributeNames;
		public String attributeValues;
		public String inputValue;
		public String assertSet;
		public boolean optional;
		public boolean exitOnFail;
		public int millisecondsToWait;
		public String function;
		public String outputLinkName;
		public String loopOrIf;
		public boolean pleaseWait;
		public boolean highlight;
		public boolean screenshot;
		public String assistiveProperties;
		public String outputValue;
		public int browserInnerWidth;
		public int browserInnerHeight;
		public int browserOuterX;
		public int browserOuterY;
		public int browserOuterWidth;
		public int browserOuterHeight;
		public int elementScreenX;
		public int elementScreenY;
		public int elementX;
		public int elementY;
		public int elementWidth;
		public int elementHeight;
		public String tagType;
		public String typeValue;
		public String currentWindowHandle;
		public String urlValue;
		public String stepExpected;
		public String stepActual;
		public String startTimestamp;
		public String endTimestamp;
		public String stepDuration;
		public String screenshotArea;
		public String highlightArea;
		public String screenshotFilePath;
		public String status;
		public String testModuleStep;
	}
}
