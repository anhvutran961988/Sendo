package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
	
	// *** Xpath for elements ***
	private String LinkToLoginPopupXpath = "//button[@id='login']//span";
	private String LinkToSendoIDLoginXpath = "//div[text()='Đã có SendoID']";
	private String EmailOrPhoneInputXpath = "//input[@name='email']";
	private String PasswordInputXpath = "//input[@name='password']";
	private String LoginButtonXpath = "//button[text()='Đăng nhập']";
	
	// *** Web elements ***
	private WebDriverWait wait (WebDriver driver) {
		return new WebDriverWait(driver, 10);
	}
	
	private WebElement LinkToLoginPopup(WebDriver driver) {	
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(LinkToLoginPopupXpath)));
	}
	
	private WebElement LinkToSendoIDLogin(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(LinkToSendoIDLoginXpath)));
	}
	
	private WebElement EmailOrPhoneInput(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmailOrPhoneInputXpath)));
	}
	
	private WebElement PasswordInput(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PasswordInputXpath)));
	}
	
	private WebElement LoginButton(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(LoginButtonXpath)));
	}
	
	// *** Basic steps ***
	private void clickLinkToLoginPopup(WebDriver driver) {
		LinkToLoginPopup(driver).click();
	}
	
	private void clickLinkToSendoIDLogin(WebDriver driver) {
		LinkToSendoIDLogin(driver).click(); 
	}
	
	private void inputEmail(WebDriver driver, String Email) {
		EmailOrPhoneInput(driver).sendKeys(Email);
	}
	
	private void inputPhone(WebDriver driver, String Phone) {
		EmailOrPhoneInput(driver).sendKeys(Phone);
	}
	private void inputPassword(WebDriver driver, String Password) {
		PasswordInput(driver).sendKeys(Password);
	}
	
	private void clickLoginButton(WebDriver driver) {
		LoginButton(driver).click();
	}
	
	// *** User steps ***
	public void loginWithEmail(WebDriver driver, String Email, String Password) throws InterruptedException {
		clickLinkToLoginPopup(driver);		//Open login popup		
		Thread.sleep(1000);
		clickLinkToSendoIDLogin(driver);	//Open SendoID login popup
		inputEmail(driver, Email);			//Input email
		inputPassword(driver, Password);	//Input password
		clickLoginButton(driver);			//Click Login button
	}
	
	public void loginWithPhone(WebDriver driver, String Phone, String Password) throws InterruptedException {
		clickLinkToLoginPopup(driver);		//Open login popup
		Thread.sleep(1000);
		clickLinkToSendoIDLogin(driver);	//Open SendoID login popup
		inputPhone(driver, Phone);			//Input phone number
		inputPassword(driver, Password);	//Input password
		clickLoginButton(driver);			//Click Login button
	}
}
