package test.java.design;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class DesignTestScreen10 {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void selectDates() {
		selectStartDate();

		selectEndDate();

		selectFirstEnroll();

		selectLastEnroll();

		// Click checkbox
		webDriver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[5]/div/label/span"))
				.click();

		// Click continue button
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[6]/button"))
				.click();

	}

	private void selectStartDate() {
		// Click on start date
		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div/input"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int startDay = cal.get(Calendar.DAY_OF_MONTH);
		webDriver.findElement(By
				.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/span[text()="
						+ startDay + "]"))
				.click();
	}

	private void selectEndDate() {
		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/input"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int currentMonth = cal.get(Calendar.MONTH);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		if (cal.get(Calendar.MONTH) != currentMonth) {
			// Move to next month
			webDriver
					.findElement(By
							.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/header/span[3]"))
					.click();
		}
		int endDay = cal.get(Calendar.DAY_OF_MONTH);
		webDriver.findElement(By
				.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/span[text()="
						+ endDay + "]"))
				.click();

	}

	private void selectFirstEnroll() {
		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div/input"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int currentMonth = cal.get(Calendar.MONTH);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		if (cal.get(Calendar.MONTH) != currentMonth) {
			// Move to next month
			webDriver
					.findElement(By
							.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div/div[1]/header/span[3]"))
					.click();
		}
		int firstEnrolledDay = cal.get(Calendar.DAY_OF_MONTH);
		webDriver.findElement(By
				.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div/div[1]/span[text()="
						+ firstEnrolledDay + "]"))
				.click();
	}

	private void selectLastEnroll() {
		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[2]/div[2]/div/input"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int currentMonth = cal.get(Calendar.MONTH);
		cal.add(Calendar.DAY_OF_MONTH, 6);
		if (cal.get(Calendar.MONTH) != currentMonth) {
			// Move to next month
			webDriver
					.findElement(By
							.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[2]/div[2]/div/div[1]/header/span[3]"))
					.click();
		}
		int lastEnrolledDay = cal.get(Calendar.DAY_OF_MONTH);
		webDriver.findElement(By
				.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div[2]/div[2]/div/div[1]/span[text()="
						+ lastEnrolledDay + "]"))
				.click();
	}

}
