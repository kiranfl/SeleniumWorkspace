package test.java.customize;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class CustomizeRegistrationTest {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void registrationTest() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dselect firstname
		WebElement element = webDriver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/label/div"));
		// Scroll the browser to the element's Y position
		/*
		 * ((JavascriptExecutor) webDriver) .executeScript("window.scrollTo(" +
		 * element.getLocation().x + "," + element.getLocation().y + ")");
		 * 
		 * element.click();
		 */

		((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);

		// Click continue button
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[3]/div/div/button[2]")).click();
	}

}
