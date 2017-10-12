package org.tianyuan.sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.tianyuan.sorm.core.DBManager;

/**
 * 连接池的类
 * @author 天问雪狼
 *
 */
public class DatabaseConnectionPool {
	/**
	 * 连接池对象
	 */
	private List<Connection> pool;
	
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConfiguration().getConnectionPoolMaxSize();
	
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConfiguration().getConnectionPoolMinSize();
	
	/**
	 * 初始化连接池，使池中连接数达到最小值
	 */
	public void initPool() {
		if(pool == null) {
			pool = new ArrayList<Connection>();
		}
		while(pool.size() < POOL_MIN_SIZE) {
			pool.add(DBManager.createConnection());
			System.out.println("初始化连接池，池中连接数" + pool.size());
		}
	}
	
	/**
	 * 从连接池中取出一个链接
	 * @return 连接对象
	 */
	public synchronized Connection getConnection() {
		return pool.remove(pool.size() - 1);
	}
	
	/**
	 * 将连接放回连接池
	 */
	public synchronized void closeConnection(Connection conn) {
		if(pool.size() == POOL_MAX_SIZE) {
			try {
				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			pool.add(conn);
		}
	}
	
	public DatabaseConnectionPool() {
		initPool();
	}
	
}
