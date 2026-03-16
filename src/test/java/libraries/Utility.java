package libraries;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility {

	public JavascriptExecutor js;

	public static WebDriver launchApplication(String baseUrl, int browser) throws MalformedURLException {
		
		WebDriver driver = null;
		
		URL gridUrl = new URL("http://localhost:4444");

		switch (browser) {
		case 1:
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new RemoteWebDriver(gridUrl, chromeOptions);
			break;

		case 2:
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new RemoteWebDriver(gridUrl, firefoxOptions);
			break;

		case 3:
			EdgeOptions edgeOptions = new EdgeOptions();
			driver = new RemoteWebDriver(gridUrl, edgeOptions);
			break;

		default:
			ChromeOptions chromeOptions1 = new ChromeOptions();
			driver = new RemoteWebDriver(gridUrl, chromeOptions1);
			break;
		}

		driver.manage().window().maximize();
		driver.get(baseUrl);
		return driver;
	}
}
