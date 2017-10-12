package io.byteio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo03 {
	public static void main(String[] args) {
		String src = "i://1.sql";
		String dest = "i://test";
		copyFile(src,dest);
	}
	public static void copyFile(File src,File dest)
	{
		if(!src.isFile())
		{
			System.err.println("只能拷贝文件");
			return;
		}
		
		if(dest.isDirectory())
		{
			System.err.println("不能创建与文件夹同名的文件" + dest.getAbsolutePath());
			return;
		}
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(src));
			os = new BufferedOutputStream(new FileOutputStream(dest));
			
		} catch (FileNotFoundException e) {
			System.err.println("文件未找到");
		}
		byte[] flush = new byte[1024];
		int len = 0;
		try
		{
			while((len = is.read(flush, 0, 1024)) != -1)
			{
				os.write(flush, 0, len);
			}
		}
		catch(IOException ex)
		{
			System.err.println("文件读写失败");
		}
		finally
		{
			try
			{
				is.close();
				os.close();
			}
			catch(IOException ex)
			{
				System.err.println("输入输出流关闭失败");
			}
		}
		System.out.println("文件拷贝完成");
	}
	public static void copyFile(String srcPath,String destPath)
	{
		copyFile(new File(srcPath),new File(destPath));
	}
}
