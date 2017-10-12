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
 * 根据配置信息，维持连接对象的管理(增加连接池功能)
 * @author 天问雪狼
 *
 */
public class DBManager {
	/**
	 * 配置信息
	 */
	private static Configuration conf = null;
	
	/**
	 * 连接池对象
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
	 * 返回Configuration对象
	 * @return Configuration对象
	 */
	public static Configuration getConfiguration() {
		return conf;
	}
	
	/**
	 * 创建新的连接
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
	 * 获得Connection对象
	 * @return 连接对象
	 */
	public static Connection getConnection() {
		if(pool == null) {
			pool = new DatabaseConnectionPool();
		}
		return pool.getConnection();
	}
	
	/**
	 * 关闭传入的ResultSet、Statement、Connection对象
	 * @param rs 传入的Result对象
	 * @param stmt 传入的Statement对象
	 * @param conn 传入的Connection对象
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
	 * 关闭传入的Statement、Connection对象
	 * @param stmt 传入的Statement对象
	 * @param conn 传入的Connection对象
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
	 * 关闭传入的Connection对象
	 * @param conn 传入的Connection对象
	 */
	public static void close(Connection conn) {
		pool.closeConnection(conn);
	}
}
