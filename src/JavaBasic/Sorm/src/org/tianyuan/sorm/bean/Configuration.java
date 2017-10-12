package org.tianyuan.sorm.bean;

/**
 * 管理配置信息
 * @author 天问雪狼
 *
 */
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver;
	
	/**
	 * jdbc的URL
	 */
	private String url;
	
	/**
	 * 数据库的用户名
	 */
	private String user;
	
	/**
	 * 数据库的密码
	 */
	private String pwd;
	
	/**
	 * 使用的数据库类型
	 */
	private String usingDB;
	
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	
	/**
	 * 扫描生成java类的包(po:Persistence Object-持久化对象)
	 */
	private String poPackage;
	
	/**
	 * 项目使用的查讯类的路径
	 */
	private String queryClass;
	
	/**
	 * 连接池中最大连接数
	 */
	private int connectionPoolMaxSize;
	
	/**
	 * 连接池中最小连接数
	 */
	private int connectionPoolMinSize;
	
	
	public Configuration() {
		
	}
	public Configuration(String driver, String url, String user, String pwd,
			String usingDB, String srcPath, String poPackage,
			String queryClass, int connectionPoolMaxSize,
			int connectionPoolMinSize) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
		this.queryClass = queryClass;
		this.connectionPoolMaxSize = connectionPoolMaxSize;
		this.connectionPoolMinSize = connectionPoolMinSize;
	}


	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	public String getQueryClass() {
		return queryClass;
	}
	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}
	public int getConnectionPoolMaxSize() {
		return connectionPoolMaxSize;
	}
	public void setConnectionPoolMaxSize(String connectionPoolMaxSize) {
		this.connectionPoolMaxSize = Integer.valueOf(connectionPoolMaxSize);
	}
	public int getConnectionPoolMinSize() {
		return connectionPoolMinSize;
	}
	public void setConnectionPoolMinSize(String connectionPoolMinSize) {
		this.connectionPoolMinSize = Integer.valueOf(connectionPoolMinSize);
	}
	
}
