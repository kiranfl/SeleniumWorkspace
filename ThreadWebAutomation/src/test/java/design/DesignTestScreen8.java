package test.java.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;
import test.java.Const;
import test.util.Utils;

public class DesignTestScreen8 implements Const {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void remoteOrCompanion() {
		By by;
		if (Utils.getValueByKey(ONBOARING_TYPE).equalsIgnoreCase("open_enrollment")) {
			by = By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/button");
		} else {
			by = By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button");
		}
		webDriver.findElement(by).click();
	}
}
