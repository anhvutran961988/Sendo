package reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFileReader {
	private String filePath = "C:\\Users\\ANH\\eclipse-workspace\\Sendo\\data\\Input.dat";
	
	private Properties properties = new Properties();
	
	private void loadAccounts() throws IOException {
		
		FileInputStream fileInput = new FileInputStream(filePath);		
		properties.load(fileInput);
	}
	
	public String getValidEmail() throws IOException {
		loadAccounts();
		return properties.getProperty("email_valid");
	}
	
	public String getValidPhone() throws IOException {
		loadAccounts();
		return properties.getProperty("phone_valid");
	}
	
	public String getValidPassword() throws IOException {
		loadAccounts();
		return properties.getProperty("password_valid");
	}
}
