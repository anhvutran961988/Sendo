package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

	// *** Xpath for elements ***
	String LinkToSubcategoryXpath(String Subcategory) {
		return "//a[@href='" + Subcategory + "']";
	}
	
	String FirstProductXpath = "//div[@id='sd-product-sponsored-upting-swiper']/div/div[1]//a";
	
	// *** Web elements ***
	private WebDriverWait wait (WebDriver driver) {
		return new WebDriverWait(driver, 10);
	}
	
	private WebElement LinkToSubcategory(WebDriver driver, String Subcategory) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LinkToSubcategoryXpath(Subcategory))));
	}
	
	private WebElement FirstProduct(WebDriver driver) {
		return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstProductXpath)));
	}
	
	// *** Basic steps ***
	
	// *** User steps ***
	public void navigateToSubcategory(WebDriver driver, String Subcategory)  {
		LinkToSubcategory(driver, Subcategory).click();
	}
	
	public void selectFirstProduct(WebDriver driver) {
		FirstProduct(driver).click();
	}
	

}
