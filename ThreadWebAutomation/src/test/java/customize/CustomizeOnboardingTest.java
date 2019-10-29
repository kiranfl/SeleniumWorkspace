package test.java.customize;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class CustomizeOnboardingTest {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void customizeOnBoarding() {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='app']/div/div[1]")));

		// Enter screen title
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[1]/div[2]/div[3]/div/div[1]/input"))
				.sendKeys("First screen title");
		// Enter screen content
		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]"))
				.sendKeys("Screen content");

		// Click save button
		WebElement webElement = webDriver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[1]/div[2]/div[3]/div/div[3]/div[2]/button[2]"));
		// Scroll the browser to the element's Y position
		((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0," + webElement.getLocation().y + ")");
		webElement.click();

		webElement = webDriver.findElement(By.className("toast-close-button"));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		webElement.click();

		// Enter study description
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/input"))
				.sendKeys("Study description");

		// Click continue button
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[4]/div/div/button[2]")).click();
	}
}
