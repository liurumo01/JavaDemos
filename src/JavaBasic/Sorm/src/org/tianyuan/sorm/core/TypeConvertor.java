package org.tianyuan.sorm.core;

/**
 * ����Java�������ͺ����ݿ��������͵Ļ���ת��
 * @author ����ѩ��
 *
 */
public interface TypeConvertor {
	/**
	 * �����ݿ���������ת����Java��������
	 * @param columnType ���ݿ��ֶε���������
	 * @return Java��������
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * ��Java��������ת�������ݿ���������
	 * @param javaDataType ���ݿ��ֶε���������
	 * @return ���ݿ���������
	 */
	public String javaType2DatabaseType(String javaDataType);
}
