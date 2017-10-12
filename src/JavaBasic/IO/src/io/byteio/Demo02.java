package io.byteio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo02 {
	public static void main(String[] args){
		File f = new File("I://1.txt");
		OutputStream os = null;
		try
		{
			os = new FileOutputStream(f,true);
			String str = "bjsxt is very good\r\n";
			os.write(str.getBytes());
			os.flush();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("�ļ�������");
			//ex.printStackTrace();
		}
		catch(IOException ex)
		{
			System.out.println("д���ļ�ʧ��");
			//ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(os != null)
				{
					os.close();
				}
			}
			catch(IOException ex)
			{
				System.out.println("�ر��ļ������ʧ��");
				//ex.printStackTrace();
			}
		}
	}
}
