package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestElementList {
	private List<Objects> element = new ArrayList<Objects>();
	private List<Objects> error = new ArrayList<Objects>();
	private List<Objects> processing = new ArrayList<Objects>();
	private String testApplication;
	private transient Integer elementEach;

	boolean findElement(String logicalName) {
		for (elementEach = 0; elementEach < this.element.size(); elementEach++) {
			if (element.get(elementEach).getLogicalName().equalsIgnoreCase(logicalName)) {
				System.out.println("findElement true");
				return true;
			}
		}
		System.out.println("findElement false");
		return false;
	}

	Objects getElement() {
		return element.get(elementEach);
	}

	List<Objects> getError() {
		return error;
	}

	List<Objects> getProcessing() {
		return processing;
	}

	String getTestApplication() {
		return this.testApplication;
	}

	void setElement(List<Objects> element) {
		this.element = element;
	}

	void setError(List<Objects> processing) {
		this.processing = processing;
	}

	void setProcessing(List<Objects> element) {
		this.element = element;
	}

	void setTestApplication(String logicalName) {
		this.testApplication = logicalName;
	}

	class Objects {
		private String attributeNames;
		private String attributeValues;
		private String logicalName;
		private String tagName;

		String getAttributeNames() {
			return this.attributeNames;
		}

		String getAttributeValues() {
			return this.attributeValues;
		}

		String getLogicalName() {
			return this.logicalName;
		}

		String getTagName() {
			return this.tagName;
		}

		void setAttributeNames(String attributeNames) {
			this.attributeNames = attributeNames;
		}

		void setAttributeValues(String attributeValues) {
			this.attributeValues = attributeValues;
		}

		void setLogicalName(String logicalName) {
			this.logicalName = logicalName;
		}

		void setTagName(String tagName) {
			this.tagName = tagName;
		}
	}
}
