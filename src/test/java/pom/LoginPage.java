package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

	By txtUsername = By.id("ctl00_MainContent_username");
	By txtPassword = By.id("ctl00_MainContent_password");
	By cmdLogin = By.id("ctl00_MainContent_login_button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(txtUsername).sendKeys(username);
	}

	public void enterPassword(String passwd) {
		driver.findElement(txtPassword).sendKeys(passwd);
	}

	public void clickLoginButton() {
		driver.findElement(cmdLogin).click();
	}

	public void loginToApplication(String username, String passwd) {
		this.enterUsername(username);
		this.enterPassword(passwd);
		this.clickLoginButton();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
