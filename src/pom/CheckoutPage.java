package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	// *** Xpath for elements ***
	private String OrderInfoHeaderXpath = "//span[text()='Thông tin đơn hàng']";
	
	private String ShopNameXpath = "//div[@class='shopName_Abkb']/strong";
	
	private String ProductNameXpath = "//div[@class='productInfo_N8BL']/p";
	
	private String ProductFinalPriceXpath = "//div[@class='productPrice_3cVX']/strong";
	
	private String ProductQuantityXpath = "//span[@class='orderQty_3iiy']";
	
	// *** Web elements ***
	private WebDriverWait wait (WebDriver driver) {
		return new WebDriverWait(driver, 10);
	}
	
	private WebElement OrderInfoHeader(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OrderInfoHeaderXpath)));
	}
	
	private WebElement ShopName(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ShopNameXpath)));
	}
	
	private WebElement ProductName(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductNameXpath)));
	}
	
	private WebElement ProductFinalPrice(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductFinalPriceXpath)));
	}
	
	private WebElement ProductQuantity(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductQuantityXpath)));
	}
	
	// *** Basic steps ***
	
	// *** User steps ***
	public void scrollToOrderInfoSection(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", OrderInfoHeader(driver));
	}
	
	public String getProductName(WebDriver driver) {
		return ProductName(driver).getText();
	}
	
	public String getProductFinalPrice(WebDriver driver) {
		return ProductFinalPrice(driver).getText();
	}
	
	public String getProductQuantity(WebDriver driver) {
		return ProductQuantity(driver).getText();
	}
	
	public String getShopName(WebDriver driver) {
		return ShopName(driver).getText();
	}
}
