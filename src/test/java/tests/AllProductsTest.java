package tests;

import org.testng.annotations.Test;
import libraries.Utility;
import pom.AllOrdersPage;
import pom.LoginPage;
import pom.ViewAllProductsPage;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AllProductsTest {
	
	public WebDriver driver;
	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	int noOfRowsAtStart = 0;
	int noOfRowsAtEnd = 0;
	
	LoginPage loginPage;
	AllOrdersPage allOrdersPage;
	ViewAllProductsPage viewAllProductsPage;

	@BeforeTest
	public void init() {
		
		driver = Utility.launchApplication(baseUrl, 2);
		loginPage = new LoginPage(driver);
		allOrdersPage = new AllOrdersPage(driver);
		viewAllProductsPage = new ViewAllProductsPage(driver);

		loginPage.loginToApplication("Tester", "test");
		
		allOrdersPage.clickViewAllProductsLink();
	}

	@Test
	public void validateCountOfAvailableProducts() {
		int noOfProducts = viewAllProductsPage.getNoOfProducts();
		Assert.assertEquals(noOfProducts, 4);
	}

	@AfterTest
	public void stop() {
		viewAllProductsPage.clickLogoutLink();
		Utility.closeApplication();
	}

}
