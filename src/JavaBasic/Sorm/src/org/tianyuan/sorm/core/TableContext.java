package org.tianyuan.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.tianyuan.sorm.bean.ColumnInfo;
import org.tianyuan.sorm.bean.TableInfo;
import org.tianyuan.sorm.util.JavaFileUtils;
import org.tianyuan.sorm.util.StringUtils;

/**
 * 负责管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
 * @author 天问雪狼
 *
 */
public class TableContext {
	/**
	 * 表明为key,表信息对象为value
	 */
	public static Map<String,TableInfo> tables = null;
	
	/**
	 * 将po的class对象和表信息关联起来，便于重用
	 */
	public static Map<Class<?>,TableInfo> poClassTableMap = null;
	
	static {
		tables = new HashMap<String,TableInfo>();
		poClassTableMap = new HashMap<Class<?>,TableInfo>();
		
		try {
			Connection conn = DBManager.getConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			
			ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
			while(tableRet.next()) {
				String tableName = (String) tableRet.getObject("TABLE_NAME");
				
				TableInfo ti = new TableInfo(tableName,new ArrayList<ColumnInfo>(),new HashMap<String,ColumnInfo>());
				tables.put(tableName, ti);
				
				ResultSet set = dbmd.getColumns(null,"%",tableName,"%");
				while(set.next()) {
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),set.getString("TYPE_NAME"),0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}
				
				ResultSet set2 = dbmd.getPrimaryKeys(null,"%",tableName);
				while(set2.next()) {
					ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);
					ti.getPrimaryKeys().add(ci2);
				}
				
				if(ti.getPrimaryKeys().size() > 0) {
					ti.setPrimaryKey(ti.getPrimaryKeys().get(0));
				}
			}
			
			updateJavaPOFile();
			loadPOTables();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 根据表结构，更新配置的po包下的Java类
	 */
	public static void updateJavaPOFile() {
		Map<String,TableInfo> tables = TableContext.tables;
		for(TableInfo t : tables.values()) {
			JavaFileUtils.createJavaPOFile(t, new MysqlTypeConvertor());
		}
	}
	
	/**
	 * 加载po包下的类
	 */
	public static void loadPOTables() {
		for(TableInfo ti : tables.values()) {
			Class<?> c;
			try {
				c = Class.forName(DBManager.getConfiguration().getPoPackage() + "." + StringUtils.firstCharToUppercase(ti.getTname()));
				poClassTableMap.put(c,ti);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	private TableContext() {
		
	}
}
