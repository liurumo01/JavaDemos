package space.snowwolf.utils;

import java.util.HashMap;
import java.util.Map;

public class FileUploadProperties {
	
	static Map<String,String> properties = new HashMap<>();
	
	private FileUploadProperties() {
		
	}
	
	private static FileUploadProperties instance = new FileUploadProperties();
	
	public static FileUploadProperties getInstance() {
		return instance;
	}
	
	public void addPropertie(String name,String value) {
		properties.put(name, value);
	}
	
	public String getProperties(String name) {
		return properties.get(name);
	}
}
