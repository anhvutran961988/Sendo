package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
	
	// *** Xpath for elements
	private String ProductNameXpath = "//h1[@class='productName_3Cdc']";
	
	private String ProductFinalPriceXpath = "//div[@class='price_21TZ']/strong";
	
	private String FirstColorButtonXpath = "//div[@id='productOptionsBox']/div[1]/div[2]/button[1]";
	
	private String FirstSizeButtonXpath = "//div[@id='productOptionsBox']/div[2]/div[2]/button[1]";
	
	private String ProductQuantity = "//div[@class='QuantityInput_3yLO']/input";
	
	private String MuaNgayButtonXpath = "//button[text()='Mua ngay']";
	
	private String ShopNameXpath = "//div[@class='shopStatus_3cS0']/a/div";

	// *** Web elements ***
	private WebDriverWait wait (WebDriver driver) {
		return new WebDriverWait(driver, 10);
	}
	
	private WebElement ProductName (WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductNameXpath)));
	}
	
	private WebElement ProductFinalPrice (WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductFinalPriceXpath)));
	}
	
	private WebElement FirstColorButton (WebDriver driver) {
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(FirstColorButtonXpath)));
	}
	
	private WebElement FirstSizeButton (WebDriver driver) {
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(FirstSizeButtonXpath)));
	}
	
	private WebElement ProductQuantity (WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductQuantity)));
	}
	
	private WebElement MuaNgayButton (WebDriver driver) {
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(MuaNgayButtonXpath)));
	}
	
	private WebElement ShopName (WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ShopNameXpath)));
	}
	
	// *** Basic steps ***
	private void selectFirstColor(WebDriver driver) {
		FirstColorButton(driver).click();
	}
	
	private void selectFirstSize(WebDriver driver) {
		FirstSizeButton(driver).click();
	}
	
	private void clickMuaNgayButton(WebDriver driver) {
		MuaNgayButton(driver).click();
	}
	
	// *** User steps ***
	public String getProductName(WebDriver driver) {
		return ProductName(driver).getText();
	}
	
	public String getProductFinalPrice(WebDriver driver) {
		return ProductFinalPrice(driver).getText();
	}
	
	public String getProductQuantity(WebDriver driver) {
		return ProductQuantity(driver).getAttribute("value");
	}
	
	public String getShopName(WebDriver driver) {
		return ShopName(driver).getText();
	}
	
	public void orderProduct(WebDriver driver) throws InterruptedException {	
		//Thread.sleep(1000)
		selectFirstColor(driver);	//Select color
		//Thread.sleep(1000)
		selectFirstSize(driver);	//Select size	
		clickMuaNgayButton(driver);	//Click Mua Ngay button
	}
}
