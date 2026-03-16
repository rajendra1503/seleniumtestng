package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {

	public WebDriver driver;
	JavascriptExecutor js;

	By ddlProduct = By.id("ctl00_MainContent_fmwOrder_ddlProduct");
	By txtQty = By.id("ctl00_MainContent_fmwOrder_txtQuantity");

	By btnCalculate = By.cssSelector("input[value='Calculate']");
	By txtCustomerName = By.id("ctl00_MainContent_fmwOrder_txtName");
	By txtStreet = By.id("ctl00_MainContent_fmwOrder_TextBox2");
	By txtCity = By.id("ctl00_MainContent_fmwOrder_TextBox3");
	By txtState = By.id("ctl00_MainContent_fmwOrder_TextBox4");
	By txtZip = By.id("ctl00_MainContent_fmwOrder_TextBox5");

	By txtCardNo = By.id("ctl00_MainContent_fmwOrder_TextBox6");
	By txtExpDate = By.id("ctl00_MainContent_fmwOrder_TextBox1");

	By btnProcess = By.linkText("Process");

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void enterProductInfo(String productName, String quantity) {
		Select product = new Select(driver.findElement(ddlProduct));
		product.selectByVisibleText(productName);
		js.executeScript("arguments[0].value=arguments[1];", driver.findElement(txtQty), quantity);
		driver.findElement(btnCalculate).click();
	}

	public void enterCustomerInfo(String custName, String street, String city, String state, String zip) {
		driver.findElement(txtCustomerName).sendKeys(custName);
		driver.findElement(txtStreet).sendKeys(street);
		driver.findElement(txtCity).sendKeys(city);
		driver.findElement(txtState).sendKeys(state);
		driver.findElement(txtZip).sendKeys(zip);
	}

	public void enterPaymentInfo(String cardType, String cardNo, String expDate) {
		driver.findElement(By.cssSelector("input[value='" + cardType + "']")).click();
		driver.findElement(txtCardNo).sendKeys(cardNo);
		driver.findElement(txtExpDate).sendKeys(expDate);
	}

	public void clickProcessButton() {
		driver.findElement(btnProcess).click();
	}

	public void createNewOrder(String productName, String quantity, String custName, String street, String city,
			String state, String zip, String cardType, String cardNo, String expDate) {
		this.enterProductInfo(productName, quantity);
		this.enterCustomerInfo(custName, street, city, state, zip);
		this.enterPaymentInfo(cardType, cardNo, expDate);
		this.clickProcessButton();
	}
}
