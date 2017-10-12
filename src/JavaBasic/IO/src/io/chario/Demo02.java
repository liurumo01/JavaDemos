package io.chario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02 {
	public static void main(String[] args) {
		File dest = new File("i://4.sql");
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dest));
			String msg = "ÌìÎÊÑ©ÀÇ";
			writer.write(msg);
			writer.append("~Ò¹ÓêÏþÔÂ");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
