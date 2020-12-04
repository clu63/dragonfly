package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//@SuppressWarnings("unchecked")
class JSON {
	//private static final long serialVersionUID = 1L;
	JSONObject jSONObject = null;

	JSON() {
	}

	JSON(JSONObject parent) {
		this.jSONObject.putAll(parent);
	}

	void addJsonObject(JSONObject objJsonObjectToAdd) {
		if (this.jSONObject.isEmpty() == true) {
		} else {
			this.jSONObject.putAll(objJsonObjectToAdd);
		}
	}

	boolean containsKey(String strKeyName) {
		return this.jSONObject.containsKey(strKeyName);
	}

	JSONArray getArray(String strJsonArrayName) {
		return (JSONArray) this.jSONObject.get(strJsonArrayName);
	}

	Boolean getBoolean(String strKeyName) {
		return Boolean.parseBoolean(this.jSONObject.get(strKeyName).toString());
	}

	int getInt(String strKeyName) {
		if (this.getString(strKeyName).equals("")) {
			return 0;
		}
		return Integer.parseInt(this.jSONObject.get(strKeyName).toString());
	}

	String getLowerCase(String strKeyName) {
		return this.getString(strKeyName).toLowerCase();
	}

	JSONObject getNode(String strKeyName) {
		return (JSONObject) this.jSONObject.get(strKeyName);
	}

	String getString(String strKeyName) {
		String strJSONObjectValue = "";
		if (this.jSONObject.containsKey(strKeyName)) {
			strJSONObjectValue = this.jSONObject.get(strKeyName).toString();
			// Logger.getInstance().add("JSONObjectExtended:getString strJSONObjectValue = " + strJSONObjectValue);
			return strJSONObjectValue;
		} else {
			// Logger.getInstance().add("JSONObjectExtended:getString JSON Key " + strKeyName + " for keyword link name " + strKeyName + " not present");
			return "";
		}
	}

	String getValue(String strInputValue, String strKeywordName) throws ExceptionJSONKeyNotPresent {
		String strJSONObjectKey = strInputValue.replace(strKeywordName, "");
		String strJSONObjectValue = "";
		this.validateKey(strJSONObjectKey);
		strJSONObjectValue = this.getString(strJSONObjectKey);
		return strJSONObjectValue;
	}

	int getValueLength(String strKeyName) {
		return (int) this.jSONObject.get(strKeyName).toString().trim().length();
	}

	void parseString(String stringToParse) throws ParseException {
		this.jSONObject = (JSONObject) new JSONParser().parse(stringToParse);
	}

	void putValue(String strKeyName, String strKeyValue) {
		this.jSONObject.put(strKeyName, strKeyValue);
	}

	void replaceAllFromFile(String pathFileToParse) throws ParseException, FileNotFoundException, IOException {
		//this.jSONObject.clear();
		this.jSONObject = (JSONObject) new JSONParser().parse(new FileReader(pathFileToParse));
	}

	void replaceAllFromJSONObject(JSONObject jSONObject) {
		//this.jSONObject.clear();
		this.jSONObject = jSONObject;
	}

	void replaceAllFromMap(Map<String, String> map) {
		//this.jSONObject.clear();
		this.jSONObject.putAll((Map<String, String>) map);
	}

	void replaceAllFromString(String stringToParse) throws ParseException {
		//this.jSONObject.clear();
		this.jSONObject = (JSONObject) new JSONParser().parse(stringToParse);
	}

	String returnKeyword(String strKeyName1) {
		String strValueToFindKeyword = this.getLowerCase(strKeyName1);
		int intRightArrowPosition = strValueToFindKeyword.indexOf(">");
		String strKeyword = "";
		if (intRightArrowPosition > -1) {
			strKeyword = strValueToFindKeyword.substring(0, intRightArrowPosition + 1);
		}
		return strKeyword;
	}

	int size() {
		return this.jSONObject.size();
	}

	String toJSONString() {
		return this.jSONObject.toJSONString();
	}

	void validateKey(String strKeyName) throws ExceptionJSONKeyNotPresent {
		if (!this.jSONObject.containsKey(strKeyName)) {
			throw new ExceptionJSONKeyNotPresent("JSON Key " + strKeyName + " not present");
		}
	}

	Boolean verifyEquals(String strKeyName, String strLowerCaseValue) {
		return this.jSONObject.get(strKeyName).toString().trim().toLowerCase().equals(strLowerCaseValue);
	}

	Boolean verifyKeyValue(String file) {
		return null;
	}

	void writeKeys(String file) throws IOException {
		for (Iterator<?> iterator = this.jSONObject.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Logger.getInstance().add("WriteJsonKeys: " + key + " = " + this.jSONObject.get(key));
		}
	}
}
