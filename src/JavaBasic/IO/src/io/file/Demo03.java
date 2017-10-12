package io.file;

import java.io.File;
import java.io.IOException;

public class Demo03 {
	public static void main(String[] args) throws IOException, InterruptedException {
		String path = "I:/200.jpg";
		File src = new File(path);
		if(!src.exists())
		{
			boolean flag = src.createNewFile();
			System.out.println(flag);
		}
		boolean flag = src.delete();
		System.out.println(flag);
		
		File temp = File.createTempFile("tmp", ".temp",new File("i:/"));
		System.out.println(temp);
		Thread.sleep(3000);
		temp.deleteOnExit();
	}
	public static void test1()
	{
		String parentPath = "D:\\JavaLibrary";
		String name = "commons-fileupload-1.3.1-bin.zip";
		File src = new File(parentPath,name);
		System.out.println(src.getName());
		src = new File(new File(parentPath),name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		src = new File("D:\\JavaLibrary\\commons-fileupload-1.3.1-bin.zip");
		System.out.println(src.getPath());
		
		src = new File("JavaLibrary\\commons-fileupload-1.3.1-bin.zip");
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}
	public static void test2()
	{
		File src = new File("D:\\JavaLibrary\\commons-fileupload-1.3.1-bin.zip");
		//File src = new File("2.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());
		
		System.out.println(src.exists());
		System.out.println(src.canRead());
		System.out.println(src.canWrite());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		System.out.println(src.isAbsolute());
		System.out.println(src.length());
	}
}
