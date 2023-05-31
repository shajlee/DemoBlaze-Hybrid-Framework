package com.qa.demoblaze.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.CategoriesTestPage;

public class DemoBlaze_CategoriesTest extends DemoBlaze_TestBase {
	public DemoBlaze_CategoriesTest() throws Exception {
		super();
		
	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launchUrl() {
		driver = initializeBrowser(prop.getProperty("browserName1"));
		
	}

	@Test(priority = 1)
	public void phoneCategory() {
		CategoriesTestPage categoriestestpage = new CategoriesTestPage(driver);
		categoriestestpage.clickOnPhoneLink();
		categoriestestpage.phoneLinkDisplay();
		softassert.assertTrue(categoriestestpage.phoneLinkDisplay(), "phoneLink is not displayed");
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void laptopCategory() {
		CategoriesTestPage categoriestestpage = new CategoriesTestPage(driver);
		categoriestestpage.clickOnLaptopLink();
		categoriestestpage.laptopLinkDisplay();
		softassert.assertTrue(categoriestestpage.laptopLinkDisplay(), "laptopLink is not displayed");
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void monitorCategory() {
		CategoriesTestPage categoriestestpage = new CategoriesTestPage(driver);
		categoriestestpage.clickOnMonitorLink();
		categoriestestpage.MonitorLinkDisplay();

		softassert.assertTrue(categoriestestpage.MonitorLinkDisplay(), "monitorLink is not displayed");
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
