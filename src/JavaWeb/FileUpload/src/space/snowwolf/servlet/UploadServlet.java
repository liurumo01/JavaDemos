package space.snowwolf.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1596891409545343812L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(5 * 1024);
		factory.setRepository(new File("i://temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(5 * 1024 * 1024);

		// Parse the request
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			
			for(FileItem item : items) {
				if(item.isFormField()) {
					String fieldName = item.getFieldName();
					String value = item.getString();
					
					System.out.println(fieldName + ": " + value);
				} else {
					String fieldName = item.getFieldName();
				    String fileName = item.getName();
				    String contentType = item.getContentType();
				    long sizeInBytes = item.getSize();
				    
				    System.out.println("fieldName: " + fieldName);
				    System.out.println("fileName: " + fileName);
				    System.out.println("contentType: " + contentType);
				    System.out.println("sizeInBytes: " + sizeInBytes);
				    
				    fileName = "i:\\temp\\" + fileName;
				    OutputStream out = new FileOutputStream(fileName);
				    byte[] buffer = new byte[1024];
				    int len = 0;
				    
				    while((len = item.getInputStream().read(buffer)) != -1) {
				    	out.write(buffer,0,len);
				    }
				    out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}
