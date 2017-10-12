package org.tianyuan.sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.tianyuan.sorm.core.DBManager;

/**
 * ���ӳص���
 * @author ����ѩ��
 *
 */
public class DatabaseConnectionPool {
	/**
	 * ���ӳض���
	 */
	private List<Connection> pool;
	
	/**
	 * ���������
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConfiguration().getConnectionPoolMaxSize();
	
	/**
	 * ��С������
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConfiguration().getConnectionPoolMinSize();
	
	/**
	 * ��ʼ�����ӳأ�ʹ�����������ﵽ��Сֵ
	 */
	public void initPool() {
		if(pool == null) {
			pool = new ArrayList<Connection>();
		}
		while(pool.size() < POOL_MIN_SIZE) {
			pool.add(DBManager.createConnection());
			System.out.println("��ʼ�����ӳأ�����������" + pool.size());
		}
	}
	
	/**
	 * �����ӳ���ȡ��һ������
	 * @return ���Ӷ���
	 */
	public synchronized Connection getConnection() {
		return pool.remove(pool.size() - 1);
	}
	
	/**
	 * �����ӷŻ����ӳ�
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
