package libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {

	public static WebDriver driver;
	public JavascriptExecutor js;

	public static WebDriver launchApplication(String baseUrl, int browser) {

		switch (browser) {
		case 1:
			driver = new ChromeDriver();
			break;

		case 2:
			driver = new FirefoxDriver();
			break;

		case 3:
			driver = new EdgeDriver();
			break;

		default:
			driver = new ChromeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.get(baseUrl);
		return driver;
	}

	public static void closeApplication() {
		driver.quit();
	}
}
