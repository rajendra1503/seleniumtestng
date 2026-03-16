package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllOrdersPage {
	
	public WebDriver driver;
	
	By lnkViewAllOrders = By.linkText("View all orders");
	By lnkViewAllProducts = By.linkText("View all products");
	By lnkOrder = By.linkText("Order");
	By lnkLogout = By.linkText("Logout");
	
	By table = By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody");
	By btnCheckAll = By.linkText("Check All");
	By btnUncheckAll = By.linkText("Uncheck All");
	By btnDelete = By.id("ctl00_MainContent_btnDelete");

	public AllOrdersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogout() {
		driver.findElement(lnkLogout).click();
	}
	
	public void clickViewAllOrdersLink() {
		driver.findElement(lnkViewAllOrders).click();
	}
	
	public void clickViewAllProductsLink() {
		driver.findElement(lnkViewAllProducts).click();
	}
	
	public void clickOrderLink() {
		driver.findElement(lnkOrder).click();
	}
	
	public void clickCheckAllButton() {
		driver.findElement(btnCheckAll).click();
	}
	
	public void clickUncheckAll() {
		driver.findElement(btnUncheckAll).click();
	}
	
	public void clickDeleteSelectedButton() {
		driver.findElement(btnDelete).click();
	}
	
	public int getNoOfTableRows() {
		List<WebElement> allRows = driver.findElement(table).findElements(By.xpath("tr"));
		return allRows.size();
	}
}
