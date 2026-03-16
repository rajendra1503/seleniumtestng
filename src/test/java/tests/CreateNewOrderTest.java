package tests;

import org.testng.annotations.Test;
import driver.DriverManager;
import libraries.Utility;
import pom.AllOrdersPage;
import pom.LoginPage;
import pom.OrderPage;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CreateNewOrderTest {

	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	int noOfRowsAtStart = 0;
	int noOfRowsAtEnd = 0;

	LoginPage loginPage;
	AllOrdersPage allOrdersPage;
	OrderPage orderPage;

	@BeforeMethod
	public void init() throws MalformedURLException, InterruptedException {

		System.out.println("Starting Test: " + this.getClass().getSimpleName() + " | Thread ID: "
				+ Thread.currentThread().getId());

		WebDriver driver = Utility.launchApplication(baseUrl, 3);
		DriverManager.setDriver(driver);

		loginPage = new LoginPage(driver);
		allOrdersPage = new AllOrdersPage(driver);
		orderPage = new OrderPage(driver);
		Thread.sleep(7000);

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
		Assert.assertEquals((noOfRowsAtEnd - noOfRowsAtStart), 1);
	}

	@AfterMethod
	public void stop() {
		allOrdersPage.clickLogout();
		DriverManager.quitDriver();
	}

}
