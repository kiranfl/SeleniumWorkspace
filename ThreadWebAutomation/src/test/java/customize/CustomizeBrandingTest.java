package test.java.customize;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import test.java.BaseClass;
import test.java.Const;
import test.util.Utils;

public class CustomizeBrandingTest implements Const {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void customizeBranding() {

		selectStudyLogo();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectAppIcon();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectColors();

		changeAppName(Utils.getValueByKey(APP_NAME));
	}

	private void selectStudyLogo() {

		// Select upload from library
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[5]/div[1]/button[2]/span"))
				.click();

		// Select any random image from first 20 images
		int i = new Random().nextInt(20) + 1;
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement element = webDriver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/div[" + i + "]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		// Click Add button
		webDriver.findElement(By.xpath("//*[@id='myModal']/div/div/div[4]/button")).click();
	}

	private void selectAppIcon() {
		// Select upload from library
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement element = webDriver
				.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[5]/div[2]/button[2]/span"));
		// wait.until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) webDriver)
				.executeScript("window.scrollTo(" + element.getLocation().x + "," + element.getLocation().y + ")");
		element.click();

		// Select any random image from first 20 images
		int i = new Random().nextInt(20) + 1;
		element = webDriver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/div[" + i + "]"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		// Click Add button
		webDriver.findElement(By.xpath("//*[@id='myModal']/div/div/div[4]/button")).click();
	}

	private void selectColors() {
		String primaryColor = Utils.getValueByKey(PRIMARY_COLOR);
		String secondaryColor = Utils.getValueByKey(SECONDARY_COLOR);

		// Select primary color
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[7]/div[1]/div[3]/div[2]/input"))
				.clear();
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[7]/div[1]/div[3]/div[2]/input"))
				.sendKeys(primaryColor);

		// Select secondary color
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[7]/div[2]/div[3]/div[2]/input"))
				.clear();
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[7]/div[2]/div[3]/div[2]/input"))
				.sendKeys(secondaryColor);
	}

	private void changeAppName(String appName) {
		webDriver.findElement(By.name("app-name")).clear();
		webDriver.findElement(By.name("app-name")).sendKeys(appName);
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[11]/div/div/button[2]"))
				.click();
		try {
			if (webDriver.findElement(By.id("toast-container")).isDisplayed()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				appName = Utils.getValueByKey(APP_NAME) + "" + (new Random().nextInt(1000) + 1);
				System.out.println(appName);
				changeAppName(appName);
			}
		} catch (NoSuchElementException exception) {
			System.out.println(exception);
		}
	}
}
