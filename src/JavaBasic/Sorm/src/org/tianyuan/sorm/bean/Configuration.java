package org.tianyuan.sorm.bean;

/**
 * ����������Ϣ
 * @author ����ѩ��
 *
 */
public class Configuration {
	/**
	 * ������
	 */
	private String driver;
	
	/**
	 * jdbc��URL
	 */
	private String url;
	
	/**
	 * ���ݿ���û���
	 */
	private String user;
	
	/**
	 * ���ݿ������
	 */
	private String pwd;
	
	/**
	 * ʹ�õ����ݿ�����
	 */
	private String usingDB;
	
	/**
	 * ��Ŀ��Դ��·��
	 */
	private String srcPath;
	
	/**
	 * ɨ������java��İ�(po:Persistence Object-�־û�����)
	 */
	private String poPackage;
	
	/**
	 * ��Ŀʹ�õĲ�Ѷ���·��
	 */
	private String queryClass;
	
	/**
	 * ���ӳ������������
	 */
	private int connectionPoolMaxSize;
	
	/**
	 * ���ӳ�����С������
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
