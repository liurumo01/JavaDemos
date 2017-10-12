package org.tianyuan.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.tianyuan.sorm.bean.ColumnInfo;
import org.tianyuan.sorm.bean.TableInfo;
import org.tianyuan.sorm.util.JDBCUtils;
import org.tianyuan.sorm.util.ReflectUtils;

/**
 * �����ѯ(�����ṩ����ĺ�����)
 * @author ����ѩ��
 *
 */
public abstract class Query implements Cloneable {
	
	/**
	 * ����ģ�巽��ģʽ��JDBC������װ��ģ�壬��������
	 * @param sql sql���
	 * @param params sql�Ĳ���
	 * @param clazz ��¼��Ҫ��װ����Java��
	 * @param back CallBack��ʵ���࣬ʵ�ֻص�
	 * @return ��ѯ���
	 */
	public Object executeQueryTemplate(String sql,Object[] params,Class<?> clazz,CallBack back) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			return back.doExecute(conn, ps, rs);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			DBManager.close(ps, conn);
		}
	}
	
	/**
	 * ֱ��ִ��һ��sql���
	 * @param sql sql���
	 * @param params ����
	 * @return ִ��sql����Ӱ���¼������
	 */
	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConnection();
		int count = 0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			count = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * ��һ������洢�����ݿ���
	 * @param obj Ҫ�洢�Ķ���
	 */
	public void insert(Object obj) {
		Class<?> c = obj.getClass();
		TableInfo ti = TableContext.poClassTableMap.get(c);
		Field[] fs = c.getDeclaredFields();
		StringBuilder sql = new StringBuilder("insert into " + ti.getTname() + " (");
		int count = 0;
		List<Object> params = new ArrayList<Object>();
		for(Field f : fs) {
			String fieldName = f.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			if(fieldValue != null) {
				sql.append(fieldName + ",");
				params.add(fieldValue);
				count++;
			}
		}
		sql.setCharAt(sql.length() - 1, ')');
		sql.append(" values (");
		for(int i=0;i<count;i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length() - 1, ')');
		executeDML(sql.toString(), params.toArray());
	}
	
	/**
	 * �����ݿ���clazz��ʾ���Ӧ�ı��еļ�¼(ָ������ֵid�ļ�¼)
	 * @param clazz ����Ӧ�����Class����
	 * @param id ������ֵ
	 */
	public void delete(Class<?> clazz, Object pkValue) {
		TableInfo ti = TableContext.poClassTableMap.get(clazz);
		ColumnInfo pk = ti.getPrimaryKey();
		String sql = "delete from " + ti.getTname() + " where " + pk.getName() + " = ?";
		executeDML(sql, new Object[] {pkValue});
		System.out.println("ɾ���ɹ�");
	}
	
	/**
	 * ɾ�����������ݿ��еļ�¼(�������ڵ����Ӧ���������������ֵ��Ӧ����¼)
	 * @param obj
	 */
	public void delete(Object obj) {
		Class<?> c = obj.getClass();
		TableInfo ti = TableContext.poClassTableMap.get(c);
		ColumnInfo pk = ti.getPrimaryKey();
		Object pkValue =  ReflectUtils.invokeGet(pk.getName(), obj);
		delete(c,pkValue);
	}
	
	/**
	 * ���¶����Ӧ�ļ�¼������ֻ����ָ�����ֶε�ֵ
	 * @param obj ��Ҫ���µĶ���
	 * @param fieldNames ���µ������б�
	 * @return ִ��sql����Ӱ���¼������
	 */
	public int update(Object obj, String[] fieldNames) {
		Class<?> c = obj.getClass();
		TableInfo ti = TableContext.poClassTableMap.get(c);
		ColumnInfo pk = ti.getPrimaryKey();
		StringBuilder sql = new StringBuilder("update " + ti.getTname() + " set");
		List<Object> params = new ArrayList<Object>();
		for(String fname : fieldNames) {
			Object fValue = ReflectUtils.invokeGet(fname, obj);
			sql.append(" " + fname + " = ?,");
			params.add(fValue);
		}
		sql.setCharAt(sql.length() - 1, ' ');
		sql.append("where " + pk.getName() + " = ?");
		params.add(ReflectUtils.invokeGet(pk.getName(), obj));
		
		return executeDML(sql.toString(), params.toArray());
	}
	
	/**
	 * ��ѯ���ض��м�¼������ÿ�м�¼��װ��clazz����ָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�JavaBean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	@SuppressWarnings("unchecked")
	public List<Object> queryRows(String sql, Class<?> clazz, Object[] params) {
		return (List<Object>)executeQueryTemplate(sql, params, clazz, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				List<Object> rows = null;
				try {
					ResultSetMetaData metaData = rs.getMetaData();
					while(rs.next()) {
						if(rows == null) {
							rows = new ArrayList<Object>();
						}
						Object rowObj = clazz.newInstance();
						for(int i=0;i<metaData.getColumnCount();i++) {
							String columnName = metaData.getColumnLabel(i + 1);
							Object columnValue = rs.getObject(i + 1);
							ReflectUtils.invokeSet(columnName, columnValue, rowObj);
						}
						rows.add(rowObj);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return (Object)rows;
			}
		});
	}
	
	/**
	 * ��ѯ����һ�м�¼�������ü�¼��װ��clazz����ָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�JavaBean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRows(String sql, Class<?> clazz, Object[] params) {
		List<Object> list = queryRows(sql, clazz, params);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}
	
	/**
	 * ��ѯ����һ��ֵ(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql, Object[] params) {
		
		return executeQueryTemplate(sql, params, null, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value = null;
				try {
					while(rs.next()) {
						value = rs.getObject(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return value;
			}
		});
	}
	
	/**
	 * ��ѯ����һ�����֣����������ַ���
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pagNum ҳ��
	 * @param size ÿҳ��ʾ����������
	 * @return
	 */
	public abstract Object queryPagenate(int pagNum,int size);
	
	@Override
	public Query clone() {
		try {
			return (Query) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
