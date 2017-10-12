package org.tianyuan.sorm.core;

public class QueryFactory {
	private static Query prototypeObj;
	static {
		//º”‘ÿtablContext∫ÕDBManager
		System.out.println(TableContext.class);
		System.out.println(DBManager.class);
		
		try {
			Class<?> c = Class.forName(DBManager.getConfiguration().getQueryClass());
			prototypeObj = (Query) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private QueryFactory() {
		
	}
	
	public static Query createQuery() {
		return (Query) prototypeObj.clone();
	}
}
