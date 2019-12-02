package reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private String filePath = "C:\\Users\\ANH\\eclipse-workspace\\Sendo\\src\\Config.properties";
	
	private Properties properties = new Properties();
	
	private void loadConfigFile() throws IOException {
		
		FileInputStream fileInput = new FileInputStream(filePath);		
		properties.load(fileInput);
	}

	public String getBrowser() throws IOException {
		loadConfigFile();
		return properties.getProperty("browser");
	}
	
	public String getChromeDriverPath() throws IOException {
		loadConfigFile();
		return properties.getProperty("chromedriverPath");
	}
	
	public String getGeckoDriverPath() throws IOException {
		loadConfigFile();
		return properties.getProperty("geckodriverPath");
	}
	
	public String getIEDriverPath() throws IOException {
		loadConfigFile();
		return properties.getProperty("iedriverPath");
	}
	
	public String getDefaulUrl() throws IOException {
		loadConfigFile();
		return properties.getProperty("defaultUrl");
	}
	

}
