package org.DragonflyAutomation;

import java.lang.reflect.InvocationTargetException;

class ClassByName {
	String getReturnString(String className, String inputValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		Class<?> classByName = Class.forName("org.DragonflyAutomation." + className);
		return (String) classByName.getMethod("returnString", String.class).invoke(classByName.newInstance(), inputValue);
	}
}
