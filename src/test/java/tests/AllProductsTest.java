package tests;

import org.testng.annotations.Test;
import driver.DriverManager;
import libraries.Utility;
import pom.AllOrdersPage;
import pom.LoginPage;
import pom.ViewAllProductsPage;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AllProductsTest {

//	public WebDriver driver;
	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	int noOfRowsAtStart = 0;
	int noOfRowsAtEnd = 0;

	LoginPage loginPage;
	AllOrdersPage allOrdersPage;
	ViewAllProductsPage viewAllProductsPage;

	@BeforeMethod
	public void init() throws MalformedURLException, InterruptedException {
		
		System.out.println("AllProductsTest");

		System.out.println("Starting Test: " + this.getClass().getSimpleName() + " | Thread ID: "
				+ Thread.currentThread().getId());

		WebDriver driver = Utility.launchApplication(baseUrl, 3);
		DriverManager.setDriver(driver);

		loginPage = new LoginPage(driver);
		allOrdersPage = new AllOrdersPage(driver);
		viewAllProductsPage = new ViewAllProductsPage(driver);

		loginPage.loginToApplication("Tester", "test");
		Thread.sleep(7000);
		allOrdersPage.clickViewAllProductsLink();
	}

	@Test
	public void validateCountOfAvailableProducts() {
		int noOfProducts = viewAllProductsPage.getNoOfProducts();
		Assert.assertEquals(noOfProducts, 4);
	}

	@AfterMethod
	public void stop() {
		viewAllProductsPage.clickLogoutLink();
		DriverManager.quitDriver();
	}

}
