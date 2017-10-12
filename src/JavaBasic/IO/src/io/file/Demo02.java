package io.file;

import java.io.File;

public class Demo02 {
	public static void main(String[] args) {
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
}
