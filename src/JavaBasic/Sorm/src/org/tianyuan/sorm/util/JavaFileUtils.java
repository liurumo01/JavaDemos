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
 * 封装了生成Java文件(源代码)常用的操作
 * @author 天问雪狼
 *
 */
public class JavaFileUtils {
	
	/**
	 * 根据字段信息生成java属性信息，如varchar username --> private String username;以及相应的get和set方法
	 * @param column 字段信息
	 * @param converter 类型转换器
	 * @return java属性和get/set方法源码
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
	 * 根据表信息生成Java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转化器
	 * @return java类的源代码
	 */
	public static String createJavaSRC(TableInfo tableInfo,TypeConvertor convertor) {
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		for(ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}
		
		StringBuilder src = new StringBuilder();
		
		//生成package语句
		src.append("package " + DBManager.getConfiguration().getPoPackage() + ";\n\n");
		//生成类声明语句
		src.append("public class " + StringUtils.firstCharToUppercase(tableInfo.getTname()) + " {\n\n");
		//生成属性列表
		for(JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n");
		//get/set方法列表
		for(JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
			src.append(f.getSetInfo());
		}
		src.append("\n");
		//生成类结束语句
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
			//目录不存在则创建
			dir.mkdirs();
		}
		
		try {
			bw = new BufferedWriter(new FileWriter(dir.getAbsolutePath() + "/" + StringUtils.firstCharToUppercase(tableInfo.getTname()) + ".java"));
			bw.write(src);
			
			System.out.println("建立表" + tableInfo.getTname() + "对应的Java类" + StringUtils.firstCharToUppercase(tableInfo.getTname()) + ".java");
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
