package org.tianyuan.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.tianyuan.sorm.bean.Configuration;
import org.tianyuan.sorm.pool.DatabaseConnectionPool;

/**
 * ����������Ϣ��ά�����Ӷ���Ĺ���(�������ӳع���)
 * @author ����ѩ��
 *
 */
public class DBManager {
	/**
	 * ������Ϣ
	 */
	private static Configuration conf = null;
	
	/**
	 * ���ӳض���
	 */
	private static DatabaseConnectionPool pool;
	
	static {
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setConnectionPoolMaxSize(pros.getProperty("connectionPoolMaxSize"));
		conf.setConnectionPoolMinSize(pros.getProperty("connectionPoolMinSize"));
		
		System.out.println(TableContext.class);
	}
	
	/**
	 * ����Configuration����
	 * @return Configuration����
	 */
	public static Configuration getConfiguration() {
		return conf;
	}
	
	/**
	 * �����µ�����
	 * @return
	 */
	public static Connection createConnection() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ���Connection����
	 * @return ���Ӷ���
	 */
	public static Connection getConnection() {
		if(pool == null) {
			pool = new DatabaseConnectionPool();
		}
		return pool.getConnection();
	}
	
	/**
	 * �رմ����ResultSet��Statement��Connection����
	 * @param rs �����Result����
	 * @param stmt �����Statement����
	 * @param conn �����Connection����
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		try {
			if(stmt != null) {
				stmt.close();
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		pool.closeConnection(conn);
	}
	
	/**
	 * �رմ����Statement��Connection����
	 * @param stmt �����Statement����
	 * @param conn �����Connection����
	 */
	public static void close(Statement stmt,Connection conn) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		pool.closeConnection(conn);
	}
	
	/**
	 * �رմ����Connection����
	 * @param conn �����Connection����
	 */
	public static void close(Connection conn) {
		pool.closeConnection(conn);
	}
}
