package org.tianyuan.sorm.util;

/**
 * ��װ���ַ������õĲ���
 * @author ����ѩ��
 *
 */
public class StringUtils {
	/**
	 * ��Ŀ���ַ�������ĸ��ɴ�д
	 * @param str Ŀ���ַ���
	 * @return ����ĸ��ɴ�д���ַ���
	 */
	public static String firstCharToUppercase(String str) {
		return str.toUpperCase().substring(0,1) + str.substring(1);
	}
}
