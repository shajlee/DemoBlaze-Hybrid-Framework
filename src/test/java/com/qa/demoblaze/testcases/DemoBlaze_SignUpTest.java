package com.qa.demoblaze.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.SingnUpTestPage;
import com.qa.demoblaze.utilities.Demoblaze_Utilities;

public class DemoBlaze_SignUpTest extends DemoBlaze_TestBase {
	public DemoBlaze_SignUpTest() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launchUrl() {
		driver = initializeBrowser(prop.getProperty("browserName1"));
		SingnUpTestPage signuptestpage = new SingnUpTestPage(driver);
		signuptestpage.clickOnSignUpLink();
	}

	@Test(priority = 1)
	public void provideSignUpCredentials() throws Exception {
		SingnUpTestPage signuptestpage = new SingnUpTestPage(driver);
		signuptestpage.enterUserName(Demoblaze_Utilities.generateEmailDateAndTimeStamp());
		signuptestpage.enterPassword(Demoblaze_Utilities.generatePasswordDateAndTimeStamp());
		signuptestpage.clickOnSignUpButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualSignUpMessage = dataprop.getProperty("signUpMessage");
		String expectedSignUpMessage = alert.getText();

		softassert.assertEquals(actualSignUpMessage, expectedSignUpMessage);
		if (actualSignUpMessage.equals(expectedSignUpMessage)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void signUpWithNoCredentials() throws Exception {
		SingnUpTestPage signuptestpage = new SingnUpTestPage(driver);
		signuptestpage.clickOnSignUpButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualNoCredentialsSignUpMessage = dataprop.getProperty("noCredentialsSignUpMessage");
		String expectedNoCredentialsSignUpMessage = alert.getText();

		softassert.assertEquals(actualNoCredentialsSignUpMessage, expectedNoCredentialsSignUpMessage);
		if (actualNoCredentialsSignUpMessage.equals(expectedNoCredentialsSignUpMessage)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
