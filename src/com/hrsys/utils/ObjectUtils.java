package com.hrsys.utils;

import java.io.IOException;
import java.util.Properties;

public class ObjectUtils {
	private static Properties properties = null;
	static{
		properties = new Properties();
		try {
			properties.load(ObjectUtils.class.getClassLoader().getResourceAsStream("object.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> T getObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<T> class1 = (Class<T>) Class.forName(properties.getProperty(className));
		T t = (T) class1.newInstance();
		return t;
	}
}
