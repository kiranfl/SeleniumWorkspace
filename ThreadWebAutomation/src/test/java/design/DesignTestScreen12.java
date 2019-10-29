package test.java.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class DesignTestScreen12 {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void selectChannels() {
		// Select iOS and Android
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[2]/div/div"))
				.click();
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/div"))
				.click();

		// Click continue button
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[4]/button"))
				.click();
	}

}
