package org.tianyuan.sorm.core;

import java.util.HashMap;
import java.util.Map;

/**
 * mysql数据类型和java数据类型的转换
 * @author 如墨
 *
 */
public class MysqlTypeConvertor implements TypeConvertor {

	private static Map<String,String> typeMap = null;
	
	static {
		typeMap = new HashMap<String,String>();
		
		typeMap.put("varchar","String");
		typeMap.put("char","String");
		typeMap.put("tinyint","Integer");
		typeMap.put("smallint","Integer");
		typeMap.put("int","Integer");
		typeMap.put("integet","Integer");
		typeMap.put("bigint","Long");
		typeMap.put("float","Double");
		typeMap.put("double","Double");
		typeMap.put("clob","java.sql.Clob");
		typeMap.put("blob","java.sql.Blob");
		typeMap.put("date","java.sql.Date");
		typeMap.put("time","java.sql.Time");
		typeMap.put("timestamp","java.sql.Timestamp");
	}
	
	@Override
	public String databaseType2JavaType(String columnType) {
		return typeMap.get(columnType.toLowerCase());
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		
		return null;
	}
	
}
