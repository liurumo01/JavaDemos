package org.tianyuan.sorm.util;

import java.lang.reflect.Method;

/**
 * 封装了反射常用的操作
 * @author 天问雪狼
 *
 */
public class ReflectUtils {
	
	/**
	 * 调用obj对象对应属性fieldName的get方法
	 * @param fieldName 属性名称
	 * @param obj 要调用get方法的obj对象
	 * @return
	 */
	public static Object invokeGet(String fieldName,Object obj) {
		try {
			Class<?> c = obj.getClass();
			Method m = c.getDeclaredMethod("get" + StringUtils.firstCharToUppercase(fieldName));
			return m.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 调用obj对象对应属性fieldName的set方法
	 * @param fieldName 属性名称
	 * @param obj 要调用set方法的obj对象
	 * @return
	 */
	public static void invokeSet(String fieldName,Object columnValue,Object obj) {
		try {
			if(columnValue == null) {
				return;
			}
			Class<?> c = obj.getClass();
			Method m = c.getDeclaredMethod("set" + StringUtils.firstCharToUppercase(fieldName), columnValue.getClass());
			m.invoke(obj, columnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
