package io.chario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo01 {
	public static void main(String[] args) {
		File src = new File("i://1.sql");
		System.out.println(src.isFile());
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			String line = null;
			while((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			if(reader != null)
			{
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
