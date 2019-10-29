package test.java.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class DesignTestScreen7 {
	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void typeOfStudy() {
		WebElement element = webDriver
				.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/select"));
		element.click();
		Select selctor = new Select(element);
		selctor.selectByVisibleText("Pragmatic Clinical Trial");

		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button"))
				.click();

	}
}
