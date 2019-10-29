package test.java.customize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import test.java.BaseClass;
import test.java.Const;
import test.util.Utils;

public class CustomizeEligibilityTest {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void selectEligibilityQuestions() {
		if (Utils.getValueByKey(Const.ONBOARING_TYPE).equalsIgnoreCase("by_invitation")) {
			throw new SkipException("Eligibility test skipped");
		} else {
			WebElement webElement = webDriver.findElement(
					By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/h5[2]"));
			new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOf(webElement));

			webElement = webDriver
					.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[3]/div/div/button[2]"));
			webElement.click();
		}
	}

}
