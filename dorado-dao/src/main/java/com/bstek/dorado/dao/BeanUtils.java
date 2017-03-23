package com.bstek.dorado.dao;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

/**
 * Bean工具类。
 * 
 *@author Kevin.yang
 *@since 2015年5月16日
 */
public final class BeanUtils {
	
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object bean, String name) {
		Field field;
		T result = null;
		try {
			field =ReflectionUtils.findField(bean.getClass(), name);
			field.setAccessible(true);
			result = (T) field.get(bean);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object bean, Field field) {
		T result = null;
		try {
			field.setAccessible(true);
			result = (T) field.get(bean);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public static void setFieldValue(Object bean, String fieldName, Object value) {
		try {
			Field field = ReflectionUtils.findField(bean.getClass(), fieldName);
			field.setAccessible(true);
			field.set(bean, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static Object newInstance(Class<?> cls) {
		Object obj = null;
		try {
			obj = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
