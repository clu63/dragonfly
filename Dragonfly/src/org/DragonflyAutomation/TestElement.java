package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.List;

class TestElement {
	class Element {
		private String logicalName;
		private String tagName;
		private String attributeNames;
		private String attributeValues;

		void setLogicalName(String logicalName) {
			this.logicalName = logicalName;
		}

		String getLogicalName() {
			return this.logicalName;
		}

		void setTagName(String tagName) {
			this.tagName = tagName;
		}

		String getTagName() {
			return this.tagName;
		}

		void setAttributeNames(String attributeNames) {
			this.attributeNames = attributeNames;
		}

		String getAttributeNames() {
			return this.attributeNames;
		}

		void setAttributeValues(String attributeValues) {
			this.attributeValues = attributeValues;
		}

		String getAttributeValues() {
			return this.attributeValues;
		}
	}

	class Processing {
		private String logicalName;
		private String tagName;
		private String attributeNames;
		private String attributeValues;

		void setLogicalName(String logicalName) {
			this.logicalName = logicalName;
		}

		String getLogicalName() {
			return this.logicalName;
		}

		void setTagName(String tagName) {
			this.tagName = tagName;
		}

		String getTagName() {
			return this.tagName;
		}

		void setAttributeNames(String attributeNames) {
			this.attributeNames = attributeNames;
		}

		String getAttributeNames() {
			return this.attributeNames;
		}

		void setAttributeValues(String attributeValues) {
			this.attributeValues = attributeValues;
		}

		String getAttributeValues() {
			return this.attributeValues;
		}
	}

	class Error {
		private String logicalName;
		private String tagName;
		private String attributeNames;
		private String attributeValues;

		void setLogicalName(String logicalName) {
			this.logicalName = logicalName;
		}

		String getLogicalName() {
			return this.logicalName;
		}

		void setTagName(String tagName) {
			this.tagName = tagName;
		}

		String getTagName() {
			return this.tagName;
		}

		void setAttributeNames(String attributeNames) {
			this.attributeNames = attributeNames;
		}

		String getAttributeNames() {
			return this.attributeNames;
		}

		void setAttributeValues(String attributeValues) {
			this.attributeValues = attributeValues;
		}

		String getAttributeValues() {
			return this.attributeValues;
		}
	}

	class Root2 {
		private String testElement;
		private List<Element> element;
		private List<Processing> processing;
		private List<Error> error;

		void setTestElement(String testElements) {
			this.testElement = testElements;
		}

		String getTestElements() {
			return this.testElement;
		}

		void setElemens(List<Element> element) {
			this.element = element;
		}

		List<Element> getElements() {
			return this.element;
		}

		void setProcessing(List<Processing> processing) {
			this.processing = processing;
		}

		List<Processing> getProcessing() {
			return this.processing;
		}

		void setError(List<Error> errors) {
			this.error = errors;
		}

		List<Error> getError() {
			return this.error;
		}
	}
}