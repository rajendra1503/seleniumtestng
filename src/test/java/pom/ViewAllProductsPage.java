package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewAllProductsPage {
	
	public WebDriver driver;
	
	By tblProducts = By.xpath("//table[@class='ProductsTable']/tbody");
	By lnkLogout = By.linkText("Logout");

	public ViewAllProductsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public int getNoOfProducts() {
		WebElement tableProd = driver.findElement(tblProducts);
		List<WebElement> allRows = tableProd.findElements(By.xpath("tr"));
		return allRows.size();
	}
	
	public void clickLogoutLink() {
		driver.findElement(lnkLogout).click();
	}
}
