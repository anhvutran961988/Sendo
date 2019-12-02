package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideMenu {
	
	// *** Xpath for elements ***
	private String LinkToCategoryXpath(String Category) {
		return "//a[@href='" + Category + "']";
	}
	private String LinkToSubCategoryXpath(String SubCategory) {
		return "//a[@href='" + SubCategory + "']";
	}
	
	// *** Web elements***
	private WebDriverWait wait (WebDriver driver) {
		return new WebDriverWait(driver, 10);
	}
	
	private WebElement LinkToCategory(WebDriver driver, String Category) {
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(LinkToCategoryXpath(Category))));
	}
	
	private WebElement LinkToSubCategory(WebDriver driver, String Subcategory) {
		return wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(LinkToSubCategoryXpath(Subcategory))));
	}
	
	// *** Basic steps ***
	
	// *** User steps ***
	public void expandMenu(WebDriver driver, String Category) {
		Actions action = new Actions(driver);
		action.moveToElement(LinkToCategory(driver, Category)).build().perform();
	}
	
	public void navigateToCategory(WebDriver driver, String Category) {
		LinkToCategory(driver, Category).click();
	}
	
	public void navigateToSubCategory(WebDriver driver, String SubCategory) {
		LinkToSubCategory(driver, SubCategory).click();
	}

}
