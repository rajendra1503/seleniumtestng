package tests;

import org.testng.annotations.Test;
import libraries.Utility;
import pom.AllOrdersPage;
import pom.LoginPage;
import pom.OrderPage;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CreateNewOrderTest {

	public WebDriver driver;
	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	int noOfRowsAtStart = 0;
	int noOfRowsAtEnd = 0;
	
	LoginPage loginPage;
	AllOrdersPage allOrdersPage;
	OrderPage orderPage;

	@BeforeTest
	public void init() {
		
		driver = Utility.launchApplication(baseUrl, 2);
		loginPage = new LoginPage(driver);
		allOrdersPage = new AllOrdersPage(driver);
		orderPage = new OrderPage(driver);

		loginPage.loginToApplication("Tester", "test");
		noOfRowsAtStart = allOrdersPage.getNoOfTableRows();
		System.out.println("No. of orders at the beginning: " + noOfRowsAtStart);
		allOrdersPage.clickOrderLink();
		
	}

	@Test
	public void validateNewOrderCreation() throws InterruptedException {
		
		orderPage.enterProductInfo("FamilyAlbum", "10");
		orderPage.enterCustomerInfo("Roger Moore", "7, North Avenue", "Boston", "NY", "57578");
		orderPage.enterPaymentInfo("MasterCard", "89789077577", "12/30");
		orderPage.clickProcessButton();
		allOrdersPage.clickViewAllOrdersLink();
		
		noOfRowsAtEnd = allOrdersPage.getNoOfTableRows();
		System.out.println("No. of orders after new order creation: " + noOfRowsAtEnd);
		Assert.assertEquals((noOfRowsAtEnd-noOfRowsAtStart), 1);
	}

	@AfterTest
	public void stop() {
		allOrdersPage.clickLogout();
		Utility.closeApplication();
	}

}
