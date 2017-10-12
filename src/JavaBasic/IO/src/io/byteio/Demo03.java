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
			System.err.println("ֻ�ܿ����ļ�");
			return;
		}
		
		if(dest.isDirectory())
		{
			System.err.println("���ܴ������ļ���ͬ�����ļ�" + dest.getAbsolutePath());
			return;
		}
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(src));
			os = new BufferedOutputStream(new FileOutputStream(dest));
			
		} catch (FileNotFoundException e) {
			System.err.println("�ļ�δ�ҵ�");
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
			System.err.println("�ļ���дʧ��");
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
				System.err.println("����������ر�ʧ��");
			}
		}
		System.out.println("�ļ��������");
	}
	public static void copyFile(String srcPath,String destPath)
	{
		copyFile(new File(srcPath),new File(destPath));
	}
}
