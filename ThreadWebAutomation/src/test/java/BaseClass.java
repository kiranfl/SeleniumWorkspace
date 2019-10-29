package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	private static BaseClass mInstance;
	private WebDriver webDriver;

	public WebDriver getWebDriver() {
		if (webDriver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/config/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			webDriver = new ChromeDriver(options);

			// Dimension screenResolution = new Dimension(Width, Height);
			// webDriver.manage().window().setSize(screenResolution);

			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return webDriver;
	}

	public static BaseClass getInstance() {
		if (mInstance == null) {
			mInstance = new BaseClass();
		}
		return mInstance;
	}

}
