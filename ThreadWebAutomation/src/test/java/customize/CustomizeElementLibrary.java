package test.java.customize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.java.BaseClass;
import test.java.Const;
import test.util.Utils;

public class CustomizeElementLibrary implements Const {

	WebDriver webDriver = BaseClass.getInstance().getWebDriver();

	@Test
	public void selectElements() {

		int i = 7;
		if (Utils.getValueByKey(ONBOARING_TYPE).equalsIgnoreCase("open_enrollment")) {
			i++;
		}
		// Select surveys
		if (Utils.getValueByKey(ADD_SURVEYS).equalsIgnoreCase("yes")) {
			selectByCssselector(
					"#app > div > div.bg-color > div.container > div > div > div.text-center > div:nth-child(" + i
							+ ") > div > div > div > div > div");
		}
		i++;
		// Select ePROs
		if (Utils.getValueByKey(ADD_EPRO).equalsIgnoreCase("yes")) {
			selectByCssselector(
					"#app > div > div.bg-color > div.container > div > div > div.text-center > div:nth-child(" + i
							+ ") > div > div > div > div > div");
		}
		i++;
		// Select eDROs
		if (Utils.getValueByKey(ADD_EDRO).equalsIgnoreCase("yes")) {
			selectByCssselector(
					"#app > div > div.bg-color > div.container > div > div > div.text-center > div:nth-child(" + i
							+ ") > div > div > div > div > div");
		}
		i++;
		// Select Patient dashboards
		if (Utils.getValueByKey(ADD_DASHBOARDS).equalsIgnoreCase("yes")) {
			selectByCssselector(
					"#app > div > div.bg-color > div.container > div > div > div.text-center > div:nth-child(" + i
							+ ") > div > div > div > div > div");
		}
		i++;
		// Select medical devices
		if (Utils.getValueByKey(ADD_VALIDIC).equalsIgnoreCase("yes")) {
			selectByCssselector(
					"#app > div > div.bg-color > div.container > div > div > div.text-center > div:nth-child(" + i
							+ ") > div > div > div > div > div");
		}
		i++;
		// Select engagement consent
		if (Utils.getValueByKey(ADD_FEEDBACK).equalsIgnoreCase("yes")) {
			selectByCssselector(
					"#app > div > div.bg-color > div.container > div > div > div.text-center > div:nth-child(" + i
							+ ") > div > div > div > div > div");
		}

		// Click continue button
		selectByCssselector(
				"#app > div > div.bg-color > div.container > div > div > div.footerStyle > div > div > button");

	}

	private void selectByCssselector(String selector) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.cssSelector(selector)).click();
	}

}
