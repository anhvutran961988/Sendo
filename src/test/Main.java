package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import common.TestBase;
import pom.CategoryPage;
import pom.CheckoutPage;
import pom.Header;
import pom.ProductDetailPage;
import pom.SideMenu;
import reader.DataFileReader;

public class Main {	
	
	static TestBase base = new TestBase();
	
	static Header header = new Header();
	static SideMenu sideMenu = new SideMenu();
	static CategoryPage categoryPage = new CategoryPage();
	static ProductDetailPage productDetailPage = new ProductDetailPage();
	static CheckoutPage checkoutPage = new CheckoutPage();
	
	static DataFileReader dataReader = new DataFileReader();
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		try {
			
			//Test case: verify order info
			testOrderInfo();
			
			//Test case: abc
			
			//Test case: xyz
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			//Close browser
			driver.quit();
		}
		
	}
	
	private static void testOrderInfo() throws IOException, InterruptedException {
		
		//Open browser
		driver = base.initiateWebDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Navigate to Home page
		base.navigateToHomePage(driver);
		
		//Login with valid email and password
		String Email = dataReader.getValidEmail();
		String Password = dataReader.getValidPassword();
		header.loginWithEmail(driver, Email, Password);
		
		//Delay thread in 1s
		Thread.sleep(1000);
		
		//Expand side menu
		String Category = "/thoi-trang-nu";
		sideMenu.expandMenu(driver, Category);
		
		//Navigate to Category page - Thoi trang nu
		//sideMenu.navigateToCategory(driver, Category);
		
		//Delay thread in 1s
		Thread.sleep(1000);
		
		//Navigate to Category page -  Dam
		String Subcategory = "/dam";
		categoryPage.navigateToSubcategory(driver, Subcategory);
		
		//Select 1st product
		categoryPage.selectFirstProduct(driver);
		
		//Get product info before ordering
		String expectedProductName = productDetailPage.getProductName(driver);
		String expectedProductFinalPrice = productDetailPage.getProductFinalPrice(driver);
		String expectedProductQuantity = "x " + productDetailPage.getProductQuantity(driver);
		String expectedShopName = productDetailPage.getShopName(driver);
		
		//Order product
		productDetailPage.orderProduct(driver);
		
		//Get product info after ordering product
		String actualProductName = checkoutPage.getProductName(driver);
		String actualProductFinalPrice = checkoutPage.getProductFinalPrice(driver);
		String actualProductQuantity = checkoutPage.getProductQuantity(driver);
		String actualShopName = checkoutPage.getShopName(driver);
		
		//Check product name
		try {
			
			assertTrue(expectedProductName.contains(actualProductName));
			
			System.out.println();
			System.out.println("Product Name: Matched");
			System.out.println(" - Value in Product Detail Page: " + expectedProductName);
			System.out.println(" - Value in Checkout Page: " + actualProductName);
			
		} catch (Exception e) {
			
			assertFalse(expectedProductName.contains(actualProductName));
			
			System.out.println();
			System.out.println("Product Name: Not matched");
			System.out.println(" - Value in Product Detail Page: " + expectedProductName);
			System.out.println(" - Value in Checkout Page: " + actualProductName);
		}
		
		//Check product final price
		try {
			
			assertTrue(actualProductFinalPrice.equals(expectedProductFinalPrice));
			
			System.out.println();
			System.out.println("Price: Matched");
			System.out.println(" - Value in Product Detail Page: " + expectedProductFinalPrice);
			System.out.println(" - Value in Checkout Page: " + actualProductFinalPrice);
			
		} catch (Exception e) {
			
			assertFalse(actualProductFinalPrice.equals(expectedProductFinalPrice));
			
			System.out.println();
			System.out.println("Price: Not matched");
			System.out.println(" - Value in Product Detail Page: " + expectedProductFinalPrice);
			System.out.println(" - Value in Checkout Page: " + actualProductFinalPrice);
		}
		
		//Check product quantity
		try {
			
			assertTrue(actualProductQuantity.equals(expectedProductQuantity));
			
			System.out.println();
			System.out.println("Product Quantity: Matched");
			System.out.println(" - Value in Product Detail Page: " + expectedProductQuantity);
			System.out.println(" - Value in Checkout Page: " + actualProductQuantity);
			
		} catch (Exception e) {
			
			assertFalse(actualProductQuantity.equals(expectedProductQuantity));
			
			System.out.println();
			System.out.println("Product Quantity: Not matched");
			System.out.println(" - Value in Product Detail Page: " + expectedProductQuantity);
			System.out.println(" - Value in Checkout Page: " + actualProductQuantity);
		}
		
		//Check shop name
		try {
			
			assertTrue(actualShopName.equals(expectedShopName));
			
			System.out.println();
			System.out.println("Shop Name: Matched");
			System.out.println(" - Value in Product Detail Page: " + expectedShopName);
			System.out.println(" - Value in Checkout Page: " + actualShopName);
			
		} catch (Exception e) {
			
			assertFalse(actualShopName.equals(expectedShopName));
			
			System.out.println();
			System.out.println("Shop Name: Not matched");
			System.out.println(" - Value in Product Detail Page: " + expectedShopName);
			System.out.println(" - Value in Checkout Page: " + actualShopName);
		}
		
		//Close browser
		driver.quit();
	
	}
}
