package org.tianyuan.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * �洢��ṹ����Ϣ
 * @author ����ѩ��
 *
 */
public class TableInfo {
	/**
	 * ����
	 */
	private String tname;
	
	/**
	 * ��������
	 */
	private List<ColumnInfo> primaryKeys;
	
	/**
	 * Ψһ����
	 */
	private ColumnInfo primaryKey;

	/**
	 * �����ֶε���Ϣ
	 */
	private Map<String,ColumnInfo> columns;

	public TableInfo() {
		
	}
	public TableInfo(String tname, List<ColumnInfo> priKeys,
			Map<String, ColumnInfo> columns) {
		super();
		this.tname = tname;
		this.primaryKeys = priKeys;
		this.columns = columns;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List<ColumnInfo> getPrimaryKeys() {
		return primaryKeys;
	}
	public void setPrimaryKeys(List<ColumnInfo> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
	public ColumnInfo getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(ColumnInfo primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	
}
