package org.tianyuan.sorm.util;

import java.lang.reflect.Method;

/**
 * ��װ�˷��䳣�õĲ���
 * @author ����ѩ��
 *
 */
public class ReflectUtils {
	
	/**
	 * ����obj�����Ӧ����fieldName��get����
	 * @param fieldName ��������
	 * @param obj Ҫ����get������obj����
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
	 * ����obj�����Ӧ����fieldName��set����
	 * @param fieldName ��������
	 * @param obj Ҫ����set������obj����
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
