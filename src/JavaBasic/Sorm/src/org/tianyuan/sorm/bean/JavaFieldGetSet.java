package org.tianyuan.sorm.bean;

/**
 * ��װ��java���Ժ�get��set������Դ����
 * @author ��ī
 *
 */
public class JavaFieldGetSet {
	/**
	 * ���Ե�Դ����Ϣ
	 */
	private String fieldInfo;
	
	/**
	 * get������Դ����Ϣ����public int getId(){return Id;}
	 */
	private String getInfo;
	
	/**
	 * set������Դ����Ϣ����public void setId(int id){this.id = id;}
	 */
	private String setInfo;

	public JavaFieldGetSet() {
		
	}
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
}
