package io.file;

import java.io.File;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		String path = "I:\\2.sql";
		System.out.println(path);
		path = "I:" + File.separator + "2.jpg";
		System.out.println(path);
		path = "I:/2.sql";
		System.out.println(path);
		
		
	}
}
