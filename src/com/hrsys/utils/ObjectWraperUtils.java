package com.hrsys.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectWraperUtils {
	public static <T> T getObject(HttpServletRequest request,Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		T t = clazz.newInstance();
		BeanUtils.populate(t, request.getParameterMap());
		return t;
	}
}
