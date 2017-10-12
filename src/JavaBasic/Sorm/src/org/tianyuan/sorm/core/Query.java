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
 * 负责查询(对外提供服务的核心类)
 * @author 天问雪狼
 *
 */
public abstract class Query implements Cloneable {
	
	/**
	 * 采用模板方法模式将JDBC操作封装成模板，便于重用
	 * @param sql sql语句
	 * @param params sql的参数
	 * @param clazz 记录到要封装到的Java类
	 * @param back CallBack的实现类，实现回调
	 * @return 查询结果
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
	 * 直接执行一个sql语句
	 * @param sql sql语句
	 * @param params 参数
	 * @return 执行sql语句后影响记录的行数
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
	 * 将一个对象存储到数据库中
	 * @param obj 要存储的对象
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
	 * 从数据库中clazz表示类对应的标中的记录(指定主键值id的记录)
	 * @param clazz 与表对应的类的Class对象
	 * @param id 主键的值
	 */
	public void delete(Class<?> clazz, Object pkValue) {
		TableInfo ti = TableContext.poClassTableMap.get(clazz);
		ColumnInfo pk = ti.getPrimaryKey();
		String sql = "delete from " + ti.getTname() + " where " + pk.getName() + " = ?";
		executeDML(sql, new Object[] {pkValue});
		System.out.println("删除成功");
	}
	
	/**
	 * 删除对象在数据库中的记录(对象所在的类对应到表，对象的主键的值对应到记录)
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
	 * 更新对象对应的记录，并且只更新指定的字段的值
	 * @param obj 所要更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return 执行sql语句后影响记录的行数
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
	 * 查询返回多行记录，并将每行记录封装到clazz对象指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的JavaBean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
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
	 * 查询返回一行记录，并将该记录封装到clazz对象指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的JavaBean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryUniqueRows(String sql, Class<?> clazz, Object[] params) {
		List<Object> list = queryRows(sql, clazz, params);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}
	
	/**
	 * 查询返回一个值(一行一列)，并将该值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的结果
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
	 * 查询返回一个数字，并将该数字返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}
	
	/**
	 * 分页查询
	 * @param pagNum 页码
	 * @param size 每页显示的数据条数
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
