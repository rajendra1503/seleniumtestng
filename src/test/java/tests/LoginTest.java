package tests;

import org.testng.annotations.Test;
import libraries.Utility;
import pom.AllOrdersPage;
import pom.LoginPage;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest {

	public WebDriver driver;
	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	String expectedTitle = "Web Orders";
	String actualTitle = null;

	LoginPage loginPage;
	AllOrdersPage allOrdersPage;

	@BeforeTest
	public void init() throws InterruptedException {

		driver = Utility.launchApplication(baseUrl, 3);
		loginPage = new LoginPage(driver);
		allOrdersPage = new AllOrdersPage(driver);	
		loginPage.loginToApplication("Tester", "test");
	}

	@Test
	public void validateSuccessfulLoginWithValidCredentials() {
		actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void stop() {
		allOrdersPage.clickLogout();
		Utility.closeApplication();
	}

}
