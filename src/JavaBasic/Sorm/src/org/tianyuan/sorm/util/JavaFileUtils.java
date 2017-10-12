package org.tianyuan.sorm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tianyuan.sorm.bean.ColumnInfo;
import org.tianyuan.sorm.bean.JavaFieldGetSet;
import org.tianyuan.sorm.bean.TableInfo;
import org.tianyuan.sorm.core.DBManager;
import org.tianyuan.sorm.core.TypeConvertor;

/**
 * ��װ������Java�ļ�(Դ����)���õĲ���
 * @author ����ѩ��
 *
 */
public class JavaFileUtils {
	
	/**
	 * �����ֶ���Ϣ����java������Ϣ����varchar username --> private String username;�Լ���Ӧ��get��set����
	 * @param column �ֶ���Ϣ
	 * @param converter ����ת����
	 * @return java���Ժ�get/set����Դ��
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");
		
		StringBuilder getSRC = new StringBuilder("");
		getSRC.append("\tpublic " + javaFieldType + " get" + StringUtils.firstCharToUppercase(column.getName()) + "() {\n");
		getSRC.append("\t\treturn " + column.getName() + ";\n");
		getSRC.append("\t}\n");
		jfgs.setGetInfo(getSRC.toString());
		
		StringBuilder setSRC = new StringBuilder("");
		setSRC.append("\tpublic void set" + StringUtils.firstCharToUppercase(column.getName()));
		setSRC.append("(" + javaFieldType + " " + column.getName() + ") {\n");
		setSRC.append("\t\tthis." + column.getName() + " = " + column.getName() + ";\n");
		setSRC.append("\t}\n");
		jfgs.setSetInfo(setSRC.toString());
		
		return jfgs;
	}
	
	/**
	 * ���ݱ���Ϣ����Java���Դ����
	 * @param tableInfo ����Ϣ
	 * @param convertor ��������ת����
	 * @return java���Դ����
	 */
	public static String createJavaSRC(TableInfo tableInfo,TypeConvertor convertor) {
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		for(ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}
		
		StringBuilder src = new StringBuilder();
		
		//����package���
		src.append("package " + DBManager.getConfiguration().getPoPackage() + ";\n\n");
		//�������������
		src.append("public class " + StringUtils.firstCharToUppercase(tableInfo.getTname()) + " {\n\n");
		//���������б�
		for(JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n");
		//get/set�����б�
		for(JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
			src.append(f.getSetInfo());
		}
		src.append("\n");
		//������������
		src.append("}\n");
		
		return src.toString();
	}
	
	public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor) {
		String src = createJavaSRC(tableInfo, convertor);
		String srcPath = DBManager.getConfiguration().getSrcPath() + "\\";
		String packagePath = DBManager.getConfiguration().getPoPackage().replaceAll("\\.", "\\\\");
		
		BufferedWriter bw = null;
		File dir = new File(srcPath + packagePath);
		
		if(!dir.exists()) {
			//Ŀ¼�������򴴽�
			dir.mkdirs();
		}
		
		try {
			bw = new BufferedWriter(new FileWriter(dir.getAbsolutePath() + "/" + StringUtils.firstCharToUppercase(tableInfo.getTname()) + ".java"));
			bw.write(src);
			
			System.out.println("������" + tableInfo.getTname() + "��Ӧ��Java��" + StringUtils.firstCharToUppercase(tableInfo.getTname()) + ".java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
 		}
	}
}
