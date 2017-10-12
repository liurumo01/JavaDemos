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
			System.out.println("文件不存在");
			//ex.printStackTrace();
		}
		catch(IOException ex)
		{
			System.out.println("写出文件失败");
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
				System.out.println("关闭文件输出流失败");
				//ex.printStackTrace();
			}
		}
	}
}
