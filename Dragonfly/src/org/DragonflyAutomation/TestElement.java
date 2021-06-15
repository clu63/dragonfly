package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestElement {
	private TestElementDetail testElement;

	class ObjectDetail {
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

	class TestElementDetail {
		private String testApplication;
		private List<ObjectDetail> element = new ArrayList<ObjectDetail>();
		private List<ObjectDetail> error = new ArrayList<ObjectDetail>();
		private List<ObjectDetail> processing = new ArrayList<ObjectDetail>();
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

		ObjectDetail getElement() {
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
		List<ObjectDetail> getError() {
			return error;
		}

		List<ObjectDetail> getProcessing() {
			return processing;
		}

		String getTestApplication() {
			return this.testApplication;
		}

		void setElement(List<ObjectDetail> element) {
			this.element = element;
		}

		void setError(List<ObjectDetail> processing) {
			this.processing = processing;
		}

		void setProcessing(List<ObjectDetail> element) {
			this.element = element;
		}

		void setTestApplication(String logicalName) {
			this.testApplication = logicalName;
		}
	}
}