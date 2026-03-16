package tests;

import org.testng.annotations.Test;
import driver.DriverManager;
import libraries.Utility;
import pom.AllOrdersPage;
import pom.LoginPage;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginTest {

	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	String expectedTitle = "Web Orders";
	String actualTitle = null;

	LoginPage loginPage;
	AllOrdersPage allOrdersPage;

	@BeforeMethod
	public void init() throws MalformedURLException, InterruptedException {
		
		System.out.println("LoginTest");

		System.out.println("Starting Test: " + this.getClass().getSimpleName() + " | Thread ID: "
				+ Thread.currentThread().getId());

		WebDriver driver = Utility.launchApplication(baseUrl, 3);
		DriverManager.setDriver(driver);

		loginPage = new LoginPage(driver);
		allOrdersPage = new AllOrdersPage(driver);

		loginPage.loginToApplication("Tester", "test");
		Thread.sleep(7000);
	}

	@Test
	public void validateSuccessfulLoginWithValidCredentials() {
		actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void stop() {
		allOrdersPage.clickLogout();
		DriverManager.quitDriver();
	}

}
