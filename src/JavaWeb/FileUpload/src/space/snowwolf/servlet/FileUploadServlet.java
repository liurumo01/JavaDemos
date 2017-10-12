package space.snowwolf.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import space.snowwolf.beans.FileUploadBean;
import space.snowwolf.exception.InvalidExtNameException;
import space.snowwolf.utils.FileUploadProperties;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 8900803128962315273L;
	
	private static final String FILE_PATH = "/WEB-INF/files";
	Random random = new Random();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = null;
		
		request.setCharacterEncoding("UTF-8");
		ServletFileUpload upload = getServletFileUpload();
		
		// Parse the request
		try {
			Map<String,FileItem> uploadFiles = new HashMap<>();
			
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			
			List<FileUploadBean> beans = buildFileUploadBeans(items,uploadFiles);
			validateExtName(beans);
			upload(uploadFiles);
			save(beans);
			
			path = "/app/success.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			path = "/app/upload.jsp";
			request.setAttribute("message", e.getMessage());
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void save(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub
		
	}

	private void upload(Map<String, FileItem> uploadFiles) throws IOException {
		System.out.println(uploadFiles.size());
		Iterator<Entry<String, FileItem>> it = uploadFiles.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,FileItem> entry = it.next();
			String filePath = entry.getKey();
			FileItem item = entry.getValue();
			
			upload(filePath,item);
		}
	}

	private void upload(String filePath, FileItem item) throws IOException {
		InputStream in = item.getInputStream();
		OutputStream out = new FileOutputStream(filePath);
		
		byte[] buffer = new byte[1024];
		int len = 0;
		
		while((len = in.read(buffer, 0, 1024)) != -1) {
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();
	}

	private void validateExtName(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub
		String exts = FileUploadProperties.getInstance().getProperties("exts");
		List<String> extList = Arrays.asList(exts.split(","));
		
		for(FileUploadBean bean : beans) {
			String fileName = bean.getFileName();
			String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			if(!extList.contains(extName)) {
				throw new InvalidExtNameException(fileName + "文件的拓展名不合法！");
			}
		}
	}

	private List<FileUploadBean> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) {
		Map<String,String> map = new HashMap<>();
		List<FileUploadBean> list = new ArrayList<>();
		
		for(FileItem item : items) {
			if(item.isFormField()) {
				map.put(item.getFieldName(), item.getString());
			}
		}
		
		for(FileItem item : items) {
			if(!item.isFormField()) {
				String fieldName = item.getFieldName();
				String index = fieldName.substring(fieldName.length() -1);
				String fileName = item.getName();
				String fileDesc = map.get("desc" + index);
				String filePath = getFilePath(fileName);
				
				FileUploadBean bean = new FileUploadBean(fileName, filePath, fileDesc);
				list.add(bean);
				
				uploadFiles.put(filePath,item);
			}
		}
		
		return list;
	}

	private String getFilePath(String fileName) {
		String extName = fileName.substring(fileName.lastIndexOf("."));
		
		String filePath = getServletContext().getRealPath(FILE_PATH) + "\\" + System.currentTimeMillis() + random.nextInt(100000) + extName;
		return filePath;
	}

	private ServletFileUpload getServletFileUpload() {

		String fileMaxSize = FileUploadProperties.getInstance().getProperties("file.max.size");
		String totalFileMaxSize = FileUploadProperties.getInstance().getProperties("total.file.max.size");
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(1024 * 500);
		factory.setRepository(new File("i:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(Long.valueOf(totalFileMaxSize));
		upload.setFileSizeMax(Long.valueOf(fileMaxSize));
		return upload;
	}

}
