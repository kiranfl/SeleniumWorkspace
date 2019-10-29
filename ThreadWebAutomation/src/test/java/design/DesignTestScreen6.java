package test.java.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;

public class DesignTestScreen6 {
	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void participantPopulation() {
		// Entering target pariticipant's population
		webDriver.findElement(By.name("target-patients")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/form/div[1]/div/ul/li[1]/a"))
				.click();

		webDriver
				.findElement(By.cssSelector(
						"#app > div > div.design.bg-color > div.container.m-0.container-style > div.has-header.pt-80 > div.panel.panel-default.panel-style.col-lg-8.col-md-8.col-sm-10.col-xs-10.br-2 > div.panel-body.panel-body-style.col-lg-8.col-lg-offset-2.col-md-8.col-md-offset-2 > div > div.pt-20 > button"))
				.click();
	}
}
