package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestElement {
	private TestElementBuild testElement;

	class ElementFields {
		private String logicalName;
		private String tagName;
		private String attributeNames;
		private String attributeValues;

		String getAttributeNames() {
			return attributeNames;
		}

		String getAttributeValues() {
			return attributeValues;
		}

		String getLogicalName() {
			return logicalName;
		}

		String getTagName() {
			return tagName;
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

	class TestElementBuild {
		private String testApplication;
		private List<ElementFields> element = new ArrayList<ElementFields>();
		private List<ElementFields> error = new ArrayList<ElementFields>();
		private List<ElementFields> processing = new ArrayList<ElementFields>();
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

		ElementFields getElement() {
			return element.get(elementEach);
		}

		//		TestElementList getElementByLogicalName(String logicalName) {
		//			for (elementEach = 0; elementEach < this.element.size(); elementEach++) {
		//				if (element.get(elementEach).getLogicalName().equalsIgnoreCase(logicalName)) {
		//					System.out.println("findElement true");
		//				}
		//			}
		//			return this;
		//		}
		List<ElementFields> getError() {
			return error;
		}

		List<ElementFields> getProcessing() {
			return processing;
		}

		String getTestApplication() {
			return this.testApplication;
		}

		void setElement(List<ElementFields> element) {
			this.element = element;
		}

		void setError(List<ElementFields> processing) {
			this.processing = processing;
		}

		void setProcessing(List<ElementFields> element) {
			this.element = element;
		}

		void setTestApplication(String logicalName) {
			this.testApplication = logicalName;
		}
	}
}