package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreateStudy {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void createStudy() {
		webDriver.findElement(By.className("plus_icon")).click();
	}
}
