package test.java.customize;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class CustomizeConsentTest {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void fillConsentDetails() {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='app']/div/div[1]")));

		WebElement consentDoc = webDriver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]"));
		wait.until(ExpectedConditions.visibilityOf(consentDoc));
		consentDoc.sendKeys("Study consent doc");

		// Upload file
		File file = new File("src/test/config/study_consent_pdf.pdf");
		webDriver.findElement(By.id("consent_section_doc")).sendKeys(file.getAbsolutePath());

		// Click on save button
		WebElement element = webDriver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div[3]/button[2]"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);

		selectQuizQuestions();

		editPrivacyText();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Click on continue button
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[4]/div/div/button[2]"))
				.click();
	}

	private void selectQuizQuestions() {
		WebElement element = webDriver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[4]/div/div/div[1]/div/select"));
		// Scroll the browser to the element's position
		Actions action = new Actions(webDriver);
		action.moveToElement(element).click().perform();

		Select selector = new Select(element);
		selector.selectByVisibleText("Yes or No");

		// Enter question
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[4]/div/div/div[2]/div/input"))
				.sendKeys("Question 1");
		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[4]/div/div/div[3]/div[3]/div[2]/input"))
				.click();

		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[4]/div/div/div[4]/div[2]/button[2]"))
				.click();
	}

	private void editPrivacyText() {
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[5]/div/div[2]/div[2]/div[1]"))
				.sendKeys("Privacy policy");
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[5]/div/div[3]/button[2]"))
				.click();
	}
}
