package io.byteio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo01 {
	public static void main(String[] args){
		File f = new File("I://1.sql");
		InputStream is = null;
		try
		{
			is = new FileInputStream(f);
			byte[] car = new byte[10];
			int len = 0;
			while((len = is.read(car)) != -1)
			{
				String str = new String(car,0,len);
				System.out.println(str);
			}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("�ļ�������");
			//ex.printStackTrace();
		}
		catch(IOException ex)
		{
			System.out.println("��ȡ�ļ�ʧ��");
			//ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(is != null)
				{
					is.close();
				}
			}
			catch(IOException ex)
			{
				System.out.println("�ر��ļ�������ʧ��");
				//ex.printStackTrace();
			}
		}
	}
}
