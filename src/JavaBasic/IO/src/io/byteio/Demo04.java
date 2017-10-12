package io.byteio;

import java.io.File;

public class Demo04 {
	public static void main(String[] args) {
		String srcPath = "i://A";
		String destPath = "i://AA";
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
		
	}
	public static void copyDir(String srcPath,String destPath)
	{
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	public static void copyDir(File src,File dest)
	{
		if(src.isDirectory())
		{
			dest = new File(dest,src.getName());
		}
		copyDirDetail(src,dest);
	}
	private static void copyDirDetail(File src,File dest)
	{
		if(src.isFile())
		{
			Demo03.copyFile(src,dest);
		}
		else if(src.isDirectory())
		{
			dest.mkdirs();
			for(File sub : src.listFiles())
			{
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}
	}
}
