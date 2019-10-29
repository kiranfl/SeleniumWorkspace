package test.java.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class DesignTestScreen1 {
	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void begin() {
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div/div/div[4]/button")).click();
	}
}
