package test.java.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class DesignTestScreen11 {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void selectMileStone() {
		// I don't want to setup milestones
		webDriver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[6]/span"))
				.click();
	}

}
