package common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import reader.ConfigFileReader;

public class TestBase {
	
	private ConfigFileReader fileReader = new ConfigFileReader();
	
	public WebDriver initiateWebDriver() throws IOException {
		
		String Browser = fileReader.getBrowser();
		
		String WebDriverPath;
		
		WebDriver driver = null;
		
		//Load config file
		//fileReader.loadConfigFile();
		
		//Open browser
		switch (Browser) {
		
			case "Chrome": 
				WebDriverPath = fileReader.getChromeDriverPath();
				
				System.setProperty("webdriver.chrome.driver", WebDriverPath);
				
				driver = new ChromeDriver();
				
				break;
			
			case "Firefox": 
				WebDriverPath = fileReader.getGeckoDriverPath();
				
				System.setProperty("webdriver.firefox.marionette", WebDriverPath);
				
				driver = new FirefoxDriver();
				
				break;
		
			case "IE": 
				WebDriverPath = fileReader.getIEDriverPath();
				
				System.setProperty("webdriver.ie.driver", WebDriverPath);
				
				driver = new InternetExplorerDriver();
			}
		
		return driver;
	}
	
	public void navigateToHomePage(WebDriver driver) throws IOException {
		
		//Load config file
		//fileReader.loadConfigFile();
		
		//Get default url
		String DefaultUrl = fileReader.getDefaulUrl();
		
		//Navigate to home page
		driver.navigate().to(DefaultUrl);
	}

}
