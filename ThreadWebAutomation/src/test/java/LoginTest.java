package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.util.Utils;

public class LoginTest implements Const {
	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void login() {
		webDriver.navigate().to(Utils.getValueByKey(LOGIN_URL));
		// webDriver.manage().window().maximize();

		webDriver.findElement(By.name("email")).sendKeys(Utils.getValueByKey(USER_NAME));
		webDriver.findElement(By.name("password")).sendKeys(Utils.getValueByKey(PASSWORD));
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div/div[1]/div/div/form/div[3]/button")).click();

	}
}
