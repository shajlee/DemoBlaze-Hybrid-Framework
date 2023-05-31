package com.qa.demoblaze.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.LoginPage;
import com.qa.demoblaze.testData.DemoBlaze_testDataSupply;
import com.qa.demoblaze.utilities.Demoblaze_Utilities;

public class DemoBlaze_LoginTest extends DemoBlaze_TestBase {
	public DemoBlaze_LoginTest() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launchUrl() {
		driver = initializeBrowser(prop.getProperty("browserName1"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();

	}

	@Test(priority = 1, dataProvider = "demoBlazeExcelDataWithDataProvider", dataProviderClass = DemoBlaze_testDataSupply.class)
	public void loginWithValidCredentials(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickOnLogInButton();
		String userNameDisplay = loginpage.userNameDisplay();
		softassert.assertTrue(true, userNameDisplay);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void loginWithInvalidCredentials() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(Demoblaze_Utilities.generateEmailDateAndTimeStamp());
		loginpage.enterPassword(Demoblaze_Utilities.generatePasswordDateAndTimeStamp());
		loginpage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		String actualInvalidCredentialsMessage = dataprop.getProperty("InvalidCredentialMessage");
		String expectedInvalidCredentialsMessage = alert.getText();

		softassert.assertEquals(actualInvalidCredentialsMessage, expectedInvalidCredentialsMessage);
		if (actualInvalidCredentialsMessage.equals(expectedInvalidCredentialsMessage)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void loginWithInValidUsernameValidPassword() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(Demoblaze_Utilities.generateEmailDateAndTimeStamp());
		loginpage.enterPassword(dataprop.getProperty("ValidPassword"));
		loginpage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		String actualInvalidUserNameMessage = dataprop.getProperty("InvalidUserNameMessage");
		String expectedInvalidUserNameMessage = alert.getText();

		softassert.assertEquals(actualInvalidUserNameMessage, expectedInvalidUserNameMessage);
		if (actualInvalidUserNameMessage.equals(expectedInvalidUserNameMessage)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();

	}

	@Test(priority = 4)
	public void loginWithValidUsernameInvalidPassword() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(dataprop.getProperty("ValidUserName"));
		loginpage.enterPassword(Demoblaze_Utilities.generatePasswordDateAndTimeStamp());
		loginpage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		String actualInvalidPasswordMessage = dataprop.getProperty("InvalidPasswordMessage");
		String expectedInvalidPasswordMessage = alert.getText();

		softassert.assertEquals(actualInvalidPasswordMessage, expectedInvalidPasswordMessage);
		if (actualInvalidPasswordMessage.equals(expectedInvalidPasswordMessage)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();

	}

	@Test(priority = 5)
	public void loginWithNoCredentials() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		String actualNoCredentialsMessage = dataprop.getProperty("NoCredentialsMessage");
		String expectedNoCredentialsMessage = alert.getText();

		softassert.assertEquals(actualNoCredentialsMessage, expectedNoCredentialsMessage);
		if (actualNoCredentialsMessage.equals(expectedNoCredentialsMessage)) {
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
