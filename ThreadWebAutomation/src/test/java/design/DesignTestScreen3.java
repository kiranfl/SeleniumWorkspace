package test.java.design;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;
import test.java.Const;
import test.util.Utils;

public class DesignTestScreen3 implements Const {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void enterStudyName() {
		String studyName = Utils.getValueByKey(STUDY_NAME);
		changeStudyName(studyName);
	}

	private void changeStudyName(String studyName) {
		webDriver.findElement(By.name("study-name")).clear();
		webDriver.findElement(By.name("study-name")).sendKeys(studyName);
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/form/div[2]/button"))
				.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (webDriver.findElement(By.xpath("//*[@id='toast-container']/div/div")).isDisplayed()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				studyName = Utils.getValueByKey(STUDY_NAME) + "_" + (new Random().nextInt(10000) + 1);
				System.out.println(studyName);
				changeStudyName(studyName);
			}
		} catch (NoSuchElementException exception) {
			System.out.println(exception);
		}
	}
}
