package org.tianyuan.sorm.core;

/**
 * 负责只针对Mysql数据库的查询
 * @author 天问雪狼
 *
 */
public class MysqlQuery extends Query {
	
	public Object queryPagenate() {
		return null;
	}
	
	@Override
	public Object queryPagenate(int pagNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}
