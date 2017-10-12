package io.file;

import java.io.File;
import java.util.Arrays;

public class Demo04 {
	public static void main(String[] args) {
		//String path = "i:/ฝฬังสำฦต";
		//File src = new File(path);
		//print(src);
		File[] f = File.listRoots();
		System.out.println(Arrays.toString(f));
	}
	
	public static void print(File f)
	{
		if(f == null || !f.exists())
		{
			return;
		}
		System.out.println(f.getAbsolutePath());
		if(f.isDirectory())
		{
			for(File sub : f.listFiles())
			{
				print(sub);
			}
		}
	}
}
