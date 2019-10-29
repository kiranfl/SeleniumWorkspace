

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
	@Test
	public void exampleOfTestNgMaven() {
		System.setProperty(
                "webdriver.chrome.driver",
                "D:/chromedriver_win32/chromedriver.exe");
WebDriver webDriver = new ChromeDriver();
webDriver.navigate().to("http://turbo.threadresearch.com");
webDriver.manage().window().maximize();
webDriver.findElement(By.name("email")).sendKeys("kiran.rajam@fissionlabs.com");
webDriver.findElement(By.name("password")).sendKeys("password");
webDriver.findElement(By.xpath("//*[@id='app']/div/div[1]/div/div/div[1]/div/div/form/div[3]/button")).click();

	}
}
