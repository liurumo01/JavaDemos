package org.tianyuan.sorm.core;

/**
 * 负责Java数据类型和数据库数据类型的互相转换
 * @author 天问雪狼
 *
 */
public interface TypeConvertor {
	/**
	 * 将数据库数据类型转化成Java数据类型
	 * @param columnType 数据库字段的数据类型
	 * @return Java数据类型
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * 将Java数据类型转化成数据库数据类型
	 * @param javaDataType 数据库字段的数据类型
	 * @return 数据库数据类型
	 */
	public String javaType2DatabaseType(String javaDataType);
}
