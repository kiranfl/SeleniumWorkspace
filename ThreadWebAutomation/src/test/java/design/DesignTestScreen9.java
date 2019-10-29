package test.java.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class DesignTestScreen9 {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void numberOfParticipants() {
		webDriver.findElement(By.name("number-of-patients")).sendKeys("5");
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/form/div[2]/button"))
				.click();
	}
}
