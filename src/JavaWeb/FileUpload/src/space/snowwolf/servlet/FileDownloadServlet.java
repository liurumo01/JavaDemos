package space.snowwolf.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = -2853450102811785710L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fileName = "²âÊÔ.docx";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		
		OutputStream out = response.getOutputStream();
		String doc = "C:\\Users\\ÈçÄ«\\Desktop\\linux²âÊÔ-13074121-ÁøÈçÄ«.docx";
		
		InputStream in = new FileInputStream(doc);
		
		byte[] buffer = new byte[1048576];
		int len = 0;
		
		while((len = in.read(buffer,0,1048576)) != -1) {
			out.write(buffer,0,len);
		}
		
		in.close();
	}

}
